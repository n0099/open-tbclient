package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import org.brotli.dec.BrotliRuntimeException;
/* loaded from: classes3.dex */
public final class c0a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public byte[] H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public long R;
    public byte[] S;
    public int T;
    public int U;
    public int V;
    public int W;
    public int X;
    public int Y;
    public byte[] Z;
    public int a;
    public int b;
    public final tz9 c;
    public byte[] d;
    public final int[] e;
    public final int[] f;
    public int g;
    public boolean h;
    public boolean i;
    public boolean j;
    public final zz9 k;
    public final zz9 l;
    public final zz9 m;
    public final int[] n;
    public final int[] o;
    public final int[] p;
    public final int[] q;
    public int r;
    public int s;
    public int t;
    public boolean u;
    public int v;
    public int w;
    public int x;
    public int y;
    public byte[] z;

    public c0a() {
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
        this.a = 0;
        this.c = new tz9();
        this.e = new int[3240];
        this.f = new int[3240];
        this.k = new zz9();
        this.l = new zz9();
        this.m = new zz9();
        this.n = new int[3];
        this.o = new int[3];
        this.p = new int[6];
        this.q = new int[]{16, 15, 11, 4};
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = false;
        this.v = 0;
        this.Q = 0;
        this.R = 0L;
        this.S = new byte[0];
        this.T = 0;
    }

    public static void a(c0a c0aVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, c0aVar) == null) {
            int i = c0aVar.a;
            if (i != 0) {
                if (i == 11) {
                    return;
                }
                c0aVar.a = 11;
                tz9.b(c0aVar.c);
                return;
            }
            throw new IllegalStateException("State MUST be initialized");
        }
    }

    public static int b(tz9 tz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, tz9Var)) == null) {
            if (tz9.i(tz9Var, 1) == 0) {
                return 16;
            }
            int i = tz9.i(tz9Var, 3);
            if (i != 0) {
                return i + 17;
            }
            int i2 = tz9.i(tz9Var, 3);
            if (i2 == 0) {
                return 17;
            }
            return i2 + 8;
        }
        return invokeL.intValue;
    }

    public static void c(c0a c0aVar, InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, c0aVar, inputStream) == null) {
            if (c0aVar.a == 0) {
                tz9.e(c0aVar.c, inputStream);
                int b = b(c0aVar.c);
                if (b != 9) {
                    int i = 1 << b;
                    c0aVar.P = i;
                    c0aVar.O = i - 16;
                    c0aVar.a = 1;
                    return;
                }
                throw new BrotliRuntimeException("Invalid 'windowBits' code");
            }
            throw new IllegalStateException("State MUST be uninitialized");
        }
    }
}
