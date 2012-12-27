package com.baidu.tieba.compatible;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class CompatibleUtile {
    private static CompatibleUtile mCompatibleUtile = null;
    private static Object5 mObject5 = null;
    private static Object7 mObject7 = null;
    private static Object8 mObject8 = null;
    private static Object11 mObject11 = null;
    private static Object14 mObject14 = null;

    /* loaded from: classes.dex */
    public class FullscreenableChromeClient extends WebChromeClient {
        private final FrameLayout.LayoutParams COVER_SCREEN_PARAMS = new FrameLayout.LayoutParams(-1, -1);
        protected Activity mActivity;
        private FrameLayout mContentView;
        private View mCustomView;
        private WebChromeClient.CustomViewCallback mCustomViewCallback;
        private FrameLayout mFullscreenContainer;
        private int mOriginalOrientation;

        /* loaded from: classes.dex */
        class FullscreenHolder extends FrameLayout {
            public FullscreenHolder(Context context) {
                super(context);
                setBackgroundColor(context.getResources().getColor(17170444));
            }

            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent motionEvent) {
                return true;
            }
        }

        public FullscreenableChromeClient(Activity activity) {
            this.mActivity = null;
            this.mActivity = activity;
        }

        private void setFullscreen(boolean z) {
            Window window = this.mActivity.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (z) {
                attributes.flags |= 1024;
            } else {
                attributes.flags &= -1025;
                if (this.mCustomView != null) {
                    this.mCustomView.setSystemUiVisibility(0);
                } else {
                    this.mContentView.setSystemUiVisibility(0);
                }
            }
            window.setAttributes(attributes);
        }

        public void hideCustomView() {
            onHideCustomView();
        }

        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
            if (this.mCustomView == null) {
                return;
            }
            setFullscreen(false);
            ((FrameLayout) this.mActivity.getWindow().getDecorView()).removeView(this.mFullscreenContainer);
            this.mFullscreenContainer = null;
            this.mCustomView = null;
            this.mCustomViewCallback.onCustomViewHidden();
            this.mActivity.setRequestedOrientation(this.mOriginalOrientation);
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
            if (this.mCustomView != null) {
                customViewCallback.onCustomViewHidden();
                return;
            }
            this.mOriginalOrientation = this.mActivity.getRequestedOrientation();
            this.mFullscreenContainer = new FullscreenHolder(this.mActivity);
            this.mFullscreenContainer.addView(view, this.COVER_SCREEN_PARAMS);
            ((FrameLayout) this.mActivity.getWindow().getDecorView()).addView(this.mFullscreenContainer, this.COVER_SCREEN_PARAMS);
            this.mCustomView = view;
            setFullscreen(true);
            this.mCustomViewCallback = customViewCallback;
            this.mActivity.setRequestedOrientation(i);
            super.onShowCustomView(view, i, customViewCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class Object11 {
        private Object11() {
        }

        /* synthetic */ Object11(CompatibleUtile compatibleUtile, Object11 object11) {
            this();
        }

        public void openGpu(Activity activity) {
            activity.getWindow().setFlags(16777216, 16777216);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class Object14 {
        private Object14() {
        }

        /* synthetic */ Object14(CompatibleUtile compatibleUtile, Object14 object14) {
            this();
        }

        public WebChromeClient getWebChromeClient(Activity activity) {
            return new FullscreenableChromeClient(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class Object5 {
        private Object5() {
        }

        /* synthetic */ Object5(CompatibleUtile compatibleUtile, Object5 object5) {
            this();
        }

        public void WebViewNoDataBase(WebSettings webSettings) {
            if (webSettings != null) {
                webSettings.setDatabaseEnabled(false);
            }
        }

        public int getActionPointerDown() {
            return 5;
        }

        public int getActionPointerUp() {
            return 6;
        }

        public int getMemoryClass(Context context) {
            return ((ActivityManager) context.getSystemService("activity")).getMemoryClass();
        }

        public float getSpacing(MotionEvent motionEvent) {
            if (motionEvent.getPointerCount() < 2) {
                return -1.0f;
            }
            float x = motionEvent.getX(0) - motionEvent.getX(1);
            float y = motionEvent.getY(0) - motionEvent.getY(1);
            return (float) Math.sqrt((x * x) + (y * y));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class Object7 {
        private Object7() {
        }

        /* synthetic */ Object7(CompatibleUtile compatibleUtile, Object7 object7) {
            this();
        }

        public boolean supportMultiTouch(Context context) {
            if (context == null) {
                return false;
            }
            return context.getPackageManager().hasSystemFeature("android.hardware.touchscreen.multitouch");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class Object8 {
        private Object8() {
        }

        /* synthetic */ Object8(CompatibleUtile compatibleUtile, Object8 object8) {
            this();
        }

        public boolean isAutoBrightness(Context context) {
            try {
                return Settings.System.getInt(context.getContentResolver(), "screen_brightness_mode") == 1;
            } catch (Settings.SettingNotFoundException e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    public static int getActionMask() {
        return 255;
    }

    public static CompatibleUtile getInstance() {
        if (mCompatibleUtile == null) {
            mCompatibleUtile = new CompatibleUtile();
        }
        return mCompatibleUtile;
    }

    private Object11 getObject11() {
        if (Build.VERSION.SDK_INT >= 11 && mObject11 == null) {
            mObject11 = new Object11(this, null);
        }
        return mObject11;
    }

    private Object14 getObject14() {
        if (Build.VERSION.SDK_INT >= 14 && mObject14 == null) {
            mObject14 = new Object14(this, null);
        }
        return mObject14;
    }

    private Object5 getObject5() {
        if (Build.VERSION.SDK_INT >= 5 && mObject5 == null) {
            mObject5 = new Object5(this, null);
        }
        return mObject5;
    }

    private Object7 getObject7() {
        if (Build.VERSION.SDK_INT >= 7 && mObject7 == null) {
            mObject7 = new Object7(this, null);
        }
        return mObject7;
    }

    private Object8 getObject8() {
        if (Build.VERSION.SDK_INT >= 8 && mObject8 == null) {
            mObject8 = new Object8(this, null);
        }
        return mObject8;
    }

    public void WebViewNoDataBase(WebSettings webSettings) {
        if (getObject5() != null) {
            getObject5().WebViewNoDataBase(webSettings);
        }
    }

    public int getActionPointerDown() {
        if (getObject5() != null) {
            return getObject5().getActionPointerDown();
        }
        return 5;
    }

    public int getActionPointerUp() {
        if (getObject5() != null) {
            return getObject5().getActionPointerUp();
        }
        return 6;
    }

    public int getBitmapMaxMemory(Context context) {
        int memoryClass = getMemoryClass(context);
        if (memoryClass <= 0) {
            memoryClass = 16;
        }
        return ((memoryClass * 1024) * 1024) / 2;
    }

    public int getMemoryClass(Context context) {
        if (getObject5() != null) {
            return getObject5().getMemoryClass(context);
        }
        return 16;
    }

    public float getSpacing(MotionEvent motionEvent) {
        if (getObject5() != null) {
            return getObject5().getSpacing(motionEvent);
        }
        return -1.0f;
    }

    public WebChromeClient getWebChromeClient(Activity activity) {
        return getObject14() != null ? getObject14().getWebChromeClient(activity) : new WebChromeClient();
    }

    public boolean isAutoBrightness(Context context) {
        if (getObject8() != null) {
            return getObject8().isAutoBrightness(context);
        }
        return false;
    }

    public void openGpu(Activity activity) {
        if (getObject11() != null) {
            getObject11().openGpu(activity);
        }
    }

    public boolean supportMultiTouch(Context context) {
        if (getObject7() != null) {
            return getObject7().supportMultiTouch(context);
        }
        return false;
    }
}
