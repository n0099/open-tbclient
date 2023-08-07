package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.DeviceInfoHelper;
import com.baidu.android.bdutil.cuid.sdk.AppCuidRuntime;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.common.config.AppIdentityManager;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.common.security.IDeviceInfoAppHost;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Singleton
@Service
/* loaded from: classes5.dex */
public class f4a implements IDeviceInfoAppHost {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IDeviceInfoAppHost.OAIDResult a;

    @Override // com.baidu.searchbox.common.security.IDeviceInfoAppHost
    public long getForceMappingCacheInterval() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 86400000L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.searchbox.common.security.IDeviceInfoAppHost
    public boolean useMapping() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public f4a() {
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

    @Override // com.baidu.searchbox.common.security.IDeviceInfoAppHost
    @NonNull
    public String getAppName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return AppIdentityManager.getInstance().getAppName();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.common.security.IDeviceInfoAppHost
    @NonNull
    public String getEnUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (PermissionUtil.isAgreePrivacyPolicy()) {
                return AppCuidRuntime.getAppCuidManager().getEnCuid();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.common.security.IDeviceInfoAppHost
    @NonNull
    public String getUA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return DeviceInfoHelper.getUA();
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public static String a(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (str != null && !TextUtils.isEmpty(str)) {
                return new v40("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).c(str.getBytes());
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.common.security.IDeviceInfoAppHost
    @NonNull
    public IDeviceInfoAppHost.OAIDResult getOAID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            IDeviceInfoAppHost.OAIDResult oAIDResult = this.a;
            if (oAIDResult != null) {
                return oAIDResult;
            }
            if (PermissionUtil.isBrowseMode()) {
                IDeviceInfoAppHost.OAIDResult oAIDResult2 = new IDeviceInfoAppHost.OAIDResult(true, "", "");
                this.a = oAIDResult2;
                return oAIDResult2;
            }
            String g = k20.f(AppRuntime.getAppContext()).g();
            IDeviceInfoAppHost.OAIDResult oAIDResult3 = new IDeviceInfoAppHost.OAIDResult(true, g, a(g));
            this.a = oAIDResult3;
            return oAIDResult3;
        }
        return (IDeviceInfoAppHost.OAIDResult) invokeV.objValue;
    }
}
