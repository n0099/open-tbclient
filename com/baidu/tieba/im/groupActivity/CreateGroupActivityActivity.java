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
    private a eUR;
    private CreateGroupActivityModel eUS;
    private boolean eUT = false;
    private c eKE = new c(103120) { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.1
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
                        if (CreateGroupActivityActivity.this.eUT) {
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
        this.eUS = new CreateGroupActivityModel(this);
        this.eUR = new a(this);
        if (this.eUS.aSS() != null) {
            if (bundle != null) {
                this.eUS.aSS().setGroupId(bundle.getLong("gid", 0L));
                this.eUT = bundle.getBoolean(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.eUT) {
                    this.eUS.aSS().setActivityId(bundle.getInt("aid", 0));
                    this.eUS.aSS().setgActivityTitle(bundle.getString("name"));
                    this.eUS.aSS().setgActivityArea(bundle.getString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.eUS.aSS().setgActivityContent(bundle.getString("content"));
                    this.eUS.aSS().setgActivityTime(bundle.getLong("time", 0L));
                }
            } else if (getIntent() != null) {
                this.eUS.aSS().setGroupId(getIntent().getLongExtra("gid", 0L));
                this.eUT = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.eUT) {
                    this.eUS.aSS().setActivityId(getIntent().getIntExtra("aid", 0));
                    this.eUS.aSS().setgActivityTitle(getIntent().getStringExtra("name"));
                    this.eUS.aSS().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.eUS.aSS().setgActivityContent(getIntent().getStringExtra("content"));
                    this.eUS.aSS().setgActivityTime(getIntent().getLongExtra("time", 0L));
                }
            }
        }
        this.eUR.a(this.eUS.aSS(), this.eUT);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initListener();
        if (this.eUS == null) {
            this.eUS = new CreateGroupActivityModel(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null && this.eUS.aSS() != null) {
            this.eUS.aSS().setGroupId(intent.getLongExtra("gid", 0L));
            this.eUT = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
            if (this.eUT) {
                this.eUS.aSS().setActivityId(intent.getIntExtra("aid", 0));
                this.eUS.aSS().setgActivityTitle(getIntent().getStringExtra("name"));
                this.eUS.aSS().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                this.eUS.aSS().setgActivityContent(getIntent().getStringExtra("content"));
                this.eUS.aSS().setgActivityTime(getIntent().getLongExtra("time", 0L));
            }
        }
        if (this.eUR == null) {
            this.eUR = new a(this);
        }
        this.eUR.a(this.eUS.aSS(), this.eUT);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        long j = 0;
        if (this.eUS.aSS() != null) {
            j = this.eUS.aSS().getGroupId();
        }
        bundle.putLong("gid", j);
        bundle.putString("name", this.eUR.getTitle());
        bundle.putString("content", this.eUR.getContent());
        bundle.putString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, this.eUR.aSX());
        bundle.putLong("time", this.eUR.getTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.eUR != null) {
            this.eUR.onChangeSkinType(i);
        }
    }

    private void initListener() {
        registerListener(this.eKE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eUS.cancelMessage();
        this.eUR.destroy();
        MessageManager.getInstance().unRegisterListener(this.eKE);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eUR.aSV()) {
            aSR();
        } else if (view == this.eUR.aSW() && this.eUS != null && this.eUS.aSS() != null) {
            long time = this.eUR.getTime();
            if ((!this.eUT || this.eUR.aSY()) && 1000 * time < System.currentTimeMillis()) {
                showToast(e.j.group_activity_time_val);
                return;
            }
            this.eUS.aSS().setgActivityArea(this.eUR.aSX());
            this.eUS.aSS().setgActivityContent(this.eUR.getContent());
            this.eUS.aSS().setgActivityTime(time);
            this.eUS.aSS().setgActivityTitle(this.eUR.getTitle());
            showProgressBar();
            this.eUS.iJ(this.eUT);
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
        DialogUtil.quitCreateGroupActivity(getPageContext().getPageActivity(), this.eUT, new a.b() { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.2
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
