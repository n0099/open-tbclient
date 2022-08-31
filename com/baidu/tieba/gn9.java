package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes4.dex */
public final class gn9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final List<String> a;
        public final Object b;

        public /* synthetic */ a(Object obj, mn9 mn9Var) {
            hn9.d(obj);
            this.b = obj;
            this.a = new ArrayList();
        }

        @NonNull
        public a a(@NonNull String str, @Nullable Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, obj)) == null) {
                List<String> list = this.a;
                hn9.d(str);
                String valueOf = String.valueOf(obj);
                StringBuilder sb = new StringBuilder(str.length() + 1 + String.valueOf(valueOf).length());
                sb.append(str);
                sb.append("=");
                sb.append(valueOf);
                list.add(sb.toString());
                return this;
            }
            return (a) invokeLL.objValue;
        }

        @NonNull
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                StringBuilder sb = new StringBuilder(100);
                sb.append(this.b.getClass().getSimpleName());
                sb.append('{');
                int size = this.a.size();
                for (int i = 0; i < size; i++) {
                    sb.append(this.a.get(i));
                    if (i < size - 1) {
                        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    }
                }
                sb.append('}');
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    public static boolean a(@Nullable Object obj, @Nullable Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, obj, obj2)) == null) ? obj == obj2 || (obj != null && obj.equals(obj2)) : invokeLL.booleanValue;
    }

    public static int b(@NonNull Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, objArr)) == null) ? Arrays.hashCode(objArr) : invokeL.intValue;
    }

    @NonNull
    public static a c(@NonNull Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, obj)) == null) ? new a(obj, null) : (a) invokeL.objValue;
    }
}
