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
    private com.baidu.tbadk.core.view.g kui;
    private m kuj;
    private MembersModel kuk;
    private final com.baidu.adp.framework.listener.c kjf = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REQUEST_MEMBERS_BY_ID) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            RequestMembersMessage requestMembersMessage;
            l cXl = MembersActivity.this.kuj.cXl();
            MembersActivity.this.cJL();
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
            MembersActivity.this.kuk.setRequestM(requestMembersMessage);
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
                if (MembersActivity.this.cPN()) {
                    MembersActivity.this.a(membersData.getPermission());
                }
                if (MembersActivity.this.cPN()) {
                    cXl.reset(true);
                }
                if (users.size() != MembersActivity.this.kuk.getLen()) {
                    cXl.sy(false);
                    cXl.sz(false);
                    if (MembersActivity.this.cPN() && users.size() == 0) {
                        MembersActivity.this.cWZ();
                        return;
                    }
                } else {
                    cXl.sz(true);
                }
                MembersActivity.this.kuk.addStart(users.size());
                MembersActivity.this.kuk.setLen(20);
                cXl.ew(users);
                cXl.notifyDataSetChanged();
            }
        }
    };
    private final com.baidu.adp.framework.listener.c kul = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REMOVE_MEMBERS) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            MembersActivity.this.kuj.showProgressBar(false);
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
            MembersActivity.this.kuj.cXl().ex(MembersActivity.this.kuk.getUserIds());
            MembersActivity.this.kuj.cXm();
            MembersActivity.this.kuj.cXl().cXe();
        }
    };
    private final CustomMessageListener kum = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.2
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
                        MembersActivity.this.kuj.cUj().startPullRefresh();
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
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_KICK_OUT, this.kum);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_SUCCESS, this.kum);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.kuk.saveInstance(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.kuj.cXk().bvb();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public MembersModel cWY() {
        return this.kuk;
    }

    private void initUI() {
        this.kuj = new m(this);
        final BdListView cUj = this.kuj.cUj();
        this.kui = new com.baidu.tbadk.core.view.g(getPageContext());
        this.kui.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (!MembersActivity.this.kuj.cXl().cTT()) {
                    if (!MembersActivity.this.cPN()) {
                        MembersActivity.this.reset();
                    }
                    MembersActivity.this.kuk.sendMessage(MembersActivity.this.kuk.getGroupId(), MembersActivity.this.kuk.getStart(), MembersActivity.this.kuk.getLen(), MembersActivity.this.kuk.getOrderType());
                    return;
                }
                cUj.completePullRefreshPostDelayed(0L);
            }
        });
        cUj.setPullRefresh(this.kui);
        cUj.setOnSrollToBottomListener(this);
        cUj.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                l cXl = MembersActivity.this.kuj.cXl();
                UserData userData = (UserData) cXl.getItem(i);
                if (userData != null) {
                    if (cXl.cTT()) {
                        if (!userData.getPermission().isController()) {
                            cXl.i(Long.valueOf(userData.getUserIdLong()));
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(MembersActivity.this.getPageContext().getContext(), userData.getUserId() + "", userData.getUserName())));
                }
            }
        });
        cUj.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.4
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!MembersActivity.this.kuj.cXl().cTT() && MembersActivity.this.kuk.isController()) {
                    UserData userData = (UserData) MembersActivity.this.kuj.cXl().getItem(i);
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
                                MembersActivity.this.b(MembersActivity.this.kuk.getGroupId(), arrayList);
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
        this.kuj.cXh().setOnClickListener(this);
        this.kuj.cXi().setOnClickListener(this);
        this.kuj.cXj().setOnClickListener(this);
        this.kuj.setController(false);
        this.kuj.cXl().a(new l.a() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.5
            @Override // com.baidu.tieba.im.frsgroup.l.a
            public void Ej(int i) {
                MembersActivity.this.kuj.Ek(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, List<Long> list) {
        if (list != null && list.size() != 0) {
            this.kuj.showProgressBar(true);
            this.kuk.setUserIds(list);
            this.kuk.sendRemoveMessage(j, ev(list));
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
        this.kuk.setUseCache(false);
        this.kuk.setRequestM(null);
        this.kuj.cXl().reset(true);
        this.kuk.setStart(0);
        this.kuk.setLen(50);
        this.kuj.cUj().startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.kuk.setUseCache(true);
        this.kuk.setRequestM(null);
        this.kuj.cXl().reset(false);
        this.kuk.setStart(0);
        this.kuk.setLen(50);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJL() {
        if (cPN()) {
            this.kuj.cJL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cPN() {
        return 50 == this.kuk.getLen();
    }

    public void initData(Bundle bundle) {
        this.kuk = new MembersModel(this);
        this.kuk.setUniqueId(getUniqueId());
        if (bundle == null) {
            this.kuk.initWithIntent(getIntent());
        } else {
            this.kuk.initWithBundle(bundle);
        }
        registerListener(this.kjf);
        registerListener(this.kul);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserData.Permission permission) {
        if (permission != null) {
            boolean isController = permission.isController();
            this.kuk.setController(isController);
            this.kuj.setController(isController);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWZ() {
        this.kuj.cXk().e(getPageContext());
        this.kuj.cXk().setTextOption(NoDataViewFactory.d.qP(R.string.members_no_person));
        this.kuj.cXk().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.kuj.onChangeSkinType(i);
        this.kui.changeSkin(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.kuj.cXn()) {
            cXa();
        } else if (view == this.kuj.cXh()) {
            cXc();
            this.kuj.sC(false);
        } else if (view == this.kuj.cXi()) {
            cXb();
            this.kuj.sC(true);
        } else if (view == this.kuj.cXj()) {
            cXd();
        }
    }

    private void cXa() {
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
                MembersActivity.this.kuk.setOrderType(i2);
                MembersActivity.this.showToast(MembersActivity.this.getResources().getStringArray(R.array.members_order_by_short)[i]);
                MembersActivity.this.reset();
                MembersActivity.this.kuj.cUj().startPullRefresh();
            }
        });
        iVar.RU();
    }

    private void cXb() {
        this.kuj.Ek(0);
        this.kuj.sB(false);
        this.kuj.cXl().sA(false);
        this.kuj.cXl().cXe();
        this.kuj.cXm();
    }

    private void cXc() {
        this.kuj.Ek(0);
        this.kuj.sB(true);
        this.kuj.cXl().sA(true);
        this.kuj.cXm();
    }

    private void cXd() {
        Set<Long> cXf = this.kuj.cXl().cXf();
        if (cXf.size() > 0) {
            final ArrayList arrayList = new ArrayList();
            arrayList.addAll(cXf);
            DialogUtil.removeMembersDialog(getPageContext().getPageActivity(), new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    MembersActivity.this.kuj.sB(false);
                    MembersActivity.this.kuj.cXl().sA(false);
                    MembersActivity.this.kuj.cXm();
                    MembersActivity.this.b(MembersActivity.this.kuk.getGroupId(), arrayList);
                    MembersActivity.this.kuj.sC(true);
                }
            }, new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
        }
    }

    private void bRM() {
        if (this.kuj.cXl().cXg()) {
            this.kuk.sendMessage(this.kuk.getGroupId(), this.kuk.getStart(), this.kuk.getLen(), this.kuk.getOrderType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        bRM();
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public t onGetPreLoadListView() {
        if (this.kuj == null || this.kuj.cUj() == null) {
            return null;
        }
        return this.kuj.cUj().getPreLoadHandle();
    }
}
