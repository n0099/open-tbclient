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
import com.baidu.tieba.f;
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
    private com.baidu.tbadk.core.view.h esW;
    private m esX;
    private MembersModel esY;
    private final com.baidu.adp.framework.listener.c ejH = new com.baidu.adp.framework.listener.c(103005) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            RequestMembersMessage requestMembersMessage;
            l aKC = MembersActivity.this.esX.aKC();
            MembersActivity.this.aAe();
            if (socketResponsedMessage == null || !(socketResponsedMessage instanceof ResponseMembersMessage)) {
                MembersActivity.this.showToast(f.j.neterror);
                return;
            }
            ResponseMembersMessage responseMembersMessage = (ResponseMembersMessage) socketResponsedMessage;
            Message<?> orginalMessage = responseMembersMessage.getOrginalMessage();
            if (orginalMessage == null || !(orginalMessage instanceof RequestMembersMessage)) {
                requestMembersMessage = null;
            } else {
                requestMembersMessage = (RequestMembersMessage) orginalMessage;
            }
            MembersActivity.this.esY.setRequestM(requestMembersMessage);
            if (responseMembersMessage.getError() != 0) {
                if (responseMembersMessage.getError() > 0) {
                    MembersActivity.this.showToast(StringUtils.isNull(responseMembersMessage.getErrorString()) ? MembersActivity.this.getResources().getString(f.j.neterror) : responseMembersMessage.getErrorString());
                    return;
                } else {
                    MembersActivity.this.showToast(f.j.neterror);
                    return;
                }
            }
            MembersData membersData = responseMembersMessage.getMembersData();
            List<UserData> users = membersData.getUsers();
            if (users != null) {
                if (MembersActivity.this.aEg()) {
                    MembersActivity.this.a(membersData.getPermission());
                }
                if (MembersActivity.this.aEg()) {
                    aKC.reset(true);
                }
                if (users.size() != MembersActivity.this.esY.getLen()) {
                    aKC.hx(false);
                    aKC.hy(false);
                    if (MembersActivity.this.aEg() && users.size() == 0) {
                        MembersActivity.this.aKr();
                        return;
                    }
                } else {
                    aKC.hy(true);
                }
                MembersActivity.this.esY.addStart(users.size());
                MembersActivity.this.esY.setLen(20);
                aKC.cn(users);
                aKC.notifyDataSetChanged();
            }
        }
    };
    private final com.baidu.adp.framework.listener.c esZ = new com.baidu.adp.framework.listener.c(103112) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            MembersActivity.this.esX.hA(false);
            if (socketResponsedMessage == null || !(socketResponsedMessage instanceof ResponseRemoveMembersMessage)) {
                MembersActivity.this.showToast(f.j.neterror);
                return;
            }
            ResponseRemoveMembersMessage responseRemoveMembersMessage = (ResponseRemoveMembersMessage) socketResponsedMessage;
            if (responseRemoveMembersMessage.getError() != 0) {
                if (responseRemoveMembersMessage.getError() > 0) {
                    MembersActivity.this.showToast(StringUtils.isNull(responseRemoveMembersMessage.getErrorString()) ? MembersActivity.this.getResources().getString(f.j.neterror) : responseRemoveMembersMessage.getErrorString());
                    return;
                } else {
                    MembersActivity.this.showToast(f.j.neterror);
                    return;
                }
            }
            MembersActivity.this.showToast(f.j.delete_success);
            MembersActivity.this.esX.aKC().co(MembersActivity.this.esY.getUserIds());
            MembersActivity.this.esX.aKD();
            MembersActivity.this.esX.aKC().aKw();
        }
    };
    private final CustomMessageListener eta = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.2
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
                        MembersActivity.this.esX.aHQ().startPullRefresh();
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
        registerListener(2001128, this.eta);
        registerListener(2001126, this.eta);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.esY.saveInstance(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.esX.aKB().onActivityStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public MembersModel aKq() {
        return this.esY;
    }

    private void initUI() {
        this.esX = new m(this);
        final BdListView aHQ = this.esX.aHQ();
        this.esW = new com.baidu.tbadk.core.view.h(getPageContext());
        this.esW.a(new g.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.1
            @Override // com.baidu.tbadk.core.view.g.b
            public void aT(boolean z) {
                if (!MembersActivity.this.esX.aKC().aHC()) {
                    if (!MembersActivity.this.aEg()) {
                        MembersActivity.this.reset();
                    }
                    MembersActivity.this.esY.sendMessage(MembersActivity.this.esY.getGroupId(), MembersActivity.this.esY.getStart(), MembersActivity.this.esY.getLen(), MembersActivity.this.esY.getOrderType());
                    return;
                }
                aHQ.completePullRefreshPostDelayed(2000L);
            }
        });
        aHQ.setPullRefresh(this.esW);
        aHQ.setOnSrollToBottomListener(this);
        aHQ.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                l aKC = MembersActivity.this.esX.aKC();
                UserData userData = (UserData) aKC.getItem(i);
                if (userData != null) {
                    if (aKC.aHC()) {
                        if (!userData.getPermission().isController()) {
                            aKC.f(Long.valueOf(userData.getUserIdLong()));
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(MembersActivity.this.getPageContext().getContext(), userData.getUserId() + "", userData.getUserName())));
                }
            }
        });
        aHQ.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.4
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!MembersActivity.this.esX.aKC().aHC() && MembersActivity.this.esY.isController()) {
                    UserData userData = (UserData) MembersActivity.this.esX.aKC().getItem(i);
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
                                MembersActivity.this.b(MembersActivity.this.esY.getGroupId(), arrayList);
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
        this.esX.aKy().setOnClickListener(this);
        this.esX.aKz().setOnClickListener(this);
        this.esX.aKA().setOnClickListener(this);
        this.esX.setController(false);
        this.esX.aKC().a(new l.a() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.5
            @Override // com.baidu.tieba.im.frsgroup.l.a
            public void of(int i) {
                MembersActivity.this.esX.og(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, List<Long> list) {
        if (list != null && list.size() != 0) {
            this.esX.hA(true);
            this.esY.setUserIds(list);
            this.esY.sendRemoveMessage(j, cm(list));
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
        this.esY.setUseCache(false);
        this.esY.setRequestM(null);
        this.esX.aKC().reset(true);
        this.esY.setStart(0);
        this.esY.setLen(50);
        this.esX.aHQ().startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.esY.setUseCache(true);
        this.esY.setRequestM(null);
        this.esX.aKC().reset(false);
        this.esY.setStart(0);
        this.esY.setLen(50);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAe() {
        if (aEg()) {
            this.esX.aAe();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aEg() {
        return 50 == this.esY.getLen();
    }

    public void initData(Bundle bundle) {
        this.esY = new MembersModel(this);
        this.esY.setUniqueId(getUniqueId());
        if (bundle == null) {
            this.esY.initWithIntent(getIntent());
        } else {
            this.esY.initWithBundle(bundle);
        }
        registerListener(this.ejH);
        registerListener(this.esZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserData.Permission permission) {
        if (permission != null) {
            boolean isController = permission.isController();
            this.esY.setController(isController);
            this.esX.setController(isController);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKr() {
        this.esX.aKB().e(getPageContext());
        this.esX.aKB().setTextOption(NoDataViewFactory.d.dt(f.j.members_no_person));
        this.esX.aKB().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.esX.onChangeSkinType(i);
        this.esW.dB(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.esX.aKE()) {
            aKs();
        } else if (view == this.esX.aKy()) {
            aKu();
            this.esX.hC(false);
        } else if (view == this.esX.aKz()) {
            aKt();
            this.esX.hC(true);
        } else if (view == this.esX.aKA()) {
            aKv();
        }
    }

    private void aKs() {
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
                MembersActivity.this.esY.setOrderType(i2);
                MembersActivity.this.showToast(MembersActivity.this.getResources().getStringArray(f.b.members_order_by_short)[i]);
                MembersActivity.this.reset();
                MembersActivity.this.esX.aHQ().startPullRefresh();
            }
        });
    }

    private void aKt() {
        this.esX.og(0);
        this.esX.hB(false);
        this.esX.aKC().hz(false);
        this.esX.aKC().aKw();
        this.esX.aKD();
    }

    private void aKu() {
        this.esX.og(0);
        this.esX.hB(true);
        this.esX.aKC().hz(true);
        this.esX.aKD();
    }

    private void aKv() {
        Set<Long> aKx = this.esX.aKC().aKx();
        if (aKx.size() > 0) {
            final ArrayList arrayList = new ArrayList();
            arrayList.addAll(aKx);
            DialogUtil.removeMembersDialog(getPageContext().getPageActivity(), new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    MembersActivity.this.esX.hB(false);
                    MembersActivity.this.esX.aKC().hz(false);
                    MembersActivity.this.esX.aKD();
                    MembersActivity.this.b(MembersActivity.this.esY.getGroupId(), arrayList);
                    MembersActivity.this.esX.hC(true);
                }
            }, new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
        }
    }

    private void Tq() {
        if (this.esX.aKC().ajO()) {
            this.esY.sendMessage(this.esY.getGroupId(), this.esY.getStart(), this.esY.getLen(), this.esY.getOrderType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        Tq();
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (this.esX == null || this.esX.aHQ() == null) {
            return null;
        }
        return this.esX.aHQ().getPreLoadHandle();
    }
}
