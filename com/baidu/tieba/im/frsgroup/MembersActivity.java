package com.baidu.tieba.im.frsgroup;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.data.UserData;
import com.baidu.tieba.e;
import com.baidu.tieba.im.data.MembersData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.frsgroup.l;
import com.baidu.tieba.im.message.PushMessage;
import com.baidu.tieba.im.message.RequestMembersMessage;
import com.baidu.tieba.im.message.ResponseMembersMessage;
import com.baidu.tieba.im.message.ResponseRemoveMembersMessage;
import com.baidu.tieba.im.model.MembersModel;
import com.baidu.tieba.im.util.DialogUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
/* loaded from: classes3.dex */
public class MembersActivity extends BaseActivity<MembersActivity> implements View.OnClickListener, BdListView.e {
    private com.baidu.tbadk.core.view.k eAq;
    private m eAr;
    private MembersModel eAs;
    private final com.baidu.adp.framework.listener.c era = new com.baidu.adp.framework.listener.c(103005) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            RequestMembersMessage requestMembersMessage;
            l aMR = MembersActivity.this.eAr.aMR();
            MembersActivity.this.aCn();
            if (socketResponsedMessage == null || !(socketResponsedMessage instanceof ResponseMembersMessage)) {
                MembersActivity.this.showToast(e.j.neterror);
                return;
            }
            ResponseMembersMessage responseMembersMessage = (ResponseMembersMessage) socketResponsedMessage;
            Message<?> orginalMessage = responseMembersMessage.getOrginalMessage();
            if (orginalMessage == null || !(orginalMessage instanceof RequestMembersMessage)) {
                requestMembersMessage = null;
            } else {
                requestMembersMessage = (RequestMembersMessage) orginalMessage;
            }
            MembersActivity.this.eAs.setRequestM(requestMembersMessage);
            if (responseMembersMessage.getError() != 0) {
                if (responseMembersMessage.getError() > 0) {
                    MembersActivity.this.showToast(StringUtils.isNull(responseMembersMessage.getErrorString()) ? MembersActivity.this.getResources().getString(e.j.neterror) : responseMembersMessage.getErrorString());
                    return;
                } else {
                    MembersActivity.this.showToast(e.j.neterror);
                    return;
                }
            }
            MembersData membersData = responseMembersMessage.getMembersData();
            List<UserData> users = membersData.getUsers();
            if (users != null) {
                if (MembersActivity.this.aGv()) {
                    MembersActivity.this.a(membersData.getPermission());
                }
                if (MembersActivity.this.aGv()) {
                    aMR.reset(true);
                }
                if (users.size() != MembersActivity.this.eAs.getLen()) {
                    aMR.hV(false);
                    aMR.hW(false);
                    if (MembersActivity.this.aGv() && users.size() == 0) {
                        MembersActivity.this.aMG();
                        return;
                    }
                } else {
                    aMR.hW(true);
                }
                MembersActivity.this.eAs.addStart(users.size());
                MembersActivity.this.eAs.setLen(20);
                aMR.co(users);
                aMR.notifyDataSetChanged();
            }
        }
    };
    private final com.baidu.adp.framework.listener.c eAt = new com.baidu.adp.framework.listener.c(103112) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            MembersActivity.this.eAr.hY(false);
            if (socketResponsedMessage == null || !(socketResponsedMessage instanceof ResponseRemoveMembersMessage)) {
                MembersActivity.this.showToast(e.j.neterror);
                return;
            }
            ResponseRemoveMembersMessage responseRemoveMembersMessage = (ResponseRemoveMembersMessage) socketResponsedMessage;
            if (responseRemoveMembersMessage.getError() != 0) {
                if (responseRemoveMembersMessage.getError() > 0) {
                    MembersActivity.this.showToast(StringUtils.isNull(responseRemoveMembersMessage.getErrorString()) ? MembersActivity.this.getResources().getString(e.j.neterror) : responseRemoveMembersMessage.getErrorString());
                    return;
                } else {
                    MembersActivity.this.showToast(e.j.neterror);
                    return;
                }
            }
            MembersActivity.this.showToast(e.j.delete_success);
            MembersActivity.this.eAr.aMR().cp(MembersActivity.this.eAs.getUserIds());
            MembersActivity.this.eAr.aMS();
            MembersActivity.this.eAr.aMR().aML();
        }
    };
    private final CustomMessageListener eAu = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GroupNewsPojo p;
            if (customResponsedMessage != null && (customResponsedMessage instanceof PushMessage) && (p = ((PushMessage) customResponsedMessage).getP()) != null) {
                String cmd = p.getCmd();
                if (!TextUtils.isEmpty(cmd)) {
                    if (cmd.equals("apply_join_success")) {
                        MembersActivity.this.reset();
                    } else if (cmd.equals("kick_out")) {
                        MembersActivity.this.reset();
                        MembersActivity.this.eAr.aKf().startPullRefresh();
                    }
                }
            }
        }
    };

    public static void i(Context context, long j) {
        Intent intent = new Intent(context, MembersActivity.class);
        intent.putExtra("group_id", j);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initListener();
        initData(bundle);
        initUI();
        startLoading();
    }

    private void initListener() {
        registerListener(2001128, this.eAu);
        registerListener(2001126, this.eAu);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.eAs.saveInstance(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.eAr.aMQ().onActivityStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public MembersModel aMF() {
        return this.eAs;
    }

    private void initUI() {
        this.eAr = new m(this);
        final BdListView aKf = this.eAr.aKf();
        this.eAq = new com.baidu.tbadk.core.view.k(getPageContext());
        this.eAq.a(new j.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.1
            @Override // com.baidu.tbadk.core.view.j.b
            public void bf(boolean z) {
                if (!MembersActivity.this.eAr.aMR().aJR()) {
                    if (!MembersActivity.this.aGv()) {
                        MembersActivity.this.reset();
                    }
                    MembersActivity.this.eAs.sendMessage(MembersActivity.this.eAs.getGroupId(), MembersActivity.this.eAs.getStart(), MembersActivity.this.eAs.getLen(), MembersActivity.this.eAs.getOrderType());
                    return;
                }
                aKf.completePullRefreshPostDelayed(2000L);
            }
        });
        aKf.setPullRefresh(this.eAq);
        aKf.setOnSrollToBottomListener(this);
        aKf.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                l aMR = MembersActivity.this.eAr.aMR();
                UserData userData = (UserData) aMR.getItem(i);
                if (userData != null) {
                    if (aMR.aJR()) {
                        if (!userData.getPermission().isController()) {
                            aMR.g(Long.valueOf(userData.getUserIdLong()));
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(MembersActivity.this.getPageContext().getContext(), userData.getUserId() + "", userData.getUserName())));
                }
            }
        });
        aKf.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.4
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!MembersActivity.this.eAr.aMR().aJR() && MembersActivity.this.eAs.isController()) {
                    UserData userData = (UserData) MembersActivity.this.eAr.aMR().getItem(i);
                    if (userData != null) {
                        if (userData.getPermission().isController()) {
                            return false;
                        }
                        long userIdLong = userData.getUserIdLong();
                        final ArrayList arrayList = new ArrayList();
                        arrayList.add(Long.valueOf(userIdLong));
                        DialogUtil.removeMemberDialog(MembersActivity.this.getPageContext().getPageActivity(), new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.4.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                aVar.dismiss();
                                MembersActivity.this.b(MembersActivity.this.eAs.getGroupId(), arrayList);
                            }
                        }, new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.4.2
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                aVar.dismiss();
                            }
                        });
                    }
                    return true;
                }
                return false;
            }
        });
        this.eAr.aMN().setOnClickListener(this);
        this.eAr.aMO().setOnClickListener(this);
        this.eAr.aMP().setOnClickListener(this);
        this.eAr.setController(false);
        this.eAr.aMR().a(new l.a() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.5
            @Override // com.baidu.tieba.im.frsgroup.l.a
            public void oJ(int i) {
                MembersActivity.this.eAr.oK(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, List<Long> list) {
        if (list != null && list.size() != 0) {
            this.eAr.hY(true);
            this.eAs.setUserIds(list);
            this.eAs.sendRemoveMessage(j, cn(list));
        }
    }

    private String cn(List<Long> list) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Long l : list) {
            stringBuffer.append(l).append(",");
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        return stringBuffer.toString();
    }

    private void startLoading() {
        this.eAs.setUseCache(false);
        this.eAs.setRequestM(null);
        this.eAr.aMR().reset(true);
        this.eAs.setStart(0);
        this.eAs.setLen(50);
        this.eAr.aKf().startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.eAs.setUseCache(true);
        this.eAs.setRequestM(null);
        this.eAr.aMR().reset(false);
        this.eAs.setStart(0);
        this.eAs.setLen(50);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCn() {
        if (aGv()) {
            this.eAr.aCn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aGv() {
        return 50 == this.eAs.getLen();
    }

    public void initData(Bundle bundle) {
        this.eAs = new MembersModel(this);
        this.eAs.setUniqueId(getUniqueId());
        if (bundle == null) {
            this.eAs.initWithIntent(getIntent());
        } else {
            this.eAs.initWithBundle(bundle);
        }
        registerListener(this.era);
        registerListener(this.eAt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserData.Permission permission) {
        if (permission != null) {
            boolean isController = permission.isController();
            this.eAs.setController(isController);
            this.eAr.setController(isController);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMG() {
        this.eAr.aMQ().e(getPageContext());
        this.eAr.aMQ().setTextOption(NoDataViewFactory.d.dE(e.j.members_no_person));
        this.eAr.aMQ().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.eAr.onChangeSkinType(i);
        this.eAq.dM(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eAr.aMT()) {
            aMH();
        } else if (view == this.eAr.aMN()) {
            aMJ();
            this.eAr.ia(false);
        } else if (view == this.eAr.aMO()) {
            aMI();
            this.eAr.ia(true);
        } else if (view == this.eAr.aMP()) {
            aMK();
        }
    }

    private void aMH() {
        DialogUtil.orderMembers(getPageContext().getPageActivity(), new b.InterfaceC0100b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.8
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0100b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                int i2 = 0;
                bVar.dismiss();
                switch (i) {
                    case 1:
                        i2 = 1;
                        break;
                    case 2:
                        i2 = 2;
                        break;
                }
                MembersActivity.this.eAs.setOrderType(i2);
                MembersActivity.this.showToast(MembersActivity.this.getResources().getStringArray(e.b.members_order_by_short)[i]);
                MembersActivity.this.reset();
                MembersActivity.this.eAr.aKf().startPullRefresh();
            }
        });
    }

    private void aMI() {
        this.eAr.oK(0);
        this.eAr.hZ(false);
        this.eAr.aMR().hX(false);
        this.eAr.aMR().aML();
        this.eAr.aMS();
    }

    private void aMJ() {
        this.eAr.oK(0);
        this.eAr.hZ(true);
        this.eAr.aMR().hX(true);
        this.eAr.aMS();
    }

    private void aMK() {
        Set<Long> aMM = this.eAr.aMR().aMM();
        if (aMM.size() > 0) {
            final ArrayList arrayList = new ArrayList();
            arrayList.addAll(aMM);
            DialogUtil.removeMembersDialog(getPageContext().getPageActivity(), new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    MembersActivity.this.eAr.hZ(false);
                    MembersActivity.this.eAr.aMR().hX(false);
                    MembersActivity.this.eAr.aMS();
                    MembersActivity.this.b(MembersActivity.this.eAs.getGroupId(), arrayList);
                    MembersActivity.this.eAr.ia(true);
                }
            }, new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
        }
    }

    private void Vd() {
        if (this.eAr.aMR().alz()) {
            this.eAs.sendMessage(this.eAs.getGroupId(), this.eAs.getStart(), this.eAs.getLen(), this.eAs.getOrderType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        Vd();
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (this.eAr == null || this.eAr.aKf() == null) {
            return null;
        }
        return this.eAr.aKf().getPreLoadHandle();
    }
}
