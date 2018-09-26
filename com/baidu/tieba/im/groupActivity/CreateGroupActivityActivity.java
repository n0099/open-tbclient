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
    private a eBu;
    private CreateGroupActivityModel eBv;
    private boolean eBw = false;
    private c era = new c(103120) { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.1
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
                        if (CreateGroupActivityActivity.this.eBw) {
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
        this.eBv = new CreateGroupActivityModel(this);
        this.eBu = new a(this);
        if (this.eBv.aNb() != null) {
            if (bundle != null) {
                this.eBv.aNb().setGroupId(bundle.getLong("gid", 0L));
                this.eBw = bundle.getBoolean(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.eBw) {
                    this.eBv.aNb().setActivityId(bundle.getInt("aid", 0));
                    this.eBv.aNb().setgActivityTitle(bundle.getString("name"));
                    this.eBv.aNb().setgActivityArea(bundle.getString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.eBv.aNb().setgActivityContent(bundle.getString("content"));
                    this.eBv.aNb().setgActivityTime(bundle.getLong("time", 0L));
                }
            } else if (getIntent() != null) {
                this.eBv.aNb().setGroupId(getIntent().getLongExtra("gid", 0L));
                this.eBw = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.eBw) {
                    this.eBv.aNb().setActivityId(getIntent().getIntExtra("aid", 0));
                    this.eBv.aNb().setgActivityTitle(getIntent().getStringExtra("name"));
                    this.eBv.aNb().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.eBv.aNb().setgActivityContent(getIntent().getStringExtra("content"));
                    this.eBv.aNb().setgActivityTime(getIntent().getLongExtra("time", 0L));
                }
            }
        }
        this.eBu.a(this.eBv.aNb(), this.eBw);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initListener();
        if (this.eBv == null) {
            this.eBv = new CreateGroupActivityModel(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null && this.eBv.aNb() != null) {
            this.eBv.aNb().setGroupId(intent.getLongExtra("gid", 0L));
            this.eBw = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
            if (this.eBw) {
                this.eBv.aNb().setActivityId(intent.getIntExtra("aid", 0));
                this.eBv.aNb().setgActivityTitle(getIntent().getStringExtra("name"));
                this.eBv.aNb().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                this.eBv.aNb().setgActivityContent(getIntent().getStringExtra("content"));
                this.eBv.aNb().setgActivityTime(getIntent().getLongExtra("time", 0L));
            }
        }
        if (this.eBu == null) {
            this.eBu = new a(this);
        }
        this.eBu.a(this.eBv.aNb(), this.eBw);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        long j = 0;
        if (this.eBv.aNb() != null) {
            j = this.eBv.aNb().getGroupId();
        }
        bundle.putLong("gid", j);
        bundle.putString("name", this.eBu.getTitle());
        bundle.putString("content", this.eBu.getContent());
        bundle.putString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, this.eBu.aNg());
        bundle.putLong("time", this.eBu.getTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.eBu != null) {
            this.eBu.onChangeSkinType(i);
        }
    }

    private void initListener() {
        registerListener(this.era);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eBv.cancelMessage();
        this.eBu.destroy();
        MessageManager.getInstance().unRegisterListener(this.era);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eBu.aNe()) {
            aNa();
        } else if (view == this.eBu.aNf() && this.eBv != null && this.eBv.aNb() != null) {
            long time = this.eBu.getTime();
            if ((!this.eBw || this.eBu.aNh()) && 1000 * time < System.currentTimeMillis()) {
                showToast(e.j.group_activity_time_val);
                return;
            }
            this.eBv.aNb().setgActivityArea(this.eBu.aNg());
            this.eBv.aNb().setgActivityContent(this.eBu.getContent());
            this.eBv.aNb().setgActivityTime(time);
            this.eBv.aNb().setgActivityTitle(this.eBu.getTitle());
            showProgressBar();
            this.eBv.ic(this.eBw);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            aNa();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void aNa() {
        DialogUtil.quitCreateGroupActivity(getPageContext().getPageActivity(), this.eBw, new a.b() { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.2
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
