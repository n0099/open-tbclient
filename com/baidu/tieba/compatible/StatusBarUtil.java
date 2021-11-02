package com.baidu.tieba.compatible;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.CodedInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes9.dex */
public final class StatusBarUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View actionBarView;
    public boolean lightStatusBar;
    public boolean transparentStatusBar;
    public Window window;

    /* loaded from: classes9.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View actionBarView;
        public boolean lightStatusBar;
        public boolean transparentStatusbar;
        public Window window;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.lightStatusBar = false;
            this.transparentStatusbar = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Builder setWindow(Window window) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, window)) == null) {
                this.window = window;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public boolean process() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new StatusBarUtil(this.window, this.lightStatusBar, this.transparentStatusbar, this.actionBarView, null).process() : invokeV.booleanValue;
        }

        public Builder setActionbarView(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view)) == null) {
                this.actionBarView = view;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setLightStatusBar(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.lightStatusBar = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setTransparentStatusbar(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.transparentStatusbar = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Builder setWindow(Activity activity) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, activity)) == null) {
                this.window = activity.getWindow();
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Builder setWindow(Dialog dialog) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, dialog)) == null) {
                this.window = dialog.getWindow();
                return this;
            }
            return (Builder) invokeL.objValue;
        }
    }

    public StatusBarUtil(Window window, boolean z, boolean z2, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {window, Boolean.valueOf(z), Boolean.valueOf(z2), view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.lightStatusBar = z;
        this.transparentStatusBar = z2;
        this.window = window;
        this.actionBarView = view;
    }

    public static Builder from(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, activity)) == null) ? new Builder().setWindow(activity) : (Builder) invokeL.objValue;
    }

    public static int getStatusBarOffsetPx(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            if (isLessKitkat()) {
                return 0;
            }
            Context applicationContext = context.getApplicationContext();
            int identifier = applicationContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                return applicationContext.getResources().getDimensionPixelSize(identifier);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static boolean isKitkat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? Build.VERSION.SDK_INT == 19 : invokeV.booleanValue;
    }

    public static boolean isLessKitkat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? Build.VERSION.SDK_INT < 19 : invokeV.booleanValue;
    }

    public static boolean isMoreLollipop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? Build.VERSION.SDK_INT >= 21 : invokeV.booleanValue;
    }

    private boolean processFlyMe(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65545, this, z)) == null) {
            WindowManager.LayoutParams attributes = this.window.getAttributes();
            try {
                Class<?> cls = Class.forName("android.view.WindowManager$LayoutParams");
                int i2 = cls.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON").getInt(attributes);
                Field declaredField = cls.getDeclaredField("meizuFlags");
                declaredField.setAccessible(true);
                int i3 = declaredField.getInt(attributes);
                if (z) {
                    declaredField.set(attributes, Integer.valueOf(i3 | i2));
                } else {
                    declaredField.set(attributes, Integer.valueOf((~i2) & i3));
                }
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeZ.booleanValue;
    }

    @TargetApi(21)
    private boolean processLollipopAbove() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            if (Build.VERSION.SDK_INT < 23) {
                return false;
            }
            int systemUiVisibility = this.window.getDecorView().getSystemUiVisibility();
            if (this.lightStatusBar) {
                systemUiVisibility |= -2147475456;
            }
            if (this.transparentStatusBar) {
                systemUiVisibility |= 1280;
            }
            this.window.getDecorView().setSystemUiVisibility(systemUiVisibility);
            this.window.setStatusBarColor(0);
            return true;
        }
        return invokeV.booleanValue;
    }

    private boolean processMIUI(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65547, this, z)) == null) {
            Class<?> cls = this.window.getClass();
            try {
                Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int i2 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
                Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
                Window window = this.window;
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(z ? i2 : 0);
                objArr[1] = Integer.valueOf(i2);
                method.invoke(window, objArr);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeZ.booleanValue;
    }

    public boolean process() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (processPrivateAPI() || processLollipopAbove()) {
                if (i2 == 19) {
                    processKitkat();
                }
                processActionBar(this.actionBarView);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void processActionBar(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || view == null || !this.transparentStatusBar || isLessKitkat()) {
            return;
        }
        view.post(new Runnable(this, view) { // from class: com.baidu.tieba.compatible.StatusBarUtil.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ StatusBarUtil this$0;
            public final /* synthetic */ View val$v;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, view};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$v = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    View view2 = this.val$v;
                    view2.setPadding(view2.getPaddingLeft(), this.val$v.getPaddingTop() + StatusBarUtil.getStatusBarOffsetPx(this.val$v.getContext()), this.val$v.getPaddingRight(), this.val$v.getPaddingBottom());
                    this.val$v.getLayoutParams().height += StatusBarUtil.getStatusBarOffsetPx(this.val$v.getContext());
                }
            }
        });
    }

    @TargetApi(19)
    public void processKitkat() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            WindowManager.LayoutParams attributes = this.window.getAttributes();
            if (this.transparentStatusBar) {
                attributes.flags |= CodedInputStream.DEFAULT_SIZE_LIMIT;
            } else {
                attributes.flags &= -67108865;
            }
            this.window.setAttributes(attributes);
        }
    }

    public boolean processPrivateAPI() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? processFlyMe(this.lightStatusBar) || processMIUI(this.lightStatusBar) : invokeV.booleanValue;
    }

    public static Builder from(Dialog dialog) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, dialog)) == null) ? new Builder().setWindow(dialog) : (Builder) invokeL.objValue;
    }

    public static Builder from(Window window) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, window)) == null) ? new Builder().setWindow(window) : (Builder) invokeL.objValue;
    }

    public /* synthetic */ StatusBarUtil(Window window, boolean z, boolean z2, View view, StatusBarUtil statusBarUtil) {
        this(window, z, z2, view);
    }
}
