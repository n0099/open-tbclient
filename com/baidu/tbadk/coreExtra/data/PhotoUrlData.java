package com.baidu.tbadk.coreExtra.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class PhotoUrlData implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -6994746964706195260L;
    public transient /* synthetic */ FieldHolder $fh;
    public String bigurl;
    public String height;
    public String originPic;
    public String pic;
    public String picId;
    public String smallurl;
    public String toServerPhotoInfo;
    public String width;

    public PhotoUrlData() {
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

    private void parsePicInfo(String str) {
        String[] split;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, this, str) == null) || StringUtils.isNull(str) || (split = str.replaceAll("#\\(|\\)", "").split(",")) == null || split.length != 4) {
            return;
        }
        this.pic = split[0];
        this.picId = split[1];
        this.width = split[2];
        this.height = split[3];
    }

    public String getBigurl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.bigurl : (String) invokeV.objValue;
    }

    public String getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.height : (String) invokeV.objValue;
    }

    public String getOriginPic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.originPic : (String) invokeV.objValue;
    }

    public String getPic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.pic : (String) invokeV.objValue;
    }

    public String getPicId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.picId : (String) invokeV.objValue;
    }

    public String getSmallurl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.smallurl : (String) invokeV.objValue;
    }

    public String getToServerPhotoInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.toServerPhotoInfo : (String) invokeV.objValue;
    }

    public String getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.width : (String) invokeV.objValue;
    }

    public void parseJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) {
            this.smallurl = jSONObject.optString("smallurl", "");
            this.bigurl = jSONObject.optString("bigurl", "");
            this.picId = jSONObject.optString("picId", "");
            String optString = jSONObject.optString("toServerPhotoInfo", "");
            this.toServerPhotoInfo = optString;
            parsePicInfo(optString);
        }
    }

    public void setBigurl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.bigurl = str;
        }
    }

    public void setHeight(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.height = str;
        }
    }

    public void setOriginPic(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.originPic = str;
        }
    }

    public void setPic(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.pic = str;
        }
    }

    public void setPicId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.picId = str;
        }
    }

    public void setSmallurl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.smallurl = str;
        }
    }

    public void setToServerPhotoInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.toServerPhotoInfo = str;
            parsePicInfo(str);
        }
    }

    public void setWidth(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.width = str;
        }
    }

    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("smallUrl", this.smallurl);
                jSONObject.put("bigurl", this.bigurl);
                jSONObject.put("picId", this.picId);
                jSONObject.put("toServerPhotoInfo", this.toServerPhotoInfo);
                return jSONObject;
            } catch (JSONException e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }
}
