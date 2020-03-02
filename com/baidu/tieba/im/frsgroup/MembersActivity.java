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
    private com.baidu.tbadk.core.view.h hAH;
    private m hAI;
    private MembersModel hAJ;
    private final com.baidu.adp.framework.listener.c hrA = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REQUEST_MEMBERS_BY_ID) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            RequestMembersMessage requestMembersMessage;
            l bVr = MembersActivity.this.hAI.bVr();
            MembersActivity.this.bJN();
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
            MembersActivity.this.hAJ.setRequestM(requestMembersMessage);
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
                if (MembersActivity.this.bOI()) {
                    MembersActivity.this.a(membersData.getPermission());
                }
                if (MembersActivity.this.bOI()) {
                    bVr.reset(true);
                }
                if (users.size() != MembersActivity.this.hAJ.getLen()) {
                    bVr.nz(false);
                    bVr.nA(false);
                    if (MembersActivity.this.bOI() && users.size() == 0) {
                        MembersActivity.this.bVf();
                        return;
                    }
                } else {
                    bVr.nA(true);
                }
                MembersActivity.this.hAJ.addStart(users.size());
                MembersActivity.this.hAJ.setLen(20);
                bVr.cX(users);
                bVr.notifyDataSetChanged();
            }
        }
    };
    private final com.baidu.adp.framework.listener.c hAK = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REMOVE_MEMBERS) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            MembersActivity.this.hAI.showProgressBar(false);
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
            MembersActivity.this.hAI.bVr().cY(MembersActivity.this.hAJ.getUserIds());
            MembersActivity.this.hAI.bVs();
            MembersActivity.this.hAI.bVr().bVk();
        }
    };
    private final CustomMessageListener hAL = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.2
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
                        MembersActivity.this.hAI.bSH().startPullRefresh();
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
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_KICK_OUT, this.hAL);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_SUCCESS, this.hAL);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.hAJ.saveInstance(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.hAI.bVq().aHB();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public MembersModel bVe() {
        return this.hAJ;
    }

    private void initUI() {
        this.hAI = new m(this);
        final BdListView bSH = this.hAI.bSH();
        this.hAH = new com.baidu.tbadk.core.view.h(getPageContext());
        this.hAH.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.1
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (!MembersActivity.this.hAI.bVr().bSu()) {
                    if (!MembersActivity.this.bOI()) {
                        MembersActivity.this.reset();
                    }
                    MembersActivity.this.hAJ.sendMessage(MembersActivity.this.hAJ.getGroupId(), MembersActivity.this.hAJ.getStart(), MembersActivity.this.hAJ.getLen(), MembersActivity.this.hAJ.getOrderType());
                    return;
                }
                bSH.completePullRefreshPostDelayed(0L);
            }
        });
        bSH.setPullRefresh(this.hAH);
        bSH.setOnSrollToBottomListener(this);
        bSH.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                l bVr = MembersActivity.this.hAI.bVr();
                UserData userData = (UserData) bVr.getItem(i);
                if (userData != null) {
                    if (bVr.bSu()) {
                        if (!userData.getPermission().isController()) {
                            bVr.f(Long.valueOf(userData.getUserIdLong()));
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(MembersActivity.this.getPageContext().getContext(), userData.getUserId() + "", userData.getUserName())));
                }
            }
        });
        bSH.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.4
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!MembersActivity.this.hAI.bVr().bSu() && MembersActivity.this.hAJ.isController()) {
                    UserData userData = (UserData) MembersActivity.this.hAI.bVr().getItem(i);
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
                                MembersActivity.this.a(MembersActivity.this.hAJ.getGroupId(), arrayList);
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
        this.hAI.bVn().setOnClickListener(this);
        this.hAI.bVo().setOnClickListener(this);
        this.hAI.bVp().setOnClickListener(this);
        this.hAI.setController(false);
        this.hAI.bVr().a(new l.a() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.5
            @Override // com.baidu.tieba.im.frsgroup.l.a
            public void wu(int i) {
                MembersActivity.this.hAI.wv(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, List<Long> list) {
        if (list != null && list.size() != 0) {
            this.hAI.showProgressBar(true);
            this.hAJ.setUserIds(list);
            this.hAJ.sendRemoveMessage(j, cW(list));
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
        this.hAJ.setUseCache(false);
        this.hAJ.setRequestM(null);
        this.hAI.bVr().reset(true);
        this.hAJ.setStart(0);
        this.hAJ.setLen(50);
        this.hAI.bSH().startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.hAJ.setUseCache(true);
        this.hAJ.setRequestM(null);
        this.hAI.bVr().reset(false);
        this.hAJ.setStart(0);
        this.hAJ.setLen(50);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJN() {
        if (bOI()) {
            this.hAI.bJN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bOI() {
        return 50 == this.hAJ.getLen();
    }

    public void initData(Bundle bundle) {
        this.hAJ = new MembersModel(this);
        this.hAJ.setUniqueId(getUniqueId());
        if (bundle == null) {
            this.hAJ.initWithIntent(getIntent());
        } else {
            this.hAJ.initWithBundle(bundle);
        }
        registerListener(this.hrA);
        registerListener(this.hAK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserData.Permission permission) {
        if (permission != null) {
            boolean isController = permission.isController();
            this.hAJ.setController(isController);
            this.hAI.setController(isController);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVf() {
        this.hAI.bVq().e(getPageContext());
        this.hAI.bVq().setTextOption(NoDataViewFactory.d.lh(R.string.members_no_person));
        this.hAI.bVq().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.hAI.onChangeSkinType(i);
        this.hAH.changeSkin(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hAI.bVt()) {
            bVg();
        } else if (view == this.hAI.bVn()) {
            bVi();
            this.hAI.nD(false);
        } else if (view == this.hAI.bVo()) {
            bVh();
            this.hAI.nD(true);
        } else if (view == this.hAI.bVp()) {
            bVj();
        }
    }

    private void bVg() {
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
                MembersActivity.this.hAJ.setOrderType(i2);
                MembersActivity.this.showToast(MembersActivity.this.getResources().getStringArray(R.array.members_order_by_short)[i]);
                MembersActivity.this.reset();
                MembersActivity.this.hAI.bSH().startPullRefresh();
            }
        });
        iVar.showDialog();
    }

    private void bVh() {
        this.hAI.wv(0);
        this.hAI.nC(false);
        this.hAI.bVr().nB(false);
        this.hAI.bVr().bVk();
        this.hAI.bVs();
    }

    private void bVi() {
        this.hAI.wv(0);
        this.hAI.nC(true);
        this.hAI.bVr().nB(true);
        this.hAI.bVs();
    }

    private void bVj() {
        Set<Long> bVl = this.hAI.bVr().bVl();
        if (bVl.size() > 0) {
            final ArrayList arrayList = new ArrayList();
            arrayList.addAll(bVl);
            DialogUtil.removeMembersDialog(getPageContext().getPageActivity(), new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    MembersActivity.this.hAI.nC(false);
                    MembersActivity.this.hAI.bVr().nB(false);
                    MembersActivity.this.hAI.bVs();
                    MembersActivity.this.a(MembersActivity.this.hAJ.getGroupId(), arrayList);
                    MembersActivity.this.hAI.nD(true);
                }
            }, new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
        }
    }

    private void bcf() {
        if (this.hAI.bVr().bVm()) {
            this.hAJ.sendMessage(this.hAJ.getGroupId(), this.hAJ.getStart(), this.hAJ.getLen(), this.hAJ.getOrderType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        bcf();
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public p onGetPreLoadListView() {
        if (this.hAI == null || this.hAI.bSH() == null) {
            return null;
        }
        return this.hAI.bSH().getPreLoadHandle();
    }
}
