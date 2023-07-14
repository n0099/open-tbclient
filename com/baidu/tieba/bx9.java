package com.baidu.tieba;

import androidx.annotation.MainThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
public final class bx9 {
    public static /* synthetic */ Interceptable $ic;
    public static final a d;
    public transient /* synthetic */ FieldHolder $fh;
    public ww9 a;
    public final HashMap<String, List<tw9>> b;
    public yw9 c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947660486, "Lcom/baidu/tieba/bx9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947660486, "Lcom/baidu/tieba/bx9;");
                return;
            }
        }
        d = new a(null);
    }

    public /* synthetic */ bx9(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final bx9 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? d.a() : (bx9) invokeV.objValue;
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
        public final bx9 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return b.a.a();
            }
            return (bx9) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;
        public static final bx9 b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-904033016, "Lcom/baidu/tieba/bx9$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-904033016, "Lcom/baidu/tieba/bx9$b;");
                    return;
                }
            }
            a = new b();
            b = new bx9(null);
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

        public final bx9 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return b;
            }
            return (bx9) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static final class c extends wy5<yw9> {
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
        @Override // com.baidu.tieba.wy5
        /* renamed from: a */
        public yw9 doInBackground() {
            InterceptResult invokeV;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ye<String> f = o55.f("tb.push_scene_group_cache");
                if (f != null) {
                    str = f.get("key_scene_group_cache");
                } else {
                    str = null;
                }
                return yw9.c.b(str);
            }
            return (yw9) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static final class d extends wy5<Unit> {
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
            ye<String> f;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (f = o55.f("tb.push_scene_group_cache")) != null) {
                f.g("key_scene_group_cache", "");
            }
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.wy5
        public /* bridge */ /* synthetic */ Unit doInBackground() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* loaded from: classes5.dex */
    public static final class e extends wy5<Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bx9 a;

        public e(bx9 bx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bx9Var;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String g = this.a.c.g();
                ye<String> f = o55.f("tb.push_scene_group_cache");
                if (f != null) {
                    f.g("key_scene_group_cache", g);
                }
            }
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.wy5
        public /* bridge */ /* synthetic */ Unit doInBackground() {
            a();
            return Unit.INSTANCE;
        }
    }

    public bx9() {
        List<tw9> list;
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
        String dateStringDay = xi.getDateStringDay(new Date());
        Intrinsics.checkNotNullExpressionValue(dateStringDay, "getDateStringDay(Date())");
        this.c = new yw9(dateStringDay, new ArrayList());
        dl1<tw9> a2 = new uw9().a();
        if (a2 != null && (list = a2.getList()) != null) {
            for (tw9 check : list) {
                List<tw9> list2 = this.b.get(check.name());
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

    public static final void k(final bx9 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            az5.b(new c(), new ay5() { // from class: com.baidu.tieba.mw9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.ay5
                public final void onReturnDataInUI(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        bx9.l(bx9.this, (yw9) obj);
                    }
                }
            });
        }
    }

    public static final void n(bx9 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.c.e();
            az5.b(new d(), null);
        }
    }

    public final zw9 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            for (zw9 zw9Var : this.c.b()) {
                if (zw9Var.a() == i) {
                    return zw9Var;
                }
            }
            return null;
        }
        return (zw9) invokeI.objValue;
    }

    public final long f(String scene) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, scene)) == null) {
            Intrinsics.checkNotNullParameter(scene, "scene");
            da5 p = da5.p();
            return p.r("key_scene_shown_prefix_" + scene, 0L);
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
        xw9 c2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && (c2 = c(str)) != null) {
            this.c.d(c2.b());
            o();
        }
    }

    public final void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            da5 p = da5.p();
            p.H("key_scene_shown_prefix_" + str, System.currentTimeMillis());
        }
    }

    public final void q(JSONObject json) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, json) == null) {
            Intrinsics.checkNotNullParameter(json, "json");
            this.a = ww9.c.a(json.optJSONObject("push_strategy_new"));
            j();
        }
    }

    public static final void l(bx9 this$0, yw9 yw9Var) {
        String dateStringDay;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, this$0, yw9Var) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (yw9Var != null && !yw9Var.c()) {
                this$0.m();
                return;
            }
            yw9 yw9Var2 = this$0.c;
            if (yw9Var == null || (dateStringDay = yw9Var.a()) == null) {
                dateStringDay = xi.getDateStringDay(new Date());
                if (dateStringDay == null) {
                    dateStringDay = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(dateStringDay, "BdStringHelper.getDateStringDay(Date()) ?: \"\"");
                }
            }
            yw9Var2.f(dateStringDay);
            yw9Var2.b().clear();
            if (yw9Var != null) {
                yw9Var2.b().addAll(yw9Var.b());
            }
        }
    }

    @MainThread
    public final boolean b(String scene) {
        InterceptResult invokeL;
        boolean z;
        zw9 d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, scene)) == null) {
            Intrinsics.checkNotNullParameter(scene, "scene");
            if (!this.c.c()) {
                m();
            }
            List<tw9> list = this.b.get(scene);
            if (list != null && !list.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return false;
            }
            for (tw9 tw9Var : list) {
                if (!tw9Var.a()) {
                    return false;
                }
            }
            xw9 c2 = c(scene);
            if (c2 == null || (d2 = d(c2.b())) == null || d2.b() < c2.c()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final xw9 c(String str) {
        InterceptResult invokeL;
        List<xw9> a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            ww9 ww9Var = this.a;
            if (ww9Var != null && (a2 = ww9Var.a()) != null) {
                for (xw9 xw9Var : a2) {
                    if (xw9Var.a().contains(str)) {
                        return xw9Var;
                    }
                }
                return null;
            }
            return null;
        }
        return (xw9) invokeL.objValue;
    }

    public final ax9 g(String scene) {
        InterceptResult invokeL;
        List<ax9> b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, scene)) == null) {
            Intrinsics.checkNotNullParameter(scene, "scene");
            ww9 ww9Var = this.a;
            if (ww9Var != null && (b2 = ww9Var.b()) != null) {
                for (ax9 ax9Var : b2) {
                    if (Intrinsics.areEqual(ax9Var.c(), scene)) {
                        return ax9Var;
                    }
                }
                return null;
            }
            return null;
        }
        return (ax9) invokeL.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            dh.g(new Runnable() { // from class: com.baidu.tieba.ow9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        bx9.k(bx9.this);
                    }
                }
            });
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            dh.g(new Runnable() { // from class: com.baidu.tieba.nw9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        bx9.n(bx9.this);
                    }
                }
            });
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            az5.b(new e(this), null);
        }
    }
}
