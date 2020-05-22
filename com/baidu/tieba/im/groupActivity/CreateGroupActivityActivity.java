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
    private a iBZ;
    private CreateGroupActivityModel iCa;
    private boolean iCb = false;
    private c irO = new c(CmdConfigSocket.CMD_CREATE_GROUP_ACTIVITY) { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.1
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
                        if (CreateGroupActivityActivity.this.iCb) {
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
        this.iCa = new CreateGroupActivityModel(this);
        this.iBZ = new a(this);
        if (this.iCa.cmR() != null) {
            if (bundle != null) {
                this.iCa.cmR().setGroupId(bundle.getLong("gid", 0L));
                this.iCb = bundle.getBoolean(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.iCb) {
                    this.iCa.cmR().setActivityId(bundle.getInt("aid", 0));
                    this.iCa.cmR().setgActivityTitle(bundle.getString("name"));
                    this.iCa.cmR().setgActivityArea(bundle.getString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.iCa.cmR().setgActivityContent(bundle.getString("content"));
                    this.iCa.cmR().setgActivityTime(bundle.getLong("time", 0L));
                }
            } else if (getIntent() != null) {
                this.iCa.cmR().setGroupId(getIntent().getLongExtra("gid", 0L));
                this.iCb = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.iCb) {
                    this.iCa.cmR().setActivityId(getIntent().getIntExtra("aid", 0));
                    this.iCa.cmR().setgActivityTitle(getIntent().getStringExtra("name"));
                    this.iCa.cmR().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.iCa.cmR().setgActivityContent(getIntent().getStringExtra("content"));
                    this.iCa.cmR().setgActivityTime(getIntent().getLongExtra("time", 0L));
                }
            }
        }
        this.iBZ.a(this.iCa.cmR(), this.iCb);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initListener();
        if (this.iCa == null) {
            this.iCa = new CreateGroupActivityModel(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null && this.iCa.cmR() != null) {
            this.iCa.cmR().setGroupId(intent.getLongExtra("gid", 0L));
            this.iCb = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
            if (this.iCb) {
                this.iCa.cmR().setActivityId(intent.getIntExtra("aid", 0));
                this.iCa.cmR().setgActivityTitle(getIntent().getStringExtra("name"));
                this.iCa.cmR().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                this.iCa.cmR().setgActivityContent(getIntent().getStringExtra("content"));
                this.iCa.cmR().setgActivityTime(getIntent().getLongExtra("time", 0L));
            }
        }
        if (this.iBZ == null) {
            this.iBZ = new a(this);
        }
        this.iBZ.a(this.iCa.cmR(), this.iCb);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        long j = 0;
        if (this.iCa.cmR() != null) {
            j = this.iCa.cmR().getGroupId();
        }
        bundle.putLong("gid", j);
        bundle.putString("name", this.iBZ.getTitle());
        bundle.putString("content", this.iBZ.getContent());
        bundle.putString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, this.iBZ.cmW());
        bundle.putLong("time", this.iBZ.getTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.iBZ != null) {
            this.iBZ.onChangeSkinType(i);
        }
    }

    private void initListener() {
        registerListener(this.irO);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.iCa.cancelMessage();
        this.iBZ.destroy();
        MessageManager.getInstance().unRegisterListener(this.irO);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iBZ.cmU()) {
            cmQ();
        } else if (view == this.iBZ.cmV() && this.iCa != null && this.iCa.cmR() != null) {
            long time = this.iBZ.getTime();
            if ((!this.iCb || this.iBZ.cmX()) && 1000 * time < System.currentTimeMillis()) {
                showToast(R.string.group_activity_time_val);
                return;
            }
            this.iCa.cmR().setgActivityArea(this.iBZ.cmW());
            this.iCa.cmR().setgActivityContent(this.iBZ.getContent());
            this.iCa.cmR().setgActivityTime(time);
            this.iCa.cmR().setgActivityTitle(this.iBZ.getTitle());
            showProgressBar();
            this.iCa.pl(this.iCb);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            cmQ();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void cmQ() {
        DialogUtil.quitCreateGroupActivity(getPageContext().getPageActivity(), this.iCb, new a.b() { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.2
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
