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
import com.baidu.adp.widget.ListView.t;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.data.UserData;
import com.baidu.tieba.R;
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
/* loaded from: classes23.dex */
public class MembersActivity extends BaseActivity<MembersActivity> implements View.OnClickListener, BdListView.e {
    private com.baidu.tbadk.core.view.g kga;
    private m kgb;
    private MembersModel kgc;
    private final com.baidu.adp.framework.listener.c jUQ = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REQUEST_MEMBERS_BY_ID) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            RequestMembersMessage requestMembersMessage;
            l cSt = MembersActivity.this.kgb.cSt();
            MembersActivity.this.cET();
            if (socketResponsedMessage == null || !(socketResponsedMessage instanceof ResponseMembersMessage)) {
                MembersActivity.this.showToast(R.string.neterror);
                return;
            }
            ResponseMembersMessage responseMembersMessage = (ResponseMembersMessage) socketResponsedMessage;
            Message<?> orginalMessage = responseMembersMessage.getOrginalMessage();
            if (orginalMessage == null || !(orginalMessage instanceof RequestMembersMessage)) {
                requestMembersMessage = null;
            } else {
                requestMembersMessage = (RequestMembersMessage) orginalMessage;
            }
            MembersActivity.this.kgc.setRequestM(requestMembersMessage);
            if (responseMembersMessage.getError() != 0) {
                if (responseMembersMessage.getError() > 0) {
                    MembersActivity.this.showToast(StringUtils.isNull(responseMembersMessage.getErrorString()) ? MembersActivity.this.getResources().getString(R.string.neterror) : responseMembersMessage.getErrorString());
                    return;
                } else {
                    MembersActivity.this.showToast(R.string.neterror);
                    return;
                }
            }
            MembersData membersData = responseMembersMessage.getMembersData();
            List<UserData> users = membersData.getUsers();
            if (users != null) {
                if (MembersActivity.this.cKS()) {
                    MembersActivity.this.a(membersData.getPermission());
                }
                if (MembersActivity.this.cKS()) {
                    cSt.reset(true);
                }
                if (users.size() != MembersActivity.this.kgc.getLen()) {
                    cSt.rT(false);
                    cSt.rU(false);
                    if (MembersActivity.this.cKS() && users.size() == 0) {
                        MembersActivity.this.cSh();
                        return;
                    }
                } else {
                    cSt.rU(true);
                }
                MembersActivity.this.kgc.addStart(users.size());
                MembersActivity.this.kgc.setLen(20);
                cSt.el(users);
                cSt.notifyDataSetChanged();
            }
        }
    };
    private final com.baidu.adp.framework.listener.c kgd = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REMOVE_MEMBERS) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            MembersActivity.this.kgb.showProgressBar(false);
            if (socketResponsedMessage == null || !(socketResponsedMessage instanceof ResponseRemoveMembersMessage)) {
                MembersActivity.this.showToast(R.string.neterror);
                return;
            }
            ResponseRemoveMembersMessage responseRemoveMembersMessage = (ResponseRemoveMembersMessage) socketResponsedMessage;
            if (responseRemoveMembersMessage.getError() != 0) {
                if (responseRemoveMembersMessage.getError() > 0) {
                    MembersActivity.this.showToast(StringUtils.isNull(responseRemoveMembersMessage.getErrorString()) ? MembersActivity.this.getResources().getString(R.string.neterror) : responseRemoveMembersMessage.getErrorString());
                    return;
                } else {
                    MembersActivity.this.showToast(R.string.neterror);
                    return;
                }
            }
            MembersActivity.this.showToast(R.string.delete_success);
            MembersActivity.this.kgb.cSt().em(MembersActivity.this.kgc.getUserIds());
            MembersActivity.this.kgb.cSu();
            MembersActivity.this.kgb.cSt().cSm();
        }
    };
    private final CustomMessageListener kge = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.2
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
                        MembersActivity.this.kgb.cPp().startPullRefresh();
                    }
                }
            }
        }
    };

    public static void d(Context context, long j) {
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
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_KICK_OUT, this.kge);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_SUCCESS, this.kge);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.kgc.saveInstance(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.kgb.cSs().bso();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public MembersModel cSg() {
        return this.kgc;
    }

    private void initUI() {
        this.kgb = new m(this);
        final BdListView cPp = this.kgb.cPp();
        this.kga = new com.baidu.tbadk.core.view.g(getPageContext());
        this.kga.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (!MembersActivity.this.kgb.cSt().cOZ()) {
                    if (!MembersActivity.this.cKS()) {
                        MembersActivity.this.reset();
                    }
                    MembersActivity.this.kgc.sendMessage(MembersActivity.this.kgc.getGroupId(), MembersActivity.this.kgc.getStart(), MembersActivity.this.kgc.getLen(), MembersActivity.this.kgc.getOrderType());
                    return;
                }
                cPp.completePullRefreshPostDelayed(0L);
            }
        });
        cPp.setPullRefresh(this.kga);
        cPp.setOnSrollToBottomListener(this);
        cPp.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                l cSt = MembersActivity.this.kgb.cSt();
                UserData userData = (UserData) cSt.getItem(i);
                if (userData != null) {
                    if (cSt.cOZ()) {
                        if (!userData.getPermission().isController()) {
                            cSt.h(Long.valueOf(userData.getUserIdLong()));
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(MembersActivity.this.getPageContext().getContext(), userData.getUserId() + "", userData.getUserName())));
                }
            }
        });
        cPp.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.4
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!MembersActivity.this.kgb.cSt().cOZ() && MembersActivity.this.kgc.isController()) {
                    UserData userData = (UserData) MembersActivity.this.kgb.cSt().getItem(i);
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
                                MembersActivity.this.b(MembersActivity.this.kgc.getGroupId(), arrayList);
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
        this.kgb.cSp().setOnClickListener(this);
        this.kgb.cSq().setOnClickListener(this);
        this.kgb.cSr().setOnClickListener(this);
        this.kgb.setController(false);
        this.kgb.cSt().a(new l.a() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.5
            @Override // com.baidu.tieba.im.frsgroup.l.a
            public void CW(int i) {
                MembersActivity.this.kgb.CX(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, List<Long> list) {
        if (list != null && list.size() != 0) {
            this.kgb.showProgressBar(true);
            this.kgc.setUserIds(list);
            this.kgc.sendRemoveMessage(j, ek(list));
        }
    }

    private String ek(List<Long> list) {
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
        this.kgc.setUseCache(false);
        this.kgc.setRequestM(null);
        this.kgb.cSt().reset(true);
        this.kgc.setStart(0);
        this.kgc.setLen(50);
        this.kgb.cPp().startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.kgc.setUseCache(true);
        this.kgc.setRequestM(null);
        this.kgb.cSt().reset(false);
        this.kgc.setStart(0);
        this.kgc.setLen(50);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cET() {
        if (cKS()) {
            this.kgb.cET();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cKS() {
        return 50 == this.kgc.getLen();
    }

    public void initData(Bundle bundle) {
        this.kgc = new MembersModel(this);
        this.kgc.setUniqueId(getUniqueId());
        if (bundle == null) {
            this.kgc.initWithIntent(getIntent());
        } else {
            this.kgc.initWithBundle(bundle);
        }
        registerListener(this.jUQ);
        registerListener(this.kgd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserData.Permission permission) {
        if (permission != null) {
            boolean isController = permission.isController();
            this.kgc.setController(isController);
            this.kgb.setController(isController);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSh() {
        this.kgb.cSs().e(getPageContext());
        this.kgb.cSs().setTextOption(NoDataViewFactory.d.pQ(R.string.members_no_person));
        this.kgb.cSs().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.kgb.onChangeSkinType(i);
        this.kga.changeSkin(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.kgb.cSv()) {
            cSi();
        } else if (view == this.kgb.cSp()) {
            cSk();
            this.kgb.rX(false);
        } else if (view == this.kgb.cSq()) {
            cSj();
            this.kgb.rX(true);
        } else if (view == this.kgb.cSr()) {
            cSl();
        }
    }

    private void cSi() {
        final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(getPageContext());
        iVar.a(TbadkApplication.getInst().getString(R.string.members_order), getResources().getStringArray(R.array.members_order_by), new k.c() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.8
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                int i2 = 0;
                if (iVar != null && iVar.isShowing()) {
                    iVar.dismiss();
                }
                switch (i) {
                    case 1:
                        i2 = 1;
                        break;
                    case 2:
                        i2 = 2;
                        break;
                }
                MembersActivity.this.kgc.setOrderType(i2);
                MembersActivity.this.showToast(MembersActivity.this.getResources().getStringArray(R.array.members_order_by_short)[i]);
                MembersActivity.this.reset();
                MembersActivity.this.kgb.cPp().startPullRefresh();
            }
        });
        iVar.Qj();
    }

    private void cSj() {
        this.kgb.CX(0);
        this.kgb.rW(false);
        this.kgb.cSt().rV(false);
        this.kgb.cSt().cSm();
        this.kgb.cSu();
    }

    private void cSk() {
        this.kgb.CX(0);
        this.kgb.rW(true);
        this.kgb.cSt().rV(true);
        this.kgb.cSu();
    }

    private void cSl() {
        Set<Long> cSn = this.kgb.cSt().cSn();
        if (cSn.size() > 0) {
            final ArrayList arrayList = new ArrayList();
            arrayList.addAll(cSn);
            DialogUtil.removeMembersDialog(getPageContext().getPageActivity(), new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    MembersActivity.this.kgb.rW(false);
                    MembersActivity.this.kgb.cSt().rV(false);
                    MembersActivity.this.kgb.cSu();
                    MembersActivity.this.b(MembersActivity.this.kgc.getGroupId(), arrayList);
                    MembersActivity.this.kgb.rX(true);
                }
            }, new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
        }
    }

    private void bOI() {
        if (this.kgb.cSt().cSo()) {
            this.kgc.sendMessage(this.kgc.getGroupId(), this.kgc.getStart(), this.kgc.getLen(), this.kgc.getOrderType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        bOI();
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public t onGetPreLoadListView() {
        if (this.kgb == null || this.kgb.cPp() == null) {
            return null;
        }
        return this.kgb.cPp().getPreLoadHandle();
    }
}
