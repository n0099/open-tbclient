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
    private a dZZ;
    private CreateGroupActivityModel eaa;
    private boolean eab = false;
    private c dPL = new c(103120) { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.1
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
                        if (CreateGroupActivityActivity.this.eab) {
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
        this.eaa = new CreateGroupActivityModel(this);
        this.dZZ = new a(this);
        if (this.eaa.aEo() != null) {
            if (bundle != null) {
                this.eaa.aEo().setGroupId(bundle.getLong("gid", 0L));
                this.eab = bundle.getBoolean(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.eab) {
                    this.eaa.aEo().setActivityId(bundle.getInt("aid", 0));
                    this.eaa.aEo().setgActivityTitle(bundle.getString("name"));
                    this.eaa.aEo().setgActivityArea(bundle.getString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.eaa.aEo().setgActivityContent(bundle.getString("content"));
                    this.eaa.aEo().setgActivityTime(bundle.getLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L));
                }
            } else if (getIntent() != null) {
                this.eaa.aEo().setGroupId(getIntent().getLongExtra("gid", 0L));
                this.eab = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.eab) {
                    this.eaa.aEo().setActivityId(getIntent().getIntExtra("aid", 0));
                    this.eaa.aEo().setgActivityTitle(getIntent().getStringExtra("name"));
                    this.eaa.aEo().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.eaa.aEo().setgActivityContent(getIntent().getStringExtra("content"));
                    this.eaa.aEo().setgActivityTime(getIntent().getLongExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L));
                }
            }
        }
        this.dZZ.a(this.eaa.aEo(), this.eab);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initListener();
        if (this.eaa == null) {
            this.eaa = new CreateGroupActivityModel(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null && this.eaa.aEo() != null) {
            this.eaa.aEo().setGroupId(intent.getLongExtra("gid", 0L));
            this.eab = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
            if (this.eab) {
                this.eaa.aEo().setActivityId(intent.getIntExtra("aid", 0));
                this.eaa.aEo().setgActivityTitle(getIntent().getStringExtra("name"));
                this.eaa.aEo().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                this.eaa.aEo().setgActivityContent(getIntent().getStringExtra("content"));
                this.eaa.aEo().setgActivityTime(getIntent().getLongExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L));
            }
        }
        if (this.dZZ == null) {
            this.dZZ = new a(this);
        }
        this.dZZ.a(this.eaa.aEo(), this.eab);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        long j = 0;
        if (this.eaa.aEo() != null) {
            j = this.eaa.aEo().getGroupId();
        }
        bundle.putLong("gid", j);
        bundle.putString("name", this.dZZ.getTitle());
        bundle.putString("content", this.dZZ.getContent());
        bundle.putString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, this.dZZ.aEt());
        bundle.putLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.dZZ.getTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.dZZ != null) {
            this.dZZ.onChangeSkinType(i);
        }
    }

    private void initListener() {
        registerListener(this.dPL);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eaa.cancelMessage();
        this.dZZ.destroy();
        MessageManager.getInstance().unRegisterListener(this.dPL);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.dZZ.aEr()) {
            aEn();
        } else if (view2 == this.dZZ.aEs() && this.eaa != null && this.eaa.aEo() != null) {
            long time = this.dZZ.getTime();
            if ((!this.eab || this.dZZ.aEu()) && 1000 * time < System.currentTimeMillis()) {
                showToast(d.k.group_activity_time_val);
                return;
            }
            this.eaa.aEo().setgActivityArea(this.dZZ.aEt());
            this.eaa.aEo().setgActivityContent(this.dZZ.getContent());
            this.eaa.aEo().setgActivityTime(time);
            this.eaa.aEo().setgActivityTitle(this.dZZ.getTitle());
            showProgressBar();
            this.eaa.hk(this.eab);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            aEn();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void aEn() {
        DialogUtil.quitCreateGroupActivity(getPageContext().getPageActivity(), this.eab, new a.b() { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.2
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
