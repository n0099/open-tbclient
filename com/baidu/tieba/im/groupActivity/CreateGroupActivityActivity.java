package com.baidu.tieba.im.groupActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.person.PersonInfoActivity;
/* loaded from: classes.dex */
public class CreateGroupActivityActivity extends com.baidu.tbadk.core.e implements View.OnClickListener {
    private e c;
    private d d;
    private boolean e = false;
    private com.baidu.adp.framework.c.g f = new a(this, 103120);

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
            intent.putExtra(PersonInfoActivity.TAG_NAME, groupActivityData.getgActivityTitle());
            intent.putExtra("time", groupActivityData.getgActivityTime());
            intent.putExtra("area", groupActivityData.getgActivityArea());
            intent.putExtra("content", groupActivityData.getgActivityContent());
            activity.startActivityForResult(intent, 23001);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.e, com.baidu.adp.a.c, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        f();
        this.d = new d(this);
        this.c = new e(this);
        if (this.d.a() != null) {
            if (bundle != null) {
                this.d.a().setGroupId(bundle.getInt("gid", 0));
                this.e = bundle.getBoolean("isedit", false);
                if (this.e) {
                    this.d.a().setActivityId(bundle.getInt("aid", 0));
                    this.d.a().setgActivityTitle(bundle.getString(PersonInfoActivity.TAG_NAME));
                    this.d.a().setgActivityArea(bundle.getString("area"));
                    this.d.a().setgActivityContent(bundle.getString("content"));
                    this.d.a().setgActivityTime(bundle.getLong("time", 0L));
                }
            } else if (getIntent() != null) {
                this.d.a().setGroupId(getIntent().getIntExtra("gid", 0));
                this.e = getIntent().getBooleanExtra("isedit", false);
                if (this.e) {
                    this.d.a().setActivityId(getIntent().getIntExtra("aid", 0));
                    this.d.a().setgActivityTitle(getIntent().getStringExtra(PersonInfoActivity.TAG_NAME));
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
        f();
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
                this.d.a().setgActivityTitle(getIntent().getStringExtra(PersonInfoActivity.TAG_NAME));
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
        bundle.putString(PersonInfoActivity.TAG_NAME, this.c.e());
        bundle.putString("content", this.c.g());
        bundle.putString("area", this.c.f());
        bundle.putLong("time", this.c.h());
    }

    @Override // com.baidu.tbadk.core.e
    protected final void c(int i) {
        if (this.c != null) {
            this.c.a(i);
        }
    }

    private void f() {
        a(this.f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.e, com.baidu.adp.a.c, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.d.cancelMessage();
        this.c.c();
    }

    @Override // com.baidu.adp.a.c, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.c.a()) {
            g();
        } else if (view == this.c.d() && this.d != null && this.d.a() != null) {
            long h = this.c.h();
            if ((!this.e || this.c.i()) && 1000 * h < System.currentTimeMillis()) {
                com.baidu.adp.lib.util.i.a((Context) this, com.baidu.tieba.im.j.group_activity_time_val);
                return;
            }
            this.d.a().setgActivityArea(this.c.f());
            this.d.a().setgActivityContent(this.c.g());
            this.d.a().setgActivityTime(h);
            this.d.a().setgActivityTitle(this.c.e());
            g_();
            this.d.a(this.e);
        }
    }

    @Override // com.baidu.tbadk.core.e, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (TextUtils.isEmpty(this.c.e())) {
                finish();
                return true;
            }
            g();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void g() {
        boolean z = this.e;
        new AlertDialog.Builder(this).setTitle(com.baidu.tieba.im.j.quit).setMessage(z ? com.baidu.tieba.im.j.group_activity_edit_quit : com.baidu.tieba.im.j.group_activity_create_quit).setPositiveButton(com.baidu.tieba.im.j.confirm, new b(this)).setNegativeButton(com.baidu.tieba.im.j.cancel, new c(this)).create().show();
    }
}
