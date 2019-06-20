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
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.ClearChatMsgResponsedMessage;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.ResponseReportGroupMessage;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.im.model.ReportGroupModel;
import com.baidu.tieba.im.model.UpdateGroupModel;
/* loaded from: classes5.dex */
public class GroupSettingActivity extends BaseActivity<GroupSettingActivity> implements BdSwitchView.a, a.b {
    private UpdateGroupModel grW;
    private k<Boolean> grY;
    private boolean isAcceptNotify;
    private b grU = null;
    private GroupSettingModel grV = null;
    private ReportGroupModel grX = null;
    private com.baidu.adp.framework.listener.c grM = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.chat.GroupSettingActivity.5
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
                    GroupSettingActivity.this.grV.setFlag(GroupSettingActivity.this.grW.getFlag());
                } else if (socketResponsedMessage.getCmd() == 103104) {
                    GroupSettingActivity.this.hideProgressBar();
                    if (socketResponsedMessage.getError() != 0) {
                        GroupSettingActivity.this.aC(socketResponsedMessage.getErrorString(), socketResponsedMessage.getError());
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
    private final b.a grZ = new b.a() { // from class: com.baidu.tieba.im.chat.GroupSettingActivity.6
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (GroupSettingActivity.this.grX == null) {
                GroupSettingActivity.this.grX = new ReportGroupModel(GroupSettingActivity.this);
            }
            GroupSettingActivity.this.grX.setGroupId(com.baidu.adp.lib.g.b.c(GroupSettingActivity.this.grV.getGroupId(), 0L));
            GroupSettingActivity.this.grX.setReportType(i);
            GroupSettingActivity.this.grX.sendMessage();
        }
    };
    private com.baidu.adp.framework.listener.c gsa = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.chat.GroupSettingActivity.7
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
                    GroupSettingActivity.this.aC(responseReportGroupMessage.getErrorString(), responseReportGroupMessage.getError());
                } else {
                    GroupSettingActivity.this.showToast(R.string.group_report_success);
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.c gsb = new com.baidu.adp.framework.listener.c(104101) { // from class: com.baidu.tieba.im.chat.GroupSettingActivity.8
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
                GroupSettingActivity.this.O(!responseUpdateMaskMessage.hasError(), requestUpdateMaskMessage.isAdd());
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.grU = new b(this);
        this.grV = new GroupSettingModel(this);
        this.grW = new UpdateGroupModel(getPageContext());
        this.grV.setUniqueId(getUniqueId());
        this.grW.setUniqueId(getUniqueId());
        initData();
        this.grU.setGroupName(this.grV.getGroupName());
        this.grU.a(this.grZ);
        this.grU.lu(uA(this.grV.getFlag()));
        this.grU.initListener();
        this.grY = new k<Boolean>() { // from class: com.baidu.tieba.im.chat.GroupSettingActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.k
            public void onReturnDataInUI(Boolean bool) {
                if (bool == null || !bool.equals(true)) {
                    GroupSettingActivity.this.grU.bxL().mW();
                    GroupSettingActivity.this.isAcceptNotify = false;
                    return;
                }
                GroupSettingActivity.this.grU.bxL().mV();
                GroupSettingActivity.this.isAcceptNotify = true;
            }
        };
        this.grV.b(this.grY);
        initListener();
    }

    private void initListener() {
        registerListener(103103, this.gsa);
        registerListener(103102, this.grM);
        registerListener(103112, this.grM);
        registerListener(103104, this.grM);
        registerListener(2001137, this.grM);
        registerListener(this.gsb);
    }

    public void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra(GroupSettingActivityConfig.INTENT_DATA_GROUP_NAME);
            String stringExtra2 = intent.getStringExtra(GroupSettingActivityConfig.INTENT_DATA_GROUP_ID);
            int intExtra = intent.getIntExtra(GroupSettingActivityConfig.INTENT_DATA_GROUP_FLAG, 0);
            if (intent.getBooleanExtra(GroupSettingActivityConfig.INTENT_DATA_IS_GROUP_MASTER, false)) {
                this.grU.bxF();
                this.grU.bxJ();
                this.grU.lt(true);
                this.grU.bxI();
            } else {
                this.grU.bxH();
                this.grU.aUr();
                this.grU.lt(false);
                this.grU.bxG();
            }
            this.grV.q(stringExtra2, stringExtra, intExtra);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.grU.onChangeSkinType(i);
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
            if (view.equals(this.grU.bxy())) {
                sendMessage(new CustomMessage(2002001, new UpdateGroupActivityConfig(getPageContext().getPageActivity(), 1, com.baidu.adp.lib.g.b.c(this.grV.getGroupId(), 0L), 1, this.grV.getGroupName())));
            } else if (view.equals(this.grU.bxz())) {
                this.grU.bxD();
            } else if (view.equals(this.grU.bxB())) {
                this.grU.ajV();
            } else if (view.equals(this.grU.bxx())) {
                finish();
            } else if (view.equals(this.grU.bxC())) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.ho(R.string.alert_clear_cache_group);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.chat.GroupSettingActivity.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        TiebaStatic.log("clear_group_msg_at_gsetting");
                        GroupSettingActivity.this.showLoadingDialog(GroupSettingActivity.this.getPageContext().getString(R.string.deleting));
                        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(GroupSettingActivity.this.grV.getGroupId(), 1, null, 1)));
                        aa.b(new z<Boolean>() { // from class: com.baidu.tieba.im.chat.GroupSettingActivity.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.baidu.tbadk.util.z
                            public Boolean doInBackground() {
                                return Boolean.valueOf(com.baidu.tieba.im.db.c.bzU().yb(GroupSettingActivity.this.grV.getGroupId()));
                            }
                        }, new k<Boolean>() { // from class: com.baidu.tieba.im.chat.GroupSettingActivity.2.2
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.k
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
                aVar.afG();
            } else if (view == this.grU.bxA()) {
                this.grU.bxM();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        Intent intent = new Intent();
        intent.putExtra(GroupSettingActivityConfig.INTENT_DATA_GROUP_FLAG, this.grV.getFlag());
        setResult(-1, intent);
        super.finish();
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view != null) {
            if (view.equals(this.grU.bxB())) {
                this.grU.ajV();
            } else if (view.equals(this.grU.bxL())) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    if (!com.baidu.tbadk.coreExtra.messageCenter.d.anf().anh() || !com.baidu.tbadk.coreExtra.messageCenter.d.anf().anv()) {
                        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                        aVar.ho(R.string.error_open_group_single_alloff);
                        aVar.b(getResources().getString(R.string.signallforum_signnow), new a.b() { // from class: com.baidu.tieba.im.chat.GroupSettingActivity.4
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                            }
                        });
                        aVar.b(getPageContext());
                        aVar.afG();
                        O(false, BdSwitchView.SwitchState.ON == switchState);
                        return;
                    }
                    showProgressBar();
                    this.grV.ls(BdSwitchView.SwitchState.ON == switchState);
                    return;
                }
                showProgressBar();
                this.grV.ls(BdSwitchView.SwitchState.ON == switchState);
            } else if (view.equals(this.grU.bxK())) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    uB(G(this.grV.getFlag(), true));
                } else {
                    uB(G(this.grV.getFlag(), false));
                }
            }
        }
    }

    private int G(int i, boolean z) {
        return z ? i & (-3) : i | 2;
    }

    private boolean uA(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void uB(int i) {
        if (this.grW != null) {
            this.grW.setGroupId(this.grV.bxw());
            this.grW.setFlag(i);
            this.grW.sendMessage(5);
            showProgressBar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aC(String str, int i) {
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
        MessageManager.getInstance().unRegisterListener(this.grM);
        if (this.grV != null) {
            this.grV.cancelMessage();
        }
        if (this.grX != null) {
            this.grX.cancelMessage();
        }
        MessageManager.getInstance().unRegisterListener(this.gsa);
        if (this.grU != null) {
            this.grU.bxO();
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
            if (aVar == this.grU.bxE()) {
                showProgressBar();
                this.grV.m21do(Long.parseLong(this.grV.getGroupId()));
            }
            if (aVar == this.grU.bxN()) {
                showProgressBar();
                this.grV.dp(this.grV.bxw());
            }
            aVar.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(boolean z, final boolean z2) {
        if (z) {
            if (z2) {
                this.grV.lr(true);
                if (!this.isAcceptNotify) {
                    MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(1));
                    this.isAcceptNotify = true;
                    return;
                }
                return;
            }
            this.grV.lr(false);
            if (this.isAcceptNotify) {
                MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(1));
                this.isAcceptNotify = false;
                return;
            }
            return;
        }
        final BdSwitchView bxL = this.grU.bxL();
        if (bxL != null) {
            com.baidu.adp.lib.g.e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.chat.GroupSettingActivity.9
                @Override // java.lang.Runnable
                public void run() {
                    if (z2) {
                        bxL.mU();
                    } else {
                        bxL.mT();
                    }
                }
            }, 500L);
        }
    }
}
