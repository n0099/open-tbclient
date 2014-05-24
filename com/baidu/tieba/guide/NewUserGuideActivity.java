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
import com.baidu.tbadk.core.atomData.al;
import com.baidu.tbadk.core.frameworkData.CmdConfig;
import com.baidu.tbadk.editortool.ab;
import com.baidu.tieba.model.ao;
import com.baidu.tieba.model.aq;
import com.baidu.tieba.view.RightSlideViewPager;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class NewUserGuideActivity extends BaseFragmentActivity {
    private ao c;
    private ab d;
    private boolean f;
    private RightSlideViewPager h;
    private boolean e = false;
    private boolean g = false;
    private aq i = new c(this);

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfig.NEW_USER_GUIDE_PAGE, new b());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void a(boolean z) {
        this.g = z;
    }

    public boolean e() {
        return this.g;
    }

    public static void a(Context context, boolean z, boolean z2) {
        Intent intent = new Intent(context, NewUserGuideActivity.class);
        intent.putExtra("is_new_user", z);
        intent.putExtra("has_like_bar", z2);
        context.startActivity(intent);
    }

    public RightSlideViewPager f() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        l();
        setContentView(com.baidu.tieba.w.guide_activity_interestfrs);
        k();
        j();
    }

    public void b(boolean z) {
        this.e = z;
    }

    private void j() {
        this.f = getIntent().getBooleanExtra("is_new_user", false);
        this.e = getIntent().getBooleanExtra("has_like_bar", false);
        int i = this.f ? 1 : 2;
        this.c = new ao();
        this.c.a(i, 0, 100, this.i);
    }

    public ab g() {
        if (this.d == null) {
            this.d = new ab(this);
        }
        return this.d;
    }

    private void k() {
        this.h = (RightSlideViewPager) findViewById(com.baidu.tieba.v.guide_viewPager);
        this.h.setAdapter(new u(getSupportFragmentManager()));
        this.h.setTag("canScroll");
        this.h.setOnPageChangeListener(new d(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
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

    public ao h() {
        return this.c;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void b(int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            i();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void l() {
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

    public void i() {
        a(new CustomMessage(2017001, new al(this).a(1, this.f)));
        finish();
    }
}
