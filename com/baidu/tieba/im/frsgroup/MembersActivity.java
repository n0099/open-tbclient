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
/* loaded from: classes17.dex */
public class MembersActivity extends BaseActivity<MembersActivity> implements View.OnClickListener, BdListView.e {
    private com.baidu.tbadk.core.view.g jaX;
    private m jaY;
    private MembersModel jaZ;
    private final com.baidu.adp.framework.listener.c iPM = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REQUEST_MEMBERS_BY_ID) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            RequestMembersMessage requestMembersMessage;
            l cuE = MembersActivity.this.jaY.cuE();
            MembersActivity.this.chU();
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
            MembersActivity.this.jaZ.setRequestM(requestMembersMessage);
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
                if (MembersActivity.this.cnd()) {
                    MembersActivity.this.a(membersData.getPermission());
                }
                if (MembersActivity.this.cnd()) {
                    cuE.reset(true);
                }
                if (users.size() != MembersActivity.this.jaZ.getLen()) {
                    cuE.pW(false);
                    cuE.pX(false);
                    if (MembersActivity.this.cnd() && users.size() == 0) {
                        MembersActivity.this.cus();
                        return;
                    }
                } else {
                    cuE.pX(true);
                }
                MembersActivity.this.jaZ.addStart(users.size());
                MembersActivity.this.jaZ.setLen(20);
                cuE.dC(users);
                cuE.notifyDataSetChanged();
            }
        }
    };
    private final com.baidu.adp.framework.listener.c jba = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REMOVE_MEMBERS) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            MembersActivity.this.jaY.showProgressBar(false);
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
            MembersActivity.this.jaY.cuE().dD(MembersActivity.this.jaZ.getUserIds());
            MembersActivity.this.jaY.cuF();
            MembersActivity.this.jaY.cuE().cux();
        }
    };
    private final CustomMessageListener jbb = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.2
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
                        MembersActivity.this.jaY.crz().startPullRefresh();
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
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_KICK_OUT, this.jbb);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_SUCCESS, this.jbb);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.jaZ.saveInstance(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.jaY.cuD().bbU();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public MembersModel cur() {
        return this.jaZ;
    }

    private void initUI() {
        this.jaY = new m(this);
        final BdListView crz = this.jaY.crz();
        this.jaX = new com.baidu.tbadk.core.view.g(getPageContext());
        this.jaX.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (!MembersActivity.this.jaY.cuE().cri()) {
                    if (!MembersActivity.this.cnd()) {
                        MembersActivity.this.reset();
                    }
                    MembersActivity.this.jaZ.sendMessage(MembersActivity.this.jaZ.getGroupId(), MembersActivity.this.jaZ.getStart(), MembersActivity.this.jaZ.getLen(), MembersActivity.this.jaZ.getOrderType());
                    return;
                }
                crz.completePullRefreshPostDelayed(0L);
            }
        });
        crz.setPullRefresh(this.jaX);
        crz.setOnSrollToBottomListener(this);
        crz.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                l cuE = MembersActivity.this.jaY.cuE();
                UserData userData = (UserData) cuE.getItem(i);
                if (userData != null) {
                    if (cuE.cri()) {
                        if (!userData.getPermission().isController()) {
                            cuE.f(Long.valueOf(userData.getUserIdLong()));
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(MembersActivity.this.getPageContext().getContext(), userData.getUserId() + "", userData.getUserName())));
                }
            }
        });
        crz.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.4
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!MembersActivity.this.jaY.cuE().cri() && MembersActivity.this.jaZ.isController()) {
                    UserData userData = (UserData) MembersActivity.this.jaY.cuE().getItem(i);
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
                                MembersActivity.this.b(MembersActivity.this.jaZ.getGroupId(), arrayList);
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
        this.jaY.cuA().setOnClickListener(this);
        this.jaY.cuB().setOnClickListener(this);
        this.jaY.cuC().setOnClickListener(this);
        this.jaY.setController(false);
        this.jaY.cuE().a(new l.a() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.5
            @Override // com.baidu.tieba.im.frsgroup.l.a
            public void yQ(int i) {
                MembersActivity.this.jaY.yR(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, List<Long> list) {
        if (list != null && list.size() != 0) {
            this.jaY.showProgressBar(true);
            this.jaZ.setUserIds(list);
            this.jaZ.sendRemoveMessage(j, dB(list));
        }
    }

    private String dB(List<Long> list) {
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
        this.jaZ.setUseCache(false);
        this.jaZ.setRequestM(null);
        this.jaY.cuE().reset(true);
        this.jaZ.setStart(0);
        this.jaZ.setLen(50);
        this.jaY.crz().startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.jaZ.setUseCache(true);
        this.jaZ.setRequestM(null);
        this.jaY.cuE().reset(false);
        this.jaZ.setStart(0);
        this.jaZ.setLen(50);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chU() {
        if (cnd()) {
            this.jaY.chU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cnd() {
        return 50 == this.jaZ.getLen();
    }

    public void initData(Bundle bundle) {
        this.jaZ = new MembersModel(this);
        this.jaZ.setUniqueId(getUniqueId());
        if (bundle == null) {
            this.jaZ.initWithIntent(getIntent());
        } else {
            this.jaZ.initWithBundle(bundle);
        }
        registerListener(this.iPM);
        registerListener(this.jba);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserData.Permission permission) {
        if (permission != null) {
            boolean isController = permission.isController();
            this.jaZ.setController(isController);
            this.jaY.setController(isController);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cus() {
        this.jaY.cuD().e(getPageContext());
        this.jaY.cuD().setTextOption(NoDataViewFactory.d.mF(R.string.members_no_person));
        this.jaY.cuD().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.jaY.onChangeSkinType(i);
        this.jaX.changeSkin(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jaY.cuG()) {
            cut();
        } else if (view == this.jaY.cuA()) {
            cuv();
            this.jaY.qa(false);
        } else if (view == this.jaY.cuB()) {
            cuu();
            this.jaY.qa(true);
        } else if (view == this.jaY.cuC()) {
            cuw();
        }
    }

    private void cut() {
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
                MembersActivity.this.jaZ.setOrderType(i2);
                MembersActivity.this.showToast(MembersActivity.this.getResources().getStringArray(R.array.members_order_by_short)[i]);
                MembersActivity.this.reset();
                MembersActivity.this.jaY.crz().startPullRefresh();
            }
        });
        iVar.showDialog();
    }

    private void cuu() {
        this.jaY.yR(0);
        this.jaY.pZ(false);
        this.jaY.cuE().pY(false);
        this.jaY.cuE().cux();
        this.jaY.cuF();
    }

    private void cuv() {
        this.jaY.yR(0);
        this.jaY.pZ(true);
        this.jaY.cuE().pY(true);
        this.jaY.cuF();
    }

    private void cuw() {
        Set<Long> cuy = this.jaY.cuE().cuy();
        if (cuy.size() > 0) {
            final ArrayList arrayList = new ArrayList();
            arrayList.addAll(cuy);
            DialogUtil.removeMembersDialog(getPageContext().getPageActivity(), new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    MembersActivity.this.jaY.pZ(false);
                    MembersActivity.this.jaY.cuE().pY(false);
                    MembersActivity.this.jaY.cuF();
                    MembersActivity.this.b(MembersActivity.this.jaZ.getGroupId(), arrayList);
                    MembersActivity.this.jaY.qa(true);
                }
            }, new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
        }
    }

    private void bwE() {
        if (this.jaY.cuE().cuz()) {
            this.jaZ.sendMessage(this.jaZ.getGroupId(), this.jaZ.getStart(), this.jaZ.getLen(), this.jaZ.getOrderType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        bwE();
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public t onGetPreLoadListView() {
        if (this.jaY == null || this.jaY.crz() == null) {
            return null;
        }
        return this.jaY.crz().getPreLoadHandle();
    }
}
