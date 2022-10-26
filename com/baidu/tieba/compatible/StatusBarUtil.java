package com.baidu.tieba.compatible;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.base.utils.SapiSystemBarTintManager;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.CodedInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public final class StatusBarUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View actionBarView;
    public boolean lightStatusBar;
    public boolean transparentStatusBar;
    public Window window;

    /* loaded from: classes3.dex */
    public final class Builder {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.lightStatusBar = false;
            this.transparentStatusbar = false;
        }

        public boolean process() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new StatusBarUtil(this.window, this.lightStatusBar, this.transparentStatusbar, this.actionBarView, null).process();
            }
            return invokeV.booleanValue;
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

        public Builder setActionbarView(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
                this.actionBarView = view2;
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
        public Builder setWindow(Dialog dialog) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, dialog)) == null) {
                this.window = dialog.getWindow();
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Builder setWindow(Window window) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, window)) == null) {
                this.window = window;
                return this;
            }
            return (Builder) invokeL.objValue;
        }
    }

    public StatusBarUtil(Window window, boolean z, boolean z2, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {window, Boolean.valueOf(z), Boolean.valueOf(z2), view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.lightStatusBar = z;
        this.transparentStatusBar = z2;
        this.window = window;
        this.actionBarView = view2;
    }

    public /* synthetic */ StatusBarUtil(Window window, boolean z, boolean z2, View view2, StatusBarUtil statusBarUtil) {
        this(window, z, z2, view2);
    }

    public static Builder from(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, activity)) == null) {
            return new Builder().setWindow(activity);
        }
        return (Builder) invokeL.objValue;
    }

    public void processActionBar(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) && view2 != null && this.transparentStatusBar && !isLessKitkat()) {
            view2.post(new Runnable(this, view2) { // from class: com.baidu.tieba.compatible.StatusBarUtil.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ StatusBarUtil this$0;
                public final /* synthetic */ View val$v;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, view2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$v = view2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        View view3 = this.val$v;
                        view3.setPadding(view3.getPaddingLeft(), this.val$v.getPaddingTop() + StatusBarUtil.getStatusBarOffsetPx(this.val$v.getContext()), this.val$v.getPaddingRight(), this.val$v.getPaddingBottom());
                        this.val$v.getLayoutParams().height += StatusBarUtil.getStatusBarOffsetPx(this.val$v.getContext());
                    }
                }
            });
        }
    }

    public static Builder from(Dialog dialog) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, dialog)) == null) {
            return new Builder().setWindow(dialog);
        }
        return (Builder) invokeL.objValue;
    }

    public static Builder from(Window window) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, window)) == null) {
            return new Builder().setWindow(window);
        }
        return (Builder) invokeL.objValue;
    }

    public static int getStatusBarOffsetPx(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            if (isLessKitkat()) {
                return 0;
            }
            Context applicationContext = context.getApplicationContext();
            int identifier = applicationContext.getResources().getIdentifier(SapiSystemBarTintManager.SystemBarConfig.g, EMABTest.TYPE_DIMEN, "android");
            if (identifier <= 0) {
                return 0;
            }
            return applicationContext.getResources().getDimensionPixelSize(identifier);
        }
        return invokeL.intValue;
    }

    public static boolean isKitkat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (Build.VERSION.SDK_INT == 19) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isLessKitkat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (Build.VERSION.SDK_INT < 19) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isMoreLollipop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean process() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i = Build.VERSION.SDK_INT;
            if (!processPrivateAPI() && !processLollipopAbove()) {
                return false;
            }
            if (i == 19) {
                processKitkat();
            }
            processActionBar(this.actionBarView);
            return true;
        }
        return invokeV.booleanValue;
    }

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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (!processFlyMe(this.lightStatusBar) && !processMIUI(this.lightStatusBar)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    private boolean processFlyMe(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65545, this, z)) == null) {
            WindowManager.LayoutParams attributes = this.window.getAttributes();
            try {
                Class<?> cls = Class.forName("android.view.WindowManager$LayoutParams");
                int i = cls.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON").getInt(attributes);
                Field declaredField = cls.getDeclaredField("meizuFlags");
                declaredField.setAccessible(true);
                int i2 = declaredField.getInt(attributes);
                if (z) {
                    declaredField.set(attributes, Integer.valueOf(i2 | i));
                } else {
                    declaredField.set(attributes, Integer.valueOf((~i) & i2));
                }
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeZ.booleanValue;
    }

    private boolean processMIUI(boolean z) {
        InterceptResult invokeZ;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65547, this, z)) == null) {
            Class<?> cls = this.window.getClass();
            try {
                Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int i2 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
                Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
                Window window = this.window;
                Object[] objArr = new Object[2];
                if (z) {
                    i = i2;
                } else {
                    i = 0;
                }
                objArr[0] = Integer.valueOf(i);
                objArr[1] = Integer.valueOf(i2);
                method.invoke(window, objArr);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeZ.booleanValue;
    }

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
}
