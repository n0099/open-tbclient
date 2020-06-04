package com.baidu.tieba.im.groupActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.c;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.ResponseDelGroupActivityMessage;
import com.baidu.tieba.im.message.ResponseGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.ResponseGetGroupActivityMessage;
import com.baidu.tieba.im.util.DialogUtil;
/* loaded from: classes10.dex */
public class GroupActivityActivity extends BaseActivity<GroupActivityActivity> implements View.OnClickListener, k.c {
    private b iDk;
    private GroupActivityModel iDl;
    private CustomMessageListener mCustomListener = new CustomMessageListener(CmdConfigCustom.CMD_REQUEST_GROUP_ACTIVITY_BY_ID_LOCAL) { // from class: com.baidu.tieba.im.groupActivity.GroupActivityActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!(customResponsedMessage instanceof ResponseGetGroupActivityLocalMessage)) {
                GroupActivityActivity.this.iDl.sendMessage(GroupActivityActivity.this.iDl.cni());
                return;
            }
            ResponseGetGroupActivityLocalMessage responseGetGroupActivityLocalMessage = (ResponseGetGroupActivityLocalMessage) customResponsedMessage;
            if (GroupActivityActivity.this.iDl.getLocalSendMsg() == responseGetGroupActivityLocalMessage.getOrginalMessage()) {
                if (responseGetGroupActivityLocalMessage.getError() != 0) {
                    GroupActivityActivity.this.iDl.sendMessage(GroupActivityActivity.this.iDl.cni());
                    return;
                }
                GroupActivityActivity.this.iDk.a(responseGetGroupActivityLocalMessage.getActivityData(), true);
                GroupActivityActivity.this.iDl.a(responseGetGroupActivityLocalMessage.getActivityData());
                GroupActivityActivity.this.iDl.sendMessage(GroupActivityActivity.this.iDl.cni());
            }
        }
    };
    private c isB = new c(0) { // from class: com.baidu.tieba.im.groupActivity.GroupActivityActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage == null) {
                GroupActivityActivity.this.hideProgressBar();
                GroupActivityActivity.this.showToast(R.string.neterror);
            } else if (socketResponsedMessage.getCmd() == 103015) {
                GroupActivityActivity.this.hideProgressBar();
                if (!(socketResponsedMessage instanceof ResponseGetGroupActivityMessage)) {
                    GroupActivityActivity.this.showToast(R.string.neterror);
                    return;
                }
                ResponseGetGroupActivityMessage responseGetGroupActivityMessage = (ResponseGetGroupActivityMessage) socketResponsedMessage;
                if (GroupActivityActivity.this.iDl.getSendMsg() == responseGetGroupActivityMessage.getOrginalMessage()) {
                    if (responseGetGroupActivityMessage.getError() == 2230504) {
                        GroupActivityActivity.this.showToast(StringUtils.isNull(responseGetGroupActivityMessage.getErrorString()) ? GroupActivityActivity.this.getResources().getString(R.string.neterror) : responseGetGroupActivityMessage.getErrorString(), false);
                        GroupActivityActivity.this.finish();
                    } else if (responseGetGroupActivityMessage.getError() == 0) {
                        GroupActivityActivity.this.iDl.a(responseGetGroupActivityMessage.getActivityData());
                        GroupActivityActivity.this.iDk.a(responseGetGroupActivityMessage.getActivityData(), false);
                    } else {
                        GroupActivityActivity.this.showToast(R.string.neterror);
                    }
                }
            } else if (socketResponsedMessage.getCmd() == 103121) {
                GroupActivityActivity.this.hideProgressBar();
                if (!(socketResponsedMessage instanceof ResponseDelGroupActivityMessage)) {
                    GroupActivityActivity.this.showToast(R.string.neterror);
                    return;
                }
                ResponseDelGroupActivityMessage responseDelGroupActivityMessage = (ResponseDelGroupActivityMessage) socketResponsedMessage;
                if (GroupActivityActivity.this.iDl.cnk() == responseDelGroupActivityMessage.getOrginalMessage()) {
                    if (responseDelGroupActivityMessage.getError() != 0) {
                        GroupActivityActivity.this.showToast(StringUtils.isNull(responseDelGroupActivityMessage.getErrorString()) ? GroupActivityActivity.this.getResources().getString(R.string.neterror) : responseDelGroupActivityMessage.getErrorString());
                        return;
                    }
                    GroupActivityActivity.this.showToast(R.string.group_activity_delete_succ, false);
                    GroupActivityActivity.this.finish();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initListener();
        if (this.iDl == null) {
            this.iDl = new GroupActivityModel(this);
            this.iDl.setUniqueId(getUniqueId());
        }
        if (bundle != null) {
            this.iDl.xM(bundle.getInt("activity_id", 0));
            this.iDl.eB(bundle.getLong("group_id", 0L));
            this.iDl.xL(bundle.getInt("from", 0));
        } else if (getIntent() != null) {
            this.iDl.xM(getIntent().getIntExtra("activity_id", 0));
            this.iDl.eB(getIntent().getLongExtra("group_id", 0L));
            this.iDl.xL(getIntent().getIntExtra("from", 0));
        }
        initUI();
        startLoading();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initListener();
        initUI();
        if (this.iDl == null) {
            this.iDl = new GroupActivityModel(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null) {
            this.iDl.xM(intent.getIntExtra("activity_id", 0));
            this.iDl.eB(intent.getLongExtra("group_id", 0L));
            this.iDl.xL(intent.getIntExtra("from", 0));
        }
        startLoading();
    }

    private void initListener() {
        registerListener(CmdConfigSocket.CMD_GET_GROUP_ACTIVITY, this.isB);
        registerListener(this.mCustomListener);
        registerListener(CmdConfigSocket.CMD_DEL_GROUP_ACTIVITY, this.isB);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.iDl != null) {
            bundle.putInt("activity_id", this.iDl.cni());
            bundle.putLong("group_id", this.iDl.cnj());
            bundle.putInt("from", this.iDl.cnh());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.iDl.cancelMessage();
        if (this.iDk != null) {
            this.iDk.onDestory();
        }
    }

    private void initUI() {
        if (this.iDk == null) {
            this.iDk = new b(this);
        }
    }

    private void startLoading() {
        showProgressBar();
        this.iDl.xP(this.iDl.cni());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iDk != null) {
            this.iDk.changeSkinType(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iDk.cnm()) {
            closeActivity();
        } else if (view == this.iDk.cnn()) {
            DialogUtil.deleteGroupActivity(getPageContext().getContext(), new a.b() { // from class: com.baidu.tieba.im.groupActivity.GroupActivityActivity.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    GroupActivityActivity.this.showProgressBar();
                    GroupActivityActivity.this.iDl.r(GroupActivityActivity.this.iDl.cnj(), GroupActivityActivity.this.iDl.cni());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_EDIT_GROUP_ACTIVITY_CODE /* 23001 */:
                    finish();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.tbadk.core.dialog.k.c
    public void a(k kVar, int i, View view) {
        if (kVar != null && this.iDk != null && this.iDk.cno() != null && kVar.getRootView() == this.iDk.cno().getContentView()) {
            this.iDk.cno().dismiss();
            if (i == 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateGroupActivityActivityConfig(getPageContext().getPageActivity(), this.iDl.cnj(), this.iDl.cnl(), RequestResponseCode.REQUEST_EDIT_GROUP_ACTIVITY_CODE)));
            } else if (i == 1) {
                DialogUtil.deleteGroupActivity(getPageContext().getContext(), new a.b() { // from class: com.baidu.tieba.im.groupActivity.GroupActivityActivity.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        GroupActivityActivity.this.showProgressBar();
                        GroupActivityActivity.this.iDl.r(GroupActivityActivity.this.iDl.cnj(), GroupActivityActivity.this.iDl.cni());
                    }
                });
            }
        }
    }
}
