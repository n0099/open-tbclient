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
    private s aYY;
    private r aYZ;
    private CustomMessageListener mCustomListener = new n(this, 2001127);
    private com.baidu.adp.framework.listener.e ayJ = new o(this, 0);

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
        HJ();
        if (this.aYZ == null) {
            this.aYZ = new r(this);
            this.aYZ.setUniqueId(getUniqueId());
        }
        if (bundle != null) {
            this.aYZ.fN(bundle.getInt("activity_id", 0));
            this.aYZ.S(bundle.getLong("group_id", 0L));
            this.aYZ.fM(bundle.getInt("from", 0));
        } else if (getIntent() != null) {
            this.aYZ.fN(getIntent().getIntExtra("activity_id", 0));
            this.aYZ.S(getIntent().getLongExtra("group_id", 0L));
            this.aYZ.fM(getIntent().getIntExtra("from", 0));
        }
        initUI();
        startLoading();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        HJ();
        initUI();
        if (this.aYZ == null) {
            this.aYZ = new r(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null) {
            this.aYZ.fN(intent.getIntExtra("activity_id", 0));
            this.aYZ.S(intent.getLongExtra("group_id", 0L));
            this.aYZ.fM(intent.getIntExtra("from", 0));
        }
        startLoading();
    }

    private void HJ() {
        registerListener(103015, this.ayJ);
        registerListener(this.mCustomListener);
        registerListener(103121, this.ayJ);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.aYZ != null) {
            bundle.putInt("activity_id", this.aYZ.Og());
            bundle.putLong("group_id", this.aYZ.Oh());
            bundle.putInt("from", this.aYZ.Of());
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
        this.aYZ.cancelMessage();
        if (this.aYY != null) {
            this.aYY.onDestory();
        }
    }

    private void initUI() {
        if (this.aYY == null) {
            this.aYY = new s(this);
        }
    }

    private void startLoading() {
        showProgressBar();
        this.aYZ.fQ(this.aYZ.Og());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.aYY != null) {
            this.aYY.changeSkinType(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aYY.Ok()) {
            closeActivity();
        } else if (view == this.aYY.Ol()) {
            DialogUtil.deleteGroupActivity(this, new p(this));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        super.onClick(dialogInterface, i);
        if (dialogInterface != null && dialogInterface == this.aYY.Om()) {
            if (i == 0) {
                CreateGroupActivityActivity.a(this, (int) this.aYZ.Oh(), this.aYZ.Oj(), 23001);
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
