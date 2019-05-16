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
    private com.baidu.tbadk.core.view.i gAV;
    private m gAW;
    private MembersModel gAX;
    private final com.baidu.adp.framework.listener.c grJ = new com.baidu.adp.framework.listener.c(103005) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            RequestMembersMessage requestMembersMessage;
            l bAW = MembersActivity.this.gAW.bAW();
            MembersActivity.this.bpD();
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
            MembersActivity.this.gAX.setRequestM(requestMembersMessage);
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
                if (MembersActivity.this.btV()) {
                    MembersActivity.this.a(membersData.getPermission());
                }
                if (MembersActivity.this.btV()) {
                    bAW.reset(true);
                }
                if (users.size() != MembersActivity.this.gAX.getLen()) {
                    bAW.lR(false);
                    bAW.lS(false);
                    if (MembersActivity.this.btV() && users.size() == 0) {
                        MembersActivity.this.bAL();
                        return;
                    }
                } else {
                    bAW.lS(true);
                }
                MembersActivity.this.gAX.addStart(users.size());
                MembersActivity.this.gAX.setLen(20);
                bAW.cY(users);
                bAW.notifyDataSetChanged();
            }
        }
    };
    private final com.baidu.adp.framework.listener.c gAY = new com.baidu.adp.framework.listener.c(103112) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            MembersActivity.this.gAW.lU(false);
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
            MembersActivity.this.gAW.bAW().cZ(MembersActivity.this.gAX.getUserIds());
            MembersActivity.this.gAW.bAX();
            MembersActivity.this.gAW.bAW().bAQ();
        }
    };
    private final CustomMessageListener gAZ = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.2
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
                        MembersActivity.this.gAW.byl().startPullRefresh();
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
        registerListener(2001128, this.gAZ);
        registerListener(2001126, this.gAZ);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.gAX.saveInstance(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.gAW.bAV().onActivityStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public MembersModel bAK() {
        return this.gAX;
    }

    private void initUI() {
        this.gAW = new m(this);
        final BdListView byl = this.gAW.byl();
        this.gAV = new com.baidu.tbadk.core.view.i(getPageContext());
        this.gAV.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.1
            @Override // com.baidu.tbadk.core.view.h.c
            public void en(boolean z) {
                if (!MembersActivity.this.gAW.bAW().bxY()) {
                    if (!MembersActivity.this.btV()) {
                        MembersActivity.this.reset();
                    }
                    MembersActivity.this.gAX.sendMessage(MembersActivity.this.gAX.getGroupId(), MembersActivity.this.gAX.getStart(), MembersActivity.this.gAX.getLen(), MembersActivity.this.gAX.getOrderType());
                    return;
                }
                byl.completePullRefreshPostDelayed(0L);
            }
        });
        byl.setPullRefresh(this.gAV);
        byl.setOnSrollToBottomListener(this);
        byl.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                l bAW = MembersActivity.this.gAW.bAW();
                UserData userData = (UserData) bAW.getItem(i);
                if (userData != null) {
                    if (bAW.bxY()) {
                        if (!userData.getPermission().isController()) {
                            bAW.e(Long.valueOf(userData.getUserIdLong()));
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(MembersActivity.this.getPageContext().getContext(), userData.getUserId() + "", userData.getUserName())));
                }
            }
        });
        byl.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.4
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!MembersActivity.this.gAW.bAW().bxY() && MembersActivity.this.gAX.isController()) {
                    UserData userData = (UserData) MembersActivity.this.gAW.bAW().getItem(i);
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
                                MembersActivity.this.b(MembersActivity.this.gAX.getGroupId(), arrayList);
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
        this.gAW.bAS().setOnClickListener(this);
        this.gAW.bAT().setOnClickListener(this);
        this.gAW.bAU().setOnClickListener(this);
        this.gAW.setController(false);
        this.gAW.bAW().a(new l.a() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.5
            @Override // com.baidu.tieba.im.frsgroup.l.a
            public void uV(int i) {
                MembersActivity.this.gAW.uW(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, List<Long> list) {
        if (list != null && list.size() != 0) {
            this.gAW.lU(true);
            this.gAX.setUserIds(list);
            this.gAX.sendRemoveMessage(j, cX(list));
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
        this.gAX.setUseCache(false);
        this.gAX.setRequestM(null);
        this.gAW.bAW().reset(true);
        this.gAX.setStart(0);
        this.gAX.setLen(50);
        this.gAW.byl().startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.gAX.setUseCache(true);
        this.gAX.setRequestM(null);
        this.gAW.bAW().reset(false);
        this.gAX.setStart(0);
        this.gAX.setLen(50);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpD() {
        if (btV()) {
            this.gAW.bpD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean btV() {
        return 50 == this.gAX.getLen();
    }

    public void initData(Bundle bundle) {
        this.gAX = new MembersModel(this);
        this.gAX.setUniqueId(getUniqueId());
        if (bundle == null) {
            this.gAX.initWithIntent(getIntent());
        } else {
            this.gAX.initWithBundle(bundle);
        }
        registerListener(this.grJ);
        registerListener(this.gAY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserData.Permission permission) {
        if (permission != null) {
            boolean isController = permission.isController();
            this.gAX.setController(isController);
            this.gAW.setController(isController);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAL() {
        this.gAW.bAV().e(getPageContext());
        this.gAW.bAV().setTextOption(NoDataViewFactory.d.iH(R.string.members_no_person));
        this.gAW.bAV().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.gAW.onChangeSkinType(i);
        this.gAV.iP(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gAW.bAY()) {
            bAM();
        } else if (view == this.gAW.bAS()) {
            bAO();
            this.gAW.lW(false);
        } else if (view == this.gAW.bAT()) {
            bAN();
            this.gAW.lW(true);
        } else if (view == this.gAW.bAU()) {
            bAP();
        }
    }

    private void bAM() {
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
                MembersActivity.this.gAX.setOrderType(i2);
                MembersActivity.this.showToast(MembersActivity.this.getResources().getStringArray(R.array.members_order_by_short)[i]);
                MembersActivity.this.reset();
                MembersActivity.this.gAW.byl().startPullRefresh();
            }
        });
        iVar.showDialog();
    }

    private void bAN() {
        this.gAW.uW(0);
        this.gAW.lV(false);
        this.gAW.bAW().lT(false);
        this.gAW.bAW().bAQ();
        this.gAW.bAX();
    }

    private void bAO() {
        this.gAW.uW(0);
        this.gAW.lV(true);
        this.gAW.bAW().lT(true);
        this.gAW.bAX();
    }

    private void bAP() {
        Set<Long> bAR = this.gAW.bAW().bAR();
        if (bAR.size() > 0) {
            final ArrayList arrayList = new ArrayList();
            arrayList.addAll(bAR);
            DialogUtil.removeMembersDialog(getPageContext().getPageActivity(), new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    MembersActivity.this.gAW.lV(false);
                    MembersActivity.this.gAW.bAW().lT(false);
                    MembersActivity.this.gAW.bAX();
                    MembersActivity.this.b(MembersActivity.this.gAX.getGroupId(), arrayList);
                    MembersActivity.this.gAW.lW(true);
                }
            }, new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
        }
    }

    private void aHq() {
        if (this.gAW.bAW().aYB()) {
            this.gAX.sendMessage(this.gAX.getGroupId(), this.gAX.getStart(), this.gAX.getLen(), this.gAX.getOrderType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        aHq();
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public p onGetPreLoadListView() {
        if (this.gAW == null || this.gAW.byl() == null) {
            return null;
        }
        return this.gAW.byl().getPreLoadHandle();
    }
}
