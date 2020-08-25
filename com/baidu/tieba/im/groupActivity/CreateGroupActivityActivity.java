package com.baidu.tieba.im.groupActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.c;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.ResponseCreateGroupActivityMessage;
import com.baidu.tieba.im.util.DialogUtil;
/* loaded from: classes17.dex */
public class CreateGroupActivityActivity extends BaseActivity implements View.OnClickListener {
    private a jrc;
    private CreateGroupActivityModel jrd;
    private boolean jre = false;
    private c jeL = new c(CmdConfigSocket.CMD_CREATE_GROUP_ACTIVITY) { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.1
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
                        if (CreateGroupActivityActivity.this.jre) {
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
        this.jrd = new CreateGroupActivityModel(this);
        this.jrc = new a(this);
        if (this.jrd.cFF() != null) {
            if (bundle != null) {
                this.jrd.cFF().setGroupId(bundle.getLong("gid", 0L));
                this.jre = bundle.getBoolean(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.jre) {
                    this.jrd.cFF().setActivityId(bundle.getInt("aid", 0));
                    this.jrd.cFF().setgActivityTitle(bundle.getString("name"));
                    this.jrd.cFF().setgActivityArea(bundle.getString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.jrd.cFF().setgActivityContent(bundle.getString("content"));
                    this.jrd.cFF().setgActivityTime(bundle.getLong("time", 0L));
                }
            } else if (getIntent() != null) {
                this.jrd.cFF().setGroupId(getIntent().getLongExtra("gid", 0L));
                this.jre = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.jre) {
                    this.jrd.cFF().setActivityId(getIntent().getIntExtra("aid", 0));
                    this.jrd.cFF().setgActivityTitle(getIntent().getStringExtra("name"));
                    this.jrd.cFF().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.jrd.cFF().setgActivityContent(getIntent().getStringExtra("content"));
                    this.jrd.cFF().setgActivityTime(getIntent().getLongExtra("time", 0L));
                }
            }
        }
        this.jrc.a(this.jrd.cFF(), this.jre);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initListener();
        if (this.jrd == null) {
            this.jrd = new CreateGroupActivityModel(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null && this.jrd.cFF() != null) {
            this.jrd.cFF().setGroupId(intent.getLongExtra("gid", 0L));
            this.jre = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
            if (this.jre) {
                this.jrd.cFF().setActivityId(intent.getIntExtra("aid", 0));
                this.jrd.cFF().setgActivityTitle(getIntent().getStringExtra("name"));
                this.jrd.cFF().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                this.jrd.cFF().setgActivityContent(getIntent().getStringExtra("content"));
                this.jrd.cFF().setgActivityTime(getIntent().getLongExtra("time", 0L));
            }
        }
        if (this.jrc == null) {
            this.jrc = new a(this);
        }
        this.jrc.a(this.jrd.cFF(), this.jre);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        long j = 0;
        if (this.jrd.cFF() != null) {
            j = this.jrd.cFF().getGroupId();
        }
        bundle.putLong("gid", j);
        bundle.putString("name", this.jrc.getTitle());
        bundle.putString("content", this.jrc.getContent());
        bundle.putString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, this.jrc.cFK());
        bundle.putLong("time", this.jrc.getTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.jrc != null) {
            this.jrc.onChangeSkinType(i);
        }
    }

    private void initListener() {
        registerListener(this.jeL);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.jrd.cancelMessage();
        this.jrc.destroy();
        MessageManager.getInstance().unRegisterListener(this.jeL);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jrc.cFI()) {
            cFE();
        } else if (view == this.jrc.cFJ() && this.jrd != null && this.jrd.cFF() != null) {
            long time = this.jrc.getTime();
            if ((!this.jre || this.jrc.cFL()) && 1000 * time < System.currentTimeMillis()) {
                showToast(R.string.group_activity_time_val);
                return;
            }
            this.jrd.cFF().setgActivityArea(this.jrc.cFK());
            this.jrd.cFF().setgActivityContent(this.jrc.getContent());
            this.jrd.cFF().setgActivityTime(time);
            this.jrd.cFF().setgActivityTitle(this.jrc.getTitle());
            showProgressBar();
            this.jrd.qI(this.jre);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            cFE();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void cFE() {
        DialogUtil.quitCreateGroupActivity(getPageContext().getPageActivity(), this.jre, new a.b() { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.2
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
