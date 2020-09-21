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
    private com.baidu.tbadk.core.view.g jyH;
    private m jyI;
    private MembersModel jyJ;
    private final com.baidu.adp.framework.listener.c jnx = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REQUEST_MEMBERS_BY_ID) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            RequestMembersMessage requestMembersMessage;
            l cJc = MembersActivity.this.jyI.cJc();
            MembersActivity.this.cvO();
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
            MembersActivity.this.jyJ.setRequestM(requestMembersMessage);
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
                if (MembersActivity.this.cBB()) {
                    MembersActivity.this.a(membersData.getPermission());
                }
                if (MembersActivity.this.cBB()) {
                    cJc.reset(true);
                }
                if (users.size() != MembersActivity.this.jyJ.getLen()) {
                    cJc.qM(false);
                    cJc.qN(false);
                    if (MembersActivity.this.cBB() && users.size() == 0) {
                        MembersActivity.this.cIQ();
                        return;
                    }
                } else {
                    cJc.qN(true);
                }
                MembersActivity.this.jyJ.addStart(users.size());
                MembersActivity.this.jyJ.setLen(20);
                cJc.dR(users);
                cJc.notifyDataSetChanged();
            }
        }
    };
    private final com.baidu.adp.framework.listener.c jyK = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REMOVE_MEMBERS) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            MembersActivity.this.jyI.showProgressBar(false);
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
            MembersActivity.this.jyI.cJc().dS(MembersActivity.this.jyJ.getUserIds());
            MembersActivity.this.jyI.cJd();
            MembersActivity.this.jyI.cJc().cIV();
        }
    };
    private final CustomMessageListener jyL = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.2
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
                        MembersActivity.this.jyI.cFY().startPullRefresh();
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
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_KICK_OUT, this.jyL);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_SUCCESS, this.jyL);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.jyJ.saveInstance(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.jyI.cJb().bll();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public MembersModel cIP() {
        return this.jyJ;
    }

    private void initUI() {
        this.jyI = new m(this);
        final BdListView cFY = this.jyI.cFY();
        this.jyH = new com.baidu.tbadk.core.view.g(getPageContext());
        this.jyH.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (!MembersActivity.this.jyI.cJc().cFI()) {
                    if (!MembersActivity.this.cBB()) {
                        MembersActivity.this.reset();
                    }
                    MembersActivity.this.jyJ.sendMessage(MembersActivity.this.jyJ.getGroupId(), MembersActivity.this.jyJ.getStart(), MembersActivity.this.jyJ.getLen(), MembersActivity.this.jyJ.getOrderType());
                    return;
                }
                cFY.completePullRefreshPostDelayed(0L);
            }
        });
        cFY.setPullRefresh(this.jyH);
        cFY.setOnSrollToBottomListener(this);
        cFY.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                l cJc = MembersActivity.this.jyI.cJc();
                UserData userData = (UserData) cJc.getItem(i);
                if (userData != null) {
                    if (cJc.cFI()) {
                        if (!userData.getPermission().isController()) {
                            cJc.g(Long.valueOf(userData.getUserIdLong()));
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(MembersActivity.this.getPageContext().getContext(), userData.getUserId() + "", userData.getUserName())));
                }
            }
        });
        cFY.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.4
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!MembersActivity.this.jyI.cJc().cFI() && MembersActivity.this.jyJ.isController()) {
                    UserData userData = (UserData) MembersActivity.this.jyI.cJc().getItem(i);
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
                                MembersActivity.this.b(MembersActivity.this.jyJ.getGroupId(), arrayList);
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
        this.jyI.cIY().setOnClickListener(this);
        this.jyI.cIZ().setOnClickListener(this);
        this.jyI.cJa().setOnClickListener(this);
        this.jyI.setController(false);
        this.jyI.cJc().a(new l.a() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.5
            @Override // com.baidu.tieba.im.frsgroup.l.a
            public void BK(int i) {
                MembersActivity.this.jyI.BL(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, List<Long> list) {
        if (list != null && list.size() != 0) {
            this.jyI.showProgressBar(true);
            this.jyJ.setUserIds(list);
            this.jyJ.sendRemoveMessage(j, dQ(list));
        }
    }

    private String dQ(List<Long> list) {
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
        this.jyJ.setUseCache(false);
        this.jyJ.setRequestM(null);
        this.jyI.cJc().reset(true);
        this.jyJ.setStart(0);
        this.jyJ.setLen(50);
        this.jyI.cFY().startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.jyJ.setUseCache(true);
        this.jyJ.setRequestM(null);
        this.jyI.cJc().reset(false);
        this.jyJ.setStart(0);
        this.jyJ.setLen(50);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvO() {
        if (cBB()) {
            this.jyI.cvO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cBB() {
        return 50 == this.jyJ.getLen();
    }

    public void initData(Bundle bundle) {
        this.jyJ = new MembersModel(this);
        this.jyJ.setUniqueId(getUniqueId());
        if (bundle == null) {
            this.jyJ.initWithIntent(getIntent());
        } else {
            this.jyJ.initWithBundle(bundle);
        }
        registerListener(this.jnx);
        registerListener(this.jyK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserData.Permission permission) {
        if (permission != null) {
            boolean isController = permission.isController();
            this.jyJ.setController(isController);
            this.jyI.setController(isController);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIQ() {
        this.jyI.cJb().e(getPageContext());
        this.jyI.cJb().setTextOption(NoDataViewFactory.d.oW(R.string.members_no_person));
        this.jyI.cJb().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.jyI.onChangeSkinType(i);
        this.jyH.changeSkin(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jyI.cJe()) {
            cIR();
        } else if (view == this.jyI.cIY()) {
            cIT();
            this.jyI.qQ(false);
        } else if (view == this.jyI.cIZ()) {
            cIS();
            this.jyI.qQ(true);
        } else if (view == this.jyI.cJa()) {
            cIU();
        }
    }

    private void cIR() {
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
                MembersActivity.this.jyJ.setOrderType(i2);
                MembersActivity.this.showToast(MembersActivity.this.getResources().getStringArray(R.array.members_order_by_short)[i]);
                MembersActivity.this.reset();
                MembersActivity.this.jyI.cFY().startPullRefresh();
            }
        });
        iVar.NY();
    }

    private void cIS() {
        this.jyI.BL(0);
        this.jyI.qP(false);
        this.jyI.cJc().qO(false);
        this.jyI.cJc().cIV();
        this.jyI.cJd();
    }

    private void cIT() {
        this.jyI.BL(0);
        this.jyI.qP(true);
        this.jyI.cJc().qO(true);
        this.jyI.cJd();
    }

    private void cIU() {
        Set<Long> cIW = this.jyI.cJc().cIW();
        if (cIW.size() > 0) {
            final ArrayList arrayList = new ArrayList();
            arrayList.addAll(cIW);
            DialogUtil.removeMembersDialog(getPageContext().getPageActivity(), new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    MembersActivity.this.jyI.qP(false);
                    MembersActivity.this.jyI.cJc().qO(false);
                    MembersActivity.this.jyI.cJd();
                    MembersActivity.this.b(MembersActivity.this.jyJ.getGroupId(), arrayList);
                    MembersActivity.this.jyI.qQ(true);
                }
            }, new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
        }
    }

    private void bGU() {
        if (this.jyI.cJc().cIX()) {
            this.jyJ.sendMessage(this.jyJ.getGroupId(), this.jyJ.getStart(), this.jyJ.getLen(), this.jyJ.getOrderType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        bGU();
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public t onGetPreLoadListView() {
        if (this.jyI == null || this.jyI.cFY() == null) {
            return null;
        }
        return this.jyI.cFY().getPreLoadHandle();
    }
}
