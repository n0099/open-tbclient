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
import com.baidu.tbadk.core.view.h;
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
/* loaded from: classes5.dex */
public class MembersActivity extends BaseActivity<MembersActivity> implements View.OnClickListener, BdListView.e {
    private com.baidu.tbadk.core.view.i gHQ;
    private m gHR;
    private MembersModel gHS;
    private final com.baidu.adp.framework.listener.c gyE = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REQUEST_MEMBERS_BY_ID) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            RequestMembersMessage requestMembersMessage;
            l bBu = MembersActivity.this.gHR.bBu();
            MembersActivity.this.bpN();
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
            MembersActivity.this.gHS.setRequestM(requestMembersMessage);
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
                if (MembersActivity.this.buK()) {
                    MembersActivity.this.a(membersData.getPermission());
                }
                if (MembersActivity.this.buK()) {
                    bBu.reset(true);
                }
                if (users.size() != MembersActivity.this.gHS.getLen()) {
                    bBu.lX(false);
                    bBu.lY(false);
                    if (MembersActivity.this.buK() && users.size() == 0) {
                        MembersActivity.this.bBj();
                        return;
                    }
                } else {
                    bBu.lY(true);
                }
                MembersActivity.this.gHS.addStart(users.size());
                MembersActivity.this.gHS.setLen(20);
                bBu.dm(users);
                bBu.notifyDataSetChanged();
            }
        }
    };
    private final com.baidu.adp.framework.listener.c gHT = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REMOVE_MEMBERS) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            MembersActivity.this.gHR.ma(false);
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
            MembersActivity.this.gHR.bBu().dn(MembersActivity.this.gHS.getUserIds());
            MembersActivity.this.gHR.bBv();
            MembersActivity.this.gHR.bBu().bBo();
        }
    };
    private final CustomMessageListener gHU = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.2
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
                        MembersActivity.this.gHR.byG().startPullRefresh();
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
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_KICK_OUT, this.gHU);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_SUCCESS, this.gHU);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.gHS.saveInstance(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.gHR.bBt().anG();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public MembersModel bBi() {
        return this.gHS;
    }

    private void initUI() {
        this.gHR = new m(this);
        final BdListView byG = this.gHR.byG();
        this.gHQ = new com.baidu.tbadk.core.view.i(getPageContext());
        this.gHQ.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.1
            @Override // com.baidu.tbadk.core.view.h.c
            public void onListPullRefresh(boolean z) {
                if (!MembersActivity.this.gHR.bBu().bys()) {
                    if (!MembersActivity.this.buK()) {
                        MembersActivity.this.reset();
                    }
                    MembersActivity.this.gHS.sendMessage(MembersActivity.this.gHS.getGroupId(), MembersActivity.this.gHS.getStart(), MembersActivity.this.gHS.getLen(), MembersActivity.this.gHS.getOrderType());
                    return;
                }
                byG.completePullRefreshPostDelayed(0L);
            }
        });
        byG.setPullRefresh(this.gHQ);
        byG.setOnSrollToBottomListener(this);
        byG.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                l bBu = MembersActivity.this.gHR.bBu();
                UserData userData = (UserData) bBu.getItem(i);
                if (userData != null) {
                    if (bBu.bys()) {
                        if (!userData.getPermission().isController()) {
                            bBu.d(Long.valueOf(userData.getUserIdLong()));
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(MembersActivity.this.getPageContext().getContext(), userData.getUserId() + "", userData.getUserName())));
                }
            }
        });
        byG.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.4
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!MembersActivity.this.gHR.bBu().bys() && MembersActivity.this.gHS.isController()) {
                    UserData userData = (UserData) MembersActivity.this.gHR.bBu().getItem(i);
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
                                MembersActivity.this.b(MembersActivity.this.gHS.getGroupId(), arrayList);
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
        this.gHR.bBq().setOnClickListener(this);
        this.gHR.bBr().setOnClickListener(this);
        this.gHR.bBs().setOnClickListener(this);
        this.gHR.setController(false);
        this.gHR.bBu().a(new l.a() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.5
            @Override // com.baidu.tieba.im.frsgroup.l.a
            public void ui(int i) {
                MembersActivity.this.gHR.uj(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, List<Long> list) {
        if (list != null && list.size() != 0) {
            this.gHR.ma(true);
            this.gHS.setUserIds(list);
            this.gHS.sendRemoveMessage(j, dl(list));
        }
    }

    private String dl(List<Long> list) {
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
        this.gHS.setUseCache(false);
        this.gHS.setRequestM(null);
        this.gHR.bBu().reset(true);
        this.gHS.setStart(0);
        this.gHS.setLen(50);
        this.gHR.byG().startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.gHS.setUseCache(true);
        this.gHS.setRequestM(null);
        this.gHR.bBu().reset(false);
        this.gHS.setStart(0);
        this.gHS.setLen(50);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpN() {
        if (buK()) {
            this.gHR.bpN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean buK() {
        return 50 == this.gHS.getLen();
    }

    public void initData(Bundle bundle) {
        this.gHS = new MembersModel(this);
        this.gHS.setUniqueId(getUniqueId());
        if (bundle == null) {
            this.gHS.initWithIntent(getIntent());
        } else {
            this.gHS.initWithBundle(bundle);
        }
        registerListener(this.gyE);
        registerListener(this.gHT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserData.Permission permission) {
        if (permission != null) {
            boolean isController = permission.isController();
            this.gHS.setController(isController);
            this.gHR.setController(isController);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBj() {
        this.gHR.bBt().e(getPageContext());
        this.gHR.bBt().setTextOption(NoDataViewFactory.d.iL(R.string.members_no_person));
        this.gHR.bBt().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.gHR.onChangeSkinType(i);
        this.gHQ.changeSkin(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gHR.bBw()) {
            bBk();
        } else if (view == this.gHR.bBq()) {
            bBm();
            this.gHR.mc(false);
        } else if (view == this.gHR.bBr()) {
            bBl();
            this.gHR.mc(true);
        } else if (view == this.gHR.bBs()) {
            bBn();
        }
    }

    private void bBk() {
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
                MembersActivity.this.gHS.setOrderType(i2);
                MembersActivity.this.showToast(MembersActivity.this.getResources().getStringArray(R.array.members_order_by_short)[i]);
                MembersActivity.this.reset();
                MembersActivity.this.gHR.byG().startPullRefresh();
            }
        });
        iVar.showDialog();
    }

    private void bBl() {
        this.gHR.uj(0);
        this.gHR.mb(false);
        this.gHR.bBu().lZ(false);
        this.gHR.bBu().bBo();
        this.gHR.bBv();
    }

    private void bBm() {
        this.gHR.uj(0);
        this.gHR.mb(true);
        this.gHR.bBu().lZ(true);
        this.gHR.bBv();
    }

    private void bBn() {
        Set<Long> bBp = this.gHR.bBu().bBp();
        if (bBp.size() > 0) {
            final ArrayList arrayList = new ArrayList();
            arrayList.addAll(bBp);
            DialogUtil.removeMembersDialog(getPageContext().getPageActivity(), new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    MembersActivity.this.gHR.mb(false);
                    MembersActivity.this.gHR.bBu().lZ(false);
                    MembersActivity.this.gHR.bBv();
                    MembersActivity.this.b(MembersActivity.this.gHS.getGroupId(), arrayList);
                    MembersActivity.this.gHR.mc(true);
                }
            }, new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
        }
    }

    private void aIW() {
        if (this.gHR.bBu().bbn()) {
            this.gHS.sendMessage(this.gHS.getGroupId(), this.gHS.getStart(), this.gHS.getLen(), this.gHS.getOrderType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        aIW();
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public p onGetPreLoadListView() {
        if (this.gHR == null || this.gHR.byG() == null) {
            return null;
        }
        return this.gHR.byG().getPreLoadHandle();
    }
}
