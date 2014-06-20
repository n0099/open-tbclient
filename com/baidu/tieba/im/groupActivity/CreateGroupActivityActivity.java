package com.baidu.tieba.im.groupActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class CreateGroupActivityActivity extends BaseFragmentActivity implements View.OnClickListener {
    private e c;
    private d d;
    private boolean e = false;
    private com.baidu.adp.framework.listener.b f = new a(this, MessageTypes.CMD_CREATE_GROUP_ACTIVITY);

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
        e();
        this.d = new d(this);
        this.c = new e(this);
        if (this.d.a() != null) {
            if (bundle != null) {
                this.d.a().setGroupId(bundle.getInt("gid", 0));
                this.e = bundle.getBoolean("isedit", false);
                if (this.e) {
                    this.d.a().setActivityId(bundle.getInt("aid", 0));
                    this.d.a().setgActivityTitle(bundle.getString("name"));
                    this.d.a().setgActivityArea(bundle.getString("area"));
                    this.d.a().setgActivityContent(bundle.getString("content"));
                    this.d.a().setgActivityTime(bundle.getLong("time", 0L));
                }
            } else if (getIntent() != null) {
                this.d.a().setGroupId(getIntent().getIntExtra("gid", 0));
                this.e = getIntent().getBooleanExtra("isedit", false);
                if (this.e) {
                    this.d.a().setActivityId(getIntent().getIntExtra("aid", 0));
                    this.d.a().setgActivityTitle(getIntent().getStringExtra("name"));
                    this.d.a().setgActivityArea(getIntent().getStringExtra("area"));
                    this.d.a().setgActivityContent(getIntent().getStringExtra("content"));
                    this.d.a().setgActivityTime(getIntent().getLongExtra("time", 0L));
                }
            }
        }
        this.c.a(this.d.a(), this.e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        e();
        if (this.d == null) {
            this.d = new d(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null && this.d.a() != null) {
            this.d.a().setGroupId(intent.getIntExtra("gid", 0));
            this.e = getIntent().getBooleanExtra("isedit", false);
            if (this.e) {
                this.d.a().setActivityId(intent.getIntExtra("aid", 0));
                this.d.a().setgActivityTitle(getIntent().getStringExtra("name"));
                this.d.a().setgActivityArea(getIntent().getStringExtra("area"));
                this.d.a().setgActivityContent(getIntent().getStringExtra("content"));
                this.d.a().setgActivityTime(getIntent().getLongExtra("time", 0L));
            }
        }
        if (this.c == null) {
            this.c = new e(this);
        }
        this.c.a(this.d.a(), this.e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        int i = 0;
        if (this.d.a() != null) {
            i = this.d.a().getGroupId();
        }
        bundle.putInt("gid", i);
        bundle.putString("name", this.c.c());
        bundle.putString("content", this.c.e());
        bundle.putString("area", this.c.d());
        bundle.putLong("time", this.c.f());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void b(int i) {
        if (this.c != null) {
            this.c.a(i);
        }
    }

    private void e() {
        a(this.f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.d.cancelMessage();
        this.c.destroy();
        MessageManager.getInstance().unRegisterListener(this.f);
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.c.a()) {
            f();
        } else if (view == this.c.b() && this.d != null && this.d.a() != null) {
            long f = this.c.f();
            if ((!this.e || this.c.g()) && 1000 * f < System.currentTimeMillis()) {
                c(y.group_activity_time_val);
                return;
            }
            this.d.a().setgActivityArea(this.c.d());
            this.d.a().setgActivityContent(this.c.e());
            this.d.a().setgActivityTime(f);
            this.d.a().setgActivityTitle(this.c.c());
            c();
            this.d.a(this.e);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            f();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void f() {
        com.baidu.tieba.im.e.b.a(this, this.e, new b(this), new c(this));
    }
}
