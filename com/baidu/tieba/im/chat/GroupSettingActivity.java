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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.GroupSettingActivityConfig;
import com.baidu.tbadk.core.atomData.UpdateGroupActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.message.RequestUpdateMaskMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.l;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.ClearChatMsgResponsedMessage;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.ResponseReportGroupMessage;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.im.model.ReportGroupModel;
import com.baidu.tieba.im.model.UpdateGroupModel;
/* loaded from: classes17.dex */
public class GroupSettingActivity extends BaseActivity<GroupSettingActivity> implements BdSwitchView.a, a.b {
    private boolean isAcceptNotify;
    private UpdateGroupModel jeV;
    private l<Boolean> jeX;
    private b jeT = null;
    private GroupSettingModel jeU = null;
    private ReportGroupModel jeW = null;
    private com.baidu.adp.framework.listener.c jeL = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.chat.GroupSettingActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsedMessage)) {
                if (socketResponsedMessage.getCmd() == 103112) {
                    if (socketResponsedMessage.getError() != 0) {
                        GroupSettingActivity.this.hideProgressBar();
                        GroupSettingActivity.this.showToast(R.string.neterror);
                        return;
                    }
                    GroupSettingActivity.this.hideProgressBar();
                    GroupSettingActivity.this.showToast(R.string.group_quit_suc);
                    GroupSettingActivity.this.finish();
                } else if (socketResponsedMessage.getCmd() == 103102) {
                    if (socketResponsedMessage.getError() != 0) {
                        GroupSettingActivity.this.hideProgressBar();
                        GroupSettingActivity.this.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? GroupSettingActivity.this.getResources().getString(R.string.neterror) : socketResponsedMessage.getErrorString());
                        return;
                    }
                    GroupSettingActivity.this.hideProgressBar();
                    GroupSettingActivity.this.showToast(R.string.group_add_group_switch_success);
                    GroupSettingActivity.this.jeU.setFlag(GroupSettingActivity.this.jeV.getFlag());
                } else if (socketResponsedMessage.getCmd() == 103104) {
                    GroupSettingActivity.this.hideProgressBar();
                    if (socketResponsedMessage.getError() != 0) {
                        GroupSettingActivity.this.aU(socketResponsedMessage.getErrorString(), socketResponsedMessage.getError());
                        return;
                    }
                    TiebaStatic.log("dismiss_group_success");
                    GroupSettingActivity.this.showToast(R.string.group_dismiss_success, false);
                    GroupSettingActivity.this.finish();
                } else {
                    if (socketResponsedMessage.getCmd() == 2001137) {
                    }
                }
            }
        }
    };
    private final b.InterfaceC0538b jeY = new b.InterfaceC0538b() { // from class: com.baidu.tieba.im.chat.GroupSettingActivity.6
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0538b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (GroupSettingActivity.this.jeW == null) {
                GroupSettingActivity.this.jeW = new ReportGroupModel(GroupSettingActivity.this);
            }
            GroupSettingActivity.this.jeW.setGroupId(com.baidu.adp.lib.f.b.toLong(GroupSettingActivity.this.jeU.getGroupId(), 0L));
            GroupSettingActivity.this.jeW.setReportType(i);
            GroupSettingActivity.this.jeW.sendMessage();
        }
    };
    private com.baidu.adp.framework.listener.c jeZ = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.chat.GroupSettingActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 103103) {
                if (!(socketResponsedMessage instanceof ResponseReportGroupMessage)) {
                    GroupSettingActivity.this.showToast(R.string.group_report_fail);
                    return;
                }
                ResponseReportGroupMessage responseReportGroupMessage = (ResponseReportGroupMessage) socketResponsedMessage;
                if (responseReportGroupMessage.getError() != 0) {
                    GroupSettingActivity.this.aU(responseReportGroupMessage.getErrorString(), responseReportGroupMessage.getError());
                } else {
                    GroupSettingActivity.this.showToast(R.string.group_report_success);
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.c jfa = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_UPDATE_MASK) { // from class: com.baidu.tieba.im.chat.GroupSettingActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            GroupSettingActivity.this.hideProgressBar();
            if ((socketResponsedMessage instanceof ResponseUpdateMaskMessage) && (socketResponsedMessage.getOrginalMessage() instanceof RequestUpdateMaskMessage)) {
                RequestUpdateMaskMessage requestUpdateMaskMessage = (RequestUpdateMaskMessage) socketResponsedMessage.getOrginalMessage();
                ResponseUpdateMaskMessage responseUpdateMaskMessage = (ResponseUpdateMaskMessage) socketResponsedMessage;
                if (responseUpdateMaskMessage.hasError()) {
                    GroupSettingActivity.this.showToast(StringUtils.isNull(responseUpdateMaskMessage.getErrorString()) ? GroupSettingActivity.this.getResources().getString(R.string.neterror) : responseUpdateMaskMessage.getErrorString());
                }
                GroupSettingActivity.this.ad(!responseUpdateMaskMessage.hasError(), requestUpdateMaskMessage.isAdd());
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jeT = new b(this);
        this.jeU = new GroupSettingModel(this);
        this.jeV = new UpdateGroupModel(getPageContext());
        this.jeU.setUniqueId(getUniqueId());
        this.jeV.setUniqueId(getUniqueId());
        initData();
        this.jeT.setGroupName(this.jeU.getGroupName());
        this.jeT.a(this.jeY);
        this.jeT.qc(AI(this.jeU.getFlag()));
        this.jeT.initListener();
        this.jeX = new l<Boolean>() { // from class: com.baidu.tieba.im.chat.GroupSettingActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            public void onReturnDataInUI(Boolean bool) {
                if (bool == null || !bool.equals(true)) {
                    GroupSettingActivity.this.jeT.cBK().turnOff();
                    GroupSettingActivity.this.isAcceptNotify = false;
                    return;
                }
                GroupSettingActivity.this.jeT.cBK().turnOn();
                GroupSettingActivity.this.isAcceptNotify = true;
            }
        };
        this.jeU.b(this.jeX);
        initListener();
    }

    private void initListener() {
        registerListener(CmdConfigSocket.CMD_REPORT_GROUP, this.jeZ);
        registerListener(CmdConfigSocket.CMD_UPDATE_GROUP, this.jeL);
        registerListener(CmdConfigSocket.CMD_REMOVE_MEMBERS, this.jeL);
        registerListener(CmdConfigSocket.CMD_DISSMISS_GROUP, this.jeL);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_DISMISS_GROUP, this.jeL);
        registerListener(this.jfa);
    }

    public void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra(GroupSettingActivityConfig.INTENT_DATA_GROUP_NAME);
            String stringExtra2 = intent.getStringExtra(GroupSettingActivityConfig.INTENT_DATA_GROUP_ID);
            int intExtra = intent.getIntExtra(GroupSettingActivityConfig.INTENT_DATA_GROUP_FLAG, 0);
            if (intent.getBooleanExtra(GroupSettingActivityConfig.INTENT_DATA_IS_GROUP_MASTER, false)) {
                this.jeT.cBE();
                this.jeT.cBI();
                this.jeT.qb(true);
                this.jeT.cBH();
            } else {
                this.jeT.cBG();
                this.jeT.bYv();
                this.jeT.qb(false);
                this.jeT.cBF();
            }
            this.jeU.r(stringExtra2, stringExtra, intExtra);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jeT.onChangeSkinType(i);
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
            if (view.equals(this.jeT.cBw())) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateGroupActivityConfig(getPageContext().getPageActivity(), 1, com.baidu.adp.lib.f.b.toLong(this.jeU.getGroupId(), 0L), 1, this.jeU.getGroupName())));
            } else if (view.equals(this.jeT.cBx())) {
                this.jeT.cBB();
            } else if (view.equals(this.jeT.cBz())) {
                this.jeT.cBD();
            } else if (view.equals(this.jeT.cBv())) {
                finish();
            } else if (view.equals(this.jeT.cBA())) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.nt(R.string.alert_clear_cache_group);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.chat.GroupSettingActivity.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        TiebaStatic.log("clear_group_msg_at_gsetting");
                        GroupSettingActivity.this.showLoadingDialog(GroupSettingActivity.this.getPageContext().getString(R.string.deleting));
                        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(GroupSettingActivity.this.jeU.getGroupId(), 1, null, 1)));
                        ad.b(new ac<Boolean>() { // from class: com.baidu.tieba.im.chat.GroupSettingActivity.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.baidu.tbadk.util.ac
                            public Boolean doInBackground() {
                                return Boolean.valueOf(com.baidu.tieba.im.db.c.cDW().Kp(GroupSettingActivity.this.jeU.getGroupId()));
                            }
                        }, new l<Boolean>() { // from class: com.baidu.tieba.im.chat.GroupSettingActivity.2.2
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.l
                            public void onReturnDataInUI(Boolean bool) {
                                GroupSettingActivity.this.closeLoadingDialog();
                                MessageManager.getInstance().dispatchResponsedMessageToUI(new ClearChatMsgResponsedMessage());
                                GroupSettingActivity.this.showToast(R.string.delete_success, false);
                            }
                        });
                        aVar2.dismiss();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.GroupSettingActivity.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(getPageContext());
                aVar.bhg();
            } else if (view == this.jeT.cBy()) {
                this.jeT.cBL();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        Intent intent = new Intent();
        intent.putExtra(GroupSettingActivityConfig.INTENT_DATA_GROUP_FLAG, this.jeU.getFlag());
        setResult(-1, intent);
        super.finish();
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view != null) {
            if (view.equals(this.jeT.cBz())) {
                this.jeT.cBD();
            } else if (view.equals(this.jeT.cBK())) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    if (!com.baidu.tbadk.coreExtra.messageCenter.d.boy().boA() || !com.baidu.tbadk.coreExtra.messageCenter.d.boy().boO()) {
                        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                        aVar.nt(R.string.error_open_group_single_alloff);
                        aVar.b(getResources().getString(R.string.signallforum_signnow), new a.b() { // from class: com.baidu.tieba.im.chat.GroupSettingActivity.4
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                            }
                        });
                        aVar.b(getPageContext());
                        aVar.bhg();
                        ad(false, BdSwitchView.SwitchState.ON == switchState);
                        return;
                    }
                    showProgressBar();
                    this.jeU.qa(BdSwitchView.SwitchState.ON == switchState);
                    return;
                }
                showProgressBar();
                this.jeU.qa(BdSwitchView.SwitchState.ON == switchState);
            } else if (view.equals(this.jeT.cBJ())) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    AJ(W(this.jeU.getFlag(), true));
                } else {
                    AJ(W(this.jeU.getFlag(), false));
                }
            }
        }
    }

    private int W(int i, boolean z) {
        return z ? i & (-3) : i | 2;
    }

    private boolean AI(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void AJ(int i) {
        if (this.jeV != null) {
            this.jeV.setGroupId(this.jeU.cBu());
            this.jeV.setFlag(i);
            this.jeV.sendMessage(5);
            showProgressBar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aU(String str, int i) {
        if (i < 0) {
            showToast(R.string.neterror);
        } else if (TextUtils.isEmpty(str)) {
            showToast(R.string.group_report_fail);
        } else {
            showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.jeL);
        if (this.jeU != null) {
            this.jeU.cancelMessage();
        }
        if (this.jeW != null) {
            this.jeW.cancelMessage();
        }
        MessageManager.getInstance().unRegisterListener(this.jeZ);
        if (this.jeT != null) {
            this.jeT.cBN();
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
            if (aVar == this.jeT.cBC()) {
                showProgressBar();
                this.jeU.eV(Long.parseLong(this.jeU.getGroupId()));
            }
            if (aVar == this.jeT.cBM()) {
                showProgressBar();
                this.jeU.eW(this.jeU.cBu());
            }
            aVar.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ad(boolean z, final boolean z2) {
        if (z) {
            if (z2) {
                this.jeU.pZ(true);
                if (!this.isAcceptNotify) {
                    MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(1));
                    this.isAcceptNotify = true;
                    return;
                }
                return;
            }
            this.jeU.pZ(false);
            if (this.isAcceptNotify) {
                MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(1));
                this.isAcceptNotify = false;
                return;
            }
            return;
        }
        final BdSwitchView cBK = this.jeT.cBK();
        if (cBK != null) {
            com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.chat.GroupSettingActivity.9
                @Override // java.lang.Runnable
                public void run() {
                    if (z2) {
                        cBK.turnOffNoCallback();
                    } else {
                        cBK.turnOnNoCallback();
                    }
                }
            }, 500L);
        }
    }
}
