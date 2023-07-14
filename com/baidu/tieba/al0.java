package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public interface al0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "deviceInfo.bag");
    public static final al0 b = new a();

    @Nullable
    xs0 a();

    @Nullable
    xs0 b();

    @Nullable
    xs0 c();

    @Nullable
    xs0 d();

    @Nullable
    xs0 e();

    @Nullable
    xs0 f();

    @Nullable
    xs0 g();

    @Nullable
    boolean h();

    /* loaded from: classes5.dex */
    public class a implements al0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.al0
        public xs0 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (xs0) invokeV.objValue;
        }

        @Override // com.baidu.tieba.al0
        public xs0 b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return null;
            }
            return (xs0) invokeV.objValue;
        }

        @Override // com.baidu.tieba.al0
        public xs0 c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (xs0) invokeV.objValue;
        }

        @Override // com.baidu.tieba.al0
        public xs0 d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return null;
            }
            return (xs0) invokeV.objValue;
        }

        @Override // com.baidu.tieba.al0
        public xs0 e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return null;
            }
            return (xs0) invokeV.objValue;
        }

        @Override // com.baidu.tieba.al0
        public xs0 f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return null;
            }
            return (xs0) invokeV.objValue;
        }

        @Override // com.baidu.tieba.al0
        public xs0 g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return null;
            }
            return (xs0) invokeV.objValue;
        }

        @Override // com.baidu.tieba.al0
        public boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        public a() {
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
    }
}
