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
import com.baidu.tbadk.core.view.e;
import com.baidu.tbadk.data.UserData;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.MembersData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.frsgroup.l;
import com.baidu.tieba.im.message.PushMessage;
import com.baidu.tieba.im.message.RequestMembersMessage;
import com.baidu.tieba.im.message.ResponseMembersMessage;
import com.baidu.tieba.im.message.ResponseRemoveMembersMessage;
import com.baidu.tieba.im.model.MembersModel;
import com.baidu.tieba.im.util.DialogUtil;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
/* loaded from: classes3.dex */
public class MembersActivity extends BaseActivity<MembersActivity> implements View.OnClickListener, BdListView.e {
    private com.baidu.tbadk.core.view.f dZZ;
    private m eaa;
    private MembersModel eab;
    private final com.baidu.adp.framework.listener.c dQP = new com.baidu.adp.framework.listener.c(103005) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            RequestMembersMessage requestMembersMessage;
            l aEc = MembersActivity.this.eaa.aEc();
            MembersActivity.this.auK();
            if (socketResponsedMessage == null || !(socketResponsedMessage instanceof ResponseMembersMessage)) {
                MembersActivity.this.showToast(d.k.neterror);
                return;
            }
            ResponseMembersMessage responseMembersMessage = (ResponseMembersMessage) socketResponsedMessage;
            Message<?> orginalMessage = responseMembersMessage.getOrginalMessage();
            if (orginalMessage == null || !(orginalMessage instanceof RequestMembersMessage)) {
                requestMembersMessage = null;
            } else {
                requestMembersMessage = (RequestMembersMessage) orginalMessage;
            }
            MembersActivity.this.eab.setRequestM(requestMembersMessage);
            if (responseMembersMessage.getError() != 0) {
                if (responseMembersMessage.getError() > 0) {
                    MembersActivity.this.showToast(StringUtils.isNull(responseMembersMessage.getErrorString()) ? MembersActivity.this.getResources().getString(d.k.neterror) : responseMembersMessage.getErrorString());
                    return;
                } else {
                    MembersActivity.this.showToast(d.k.neterror);
                    return;
                }
            }
            MembersData membersData = responseMembersMessage.getMembersData();
            List<UserData> users = membersData.getUsers();
            if (users != null) {
                if (MembersActivity.this.axJ()) {
                    MembersActivity.this.a(membersData.getPermission());
                }
                if (MembersActivity.this.axJ()) {
                    aEc.reset(true);
                }
                if (users.size() != MembersActivity.this.eab.getLen()) {
                    aEc.he(false);
                    aEc.hf(false);
                    if (MembersActivity.this.axJ() && users.size() == 0) {
                        MembersActivity.this.aDR();
                        return;
                    }
                } else {
                    aEc.hf(true);
                }
                MembersActivity.this.eab.addStart(users.size());
                MembersActivity.this.eab.setLen(20);
                aEc.ce(users);
                aEc.notifyDataSetChanged();
            }
        }
    };
    private final com.baidu.adp.framework.listener.c eac = new com.baidu.adp.framework.listener.c(103112) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            MembersActivity.this.eaa.hh(false);
            if (socketResponsedMessage == null || !(socketResponsedMessage instanceof ResponseRemoveMembersMessage)) {
                MembersActivity.this.showToast(d.k.neterror);
                return;
            }
            ResponseRemoveMembersMessage responseRemoveMembersMessage = (ResponseRemoveMembersMessage) socketResponsedMessage;
            if (responseRemoveMembersMessage.getError() != 0) {
                if (responseRemoveMembersMessage.getError() > 0) {
                    MembersActivity.this.showToast(StringUtils.isNull(responseRemoveMembersMessage.getErrorString()) ? MembersActivity.this.getResources().getString(d.k.neterror) : responseRemoveMembersMessage.getErrorString());
                    return;
                } else {
                    MembersActivity.this.showToast(d.k.neterror);
                    return;
                }
            }
            MembersActivity.this.showToast(d.k.delete_success);
            MembersActivity.this.eaa.aEc().cf(MembersActivity.this.eab.getUserIds());
            MembersActivity.this.eaa.aEd();
            MembersActivity.this.eaa.aEc().aDW();
        }
    };
    private final CustomMessageListener ead = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.2
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
                        MembersActivity.this.eaa.aBr().startPullRefresh();
                    }
                }
            }
        }
    };

    public static void e(Context context, long j) {
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
        registerListener(2001128, this.ead);
        registerListener(2001126, this.ead);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.eab.saveInstance(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.eaa.aEb().onActivityStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public MembersModel aDQ() {
        return this.eab;
    }

    private void initUI() {
        this.eaa = new m(this);
        final BdListView aBr = this.eaa.aBr();
        this.dZZ = new com.baidu.tbadk.core.view.f(getPageContext());
        this.dZZ.a(new e.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.1
            @Override // com.baidu.tbadk.core.view.e.b
            public void aO(boolean z) {
                if (!MembersActivity.this.eaa.aEc().aBc()) {
                    if (!MembersActivity.this.axJ()) {
                        MembersActivity.this.reset();
                    }
                    MembersActivity.this.eab.sendMessage(MembersActivity.this.eab.getGroupId(), MembersActivity.this.eab.getStart(), MembersActivity.this.eab.getLen(), MembersActivity.this.eab.getOrderType());
                    return;
                }
                aBr.completePullRefreshPostDelayed(2000L);
            }
        });
        aBr.setPullRefresh(this.dZZ);
        aBr.setOnSrollToBottomListener(this);
        aBr.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                l aEc = MembersActivity.this.eaa.aEc();
                UserData userData = (UserData) aEc.getItem(i);
                if (userData != null) {
                    if (aEc.aBc()) {
                        if (!userData.getPermission().isController()) {
                            aEc.f(Long.valueOf(userData.getUserIdLong()));
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(MembersActivity.this.getPageContext().getContext(), userData.getUserId() + "", userData.getUserName())));
                }
            }
        });
        aBr.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.4
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view2, int i, long j) {
                if (!MembersActivity.this.eaa.aEc().aBc() && MembersActivity.this.eab.isController()) {
                    UserData userData = (UserData) MembersActivity.this.eaa.aEc().getItem(i);
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
                                MembersActivity.this.b(MembersActivity.this.eab.getGroupId(), arrayList);
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
        this.eaa.aDY().setOnClickListener(this);
        this.eaa.aDZ().setOnClickListener(this);
        this.eaa.aEa().setOnClickListener(this);
        this.eaa.setController(false);
        this.eaa.aEc().a(new l.a() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.5
            @Override // com.baidu.tieba.im.frsgroup.l.a
            public void ny(int i) {
                MembersActivity.this.eaa.nz(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, List<Long> list) {
        if (list != null && list.size() != 0) {
            this.eaa.hh(true);
            this.eab.setUserIds(list);
            this.eab.sendRemoveMessage(j, cd(list));
        }
    }

    private String cd(List<Long> list) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Long l : list) {
            stringBuffer.append(l).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        return stringBuffer.toString();
    }

    private void startLoading() {
        this.eab.setUseCache(false);
        this.eab.setRequestM(null);
        this.eaa.aEc().reset(true);
        this.eab.setStart(0);
        this.eab.setLen(50);
        this.eaa.aBr().startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.eab.setUseCache(true);
        this.eab.setRequestM(null);
        this.eaa.aEc().reset(false);
        this.eab.setStart(0);
        this.eab.setLen(50);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auK() {
        if (axJ()) {
            this.eaa.auK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean axJ() {
        return 50 == this.eab.getLen();
    }

    public void initData(Bundle bundle) {
        this.eab = new MembersModel(this);
        this.eab.setUniqueId(getUniqueId());
        if (bundle == null) {
            this.eab.initWithIntent(getIntent());
        } else {
            this.eab.initWithBundle(bundle);
        }
        registerListener(this.dQP);
        registerListener(this.eac);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserData.Permission permission) {
        if (permission != null) {
            boolean isController = permission.isController();
            this.eab.setController(isController);
            this.eaa.setController(isController);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDR() {
        this.eaa.aEb().e(getPageContext());
        this.eaa.aEb().setTextOption(NoDataViewFactory.d.dp(d.k.members_no_person));
        this.eaa.aEb().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.eaa.onChangeSkinType(i);
        this.dZZ.dw(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.eaa.aEe()) {
            aDS();
        } else if (view2 == this.eaa.aDY()) {
            aDU();
            this.eaa.hj(false);
        } else if (view2 == this.eaa.aDZ()) {
            aDT();
            this.eaa.hj(true);
        } else if (view2 == this.eaa.aEa()) {
            aDV();
        }
    }

    private void aDS() {
        DialogUtil.orderMembers(getPageContext().getPageActivity(), new b.InterfaceC0086b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.8
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
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
                MembersActivity.this.eab.setOrderType(i2);
                MembersActivity.this.showToast(MembersActivity.this.getResources().getStringArray(d.b.members_order_by_short)[i]);
                MembersActivity.this.reset();
                MembersActivity.this.eaa.aBr().startPullRefresh();
            }
        });
    }

    private void aDT() {
        this.eaa.nz(0);
        this.eaa.hi(false);
        this.eaa.aEc().hg(false);
        this.eaa.aEc().aDW();
        this.eaa.aEd();
    }

    private void aDU() {
        this.eaa.nz(0);
        this.eaa.hi(true);
        this.eaa.aEc().hg(true);
        this.eaa.aEd();
    }

    private void aDV() {
        Set<Long> aDX = this.eaa.aEc().aDX();
        if (aDX.size() > 0) {
            final ArrayList arrayList = new ArrayList();
            arrayList.addAll(aDX);
            DialogUtil.removeMembersDialog(getPageContext().getPageActivity(), new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    MembersActivity.this.eaa.hi(false);
                    MembersActivity.this.eaa.aEc().hg(false);
                    MembersActivity.this.eaa.aEd();
                    MembersActivity.this.b(MembersActivity.this.eab.getGroupId(), arrayList);
                    MembersActivity.this.eaa.hj(true);
                }
            }, new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
        }
    }

    private void Pl() {
        if (this.eaa.aEc().agl()) {
            this.eab.sendMessage(this.eab.getGroupId(), this.eab.getStart(), this.eab.getLen(), this.eab.getOrderType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        Pl();
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (this.eaa == null || this.eaa.aBr() == null) {
            return null;
        }
        return this.eaa.aBr().getPreLoadHandle();
    }
}
