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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbDomainConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class CompatibleUtile {
    public static /* synthetic */ Interceptable $ic;
    public static CompatibleUtile mCompatibleUtile;
    public static Object11 mObject11;
    public static Object14 mObject14;
    public static Object5 mObject5;
    public static Object7 mObject7;
    public static Object8 mObject8;
    public static Object9 mObject9;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class FullscreenableChromeClient extends WebChromeClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final FrameLayout.LayoutParams COVER_SCREEN_PARAMS;
        public Activity mActivity;
        public FrameLayout mContentView;
        public View mCustomView;
        public WebChromeClient.CustomViewCallback mCustomViewCallback;
        public FrameLayout mFullscreenContainer;
        public int mOriginalOrientation;

        /* loaded from: classes3.dex */
        public class FullscreenHolder extends FrameLayout {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FullscreenableChromeClient this$1;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FullscreenHolder(FullscreenableChromeClient fullscreenableChromeClient, Context context) {
                super(context);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fullscreenableChromeClient, context};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((Context) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$1 = fullscreenableChromeClient;
                setBackgroundColor(context.getResources().getColor(17170444));
            }

            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent motionEvent) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                    return true;
                }
                return invokeL.booleanValue;
            }
        }

        public FullscreenableChromeClient(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mActivity = null;
            this.COVER_SCREEN_PARAMS = new FrameLayout.LayoutParams(-1, -1);
            this.mActivity = activity;
        }

        private void setFullscreen(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(65537, this, z) == null) {
                Window window = this.mActivity.getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                if (z) {
                    attributes.flags |= 1024;
                } else {
                    attributes.flags &= -1025;
                    View view2 = this.mCustomView;
                    if (view2 != null) {
                        view2.setSystemUiVisibility(0);
                    } else {
                        this.mContentView.setSystemUiVisibility(0);
                    }
                }
                window.setAttributes(attributes);
            }
        }

        public void hideCustomView() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                onHideCustomView();
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.mCustomView == null) {
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
        public void onShowCustomView(View view2, int i, WebChromeClient.CustomViewCallback customViewCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, view2, i, customViewCallback) == null) {
                if (this.mCustomView != null) {
                    customViewCallback.onCustomViewHidden();
                    return;
                }
                this.mOriginalOrientation = this.mActivity.getRequestedOrientation();
                FullscreenHolder fullscreenHolder = new FullscreenHolder(this, this.mActivity);
                this.mFullscreenContainer = fullscreenHolder;
                fullscreenHolder.addView(view2, this.COVER_SCREEN_PARAMS);
                ((FrameLayout) this.mActivity.getWindow().getDecorView()).addView(this.mFullscreenContainer, this.COVER_SCREEN_PARAMS);
                this.mCustomView = view2;
                setFullscreen(true);
                this.mCustomViewCallback = customViewCallback;
                this.mActivity.setRequestedOrientation(i);
                super.onShowCustomView(view2, i, customViewCallback);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class Object14 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CompatibleUtile this$0;

        public Object14(CompatibleUtile compatibleUtile) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {compatibleUtile};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = compatibleUtile;
        }

        public WebChromeClient getWebChromeClient(Activity activity) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, activity)) == null) ? new FullscreenableChromeClient(activity) : (WebChromeClient) invokeL.objValue;
        }

        public /* synthetic */ Object14(CompatibleUtile compatibleUtile, Object14 object14) {
            this(compatibleUtile);
        }
    }

    /* loaded from: classes3.dex */
    public class Object5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CompatibleUtile this$0;

        public Object5(CompatibleUtile compatibleUtile) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {compatibleUtile};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = compatibleUtile;
        }

        public void WebViewNoDataBase(WebSettings webSettings) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, webSettings) == null) || webSettings == null) {
                return;
            }
            webSettings.setDatabaseEnabled(false);
        }

        public int getActionPointerDown() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 5;
            }
            return invokeV.intValue;
        }

        public int getActionPointerUp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return 6;
            }
            return invokeV.intValue;
        }

        public int getMemoryClass(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) ? ((ActivityManager) context.getSystemService("activity")).getMemoryClass() : invokeL.intValue;
        }

        public float getSpacing(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
                if (motionEvent.getPointerCount() < 2) {
                    return -1.0f;
                }
                float x = motionEvent.getX(0) - motionEvent.getX(1);
                float y = motionEvent.getY(0) - motionEvent.getY(1);
                return (float) Math.sqrt((x * x) + (y * y));
            }
            return invokeL.floatValue;
        }

        public /* synthetic */ Object5(CompatibleUtile compatibleUtile, Object5 object5) {
            this(compatibleUtile);
        }
    }

    /* loaded from: classes3.dex */
    public class Object7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CompatibleUtile this$0;

        public Object7(CompatibleUtile compatibleUtile) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {compatibleUtile};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = compatibleUtile;
        }

        public boolean supportMultiTouch(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                if (context == null) {
                    return false;
                }
                return context.getPackageManager().hasSystemFeature("android.hardware.touchscreen.multitouch");
            }
            return invokeL.booleanValue;
        }

        public /* synthetic */ Object7(CompatibleUtile compatibleUtile, Object7 object7) {
            this(compatibleUtile);
        }
    }

    /* loaded from: classes3.dex */
    public class Object8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CompatibleUtile this$0;

        public Object8(CompatibleUtile compatibleUtile) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {compatibleUtile};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = compatibleUtile;
        }

        public long getUidRxBytes(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? TrafficStats.getUidRxBytes(i) : invokeI.longValue;
        }

        public long getUidTxBytes(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? TrafficStats.getUidTxBytes(i) : invokeI.longValue;
        }

        public boolean isAutoBrightness(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
                try {
                    return Settings.System.getInt(context.getContentResolver(), "screen_brightness_mode") == 1;
                } catch (Settings.SettingNotFoundException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            return invokeL.booleanValue;
        }

        public void loadUrl(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048579, this, webView, str) == null) || webView == null || TextUtils.isEmpty(str)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(Config.LAUNCH_REFERER, TbDomainConfig.DOMAIN_HTTPS_SERVER_ADDRESS);
            webView.loadUrl(str, hashMap);
        }

        public void setCameraDisplayOrientation(Camera camera, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048580, this, camera, i) == null) || camera == null) {
                return;
            }
            camera.setDisplayOrientation(i);
        }

        public /* synthetic */ Object8(CompatibleUtile compatibleUtile, Object8 object8) {
            this(compatibleUtile);
        }
    }

    /* loaded from: classes3.dex */
    public class Object9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CompatibleUtile this$0;

        public Object9(CompatibleUtile compatibleUtile) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {compatibleUtile};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = compatibleUtile;
        }

        public Camera getBackCamera() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
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
            return (Camera) invokeV.objValue;
        }

        public /* synthetic */ Object9(CompatibleUtile compatibleUtile, Object9 object9) {
            this(compatibleUtile);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(228271961, "Lcom/baidu/tieba/compatible/CompatibleUtile;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(228271961, "Lcom/baidu/tieba/compatible/CompatibleUtile;");
        }
    }

    public CompatibleUtile() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void dealWebView(WebSettings webSettings) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, webSettings) == null) {
            if (Build.VERSION.SDK_INT <= 11) {
                try {
                    Class<?> cls = Class.forName("android.webkit.WebView");
                    Method method = cls.getMethod("disablePlatformNotifications", new Class[0]);
                    Method method2 = cls.getMethod("enablePlatformNotifications", new Class[0]);
                    method.invoke(null, new Object[0]);
                    method2.invoke(null, new Object[0]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (webSettings == null || Build.VERSION.SDK_INT > 18) {
                return;
            }
            try {
                webSettings.getClass().getMethod("setPluginsEnabled", Boolean.class).invoke(webSettings, Boolean.TRUE);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static int getActionMask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return 255;
        }
        return invokeV.intValue;
    }

    public static CompatibleUtile getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (mCompatibleUtile == null) {
                mCompatibleUtile = new CompatibleUtile();
            }
            return mCompatibleUtile;
        }
        return (CompatibleUtile) invokeV.objValue;
    }

    private Object11 getObject11() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            if (Build.VERSION.SDK_INT >= 11 && mObject11 == null) {
                mObject11 = new Object11(this, null);
            }
            return mObject11;
        }
        return (Object11) invokeV.objValue;
    }

    private Object14 getObject14() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            if (Build.VERSION.SDK_INT >= 14 && mObject14 == null) {
                mObject14 = new Object14(this, null);
            }
            return mObject14;
        }
        return (Object14) invokeV.objValue;
    }

    private Object5 getObject5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            if (Build.VERSION.SDK_INT >= 5 && mObject5 == null) {
                mObject5 = new Object5(this, null);
            }
            return mObject5;
        }
        return (Object5) invokeV.objValue;
    }

    private Object7 getObject7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            if (Build.VERSION.SDK_INT >= 7 && mObject7 == null) {
                mObject7 = new Object7(this, null);
            }
            return mObject7;
        }
        return (Object7) invokeV.objValue;
    }

    private Object8 getObject8() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            if (Build.VERSION.SDK_INT >= 8 && mObject8 == null) {
                mObject8 = new Object8(this, null);
            }
            return mObject8;
        }
        return (Object8) invokeV.objValue;
    }

    private Object9 getObject9() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            if (Build.VERSION.SDK_INT >= 9 && mObject9 == null) {
                mObject9 = new Object9(this, null);
            }
            return mObject9;
        }
        return (Object9) invokeV.objValue;
    }

    public static void scrollListViewBy(ListView listView, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65547, null, listView, i, i2) == null) || Build.VERSION.SDK_INT < 8) {
            return;
        }
        listView.smoothScrollBy(i, i2);
    }

    public static void scrollListViewTo(ListView listView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65548, null, listView, i) == null) {
            if (Build.VERSION.SDK_INT >= 8) {
                listView.smoothScrollToPosition(i);
            } else {
                listView.setSelection(i);
            }
        }
    }

    public static void setAnim(Activity activity, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65549, null, activity, i, i2) == null) || Build.VERSION.SDK_INT < 5) {
            return;
        }
        activity.overridePendingTransition(i, i2);
    }

    public void WebViewNoDataBase(WebSettings webSettings) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, webSettings) == null) || getObject5() == null) {
            return;
        }
        getObject5().WebViewNoDataBase(webSettings);
    }

    public void closeViewGpu(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) || getObject11() == null) {
            return;
        }
        getObject11().closeViewGpu(view2);
    }

    public int getActionPointerDown() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (getObject5() != null) {
                return getObject5().getActionPointerDown();
            }
            return 5;
        }
        return invokeV.intValue;
    }

    public int getActionPointerUp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (getObject5() != null) {
                return getObject5().getActionPointerUp();
            }
            return 6;
        }
        return invokeV.intValue;
    }

    public Camera getBackCamera() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (getObject9() != null) {
                return getObject9().getBackCamera();
            }
            return Camera.open();
        }
        return (Camera) invokeV.objValue;
    }

    public int getBitmapMaxMemory(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            int memoryClass = getMemoryClass(context);
            if (memoryClass <= 0) {
                memoryClass = 16;
            }
            return ((memoryClass * 1024) * 1024) / 2;
        }
        return invokeL.intValue;
    }

    public int getMemoryClass(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            if (getObject5() != null) {
                return getObject5().getMemoryClass(context);
            }
            return 16;
        }
        return invokeL.intValue;
    }

    public float getSpacing(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, motionEvent)) == null) {
            if (getObject5() != null) {
                return getObject5().getSpacing(motionEvent);
            }
            return -1.0f;
        }
        return invokeL.floatValue;
    }

    public int getStatusBarColor(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context)) == null) {
            try {
                if (getObject11() != null) {
                    return getObject11().getStatusBarColor(context);
                }
            } catch (Exception unused) {
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public long getUidRxBytes(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            if (getObject8() != null) {
                return getObject8().getUidRxBytes(i);
            }
            return 0L;
        }
        return invokeI.longValue;
    }

    public long getUidTxBytes(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            if (getObject8() != null) {
                return getObject8().getUidTxBytes(i);
            }
            return 0L;
        }
        return invokeI.longValue;
    }

    public int getViewLayer(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, view2)) == null) {
            if (getObject11() != null) {
                return getObject11().getViewLayer(view2);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public WebChromeClient getWebChromeClient(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, activity)) == null) {
            if (getObject14() != null) {
                return getObject14().getWebChromeClient(activity);
            }
            return new WebChromeClient();
        }
        return (WebChromeClient) invokeL.objValue;
    }

    public boolean isAutoBrightness(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, context)) == null) {
            if (getObject8() != null) {
                return getObject8().isAutoBrightness(context);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean isUseHw(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, view2)) == null) {
            if (getObject11() != null) {
                return getObject11().isUseHw(view2);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void loadUrl(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, webView, str) == null) {
            if (getObject8() != null) {
                getObject8().loadUrl(webView, str);
            } else {
                webView.loadUrl(str);
            }
        }
    }

    public void noneViewGpu(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, view2) == null) || getObject11() == null) {
            return;
        }
        getObject11().noneViewGpu(view2);
    }

    public void openGpu(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, activity) == null) || getObject11() == null) {
            return;
        }
        getObject11().openGpu(activity);
    }

    public void openViewGpu(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, view2) == null) || getObject11() == null) {
            return;
        }
        getObject11().openViewGpu(view2);
    }

    public void removeJavascriptInterface(WebView webView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, webView) == null) || getObject11() == null) {
            return;
        }
        getObject11().removeJavascriptInterface(webView);
    }

    public void setCameraDisplayOrientation(Camera camera, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048596, this, camera, i) == null) || getObject8() == null) {
            return;
        }
        getObject8().setCameraDisplayOrientation(camera, i);
    }

    public boolean supportMultiTouch(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, context)) == null) {
            if (getObject7() != null) {
                return getObject7().supportMultiTouch(context);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* loaded from: classes3.dex */
    public class Object11 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int[] STATUSBAR_ATTRS;
        public final /* synthetic */ CompatibleUtile this$0;

        public Object11(CompatibleUtile compatibleUtile) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {compatibleUtile};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = compatibleUtile;
            this.STATUSBAR_ATTRS = new int[]{16842904};
        }

        public void closeViewGpu(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && view2.isHardwareAccelerated()) {
                view2.setLayerType(1, null);
            }
        }

        public int getStatusBarColor(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? context.obtainStyledAttributes(16973928, this.STATUSBAR_ATTRS).getColor(0, 0) : invokeL.intValue;
        }

        public int getViewLayer(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
                if (view2 != null) {
                    return view2.getLayerType();
                }
                return 0;
            }
            return invokeL.intValue;
        }

        public boolean isUseHw(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, view2)) == null) ? view2 != null && view2.isHardwareAccelerated() : invokeL.booleanValue;
        }

        public void noneViewGpu(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, view2) == null) || view2 == null) {
                return;
            }
            view2.setLayerType(0, null);
        }

        public void openGpu(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, activity) == null) {
                activity.getWindow().setFlags(16777216, 16777216);
            }
        }

        public void openViewGpu(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048582, this, view2) == null) || view2 == null) {
                return;
            }
            view2.setLayerType(2, null);
        }

        public void removeJavascriptInterface(WebView webView) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048583, this, webView) == null) || webView == null) {
                return;
            }
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
        }

        public /* synthetic */ Object11(CompatibleUtile compatibleUtile, Object11 object11) {
            this(compatibleUtile);
        }
    }
}
