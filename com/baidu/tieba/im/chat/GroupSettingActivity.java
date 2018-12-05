package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.GroupSettingActivityConfig;
import com.baidu.tbadk.core.atomData.UpdateGroupActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.message.RequestUpdateMaskMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.e;
import com.baidu.tieba.im.message.ClearChatMsgResponsedMessage;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.ResponseReportGroupMessage;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.im.model.ReportGroupModel;
import com.baidu.tieba.im.model.UpdateGroupModel;
/* loaded from: classes3.dex */
public class GroupSettingActivity extends BaseActivity<GroupSettingActivity> implements BdSwitchView.a, a.b {
    private UpdateGroupModel eHk;
    private com.baidu.tbadk.util.h<Boolean> eHm;
    private boolean isAcceptNotify;
    private b eHi = null;
    private GroupSettingModel eHj = null;
    private ReportGroupModel eHl = null;
    private com.baidu.adp.framework.listener.c eHa = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.chat.GroupSettingActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsedMessage)) {
                if (socketResponsedMessage.getCmd() == 103112) {
                    if (socketResponsedMessage.getError() != 0) {
                        GroupSettingActivity.this.hideProgressBar();
                        GroupSettingActivity.this.showToast(e.j.neterror);
                        return;
                    }
                    GroupSettingActivity.this.hideProgressBar();
                    GroupSettingActivity.this.showToast(e.j.group_quit_suc);
                    GroupSettingActivity.this.finish();
                } else if (socketResponsedMessage.getCmd() == 103102) {
                    if (socketResponsedMessage.getError() != 0) {
                        GroupSettingActivity.this.hideProgressBar();
                        GroupSettingActivity.this.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? GroupSettingActivity.this.getResources().getString(e.j.neterror) : socketResponsedMessage.getErrorString());
                        return;
                    }
                    GroupSettingActivity.this.hideProgressBar();
                    GroupSettingActivity.this.showToast(e.j.group_add_group_switch_success);
                    GroupSettingActivity.this.eHj.setFlag(GroupSettingActivity.this.eHk.getFlag());
                } else if (socketResponsedMessage.getCmd() == 103104) {
                    GroupSettingActivity.this.hideProgressBar();
                    if (socketResponsedMessage.getError() != 0) {
                        GroupSettingActivity.this.ak(socketResponsedMessage.getErrorString(), socketResponsedMessage.getError());
                        return;
                    }
                    TiebaStatic.log("dismiss_group_success");
                    GroupSettingActivity.this.showToast(e.j.group_dismiss_success, false);
                    GroupSettingActivity.this.finish();
                } else {
                    if (socketResponsedMessage.getCmd() == 2001137) {
                    }
                }
            }
        }
    };
    private final b.InterfaceC0158b eHn = new b.InterfaceC0158b() { // from class: com.baidu.tieba.im.chat.GroupSettingActivity.6
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (GroupSettingActivity.this.eHl == null) {
                GroupSettingActivity.this.eHl = new ReportGroupModel(GroupSettingActivity.this);
            }
            GroupSettingActivity.this.eHl.setGroupId(com.baidu.adp.lib.g.b.d(GroupSettingActivity.this.eHj.getGroupId(), 0L));
            GroupSettingActivity.this.eHl.setReportType(i);
            GroupSettingActivity.this.eHl.sendMessage();
        }
    };
    private com.baidu.adp.framework.listener.c eHo = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.chat.GroupSettingActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 103103) {
                if (!(socketResponsedMessage instanceof ResponseReportGroupMessage)) {
                    GroupSettingActivity.this.showToast(e.j.group_report_fail);
                    return;
                }
                ResponseReportGroupMessage responseReportGroupMessage = (ResponseReportGroupMessage) socketResponsedMessage;
                if (responseReportGroupMessage.getError() != 0) {
                    GroupSettingActivity.this.ak(responseReportGroupMessage.getErrorString(), responseReportGroupMessage.getError());
                } else {
                    GroupSettingActivity.this.showToast(e.j.group_report_success);
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.c eHp = new com.baidu.adp.framework.listener.c(104101) { // from class: com.baidu.tieba.im.chat.GroupSettingActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            GroupSettingActivity.this.hideProgressBar();
            if ((socketResponsedMessage instanceof ResponseUpdateMaskMessage) && (socketResponsedMessage.getOrginalMessage() instanceof RequestUpdateMaskMessage)) {
                RequestUpdateMaskMessage requestUpdateMaskMessage = (RequestUpdateMaskMessage) socketResponsedMessage.getOrginalMessage();
                ResponseUpdateMaskMessage responseUpdateMaskMessage = (ResponseUpdateMaskMessage) socketResponsedMessage;
                if (responseUpdateMaskMessage.hasError()) {
                    GroupSettingActivity.this.showToast(StringUtils.isNull(responseUpdateMaskMessage.getErrorString()) ? GroupSettingActivity.this.getResources().getString(e.j.neterror) : responseUpdateMaskMessage.getErrorString());
                }
                GroupSettingActivity.this.I(!responseUpdateMaskMessage.hasError(), requestUpdateMaskMessage.isAdd());
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eHi = new b(this);
        this.eHj = new GroupSettingModel(this);
        this.eHk = new UpdateGroupModel(getPageContext());
        this.eHj.setUniqueId(getUniqueId());
        this.eHk.setUniqueId(getUniqueId());
        initData();
        this.eHi.setGroupName(this.eHj.getGroupName());
        this.eHi.a(this.eHn);
        this.eHi.ib(pz(this.eHj.getFlag()));
        this.eHi.initListener();
        this.eHm = new com.baidu.tbadk.util.h<Boolean>() { // from class: com.baidu.tieba.im.chat.GroupSettingActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(Boolean bool) {
                if (bool == null || !bool.equals(true)) {
                    GroupSettingActivity.this.eHi.aOg().nS();
                    GroupSettingActivity.this.isAcceptNotify = false;
                    return;
                }
                GroupSettingActivity.this.eHi.aOg().nR();
                GroupSettingActivity.this.isAcceptNotify = true;
            }
        };
        this.eHj.b(this.eHm);
        initListener();
    }

    private void initListener() {
        registerListener(103103, this.eHo);
        registerListener(103102, this.eHa);
        registerListener(103112, this.eHa);
        registerListener(103104, this.eHa);
        registerListener(2001137, this.eHa);
        registerListener(this.eHp);
    }

    public void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra(GroupSettingActivityConfig.INTENT_DATA_GROUP_NAME);
            String stringExtra2 = intent.getStringExtra(GroupSettingActivityConfig.INTENT_DATA_GROUP_ID);
            int intExtra = intent.getIntExtra(GroupSettingActivityConfig.INTENT_DATA_GROUP_FLAG, 0);
            if (intent.getBooleanExtra(GroupSettingActivityConfig.INTENT_DATA_IS_GROUP_MASTER, false)) {
                this.eHi.aOa();
                this.eHi.aOe();
                this.eHi.ia(true);
                this.eHi.aOd();
            } else {
                this.eHi.aOc();
                this.eHi.amA();
                this.eHi.ia(false);
                this.eHi.aOb();
            }
            this.eHj.i(stringExtra2, stringExtra, intExtra);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eHi.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (1 == i) {
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.equals(this.eHi.aNT())) {
                sendMessage(new CustomMessage(2002001, new UpdateGroupActivityConfig(getPageContext().getPageActivity(), 1, com.baidu.adp.lib.g.b.d(this.eHj.getGroupId(), 0L), 1, this.eHj.getGroupName())));
            } else if (view.equals(this.eHi.aNU())) {
                this.eHi.aNY();
            } else if (view.equals(this.eHi.aNW())) {
                this.eHi.Fr();
            } else if (view.equals(this.eHi.aNS())) {
                finish();
            } else if (view.equals(this.eHi.aNX())) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.db(e.j.alert_clear_cache_group);
                aVar.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.chat.GroupSettingActivity.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        TiebaStatic.log("clear_group_msg_at_gsetting");
                        GroupSettingActivity.this.showLoadingDialog(GroupSettingActivity.this.getPageContext().getString(e.j.deleting));
                        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(GroupSettingActivity.this.eHj.getGroupId(), 1, null, 1)));
                        x.b(new w<Boolean>() { // from class: com.baidu.tieba.im.chat.GroupSettingActivity.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.baidu.tbadk.util.w
                            public Boolean doInBackground() {
                                return Boolean.valueOf(com.baidu.tieba.im.db.c.aQp().pO(GroupSettingActivity.this.eHj.getGroupId()));
                            }
                        }, new com.baidu.tbadk.util.h<Boolean>() { // from class: com.baidu.tieba.im.chat.GroupSettingActivity.2.2
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.h
                            public void onReturnDataInUI(Boolean bool) {
                                GroupSettingActivity.this.closeLoadingDialog();
                                MessageManager.getInstance().dispatchResponsedMessageToUI(new ClearChatMsgResponsedMessage());
                                GroupSettingActivity.this.showToast(e.j.delete_success, false);
                            }
                        });
                        aVar2.dismiss();
                    }
                });
                aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.GroupSettingActivity.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(getPageContext());
                aVar.BF();
            } else if (view == this.eHi.aNV()) {
                this.eHi.aOh();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        Intent intent = new Intent();
        intent.putExtra(GroupSettingActivityConfig.INTENT_DATA_GROUP_FLAG, this.eHj.getFlag());
        setResult(-1, intent);
        super.finish();
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view != null) {
            if (view.equals(this.eHi.aNW())) {
                this.eHi.Fr();
            } else if (view.equals(this.eHi.aOg())) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    if (!com.baidu.tbadk.coreExtra.messageCenter.c.Iw().Iy() || !com.baidu.tbadk.coreExtra.messageCenter.c.Iw().IM()) {
                        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                        aVar.db(e.j.error_open_group_single_alloff);
                        aVar.b(getResources().getString(e.j.signallforum_signnow), new a.b() { // from class: com.baidu.tieba.im.chat.GroupSettingActivity.4
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                            }
                        });
                        aVar.b(getPageContext());
                        aVar.BF();
                        I(false, BdSwitchView.SwitchState.ON == switchState);
                        return;
                    }
                    showProgressBar();
                    this.eHj.hZ(BdSwitchView.SwitchState.ON == switchState);
                    return;
                }
                showProgressBar();
                this.eHj.hZ(BdSwitchView.SwitchState.ON == switchState);
            } else if (view.equals(this.eHi.aOf())) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    pA(v(this.eHj.getFlag(), true));
                } else {
                    pA(v(this.eHj.getFlag(), false));
                }
            }
        }
    }

    private int v(int i, boolean z) {
        return z ? i & (-3) : i | 2;
    }

    private boolean pz(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void pA(int i) {
        if (this.eHk != null) {
            this.eHk.setGroupId(this.eHj.aNR());
            this.eHk.setFlag(i);
            this.eHk.sendMessage(5);
            showProgressBar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ak(String str, int i) {
        if (i < 0) {
            showToast(e.j.neterror);
        } else if (TextUtils.isEmpty(str)) {
            showToast(e.j.group_report_fail);
        } else {
            showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.eHa);
        if (this.eHj != null) {
            this.eHj.cancelMessage();
        }
        if (this.eHl != null) {
            this.eHl.cancelMessage();
        }
        MessageManager.getInstance().unRegisterListener(this.eHo);
        if (this.eHi != null) {
            this.eHi.aOj();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (aVar != null) {
            if (aVar == this.eHi.aNZ()) {
                showProgressBar();
                this.eHj.ch(Long.parseLong(this.eHj.getGroupId()));
            }
            if (aVar == this.eHi.aOi()) {
                showProgressBar();
                this.eHj.ci(this.eHj.aNR());
            }
            aVar.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(boolean z, final boolean z2) {
        if (z) {
            if (z2) {
                this.eHj.hY(true);
                if (!this.isAcceptNotify) {
                    MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(1));
                    this.isAcceptNotify = true;
                    return;
                }
                return;
            }
            this.eHj.hY(false);
            if (this.isAcceptNotify) {
                MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(1));
                this.isAcceptNotify = false;
                return;
            }
            return;
        }
        final BdSwitchView aOg = this.eHi.aOg();
        if (aOg != null) {
            com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.chat.GroupSettingActivity.9
                @Override // java.lang.Runnable
                public void run() {
                    if (z2) {
                        aOg.nQ();
                    } else {
                        aOg.nP();
                    }
                }
            }, 500L);
        }
    }
}
