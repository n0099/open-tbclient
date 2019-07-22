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
    private com.baidu.tbadk.core.view.i gHi;
    private m gHj;
    private MembersModel gHk;
    private final com.baidu.adp.framework.listener.c gxX = new com.baidu.adp.framework.listener.c(103005) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            RequestMembersMessage requestMembersMessage;
            l bDH = MembersActivity.this.gHj.bDH();
            MembersActivity.this.brJ();
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
            MembersActivity.this.gHk.setRequestM(requestMembersMessage);
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
                if (MembersActivity.this.bwE()) {
                    MembersActivity.this.a(membersData.getPermission());
                }
                if (MembersActivity.this.bwE()) {
                    bDH.reset(true);
                }
                if (users.size() != MembersActivity.this.gHk.getLen()) {
                    bDH.mg(false);
                    bDH.mh(false);
                    if (MembersActivity.this.bwE() && users.size() == 0) {
                        MembersActivity.this.bDw();
                        return;
                    }
                } else {
                    bDH.mh(true);
                }
                MembersActivity.this.gHk.addStart(users.size());
                MembersActivity.this.gHk.setLen(20);
                bDH.da(users);
                bDH.notifyDataSetChanged();
            }
        }
    };
    private final com.baidu.adp.framework.listener.c gHl = new com.baidu.adp.framework.listener.c(103112) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            MembersActivity.this.gHj.mj(false);
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
            MembersActivity.this.gHj.bDH().db(MembersActivity.this.gHk.getUserIds());
            MembersActivity.this.gHj.bDI();
            MembersActivity.this.gHj.bDH().bDB();
        }
    };
    private final CustomMessageListener gHm = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.2
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
                        MembersActivity.this.gHj.bAT().startPullRefresh();
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
        registerListener(2001128, this.gHm);
        registerListener(2001126, this.gHm);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.gHk.saveInstance(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.gHj.bDG().aku();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public MembersModel bDv() {
        return this.gHk;
    }

    private void initUI() {
        this.gHj = new m(this);
        final BdListView bAT = this.gHj.bAT();
        this.gHi = new com.baidu.tbadk.core.view.i(getPageContext());
        this.gHi.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.1
            @Override // com.baidu.tbadk.core.view.h.c
            public void er(boolean z) {
                if (!MembersActivity.this.gHj.bDH().bAG()) {
                    if (!MembersActivity.this.bwE()) {
                        MembersActivity.this.reset();
                    }
                    MembersActivity.this.gHk.sendMessage(MembersActivity.this.gHk.getGroupId(), MembersActivity.this.gHk.getStart(), MembersActivity.this.gHk.getLen(), MembersActivity.this.gHk.getOrderType());
                    return;
                }
                bAT.completePullRefreshPostDelayed(0L);
            }
        });
        bAT.setPullRefresh(this.gHi);
        bAT.setOnSrollToBottomListener(this);
        bAT.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                l bDH = MembersActivity.this.gHj.bDH();
                UserData userData = (UserData) bDH.getItem(i);
                if (userData != null) {
                    if (bDH.bAG()) {
                        if (!userData.getPermission().isController()) {
                            bDH.e(Long.valueOf(userData.getUserIdLong()));
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(MembersActivity.this.getPageContext().getContext(), userData.getUserId() + "", userData.getUserName())));
                }
            }
        });
        bAT.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.4
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!MembersActivity.this.gHj.bDH().bAG() && MembersActivity.this.gHk.isController()) {
                    UserData userData = (UserData) MembersActivity.this.gHj.bDH().getItem(i);
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
                                MembersActivity.this.b(MembersActivity.this.gHk.getGroupId(), arrayList);
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
        this.gHj.bDD().setOnClickListener(this);
        this.gHj.bDE().setOnClickListener(this);
        this.gHj.bDF().setOnClickListener(this);
        this.gHj.setController(false);
        this.gHj.bDH().a(new l.a() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.5
            @Override // com.baidu.tieba.im.frsgroup.l.a
            public void vw(int i) {
                MembersActivity.this.gHj.vx(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, List<Long> list) {
        if (list != null && list.size() != 0) {
            this.gHj.mj(true);
            this.gHk.setUserIds(list);
            this.gHk.sendRemoveMessage(j, cZ(list));
        }
    }

    private String cZ(List<Long> list) {
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
        this.gHk.setUseCache(false);
        this.gHk.setRequestM(null);
        this.gHj.bDH().reset(true);
        this.gHk.setStart(0);
        this.gHk.setLen(50);
        this.gHj.bAT().startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.gHk.setUseCache(true);
        this.gHk.setRequestM(null);
        this.gHj.bDH().reset(false);
        this.gHk.setStart(0);
        this.gHk.setLen(50);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brJ() {
        if (bwE()) {
            this.gHj.brJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bwE() {
        return 50 == this.gHk.getLen();
    }

    public void initData(Bundle bundle) {
        this.gHk = new MembersModel(this);
        this.gHk.setUniqueId(getUniqueId());
        if (bundle == null) {
            this.gHk.initWithIntent(getIntent());
        } else {
            this.gHk.initWithBundle(bundle);
        }
        registerListener(this.gxX);
        registerListener(this.gHl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserData.Permission permission) {
        if (permission != null) {
            boolean isController = permission.isController();
            this.gHk.setController(isController);
            this.gHj.setController(isController);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDw() {
        this.gHj.bDG().e(getPageContext());
        this.gHj.bDG().setTextOption(NoDataViewFactory.d.iN(R.string.members_no_person));
        this.gHj.bDG().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.gHj.onChangeSkinType(i);
        this.gHi.iV(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gHj.bDJ()) {
            bDx();
        } else if (view == this.gHj.bDD()) {
            bDz();
            this.gHj.ml(false);
        } else if (view == this.gHj.bDE()) {
            bDy();
            this.gHj.ml(true);
        } else if (view == this.gHj.bDF()) {
            bDA();
        }
    }

    private void bDx() {
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
                MembersActivity.this.gHk.setOrderType(i2);
                MembersActivity.this.showToast(MembersActivity.this.getResources().getStringArray(R.array.members_order_by_short)[i]);
                MembersActivity.this.reset();
                MembersActivity.this.gHj.bAT().startPullRefresh();
            }
        });
        iVar.showDialog();
    }

    private void bDy() {
        this.gHj.vx(0);
        this.gHj.mk(false);
        this.gHj.bDH().mi(false);
        this.gHj.bDH().bDB();
        this.gHj.bDI();
    }

    private void bDz() {
        this.gHj.vx(0);
        this.gHj.mk(true);
        this.gHj.bDH().mi(true);
        this.gHj.bDI();
    }

    private void bDA() {
        Set<Long> bDC = this.gHj.bDH().bDC();
        if (bDC.size() > 0) {
            final ArrayList arrayList = new ArrayList();
            arrayList.addAll(bDC);
            DialogUtil.removeMembersDialog(getPageContext().getPageActivity(), new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    MembersActivity.this.gHj.mk(false);
                    MembersActivity.this.gHj.bDH().mi(false);
                    MembersActivity.this.gHj.bDI();
                    MembersActivity.this.b(MembersActivity.this.gHk.getGroupId(), arrayList);
                    MembersActivity.this.gHj.ml(true);
                }
            }, new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
        }
    }

    private void aIQ() {
        if (this.gHj.bDH().baD()) {
            this.gHk.sendMessage(this.gHk.getGroupId(), this.gHk.getStart(), this.gHk.getLen(), this.gHk.getOrderType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        aIQ();
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public p onGetPreLoadListView() {
        if (this.gHj == null || this.gHj.bAT() == null) {
            return null;
        }
        return this.gHj.bAT().getPreLoadHandle();
    }
}
