package com.baidu.tieba.advert.sdk.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.util.UriUtil;
import d.a.p0.t.a.f.b;
import d.a.p0.t.a.j.a;
import java.io.Serializable;
import java.net.URLDecoder;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AdInfo implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public int adHeight;
    public String adImgUrl;
    public CreativeType adShowType;
    public String adVideoUrl;
    public int adWidth;
    public String adpUserId;
    public int advisible;
    public String apkFilePath;
    public Integer chargingMode;
    public ArrayList<String> dcu;
    public ArrayList<String> ddu;
    public int dduTime;
    public String desc;
    public String displayName;
    public String downLoadUrl;
    public String downloadName;
    public long endDownloadTime;
    public long endInstallTime;
    public long endShowTime;
    public String extraParam;
    public String fileName;
    public String finalPrice;
    public String html;
    public String icon;
    public String ideaId;
    public int isSwitch;
    public String packageName;
    public String placeId;
    public String planId;
    public LandingPageType redirectType;
    public String redirectUrl;
    public int sourceType;
    public long startShowTime;
    public int switchTime;
    public String title;
    public String token;
    public AdType typeId;
    public String unitId;
    public int videoDuration;
    public int videoHight;
    public String videoJumpUrl;
    public String videoLocalPath;
    public String videoMd5;
    public int videoWidth;

    public AdInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.advisible = -1;
    }

    public static ArrayList<String> convertStrToList(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            if (!TextUtils.isEmpty(str)) {
                for (String str2 : str.split(",")) {
                    try {
                        arrayList.add(URLDecoder.decode(str2, "utf-8"));
                    } catch (Exception e2) {
                        BdLog.e("decode 监测地址失败" + e2);
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static AdInfo jsonToObject(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            AdInfo adInfo = new AdInfo();
            if (TextUtils.isEmpty(str)) {
                return adInfo;
            }
            JSONObject jSONObject = null;
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            adInfo.parseFromJson(jSONObject);
            return adInfo;
        }
        return (AdInfo) invokeL.objValue;
    }

    public boolean isVideoUrlValide() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !TextUtils.isEmpty(this.adVideoUrl) : invokeV.booleanValue;
    }

    public void parseFromJson(JSONObject jSONObject) {
        JSONArray jSONArray;
        JSONObject jSONObject2;
        JSONArray jSONArray2;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        JSONObject jSONObject5;
        JSONObject jSONObject6;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObject7 = jSONObject.getJSONObject(UriUtil.LOCAL_RESOURCE_SCHEME);
            if (jSONObject7 != null && (jSONArray = jSONObject7.getJSONArray("ad")) != null && jSONArray.length() > 0 && (jSONObject2 = jSONArray.getJSONObject(0)) != null && (jSONArray2 = jSONObject2.getJSONArray("adInfo")) != null && jSONArray2.length() > 0 && (jSONObject3 = jSONArray2.getJSONObject(0)) != null) {
                if (jSONObject3.has("advisible")) {
                    this.advisible = jSONObject3.getInt("advisible");
                } else {
                    this.advisible = 1;
                }
                JSONArray jSONArray3 = jSONObject3.getJSONArray("material");
                JSONArray jSONArray4 = jSONObject3.getJSONArray("extra");
                if (jSONArray4 != null && jSONArray4.length() > 0 && (jSONObject4 = jSONArray4.getJSONObject(0)) != null) {
                    this.extraParam = jSONObject4.getString("v");
                    if (jSONArray3 != null && jSONArray3.length() > 0 && (jSONObject5 = jSONArray3.getJSONObject(0)) != null) {
                        String optString = jSONObject5.optString("info");
                        if (TextUtils.isEmpty(optString)) {
                            return;
                        }
                        JSONArray jSONArray5 = new JSONArray(optString);
                        if (jSONArray5.length() > 0 && (jSONObject6 = jSONArray5.getJSONObject(0)) != null) {
                            this.adImgUrl = jSONObject6.optString("thread_pic");
                            this.redirectUrl = jSONObject6.optString("url");
                            this.displayName = jSONObject6.optString("displayName");
                            this.startShowTime = jSONObject6.optLong("start_show_time");
                            this.endShowTime = jSONObject6.optLong("end_show_time");
                            this.adVideoUrl = jSONObject6.optString("adVideo");
                            this.videoJumpUrl = jSONObject6.optString("video_jump");
                            this.videoWidth = jSONObject6.optInt("video_width");
                            this.videoHight = jSONObject6.optInt("video_height");
                            this.videoMd5 = jSONObject6.optString(VideoFinishResult.KEY_VIDEO_MD5);
                        }
                    }
                }
            }
        } catch (NullPointerException e2) {
            BdLog.e("服务端获取数据为空" + e2);
        } catch (JSONException e3) {
            BdLog.e("解析服务端json数据异常" + e3);
        }
    }

    public boolean shouldDownloadVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            b b2 = b.b(a.d());
            if (TextUtils.isEmpty(b2.f62264d)) {
                return true;
            }
            return TextUtils.isEmpty(b2.f62263c) ? !TextUtils.isEmpty(this.adVideoUrl) : !b2.f62263c.equals(this.adVideoUrl);
        }
        return invokeV.booleanValue;
    }
}
