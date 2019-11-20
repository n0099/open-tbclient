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
    private a gId;
    private CreateGroupActivityModel gIe;
    private boolean gIf = false;
    private c gxN = new c(CmdConfigSocket.CMD_CREATE_GROUP_ACTIVITY) { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.1
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
                        if (CreateGroupActivityActivity.this.gIf) {
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
        this.gIe = new CreateGroupActivityModel(this);
        this.gId = new a(this);
        if (this.gIe.bBC() != null) {
            if (bundle != null) {
                this.gIe.bBC().setGroupId(bundle.getLong("gid", 0L));
                this.gIf = bundle.getBoolean(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.gIf) {
                    this.gIe.bBC().setActivityId(bundle.getInt("aid", 0));
                    this.gIe.bBC().setgActivityTitle(bundle.getString("name"));
                    this.gIe.bBC().setgActivityArea(bundle.getString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.gIe.bBC().setgActivityContent(bundle.getString("content"));
                    this.gIe.bBC().setgActivityTime(bundle.getLong("time", 0L));
                }
            } else if (getIntent() != null) {
                this.gIe.bBC().setGroupId(getIntent().getLongExtra("gid", 0L));
                this.gIf = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.gIf) {
                    this.gIe.bBC().setActivityId(getIntent().getIntExtra("aid", 0));
                    this.gIe.bBC().setgActivityTitle(getIntent().getStringExtra("name"));
                    this.gIe.bBC().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.gIe.bBC().setgActivityContent(getIntent().getStringExtra("content"));
                    this.gIe.bBC().setgActivityTime(getIntent().getLongExtra("time", 0L));
                }
            }
        }
        this.gId.a(this.gIe.bBC(), this.gIf);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initListener();
        if (this.gIe == null) {
            this.gIe = new CreateGroupActivityModel(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null && this.gIe.bBC() != null) {
            this.gIe.bBC().setGroupId(intent.getLongExtra("gid", 0L));
            this.gIf = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
            if (this.gIf) {
                this.gIe.bBC().setActivityId(intent.getIntExtra("aid", 0));
                this.gIe.bBC().setgActivityTitle(getIntent().getStringExtra("name"));
                this.gIe.bBC().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                this.gIe.bBC().setgActivityContent(getIntent().getStringExtra("content"));
                this.gIe.bBC().setgActivityTime(getIntent().getLongExtra("time", 0L));
            }
        }
        if (this.gId == null) {
            this.gId = new a(this);
        }
        this.gId.a(this.gIe.bBC(), this.gIf);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        long j = 0;
        if (this.gIe.bBC() != null) {
            j = this.gIe.bBC().getGroupId();
        }
        bundle.putLong("gid", j);
        bundle.putString("name", this.gId.getTitle());
        bundle.putString("content", this.gId.getContent());
        bundle.putString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, this.gId.bBH());
        bundle.putLong("time", this.gId.getTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.gId != null) {
            this.gId.onChangeSkinType(i);
        }
    }

    private void initListener() {
        registerListener(this.gxN);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gIe.cancelMessage();
        this.gId.destroy();
        MessageManager.getInstance().unRegisterListener(this.gxN);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gId.bBF()) {
            bBB();
        } else if (view == this.gId.bBG() && this.gIe != null && this.gIe.bBC() != null) {
            long time = this.gId.getTime();
            if ((!this.gIf || this.gId.bBI()) && 1000 * time < System.currentTimeMillis()) {
                showToast(R.string.group_activity_time_val);
                return;
            }
            this.gIe.bBC().setgActivityArea(this.gId.bBH());
            this.gIe.bBC().setgActivityContent(this.gId.getContent());
            this.gIe.bBC().setgActivityTime(time);
            this.gIe.bBC().setgActivityTitle(this.gId.getTitle());
            showProgressBar();
            this.gIe.me(this.gIf);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            bBB();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bBB() {
        DialogUtil.quitCreateGroupActivity(getPageContext().getPageActivity(), this.gIf, new a.b() { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.2
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
