package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public final class e0a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final float a;
    public int b;
    public int c;
    public int d;
    public Object[] e;

    public static int c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            int i2 = i * (-1640531527);
            return i2 ^ (i2 >>> 16);
        }
        return invokeI.intValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e0a() {
        this(16, 0.75f);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this(((Integer) objArr[0]).intValue(), ((Float) objArr[1]).floatValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public e0a(int i, float f) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Float.valueOf(f)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = f;
        int b = x0a.b(i);
        this.b = b - 1;
        this.d = (int) (f * b);
        this.e = new Object[b];
    }

    public boolean a(Object obj) {
        InterceptResult invokeL;
        Object obj2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            Object[] objArr = this.e;
            int i = this.b;
            int c = c(obj.hashCode()) & i;
            Object obj3 = objArr[c];
            if (obj3 != null) {
                if (obj3.equals(obj)) {
                    return false;
                }
                do {
                    c = (c + 1) & i;
                    obj2 = objArr[c];
                    if (obj2 == null) {
                    }
                } while (!obj2.equals(obj));
                return false;
            }
            objArr[c] = obj;
            int i2 = this.c + 1;
            this.c = i2;
            if (i2 >= this.d) {
                d();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.c == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.c = 0;
            this.e = new Object[0];
        }
    }

    public Object[] h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e;
        }
        return (Object[]) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Object[] objArr = this.e;
            int length = objArr.length;
            int i = length << 1;
            int i2 = i - 1;
            Object[] objArr2 = new Object[i];
            int i3 = this.c;
            while (true) {
                int i4 = i3 - 1;
                if (i3 != 0) {
                    do {
                        length--;
                    } while (objArr[length] == null);
                    int c = c(objArr[length].hashCode()) & i2;
                    if (objArr2[c] != null) {
                        do {
                            c = (c + 1) & i2;
                        } while (objArr2[c] != null);
                    }
                    objArr2[c] = objArr[length];
                    i3 = i4;
                } else {
                    this.b = i2;
                    this.d = (int) (i * this.a);
                    this.e = objArr2;
                    return;
                }
            }
        }
    }

    public boolean e(Object obj) {
        InterceptResult invokeL;
        Object obj2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            Object[] objArr = this.e;
            int i = this.b;
            int c = c(obj.hashCode()) & i;
            Object obj3 = objArr[c];
            if (obj3 == null) {
                return false;
            }
            if (obj3.equals(obj)) {
                return f(c, objArr, i);
            }
            do {
                c = (c + 1) & i;
                obj2 = objArr[c];
                if (obj2 == null) {
                    return false;
                }
            } while (!obj2.equals(obj));
            return f(c, objArr, i);
        }
        return invokeL.booleanValue;
    }

    public boolean f(int i, Object[] objArr, int i2) {
        InterceptResult invokeCommon;
        int i3;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), objArr, Integer.valueOf(i2)})) == null) {
            this.c--;
            while (true) {
                int i4 = i + 1;
                while (true) {
                    i3 = i4 & i2;
                    obj = objArr[i3];
                    if (obj == null) {
                        objArr[i] = null;
                        return true;
                    }
                    int c = c(obj.hashCode()) & i2;
                    if (i <= i3) {
                        if (i < c && c <= i3) {
                            i4 = i3 + 1;
                        }
                    } else {
                        if (i >= c && c > i3) {
                            break;
                        }
                        i4 = i3 + 1;
                    }
                }
                objArr[i] = obj;
                i = i3;
            }
        } else {
            return invokeCommon.booleanValue;
        }
    }
}
