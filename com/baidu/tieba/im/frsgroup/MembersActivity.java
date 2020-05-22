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
    private com.baidu.tbadk.core.view.g iAV;
    private m iAW;
    private MembersModel iAX;
    private final com.baidu.adp.framework.listener.c irO = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REQUEST_MEMBERS_BY_ID) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            RequestMembersMessage requestMembersMessage;
            l cmH = MembersActivity.this.iAW.cmH();
            MembersActivity.this.caU();
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
            MembersActivity.this.iAX.setRequestM(requestMembersMessage);
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
                if (MembersActivity.this.cfS()) {
                    MembersActivity.this.a(membersData.getPermission());
                }
                if (MembersActivity.this.cfS()) {
                    cmH.reset(true);
                }
                if (users.size() != MembersActivity.this.iAX.getLen()) {
                    cmH.pf(false);
                    cmH.pg(false);
                    if (MembersActivity.this.cfS() && users.size() == 0) {
                        MembersActivity.this.cmv();
                        return;
                    }
                } else {
                    cmH.pg(true);
                }
                MembersActivity.this.iAX.addStart(users.size());
                MembersActivity.this.iAX.setLen(20);
                cmH.dg(users);
                cmH.notifyDataSetChanged();
            }
        }
    };
    private final com.baidu.adp.framework.listener.c iAY = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REMOVE_MEMBERS) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            MembersActivity.this.iAW.showProgressBar(false);
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
            MembersActivity.this.iAW.cmH().dh(MembersActivity.this.iAX.getUserIds());
            MembersActivity.this.iAW.cmI();
            MembersActivity.this.iAW.cmH().cmA();
        }
    };
    private final CustomMessageListener iAZ = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.2
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
                        MembersActivity.this.iAW.cjX().startPullRefresh();
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
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_KICK_OUT, this.iAZ);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_SUCCESS, this.iAZ);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.iAX.saveInstance(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.iAW.cmG().aVZ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public MembersModel cmu() {
        return this.iAX;
    }

    private void initUI() {
        this.iAW = new m(this);
        final BdListView cjX = this.iAW.cjX();
        this.iAV = new com.baidu.tbadk.core.view.g(getPageContext());
        this.iAV.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (!MembersActivity.this.iAW.cmH().cjJ()) {
                    if (!MembersActivity.this.cfS()) {
                        MembersActivity.this.reset();
                    }
                    MembersActivity.this.iAX.sendMessage(MembersActivity.this.iAX.getGroupId(), MembersActivity.this.iAX.getStart(), MembersActivity.this.iAX.getLen(), MembersActivity.this.iAX.getOrderType());
                    return;
                }
                cjX.completePullRefreshPostDelayed(0L);
            }
        });
        cjX.setPullRefresh(this.iAV);
        cjX.setOnSrollToBottomListener(this);
        cjX.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                l cmH = MembersActivity.this.iAW.cmH();
                UserData userData = (UserData) cmH.getItem(i);
                if (userData != null) {
                    if (cmH.cjJ()) {
                        if (!userData.getPermission().isController()) {
                            cmH.f(Long.valueOf(userData.getUserIdLong()));
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(MembersActivity.this.getPageContext().getContext(), userData.getUserId() + "", userData.getUserName())));
                }
            }
        });
        cjX.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.4
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!MembersActivity.this.iAW.cmH().cjJ() && MembersActivity.this.iAX.isController()) {
                    UserData userData = (UserData) MembersActivity.this.iAW.cmH().getItem(i);
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
                                MembersActivity.this.a(MembersActivity.this.iAX.getGroupId(), arrayList);
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
        this.iAW.cmD().setOnClickListener(this);
        this.iAW.cmE().setOnClickListener(this);
        this.iAW.cmF().setOnClickListener(this);
        this.iAW.setController(false);
        this.iAW.cmH().a(new l.a() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.5
            @Override // com.baidu.tieba.im.frsgroup.l.a
            public void xG(int i) {
                MembersActivity.this.iAW.xH(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, List<Long> list) {
        if (list != null && list.size() != 0) {
            this.iAW.showProgressBar(true);
            this.iAX.setUserIds(list);
            this.iAX.sendRemoveMessage(j, df(list));
        }
    }

    private String df(List<Long> list) {
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
        this.iAX.setUseCache(false);
        this.iAX.setRequestM(null);
        this.iAW.cmH().reset(true);
        this.iAX.setStart(0);
        this.iAX.setLen(50);
        this.iAW.cjX().startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.iAX.setUseCache(true);
        this.iAX.setRequestM(null);
        this.iAW.cmH().reset(false);
        this.iAX.setStart(0);
        this.iAX.setLen(50);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caU() {
        if (cfS()) {
            this.iAW.caU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cfS() {
        return 50 == this.iAX.getLen();
    }

    public void initData(Bundle bundle) {
        this.iAX = new MembersModel(this);
        this.iAX.setUniqueId(getUniqueId());
        if (bundle == null) {
            this.iAX.initWithIntent(getIntent());
        } else {
            this.iAX.initWithBundle(bundle);
        }
        registerListener(this.irO);
        registerListener(this.iAY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserData.Permission permission) {
        if (permission != null) {
            boolean isController = permission.isController();
            this.iAX.setController(isController);
            this.iAW.setController(isController);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmv() {
        this.iAW.cmG().e(getPageContext());
        this.iAW.cmG().setTextOption(NoDataViewFactory.d.lT(R.string.members_no_person));
        this.iAW.cmG().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.iAW.onChangeSkinType(i);
        this.iAV.changeSkin(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iAW.cmJ()) {
            cmw();
        } else if (view == this.iAW.cmD()) {
            cmy();
            this.iAW.pj(false);
        } else if (view == this.iAW.cmE()) {
            cmx();
            this.iAW.pj(true);
        } else if (view == this.iAW.cmF()) {
            cmz();
        }
    }

    private void cmw() {
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
                MembersActivity.this.iAX.setOrderType(i2);
                MembersActivity.this.showToast(MembersActivity.this.getResources().getStringArray(R.array.members_order_by_short)[i]);
                MembersActivity.this.reset();
                MembersActivity.this.iAW.cjX().startPullRefresh();
            }
        });
        iVar.showDialog();
    }

    private void cmx() {
        this.iAW.xH(0);
        this.iAW.pi(false);
        this.iAW.cmH().ph(false);
        this.iAW.cmH().cmA();
        this.iAW.cmI();
    }

    private void cmy() {
        this.iAW.xH(0);
        this.iAW.pi(true);
        this.iAW.cmH().ph(true);
        this.iAW.cmI();
    }

    private void cmz() {
        Set<Long> cmB = this.iAW.cmH().cmB();
        if (cmB.size() > 0) {
            final ArrayList arrayList = new ArrayList();
            arrayList.addAll(cmB);
            DialogUtil.removeMembersDialog(getPageContext().getPageActivity(), new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    MembersActivity.this.iAW.pi(false);
                    MembersActivity.this.iAW.cmH().ph(false);
                    MembersActivity.this.iAW.cmI();
                    MembersActivity.this.a(MembersActivity.this.iAX.getGroupId(), arrayList);
                    MembersActivity.this.iAW.pj(true);
                }
            }, new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
        }
    }

    private void bqv() {
        if (this.iAW.cmH().cmC()) {
            this.iAX.sendMessage(this.iAX.getGroupId(), this.iAX.getStart(), this.iAX.getLen(), this.iAX.getOrderType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        bqv();
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public r onGetPreLoadListView() {
        if (this.iAW == null || this.iAW.cjX() == null) {
            return null;
        }
        return this.iAW.cjX().getPreLoadHandle();
    }
}
