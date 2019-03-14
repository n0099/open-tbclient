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
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.k;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.d;
import com.baidu.tieba.im.message.ClearChatMsgResponsedMessage;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.ResponseReportGroupMessage;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.im.model.ReportGroupModel;
import com.baidu.tieba.im.model.UpdateGroupModel;
/* loaded from: classes5.dex */
public class GroupSettingActivity extends BaseActivity<GroupSettingActivity> implements BdSwitchView.a, a.b {
    private UpdateGroupModel gaP;
    private k<Boolean> gaR;
    private boolean isAcceptNotify;
    private b gaN = null;
    private GroupSettingModel gaO = null;
    private ReportGroupModel gaQ = null;
    private com.baidu.adp.framework.listener.c gaF = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.chat.GroupSettingActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsedMessage)) {
                if (socketResponsedMessage.getCmd() == 103112) {
                    if (socketResponsedMessage.getError() != 0) {
                        GroupSettingActivity.this.hideProgressBar();
                        GroupSettingActivity.this.showToast(d.j.neterror);
                        return;
                    }
                    GroupSettingActivity.this.hideProgressBar();
                    GroupSettingActivity.this.showToast(d.j.group_quit_suc);
                    GroupSettingActivity.this.finish();
                } else if (socketResponsedMessage.getCmd() == 103102) {
                    if (socketResponsedMessage.getError() != 0) {
                        GroupSettingActivity.this.hideProgressBar();
                        GroupSettingActivity.this.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? GroupSettingActivity.this.getResources().getString(d.j.neterror) : socketResponsedMessage.getErrorString());
                        return;
                    }
                    GroupSettingActivity.this.hideProgressBar();
                    GroupSettingActivity.this.showToast(d.j.group_add_group_switch_success);
                    GroupSettingActivity.this.gaO.setFlag(GroupSettingActivity.this.gaP.getFlag());
                } else if (socketResponsedMessage.getCmd() == 103104) {
                    GroupSettingActivity.this.hideProgressBar();
                    if (socketResponsedMessage.getError() != 0) {
                        GroupSettingActivity.this.aG(socketResponsedMessage.getErrorString(), socketResponsedMessage.getError());
                        return;
                    }
                    TiebaStatic.log("dismiss_group_success");
                    GroupSettingActivity.this.showToast(d.j.group_dismiss_success, false);
                    GroupSettingActivity.this.finish();
                } else {
                    if (socketResponsedMessage.getCmd() == 2001137) {
                    }
                }
            }
        }
    };
    private final b.InterfaceC0225b gaS = new b.InterfaceC0225b() { // from class: com.baidu.tieba.im.chat.GroupSettingActivity.6
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0225b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (GroupSettingActivity.this.gaQ == null) {
                GroupSettingActivity.this.gaQ = new ReportGroupModel(GroupSettingActivity.this);
            }
            GroupSettingActivity.this.gaQ.setGroupId(com.baidu.adp.lib.g.b.d(GroupSettingActivity.this.gaO.getGroupId(), 0L));
            GroupSettingActivity.this.gaQ.setReportType(i);
            GroupSettingActivity.this.gaQ.sendMessage();
        }
    };
    private com.baidu.adp.framework.listener.c gaT = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.chat.GroupSettingActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 103103) {
                if (!(socketResponsedMessage instanceof ResponseReportGroupMessage)) {
                    GroupSettingActivity.this.showToast(d.j.group_report_fail);
                    return;
                }
                ResponseReportGroupMessage responseReportGroupMessage = (ResponseReportGroupMessage) socketResponsedMessage;
                if (responseReportGroupMessage.getError() != 0) {
                    GroupSettingActivity.this.aG(responseReportGroupMessage.getErrorString(), responseReportGroupMessage.getError());
                } else {
                    GroupSettingActivity.this.showToast(d.j.group_report_success);
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.c gaU = new com.baidu.adp.framework.listener.c(104101) { // from class: com.baidu.tieba.im.chat.GroupSettingActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            GroupSettingActivity.this.hideProgressBar();
            if ((socketResponsedMessage instanceof ResponseUpdateMaskMessage) && (socketResponsedMessage.getOrginalMessage() instanceof RequestUpdateMaskMessage)) {
                RequestUpdateMaskMessage requestUpdateMaskMessage = (RequestUpdateMaskMessage) socketResponsedMessage.getOrginalMessage();
                ResponseUpdateMaskMessage responseUpdateMaskMessage = (ResponseUpdateMaskMessage) socketResponsedMessage;
                if (responseUpdateMaskMessage.hasError()) {
                    GroupSettingActivity.this.showToast(StringUtils.isNull(responseUpdateMaskMessage.getErrorString()) ? GroupSettingActivity.this.getResources().getString(d.j.neterror) : responseUpdateMaskMessage.getErrorString());
                }
                GroupSettingActivity.this.P(!responseUpdateMaskMessage.hasError(), requestUpdateMaskMessage.isAdd());
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gaN = new b(this);
        this.gaO = new GroupSettingModel(this);
        this.gaP = new UpdateGroupModel(getPageContext());
        this.gaO.setUniqueId(getUniqueId());
        this.gaP.setUniqueId(getUniqueId());
        initData();
        this.gaN.setGroupName(this.gaO.getGroupName());
        this.gaN.a(this.gaS);
        this.gaN.kE(tx(this.gaO.getFlag()));
        this.gaN.initListener();
        this.gaR = new k<Boolean>() { // from class: com.baidu.tieba.im.chat.GroupSettingActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.k
            public void onReturnDataInUI(Boolean bool) {
                if (bool == null || !bool.equals(true)) {
                    GroupSettingActivity.this.gaN.bpY().ob();
                    GroupSettingActivity.this.isAcceptNotify = false;
                    return;
                }
                GroupSettingActivity.this.gaN.bpY().oa();
                GroupSettingActivity.this.isAcceptNotify = true;
            }
        };
        this.gaO.b(this.gaR);
        initListener();
    }

    private void initListener() {
        registerListener(103103, this.gaT);
        registerListener(103102, this.gaF);
        registerListener(103112, this.gaF);
        registerListener(103104, this.gaF);
        registerListener(2001137, this.gaF);
        registerListener(this.gaU);
    }

    public void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra(GroupSettingActivityConfig.INTENT_DATA_GROUP_NAME);
            String stringExtra2 = intent.getStringExtra(GroupSettingActivityConfig.INTENT_DATA_GROUP_ID);
            int intExtra = intent.getIntExtra(GroupSettingActivityConfig.INTENT_DATA_GROUP_FLAG, 0);
            if (intent.getBooleanExtra(GroupSettingActivityConfig.INTENT_DATA_IS_GROUP_MASTER, false)) {
                this.gaN.bpS();
                this.gaN.bpW();
                this.gaN.kD(true);
                this.gaN.bpV();
            } else {
                this.gaN.bpU();
                this.gaN.aOo();
                this.gaN.kD(false);
                this.gaN.bpT();
            }
            this.gaO.r(stringExtra2, stringExtra, intExtra);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gaN.onChangeSkinType(i);
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
            if (view.equals(this.gaN.bpL())) {
                sendMessage(new CustomMessage(2002001, new UpdateGroupActivityConfig(getPageContext().getPageActivity(), 1, com.baidu.adp.lib.g.b.d(this.gaO.getGroupId(), 0L), 1, this.gaO.getGroupName())));
            } else if (view.equals(this.gaN.bpM())) {
                this.gaN.bpQ();
            } else if (view.equals(this.gaN.bpO())) {
                this.gaN.aeZ();
            } else if (view.equals(this.gaN.bpK())) {
                finish();
            } else if (view.equals(this.gaN.bpP())) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.gD(d.j.alert_clear_cache_group);
                aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.chat.GroupSettingActivity.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        TiebaStatic.log("clear_group_msg_at_gsetting");
                        GroupSettingActivity.this.showLoadingDialog(GroupSettingActivity.this.getPageContext().getString(d.j.deleting));
                        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(GroupSettingActivity.this.gaO.getGroupId(), 1, null, 1)));
                        aa.b(new z<Boolean>() { // from class: com.baidu.tieba.im.chat.GroupSettingActivity.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.baidu.tbadk.util.z
                            public Boolean doInBackground() {
                                return Boolean.valueOf(com.baidu.tieba.im.db.c.bsh().wL(GroupSettingActivity.this.gaO.getGroupId()));
                            }
                        }, new k<Boolean>() { // from class: com.baidu.tieba.im.chat.GroupSettingActivity.2.2
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.k
                            public void onReturnDataInUI(Boolean bool) {
                                GroupSettingActivity.this.closeLoadingDialog();
                                MessageManager.getInstance().dispatchResponsedMessageToUI(new ClearChatMsgResponsedMessage());
                                GroupSettingActivity.this.showToast(d.j.delete_success, false);
                            }
                        });
                        aVar2.dismiss();
                    }
                });
                aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.GroupSettingActivity.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(getPageContext());
                aVar.aaZ();
            } else if (view == this.gaN.bpN()) {
                this.gaN.bpZ();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        Intent intent = new Intent();
        intent.putExtra(GroupSettingActivityConfig.INTENT_DATA_GROUP_FLAG, this.gaO.getFlag());
        setResult(-1, intent);
        super.finish();
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view != null) {
            if (view.equals(this.gaN.bpO())) {
                this.gaN.aeZ();
            } else if (view.equals(this.gaN.bpY())) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    if (!com.baidu.tbadk.coreExtra.messageCenter.d.aih().aij() || !com.baidu.tbadk.coreExtra.messageCenter.d.aih().aix()) {
                        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                        aVar.gD(d.j.error_open_group_single_alloff);
                        aVar.b(getResources().getString(d.j.signallforum_signnow), new a.b() { // from class: com.baidu.tieba.im.chat.GroupSettingActivity.4
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                            }
                        });
                        aVar.b(getPageContext());
                        aVar.aaZ();
                        P(false, BdSwitchView.SwitchState.ON == switchState);
                        return;
                    }
                    showProgressBar();
                    this.gaO.kC(BdSwitchView.SwitchState.ON == switchState);
                    return;
                }
                showProgressBar();
                this.gaO.kC(BdSwitchView.SwitchState.ON == switchState);
            } else if (view.equals(this.gaN.bpX())) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    ty(B(this.gaO.getFlag(), true));
                } else {
                    ty(B(this.gaO.getFlag(), false));
                }
            }
        }
    }

    private int B(int i, boolean z) {
        return z ? i & (-3) : i | 2;
    }

    private boolean tx(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void ty(int i) {
        if (this.gaP != null) {
            this.gaP.setGroupId(this.gaO.bpJ());
            this.gaP.setFlag(i);
            this.gaP.sendMessage(5);
            showProgressBar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(String str, int i) {
        if (i < 0) {
            showToast(d.j.neterror);
        } else if (TextUtils.isEmpty(str)) {
            showToast(d.j.group_report_fail);
        } else {
            showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.gaF);
        if (this.gaO != null) {
            this.gaO.cancelMessage();
        }
        if (this.gaQ != null) {
            this.gaQ.cancelMessage();
        }
        MessageManager.getInstance().unRegisterListener(this.gaT);
        if (this.gaN != null) {
            this.gaN.bqb();
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
            if (aVar == this.gaN.bpR()) {
                showProgressBar();
                this.gaO.cR(Long.parseLong(this.gaO.getGroupId()));
            }
            if (aVar == this.gaN.bqa()) {
                showProgressBar();
                this.gaO.cS(this.gaO.bpJ());
            }
            aVar.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(boolean z, final boolean z2) {
        if (z) {
            if (z2) {
                this.gaO.kB(true);
                if (!this.isAcceptNotify) {
                    MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(1));
                    this.isAcceptNotify = true;
                    return;
                }
                return;
            }
            this.gaO.kB(false);
            if (this.isAcceptNotify) {
                MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(1));
                this.isAcceptNotify = false;
                return;
            }
            return;
        }
        final BdSwitchView bpY = this.gaN.bpY();
        if (bpY != null) {
            com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.chat.GroupSettingActivity.9
                @Override // java.lang.Runnable
                public void run() {
                    if (z2) {
                        bpY.nZ();
                    } else {
                        bpY.nY();
                    }
                }
            }, 500L);
        }
    }
}
