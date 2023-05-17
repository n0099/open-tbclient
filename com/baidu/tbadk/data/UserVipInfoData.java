package com.baidu.tbadk.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.UserVipInfo;
/* loaded from: classes4.dex */
public class UserVipInfoData implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 1412620310378890L;
    public transient /* synthetic */ FieldHolder $fh;
    public int dayAddScore;
    public int getScore;
    public int nextLevelScore;
    public int vipEndTime;
    public String vipIconUrl;
    public int vipLevel;
    public int vipStartTime;
    public int vipStatus;

    public UserVipInfoData() {
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

    public int getDayAddScore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.dayAddScore;
        }
        return invokeV.intValue;
    }

    public int getGetScore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.getScore;
        }
        return invokeV.intValue;
    }

    public int getNextLevelScore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.nextLevelScore;
        }
        return invokeV.intValue;
    }

    public int getVipEndTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.vipEndTime;
        }
        return invokeV.intValue;
    }

    public String getVipIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.vipIconUrl;
        }
        return (String) invokeV.objValue;
    }

    public int getVipLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.vipLevel;
        }
        return invokeV.intValue;
    }

    public int getVipStartTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.vipStartTime;
        }
        return invokeV.intValue;
    }

    public int getVipStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.vipStatus;
        }
        return invokeV.intValue;
    }

    public void parseJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        this.vipStatus = jSONObject.optInt("v_status", 0);
        this.vipIconUrl = jSONObject.optString("icon_url", "");
        this.vipStartTime = jSONObject.optInt("s_time", 0);
        this.vipEndTime = jSONObject.optInt("e_time", 0);
        this.getScore = jSONObject.optInt("ext_score", 0);
        this.vipLevel = jSONObject.optInt("v_level", 0);
        this.nextLevelScore = jSONObject.optInt("n_score", 0);
        this.dayAddScore = jSONObject.optInt("a_score", 0);
    }

    public void parserProtobuf(UserVipInfo userVipInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, userVipInfo) != null) || userVipInfo == null) {
            return;
        }
        Integer num = userVipInfo.v_status;
        if (num != null) {
            this.vipStatus = num.intValue();
        }
        this.vipIconUrl = userVipInfo.icon_url;
        Integer num2 = userVipInfo.s_time;
        if (num2 != null) {
            this.vipStartTime = num2.intValue();
        }
        Integer num3 = userVipInfo.e_time;
        if (num3 != null) {
            this.vipEndTime = num3.intValue();
        }
        Integer num4 = userVipInfo.ext_score;
        if (num4 != null) {
            this.getScore = num4.intValue();
        }
        Integer num5 = userVipInfo.v_level;
        if (num5 != null) {
            this.vipLevel = num5.intValue();
        }
        Integer num6 = userVipInfo.n_score;
        if (num6 != null) {
            this.nextLevelScore = num6.intValue();
        }
        Integer num7 = userVipInfo.a_score;
        if (num7 != null) {
            this.dayAddScore = num7.intValue();
        }
    }
}
