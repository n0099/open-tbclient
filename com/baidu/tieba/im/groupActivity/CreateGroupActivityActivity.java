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

    /* renamed from: int  reason: not valid java name */
    private a f4int;
    private CreateGroupActivityModel inu;
    private boolean inv = false;
    private c idb = new c(CmdConfigSocket.CMD_CREATE_GROUP_ACTIVITY) { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.1
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
                        if (CreateGroupActivityActivity.this.inv) {
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
        this.inu = new CreateGroupActivityModel(this);
        this.f4int = new a(this);
        if (this.inu.cgt() != null) {
            if (bundle != null) {
                this.inu.cgt().setGroupId(bundle.getLong("gid", 0L));
                this.inv = bundle.getBoolean(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.inv) {
                    this.inu.cgt().setActivityId(bundle.getInt("aid", 0));
                    this.inu.cgt().setgActivityTitle(bundle.getString("name"));
                    this.inu.cgt().setgActivityArea(bundle.getString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.inu.cgt().setgActivityContent(bundle.getString("content"));
                    this.inu.cgt().setgActivityTime(bundle.getLong("time", 0L));
                }
            } else if (getIntent() != null) {
                this.inu.cgt().setGroupId(getIntent().getLongExtra("gid", 0L));
                this.inv = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.inv) {
                    this.inu.cgt().setActivityId(getIntent().getIntExtra("aid", 0));
                    this.inu.cgt().setgActivityTitle(getIntent().getStringExtra("name"));
                    this.inu.cgt().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.inu.cgt().setgActivityContent(getIntent().getStringExtra("content"));
                    this.inu.cgt().setgActivityTime(getIntent().getLongExtra("time", 0L));
                }
            }
        }
        this.f4int.a(this.inu.cgt(), this.inv);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initListener();
        if (this.inu == null) {
            this.inu = new CreateGroupActivityModel(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null && this.inu.cgt() != null) {
            this.inu.cgt().setGroupId(intent.getLongExtra("gid", 0L));
            this.inv = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
            if (this.inv) {
                this.inu.cgt().setActivityId(intent.getIntExtra("aid", 0));
                this.inu.cgt().setgActivityTitle(getIntent().getStringExtra("name"));
                this.inu.cgt().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                this.inu.cgt().setgActivityContent(getIntent().getStringExtra("content"));
                this.inu.cgt().setgActivityTime(getIntent().getLongExtra("time", 0L));
            }
        }
        if (this.f4int == null) {
            this.f4int = new a(this);
        }
        this.f4int.a(this.inu.cgt(), this.inv);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        long j = 0;
        if (this.inu.cgt() != null) {
            j = this.inu.cgt().getGroupId();
        }
        bundle.putLong("gid", j);
        bundle.putString("name", this.f4int.getTitle());
        bundle.putString("content", this.f4int.getContent());
        bundle.putString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, this.f4int.cgy());
        bundle.putLong("time", this.f4int.getTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.f4int != null) {
            this.f4int.onChangeSkinType(i);
        }
    }

    private void initListener() {
        registerListener(this.idb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.inu.cancelMessage();
        this.f4int.destroy();
        MessageManager.getInstance().unRegisterListener(this.idb);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f4int.cgw()) {
            cgs();
        } else if (view == this.f4int.cgx() && this.inu != null && this.inu.cgt() != null) {
            long time = this.f4int.getTime();
            if ((!this.inv || this.f4int.cgz()) && 1000 * time < System.currentTimeMillis()) {
                showToast(R.string.group_activity_time_val);
                return;
            }
            this.inu.cgt().setgActivityArea(this.f4int.cgy());
            this.inu.cgt().setgActivityContent(this.f4int.getContent());
            this.inu.cgt().setgActivityTime(time);
            this.inu.cgt().setgActivityTitle(this.f4int.getTitle());
            showProgressBar();
            this.inu.oP(this.inv);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            cgs();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void cgs() {
        DialogUtil.quitCreateGroupActivity(getPageContext().getPageActivity(), this.inv, new a.b() { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.2
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
