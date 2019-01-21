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
    private com.baidu.tbadk.core.view.k eTN;
    private m eTO;
    private MembersModel eTP;
    private final com.baidu.adp.framework.listener.c eKE = new com.baidu.adp.framework.listener.c(103005) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            RequestMembersMessage requestMembersMessage;
            l aSI = MembersActivity.this.eTO.aSI();
            MembersActivity.this.aIa();
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
            MembersActivity.this.eTP.setRequestM(requestMembersMessage);
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
                if (MembersActivity.this.aMq()) {
                    MembersActivity.this.a(membersData.getPermission());
                }
                if (MembersActivity.this.aMq()) {
                    aSI.reset(true);
                }
                if (users.size() != MembersActivity.this.eTP.getLen()) {
                    aSI.iC(false);
                    aSI.iD(false);
                    if (MembersActivity.this.aMq() && users.size() == 0) {
                        MembersActivity.this.aSx();
                        return;
                    }
                } else {
                    aSI.iD(true);
                }
                MembersActivity.this.eTP.addStart(users.size());
                MembersActivity.this.eTP.setLen(20);
                aSI.cH(users);
                aSI.notifyDataSetChanged();
            }
        }
    };
    private final com.baidu.adp.framework.listener.c eTQ = new com.baidu.adp.framework.listener.c(103112) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            MembersActivity.this.eTO.iF(false);
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
            MembersActivity.this.eTO.aSI().cI(MembersActivity.this.eTP.getUserIds());
            MembersActivity.this.eTO.aSJ();
            MembersActivity.this.eTO.aSI().aSC();
        }
    };
    private final CustomMessageListener eTR = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.2
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
                        MembersActivity.this.eTO.aPX().startPullRefresh();
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
        registerListener(2001128, this.eTR);
        registerListener(2001126, this.eTR);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.eTP.saveInstance(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.eTO.aSH().onActivityStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public MembersModel aSw() {
        return this.eTP;
    }

    private void initUI() {
        this.eTO = new m(this);
        final BdListView aPX = this.eTO.aPX();
        this.eTN = new com.baidu.tbadk.core.view.k(getPageContext());
        this.eTN.a(new j.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.1
            @Override // com.baidu.tbadk.core.view.j.b
            public void bI(boolean z) {
                if (!MembersActivity.this.eTO.aSI().aPK()) {
                    if (!MembersActivity.this.aMq()) {
                        MembersActivity.this.reset();
                    }
                    MembersActivity.this.eTP.sendMessage(MembersActivity.this.eTP.getGroupId(), MembersActivity.this.eTP.getStart(), MembersActivity.this.eTP.getLen(), MembersActivity.this.eTP.getOrderType());
                    return;
                }
                aPX.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
            }
        });
        aPX.setPullRefresh(this.eTN);
        aPX.setOnSrollToBottomListener(this);
        aPX.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                l aSI = MembersActivity.this.eTO.aSI();
                UserData userData = (UserData) aSI.getItem(i);
                if (userData != null) {
                    if (aSI.aPK()) {
                        if (!userData.getPermission().isController()) {
                            aSI.h(Long.valueOf(userData.getUserIdLong()));
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(MembersActivity.this.getPageContext().getContext(), userData.getUserId() + "", userData.getUserName())));
                }
            }
        });
        aPX.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.4
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!MembersActivity.this.eTO.aSI().aPK() && MembersActivity.this.eTP.isController()) {
                    UserData userData = (UserData) MembersActivity.this.eTO.aSI().getItem(i);
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
                                MembersActivity.this.b(MembersActivity.this.eTP.getGroupId(), arrayList);
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
        this.eTO.aSE().setOnClickListener(this);
        this.eTO.aSF().setOnClickListener(this);
        this.eTO.aSG().setOnClickListener(this);
        this.eTO.setController(false);
        this.eTO.aSI().a(new l.a() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.5
            @Override // com.baidu.tieba.im.frsgroup.l.a
            public void qi(int i) {
                MembersActivity.this.eTO.qj(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, List<Long> list) {
        if (list != null && list.size() != 0) {
            this.eTO.iF(true);
            this.eTP.setUserIds(list);
            this.eTP.sendRemoveMessage(j, cG(list));
        }
    }

    private String cG(List<Long> list) {
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
        this.eTP.setUseCache(false);
        this.eTP.setRequestM(null);
        this.eTO.aSI().reset(true);
        this.eTP.setStart(0);
        this.eTP.setLen(50);
        this.eTO.aPX().startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.eTP.setUseCache(true);
        this.eTP.setRequestM(null);
        this.eTO.aSI().reset(false);
        this.eTP.setStart(0);
        this.eTP.setLen(50);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIa() {
        if (aMq()) {
            this.eTO.aIa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aMq() {
        return 50 == this.eTP.getLen();
    }

    public void initData(Bundle bundle) {
        this.eTP = new MembersModel(this);
        this.eTP.setUniqueId(getUniqueId());
        if (bundle == null) {
            this.eTP.initWithIntent(getIntent());
        } else {
            this.eTP.initWithBundle(bundle);
        }
        registerListener(this.eKE);
        registerListener(this.eTQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserData.Permission permission) {
        if (permission != null) {
            boolean isController = permission.isController();
            this.eTP.setController(isController);
            this.eTO.setController(isController);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSx() {
        this.eTO.aSH().e(getPageContext());
        this.eTO.aSH().setTextOption(NoDataViewFactory.d.eq(e.j.members_no_person));
        this.eTO.aSH().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.eTO.onChangeSkinType(i);
        this.eTN.ey(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eTO.aSK()) {
            aSy();
        } else if (view == this.eTO.aSE()) {
            aSA();
            this.eTO.iH(false);
        } else if (view == this.eTO.aSF()) {
            aSz();
            this.eTO.iH(true);
        } else if (view == this.eTO.aSG()) {
            aSB();
        }
    }

    private void aSy() {
        DialogUtil.orderMembers(getPageContext().getPageActivity(), new b.InterfaceC0158b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.8
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
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
                MembersActivity.this.eTP.setOrderType(i2);
                MembersActivity.this.showToast(MembersActivity.this.getResources().getStringArray(e.b.members_order_by_short)[i]);
                MembersActivity.this.reset();
                MembersActivity.this.eTO.aPX().startPullRefresh();
            }
        });
    }

    private void aSz() {
        this.eTO.qj(0);
        this.eTO.iG(false);
        this.eTO.aSI().iE(false);
        this.eTO.aSI().aSC();
        this.eTO.aSJ();
    }

    private void aSA() {
        this.eTO.qj(0);
        this.eTO.iG(true);
        this.eTO.aSI().iE(true);
        this.eTO.aSJ();
    }

    private void aSB() {
        Set<Long> aSD = this.eTO.aSI().aSD();
        if (aSD.size() > 0) {
            final ArrayList arrayList = new ArrayList();
            arrayList.addAll(aSD);
            DialogUtil.removeMembersDialog(getPageContext().getPageActivity(), new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    MembersActivity.this.eTO.iG(false);
                    MembersActivity.this.eTO.aSI().iE(false);
                    MembersActivity.this.eTO.aSJ();
                    MembersActivity.this.b(MembersActivity.this.eTP.getGroupId(), arrayList);
                    MembersActivity.this.eTO.iH(true);
                }
            }, new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
        }
    }

    private void aaA() {
        if (this.eTO.aSI().arD()) {
            this.eTP.sendMessage(this.eTP.getGroupId(), this.eTP.getStart(), this.eTP.getLen(), this.eTP.getOrderType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        aaA();
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (this.eTO == null || this.eTO.aPX() == null) {
            return null;
        }
        return this.eTO.aPX().getPreLoadHandle();
    }
}
