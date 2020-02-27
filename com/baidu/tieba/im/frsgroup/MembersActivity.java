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
import com.baidu.adp.widget.ListView.p;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.g;
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
    private com.baidu.tbadk.core.view.h hAF;
    private m hAG;
    private MembersModel hAH;
    private final com.baidu.adp.framework.listener.c hry = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REQUEST_MEMBERS_BY_ID) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            RequestMembersMessage requestMembersMessage;
            l bVp = MembersActivity.this.hAG.bVp();
            MembersActivity.this.bJL();
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
            MembersActivity.this.hAH.setRequestM(requestMembersMessage);
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
                if (MembersActivity.this.bOG()) {
                    MembersActivity.this.a(membersData.getPermission());
                }
                if (MembersActivity.this.bOG()) {
                    bVp.reset(true);
                }
                if (users.size() != MembersActivity.this.hAH.getLen()) {
                    bVp.nz(false);
                    bVp.nA(false);
                    if (MembersActivity.this.bOG() && users.size() == 0) {
                        MembersActivity.this.bVd();
                        return;
                    }
                } else {
                    bVp.nA(true);
                }
                MembersActivity.this.hAH.addStart(users.size());
                MembersActivity.this.hAH.setLen(20);
                bVp.cX(users);
                bVp.notifyDataSetChanged();
            }
        }
    };
    private final com.baidu.adp.framework.listener.c hAI = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REMOVE_MEMBERS) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            MembersActivity.this.hAG.showProgressBar(false);
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
            MembersActivity.this.hAG.bVp().cY(MembersActivity.this.hAH.getUserIds());
            MembersActivity.this.hAG.bVq();
            MembersActivity.this.hAG.bVp().bVi();
        }
    };
    private final CustomMessageListener hAJ = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.2
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
                        MembersActivity.this.hAG.bSF().startPullRefresh();
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
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_KICK_OUT, this.hAJ);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_SUCCESS, this.hAJ);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.hAH.saveInstance(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.hAG.bVo().aHz();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public MembersModel bVc() {
        return this.hAH;
    }

    private void initUI() {
        this.hAG = new m(this);
        final BdListView bSF = this.hAG.bSF();
        this.hAF = new com.baidu.tbadk.core.view.h(getPageContext());
        this.hAF.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.1
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (!MembersActivity.this.hAG.bVp().bSs()) {
                    if (!MembersActivity.this.bOG()) {
                        MembersActivity.this.reset();
                    }
                    MembersActivity.this.hAH.sendMessage(MembersActivity.this.hAH.getGroupId(), MembersActivity.this.hAH.getStart(), MembersActivity.this.hAH.getLen(), MembersActivity.this.hAH.getOrderType());
                    return;
                }
                bSF.completePullRefreshPostDelayed(0L);
            }
        });
        bSF.setPullRefresh(this.hAF);
        bSF.setOnSrollToBottomListener(this);
        bSF.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                l bVp = MembersActivity.this.hAG.bVp();
                UserData userData = (UserData) bVp.getItem(i);
                if (userData != null) {
                    if (bVp.bSs()) {
                        if (!userData.getPermission().isController()) {
                            bVp.f(Long.valueOf(userData.getUserIdLong()));
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(MembersActivity.this.getPageContext().getContext(), userData.getUserId() + "", userData.getUserName())));
                }
            }
        });
        bSF.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.4
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!MembersActivity.this.hAG.bVp().bSs() && MembersActivity.this.hAH.isController()) {
                    UserData userData = (UserData) MembersActivity.this.hAG.bVp().getItem(i);
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
                                MembersActivity.this.a(MembersActivity.this.hAH.getGroupId(), arrayList);
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
        this.hAG.bVl().setOnClickListener(this);
        this.hAG.bVm().setOnClickListener(this);
        this.hAG.bVn().setOnClickListener(this);
        this.hAG.setController(false);
        this.hAG.bVp().a(new l.a() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.5
            @Override // com.baidu.tieba.im.frsgroup.l.a
            public void wu(int i) {
                MembersActivity.this.hAG.wv(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, List<Long> list) {
        if (list != null && list.size() != 0) {
            this.hAG.showProgressBar(true);
            this.hAH.setUserIds(list);
            this.hAH.sendRemoveMessage(j, cW(list));
        }
    }

    private String cW(List<Long> list) {
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
        this.hAH.setUseCache(false);
        this.hAH.setRequestM(null);
        this.hAG.bVp().reset(true);
        this.hAH.setStart(0);
        this.hAH.setLen(50);
        this.hAG.bSF().startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.hAH.setUseCache(true);
        this.hAH.setRequestM(null);
        this.hAG.bVp().reset(false);
        this.hAH.setStart(0);
        this.hAH.setLen(50);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJL() {
        if (bOG()) {
            this.hAG.bJL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bOG() {
        return 50 == this.hAH.getLen();
    }

    public void initData(Bundle bundle) {
        this.hAH = new MembersModel(this);
        this.hAH.setUniqueId(getUniqueId());
        if (bundle == null) {
            this.hAH.initWithIntent(getIntent());
        } else {
            this.hAH.initWithBundle(bundle);
        }
        registerListener(this.hry);
        registerListener(this.hAI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserData.Permission permission) {
        if (permission != null) {
            boolean isController = permission.isController();
            this.hAH.setController(isController);
            this.hAG.setController(isController);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVd() {
        this.hAG.bVo().e(getPageContext());
        this.hAG.bVo().setTextOption(NoDataViewFactory.d.lh(R.string.members_no_person));
        this.hAG.bVo().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.hAG.onChangeSkinType(i);
        this.hAF.changeSkin(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hAG.bVr()) {
            bVe();
        } else if (view == this.hAG.bVl()) {
            bVg();
            this.hAG.nD(false);
        } else if (view == this.hAG.bVm()) {
            bVf();
            this.hAG.nD(true);
        } else if (view == this.hAG.bVn()) {
            bVh();
        }
    }

    private void bVe() {
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
                MembersActivity.this.hAH.setOrderType(i2);
                MembersActivity.this.showToast(MembersActivity.this.getResources().getStringArray(R.array.members_order_by_short)[i]);
                MembersActivity.this.reset();
                MembersActivity.this.hAG.bSF().startPullRefresh();
            }
        });
        iVar.showDialog();
    }

    private void bVf() {
        this.hAG.wv(0);
        this.hAG.nC(false);
        this.hAG.bVp().nB(false);
        this.hAG.bVp().bVi();
        this.hAG.bVq();
    }

    private void bVg() {
        this.hAG.wv(0);
        this.hAG.nC(true);
        this.hAG.bVp().nB(true);
        this.hAG.bVq();
    }

    private void bVh() {
        Set<Long> bVj = this.hAG.bVp().bVj();
        if (bVj.size() > 0) {
            final ArrayList arrayList = new ArrayList();
            arrayList.addAll(bVj);
            DialogUtil.removeMembersDialog(getPageContext().getPageActivity(), new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    MembersActivity.this.hAG.nC(false);
                    MembersActivity.this.hAG.bVp().nB(false);
                    MembersActivity.this.hAG.bVq();
                    MembersActivity.this.a(MembersActivity.this.hAH.getGroupId(), arrayList);
                    MembersActivity.this.hAG.nD(true);
                }
            }, new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
        }
    }

    private void bcd() {
        if (this.hAG.bVp().bVk()) {
            this.hAH.sendMessage(this.hAH.getGroupId(), this.hAH.getStart(), this.hAH.getLen(), this.hAH.getOrderType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        bcd();
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public p onGetPreLoadListView() {
        if (this.hAG == null || this.hAG.bSF() == null) {
            return null;
        }
        return this.hAG.bSF().getPreLoadHandle();
    }
}
