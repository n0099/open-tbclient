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
/* loaded from: classes3.dex */
public class HotEventData implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int WINDOW_TYPE_NORMAL = 2;
    public static final int WINDOW_TYPE_SCHEMA = 3;
    public static final int WINDOW_TYPE_TIME = 1;
    public static volatile HotEventData instance;
    public transient /* synthetic */ FieldHolder $fh;
    public String btnSchema;
    public String btnText;
    public String cancelBtnSchema;
    public String cancelBtnText;
    public String desc;
    public String icon;
    public String schemaUrl;
    public boolean showCloseBtn;
    public int skinType;
    public String title;
    public boolean useRightBg;
    public int windowType;

    public HotEventData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.showCloseBtn = true;
        this.useRightBg = true;
    }

    public static HotEventData getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (instance == null) {
                synchronized (HotEventData.class) {
                    if (instance == null) {
                        instance = new HotEventData();
                    }
                }
            }
            return instance;
        }
        return (HotEventData) invokeV.objValue;
    }

    public String getBtnSchema() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.btnSchema;
        }
        return (String) invokeV.objValue;
    }

    public String getBtnText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.btnText;
        }
        return (String) invokeV.objValue;
    }

    public String getCancelBtnSchema() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.cancelBtnSchema;
        }
        return (String) invokeV.objValue;
    }

    public String getCancelBtnText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.cancelBtnText;
        }
        return (String) invokeV.objValue;
    }

    public String getDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.desc;
        }
        return (String) invokeV.objValue;
    }

    public String getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.icon;
        }
        return (String) invokeV.objValue;
    }

    public String getSchemaUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.schemaUrl;
        }
        return (String) invokeV.objValue;
    }

    public int getSkinType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.skinType;
        }
        return invokeV.intValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.title;
        }
        return (String) invokeV.objValue;
    }

    public int getWindowType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.windowType;
        }
        return invokeV.intValue;
    }

    public boolean isShowCloseBtn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.showCloseBtn;
        }
        return invokeV.booleanValue;
    }

    public boolean isUseRightBg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.useRightBg;
        }
        return invokeV.booleanValue;
    }

    public void parsJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        this.title = jSONObject.optString("title");
        this.desc = jSONObject.optString("desc");
        this.cancelBtnText = jSONObject.optString("cancel_btn_text");
        this.cancelBtnSchema = jSONObject.optString("cancel_btn_schema");
        this.btnText = jSONObject.optString("btn_text");
        this.btnSchema = jSONObject.optString("btn_schema");
        this.icon = jSONObject.optString("icon");
        this.windowType = jSONObject.optInt("window_type");
        this.schemaUrl = jSONObject.optString("scheme");
        this.showCloseBtn = true;
        this.useRightBg = true;
    }

    public void setBtnText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.btnText = str;
        }
    }

    public void setDesc(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.desc = str;
        }
    }

    public void setSchemaUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.schemaUrl = str;
        }
    }

    public void setShowCloseBtn(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.showCloseBtn = z;
        }
    }

    public void setSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.skinType = i;
        }
    }

    public void setUseRightBg(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.useRightBg = z;
        }
    }
}
