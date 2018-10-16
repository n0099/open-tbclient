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
    private com.baidu.tbadk.core.view.k eIa;
    private m eIb;
    private MembersModel eIc;
    private final com.baidu.adp.framework.listener.c eyR = new com.baidu.adp.framework.listener.c(103005) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            RequestMembersMessage requestMembersMessage;
            l aQg = MembersActivity.this.eIb.aQg();
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
            MembersActivity.this.eIc.setRequestM(requestMembersMessage);
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
                if (users.size() != MembersActivity.this.eIc.getLen()) {
                    aQg.in(false);
                    aQg.io(false);
                    if (MembersActivity.this.aJN() && users.size() == 0) {
                        MembersActivity.this.aPV();
                        return;
                    }
                } else {
                    aQg.io(true);
                }
                MembersActivity.this.eIc.addStart(users.size());
                MembersActivity.this.eIc.setLen(20);
                aQg.cD(users);
                aQg.notifyDataSetChanged();
            }
        }
    };
    private final com.baidu.adp.framework.listener.c eId = new com.baidu.adp.framework.listener.c(103112) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            MembersActivity.this.eIb.iq(false);
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
            MembersActivity.this.eIb.aQg().cE(MembersActivity.this.eIc.getUserIds());
            MembersActivity.this.eIb.aQh();
            MembersActivity.this.eIb.aQg().aQa();
        }
    };
    private final CustomMessageListener eIe = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.2
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
                        MembersActivity.this.eIb.aNv().startPullRefresh();
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
        registerListener(2001128, this.eIe);
        registerListener(2001126, this.eIe);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.eIc.saveInstance(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.eIb.aQf().onActivityStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public MembersModel aPU() {
        return this.eIc;
    }

    private void initUI() {
        this.eIb = new m(this);
        final BdListView aNv = this.eIb.aNv();
        this.eIa = new com.baidu.tbadk.core.view.k(getPageContext());
        this.eIa.a(new j.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.1
            @Override // com.baidu.tbadk.core.view.j.b
            public void bp(boolean z) {
                if (!MembersActivity.this.eIb.aQg().aNh()) {
                    if (!MembersActivity.this.aJN()) {
                        MembersActivity.this.reset();
                    }
                    MembersActivity.this.eIc.sendMessage(MembersActivity.this.eIc.getGroupId(), MembersActivity.this.eIc.getStart(), MembersActivity.this.eIc.getLen(), MembersActivity.this.eIc.getOrderType());
                    return;
                }
                aNv.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
            }
        });
        aNv.setPullRefresh(this.eIa);
        aNv.setOnSrollToBottomListener(this);
        aNv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                l aQg = MembersActivity.this.eIb.aQg();
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
                if (!MembersActivity.this.eIb.aQg().aNh() && MembersActivity.this.eIc.isController()) {
                    UserData userData = (UserData) MembersActivity.this.eIb.aQg().getItem(i);
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
                                MembersActivity.this.b(MembersActivity.this.eIc.getGroupId(), arrayList);
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
        this.eIb.aQc().setOnClickListener(this);
        this.eIb.aQd().setOnClickListener(this);
        this.eIb.aQe().setOnClickListener(this);
        this.eIb.setController(false);
        this.eIb.aQg().a(new l.a() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.5
            @Override // com.baidu.tieba.im.frsgroup.l.a
            public void ph(int i) {
                MembersActivity.this.eIb.pi(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, List<Long> list) {
        if (list != null && list.size() != 0) {
            this.eIb.iq(true);
            this.eIc.setUserIds(list);
            this.eIc.sendRemoveMessage(j, cC(list));
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
        this.eIc.setUseCache(false);
        this.eIc.setRequestM(null);
        this.eIb.aQg().reset(true);
        this.eIc.setStart(0);
        this.eIc.setLen(50);
        this.eIb.aNv().startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.eIc.setUseCache(true);
        this.eIc.setRequestM(null);
        this.eIb.aQg().reset(false);
        this.eIc.setStart(0);
        this.eIc.setLen(50);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFG() {
        if (aJN()) {
            this.eIb.aFG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aJN() {
        return 50 == this.eIc.getLen();
    }

    public void initData(Bundle bundle) {
        this.eIc = new MembersModel(this);
        this.eIc.setUniqueId(getUniqueId());
        if (bundle == null) {
            this.eIc.initWithIntent(getIntent());
        } else {
            this.eIc.initWithBundle(bundle);
        }
        registerListener(this.eyR);
        registerListener(this.eId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserData.Permission permission) {
        if (permission != null) {
            boolean isController = permission.isController();
            this.eIc.setController(isController);
            this.eIb.setController(isController);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPV() {
        this.eIb.aQf().e(getPageContext());
        this.eIb.aQf().setTextOption(NoDataViewFactory.d.dO(e.j.members_no_person));
        this.eIb.aQf().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.eIb.onChangeSkinType(i);
        this.eIa.dW(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eIb.aQi()) {
            aPW();
        } else if (view == this.eIb.aQc()) {
            aPY();
            this.eIb.is(false);
        } else if (view == this.eIb.aQd()) {
            aPX();
            this.eIb.is(true);
        } else if (view == this.eIb.aQe()) {
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
                MembersActivity.this.eIc.setOrderType(i2);
                MembersActivity.this.showToast(MembersActivity.this.getResources().getStringArray(e.b.members_order_by_short)[i]);
                MembersActivity.this.reset();
                MembersActivity.this.eIb.aNv().startPullRefresh();
            }
        });
    }

    private void aPX() {
        this.eIb.pi(0);
        this.eIb.ir(false);
        this.eIb.aQg().ip(false);
        this.eIb.aQg().aQa();
        this.eIb.aQh();
    }

    private void aPY() {
        this.eIb.pi(0);
        this.eIb.ir(true);
        this.eIb.aQg().ip(true);
        this.eIb.aQh();
    }

    private void aPZ() {
        Set<Long> aQb = this.eIb.aQg().aQb();
        if (aQb.size() > 0) {
            final ArrayList arrayList = new ArrayList();
            arrayList.addAll(aQb);
            DialogUtil.removeMembersDialog(getPageContext().getPageActivity(), new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    MembersActivity.this.eIb.ir(false);
                    MembersActivity.this.eIb.aQg().ip(false);
                    MembersActivity.this.eIb.aQh();
                    MembersActivity.this.b(MembersActivity.this.eIc.getGroupId(), arrayList);
                    MembersActivity.this.eIb.is(true);
                }
            }, new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
        }
    }

    private void YK() {
        if (this.eIb.aQg().apb()) {
            this.eIc.sendMessage(this.eIc.getGroupId(), this.eIc.getStart(), this.eIc.getLen(), this.eIc.getOrderType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        YK();
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (this.eIb == null || this.eIb.aNv() == null) {
            return null;
        }
        return this.eIb.aNv().getPreLoadHandle();
    }
}
