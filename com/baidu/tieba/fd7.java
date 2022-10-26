package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class fd7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public Object b;

    public fd7() {
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

    public Object a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return invokeV.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public int c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            if (str == null) {
                return -1;
            }
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() == 3) {
                    jSONArray.optString(0);
                    this.a = jSONArray.optInt(1);
                    JSONObject optJSONObject = jSONArray.optJSONObject(2);
                    if (1 == this.a) {
                        String optString = optJSONObject.optString(NativeConstants.ID_BUTTON);
                        String optString2 = optJSONObject.optString("shareSourceIcon");
                        String optString3 = optJSONObject.optString("shareSource");
                        String optString4 = optJSONObject.optString("shareUrl");
                        String optString5 = optJSONObject.optString("shareSourceUrl");
                        if (TextUtils.isEmpty(optString4)) {
                            ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
                            shareFromPBMsgData.setContent(optJSONObject.optString("themeContent"));
                            shareFromPBMsgData.setForumName(optJSONObject.optString("forumName"));
                            shareFromPBMsgData.setImageUrl(optJSONObject.optString("themeImageUrl"));
                            shareFromPBMsgData.setPostId(optJSONObject.optString("postID"));
                            shareFromPBMsgData.setThreadId(optJSONObject.optString("themeID"));
                            shareFromPBMsgData.setTitle(optJSONObject.optString("themeTitle"));
                            shareFromPBMsgData.setTheNewThemeId(optJSONObject.optString("theNewThemeID"));
                            shareFromPBMsgData.setThreadType(optJSONObject.optInt("threadType"));
                            this.b = shareFromPBMsgData;
                            return 0;
                        }
                        ShareFromGameCenterMsgData shareFromGameCenterMsgData = new ShareFromGameCenterMsgData();
                        shareFromGameCenterMsgData.setContent(optJSONObject.optString("themeContent"));
                        shareFromGameCenterMsgData.setForumName(optJSONObject.optString("forumName"));
                        shareFromGameCenterMsgData.setImageUrl(optJSONObject.optString("themeImageUrl"));
                        shareFromGameCenterMsgData.setPostId(optJSONObject.optString("postID"));
                        shareFromGameCenterMsgData.setThreadId(optJSONObject.optString("themeID"));
                        shareFromGameCenterMsgData.setTitle(optJSONObject.optString("themeTitle"));
                        shareFromGameCenterMsgData.setButton(optString);
                        shareFromGameCenterMsgData.setShareSource(optString3);
                        shareFromGameCenterMsgData.setShareSourceIcon(optString2);
                        shareFromGameCenterMsgData.setShareSourceUrl(optString5);
                        shareFromGameCenterMsgData.setShareUrl(optString4);
                        this.b = shareFromGameCenterMsgData;
                        return 1;
                    } else if (4 == this.a) {
                        ShareFromFrsMsgData shareFromFrsMsgData = new ShareFromFrsMsgData();
                        shareFromFrsMsgData.setName(optJSONObject.optString("forumName"));
                        shareFromFrsMsgData.setImageUrl(optJSONObject.optString("themeImageUrl"));
                        shareFromFrsMsgData.setMemberNum(optJSONObject.optInt("memberNum"));
                        shareFromFrsMsgData.setPostNum(optJSONObject.optInt("postNum"));
                        this.b = shareFromFrsMsgData;
                        return 2;
                    } else {
                        return -1;
                    }
                }
                return -1;
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeLL.intValue;
    }
}
