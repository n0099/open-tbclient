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
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.ClearChatMsgResponsedMessage;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.ResponseReportGroupMessage;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.im.model.ReportGroupModel;
import com.baidu.tieba.im.model.UpdateGroupModel;
/* loaded from: classes23.dex */
public class GroupSettingActivity extends BaseActivity<GroupSettingActivity> implements BdSwitchView.a, a.b {
    private boolean isAcceptNotify;
    private UpdateGroupModel jVa;
    private m<Boolean> jVc;
    private b jUY = null;
    private GroupSettingModel jUZ = null;
    private ReportGroupModel jVb = null;
    private com.baidu.adp.framework.listener.c jUQ = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.chat.GroupSettingActivity.5
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
                    GroupSettingActivity.this.jUZ.setFlag(GroupSettingActivity.this.jVa.getFlag());
                } else if (socketResponsedMessage.getCmd() == 103104) {
                    GroupSettingActivity.this.hideProgressBar();
                    if (socketResponsedMessage.getError() != 0) {
                        GroupSettingActivity.this.aY(socketResponsedMessage.getErrorString(), socketResponsedMessage.getError());
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
    private final b.InterfaceC0576b jVd = new b.InterfaceC0576b() { // from class: com.baidu.tieba.im.chat.GroupSettingActivity.6
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0576b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (GroupSettingActivity.this.jVb == null) {
                GroupSettingActivity.this.jVb = new ReportGroupModel(GroupSettingActivity.this);
            }
            GroupSettingActivity.this.jVb.setGroupId(com.baidu.adp.lib.f.b.toLong(GroupSettingActivity.this.jUZ.getGroupId(), 0L));
            GroupSettingActivity.this.jVb.setReportType(i);
            GroupSettingActivity.this.jVb.sendMessage();
        }
    };
    private com.baidu.adp.framework.listener.c jVe = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.chat.GroupSettingActivity.7
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
                    GroupSettingActivity.this.aY(responseReportGroupMessage.getErrorString(), responseReportGroupMessage.getError());
                } else {
                    GroupSettingActivity.this.showToast(R.string.group_report_success);
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.c jVf = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_UPDATE_MASK) { // from class: com.baidu.tieba.im.chat.GroupSettingActivity.8
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
                GroupSettingActivity.this.ah(!responseUpdateMaskMessage.hasError(), requestUpdateMaskMessage.isAdd());
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jUY = new b(this);
        this.jUZ = new GroupSettingModel(this);
        this.jVa = new UpdateGroupModel(getPageContext());
        this.jUZ.setUniqueId(getUniqueId());
        this.jVa.setUniqueId(getUniqueId());
        initData();
        this.jUY.setGroupName(this.jUZ.getGroupName());
        this.jUY.a(this.jVd);
        this.jUY.rt(Cv(this.jUZ.getFlag()));
        this.jUY.initListener();
        this.jVc = new m<Boolean>() { // from class: com.baidu.tieba.im.chat.GroupSettingActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            public void onReturnDataInUI(Boolean bool) {
                if (bool == null || !bool.equals(true)) {
                    GroupSettingActivity.this.jUY.cOJ().turnOff();
                    GroupSettingActivity.this.isAcceptNotify = false;
                    return;
                }
                GroupSettingActivity.this.jUY.cOJ().turnOn();
                GroupSettingActivity.this.isAcceptNotify = true;
            }
        };
        this.jUZ.b(this.jVc);
        initListener();
    }

    private void initListener() {
        registerListener(CmdConfigSocket.CMD_REPORT_GROUP, this.jVe);
        registerListener(CmdConfigSocket.CMD_UPDATE_GROUP, this.jUQ);
        registerListener(CmdConfigSocket.CMD_REMOVE_MEMBERS, this.jUQ);
        registerListener(CmdConfigSocket.CMD_DISSMISS_GROUP, this.jUQ);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_DISMISS_GROUP, this.jUQ);
        registerListener(this.jVf);
    }

    public void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra(GroupSettingActivityConfig.INTENT_DATA_GROUP_NAME);
            String stringExtra2 = intent.getStringExtra(GroupSettingActivityConfig.INTENT_DATA_GROUP_ID);
            int intExtra = intent.getIntExtra(GroupSettingActivityConfig.INTENT_DATA_GROUP_FLAG, 0);
            if (intent.getBooleanExtra(GroupSettingActivityConfig.INTENT_DATA_IS_GROUP_MASTER, false)) {
                this.jUY.cOD();
                this.jUY.cOH();
                this.jUY.rs(true);
                this.jUY.cOG();
            } else {
                this.jUY.cOF();
                this.jUY.cju();
                this.jUY.rs(false);
                this.jUY.cOE();
            }
            this.jUZ.r(stringExtra2, stringExtra, intExtra);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jUY.onChangeSkinType(i);
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
            if (view.equals(this.jUY.cOv())) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateGroupActivityConfig(getPageContext().getPageActivity(), 1, com.baidu.adp.lib.f.b.toLong(this.jUZ.getGroupId(), 0L), 1, this.jUZ.getGroupName())));
            } else if (view.equals(this.jUY.cOw())) {
                this.jUY.cOA();
            } else if (view.equals(this.jUY.cOy())) {
                this.jUY.cOC();
            } else if (view.equals(this.jUY.cOu())) {
                finish();
            } else if (view.equals(this.jUY.cOz())) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.ow(R.string.alert_clear_cache_group);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.chat.GroupSettingActivity.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        TiebaStatic.log("clear_group_msg_at_gsetting");
                        GroupSettingActivity.this.showLoadingDialog(GroupSettingActivity.this.getPageContext().getString(R.string.deleting));
                        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(GroupSettingActivity.this.jUZ.getGroupId(), 1, null, 1)));
                        ae.b(new ad<Boolean>() { // from class: com.baidu.tieba.im.chat.GroupSettingActivity.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.baidu.tbadk.util.ad
                            public Boolean doInBackground() {
                                return Boolean.valueOf(com.baidu.tieba.im.db.c.cQU().Mw(GroupSettingActivity.this.jUZ.getGroupId()));
                            }
                        }, new m<Boolean>() { // from class: com.baidu.tieba.im.chat.GroupSettingActivity.2.2
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.m
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
                aVar.bpc();
            } else if (view == this.jUY.cOx()) {
                this.jUY.cOK();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        Intent intent = new Intent();
        intent.putExtra(GroupSettingActivityConfig.INTENT_DATA_GROUP_FLAG, this.jUZ.getFlag());
        setResult(-1, intent);
        super.finish();
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view != null) {
            if (view.equals(this.jUY.cOy())) {
                this.jUY.cOC();
            } else if (view.equals(this.jUY.cOJ())) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    if (!com.baidu.tbadk.coreExtra.messageCenter.d.bwv().bwx() || !com.baidu.tbadk.coreExtra.messageCenter.d.bwv().bwL()) {
                        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                        aVar.ow(R.string.error_open_group_single_alloff);
                        aVar.b(getResources().getString(R.string.signallforum_signnow), new a.b() { // from class: com.baidu.tieba.im.chat.GroupSettingActivity.4
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                            }
                        });
                        aVar.b(getPageContext());
                        aVar.bpc();
                        ah(false, BdSwitchView.SwitchState.ON == switchState);
                        return;
                    }
                    showProgressBar();
                    this.jUZ.rr(BdSwitchView.SwitchState.ON == switchState);
                    return;
                }
                showProgressBar();
                this.jUZ.rr(BdSwitchView.SwitchState.ON == switchState);
            } else if (view.equals(this.jUY.cOI())) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    Cw(Z(this.jUZ.getFlag(), true));
                } else {
                    Cw(Z(this.jUZ.getFlag(), false));
                }
            }
        }
    }

    private int Z(int i, boolean z) {
        return z ? i & (-3) : i | 2;
    }

    private boolean Cv(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void Cw(int i) {
        if (this.jVa != null) {
            this.jVa.setGroupId(this.jUZ.cOt());
            this.jVa.setFlag(i);
            this.jVa.sendMessage(5);
            showProgressBar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(String str, int i) {
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
        MessageManager.getInstance().unRegisterListener(this.jUQ);
        if (this.jUZ != null) {
            this.jUZ.cancelMessage();
        }
        if (this.jVb != null) {
            this.jVb.cancelMessage();
        }
        MessageManager.getInstance().unRegisterListener(this.jVe);
        if (this.jUY != null) {
            this.jUY.cOM();
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
            if (aVar == this.jUY.cOB()) {
                showProgressBar();
                this.jUZ.fY(Long.parseLong(this.jUZ.getGroupId()));
            }
            if (aVar == this.jUY.cOL()) {
                showProgressBar();
                this.jUZ.fZ(this.jUZ.cOt());
            }
            aVar.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(boolean z, final boolean z2) {
        if (z) {
            if (z2) {
                this.jUZ.rq(true);
                if (!this.isAcceptNotify) {
                    MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(1));
                    this.isAcceptNotify = true;
                    return;
                }
                return;
            }
            this.jUZ.rq(false);
            if (this.isAcceptNotify) {
                MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(1));
                this.isAcceptNotify = false;
                return;
            }
            return;
        }
        final BdSwitchView cOJ = this.jUY.cOJ();
        if (cOJ != null) {
            com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.chat.GroupSettingActivity.9
                @Override // java.lang.Runnable
                public void run() {
                    if (z2) {
                        cOJ.turnOffNoCallback();
                    } else {
                        cOJ.turnOnNoCallback();
                    }
                }
            }, 500L);
        }
    }
}
