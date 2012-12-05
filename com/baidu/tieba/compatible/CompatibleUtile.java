package com.baidu.tieba.compatible;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
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

    public static CompatibleUtile getInstance() {
        if (mCompatibleUtile == null) {
            mCompatibleUtile = new CompatibleUtile();
        }
        return mCompatibleUtile;
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

    public int getMemoryClass(Context context) {
        if (getObject5() != null) {
            return getObject5().getMemoryClass(context);
        }
        return 16;
    }

    public boolean isAutoBrightness(Context context) {
        if (getObject8() != null) {
            return getObject8().isAutoBrightness(context);
        }
        return false;
    }

    public int getBitmapMaxMemory(Context context) {
        int max = getMemoryClass(context);
        if (max <= 0) {
            max = 16;
        }
        return ((max * AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END) * AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END) / 2;
    }

    public static int getActionMask() {
        return MotionEventCompat.ACTION_MASK;
    }

    public int getActionPointerUp() {
        if (getObject5() != null) {
            return getObject5().getActionPointerUp();
        }
        return 6;
    }

    public int getActionPointerDown() {
        if (getObject5() != null) {
            return getObject5().getActionPointerDown();
        }
        return 5;
    }

    public float getSpacing(MotionEvent event) {
        if (getObject5() != null) {
            return getObject5().getSpacing(event);
        }
        return -1.0f;
    }

    public void WebViewNoDataBase(WebSettings settings) {
        if (getObject5() != null) {
            getObject5().WebViewNoDataBase(settings);
        }
    }

    public boolean supportMultiTouch(Context context) {
        if (getObject7() != null) {
            return getObject7().supportMultiTouch(context);
        }
        return false;
    }

    public void openGpu(Activity context) {
        if (getObject11() != null) {
            getObject11().openGpu(context);
        }
    }

    public WebChromeClient getWebChromeClient(Activity activity) {
        return getObject14() != null ? getObject14().getWebChromeClient(activity) : new WebChromeClient();
    }

    /* loaded from: classes.dex */
    public static class FullscreenableChromeClient extends WebChromeClient {
        private final FrameLayout.LayoutParams COVER_SCREEN_PARAMS = new FrameLayout.LayoutParams(-1, -1);
        protected Activity mActivity;
        private FrameLayout mContentView;
        private View mCustomView;
        private WebChromeClient.CustomViewCallback mCustomViewCallback;
        private FrameLayout mFullscreenContainer;
        private int mOriginalOrientation;

        public FullscreenableChromeClient(Activity activity) {
            this.mActivity = null;
            this.mActivity = activity;
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view, int requestedOrientation, WebChromeClient.CustomViewCallback callback) {
            if (this.mCustomView != null) {
                callback.onCustomViewHidden();
                return;
            }
            this.mOriginalOrientation = this.mActivity.getRequestedOrientation();
            FrameLayout decor = (FrameLayout) this.mActivity.getWindow().getDecorView();
            this.mFullscreenContainer = new FullscreenHolder(this.mActivity);
            this.mFullscreenContainer.addView(view, this.COVER_SCREEN_PARAMS);
            decor.addView(this.mFullscreenContainer, this.COVER_SCREEN_PARAMS);
            this.mCustomView = view;
            setFullscreen(true);
            this.mCustomViewCallback = callback;
            this.mActivity.setRequestedOrientation(requestedOrientation);
            super.onShowCustomView(view, requestedOrientation, callback);
        }

        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
            if (this.mCustomView != null) {
                setFullscreen(false);
                FrameLayout decor = (FrameLayout) this.mActivity.getWindow().getDecorView();
                decor.removeView(this.mFullscreenContainer);
                this.mFullscreenContainer = null;
                this.mCustomView = null;
                this.mCustomViewCallback.onCustomViewHidden();
                this.mActivity.setRequestedOrientation(this.mOriginalOrientation);
            }
        }

        private void setFullscreen(boolean enabled) {
            Window win = this.mActivity.getWindow();
            WindowManager.LayoutParams winParams = win.getAttributes();
            if (enabled) {
                winParams.flags |= AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END;
            } else {
                winParams.flags &= -1025;
                if (this.mCustomView != null) {
                    this.mCustomView.setSystemUiVisibility(0);
                } else {
                    this.mContentView.setSystemUiVisibility(0);
                }
            }
            win.setAttributes(winParams);
        }

        /* loaded from: classes.dex */
        private class FullscreenHolder extends FrameLayout {
            public FullscreenHolder(Context ctx) {
                super(ctx);
                setBackgroundColor(ctx.getResources().getColor(17170444));
            }

            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent evt) {
                return true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class Object5 {
        private Object5() {
        }

        /* synthetic */ Object5(CompatibleUtile compatibleUtile, Object5 object5) {
            this();
        }

        public int getActionPointerUp() {
            return 6;
        }

        public int getActionPointerDown() {
            return 5;
        }

        public float getSpacing(MotionEvent event) {
            int pointer = event.getPointerCount();
            if (pointer < 2) {
                return -1.0f;
            }
            float x = event.getX(0) - event.getX(1);
            float y = event.getY(0) - event.getY(1);
            return (float) Math.sqrt((x * x) + (y * y));
        }

        public int getMemoryClass(Context context) {
            ActivityManager am = (ActivityManager) context.getSystemService("activity");
            return am.getMemoryClass();
        }

        public void WebViewNoDataBase(WebSettings settings) {
            if (settings != null) {
                settings.setDatabaseEnabled(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class Object11 {
        private Object11() {
        }

        /* synthetic */ Object11(CompatibleUtile compatibleUtile, Object11 object11) {
            this();
        }

        public void openGpu(Activity context) {
            context.getWindow().setFlags(16777216, 16777216);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
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
}
