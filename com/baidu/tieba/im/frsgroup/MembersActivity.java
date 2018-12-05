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
    private com.baidu.tbadk.core.view.k eQi;
    private m eQj;
    private MembersModel eQk;
    private final com.baidu.adp.framework.listener.c eHa = new com.baidu.adp.framework.listener.c(103005) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            RequestMembersMessage requestMembersMessage;
            l aRv = MembersActivity.this.eQj.aRv();
            MembersActivity.this.aGO();
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
            MembersActivity.this.eQk.setRequestM(requestMembersMessage);
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
                if (MembersActivity.this.aLd()) {
                    MembersActivity.this.a(membersData.getPermission());
                }
                if (MembersActivity.this.aLd()) {
                    aRv.reset(true);
                }
                if (users.size() != MembersActivity.this.eQk.getLen()) {
                    aRv.iz(false);
                    aRv.iA(false);
                    if (MembersActivity.this.aLd() && users.size() == 0) {
                        MembersActivity.this.aRk();
                        return;
                    }
                } else {
                    aRv.iA(true);
                }
                MembersActivity.this.eQk.addStart(users.size());
                MembersActivity.this.eQk.setLen(20);
                aRv.cF(users);
                aRv.notifyDataSetChanged();
            }
        }
    };
    private final com.baidu.adp.framework.listener.c eQl = new com.baidu.adp.framework.listener.c(103112) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            MembersActivity.this.eQj.iC(false);
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
            MembersActivity.this.eQj.aRv().cG(MembersActivity.this.eQk.getUserIds());
            MembersActivity.this.eQj.aRw();
            MembersActivity.this.eQj.aRv().aRp();
        }
    };
    private final CustomMessageListener eQm = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.2
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
                        MembersActivity.this.eQj.aOK().startPullRefresh();
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
        registerListener(2001128, this.eQm);
        registerListener(2001126, this.eQm);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.eQk.saveInstance(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.eQj.aRu().onActivityStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public MembersModel aRj() {
        return this.eQk;
    }

    private void initUI() {
        this.eQj = new m(this);
        final BdListView aOK = this.eQj.aOK();
        this.eQi = new com.baidu.tbadk.core.view.k(getPageContext());
        this.eQi.a(new j.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.1
            @Override // com.baidu.tbadk.core.view.j.b
            public void bH(boolean z) {
                if (!MembersActivity.this.eQj.aRv().aOx()) {
                    if (!MembersActivity.this.aLd()) {
                        MembersActivity.this.reset();
                    }
                    MembersActivity.this.eQk.sendMessage(MembersActivity.this.eQk.getGroupId(), MembersActivity.this.eQk.getStart(), MembersActivity.this.eQk.getLen(), MembersActivity.this.eQk.getOrderType());
                    return;
                }
                aOK.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
            }
        });
        aOK.setPullRefresh(this.eQi);
        aOK.setOnSrollToBottomListener(this);
        aOK.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                l aRv = MembersActivity.this.eQj.aRv();
                UserData userData = (UserData) aRv.getItem(i);
                if (userData != null) {
                    if (aRv.aOx()) {
                        if (!userData.getPermission().isController()) {
                            aRv.h(Long.valueOf(userData.getUserIdLong()));
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(MembersActivity.this.getPageContext().getContext(), userData.getUserId() + "", userData.getUserName())));
                }
            }
        });
        aOK.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.4
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!MembersActivity.this.eQj.aRv().aOx() && MembersActivity.this.eQk.isController()) {
                    UserData userData = (UserData) MembersActivity.this.eQj.aRv().getItem(i);
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
                                MembersActivity.this.b(MembersActivity.this.eQk.getGroupId(), arrayList);
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
        this.eQj.aRr().setOnClickListener(this);
        this.eQj.aRs().setOnClickListener(this);
        this.eQj.aRt().setOnClickListener(this);
        this.eQj.setController(false);
        this.eQj.aRv().a(new l.a() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.5
            @Override // com.baidu.tieba.im.frsgroup.l.a
            public void pU(int i) {
                MembersActivity.this.eQj.pV(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, List<Long> list) {
        if (list != null && list.size() != 0) {
            this.eQj.iC(true);
            this.eQk.setUserIds(list);
            this.eQk.sendRemoveMessage(j, cE(list));
        }
    }

    private String cE(List<Long> list) {
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
        this.eQk.setUseCache(false);
        this.eQk.setRequestM(null);
        this.eQj.aRv().reset(true);
        this.eQk.setStart(0);
        this.eQk.setLen(50);
        this.eQj.aOK().startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.eQk.setUseCache(true);
        this.eQk.setRequestM(null);
        this.eQj.aRv().reset(false);
        this.eQk.setStart(0);
        this.eQk.setLen(50);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGO() {
        if (aLd()) {
            this.eQj.aGO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aLd() {
        return 50 == this.eQk.getLen();
    }

    public void initData(Bundle bundle) {
        this.eQk = new MembersModel(this);
        this.eQk.setUniqueId(getUniqueId());
        if (bundle == null) {
            this.eQk.initWithIntent(getIntent());
        } else {
            this.eQk.initWithBundle(bundle);
        }
        registerListener(this.eHa);
        registerListener(this.eQl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserData.Permission permission) {
        if (permission != null) {
            boolean isController = permission.isController();
            this.eQk.setController(isController);
            this.eQj.setController(isController);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRk() {
        this.eQj.aRu().e(getPageContext());
        this.eQj.aRu().setTextOption(NoDataViewFactory.d.eq(e.j.members_no_person));
        this.eQj.aRu().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.eQj.onChangeSkinType(i);
        this.eQi.ey(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eQj.aRx()) {
            aRl();
        } else if (view == this.eQj.aRr()) {
            aRn();
            this.eQj.iE(false);
        } else if (view == this.eQj.aRs()) {
            aRm();
            this.eQj.iE(true);
        } else if (view == this.eQj.aRt()) {
            aRo();
        }
    }

    private void aRl() {
        DialogUtil.orderMembers(getPageContext().getPageActivity(), new b.InterfaceC0158b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.8
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
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
                MembersActivity.this.eQk.setOrderType(i2);
                MembersActivity.this.showToast(MembersActivity.this.getResources().getStringArray(e.b.members_order_by_short)[i]);
                MembersActivity.this.reset();
                MembersActivity.this.eQj.aOK().startPullRefresh();
            }
        });
    }

    private void aRm() {
        this.eQj.pV(0);
        this.eQj.iD(false);
        this.eQj.aRv().iB(false);
        this.eQj.aRv().aRp();
        this.eQj.aRw();
    }

    private void aRn() {
        this.eQj.pV(0);
        this.eQj.iD(true);
        this.eQj.aRv().iB(true);
        this.eQj.aRw();
    }

    private void aRo() {
        Set<Long> aRq = this.eQj.aRv().aRq();
        if (aRq.size() > 0) {
            final ArrayList arrayList = new ArrayList();
            arrayList.addAll(aRq);
            DialogUtil.removeMembersDialog(getPageContext().getPageActivity(), new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    MembersActivity.this.eQj.iD(false);
                    MembersActivity.this.eQj.aRv().iB(false);
                    MembersActivity.this.eQj.aRw();
                    MembersActivity.this.b(MembersActivity.this.eQk.getGroupId(), arrayList);
                    MembersActivity.this.eQj.iE(true);
                }
            }, new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
        }
    }

    private void aab() {
        if (this.eQj.aRv().aqq()) {
            this.eQk.sendMessage(this.eQk.getGroupId(), this.eQk.getStart(), this.eQk.getLen(), this.eQk.getOrderType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        aab();
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (this.eQj == null || this.eQj.aOK() == null) {
            return null;
        }
        return this.eQj.aOK().getPreLoadHandle();
    }
}
