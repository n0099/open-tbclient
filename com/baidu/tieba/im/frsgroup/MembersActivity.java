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
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
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
    private com.baidu.tbadk.core.view.k eJt;
    private m eJu;
    private MembersModel eJv;
    private final com.baidu.adp.framework.listener.c eAl = new com.baidu.adp.framework.listener.c(103005) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            RequestMembersMessage requestMembersMessage;
            l aPD = MembersActivity.this.eJu.aPD();
            MembersActivity.this.aFc();
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
            MembersActivity.this.eJv.setRequestM(requestMembersMessage);
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
                if (MembersActivity.this.aJl()) {
                    MembersActivity.this.a(membersData.getPermission());
                }
                if (MembersActivity.this.aJl()) {
                    aPD.reset(true);
                }
                if (users.size() != MembersActivity.this.eJv.getLen()) {
                    aPD.iw(false);
                    aPD.ix(false);
                    if (MembersActivity.this.aJl() && users.size() == 0) {
                        MembersActivity.this.aPs();
                        return;
                    }
                } else {
                    aPD.ix(true);
                }
                MembersActivity.this.eJv.addStart(users.size());
                MembersActivity.this.eJv.setLen(20);
                aPD.cB(users);
                aPD.notifyDataSetChanged();
            }
        }
    };
    private final com.baidu.adp.framework.listener.c eJw = new com.baidu.adp.framework.listener.c(103112) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            MembersActivity.this.eJu.iz(false);
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
            MembersActivity.this.eJu.aPD().cC(MembersActivity.this.eJv.getUserIds());
            MembersActivity.this.eJu.aPE();
            MembersActivity.this.eJu.aPD().aPx();
        }
    };
    private final CustomMessageListener eJx = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.2
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
                        MembersActivity.this.eJu.aMS().startPullRefresh();
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
        registerListener(2001128, this.eJx);
        registerListener(2001126, this.eJx);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.eJv.saveInstance(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.eJu.aPC().onActivityStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public MembersModel aPr() {
        return this.eJv;
    }

    private void initUI() {
        this.eJu = new m(this);
        final BdListView aMS = this.eJu.aMS();
        this.eJt = new com.baidu.tbadk.core.view.k(getPageContext());
        this.eJt.a(new j.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.1
            @Override // com.baidu.tbadk.core.view.j.b
            public void bG(boolean z) {
                if (!MembersActivity.this.eJu.aPD().aMF()) {
                    if (!MembersActivity.this.aJl()) {
                        MembersActivity.this.reset();
                    }
                    MembersActivity.this.eJv.sendMessage(MembersActivity.this.eJv.getGroupId(), MembersActivity.this.eJv.getStart(), MembersActivity.this.eJv.getLen(), MembersActivity.this.eJv.getOrderType());
                    return;
                }
                aMS.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
            }
        });
        aMS.setPullRefresh(this.eJt);
        aMS.setOnSrollToBottomListener(this);
        aMS.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                l aPD = MembersActivity.this.eJu.aPD();
                UserData userData = (UserData) aPD.getItem(i);
                if (userData != null) {
                    if (aPD.aMF()) {
                        if (!userData.getPermission().isController()) {
                            aPD.h(Long.valueOf(userData.getUserIdLong()));
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(MembersActivity.this.getPageContext().getContext(), userData.getUserId() + "", userData.getUserName())));
                }
            }
        });
        aMS.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.4
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!MembersActivity.this.eJu.aPD().aMF() && MembersActivity.this.eJv.isController()) {
                    UserData userData = (UserData) MembersActivity.this.eJu.aPD().getItem(i);
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
                                MembersActivity.this.b(MembersActivity.this.eJv.getGroupId(), arrayList);
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
        this.eJu.aPz().setOnClickListener(this);
        this.eJu.aPA().setOnClickListener(this);
        this.eJu.aPB().setOnClickListener(this);
        this.eJu.setController(false);
        this.eJu.aPD().a(new l.a() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.5
            @Override // com.baidu.tieba.im.frsgroup.l.a
            public void pA(int i) {
                MembersActivity.this.eJu.pB(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, List<Long> list) {
        if (list != null && list.size() != 0) {
            this.eJu.iz(true);
            this.eJv.setUserIds(list);
            this.eJv.sendRemoveMessage(j, cA(list));
        }
    }

    private String cA(List<Long> list) {
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
        this.eJv.setUseCache(false);
        this.eJv.setRequestM(null);
        this.eJu.aPD().reset(true);
        this.eJv.setStart(0);
        this.eJv.setLen(50);
        this.eJu.aMS().startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.eJv.setUseCache(true);
        this.eJv.setRequestM(null);
        this.eJu.aPD().reset(false);
        this.eJv.setStart(0);
        this.eJv.setLen(50);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFc() {
        if (aJl()) {
            this.eJu.aFc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aJl() {
        return 50 == this.eJv.getLen();
    }

    public void initData(Bundle bundle) {
        this.eJv = new MembersModel(this);
        this.eJv.setUniqueId(getUniqueId());
        if (bundle == null) {
            this.eJv.initWithIntent(getIntent());
        } else {
            this.eJv.initWithBundle(bundle);
        }
        registerListener(this.eAl);
        registerListener(this.eJw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserData.Permission permission) {
        if (permission != null) {
            boolean isController = permission.isController();
            this.eJv.setController(isController);
            this.eJu.setController(isController);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPs() {
        this.eJu.aPC().e(getPageContext());
        this.eJu.aPC().setTextOption(NoDataViewFactory.d.ec(e.j.members_no_person));
        this.eJu.aPC().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.eJu.onChangeSkinType(i);
        this.eJt.ek(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eJu.aPF()) {
            aPt();
        } else if (view == this.eJu.aPz()) {
            aPv();
            this.eJu.iB(false);
        } else if (view == this.eJu.aPA()) {
            aPu();
            this.eJu.iB(true);
        } else if (view == this.eJu.aPB()) {
            aPw();
        }
    }

    private void aPt() {
        DialogUtil.orderMembers(getPageContext().getPageActivity(), new b.InterfaceC0148b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.8
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0148b
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
                MembersActivity.this.eJv.setOrderType(i2);
                MembersActivity.this.showToast(MembersActivity.this.getResources().getStringArray(e.b.members_order_by_short)[i]);
                MembersActivity.this.reset();
                MembersActivity.this.eJu.aMS().startPullRefresh();
            }
        });
    }

    private void aPu() {
        this.eJu.pB(0);
        this.eJu.iA(false);
        this.eJu.aPD().iy(false);
        this.eJu.aPD().aPx();
        this.eJu.aPE();
    }

    private void aPv() {
        this.eJu.pB(0);
        this.eJu.iA(true);
        this.eJu.aPD().iy(true);
        this.eJu.aPE();
    }

    private void aPw() {
        Set<Long> aPy = this.eJu.aPD().aPy();
        if (aPy.size() > 0) {
            final ArrayList arrayList = new ArrayList();
            arrayList.addAll(aPy);
            DialogUtil.removeMembersDialog(getPageContext().getPageActivity(), new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    MembersActivity.this.eJu.iA(false);
                    MembersActivity.this.eJu.aPD().iy(false);
                    MembersActivity.this.eJu.aPE();
                    MembersActivity.this.b(MembersActivity.this.eJv.getGroupId(), arrayList);
                    MembersActivity.this.eJu.iB(true);
                }
            }, new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
        }
    }

    private void YV() {
        if (this.eJu.aPD().aoD()) {
            this.eJv.sendMessage(this.eJv.getGroupId(), this.eJv.getStart(), this.eJv.getLen(), this.eJv.getOrderType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        YV();
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (this.eJu == null || this.eJu.aMS() == null) {
            return null;
        }
        return this.eJu.aMS().getPreLoadHandle();
    }
}
