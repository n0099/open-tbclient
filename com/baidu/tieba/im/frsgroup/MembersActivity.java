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
import com.baidu.tbadk.core.view.g;
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
/* loaded from: classes8.dex */
public class MembersActivity extends BaseActivity<MembersActivity> implements View.OnClickListener, BdListView.e {
    private com.baidu.tbadk.core.view.h hyG;
    private m hyH;
    private MembersModel hyI;
    private final com.baidu.adp.framework.listener.c hpz = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REQUEST_MEMBERS_BY_ID) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            RequestMembersMessage requestMembersMessage;
            l bTO = MembersActivity.this.hyH.bTO();
            MembersActivity.this.bIj();
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
            MembersActivity.this.hyI.setRequestM(requestMembersMessage);
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
                if (MembersActivity.this.bNe()) {
                    MembersActivity.this.a(membersData.getPermission());
                }
                if (MembersActivity.this.bNe()) {
                    bTO.reset(true);
                }
                if (users.size() != MembersActivity.this.hyI.getLen()) {
                    bTO.nx(false);
                    bTO.ny(false);
                    if (MembersActivity.this.bNe() && users.size() == 0) {
                        MembersActivity.this.bTC();
                        return;
                    }
                } else {
                    bTO.ny(true);
                }
                MembersActivity.this.hyI.addStart(users.size());
                MembersActivity.this.hyI.setLen(20);
                bTO.db(users);
                bTO.notifyDataSetChanged();
            }
        }
    };
    private final com.baidu.adp.framework.listener.c hyJ = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REMOVE_MEMBERS) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            MembersActivity.this.hyH.showProgressBar(false);
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
            MembersActivity.this.hyH.bTO().dc(MembersActivity.this.hyI.getUserIds());
            MembersActivity.this.hyH.bTP();
            MembersActivity.this.hyH.bTO().bTH();
        }
    };
    private final CustomMessageListener hyK = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.2
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
                        MembersActivity.this.hyH.bRe().startPullRefresh();
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
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_KICK_OUT, this.hyK);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_SUCCESS, this.hyK);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.hyI.saveInstance(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.hyH.bTN().aFn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public MembersModel bTB() {
        return this.hyI;
    }

    private void initUI() {
        this.hyH = new m(this);
        final BdListView bRe = this.hyH.bRe();
        this.hyG = new com.baidu.tbadk.core.view.h(getPageContext());
        this.hyG.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.1
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (!MembersActivity.this.hyH.bTO().bQR()) {
                    if (!MembersActivity.this.bNe()) {
                        MembersActivity.this.reset();
                    }
                    MembersActivity.this.hyI.sendMessage(MembersActivity.this.hyI.getGroupId(), MembersActivity.this.hyI.getStart(), MembersActivity.this.hyI.getLen(), MembersActivity.this.hyI.getOrderType());
                    return;
                }
                bRe.completePullRefreshPostDelayed(0L);
            }
        });
        bRe.setPullRefresh(this.hyG);
        bRe.setOnSrollToBottomListener(this);
        bRe.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                l bTO = MembersActivity.this.hyH.bTO();
                UserData userData = (UserData) bTO.getItem(i);
                if (userData != null) {
                    if (bTO.bQR()) {
                        if (!userData.getPermission().isController()) {
                            bTO.f(Long.valueOf(userData.getUserIdLong()));
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(MembersActivity.this.getPageContext().getContext(), userData.getUserId() + "", userData.getUserName())));
                }
            }
        });
        bRe.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.4
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!MembersActivity.this.hyH.bTO().bQR() && MembersActivity.this.hyI.isController()) {
                    UserData userData = (UserData) MembersActivity.this.hyH.bTO().getItem(i);
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
                                MembersActivity.this.a(MembersActivity.this.hyI.getGroupId(), arrayList);
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
        this.hyH.bTK().setOnClickListener(this);
        this.hyH.bTL().setOnClickListener(this);
        this.hyH.bTM().setOnClickListener(this);
        this.hyH.setController(false);
        this.hyH.bTO().a(new l.a() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.5
            @Override // com.baidu.tieba.im.frsgroup.l.a
            public void wo(int i) {
                MembersActivity.this.hyH.wp(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, List<Long> list) {
        if (list != null && list.size() != 0) {
            this.hyH.showProgressBar(true);
            this.hyI.setUserIds(list);
            this.hyI.sendRemoveMessage(j, da(list));
        }
    }

    private String da(List<Long> list) {
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
        this.hyI.setUseCache(false);
        this.hyI.setRequestM(null);
        this.hyH.bTO().reset(true);
        this.hyI.setStart(0);
        this.hyI.setLen(50);
        this.hyH.bRe().startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.hyI.setUseCache(true);
        this.hyI.setRequestM(null);
        this.hyH.bTO().reset(false);
        this.hyI.setStart(0);
        this.hyI.setLen(50);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIj() {
        if (bNe()) {
            this.hyH.bIj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bNe() {
        return 50 == this.hyI.getLen();
    }

    public void initData(Bundle bundle) {
        this.hyI = new MembersModel(this);
        this.hyI.setUniqueId(getUniqueId());
        if (bundle == null) {
            this.hyI.initWithIntent(getIntent());
        } else {
            this.hyI.initWithBundle(bundle);
        }
        registerListener(this.hpz);
        registerListener(this.hyJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserData.Permission permission) {
        if (permission != null) {
            boolean isController = permission.isController();
            this.hyI.setController(isController);
            this.hyH.setController(isController);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTC() {
        this.hyH.bTN().e(getPageContext());
        this.hyH.bTN().setTextOption(NoDataViewFactory.d.kQ(R.string.members_no_person));
        this.hyH.bTN().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.hyH.onChangeSkinType(i);
        this.hyG.changeSkin(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hyH.bTQ()) {
            bTD();
        } else if (view == this.hyH.bTK()) {
            bTF();
            this.hyH.nB(false);
        } else if (view == this.hyH.bTL()) {
            bTE();
            this.hyH.nB(true);
        } else if (view == this.hyH.bTM()) {
            bTG();
        }
    }

    private void bTD() {
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
                MembersActivity.this.hyI.setOrderType(i2);
                MembersActivity.this.showToast(MembersActivity.this.getResources().getStringArray(R.array.members_order_by_short)[i]);
                MembersActivity.this.reset();
                MembersActivity.this.hyH.bRe().startPullRefresh();
            }
        });
        iVar.showDialog();
    }

    private void bTE() {
        this.hyH.wp(0);
        this.hyH.nA(false);
        this.hyH.bTO().nz(false);
        this.hyH.bTO().bTH();
        this.hyH.bTP();
    }

    private void bTF() {
        this.hyH.wp(0);
        this.hyH.nA(true);
        this.hyH.bTO().nz(true);
        this.hyH.bTP();
    }

    private void bTG() {
        Set<Long> bTI = this.hyH.bTO().bTI();
        if (bTI.size() > 0) {
            final ArrayList arrayList = new ArrayList();
            arrayList.addAll(bTI);
            DialogUtil.removeMembersDialog(getPageContext().getPageActivity(), new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    MembersActivity.this.hyH.nA(false);
                    MembersActivity.this.hyH.bTO().nz(false);
                    MembersActivity.this.hyH.bTP();
                    MembersActivity.this.a(MembersActivity.this.hyI.getGroupId(), arrayList);
                    MembersActivity.this.hyH.nB(true);
                }
            }, new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
        }
    }

    private void aZN() {
        if (this.hyH.bTO().bTJ()) {
            this.hyI.sendMessage(this.hyI.getGroupId(), this.hyI.getStart(), this.hyI.getLen(), this.hyI.getOrderType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        aZN();
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public p onGetPreLoadListView() {
        if (this.hyH == null || this.hyH.bRe() == null) {
            return null;
        }
        return this.hyH.bRe().getPreLoadHandle();
    }
}
