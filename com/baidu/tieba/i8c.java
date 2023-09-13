package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import org.brotli.dec.BrotliRuntimeException;
/* loaded from: classes6.dex */
public final class i8c {
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

    /* renamed from: T  reason: collision with root package name */
    public int f1114T;
    public int U;
    public int V;
    public int W;
    public int X;
    public int Y;
    public byte[] Z;
    public int a;
    public int b;
    public final z7c c;
    public byte[] d;
    public final int[] e;
    public final int[] f;
    public int g;
    public boolean h;
    public boolean i;
    public boolean j;
    public final f8c k;
    public final f8c l;
    public final f8c m;
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

    public i8c() {
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
        this.c = new z7c();
        this.e = new int[3240];
        this.f = new int[3240];
        this.k = new f8c();
        this.l = new f8c();
        this.m = new f8c();
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
        this.f1114T = 0;
    }

    public static void a(i8c i8cVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, i8cVar) == null) {
            int i = i8cVar.a;
            if (i != 0) {
                if (i == 11) {
                    return;
                }
                i8cVar.a = 11;
                z7c.b(i8cVar.c);
                return;
            }
            throw new IllegalStateException("State MUST be initialized");
        }
    }

    public static int b(z7c z7cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, z7cVar)) == null) {
            if (z7c.i(z7cVar, 1) == 0) {
                return 16;
            }
            int i = z7c.i(z7cVar, 3);
            if (i != 0) {
                return i + 17;
            }
            int i2 = z7c.i(z7cVar, 3);
            if (i2 == 0) {
                return 17;
            }
            return i2 + 8;
        }
        return invokeL.intValue;
    }

    public static void c(i8c i8cVar, InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, i8cVar, inputStream) == null) {
            if (i8cVar.a == 0) {
                z7c.e(i8cVar.c, inputStream);
                int b = b(i8cVar.c);
                if (b != 9) {
                    int i = 1 << b;
                    i8cVar.P = i;
                    i8cVar.O = i - 16;
                    i8cVar.a = 1;
                    return;
                }
                throw new BrotliRuntimeException("Invalid 'windowBits' code");
            }
            throw new IllegalStateException("State MUST be uninitialized");
        }
    }
}
