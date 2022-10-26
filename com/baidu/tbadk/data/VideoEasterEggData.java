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
public class VideoEasterEggData implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String activityID;
    public String popImageUrl;
    public String popText;
    public String shareContent;
    public String shareImageUrl;
    public String shareTitle;
    public String shareUrl;
    public String videoUrl;

    public VideoEasterEggData() {
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

    public String getActivityID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.activityID;
        }
        return (String) invokeV.objValue;
    }

    public String getPopImageUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.popImageUrl;
        }
        return (String) invokeV.objValue;
    }

    public String getPopText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.popText;
        }
        return (String) invokeV.objValue;
    }

    public String getShareContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.shareContent;
        }
        return (String) invokeV.objValue;
    }

    public String getShareImageUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.shareImageUrl;
        }
        return (String) invokeV.objValue;
    }

    public String getShareTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.shareTitle;
        }
        return (String) invokeV.objValue;
    }

    public String getShareUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.shareUrl;
        }
        return (String) invokeV.objValue;
    }

    public String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.videoUrl;
        }
        return (String) invokeV.objValue;
    }

    public void parseJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        this.activityID = jSONObject.optString("activity_id", "");
        this.videoUrl = jSONObject.optString("video_url", "");
        this.popText = jSONObject.optString("pop_text", "");
        this.popImageUrl = jSONObject.optString("pop_imageurl", "");
        JSONObject optJSONObject = jSONObject.optJSONObject("share_info");
        if (optJSONObject != null) {
            this.shareTitle = optJSONObject.optString("title", "");
            this.shareContent = optJSONObject.optString("content", "");
            this.shareUrl = optJSONObject.optString("url", "");
            this.shareImageUrl = optJSONObject.optString("imageurl", "");
        }
    }
}
