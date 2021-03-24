package com.baidu.tieba.compatible;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.hardware.Camera;
import android.net.TrafficStats;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbDomainConfig;
import java.lang.reflect.Method;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class CompatibleUtile {
    public static CompatibleUtile mCompatibleUtile;
    public static Object11 mObject11;
    public static Object14 mObject14;
    public static Object5 mObject5;
    public static Object7 mObject7;
    public static Object8 mObject8;
    public static Object9 mObject9;

    /* loaded from: classes4.dex */
    public static class FullscreenableChromeClient extends WebChromeClient {
        public final FrameLayout.LayoutParams COVER_SCREEN_PARAMS = new FrameLayout.LayoutParams(-1, -1);
        public Activity mActivity;
        public FrameLayout mContentView;
        public View mCustomView;
        public WebChromeClient.CustomViewCallback mCustomViewCallback;
        public FrameLayout mFullscreenContainer;
        public int mOriginalOrientation;

        /* loaded from: classes4.dex */
        public class FullscreenHolder extends FrameLayout {
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
                View view = this.mCustomView;
                if (view != null) {
                    view.setSystemUiVisibility(0);
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
            FullscreenHolder fullscreenHolder = new FullscreenHolder(this.mActivity);
            this.mFullscreenContainer = fullscreenHolder;
            fullscreenHolder.addView(view, this.COVER_SCREEN_PARAMS);
            ((FrameLayout) this.mActivity.getWindow().getDecorView()).addView(this.mFullscreenContainer, this.COVER_SCREEN_PARAMS);
            this.mCustomView = view;
            setFullscreen(true);
            this.mCustomViewCallback = customViewCallback;
            this.mActivity.setRequestedOrientation(i);
            super.onShowCustomView(view, i, customViewCallback);
        }
    }

    /* loaded from: classes4.dex */
    public class Object14 {
        public Object14() {
        }

        public WebChromeClient getWebChromeClient(Activity activity) {
            return new FullscreenableChromeClient(activity);
        }

        public /* synthetic */ Object14(CompatibleUtile compatibleUtile, Object14 object14) {
            this();
        }
    }

    /* loaded from: classes4.dex */
    public class Object5 {
        public Object5() {
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

        public /* synthetic */ Object5(CompatibleUtile compatibleUtile, Object5 object5) {
            this();
        }
    }

    /* loaded from: classes4.dex */
    public class Object7 {
        public Object7() {
        }

        public boolean supportMultiTouch(Context context) {
            if (context == null) {
                return false;
            }
            return context.getPackageManager().hasSystemFeature("android.hardware.touchscreen.multitouch");
        }

        public /* synthetic */ Object7(CompatibleUtile compatibleUtile, Object7 object7) {
            this();
        }
    }

    /* loaded from: classes4.dex */
    public class Object8 {
        public Object8() {
        }

        public long getUidRxBytes(int i) {
            return TrafficStats.getUidRxBytes(i);
        }

        public long getUidTxBytes(int i) {
            return TrafficStats.getUidTxBytes(i);
        }

        public boolean isAutoBrightness(Context context) {
            try {
                return Settings.System.getInt(context.getContentResolver(), "screen_brightness_mode") == 1;
            } catch (Settings.SettingNotFoundException e2) {
                e2.printStackTrace();
                return false;
            }
        }

        public void loadUrl(WebView webView, String str) {
            if (webView == null || TextUtils.isEmpty(str)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(Config.LAUNCH_REFERER, TbDomainConfig.DOMAIN_HTTPS_SERVER_ADDRESS);
            webView.loadUrl(str, hashMap);
        }

        public void setCameraDisplayOrientation(Camera camera, int i) {
            if (camera == null) {
                return;
            }
            camera.setDisplayOrientation(i);
        }

        public /* synthetic */ Object8(CompatibleUtile compatibleUtile, Object8 object8) {
            this();
        }
    }

    /* loaded from: classes4.dex */
    public class Object9 {
        public Object9() {
        }

        public Camera getBackCamera() {
            int numberOfCameras = Camera.getNumberOfCameras();
            if (numberOfCameras == 0) {
                return null;
            }
            int i = 0;
            while (i < numberOfCameras) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i, cameraInfo);
                if (cameraInfo.facing == 0) {
                    break;
                }
                i++;
            }
            if (i < numberOfCameras) {
                return Camera.open(i);
            }
            return Camera.open(0);
        }

        public /* synthetic */ Object9(CompatibleUtile compatibleUtile, Object9 object9) {
            this();
        }
    }

    public static void dealWebView(WebSettings webSettings) {
        if (Build.VERSION.SDK_INT <= 11) {
            try {
                Class<?> cls = Class.forName("android.webkit.WebView");
                Method method = cls.getMethod("disablePlatformNotifications", new Class[0]);
                Method method2 = cls.getMethod("enablePlatformNotifications", new Class[0]);
                method.invoke(null, new Object[0]);
                method2.invoke(null, new Object[0]);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (webSettings == null || Build.VERSION.SDK_INT > 18) {
            return;
        }
        try {
            webSettings.getClass().getMethod("setPluginsEnabled", Boolean.class).invoke(webSettings, Boolean.TRUE);
        } catch (Exception e3) {
            e3.printStackTrace();
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

    private Object9 getObject9() {
        if (Build.VERSION.SDK_INT >= 9 && mObject9 == null) {
            mObject9 = new Object9(this, null);
        }
        return mObject9;
    }

    public static void scrollListViewBy(ListView listView, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 8) {
            listView.smoothScrollBy(i, i2);
        }
    }

    public static void scrollListViewTo(ListView listView, int i) {
        if (Build.VERSION.SDK_INT >= 8) {
            listView.smoothScrollToPosition(i);
        } else {
            listView.setSelection(i);
        }
    }

    public static void setAnim(Activity activity, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 5) {
            activity.overridePendingTransition(i, i2);
        }
    }

    public void WebViewNoDataBase(WebSettings webSettings) {
        if (getObject5() != null) {
            getObject5().WebViewNoDataBase(webSettings);
        }
    }

    public void closeViewGpu(View view) {
        if (getObject11() != null) {
            getObject11().closeViewGpu(view);
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

    public Camera getBackCamera() {
        if (getObject9() != null) {
            return getObject9().getBackCamera();
        }
        return Camera.open();
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

    public int getStatusBarColor(Context context) {
        try {
            if (getObject11() != null) {
                return getObject11().getStatusBarColor(context);
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    public long getUidRxBytes(int i) {
        if (getObject8() != null) {
            return getObject8().getUidRxBytes(i);
        }
        return 0L;
    }

    public long getUidTxBytes(int i) {
        if (getObject8() != null) {
            return getObject8().getUidTxBytes(i);
        }
        return 0L;
    }

    public int getViewLayer(View view) {
        if (getObject11() != null) {
            return getObject11().getViewLayer(view);
        }
        return 0;
    }

    public WebChromeClient getWebChromeClient(Activity activity) {
        if (getObject14() != null) {
            return getObject14().getWebChromeClient(activity);
        }
        return new WebChromeClient();
    }

    public boolean isAutoBrightness(Context context) {
        if (getObject8() != null) {
            return getObject8().isAutoBrightness(context);
        }
        return false;
    }

    public boolean isUseHw(View view) {
        if (getObject11() != null) {
            return getObject11().isUseHw(view);
        }
        return false;
    }

    public void loadUrl(WebView webView, String str) {
        if (getObject8() != null) {
            getObject8().loadUrl(webView, str);
        } else {
            webView.loadUrl(str);
        }
    }

    public void noneViewGpu(View view) {
        if (getObject11() != null) {
            getObject11().noneViewGpu(view);
        }
    }

    public void openGpu(Activity activity) {
        if (getObject11() != null) {
            getObject11().openGpu(activity);
        }
    }

    public void openViewGpu(View view) {
        if (getObject11() != null) {
            getObject11().openViewGpu(view);
        }
    }

    public void removeJavascriptInterface(WebView webView) {
        if (getObject11() != null) {
            getObject11().removeJavascriptInterface(webView);
        }
    }

    public void setCameraDisplayOrientation(Camera camera, int i) {
        if (getObject8() != null) {
            getObject8().setCameraDisplayOrientation(camera, i);
        }
    }

    public boolean supportMultiTouch(Context context) {
        if (getObject7() != null) {
            return getObject7().supportMultiTouch(context);
        }
        return false;
    }

    /* loaded from: classes4.dex */
    public class Object11 {
        public final int[] STATUSBAR_ATTRS;

        public Object11() {
            this.STATUSBAR_ATTRS = new int[]{16842904};
        }

        public void closeViewGpu(View view) {
            if (view == null || !view.isHardwareAccelerated()) {
                return;
            }
            view.setLayerType(1, null);
        }

        public int getStatusBarColor(Context context) {
            return context.obtainStyledAttributes(16973928, this.STATUSBAR_ATTRS).getColor(0, 0);
        }

        public int getViewLayer(View view) {
            if (view != null) {
                return view.getLayerType();
            }
            return 0;
        }

        public boolean isUseHw(View view) {
            return view != null && view.isHardwareAccelerated();
        }

        public void noneViewGpu(View view) {
            if (view != null) {
                view.setLayerType(0, null);
            }
        }

        public void openGpu(Activity activity) {
            activity.getWindow().setFlags(16777216, 16777216);
        }

        public void openViewGpu(View view) {
            if (view != null) {
                view.setLayerType(2, null);
            }
        }

        public void removeJavascriptInterface(WebView webView) {
            if (webView != null) {
                webView.removeJavascriptInterface("searchBoxJavaBridge_");
            }
        }

        public /* synthetic */ Object11(CompatibleUtile compatibleUtile, Object11 object11) {
            this();
        }
    }
}
