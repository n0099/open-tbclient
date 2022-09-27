package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.tieba.kf0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class cf0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String m = "def";
    public transient /* synthetic */ FieldHolder $fh;
    public jf0 a;
    public String b;
    public List<kf0> c;
    public List<kf0> d;
    public ef0 e;
    public ef0 f;
    public kf0 g;
    public kf0.c h;
    public Context i;
    public Boolean j;
    public boolean k;
    public kf0.c l;

    /* loaded from: classes3.dex */
    public class a extends kf0.c<kf0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cf0 a;

        public a(cf0 cf0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cf0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cf0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kf0.c
        /* renamed from: e */
        public void a(kf0 kf0Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, kf0Var, str) == null) {
                this.a.d.remove(kf0Var);
                this.a.c.add(kf0Var);
                if (kf0Var == this.a.g) {
                    this.a.a.i(cf0.m, this.a.g.m());
                }
                if (this.a.q()) {
                    this.a.r();
                }
                super.a(kf0Var, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kf0.c
        /* renamed from: f */
        public void b(kf0 kf0Var, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, kf0Var, exc) == null) {
                super.b(kf0Var, exc);
                this.a.s();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kf0.c
        /* renamed from: g */
        public void c(kf0 kf0Var, long j, long j2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{kf0Var, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)}) == null) {
                super.c(kf0Var, j, j2, i);
                int k = this.a.k();
                if (this.a.h != null) {
                    this.a.h.c(this.a, 0L, 100L, k);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final cf0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-892295362, "Lcom/baidu/tieba/cf0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-892295362, "Lcom/baidu/tieba/cf0$b;");
                    return;
                }
            }
            a = new cf0(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947672700, "Lcom/baidu/tieba/cf0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947672700, "Lcom/baidu/tieba/cf0;");
        }
    }

    public /* synthetic */ cf0(a aVar) {
        this();
    }

    public static void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, str) == null) {
            Log.d("DuAr_InitModel", str);
        }
    }

    public static final cf0 j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            m = str;
            return b.a;
        }
        return (cf0) invokeL.objValue;
    }

    public final void h(kf0 kf0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, kf0Var) == null) {
            boolean q = kf0Var.q();
            if (p()) {
                i("isLoaded " + q + StringUtil.ARRAY_ELEMENT_SEPARATOR + kf0Var.o() + " to " + kf0Var.m());
            }
            if (kf0Var.q()) {
                this.c.add(kf0Var);
                return;
            }
            if (this.d == null) {
                this.d = new ArrayList();
            }
            this.d.add(kf0Var);
        }
    }

    public final int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<kf0> list = this.d;
            float f = 100.0f;
            if (list != null && list.size() != 0) {
                float size = 100.0f / (this.c.size() + this.d.size());
                float f2 = 0.0f;
                for (int i = 0; i < this.d.size(); i++) {
                    f2 += (this.d.get(i).n() / 100.0f) * size;
                }
                f = (this.c.size() * size) + f2;
            }
            return (int) f;
        }
        return invokeV.intValue;
    }

    public File l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f.g : (File) invokeV.objValue;
    }

    public File m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.e.g : (File) invokeV.objValue;
    }

    public boolean n(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            Boolean bool = this.j;
            if (bool != null && bool.booleanValue()) {
                return this.j.booleanValue();
            }
            this.j = Boolean.FALSE;
            long currentTimeMillis = System.currentTimeMillis();
            boolean k0 = te0.k0();
            if (p()) {
                i("ARControllerProxy.loadSoFile " + k0);
            }
            if (!k0) {
                return this.j.booleanValue();
            }
            File file = this.f.g;
            if (p()) {
                i("setResConfig " + file);
            }
            if (file != null) {
                ue0.s(new ve0(file.getAbsolutePath()));
            }
            if (p()) {
                i("initRecource costMS: " + (System.currentTimeMillis() - currentTimeMillis));
            }
            Boolean bool2 = Boolean.TRUE;
            this.j = bool2;
            return bool2.booleanValue();
        }
        return invokeL.booleanValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.c.clear();
            List<kf0> list = this.d;
            if (list != null) {
                list.clear();
            }
            if ("live".equals(ue0.e())) {
                this.e = ef0.i();
                this.f = ef0.g();
            }
            if (BdUploadHandler.MEDIA_SOURCE_KEY.equals(ue0.e())) {
                this.e = ef0.h();
                this.f = ef0.f();
            }
            if ("tieba".equals(ue0.e())) {
                this.e = ef0.i();
                this.f = ef0.f();
            }
            df0 df0Var = new df0(this.f);
            this.g = df0Var;
            h(df0Var);
            h(new df0(this.e));
        }
    }

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? ue0.m() : invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        List<kf0> list;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.c.size() > 0 && ((list = this.d) == null || list.size() == 0) : invokeV.booleanValue;
    }

    public void r() {
        File file;
        kf0.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            synchronized (this) {
                this.k = false;
            }
            boolean n = n(this.i);
            String str = null;
            if (!n && (cVar = this.h) != null) {
                cVar.b(null, null);
                return;
            }
            this.a.n(this.b);
            this.a.f();
            if (p()) {
                i("all onCompleted " + n);
            }
            if (this.h == null || !n) {
                return;
            }
            ef0 ef0Var = this.f;
            if (ef0Var != null && (file = ef0Var.g) != null) {
                str = file.getAbsolutePath();
            }
            this.h.a(this, str);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (p()) {
                i("all onFailed .");
            }
            synchronized (this) {
                this.k = false;
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.b = this.a.e(m);
            List<kf0> list = this.d;
            if (list != null && list.size() > 0) {
                for (kf0 kf0Var : this.d) {
                    kf0Var.l(this.l);
                }
                return;
            }
            r();
        }
    }

    public void u(Context context, kf0.c<cf0> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, context, cVar) == null) {
            this.i = context;
            this.h = cVar;
            synchronized (this) {
                if (this.k) {
                    if (p()) {
                        i("start return, isLoading true");
                    }
                    return;
                }
                this.k = true;
                o();
                t();
            }
        }
    }

    public cf0() {
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
        this.c = new ArrayList();
        this.d = null;
        this.l = new a(this);
        jf0 jf0Var = new jf0(ff0.d().g());
        this.a = jf0Var;
        jf0Var.h(m);
        o();
    }
}
