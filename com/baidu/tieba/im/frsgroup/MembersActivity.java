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
/* loaded from: classes10.dex */
public class MembersActivity extends BaseActivity<MembersActivity> implements View.OnClickListener, BdListView.e {
    private com.baidu.tbadk.core.view.g iSN;
    private m iSO;
    private MembersModel iSP;
    private final com.baidu.adp.framework.listener.c iJH = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REQUEST_MEMBERS_BY_ID) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            RequestMembersMessage requestMembersMessage;
            l cqG = MembersActivity.this.iSO.cqG();
            MembersActivity.this.cev();
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
            MembersActivity.this.iSP.setRequestM(requestMembersMessage);
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
                if (MembersActivity.this.cjC()) {
                    MembersActivity.this.a(membersData.getPermission());
                }
                if (MembersActivity.this.cjC()) {
                    cqG.reset(true);
                }
                if (users.size() != MembersActivity.this.iSP.getLen()) {
                    cqG.pp(false);
                    cqG.pq(false);
                    if (MembersActivity.this.cjC() && users.size() == 0) {
                        MembersActivity.this.cqu();
                        return;
                    }
                } else {
                    cqG.pq(true);
                }
                MembersActivity.this.iSP.addStart(users.size());
                MembersActivity.this.iSP.setLen(20);
                cqG.dv(users);
                cqG.notifyDataSetChanged();
            }
        }
    };
    private final com.baidu.adp.framework.listener.c iSQ = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REMOVE_MEMBERS) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            MembersActivity.this.iSO.showProgressBar(false);
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
            MembersActivity.this.iSO.cqG().dw(MembersActivity.this.iSP.getUserIds());
            MembersActivity.this.iSO.cqH();
            MembersActivity.this.iSO.cqG().cqz();
        }
    };
    private final CustomMessageListener iSR = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.2
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
                        MembersActivity.this.iSO.cnW().startPullRefresh();
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
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_KICK_OUT, this.iSR);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_SUCCESS, this.iSR);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.iSP.saveInstance(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.iSO.cqF().aXU();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public MembersModel cqt() {
        return this.iSP;
    }

    private void initUI() {
        this.iSO = new m(this);
        final BdListView cnW = this.iSO.cnW();
        this.iSN = new com.baidu.tbadk.core.view.g(getPageContext());
        this.iSN.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (!MembersActivity.this.iSO.cqG().cnI()) {
                    if (!MembersActivity.this.cjC()) {
                        MembersActivity.this.reset();
                    }
                    MembersActivity.this.iSP.sendMessage(MembersActivity.this.iSP.getGroupId(), MembersActivity.this.iSP.getStart(), MembersActivity.this.iSP.getLen(), MembersActivity.this.iSP.getOrderType());
                    return;
                }
                cnW.completePullRefreshPostDelayed(0L);
            }
        });
        cnW.setPullRefresh(this.iSN);
        cnW.setOnSrollToBottomListener(this);
        cnW.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                l cqG = MembersActivity.this.iSO.cqG();
                UserData userData = (UserData) cqG.getItem(i);
                if (userData != null) {
                    if (cqG.cnI()) {
                        if (!userData.getPermission().isController()) {
                            cqG.f(Long.valueOf(userData.getUserIdLong()));
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(MembersActivity.this.getPageContext().getContext(), userData.getUserId() + "", userData.getUserName())));
                }
            }
        });
        cnW.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.4
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!MembersActivity.this.iSO.cqG().cnI() && MembersActivity.this.iSP.isController()) {
                    UserData userData = (UserData) MembersActivity.this.iSO.cqG().getItem(i);
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
                                MembersActivity.this.b(MembersActivity.this.iSP.getGroupId(), arrayList);
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
        this.iSO.cqC().setOnClickListener(this);
        this.iSO.cqD().setOnClickListener(this);
        this.iSO.cqE().setOnClickListener(this);
        this.iSO.setController(false);
        this.iSO.cqG().a(new l.a() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.5
            @Override // com.baidu.tieba.im.frsgroup.l.a
            public void ys(int i) {
                MembersActivity.this.iSO.yt(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, List<Long> list) {
        if (list != null && list.size() != 0) {
            this.iSO.showProgressBar(true);
            this.iSP.setUserIds(list);
            this.iSP.sendRemoveMessage(j, du(list));
        }
    }

    private String du(List<Long> list) {
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
        this.iSP.setUseCache(false);
        this.iSP.setRequestM(null);
        this.iSO.cqG().reset(true);
        this.iSP.setStart(0);
        this.iSP.setLen(50);
        this.iSO.cnW().startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.iSP.setUseCache(true);
        this.iSP.setRequestM(null);
        this.iSO.cqG().reset(false);
        this.iSP.setStart(0);
        this.iSP.setLen(50);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cev() {
        if (cjC()) {
            this.iSO.cev();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cjC() {
        return 50 == this.iSP.getLen();
    }

    public void initData(Bundle bundle) {
        this.iSP = new MembersModel(this);
        this.iSP.setUniqueId(getUniqueId());
        if (bundle == null) {
            this.iSP.initWithIntent(getIntent());
        } else {
            this.iSP.initWithBundle(bundle);
        }
        registerListener(this.iJH);
        registerListener(this.iSQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserData.Permission permission) {
        if (permission != null) {
            boolean isController = permission.isController();
            this.iSP.setController(isController);
            this.iSO.setController(isController);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqu() {
        this.iSO.cqF().e(getPageContext());
        this.iSO.cqF().setTextOption(NoDataViewFactory.d.mm(R.string.members_no_person));
        this.iSO.cqF().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.iSO.onChangeSkinType(i);
        this.iSN.changeSkin(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iSO.cqI()) {
            cqv();
        } else if (view == this.iSO.cqC()) {
            cqx();
            this.iSO.pt(false);
        } else if (view == this.iSO.cqD()) {
            cqw();
            this.iSO.pt(true);
        } else if (view == this.iSO.cqE()) {
            cqy();
        }
    }

    private void cqv() {
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
                MembersActivity.this.iSP.setOrderType(i2);
                MembersActivity.this.showToast(MembersActivity.this.getResources().getStringArray(R.array.members_order_by_short)[i]);
                MembersActivity.this.reset();
                MembersActivity.this.iSO.cnW().startPullRefresh();
            }
        });
        iVar.showDialog();
    }

    private void cqw() {
        this.iSO.yt(0);
        this.iSO.ps(false);
        this.iSO.cqG().pr(false);
        this.iSO.cqG().cqz();
        this.iSO.cqH();
    }

    private void cqx() {
        this.iSO.yt(0);
        this.iSO.ps(true);
        this.iSO.cqG().pr(true);
        this.iSO.cqH();
    }

    private void cqy() {
        Set<Long> cqA = this.iSO.cqG().cqA();
        if (cqA.size() > 0) {
            final ArrayList arrayList = new ArrayList();
            arrayList.addAll(cqA);
            DialogUtil.removeMembersDialog(getPageContext().getPageActivity(), new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    MembersActivity.this.iSO.ps(false);
                    MembersActivity.this.iSO.cqG().pr(false);
                    MembersActivity.this.iSO.cqH();
                    MembersActivity.this.b(MembersActivity.this.iSP.getGroupId(), arrayList);
                    MembersActivity.this.iSO.pt(true);
                }
            }, new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
        }
    }

    private void btv() {
        if (this.iSO.cqG().cqB()) {
            this.iSP.sendMessage(this.iSP.getGroupId(), this.iSP.getStart(), this.iSP.getLen(), this.iSP.getOrderType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        btv();
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public t onGetPreLoadListView() {
        if (this.iSO == null || this.iSO.cnW() == null) {
            return null;
        }
        return this.iSO.cnW().getPreLoadHandle();
    }
}
