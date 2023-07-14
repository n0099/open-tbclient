package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class ez3<ContenT> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, ez3<ContenT>.a> a;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;
        public final ContenT b;
        public final /* synthetic */ ez3 c;

        public a(ez3 ez3Var, String str, ContenT content) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ez3Var, str, content};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ez3Var;
            this.a = str;
            this.b = content;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.d(this.a);
            }
        }
    }

    public ez3() {
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
        this.a = new HashMap();
    }

    public synchronized ContenT a(String str, ContenT content, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, content, Long.valueOf(j)})) == null) {
            synchronized (this) {
                d(str);
                if (content == null) {
                    return null;
                }
                ez3<ContenT>.a aVar = new a(this, str, content);
                this.a.put(str, aVar);
                if (j > 0) {
                    ub3.M().postDelayed(aVar, j);
                }
                return content;
            }
        }
        return (ContenT) invokeCommon.objValue;
    }

    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                for (ez3<ContenT>.a aVar : this.a.values()) {
                    if (aVar != null) {
                        ub3.M().removeCallbacks(aVar);
                    }
                }
                this.a.clear();
            }
        }
    }

    public ContenT c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            ez3<ContenT>.a aVar = this.a.get(str);
            if (aVar == null) {
                return null;
            }
            return aVar.b;
        }
        return (ContenT) invokeL.objValue;
    }

    public synchronized ContenT d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            synchronized (this) {
                ez3<ContenT>.a remove = this.a.remove(str);
                if (remove != null) {
                    ub3.M().removeCallbacks(remove);
                    return remove.b;
                }
                return null;
            }
        }
        return (ContenT) invokeL.objValue;
    }
}
