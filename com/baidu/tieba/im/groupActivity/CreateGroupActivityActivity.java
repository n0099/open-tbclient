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
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.ResponseCreateGroupActivityMessage;
import com.baidu.tieba.im.util.DialogUtil;
/* loaded from: classes5.dex */
public class CreateGroupActivityActivity extends BaseActivity implements View.OnClickListener {
    private a gBZ;
    private CreateGroupActivityModel gCa;
    private boolean gCb = false;
    private c grJ = new c(103120) { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            CreateGroupActivityActivity.this.hideProgressBar();
            if (socketResponsedMessage == null) {
                CreateGroupActivityActivity.this.showToast(R.string.neterror);
            } else if (socketResponsedMessage.getCmd() == 103120) {
                if (socketResponsedMessage instanceof ResponseCreateGroupActivityMessage) {
                    ResponseCreateGroupActivityMessage responseCreateGroupActivityMessage = (ResponseCreateGroupActivityMessage) socketResponsedMessage;
                    if (responseCreateGroupActivityMessage.getError() == 0) {
                        if (CreateGroupActivityActivity.this.gCb) {
                            CreateGroupActivityActivity.this.showToast(R.string.group_activity_edit_succ);
                        } else {
                            CreateGroupActivityActivity.this.showToast(R.string.group_activity_create_succ);
                        }
                        CreateGroupActivityActivity.this.setResult(-1);
                        CreateGroupActivityActivity.this.finish();
                        return;
                    }
                    CreateGroupActivityActivity.this.showToast(StringUtils.isNull(responseCreateGroupActivityMessage.getErrorString()) ? CreateGroupActivityActivity.this.getResources().getString(R.string.neterror) : responseCreateGroupActivityMessage.getErrorString());
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
        this.gCa = new CreateGroupActivityModel(this);
        this.gBZ = new a(this);
        if (this.gCa.bBg() != null) {
            if (bundle != null) {
                this.gCa.bBg().setGroupId(bundle.getLong("gid", 0L));
                this.gCb = bundle.getBoolean(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.gCb) {
                    this.gCa.bBg().setActivityId(bundle.getInt("aid", 0));
                    this.gCa.bBg().setgActivityTitle(bundle.getString("name"));
                    this.gCa.bBg().setgActivityArea(bundle.getString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.gCa.bBg().setgActivityContent(bundle.getString("content"));
                    this.gCa.bBg().setgActivityTime(bundle.getLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L));
                }
            } else if (getIntent() != null) {
                this.gCa.bBg().setGroupId(getIntent().getLongExtra("gid", 0L));
                this.gCb = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.gCb) {
                    this.gCa.bBg().setActivityId(getIntent().getIntExtra("aid", 0));
                    this.gCa.bBg().setgActivityTitle(getIntent().getStringExtra("name"));
                    this.gCa.bBg().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.gCa.bBg().setgActivityContent(getIntent().getStringExtra("content"));
                    this.gCa.bBg().setgActivityTime(getIntent().getLongExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L));
                }
            }
        }
        this.gBZ.a(this.gCa.bBg(), this.gCb);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initListener();
        if (this.gCa == null) {
            this.gCa = new CreateGroupActivityModel(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null && this.gCa.bBg() != null) {
            this.gCa.bBg().setGroupId(intent.getLongExtra("gid", 0L));
            this.gCb = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
            if (this.gCb) {
                this.gCa.bBg().setActivityId(intent.getIntExtra("aid", 0));
                this.gCa.bBg().setgActivityTitle(getIntent().getStringExtra("name"));
                this.gCa.bBg().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                this.gCa.bBg().setgActivityContent(getIntent().getStringExtra("content"));
                this.gCa.bBg().setgActivityTime(getIntent().getLongExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L));
            }
        }
        if (this.gBZ == null) {
            this.gBZ = new a(this);
        }
        this.gBZ.a(this.gCa.bBg(), this.gCb);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        long j = 0;
        if (this.gCa.bBg() != null) {
            j = this.gCa.bBg().getGroupId();
        }
        bundle.putLong("gid", j);
        bundle.putString("name", this.gBZ.getTitle());
        bundle.putString("content", this.gBZ.getContent());
        bundle.putString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, this.gBZ.bBl());
        bundle.putLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.gBZ.getTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.gBZ != null) {
            this.gBZ.onChangeSkinType(i);
        }
    }

    private void initListener() {
        registerListener(this.grJ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gCa.cancelMessage();
        this.gBZ.destroy();
        MessageManager.getInstance().unRegisterListener(this.grJ);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gBZ.bBj()) {
            bBf();
        } else if (view == this.gBZ.bBk() && this.gCa != null && this.gCa.bBg() != null) {
            long time = this.gBZ.getTime();
            if ((!this.gCb || this.gBZ.bBm()) && 1000 * time < System.currentTimeMillis()) {
                showToast(R.string.group_activity_time_val);
                return;
            }
            this.gCa.bBg().setgActivityArea(this.gBZ.bBl());
            this.gCa.bBg().setgActivityContent(this.gBZ.getContent());
            this.gCa.bBg().setgActivityTime(time);
            this.gCa.bBg().setgActivityTitle(this.gBZ.getTitle());
            showProgressBar();
            this.gCa.lY(this.gCb);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            bBf();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bBf() {
        DialogUtil.quitCreateGroupActivity(getPageContext().getPageActivity(), this.gCb, new a.b() { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.2
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
