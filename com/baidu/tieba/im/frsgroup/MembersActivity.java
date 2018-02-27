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
    private com.baidu.tbadk.core.view.k eEb;
    private m eEc;
    private MembersModel eEd;
    private final com.baidu.adp.framework.listener.c euP = new com.baidu.adp.framework.listener.c(103005) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            RequestMembersMessage requestMembersMessage;
            l aJg = MembersActivity.this.eEc.aJg();
            MembersActivity.this.azS();
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
            MembersActivity.this.eEd.setRequestM(requestMembersMessage);
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
                if (MembersActivity.this.aCM()) {
                    MembersActivity.this.a(membersData.getPermission());
                }
                if (MembersActivity.this.aCM()) {
                    aJg.reset(true);
                }
                if (users.size() != MembersActivity.this.eEd.getLen()) {
                    aJg.hy(false);
                    aJg.hz(false);
                    if (MembersActivity.this.aCM() && users.size() == 0) {
                        MembersActivity.this.aIV();
                        return;
                    }
                } else {
                    aJg.hz(true);
                }
                MembersActivity.this.eEd.addStart(users.size());
                MembersActivity.this.eEd.setLen(20);
                aJg.ci(users);
                aJg.notifyDataSetChanged();
            }
        }
    };
    private final com.baidu.adp.framework.listener.c eEe = new com.baidu.adp.framework.listener.c(103112) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            MembersActivity.this.eEc.hB(false);
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
            MembersActivity.this.eEc.aJg().cj(MembersActivity.this.eEd.getUserIds());
            MembersActivity.this.eEc.aJh();
            MembersActivity.this.eEc.aJg().aJa();
        }
    };
    private final CustomMessageListener eEf = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.2
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
                        MembersActivity.this.eEc.aGs().startPullRefresh();
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
        registerListener(2001128, this.eEf);
        registerListener(2001126, this.eEf);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.eEd.saveInstance(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.eEc.aJf().onActivityStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public MembersModel aIU() {
        return this.eEd;
    }

    private void initUI() {
        this.eEc = new m(this);
        final BdListView aGs = this.eEc.aGs();
        this.eEb = new com.baidu.tbadk.core.view.k(getPageContext());
        this.eEb.a(new j.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.1
            @Override // com.baidu.tbadk.core.view.j.b
            public void bw(boolean z) {
                if (!MembersActivity.this.eEc.aJg().aGd()) {
                    if (!MembersActivity.this.aCM()) {
                        MembersActivity.this.reset();
                    }
                    MembersActivity.this.eEd.sendMessage(MembersActivity.this.eEd.getGroupId(), MembersActivity.this.eEd.getStart(), MembersActivity.this.eEd.getLen(), MembersActivity.this.eEd.getOrderType());
                    return;
                }
                aGs.completePullRefreshPostDelayed(2000L);
            }
        });
        aGs.setPullRefresh(this.eEb);
        aGs.setOnSrollToBottomListener(this);
        aGs.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                l aJg = MembersActivity.this.eEc.aJg();
                UserData userData = (UserData) aJg.getItem(i);
                if (userData != null) {
                    if (aJg.aGd()) {
                        if (!userData.getPermission().isController()) {
                            aJg.f(Long.valueOf(userData.getUserIdLong()));
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(MembersActivity.this.getPageContext().getContext(), userData.getUserId() + "", userData.getUserName())));
                }
            }
        });
        aGs.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.4
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!MembersActivity.this.eEc.aJg().aGd() && MembersActivity.this.eEd.isController()) {
                    UserData userData = (UserData) MembersActivity.this.eEc.aJg().getItem(i);
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
                                MembersActivity.this.b(MembersActivity.this.eEd.getGroupId(), arrayList);
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
        this.eEc.aJc().setOnClickListener(this);
        this.eEc.aJd().setOnClickListener(this);
        this.eEc.aJe().setOnClickListener(this);
        this.eEc.setController(false);
        this.eEc.aJg().a(new l.a() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.5
            @Override // com.baidu.tieba.im.frsgroup.l.a
            public void qb(int i) {
                MembersActivity.this.eEc.qc(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, List<Long> list) {
        if (list != null && list.size() != 0) {
            this.eEc.hB(true);
            this.eEd.setUserIds(list);
            this.eEd.sendRemoveMessage(j, ch(list));
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
        this.eEd.setUseCache(false);
        this.eEd.setRequestM(null);
        this.eEc.aJg().reset(true);
        this.eEd.setStart(0);
        this.eEd.setLen(50);
        this.eEc.aGs().startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.eEd.setUseCache(true);
        this.eEd.setRequestM(null);
        this.eEc.aJg().reset(false);
        this.eEd.setStart(0);
        this.eEd.setLen(50);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azS() {
        if (aCM()) {
            this.eEc.azS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aCM() {
        return 50 == this.eEd.getLen();
    }

    public void initData(Bundle bundle) {
        this.eEd = new MembersModel(this);
        this.eEd.setUniqueId(getUniqueId());
        if (bundle == null) {
            this.eEd.initWithIntent(getIntent());
        } else {
            this.eEd.initWithBundle(bundle);
        }
        registerListener(this.euP);
        registerListener(this.eEe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserData.Permission permission) {
        if (permission != null) {
            boolean isController = permission.isController();
            this.eEd.setController(isController);
            this.eEc.setController(isController);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIV() {
        this.eEc.aJf().e(getPageContext());
        this.eEc.aJf().setTextOption(NoDataViewFactory.d.gp(d.j.members_no_person));
        this.eEc.aJf().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.eEc.onChangeSkinType(i);
        this.eEb.gx(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eEc.aJi()) {
            aIW();
        } else if (view == this.eEc.aJc()) {
            aIY();
            this.eEc.hD(false);
        } else if (view == this.eEc.aJd()) {
            aIX();
            this.eEc.hD(true);
        } else if (view == this.eEc.aJe()) {
            aIZ();
        }
    }

    private void aIW() {
        DialogUtil.orderMembers(getPageContext().getPageActivity(), new b.InterfaceC0097b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.8
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0097b
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
                MembersActivity.this.eEd.setOrderType(i2);
                MembersActivity.this.showToast(MembersActivity.this.getResources().getStringArray(d.b.members_order_by_short)[i]);
                MembersActivity.this.reset();
                MembersActivity.this.eEc.aGs().startPullRefresh();
            }
        });
    }

    private void aIX() {
        this.eEc.qc(0);
        this.eEc.hC(false);
        this.eEc.aJg().hA(false);
        this.eEc.aJg().aJa();
        this.eEc.aJh();
    }

    private void aIY() {
        this.eEc.qc(0);
        this.eEc.hC(true);
        this.eEc.aJg().hA(true);
        this.eEc.aJh();
    }

    private void aIZ() {
        Set<Long> aJb = this.eEc.aJg().aJb();
        if (aJb.size() > 0) {
            final ArrayList arrayList = new ArrayList();
            arrayList.addAll(aJb);
            DialogUtil.removeMembersDialog(getPageContext().getPageActivity(), new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    MembersActivity.this.eEc.hC(false);
                    MembersActivity.this.eEc.aJg().hA(false);
                    MembersActivity.this.eEc.aJh();
                    MembersActivity.this.b(MembersActivity.this.eEd.getGroupId(), arrayList);
                    MembersActivity.this.eEc.hD(true);
                }
            }, new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
        }
    }

    private void WN() {
        if (this.eEc.aJg().amk()) {
            this.eEd.sendMessage(this.eEd.getGroupId(), this.eEd.getStart(), this.eEd.getLen(), this.eEd.getOrderType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        WN();
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.l onGetPreLoadListView() {
        if (this.eEc == null || this.eEc.aGs() == null) {
            return null;
        }
        return this.eEc.aGs().getPreLoadHandle();
    }
}
