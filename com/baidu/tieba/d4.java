package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class d4 extends w3 {
    public static /* synthetic */ Interceptable $ic;
    public static final long j;
    public static final long k;
    public static final long l;
    public static final long m;
    public static final long n;
    public static final long o;
    public static final long p;
    public static long q;
    public transient /* synthetic */ FieldHolder $fh;
    public final g5<Texture> d;
    public float e;
    public float f;
    public float g;
    public float h;
    public int i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448300893, "Lcom/baidu/tieba/d4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448300893, "Lcom/baidu/tieba/d4;");
                return;
            }
        }
        j = w3.d("diffuseTexture");
        k = w3.d("specularTexture");
        l = w3.d("bumpTexture");
        m = w3.d("normalTexture");
        n = w3.d("ambientTexture");
        o = w3.d("emissiveTexture");
        long d = w3.d("reflectionTexture");
        p = d;
        q = d | j | k | l | m | n | o;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d4(long j2) {
        super(j2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Long) newInitContext.callArgs[0]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 1.0f;
        this.h = 1.0f;
        this.i = 0;
        if (f(j2)) {
            this.d = new g5<>();
            return;
        }
        throw new GdxRuntimeException("Invalid type specified");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public <T extends Texture> d4(long j2, g5<T> g5Var) {
        this(j2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2), g5Var};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this(((Long) newInitContext.callArgs[0]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.d.c(g5Var);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public <T extends Texture> d4(long j2, g5<T> g5Var, float f, float f2, float f3, float f4) {
        this(j2, g5Var, f, f2, f3, f4, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2), g5Var, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Long) objArr2[0]).longValue(), (g5) objArr2[1], ((Float) objArr2[2]).floatValue(), ((Float) objArr2[3]).floatValue(), ((Float) objArr2[4]).floatValue(), ((Float) objArr2[5]).floatValue(), ((Integer) objArr2[6]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public <T extends Texture> d4(long j2, g5<T> g5Var, float f, float f2, float f3, float f4, int i) {
        this(j2, g5Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Long.valueOf(j2), g5Var, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Integer.valueOf(i)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Long) objArr2[0]).longValue(), (g5) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.e = f;
        this.f = f2;
        this.g = f3;
        this.h = f4;
        this.i = i;
    }

    public static final boolean f(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65541, null, j2)) == null) {
            if ((j2 & q) != 0) {
                return true;
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: e */
    public int compareTo(w3 w3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, w3Var)) == null) {
            long j2 = this.a;
            long j3 = w3Var.a;
            if (j2 != j3) {
                if (j2 < j3) {
                    return -1;
                }
                return 1;
            }
            d4 d4Var = (d4) w3Var;
            int compareTo = this.d.compareTo(d4Var.d);
            if (compareTo != 0) {
                return compareTo;
            }
            int i = this.i;
            int i2 = d4Var.i;
            if (i != i2) {
                return i - i2;
            }
            if (!com.badlogic.gdx.math.d.e(this.g, d4Var.g)) {
                if (this.g <= d4Var.g) {
                    return -1;
                }
                return 1;
            } else if (!com.badlogic.gdx.math.d.e(this.h, d4Var.h)) {
                if (this.h <= d4Var.h) {
                    return -1;
                }
                return 1;
            } else if (!com.badlogic.gdx.math.d.e(this.e, d4Var.e)) {
                if (this.e <= d4Var.e) {
                    return -1;
                }
                return 1;
            } else if (!com.badlogic.gdx.math.d.e(this.f, d4Var.f)) {
                if (this.f <= d4Var.f) {
                    return -1;
                }
                return 1;
            } else {
                return 0;
            }
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.tieba.w3
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return (((((((((((super.hashCode() * 991) + this.d.hashCode()) * 991) + m7.b(this.e)) * 991) + m7.b(this.f)) * 991) + m7.b(this.g)) * 991) + m7.b(this.h)) * 991) + this.i;
        }
        return invokeV.intValue;
    }
}
