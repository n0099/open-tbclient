package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes6.dex */
public class hd implements gd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Integer a;

    public hd(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = Integer.valueOf(i);
    }

    @Override // com.baidu.tieba.gd
    public Object a(wd wdVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, wdVar)) == null) {
            Class<?> a = wdVar.a();
            if (a != Byte.class && a != Byte.TYPE) {
                if (a != Short.class && a != Short.TYPE) {
                    if (a != Integer.class && a != Integer.TYPE) {
                        if (a != Long.class && a != Long.TYPE) {
                            if (a != Float.class && a != Float.TYPE) {
                                if (a != Double.class && a != Double.TYPE) {
                                    if (a != Character.class && a != Character.TYPE) {
                                        boolean z = false;
                                        if (a != Boolean.class && a != Boolean.TYPE) {
                                            if (a == String.class) {
                                                return String.valueOf(this.a);
                                            }
                                            if (a == char[].class) {
                                                return String.valueOf(this.a).toCharArray();
                                            }
                                            if (a == byte[].class) {
                                                try {
                                                    return xh.e(String.valueOf(this.a), 0);
                                                } catch (IOException e) {
                                                    e.printStackTrace();
                                                    return null;
                                                }
                                            }
                                            return null;
                                        }
                                        if (this.a.byteValue() == 0) {
                                            z = true;
                                        }
                                        return Boolean.valueOf(z);
                                    }
                                    return Character.valueOf((char) this.a.intValue());
                                }
                                return Double.valueOf(this.a.doubleValue());
                            }
                            return Float.valueOf(this.a.floatValue());
                        }
                        return Long.valueOf(this.a.longValue());
                    }
                    return Integer.valueOf(this.a.intValue());
                }
                return Short.valueOf(this.a.shortValue());
            }
            return Byte.valueOf(this.a.byteValue());
        }
        return invokeL.objValue;
    }
}
