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
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class CreateGroupActivityActivity extends BaseFragmentActivity implements View.OnClickListener {
    private e d;
    private d e;
    private boolean f = false;
    private com.baidu.adp.framework.listener.d g = new a(this, 103120);

    public static void a(Context context, int i) {
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
        g();
        this.e = new d(this);
        this.d = new e(this);
        if (this.e.a() != null) {
            if (bundle != null) {
                this.e.a().setGroupId(bundle.getInt("gid", 0));
                this.f = bundle.getBoolean("isedit", false);
                if (this.f) {
                    this.e.a().setActivityId(bundle.getInt("aid", 0));
                    this.e.a().setgActivityTitle(bundle.getString("name"));
                    this.e.a().setgActivityArea(bundle.getString("area"));
                    this.e.a().setgActivityContent(bundle.getString("content"));
                    this.e.a().setgActivityTime(bundle.getLong("time", 0L));
                }
            } else if (getIntent() != null) {
                this.e.a().setGroupId(getIntent().getIntExtra("gid", 0));
                this.f = getIntent().getBooleanExtra("isedit", false);
                if (this.f) {
                    this.e.a().setActivityId(getIntent().getIntExtra("aid", 0));
                    this.e.a().setgActivityTitle(getIntent().getStringExtra("name"));
                    this.e.a().setgActivityArea(getIntent().getStringExtra("area"));
                    this.e.a().setgActivityContent(getIntent().getStringExtra("content"));
                    this.e.a().setgActivityTime(getIntent().getLongExtra("time", 0L));
                }
            }
        }
        this.d.a(this.e.a(), this.f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        g();
        if (this.e == null) {
            this.e = new d(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null && this.e.a() != null) {
            this.e.a().setGroupId(intent.getIntExtra("gid", 0));
            this.f = getIntent().getBooleanExtra("isedit", false);
            if (this.f) {
                this.e.a().setActivityId(intent.getIntExtra("aid", 0));
                this.e.a().setgActivityTitle(getIntent().getStringExtra("name"));
                this.e.a().setgActivityArea(getIntent().getStringExtra("area"));
                this.e.a().setgActivityContent(getIntent().getStringExtra("content"));
                this.e.a().setgActivityTime(getIntent().getLongExtra("time", 0L));
            }
        }
        if (this.d == null) {
            this.d = new e(this);
        }
        this.d.a(this.e.a(), this.f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        int i = 0;
        if (this.e.a() != null) {
            i = this.e.a().getGroupId();
        }
        bundle.putInt("gid", i);
        bundle.putString("name", this.d.c());
        bundle.putString("content", this.d.e());
        bundle.putString("area", this.d.d());
        bundle.putLong("time", this.d.f());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void b(int i) {
        if (this.d != null) {
            this.d.a(i);
        }
    }

    private void g() {
        a(this.g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.e.cancelMessage();
        this.d.destroy();
        MessageManager.getInstance().unRegisterListener(this.g);
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.d.a()) {
            h();
        } else if (view == this.d.b() && this.e != null && this.e.a() != null) {
            long f = this.d.f();
            if ((!this.f || this.d.g()) && 1000 * f < System.currentTimeMillis()) {
                c(x.group_activity_time_val);
                return;
            }
            this.e.a().setgActivityArea(this.d.d());
            this.e.a().setgActivityContent(this.d.e());
            this.e.a().setgActivityTime(f);
            this.e.a().setgActivityTitle(this.d.c());
            e_();
            this.e.a(this.f);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            h();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void h() {
        com.baidu.tieba.im.d.b.a(this, this.f, new b(this), new c(this));
    }
}
