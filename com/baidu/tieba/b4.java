package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class b4 extends x3 {
    public static /* synthetic */ Interceptable $ic;
    public static final long h;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean d;
    public int e;
    public int f;
    public float g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448298971, "Lcom/baidu/tieba/b4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448298971, "Lcom/baidu/tieba/b4;");
                return;
            }
        }
        h = x3.d("blended");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b4() {
        this(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((b4) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.x3
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return (((((((super.hashCode() * 947) + (this.d ? 1 : 0)) * 947) + this.e) * 947) + this.f) * 947) + n7.b(this.g);
        }
        return invokeV.intValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b4(int i, int i2, float f) {
        this(true, i, i2, f);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Boolean) objArr2[0]).booleanValue(), ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Float) objArr2[3]).floatValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b4(b4 b4Var) {
        this(r0, r1, r2, r10);
        boolean z;
        int i;
        int i2;
        float f;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b4Var};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Boolean) objArr2[0]).booleanValue(), ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Float) objArr2[3]).floatValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        if (b4Var != null && !b4Var.d) {
            z = false;
        } else {
            z = true;
        }
        if (b4Var == null) {
            i = 770;
        } else {
            i = b4Var.e;
        }
        if (b4Var == null) {
            i2 = 771;
        } else {
            i2 = b4Var.f;
        }
        if (b4Var == null) {
            f = 1.0f;
        } else {
            f = b4Var.g;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b4(boolean z, int i, int i2, float f) {
        super(h);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Long) newInitContext.callArgs[0]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.g = 1.0f;
        this.d = z;
        this.e = i;
        this.f = i2;
        this.g = f;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: e */
    public int compareTo(x3 x3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, x3Var)) == null) {
            long j = this.a;
            long j2 = x3Var.a;
            if (j != j2) {
                return (int) (j - j2);
            }
            b4 b4Var = (b4) x3Var;
            boolean z = this.d;
            if (z != b4Var.d) {
                if (z) {
                    return 1;
                }
                return -1;
            }
            int i = this.e;
            int i2 = b4Var.e;
            if (i != i2) {
                return i - i2;
            }
            int i3 = this.f;
            int i4 = b4Var.f;
            if (i3 != i4) {
                return i3 - i4;
            }
            if (com.badlogic.gdx.math.d.e(this.g, b4Var.g)) {
                return 0;
            }
            if (this.g < b4Var.g) {
                return 1;
            }
            return -1;
        }
        return invokeL.intValue;
    }
}
