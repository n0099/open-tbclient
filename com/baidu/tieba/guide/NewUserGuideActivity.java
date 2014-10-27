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
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.NewUserGuideActivityConfig;
import com.baidu.tieba.model.ao;
import com.baidu.tieba.model.aq;
import com.baidu.tieba.view.RightSlideViewPager;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class NewUserGuideActivity extends BaseFragmentActivity {
    private ao aKL;
    private boolean aKN;
    private RightSlideViewPager aKP;
    private boolean aKM = false;
    private boolean aKO = false;
    private aq aKQ = new c(this);

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2012116, new b());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void cq(boolean z) {
        this.aKO = z;
    }

    public boolean It() {
        return this.aKO;
    }

    public static void a(Context context, boolean z, boolean z2) {
        Intent intent = new Intent(context, NewUserGuideActivity.class);
        intent.putExtra("is_new_user", z);
        intent.putExtra(NewUserGuideActivityConfig.HAS_LIEK_BAR, z2);
        context.startActivity(intent);
    }

    public RightSlideViewPager Iu() {
        return this.aKP;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Iw();
        setContentView(com.baidu.tieba.w.guide_activity_interestfrs);
        initUI();
        initData();
    }

    public void cr(boolean z) {
        this.aKM = z;
    }

    private void initData() {
        this.aKN = getIntent().getBooleanExtra("is_new_user", false);
        this.aKM = getIntent().getBooleanExtra(NewUserGuideActivityConfig.HAS_LIEK_BAR, false);
        int i = this.aKN ? 1 : 2;
        this.aKL = new ao(this);
        this.aKL.a(i, 0, 100, this.aKQ);
    }

    private void initUI() {
        this.aKP = (RightSlideViewPager) findViewById(com.baidu.tieba.v.guide_viewPager);
        this.aKP.setAdapter(new q(getSupportFragmentManager()));
        this.aKP.setTag("canScroll");
        this.aKP.setOnPageChangeListener(new d(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.aKL != null) {
            this.aKL.TQ();
        }
    }

    public ao Iv() {
        return this.aKL;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            Ix();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void Iw() {
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

    public void Ix() {
        sendMessage(new CustomMessage(2015001, new MainTabActivityConfig(this).createNewUserCfg(1, this.aKN)));
        finish();
    }
}
