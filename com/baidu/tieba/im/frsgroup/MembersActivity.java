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
    private com.baidu.tbadk.core.view.g jpZ;
    private m jqa;
    private MembersModel jqb;
    private final com.baidu.adp.framework.listener.c jeL = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REQUEST_MEMBERS_BY_ID) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            RequestMembersMessage requestMembersMessage;
            l cFv = MembersActivity.this.jqa.cFv();
            MembersActivity.this.csy();
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
            MembersActivity.this.jqb.setRequestM(requestMembersMessage);
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
                if (MembersActivity.this.cxS()) {
                    MembersActivity.this.a(membersData.getPermission());
                }
                if (MembersActivity.this.cxS()) {
                    cFv.reset(true);
                }
                if (users.size() != MembersActivity.this.jqb.getLen()) {
                    cFv.qC(false);
                    cFv.qD(false);
                    if (MembersActivity.this.cxS() && users.size() == 0) {
                        MembersActivity.this.cFj();
                        return;
                    }
                } else {
                    cFv.qD(true);
                }
                MembersActivity.this.jqb.addStart(users.size());
                MembersActivity.this.jqb.setLen(20);
                cFv.dJ(users);
                cFv.notifyDataSetChanged();
            }
        }
    };
    private final com.baidu.adp.framework.listener.c jqc = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REMOVE_MEMBERS) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            MembersActivity.this.jqa.showProgressBar(false);
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
            MembersActivity.this.jqa.cFv().dK(MembersActivity.this.jqb.getUserIds());
            MembersActivity.this.jqa.cFw();
            MembersActivity.this.jqa.cFv().cFo();
        }
    };
    private final CustomMessageListener jqd = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.2
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
                        MembersActivity.this.jqa.cCr().startPullRefresh();
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
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_KICK_OUT, this.jqd);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_SUCCESS, this.jqd);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.jqb.saveInstance(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.jqa.cFu().bkq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public MembersModel cFi() {
        return this.jqb;
    }

    private void initUI() {
        this.jqa = new m(this);
        final BdListView cCr = this.jqa.cCr();
        this.jpZ = new com.baidu.tbadk.core.view.g(getPageContext());
        this.jpZ.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (!MembersActivity.this.jqa.cFv().cCa()) {
                    if (!MembersActivity.this.cxS()) {
                        MembersActivity.this.reset();
                    }
                    MembersActivity.this.jqb.sendMessage(MembersActivity.this.jqb.getGroupId(), MembersActivity.this.jqb.getStart(), MembersActivity.this.jqb.getLen(), MembersActivity.this.jqb.getOrderType());
                    return;
                }
                cCr.completePullRefreshPostDelayed(0L);
            }
        });
        cCr.setPullRefresh(this.jpZ);
        cCr.setOnSrollToBottomListener(this);
        cCr.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                l cFv = MembersActivity.this.jqa.cFv();
                UserData userData = (UserData) cFv.getItem(i);
                if (userData != null) {
                    if (cFv.cCa()) {
                        if (!userData.getPermission().isController()) {
                            cFv.f(Long.valueOf(userData.getUserIdLong()));
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(MembersActivity.this.getPageContext().getContext(), userData.getUserId() + "", userData.getUserName())));
                }
            }
        });
        cCr.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.4
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!MembersActivity.this.jqa.cFv().cCa() && MembersActivity.this.jqb.isController()) {
                    UserData userData = (UserData) MembersActivity.this.jqa.cFv().getItem(i);
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
                                MembersActivity.this.b(MembersActivity.this.jqb.getGroupId(), arrayList);
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
        this.jqa.cFr().setOnClickListener(this);
        this.jqa.cFs().setOnClickListener(this);
        this.jqa.cFt().setOnClickListener(this);
        this.jqa.setController(false);
        this.jqa.cFv().a(new l.a() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.5
            @Override // com.baidu.tieba.im.frsgroup.l.a
            public void Bj(int i) {
                MembersActivity.this.jqa.Bk(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, List<Long> list) {
        if (list != null && list.size() != 0) {
            this.jqa.showProgressBar(true);
            this.jqb.setUserIds(list);
            this.jqb.sendRemoveMessage(j, dI(list));
        }
    }

    private String dI(List<Long> list) {
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
        this.jqb.setUseCache(false);
        this.jqb.setRequestM(null);
        this.jqa.cFv().reset(true);
        this.jqb.setStart(0);
        this.jqb.setLen(50);
        this.jqa.cCr().startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.jqb.setUseCache(true);
        this.jqb.setRequestM(null);
        this.jqa.cFv().reset(false);
        this.jqb.setStart(0);
        this.jqb.setLen(50);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csy() {
        if (cxS()) {
            this.jqa.csy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cxS() {
        return 50 == this.jqb.getLen();
    }

    public void initData(Bundle bundle) {
        this.jqb = new MembersModel(this);
        this.jqb.setUniqueId(getUniqueId());
        if (bundle == null) {
            this.jqb.initWithIntent(getIntent());
        } else {
            this.jqb.initWithBundle(bundle);
        }
        registerListener(this.jeL);
        registerListener(this.jqc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserData.Permission permission) {
        if (permission != null) {
            boolean isController = permission.isController();
            this.jqb.setController(isController);
            this.jqa.setController(isController);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFj() {
        this.jqa.cFu().e(getPageContext());
        this.jqa.cFu().setTextOption(NoDataViewFactory.d.oK(R.string.members_no_person));
        this.jqa.cFu().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.jqa.onChangeSkinType(i);
        this.jpZ.changeSkin(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jqa.cFx()) {
            cFk();
        } else if (view == this.jqa.cFr()) {
            cFm();
            this.jqa.qG(false);
        } else if (view == this.jqa.cFs()) {
            cFl();
            this.jqa.qG(true);
        } else if (view == this.jqa.cFt()) {
            cFn();
        }
    }

    private void cFk() {
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
                MembersActivity.this.jqb.setOrderType(i2);
                MembersActivity.this.showToast(MembersActivity.this.getResources().getStringArray(R.array.members_order_by_short)[i]);
                MembersActivity.this.reset();
                MembersActivity.this.jqa.cCr().startPullRefresh();
            }
        });
        iVar.Nv();
    }

    private void cFl() {
        this.jqa.Bk(0);
        this.jqa.qF(false);
        this.jqa.cFv().qE(false);
        this.jqa.cFv().cFo();
        this.jqa.cFw();
    }

    private void cFm() {
        this.jqa.Bk(0);
        this.jqa.qF(true);
        this.jqa.cFv().qE(true);
        this.jqa.cFw();
    }

    private void cFn() {
        Set<Long> cFp = this.jqa.cFv().cFp();
        if (cFp.size() > 0) {
            final ArrayList arrayList = new ArrayList();
            arrayList.addAll(cFp);
            DialogUtil.removeMembersDialog(getPageContext().getPageActivity(), new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    MembersActivity.this.jqa.qF(false);
                    MembersActivity.this.jqa.cFv().qE(false);
                    MembersActivity.this.jqa.cFw();
                    MembersActivity.this.b(MembersActivity.this.jqb.getGroupId(), arrayList);
                    MembersActivity.this.jqa.qG(true);
                }
            }, new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
        }
    }

    private void bFD() {
        if (this.jqa.cFv().cFq()) {
            this.jqb.sendMessage(this.jqb.getGroupId(), this.jqb.getStart(), this.jqb.getLen(), this.jqb.getOrderType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        bFD();
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public t onGetPreLoadListView() {
        if (this.jqa == null || this.jqa.cCr() == null) {
            return null;
        }
        return this.jqa.cCr().getPreLoadHandle();
    }
}
