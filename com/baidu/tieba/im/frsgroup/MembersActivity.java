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
import com.baidu.tbadk.core.view.f;
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
    private com.baidu.tbadk.core.view.g elm;
    private m eln;
    private MembersModel elo;
    private final com.baidu.adp.framework.listener.c ecb = new com.baidu.adp.framework.listener.c(103005) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            RequestMembersMessage requestMembersMessage;
            l aIX = MembersActivity.this.eln.aIX();
            MembersActivity.this.ayU();
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
            MembersActivity.this.elo.setRequestM(requestMembersMessage);
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
                if (MembersActivity.this.aCE()) {
                    MembersActivity.this.a(membersData.getPermission());
                }
                if (MembersActivity.this.aCE()) {
                    aIX.reset(true);
                }
                if (users.size() != MembersActivity.this.elo.getLen()) {
                    aIX.hk(false);
                    aIX.hl(false);
                    if (MembersActivity.this.aCE() && users.size() == 0) {
                        MembersActivity.this.aIM();
                        return;
                    }
                } else {
                    aIX.hl(true);
                }
                MembersActivity.this.elo.addStart(users.size());
                MembersActivity.this.elo.setLen(20);
                aIX.cj(users);
                aIX.notifyDataSetChanged();
            }
        }
    };
    private final com.baidu.adp.framework.listener.c elp = new com.baidu.adp.framework.listener.c(103112) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            MembersActivity.this.eln.hn(false);
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
            MembersActivity.this.eln.aIX().ck(MembersActivity.this.elo.getUserIds());
            MembersActivity.this.eln.aIY();
            MembersActivity.this.eln.aIX().aIR();
        }
    };
    private final CustomMessageListener elq = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.2
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
                        MembersActivity.this.eln.aGm().startPullRefresh();
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
        registerListener(2001128, this.elq);
        registerListener(2001126, this.elq);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.elo.saveInstance(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.eln.aIW().onActivityStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public MembersModel aIL() {
        return this.elo;
    }

    private void initUI() {
        this.eln = new m(this);
        final BdListView aGm = this.eln.aGm();
        this.elm = new com.baidu.tbadk.core.view.g(getPageContext());
        this.elm.a(new f.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.1
            @Override // com.baidu.tbadk.core.view.f.b
            public void aS(boolean z) {
                if (!MembersActivity.this.eln.aIX().aFX()) {
                    if (!MembersActivity.this.aCE()) {
                        MembersActivity.this.reset();
                    }
                    MembersActivity.this.elo.sendMessage(MembersActivity.this.elo.getGroupId(), MembersActivity.this.elo.getStart(), MembersActivity.this.elo.getLen(), MembersActivity.this.elo.getOrderType());
                    return;
                }
                aGm.completePullRefreshPostDelayed(2000L);
            }
        });
        aGm.setPullRefresh(this.elm);
        aGm.setOnSrollToBottomListener(this);
        aGm.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                l aIX = MembersActivity.this.eln.aIX();
                UserData userData = (UserData) aIX.getItem(i);
                if (userData != null) {
                    if (aIX.aFX()) {
                        if (!userData.getPermission().isController()) {
                            aIX.g(Long.valueOf(userData.getUserIdLong()));
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(MembersActivity.this.getPageContext().getContext(), userData.getUserId() + "", userData.getUserName())));
                }
            }
        });
        aGm.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.4
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!MembersActivity.this.eln.aIX().aFX() && MembersActivity.this.elo.isController()) {
                    UserData userData = (UserData) MembersActivity.this.eln.aIX().getItem(i);
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
                                MembersActivity.this.b(MembersActivity.this.elo.getGroupId(), arrayList);
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
        this.eln.aIT().setOnClickListener(this);
        this.eln.aIU().setOnClickListener(this);
        this.eln.aIV().setOnClickListener(this);
        this.eln.setController(false);
        this.eln.aIX().a(new l.a() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.5
            @Override // com.baidu.tieba.im.frsgroup.l.a
            public void nK(int i) {
                MembersActivity.this.eln.nL(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, List<Long> list) {
        if (list != null && list.size() != 0) {
            this.eln.hn(true);
            this.elo.setUserIds(list);
            this.elo.sendRemoveMessage(j, ci(list));
        }
    }

    private String ci(List<Long> list) {
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
        this.elo.setUseCache(false);
        this.elo.setRequestM(null);
        this.eln.aIX().reset(true);
        this.elo.setStart(0);
        this.elo.setLen(50);
        this.eln.aGm().startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.elo.setUseCache(true);
        this.elo.setRequestM(null);
        this.eln.aIX().reset(false);
        this.elo.setStart(0);
        this.elo.setLen(50);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayU() {
        if (aCE()) {
            this.eln.ayU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aCE() {
        return 50 == this.elo.getLen();
    }

    public void initData(Bundle bundle) {
        this.elo = new MembersModel(this);
        this.elo.setUniqueId(getUniqueId());
        if (bundle == null) {
            this.elo.initWithIntent(getIntent());
        } else {
            this.elo.initWithBundle(bundle);
        }
        registerListener(this.ecb);
        registerListener(this.elp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserData.Permission permission) {
        if (permission != null) {
            boolean isController = permission.isController();
            this.elo.setController(isController);
            this.eln.setController(isController);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIM() {
        this.eln.aIW().e(getPageContext());
        this.eln.aIW().setTextOption(NoDataViewFactory.d.dr(d.k.members_no_person));
        this.eln.aIW().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.eln.onChangeSkinType(i);
        this.elm.dy(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eln.aIZ()) {
            aIN();
        } else if (view == this.eln.aIT()) {
            aIP();
            this.eln.hp(false);
        } else if (view == this.eln.aIU()) {
            aIO();
            this.eln.hp(true);
        } else if (view == this.eln.aIV()) {
            aIQ();
        }
    }

    private void aIN() {
        DialogUtil.orderMembers(getPageContext().getPageActivity(), new b.InterfaceC0103b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.8
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0103b
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
                MembersActivity.this.elo.setOrderType(i2);
                MembersActivity.this.showToast(MembersActivity.this.getResources().getStringArray(d.b.members_order_by_short)[i]);
                MembersActivity.this.reset();
                MembersActivity.this.eln.aGm().startPullRefresh();
            }
        });
    }

    private void aIO() {
        this.eln.nL(0);
        this.eln.ho(false);
        this.eln.aIX().hm(false);
        this.eln.aIX().aIR();
        this.eln.aIY();
    }

    private void aIP() {
        this.eln.nL(0);
        this.eln.ho(true);
        this.eln.aIX().hm(true);
        this.eln.aIY();
    }

    private void aIQ() {
        Set<Long> aIS = this.eln.aIX().aIS();
        if (aIS.size() > 0) {
            final ArrayList arrayList = new ArrayList();
            arrayList.addAll(aIS);
            DialogUtil.removeMembersDialog(getPageContext().getPageActivity(), new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    MembersActivity.this.eln.ho(false);
                    MembersActivity.this.eln.aIX().hm(false);
                    MembersActivity.this.eln.aIY();
                    MembersActivity.this.b(MembersActivity.this.elo.getGroupId(), arrayList);
                    MembersActivity.this.eln.hp(true);
                }
            }, new a.b() { // from class: com.baidu.tieba.im.frsgroup.MembersActivity.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
        }
    }

    private void SJ() {
        if (this.eln.aIX().ajT()) {
            this.elo.sendMessage(this.elo.getGroupId(), this.elo.getStart(), this.elo.getLen(), this.elo.getOrderType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        SJ();
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (this.eln == null || this.eln.aGm() == null) {
            return null;
        }
        return this.eln.aGm().getPreLoadHandle();
    }
}
