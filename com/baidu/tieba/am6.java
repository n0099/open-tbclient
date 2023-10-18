package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.tieba.compact.CardPeiWanViewImpl;
import com.baidu.tieba.compact.SocialBarImpl;
import com.baidu.tieba.s07;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class am6 extends kf1<s07.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements s07.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(am6 am6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {am6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.s07.b
        @NonNull
        public s07.o a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new SocialBarImpl();
            }
            return (s07.o) invokeV.objValue;
        }

        @Override // com.baidu.tieba.s07.b
        public s07.j b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new gm6();
            }
            return (s07.j) invokeV.objValue;
        }

        @Override // com.baidu.tieba.s07.b
        public s07.q c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return new xm6();
            }
            return (s07.q) invokeV.objValue;
        }

        @Override // com.baidu.tieba.s07.b
        public s07.h d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return new dm6();
            }
            return (s07.h) invokeV.objValue;
        }

        @Override // com.baidu.tieba.s07.b
        public s07.e e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return new wl6();
            }
            return (s07.e) invokeV.objValue;
        }

        @Override // com.baidu.tieba.s07.b
        public s07.p f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return new vm6();
            }
            return (s07.p) invokeV.objValue;
        }

        @Override // com.baidu.tieba.s07.b
        public s07.k g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return new hm6();
            }
            return (s07.k) invokeV.objValue;
        }

        @Override // com.baidu.tieba.s07.b
        public s07.l h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return new im6();
            }
            return (s07.l) invokeV.objValue;
        }

        @Override // com.baidu.tieba.s07.b
        public s07.n i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return new tm6();
            }
            return (s07.n) invokeV.objValue;
        }

        @Override // com.baidu.tieba.s07.b
        @NonNull
        public s07.m j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return new km6();
            }
            return (s07.m) invokeV.objValue;
        }

        @Override // com.baidu.tieba.s07.b
        public s07.f k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                return new CardPeiWanViewImpl();
            }
            return (s07.f) invokeV.objValue;
        }

        @Override // com.baidu.tieba.s07.b
        public s07.i l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return new fm6();
            }
            return (s07.i) invokeV.objValue;
        }

        @Override // com.baidu.tieba.s07.b
        public s07.g m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                return new yl6();
            }
            return (s07.g) invokeV.objValue;
        }
    }

    public am6() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kf1
    /* renamed from: a */
    public s07.b createService() throws ServiceNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a(this);
        }
        return (s07.b) invokeV.objValue;
    }
}
