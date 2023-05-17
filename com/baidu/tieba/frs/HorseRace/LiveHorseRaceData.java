package com.baidu.tieba.frs.HorseRace;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import tbclient.GetHorseRaceLampList.LiveList;
/* loaded from: classes5.dex */
public class LiveHorseRaceData implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Integer amount;
    public Long live_id;
    public String live_title;
    public Long rob_end_tm;
    public Integer screen_direction;
    public Long user_id;
    public String user_nickname;

    public LiveHorseRaceData() {
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

    public Integer getAmount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.amount;
        }
        return (Integer) invokeV.objValue;
    }

    public Long getLive_id() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.live_id;
        }
        return (Long) invokeV.objValue;
    }

    public String getLive_title() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.live_title;
        }
        return (String) invokeV.objValue;
    }

    public Long getRob_end_tm() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.rob_end_tm;
        }
        return (Long) invokeV.objValue;
    }

    public Integer getScreen_direction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.screen_direction;
        }
        return (Integer) invokeV.objValue;
    }

    public Long getUser_id() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.user_id;
        }
        return (Long) invokeV.objValue;
    }

    public String getUser_nickname() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.user_nickname;
        }
        return (String) invokeV.objValue;
    }

    public void parserProtobuf(LiveList liveList) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, liveList) != null) || liveList == null) {
            return;
        }
        this.live_id = liveList.live_id;
        this.live_title = liveList.live_title;
        this.user_id = liveList.user_id;
        this.user_nickname = liveList.user_nickname;
        this.amount = liveList.amount;
        this.rob_end_tm = liveList.rob_end_tm;
        this.screen_direction = liveList.screen_direction;
    }

    public void setAmount(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, num) == null) {
            this.amount = num;
        }
    }

    public void setLive_id(Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, l) == null) {
            this.live_id = l;
        }
    }

    public void setLive_title(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.live_title = str;
        }
    }

    public void setRob_end_tm(Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, l) == null) {
            this.rob_end_tm = l;
        }
    }

    public void setScreen_direction(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, num) == null) {
            this.screen_direction = num;
        }
    }

    public void setUser_id(Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, l) == null) {
            this.user_id = l;
        }
    }

    public void setUser_nickname(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.user_nickname = str;
        }
    }
}
