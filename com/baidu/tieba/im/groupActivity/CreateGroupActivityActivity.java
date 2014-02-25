package com.baidu.tieba.im.groupActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.im.data.GroupActivityData;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class CreateGroupActivityActivity extends com.baidu.tieba.k implements View.OnClickListener {
    private e d;
    private d e;
    private c f;
    private boolean g = false;

    public static void a(Context context, int i) {
        if (context != null) {
            Intent intent = new Intent(context, CreateGroupActivityActivity.class);
            intent.putExtra(PushConstants.EXTRA_GID, i);
            intent.putExtra("isedit", false);
            context.startActivity(intent);
        }
    }

    public static void a(Activity activity, int i, GroupActivityData groupActivityData, int i2) {
        if (activity != null && i != 0 && groupActivityData != null) {
            Intent intent = new Intent(activity, CreateGroupActivityActivity.class);
            intent.putExtra(PushConstants.EXTRA_GID, i);
            intent.putExtra("isedit", true);
            intent.putExtra("aid", groupActivityData.getActivityId());
            intent.putExtra(SocialConstants.PARAM_MEDIA_UNAME, groupActivityData.getgActivityTitle());
            intent.putExtra("time", groupActivityData.getgActivityTime());
            intent.putExtra("area", groupActivityData.getgActivityArea());
            intent.putExtra(PushConstants.EXTRA_CONTENT, groupActivityData.getgActivityContent());
            activity.startActivityForResult(intent, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.k, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        e();
        this.e = new d();
        this.d = new e(this);
        if (this.e.a() != null) {
            if (bundle != null) {
                this.e.a().setGroupId(bundle.getInt(PushConstants.EXTRA_GID, 0));
                this.g = bundle.getBoolean("isedit", false);
                if (this.g) {
                    this.e.a().setActivityId(bundle.getInt("aid", 0));
                    this.e.a().setgActivityTitle(bundle.getString(SocialConstants.PARAM_MEDIA_UNAME));
                    this.e.a().setgActivityArea(bundle.getString("area"));
                    this.e.a().setgActivityContent(bundle.getString(PushConstants.EXTRA_CONTENT));
                    this.e.a().setgActivityTime(bundle.getLong("time", 0L));
                }
            } else if (getIntent() != null) {
                this.e.a().setGroupId(getIntent().getIntExtra(PushConstants.EXTRA_GID, 0));
                this.g = getIntent().getBooleanExtra("isedit", false);
                if (this.g) {
                    this.e.a().setActivityId(getIntent().getIntExtra("aid", 0));
                    this.e.a().setgActivityTitle(getIntent().getStringExtra(SocialConstants.PARAM_MEDIA_UNAME));
                    this.e.a().setgActivityArea(getIntent().getStringExtra("area"));
                    this.e.a().setgActivityContent(getIntent().getStringExtra(PushConstants.EXTRA_CONTENT));
                    this.e.a().setgActivityTime(getIntent().getLongExtra("time", 0L));
                }
            }
        }
        this.d.a(this.e.a(), this.g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        e();
        if (this.e == null) {
            this.e = new d();
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null && this.e.a() != null) {
            this.e.a().setGroupId(intent.getIntExtra(PushConstants.EXTRA_GID, 0));
            this.g = getIntent().getBooleanExtra("isedit", false);
            if (this.g) {
                this.e.a().setActivityId(intent.getIntExtra("aid", 0));
                this.e.a().setgActivityTitle(getIntent().getStringExtra(SocialConstants.PARAM_MEDIA_UNAME));
                this.e.a().setgActivityArea(getIntent().getStringExtra("area"));
                this.e.a().setgActivityContent(getIntent().getStringExtra(PushConstants.EXTRA_CONTENT));
                this.e.a().setgActivityTime(getIntent().getLongExtra("time", 0L));
            }
        }
        if (this.d == null) {
            this.d = new e(this);
        }
        this.d.a(this.e.a(), this.g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        int i = 0;
        if (this.e.a() != null) {
            i = this.e.a().getGroupId();
        }
        bundle.putInt(PushConstants.EXTRA_GID, i);
        bundle.putString(SocialConstants.PARAM_MEDIA_UNAME, this.d.f());
        bundle.putString(PushConstants.EXTRA_CONTENT, this.d.h());
        bundle.putString("area", this.d.g());
        bundle.putLong("time", this.d.i());
    }

    @Override // com.baidu.tieba.k
    protected void b(int i) {
        if (this.d != null) {
            this.d.a(i);
        }
    }

    private void e() {
        if (this.f == null) {
            this.f = new c(this, null);
            com.baidu.tieba.im.messageCenter.e.a().a(103120, this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.k, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.e.b();
        com.baidu.tieba.im.messageCenter.e.a().a(this.f);
        this.d.c();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.d.a()) {
            f();
        } else if (view == this.d.e() && this.e != null && this.e.a() != null) {
            long i = this.d.i();
            if ((!this.g || this.d.j()) && 1000 * i < System.currentTimeMillis()) {
                c(R.string.group_activity_time_val);
                return;
            }
            this.e.a().setgActivityArea(this.d.g());
            this.e.a().setgActivityContent(this.d.h());
            this.e.a().setgActivityTime(i);
            this.e.a().setgActivityTitle(this.d.f());
            c();
            this.e.a(this.g);
        }
    }

    @Override // com.baidu.tieba.k, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (TextUtils.isEmpty(this.d.f())) {
                finish();
                return true;
            }
            f();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void f() {
        com.baidu.tieba.im.util.b.a(this, this.g, new a(this), new b(this));
    }
}
