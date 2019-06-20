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
    private com.baidu.tbadk.core.view.i gAY;
    private m gAZ;
    private MembersModel gBa;
    private final com.baidu.adp.framework.listener.c grM = new com.baidu.adp.framework.listener.c(103005) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            RequestMembersMessage requestMembersMessage;
            l bBa = MembersActivity.this.gAZ.bBa();
            MembersActivity.this.bpI();
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
            MembersActivity.this.gBa.setRequestM(requestMembersMessage);
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
                if (MembersActivity.this.btZ()) {
                    MembersActivity.this.a(membersData.getPermission());
                }
                if (MembersActivity.this.btZ()) {
                    bBa.reset(true);
                }
                if (users.size() != MembersActivity.this.gBa.getLen()) {
                    bBa.lS(false);
                    bBa.lT(false);
                    if (MembersActivity.this.btZ() && users.size() == 0) {
                        MembersActivity.this.bAP();
                        return;
                    }
                } else {
                    bBa.lT(true);
                }
                MembersActivity.this.gBa.addStart(users.size());
                MembersActivity.this.gBa.setLen(20);
                bBa.cY(users);
                bBa.notifyDataSetChanged();
            }
        }
    };
    private final com.baidu.adp.framework.listener.c gBb = new com.baidu.adp.framework.listener.c(103112) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            MembersActivity.this.gAZ.lV(false);
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
            MembersActivity.this.gAZ.bBa().cZ(MembersActivity.this.gBa.getUserIds());
            MembersActivity.this.gAZ.bBb();
            MembersActivity.this.gAZ.bBa().bAU();
        }
    };
    private final CustomMessageListener gBc = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.2
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
                        MembersActivity.this.gAZ.byp().startPullRefresh();
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
        registerListener(2001128, this.gBc);
        registerListener(2001126, this.gBc);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.gBa.saveInstance(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.gAZ.bAZ().onActivityStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public MembersModel bAO() {
        return this.gBa;
    }

    private void initUI() {
        this.gAZ = new m(this);
        final BdListView byp = this.gAZ.byp();
        this.gAY = new com.baidu.tbadk.core.view.i(getPageContext());
        this.gAY.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.1
            @Override // com.baidu.tbadk.core.view.h.c
            public void en(boolean z) {
                if (!MembersActivity.this.gAZ.bBa().byc()) {
                    if (!MembersActivity.this.btZ()) {
                        MembersActivity.this.reset();
                    }
                    MembersActivity.this.gBa.sendMessage(MembersActivity.this.gBa.getGroupId(), MembersActivity.this.gBa.getStart(), MembersActivity.this.gBa.getLen(), MembersActivity.this.gBa.getOrderType());
                    return;
                }
                byp.completePullRefreshPostDelayed(0L);
            }
        });
        byp.setPullRefresh(this.gAY);
        byp.setOnSrollToBottomListener(this);
        byp.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                l bBa = MembersActivity.this.gAZ.bBa();
                UserData userData = (UserData) bBa.getItem(i);
                if (userData != null) {
                    if (bBa.byc()) {
                        if (!userData.getPermission().isController()) {
                            bBa.e(Long.valueOf(userData.getUserIdLong()));
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(MembersActivity.this.getPageContext().getContext(), userData.getUserId() + "", userData.getUserName())));
                }
            }
        });
        byp.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.4
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!MembersActivity.this.gAZ.bBa().byc() && MembersActivity.this.gBa.isController()) {
                    UserData userData = (UserData) MembersActivity.this.gAZ.bBa().getItem(i);
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
                                MembersActivity.this.b(MembersActivity.this.gBa.getGroupId(), arrayList);
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
        this.gAZ.bAW().setOnClickListener(this);
        this.gAZ.bAX().setOnClickListener(this);
        this.gAZ.bAY().setOnClickListener(this);
        this.gAZ.setController(false);
        this.gAZ.bBa().a(new l.a() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.5
            @Override // com.baidu.tieba.im.frsgroup.l.a
            public void uV(int i) {
                MembersActivity.this.gAZ.uW(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, List<Long> list) {
        if (list != null && list.size() != 0) {
            this.gAZ.lV(true);
            this.gBa.setUserIds(list);
            this.gBa.sendRemoveMessage(j, cX(list));
        }
    }

    private String cX(List<Long> list) {
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
        this.gBa.setUseCache(false);
        this.gBa.setRequestM(null);
        this.gAZ.bBa().reset(true);
        this.gBa.setStart(0);
        this.gBa.setLen(50);
        this.gAZ.byp().startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.gBa.setUseCache(true);
        this.gBa.setRequestM(null);
        this.gAZ.bBa().reset(false);
        this.gBa.setStart(0);
        this.gBa.setLen(50);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpI() {
        if (btZ()) {
            this.gAZ.bpI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean btZ() {
        return 50 == this.gBa.getLen();
    }

    public void initData(Bundle bundle) {
        this.gBa = new MembersModel(this);
        this.gBa.setUniqueId(getUniqueId());
        if (bundle == null) {
            this.gBa.initWithIntent(getIntent());
        } else {
            this.gBa.initWithBundle(bundle);
        }
        registerListener(this.grM);
        registerListener(this.gBb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserData.Permission permission) {
        if (permission != null) {
            boolean isController = permission.isController();
            this.gBa.setController(isController);
            this.gAZ.setController(isController);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAP() {
        this.gAZ.bAZ().e(getPageContext());
        this.gAZ.bAZ().setTextOption(NoDataViewFactory.d.iH(R.string.members_no_person));
        this.gAZ.bAZ().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.gAZ.onChangeSkinType(i);
        this.gAY.iP(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gAZ.bBc()) {
            bAQ();
        } else if (view == this.gAZ.bAW()) {
            bAS();
            this.gAZ.lX(false);
        } else if (view == this.gAZ.bAX()) {
            bAR();
            this.gAZ.lX(true);
        } else if (view == this.gAZ.bAY()) {
            bAT();
        }
    }

    private void bAQ() {
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
                MembersActivity.this.gBa.setOrderType(i2);
                MembersActivity.this.showToast(MembersActivity.this.getResources().getStringArray(R.array.members_order_by_short)[i]);
                MembersActivity.this.reset();
                MembersActivity.this.gAZ.byp().startPullRefresh();
            }
        });
        iVar.showDialog();
    }

    private void bAR() {
        this.gAZ.uW(0);
        this.gAZ.lW(false);
        this.gAZ.bBa().lU(false);
        this.gAZ.bBa().bAU();
        this.gAZ.bBb();
    }

    private void bAS() {
        this.gAZ.uW(0);
        this.gAZ.lW(true);
        this.gAZ.bBa().lU(true);
        this.gAZ.bBb();
    }

    private void bAT() {
        Set<Long> bAV = this.gAZ.bBa().bAV();
        if (bAV.size() > 0) {
            final ArrayList arrayList = new ArrayList();
            arrayList.addAll(bAV);
            DialogUtil.removeMembersDialog(getPageContext().getPageActivity(), new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    MembersActivity.this.gAZ.lW(false);
                    MembersActivity.this.gAZ.bBa().lU(false);
                    MembersActivity.this.gAZ.bBb();
                    MembersActivity.this.b(MembersActivity.this.gBa.getGroupId(), arrayList);
                    MembersActivity.this.gAZ.lX(true);
                }
            }, new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
        }
    }

    private void aHt() {
        if (this.gAZ.bBa().aYE()) {
            this.gBa.sendMessage(this.gBa.getGroupId(), this.gBa.getStart(), this.gBa.getLen(), this.gBa.getOrderType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        aHt();
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public p onGetPreLoadListView() {
        if (this.gAZ == null || this.gAZ.byp() == null) {
            return null;
        }
        return this.gAZ.byp().getPreLoadHandle();
    }
}
