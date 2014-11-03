package com.baidu.tieba.im.groupActivity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.util.DialogUtil;
/* loaded from: classes.dex */
public class GroupActivityActivity extends BaseActivity implements View.OnClickListener {
    private s aZl;
    private r aZm;
    private CustomMessageListener mCustomListener = new n(this, 2001127);
    private com.baidu.adp.framework.listener.e ayS = new o(this, 0);

    public static void a(Context context, int i, long j, int i2) {
        Intent intent = new Intent(context, GroupActivityActivity.class);
        intent.putExtra("activity_id", i);
        intent.putExtra("group_id", j);
        intent.putExtra("from", i2);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        HN();
        if (this.aZm == null) {
            this.aZm = new r(this);
            this.aZm.setUniqueId(getUniqueId());
        }
        if (bundle != null) {
            this.aZm.fN(bundle.getInt("activity_id", 0));
            this.aZm.S(bundle.getLong("group_id", 0L));
            this.aZm.fM(bundle.getInt("from", 0));
        } else if (getIntent() != null) {
            this.aZm.fN(getIntent().getIntExtra("activity_id", 0));
            this.aZm.S(getIntent().getLongExtra("group_id", 0L));
            this.aZm.fM(getIntent().getIntExtra("from", 0));
        }
        initUI();
        startLoading();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        HN();
        initUI();
        if (this.aZm == null) {
            this.aZm = new r(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null) {
            this.aZm.fN(intent.getIntExtra("activity_id", 0));
            this.aZm.S(intent.getLongExtra("group_id", 0L));
            this.aZm.fM(intent.getIntExtra("from", 0));
        }
        startLoading();
    }

    private void HN() {
        registerListener(103015, this.ayS);
        registerListener(this.mCustomListener);
        registerListener(103121, this.ayS);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.aZm != null) {
            bundle.putInt("activity_id", this.aZm.Oj());
            bundle.putLong("group_id", this.aZm.Ok());
            bundle.putInt("from", this.aZm.Oi());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.aZm.cancelMessage();
        if (this.aZl != null) {
            this.aZl.onDestory();
        }
    }

    private void initUI() {
        if (this.aZl == null) {
            this.aZl = new s(this);
        }
    }

    private void startLoading() {
        showProgressBar();
        this.aZm.fQ(this.aZm.Oj());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.aZl != null) {
            this.aZl.changeSkinType(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aZl.On()) {
            closeActivity();
        } else if (view == this.aZl.Oo()) {
            DialogUtil.deleteGroupActivity(this, new p(this));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        super.onClick(dialogInterface, i);
        if (dialogInterface != null && dialogInterface == this.aZl.Op()) {
            if (i == 0) {
                CreateGroupActivityActivity.a(this, (int) this.aZm.Ok(), this.aZm.Om(), 23001);
            } else if (i == 1) {
                DialogUtil.deleteGroupActivity(this, new q(this));
            }
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 23001:
                    finish();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        finish();
    }
}
