package com.baidu.tieba;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.view.KeyEvent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.baidu.tieba.account.AccountShareHelper;
import com.baidu.tieba.service.FatalErrorService;
import com.baidu.tieba.util.BitmapHelper;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.TiebaLog;
import java.io.File;
/* loaded from: classes.dex */
public class LogoActivity extends BaseActivity {
    private boolean mHaveFinishiAnim = false;
    private boolean mHaveInitData = false;
    private ImageView mImage = null;
    private Bitmap mBitmap = null;
    private AlphaAnimation mAnim = null;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.LogoActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            LogoActivity.this.mHaveInitData = true;
            if (LogoActivity.this.mHaveFinishiAnim) {
                LogoActivity.this.startApp();
            }
            super.handleMessage(msg);
        }
    };

    /* JADX WARN: Type inference failed for: r0v14, types: [com.baidu.tieba.LogoActivity$3] */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TiebaLog.i(getClass().getName(), "onCreate", null);
        getWindow().setFlags(AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END, AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END);
        setContentView(R.layout.logo_activity);
        this.mImage = (ImageView) findViewById(R.id.logo);
        this.mBitmap = BitmapHelper.getResBitmap(this, R.drawable.logo);
        this.mImage.setImageBitmap(this.mBitmap);
        this.mAnim = new AlphaAnimation(0.5f, 1.0f);
        this.mAnim.setDuration(2000L);
        this.mAnim.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.LogoActivity.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation arg0) {
                LogoActivity.this.mHaveFinishiAnim = true;
                if (!LogoActivity.this.mHaveInitData) {
                    return;
                }
                LogoActivity.this.startApp();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation arg0) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation arg0) {
            }
        });
        this.mImage.startAnimation(this.mAnim);
        new Thread() { // from class: com.baidu.tieba.LogoActivity.3
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                super.run();
                try {
                    TiebaApplication app = (TiebaApplication) LogoActivity.this.getApplication();
                    app.setAPPUseTimes(app.getAPPUseTimes() + 1);
                    if (app.isInvalidTDatabase()) {
                        DatabaseService.deletSdDatebase();
                        app.setAPPUseTimes(0);
                    }
                    DatabaseService.delOverdueDraft();
                    DatabaseService.delOverdueChunkUploadData();
                    LogoActivity.this.deleteAllfile(LogoActivity.this.getCacheDir());
                } catch (Exception e) {
                }
                LogoActivity.this.mHandler.handleMessage(LogoActivity.this.mHandler.obtainMessage());
            }
        }.start();
        startErrorUploadService();
    }

    private void startErrorUploadService() {
        Intent service = new Intent(this, FatalErrorService.class);
        startService(service);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteAllfile(File file) {
        if (file != null) {
            try {
                if (file.isDirectory()) {
                    File[] list = file.listFiles();
                    if (list != null) {
                        for (int i = 0; i < list.length; i++) {
                            if (list[i].isDirectory()) {
                                deleteAllfile(list[i]);
                            } else {
                                list[i].delete();
                            }
                        }
                        return;
                    }
                    return;
                }
                file.delete();
            } catch (Exception ex) {
                TiebaLog.e(getClass().getName(), "deleteAllfile", ex.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mImage.setImageBitmap(null);
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startApp() {
        AccountShareHelper.getInstance().prepare();
        TiebaApplication.app.startLocationServer();
        if (TiebaApplication.app.getIsFirstUse()) {
            TiebaApplication.app.setUsed();
            GuideActivity.startActivity(this);
            finish();
            return;
        }
        String id = TiebaApplication.getCurrentAccount();
        MainTabActivity.startActivity(this, MainTabActivity.GOTO_RECOMMEND);
        if ((id == null || id.length() <= 0) && TiebaApplication.isBaiduAccountManager() && BaiduAccountProxy.hasValidBaiduAccount(this)) {
            BaiduAccountProxy.getAccountData(this, 0, MainTabActivity.GOTO_RECOMMEND, false);
        }
        finish();
    }
}
