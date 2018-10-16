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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tieba.e;
import com.baidu.tieba.im.message.ResponseDelGroupActivityMessage;
import com.baidu.tieba.im.message.ResponseGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.ResponseGetGroupActivityMessage;
import com.baidu.tieba.im.util.DialogUtil;
/* loaded from: classes3.dex */
public class GroupActivityActivity extends BaseActivity<GroupActivityActivity> implements View.OnClickListener, b.InterfaceC0124b {
    private b eJB;
    private GroupActivityModel eJC;
    private CustomMessageListener mCustomListener = new CustomMessageListener(2001123) { // from class: com.baidu.tieba.im.groupActivity.GroupActivityActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!(customResponsedMessage instanceof ResponseGetGroupActivityLocalMessage)) {
                GroupActivityActivity.this.eJC.sendMessage(GroupActivityActivity.this.eJC.aQy());
                return;
            }
            ResponseGetGroupActivityLocalMessage responseGetGroupActivityLocalMessage = (ResponseGetGroupActivityLocalMessage) customResponsedMessage;
            if (GroupActivityActivity.this.eJC.getLocalSendMsg() == responseGetGroupActivityLocalMessage.getOrginalMessage()) {
                if (responseGetGroupActivityLocalMessage.getError() != 0) {
                    GroupActivityActivity.this.eJC.sendMessage(GroupActivityActivity.this.eJC.aQy());
                    return;
                }
                GroupActivityActivity.this.eJB.a(responseGetGroupActivityLocalMessage.getActivityData(), true);
                GroupActivityActivity.this.eJC.a(responseGetGroupActivityLocalMessage.getActivityData());
                GroupActivityActivity.this.eJC.sendMessage(GroupActivityActivity.this.eJC.aQy());
            }
        }
    };
    private c eyR = new c(0) { // from class: com.baidu.tieba.im.groupActivity.GroupActivityActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage == null) {
                GroupActivityActivity.this.hideProgressBar();
                GroupActivityActivity.this.showToast(e.j.neterror);
            } else if (socketResponsedMessage.getCmd() == 103015) {
                GroupActivityActivity.this.hideProgressBar();
                if (!(socketResponsedMessage instanceof ResponseGetGroupActivityMessage)) {
                    GroupActivityActivity.this.showToast(e.j.neterror);
                    return;
                }
                ResponseGetGroupActivityMessage responseGetGroupActivityMessage = (ResponseGetGroupActivityMessage) socketResponsedMessage;
                if (GroupActivityActivity.this.eJC.getSendMsg() == responseGetGroupActivityMessage.getOrginalMessage()) {
                    if (responseGetGroupActivityMessage.getError() == 2230504) {
                        GroupActivityActivity.this.showToast(StringUtils.isNull(responseGetGroupActivityMessage.getErrorString()) ? GroupActivityActivity.this.getResources().getString(e.j.neterror) : responseGetGroupActivityMessage.getErrorString(), false);
                        GroupActivityActivity.this.finish();
                    } else if (responseGetGroupActivityMessage.getError() == 0) {
                        GroupActivityActivity.this.eJC.a(responseGetGroupActivityMessage.getActivityData());
                        GroupActivityActivity.this.eJB.a(responseGetGroupActivityMessage.getActivityData(), false);
                    } else {
                        GroupActivityActivity.this.showToast(e.j.neterror);
                    }
                }
            } else if (socketResponsedMessage.getCmd() == 103121) {
                GroupActivityActivity.this.hideProgressBar();
                if (!(socketResponsedMessage instanceof ResponseDelGroupActivityMessage)) {
                    GroupActivityActivity.this.showToast(e.j.neterror);
                    return;
                }
                ResponseDelGroupActivityMessage responseDelGroupActivityMessage = (ResponseDelGroupActivityMessage) socketResponsedMessage;
                if (GroupActivityActivity.this.eJC.aQA() == responseDelGroupActivityMessage.getOrginalMessage()) {
                    if (responseDelGroupActivityMessage.getError() != 0) {
                        GroupActivityActivity.this.showToast(StringUtils.isNull(responseDelGroupActivityMessage.getErrorString()) ? GroupActivityActivity.this.getResources().getString(e.j.neterror) : responseDelGroupActivityMessage.getErrorString());
                        return;
                    }
                    GroupActivityActivity.this.showToast(e.j.group_activity_delete_succ, false);
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
        if (this.eJC == null) {
            this.eJC = new GroupActivityModel(this);
            this.eJC.setUniqueId(getUniqueId());
        }
        if (bundle != null) {
            this.eJC.pl(bundle.getInt(GroupActivityActivityConfig.ACTIVITY_ID, 0));
            this.eJC.cn(bundle.getLong("group_id", 0L));
            this.eJC.pk(bundle.getInt("from", 0));
        } else if (getIntent() != null) {
            this.eJC.pl(getIntent().getIntExtra(GroupActivityActivityConfig.ACTIVITY_ID, 0));
            this.eJC.cn(getIntent().getLongExtra("group_id", 0L));
            this.eJC.pk(getIntent().getIntExtra("from", 0));
        }
        initUI();
        startLoading();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initListener();
        initUI();
        if (this.eJC == null) {
            this.eJC = new GroupActivityModel(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null) {
            this.eJC.pl(intent.getIntExtra(GroupActivityActivityConfig.ACTIVITY_ID, 0));
            this.eJC.cn(intent.getLongExtra("group_id", 0L));
            this.eJC.pk(intent.getIntExtra("from", 0));
        }
        startLoading();
    }

    private void initListener() {
        registerListener(103015, this.eyR);
        registerListener(this.mCustomListener);
        registerListener(103121, this.eyR);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.eJC != null) {
            bundle.putInt(GroupActivityActivityConfig.ACTIVITY_ID, this.eJC.aQy());
            bundle.putLong("group_id", this.eJC.aQz());
            bundle.putInt("from", this.eJC.aQx());
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
        this.eJC.cancelMessage();
        if (this.eJB != null) {
            this.eJB.onDestory();
        }
    }

    private void initUI() {
        if (this.eJB == null) {
            this.eJB = new b(this);
        }
    }

    private void startLoading() {
        showProgressBar();
        this.eJC.po(this.eJC.aQy());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eJB != null) {
            this.eJB.changeSkinType(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eJB.aQC()) {
            closeActivity();
        } else if (view == this.eJB.aQD()) {
            DialogUtil.deleteGroupActivity(getPageContext().getContext(), new a.b() { // from class: com.baidu.tieba.im.groupActivity.GroupActivityActivity.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    GroupActivityActivity.this.showProgressBar();
                    GroupActivityActivity.this.eJC.m(GroupActivityActivity.this.eJC.aQz(), GroupActivityActivity.this.eJC.aQy());
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
                case 23001:
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

    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0124b
    public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
        if (bVar != null && bVar == this.eJB.aQE()) {
            bVar.dismiss();
            if (i == 0) {
                sendMessage(new CustomMessage(2002001, new CreateGroupActivityActivityConfig(getPageContext().getPageActivity(), this.eJC.aQz(), this.eJC.aQB(), 23001)));
            } else if (i == 1) {
                DialogUtil.deleteGroupActivity(getPageContext().getContext(), new a.b() { // from class: com.baidu.tieba.im.groupActivity.GroupActivityActivity.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        GroupActivityActivity.this.showProgressBar();
                        GroupActivityActivity.this.eJC.m(GroupActivityActivity.this.eJC.aQz(), GroupActivityActivity.this.eJC.aQy());
                    }
                });
            }
        }
    }
}
