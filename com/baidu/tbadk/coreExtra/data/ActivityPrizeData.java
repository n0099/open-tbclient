package com.baidu.tbadk.coreExtra.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public String getDotTimestamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.dotTimestamp;
        }
        return (String) invokeV.objValue;
    }

    public String getEnterForumText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.enterForumText;
        }
        return (String) invokeV.objValue;
    }

    public String getFeedText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.feedText;
        }
        return (String) invokeV.objValue;
    }

    public String getH5Url() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.h5Url;
        }
        return (String) invokeV.objValue;
    }

    public String getMyTabText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.myTabText;
        }
        return (String) invokeV.objValue;
    }

    public String getPersonItemText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.personItemText;
        }
        return (String) invokeV.objValue;
    }

    public boolean isPersonItemSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.personItemSwitch;
        }
        return invokeV.booleanValue;
    }

    public boolean isSwitchTurn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.switchTurn;
        }
        return invokeV.booleanValue;
    }

    public boolean isUserSatisfy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.userSatisfy;
        }
        return invokeV.booleanValue;
    }

    public void parse(JSONObject jSONObject) {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        boolean z3 = false;
        if (jSONObject.optInt("switch") == 1) {
            z = true;
        } else {
            z = false;
        }
        setSwitchTurn(z);
        this.feedText = jSONObject.optString("feed_text");
        this.enterForumText = jSONObject.optString("enter_forum_text");
        this.myTabText = jSONObject.optString("my_tab_text");
        long optLong = jSONObject.optLong("dot_timestamp");
        String str = "";
        if (optLong != 0) {
            str = optLong + "";
        }
        this.dotTimestamp = str;
        if (jSONObject.optInt("user_satisfy") == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.userSatisfy = z2;
        this.h5Url = jSONObject.optString("h5_url");
        if (jSONObject.optInt("person_item_switch") == 1) {
            z3 = true;
        }
        this.personItemSwitch = z3;
        this.personItemText = jSONObject.optString("person_item_text");
    }

    public void setSwitchTurn(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.switchTurn = z;
        }
    }
}
