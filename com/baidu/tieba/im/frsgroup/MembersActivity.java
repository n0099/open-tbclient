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
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
/* loaded from: classes23.dex */
public class MembersActivity extends BaseActivity<MembersActivity> implements View.OnClickListener, BdListView.e {
    private com.baidu.tbadk.core.view.g kuk;
    private m kul;
    private MembersModel kum;
    private final com.baidu.adp.framework.listener.c kjh = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REQUEST_MEMBERS_BY_ID) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            RequestMembersMessage requestMembersMessage;
            l cXm = MembersActivity.this.kul.cXm();
            MembersActivity.this.cJM();
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
            MembersActivity.this.kum.setRequestM(requestMembersMessage);
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
                if (MembersActivity.this.cPO()) {
                    MembersActivity.this.a(membersData.getPermission());
                }
                if (MembersActivity.this.cPO()) {
                    cXm.reset(true);
                }
                if (users.size() != MembersActivity.this.kum.getLen()) {
                    cXm.sy(false);
                    cXm.sz(false);
                    if (MembersActivity.this.cPO() && users.size() == 0) {
                        MembersActivity.this.cXa();
                        return;
                    }
                } else {
                    cXm.sz(true);
                }
                MembersActivity.this.kum.addStart(users.size());
                MembersActivity.this.kum.setLen(20);
                cXm.ew(users);
                cXm.notifyDataSetChanged();
            }
        }
    };
    private final com.baidu.adp.framework.listener.c kun = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REMOVE_MEMBERS) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            MembersActivity.this.kul.showProgressBar(false);
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
            MembersActivity.this.kul.cXm().ex(MembersActivity.this.kum.getUserIds());
            MembersActivity.this.kul.cXn();
            MembersActivity.this.kul.cXm().cXf();
        }
    };
    private final CustomMessageListener kuo = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.2
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
                        MembersActivity.this.kul.cUk().startPullRefresh();
                    }
                }
            }
        }
    };

    public static void f(Context context, long j) {
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
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_KICK_OUT, this.kuo);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_SUCCESS, this.kuo);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.kum.saveInstance(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.kul.cXl().bvb();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public MembersModel cWZ() {
        return this.kum;
    }

    private void initUI() {
        this.kul = new m(this);
        final BdListView cUk = this.kul.cUk();
        this.kuk = new com.baidu.tbadk.core.view.g(getPageContext());
        this.kuk.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (!MembersActivity.this.kul.cXm().cTU()) {
                    if (!MembersActivity.this.cPO()) {
                        MembersActivity.this.reset();
                    }
                    MembersActivity.this.kum.sendMessage(MembersActivity.this.kum.getGroupId(), MembersActivity.this.kum.getStart(), MembersActivity.this.kum.getLen(), MembersActivity.this.kum.getOrderType());
                    return;
                }
                cUk.completePullRefreshPostDelayed(0L);
            }
        });
        cUk.setPullRefresh(this.kuk);
        cUk.setOnSrollToBottomListener(this);
        cUk.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                l cXm = MembersActivity.this.kul.cXm();
                UserData userData = (UserData) cXm.getItem(i);
                if (userData != null) {
                    if (cXm.cTU()) {
                        if (!userData.getPermission().isController()) {
                            cXm.i(Long.valueOf(userData.getUserIdLong()));
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(MembersActivity.this.getPageContext().getContext(), userData.getUserId() + "", userData.getUserName())));
                }
            }
        });
        cUk.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.4
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!MembersActivity.this.kul.cXm().cTU() && MembersActivity.this.kum.isController()) {
                    UserData userData = (UserData) MembersActivity.this.kul.cXm().getItem(i);
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
                                MembersActivity.this.b(MembersActivity.this.kum.getGroupId(), arrayList);
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
        this.kul.cXi().setOnClickListener(this);
        this.kul.cXj().setOnClickListener(this);
        this.kul.cXk().setOnClickListener(this);
        this.kul.setController(false);
        this.kul.cXm().a(new l.a() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.5
            @Override // com.baidu.tieba.im.frsgroup.l.a
            public void Ej(int i) {
                MembersActivity.this.kul.Ek(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, List<Long> list) {
        if (list != null && list.size() != 0) {
            this.kul.showProgressBar(true);
            this.kum.setUserIds(list);
            this.kum.sendRemoveMessage(j, ev(list));
        }
    }

    private String ev(List<Long> list) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Long l : list) {
            stringBuffer.append(l).append(",");
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        return stringBuffer.toString();
    }

    private void startLoading() {
        this.kum.setUseCache(false);
        this.kum.setRequestM(null);
        this.kul.cXm().reset(true);
        this.kum.setStart(0);
        this.kum.setLen(50);
        this.kul.cUk().startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.kum.setUseCache(true);
        this.kum.setRequestM(null);
        this.kul.cXm().reset(false);
        this.kum.setStart(0);
        this.kum.setLen(50);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJM() {
        if (cPO()) {
            this.kul.cJM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cPO() {
        return 50 == this.kum.getLen();
    }

    public void initData(Bundle bundle) {
        this.kum = new MembersModel(this);
        this.kum.setUniqueId(getUniqueId());
        if (bundle == null) {
            this.kum.initWithIntent(getIntent());
        } else {
            this.kum.initWithBundle(bundle);
        }
        registerListener(this.kjh);
        registerListener(this.kun);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserData.Permission permission) {
        if (permission != null) {
            boolean isController = permission.isController();
            this.kum.setController(isController);
            this.kul.setController(isController);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXa() {
        this.kul.cXl().e(getPageContext());
        this.kul.cXl().setTextOption(NoDataViewFactory.d.qP(R.string.members_no_person));
        this.kul.cXl().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.kul.onChangeSkinType(i);
        this.kuk.changeSkin(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.kul.cXo()) {
            cXb();
        } else if (view == this.kul.cXi()) {
            cXd();
            this.kul.sC(false);
        } else if (view == this.kul.cXj()) {
            cXc();
            this.kul.sC(true);
        } else if (view == this.kul.cXk()) {
            cXe();
        }
    }

    private void cXb() {
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
                MembersActivity.this.kum.setOrderType(i2);
                MembersActivity.this.showToast(MembersActivity.this.getResources().getStringArray(R.array.members_order_by_short)[i]);
                MembersActivity.this.reset();
                MembersActivity.this.kul.cUk().startPullRefresh();
            }
        });
        iVar.RU();
    }

    private void cXc() {
        this.kul.Ek(0);
        this.kul.sB(false);
        this.kul.cXm().sA(false);
        this.kul.cXm().cXf();
        this.kul.cXn();
    }

    private void cXd() {
        this.kul.Ek(0);
        this.kul.sB(true);
        this.kul.cXm().sA(true);
        this.kul.cXn();
    }

    private void cXe() {
        Set<Long> cXg = this.kul.cXm().cXg();
        if (cXg.size() > 0) {
            final ArrayList arrayList = new ArrayList();
            arrayList.addAll(cXg);
            DialogUtil.removeMembersDialog(getPageContext().getPageActivity(), new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    MembersActivity.this.kul.sB(false);
                    MembersActivity.this.kul.cXm().sA(false);
                    MembersActivity.this.kul.cXn();
                    MembersActivity.this.b(MembersActivity.this.kum.getGroupId(), arrayList);
                    MembersActivity.this.kul.sC(true);
                }
            }, new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
        }
    }

    private void bRN() {
        if (this.kul.cXm().cXh()) {
            this.kum.sendMessage(this.kum.getGroupId(), this.kum.getStart(), this.kum.getLen(), this.kum.getOrderType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        bRN();
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public t onGetPreLoadListView() {
        if (this.kul == null || this.kul.cUk() == null) {
            return null;
        }
        return this.kul.cUk().getPreLoadHandle();
    }
}
