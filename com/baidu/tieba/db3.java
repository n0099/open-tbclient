package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes3.dex */
public class db3 implements bb3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public cb3 a;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-867270953, "Lcom/baidu/tieba/db3$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-867270953, "Lcom/baidu/tieba/db3$a;");
                    return;
                }
            }
            int[] iArr = new int[PathType.values().length];
            a = iArr;
            try {
                iArr[PathType.RELATIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[PathType.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[PathType.BD_FILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public db3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.bb3
    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            y23 b0 = y23.b0();
            return b0 == null ? str : ga3.H(str, b0);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.bb3
    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? ga3.G(str) : invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.bb3
    public String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            y23 b0 = y23.b0();
            return b0 == null ? "" : ga3.n(b0.b, str, null);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.bb3
    @NonNull
    public synchronized cb3 d() {
        InterceptResult invokeV;
        cb3 cb3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                if (this.a == null) {
                    this.a = new eb3();
                }
                cb3Var = this.a;
            }
            return cb3Var;
        }
        return (cb3) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bb3
    public String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            y23 b0 = y23.b0();
            if (b0 == null) {
                return null;
            }
            return ga3.L(str, b0, b0.k0());
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.bb3
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            y23 b0 = y23.b0();
            return b0 == null ? "" : ga3.z(b0.b);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bb3
    public String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            y23 b0 = y23.b0();
            return b0 == null ? str : ga3.I(str, b0.b);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.bb3
    public String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            String t = cj4.t(str);
            if (TextUtils.isEmpty(t)) {
                return g(str);
            }
            return g(str) + "." + t;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.bb3
    public String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            y23 b0 = y23.b0();
            if (b0 == null) {
                return null;
            }
            return ga3.M(str, b0.b);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.bb3
    public boolean j(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048585, this, str, z)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            PathType s = ga3.s(str);
            if (z) {
                s = o(str, s);
            }
            return s != PathType.ERROR;
        }
        return invokeLZ.booleanValue;
    }

    @Override // com.baidu.tieba.bb3
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            y23 b0 = y23.b0();
            return b0 == null ? "" : ga3.x(b0.b);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bb3
    public boolean l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) ? ga3.F(str) : invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.bb3
    public String m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) ? ga3.K(str) : (String) invokeL.objValue;
    }

    public final boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            int indexOf = str.indexOf("../");
            if (indexOf != 0) {
                return indexOf > 0;
            }
            String substring = str.substring(3);
            return !TextUtils.isEmpty(substring) && substring.contains("../");
        }
        return invokeL.booleanValue;
    }

    public final PathType o(String str, PathType pathType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, str, pathType)) == null) {
            int i = a.a[pathType.ordinal()];
            if (i == 1) {
                return n(str) ? PathType.ERROR : pathType;
            } else if (i != 2) {
                return i != 3 ? PathType.ERROR : pathType;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("bdfile://code");
                sb.append(File.separator);
                return (str.startsWith(sb.toString()) || "bdfile://code".equals(str)) ? PathType.RELATIVE : pathType;
            }
        }
        return (PathType) invokeLL.objValue;
    }
}
