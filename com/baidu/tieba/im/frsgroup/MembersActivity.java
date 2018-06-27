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
    private com.baidu.tbadk.core.view.h epi;
    private m epj;
    private MembersModel epk;
    private final com.baidu.adp.framework.listener.c efV = new com.baidu.adp.framework.listener.c(103005) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            RequestMembersMessage requestMembersMessage;
            l aJE = MembersActivity.this.epj.aJE();
            MembersActivity.this.azA();
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
            MembersActivity.this.epk.setRequestM(requestMembersMessage);
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
                if (MembersActivity.this.aDj()) {
                    MembersActivity.this.a(membersData.getPermission());
                }
                if (MembersActivity.this.aDj()) {
                    aJE.reset(true);
                }
                if (users.size() != MembersActivity.this.epk.getLen()) {
                    aJE.hu(false);
                    aJE.hv(false);
                    if (MembersActivity.this.aDj() && users.size() == 0) {
                        MembersActivity.this.aJt();
                        return;
                    }
                } else {
                    aJE.hv(true);
                }
                MembersActivity.this.epk.addStart(users.size());
                MembersActivity.this.epk.setLen(20);
                aJE.cn(users);
                aJE.notifyDataSetChanged();
            }
        }
    };
    private final com.baidu.adp.framework.listener.c epl = new com.baidu.adp.framework.listener.c(103112) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            MembersActivity.this.epj.hx(false);
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
            MembersActivity.this.epj.aJE().co(MembersActivity.this.epk.getUserIds());
            MembersActivity.this.epj.aJF();
            MembersActivity.this.epj.aJE().aJy();
        }
    };
    private final CustomMessageListener epm = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.2
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
                        MembersActivity.this.epj.aGT().startPullRefresh();
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
        registerListener(2001128, this.epm);
        registerListener(2001126, this.epm);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.epk.saveInstance(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.epj.aJD().onActivityStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public MembersModel aJs() {
        return this.epk;
    }

    private void initUI() {
        this.epj = new m(this);
        final BdListView aGT = this.epj.aGT();
        this.epi = new com.baidu.tbadk.core.view.h(getPageContext());
        this.epi.a(new g.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.1
            @Override // com.baidu.tbadk.core.view.g.b
            public void aU(boolean z) {
                if (!MembersActivity.this.epj.aJE().aGF()) {
                    if (!MembersActivity.this.aDj()) {
                        MembersActivity.this.reset();
                    }
                    MembersActivity.this.epk.sendMessage(MembersActivity.this.epk.getGroupId(), MembersActivity.this.epk.getStart(), MembersActivity.this.epk.getLen(), MembersActivity.this.epk.getOrderType());
                    return;
                }
                aGT.completePullRefreshPostDelayed(2000L);
            }
        });
        aGT.setPullRefresh(this.epi);
        aGT.setOnSrollToBottomListener(this);
        aGT.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                l aJE = MembersActivity.this.epj.aJE();
                UserData userData = (UserData) aJE.getItem(i);
                if (userData != null) {
                    if (aJE.aGF()) {
                        if (!userData.getPermission().isController()) {
                            aJE.g(Long.valueOf(userData.getUserIdLong()));
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(MembersActivity.this.getPageContext().getContext(), userData.getUserId() + "", userData.getUserName())));
                }
            }
        });
        aGT.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.4
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!MembersActivity.this.epj.aJE().aGF() && MembersActivity.this.epk.isController()) {
                    UserData userData = (UserData) MembersActivity.this.epj.aJE().getItem(i);
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
                                MembersActivity.this.b(MembersActivity.this.epk.getGroupId(), arrayList);
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
        this.epj.aJA().setOnClickListener(this);
        this.epj.aJB().setOnClickListener(this);
        this.epj.aJC().setOnClickListener(this);
        this.epj.setController(false);
        this.epj.aJE().a(new l.a() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.5
            @Override // com.baidu.tieba.im.frsgroup.l.a
            public void nR(int i) {
                MembersActivity.this.epj.nS(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, List<Long> list) {
        if (list != null && list.size() != 0) {
            this.epj.hx(true);
            this.epk.setUserIds(list);
            this.epk.sendRemoveMessage(j, cm(list));
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
        this.epk.setUseCache(false);
        this.epk.setRequestM(null);
        this.epj.aJE().reset(true);
        this.epk.setStart(0);
        this.epk.setLen(50);
        this.epj.aGT().startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.epk.setUseCache(true);
        this.epk.setRequestM(null);
        this.epj.aJE().reset(false);
        this.epk.setStart(0);
        this.epk.setLen(50);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azA() {
        if (aDj()) {
            this.epj.azA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aDj() {
        return 50 == this.epk.getLen();
    }

    public void initData(Bundle bundle) {
        this.epk = new MembersModel(this);
        this.epk.setUniqueId(getUniqueId());
        if (bundle == null) {
            this.epk.initWithIntent(getIntent());
        } else {
            this.epk.initWithBundle(bundle);
        }
        registerListener(this.efV);
        registerListener(this.epl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserData.Permission permission) {
        if (permission != null) {
            boolean isController = permission.isController();
            this.epk.setController(isController);
            this.epj.setController(isController);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJt() {
        this.epj.aJD().e(getPageContext());
        this.epj.aJD().setTextOption(NoDataViewFactory.d.ds(d.k.members_no_person));
        this.epj.aJD().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.epj.onChangeSkinType(i);
        this.epi.dz(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.epj.aJG()) {
            aJu();
        } else if (view == this.epj.aJA()) {
            aJw();
            this.epj.hz(false);
        } else if (view == this.epj.aJB()) {
            aJv();
            this.epj.hz(true);
        } else if (view == this.epj.aJC()) {
            aJx();
        }
    }

    private void aJu() {
        DialogUtil.orderMembers(getPageContext().getPageActivity(), new b.InterfaceC0104b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.8
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0104b
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
                MembersActivity.this.epk.setOrderType(i2);
                MembersActivity.this.showToast(MembersActivity.this.getResources().getStringArray(d.b.members_order_by_short)[i]);
                MembersActivity.this.reset();
                MembersActivity.this.epj.aGT().startPullRefresh();
            }
        });
    }

    private void aJv() {
        this.epj.nS(0);
        this.epj.hy(false);
        this.epj.aJE().hw(false);
        this.epj.aJE().aJy();
        this.epj.aJF();
    }

    private void aJw() {
        this.epj.nS(0);
        this.epj.hy(true);
        this.epj.aJE().hw(true);
        this.epj.aJF();
    }

    private void aJx() {
        Set<Long> aJz = this.epj.aJE().aJz();
        if (aJz.size() > 0) {
            final ArrayList arrayList = new ArrayList();
            arrayList.addAll(aJz);
            DialogUtil.removeMembersDialog(getPageContext().getPageActivity(), new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    MembersActivity.this.epj.hy(false);
                    MembersActivity.this.epj.aJE().hw(false);
                    MembersActivity.this.epj.aJF();
                    MembersActivity.this.b(MembersActivity.this.epk.getGroupId(), arrayList);
                    MembersActivity.this.epj.hz(true);
                }
            }, new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
        }
    }

    private void Tf() {
        if (this.epj.aJE().ajn()) {
            this.epk.sendMessage(this.epk.getGroupId(), this.epk.getStart(), this.epk.getLen(), this.epk.getOrderType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        Tf();
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (this.epj == null || this.epj.aGT() == null) {
            return null;
        }
        return this.epj.aGT().getPreLoadHandle();
    }
}
