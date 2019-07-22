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
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.ResponseCreateGroupActivityMessage;
import com.baidu.tieba.im.util.DialogUtil;
/* loaded from: classes5.dex */
public class CreateGroupActivityActivity extends BaseActivity implements View.OnClickListener {
    private a gIm;
    private CreateGroupActivityModel gIn;
    private boolean gIo = false;
    private c gxX = new c(103120) { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.1
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
                        if (CreateGroupActivityActivity.this.gIo) {
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
        this.gIn = new CreateGroupActivityModel(this);
        this.gIm = new a(this);
        if (this.gIn.bDR() != null) {
            if (bundle != null) {
                this.gIn.bDR().setGroupId(bundle.getLong("gid", 0L));
                this.gIo = bundle.getBoolean(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.gIo) {
                    this.gIn.bDR().setActivityId(bundle.getInt("aid", 0));
                    this.gIn.bDR().setgActivityTitle(bundle.getString("name"));
                    this.gIn.bDR().setgActivityArea(bundle.getString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.gIn.bDR().setgActivityContent(bundle.getString("content"));
                    this.gIn.bDR().setgActivityTime(bundle.getLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L));
                }
            } else if (getIntent() != null) {
                this.gIn.bDR().setGroupId(getIntent().getLongExtra("gid", 0L));
                this.gIo = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.gIo) {
                    this.gIn.bDR().setActivityId(getIntent().getIntExtra("aid", 0));
                    this.gIn.bDR().setgActivityTitle(getIntent().getStringExtra("name"));
                    this.gIn.bDR().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.gIn.bDR().setgActivityContent(getIntent().getStringExtra("content"));
                    this.gIn.bDR().setgActivityTime(getIntent().getLongExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L));
                }
            }
        }
        this.gIm.a(this.gIn.bDR(), this.gIo);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initListener();
        if (this.gIn == null) {
            this.gIn = new CreateGroupActivityModel(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null && this.gIn.bDR() != null) {
            this.gIn.bDR().setGroupId(intent.getLongExtra("gid", 0L));
            this.gIo = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
            if (this.gIo) {
                this.gIn.bDR().setActivityId(intent.getIntExtra("aid", 0));
                this.gIn.bDR().setgActivityTitle(getIntent().getStringExtra("name"));
                this.gIn.bDR().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                this.gIn.bDR().setgActivityContent(getIntent().getStringExtra("content"));
                this.gIn.bDR().setgActivityTime(getIntent().getLongExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L));
            }
        }
        if (this.gIm == null) {
            this.gIm = new a(this);
        }
        this.gIm.a(this.gIn.bDR(), this.gIo);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        long j = 0;
        if (this.gIn.bDR() != null) {
            j = this.gIn.bDR().getGroupId();
        }
        bundle.putLong("gid", j);
        bundle.putString("name", this.gIm.getTitle());
        bundle.putString("content", this.gIm.getContent());
        bundle.putString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, this.gIm.bDW());
        bundle.putLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.gIm.getTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.gIm != null) {
            this.gIm.onChangeSkinType(i);
        }
    }

    private void initListener() {
        registerListener(this.gxX);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gIn.cancelMessage();
        this.gIm.destroy();
        MessageManager.getInstance().unRegisterListener(this.gxX);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gIm.bDU()) {
            bDQ();
        } else if (view == this.gIm.bDV() && this.gIn != null && this.gIn.bDR() != null) {
            long time = this.gIm.getTime();
            if ((!this.gIo || this.gIm.bDX()) && 1000 * time < System.currentTimeMillis()) {
                showToast(R.string.group_activity_time_val);
                return;
            }
            this.gIn.bDR().setgActivityArea(this.gIm.bDW());
            this.gIn.bDR().setgActivityContent(this.gIm.getContent());
            this.gIn.bDR().setgActivityTime(time);
            this.gIn.bDR().setgActivityTitle(this.gIm.getTitle());
            showProgressBar();
            this.gIn.mn(this.gIo);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            bDQ();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bDQ() {
        DialogUtil.quitCreateGroupActivity(getPageContext().getPageActivity(), this.gIo, new a.b() { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.2
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
