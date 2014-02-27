package com.baidu.tieba.guide;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.model.bh;
import com.baidu.tieba.model.bj;
import com.baidu.tieba.view.RightSlideViewPager;
import com.slidingmenu.lib.R;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class NewUserGuideActivity extends com.baidu.tieba.k {
    private bh d;
    private com.baidu.tieba.util.i e;
    private boolean g;
    private RightSlideViewPager i;
    private boolean f = false;
    private boolean h = false;
    private bj j = new b(this);

    public final void a(boolean z) {
        this.h = true;
    }

    public final boolean e() {
        return this.h;
    }

    public static void a(Context context, boolean z, boolean z2) {
        Intent intent = new Intent(context, NewUserGuideActivity.class);
        intent.putExtra("is_new_user", z);
        intent.putExtra("has_like_bar", z2);
        context.startActivity(intent);
    }

    public final RightSlideViewPager f() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.k, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 11) {
            try {
                Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("FLAG_HARDWARE_ACCELERATED");
                declaredField.setAccessible(true);
                int i = declaredField.getInt(null);
                Window.class.getMethod("setFlags", Integer.TYPE, Integer.TYPE).invoke(getWindow(), Integer.valueOf(i), Integer.valueOf(i));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        setContentView(R.layout.guide_activity_interestfrs);
        this.i = (RightSlideViewPager) findViewById(R.id.guide_viewPager);
        this.i.setAdapter(new t(getSupportFragmentManager()));
        this.i.setTag("canScroll");
        this.i.setOnPageChangeListener(new c(this));
        this.g = getIntent().getBooleanExtra("is_new_user", false);
        this.f = getIntent().getBooleanExtra("has_like_bar", false);
        int i2 = this.g ? 1 : 2;
        this.d = new bh();
        this.d.a(i2, 0, 100, this.j);
    }

    public final void b(boolean z) {
        this.f = true;
    }

    public final com.baidu.tieba.util.i g() {
        if (this.e == null) {
            this.e = new com.baidu.tieba.util.i(this);
        }
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.k, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.k, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.d != null) {
            this.d.c();
        }
        if (this.e != null) {
            this.e.c();
        }
    }

    public final bh h() {
        return this.d;
    }

    @Override // com.baidu.tieba.k
    protected final void b(int i) {
    }

    public final void i() {
        MainTabActivity.a(this, 1, this.g);
        finish();
    }
}
