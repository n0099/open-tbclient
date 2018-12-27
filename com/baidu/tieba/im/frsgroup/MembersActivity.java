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
    private com.baidu.tbadk.core.view.k eSZ;
    private m eTa;
    private MembersModel eTb;
    private final com.baidu.adp.framework.listener.c eJR = new com.baidu.adp.framework.listener.c(103005) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            RequestMembersMessage requestMembersMessage;
            l aSi = MembersActivity.this.eTa.aSi();
            MembersActivity.this.aHD();
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
            MembersActivity.this.eTb.setRequestM(requestMembersMessage);
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
                if (MembersActivity.this.aLQ()) {
                    MembersActivity.this.a(membersData.getPermission());
                }
                if (MembersActivity.this.aLQ()) {
                    aSi.reset(true);
                }
                if (users.size() != MembersActivity.this.eTb.getLen()) {
                    aSi.iC(false);
                    aSi.iD(false);
                    if (MembersActivity.this.aLQ() && users.size() == 0) {
                        MembersActivity.this.aRX();
                        return;
                    }
                } else {
                    aSi.iD(true);
                }
                MembersActivity.this.eTb.addStart(users.size());
                MembersActivity.this.eTb.setLen(20);
                aSi.cG(users);
                aSi.notifyDataSetChanged();
            }
        }
    };
    private final com.baidu.adp.framework.listener.c eTc = new com.baidu.adp.framework.listener.c(103112) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            MembersActivity.this.eTa.iF(false);
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
            MembersActivity.this.eTa.aSi().cH(MembersActivity.this.eTb.getUserIds());
            MembersActivity.this.eTa.aSj();
            MembersActivity.this.eTa.aSi().aSc();
        }
    };
    private final CustomMessageListener eTd = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.2
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
                        MembersActivity.this.eTa.aPx().startPullRefresh();
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
        registerListener(2001128, this.eTd);
        registerListener(2001126, this.eTd);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.eTb.saveInstance(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.eTa.aSh().onActivityStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public MembersModel aRW() {
        return this.eTb;
    }

    private void initUI() {
        this.eTa = new m(this);
        final BdListView aPx = this.eTa.aPx();
        this.eSZ = new com.baidu.tbadk.core.view.k(getPageContext());
        this.eSZ.a(new j.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.1
            @Override // com.baidu.tbadk.core.view.j.b
            public void bH(boolean z) {
                if (!MembersActivity.this.eTa.aSi().aPk()) {
                    if (!MembersActivity.this.aLQ()) {
                        MembersActivity.this.reset();
                    }
                    MembersActivity.this.eTb.sendMessage(MembersActivity.this.eTb.getGroupId(), MembersActivity.this.eTb.getStart(), MembersActivity.this.eTb.getLen(), MembersActivity.this.eTb.getOrderType());
                    return;
                }
                aPx.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
            }
        });
        aPx.setPullRefresh(this.eSZ);
        aPx.setOnSrollToBottomListener(this);
        aPx.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                l aSi = MembersActivity.this.eTa.aSi();
                UserData userData = (UserData) aSi.getItem(i);
                if (userData != null) {
                    if (aSi.aPk()) {
                        if (!userData.getPermission().isController()) {
                            aSi.h(Long.valueOf(userData.getUserIdLong()));
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(MembersActivity.this.getPageContext().getContext(), userData.getUserId() + "", userData.getUserName())));
                }
            }
        });
        aPx.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.4
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!MembersActivity.this.eTa.aSi().aPk() && MembersActivity.this.eTb.isController()) {
                    UserData userData = (UserData) MembersActivity.this.eTa.aSi().getItem(i);
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
                                MembersActivity.this.b(MembersActivity.this.eTb.getGroupId(), arrayList);
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
        this.eTa.aSe().setOnClickListener(this);
        this.eTa.aSf().setOnClickListener(this);
        this.eTa.aSg().setOnClickListener(this);
        this.eTa.setController(false);
        this.eTa.aSi().a(new l.a() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.5
            @Override // com.baidu.tieba.im.frsgroup.l.a
            public void qh(int i) {
                MembersActivity.this.eTa.qi(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, List<Long> list) {
        if (list != null && list.size() != 0) {
            this.eTa.iF(true);
            this.eTb.setUserIds(list);
            this.eTb.sendRemoveMessage(j, cF(list));
        }
    }

    private String cF(List<Long> list) {
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
        this.eTb.setUseCache(false);
        this.eTb.setRequestM(null);
        this.eTa.aSi().reset(true);
        this.eTb.setStart(0);
        this.eTb.setLen(50);
        this.eTa.aPx().startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.eTb.setUseCache(true);
        this.eTb.setRequestM(null);
        this.eTa.aSi().reset(false);
        this.eTb.setStart(0);
        this.eTb.setLen(50);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHD() {
        if (aLQ()) {
            this.eTa.aHD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aLQ() {
        return 50 == this.eTb.getLen();
    }

    public void initData(Bundle bundle) {
        this.eTb = new MembersModel(this);
        this.eTb.setUniqueId(getUniqueId());
        if (bundle == null) {
            this.eTb.initWithIntent(getIntent());
        } else {
            this.eTb.initWithBundle(bundle);
        }
        registerListener(this.eJR);
        registerListener(this.eTc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserData.Permission permission) {
        if (permission != null) {
            boolean isController = permission.isController();
            this.eTb.setController(isController);
            this.eTa.setController(isController);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRX() {
        this.eTa.aSh().e(getPageContext());
        this.eTa.aSh().setTextOption(NoDataViewFactory.d.eq(e.j.members_no_person));
        this.eTa.aSh().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.eTa.onChangeSkinType(i);
        this.eSZ.ey(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eTa.aSk()) {
            aRY();
        } else if (view == this.eTa.aSe()) {
            aSa();
            this.eTa.iH(false);
        } else if (view == this.eTa.aSf()) {
            aRZ();
            this.eTa.iH(true);
        } else if (view == this.eTa.aSg()) {
            aSb();
        }
    }

    private void aRY() {
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
                MembersActivity.this.eTb.setOrderType(i2);
                MembersActivity.this.showToast(MembersActivity.this.getResources().getStringArray(e.b.members_order_by_short)[i]);
                MembersActivity.this.reset();
                MembersActivity.this.eTa.aPx().startPullRefresh();
            }
        });
    }

    private void aRZ() {
        this.eTa.qi(0);
        this.eTa.iG(false);
        this.eTa.aSi().iE(false);
        this.eTa.aSi().aSc();
        this.eTa.aSj();
    }

    private void aSa() {
        this.eTa.qi(0);
        this.eTa.iG(true);
        this.eTa.aSi().iE(true);
        this.eTa.aSj();
    }

    private void aSb() {
        Set<Long> aSd = this.eTa.aSi().aSd();
        if (aSd.size() > 0) {
            final ArrayList arrayList = new ArrayList();
            arrayList.addAll(aSd);
            DialogUtil.removeMembersDialog(getPageContext().getPageActivity(), new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    MembersActivity.this.eTa.iG(false);
                    MembersActivity.this.eTa.aSi().iE(false);
                    MembersActivity.this.eTa.aSj();
                    MembersActivity.this.b(MembersActivity.this.eTb.getGroupId(), arrayList);
                    MembersActivity.this.eTa.iH(true);
                }
            }, new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
        }
    }

    private void aad() {
        if (this.eTa.aSi().arf()) {
            this.eTb.sendMessage(this.eTb.getGroupId(), this.eTb.getStart(), this.eTb.getLen(), this.eTb.getOrderType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        aad();
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (this.eTa == null || this.eTa.aPx() == null) {
            return null;
        }
        return this.eTa.aPx().getPreLoadHandle();
    }
}
