package com.baidu.tieba.im.groupActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.c;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.d;
import com.baidu.tieba.im.message.ResponseCreateGroupActivityMessage;
import com.baidu.tieba.im.util.DialogUtil;
/* loaded from: classes3.dex */
public class CreateGroupActivityActivity extends BaseActivity implements View.OnClickListener {
    private a ebd;
    private CreateGroupActivityModel ebe;
    private boolean ebf = false;
    private c dQP = new c(103120) { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            CreateGroupActivityActivity.this.hideProgressBar();
            if (socketResponsedMessage == null) {
                CreateGroupActivityActivity.this.showToast(d.k.neterror);
            } else if (socketResponsedMessage.getCmd() == 103120) {
                if (socketResponsedMessage instanceof ResponseCreateGroupActivityMessage) {
                    ResponseCreateGroupActivityMessage responseCreateGroupActivityMessage = (ResponseCreateGroupActivityMessage) socketResponsedMessage;
                    if (responseCreateGroupActivityMessage.getError() == 0) {
                        if (CreateGroupActivityActivity.this.ebf) {
                            CreateGroupActivityActivity.this.showToast(d.k.group_activity_edit_succ);
                        } else {
                            CreateGroupActivityActivity.this.showToast(d.k.group_activity_create_succ);
                        }
                        CreateGroupActivityActivity.this.setResult(-1);
                        CreateGroupActivityActivity.this.finish();
                        return;
                    }
                    CreateGroupActivityActivity.this.showToast(StringUtils.isNull(responseCreateGroupActivityMessage.getErrorString()) ? CreateGroupActivityActivity.this.getResources().getString(d.k.neterror) : responseCreateGroupActivityMessage.getErrorString());
                } else if (socketResponsedMessage.getError() != 0) {
                    CreateGroupActivityActivity.this.showToast(socketResponsedMessage.getErrorString());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initListener();
        this.ebe = new CreateGroupActivityModel(this);
        this.ebd = new a(this);
        if (this.ebe.aEm() != null) {
            if (bundle != null) {
                this.ebe.aEm().setGroupId(bundle.getLong("gid", 0L));
                this.ebf = bundle.getBoolean(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.ebf) {
                    this.ebe.aEm().setActivityId(bundle.getInt("aid", 0));
                    this.ebe.aEm().setgActivityTitle(bundle.getString("name"));
                    this.ebe.aEm().setgActivityArea(bundle.getString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.ebe.aEm().setgActivityContent(bundle.getString("content"));
                    this.ebe.aEm().setgActivityTime(bundle.getLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L));
                }
            } else if (getIntent() != null) {
                this.ebe.aEm().setGroupId(getIntent().getLongExtra("gid", 0L));
                this.ebf = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.ebf) {
                    this.ebe.aEm().setActivityId(getIntent().getIntExtra("aid", 0));
                    this.ebe.aEm().setgActivityTitle(getIntent().getStringExtra("name"));
                    this.ebe.aEm().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.ebe.aEm().setgActivityContent(getIntent().getStringExtra("content"));
                    this.ebe.aEm().setgActivityTime(getIntent().getLongExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L));
                }
            }
        }
        this.ebd.a(this.ebe.aEm(), this.ebf);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initListener();
        if (this.ebe == null) {
            this.ebe = new CreateGroupActivityModel(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null && this.ebe.aEm() != null) {
            this.ebe.aEm().setGroupId(intent.getLongExtra("gid", 0L));
            this.ebf = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
            if (this.ebf) {
                this.ebe.aEm().setActivityId(intent.getIntExtra("aid", 0));
                this.ebe.aEm().setgActivityTitle(getIntent().getStringExtra("name"));
                this.ebe.aEm().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                this.ebe.aEm().setgActivityContent(getIntent().getStringExtra("content"));
                this.ebe.aEm().setgActivityTime(getIntent().getLongExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L));
            }
        }
        if (this.ebd == null) {
            this.ebd = new a(this);
        }
        this.ebd.a(this.ebe.aEm(), this.ebf);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        long j = 0;
        if (this.ebe.aEm() != null) {
            j = this.ebe.aEm().getGroupId();
        }
        bundle.putLong("gid", j);
        bundle.putString("name", this.ebd.getTitle());
        bundle.putString("content", this.ebd.getContent());
        bundle.putString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, this.ebd.aEr());
        bundle.putLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.ebd.getTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.ebd != null) {
            this.ebd.onChangeSkinType(i);
        }
    }

    private void initListener() {
        registerListener(this.dQP);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.ebe.cancelMessage();
        this.ebd.destroy();
        MessageManager.getInstance().unRegisterListener(this.dQP);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.ebd.aEp()) {
            aEl();
        } else if (view2 == this.ebd.aEq() && this.ebe != null && this.ebe.aEm() != null) {
            long time = this.ebd.getTime();
            if ((!this.ebf || this.ebd.aEs()) && 1000 * time < System.currentTimeMillis()) {
                showToast(d.k.group_activity_time_val);
                return;
            }
            this.ebe.aEm().setgActivityArea(this.ebd.aEr());
            this.ebe.aEm().setgActivityContent(this.ebd.getContent());
            this.ebe.aEm().setgActivityTime(time);
            this.ebe.aEm().setgActivityTitle(this.ebd.getTitle());
            showProgressBar();
            this.ebe.hl(this.ebf);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            aEl();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void aEl() {
        DialogUtil.quitCreateGroupActivity(getPageContext().getPageActivity(), this.ebf, new a.b() { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                CreateGroupActivityActivity.this.finish();
            }
        }, new a.b() { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
    }
}
