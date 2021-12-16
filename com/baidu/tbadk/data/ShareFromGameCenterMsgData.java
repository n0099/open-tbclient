package com.baidu.tbadk.data;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class ShareFromGameCenterMsgData extends ShareFromPBMsgData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String button;
    public String shareSource;
    public String shareSourceIcon;
    public String shareSourceUrl;
    public String shareUrl;

    public ShareFromGameCenterMsgData() {
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

    public String getButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.button : (String) invokeV.objValue;
    }

    public String getShareSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.shareSource : (String) invokeV.objValue;
    }

    public String getShareSourceIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.shareSourceIcon : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.data.ShareFromPBMsgData
    public String getShareSourceUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.shareSourceUrl : (String) invokeV.objValue;
    }

    public String getShareUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.shareUrl : (String) invokeV.objValue;
    }

    public void setButton(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.button = str;
        }
    }

    public void setShareSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.shareSource = str;
        }
    }

    public void setShareSourceIcon(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.shareSourceIcon = str;
        }
    }

    @Override // com.baidu.tbadk.data.ShareFromPBMsgData
    public void setShareSourceUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.shareSourceUrl = str;
        }
    }

    public void setShareUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.shareUrl = str;
        }
    }

    @Override // com.baidu.tbadk.data.ShareFromPBMsgData, com.baidu.tbadk.data.ShareBaseMsgData
    public String toChatMessageContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("forumName", this.forumName);
                jSONObject.put("postID", this.postId);
                jSONObject.put("themeContent", this.content);
                jSONObject.put("themeID", this.threadId);
                String str = "";
                jSONObject.put("themeImageUrl", this.imageUrl == null ? "" : this.imageUrl);
                jSONObject.put("themeTitle", this.title);
                jSONObject.put("button", this.button);
                jSONObject.put("shareSource", this.shareSource);
                jSONObject.put("shareSourceIcon", this.shareSourceIcon);
                jSONObject.put("shareSourceUrl", this.shareSourceUrl);
                jSONObject.put("shareUrl", this.shareUrl);
                JSONArray jSONArray = new JSONArray();
                if (!TextUtils.isEmpty(this.title)) {
                    str = "【" + this.title + "】";
                }
                if (!TextUtils.isEmpty(this.content)) {
                    str = str + this.content;
                }
                jSONArray.put(str);
                jSONArray.put("1");
                jSONArray.put(jSONObject);
                return jSONArray.toString();
            } catch (JSONException e2) {
                BdLog.detailException(e2);
                return null;
            }
        }
        return (String) invokeV.objValue;
    }
}
