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
import com.baidu.adp.widget.ListView.p;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.h;
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
/* loaded from: classes5.dex */
public class MembersActivity extends BaseActivity<MembersActivity> implements View.OnClickListener, BdListView.e {
    private com.baidu.tbadk.core.view.i gjU;
    private m gjV;
    private MembersModel gjW;
    private final com.baidu.adp.framework.listener.c gaF = new com.baidu.adp.framework.listener.c(103005) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            RequestMembersMessage requestMembersMessage;
            l btn = MembersActivity.this.gjV.btn();
            MembersActivity.this.bip();
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
            MembersActivity.this.gjW.setRequestM(requestMembersMessage);
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
                if (MembersActivity.this.bmw()) {
                    MembersActivity.this.a(membersData.getPermission());
                }
                if (MembersActivity.this.bmw()) {
                    btn.reset(true);
                }
                if (users.size() != MembersActivity.this.gjW.getLen()) {
                    btn.lc(false);
                    btn.ld(false);
                    if (MembersActivity.this.bmw() && users.size() == 0) {
                        MembersActivity.this.btc();
                        return;
                    }
                } else {
                    btn.ld(true);
                }
                MembersActivity.this.gjW.addStart(users.size());
                MembersActivity.this.gjW.setLen(20);
                btn.cT(users);
                btn.notifyDataSetChanged();
            }
        }
    };
    private final com.baidu.adp.framework.listener.c gjX = new com.baidu.adp.framework.listener.c(103112) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            MembersActivity.this.gjV.lf(false);
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
            MembersActivity.this.gjV.btn().cU(MembersActivity.this.gjW.getUserIds());
            MembersActivity.this.gjV.bto();
            MembersActivity.this.gjV.btn().bth();
        }
    };
    private final CustomMessageListener gjY = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.2
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
                        MembersActivity.this.gjV.bqC().startPullRefresh();
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
        registerListener(2001128, this.gjY);
        registerListener(2001126, this.gjY);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.gjW.saveInstance(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.gjV.btm().onActivityStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public MembersModel btb() {
        return this.gjW;
    }

    private void initUI() {
        this.gjV = new m(this);
        final BdListView bqC = this.gjV.bqC();
        this.gjU = new com.baidu.tbadk.core.view.i(getPageContext());
        this.gjU.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.1
            @Override // com.baidu.tbadk.core.view.h.c
            public void dR(boolean z) {
                if (!MembersActivity.this.gjV.btn().bqp()) {
                    if (!MembersActivity.this.bmw()) {
                        MembersActivity.this.reset();
                    }
                    MembersActivity.this.gjW.sendMessage(MembersActivity.this.gjW.getGroupId(), MembersActivity.this.gjW.getStart(), MembersActivity.this.gjW.getLen(), MembersActivity.this.gjW.getOrderType());
                    return;
                }
                bqC.completePullRefreshPostDelayed(0L);
            }
        });
        bqC.setPullRefresh(this.gjU);
        bqC.setOnSrollToBottomListener(this);
        bqC.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                l btn = MembersActivity.this.gjV.btn();
                UserData userData = (UserData) btn.getItem(i);
                if (userData != null) {
                    if (btn.bqp()) {
                        if (!userData.getPermission().isController()) {
                            btn.g(Long.valueOf(userData.getUserIdLong()));
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(MembersActivity.this.getPageContext().getContext(), userData.getUserId() + "", userData.getUserName())));
                }
            }
        });
        bqC.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.4
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!MembersActivity.this.gjV.btn().bqp() && MembersActivity.this.gjW.isController()) {
                    UserData userData = (UserData) MembersActivity.this.gjV.btn().getItem(i);
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
                                MembersActivity.this.b(MembersActivity.this.gjW.getGroupId(), arrayList);
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
        this.gjV.btj().setOnClickListener(this);
        this.gjV.btk().setOnClickListener(this);
        this.gjV.btl().setOnClickListener(this);
        this.gjV.setController(false);
        this.gjV.btn().a(new l.a() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.5
            @Override // com.baidu.tieba.im.frsgroup.l.a
            public void tS(int i) {
                MembersActivity.this.gjV.tT(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, List<Long> list) {
        if (list != null && list.size() != 0) {
            this.gjV.lf(true);
            this.gjW.setUserIds(list);
            this.gjW.sendRemoveMessage(j, cS(list));
        }
    }

    private String cS(List<Long> list) {
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
        this.gjW.setUseCache(false);
        this.gjW.setRequestM(null);
        this.gjV.btn().reset(true);
        this.gjW.setStart(0);
        this.gjW.setLen(50);
        this.gjV.bqC().startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.gjW.setUseCache(true);
        this.gjW.setRequestM(null);
        this.gjV.btn().reset(false);
        this.gjW.setStart(0);
        this.gjW.setLen(50);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bip() {
        if (bmw()) {
            this.gjV.bip();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bmw() {
        return 50 == this.gjW.getLen();
    }

    public void initData(Bundle bundle) {
        this.gjW = new MembersModel(this);
        this.gjW.setUniqueId(getUniqueId());
        if (bundle == null) {
            this.gjW.initWithIntent(getIntent());
        } else {
            this.gjW.initWithBundle(bundle);
        }
        registerListener(this.gaF);
        registerListener(this.gjX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserData.Permission permission) {
        if (permission != null) {
            boolean isController = permission.isController();
            this.gjW.setController(isController);
            this.gjV.setController(isController);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btc() {
        this.gjV.btm().e(getPageContext());
        this.gjV.btm().setTextOption(NoDataViewFactory.d.hU(d.j.members_no_person));
        this.gjV.btm().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.gjV.onChangeSkinType(i);
        this.gjU.ic(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gjV.btp()) {
            btd();
        } else if (view == this.gjV.btj()) {
            btf();
            this.gjV.lh(false);
        } else if (view == this.gjV.btk()) {
            bte();
            this.gjV.lh(true);
        } else if (view == this.gjV.btl()) {
            btg();
        }
    }

    private void btd() {
        final com.baidu.tbadk.core.dialog.g gVar = new com.baidu.tbadk.core.dialog.g(getPageContext());
        gVar.a(TbadkApplication.getInst().getString(d.j.members_order), getResources().getStringArray(d.b.members_order_by), new i.c() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.8
            @Override // com.baidu.tbadk.core.dialog.i.c
            public void a(com.baidu.tbadk.core.dialog.i iVar, int i, View view) {
                int i2 = 0;
                if (gVar != null && gVar.isShowing()) {
                    gVar.dismiss();
                }
                switch (i) {
                    case 1:
                        i2 = 1;
                        break;
                    case 2:
                        i2 = 2;
                        break;
                }
                MembersActivity.this.gjW.setOrderType(i2);
                MembersActivity.this.showToast(MembersActivity.this.getResources().getStringArray(d.b.members_order_by_short)[i]);
                MembersActivity.this.reset();
                MembersActivity.this.gjV.bqC().startPullRefresh();
            }
        });
        gVar.showDialog();
    }

    private void bte() {
        this.gjV.tT(0);
        this.gjV.lg(false);
        this.gjV.btn().le(false);
        this.gjV.btn().bth();
        this.gjV.bto();
    }

    private void btf() {
        this.gjV.tT(0);
        this.gjV.lg(true);
        this.gjV.btn().le(true);
        this.gjV.bto();
    }

    private void btg() {
        Set<Long> bti = this.gjV.btn().bti();
        if (bti.size() > 0) {
            final ArrayList arrayList = new ArrayList();
            arrayList.addAll(bti);
            DialogUtil.removeMembersDialog(getPageContext().getPageActivity(), new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    MembersActivity.this.gjV.lg(false);
                    MembersActivity.this.gjV.btn().le(false);
                    MembersActivity.this.gjV.bto();
                    MembersActivity.this.b(MembersActivity.this.gjW.getGroupId(), arrayList);
                    MembersActivity.this.gjV.lh(true);
                }
            }, new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
        }
    }

    private void aBc() {
        if (this.gjV.btn().aRu()) {
            this.gjW.sendMessage(this.gjW.getGroupId(), this.gjW.getStart(), this.gjW.getLen(), this.gjW.getOrderType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        aBc();
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public p onGetPreLoadListView() {
        if (this.gjV == null || this.gjV.bqC() == null) {
            return null;
        }
        return this.gjV.bqC().getPreLoadHandle();
    }
}
