package com.baidu.tieba;

import com.badlogic.gdx.utils.reflect.ReflectionException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes3.dex */
public final class b9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Constructor a;

    public b9(Constructor constructor) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {constructor};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = constructor;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.a.setAccessible(z);
        }
    }

    public Class a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a.getDeclaringClass();
        }
        return (Class) invokeV.objValue;
    }

    public Object b(Object... objArr) throws ReflectionException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, objArr)) == null) {
            try {
                return this.a.newInstance(objArr);
            } catch (IllegalAccessException e) {
                throw new ReflectionException("Could not instantiate instance of class: " + a().getName(), e);
            } catch (IllegalArgumentException e2) {
                throw new ReflectionException("Illegal argument(s) supplied to constructor for class: " + a().getName(), e2);
            } catch (InstantiationException e3) {
                throw new ReflectionException("Could not instantiate instance of class: " + a().getName(), e3);
            } catch (InvocationTargetException e4) {
                throw new ReflectionException("Exception occurred in constructor for class: " + a().getName(), e4);
            }
        }
        return invokeL.objValue;
    }
}
