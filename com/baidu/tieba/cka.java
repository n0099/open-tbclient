package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.bdutil.cuid.sdk.AppCuidRuntime;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityContext;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Singleton
@Service
/* loaded from: classes5.dex */
public class cka implements ww, ILokiIdentityContext, qw {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947679024, "Lcom/baidu/tieba/cka;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947679024, "Lcom/baidu/tieba/cka;");
        }
    }

    @Override // com.baidu.tieba.qw
    public String getAppName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "tieba" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ww, com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityContext
    public String getBDVCInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityContext
    public String getDeviceScore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityContext
    public String getIID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ww, com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityContext
    public String getSchemeHeader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ww
    public String processUrlExternal(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048588, this, str, z)) == null) ? str : (String) invokeLZ.objValue;
    }

    public cka() {
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

    @Override // com.baidu.tieba.ww, com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityContext
    public String getC3Aid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (hasPrivacyAuthority()) {
                return TbadkCoreApplication.getInst().getCuidGalaxy3();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ww, com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityContext
    public String getCfrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return TbConfig.getCurrentFrom();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ww
    public String getDeviceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (hasPrivacyAuthority()) {
                return AppCuidRuntime.getAppCuidManager().getCuid();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ww, com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityContext
    public String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return TbConfig.getFrom();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ww, com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityContext
    public String getSid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return TbSingleton.getInstance().getSampleId();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ww, com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityContext
    public String getZid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return a;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityContext
    public boolean hasPrivacyAuthority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return PermissionUtil.isAgreePrivacyPolicy();
        }
        return invokeV.booleanValue;
    }
}
