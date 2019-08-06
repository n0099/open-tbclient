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
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.data.UserData;
import com.baidu.tieba.R;
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
    private com.baidu.tbadk.core.view.i gIa;
    private m gIb;
    private MembersModel gIc;
    private final com.baidu.adp.framework.listener.c gyP = new com.baidu.adp.framework.listener.c(103005) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            RequestMembersMessage requestMembersMessage;
            l bDV = MembersActivity.this.gIb.bDV();
            MembersActivity.this.brW();
            if (socketResponsedMessage == null || !(socketResponsedMessage instanceof ResponseMembersMessage)) {
                MembersActivity.this.showToast(R.string.neterror);
                return;
            }
            ResponseMembersMessage responseMembersMessage = (ResponseMembersMessage) socketResponsedMessage;
            Message<?> orginalMessage = responseMembersMessage.getOrginalMessage();
            if (orginalMessage == null || !(orginalMessage instanceof RequestMembersMessage)) {
                requestMembersMessage = null;
            } else {
                requestMembersMessage = (RequestMembersMessage) orginalMessage;
            }
            MembersActivity.this.gIc.setRequestM(requestMembersMessage);
            if (responseMembersMessage.getError() != 0) {
                if (responseMembersMessage.getError() > 0) {
                    MembersActivity.this.showToast(StringUtils.isNull(responseMembersMessage.getErrorString()) ? MembersActivity.this.getResources().getString(R.string.neterror) : responseMembersMessage.getErrorString());
                    return;
                } else {
                    MembersActivity.this.showToast(R.string.neterror);
                    return;
                }
            }
            MembersData membersData = responseMembersMessage.getMembersData();
            List<UserData> users = membersData.getUsers();
            if (users != null) {
                if (MembersActivity.this.bwS()) {
                    MembersActivity.this.a(membersData.getPermission());
                }
                if (MembersActivity.this.bwS()) {
                    bDV.reset(true);
                }
                if (users.size() != MembersActivity.this.gIc.getLen()) {
                    bDV.mg(false);
                    bDV.mh(false);
                    if (MembersActivity.this.bwS() && users.size() == 0) {
                        MembersActivity.this.bDK();
                        return;
                    }
                } else {
                    bDV.mh(true);
                }
                MembersActivity.this.gIc.addStart(users.size());
                MembersActivity.this.gIc.setLen(20);
                bDV.cZ(users);
                bDV.notifyDataSetChanged();
            }
        }
    };
    private final com.baidu.adp.framework.listener.c gId = new com.baidu.adp.framework.listener.c(103112) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            MembersActivity.this.gIb.mj(false);
            if (socketResponsedMessage == null || !(socketResponsedMessage instanceof ResponseRemoveMembersMessage)) {
                MembersActivity.this.showToast(R.string.neterror);
                return;
            }
            ResponseRemoveMembersMessage responseRemoveMembersMessage = (ResponseRemoveMembersMessage) socketResponsedMessage;
            if (responseRemoveMembersMessage.getError() != 0) {
                if (responseRemoveMembersMessage.getError() > 0) {
                    MembersActivity.this.showToast(StringUtils.isNull(responseRemoveMembersMessage.getErrorString()) ? MembersActivity.this.getResources().getString(R.string.neterror) : responseRemoveMembersMessage.getErrorString());
                    return;
                } else {
                    MembersActivity.this.showToast(R.string.neterror);
                    return;
                }
            }
            MembersActivity.this.showToast(R.string.delete_success);
            MembersActivity.this.gIb.bDV().da(MembersActivity.this.gIc.getUserIds());
            MembersActivity.this.gIb.bDW();
            MembersActivity.this.gIb.bDV().bDP();
        }
    };
    private final CustomMessageListener gIe = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.2
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
                        MembersActivity.this.gIb.bBh().startPullRefresh();
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
        registerListener(2001128, this.gIe);
        registerListener(2001126, this.gIe);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.gIc.saveInstance(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.gIb.bDU().akw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public MembersModel bDJ() {
        return this.gIc;
    }

    private void initUI() {
        this.gIb = new m(this);
        final BdListView bBh = this.gIb.bBh();
        this.gIa = new com.baidu.tbadk.core.view.i(getPageContext());
        this.gIa.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.1
            @Override // com.baidu.tbadk.core.view.h.c
            public void er(boolean z) {
                if (!MembersActivity.this.gIb.bDV().bAU()) {
                    if (!MembersActivity.this.bwS()) {
                        MembersActivity.this.reset();
                    }
                    MembersActivity.this.gIc.sendMessage(MembersActivity.this.gIc.getGroupId(), MembersActivity.this.gIc.getStart(), MembersActivity.this.gIc.getLen(), MembersActivity.this.gIc.getOrderType());
                    return;
                }
                bBh.completePullRefreshPostDelayed(0L);
            }
        });
        bBh.setPullRefresh(this.gIa);
        bBh.setOnSrollToBottomListener(this);
        bBh.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                l bDV = MembersActivity.this.gIb.bDV();
                UserData userData = (UserData) bDV.getItem(i);
                if (userData != null) {
                    if (bDV.bAU()) {
                        if (!userData.getPermission().isController()) {
                            bDV.e(Long.valueOf(userData.getUserIdLong()));
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(MembersActivity.this.getPageContext().getContext(), userData.getUserId() + "", userData.getUserName())));
                }
            }
        });
        bBh.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.4
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!MembersActivity.this.gIb.bDV().bAU() && MembersActivity.this.gIc.isController()) {
                    UserData userData = (UserData) MembersActivity.this.gIb.bDV().getItem(i);
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
                                MembersActivity.this.b(MembersActivity.this.gIc.getGroupId(), arrayList);
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
        this.gIb.bDR().setOnClickListener(this);
        this.gIb.bDS().setOnClickListener(this);
        this.gIb.bDT().setOnClickListener(this);
        this.gIb.setController(false);
        this.gIb.bDV().a(new l.a() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.5
            @Override // com.baidu.tieba.im.frsgroup.l.a
            public void vy(int i) {
                MembersActivity.this.gIb.vz(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, List<Long> list) {
        if (list != null && list.size() != 0) {
            this.gIb.mj(true);
            this.gIc.setUserIds(list);
            this.gIc.sendRemoveMessage(j, cY(list));
        }
    }

    private String cY(List<Long> list) {
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
        this.gIc.setUseCache(false);
        this.gIc.setRequestM(null);
        this.gIb.bDV().reset(true);
        this.gIc.setStart(0);
        this.gIc.setLen(50);
        this.gIb.bBh().startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.gIc.setUseCache(true);
        this.gIc.setRequestM(null);
        this.gIb.bDV().reset(false);
        this.gIc.setStart(0);
        this.gIc.setLen(50);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brW() {
        if (bwS()) {
            this.gIb.brW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bwS() {
        return 50 == this.gIc.getLen();
    }

    public void initData(Bundle bundle) {
        this.gIc = new MembersModel(this);
        this.gIc.setUniqueId(getUniqueId());
        if (bundle == null) {
            this.gIc.initWithIntent(getIntent());
        } else {
            this.gIc.initWithBundle(bundle);
        }
        registerListener(this.gyP);
        registerListener(this.gId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserData.Permission permission) {
        if (permission != null) {
            boolean isController = permission.isController();
            this.gIc.setController(isController);
            this.gIb.setController(isController);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDK() {
        this.gIb.bDU().e(getPageContext());
        this.gIb.bDU().setTextOption(NoDataViewFactory.d.iN(R.string.members_no_person));
        this.gIb.bDU().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.gIb.onChangeSkinType(i);
        this.gIa.iV(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gIb.bDX()) {
            bDL();
        } else if (view == this.gIb.bDR()) {
            bDN();
            this.gIb.ml(false);
        } else if (view == this.gIb.bDS()) {
            bDM();
            this.gIb.ml(true);
        } else if (view == this.gIb.bDT()) {
            bDO();
        }
    }

    private void bDL() {
        final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(getPageContext());
        iVar.a(TbadkApplication.getInst().getString(R.string.members_order), getResources().getStringArray(R.array.members_order_by), new k.c() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.8
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                int i2 = 0;
                if (iVar != null && iVar.isShowing()) {
                    iVar.dismiss();
                }
                switch (i) {
                    case 1:
                        i2 = 1;
                        break;
                    case 2:
                        i2 = 2;
                        break;
                }
                MembersActivity.this.gIc.setOrderType(i2);
                MembersActivity.this.showToast(MembersActivity.this.getResources().getStringArray(R.array.members_order_by_short)[i]);
                MembersActivity.this.reset();
                MembersActivity.this.gIb.bBh().startPullRefresh();
            }
        });
        iVar.showDialog();
    }

    private void bDM() {
        this.gIb.vz(0);
        this.gIb.mk(false);
        this.gIb.bDV().mi(false);
        this.gIb.bDV().bDP();
        this.gIb.bDW();
    }

    private void bDN() {
        this.gIb.vz(0);
        this.gIb.mk(true);
        this.gIb.bDV().mi(true);
        this.gIb.bDW();
    }

    private void bDO() {
        Set<Long> bDQ = this.gIb.bDV().bDQ();
        if (bDQ.size() > 0) {
            final ArrayList arrayList = new ArrayList();
            arrayList.addAll(bDQ);
            DialogUtil.removeMembersDialog(getPageContext().getPageActivity(), new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    MembersActivity.this.gIb.mk(false);
                    MembersActivity.this.gIb.bDV().mi(false);
                    MembersActivity.this.gIb.bDW();
                    MembersActivity.this.b(MembersActivity.this.gIc.getGroupId(), arrayList);
                    MembersActivity.this.gIb.ml(true);
                }
            }, new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
        }
    }

    private void aIS() {
        if (this.gIb.bDV().baF()) {
            this.gIc.sendMessage(this.gIc.getGroupId(), this.gIc.getStart(), this.gIc.getLen(), this.gIc.getOrderType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        aIS();
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public p onGetPreLoadListView() {
        if (this.gIb == null || this.gIb.bBh() == null) {
            return null;
        }
        return this.gIb.bBh().getPreLoadHandle();
    }
}
