package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.nadcore.sweetsqlite.IntegerColumn;
import com.baidu.nadcore.sweetsqlite.LongColumn;
import com.baidu.nadcore.sweetsqlite.StringColumn;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class h01 extends a11 {
    public static /* synthetic */ Interceptable $ic;
    public static final s01 A;
    public static final s01 B;
    public static final s01[] C;
    public static final s01[] D;
    public static final s01 p;
    public static final s01 q;
    public static final s01 r;
    public static final s01 s;
    public static final s01 t;
    public static final s01 u;
    public static final s01 v;
    public static final s01 w;
    public static final s01 x;
    public static final s01 y;
    public static final s01 z;
    public transient /* synthetic */ FieldHolder $fh;
    public final StringColumn b;
    public final IntegerColumn c;
    public final IntegerColumn d;
    public final StringColumn e;
    public final StringColumn f;
    public final StringColumn g;
    public final IntegerColumn h;
    public final IntegerColumn i;
    public final LongColumn j;
    public final LongColumn k;
    public final StringColumn l;
    public final StringColumn m;
    public final StringColumn n;
    public final Column[] o;

    @Override // com.baidu.tieba.a11
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "t_apk_info" : (String) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947769792, "Lcom/baidu/tieba/h01;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947769792, "Lcom/baidu/tieba/h01;");
                return;
            }
        }
        p = a11.b(4, "key", "          key           ", 0, 2);
        q = a11.a(2, "task_id", "        task_id         ", 1);
        r = a11.a(2, "status", "         status         ", 2);
        s = a11.a(4, "package_name", "      package_name      ", 3);
        t = a11.a(4, "url", "          url           ", 4);
        u = a11.a(4, "file", "          file          ", 5);
        v = a11.a(2, "progress", "        progress        ", 6);
        w = a11.a(2, "v_progress", "       v_progress       ", 7);
        x = a11.a(3, "start_download_time", "  start_download_time   ", 8);
        y = a11.a(3, "finished_download_time", " finished_download_time ", 9);
        z = a11.a(4, "mt", "           mt           ", 10);
        A = a11.a(4, "ctrl", "          ctrl          ", 11);
        s01 a = a11.a(4, "extra", "         extra          ", 12);
        B = a;
        s01 s01Var = p;
        C = new s01[]{s01Var, q, r, s, t, u, v, w, x, y, z, A, a};
        D = new s01[]{s01Var};
    }

    public h01() {
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
        this.b = new StringColumn(p);
        this.c = new IntegerColumn(q);
        this.d = new IntegerColumn(r);
        this.e = new StringColumn(s);
        this.f = new StringColumn(t);
        this.g = new StringColumn(u);
        this.h = new IntegerColumn(v);
        this.i = new IntegerColumn(w);
        this.j = new LongColumn(x);
        this.k = new LongColumn(y);
        this.l = new StringColumn(z);
        this.m = new StringColumn(A);
        StringColumn stringColumn = new StringColumn(B);
        this.n = stringColumn;
        this.o = new Column[]{this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, stringColumn};
    }

    @Override // com.baidu.tieba.a11
    public Column[] c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.o;
        }
        return (Column[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.a11
    public s01[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return C;
        }
        return (s01[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.a11
    public s01[] f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return D;
        }
        return (s01[]) invokeV.objValue;
    }
}
