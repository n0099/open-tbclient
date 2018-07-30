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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.data.UserData;
import com.baidu.tieba.d;
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
    private com.baidu.tbadk.core.view.h eta;
    private m etb;
    private MembersModel etd;
    private final com.baidu.adp.framework.listener.c ejL = new com.baidu.adp.framework.listener.c(103005) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            RequestMembersMessage requestMembersMessage;
            l aKF = MembersActivity.this.etb.aKF();
            MembersActivity.this.aAh();
            if (socketResponsedMessage == null || !(socketResponsedMessage instanceof ResponseMembersMessage)) {
                MembersActivity.this.showToast(d.j.neterror);
                return;
            }
            ResponseMembersMessage responseMembersMessage = (ResponseMembersMessage) socketResponsedMessage;
            Message<?> orginalMessage = responseMembersMessage.getOrginalMessage();
            if (orginalMessage == null || !(orginalMessage instanceof RequestMembersMessage)) {
                requestMembersMessage = null;
            } else {
                requestMembersMessage = (RequestMembersMessage) orginalMessage;
            }
            MembersActivity.this.etd.setRequestM(requestMembersMessage);
            if (responseMembersMessage.getError() != 0) {
                if (responseMembersMessage.getError() > 0) {
                    MembersActivity.this.showToast(StringUtils.isNull(responseMembersMessage.getErrorString()) ? MembersActivity.this.getResources().getString(d.j.neterror) : responseMembersMessage.getErrorString());
                    return;
                } else {
                    MembersActivity.this.showToast(d.j.neterror);
                    return;
                }
            }
            MembersData membersData = responseMembersMessage.getMembersData();
            List<UserData> users = membersData.getUsers();
            if (users != null) {
                if (MembersActivity.this.aEj()) {
                    MembersActivity.this.a(membersData.getPermission());
                }
                if (MembersActivity.this.aEj()) {
                    aKF.reset(true);
                }
                if (users.size() != MembersActivity.this.etd.getLen()) {
                    aKF.hx(false);
                    aKF.hy(false);
                    if (MembersActivity.this.aEj() && users.size() == 0) {
                        MembersActivity.this.aKu();
                        return;
                    }
                } else {
                    aKF.hy(true);
                }
                MembersActivity.this.etd.addStart(users.size());
                MembersActivity.this.etd.setLen(20);
                aKF.cn(users);
                aKF.notifyDataSetChanged();
            }
        }
    };
    private final com.baidu.adp.framework.listener.c ete = new com.baidu.adp.framework.listener.c(103112) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            MembersActivity.this.etb.hA(false);
            if (socketResponsedMessage == null || !(socketResponsedMessage instanceof ResponseRemoveMembersMessage)) {
                MembersActivity.this.showToast(d.j.neterror);
                return;
            }
            ResponseRemoveMembersMessage responseRemoveMembersMessage = (ResponseRemoveMembersMessage) socketResponsedMessage;
            if (responseRemoveMembersMessage.getError() != 0) {
                if (responseRemoveMembersMessage.getError() > 0) {
                    MembersActivity.this.showToast(StringUtils.isNull(responseRemoveMembersMessage.getErrorString()) ? MembersActivity.this.getResources().getString(d.j.neterror) : responseRemoveMembersMessage.getErrorString());
                    return;
                } else {
                    MembersActivity.this.showToast(d.j.neterror);
                    return;
                }
            }
            MembersActivity.this.showToast(d.j.delete_success);
            MembersActivity.this.etb.aKF().co(MembersActivity.this.etd.getUserIds());
            MembersActivity.this.etb.aKG();
            MembersActivity.this.etb.aKF().aKz();
        }
    };
    private final CustomMessageListener etf = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.2
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
                        MembersActivity.this.etb.aHT().startPullRefresh();
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
        registerListener(2001128, this.etf);
        registerListener(2001126, this.etf);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.etd.saveInstance(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.etb.aKE().onActivityStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public MembersModel aKt() {
        return this.etd;
    }

    private void initUI() {
        this.etb = new m(this);
        final BdListView aHT = this.etb.aHT();
        this.eta = new com.baidu.tbadk.core.view.h(getPageContext());
        this.eta.a(new g.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.1
            @Override // com.baidu.tbadk.core.view.g.b
            public void aS(boolean z) {
                if (!MembersActivity.this.etb.aKF().aHF()) {
                    if (!MembersActivity.this.aEj()) {
                        MembersActivity.this.reset();
                    }
                    MembersActivity.this.etd.sendMessage(MembersActivity.this.etd.getGroupId(), MembersActivity.this.etd.getStart(), MembersActivity.this.etd.getLen(), MembersActivity.this.etd.getOrderType());
                    return;
                }
                aHT.completePullRefreshPostDelayed(2000L);
            }
        });
        aHT.setPullRefresh(this.eta);
        aHT.setOnSrollToBottomListener(this);
        aHT.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                l aKF = MembersActivity.this.etb.aKF();
                UserData userData = (UserData) aKF.getItem(i);
                if (userData != null) {
                    if (aKF.aHF()) {
                        if (!userData.getPermission().isController()) {
                            aKF.f(Long.valueOf(userData.getUserIdLong()));
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(MembersActivity.this.getPageContext().getContext(), userData.getUserId() + "", userData.getUserName())));
                }
            }
        });
        aHT.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.4
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!MembersActivity.this.etb.aKF().aHF() && MembersActivity.this.etd.isController()) {
                    UserData userData = (UserData) MembersActivity.this.etb.aKF().getItem(i);
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
                                MembersActivity.this.b(MembersActivity.this.etd.getGroupId(), arrayList);
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
        this.etb.aKB().setOnClickListener(this);
        this.etb.aKC().setOnClickListener(this);
        this.etb.aKD().setOnClickListener(this);
        this.etb.setController(false);
        this.etb.aKF().a(new l.a() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.5
            @Override // com.baidu.tieba.im.frsgroup.l.a
            public void of(int i) {
                MembersActivity.this.etb.og(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, List<Long> list) {
        if (list != null && list.size() != 0) {
            this.etb.hA(true);
            this.etd.setUserIds(list);
            this.etd.sendRemoveMessage(j, cm(list));
        }
    }

    private String cm(List<Long> list) {
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
        this.etd.setUseCache(false);
        this.etd.setRequestM(null);
        this.etb.aKF().reset(true);
        this.etd.setStart(0);
        this.etd.setLen(50);
        this.etb.aHT().startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.etd.setUseCache(true);
        this.etd.setRequestM(null);
        this.etb.aKF().reset(false);
        this.etd.setStart(0);
        this.etd.setLen(50);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAh() {
        if (aEj()) {
            this.etb.aAh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aEj() {
        return 50 == this.etd.getLen();
    }

    public void initData(Bundle bundle) {
        this.etd = new MembersModel(this);
        this.etd.setUniqueId(getUniqueId());
        if (bundle == null) {
            this.etd.initWithIntent(getIntent());
        } else {
            this.etd.initWithBundle(bundle);
        }
        registerListener(this.ejL);
        registerListener(this.ete);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserData.Permission permission) {
        if (permission != null) {
            boolean isController = permission.isController();
            this.etd.setController(isController);
            this.etb.setController(isController);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKu() {
        this.etb.aKE().e(getPageContext());
        this.etb.aKE().setTextOption(NoDataViewFactory.d.du(d.j.members_no_person));
        this.etb.aKE().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.etb.onChangeSkinType(i);
        this.eta.dC(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.etb.aKH()) {
            aKv();
        } else if (view == this.etb.aKB()) {
            aKx();
            this.etb.hC(false);
        } else if (view == this.etb.aKC()) {
            aKw();
            this.etb.hC(true);
        } else if (view == this.etb.aKD()) {
            aKy();
        }
    }

    private void aKv() {
        DialogUtil.orderMembers(getPageContext().getPageActivity(), new b.InterfaceC0101b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.8
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
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
                MembersActivity.this.etd.setOrderType(i2);
                MembersActivity.this.showToast(MembersActivity.this.getResources().getStringArray(d.b.members_order_by_short)[i]);
                MembersActivity.this.reset();
                MembersActivity.this.etb.aHT().startPullRefresh();
            }
        });
    }

    private void aKw() {
        this.etb.og(0);
        this.etb.hB(false);
        this.etb.aKF().hz(false);
        this.etb.aKF().aKz();
        this.etb.aKG();
    }

    private void aKx() {
        this.etb.og(0);
        this.etb.hB(true);
        this.etb.aKF().hz(true);
        this.etb.aKG();
    }

    private void aKy() {
        Set<Long> aKA = this.etb.aKF().aKA();
        if (aKA.size() > 0) {
            final ArrayList arrayList = new ArrayList();
            arrayList.addAll(aKA);
            DialogUtil.removeMembersDialog(getPageContext().getPageActivity(), new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    MembersActivity.this.etb.hB(false);
                    MembersActivity.this.etb.aKF().hz(false);
                    MembersActivity.this.etb.aKG();
                    MembersActivity.this.b(MembersActivity.this.etd.getGroupId(), arrayList);
                    MembersActivity.this.etb.hC(true);
                }
            }, new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
        }
    }

    private void Tn() {
        if (this.etb.aKF().ajL()) {
            this.etd.sendMessage(this.etd.getGroupId(), this.etd.getStart(), this.etd.getLen(), this.etd.getOrderType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        Tn();
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (this.etb == null || this.etb.aHT() == null) {
            return null;
        }
        return this.etb.aHT().getPreLoadHandle();
    }
}
