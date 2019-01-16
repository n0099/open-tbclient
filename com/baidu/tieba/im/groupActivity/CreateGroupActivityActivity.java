package com.baidu.tieba.im.groupActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.c;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.e;
import com.baidu.tieba.im.message.ResponseCreateGroupActivityMessage;
import com.baidu.tieba.im.util.DialogUtil;
/* loaded from: classes3.dex */
public class CreateGroupActivityActivity extends BaseActivity implements View.OnClickListener {
    private a eUQ;
    private CreateGroupActivityModel eUR;
    private boolean eUS = false;
    private c eKD = new c(103120) { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            CreateGroupActivityActivity.this.hideProgressBar();
            if (socketResponsedMessage == null) {
                CreateGroupActivityActivity.this.showToast(e.j.neterror);
            } else if (socketResponsedMessage.getCmd() == 103120) {
                if (socketResponsedMessage instanceof ResponseCreateGroupActivityMessage) {
                    ResponseCreateGroupActivityMessage responseCreateGroupActivityMessage = (ResponseCreateGroupActivityMessage) socketResponsedMessage;
                    if (responseCreateGroupActivityMessage.getError() == 0) {
                        if (CreateGroupActivityActivity.this.eUS) {
                            CreateGroupActivityActivity.this.showToast(e.j.group_activity_edit_succ);
                        } else {
                            CreateGroupActivityActivity.this.showToast(e.j.group_activity_create_succ);
                        }
                        CreateGroupActivityActivity.this.setResult(-1);
                        CreateGroupActivityActivity.this.finish();
                        return;
                    }
                    CreateGroupActivityActivity.this.showToast(StringUtils.isNull(responseCreateGroupActivityMessage.getErrorString()) ? CreateGroupActivityActivity.this.getResources().getString(e.j.neterror) : responseCreateGroupActivityMessage.getErrorString());
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
        this.eUR = new CreateGroupActivityModel(this);
        this.eUQ = new a(this);
        if (this.eUR.aSS() != null) {
            if (bundle != null) {
                this.eUR.aSS().setGroupId(bundle.getLong("gid", 0L));
                this.eUS = bundle.getBoolean(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.eUS) {
                    this.eUR.aSS().setActivityId(bundle.getInt("aid", 0));
                    this.eUR.aSS().setgActivityTitle(bundle.getString("name"));
                    this.eUR.aSS().setgActivityArea(bundle.getString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.eUR.aSS().setgActivityContent(bundle.getString("content"));
                    this.eUR.aSS().setgActivityTime(bundle.getLong("time", 0L));
                }
            } else if (getIntent() != null) {
                this.eUR.aSS().setGroupId(getIntent().getLongExtra("gid", 0L));
                this.eUS = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.eUS) {
                    this.eUR.aSS().setActivityId(getIntent().getIntExtra("aid", 0));
                    this.eUR.aSS().setgActivityTitle(getIntent().getStringExtra("name"));
                    this.eUR.aSS().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.eUR.aSS().setgActivityContent(getIntent().getStringExtra("content"));
                    this.eUR.aSS().setgActivityTime(getIntent().getLongExtra("time", 0L));
                }
            }
        }
        this.eUQ.a(this.eUR.aSS(), this.eUS);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initListener();
        if (this.eUR == null) {
            this.eUR = new CreateGroupActivityModel(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null && this.eUR.aSS() != null) {
            this.eUR.aSS().setGroupId(intent.getLongExtra("gid", 0L));
            this.eUS = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
            if (this.eUS) {
                this.eUR.aSS().setActivityId(intent.getIntExtra("aid", 0));
                this.eUR.aSS().setgActivityTitle(getIntent().getStringExtra("name"));
                this.eUR.aSS().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                this.eUR.aSS().setgActivityContent(getIntent().getStringExtra("content"));
                this.eUR.aSS().setgActivityTime(getIntent().getLongExtra("time", 0L));
            }
        }
        if (this.eUQ == null) {
            this.eUQ = new a(this);
        }
        this.eUQ.a(this.eUR.aSS(), this.eUS);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        long j = 0;
        if (this.eUR.aSS() != null) {
            j = this.eUR.aSS().getGroupId();
        }
        bundle.putLong("gid", j);
        bundle.putString("name", this.eUQ.getTitle());
        bundle.putString("content", this.eUQ.getContent());
        bundle.putString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, this.eUQ.aSX());
        bundle.putLong("time", this.eUQ.getTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.eUQ != null) {
            this.eUQ.onChangeSkinType(i);
        }
    }

    private void initListener() {
        registerListener(this.eKD);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eUR.cancelMessage();
        this.eUQ.destroy();
        MessageManager.getInstance().unRegisterListener(this.eKD);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eUQ.aSV()) {
            aSR();
        } else if (view == this.eUQ.aSW() && this.eUR != null && this.eUR.aSS() != null) {
            long time = this.eUQ.getTime();
            if ((!this.eUS || this.eUQ.aSY()) && 1000 * time < System.currentTimeMillis()) {
                showToast(e.j.group_activity_time_val);
                return;
            }
            this.eUR.aSS().setgActivityArea(this.eUQ.aSX());
            this.eUR.aSS().setgActivityContent(this.eUQ.getContent());
            this.eUR.aSS().setgActivityTime(time);
            this.eUR.aSS().setgActivityTitle(this.eUQ.getTitle());
            showProgressBar();
            this.eUR.iJ(this.eUS);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            aSR();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void aSR() {
        DialogUtil.quitCreateGroupActivity(getPageContext().getPageActivity(), this.eUS, new a.b() { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.2
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
