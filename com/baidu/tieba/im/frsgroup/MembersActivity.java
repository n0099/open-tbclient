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
    private com.baidu.tbadk.core.view.i gjI;
    private m gjJ;
    private MembersModel gjK;
    private final com.baidu.adp.framework.listener.c gat = new com.baidu.adp.framework.listener.c(103005) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            RequestMembersMessage requestMembersMessage;
            l btk = MembersActivity.this.gjJ.btk();
            MembersActivity.this.bin();
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
            MembersActivity.this.gjK.setRequestM(requestMembersMessage);
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
                if (MembersActivity.this.bmt()) {
                    MembersActivity.this.a(membersData.getPermission());
                }
                if (MembersActivity.this.bmt()) {
                    btk.reset(true);
                }
                if (users.size() != MembersActivity.this.gjK.getLen()) {
                    btk.lc(false);
                    btk.ld(false);
                    if (MembersActivity.this.bmt() && users.size() == 0) {
                        MembersActivity.this.bsZ();
                        return;
                    }
                } else {
                    btk.ld(true);
                }
                MembersActivity.this.gjK.addStart(users.size());
                MembersActivity.this.gjK.setLen(20);
                btk.cQ(users);
                btk.notifyDataSetChanged();
            }
        }
    };
    private final com.baidu.adp.framework.listener.c gjL = new com.baidu.adp.framework.listener.c(103112) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            MembersActivity.this.gjJ.lf(false);
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
            MembersActivity.this.gjJ.btk().cR(MembersActivity.this.gjK.getUserIds());
            MembersActivity.this.gjJ.btl();
            MembersActivity.this.gjJ.btk().bte();
        }
    };
    private final CustomMessageListener gjM = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.2
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
                        MembersActivity.this.gjJ.bqz().startPullRefresh();
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
        registerListener(2001128, this.gjM);
        registerListener(2001126, this.gjM);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.gjK.saveInstance(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.gjJ.btj().onActivityStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public MembersModel bsY() {
        return this.gjK;
    }

    private void initUI() {
        this.gjJ = new m(this);
        final BdListView bqz = this.gjJ.bqz();
        this.gjI = new com.baidu.tbadk.core.view.i(getPageContext());
        this.gjI.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.1
            @Override // com.baidu.tbadk.core.view.h.c
            public void dR(boolean z) {
                if (!MembersActivity.this.gjJ.btk().bqm()) {
                    if (!MembersActivity.this.bmt()) {
                        MembersActivity.this.reset();
                    }
                    MembersActivity.this.gjK.sendMessage(MembersActivity.this.gjK.getGroupId(), MembersActivity.this.gjK.getStart(), MembersActivity.this.gjK.getLen(), MembersActivity.this.gjK.getOrderType());
                    return;
                }
                bqz.completePullRefreshPostDelayed(0L);
            }
        });
        bqz.setPullRefresh(this.gjI);
        bqz.setOnSrollToBottomListener(this);
        bqz.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                l btk = MembersActivity.this.gjJ.btk();
                UserData userData = (UserData) btk.getItem(i);
                if (userData != null) {
                    if (btk.bqm()) {
                        if (!userData.getPermission().isController()) {
                            btk.g(Long.valueOf(userData.getUserIdLong()));
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(MembersActivity.this.getPageContext().getContext(), userData.getUserId() + "", userData.getUserName())));
                }
            }
        });
        bqz.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.4
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!MembersActivity.this.gjJ.btk().bqm() && MembersActivity.this.gjK.isController()) {
                    UserData userData = (UserData) MembersActivity.this.gjJ.btk().getItem(i);
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
                                MembersActivity.this.b(MembersActivity.this.gjK.getGroupId(), arrayList);
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
        this.gjJ.btg().setOnClickListener(this);
        this.gjJ.bth().setOnClickListener(this);
        this.gjJ.bti().setOnClickListener(this);
        this.gjJ.setController(false);
        this.gjJ.btk().a(new l.a() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.5
            @Override // com.baidu.tieba.im.frsgroup.l.a
            public void tO(int i) {
                MembersActivity.this.gjJ.tP(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, List<Long> list) {
        if (list != null && list.size() != 0) {
            this.gjJ.lf(true);
            this.gjK.setUserIds(list);
            this.gjK.sendRemoveMessage(j, cP(list));
        }
    }

    private String cP(List<Long> list) {
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
        this.gjK.setUseCache(false);
        this.gjK.setRequestM(null);
        this.gjJ.btk().reset(true);
        this.gjK.setStart(0);
        this.gjK.setLen(50);
        this.gjJ.bqz().startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.gjK.setUseCache(true);
        this.gjK.setRequestM(null);
        this.gjJ.btk().reset(false);
        this.gjK.setStart(0);
        this.gjK.setLen(50);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bin() {
        if (bmt()) {
            this.gjJ.bin();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bmt() {
        return 50 == this.gjK.getLen();
    }

    public void initData(Bundle bundle) {
        this.gjK = new MembersModel(this);
        this.gjK.setUniqueId(getUniqueId());
        if (bundle == null) {
            this.gjK.initWithIntent(getIntent());
        } else {
            this.gjK.initWithBundle(bundle);
        }
        registerListener(this.gat);
        registerListener(this.gjL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserData.Permission permission) {
        if (permission != null) {
            boolean isController = permission.isController();
            this.gjK.setController(isController);
            this.gjJ.setController(isController);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsZ() {
        this.gjJ.btj().e(getPageContext());
        this.gjJ.btj().setTextOption(NoDataViewFactory.d.hT(d.j.members_no_person));
        this.gjJ.btj().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.gjJ.onChangeSkinType(i);
        this.gjI.ib(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gjJ.btm()) {
            bta();
        } else if (view == this.gjJ.btg()) {
            btc();
            this.gjJ.lh(false);
        } else if (view == this.gjJ.bth()) {
            btb();
            this.gjJ.lh(true);
        } else if (view == this.gjJ.bti()) {
            btd();
        }
    }

    private void bta() {
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
                MembersActivity.this.gjK.setOrderType(i2);
                MembersActivity.this.showToast(MembersActivity.this.getResources().getStringArray(d.b.members_order_by_short)[i]);
                MembersActivity.this.reset();
                MembersActivity.this.gjJ.bqz().startPullRefresh();
            }
        });
        gVar.showDialog();
    }

    private void btb() {
        this.gjJ.tP(0);
        this.gjJ.lg(false);
        this.gjJ.btk().le(false);
        this.gjJ.btk().bte();
        this.gjJ.btl();
    }

    private void btc() {
        this.gjJ.tP(0);
        this.gjJ.lg(true);
        this.gjJ.btk().le(true);
        this.gjJ.btl();
    }

    private void btd() {
        Set<Long> btf = this.gjJ.btk().btf();
        if (btf.size() > 0) {
            final ArrayList arrayList = new ArrayList();
            arrayList.addAll(btf);
            DialogUtil.removeMembersDialog(getPageContext().getPageActivity(), new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    MembersActivity.this.gjJ.lg(false);
                    MembersActivity.this.gjJ.btk().le(false);
                    MembersActivity.this.gjJ.btl();
                    MembersActivity.this.b(MembersActivity.this.gjK.getGroupId(), arrayList);
                    MembersActivity.this.gjJ.lh(true);
                }
            }, new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
        }
    }

    private void aAZ() {
        if (this.gjJ.btk().aRs()) {
            this.gjK.sendMessage(this.gjK.getGroupId(), this.gjK.getStart(), this.gjK.getLen(), this.gjK.getOrderType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        aAZ();
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public p onGetPreLoadListView() {
        if (this.gjJ == null || this.gjJ.bqz() == null) {
            return null;
        }
        return this.gjJ.bqz().getPreLoadHandle();
    }
}
