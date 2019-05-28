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
    private com.baidu.tbadk.core.view.i gAW;
    private m gAX;
    private MembersModel gAY;
    private final com.baidu.adp.framework.listener.c grK = new com.baidu.adp.framework.listener.c(103005) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            RequestMembersMessage requestMembersMessage;
            l bAZ = MembersActivity.this.gAX.bAZ();
            MembersActivity.this.bpG();
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
            MembersActivity.this.gAY.setRequestM(requestMembersMessage);
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
                if (MembersActivity.this.btY()) {
                    MembersActivity.this.a(membersData.getPermission());
                }
                if (MembersActivity.this.btY()) {
                    bAZ.reset(true);
                }
                if (users.size() != MembersActivity.this.gAY.getLen()) {
                    bAZ.lR(false);
                    bAZ.lS(false);
                    if (MembersActivity.this.btY() && users.size() == 0) {
                        MembersActivity.this.bAO();
                        return;
                    }
                } else {
                    bAZ.lS(true);
                }
                MembersActivity.this.gAY.addStart(users.size());
                MembersActivity.this.gAY.setLen(20);
                bAZ.cY(users);
                bAZ.notifyDataSetChanged();
            }
        }
    };
    private final com.baidu.adp.framework.listener.c gAZ = new com.baidu.adp.framework.listener.c(103112) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            MembersActivity.this.gAX.lU(false);
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
            MembersActivity.this.gAX.bAZ().cZ(MembersActivity.this.gAY.getUserIds());
            MembersActivity.this.gAX.bBa();
            MembersActivity.this.gAX.bAZ().bAT();
        }
    };
    private final CustomMessageListener gBa = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.2
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
                        MembersActivity.this.gAX.byo().startPullRefresh();
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
        registerListener(2001128, this.gBa);
        registerListener(2001126, this.gBa);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.gAY.saveInstance(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.gAX.bAY().onActivityStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public MembersModel bAN() {
        return this.gAY;
    }

    private void initUI() {
        this.gAX = new m(this);
        final BdListView byo = this.gAX.byo();
        this.gAW = new com.baidu.tbadk.core.view.i(getPageContext());
        this.gAW.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.1
            @Override // com.baidu.tbadk.core.view.h.c
            public void en(boolean z) {
                if (!MembersActivity.this.gAX.bAZ().byb()) {
                    if (!MembersActivity.this.btY()) {
                        MembersActivity.this.reset();
                    }
                    MembersActivity.this.gAY.sendMessage(MembersActivity.this.gAY.getGroupId(), MembersActivity.this.gAY.getStart(), MembersActivity.this.gAY.getLen(), MembersActivity.this.gAY.getOrderType());
                    return;
                }
                byo.completePullRefreshPostDelayed(0L);
            }
        });
        byo.setPullRefresh(this.gAW);
        byo.setOnSrollToBottomListener(this);
        byo.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                l bAZ = MembersActivity.this.gAX.bAZ();
                UserData userData = (UserData) bAZ.getItem(i);
                if (userData != null) {
                    if (bAZ.byb()) {
                        if (!userData.getPermission().isController()) {
                            bAZ.e(Long.valueOf(userData.getUserIdLong()));
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(MembersActivity.this.getPageContext().getContext(), userData.getUserId() + "", userData.getUserName())));
                }
            }
        });
        byo.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.4
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!MembersActivity.this.gAX.bAZ().byb() && MembersActivity.this.gAY.isController()) {
                    UserData userData = (UserData) MembersActivity.this.gAX.bAZ().getItem(i);
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
                                MembersActivity.this.b(MembersActivity.this.gAY.getGroupId(), arrayList);
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
        this.gAX.bAV().setOnClickListener(this);
        this.gAX.bAW().setOnClickListener(this);
        this.gAX.bAX().setOnClickListener(this);
        this.gAX.setController(false);
        this.gAX.bAZ().a(new l.a() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.5
            @Override // com.baidu.tieba.im.frsgroup.l.a
            public void uV(int i) {
                MembersActivity.this.gAX.uW(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, List<Long> list) {
        if (list != null && list.size() != 0) {
            this.gAX.lU(true);
            this.gAY.setUserIds(list);
            this.gAY.sendRemoveMessage(j, cX(list));
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
        this.gAY.setUseCache(false);
        this.gAY.setRequestM(null);
        this.gAX.bAZ().reset(true);
        this.gAY.setStart(0);
        this.gAY.setLen(50);
        this.gAX.byo().startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.gAY.setUseCache(true);
        this.gAY.setRequestM(null);
        this.gAX.bAZ().reset(false);
        this.gAY.setStart(0);
        this.gAY.setLen(50);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpG() {
        if (btY()) {
            this.gAX.bpG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean btY() {
        return 50 == this.gAY.getLen();
    }

    public void initData(Bundle bundle) {
        this.gAY = new MembersModel(this);
        this.gAY.setUniqueId(getUniqueId());
        if (bundle == null) {
            this.gAY.initWithIntent(getIntent());
        } else {
            this.gAY.initWithBundle(bundle);
        }
        registerListener(this.grK);
        registerListener(this.gAZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserData.Permission permission) {
        if (permission != null) {
            boolean isController = permission.isController();
            this.gAY.setController(isController);
            this.gAX.setController(isController);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAO() {
        this.gAX.bAY().e(getPageContext());
        this.gAX.bAY().setTextOption(NoDataViewFactory.d.iH(R.string.members_no_person));
        this.gAX.bAY().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.gAX.onChangeSkinType(i);
        this.gAW.iP(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gAX.bBb()) {
            bAP();
        } else if (view == this.gAX.bAV()) {
            bAR();
            this.gAX.lW(false);
        } else if (view == this.gAX.bAW()) {
            bAQ();
            this.gAX.lW(true);
        } else if (view == this.gAX.bAX()) {
            bAS();
        }
    }

    private void bAP() {
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
                MembersActivity.this.gAY.setOrderType(i2);
                MembersActivity.this.showToast(MembersActivity.this.getResources().getStringArray(R.array.members_order_by_short)[i]);
                MembersActivity.this.reset();
                MembersActivity.this.gAX.byo().startPullRefresh();
            }
        });
        iVar.showDialog();
    }

    private void bAQ() {
        this.gAX.uW(0);
        this.gAX.lV(false);
        this.gAX.bAZ().lT(false);
        this.gAX.bAZ().bAT();
        this.gAX.bBa();
    }

    private void bAR() {
        this.gAX.uW(0);
        this.gAX.lV(true);
        this.gAX.bAZ().lT(true);
        this.gAX.bBa();
    }

    private void bAS() {
        Set<Long> bAU = this.gAX.bAZ().bAU();
        if (bAU.size() > 0) {
            final ArrayList arrayList = new ArrayList();
            arrayList.addAll(bAU);
            DialogUtil.removeMembersDialog(getPageContext().getPageActivity(), new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    MembersActivity.this.gAX.lV(false);
                    MembersActivity.this.gAX.bAZ().lT(false);
                    MembersActivity.this.gAX.bBa();
                    MembersActivity.this.b(MembersActivity.this.gAY.getGroupId(), arrayList);
                    MembersActivity.this.gAX.lW(true);
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
        if (this.gAX.bAZ().aYE()) {
            this.gAY.sendMessage(this.gAY.getGroupId(), this.gAY.getStart(), this.gAY.getLen(), this.gAY.getOrderType());
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
        if (this.gAX == null || this.gAX.byo() == null) {
            return null;
        }
        return this.gAX.byo().getPreLoadHandle();
    }
}
