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
import com.baidu.tieba.db3;
import com.baidu.tieba.pb3;
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
/* loaded from: classes5.dex */
public class cb3 extends h83 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public interface j {
        void a(boolean z, int i);
    }

    /* loaded from: classes5.dex */
    public class b implements hy2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ JSONArray c;
        public final /* synthetic */ k63 d;
        public final /* synthetic */ Activity e;
        public final /* synthetic */ cb3 f;

        /* loaded from: classes5.dex */
        public class a implements dl3<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ kb3 a;
            public final /* synthetic */ List b;
            public final /* synthetic */ b c;

            /* renamed from: com.baidu.tieba.cb3$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class RunnableC0240a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Boolean a;
                public final /* synthetic */ a b;

                public RunnableC0240a(a aVar, Boolean bool) {
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
                        cb3 cb3Var = aVar.c.f;
                        kb3 kb3Var = aVar.a;
                        List list = aVar.b;
                        boolean booleanValue = this.a.booleanValue();
                        b bVar = this.b.c;
                        cb3Var.P(kb3Var, list, booleanValue, bVar.e, bVar.d, bVar.a, bVar.b);
                    }
                }
            }

            public a(b bVar, kb3 kb3Var, List list) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, kb3Var, list};
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
                this.a = kb3Var;
                this.b = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.dl3
            /* renamed from: b */
            public void a(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                    b bVar = this.c;
                    bVar.f.O(bVar.e, this.a, bool);
                    ek3.a0(new RunnableC0240a(this, bool));
                }
            }
        }

        /* renamed from: com.baidu.tieba.cb3$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0241b implements dl3<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ kb3 a;
            public final /* synthetic */ List b;
            public final /* synthetic */ b c;

            /* renamed from: com.baidu.tieba.cb3$b$b$a */
            /* loaded from: classes5.dex */
            public class a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ C0241b a;

                public a(C0241b c0241b) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0241b};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = c0241b;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        C0241b c0241b = this.a;
                        b bVar = c0241b.c;
                        bVar.f.P(c0241b.a, c0241b.b, false, bVar.e, bVar.d, bVar.a, bVar.b);
                    }
                }
            }

            public C0241b(b bVar, kb3 kb3Var, List list) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, kb3Var, list};
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
                this.a = kb3Var;
                this.b = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.dl3
            /* renamed from: b */
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                    b bVar = this.c;
                    bVar.f.N(bVar.e, this.a, str);
                    ek3.a0(new a(this));
                }
            }
        }

        public b(cb3 cb3Var, CallbackHandler callbackHandler, String str, JSONArray jSONArray, k63 k63Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cb3Var, callbackHandler, str, jSONArray, k63Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = cb3Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = jSONArray;
            this.d = k63Var;
            this.e = activity;
        }

        @Override // com.baidu.tieba.hy2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Map<String, kb3> g = iy2.g(true);
                kb3 y = this.f.y(g, this.a, this.b);
                if (y == null) {
                    db3.b d = db3.d();
                    d.n(false);
                    d.o();
                    return;
                }
                List<kb3> w = this.f.w(g, this.c, this.a, this.b);
                if (w == null) {
                    return;
                }
                y.i(w);
                if (!this.d.N().e(this.e)) {
                    rp2.Z().a(this.e, new a(this, y, w));
                } else {
                    this.f.z(new C0241b(this, y, w));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements dl3<nb3<pb3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ k63 d;
        public final /* synthetic */ JSONArray e;
        public final /* synthetic */ cb3 f;

        public a(cb3 cb3Var, CallbackHandler callbackHandler, String str, Context context, k63 k63Var, JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cb3Var, callbackHandler, str, context, k63Var, jSONArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = cb3Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = context;
            this.d = k63Var;
            this.e = jSONArray;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(nb3<pb3.e> nb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nb3Var) == null) {
                if (ib3.h(nb3Var)) {
                    this.f.x((Activity) this.c, this.d, this.a, this.e, this.b);
                    return;
                }
                db3.b d = db3.d();
                d.n(false);
                d.o();
                ib3.q(nb3Var, this.a, this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements fb3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ k63 d;
        public final /* synthetic */ Activity e;
        public final /* synthetic */ List f;
        public final /* synthetic */ cb3 g;

        public c(cb3 cb3Var, CallbackHandler callbackHandler, String str, boolean z, k63 k63Var, Activity activity, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cb3Var, callbackHandler, str, Boolean.valueOf(z), k63Var, activity, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = cb3Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = z;
            this.d = k63Var;
            this.e = activity;
            this.f = list;
        }

        @Override // com.baidu.tieba.fb3
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                k32.i("MultiAuthorize", "showAuthDialog " + z);
                if (!z) {
                    db3.b d = db3.d();
                    d.i(false);
                    d.h(false);
                    d.o();
                    ib3.o(10003, this.a, this.b);
                    return;
                }
                db3.b d2 = db3.d();
                d2.i(true);
                d2.h(true);
                boolean z2 = this.c;
                if (this.d.N().e(this.e)) {
                    db3.d().m(true);
                    this.g.H(this.f, this.e, this.a, this.b);
                } else if (!z2) {
                    db3.d().m(false);
                    this.g.G(this.f, this.e, this.a, this.b, this.d);
                } else {
                    this.g.K(this.f, this.e, this.a, this.b);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ String d;
        public final /* synthetic */ cb3 e;

        public d(cb3 cb3Var, List list, Activity activity, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cb3Var, list, activity, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = cb3Var;
            this.a = list;
            this.b = activity;
            this.c = callbackHandler;
            this.d = str;
        }

        @Override // com.baidu.tieba.cb3.j
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                k32.i("MultiAuthorize", "login result:" + i);
                if (z) {
                    db3.d().k(true);
                    this.e.H(this.a, this.b, this.c, this.d);
                    return;
                }
                db3.b d = db3.d();
                d.k(false);
                d.n(true);
                d.i(false);
                d.o();
                ib3.o(10004, this.c, this.d);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements dl3<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ String d;
        public final /* synthetic */ cb3 e;

        public e(cb3 cb3Var, List list, Activity activity, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cb3Var, list, activity, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = cb3Var;
            this.a = list;
            this.b = activity;
            this.c = callbackHandler;
            this.d = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.e.I(TextUtils.equals(str, "1"), this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements dl3<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ List b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ String d;
        public final /* synthetic */ cb3 e;

        public f(cb3 cb3Var, Activity activity, List list, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cb3Var, activity, list, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = cb3Var;
            this.a = activity;
            this.b = list;
            this.c = callbackHandler;
            this.d = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (!TextUtils.isEmpty(str)) {
                    db3.b d = db3.d();
                    d.j(true);
                    d.i(true);
                    this.e.J(this.a, this.b, this.c, this.d);
                    return;
                }
                db3.b d2 = db3.d();
                d2.j(false);
                d2.i(false);
                d2.o();
                ib3.o(10003, this.c, this.d);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements dl3<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ String d;
        public final /* synthetic */ cb3 e;

        public g(cb3 cb3Var, List list, Activity activity, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cb3Var, list, activity, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = cb3Var;
            this.a = list;
            this.b = activity;
            this.c = callbackHandler;
            this.d = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, num) == null) {
                if (num.intValue() == 0) {
                    db3.d().m(true);
                    this.e.H(this.a, this.b, this.c, this.d);
                    return;
                }
                db3.b d = db3.d();
                d.m(false);
                d.n(false);
                d.o();
                ib3.o(10003, this.c, this.d);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements dl3<nb3<pb3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;

        public h(cb3 cb3Var, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cb3Var, callbackHandler, str};
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
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(nb3<pb3.e> nb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nb3Var) == null) {
                if (nb3Var == null) {
                    ib3.o(10001, this.a, this.b);
                    db3.b d = db3.d();
                    d.n(false);
                    d.o();
                    dd3.r(10001, null);
                    return;
                }
                int b = nb3Var.b();
                k32.o("MultiAuthorize", "requestAuthorize " + nb3Var.a() + ",  code=" + b + ", data=" + nb3Var.a);
                if (b != 0) {
                    db3.b d2 = db3.d();
                    d2.n(false);
                    d2.o();
                    ib3.o(b, this.a, this.b);
                    return;
                }
                db3.b d3 = db3.d();
                d3.n(true);
                d3.o();
                this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(0, "success").toString());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements xm1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j a;

        public i(cb3 cb3Var, j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cb3Var, jVar};
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

        @Override // com.baidu.tieba.xm1
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
    public cb3(h73 h73Var) {
        super(h73Var, "/swanAPI/multiAuthorize");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {h73Var};
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

    public final boolean A(List<kb3> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            if (list != null && list.size() > 0) {
                for (kb3 kb3Var : list) {
                    if (kb3Var != null && C(kb3Var)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean D(List<kb3> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            if (list == null || list.size() <= 0) {
                return false;
            }
            boolean z = true;
            for (kb3 kb3Var : list) {
                if (kb3Var != null && !E(kb3Var)) {
                    z = false;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean F(List<kb3> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            if (list == null || list.size() <= 0) {
                return false;
            }
            for (kb3 kb3Var : list) {
                if (kb3Var != null && C(kb3Var)) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void H(List<kb3> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, list, activity, callbackHandler, str) == null) {
            if (F(list)) {
                db3.d().i(true);
                J(activity, list, callbackHandler, str);
                return;
            }
            z(new e(this, list, activity, callbackHandler, str));
        }
    }

    public final void K(List<kb3> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, list, activity, callbackHandler, str) == null) {
            rp2.Z().d(new g(this, list, activity, callbackHandler, str));
        }
    }

    public final void G(List<kb3> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str, @NonNull k63 k63Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048582, this, list, activity, callbackHandler, str, k63Var) == null) {
            if (D(list)) {
                db3.d().i(true);
                J(activity, list, callbackHandler, str);
                return;
            }
            L(k63Var, activity, new d(this, list, activity, callbackHandler, str));
        }
    }

    @AnyThread
    public final void x(@NonNull Activity activity, @NonNull k63 k63Var, @NonNull CallbackHandler callbackHandler, @NonNull JSONArray jSONArray, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048595, this, activity, k63Var, callbackHandler, jSONArray, str) == null) {
            gy2.g().z(new b(this, callbackHandler, str, jSONArray, k63Var, activity));
        }
    }

    public final boolean B(kb3 kb3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kb3Var)) == null) {
            if (!TextUtils.equals(kb3Var.b, "mapp_location") && !TextUtils.equals(kb3Var.b, "mapp_images") && !TextUtils.equals(kb3Var.b, PermissionProxy.SCOPE_ID_RECORD) && !TextUtils.equals(kb3Var.b, PermissionProxy.SCOPE_ID_CAMERA) && !TextUtils.equals(kb3Var.b, "ppcert") && !TextUtils.equals(kb3Var.b, "mapp_i_face_verify") && !TextUtils.equals(kb3Var.b, "snsapi_userinfo") && !TextUtils.equals(kb3Var.b, "mapp_choose_address") && !TextUtils.equals(kb3Var.b, "mobile") && !TextUtils.equals(kb3Var.b, "mapp_choose_invoice") && !TextUtils.equals(kb3Var.b, "mapp_i_read_contacts") && !TextUtils.equals(kb3Var.b, "scope_calendar")) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean C(kb3 kb3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, kb3Var)) == null) {
            if (!TextUtils.equals(kb3Var.b, "ppcert") && !TextUtils.equals(kb3Var.b, "mapp_i_face_verify")) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void M(dl3<String> dl3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, dl3Var) == null) {
            rp2.Z().b(false, dl3Var);
        }
    }

    public final void z(dl3<String> dl3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, dl3Var) == null) {
            rp2.Z().c(rp2.c(), dl3Var);
        }
    }

    public final boolean E(kb3 kb3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, kb3Var)) == null) {
            if (!TextUtils.equals(kb3Var.b, "mapp_location") && !TextUtils.equals(kb3Var.b, "mapp_images") && !TextUtils.equals(kb3Var.b, PermissionProxy.SCOPE_ID_RECORD) && !TextUtils.equals(kb3Var.b, PermissionProxy.SCOPE_ID_CAMERA) && !TextUtils.equals(kb3Var.b, "scope_calendar")) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void I(boolean z, List<kb3> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), list, activity, callbackHandler, str}) == null) {
            if (z) {
                db3.b d2 = db3.d();
                d2.l(true);
                d2.i(true);
                k32.i("MultiAuthorize", "onCallback: real name success");
                J(activity, list, callbackHandler, str);
                return;
            }
            db3.d().l(false);
            k32.i("MultiAuthorize", "onCallback: real name fail");
            M(new f(this, activity, list, callbackHandler, str));
        }
    }

    public final void J(@NonNull Activity activity, @NonNull List<kb3> list, @NonNull CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048585, this, activity, list, callbackHandler, str) == null) {
            int size = list.size();
            String[] strArr = new String[size];
            for (int i2 = 0; i2 < size; i2++) {
                strArr[i2] = list.get(i2).b;
            }
            pb3 d2 = j63.K().x().a().b().d(activity, false, true, strArr, null, true);
            d2.p(new h(this, callbackHandler, str));
            d2.a();
        }
    }

    public final void L(@NonNull k63 k63Var, @NonNull Activity activity, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, k63Var, activity, jVar) == null) {
            v(k63Var, activity, jVar);
        }
    }

    public final void v(@NonNull k63 k63Var, @NonNull Activity activity, @NonNull j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048593, this, k63Var, activity, jVar) == null) {
            k63Var.N().f(activity, null, new i(this, jVar));
        }
    }

    public final void N(@NonNull Activity activity, kb3 kb3Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, activity, kb3Var, str) == null) {
            String a0 = j63.K().q().a0();
            boolean equals = TextUtils.equals(str, "1");
            if (A(kb3Var.s)) {
                if (equals) {
                    kb3Var.r = activity.getString(R.string.obfuscated_res_0x7f0f159d) + a0 + activity.getString(R.string.obfuscated_res_0x7f0f159c);
                    return;
                }
                kb3Var.r = activity.getString(R.string.obfuscated_res_0x7f0f159f) + a0 + activity.getString(R.string.obfuscated_res_0x7f0f159c);
                return;
            }
            kb3Var.r = activity.getString(R.string.obfuscated_res_0x7f0f159d) + a0 + activity.getString(R.string.obfuscated_res_0x7f0f159c);
        }
    }

    public final void O(@NonNull Activity activity, kb3 kb3Var, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, activity, kb3Var, bool) == null) {
            String a0 = j63.K().q().a0();
            boolean D = D(kb3Var.s);
            boolean A = A(kb3Var.s);
            if (!bool.booleanValue() && !D) {
                kb3Var.r = activity.getString(R.string.obfuscated_res_0x7f0f159e) + a0 + activity.getString(R.string.obfuscated_res_0x7f0f159c);
            } else if (A) {
                kb3Var.r = activity.getString(R.string.obfuscated_res_0x7f0f159f) + a0 + activity.getString(R.string.obfuscated_res_0x7f0f159c);
            } else {
                kb3Var.r = activity.getString(R.string.obfuscated_res_0x7f0f159d) + a0 + activity.getString(R.string.obfuscated_res_0x7f0f159c);
            }
        }
    }

    public final void P(kb3 kb3Var, List<kb3> list, boolean z, @NonNull Activity activity, @NonNull k63 k63Var, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{kb3Var, list, Boolean.valueOf(z), activity, k63Var, callbackHandler, str}) == null) {
            ib3.u(activity, k63Var, kb3Var, new JSONObject(), new c(this, callbackHandler, str, z, k63Var, activity, list));
        }
    }

    @Override // com.baidu.tieba.h83
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, k63 k63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048592, this, context, unitedSchemeEntity, callbackHandler, k63Var)) == null) {
            if (k63Var != null && (context instanceof Activity)) {
                JSONObject a2 = h83.a(unitedSchemeEntity, "params");
                if (a2 != null && a2.has("scopes")) {
                    JSONArray optJSONArray = a2.optJSONArray("scopes");
                    if (optJSONArray != null && optJSONArray.length() >= 2 && optJSONArray.length() <= 4) {
                        db3.d().n(true);
                        k63Var.f0().g(context, "scope_multi_authorize", new a(this, callbackHandler, a2.optString("cb"), context, k63Var, optJSONArray));
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                        return true;
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(100203, "scopes count error"));
                    db3.b d2 = db3.d();
                    d2.n(false);
                    d2.o();
                    return false;
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(100203, "illegal parameter"));
                db3.b d3 = db3.d();
                d3.n(false);
                d3.o();
                return false;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(401, "runtime parameter error");
            db3.b d4 = db3.d();
            d4.n(false);
            d4.o();
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final List<kb3> w(Map<String, kb3> map, @NonNull JSONArray jSONArray, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048594, this, map, jSONArray, callbackHandler, str)) == null) {
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            boolean z = true;
            for (int i2 = 0; i2 < length; i2++) {
                String c2 = kb3.c(jSONArray.optString(i2));
                if (!TextUtils.isEmpty(c2)) {
                    kb3 kb3Var = map.get(c2);
                    if (map.containsKey(c2) && kb3Var != null && B(kb3Var)) {
                        if (kb3Var.d) {
                            ib3.o(10005, callbackHandler, str);
                            db3.b d2 = db3.d();
                            d2.n(false);
                            d2.o();
                            dd3.r(10005, kb3Var);
                            return null;
                        }
                        if (!arrayList.contains(kb3Var) && !kb3Var.a()) {
                            arrayList.add(kb3Var);
                        }
                        if (!kb3Var.a()) {
                            z = false;
                        }
                    } else {
                        ib3.o(10005, callbackHandler, str);
                        db3.b d3 = db3.d();
                        d3.n(false);
                        d3.o();
                        dd3.r(10005, kb3Var);
                        return null;
                    }
                }
            }
            if (z) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                db3.b d4 = db3.d();
                d4.i(true);
                d4.n(true);
                d4.o();
                return null;
            }
            k32.i("MultiAuthorize", "cb=" + str + ", gain=false , scopes=" + arrayList);
            if (arrayList.isEmpty()) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(202, "scopes invalid").toString());
                db3.b d5 = db3.d();
                d5.n(true);
                d5.o();
                return null;
            }
            return arrayList;
        }
        return (List) invokeLLLL.objValue;
    }

    public final kb3 y(Map<String, kb3> map, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048596, this, map, callbackHandler, str)) == null) {
            kb3 kb3Var = map.get("scope_multi_authorize");
            if (kb3Var == null) {
                ib3.o(10001, callbackHandler, str);
                dd3.r(10001, null);
                return null;
            } else if (kb3Var.d) {
                ib3.o(10005, callbackHandler, str);
                dd3.r(10005, kb3Var);
                return null;
            } else {
                return kb3Var;
            }
        }
        return (kb3) invokeLLL.objValue;
    }
}
