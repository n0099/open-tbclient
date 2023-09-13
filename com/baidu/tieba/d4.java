package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class d4 extends x3 {
    public static /* synthetic */ Interceptable $ic;
    public static final long e;
    public transient /* synthetic */ FieldHolder $fh;
    public float d;

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
        e = x3.d("shininess");
        x3.d("alphaTest");
    }

    @Override // com.baidu.tieba.x3
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return (super.hashCode() * 977) + n7.b(this.d);
        }
        return invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d4(long j, float f) {
        super(j);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Float.valueOf(f)};
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
        this.d = f;
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
            float f = ((d4) x3Var).d;
            if (com.badlogic.gdx.math.d.e(this.d, f)) {
                return 0;
            }
            if (this.d < f) {
                return -1;
            }
            return 1;
        }
        return invokeL.intValue;
    }
}
