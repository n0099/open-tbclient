package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class i41 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public final ArrayList<String> b;
    public final StringBuilder c;

    public i41() {
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
        this.a = false;
        this.b = new ArrayList<>();
        this.c = new StringBuilder();
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append((CharSequence) this.c);
            if (this.a) {
                sb.insert(0, "(");
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
            }
            sb.insert(0, " WHERE ");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static i41 g(Column column) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, column)) == null) {
            return i(column.field, column.stringValue());
        }
        return (i41) invokeL.objValue;
    }

    public static i41 h(y31 y31Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, y31Var)) == null) {
            i41 i41Var = new i41();
            i41Var.f(null, y31Var, " = ?");
            return i41Var;
        }
        return (i41) invokeL.objValue;
    }

    public static i41 j(Column... columnArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, columnArr)) == null) {
            i41 g = g(columnArr[0]);
            for (int i = 1; i < columnArr.length; i++) {
                g.b(columnArr[i].field, columnArr[i].stringValue());
            }
            return g;
        }
        return (i41) invokeL.objValue;
    }

    public i41 d(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, objArr)) == null) {
            for (Object obj : objArr) {
                this.b.add(String.valueOf(obj));
            }
            return this;
        }
        return (i41) invokeL.objValue;
    }

    public static i41 i(y31 y31Var, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, y31Var, obj)) == null) {
            i41 h = h(y31Var);
            h.d(obj);
            return h;
        }
        return (i41) invokeLL.objValue;
    }

    public i41 b(y31 y31Var, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, y31Var, obj)) == null) {
            c(null, y31Var, obj);
            return this;
        }
        return (i41) invokeLL.objValue;
    }

    public i41 a(String str, y31 y31Var, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, y31Var, str2)) == null) {
            this.a = true;
            this.c.append(" AND ");
            f(str, y31Var, str2);
            return this;
        }
        return (i41) invokeLLL.objValue;
    }

    public i41 c(String str, y31 y31Var, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, y31Var, obj)) == null) {
            a(str, y31Var, " = ?");
            d(obj);
            return this;
        }
        return (i41) invokeLLL.objValue;
    }

    public String[] e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            String[] strArr = new String[this.b.size()];
            for (int i = 0; i < this.b.size(); i++) {
                strArr[i] = this.b.get(i);
            }
            return strArr;
        }
        return (String[]) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append((CharSequence) this.c);
            if (this.a) {
                sb.insert(0, "(");
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public final void f(String str, y31 y31Var, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, str, y31Var, str2) == null) {
            if (y31Var != null) {
                if (str != null) {
                    this.c.append(str);
                    this.c.append(".");
                }
                this.c.append(y31Var.b);
                if (str2.charAt(0) != ' ') {
                    this.c.append(" ");
                }
            } else if (str != null) {
                throw new IllegalArgumentException("prefix should be null when field is null");
            }
            this.c.append(str2);
        }
    }
}
