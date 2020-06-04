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
import com.baidu.adp.widget.ListView.r;
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
    private com.baidu.tbadk.core.view.g iBI;
    private m iBJ;
    private MembersModel iBK;
    private final com.baidu.adp.framework.listener.c isB = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REQUEST_MEMBERS_BY_ID) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            RequestMembersMessage requestMembersMessage;
            l cmQ = MembersActivity.this.iBJ.cmQ();
            MembersActivity.this.cbc();
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
            MembersActivity.this.iBK.setRequestM(requestMembersMessage);
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
                if (MembersActivity.this.cgb()) {
                    MembersActivity.this.a(membersData.getPermission());
                }
                if (MembersActivity.this.cgb()) {
                    cmQ.reset(true);
                }
                if (users.size() != MembersActivity.this.iBK.getLen()) {
                    cmQ.pf(false);
                    cmQ.pg(false);
                    if (MembersActivity.this.cgb() && users.size() == 0) {
                        MembersActivity.this.cmE();
                        return;
                    }
                } else {
                    cmQ.pg(true);
                }
                MembersActivity.this.iBK.addStart(users.size());
                MembersActivity.this.iBK.setLen(20);
                cmQ.dh(users);
                cmQ.notifyDataSetChanged();
            }
        }
    };
    private final com.baidu.adp.framework.listener.c iBL = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REMOVE_MEMBERS) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            MembersActivity.this.iBJ.showProgressBar(false);
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
            MembersActivity.this.iBJ.cmQ().di(MembersActivity.this.iBK.getUserIds());
            MembersActivity.this.iBJ.cmR();
            MembersActivity.this.iBJ.cmQ().cmJ();
        }
    };
    private final CustomMessageListener iBM = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.2
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
                        MembersActivity.this.iBJ.ckg().startPullRefresh();
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
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_KICK_OUT, this.iBM);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_SUCCESS, this.iBM);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.iBK.saveInstance(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.iBJ.cmP().aWa();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public MembersModel cmD() {
        return this.iBK;
    }

    private void initUI() {
        this.iBJ = new m(this);
        final BdListView ckg = this.iBJ.ckg();
        this.iBI = new com.baidu.tbadk.core.view.g(getPageContext());
        this.iBI.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (!MembersActivity.this.iBJ.cmQ().cjS()) {
                    if (!MembersActivity.this.cgb()) {
                        MembersActivity.this.reset();
                    }
                    MembersActivity.this.iBK.sendMessage(MembersActivity.this.iBK.getGroupId(), MembersActivity.this.iBK.getStart(), MembersActivity.this.iBK.getLen(), MembersActivity.this.iBK.getOrderType());
                    return;
                }
                ckg.completePullRefreshPostDelayed(0L);
            }
        });
        ckg.setPullRefresh(this.iBI);
        ckg.setOnSrollToBottomListener(this);
        ckg.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                l cmQ = MembersActivity.this.iBJ.cmQ();
                UserData userData = (UserData) cmQ.getItem(i);
                if (userData != null) {
                    if (cmQ.cjS()) {
                        if (!userData.getPermission().isController()) {
                            cmQ.f(Long.valueOf(userData.getUserIdLong()));
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(MembersActivity.this.getPageContext().getContext(), userData.getUserId() + "", userData.getUserName())));
                }
            }
        });
        ckg.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.4
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!MembersActivity.this.iBJ.cmQ().cjS() && MembersActivity.this.iBK.isController()) {
                    UserData userData = (UserData) MembersActivity.this.iBJ.cmQ().getItem(i);
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
                                MembersActivity.this.a(MembersActivity.this.iBK.getGroupId(), arrayList);
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
        this.iBJ.cmM().setOnClickListener(this);
        this.iBJ.cmN().setOnClickListener(this);
        this.iBJ.cmO().setOnClickListener(this);
        this.iBJ.setController(false);
        this.iBJ.cmQ().a(new l.a() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.5
            @Override // com.baidu.tieba.im.frsgroup.l.a
            public void xI(int i) {
                MembersActivity.this.iBJ.xJ(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, List<Long> list) {
        if (list != null && list.size() != 0) {
            this.iBJ.showProgressBar(true);
            this.iBK.setUserIds(list);
            this.iBK.sendRemoveMessage(j, dg(list));
        }
    }

    private String dg(List<Long> list) {
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
        this.iBK.setUseCache(false);
        this.iBK.setRequestM(null);
        this.iBJ.cmQ().reset(true);
        this.iBK.setStart(0);
        this.iBK.setLen(50);
        this.iBJ.ckg().startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.iBK.setUseCache(true);
        this.iBK.setRequestM(null);
        this.iBJ.cmQ().reset(false);
        this.iBK.setStart(0);
        this.iBK.setLen(50);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbc() {
        if (cgb()) {
            this.iBJ.cbc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cgb() {
        return 50 == this.iBK.getLen();
    }

    public void initData(Bundle bundle) {
        this.iBK = new MembersModel(this);
        this.iBK.setUniqueId(getUniqueId());
        if (bundle == null) {
            this.iBK.initWithIntent(getIntent());
        } else {
            this.iBK.initWithBundle(bundle);
        }
        registerListener(this.isB);
        registerListener(this.iBL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserData.Permission permission) {
        if (permission != null) {
            boolean isController = permission.isController();
            this.iBK.setController(isController);
            this.iBJ.setController(isController);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmE() {
        this.iBJ.cmP().e(getPageContext());
        this.iBJ.cmP().setTextOption(NoDataViewFactory.d.lV(R.string.members_no_person));
        this.iBJ.cmP().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.iBJ.onChangeSkinType(i);
        this.iBI.changeSkin(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iBJ.cmS()) {
            cmF();
        } else if (view == this.iBJ.cmM()) {
            cmH();
            this.iBJ.pj(false);
        } else if (view == this.iBJ.cmN()) {
            cmG();
            this.iBJ.pj(true);
        } else if (view == this.iBJ.cmO()) {
            cmI();
        }
    }

    private void cmF() {
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
                MembersActivity.this.iBK.setOrderType(i2);
                MembersActivity.this.showToast(MembersActivity.this.getResources().getStringArray(R.array.members_order_by_short)[i]);
                MembersActivity.this.reset();
                MembersActivity.this.iBJ.ckg().startPullRefresh();
            }
        });
        iVar.showDialog();
    }

    private void cmG() {
        this.iBJ.xJ(0);
        this.iBJ.pi(false);
        this.iBJ.cmQ().ph(false);
        this.iBJ.cmQ().cmJ();
        this.iBJ.cmR();
    }

    private void cmH() {
        this.iBJ.xJ(0);
        this.iBJ.pi(true);
        this.iBJ.cmQ().ph(true);
        this.iBJ.cmR();
    }

    private void cmI() {
        Set<Long> cmK = this.iBJ.cmQ().cmK();
        if (cmK.size() > 0) {
            final ArrayList arrayList = new ArrayList();
            arrayList.addAll(cmK);
            DialogUtil.removeMembersDialog(getPageContext().getPageActivity(), new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    MembersActivity.this.iBJ.pi(false);
                    MembersActivity.this.iBJ.cmQ().ph(false);
                    MembersActivity.this.iBJ.cmR();
                    MembersActivity.this.a(MembersActivity.this.iBK.getGroupId(), arrayList);
                    MembersActivity.this.iBJ.pj(true);
                }
            }, new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
        }
    }

    private void bqx() {
        if (this.iBJ.cmQ().cmL()) {
            this.iBK.sendMessage(this.iBK.getGroupId(), this.iBK.getStart(), this.iBK.getLen(), this.iBK.getOrderType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        bqx();
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public r onGetPreLoadListView() {
        if (this.iBJ == null || this.iBJ.ckg() == null) {
            return null;
        }
        return this.iBJ.ckg().getPreLoadHandle();
    }
}
