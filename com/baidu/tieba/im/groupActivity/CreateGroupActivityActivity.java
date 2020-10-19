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
/* loaded from: classes23.dex */
public class CreateGroupActivityActivity extends BaseActivity implements View.OnClickListener {
    private a jOH;
    private CreateGroupActivityModel jOI;
    private boolean jOJ = false;
    private c jCu = new c(CmdConfigSocket.CMD_CREATE_GROUP_ACTIVITY) { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.1
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
                        if (CreateGroupActivityActivity.this.jOJ) {
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
        this.jOI = new CreateGroupActivityModel(this);
        this.jOH = new a(this);
        if (this.jOI.cMV() != null) {
            if (bundle != null) {
                this.jOI.cMV().setGroupId(bundle.getLong("gid", 0L));
                this.jOJ = bundle.getBoolean(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.jOJ) {
                    this.jOI.cMV().setActivityId(bundle.getInt("aid", 0));
                    this.jOI.cMV().setgActivityTitle(bundle.getString("name"));
                    this.jOI.cMV().setgActivityArea(bundle.getString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.jOI.cMV().setgActivityContent(bundle.getString("content"));
                    this.jOI.cMV().setgActivityTime(bundle.getLong("time", 0L));
                }
            } else if (getIntent() != null) {
                this.jOI.cMV().setGroupId(getIntent().getLongExtra("gid", 0L));
                this.jOJ = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.jOJ) {
                    this.jOI.cMV().setActivityId(getIntent().getIntExtra("aid", 0));
                    this.jOI.cMV().setgActivityTitle(getIntent().getStringExtra("name"));
                    this.jOI.cMV().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.jOI.cMV().setgActivityContent(getIntent().getStringExtra("content"));
                    this.jOI.cMV().setgActivityTime(getIntent().getLongExtra("time", 0L));
                }
            }
        }
        this.jOH.a(this.jOI.cMV(), this.jOJ);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initListener();
        if (this.jOI == null) {
            this.jOI = new CreateGroupActivityModel(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null && this.jOI.cMV() != null) {
            this.jOI.cMV().setGroupId(intent.getLongExtra("gid", 0L));
            this.jOJ = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
            if (this.jOJ) {
                this.jOI.cMV().setActivityId(intent.getIntExtra("aid", 0));
                this.jOI.cMV().setgActivityTitle(getIntent().getStringExtra("name"));
                this.jOI.cMV().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                this.jOI.cMV().setgActivityContent(getIntent().getStringExtra("content"));
                this.jOI.cMV().setgActivityTime(getIntent().getLongExtra("time", 0L));
            }
        }
        if (this.jOH == null) {
            this.jOH = new a(this);
        }
        this.jOH.a(this.jOI.cMV(), this.jOJ);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        long j = 0;
        if (this.jOI.cMV() != null) {
            j = this.jOI.cMV().getGroupId();
        }
        bundle.putLong("gid", j);
        bundle.putString("name", this.jOH.getTitle());
        bundle.putString("content", this.jOH.getContent());
        bundle.putString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, this.jOH.cNa());
        bundle.putLong("time", this.jOH.getTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.jOH != null) {
            this.jOH.onChangeSkinType(i);
        }
    }

    private void initListener() {
        registerListener(this.jCu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.jOI.cancelMessage();
        this.jOH.destroy();
        MessageManager.getInstance().unRegisterListener(this.jCu);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jOH.cMY()) {
            cMU();
        } else if (view == this.jOH.cMZ() && this.jOI != null && this.jOI.cMV() != null) {
            long time = this.jOH.getTime();
            if ((!this.jOJ || this.jOH.cNb()) && 1000 * time < System.currentTimeMillis()) {
                showToast(R.string.group_activity_time_val);
                return;
            }
            this.jOI.cMV().setgActivityArea(this.jOH.cNa());
            this.jOI.cMV().setgActivityContent(this.jOH.getContent());
            this.jOI.cMV().setgActivityTime(time);
            this.jOI.cMV().setgActivityTitle(this.jOH.getTitle());
            showProgressBar();
            this.jOI.ry(this.jOJ);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            cMU();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void cMU() {
        DialogUtil.quitCreateGroupActivity(getPageContext().getPageActivity(), this.jOJ, new a.b() { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.2
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
