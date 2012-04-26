package com.baidu.tieba;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.service.FatalErrorService;
import com.baidu.tieba.util.BitmapHelper;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.TiebaLog;
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
        getWindow().setFlags(1024, 1024);
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
                TiebaApplication app;
                super.run();
                try {
                    app = (TiebaApplication) LogoActivity.this.getApplication();
                } catch (Exception e) {
                }
                if (app != null) {
                    app.readDisplayPhoto();
                    app.setAPPUseTimes(app.getAPPUseTimes() + 1);
                    if (app.isInvalidTDatabase()) {
                        DatabaseService.deletSdDatebase();
                        app.setAPPUseTimes(0);
                    }
                    new DatabaseService();
                    new DatabaseService(DatabaseService.DatabaseLocation.SDCARD);
                    DatabaseService.delOverdueDraft();
                    DatabaseService.delOverdueChunkUploadData();
                    if (TiebaApplication.getCurrentAccount() != null && TiebaApplication.getCurrentAccountName() == null) {
                        TiebaApplication.setCurrentAccount(DatabaseService.getActiveAccountData());
                        DatabaseService.getSettingData();
                    }
                    LogoActivity.this.mHandler.handleMessage(LogoActivity.this.mHandler.obtainMessage());
                }
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
        String account = TiebaApplication.getCurrentAccountName();
        if (TiebaApplication.isBaiduAccountManager()) {
            BaiduAccountProxy.getAccountData(this);
            return;
        }
        if (account == null) {
            LoginActivity.startActivity(this);
        } else {
            MainTabActivity.startActivity(this, (String) null);
        }
        finish();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.mHaveFinishiAnim && this.mHaveInitData && TiebaApplication.isBaiduAccountManager() && TiebaApplication.getCurrentBduss() == null) {
            BaiduAccountProxy.getAccountData(this);
        }
    }
}
