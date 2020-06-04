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
    private a iCM;
    private CreateGroupActivityModel iCN;
    private boolean iCO = false;
    private c isB = new c(CmdConfigSocket.CMD_CREATE_GROUP_ACTIVITY) { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.1
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
                        if (CreateGroupActivityActivity.this.iCO) {
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
        this.iCN = new CreateGroupActivityModel(this);
        this.iCM = new a(this);
        if (this.iCN.cna() != null) {
            if (bundle != null) {
                this.iCN.cna().setGroupId(bundle.getLong("gid", 0L));
                this.iCO = bundle.getBoolean(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.iCO) {
                    this.iCN.cna().setActivityId(bundle.getInt("aid", 0));
                    this.iCN.cna().setgActivityTitle(bundle.getString("name"));
                    this.iCN.cna().setgActivityArea(bundle.getString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.iCN.cna().setgActivityContent(bundle.getString("content"));
                    this.iCN.cna().setgActivityTime(bundle.getLong("time", 0L));
                }
            } else if (getIntent() != null) {
                this.iCN.cna().setGroupId(getIntent().getLongExtra("gid", 0L));
                this.iCO = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.iCO) {
                    this.iCN.cna().setActivityId(getIntent().getIntExtra("aid", 0));
                    this.iCN.cna().setgActivityTitle(getIntent().getStringExtra("name"));
                    this.iCN.cna().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.iCN.cna().setgActivityContent(getIntent().getStringExtra("content"));
                    this.iCN.cna().setgActivityTime(getIntent().getLongExtra("time", 0L));
                }
            }
        }
        this.iCM.a(this.iCN.cna(), this.iCO);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initListener();
        if (this.iCN == null) {
            this.iCN = new CreateGroupActivityModel(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null && this.iCN.cna() != null) {
            this.iCN.cna().setGroupId(intent.getLongExtra("gid", 0L));
            this.iCO = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
            if (this.iCO) {
                this.iCN.cna().setActivityId(intent.getIntExtra("aid", 0));
                this.iCN.cna().setgActivityTitle(getIntent().getStringExtra("name"));
                this.iCN.cna().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                this.iCN.cna().setgActivityContent(getIntent().getStringExtra("content"));
                this.iCN.cna().setgActivityTime(getIntent().getLongExtra("time", 0L));
            }
        }
        if (this.iCM == null) {
            this.iCM = new a(this);
        }
        this.iCM.a(this.iCN.cna(), this.iCO);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        long j = 0;
        if (this.iCN.cna() != null) {
            j = this.iCN.cna().getGroupId();
        }
        bundle.putLong("gid", j);
        bundle.putString("name", this.iCM.getTitle());
        bundle.putString("content", this.iCM.getContent());
        bundle.putString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, this.iCM.cnf());
        bundle.putLong("time", this.iCM.getTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.iCM != null) {
            this.iCM.onChangeSkinType(i);
        }
    }

    private void initListener() {
        registerListener(this.isB);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.iCN.cancelMessage();
        this.iCM.destroy();
        MessageManager.getInstance().unRegisterListener(this.isB);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iCM.cnd()) {
            cmZ();
        } else if (view == this.iCM.cne() && this.iCN != null && this.iCN.cna() != null) {
            long time = this.iCM.getTime();
            if ((!this.iCO || this.iCM.cng()) && 1000 * time < System.currentTimeMillis()) {
                showToast(R.string.group_activity_time_val);
                return;
            }
            this.iCN.cna().setgActivityArea(this.iCM.cnf());
            this.iCN.cna().setgActivityContent(this.iCM.getContent());
            this.iCN.cna().setgActivityTime(time);
            this.iCN.cna().setgActivityTitle(this.iCM.getTitle());
            showProgressBar();
            this.iCN.pl(this.iCO);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            cmZ();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void cmZ() {
        DialogUtil.quitCreateGroupActivity(getPageContext().getPageActivity(), this.iCO, new a.b() { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.2
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
