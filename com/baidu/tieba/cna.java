package com.baidu.tieba;

import android.os.Looper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes3.dex */
public final class cna {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<cna> b;
    public transient /* synthetic */ FieldHolder $fh;
    public final vma a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947681907, "Lcom/baidu/tieba/cna;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947681907, "Lcom/baidu/tieba/cna;");
                return;
            }
        }
        b = new AtomicReference<>();
    }

    public static cna a() {
        cna cnaVar;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            do {
                cna cnaVar2 = b.get();
                if (cnaVar2 != null) {
                    return cnaVar2;
                }
                cnaVar = new cna();
            } while (!b.compareAndSet(null, cnaVar));
            return cnaVar;
        }
        return (cna) invokeV.objValue;
    }

    public static vma b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return a().a;
        }
        return (vma) invokeV.objValue;
    }

    public cna() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        vma b2 = ana.a().b().b();
        if (b2 != null) {
            this.a = b2;
        } else {
            this.a = new dna(Looper.getMainLooper());
        }
    }
}
