package com.baidu.tieba;

import com.badlogic.gdx.utils.BufferUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
/* loaded from: classes4.dex */
public class g6 implements h6 {
    public static /* synthetic */ Interceptable $ic;
    public static final IntBuffer g;
    public transient /* synthetic */ FieldHolder $fh;
    public final a4 a;
    public final FloatBuffer b;
    public final ByteBuffer c;
    public final boolean d;
    public int e;
    public int f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448303838, "Lcom/baidu/tieba/g6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448303838, "Lcom/baidu/tieba/g6;");
                return;
            }
        }
        g = BufferUtils.d(1);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            g.clear();
            l1.g.v(1, g);
            this.f = g.get();
        }
    }

    @Override // com.baidu.tieba.h6
    public a4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (a4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h6
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return (this.b.limit() * 4) / this.a.b;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.h6, com.baidu.tieba.o7
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            u3 u3Var = l1.g;
            u3Var.E(34962, 0);
            u3Var.b(this.e);
            this.e = 0;
            if (this.d) {
                BufferUtils.b(this.c);
            }
            f();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f != -1) {
            g.clear();
            g.put(this.f);
            g.flip();
            l1.g.A(1, g);
            this.f = -1;
        }
    }

    @Override // com.baidu.tieba.h6
    public FloatBuffer getBuffer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.b;
        }
        return (FloatBuffer) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h6
    public void invalidate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.e = l1.g.n();
            a();
        }
    }

    public g6(boolean z, int i, a4 a4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i), a4Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = -1;
        new s7();
        this.a = a4Var;
        ByteBuffer e = BufferUtils.e(a4Var.b * i);
        this.c = e;
        FloatBuffer asFloatBuffer = e.asFloatBuffer();
        this.b = asFloatBuffer;
        this.d = true;
        asFloatBuffer.flip();
        this.c.flip();
        this.e = l1.f.n();
        a();
    }
}
