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
    private com.baidu.tbadk.core.view.i gGZ;
    private m gHa;
    private MembersModel gHb;
    private final com.baidu.adp.framework.listener.c gxN = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REQUEST_MEMBERS_BY_ID) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            RequestMembersMessage requestMembersMessage;
            l bBs = MembersActivity.this.gHa.bBs();
            MembersActivity.this.bpL();
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
            MembersActivity.this.gHb.setRequestM(requestMembersMessage);
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
                if (MembersActivity.this.buI()) {
                    MembersActivity.this.a(membersData.getPermission());
                }
                if (MembersActivity.this.buI()) {
                    bBs.reset(true);
                }
                if (users.size() != MembersActivity.this.gHb.getLen()) {
                    bBs.lX(false);
                    bBs.lY(false);
                    if (MembersActivity.this.buI() && users.size() == 0) {
                        MembersActivity.this.bBh();
                        return;
                    }
                } else {
                    bBs.lY(true);
                }
                MembersActivity.this.gHb.addStart(users.size());
                MembersActivity.this.gHb.setLen(20);
                bBs.dm(users);
                bBs.notifyDataSetChanged();
            }
        }
    };
    private final com.baidu.adp.framework.listener.c gHc = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REMOVE_MEMBERS) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            MembersActivity.this.gHa.ma(false);
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
            MembersActivity.this.gHa.bBs().dn(MembersActivity.this.gHb.getUserIds());
            MembersActivity.this.gHa.bBt();
            MembersActivity.this.gHa.bBs().bBm();
        }
    };
    private final CustomMessageListener gHd = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.2
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
                        MembersActivity.this.gHa.byE().startPullRefresh();
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
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_KICK_OUT, this.gHd);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_SUCCESS, this.gHd);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.gHb.saveInstance(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.gHa.bBr().anE();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public MembersModel bBg() {
        return this.gHb;
    }

    private void initUI() {
        this.gHa = new m(this);
        final BdListView byE = this.gHa.byE();
        this.gGZ = new com.baidu.tbadk.core.view.i(getPageContext());
        this.gGZ.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.1
            @Override // com.baidu.tbadk.core.view.h.c
            public void onListPullRefresh(boolean z) {
                if (!MembersActivity.this.gHa.bBs().byq()) {
                    if (!MembersActivity.this.buI()) {
                        MembersActivity.this.reset();
                    }
                    MembersActivity.this.gHb.sendMessage(MembersActivity.this.gHb.getGroupId(), MembersActivity.this.gHb.getStart(), MembersActivity.this.gHb.getLen(), MembersActivity.this.gHb.getOrderType());
                    return;
                }
                byE.completePullRefreshPostDelayed(0L);
            }
        });
        byE.setPullRefresh(this.gGZ);
        byE.setOnSrollToBottomListener(this);
        byE.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                l bBs = MembersActivity.this.gHa.bBs();
                UserData userData = (UserData) bBs.getItem(i);
                if (userData != null) {
                    if (bBs.byq()) {
                        if (!userData.getPermission().isController()) {
                            bBs.d(Long.valueOf(userData.getUserIdLong()));
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(MembersActivity.this.getPageContext().getContext(), userData.getUserId() + "", userData.getUserName())));
                }
            }
        });
        byE.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.4
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!MembersActivity.this.gHa.bBs().byq() && MembersActivity.this.gHb.isController()) {
                    UserData userData = (UserData) MembersActivity.this.gHa.bBs().getItem(i);
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
                                MembersActivity.this.b(MembersActivity.this.gHb.getGroupId(), arrayList);
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
        this.gHa.bBo().setOnClickListener(this);
        this.gHa.bBp().setOnClickListener(this);
        this.gHa.bBq().setOnClickListener(this);
        this.gHa.setController(false);
        this.gHa.bBs().a(new l.a() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.5
            @Override // com.baidu.tieba.im.frsgroup.l.a
            public void uh(int i) {
                MembersActivity.this.gHa.ui(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, List<Long> list) {
        if (list != null && list.size() != 0) {
            this.gHa.ma(true);
            this.gHb.setUserIds(list);
            this.gHb.sendRemoveMessage(j, dl(list));
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
        this.gHb.setUseCache(false);
        this.gHb.setRequestM(null);
        this.gHa.bBs().reset(true);
        this.gHb.setStart(0);
        this.gHb.setLen(50);
        this.gHa.byE().startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.gHb.setUseCache(true);
        this.gHb.setRequestM(null);
        this.gHa.bBs().reset(false);
        this.gHb.setStart(0);
        this.gHb.setLen(50);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpL() {
        if (buI()) {
            this.gHa.bpL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean buI() {
        return 50 == this.gHb.getLen();
    }

    public void initData(Bundle bundle) {
        this.gHb = new MembersModel(this);
        this.gHb.setUniqueId(getUniqueId());
        if (bundle == null) {
            this.gHb.initWithIntent(getIntent());
        } else {
            this.gHb.initWithBundle(bundle);
        }
        registerListener(this.gxN);
        registerListener(this.gHc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserData.Permission permission) {
        if (permission != null) {
            boolean isController = permission.isController();
            this.gHb.setController(isController);
            this.gHa.setController(isController);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBh() {
        this.gHa.bBr().e(getPageContext());
        this.gHa.bBr().setTextOption(NoDataViewFactory.d.iK(R.string.members_no_person));
        this.gHa.bBr().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.gHa.onChangeSkinType(i);
        this.gGZ.changeSkin(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gHa.bBu()) {
            bBi();
        } else if (view == this.gHa.bBo()) {
            bBk();
            this.gHa.mc(false);
        } else if (view == this.gHa.bBp()) {
            bBj();
            this.gHa.mc(true);
        } else if (view == this.gHa.bBq()) {
            bBl();
        }
    }

    private void bBi() {
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
                MembersActivity.this.gHb.setOrderType(i2);
                MembersActivity.this.showToast(MembersActivity.this.getResources().getStringArray(R.array.members_order_by_short)[i]);
                MembersActivity.this.reset();
                MembersActivity.this.gHa.byE().startPullRefresh();
            }
        });
        iVar.showDialog();
    }

    private void bBj() {
        this.gHa.ui(0);
        this.gHa.mb(false);
        this.gHa.bBs().lZ(false);
        this.gHa.bBs().bBm();
        this.gHa.bBt();
    }

    private void bBk() {
        this.gHa.ui(0);
        this.gHa.mb(true);
        this.gHa.bBs().lZ(true);
        this.gHa.bBt();
    }

    private void bBl() {
        Set<Long> bBn = this.gHa.bBs().bBn();
        if (bBn.size() > 0) {
            final ArrayList arrayList = new ArrayList();
            arrayList.addAll(bBn);
            DialogUtil.removeMembersDialog(getPageContext().getPageActivity(), new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    MembersActivity.this.gHa.mb(false);
                    MembersActivity.this.gHa.bBs().lZ(false);
                    MembersActivity.this.gHa.bBt();
                    MembersActivity.this.b(MembersActivity.this.gHb.getGroupId(), arrayList);
                    MembersActivity.this.gHa.mc(true);
                }
            }, new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
        }
    }

    private void aIU() {
        if (this.gHa.bBs().bbl()) {
            this.gHb.sendMessage(this.gHb.getGroupId(), this.gHb.getStart(), this.gHb.getLen(), this.gHb.getOrderType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        aIU();
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public p onGetPreLoadListView() {
        if (this.gHa == null || this.gHa.byE() == null) {
            return null;
        }
        return this.gHa.byE().getPreLoadHandle();
    }
}
