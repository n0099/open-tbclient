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
import com.baidu.tieba.f;
import com.baidu.tieba.im.message.ResponseDelGroupActivityMessage;
import com.baidu.tieba.im.message.ResponseGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.ResponseGetGroupActivityMessage;
import com.baidu.tieba.im.util.DialogUtil;
/* loaded from: classes3.dex */
public class GroupActivityActivity extends BaseActivity<GroupActivityActivity> implements View.OnClickListener, b.InterfaceC0101b {
    private GroupActivityModel euA;
    private b euz;
    private CustomMessageListener mCustomListener = new CustomMessageListener(2001123) { // from class: com.baidu.tieba.im.groupActivity.GroupActivityActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!(customResponsedMessage instanceof ResponseGetGroupActivityLocalMessage)) {
                GroupActivityActivity.this.euA.sendMessage(GroupActivityActivity.this.euA.aKU());
                return;
            }
            ResponseGetGroupActivityLocalMessage responseGetGroupActivityLocalMessage = (ResponseGetGroupActivityLocalMessage) customResponsedMessage;
            if (GroupActivityActivity.this.euA.getLocalSendMsg() == responseGetGroupActivityLocalMessage.getOrginalMessage()) {
                if (responseGetGroupActivityLocalMessage.getError() != 0) {
                    GroupActivityActivity.this.euA.sendMessage(GroupActivityActivity.this.euA.aKU());
                    return;
                }
                GroupActivityActivity.this.euz.a(responseGetGroupActivityLocalMessage.getActivityData(), true);
                GroupActivityActivity.this.euA.a(responseGetGroupActivityLocalMessage.getActivityData());
                GroupActivityActivity.this.euA.sendMessage(GroupActivityActivity.this.euA.aKU());
            }
        }
    };
    private c ejH = new c(0) { // from class: com.baidu.tieba.im.groupActivity.GroupActivityActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage == null) {
                GroupActivityActivity.this.hideProgressBar();
                GroupActivityActivity.this.showToast(f.j.neterror);
            } else if (socketResponsedMessage.getCmd() == 103015) {
                GroupActivityActivity.this.hideProgressBar();
                if (!(socketResponsedMessage instanceof ResponseGetGroupActivityMessage)) {
                    GroupActivityActivity.this.showToast(f.j.neterror);
                    return;
                }
                ResponseGetGroupActivityMessage responseGetGroupActivityMessage = (ResponseGetGroupActivityMessage) socketResponsedMessage;
                if (GroupActivityActivity.this.euA.getSendMsg() == responseGetGroupActivityMessage.getOrginalMessage()) {
                    if (responseGetGroupActivityMessage.getError() == 2230504) {
                        GroupActivityActivity.this.showToast(StringUtils.isNull(responseGetGroupActivityMessage.getErrorString()) ? GroupActivityActivity.this.getResources().getString(f.j.neterror) : responseGetGroupActivityMessage.getErrorString(), false);
                        GroupActivityActivity.this.finish();
                    } else if (responseGetGroupActivityMessage.getError() == 0) {
                        GroupActivityActivity.this.euA.a(responseGetGroupActivityMessage.getActivityData());
                        GroupActivityActivity.this.euz.a(responseGetGroupActivityMessage.getActivityData(), false);
                    } else {
                        GroupActivityActivity.this.showToast(f.j.neterror);
                    }
                }
            } else if (socketResponsedMessage.getCmd() == 103121) {
                GroupActivityActivity.this.hideProgressBar();
                if (!(socketResponsedMessage instanceof ResponseDelGroupActivityMessage)) {
                    GroupActivityActivity.this.showToast(f.j.neterror);
                    return;
                }
                ResponseDelGroupActivityMessage responseDelGroupActivityMessage = (ResponseDelGroupActivityMessage) socketResponsedMessage;
                if (GroupActivityActivity.this.euA.aKW() == responseDelGroupActivityMessage.getOrginalMessage()) {
                    if (responseDelGroupActivityMessage.getError() != 0) {
                        GroupActivityActivity.this.showToast(StringUtils.isNull(responseDelGroupActivityMessage.getErrorString()) ? GroupActivityActivity.this.getResources().getString(f.j.neterror) : responseDelGroupActivityMessage.getErrorString());
                        return;
                    }
                    GroupActivityActivity.this.showToast(f.j.group_activity_delete_succ, false);
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
        if (this.euA == null) {
            this.euA = new GroupActivityModel(this);
            this.euA.setUniqueId(getUniqueId());
        }
        if (bundle != null) {
            this.euA.oj(bundle.getInt(GroupActivityActivityConfig.ACTIVITY_ID, 0));
            this.euA.cc(bundle.getLong("group_id", 0L));
            this.euA.oi(bundle.getInt("from", 0));
        } else if (getIntent() != null) {
            this.euA.oj(getIntent().getIntExtra(GroupActivityActivityConfig.ACTIVITY_ID, 0));
            this.euA.cc(getIntent().getLongExtra("group_id", 0L));
            this.euA.oi(getIntent().getIntExtra("from", 0));
        }
        initUI();
        startLoading();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initListener();
        initUI();
        if (this.euA == null) {
            this.euA = new GroupActivityModel(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null) {
            this.euA.oj(intent.getIntExtra(GroupActivityActivityConfig.ACTIVITY_ID, 0));
            this.euA.cc(intent.getLongExtra("group_id", 0L));
            this.euA.oi(intent.getIntExtra("from", 0));
        }
        startLoading();
    }

    private void initListener() {
        registerListener(103015, this.ejH);
        registerListener(this.mCustomListener);
        registerListener(103121, this.ejH);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.euA != null) {
            bundle.putInt(GroupActivityActivityConfig.ACTIVITY_ID, this.euA.aKU());
            bundle.putLong("group_id", this.euA.aKV());
            bundle.putInt("from", this.euA.aKT());
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
        this.euA.cancelMessage();
        if (this.euz != null) {
            this.euz.onDestory();
        }
    }

    private void initUI() {
        if (this.euz == null) {
            this.euz = new b(this);
        }
    }

    private void startLoading() {
        showProgressBar();
        this.euA.om(this.euA.aKU());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.euz != null) {
            this.euz.changeSkinType(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.euz.aKY()) {
            closeActivity();
        } else if (view == this.euz.aKZ()) {
            DialogUtil.deleteGroupActivity(getPageContext().getContext(), new a.b() { // from class: com.baidu.tieba.im.groupActivity.GroupActivityActivity.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    GroupActivityActivity.this.showProgressBar();
                    GroupActivityActivity.this.euA.j(GroupActivityActivity.this.euA.aKV(), GroupActivityActivity.this.euA.aKU());
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

    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
    public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
        if (bVar != null && bVar == this.euz.aLa()) {
            bVar.dismiss();
            if (i == 0) {
                sendMessage(new CustomMessage(2002001, new CreateGroupActivityActivityConfig(getPageContext().getPageActivity(), this.euA.aKV(), this.euA.aKX(), 23001)));
            } else if (i == 1) {
                DialogUtil.deleteGroupActivity(getPageContext().getContext(), new a.b() { // from class: com.baidu.tieba.im.groupActivity.GroupActivityActivity.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        GroupActivityActivity.this.showProgressBar();
                        GroupActivityActivity.this.euA.j(GroupActivityActivity.this.euA.aKV(), GroupActivityActivity.this.euA.aKU());
                    }
                });
            }
        }
    }
}
