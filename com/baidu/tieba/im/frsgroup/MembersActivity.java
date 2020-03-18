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
/* loaded from: classes10.dex */
public class MembersActivity extends BaseActivity<MembersActivity> implements View.OnClickListener, BdListView.e {
    private com.baidu.tbadk.core.view.h hCt;
    private m hCu;
    private MembersModel hCv;
    private final com.baidu.adp.framework.listener.c htm = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REQUEST_MEMBERS_BY_ID) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            RequestMembersMessage requestMembersMessage;
            l bVK = MembersActivity.this.hCu.bVK();
            MembersActivity.this.bKb();
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
            MembersActivity.this.hCv.setRequestM(requestMembersMessage);
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
                if (MembersActivity.this.bOX()) {
                    MembersActivity.this.a(membersData.getPermission());
                }
                if (MembersActivity.this.bOX()) {
                    bVK.reset(true);
                }
                if (users.size() != MembersActivity.this.hCv.getLen()) {
                    bVK.nF(false);
                    bVK.nG(false);
                    if (MembersActivity.this.bOX() && users.size() == 0) {
                        MembersActivity.this.bVy();
                        return;
                    }
                } else {
                    bVK.nG(true);
                }
                MembersActivity.this.hCv.addStart(users.size());
                MembersActivity.this.hCv.setLen(20);
                bVK.cX(users);
                bVK.notifyDataSetChanged();
            }
        }
    };
    private final com.baidu.adp.framework.listener.c hCw = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REMOVE_MEMBERS) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            MembersActivity.this.hCu.showProgressBar(false);
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
            MembersActivity.this.hCu.bVK().cY(MembersActivity.this.hCv.getUserIds());
            MembersActivity.this.hCu.bVL();
            MembersActivity.this.hCu.bVK().bVD();
        }
    };
    private final CustomMessageListener hCx = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.2
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
                        MembersActivity.this.hCu.bTa().startPullRefresh();
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
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_KICK_OUT, this.hCx);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_SUCCESS, this.hCx);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.hCv.saveInstance(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.hCu.bVJ().aHG();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public MembersModel bVx() {
        return this.hCv;
    }

    private void initUI() {
        this.hCu = new m(this);
        final BdListView bTa = this.hCu.bTa();
        this.hCt = new com.baidu.tbadk.core.view.h(getPageContext());
        this.hCt.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.1
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (!MembersActivity.this.hCu.bVK().bSN()) {
                    if (!MembersActivity.this.bOX()) {
                        MembersActivity.this.reset();
                    }
                    MembersActivity.this.hCv.sendMessage(MembersActivity.this.hCv.getGroupId(), MembersActivity.this.hCv.getStart(), MembersActivity.this.hCv.getLen(), MembersActivity.this.hCv.getOrderType());
                    return;
                }
                bTa.completePullRefreshPostDelayed(0L);
            }
        });
        bTa.setPullRefresh(this.hCt);
        bTa.setOnSrollToBottomListener(this);
        bTa.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                l bVK = MembersActivity.this.hCu.bVK();
                UserData userData = (UserData) bVK.getItem(i);
                if (userData != null) {
                    if (bVK.bSN()) {
                        if (!userData.getPermission().isController()) {
                            bVK.f(Long.valueOf(userData.getUserIdLong()));
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(MembersActivity.this.getPageContext().getContext(), userData.getUserId() + "", userData.getUserName())));
                }
            }
        });
        bTa.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.4
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!MembersActivity.this.hCu.bVK().bSN() && MembersActivity.this.hCv.isController()) {
                    UserData userData = (UserData) MembersActivity.this.hCu.bVK().getItem(i);
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
                                MembersActivity.this.a(MembersActivity.this.hCv.getGroupId(), arrayList);
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
        this.hCu.bVG().setOnClickListener(this);
        this.hCu.bVH().setOnClickListener(this);
        this.hCu.bVI().setOnClickListener(this);
        this.hCu.setController(false);
        this.hCu.bVK().a(new l.a() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.5
            @Override // com.baidu.tieba.im.frsgroup.l.a
            public void wC(int i) {
                MembersActivity.this.hCu.wD(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, List<Long> list) {
        if (list != null && list.size() != 0) {
            this.hCu.showProgressBar(true);
            this.hCv.setUserIds(list);
            this.hCv.sendRemoveMessage(j, cW(list));
        }
    }

    private String cW(List<Long> list) {
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
        this.hCv.setUseCache(false);
        this.hCv.setRequestM(null);
        this.hCu.bVK().reset(true);
        this.hCv.setStart(0);
        this.hCv.setLen(50);
        this.hCu.bTa().startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.hCv.setUseCache(true);
        this.hCv.setRequestM(null);
        this.hCu.bVK().reset(false);
        this.hCv.setStart(0);
        this.hCv.setLen(50);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKb() {
        if (bOX()) {
            this.hCu.bKb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bOX() {
        return 50 == this.hCv.getLen();
    }

    public void initData(Bundle bundle) {
        this.hCv = new MembersModel(this);
        this.hCv.setUniqueId(getUniqueId());
        if (bundle == null) {
            this.hCv.initWithIntent(getIntent());
        } else {
            this.hCv.initWithBundle(bundle);
        }
        registerListener(this.htm);
        registerListener(this.hCw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserData.Permission permission) {
        if (permission != null) {
            boolean isController = permission.isController();
            this.hCv.setController(isController);
            this.hCu.setController(isController);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVy() {
        this.hCu.bVJ().e(getPageContext());
        this.hCu.bVJ().setTextOption(NoDataViewFactory.d.lh(R.string.members_no_person));
        this.hCu.bVJ().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.hCu.onChangeSkinType(i);
        this.hCt.changeSkin(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hCu.bVM()) {
            bVz();
        } else if (view == this.hCu.bVG()) {
            bVB();
            this.hCu.nJ(false);
        } else if (view == this.hCu.bVH()) {
            bVA();
            this.hCu.nJ(true);
        } else if (view == this.hCu.bVI()) {
            bVC();
        }
    }

    private void bVz() {
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
                MembersActivity.this.hCv.setOrderType(i2);
                MembersActivity.this.showToast(MembersActivity.this.getResources().getStringArray(R.array.members_order_by_short)[i]);
                MembersActivity.this.reset();
                MembersActivity.this.hCu.bTa().startPullRefresh();
            }
        });
        iVar.showDialog();
    }

    private void bVA() {
        this.hCu.wD(0);
        this.hCu.nI(false);
        this.hCu.bVK().nH(false);
        this.hCu.bVK().bVD();
        this.hCu.bVL();
    }

    private void bVB() {
        this.hCu.wD(0);
        this.hCu.nI(true);
        this.hCu.bVK().nH(true);
        this.hCu.bVL();
    }

    private void bVC() {
        Set<Long> bVE = this.hCu.bVK().bVE();
        if (bVE.size() > 0) {
            final ArrayList arrayList = new ArrayList();
            arrayList.addAll(bVE);
            DialogUtil.removeMembersDialog(getPageContext().getPageActivity(), new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    MembersActivity.this.hCu.nI(false);
                    MembersActivity.this.hCu.bVK().nH(false);
                    MembersActivity.this.hCu.bVL();
                    MembersActivity.this.a(MembersActivity.this.hCv.getGroupId(), arrayList);
                    MembersActivity.this.hCu.nJ(true);
                }
            }, new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
        }
    }

    private void bck() {
        if (this.hCu.bVK().bVF()) {
            this.hCv.sendMessage(this.hCv.getGroupId(), this.hCv.getStart(), this.hCv.getLen(), this.hCv.getOrderType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        bck();
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public p onGetPreLoadListView() {
        if (this.hCu == null || this.hCu.bTa() == null) {
            return null;
        }
        return this.hCu.bTa().getPreLoadHandle();
    }
}
