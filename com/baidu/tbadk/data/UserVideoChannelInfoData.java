package com.baidu.tbadk.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.UserManChannelInfo;
/* loaded from: classes5.dex */
public class UserVideoChannelInfoData implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 1412620310378110L;
    public transient /* synthetic */ FieldHolder $fh;
    public int followChannel;
    public int manChannel;

    public UserVideoChannelInfoData() {
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

    public int getFollowChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.followChannel : invokeV.intValue;
    }

    public int getManChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.manChannel : invokeV.intValue;
    }

    public void parseJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.manChannel = jSONObject.optInt("man_channel", 0);
        this.followChannel = jSONObject.optInt("follow_channel", 0);
    }

    public void parserProtobuf(UserManChannelInfo userManChannelInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, userManChannelInfo) == null) || userManChannelInfo == null) {
            return;
        }
        Integer num = userManChannelInfo.man_channel;
        if (num != null) {
            this.manChannel = num.intValue();
        }
        Integer num2 = userManChannelInfo.follow_channel;
        if (num2 != null) {
            this.followChannel = num2.intValue();
        }
    }
}
