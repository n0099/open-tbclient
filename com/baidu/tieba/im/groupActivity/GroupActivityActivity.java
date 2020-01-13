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
/* loaded from: classes8.dex */
public class GroupActivityActivity extends BaseActivity<GroupActivityActivity> implements View.OnClickListener, k.c {
    private b hAi;
    private GroupActivityModel hAj;
    private CustomMessageListener mCustomListener = new CustomMessageListener(CmdConfigCustom.CMD_REQUEST_GROUP_ACTIVITY_BY_ID_LOCAL) { // from class: com.baidu.tieba.im.groupActivity.GroupActivityActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!(customResponsedMessage instanceof ResponseGetGroupActivityLocalMessage)) {
                GroupActivityActivity.this.hAj.sendMessage(GroupActivityActivity.this.hAj.bUg());
                return;
            }
            ResponseGetGroupActivityLocalMessage responseGetGroupActivityLocalMessage = (ResponseGetGroupActivityLocalMessage) customResponsedMessage;
            if (GroupActivityActivity.this.hAj.getLocalSendMsg() == responseGetGroupActivityLocalMessage.getOrginalMessage()) {
                if (responseGetGroupActivityLocalMessage.getError() != 0) {
                    GroupActivityActivity.this.hAj.sendMessage(GroupActivityActivity.this.hAj.bUg());
                    return;
                }
                GroupActivityActivity.this.hAi.a(responseGetGroupActivityLocalMessage.getActivityData(), true);
                GroupActivityActivity.this.hAj.a(responseGetGroupActivityLocalMessage.getActivityData());
                GroupActivityActivity.this.hAj.sendMessage(GroupActivityActivity.this.hAj.bUg());
            }
        }
    };
    private c hpz = new c(0) { // from class: com.baidu.tieba.im.groupActivity.GroupActivityActivity.3
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
                if (GroupActivityActivity.this.hAj.getSendMsg() == responseGetGroupActivityMessage.getOrginalMessage()) {
                    if (responseGetGroupActivityMessage.getError() == 2230504) {
                        GroupActivityActivity.this.showToast(StringUtils.isNull(responseGetGroupActivityMessage.getErrorString()) ? GroupActivityActivity.this.getResources().getString(R.string.neterror) : responseGetGroupActivityMessage.getErrorString(), false);
                        GroupActivityActivity.this.finish();
                    } else if (responseGetGroupActivityMessage.getError() == 0) {
                        GroupActivityActivity.this.hAj.a(responseGetGroupActivityMessage.getActivityData());
                        GroupActivityActivity.this.hAi.a(responseGetGroupActivityMessage.getActivityData(), false);
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
                if (GroupActivityActivity.this.hAj.bUi() == responseDelGroupActivityMessage.getOrginalMessage()) {
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
        if (this.hAj == null) {
            this.hAj = new GroupActivityModel(this);
            this.hAj.setUniqueId(getUniqueId());
        }
        if (bundle != null) {
            this.hAj.ws(bundle.getInt("activity_id", 0));
            this.hAj.dQ(bundle.getLong("group_id", 0L));
            this.hAj.wr(bundle.getInt("from", 0));
        } else if (getIntent() != null) {
            this.hAj.ws(getIntent().getIntExtra("activity_id", 0));
            this.hAj.dQ(getIntent().getLongExtra("group_id", 0L));
            this.hAj.wr(getIntent().getIntExtra("from", 0));
        }
        initUI();
        startLoading();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initListener();
        initUI();
        if (this.hAj == null) {
            this.hAj = new GroupActivityModel(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null) {
            this.hAj.ws(intent.getIntExtra("activity_id", 0));
            this.hAj.dQ(intent.getLongExtra("group_id", 0L));
            this.hAj.wr(intent.getIntExtra("from", 0));
        }
        startLoading();
    }

    private void initListener() {
        registerListener(CmdConfigSocket.CMD_GET_GROUP_ACTIVITY, this.hpz);
        registerListener(this.mCustomListener);
        registerListener(CmdConfigSocket.CMD_DEL_GROUP_ACTIVITY, this.hpz);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.hAj != null) {
            bundle.putInt("activity_id", this.hAj.bUg());
            bundle.putLong("group_id", this.hAj.bUh());
            bundle.putInt("from", this.hAj.bUf());
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
        this.hAj.cancelMessage();
        if (this.hAi != null) {
            this.hAi.onDestory();
        }
    }

    private void initUI() {
        if (this.hAi == null) {
            this.hAi = new b(this);
        }
    }

    private void startLoading() {
        showProgressBar();
        this.hAj.wv(this.hAj.bUg());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hAi != null) {
            this.hAi.changeSkinType(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hAi.bUk()) {
            closeActivity();
        } else if (view == this.hAi.bUl()) {
            DialogUtil.deleteGroupActivity(getPageContext().getContext(), new a.b() { // from class: com.baidu.tieba.im.groupActivity.GroupActivityActivity.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    GroupActivityActivity.this.showProgressBar();
                    GroupActivityActivity.this.hAj.r(GroupActivityActivity.this.hAj.bUh(), GroupActivityActivity.this.hAj.bUg());
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
        if (kVar != null && this.hAi != null && this.hAi.bUm() != null && kVar.getRootView() == this.hAi.bUm().getContentView()) {
            this.hAi.bUm().dismiss();
            if (i == 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateGroupActivityActivityConfig(getPageContext().getPageActivity(), this.hAj.bUh(), this.hAj.bUj(), RequestResponseCode.REQUEST_EDIT_GROUP_ACTIVITY_CODE)));
            } else if (i == 1) {
                DialogUtil.deleteGroupActivity(getPageContext().getContext(), new a.b() { // from class: com.baidu.tieba.im.groupActivity.GroupActivityActivity.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        GroupActivityActivity.this.showProgressBar();
                        GroupActivityActivity.this.hAj.r(GroupActivityActivity.this.hAj.bUh(), GroupActivityActivity.this.hAj.bUg());
                    }
                });
            }
        }
    }
}
