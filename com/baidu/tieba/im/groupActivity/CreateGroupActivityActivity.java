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
    private a kbg;
    private CreateGroupActivityModel kbh;
    private boolean kbi = false;
    private c jOT = new c(CmdConfigSocket.CMD_CREATE_GROUP_ACTIVITY) { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.1
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
                        if (CreateGroupActivityActivity.this.kbi) {
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
        this.kbh = new CreateGroupActivityModel(this);
        this.kbg = new a(this);
        if (this.kbh.cQc() != null) {
            if (bundle != null) {
                this.kbh.cQc().setGroupId(bundle.getLong("gid", 0L));
                this.kbi = bundle.getBoolean(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.kbi) {
                    this.kbh.cQc().setActivityId(bundle.getInt("aid", 0));
                    this.kbh.cQc().setgActivityTitle(bundle.getString("name"));
                    this.kbh.cQc().setgActivityArea(bundle.getString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.kbh.cQc().setgActivityContent(bundle.getString("content"));
                    this.kbh.cQc().setgActivityTime(bundle.getLong("time", 0L));
                }
            } else if (getIntent() != null) {
                this.kbh.cQc().setGroupId(getIntent().getLongExtra("gid", 0L));
                this.kbi = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.kbi) {
                    this.kbh.cQc().setActivityId(getIntent().getIntExtra("aid", 0));
                    this.kbh.cQc().setgActivityTitle(getIntent().getStringExtra("name"));
                    this.kbh.cQc().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.kbh.cQc().setgActivityContent(getIntent().getStringExtra("content"));
                    this.kbh.cQc().setgActivityTime(getIntent().getLongExtra("time", 0L));
                }
            }
        }
        this.kbg.a(this.kbh.cQc(), this.kbi);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initListener();
        if (this.kbh == null) {
            this.kbh = new CreateGroupActivityModel(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null && this.kbh.cQc() != null) {
            this.kbh.cQc().setGroupId(intent.getLongExtra("gid", 0L));
            this.kbi = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
            if (this.kbi) {
                this.kbh.cQc().setActivityId(intent.getIntExtra("aid", 0));
                this.kbh.cQc().setgActivityTitle(getIntent().getStringExtra("name"));
                this.kbh.cQc().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                this.kbh.cQc().setgActivityContent(getIntent().getStringExtra("content"));
                this.kbh.cQc().setgActivityTime(getIntent().getLongExtra("time", 0L));
            }
        }
        if (this.kbg == null) {
            this.kbg = new a(this);
        }
        this.kbg.a(this.kbh.cQc(), this.kbi);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        long j = 0;
        if (this.kbh.cQc() != null) {
            j = this.kbh.cQc().getGroupId();
        }
        bundle.putLong("gid", j);
        bundle.putString("name", this.kbg.getTitle());
        bundle.putString("content", this.kbg.getContent());
        bundle.putString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, this.kbg.cQh());
        bundle.putLong("time", this.kbg.getTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.kbg != null) {
            this.kbg.onChangeSkinType(i);
        }
    }

    private void initListener() {
        registerListener(this.jOT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.kbh.cancelMessage();
        this.kbg.destroy();
        MessageManager.getInstance().unRegisterListener(this.jOT);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.kbg.cQf()) {
            cQb();
        } else if (view == this.kbg.cQg() && this.kbh != null && this.kbh.cQc() != null) {
            long time = this.kbg.getTime();
            if ((!this.kbi || this.kbg.cQi()) && 1000 * time < System.currentTimeMillis()) {
                showToast(R.string.group_activity_time_val);
                return;
            }
            this.kbh.cQc().setgActivityArea(this.kbg.cQh());
            this.kbh.cQc().setgActivityContent(this.kbg.getContent());
            this.kbh.cQc().setgActivityTime(time);
            this.kbh.cQc().setgActivityTitle(this.kbg.getTitle());
            showProgressBar();
            this.kbh.rQ(this.kbi);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            cQb();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void cQb() {
        DialogUtil.quitCreateGroupActivity(getPageContext().getPageActivity(), this.kbi, new a.b() { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.2
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
