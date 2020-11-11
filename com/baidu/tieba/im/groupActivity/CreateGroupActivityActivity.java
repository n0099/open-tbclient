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
    private a khd;
    private CreateGroupActivityModel khe;
    private boolean khf = false;
    private c jUQ = new c(CmdConfigSocket.CMD_CREATE_GROUP_ACTIVITY) { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.1
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
                        if (CreateGroupActivityActivity.this.khf) {
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
        this.khe = new CreateGroupActivityModel(this);
        this.khd = new a(this);
        if (this.khe.cSD() != null) {
            if (bundle != null) {
                this.khe.cSD().setGroupId(bundle.getLong("gid", 0L));
                this.khf = bundle.getBoolean(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.khf) {
                    this.khe.cSD().setActivityId(bundle.getInt("aid", 0));
                    this.khe.cSD().setgActivityTitle(bundle.getString("name"));
                    this.khe.cSD().setgActivityArea(bundle.getString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.khe.cSD().setgActivityContent(bundle.getString("content"));
                    this.khe.cSD().setgActivityTime(bundle.getLong("time", 0L));
                }
            } else if (getIntent() != null) {
                this.khe.cSD().setGroupId(getIntent().getLongExtra("gid", 0L));
                this.khf = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.khf) {
                    this.khe.cSD().setActivityId(getIntent().getIntExtra("aid", 0));
                    this.khe.cSD().setgActivityTitle(getIntent().getStringExtra("name"));
                    this.khe.cSD().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.khe.cSD().setgActivityContent(getIntent().getStringExtra("content"));
                    this.khe.cSD().setgActivityTime(getIntent().getLongExtra("time", 0L));
                }
            }
        }
        this.khd.a(this.khe.cSD(), this.khf);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initListener();
        if (this.khe == null) {
            this.khe = new CreateGroupActivityModel(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null && this.khe.cSD() != null) {
            this.khe.cSD().setGroupId(intent.getLongExtra("gid", 0L));
            this.khf = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
            if (this.khf) {
                this.khe.cSD().setActivityId(intent.getIntExtra("aid", 0));
                this.khe.cSD().setgActivityTitle(getIntent().getStringExtra("name"));
                this.khe.cSD().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                this.khe.cSD().setgActivityContent(getIntent().getStringExtra("content"));
                this.khe.cSD().setgActivityTime(getIntent().getLongExtra("time", 0L));
            }
        }
        if (this.khd == null) {
            this.khd = new a(this);
        }
        this.khd.a(this.khe.cSD(), this.khf);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        long j = 0;
        if (this.khe.cSD() != null) {
            j = this.khe.cSD().getGroupId();
        }
        bundle.putLong("gid", j);
        bundle.putString("name", this.khd.getTitle());
        bundle.putString("content", this.khd.getContent());
        bundle.putString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, this.khd.cSI());
        bundle.putLong("time", this.khd.getTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.khd != null) {
            this.khd.onChangeSkinType(i);
        }
    }

    private void initListener() {
        registerListener(this.jUQ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.khe.cancelMessage();
        this.khd.destroy();
        MessageManager.getInstance().unRegisterListener(this.jUQ);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.khd.cSG()) {
            cSC();
        } else if (view == this.khd.cSH() && this.khe != null && this.khe.cSD() != null) {
            long time = this.khd.getTime();
            if ((!this.khf || this.khd.cSJ()) && 1000 * time < System.currentTimeMillis()) {
                showToast(R.string.group_activity_time_val);
                return;
            }
            this.khe.cSD().setgActivityArea(this.khd.cSI());
            this.khe.cSD().setgActivityContent(this.khd.getContent());
            this.khe.cSD().setgActivityTime(time);
            this.khe.cSD().setgActivityTitle(this.khd.getTitle());
            showProgressBar();
            this.khe.rZ(this.khf);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            cSC();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void cSC() {
        DialogUtil.quitCreateGroupActivity(getPageContext().getPageActivity(), this.khf, new a.b() { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.2
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
