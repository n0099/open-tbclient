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
/* loaded from: classes22.dex */
public class MembersActivity extends BaseActivity<MembersActivity> implements View.OnClickListener, BdListView.e {
    private com.baidu.tbadk.core.view.g kgK;
    private m kgL;
    private MembersModel kgM;
    private final com.baidu.adp.framework.listener.c jVA = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REQUEST_MEMBERS_BY_ID) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            RequestMembersMessage requestMembersMessage;
            l cRZ = MembersActivity.this.kgL.cRZ();
            MembersActivity.this.cEy();
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
            MembersActivity.this.kgM.setRequestM(requestMembersMessage);
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
                if (MembersActivity.this.cKy()) {
                    MembersActivity.this.a(membersData.getPermission());
                }
                if (MembersActivity.this.cKy()) {
                    cRZ.reset(true);
                }
                if (users.size() != MembersActivity.this.kgM.getLen()) {
                    cRZ.rW(false);
                    cRZ.rX(false);
                    if (MembersActivity.this.cKy() && users.size() == 0) {
                        MembersActivity.this.cRN();
                        return;
                    }
                } else {
                    cRZ.rX(true);
                }
                MembersActivity.this.kgM.addStart(users.size());
                MembersActivity.this.kgM.setLen(20);
                cRZ.el(users);
                cRZ.notifyDataSetChanged();
            }
        }
    };
    private final com.baidu.adp.framework.listener.c kgN = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REMOVE_MEMBERS) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            MembersActivity.this.kgL.showProgressBar(false);
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
            MembersActivity.this.kgL.cRZ().em(MembersActivity.this.kgM.getUserIds());
            MembersActivity.this.kgL.cSa();
            MembersActivity.this.kgL.cRZ().cRS();
        }
    };
    private final CustomMessageListener kgO = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.2
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
                        MembersActivity.this.kgL.cOV().startPullRefresh();
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
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_KICK_OUT, this.kgO);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_SUCCESS, this.kgO);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.kgM.saveInstance(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.kgL.cRY().brC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public MembersModel cRM() {
        return this.kgM;
    }

    private void initUI() {
        this.kgL = new m(this);
        final BdListView cOV = this.kgL.cOV();
        this.kgK = new com.baidu.tbadk.core.view.g(getPageContext());
        this.kgK.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (!MembersActivity.this.kgL.cRZ().cOF()) {
                    if (!MembersActivity.this.cKy()) {
                        MembersActivity.this.reset();
                    }
                    MembersActivity.this.kgM.sendMessage(MembersActivity.this.kgM.getGroupId(), MembersActivity.this.kgM.getStart(), MembersActivity.this.kgM.getLen(), MembersActivity.this.kgM.getOrderType());
                    return;
                }
                cOV.completePullRefreshPostDelayed(0L);
            }
        });
        cOV.setPullRefresh(this.kgK);
        cOV.setOnSrollToBottomListener(this);
        cOV.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                l cRZ = MembersActivity.this.kgL.cRZ();
                UserData userData = (UserData) cRZ.getItem(i);
                if (userData != null) {
                    if (cRZ.cOF()) {
                        if (!userData.getPermission().isController()) {
                            cRZ.i(Long.valueOf(userData.getUserIdLong()));
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(MembersActivity.this.getPageContext().getContext(), userData.getUserId() + "", userData.getUserName())));
                }
            }
        });
        cOV.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.4
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!MembersActivity.this.kgL.cRZ().cOF() && MembersActivity.this.kgM.isController()) {
                    UserData userData = (UserData) MembersActivity.this.kgL.cRZ().getItem(i);
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
                                MembersActivity.this.b(MembersActivity.this.kgM.getGroupId(), arrayList);
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
        this.kgL.cRV().setOnClickListener(this);
        this.kgL.cRW().setOnClickListener(this);
        this.kgL.cRX().setOnClickListener(this);
        this.kgL.setController(false);
        this.kgL.cRZ().a(new l.a() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.5
            @Override // com.baidu.tieba.im.frsgroup.l.a
            public void Du(int i) {
                MembersActivity.this.kgL.Dv(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, List<Long> list) {
        if (list != null && list.size() != 0) {
            this.kgL.showProgressBar(true);
            this.kgM.setUserIds(list);
            this.kgM.sendRemoveMessage(j, ek(list));
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
        this.kgM.setUseCache(false);
        this.kgM.setRequestM(null);
        this.kgL.cRZ().reset(true);
        this.kgM.setStart(0);
        this.kgM.setLen(50);
        this.kgL.cOV().startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.kgM.setUseCache(true);
        this.kgM.setRequestM(null);
        this.kgL.cRZ().reset(false);
        this.kgM.setStart(0);
        this.kgM.setLen(50);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEy() {
        if (cKy()) {
            this.kgL.cEy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cKy() {
        return 50 == this.kgM.getLen();
    }

    public void initData(Bundle bundle) {
        this.kgM = new MembersModel(this);
        this.kgM.setUniqueId(getUniqueId());
        if (bundle == null) {
            this.kgM.initWithIntent(getIntent());
        } else {
            this.kgM.initWithBundle(bundle);
        }
        registerListener(this.jVA);
        registerListener(this.kgN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserData.Permission permission) {
        if (permission != null) {
            boolean isController = permission.isController();
            this.kgM.setController(isController);
            this.kgL.setController(isController);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRN() {
        this.kgL.cRY().e(getPageContext());
        this.kgL.cRY().setTextOption(NoDataViewFactory.d.qo(R.string.members_no_person));
        this.kgL.cRY().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.kgL.onChangeSkinType(i);
        this.kgK.changeSkin(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.kgL.cSb()) {
            cRO();
        } else if (view == this.kgL.cRV()) {
            cRQ();
            this.kgL.sa(false);
        } else if (view == this.kgL.cRW()) {
            cRP();
            this.kgL.sa(true);
        } else if (view == this.kgL.cRX()) {
            cRR();
        }
    }

    private void cRO() {
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
                MembersActivity.this.kgM.setOrderType(i2);
                MembersActivity.this.showToast(MembersActivity.this.getResources().getStringArray(R.array.members_order_by_short)[i]);
                MembersActivity.this.reset();
                MembersActivity.this.kgL.cOV().startPullRefresh();
            }
        });
        iVar.PA();
    }

    private void cRP() {
        this.kgL.Dv(0);
        this.kgL.rZ(false);
        this.kgL.cRZ().rY(false);
        this.kgL.cRZ().cRS();
        this.kgL.cSa();
    }

    private void cRQ() {
        this.kgL.Dv(0);
        this.kgL.rZ(true);
        this.kgL.cRZ().rY(true);
        this.kgL.cSa();
    }

    private void cRR() {
        Set<Long> cRT = this.kgL.cRZ().cRT();
        if (cRT.size() > 0) {
            final ArrayList arrayList = new ArrayList();
            arrayList.addAll(cRT);
            DialogUtil.removeMembersDialog(getPageContext().getPageActivity(), new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    MembersActivity.this.kgL.rZ(false);
                    MembersActivity.this.kgL.cRZ().rY(false);
                    MembersActivity.this.kgL.cSa();
                    MembersActivity.this.b(MembersActivity.this.kgM.getGroupId(), arrayList);
                    MembersActivity.this.kgL.sa(true);
                }
            }, new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
        }
    }

    private void bOb() {
        if (this.kgL.cRZ().cRU()) {
            this.kgM.sendMessage(this.kgM.getGroupId(), this.kgM.getStart(), this.kgM.getLen(), this.kgM.getOrderType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        bOb();
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public t onGetPreLoadListView() {
        if (this.kgL == null || this.kgL.cOV() == null) {
            return null;
        }
        return this.kgL.cOV().getPreLoadHandle();
    }
}
