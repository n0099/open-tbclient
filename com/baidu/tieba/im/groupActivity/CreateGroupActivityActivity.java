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
    private a gCc;
    private CreateGroupActivityModel gCd;
    private boolean gCe = false;
    private c grM = new c(103120) { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.1
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
                        if (CreateGroupActivityActivity.this.gCe) {
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
        this.gCd = new CreateGroupActivityModel(this);
        this.gCc = new a(this);
        if (this.gCd.bBk() != null) {
            if (bundle != null) {
                this.gCd.bBk().setGroupId(bundle.getLong("gid", 0L));
                this.gCe = bundle.getBoolean(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.gCe) {
                    this.gCd.bBk().setActivityId(bundle.getInt("aid", 0));
                    this.gCd.bBk().setgActivityTitle(bundle.getString("name"));
                    this.gCd.bBk().setgActivityArea(bundle.getString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.gCd.bBk().setgActivityContent(bundle.getString("content"));
                    this.gCd.bBk().setgActivityTime(bundle.getLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L));
                }
            } else if (getIntent() != null) {
                this.gCd.bBk().setGroupId(getIntent().getLongExtra("gid", 0L));
                this.gCe = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.gCe) {
                    this.gCd.bBk().setActivityId(getIntent().getIntExtra("aid", 0));
                    this.gCd.bBk().setgActivityTitle(getIntent().getStringExtra("name"));
                    this.gCd.bBk().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.gCd.bBk().setgActivityContent(getIntent().getStringExtra("content"));
                    this.gCd.bBk().setgActivityTime(getIntent().getLongExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L));
                }
            }
        }
        this.gCc.a(this.gCd.bBk(), this.gCe);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initListener();
        if (this.gCd == null) {
            this.gCd = new CreateGroupActivityModel(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null && this.gCd.bBk() != null) {
            this.gCd.bBk().setGroupId(intent.getLongExtra("gid", 0L));
            this.gCe = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
            if (this.gCe) {
                this.gCd.bBk().setActivityId(intent.getIntExtra("aid", 0));
                this.gCd.bBk().setgActivityTitle(getIntent().getStringExtra("name"));
                this.gCd.bBk().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                this.gCd.bBk().setgActivityContent(getIntent().getStringExtra("content"));
                this.gCd.bBk().setgActivityTime(getIntent().getLongExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L));
            }
        }
        if (this.gCc == null) {
            this.gCc = new a(this);
        }
        this.gCc.a(this.gCd.bBk(), this.gCe);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        long j = 0;
        if (this.gCd.bBk() != null) {
            j = this.gCd.bBk().getGroupId();
        }
        bundle.putLong("gid", j);
        bundle.putString("name", this.gCc.getTitle());
        bundle.putString("content", this.gCc.getContent());
        bundle.putString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, this.gCc.bBp());
        bundle.putLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.gCc.getTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.gCc != null) {
            this.gCc.onChangeSkinType(i);
        }
    }

    private void initListener() {
        registerListener(this.grM);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gCd.cancelMessage();
        this.gCc.destroy();
        MessageManager.getInstance().unRegisterListener(this.grM);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gCc.bBn()) {
            bBj();
        } else if (view == this.gCc.bBo() && this.gCd != null && this.gCd.bBk() != null) {
            long time = this.gCc.getTime();
            if ((!this.gCe || this.gCc.bBq()) && 1000 * time < System.currentTimeMillis()) {
                showToast(R.string.group_activity_time_val);
                return;
            }
            this.gCd.bBk().setgActivityArea(this.gCc.bBp());
            this.gCd.bBk().setgActivityContent(this.gCc.getContent());
            this.gCd.bBk().setgActivityTime(time);
            this.gCd.bBk().setgActivityTitle(this.gCc.getTitle());
            showProgressBar();
            this.gCd.lZ(this.gCe);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            bBj();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bBj() {
        DialogUtil.quitCreateGroupActivity(getPageContext().getPageActivity(), this.gCe, new a.b() { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.2
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
