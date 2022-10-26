package com.baidu.tbadk.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import tbclient.CustomState;
import tbclient.StateInfo;
/* loaded from: classes3.dex */
public class VirtualImageCustomState implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ICON_TYPE_CUSTOM = "url";
    public static final int ICON_TYPE_CUSTOM_INT = 2;
    public static final String ICON_TYPE_EMOJI = "emoji";
    public static final int ICON_TYPE_EMOJI_INT = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public String content;
    public String icon;
    public String iconType;

    public VirtualImageCustomState() {
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

    public String getContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.content;
        }
        return (String) invokeV.objValue;
    }

    public String getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.icon;
        }
        return (String) invokeV.objValue;
    }

    public boolean isCustomState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "url".equals(this.iconType);
        }
        return invokeV.booleanValue;
    }

    public boolean isEmojiState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return "emoji".equals(this.iconType);
        }
        return invokeV.booleanValue;
    }

    public void parseProto(CustomState customState) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, customState) != null) || customState == null) {
            return;
        }
        this.icon = customState.icon;
        this.content = customState.content;
        this.iconType = customState.icon_type;
    }

    public void setContent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.content = str;
        }
    }

    public void setIcon(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.icon = str;
        }
    }

    public void setIconType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.iconType = str;
        }
    }

    public void parseProto(StateInfo stateInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, stateInfo) == null) {
            this.icon = stateInfo.icon;
            this.content = stateInfo.text;
            int intValue = stateInfo.icon_type.intValue();
            if (intValue != 1) {
                if (intValue == 2) {
                    this.iconType = "url";
                    return;
                }
                return;
            }
            this.iconType = "emoji";
        }
    }
}
