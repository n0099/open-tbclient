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
    private com.baidu.tbadk.core.view.i gjH;
    private m gjI;
    private MembersModel gjJ;
    private final com.baidu.adp.framework.listener.c gat = new com.baidu.adp.framework.listener.c(103005) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            RequestMembersMessage requestMembersMessage;
            l btk = MembersActivity.this.gjI.btk();
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
            MembersActivity.this.gjJ.setRequestM(requestMembersMessage);
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
                if (users.size() != MembersActivity.this.gjJ.getLen()) {
                    btk.lc(false);
                    btk.ld(false);
                    if (MembersActivity.this.bmt() && users.size() == 0) {
                        MembersActivity.this.bsZ();
                        return;
                    }
                } else {
                    btk.ld(true);
                }
                MembersActivity.this.gjJ.addStart(users.size());
                MembersActivity.this.gjJ.setLen(20);
                btk.cQ(users);
                btk.notifyDataSetChanged();
            }
        }
    };
    private final com.baidu.adp.framework.listener.c gjK = new com.baidu.adp.framework.listener.c(103112) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            MembersActivity.this.gjI.lf(false);
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
            MembersActivity.this.gjI.btk().cR(MembersActivity.this.gjJ.getUserIds());
            MembersActivity.this.gjI.btl();
            MembersActivity.this.gjI.btk().bte();
        }
    };
    private final CustomMessageListener gjL = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.2
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
                        MembersActivity.this.gjI.bqz().startPullRefresh();
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
        registerListener(2001128, this.gjL);
        registerListener(2001126, this.gjL);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.gjJ.saveInstance(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.gjI.btj().onActivityStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public MembersModel bsY() {
        return this.gjJ;
    }

    private void initUI() {
        this.gjI = new m(this);
        final BdListView bqz = this.gjI.bqz();
        this.gjH = new com.baidu.tbadk.core.view.i(getPageContext());
        this.gjH.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.1
            @Override // com.baidu.tbadk.core.view.h.c
            public void dR(boolean z) {
                if (!MembersActivity.this.gjI.btk().bqm()) {
                    if (!MembersActivity.this.bmt()) {
                        MembersActivity.this.reset();
                    }
                    MembersActivity.this.gjJ.sendMessage(MembersActivity.this.gjJ.getGroupId(), MembersActivity.this.gjJ.getStart(), MembersActivity.this.gjJ.getLen(), MembersActivity.this.gjJ.getOrderType());
                    return;
                }
                bqz.completePullRefreshPostDelayed(0L);
            }
        });
        bqz.setPullRefresh(this.gjH);
        bqz.setOnSrollToBottomListener(this);
        bqz.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                l btk = MembersActivity.this.gjI.btk();
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
                if (!MembersActivity.this.gjI.btk().bqm() && MembersActivity.this.gjJ.isController()) {
                    UserData userData = (UserData) MembersActivity.this.gjI.btk().getItem(i);
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
                                MembersActivity.this.b(MembersActivity.this.gjJ.getGroupId(), arrayList);
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
        this.gjI.btg().setOnClickListener(this);
        this.gjI.bth().setOnClickListener(this);
        this.gjI.bti().setOnClickListener(this);
        this.gjI.setController(false);
        this.gjI.btk().a(new l.a() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.5
            @Override // com.baidu.tieba.im.frsgroup.l.a
            public void tO(int i) {
                MembersActivity.this.gjI.tP(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, List<Long> list) {
        if (list != null && list.size() != 0) {
            this.gjI.lf(true);
            this.gjJ.setUserIds(list);
            this.gjJ.sendRemoveMessage(j, cP(list));
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
        this.gjJ.setUseCache(false);
        this.gjJ.setRequestM(null);
        this.gjI.btk().reset(true);
        this.gjJ.setStart(0);
        this.gjJ.setLen(50);
        this.gjI.bqz().startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.gjJ.setUseCache(true);
        this.gjJ.setRequestM(null);
        this.gjI.btk().reset(false);
        this.gjJ.setStart(0);
        this.gjJ.setLen(50);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bin() {
        if (bmt()) {
            this.gjI.bin();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bmt() {
        return 50 == this.gjJ.getLen();
    }

    public void initData(Bundle bundle) {
        this.gjJ = new MembersModel(this);
        this.gjJ.setUniqueId(getUniqueId());
        if (bundle == null) {
            this.gjJ.initWithIntent(getIntent());
        } else {
            this.gjJ.initWithBundle(bundle);
        }
        registerListener(this.gat);
        registerListener(this.gjK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserData.Permission permission) {
        if (permission != null) {
            boolean isController = permission.isController();
            this.gjJ.setController(isController);
            this.gjI.setController(isController);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsZ() {
        this.gjI.btj().e(getPageContext());
        this.gjI.btj().setTextOption(NoDataViewFactory.d.hT(d.j.members_no_person));
        this.gjI.btj().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.gjI.onChangeSkinType(i);
        this.gjH.ib(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gjI.btm()) {
            bta();
        } else if (view == this.gjI.btg()) {
            btc();
            this.gjI.lh(false);
        } else if (view == this.gjI.bth()) {
            btb();
            this.gjI.lh(true);
        } else if (view == this.gjI.bti()) {
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
                MembersActivity.this.gjJ.setOrderType(i2);
                MembersActivity.this.showToast(MembersActivity.this.getResources().getStringArray(d.b.members_order_by_short)[i]);
                MembersActivity.this.reset();
                MembersActivity.this.gjI.bqz().startPullRefresh();
            }
        });
        gVar.showDialog();
    }

    private void btb() {
        this.gjI.tP(0);
        this.gjI.lg(false);
        this.gjI.btk().le(false);
        this.gjI.btk().bte();
        this.gjI.btl();
    }

    private void btc() {
        this.gjI.tP(0);
        this.gjI.lg(true);
        this.gjI.btk().le(true);
        this.gjI.btl();
    }

    private void btd() {
        Set<Long> btf = this.gjI.btk().btf();
        if (btf.size() > 0) {
            final ArrayList arrayList = new ArrayList();
            arrayList.addAll(btf);
            DialogUtil.removeMembersDialog(getPageContext().getPageActivity(), new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    MembersActivity.this.gjI.lg(false);
                    MembersActivity.this.gjI.btk().le(false);
                    MembersActivity.this.gjI.btl();
                    MembersActivity.this.b(MembersActivity.this.gjJ.getGroupId(), arrayList);
                    MembersActivity.this.gjI.lh(true);
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
        if (this.gjI.btk().aRs()) {
            this.gjJ.sendMessage(this.gjJ.getGroupId(), this.gjJ.getStart(), this.gjJ.getLen(), this.gjJ.getOrderType());
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
        if (this.gjI == null || this.gjI.bqz() == null) {
            return null;
        }
        return this.gjI.bqz().getPreLoadHandle();
    }
}
