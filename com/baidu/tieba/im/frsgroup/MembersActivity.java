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
import com.baidu.tbadk.core.view.e;
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
    private com.baidu.tbadk.core.view.f dYS;
    private m dYT;
    private MembersModel dYU;
    private final com.baidu.adp.framework.listener.c dPI = new com.baidu.adp.framework.listener.c(103005) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            RequestMembersMessage requestMembersMessage;
            l aEe = MembersActivity.this.dYT.aEe();
            MembersActivity.this.auL();
            if (socketResponsedMessage == null || !(socketResponsedMessage instanceof ResponseMembersMessage)) {
                MembersActivity.this.showToast(d.k.neterror);
                return;
            }
            ResponseMembersMessage responseMembersMessage = (ResponseMembersMessage) socketResponsedMessage;
            Message<?> orginalMessage = responseMembersMessage.getOrginalMessage();
            if (orginalMessage == null || !(orginalMessage instanceof RequestMembersMessage)) {
                requestMembersMessage = null;
            } else {
                requestMembersMessage = (RequestMembersMessage) orginalMessage;
            }
            MembersActivity.this.dYU.setRequestM(requestMembersMessage);
            if (responseMembersMessage.getError() != 0) {
                if (responseMembersMessage.getError() > 0) {
                    MembersActivity.this.showToast(StringUtils.isNull(responseMembersMessage.getErrorString()) ? MembersActivity.this.getResources().getString(d.k.neterror) : responseMembersMessage.getErrorString());
                    return;
                } else {
                    MembersActivity.this.showToast(d.k.neterror);
                    return;
                }
            }
            MembersData membersData = responseMembersMessage.getMembersData();
            List<UserData> users = membersData.getUsers();
            if (users != null) {
                if (MembersActivity.this.axL()) {
                    MembersActivity.this.a(membersData.getPermission());
                }
                if (MembersActivity.this.axL()) {
                    aEe.reset(true);
                }
                if (users.size() != MembersActivity.this.dYU.getLen()) {
                    aEe.hd(false);
                    aEe.he(false);
                    if (MembersActivity.this.axL() && users.size() == 0) {
                        MembersActivity.this.aDT();
                        return;
                    }
                } else {
                    aEe.he(true);
                }
                MembersActivity.this.dYU.addStart(users.size());
                MembersActivity.this.dYU.setLen(20);
                aEe.cb(users);
                aEe.notifyDataSetChanged();
            }
        }
    };
    private final com.baidu.adp.framework.listener.c dYV = new com.baidu.adp.framework.listener.c(103112) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            MembersActivity.this.dYT.hg(false);
            if (socketResponsedMessage == null || !(socketResponsedMessage instanceof ResponseRemoveMembersMessage)) {
                MembersActivity.this.showToast(d.k.neterror);
                return;
            }
            ResponseRemoveMembersMessage responseRemoveMembersMessage = (ResponseRemoveMembersMessage) socketResponsedMessage;
            if (responseRemoveMembersMessage.getError() != 0) {
                if (responseRemoveMembersMessage.getError() > 0) {
                    MembersActivity.this.showToast(StringUtils.isNull(responseRemoveMembersMessage.getErrorString()) ? MembersActivity.this.getResources().getString(d.k.neterror) : responseRemoveMembersMessage.getErrorString());
                    return;
                } else {
                    MembersActivity.this.showToast(d.k.neterror);
                    return;
                }
            }
            MembersActivity.this.showToast(d.k.delete_success);
            MembersActivity.this.dYT.aEe().cc(MembersActivity.this.dYU.getUserIds());
            MembersActivity.this.dYT.aEf();
            MembersActivity.this.dYT.aEe().aDY();
        }
    };
    private final CustomMessageListener dYW = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.2
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
                        MembersActivity.this.dYT.aBt().startPullRefresh();
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
        registerListener(2001128, this.dYW);
        registerListener(2001126, this.dYW);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.dYU.saveInstance(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.dYT.aEd().onActivityStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public MembersModel aDS() {
        return this.dYU;
    }

    private void initUI() {
        this.dYT = new m(this);
        final BdListView aBt = this.dYT.aBt();
        this.dYS = new com.baidu.tbadk.core.view.f(getPageContext());
        this.dYS.a(new e.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.1
            @Override // com.baidu.tbadk.core.view.e.b
            public void aO(boolean z) {
                if (!MembersActivity.this.dYT.aEe().aBe()) {
                    if (!MembersActivity.this.axL()) {
                        MembersActivity.this.reset();
                    }
                    MembersActivity.this.dYU.sendMessage(MembersActivity.this.dYU.getGroupId(), MembersActivity.this.dYU.getStart(), MembersActivity.this.dYU.getLen(), MembersActivity.this.dYU.getOrderType());
                    return;
                }
                aBt.completePullRefreshPostDelayed(2000L);
            }
        });
        aBt.setPullRefresh(this.dYS);
        aBt.setOnSrollToBottomListener(this);
        aBt.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                l aEe = MembersActivity.this.dYT.aEe();
                UserData userData = (UserData) aEe.getItem(i);
                if (userData != null) {
                    if (aEe.aBe()) {
                        if (!userData.getPermission().isController()) {
                            aEe.f(Long.valueOf(userData.getUserIdLong()));
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(MembersActivity.this.getPageContext().getContext(), userData.getUserId() + "", userData.getUserName())));
                }
            }
        });
        aBt.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.4
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view2, int i, long j) {
                if (!MembersActivity.this.dYT.aEe().aBe() && MembersActivity.this.dYU.isController()) {
                    UserData userData = (UserData) MembersActivity.this.dYT.aEe().getItem(i);
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
                                MembersActivity.this.b(MembersActivity.this.dYU.getGroupId(), arrayList);
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
        this.dYT.aEa().setOnClickListener(this);
        this.dYT.aEb().setOnClickListener(this);
        this.dYT.aEc().setOnClickListener(this);
        this.dYT.setController(false);
        this.dYT.aEe().a(new l.a() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.5
            @Override // com.baidu.tieba.im.frsgroup.l.a
            public void nz(int i) {
                MembersActivity.this.dYT.nA(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, List<Long> list) {
        if (list != null && list.size() != 0) {
            this.dYT.hg(true);
            this.dYU.setUserIds(list);
            this.dYU.sendRemoveMessage(j, ca(list));
        }
    }

    private String ca(List<Long> list) {
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
        this.dYU.setUseCache(false);
        this.dYU.setRequestM(null);
        this.dYT.aEe().reset(true);
        this.dYU.setStart(0);
        this.dYU.setLen(50);
        this.dYT.aBt().startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.dYU.setUseCache(true);
        this.dYU.setRequestM(null);
        this.dYT.aEe().reset(false);
        this.dYU.setStart(0);
        this.dYU.setLen(50);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auL() {
        if (axL()) {
            this.dYT.auL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean axL() {
        return 50 == this.dYU.getLen();
    }

    public void initData(Bundle bundle) {
        this.dYU = new MembersModel(this);
        this.dYU.setUniqueId(getUniqueId());
        if (bundle == null) {
            this.dYU.initWithIntent(getIntent());
        } else {
            this.dYU.initWithBundle(bundle);
        }
        registerListener(this.dPI);
        registerListener(this.dYV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserData.Permission permission) {
        if (permission != null) {
            boolean isController = permission.isController();
            this.dYU.setController(isController);
            this.dYT.setController(isController);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDT() {
        this.dYT.aEd().e(getPageContext());
        this.dYT.aEd().setTextOption(NoDataViewFactory.d.m16do(d.k.members_no_person));
        this.dYT.aEd().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.dYT.onChangeSkinType(i);
        this.dYS.dv(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.dYT.aEg()) {
            aDU();
        } else if (view2 == this.dYT.aEa()) {
            aDW();
            this.dYT.hi(false);
        } else if (view2 == this.dYT.aEb()) {
            aDV();
            this.dYT.hi(true);
        } else if (view2 == this.dYT.aEc()) {
            aDX();
        }
    }

    private void aDU() {
        DialogUtil.orderMembers(getPageContext().getPageActivity(), new b.InterfaceC0086b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.8
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
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
                MembersActivity.this.dYU.setOrderType(i2);
                MembersActivity.this.showToast(MembersActivity.this.getResources().getStringArray(d.b.members_order_by_short)[i]);
                MembersActivity.this.reset();
                MembersActivity.this.dYT.aBt().startPullRefresh();
            }
        });
    }

    private void aDV() {
        this.dYT.nA(0);
        this.dYT.hh(false);
        this.dYT.aEe().hf(false);
        this.dYT.aEe().aDY();
        this.dYT.aEf();
    }

    private void aDW() {
        this.dYT.nA(0);
        this.dYT.hh(true);
        this.dYT.aEe().hf(true);
        this.dYT.aEf();
    }

    private void aDX() {
        Set<Long> aDZ = this.dYT.aEe().aDZ();
        if (aDZ.size() > 0) {
            final ArrayList arrayList = new ArrayList();
            arrayList.addAll(aDZ);
            DialogUtil.removeMembersDialog(getPageContext().getPageActivity(), new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    MembersActivity.this.dYT.hh(false);
                    MembersActivity.this.dYT.aEe().hf(false);
                    MembersActivity.this.dYT.aEf();
                    MembersActivity.this.b(MembersActivity.this.dYU.getGroupId(), arrayList);
                    MembersActivity.this.dYT.hi(true);
                }
            }, new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
        }
    }

    private void Po() {
        if (this.dYT.aEe().agl()) {
            this.dYU.sendMessage(this.dYU.getGroupId(), this.dYU.getStart(), this.dYU.getLen(), this.dYU.getOrderType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        Po();
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (this.dYT == null || this.dYT.aBt() == null) {
            return null;
        }
        return this.dYT.aBt().getPreLoadHandle();
    }
}
