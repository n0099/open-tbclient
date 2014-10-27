package com.baidu.tieba.im.groupActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.util.DialogUtil;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class CreateGroupActivityActivity extends BaseFragmentActivity implements View.OnClickListener {
    private e aYx;
    private d aYy;
    private boolean aYz = false;
    private com.baidu.adp.framework.listener.e ayJ = new a(this, 103120);

    public static void j(Context context, int i) {
        if (context != null) {
            Intent intent = new Intent(context, CreateGroupActivityActivity.class);
            intent.putExtra("gid", i);
            intent.putExtra("isedit", false);
            context.startActivity(intent);
        }
    }

    public static void a(Activity activity, int i, GroupActivityData groupActivityData, int i2) {
        if (activity != null && i != 0 && groupActivityData != null) {
            Intent intent = new Intent(activity, CreateGroupActivityActivity.class);
            intent.putExtra("gid", i);
            intent.putExtra("isedit", true);
            intent.putExtra("aid", groupActivityData.getActivityId());
            intent.putExtra("name", groupActivityData.getgActivityTitle());
            intent.putExtra("time", groupActivityData.getgActivityTime());
            intent.putExtra("area", groupActivityData.getgActivityArea());
            intent.putExtra("content", groupActivityData.getgActivityContent());
            activity.startActivityForResult(intent, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        HJ();
        this.aYy = new d(this);
        this.aYx = new e(this);
        if (this.aYy.NY() != null) {
            if (bundle != null) {
                this.aYy.NY().setGroupId(bundle.getInt("gid", 0));
                this.aYz = bundle.getBoolean("isedit", false);
                if (this.aYz) {
                    this.aYy.NY().setActivityId(bundle.getInt("aid", 0));
                    this.aYy.NY().setgActivityTitle(bundle.getString("name"));
                    this.aYy.NY().setgActivityArea(bundle.getString("area"));
                    this.aYy.NY().setgActivityContent(bundle.getString("content"));
                    this.aYy.NY().setgActivityTime(bundle.getLong("time", 0L));
                }
            } else if (getIntent() != null) {
                this.aYy.NY().setGroupId(getIntent().getIntExtra("gid", 0));
                this.aYz = getIntent().getBooleanExtra("isedit", false);
                if (this.aYz) {
                    this.aYy.NY().setActivityId(getIntent().getIntExtra("aid", 0));
                    this.aYy.NY().setgActivityTitle(getIntent().getStringExtra("name"));
                    this.aYy.NY().setgActivityArea(getIntent().getStringExtra("area"));
                    this.aYy.NY().setgActivityContent(getIntent().getStringExtra("content"));
                    this.aYy.NY().setgActivityTime(getIntent().getLongExtra("time", 0L));
                }
            }
        }
        this.aYx.a(this.aYy.NY(), this.aYz);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        HJ();
        if (this.aYy == null) {
            this.aYy = new d(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null && this.aYy.NY() != null) {
            this.aYy.NY().setGroupId(intent.getIntExtra("gid", 0));
            this.aYz = getIntent().getBooleanExtra("isedit", false);
            if (this.aYz) {
                this.aYy.NY().setActivityId(intent.getIntExtra("aid", 0));
                this.aYy.NY().setgActivityTitle(getIntent().getStringExtra("name"));
                this.aYy.NY().setgActivityArea(getIntent().getStringExtra("area"));
                this.aYy.NY().setgActivityContent(getIntent().getStringExtra("content"));
                this.aYy.NY().setgActivityTime(getIntent().getLongExtra("time", 0L));
            }
        }
        if (this.aYx == null) {
            this.aYx = new e(this);
        }
        this.aYx.a(this.aYy.NY(), this.aYz);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        int i = 0;
        if (this.aYy.NY() != null) {
            i = this.aYy.NY().getGroupId();
        }
        bundle.putInt("gid", i);
        bundle.putString("name", this.aYx.getTitle());
        bundle.putString("content", this.aYx.getContent());
        bundle.putString("area", this.aYx.Od());
        bundle.putLong("time", this.aYx.getTime());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        if (this.aYx != null) {
            this.aYx.onChangeSkinType(i);
        }
    }

    private void HJ() {
        registerListener(this.ayJ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.aYy.cancelMessage();
        this.aYx.destroy();
        MessageManager.getInstance().unRegisterListener(this.ayJ);
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aYx.Ob()) {
            NX();
        } else if (view == this.aYx.Oc() && this.aYy != null && this.aYy.NY() != null) {
            long time = this.aYx.getTime();
            if ((!this.aYz || this.aYx.Oe()) && 1000 * time < System.currentTimeMillis()) {
                showToast(y.group_activity_time_val);
                return;
            }
            this.aYy.NY().setgActivityArea(this.aYx.Od());
            this.aYy.NY().setgActivityContent(this.aYx.getContent());
            this.aYy.NY().setgActivityTime(time);
            this.aYy.NY().setgActivityTitle(this.aYx.getTitle());
            showProgressBar();
            this.aYy.bK(this.aYz);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            NX();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void NX() {
        DialogUtil.quitCreateGroupActivity(this, this.aYz, new b(this), new c(this));
    }
}
