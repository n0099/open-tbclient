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
    private com.baidu.tbadk.core.view.f dYV;
    private m dYW;
    private MembersModel dYX;
    private final com.baidu.adp.framework.listener.c dPL = new com.baidu.adp.framework.listener.c(103005) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            RequestMembersMessage requestMembersMessage;
            l aEe = MembersActivity.this.dYW.aEe();
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
            MembersActivity.this.dYX.setRequestM(requestMembersMessage);
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
                if (users.size() != MembersActivity.this.dYX.getLen()) {
                    aEe.hd(false);
                    aEe.he(false);
                    if (MembersActivity.this.axL() && users.size() == 0) {
                        MembersActivity.this.aDT();
                        return;
                    }
                } else {
                    aEe.he(true);
                }
                MembersActivity.this.dYX.addStart(users.size());
                MembersActivity.this.dYX.setLen(20);
                aEe.cb(users);
                aEe.notifyDataSetChanged();
            }
        }
    };
    private final com.baidu.adp.framework.listener.c dYY = new com.baidu.adp.framework.listener.c(103112) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            MembersActivity.this.dYW.hg(false);
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
            MembersActivity.this.dYW.aEe().cc(MembersActivity.this.dYX.getUserIds());
            MembersActivity.this.dYW.aEf();
            MembersActivity.this.dYW.aEe().aDY();
        }
    };
    private final CustomMessageListener dYZ = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.2
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
                        MembersActivity.this.dYW.aBt().startPullRefresh();
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
        registerListener(2001128, this.dYZ);
        registerListener(2001126, this.dYZ);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.dYX.saveInstance(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.dYW.aEd().onActivityStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public MembersModel aDS() {
        return this.dYX;
    }

    private void initUI() {
        this.dYW = new m(this);
        final BdListView aBt = this.dYW.aBt();
        this.dYV = new com.baidu.tbadk.core.view.f(getPageContext());
        this.dYV.a(new e.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.1
            @Override // com.baidu.tbadk.core.view.e.b
            public void aO(boolean z) {
                if (!MembersActivity.this.dYW.aEe().aBe()) {
                    if (!MembersActivity.this.axL()) {
                        MembersActivity.this.reset();
                    }
                    MembersActivity.this.dYX.sendMessage(MembersActivity.this.dYX.getGroupId(), MembersActivity.this.dYX.getStart(), MembersActivity.this.dYX.getLen(), MembersActivity.this.dYX.getOrderType());
                    return;
                }
                aBt.completePullRefreshPostDelayed(2000L);
            }
        });
        aBt.setPullRefresh(this.dYV);
        aBt.setOnSrollToBottomListener(this);
        aBt.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                l aEe = MembersActivity.this.dYW.aEe();
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
                if (!MembersActivity.this.dYW.aEe().aBe() && MembersActivity.this.dYX.isController()) {
                    UserData userData = (UserData) MembersActivity.this.dYW.aEe().getItem(i);
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
                                MembersActivity.this.b(MembersActivity.this.dYX.getGroupId(), arrayList);
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
        this.dYW.aEa().setOnClickListener(this);
        this.dYW.aEb().setOnClickListener(this);
        this.dYW.aEc().setOnClickListener(this);
        this.dYW.setController(false);
        this.dYW.aEe().a(new l.a() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.5
            @Override // com.baidu.tieba.im.frsgroup.l.a
            public void nA(int i) {
                MembersActivity.this.dYW.nB(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, List<Long> list) {
        if (list != null && list.size() != 0) {
            this.dYW.hg(true);
            this.dYX.setUserIds(list);
            this.dYX.sendRemoveMessage(j, ca(list));
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
        this.dYX.setUseCache(false);
        this.dYX.setRequestM(null);
        this.dYW.aEe().reset(true);
        this.dYX.setStart(0);
        this.dYX.setLen(50);
        this.dYW.aBt().startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.dYX.setUseCache(true);
        this.dYX.setRequestM(null);
        this.dYW.aEe().reset(false);
        this.dYX.setStart(0);
        this.dYX.setLen(50);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auL() {
        if (axL()) {
            this.dYW.auL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean axL() {
        return 50 == this.dYX.getLen();
    }

    public void initData(Bundle bundle) {
        this.dYX = new MembersModel(this);
        this.dYX.setUniqueId(getUniqueId());
        if (bundle == null) {
            this.dYX.initWithIntent(getIntent());
        } else {
            this.dYX.initWithBundle(bundle);
        }
        registerListener(this.dPL);
        registerListener(this.dYY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserData.Permission permission) {
        if (permission != null) {
            boolean isController = permission.isController();
            this.dYX.setController(isController);
            this.dYW.setController(isController);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDT() {
        this.dYW.aEd().e(getPageContext());
        this.dYW.aEd().setTextOption(NoDataViewFactory.d.dp(d.k.members_no_person));
        this.dYW.aEd().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.dYW.onChangeSkinType(i);
        this.dYV.dw(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.dYW.aEg()) {
            aDU();
        } else if (view2 == this.dYW.aEa()) {
            aDW();
            this.dYW.hi(false);
        } else if (view2 == this.dYW.aEb()) {
            aDV();
            this.dYW.hi(true);
        } else if (view2 == this.dYW.aEc()) {
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
                MembersActivity.this.dYX.setOrderType(i2);
                MembersActivity.this.showToast(MembersActivity.this.getResources().getStringArray(d.b.members_order_by_short)[i]);
                MembersActivity.this.reset();
                MembersActivity.this.dYW.aBt().startPullRefresh();
            }
        });
    }

    private void aDV() {
        this.dYW.nB(0);
        this.dYW.hh(false);
        this.dYW.aEe().hf(false);
        this.dYW.aEe().aDY();
        this.dYW.aEf();
    }

    private void aDW() {
        this.dYW.nB(0);
        this.dYW.hh(true);
        this.dYW.aEe().hf(true);
        this.dYW.aEf();
    }

    private void aDX() {
        Set<Long> aDZ = this.dYW.aEe().aDZ();
        if (aDZ.size() > 0) {
            final ArrayList arrayList = new ArrayList();
            arrayList.addAll(aDZ);
            DialogUtil.removeMembersDialog(getPageContext().getPageActivity(), new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    MembersActivity.this.dYW.hh(false);
                    MembersActivity.this.dYW.aEe().hf(false);
                    MembersActivity.this.dYW.aEf();
                    MembersActivity.this.b(MembersActivity.this.dYX.getGroupId(), arrayList);
                    MembersActivity.this.dYW.hi(true);
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
        if (this.dYW.aEe().agl()) {
            this.dYX.sendMessage(this.dYX.getGroupId(), this.dYX.getStart(), this.dYX.getLen(), this.dYX.getOrderType());
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
        if (this.dYW == null || this.dYW.aBt() == null) {
            return null;
        }
        return this.dYW.aBt().getPreLoadHandle();
    }
}
