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
/* loaded from: classes10.dex */
public class CreateGroupActivityActivity extends BaseActivity implements View.OnClickListener {
    private a hBJ;
    private CreateGroupActivityModel hBK;
    private boolean hBL = false;
    private c hry = new c(CmdConfigSocket.CMD_CREATE_GROUP_ACTIVITY) { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.1
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
                        if (CreateGroupActivityActivity.this.hBL) {
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
        this.hBK = new CreateGroupActivityModel(this);
        this.hBJ = new a(this);
        if (this.hBK.bVz() != null) {
            if (bundle != null) {
                this.hBK.bVz().setGroupId(bundle.getLong("gid", 0L));
                this.hBL = bundle.getBoolean(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.hBL) {
                    this.hBK.bVz().setActivityId(bundle.getInt("aid", 0));
                    this.hBK.bVz().setgActivityTitle(bundle.getString("name"));
                    this.hBK.bVz().setgActivityArea(bundle.getString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.hBK.bVz().setgActivityContent(bundle.getString("content"));
                    this.hBK.bVz().setgActivityTime(bundle.getLong("time", 0L));
                }
            } else if (getIntent() != null) {
                this.hBK.bVz().setGroupId(getIntent().getLongExtra("gid", 0L));
                this.hBL = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.hBL) {
                    this.hBK.bVz().setActivityId(getIntent().getIntExtra("aid", 0));
                    this.hBK.bVz().setgActivityTitle(getIntent().getStringExtra("name"));
                    this.hBK.bVz().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.hBK.bVz().setgActivityContent(getIntent().getStringExtra("content"));
                    this.hBK.bVz().setgActivityTime(getIntent().getLongExtra("time", 0L));
                }
            }
        }
        this.hBJ.a(this.hBK.bVz(), this.hBL);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initListener();
        if (this.hBK == null) {
            this.hBK = new CreateGroupActivityModel(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null && this.hBK.bVz() != null) {
            this.hBK.bVz().setGroupId(intent.getLongExtra("gid", 0L));
            this.hBL = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
            if (this.hBL) {
                this.hBK.bVz().setActivityId(intent.getIntExtra("aid", 0));
                this.hBK.bVz().setgActivityTitle(getIntent().getStringExtra("name"));
                this.hBK.bVz().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                this.hBK.bVz().setgActivityContent(getIntent().getStringExtra("content"));
                this.hBK.bVz().setgActivityTime(getIntent().getLongExtra("time", 0L));
            }
        }
        if (this.hBJ == null) {
            this.hBJ = new a(this);
        }
        this.hBJ.a(this.hBK.bVz(), this.hBL);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        long j = 0;
        if (this.hBK.bVz() != null) {
            j = this.hBK.bVz().getGroupId();
        }
        bundle.putLong("gid", j);
        bundle.putString("name", this.hBJ.getTitle());
        bundle.putString("content", this.hBJ.getContent());
        bundle.putString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, this.hBJ.bVE());
        bundle.putLong("time", this.hBJ.getTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.hBJ != null) {
            this.hBJ.onChangeSkinType(i);
        }
    }

    private void initListener() {
        registerListener(this.hry);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hBK.cancelMessage();
        this.hBJ.destroy();
        MessageManager.getInstance().unRegisterListener(this.hry);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hBJ.bVC()) {
            bVy();
        } else if (view == this.hBJ.bVD() && this.hBK != null && this.hBK.bVz() != null) {
            long time = this.hBJ.getTime();
            if ((!this.hBL || this.hBJ.bVF()) && 1000 * time < System.currentTimeMillis()) {
                showToast(R.string.group_activity_time_val);
                return;
            }
            this.hBK.bVz().setgActivityArea(this.hBJ.bVE());
            this.hBK.bVz().setgActivityContent(this.hBJ.getContent());
            this.hBK.bVz().setgActivityTime(time);
            this.hBK.bVz().setgActivityTitle(this.hBJ.getTitle());
            showProgressBar();
            this.hBK.nF(this.hBL);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            bVy();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bVy() {
        DialogUtil.quitCreateGroupActivity(getPageContext().getPageActivity(), this.hBL, new a.b() { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.2
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
