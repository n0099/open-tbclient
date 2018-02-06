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
import com.baidu.tbadk.core.view.j;
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
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
/* loaded from: classes3.dex */
public class MembersActivity extends BaseActivity<MembersActivity> implements View.OnClickListener, BdListView.e {
    private com.baidu.tbadk.core.view.k eEn;
    private m eEo;
    private MembersModel eEp;
    private final com.baidu.adp.framework.listener.c evb = new com.baidu.adp.framework.listener.c(103005) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            RequestMembersMessage requestMembersMessage;
            l aJh = MembersActivity.this.eEo.aJh();
            MembersActivity.this.azT();
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
            MembersActivity.this.eEp.setRequestM(requestMembersMessage);
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
                if (MembersActivity.this.aCN()) {
                    MembersActivity.this.a(membersData.getPermission());
                }
                if (MembersActivity.this.aCN()) {
                    aJh.reset(true);
                }
                if (users.size() != MembersActivity.this.eEp.getLen()) {
                    aJh.hy(false);
                    aJh.hz(false);
                    if (MembersActivity.this.aCN() && users.size() == 0) {
                        MembersActivity.this.aIW();
                        return;
                    }
                } else {
                    aJh.hz(true);
                }
                MembersActivity.this.eEp.addStart(users.size());
                MembersActivity.this.eEp.setLen(20);
                aJh.ci(users);
                aJh.notifyDataSetChanged();
            }
        }
    };
    private final com.baidu.adp.framework.listener.c eEq = new com.baidu.adp.framework.listener.c(103112) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            MembersActivity.this.eEo.hB(false);
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
            MembersActivity.this.eEo.aJh().cj(MembersActivity.this.eEp.getUserIds());
            MembersActivity.this.eEo.aJi();
            MembersActivity.this.eEo.aJh().aJb();
        }
    };
    private final CustomMessageListener eEr = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.2
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
                        MembersActivity.this.eEo.aGt().startPullRefresh();
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
        registerListener(2001128, this.eEr);
        registerListener(2001126, this.eEr);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.eEp.saveInstance(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.eEo.aJg().onActivityStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public MembersModel aIV() {
        return this.eEp;
    }

    private void initUI() {
        this.eEo = new m(this);
        final BdListView aGt = this.eEo.aGt();
        this.eEn = new com.baidu.tbadk.core.view.k(getPageContext());
        this.eEn.a(new j.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.1
            @Override // com.baidu.tbadk.core.view.j.b
            public void bw(boolean z) {
                if (!MembersActivity.this.eEo.aJh().aGe()) {
                    if (!MembersActivity.this.aCN()) {
                        MembersActivity.this.reset();
                    }
                    MembersActivity.this.eEp.sendMessage(MembersActivity.this.eEp.getGroupId(), MembersActivity.this.eEp.getStart(), MembersActivity.this.eEp.getLen(), MembersActivity.this.eEp.getOrderType());
                    return;
                }
                aGt.completePullRefreshPostDelayed(2000L);
            }
        });
        aGt.setPullRefresh(this.eEn);
        aGt.setOnSrollToBottomListener(this);
        aGt.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                l aJh = MembersActivity.this.eEo.aJh();
                UserData userData = (UserData) aJh.getItem(i);
                if (userData != null) {
                    if (aJh.aGe()) {
                        if (!userData.getPermission().isController()) {
                            aJh.f(Long.valueOf(userData.getUserIdLong()));
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(MembersActivity.this.getPageContext().getContext(), userData.getUserId() + "", userData.getUserName())));
                }
            }
        });
        aGt.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.4
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!MembersActivity.this.eEo.aJh().aGe() && MembersActivity.this.eEp.isController()) {
                    UserData userData = (UserData) MembersActivity.this.eEo.aJh().getItem(i);
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
                                MembersActivity.this.b(MembersActivity.this.eEp.getGroupId(), arrayList);
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
        this.eEo.aJd().setOnClickListener(this);
        this.eEo.aJe().setOnClickListener(this);
        this.eEo.aJf().setOnClickListener(this);
        this.eEo.setController(false);
        this.eEo.aJh().a(new l.a() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.5
            @Override // com.baidu.tieba.im.frsgroup.l.a
            public void qb(int i) {
                MembersActivity.this.eEo.qc(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, List<Long> list) {
        if (list != null && list.size() != 0) {
            this.eEo.hB(true);
            this.eEp.setUserIds(list);
            this.eEp.sendRemoveMessage(j, ch(list));
        }
    }

    private String ch(List<Long> list) {
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
        this.eEp.setUseCache(false);
        this.eEp.setRequestM(null);
        this.eEo.aJh().reset(true);
        this.eEp.setStart(0);
        this.eEp.setLen(50);
        this.eEo.aGt().startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.eEp.setUseCache(true);
        this.eEp.setRequestM(null);
        this.eEo.aJh().reset(false);
        this.eEp.setStart(0);
        this.eEp.setLen(50);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azT() {
        if (aCN()) {
            this.eEo.azT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aCN() {
        return 50 == this.eEp.getLen();
    }

    public void initData(Bundle bundle) {
        this.eEp = new MembersModel(this);
        this.eEp.setUniqueId(getUniqueId());
        if (bundle == null) {
            this.eEp.initWithIntent(getIntent());
        } else {
            this.eEp.initWithBundle(bundle);
        }
        registerListener(this.evb);
        registerListener(this.eEq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserData.Permission permission) {
        if (permission != null) {
            boolean isController = permission.isController();
            this.eEp.setController(isController);
            this.eEo.setController(isController);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIW() {
        this.eEo.aJg().e(getPageContext());
        this.eEo.aJg().setTextOption(NoDataViewFactory.d.gp(d.j.members_no_person));
        this.eEo.aJg().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.eEo.onChangeSkinType(i);
        this.eEn.gx(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eEo.aJj()) {
            aIX();
        } else if (view == this.eEo.aJd()) {
            aIZ();
            this.eEo.hD(false);
        } else if (view == this.eEo.aJe()) {
            aIY();
            this.eEo.hD(true);
        } else if (view == this.eEo.aJf()) {
            aJa();
        }
    }

    private void aIX() {
        DialogUtil.orderMembers(getPageContext().getPageActivity(), new b.InterfaceC0096b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.8
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0096b
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
                MembersActivity.this.eEp.setOrderType(i2);
                MembersActivity.this.showToast(MembersActivity.this.getResources().getStringArray(d.b.members_order_by_short)[i]);
                MembersActivity.this.reset();
                MembersActivity.this.eEo.aGt().startPullRefresh();
            }
        });
    }

    private void aIY() {
        this.eEo.qc(0);
        this.eEo.hC(false);
        this.eEo.aJh().hA(false);
        this.eEo.aJh().aJb();
        this.eEo.aJi();
    }

    private void aIZ() {
        this.eEo.qc(0);
        this.eEo.hC(true);
        this.eEo.aJh().hA(true);
        this.eEo.aJi();
    }

    private void aJa() {
        Set<Long> aJc = this.eEo.aJh().aJc();
        if (aJc.size() > 0) {
            final ArrayList arrayList = new ArrayList();
            arrayList.addAll(aJc);
            DialogUtil.removeMembersDialog(getPageContext().getPageActivity(), new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    MembersActivity.this.eEo.hC(false);
                    MembersActivity.this.eEo.aJh().hA(false);
                    MembersActivity.this.eEo.aJi();
                    MembersActivity.this.b(MembersActivity.this.eEp.getGroupId(), arrayList);
                    MembersActivity.this.eEo.hD(true);
                }
            }, new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
        }
    }

    private void WO() {
        if (this.eEo.aJh().aml()) {
            this.eEp.sendMessage(this.eEp.getGroupId(), this.eEp.getStart(), this.eEp.getLen(), this.eEp.getOrderType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        WO();
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.l onGetPreLoadListView() {
        if (this.eEo == null || this.eEo.aGt() == null) {
            return null;
        }
        return this.eEo.aGt().getPreLoadHandle();
    }
}
