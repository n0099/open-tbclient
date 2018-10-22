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
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.data.UserData;
import com.baidu.tieba.e;
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
/* loaded from: classes3.dex */
public class MembersActivity extends BaseActivity<MembersActivity> implements View.OnClickListener, BdListView.e {
    private com.baidu.tbadk.core.view.k eIb;
    private m eIc;
    private MembersModel eId;
    private final com.baidu.adp.framework.listener.c eyS = new com.baidu.adp.framework.listener.c(103005) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            RequestMembersMessage requestMembersMessage;
            l aQg = MembersActivity.this.eIc.aQg();
            MembersActivity.this.aFG();
            if (socketResponsedMessage == null || !(socketResponsedMessage instanceof ResponseMembersMessage)) {
                MembersActivity.this.showToast(e.j.neterror);
                return;
            }
            ResponseMembersMessage responseMembersMessage = (ResponseMembersMessage) socketResponsedMessage;
            Message<?> orginalMessage = responseMembersMessage.getOrginalMessage();
            if (orginalMessage == null || !(orginalMessage instanceof RequestMembersMessage)) {
                requestMembersMessage = null;
            } else {
                requestMembersMessage = (RequestMembersMessage) orginalMessage;
            }
            MembersActivity.this.eId.setRequestM(requestMembersMessage);
            if (responseMembersMessage.getError() != 0) {
                if (responseMembersMessage.getError() > 0) {
                    MembersActivity.this.showToast(StringUtils.isNull(responseMembersMessage.getErrorString()) ? MembersActivity.this.getResources().getString(e.j.neterror) : responseMembersMessage.getErrorString());
                    return;
                } else {
                    MembersActivity.this.showToast(e.j.neterror);
                    return;
                }
            }
            MembersData membersData = responseMembersMessage.getMembersData();
            List<UserData> users = membersData.getUsers();
            if (users != null) {
                if (MembersActivity.this.aJN()) {
                    MembersActivity.this.a(membersData.getPermission());
                }
                if (MembersActivity.this.aJN()) {
                    aQg.reset(true);
                }
                if (users.size() != MembersActivity.this.eId.getLen()) {
                    aQg.in(false);
                    aQg.io(false);
                    if (MembersActivity.this.aJN() && users.size() == 0) {
                        MembersActivity.this.aPV();
                        return;
                    }
                } else {
                    aQg.io(true);
                }
                MembersActivity.this.eId.addStart(users.size());
                MembersActivity.this.eId.setLen(20);
                aQg.cD(users);
                aQg.notifyDataSetChanged();
            }
        }
    };
    private final com.baidu.adp.framework.listener.c eIe = new com.baidu.adp.framework.listener.c(103112) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            MembersActivity.this.eIc.iq(false);
            if (socketResponsedMessage == null || !(socketResponsedMessage instanceof ResponseRemoveMembersMessage)) {
                MembersActivity.this.showToast(e.j.neterror);
                return;
            }
            ResponseRemoveMembersMessage responseRemoveMembersMessage = (ResponseRemoveMembersMessage) socketResponsedMessage;
            if (responseRemoveMembersMessage.getError() != 0) {
                if (responseRemoveMembersMessage.getError() > 0) {
                    MembersActivity.this.showToast(StringUtils.isNull(responseRemoveMembersMessage.getErrorString()) ? MembersActivity.this.getResources().getString(e.j.neterror) : responseRemoveMembersMessage.getErrorString());
                    return;
                } else {
                    MembersActivity.this.showToast(e.j.neterror);
                    return;
                }
            }
            MembersActivity.this.showToast(e.j.delete_success);
            MembersActivity.this.eIc.aQg().cE(MembersActivity.this.eId.getUserIds());
            MembersActivity.this.eIc.aQh();
            MembersActivity.this.eIc.aQg().aQa();
        }
    };
    private final CustomMessageListener eIf = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.2
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
                        MembersActivity.this.eIc.aNv().startPullRefresh();
                    }
                }
            }
        }
    };

    public static void i(Context context, long j) {
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
        registerListener(2001128, this.eIf);
        registerListener(2001126, this.eIf);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.eId.saveInstance(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.eIc.aQf().onActivityStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public MembersModel aPU() {
        return this.eId;
    }

    private void initUI() {
        this.eIc = new m(this);
        final BdListView aNv = this.eIc.aNv();
        this.eIb = new com.baidu.tbadk.core.view.k(getPageContext());
        this.eIb.a(new j.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.1
            @Override // com.baidu.tbadk.core.view.j.b
            public void bp(boolean z) {
                if (!MembersActivity.this.eIc.aQg().aNh()) {
                    if (!MembersActivity.this.aJN()) {
                        MembersActivity.this.reset();
                    }
                    MembersActivity.this.eId.sendMessage(MembersActivity.this.eId.getGroupId(), MembersActivity.this.eId.getStart(), MembersActivity.this.eId.getLen(), MembersActivity.this.eId.getOrderType());
                    return;
                }
                aNv.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
            }
        });
        aNv.setPullRefresh(this.eIb);
        aNv.setOnSrollToBottomListener(this);
        aNv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                l aQg = MembersActivity.this.eIc.aQg();
                UserData userData = (UserData) aQg.getItem(i);
                if (userData != null) {
                    if (aQg.aNh()) {
                        if (!userData.getPermission().isController()) {
                            aQg.g(Long.valueOf(userData.getUserIdLong()));
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(MembersActivity.this.getPageContext().getContext(), userData.getUserId() + "", userData.getUserName())));
                }
            }
        });
        aNv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.4
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!MembersActivity.this.eIc.aQg().aNh() && MembersActivity.this.eId.isController()) {
                    UserData userData = (UserData) MembersActivity.this.eIc.aQg().getItem(i);
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
                                MembersActivity.this.b(MembersActivity.this.eId.getGroupId(), arrayList);
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
        this.eIc.aQc().setOnClickListener(this);
        this.eIc.aQd().setOnClickListener(this);
        this.eIc.aQe().setOnClickListener(this);
        this.eIc.setController(false);
        this.eIc.aQg().a(new l.a() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.5
            @Override // com.baidu.tieba.im.frsgroup.l.a
            public void ph(int i) {
                MembersActivity.this.eIc.pi(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, List<Long> list) {
        if (list != null && list.size() != 0) {
            this.eIc.iq(true);
            this.eId.setUserIds(list);
            this.eId.sendRemoveMessage(j, cC(list));
        }
    }

    private String cC(List<Long> list) {
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
        this.eId.setUseCache(false);
        this.eId.setRequestM(null);
        this.eIc.aQg().reset(true);
        this.eId.setStart(0);
        this.eId.setLen(50);
        this.eIc.aNv().startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.eId.setUseCache(true);
        this.eId.setRequestM(null);
        this.eIc.aQg().reset(false);
        this.eId.setStart(0);
        this.eId.setLen(50);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFG() {
        if (aJN()) {
            this.eIc.aFG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aJN() {
        return 50 == this.eId.getLen();
    }

    public void initData(Bundle bundle) {
        this.eId = new MembersModel(this);
        this.eId.setUniqueId(getUniqueId());
        if (bundle == null) {
            this.eId.initWithIntent(getIntent());
        } else {
            this.eId.initWithBundle(bundle);
        }
        registerListener(this.eyS);
        registerListener(this.eIe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserData.Permission permission) {
        if (permission != null) {
            boolean isController = permission.isController();
            this.eId.setController(isController);
            this.eIc.setController(isController);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPV() {
        this.eIc.aQf().e(getPageContext());
        this.eIc.aQf().setTextOption(NoDataViewFactory.d.dO(e.j.members_no_person));
        this.eIc.aQf().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.eIc.onChangeSkinType(i);
        this.eIb.dW(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eIc.aQi()) {
            aPW();
        } else if (view == this.eIc.aQc()) {
            aPY();
            this.eIc.is(false);
        } else if (view == this.eIc.aQd()) {
            aPX();
            this.eIc.is(true);
        } else if (view == this.eIc.aQe()) {
            aPZ();
        }
    }

    private void aPW() {
        DialogUtil.orderMembers(getPageContext().getPageActivity(), new b.InterfaceC0124b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.8
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0124b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                int i2 = 0;
                bVar.dismiss();
                switch (i) {
                    case 1:
                        i2 = 1;
                        break;
                    case 2:
                        i2 = 2;
                        break;
                }
                MembersActivity.this.eId.setOrderType(i2);
                MembersActivity.this.showToast(MembersActivity.this.getResources().getStringArray(e.b.members_order_by_short)[i]);
                MembersActivity.this.reset();
                MembersActivity.this.eIc.aNv().startPullRefresh();
            }
        });
    }

    private void aPX() {
        this.eIc.pi(0);
        this.eIc.ir(false);
        this.eIc.aQg().ip(false);
        this.eIc.aQg().aQa();
        this.eIc.aQh();
    }

    private void aPY() {
        this.eIc.pi(0);
        this.eIc.ir(true);
        this.eIc.aQg().ip(true);
        this.eIc.aQh();
    }

    private void aPZ() {
        Set<Long> aQb = this.eIc.aQg().aQb();
        if (aQb.size() > 0) {
            final ArrayList arrayList = new ArrayList();
            arrayList.addAll(aQb);
            DialogUtil.removeMembersDialog(getPageContext().getPageActivity(), new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    MembersActivity.this.eIc.ir(false);
                    MembersActivity.this.eIc.aQg().ip(false);
                    MembersActivity.this.eIc.aQh();
                    MembersActivity.this.b(MembersActivity.this.eId.getGroupId(), arrayList);
                    MembersActivity.this.eIc.is(true);
                }
            }, new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
        }
    }

    private void YL() {
        if (this.eIc.aQg().apc()) {
            this.eId.sendMessage(this.eId.getGroupId(), this.eId.getStart(), this.eId.getLen(), this.eId.getOrderType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        YL();
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (this.eIc == null || this.eIc.aNv() == null) {
            return null;
        }
        return this.eIc.aNv().getPreLoadHandle();
    }
}
