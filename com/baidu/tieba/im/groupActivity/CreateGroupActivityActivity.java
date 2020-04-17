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
    private a inm;
    private CreateGroupActivityModel inn;
    private boolean ino = false;
    private c icV = new c(CmdConfigSocket.CMD_CREATE_GROUP_ACTIVITY) { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.1
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
                        if (CreateGroupActivityActivity.this.ino) {
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
        this.inn = new CreateGroupActivityModel(this);
        this.inm = new a(this);
        if (this.inn.cgv() != null) {
            if (bundle != null) {
                this.inn.cgv().setGroupId(bundle.getLong("gid", 0L));
                this.ino = bundle.getBoolean(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.ino) {
                    this.inn.cgv().setActivityId(bundle.getInt("aid", 0));
                    this.inn.cgv().setgActivityTitle(bundle.getString("name"));
                    this.inn.cgv().setgActivityArea(bundle.getString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.inn.cgv().setgActivityContent(bundle.getString("content"));
                    this.inn.cgv().setgActivityTime(bundle.getLong("time", 0L));
                }
            } else if (getIntent() != null) {
                this.inn.cgv().setGroupId(getIntent().getLongExtra("gid", 0L));
                this.ino = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.ino) {
                    this.inn.cgv().setActivityId(getIntent().getIntExtra("aid", 0));
                    this.inn.cgv().setgActivityTitle(getIntent().getStringExtra("name"));
                    this.inn.cgv().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.inn.cgv().setgActivityContent(getIntent().getStringExtra("content"));
                    this.inn.cgv().setgActivityTime(getIntent().getLongExtra("time", 0L));
                }
            }
        }
        this.inm.a(this.inn.cgv(), this.ino);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initListener();
        if (this.inn == null) {
            this.inn = new CreateGroupActivityModel(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null && this.inn.cgv() != null) {
            this.inn.cgv().setGroupId(intent.getLongExtra("gid", 0L));
            this.ino = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
            if (this.ino) {
                this.inn.cgv().setActivityId(intent.getIntExtra("aid", 0));
                this.inn.cgv().setgActivityTitle(getIntent().getStringExtra("name"));
                this.inn.cgv().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                this.inn.cgv().setgActivityContent(getIntent().getStringExtra("content"));
                this.inn.cgv().setgActivityTime(getIntent().getLongExtra("time", 0L));
            }
        }
        if (this.inm == null) {
            this.inm = new a(this);
        }
        this.inm.a(this.inn.cgv(), this.ino);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        long j = 0;
        if (this.inn.cgv() != null) {
            j = this.inn.cgv().getGroupId();
        }
        bundle.putLong("gid", j);
        bundle.putString("name", this.inm.getTitle());
        bundle.putString("content", this.inm.getContent());
        bundle.putString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, this.inm.cgA());
        bundle.putLong("time", this.inm.getTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.inm != null) {
            this.inm.onChangeSkinType(i);
        }
    }

    private void initListener() {
        registerListener(this.icV);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.inn.cancelMessage();
        this.inm.destroy();
        MessageManager.getInstance().unRegisterListener(this.icV);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.inm.cgy()) {
            cgu();
        } else if (view == this.inm.cgz() && this.inn != null && this.inn.cgv() != null) {
            long time = this.inm.getTime();
            if ((!this.ino || this.inm.cgB()) && 1000 * time < System.currentTimeMillis()) {
                showToast(R.string.group_activity_time_val);
                return;
            }
            this.inn.cgv().setgActivityArea(this.inm.cgA());
            this.inn.cgv().setgActivityContent(this.inm.getContent());
            this.inn.cgv().setgActivityTime(time);
            this.inn.cgv().setgActivityTitle(this.inm.getTitle());
            showProgressBar();
            this.inn.oP(this.ino);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            cgu();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void cgu() {
        DialogUtil.quitCreateGroupActivity(getPageContext().getPageActivity(), this.ino, new a.b() { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.2
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
