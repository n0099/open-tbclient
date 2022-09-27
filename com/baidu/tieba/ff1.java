package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public abstract class ff1<T> implements gf1<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean DEBUG;
    public transient /* synthetic */ FieldHolder $fh;
    public T mCachedInstance;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947762104, "Lcom/baidu/tieba/ff1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947762104, "Lcom/baidu/tieba/ff1;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
    }

    public ff1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public abstract T createService() throws ServiceNotFoundException;

    @Override // com.baidu.tieba.gf1
    public final T getService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                if (this.mCachedInstance == null) {
                    try {
                        this.mCachedInstance = createService();
                    } catch (ServiceNotFoundException e) {
                        if (DEBUG) {
                            e.printStackTrace();
                            throw e;
                        }
                    }
                }
            }
            return this.mCachedInstance;
        }
        return (T) invokeV.objValue;
    }
}
