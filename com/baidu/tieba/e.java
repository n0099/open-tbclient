package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.searchbox.common.security.DeviceIdBag;
import com.baidu.searchbox.common.security.DeviceInfoManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class e extends fg1<qf0> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements qf0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.qf0
        @Nullable
        public boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.qf0
        @Nullable
        public xn0 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                DeviceIdBag androidId = DeviceInfoManager.INSTANCE.getAndroidId(hf0.b(), "fad", "fad");
                return new xn0(androidId.errorCode, androidId.deviceId, androidId.encodedDeviceId);
            }
            return (xn0) invokeV.objValue;
        }

        @Override // com.baidu.tieba.qf0
        @Nullable
        public xn0 b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                DeviceIdBag osVersion = DeviceInfoManager.INSTANCE.getOsVersion("fad", "fad");
                return new xn0(osVersion.errorCode, osVersion.deviceId, osVersion.encodedDeviceId);
            }
            return (xn0) invokeV.objValue;
        }

        @Override // com.baidu.tieba.qf0
        @Nullable
        public xn0 c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                DeviceIdBag oaid = DeviceInfoManager.INSTANCE.getOAID("fad", "fad");
                return new xn0(oaid.errorCode, oaid.deviceId, oaid.encodedDeviceId);
            }
            return (xn0) invokeV.objValue;
        }

        @Override // com.baidu.tieba.qf0
        @Nullable
        public xn0 d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                DeviceIdBag model = DeviceInfoManager.INSTANCE.getModel("fad", "fad");
                return new xn0(model.errorCode, model.deviceId, model.encodedDeviceId);
            }
            return (xn0) invokeV.objValue;
        }

        @Override // com.baidu.tieba.qf0
        @Nullable
        public xn0 e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                DeviceIdBag imei = DeviceInfoManager.INSTANCE.getIMEI(hf0.b(), "fad", "fad");
                return new xn0(imei.errorCode, imei.deviceId, imei.encodedDeviceId);
            }
            return (xn0) invokeV.objValue;
        }

        @Override // com.baidu.tieba.qf0
        @Nullable
        public xn0 f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                DeviceIdBag macAddress = DeviceInfoManager.INSTANCE.getMacAddress(hf0.b(), "fad", "fad");
                return new xn0(macAddress.errorCode, macAddress.deviceId, macAddress.encodedDeviceId);
            }
            return (xn0) invokeV.objValue;
        }

        @Override // com.baidu.tieba.qf0
        @Nullable
        public xn0 g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                DeviceIdBag manufacturer = DeviceInfoManager.INSTANCE.getManufacturer("fad", "fad");
                return new xn0(manufacturer.errorCode, manufacturer.deviceId, manufacturer.encodedDeviceId);
            }
            return (xn0) invokeV.objValue;
        }
    }

    public e() {
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
    @Override // com.baidu.tieba.fg1
    /* renamed from: a */
    public qf0 createService() throws ServiceNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a(this);
        }
        return (qf0) invokeV.objValue;
    }
}
