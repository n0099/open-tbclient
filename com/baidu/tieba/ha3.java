package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.tieba.ia3;
import com.baidu.tieba.ua3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ha3 extends m73 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public interface j {
        void a(boolean z, int i);
    }

    /* loaded from: classes6.dex */
    public class b implements mx2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ JSONArray c;
        public final /* synthetic */ p53 d;
        public final /* synthetic */ Activity e;
        public final /* synthetic */ ha3 f;

        /* loaded from: classes6.dex */
        public class a implements ik3<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ pa3 a;
            public final /* synthetic */ List b;
            public final /* synthetic */ b c;

            /* renamed from: com.baidu.tieba.ha3$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class RunnableC0302a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Boolean a;
                public final /* synthetic */ a b;

                public RunnableC0302a(a aVar, Boolean bool) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar, bool};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = aVar;
                    this.a = bool;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        a aVar = this.b;
                        ha3 ha3Var = aVar.c.f;
                        pa3 pa3Var = aVar.a;
                        List list = aVar.b;
                        boolean booleanValue = this.a.booleanValue();
                        b bVar = this.b.c;
                        ha3Var.P(pa3Var, list, booleanValue, bVar.e, bVar.d, bVar.a, bVar.b);
                    }
                }
            }

            public a(b bVar, pa3 pa3Var, List list) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, pa3Var, list};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = bVar;
                this.a = pa3Var;
                this.b = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ik3
            /* renamed from: b */
            public void a(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                    b bVar = this.c;
                    bVar.f.O(bVar.e, this.a, bool);
                    jj3.a0(new RunnableC0302a(this, bool));
                }
            }
        }

        /* renamed from: com.baidu.tieba.ha3$b$b  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0303b implements ik3<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ pa3 a;
            public final /* synthetic */ List b;
            public final /* synthetic */ b c;

            /* renamed from: com.baidu.tieba.ha3$b$b$a */
            /* loaded from: classes6.dex */
            public class a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ C0303b a;

                public a(C0303b c0303b) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0303b};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = c0303b;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        C0303b c0303b = this.a;
                        b bVar = c0303b.c;
                        bVar.f.P(c0303b.a, c0303b.b, false, bVar.e, bVar.d, bVar.a, bVar.b);
                    }
                }
            }

            public C0303b(b bVar, pa3 pa3Var, List list) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, pa3Var, list};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = bVar;
                this.a = pa3Var;
                this.b = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ik3
            /* renamed from: b */
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                    b bVar = this.c;
                    bVar.f.N(bVar.e, this.a, str);
                    jj3.a0(new a(this));
                }
            }
        }

        public b(ha3 ha3Var, CallbackHandler callbackHandler, String str, JSONArray jSONArray, p53 p53Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ha3Var, callbackHandler, str, jSONArray, p53Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = ha3Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = jSONArray;
            this.d = p53Var;
            this.e = activity;
        }

        @Override // com.baidu.tieba.mx2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Map<String, pa3> g = nx2.g(true);
                pa3 y = this.f.y(g, this.a, this.b);
                if (y == null) {
                    ia3.b d = ia3.d();
                    d.n(false);
                    d.o();
                    return;
                }
                List<pa3> w = this.f.w(g, this.c, this.a, this.b);
                if (w == null) {
                    return;
                }
                y.i(w);
                if (!this.d.N().e(this.e)) {
                    wo2.Z().a(this.e, new a(this, y, w));
                } else {
                    this.f.z(new C0303b(this, y, w));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements ik3<sa3<ua3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ p53 d;
        public final /* synthetic */ JSONArray e;
        public final /* synthetic */ ha3 f;

        public a(ha3 ha3Var, CallbackHandler callbackHandler, String str, Context context, p53 p53Var, JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ha3Var, callbackHandler, str, context, p53Var, jSONArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = ha3Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = context;
            this.d = p53Var;
            this.e = jSONArray;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ik3
        /* renamed from: b */
        public void a(sa3<ua3.e> sa3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sa3Var) == null) {
                if (na3.h(sa3Var)) {
                    this.f.x((Activity) this.c, this.d, this.a, this.e, this.b);
                    return;
                }
                ia3.b d = ia3.d();
                d.n(false);
                d.o();
                na3.q(sa3Var, this.a, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ka3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ p53 d;
        public final /* synthetic */ Activity e;
        public final /* synthetic */ List f;
        public final /* synthetic */ ha3 g;

        public c(ha3 ha3Var, CallbackHandler callbackHandler, String str, boolean z, p53 p53Var, Activity activity, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ha3Var, callbackHandler, str, Boolean.valueOf(z), p53Var, activity, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = ha3Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = z;
            this.d = p53Var;
            this.e = activity;
            this.f = list;
        }

        @Override // com.baidu.tieba.ka3
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                p22.i("MultiAuthorize", "showAuthDialog " + z);
                if (!z) {
                    ia3.b d = ia3.d();
                    d.i(false);
                    d.h(false);
                    d.o();
                    na3.o(10003, this.a, this.b);
                    return;
                }
                ia3.b d2 = ia3.d();
                d2.i(true);
                d2.h(true);
                boolean z2 = this.c;
                if (this.d.N().e(this.e)) {
                    ia3.d().m(true);
                    this.g.H(this.f, this.e, this.a, this.b);
                } else if (!z2) {
                    ia3.d().m(false);
                    this.g.G(this.f, this.e, this.a, this.b, this.d);
                } else {
                    this.g.K(this.f, this.e, this.a, this.b);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ String d;
        public final /* synthetic */ ha3 e;

        public d(ha3 ha3Var, List list, Activity activity, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ha3Var, list, activity, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ha3Var;
            this.a = list;
            this.b = activity;
            this.c = callbackHandler;
            this.d = str;
        }

        @Override // com.baidu.tieba.ha3.j
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                p22.i("MultiAuthorize", "login result:" + i);
                if (z) {
                    ia3.d().k(true);
                    this.e.H(this.a, this.b, this.c, this.d);
                    return;
                }
                ia3.b d = ia3.d();
                d.k(false);
                d.n(true);
                d.i(false);
                d.o();
                na3.o(10004, this.c, this.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements ik3<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ String d;
        public final /* synthetic */ ha3 e;

        public e(ha3 ha3Var, List list, Activity activity, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ha3Var, list, activity, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ha3Var;
            this.a = list;
            this.b = activity;
            this.c = callbackHandler;
            this.d = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ik3
        /* renamed from: b */
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.e.I(TextUtils.equals(str, "1"), this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements ik3<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ List b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ String d;
        public final /* synthetic */ ha3 e;

        public f(ha3 ha3Var, Activity activity, List list, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ha3Var, activity, list, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ha3Var;
            this.a = activity;
            this.b = list;
            this.c = callbackHandler;
            this.d = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ik3
        /* renamed from: b */
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (!TextUtils.isEmpty(str)) {
                    ia3.b d = ia3.d();
                    d.j(true);
                    d.i(true);
                    this.e.J(this.a, this.b, this.c, this.d);
                    return;
                }
                ia3.b d2 = ia3.d();
                d2.j(false);
                d2.i(false);
                d2.o();
                na3.o(10003, this.c, this.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements ik3<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ String d;
        public final /* synthetic */ ha3 e;

        public g(ha3 ha3Var, List list, Activity activity, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ha3Var, list, activity, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ha3Var;
            this.a = list;
            this.b = activity;
            this.c = callbackHandler;
            this.d = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ik3
        /* renamed from: b */
        public void a(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, num) == null) {
                if (num.intValue() == 0) {
                    ia3.d().m(true);
                    this.e.H(this.a, this.b, this.c, this.d);
                    return;
                }
                ia3.b d = ia3.d();
                d.m(false);
                d.n(false);
                d.o();
                na3.o(10003, this.c, this.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements ik3<sa3<ua3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;

        public h(ha3 ha3Var, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ha3Var, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = callbackHandler;
            this.b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ik3
        /* renamed from: b */
        public void a(sa3<ua3.e> sa3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sa3Var) == null) {
                if (sa3Var == null) {
                    na3.o(10001, this.a, this.b);
                    ia3.b d = ia3.d();
                    d.n(false);
                    d.o();
                    ic3.r(10001, null);
                    return;
                }
                int b = sa3Var.b();
                p22.o("MultiAuthorize", "requestAuthorize " + sa3Var.a() + ",  code=" + b + ", data=" + sa3Var.a);
                if (b != 0) {
                    ia3.b d2 = ia3.d();
                    d2.n(false);
                    d2.o();
                    na3.o(b, this.a, this.b);
                    return;
                }
                ia3.b d3 = ia3.d();
                d3.n(true);
                d3.o();
                this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(0, "success").toString());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements cm1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j a;

        public i(ha3 ha3Var, j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ha3Var, jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jVar;
        }

        @Override // com.baidu.tieba.cm1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != 0) {
                    this.a.a(false, i);
                } else {
                    this.a.a(true, i);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ha3(m63 m63Var) {
        super(m63Var, "/swanAPI/multiAuthorize");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {m63Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final boolean A(List<pa3> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            if (list != null && list.size() > 0) {
                for (pa3 pa3Var : list) {
                    if (pa3Var != null && C(pa3Var)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean D(List<pa3> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            if (list == null || list.size() <= 0) {
                return false;
            }
            boolean z = true;
            for (pa3 pa3Var : list) {
                if (pa3Var != null && !E(pa3Var)) {
                    z = false;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean F(List<pa3> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            if (list == null || list.size() <= 0) {
                return false;
            }
            for (pa3 pa3Var : list) {
                if (pa3Var != null && C(pa3Var)) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void H(List<pa3> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, list, activity, callbackHandler, str) == null) {
            if (F(list)) {
                ia3.d().i(true);
                J(activity, list, callbackHandler, str);
                return;
            }
            z(new e(this, list, activity, callbackHandler, str));
        }
    }

    public final void K(List<pa3> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, list, activity, callbackHandler, str) == null) {
            wo2.Z().d(new g(this, list, activity, callbackHandler, str));
        }
    }

    public final void G(List<pa3> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str, @NonNull p53 p53Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048582, this, list, activity, callbackHandler, str, p53Var) == null) {
            if (D(list)) {
                ia3.d().i(true);
                J(activity, list, callbackHandler, str);
                return;
            }
            L(p53Var, activity, new d(this, list, activity, callbackHandler, str));
        }
    }

    @AnyThread
    public final void x(@NonNull Activity activity, @NonNull p53 p53Var, @NonNull CallbackHandler callbackHandler, @NonNull JSONArray jSONArray, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048595, this, activity, p53Var, callbackHandler, jSONArray, str) == null) {
            lx2.g().z(new b(this, callbackHandler, str, jSONArray, p53Var, activity));
        }
    }

    public final boolean B(pa3 pa3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pa3Var)) == null) {
            if (!TextUtils.equals(pa3Var.b, "mapp_location") && !TextUtils.equals(pa3Var.b, "mapp_images") && !TextUtils.equals(pa3Var.b, PermissionProxy.SCOPE_ID_RECORD) && !TextUtils.equals(pa3Var.b, PermissionProxy.SCOPE_ID_CAMERA) && !TextUtils.equals(pa3Var.b, "ppcert") && !TextUtils.equals(pa3Var.b, "mapp_i_face_verify") && !TextUtils.equals(pa3Var.b, "snsapi_userinfo") && !TextUtils.equals(pa3Var.b, "mapp_choose_address") && !TextUtils.equals(pa3Var.b, "mobile") && !TextUtils.equals(pa3Var.b, "mapp_choose_invoice") && !TextUtils.equals(pa3Var.b, "mapp_i_read_contacts") && !TextUtils.equals(pa3Var.b, "scope_calendar")) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean C(pa3 pa3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pa3Var)) == null) {
            if (!TextUtils.equals(pa3Var.b, "ppcert") && !TextUtils.equals(pa3Var.b, "mapp_i_face_verify")) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void M(ik3<String> ik3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, ik3Var) == null) {
            wo2.Z().b(false, ik3Var);
        }
    }

    public final void z(ik3<String> ik3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, ik3Var) == null) {
            wo2.Z().c(wo2.c(), ik3Var);
        }
    }

    public final boolean E(pa3 pa3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, pa3Var)) == null) {
            if (!TextUtils.equals(pa3Var.b, "mapp_location") && !TextUtils.equals(pa3Var.b, "mapp_images") && !TextUtils.equals(pa3Var.b, PermissionProxy.SCOPE_ID_RECORD) && !TextUtils.equals(pa3Var.b, PermissionProxy.SCOPE_ID_CAMERA) && !TextUtils.equals(pa3Var.b, "scope_calendar")) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void I(boolean z, List<pa3> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), list, activity, callbackHandler, str}) == null) {
            if (z) {
                ia3.b d2 = ia3.d();
                d2.l(true);
                d2.i(true);
                p22.i("MultiAuthorize", "onCallback: real name success");
                J(activity, list, callbackHandler, str);
                return;
            }
            ia3.d().l(false);
            p22.i("MultiAuthorize", "onCallback: real name fail");
            M(new f(this, activity, list, callbackHandler, str));
        }
    }

    public final void J(@NonNull Activity activity, @NonNull List<pa3> list, @NonNull CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048585, this, activity, list, callbackHandler, str) == null) {
            int size = list.size();
            String[] strArr = new String[size];
            for (int i2 = 0; i2 < size; i2++) {
                strArr[i2] = list.get(i2).b;
            }
            ua3 d2 = o53.K().x().a().b().d(activity, false, true, strArr, null, true);
            d2.p(new h(this, callbackHandler, str));
            d2.a();
        }
    }

    public final void L(@NonNull p53 p53Var, @NonNull Activity activity, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, p53Var, activity, jVar) == null) {
            v(p53Var, activity, jVar);
        }
    }

    public final void v(@NonNull p53 p53Var, @NonNull Activity activity, @NonNull j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048593, this, p53Var, activity, jVar) == null) {
            p53Var.N().f(activity, null, new i(this, jVar));
        }
    }

    public final void N(@NonNull Activity activity, pa3 pa3Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, activity, pa3Var, str) == null) {
            String a0 = o53.K().q().a0();
            boolean equals = TextUtils.equals(str, "1");
            if (A(pa3Var.s)) {
                if (equals) {
                    pa3Var.r = activity.getString(R.string.obfuscated_res_0x7f0f1575) + a0 + activity.getString(R.string.obfuscated_res_0x7f0f1574);
                    return;
                }
                pa3Var.r = activity.getString(R.string.obfuscated_res_0x7f0f1577) + a0 + activity.getString(R.string.obfuscated_res_0x7f0f1574);
                return;
            }
            pa3Var.r = activity.getString(R.string.obfuscated_res_0x7f0f1575) + a0 + activity.getString(R.string.obfuscated_res_0x7f0f1574);
        }
    }

    public final void O(@NonNull Activity activity, pa3 pa3Var, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, activity, pa3Var, bool) == null) {
            String a0 = o53.K().q().a0();
            boolean D = D(pa3Var.s);
            boolean A = A(pa3Var.s);
            if (!bool.booleanValue() && !D) {
                pa3Var.r = activity.getString(R.string.obfuscated_res_0x7f0f1576) + a0 + activity.getString(R.string.obfuscated_res_0x7f0f1574);
            } else if (A) {
                pa3Var.r = activity.getString(R.string.obfuscated_res_0x7f0f1577) + a0 + activity.getString(R.string.obfuscated_res_0x7f0f1574);
            } else {
                pa3Var.r = activity.getString(R.string.obfuscated_res_0x7f0f1575) + a0 + activity.getString(R.string.obfuscated_res_0x7f0f1574);
            }
        }
    }

    public final void P(pa3 pa3Var, List<pa3> list, boolean z, @NonNull Activity activity, @NonNull p53 p53Var, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{pa3Var, list, Boolean.valueOf(z), activity, p53Var, callbackHandler, str}) == null) {
            na3.u(activity, p53Var, pa3Var, new JSONObject(), new c(this, callbackHandler, str, z, p53Var, activity, list));
        }
    }

    @Override // com.baidu.tieba.m73
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, p53 p53Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048592, this, context, unitedSchemeEntity, callbackHandler, p53Var)) == null) {
            if (p53Var != null && (context instanceof Activity)) {
                JSONObject a2 = m73.a(unitedSchemeEntity, "params");
                if (a2 != null && a2.has("scopes")) {
                    JSONArray optJSONArray = a2.optJSONArray("scopes");
                    if (optJSONArray != null && optJSONArray.length() >= 2 && optJSONArray.length() <= 4) {
                        ia3.d().n(true);
                        p53Var.f0().g(context, "scope_multi_authorize", new a(this, callbackHandler, a2.optString("cb"), context, p53Var, optJSONArray));
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                        return true;
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(100203, "scopes count error"));
                    ia3.b d2 = ia3.d();
                    d2.n(false);
                    d2.o();
                    return false;
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(100203, "illegal parameter"));
                ia3.b d3 = ia3.d();
                d3.n(false);
                d3.o();
                return false;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(401, "runtime parameter error");
            ia3.b d4 = ia3.d();
            d4.n(false);
            d4.o();
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final List<pa3> w(Map<String, pa3> map, @NonNull JSONArray jSONArray, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048594, this, map, jSONArray, callbackHandler, str)) == null) {
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            boolean z = true;
            for (int i2 = 0; i2 < length; i2++) {
                String c2 = pa3.c(jSONArray.optString(i2));
                if (!TextUtils.isEmpty(c2)) {
                    pa3 pa3Var = map.get(c2);
                    if (map.containsKey(c2) && pa3Var != null && B(pa3Var)) {
                        if (pa3Var.d) {
                            na3.o(10005, callbackHandler, str);
                            ia3.b d2 = ia3.d();
                            d2.n(false);
                            d2.o();
                            ic3.r(10005, pa3Var);
                            return null;
                        }
                        if (!arrayList.contains(pa3Var) && !pa3Var.a()) {
                            arrayList.add(pa3Var);
                        }
                        if (!pa3Var.a()) {
                            z = false;
                        }
                    } else {
                        na3.o(10005, callbackHandler, str);
                        ia3.b d3 = ia3.d();
                        d3.n(false);
                        d3.o();
                        ic3.r(10005, pa3Var);
                        return null;
                    }
                }
            }
            if (z) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                ia3.b d4 = ia3.d();
                d4.i(true);
                d4.n(true);
                d4.o();
                return null;
            }
            p22.i("MultiAuthorize", "cb=" + str + ", gain=false , scopes=" + arrayList);
            if (arrayList.isEmpty()) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(202, "scopes invalid").toString());
                ia3.b d5 = ia3.d();
                d5.n(true);
                d5.o();
                return null;
            }
            return arrayList;
        }
        return (List) invokeLLLL.objValue;
    }

    public final pa3 y(Map<String, pa3> map, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048596, this, map, callbackHandler, str)) == null) {
            pa3 pa3Var = map.get("scope_multi_authorize");
            if (pa3Var == null) {
                na3.o(10001, callbackHandler, str);
                ic3.r(10001, null);
                return null;
            } else if (pa3Var.d) {
                na3.o(10005, callbackHandler, str);
                ic3.r(10005, pa3Var);
                return null;
            } else {
                return pa3Var;
            }
        }
        return (pa3) invokeLLL.objValue;
    }
}
