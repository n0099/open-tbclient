package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.liveremind.LiveRemindConfig;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes5.dex */
public class c95 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c95 g;
    public static int h;
    public static int i;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-933704883, "Lcom/baidu/tieba/c95$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-933704883, "Lcom/baidu/tieba/c95$a;");
                    return;
                }
            }
            int[] iArr = new int[LiveRemindConfig.Scene.values().length];
            a = iArr;
            try {
                iArr[LiveRemindConfig.Scene.LIVE_BUBBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[LiveRemindConfig.Scene.LIVE_FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947629610, "Lcom/baidu/tieba/c95;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947629610, "Lcom/baidu/tieba/c95;");
                return;
            }
        }
        new Date();
        new Date();
    }

    public c95() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        h();
    }

    public static c95 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (g == null) {
                synchronized (c95.class) {
                    if (g == null) {
                        g = new c95();
                    }
                }
            }
            return g;
        }
        return (c95) invokeV.objValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return o95.p().q(c(LiveRemindConfig.Scene.LIVE_BUBBLE), 0);
        }
        return invokeV.intValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            i = 0;
            h = 0;
            if (TbadkCoreApplication.isLogin()) {
                h();
            }
        }
    }

    public final String c(LiveRemindConfig.Scene scene) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, scene)) == null) {
            if (scene == LiveRemindConfig.Scene.LIVE_BUBBLE) {
                return this.a;
            }
            if (scene == LiveRemindConfig.Scene.LIVE_FLOAT) {
                return this.d;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public final String d(LiveRemindConfig.Scene scene) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, scene)) == null) {
            if (scene == LiveRemindConfig.Scene.LIVE_BUBBLE) {
                return this.c;
            }
            if (scene == LiveRemindConfig.Scene.LIVE_FLOAT) {
                return this.f;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public final String e(LiveRemindConfig.Scene scene) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, scene)) == null) {
            if (scene == LiveRemindConfig.Scene.LIVE_BUBBLE) {
                return this.b;
            }
            if (scene == LiveRemindConfig.Scene.LIVE_FLOAT) {
                return this.e;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public final void g(LiveRemindConfig.Scene scene) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, scene) == null) {
            o95.p().F(c(scene), o95.p().q(c(scene), 0) + 1);
        }
    }

    public void m(LiveRemindConfig.Scene scene) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, scene) == null) {
            if (scene == LiveRemindConfig.Scene.LIVE_BUBBLE) {
                i = 0;
            } else if (scene == LiveRemindConfig.Scene.LIVE_FLOAT) {
                h = 0;
            }
            o95.p().F(c(scene), 0);
        }
    }

    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            o95.p().F(c(LiveRemindConfig.Scene.LIVE_BUBBLE), i2);
        }
    }

    public void f(LiveRemindConfig.Scene scene) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, scene) == null) {
            int i2 = a.a[scene.ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    o95.p().H(d(scene), System.currentTimeMillis());
                    h++;
                    g(LiveRemindConfig.Scene.LIVE_FLOAT);
                    return;
                }
                return;
            }
            o95.p().H(d(scene), System.currentTimeMillis());
            i++;
            g(LiveRemindConfig.Scene.LIVE_BUBBLE);
        }
    }

    public boolean j(LiveRemindConfig.Scene scene) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, scene)) == null) {
            if (!StringHelper.isTaday(o95.p().r(e(scene), 0L))) {
                o95.p().H(e(scene), System.currentTimeMillis());
                m(scene);
            }
            if (i(scene) && k(scene)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a = "key_live_bubble_remind_show_count" + TbadkCoreApplication.getCurrentAccount();
            this.b = "key_live_bubble_remind_show_time" + TbadkCoreApplication.getCurrentAccount();
            this.c = "key_live_bubble_last_show_time" + TbadkCoreApplication.getCurrentAccount();
            this.d = "key_live_top_float_remind_show_count" + TbadkCoreApplication.getCurrentAccount();
            this.e = "key_live_top_float_remind_show_time" + TbadkCoreApplication.getCurrentAccount();
            this.f = "key_live_top_float_last_show_time" + TbadkCoreApplication.getCurrentAccount();
        }
    }

    public final boolean i(LiveRemindConfig.Scene scene) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, scene)) == null) {
            if (scene == LiveRemindConfig.Scene.LIVE_BUBBLE) {
                i2 = i;
            } else if (scene == LiveRemindConfig.Scene.LIVE_FLOAT) {
                i2 = h;
            } else {
                i2 = 0;
            }
            if (o95.p().q(c(scene), 0) >= LiveRemindConfig.c().b() || i2 >= LiveRemindConfig.c().a()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean k(LiveRemindConfig.Scene scene) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, scene)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long r = o95.p().r(d(scene), currentTimeMillis);
            if (currentTimeMillis == r || (currentTimeMillis - r) / 1000 >= LiveRemindConfig.c().d()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
