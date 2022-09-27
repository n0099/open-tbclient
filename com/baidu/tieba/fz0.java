package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.player.utils.BdViewOpUtils;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class fz0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ Activity b;

        public a(View view2, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
            this.b = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int g = fz0.g();
                int systemUiVisibility = this.a.getSystemUiVisibility();
                int h = fz0.h(this.b);
                if (g != systemUiVisibility) {
                    h |= systemUiVisibility;
                }
                dz0.b(BdViewOpUtils.TAG, "RESTORE KEY_SYSTEM_UI_VISIBILITY=" + h);
                this.a.setSystemUiVisibility(h);
            }
        }
    }

    public static boolean b(Activity activity, View view2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, activity, view2)) == null) {
            if (activity == null || view2 == null) {
                return false;
            }
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            k(view2);
            viewGroup.removeView(view2);
            viewGroup.addView(view2);
            if (i(activity)) {
                n(activity);
                o(viewGroup, true);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean c(View view2, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, view2, viewGroup)) == null) {
            if (view2 != null && viewGroup != null && viewGroup.getParent() != null) {
                dz0.b(BdViewOpUtils.TAG, "attachView " + view2.hashCode() + " " + viewGroup.hashCode());
                try {
                    viewGroup.addView(view2);
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65539, null, activity, z) == null) || activity == null || Build.VERSION.SDK_INT < 28) {
            return;
        }
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (z) {
            m(activity, attributes.layoutInDisplayCutoutMode);
            attributes.layoutInDisplayCutoutMode = 1;
        } else {
            attributes.layoutInDisplayCutoutMode = f(activity);
        }
        window.setAttributes(attributes);
    }

    @Nullable
    public static ViewGroup e(@Nullable Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity)) == null) {
            if (activity != null) {
                return (ViewGroup) activity.getWindow().getDecorView();
            }
            return null;
        }
        return (ViewGroup) invokeL.objValue;
    }

    public static int f(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, activity)) == null) {
            if (activity.getIntent() != null) {
                return activity.getIntent().getIntExtra(BdViewOpUtils.KEY_DISPLAY_CUTOUT_MODE, 0);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? Build.VERSION.SDK_INT >= 19 ? 5638 : 1542 : invokeV.intValue;
    }

    public static int h(@Nullable Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, activity)) == null) {
            if (activity == null || activity.getIntent() == null) {
                return -1;
            }
            return activity.getIntent().getIntExtra(BdViewOpUtils.KEY_SYSTEM_UI_VISIBILITY, -1);
        }
        return invokeL.intValue;
    }

    public static boolean i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            if (context != null) {
                return !ViewConfiguration.get(context).hasPermanentMenuKey();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean j(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, viewGroup)) == null) {
            if (viewGroup != null) {
                dz0.b(BdViewOpUtils.TAG, "removeChilds " + viewGroup.hashCode());
                viewGroup.removeAllViews();
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean k(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, view2)) == null) {
            if (view2 == null || view2.getParent() == null || !(view2.getParent() instanceof ViewGroup)) {
                return false;
            }
            ViewGroup viewGroup = (ViewGroup) view2.getParent();
            if (viewGroup.indexOfChild(view2) != -1) {
                try {
                    dz0.b(BdViewOpUtils.TAG, "removeView " + view2.hashCode());
                    viewGroup.removeView(view2);
                    return true;
                } catch (Exception e) {
                    dz0.f("removeView(" + System.identityHashCode(view2) + SmallTailInfo.EMOTION_SUFFIX, e);
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void l(@Nullable Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, activity) == null) && i(activity)) {
            ViewGroup e = e(activity);
            int h = h(activity);
            if (e == null || h == -1) {
                return;
            }
            e.postDelayed(new a(e, activity), 300L);
        }
    }

    public static void m(Activity activity, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65548, null, activity, i) == null) || activity.getIntent() == null) {
            return;
        }
        activity.getIntent().putExtra(BdViewOpUtils.KEY_DISPLAY_CUTOUT_MODE, i);
    }

    public static void n(@Nullable Activity activity) {
        ViewGroup e;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, null, activity) == null) || activity == null || activity.getIntent() == null || (e = e(activity)) == null) {
            return;
        }
        dz0.b(BdViewOpUtils.TAG, "SAVE KEY_SYSTEM_UI_VISIBILITY=" + e.getSystemUiVisibility());
        activity.getIntent().putExtra(BdViewOpUtils.KEY_SYSTEM_UI_VISIBILITY, e.getSystemUiVisibility());
    }

    public static void o(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65550, null, view2, z) == null) {
            dz0.b(BdViewOpUtils.TAG, "setSystemUiVisibility immersive: " + z);
            if (view2 == null) {
                return;
            }
            if (z) {
                view2.setSystemUiVisibility(g());
            } else {
                view2.setSystemUiVisibility(0);
            }
        }
    }
}
