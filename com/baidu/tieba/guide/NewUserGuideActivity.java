package com.baidu.tieba.guide;

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
import com.baidu.tieba.view.RightSlideViewPager;
import com.baidu.tieba.x;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class NewUserGuideActivity extends BaseFragmentActivity {
    private com.baidu.tieba.model.o aMT;
    private boolean aMV;
    private RightSlideViewPager aMX;
    private boolean aMU = false;
    private boolean aMW = false;
    private com.baidu.tieba.model.q aMY = new c(this);

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2012116, new b());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void ce(boolean z) {
        this.aMW = z;
    }

    public boolean IO() {
        return this.aMW;
    }

    public RightSlideViewPager IP() {
        return this.aMX;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        IR();
        setContentView(x.guide_activity_interestfrs);
        initUI();
        initData();
    }

    public void cf(boolean z) {
        this.aMU = z;
    }

    private void initData() {
        this.aMV = getIntent().getBooleanExtra("is_new_user", false);
        this.aMU = getIntent().getBooleanExtra(NewUserGuideActivityConfig.HAS_LIEK_BAR, false);
        int i = this.aMV ? 1 : 2;
        this.aMT = new com.baidu.tieba.model.o(this);
        this.aMT.a(i, 0, 100, this.aMY);
    }

    private void initUI() {
        this.aMX = (RightSlideViewPager) findViewById(com.baidu.tieba.w.guide_viewPager);
        this.aMX.setAdapter(new q(getSupportFragmentManager()));
        this.aMX.setTag("canScroll");
        this.aMX.setOnPageChangeListener(new d(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.aMT != null) {
            this.aMT.Uq();
        }
    }

    public com.baidu.tieba.model.o IQ() {
        return this.aMT;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            IS();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void IR() {
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

    public void IS() {
        sendMessage(new CustomMessage(2015001, new MainTabActivityConfig(getPageContext().getPageActivity()).createNewUserCfg(1, this.aMV)));
        finish();
    }
}
