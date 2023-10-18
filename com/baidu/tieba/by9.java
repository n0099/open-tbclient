package com.baidu.tieba;

import androidx.annotation.MainThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.UiUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class by9 {
    public static /* synthetic */ Interceptable $ic;
    public static final a d;
    public transient /* synthetic */ FieldHolder $fh;
    public wx9 a;
    public final HashMap<String, List<tx9>> b;
    public yx9 c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947661447, "Lcom/baidu/tieba/by9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947661447, "Lcom/baidu/tieba/by9;");
                return;
            }
        }
        d = new a(null);
    }

    public /* synthetic */ by9(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final by9 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? d.a() : (by9) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @JvmStatic
        public final by9 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return b.a.a();
            }
            return (by9) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;
        public static final by9 b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-903109495, "Lcom/baidu/tieba/by9$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-903109495, "Lcom/baidu/tieba/by9$b;");
                    return;
                }
            }
            a = new b();
            b = new by9(null);
        }

        public b() {
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

        public final by9 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return b;
            }
            return (by9) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static final class c extends gs5<yx9> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gs5
        /* renamed from: a */
        public yx9 doInBackground() {
            InterceptResult invokeV;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                m9<String> l = gz4.l("tb.push_scene_group_cache");
                if (l != null) {
                    str = l.get("key_scene_group_cache");
                } else {
                    str = null;
                }
                return yx9.c.b(str);
            }
            return (yx9) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static final class d extends gs5<Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void a() {
            m9<String> l;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (l = gz4.l("tb.push_scene_group_cache")) != null) {
                l.g("key_scene_group_cache", "");
            }
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.gs5
        public /* bridge */ /* synthetic */ Unit doInBackground() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* loaded from: classes5.dex */
    public static final class e extends gs5<Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ by9 a;

        public e(by9 by9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {by9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = by9Var;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String g = this.a.c.g();
                m9<String> l = gz4.l("tb.push_scene_group_cache");
                if (l != null) {
                    l.g("key_scene_group_cache", g);
                }
            }
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.gs5
        public /* bridge */ /* synthetic */ Unit doInBackground() {
            a();
            return Unit.INSTANCE;
        }
    }

    public by9() {
        List<tx9> list;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new HashMap<>();
        String dateStringDay = ad.getDateStringDay(new Date());
        Intrinsics.checkNotNullExpressionValue(dateStringDay, "getDateStringDay(Date())");
        this.c = new yx9(dateStringDay, new ArrayList());
        ye1<tx9> a2 = new ux9().a();
        if (a2 != null && (list = a2.getList()) != null) {
            for (tx9 check : list) {
                List<tx9> list2 = this.b.get(check.name());
                if (list2 != null) {
                    Intrinsics.checkNotNullExpressionValue(check, "check");
                    list2.add(check);
                } else {
                    ArrayList arrayList = new ArrayList();
                    Intrinsics.checkNotNullExpressionValue(check, "check");
                    arrayList.add(check);
                    this.b.put(check.name(), arrayList);
                }
            }
        }
    }

    public static final void k(final by9 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ks5.b(new c(), new lr5() { // from class: com.baidu.tieba.mx9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.lr5
                public final void onReturnDataInUI(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        by9.l(by9.this, (yx9) obj);
                    }
                }
            });
        }
    }

    public static final void n(by9 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.c.e();
            ks5.b(new d(), null);
        }
    }

    public final zx9 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            for (zx9 zx9Var : this.c.b()) {
                if (zx9Var.a() == i) {
                    return zx9Var;
                }
            }
            return null;
        }
        return (zx9) invokeI.objValue;
    }

    public final long f(String scene) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, scene)) == null) {
            Intrinsics.checkNotNullParameter(scene, "scene");
            SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
            return sharedPrefHelper.getLong("key_scene_shown_prefix_" + scene, 0L);
        }
        return invokeL.longValue;
    }

    @MainThread
    public final void h(String scene) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, scene) == null) {
            Intrinsics.checkNotNullParameter(scene, "scene");
            p(scene);
            if (this.a != null) {
                i(scene);
            }
        }
    }

    public final void i(String str) {
        xx9 c2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && (c2 = c(str)) != null) {
            this.c.d(c2.b());
            o();
        }
    }

    public final void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
            sharedPrefHelper.putLong("key_scene_shown_prefix_" + str, System.currentTimeMillis());
        }
    }

    public final void q(JSONObject json) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, json) == null) {
            Intrinsics.checkNotNullParameter(json, "json");
            this.a = wx9.c.a(json.optJSONObject("push_strategy_new"));
            j();
        }
    }

    public static final void l(by9 this$0, yx9 yx9Var) {
        String dateStringDay;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, this$0, yx9Var) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (yx9Var != null && !yx9Var.c()) {
                this$0.m();
                return;
            }
            yx9 yx9Var2 = this$0.c;
            if (yx9Var == null || (dateStringDay = yx9Var.a()) == null) {
                dateStringDay = ad.getDateStringDay(new Date());
                if (dateStringDay == null) {
                    dateStringDay = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(dateStringDay, "BdStringHelper.getDateStringDay(Date()) ?: \"\"");
                }
            }
            yx9Var2.f(dateStringDay);
            yx9Var2.b().clear();
            if (yx9Var != null) {
                yx9Var2.b().addAll(yx9Var.b());
            }
        }
    }

    @MainThread
    public final boolean b(String scene) {
        InterceptResult invokeL;
        boolean z;
        zx9 d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, scene)) == null) {
            Intrinsics.checkNotNullParameter(scene, "scene");
            if (!this.c.c()) {
                m();
            }
            List<tx9> list = this.b.get(scene);
            if (list != null && !list.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return false;
            }
            for (tx9 tx9Var : list) {
                if (!tx9Var.a()) {
                    return false;
                }
            }
            xx9 c2 = c(scene);
            if (c2 == null || (d2 = d(c2.b())) == null || d2.b() < c2.c()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final xx9 c(String str) {
        InterceptResult invokeL;
        List<xx9> a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            wx9 wx9Var = this.a;
            if (wx9Var != null && (a2 = wx9Var.a()) != null) {
                for (xx9 xx9Var : a2) {
                    if (xx9Var.a().contains(str)) {
                        return xx9Var;
                    }
                }
                return null;
            }
            return null;
        }
        return (xx9) invokeL.objValue;
    }

    public final ay9 g(String scene) {
        InterceptResult invokeL;
        List<ay9> b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, scene)) == null) {
            Intrinsics.checkNotNullParameter(scene, "scene");
            wx9 wx9Var = this.a;
            if (wx9Var != null && (b2 = wx9Var.b()) != null) {
                for (ay9 ay9Var : b2) {
                    if (Intrinsics.areEqual(ay9Var.c(), scene)) {
                        return ay9Var;
                    }
                }
                return null;
            }
            return null;
        }
        return (ay9) invokeL.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            UiUtils.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.ox9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        by9.k(by9.this);
                    }
                }
            });
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            UiUtils.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.nx9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        by9.n(by9.this);
                    }
                }
            });
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ks5.b(new e(this), null);
        }
    }
}
