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
    private com.baidu.tbadk.core.view.h hAT;
    private m hAU;
    private MembersModel hAV;
    private final com.baidu.adp.framework.listener.c hrM = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REQUEST_MEMBERS_BY_ID) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            RequestMembersMessage requestMembersMessage;
            l bVs = MembersActivity.this.hAU.bVs();
            MembersActivity.this.bJO();
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
            MembersActivity.this.hAV.setRequestM(requestMembersMessage);
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
                if (MembersActivity.this.bOJ()) {
                    MembersActivity.this.a(membersData.getPermission());
                }
                if (MembersActivity.this.bOJ()) {
                    bVs.reset(true);
                }
                if (users.size() != MembersActivity.this.hAV.getLen()) {
                    bVs.nz(false);
                    bVs.nA(false);
                    if (MembersActivity.this.bOJ() && users.size() == 0) {
                        MembersActivity.this.bVg();
                        return;
                    }
                } else {
                    bVs.nA(true);
                }
                MembersActivity.this.hAV.addStart(users.size());
                MembersActivity.this.hAV.setLen(20);
                bVs.cX(users);
                bVs.notifyDataSetChanged();
            }
        }
    };
    private final com.baidu.adp.framework.listener.c hAW = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REMOVE_MEMBERS) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            MembersActivity.this.hAU.showProgressBar(false);
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
            MembersActivity.this.hAU.bVs().cY(MembersActivity.this.hAV.getUserIds());
            MembersActivity.this.hAU.bVt();
            MembersActivity.this.hAU.bVs().bVl();
        }
    };
    private final CustomMessageListener hAX = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.2
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
                        MembersActivity.this.hAU.bSI().startPullRefresh();
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
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_KICK_OUT, this.hAX);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_SUCCESS, this.hAX);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.hAV.saveInstance(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.hAU.bVr().aHC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public MembersModel bVf() {
        return this.hAV;
    }

    private void initUI() {
        this.hAU = new m(this);
        final BdListView bSI = this.hAU.bSI();
        this.hAT = new com.baidu.tbadk.core.view.h(getPageContext());
        this.hAT.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.1
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (!MembersActivity.this.hAU.bVs().bSv()) {
                    if (!MembersActivity.this.bOJ()) {
                        MembersActivity.this.reset();
                    }
                    MembersActivity.this.hAV.sendMessage(MembersActivity.this.hAV.getGroupId(), MembersActivity.this.hAV.getStart(), MembersActivity.this.hAV.getLen(), MembersActivity.this.hAV.getOrderType());
                    return;
                }
                bSI.completePullRefreshPostDelayed(0L);
            }
        });
        bSI.setPullRefresh(this.hAT);
        bSI.setOnSrollToBottomListener(this);
        bSI.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                l bVs = MembersActivity.this.hAU.bVs();
                UserData userData = (UserData) bVs.getItem(i);
                if (userData != null) {
                    if (bVs.bSv()) {
                        if (!userData.getPermission().isController()) {
                            bVs.f(Long.valueOf(userData.getUserIdLong()));
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(MembersActivity.this.getPageContext().getContext(), userData.getUserId() + "", userData.getUserName())));
                }
            }
        });
        bSI.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.4
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!MembersActivity.this.hAU.bVs().bSv() && MembersActivity.this.hAV.isController()) {
                    UserData userData = (UserData) MembersActivity.this.hAU.bVs().getItem(i);
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
                                MembersActivity.this.a(MembersActivity.this.hAV.getGroupId(), arrayList);
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
        this.hAU.bVo().setOnClickListener(this);
        this.hAU.bVp().setOnClickListener(this);
        this.hAU.bVq().setOnClickListener(this);
        this.hAU.setController(false);
        this.hAU.bVs().a(new l.a() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.5
            @Override // com.baidu.tieba.im.frsgroup.l.a
            public void wu(int i) {
                MembersActivity.this.hAU.wv(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, List<Long> list) {
        if (list != null && list.size() != 0) {
            this.hAU.showProgressBar(true);
            this.hAV.setUserIds(list);
            this.hAV.sendRemoveMessage(j, cW(list));
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
        this.hAV.setUseCache(false);
        this.hAV.setRequestM(null);
        this.hAU.bVs().reset(true);
        this.hAV.setStart(0);
        this.hAV.setLen(50);
        this.hAU.bSI().startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.hAV.setUseCache(true);
        this.hAV.setRequestM(null);
        this.hAU.bVs().reset(false);
        this.hAV.setStart(0);
        this.hAV.setLen(50);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJO() {
        if (bOJ()) {
            this.hAU.bJO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bOJ() {
        return 50 == this.hAV.getLen();
    }

    public void initData(Bundle bundle) {
        this.hAV = new MembersModel(this);
        this.hAV.setUniqueId(getUniqueId());
        if (bundle == null) {
            this.hAV.initWithIntent(getIntent());
        } else {
            this.hAV.initWithBundle(bundle);
        }
        registerListener(this.hrM);
        registerListener(this.hAW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserData.Permission permission) {
        if (permission != null) {
            boolean isController = permission.isController();
            this.hAV.setController(isController);
            this.hAU.setController(isController);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVg() {
        this.hAU.bVr().e(getPageContext());
        this.hAU.bVr().setTextOption(NoDataViewFactory.d.lh(R.string.members_no_person));
        this.hAU.bVr().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.hAU.onChangeSkinType(i);
        this.hAT.changeSkin(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hAU.bVu()) {
            bVh();
        } else if (view == this.hAU.bVo()) {
            bVj();
            this.hAU.nD(false);
        } else if (view == this.hAU.bVp()) {
            bVi();
            this.hAU.nD(true);
        } else if (view == this.hAU.bVq()) {
            bVk();
        }
    }

    private void bVh() {
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
                MembersActivity.this.hAV.setOrderType(i2);
                MembersActivity.this.showToast(MembersActivity.this.getResources().getStringArray(R.array.members_order_by_short)[i]);
                MembersActivity.this.reset();
                MembersActivity.this.hAU.bSI().startPullRefresh();
            }
        });
        iVar.showDialog();
    }

    private void bVi() {
        this.hAU.wv(0);
        this.hAU.nC(false);
        this.hAU.bVs().nB(false);
        this.hAU.bVs().bVl();
        this.hAU.bVt();
    }

    private void bVj() {
        this.hAU.wv(0);
        this.hAU.nC(true);
        this.hAU.bVs().nB(true);
        this.hAU.bVt();
    }

    private void bVk() {
        Set<Long> bVm = this.hAU.bVs().bVm();
        if (bVm.size() > 0) {
            final ArrayList arrayList = new ArrayList();
            arrayList.addAll(bVm);
            DialogUtil.removeMembersDialog(getPageContext().getPageActivity(), new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    MembersActivity.this.hAU.nC(false);
                    MembersActivity.this.hAU.bVs().nB(false);
                    MembersActivity.this.hAU.bVt();
                    MembersActivity.this.a(MembersActivity.this.hAV.getGroupId(), arrayList);
                    MembersActivity.this.hAU.nD(true);
                }
            }, new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
        }
    }

    private void bcg() {
        if (this.hAU.bVs().bVn()) {
            this.hAV.sendMessage(this.hAV.getGroupId(), this.hAV.getStart(), this.hAV.getLen(), this.hAV.getOrderType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        bcg();
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public p onGetPreLoadListView() {
        if (this.hAU == null || this.hAU.bSI() == null) {
            return null;
        }
        return this.hAU.bSI().getPreLoadHandle();
    }
}
