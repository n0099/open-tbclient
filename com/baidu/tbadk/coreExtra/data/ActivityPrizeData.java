package com.baidu.tbadk.coreExtra.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ActivityPrizeData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String dotTimestamp;
    public String enterForumText;
    public String feedText;
    public String h5Url;
    public String myTabText;
    public boolean personItemSwitch;
    public String personItemText;
    public boolean switchTurn;
    public boolean userSatisfy;

    public ActivityPrizeData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public String getDotTimestamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.dotTimestamp : (String) invokeV.objValue;
    }

    public String getEnterForumText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.enterForumText : (String) invokeV.objValue;
    }

    public String getFeedText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.feedText : (String) invokeV.objValue;
    }

    public String getH5Url() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.h5Url : (String) invokeV.objValue;
    }

    public String getMyTabText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.myTabText : (String) invokeV.objValue;
    }

    public String getPersonItemText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.personItemText : (String) invokeV.objValue;
    }

    public boolean isPersonItemSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.personItemSwitch : invokeV.booleanValue;
    }

    public boolean isSwitchTurn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.switchTurn : invokeV.booleanValue;
    }

    public boolean isUserSatisfy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.userSatisfy : invokeV.booleanValue;
    }

    public void parse(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        setSwitchTurn(jSONObject.optInt("switch") == 1);
        this.feedText = jSONObject.optString("feed_text");
        this.enterForumText = jSONObject.optString("enter_forum_text");
        this.myTabText = jSONObject.optString("my_tab_text");
        long optLong = jSONObject.optLong("dot_timestamp");
        String str = "";
        if (optLong != 0) {
            str = optLong + "";
        }
        this.dotTimestamp = str;
        this.userSatisfy = jSONObject.optInt("user_satisfy") == 1;
        this.h5Url = jSONObject.optString("h5_url");
        this.personItemSwitch = jSONObject.optInt("person_item_switch") == 1;
        this.personItemText = jSONObject.optString("person_item_text");
    }

    public void setSwitchTurn(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.switchTurn = z;
        }
    }
}
