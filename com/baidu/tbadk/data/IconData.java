package com.baidu.tbadk.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.Icon;
import tbclient.TshowInfo;
/* loaded from: classes4.dex */
public class IconData extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static String meizhi_icon_name = "meizhi_level";
    public static String redi_icon_name = "is_verify";
    public static final long serialVersionUID = 5554483396003492966L;
    public transient /* synthetic */ FieldHolder $fh;
    public String icon;
    public String name;
    public String url;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1384490966, "Lcom/baidu/tbadk/data/IconData;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1384490966, "Lcom/baidu/tbadk/data/IconData;");
        }
    }

    public IconData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.icon = null;
        this.name = null;
        this.url = null;
    }

    public String getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.icon : (String) invokeV.objValue;
    }

    public String getIconName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.name : (String) invokeV.objValue;
    }

    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.url : (String) invokeV.objValue;
    }

    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            this.icon = jSONObject.optString("icon");
            this.name = jSONObject.optString("name");
            this.url = jSONObject.optString("url");
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public void parserProtobuf(Icon icon) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, icon) == null) || icon == null) {
            return;
        }
        this.icon = icon.icon;
        this.name = icon.name;
        this.url = icon.url;
    }

    public void setIcon(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.icon = str;
        }
    }

    public void setIconName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.name = str;
        }
    }

    public void setUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.url = str;
        }
    }

    public void parserProtobuf(TshowInfo tshowInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, tshowInfo) == null) || tshowInfo == null) {
            return;
        }
        this.icon = tshowInfo.icon;
        this.name = tshowInfo.name;
        this.url = tshowInfo.url;
    }

    public IconData(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.icon = str;
        this.name = str2;
        this.url = str3;
    }
}
