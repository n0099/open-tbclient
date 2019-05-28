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
    private a gCa;
    private CreateGroupActivityModel gCb;
    private boolean gCc = false;
    private c grK = new c(103120) { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.1
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
                        if (CreateGroupActivityActivity.this.gCc) {
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
        this.gCb = new CreateGroupActivityModel(this);
        this.gCa = new a(this);
        if (this.gCb.bBj() != null) {
            if (bundle != null) {
                this.gCb.bBj().setGroupId(bundle.getLong("gid", 0L));
                this.gCc = bundle.getBoolean(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.gCc) {
                    this.gCb.bBj().setActivityId(bundle.getInt("aid", 0));
                    this.gCb.bBj().setgActivityTitle(bundle.getString("name"));
                    this.gCb.bBj().setgActivityArea(bundle.getString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.gCb.bBj().setgActivityContent(bundle.getString("content"));
                    this.gCb.bBj().setgActivityTime(bundle.getLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L));
                }
            } else if (getIntent() != null) {
                this.gCb.bBj().setGroupId(getIntent().getLongExtra("gid", 0L));
                this.gCc = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.gCc) {
                    this.gCb.bBj().setActivityId(getIntent().getIntExtra("aid", 0));
                    this.gCb.bBj().setgActivityTitle(getIntent().getStringExtra("name"));
                    this.gCb.bBj().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.gCb.bBj().setgActivityContent(getIntent().getStringExtra("content"));
                    this.gCb.bBj().setgActivityTime(getIntent().getLongExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L));
                }
            }
        }
        this.gCa.a(this.gCb.bBj(), this.gCc);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initListener();
        if (this.gCb == null) {
            this.gCb = new CreateGroupActivityModel(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null && this.gCb.bBj() != null) {
            this.gCb.bBj().setGroupId(intent.getLongExtra("gid", 0L));
            this.gCc = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
            if (this.gCc) {
                this.gCb.bBj().setActivityId(intent.getIntExtra("aid", 0));
                this.gCb.bBj().setgActivityTitle(getIntent().getStringExtra("name"));
                this.gCb.bBj().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                this.gCb.bBj().setgActivityContent(getIntent().getStringExtra("content"));
                this.gCb.bBj().setgActivityTime(getIntent().getLongExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L));
            }
        }
        if (this.gCa == null) {
            this.gCa = new a(this);
        }
        this.gCa.a(this.gCb.bBj(), this.gCc);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        long j = 0;
        if (this.gCb.bBj() != null) {
            j = this.gCb.bBj().getGroupId();
        }
        bundle.putLong("gid", j);
        bundle.putString("name", this.gCa.getTitle());
        bundle.putString("content", this.gCa.getContent());
        bundle.putString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, this.gCa.bBo());
        bundle.putLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.gCa.getTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.gCa != null) {
            this.gCa.onChangeSkinType(i);
        }
    }

    private void initListener() {
        registerListener(this.grK);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gCb.cancelMessage();
        this.gCa.destroy();
        MessageManager.getInstance().unRegisterListener(this.grK);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gCa.bBm()) {
            bBi();
        } else if (view == this.gCa.bBn() && this.gCb != null && this.gCb.bBj() != null) {
            long time = this.gCa.getTime();
            if ((!this.gCc || this.gCa.bBp()) && 1000 * time < System.currentTimeMillis()) {
                showToast(R.string.group_activity_time_val);
                return;
            }
            this.gCb.bBj().setgActivityArea(this.gCa.bBo());
            this.gCb.bBj().setgActivityContent(this.gCa.getContent());
            this.gCb.bBj().setgActivityTime(time);
            this.gCb.bBj().setgActivityTitle(this.gCa.getTitle());
            showProgressBar();
            this.gCb.lY(this.gCc);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            bBi();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bBi() {
        DialogUtil.quitCreateGroupActivity(getPageContext().getPageActivity(), this.gCc, new a.b() { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.2
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
