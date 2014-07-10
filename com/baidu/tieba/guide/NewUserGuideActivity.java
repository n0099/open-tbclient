package com.baidu.tieba.guide;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.editortool.aa;
import com.baidu.tieba.model.an;
import com.baidu.tieba.model.ap;
import com.baidu.tieba.view.RightSlideViewPager;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class NewUserGuideActivity extends BaseFragmentActivity {
    private an c;
    private aa d;
    private boolean f;
    private RightSlideViewPager h;
    private boolean e = false;
    private boolean g = false;
    private ap i = new c(this);

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2012116, new b());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void a(boolean z) {
        this.g = z;
    }

    public boolean g() {
        return this.g;
    }

    public static void a(Context context, boolean z, boolean z2) {
        Intent intent = new Intent(context, NewUserGuideActivity.class);
        intent.putExtra("is_new_user", z);
        intent.putExtra("has_like_bar", z2);
        context.startActivity(intent);
    }

    public RightSlideViewPager h() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        n();
        setContentView(com.baidu.tieba.w.guide_activity_interestfrs);
        m();
        l();
    }

    public void b(boolean z) {
        this.e = z;
    }

    private void l() {
        this.f = getIntent().getBooleanExtra("is_new_user", false);
        this.e = getIntent().getBooleanExtra("has_like_bar", false);
        int i = this.f ? 1 : 2;
        this.c = new an();
        this.c.a(i, 0, 100, this.i);
    }

    public aa i() {
        if (this.d == null) {
            this.d = new aa(this);
        }
        return this.d;
    }

    private void m() {
        this.h = (RightSlideViewPager) findViewById(com.baidu.tieba.v.guide_viewPager);
        this.h.setAdapter(new r(getSupportFragmentManager()));
        this.h.setTag("canScroll");
        this.h.setOnPageChangeListener(new d(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.c != null) {
            this.c.c();
        }
        if (this.d != null) {
            this.d.d();
        }
    }

    public an j() {
        return this.c;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void b(int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            k();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void n() {
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
    }

    public void k() {
        a(new CustomMessage(2015001, new com.baidu.tbadk.core.atomData.ap(this).a(1, this.f)));
        finish();
    }
}
