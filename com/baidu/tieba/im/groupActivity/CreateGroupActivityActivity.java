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
import com.baidu.tieba.f;
import com.baidu.tieba.im.message.ResponseCreateGroupActivityMessage;
import com.baidu.tieba.im.util.DialogUtil;
/* loaded from: classes3.dex */
public class CreateGroupActivityActivity extends BaseActivity implements View.OnClickListener {
    private a eub;
    private CreateGroupActivityModel euc;
    private boolean eud = false;
    private c ejH = new c(103120) { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            CreateGroupActivityActivity.this.hideProgressBar();
            if (socketResponsedMessage == null) {
                CreateGroupActivityActivity.this.showToast(f.j.neterror);
            } else if (socketResponsedMessage.getCmd() == 103120) {
                if (socketResponsedMessage instanceof ResponseCreateGroupActivityMessage) {
                    ResponseCreateGroupActivityMessage responseCreateGroupActivityMessage = (ResponseCreateGroupActivityMessage) socketResponsedMessage;
                    if (responseCreateGroupActivityMessage.getError() == 0) {
                        if (CreateGroupActivityActivity.this.eud) {
                            CreateGroupActivityActivity.this.showToast(f.j.group_activity_edit_succ);
                        } else {
                            CreateGroupActivityActivity.this.showToast(f.j.group_activity_create_succ);
                        }
                        CreateGroupActivityActivity.this.setResult(-1);
                        CreateGroupActivityActivity.this.finish();
                        return;
                    }
                    CreateGroupActivityActivity.this.showToast(StringUtils.isNull(responseCreateGroupActivityMessage.getErrorString()) ? CreateGroupActivityActivity.this.getResources().getString(f.j.neterror) : responseCreateGroupActivityMessage.getErrorString());
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
        this.euc = new CreateGroupActivityModel(this);
        this.eub = new a(this);
        if (this.euc.aKM() != null) {
            if (bundle != null) {
                this.euc.aKM().setGroupId(bundle.getLong("gid", 0L));
                this.eud = bundle.getBoolean(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.eud) {
                    this.euc.aKM().setActivityId(bundle.getInt("aid", 0));
                    this.euc.aKM().setgActivityTitle(bundle.getString("name"));
                    this.euc.aKM().setgActivityArea(bundle.getString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.euc.aKM().setgActivityContent(bundle.getString("content"));
                    this.euc.aKM().setgActivityTime(bundle.getLong("time", 0L));
                }
            } else if (getIntent() != null) {
                this.euc.aKM().setGroupId(getIntent().getLongExtra("gid", 0L));
                this.eud = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.eud) {
                    this.euc.aKM().setActivityId(getIntent().getIntExtra("aid", 0));
                    this.euc.aKM().setgActivityTitle(getIntent().getStringExtra("name"));
                    this.euc.aKM().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.euc.aKM().setgActivityContent(getIntent().getStringExtra("content"));
                    this.euc.aKM().setgActivityTime(getIntent().getLongExtra("time", 0L));
                }
            }
        }
        this.eub.a(this.euc.aKM(), this.eud);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initListener();
        if (this.euc == null) {
            this.euc = new CreateGroupActivityModel(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null && this.euc.aKM() != null) {
            this.euc.aKM().setGroupId(intent.getLongExtra("gid", 0L));
            this.eud = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
            if (this.eud) {
                this.euc.aKM().setActivityId(intent.getIntExtra("aid", 0));
                this.euc.aKM().setgActivityTitle(getIntent().getStringExtra("name"));
                this.euc.aKM().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                this.euc.aKM().setgActivityContent(getIntent().getStringExtra("content"));
                this.euc.aKM().setgActivityTime(getIntent().getLongExtra("time", 0L));
            }
        }
        if (this.eub == null) {
            this.eub = new a(this);
        }
        this.eub.a(this.euc.aKM(), this.eud);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        long j = 0;
        if (this.euc.aKM() != null) {
            j = this.euc.aKM().getGroupId();
        }
        bundle.putLong("gid", j);
        bundle.putString("name", this.eub.getTitle());
        bundle.putString("content", this.eub.getContent());
        bundle.putString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, this.eub.aKR());
        bundle.putLong("time", this.eub.getTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.eub != null) {
            this.eub.onChangeSkinType(i);
        }
    }

    private void initListener() {
        registerListener(this.ejH);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.euc.cancelMessage();
        this.eub.destroy();
        MessageManager.getInstance().unRegisterListener(this.ejH);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eub.aKP()) {
            aKL();
        } else if (view == this.eub.aKQ() && this.euc != null && this.euc.aKM() != null) {
            long time = this.eub.getTime();
            if ((!this.eud || this.eub.aKS()) && 1000 * time < System.currentTimeMillis()) {
                showToast(f.j.group_activity_time_val);
                return;
            }
            this.euc.aKM().setgActivityArea(this.eub.aKR());
            this.euc.aKM().setgActivityContent(this.eub.getContent());
            this.euc.aKM().setgActivityTime(time);
            this.euc.aKM().setgActivityTitle(this.eub.getTitle());
            showProgressBar();
            this.euc.hE(this.eud);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            aKL();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void aKL() {
        DialogUtil.quitCreateGroupActivity(getPageContext().getPageActivity(), this.eud, new a.b() { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.2
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
