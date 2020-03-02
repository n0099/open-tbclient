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
    private a hBL;
    private CreateGroupActivityModel hBM;
    private boolean hBN = false;
    private c hrA = new c(CmdConfigSocket.CMD_CREATE_GROUP_ACTIVITY) { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.1
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
                        if (CreateGroupActivityActivity.this.hBN) {
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
        this.hBM = new CreateGroupActivityModel(this);
        this.hBL = new a(this);
        if (this.hBM.bVB() != null) {
            if (bundle != null) {
                this.hBM.bVB().setGroupId(bundle.getLong("gid", 0L));
                this.hBN = bundle.getBoolean(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.hBN) {
                    this.hBM.bVB().setActivityId(bundle.getInt("aid", 0));
                    this.hBM.bVB().setgActivityTitle(bundle.getString("name"));
                    this.hBM.bVB().setgActivityArea(bundle.getString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.hBM.bVB().setgActivityContent(bundle.getString("content"));
                    this.hBM.bVB().setgActivityTime(bundle.getLong("time", 0L));
                }
            } else if (getIntent() != null) {
                this.hBM.bVB().setGroupId(getIntent().getLongExtra("gid", 0L));
                this.hBN = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.hBN) {
                    this.hBM.bVB().setActivityId(getIntent().getIntExtra("aid", 0));
                    this.hBM.bVB().setgActivityTitle(getIntent().getStringExtra("name"));
                    this.hBM.bVB().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.hBM.bVB().setgActivityContent(getIntent().getStringExtra("content"));
                    this.hBM.bVB().setgActivityTime(getIntent().getLongExtra("time", 0L));
                }
            }
        }
        this.hBL.a(this.hBM.bVB(), this.hBN);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initListener();
        if (this.hBM == null) {
            this.hBM = new CreateGroupActivityModel(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null && this.hBM.bVB() != null) {
            this.hBM.bVB().setGroupId(intent.getLongExtra("gid", 0L));
            this.hBN = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
            if (this.hBN) {
                this.hBM.bVB().setActivityId(intent.getIntExtra("aid", 0));
                this.hBM.bVB().setgActivityTitle(getIntent().getStringExtra("name"));
                this.hBM.bVB().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                this.hBM.bVB().setgActivityContent(getIntent().getStringExtra("content"));
                this.hBM.bVB().setgActivityTime(getIntent().getLongExtra("time", 0L));
            }
        }
        if (this.hBL == null) {
            this.hBL = new a(this);
        }
        this.hBL.a(this.hBM.bVB(), this.hBN);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        long j = 0;
        if (this.hBM.bVB() != null) {
            j = this.hBM.bVB().getGroupId();
        }
        bundle.putLong("gid", j);
        bundle.putString("name", this.hBL.getTitle());
        bundle.putString("content", this.hBL.getContent());
        bundle.putString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, this.hBL.bVG());
        bundle.putLong("time", this.hBL.getTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.hBL != null) {
            this.hBL.onChangeSkinType(i);
        }
    }

    private void initListener() {
        registerListener(this.hrA);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hBM.cancelMessage();
        this.hBL.destroy();
        MessageManager.getInstance().unRegisterListener(this.hrA);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hBL.bVE()) {
            bVA();
        } else if (view == this.hBL.bVF() && this.hBM != null && this.hBM.bVB() != null) {
            long time = this.hBL.getTime();
            if ((!this.hBN || this.hBL.bVH()) && 1000 * time < System.currentTimeMillis()) {
                showToast(R.string.group_activity_time_val);
                return;
            }
            this.hBM.bVB().setgActivityArea(this.hBL.bVG());
            this.hBM.bVB().setgActivityContent(this.hBL.getContent());
            this.hBM.bVB().setgActivityTime(time);
            this.hBM.bVB().setgActivityTitle(this.hBL.getTitle());
            showProgressBar();
            this.hBM.nF(this.hBN);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            bVA();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bVA() {
        DialogUtil.quitCreateGroupActivity(getPageContext().getPageActivity(), this.hBN, new a.b() { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.2
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
