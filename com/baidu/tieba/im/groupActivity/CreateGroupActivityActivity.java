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
/* loaded from: classes22.dex */
public class CreateGroupActivityActivity extends BaseActivity implements View.OnClickListener {
    private a khN;
    private CreateGroupActivityModel khO;
    private boolean khP = false;
    private c jVA = new c(CmdConfigSocket.CMD_CREATE_GROUP_ACTIVITY) { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.1
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
                        if (CreateGroupActivityActivity.this.khP) {
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
        this.khO = new CreateGroupActivityModel(this);
        this.khN = new a(this);
        if (this.khO.cSj() != null) {
            if (bundle != null) {
                this.khO.cSj().setGroupId(bundle.getLong("gid", 0L));
                this.khP = bundle.getBoolean(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.khP) {
                    this.khO.cSj().setActivityId(bundle.getInt("aid", 0));
                    this.khO.cSj().setgActivityTitle(bundle.getString("name"));
                    this.khO.cSj().setgActivityArea(bundle.getString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.khO.cSj().setgActivityContent(bundle.getString("content"));
                    this.khO.cSj().setgActivityTime(bundle.getLong("time", 0L));
                }
            } else if (getIntent() != null) {
                this.khO.cSj().setGroupId(getIntent().getLongExtra("gid", 0L));
                this.khP = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.khP) {
                    this.khO.cSj().setActivityId(getIntent().getIntExtra("aid", 0));
                    this.khO.cSj().setgActivityTitle(getIntent().getStringExtra("name"));
                    this.khO.cSj().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.khO.cSj().setgActivityContent(getIntent().getStringExtra("content"));
                    this.khO.cSj().setgActivityTime(getIntent().getLongExtra("time", 0L));
                }
            }
        }
        this.khN.a(this.khO.cSj(), this.khP);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initListener();
        if (this.khO == null) {
            this.khO = new CreateGroupActivityModel(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null && this.khO.cSj() != null) {
            this.khO.cSj().setGroupId(intent.getLongExtra("gid", 0L));
            this.khP = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
            if (this.khP) {
                this.khO.cSj().setActivityId(intent.getIntExtra("aid", 0));
                this.khO.cSj().setgActivityTitle(getIntent().getStringExtra("name"));
                this.khO.cSj().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                this.khO.cSj().setgActivityContent(getIntent().getStringExtra("content"));
                this.khO.cSj().setgActivityTime(getIntent().getLongExtra("time", 0L));
            }
        }
        if (this.khN == null) {
            this.khN = new a(this);
        }
        this.khN.a(this.khO.cSj(), this.khP);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        long j = 0;
        if (this.khO.cSj() != null) {
            j = this.khO.cSj().getGroupId();
        }
        bundle.putLong("gid", j);
        bundle.putString("name", this.khN.getTitle());
        bundle.putString("content", this.khN.getContent());
        bundle.putString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, this.khN.cSo());
        bundle.putLong("time", this.khN.getTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.khN != null) {
            this.khN.onChangeSkinType(i);
        }
    }

    private void initListener() {
        registerListener(this.jVA);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.khO.cancelMessage();
        this.khN.destroy();
        MessageManager.getInstance().unRegisterListener(this.jVA);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.khN.cSm()) {
            cSi();
        } else if (view == this.khN.cSn() && this.khO != null && this.khO.cSj() != null) {
            long time = this.khN.getTime();
            if ((!this.khP || this.khN.cSp()) && 1000 * time < System.currentTimeMillis()) {
                showToast(R.string.group_activity_time_val);
                return;
            }
            this.khO.cSj().setgActivityArea(this.khN.cSo());
            this.khO.cSj().setgActivityContent(this.khN.getContent());
            this.khO.cSj().setgActivityTime(time);
            this.khO.cSj().setgActivityTitle(this.khN.getTitle());
            showProgressBar();
            this.khO.sc(this.khP);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            cSi();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void cSi() {
        DialogUtil.quitCreateGroupActivity(getPageContext().getPageActivity(), this.khP, new a.b() { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.2
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
