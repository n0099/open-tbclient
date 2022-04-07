package com.baidu.tbadk.task;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class TbHttpMessageTask extends HttpMessageTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mIsBDImage;
    public boolean mIsBaiduServer;
    public boolean mIsFromCDN;
    public boolean mIsNeedAddCommenParam;
    public boolean mIsNeedAddStatisticsParam;
    public boolean mIsNeedCookie;
    public boolean mIsNeedLogin;
    public boolean mIsNeedTbs;
    public boolean mIsUseCurrentBDUSS;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbHttpMessageTask(int i, String str) {
        super(i, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mIsNeedTbs = false;
        this.mIsUseCurrentBDUSS = true;
        this.mIsNeedAddStatisticsParam = true;
        this.mIsNeedAddCommenParam = true;
        this.mIsBaiduServer = true;
        this.mIsNeedLogin = false;
        this.mIsNeedCookie = false;
    }

    public boolean isBDImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mIsBDImage : invokeV.booleanValue;
    }

    public boolean isBaiduServer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mIsBaiduServer : invokeV.booleanValue;
    }

    public boolean isFromCDN() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mIsFromCDN : invokeV.booleanValue;
    }

    public boolean isIsNeedCookie() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mIsNeedCookie : invokeV.booleanValue;
    }

    public boolean isNeedAddCommenParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mIsNeedAddCommenParam : invokeV.booleanValue;
    }

    public boolean isNeedAddStatisticsParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mIsNeedAddStatisticsParam : invokeV.booleanValue;
    }

    public boolean isNeedLogin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mIsNeedLogin : invokeV.booleanValue;
    }

    public boolean isNeedTbs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mIsNeedTbs : invokeV.booleanValue;
    }

    public boolean isUseCurrentBDUSS() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mIsUseCurrentBDUSS : invokeV.booleanValue;
    }

    public void setIsBDImage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.mIsBDImage = z;
        }
    }

    public void setIsFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.mIsFromCDN = z;
        }
    }

    public void setIsNeedAddCommenParam(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.mIsNeedAddCommenParam = z;
        }
    }

    public void setIsNeedAddStatisticsParam(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.mIsNeedAddStatisticsParam = z;
        }
    }

    public void setIsNeedCookie(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.mIsNeedCookie = z;
        }
    }

    public void setIsNeedLogin(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.mIsNeedLogin = z;
        }
    }

    public void setIsNeedTbs(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.mIsNeedTbs = z;
        }
    }

    public void setIsUseCurrentBDUSS(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.mIsUseCurrentBDUSS = z;
        }
    }

    public void setmIsNBaiduServer(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.mIsBaiduServer = z;
        }
    }
}
