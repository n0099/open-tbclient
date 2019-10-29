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
/* loaded from: classes5.dex */
public class CreateGroupActivityActivity extends BaseActivity implements View.OnClickListener {
    private a gIU;
    private CreateGroupActivityModel gIV;
    private boolean gIW = false;
    private c gyE = new c(CmdConfigSocket.CMD_CREATE_GROUP_ACTIVITY) { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.1
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
                        if (CreateGroupActivityActivity.this.gIW) {
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
        this.gIV = new CreateGroupActivityModel(this);
        this.gIU = new a(this);
        if (this.gIV.bBE() != null) {
            if (bundle != null) {
                this.gIV.bBE().setGroupId(bundle.getLong("gid", 0L));
                this.gIW = bundle.getBoolean(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.gIW) {
                    this.gIV.bBE().setActivityId(bundle.getInt("aid", 0));
                    this.gIV.bBE().setgActivityTitle(bundle.getString("name"));
                    this.gIV.bBE().setgActivityArea(bundle.getString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.gIV.bBE().setgActivityContent(bundle.getString("content"));
                    this.gIV.bBE().setgActivityTime(bundle.getLong("time", 0L));
                }
            } else if (getIntent() != null) {
                this.gIV.bBE().setGroupId(getIntent().getLongExtra("gid", 0L));
                this.gIW = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.gIW) {
                    this.gIV.bBE().setActivityId(getIntent().getIntExtra("aid", 0));
                    this.gIV.bBE().setgActivityTitle(getIntent().getStringExtra("name"));
                    this.gIV.bBE().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.gIV.bBE().setgActivityContent(getIntent().getStringExtra("content"));
                    this.gIV.bBE().setgActivityTime(getIntent().getLongExtra("time", 0L));
                }
            }
        }
        this.gIU.a(this.gIV.bBE(), this.gIW);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initListener();
        if (this.gIV == null) {
            this.gIV = new CreateGroupActivityModel(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null && this.gIV.bBE() != null) {
            this.gIV.bBE().setGroupId(intent.getLongExtra("gid", 0L));
            this.gIW = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
            if (this.gIW) {
                this.gIV.bBE().setActivityId(intent.getIntExtra("aid", 0));
                this.gIV.bBE().setgActivityTitle(getIntent().getStringExtra("name"));
                this.gIV.bBE().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                this.gIV.bBE().setgActivityContent(getIntent().getStringExtra("content"));
                this.gIV.bBE().setgActivityTime(getIntent().getLongExtra("time", 0L));
            }
        }
        if (this.gIU == null) {
            this.gIU = new a(this);
        }
        this.gIU.a(this.gIV.bBE(), this.gIW);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        long j = 0;
        if (this.gIV.bBE() != null) {
            j = this.gIV.bBE().getGroupId();
        }
        bundle.putLong("gid", j);
        bundle.putString("name", this.gIU.getTitle());
        bundle.putString("content", this.gIU.getContent());
        bundle.putString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, this.gIU.bBJ());
        bundle.putLong("time", this.gIU.getTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.gIU != null) {
            this.gIU.onChangeSkinType(i);
        }
    }

    private void initListener() {
        registerListener(this.gyE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gIV.cancelMessage();
        this.gIU.destroy();
        MessageManager.getInstance().unRegisterListener(this.gyE);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gIU.bBH()) {
            bBD();
        } else if (view == this.gIU.bBI() && this.gIV != null && this.gIV.bBE() != null) {
            long time = this.gIU.getTime();
            if ((!this.gIW || this.gIU.bBK()) && 1000 * time < System.currentTimeMillis()) {
                showToast(R.string.group_activity_time_val);
                return;
            }
            this.gIV.bBE().setgActivityArea(this.gIU.bBJ());
            this.gIV.bBE().setgActivityContent(this.gIU.getContent());
            this.gIV.bBE().setgActivityTime(time);
            this.gIV.bBE().setgActivityTitle(this.gIU.getTitle());
            showProgressBar();
            this.gIV.me(this.gIW);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            bBD();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bBD() {
        DialogUtil.quitCreateGroupActivity(getPageContext().getPageActivity(), this.gIW, new a.b() { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.2
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
