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
import com.baidu.tieba.e83;
import com.baidu.tieba.q83;
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
/* loaded from: classes3.dex */
public class d83 extends i53 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public class a implements ei3<o83<q83.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ l33 d;
        public final /* synthetic */ JSONArray e;
        public final /* synthetic */ d83 f;

        public a(d83 d83Var, CallbackHandler callbackHandler, String str, Context context, l33 l33Var, JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d83Var, callbackHandler, str, context, l33Var, jSONArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = d83Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = context;
            this.d = l33Var;
            this.e = jSONArray;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ei3
        /* renamed from: b */
        public void a(o83<q83.e> o83Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o83Var) == null) {
                if (j83.h(o83Var)) {
                    this.f.x((Activity) this.c, this.d, this.a, this.e, this.b);
                    return;
                }
                e83.b d = e83.d();
                d.n(false);
                d.o();
                j83.q(o83Var, this.a, this.b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements iv2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ JSONArray c;
        public final /* synthetic */ l33 d;
        public final /* synthetic */ Activity e;
        public final /* synthetic */ d83 f;

        /* loaded from: classes3.dex */
        public class a implements ei3<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l83 a;
            public final /* synthetic */ List b;
            public final /* synthetic */ b c;

            /* renamed from: com.baidu.tieba.d83$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class RunnableC0220a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Boolean a;
                public final /* synthetic */ a b;

                public RunnableC0220a(a aVar, Boolean bool) {
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
                        d83 d83Var = aVar.c.f;
                        l83 l83Var = aVar.a;
                        List list = aVar.b;
                        boolean booleanValue = this.a.booleanValue();
                        b bVar = this.b.c;
                        d83Var.P(l83Var, list, booleanValue, bVar.e, bVar.d, bVar.a, bVar.b);
                    }
                }
            }

            public a(b bVar, l83 l83Var, List list) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, l83Var, list};
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
                this.a = l83Var;
                this.b = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ei3
            /* renamed from: b */
            public void a(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                    b bVar = this.c;
                    bVar.f.O(bVar.e, this.a, bool);
                    fh3.a0(new RunnableC0220a(this, bool));
                }
            }
        }

        /* renamed from: com.baidu.tieba.d83$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0221b implements ei3<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l83 a;
            public final /* synthetic */ List b;
            public final /* synthetic */ b c;

            /* renamed from: com.baidu.tieba.d83$b$b$a */
            /* loaded from: classes3.dex */
            public class a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ C0221b a;

                public a(C0221b c0221b) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0221b};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = c0221b;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        C0221b c0221b = this.a;
                        b bVar = c0221b.c;
                        bVar.f.P(c0221b.a, c0221b.b, false, bVar.e, bVar.d, bVar.a, bVar.b);
                    }
                }
            }

            public C0221b(b bVar, l83 l83Var, List list) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, l83Var, list};
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
                this.a = l83Var;
                this.b = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ei3
            /* renamed from: b */
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                    b bVar = this.c;
                    bVar.f.N(bVar.e, this.a, str);
                    fh3.a0(new a(this));
                }
            }
        }

        public b(d83 d83Var, CallbackHandler callbackHandler, String str, JSONArray jSONArray, l33 l33Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d83Var, callbackHandler, str, jSONArray, l33Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = d83Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = jSONArray;
            this.d = l33Var;
            this.e = activity;
        }

        @Override // com.baidu.tieba.iv2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Map<String, l83> g = jv2.g(true);
                l83 y = this.f.y(g, this.a, this.b);
                if (y != null) {
                    List<l83> w = this.f.w(g, this.c, this.a, this.b);
                    if (w == null) {
                        return;
                    }
                    y.i(w);
                    if (this.d.N().e(this.e)) {
                        this.f.z(new C0221b(this, y, w));
                        return;
                    } else {
                        sm2.Z().a(this.e, new a(this, y, w));
                        return;
                    }
                }
                e83.b d = e83.d();
                d.n(false);
                d.o();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements g83 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ l33 d;
        public final /* synthetic */ Activity e;
        public final /* synthetic */ List f;
        public final /* synthetic */ d83 g;

        public c(d83 d83Var, CallbackHandler callbackHandler, String str, boolean z, l33 l33Var, Activity activity, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d83Var, callbackHandler, str, Boolean.valueOf(z), l33Var, activity, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = d83Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = z;
            this.d = l33Var;
            this.e = activity;
            this.f = list;
        }

        @Override // com.baidu.tieba.g83
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                l02.i("MultiAuthorize", "showAuthDialog " + z);
                if (!z) {
                    e83.b d = e83.d();
                    d.i(false);
                    d.h(false);
                    d.o();
                    j83.o(10003, this.a, this.b);
                    return;
                }
                e83.b d2 = e83.d();
                d2.i(true);
                d2.h(true);
                boolean z2 = this.c;
                if (this.d.N().e(this.e)) {
                    e83.d().m(true);
                    this.g.H(this.f, this.e, this.a, this.b);
                } else if (z2) {
                    this.g.K(this.f, this.e, this.a, this.b);
                } else {
                    e83.d().m(false);
                    this.g.G(this.f, this.e, this.a, this.b, this.d);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ String d;
        public final /* synthetic */ d83 e;

        public d(d83 d83Var, List list, Activity activity, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d83Var, list, activity, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = d83Var;
            this.a = list;
            this.b = activity;
            this.c = callbackHandler;
            this.d = str;
        }

        @Override // com.baidu.tieba.d83.j
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                l02.i("MultiAuthorize", "login result:" + i);
                if (z) {
                    e83.d().k(true);
                    this.e.H(this.a, this.b, this.c, this.d);
                    return;
                }
                e83.b d = e83.d();
                d.k(false);
                d.n(true);
                d.i(false);
                d.o();
                j83.o(10004, this.c, this.d);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements ei3<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ String d;
        public final /* synthetic */ d83 e;

        public e(d83 d83Var, List list, Activity activity, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d83Var, list, activity, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = d83Var;
            this.a = list;
            this.b = activity;
            this.c = callbackHandler;
            this.d = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ei3
        /* renamed from: b */
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.e.I(TextUtils.equals(str, "1"), this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements ei3<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ List b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ String d;
        public final /* synthetic */ d83 e;

        public f(d83 d83Var, Activity activity, List list, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d83Var, activity, list, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = d83Var;
            this.a = activity;
            this.b = list;
            this.c = callbackHandler;
            this.d = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ei3
        /* renamed from: b */
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (!TextUtils.isEmpty(str)) {
                    e83.b d = e83.d();
                    d.j(true);
                    d.i(true);
                    this.e.J(this.a, this.b, this.c, this.d);
                    return;
                }
                e83.b d2 = e83.d();
                d2.j(false);
                d2.i(false);
                d2.o();
                j83.o(10003, this.c, this.d);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements ei3<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ String d;
        public final /* synthetic */ d83 e;

        public g(d83 d83Var, List list, Activity activity, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d83Var, list, activity, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = d83Var;
            this.a = list;
            this.b = activity;
            this.c = callbackHandler;
            this.d = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ei3
        /* renamed from: b */
        public void a(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, num) == null) {
                if (num.intValue() == 0) {
                    e83.d().m(true);
                    this.e.H(this.a, this.b, this.c, this.d);
                    return;
                }
                e83.b d = e83.d();
                d.m(false);
                d.n(false);
                d.o();
                j83.o(10003, this.c, this.d);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements ei3<o83<q83.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;

        public h(d83 d83Var, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d83Var, callbackHandler, str};
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
        @Override // com.baidu.tieba.ei3
        /* renamed from: b */
        public void a(o83<q83.e> o83Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o83Var) == null) {
                if (o83Var == null) {
                    j83.o(10001, this.a, this.b);
                    e83.b d = e83.d();
                    d.n(false);
                    d.o();
                    ea3.r(10001, null);
                    return;
                }
                int b = o83Var.b();
                l02.o("MultiAuthorize", "requestAuthorize " + o83Var.a() + ",  code=" + b + ", data=" + o83Var.a);
                if (b != 0) {
                    e83.b d2 = e83.d();
                    d2.n(false);
                    d2.o();
                    j83.o(b, this.a, this.b);
                    return;
                }
                e83.b d3 = e83.d();
                d3.n(true);
                d3.o();
                this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(0, "success").toString());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements xj1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j a;

        public i(d83 d83Var, j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d83Var, jVar};
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

        @Override // com.baidu.tieba.xj1
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

    /* loaded from: classes3.dex */
    public interface j {
        void a(boolean z, int i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d83(i43 i43Var) {
        super(i43Var, "/swanAPI/multiAuthorize");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {i43Var};
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

    public final boolean A(List<l83> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            if (list != null && list.size() > 0) {
                for (l83 l83Var : list) {
                    if (l83Var != null && C(l83Var)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean B(l83 l83Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l83Var)) == null) ? TextUtils.equals(l83Var.b, "mapp_location") || TextUtils.equals(l83Var.b, "mapp_images") || TextUtils.equals(l83Var.b, PermissionProxy.SCOPE_ID_RECORD) || TextUtils.equals(l83Var.b, PermissionProxy.SCOPE_ID_CAMERA) || TextUtils.equals(l83Var.b, "ppcert") || TextUtils.equals(l83Var.b, "mapp_i_face_verify") || TextUtils.equals(l83Var.b, "snsapi_userinfo") || TextUtils.equals(l83Var.b, "mapp_choose_address") || TextUtils.equals(l83Var.b, "mobile") || TextUtils.equals(l83Var.b, "mapp_choose_invoice") || TextUtils.equals(l83Var.b, "mapp_i_read_contacts") || TextUtils.equals(l83Var.b, "scope_calendar") : invokeL.booleanValue;
    }

    public final boolean C(l83 l83Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, l83Var)) == null) ? TextUtils.equals(l83Var.b, "ppcert") || TextUtils.equals(l83Var.b, "mapp_i_face_verify") : invokeL.booleanValue;
    }

    public final boolean D(List<l83> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            if (list == null || list.size() <= 0) {
                return false;
            }
            boolean z = true;
            for (l83 l83Var : list) {
                if (l83Var != null && !E(l83Var)) {
                    z = false;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean E(l83 l83Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, l83Var)) == null) ? TextUtils.equals(l83Var.b, "mapp_location") || TextUtils.equals(l83Var.b, "mapp_images") || TextUtils.equals(l83Var.b, PermissionProxy.SCOPE_ID_RECORD) || TextUtils.equals(l83Var.b, PermissionProxy.SCOPE_ID_CAMERA) || TextUtils.equals(l83Var.b, "scope_calendar") : invokeL.booleanValue;
    }

    public final boolean F(List<l83> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            if (list == null || list.size() <= 0) {
                return false;
            }
            for (l83 l83Var : list) {
                if (l83Var != null && C(l83Var)) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void G(List<l83> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str, @NonNull l33 l33Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048582, this, list, activity, callbackHandler, str, l33Var) == null) {
            if (D(list)) {
                e83.d().i(true);
                J(activity, list, callbackHandler, str);
                return;
            }
            L(l33Var, activity, new d(this, list, activity, callbackHandler, str));
        }
    }

    public final void H(List<l83> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, list, activity, callbackHandler, str) == null) {
            if (F(list)) {
                e83.d().i(true);
                J(activity, list, callbackHandler, str);
                return;
            }
            z(new e(this, list, activity, callbackHandler, str));
        }
    }

    public final void I(boolean z, List<l83> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), list, activity, callbackHandler, str}) == null) {
            if (z) {
                e83.b d2 = e83.d();
                d2.l(true);
                d2.i(true);
                l02.i("MultiAuthorize", "onCallback: real name success");
                J(activity, list, callbackHandler, str);
                return;
            }
            e83.d().l(false);
            l02.i("MultiAuthorize", "onCallback: real name fail");
            M(new f(this, activity, list, callbackHandler, str));
        }
    }

    public final void J(@NonNull Activity activity, @NonNull List<l83> list, @NonNull CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048585, this, activity, list, callbackHandler, str) == null) {
            int size = list.size();
            String[] strArr = new String[size];
            for (int i2 = 0; i2 < size; i2++) {
                strArr[i2] = list.get(i2).b;
            }
            q83 d2 = k33.K().x().a().b().d(activity, false, true, strArr, null, true);
            d2.o(new h(this, callbackHandler, str));
            d2.call();
        }
    }

    public final void K(List<l83> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, list, activity, callbackHandler, str) == null) {
            sm2.Z().d(new g(this, list, activity, callbackHandler, str));
        }
    }

    public final void L(@NonNull l33 l33Var, @NonNull Activity activity, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, l33Var, activity, jVar) == null) {
            v(l33Var, activity, jVar);
        }
    }

    public final void M(ei3<String> ei3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, ei3Var) == null) {
            sm2.Z().b(false, ei3Var);
        }
    }

    public final void N(@NonNull Activity activity, l83 l83Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, activity, l83Var, str) == null) {
            String Z = k33.K().q().Z();
            boolean equals = TextUtils.equals(str, "1");
            if (!A(l83Var.s)) {
                l83Var.r = activity.getString(R.string.obfuscated_res_0x7f0f12f4) + Z + activity.getString(R.string.obfuscated_res_0x7f0f12f3);
            } else if (equals) {
                l83Var.r = activity.getString(R.string.obfuscated_res_0x7f0f12f4) + Z + activity.getString(R.string.obfuscated_res_0x7f0f12f3);
            } else {
                l83Var.r = activity.getString(R.string.obfuscated_res_0x7f0f12f6) + Z + activity.getString(R.string.obfuscated_res_0x7f0f12f3);
            }
        }
    }

    public final void O(@NonNull Activity activity, l83 l83Var, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, activity, l83Var, bool) == null) {
            String Z = k33.K().q().Z();
            boolean D = D(l83Var.s);
            boolean A = A(l83Var.s);
            if (!bool.booleanValue() && !D) {
                l83Var.r = activity.getString(R.string.obfuscated_res_0x7f0f12f5) + Z + activity.getString(R.string.obfuscated_res_0x7f0f12f3);
            } else if (A) {
                l83Var.r = activity.getString(R.string.obfuscated_res_0x7f0f12f6) + Z + activity.getString(R.string.obfuscated_res_0x7f0f12f3);
            } else {
                l83Var.r = activity.getString(R.string.obfuscated_res_0x7f0f12f4) + Z + activity.getString(R.string.obfuscated_res_0x7f0f12f3);
            }
        }
    }

    public final void P(l83 l83Var, List<l83> list, boolean z, @NonNull Activity activity, @NonNull l33 l33Var, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{l83Var, list, Boolean.valueOf(z), activity, l33Var, callbackHandler, str}) == null) {
            j83.u(activity, l33Var, l83Var, new JSONObject(), new c(this, callbackHandler, str, z, l33Var, activity, list));
        }
    }

    @Override // com.baidu.tieba.i53
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, l33 l33Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048592, this, context, unitedSchemeEntity, callbackHandler, l33Var)) == null) {
            if (l33Var != null && (context instanceof Activity)) {
                JSONObject a2 = i53.a(unitedSchemeEntity, "params");
                if (a2 != null && a2.has("scopes")) {
                    JSONArray optJSONArray = a2.optJSONArray("scopes");
                    if (optJSONArray != null && optJSONArray.length() >= 2 && optJSONArray.length() <= 4) {
                        e83.d().n(true);
                        l33Var.e0().g(context, "scope_multi_authorize", new a(this, callbackHandler, a2.optString("cb"), context, l33Var, optJSONArray));
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                        return true;
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(100203, "scopes count error"));
                    e83.b d2 = e83.d();
                    d2.n(false);
                    d2.o();
                    return false;
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(100203, "illegal parameter"));
                e83.b d3 = e83.d();
                d3.n(false);
                d3.o();
                return false;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(401, "runtime parameter error");
            e83.b d4 = e83.d();
            d4.n(false);
            d4.o();
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final void v(@NonNull l33 l33Var, @NonNull Activity activity, @NonNull j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048593, this, l33Var, activity, jVar) == null) {
            l33Var.N().f(activity, null, new i(this, jVar));
        }
    }

    public final List<l83> w(Map<String, l83> map, @NonNull JSONArray jSONArray, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048594, this, map, jSONArray, callbackHandler, str)) == null) {
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            boolean z = true;
            for (int i2 = 0; i2 < length; i2++) {
                String c2 = l83.c(jSONArray.optString(i2));
                if (!TextUtils.isEmpty(c2)) {
                    l83 l83Var = map.get(c2);
                    if (map.containsKey(c2) && l83Var != null && B(l83Var)) {
                        if (l83Var.d) {
                            j83.o(10005, callbackHandler, str);
                            e83.b d2 = e83.d();
                            d2.n(false);
                            d2.o();
                            ea3.r(10005, l83Var);
                            return null;
                        }
                        if (!arrayList.contains(l83Var) && !l83Var.a()) {
                            arrayList.add(l83Var);
                        }
                        if (!l83Var.a()) {
                            z = false;
                        }
                    } else {
                        j83.o(10005, callbackHandler, str);
                        e83.b d3 = e83.d();
                        d3.n(false);
                        d3.o();
                        ea3.r(10005, l83Var);
                        return null;
                    }
                }
            }
            if (z) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                e83.b d4 = e83.d();
                d4.i(true);
                d4.n(true);
                d4.o();
                return null;
            }
            l02.i("MultiAuthorize", "cb=" + str + ", gain=false , scopes=" + arrayList);
            if (arrayList.isEmpty()) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(202, "scopes invalid").toString());
                e83.b d5 = e83.d();
                d5.n(true);
                d5.o();
                return null;
            }
            return arrayList;
        }
        return (List) invokeLLLL.objValue;
    }

    @AnyThread
    public final void x(@NonNull Activity activity, @NonNull l33 l33Var, @NonNull CallbackHandler callbackHandler, @NonNull JSONArray jSONArray, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048595, this, activity, l33Var, callbackHandler, jSONArray, str) == null) {
            hv2.g().z(new b(this, callbackHandler, str, jSONArray, l33Var, activity));
        }
    }

    public final l83 y(Map<String, l83> map, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048596, this, map, callbackHandler, str)) == null) {
            l83 l83Var = map.get("scope_multi_authorize");
            if (l83Var == null) {
                j83.o(10001, callbackHandler, str);
                ea3.r(10001, null);
                return null;
            } else if (l83Var.d) {
                j83.o(10005, callbackHandler, str);
                ea3.r(10005, l83Var);
                return null;
            } else {
                return l83Var;
            }
        }
        return (l83) invokeLLL.objValue;
    }

    public final void z(ei3<String> ei3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, ei3Var) == null) {
            sm2.Z().c(sm2.c(), ei3Var);
        }
    }
}
