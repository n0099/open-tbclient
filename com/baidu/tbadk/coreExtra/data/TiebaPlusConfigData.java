package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.url.UrlUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class TiebaPlusConfigData {
    public static /* synthetic */ Interceptable $ic = null;
    @NonNull
    public static final TiebaPlusConfigData DEFAULT;
    public static final String URL_PARAM_TID = "tid";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mIsSwitchOpen;
    public String mJumpUrl;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(843393546, "Lcom/baidu/tbadk/coreExtra/data/TiebaPlusConfigData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(843393546, "Lcom/baidu/tbadk/coreExtra/data/TiebaPlusConfigData;");
                return;
            }
        }
        DEFAULT = new TiebaPlusConfigData();
    }

    public TiebaPlusConfigData() {
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

    public static void addClickStatsForFireLink(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i) == null) {
            StatisticItem.make(TbadkCoreStatisticKey.KEY_THREAD_FIRE_CLICK).addParam("obj_locate", i).eventStat();
        }
    }

    public static boolean dealFireLinkWithTid(TbPageContext<?> tbPageContext, String str) {
        InterceptResult invokeLL;
        String jumpUrlWithTid;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, tbPageContext, str)) == null) {
            TiebaPlusConfigData tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
            if (tiebaPlusConfigData == null || str == null || (jumpUrlWithTid = tiebaPlusConfigData.getJumpUrlWithTid(str)) == null) {
                return false;
            }
            return UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{jumpUrlWithTid});
        }
        return invokeLL.booleanValue;
    }

    public static boolean isHeatingSwitchOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            TiebaPlusConfigData tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
            if (tiebaPlusConfigData != null) {
                return tiebaPlusConfigData.isSwitchOpen();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String getJumpUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mJumpUrl : (String) invokeV.objValue;
    }

    @Nullable
    public String getJumpUrlWithTid(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(this.mJumpUrl)) {
                return null;
            }
            return UrlUtils.appendParam(this.mJumpUrl, "tid", str);
        }
        return (String) invokeL.objValue;
    }

    public boolean isSwitchOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mIsSwitchOpen && !TextUtils.isEmpty(this.mJumpUrl) : invokeV.booleanValue;
    }

    public void setJumpUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.mJumpUrl = str;
        }
    }

    public void setSwitchOpen(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.mIsSwitchOpen = z;
        }
    }
}
