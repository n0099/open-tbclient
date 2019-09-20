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
    private com.baidu.tbadk.core.view.i gJS;
    private m gJT;
    private MembersModel gJU;
    private final com.baidu.adp.framework.listener.c gAG = new com.baidu.adp.framework.listener.c(103005) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            RequestMembersMessage requestMembersMessage;
            l bEJ = MembersActivity.this.gJT.bEJ();
            MembersActivity.this.bsJ();
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
            MembersActivity.this.gJU.setRequestM(requestMembersMessage);
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
                if (MembersActivity.this.bxG()) {
                    MembersActivity.this.a(membersData.getPermission());
                }
                if (MembersActivity.this.bxG()) {
                    bEJ.reset(true);
                }
                if (users.size() != MembersActivity.this.gJU.getLen()) {
                    bEJ.mj(false);
                    bEJ.mk(false);
                    if (MembersActivity.this.bxG() && users.size() == 0) {
                        MembersActivity.this.bEy();
                        return;
                    }
                } else {
                    bEJ.mk(true);
                }
                MembersActivity.this.gJU.addStart(users.size());
                MembersActivity.this.gJU.setLen(20);
                bEJ.cZ(users);
                bEJ.notifyDataSetChanged();
            }
        }
    };
    private final com.baidu.adp.framework.listener.c gJV = new com.baidu.adp.framework.listener.c(103112) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            MembersActivity.this.gJT.mm(false);
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
            MembersActivity.this.gJT.bEJ().da(MembersActivity.this.gJU.getUserIds());
            MembersActivity.this.gJT.bEK();
            MembersActivity.this.gJT.bEJ().bED();
        }
    };
    private final CustomMessageListener gJW = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.2
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
                        MembersActivity.this.gJT.bBV().startPullRefresh();
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
        registerListener(2001128, this.gJW);
        registerListener(2001126, this.gJW);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.gJU.saveInstance(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.gJT.bEI().akI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public MembersModel bEx() {
        return this.gJU;
    }

    private void initUI() {
        this.gJT = new m(this);
        final BdListView bBV = this.gJT.bBV();
        this.gJS = new com.baidu.tbadk.core.view.i(getPageContext());
        this.gJS.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.1
            @Override // com.baidu.tbadk.core.view.h.c
            public void eu(boolean z) {
                if (!MembersActivity.this.gJT.bEJ().bBI()) {
                    if (!MembersActivity.this.bxG()) {
                        MembersActivity.this.reset();
                    }
                    MembersActivity.this.gJU.sendMessage(MembersActivity.this.gJU.getGroupId(), MembersActivity.this.gJU.getStart(), MembersActivity.this.gJU.getLen(), MembersActivity.this.gJU.getOrderType());
                    return;
                }
                bBV.completePullRefreshPostDelayed(0L);
            }
        });
        bBV.setPullRefresh(this.gJS);
        bBV.setOnSrollToBottomListener(this);
        bBV.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                l bEJ = MembersActivity.this.gJT.bEJ();
                UserData userData = (UserData) bEJ.getItem(i);
                if (userData != null) {
                    if (bEJ.bBI()) {
                        if (!userData.getPermission().isController()) {
                            bEJ.e(Long.valueOf(userData.getUserIdLong()));
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(MembersActivity.this.getPageContext().getContext(), userData.getUserId() + "", userData.getUserName())));
                }
            }
        });
        bBV.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.4
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!MembersActivity.this.gJT.bEJ().bBI() && MembersActivity.this.gJU.isController()) {
                    UserData userData = (UserData) MembersActivity.this.gJT.bEJ().getItem(i);
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
                                MembersActivity.this.b(MembersActivity.this.gJU.getGroupId(), arrayList);
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
        this.gJT.bEF().setOnClickListener(this);
        this.gJT.bEG().setOnClickListener(this);
        this.gJT.bEH().setOnClickListener(this);
        this.gJT.setController(false);
        this.gJT.bEJ().a(new l.a() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.5
            @Override // com.baidu.tieba.im.frsgroup.l.a
            public void vC(int i) {
                MembersActivity.this.gJT.vD(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, List<Long> list) {
        if (list != null && list.size() != 0) {
            this.gJT.mm(true);
            this.gJU.setUserIds(list);
            this.gJU.sendRemoveMessage(j, cY(list));
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
        this.gJU.setUseCache(false);
        this.gJU.setRequestM(null);
        this.gJT.bEJ().reset(true);
        this.gJU.setStart(0);
        this.gJU.setLen(50);
        this.gJT.bBV().startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.gJU.setUseCache(true);
        this.gJU.setRequestM(null);
        this.gJT.bEJ().reset(false);
        this.gJU.setStart(0);
        this.gJU.setLen(50);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsJ() {
        if (bxG()) {
            this.gJT.bsJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bxG() {
        return 50 == this.gJU.getLen();
    }

    public void initData(Bundle bundle) {
        this.gJU = new MembersModel(this);
        this.gJU.setUniqueId(getUniqueId());
        if (bundle == null) {
            this.gJU.initWithIntent(getIntent());
        } else {
            this.gJU.initWithBundle(bundle);
        }
        registerListener(this.gAG);
        registerListener(this.gJV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserData.Permission permission) {
        if (permission != null) {
            boolean isController = permission.isController();
            this.gJU.setController(isController);
            this.gJT.setController(isController);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEy() {
        this.gJT.bEI().e(getPageContext());
        this.gJT.bEI().setTextOption(NoDataViewFactory.d.iQ(R.string.members_no_person));
        this.gJT.bEI().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.gJT.onChangeSkinType(i);
        this.gJS.iY(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gJT.bEL()) {
            bEz();
        } else if (view == this.gJT.bEF()) {
            bEB();
            this.gJT.mo(false);
        } else if (view == this.gJT.bEG()) {
            bEA();
            this.gJT.mo(true);
        } else if (view == this.gJT.bEH()) {
            bEC();
        }
    }

    private void bEz() {
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
                MembersActivity.this.gJU.setOrderType(i2);
                MembersActivity.this.showToast(MembersActivity.this.getResources().getStringArray(R.array.members_order_by_short)[i]);
                MembersActivity.this.reset();
                MembersActivity.this.gJT.bBV().startPullRefresh();
            }
        });
        iVar.showDialog();
    }

    private void bEA() {
        this.gJT.vD(0);
        this.gJT.mn(false);
        this.gJT.bEJ().ml(false);
        this.gJT.bEJ().bED();
        this.gJT.bEK();
    }

    private void bEB() {
        this.gJT.vD(0);
        this.gJT.mn(true);
        this.gJT.bEJ().ml(true);
        this.gJT.bEK();
    }

    private void bEC() {
        Set<Long> bEE = this.gJT.bEJ().bEE();
        if (bEE.size() > 0) {
            final ArrayList arrayList = new ArrayList();
            arrayList.addAll(bEE);
            DialogUtil.removeMembersDialog(getPageContext().getPageActivity(), new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    MembersActivity.this.gJT.mn(false);
                    MembersActivity.this.gJT.bEJ().ml(false);
                    MembersActivity.this.gJT.bEK();
                    MembersActivity.this.b(MembersActivity.this.gJU.getGroupId(), arrayList);
                    MembersActivity.this.gJT.mo(true);
                }
            }, new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
        }
    }

    private void aJw() {
        if (this.gJT.bEJ().bbj()) {
            this.gJU.sendMessage(this.gJU.getGroupId(), this.gJU.getStart(), this.gJU.getLen(), this.gJU.getOrderType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        aJw();
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public p onGetPreLoadListView() {
        if (this.gJT == null || this.gJT.bBV() == null) {
            return null;
        }
        return this.gJT.bBV().getPreLoadHandle();
    }
}
