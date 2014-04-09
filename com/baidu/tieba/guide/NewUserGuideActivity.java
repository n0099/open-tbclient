package com.baidu.tieba.guide;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.tbadk.core.b.aa;
import com.baidu.tbadk.editortool.ab;
import com.baidu.tieba.model.ao;
import com.baidu.tieba.model.aq;
import com.baidu.tieba.view.RightSlideViewPager;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class NewUserGuideActivity extends com.baidu.tbadk.core.e {
    private ao c;
    private ab d;
    private boolean f;
    private RightSlideViewPager h;
    private boolean e = false;
    private boolean g = false;
    private aq i = new b(this);

    public final void a(boolean z) {
        this.g = true;
    }

    public final boolean f() {
        return this.g;
    }

    public static void a(Context context, boolean z, boolean z2) {
        Intent intent = new Intent(context, NewUserGuideActivity.class);
        intent.putExtra("is_new_user", z);
        intent.putExtra("has_like_bar", z2);
        context.startActivity(intent);
    }

    public final RightSlideViewPager g() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.e, com.baidu.adp.a.c, android.support.v4.app.FragmentActivity, android.app.Activity
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
        setContentView(com.baidu.tieba.a.i.guide_activity_interestfrs);
        this.h = (RightSlideViewPager) findViewById(com.baidu.tieba.a.h.guide_viewPager);
        this.h.setAdapter(new t(getSupportFragmentManager()));
        this.h.setTag("canScroll");
        this.h.setOnPageChangeListener(new c(this));
        this.f = getIntent().getBooleanExtra("is_new_user", false);
        this.e = getIntent().getBooleanExtra("has_like_bar", false);
        int i2 = this.f ? 1 : 2;
        this.c = new ao();
        this.c.a(i2, 0, 100, this.i);
    }

    public final void b(boolean z) {
        this.e = true;
    }

    public final ab h() {
        if (this.d == null) {
            this.d = new ab(this);
        }
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.e, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.e, com.baidu.adp.a.c, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.c != null) {
            this.c.c();
        }
        if (this.d != null) {
            this.d.c();
        }
    }

    public final ao i() {
        return this.c;
    }

    @Override // com.baidu.tbadk.core.e
    protected final void b(int i) {
    }

    public final void j() {
        a(new com.baidu.adp.framework.message.a(2015001, new aa(this).a(1, this.f)));
        finish();
    }
}
