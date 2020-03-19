package com.baidu.tieba.advert.sdk.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.net.URLDecoder;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AdInfo implements Serializable {
    private static final long serialVersionUID = 1;
    public int adHeight;
    public String adImgUrl;
    public CreativeType adShowType;
    public String adVideoUrl;
    public int adWidth;
    public String adpUserId;
    public int advisible = -1;
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

    public static AdInfo jsonToObject(String str) {
        JSONObject jSONObject;
        AdInfo adInfo = new AdInfo();
        if (TextUtils.isEmpty(str)) {
            return adInfo;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = null;
        }
        adInfo.parseFromJson(jSONObject);
        return adInfo;
    }

    public boolean isVideoUrlValide() {
        return !TextUtils.isEmpty(this.adVideoUrl);
    }

    public boolean shouldDownloadVideo() {
        b xB = b.xB(com.baidu.tieba.advert.sdk.c.a.aZu());
        if (TextUtils.isEmpty(xB.videoLocalPath)) {
            return true;
        }
        return TextUtils.isEmpty(xB.adVideoUrl) ? !TextUtils.isEmpty(this.adVideoUrl) : !xB.adVideoUrl.equals(this.adVideoUrl);
    }

    public void parseFromJson(JSONObject jSONObject) {
        JSONArray jSONArray;
        JSONObject jSONObject2;
        JSONArray jSONArray2;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        JSONObject jSONObject5;
        JSONArray jSONArray3;
        JSONObject jSONObject6;
        if (jSONObject != null) {
            try {
                JSONObject jSONObject7 = jSONObject.getJSONObject("res");
                if (jSONObject7 != null && (jSONArray = jSONObject7.getJSONArray("ad")) != null && jSONArray.length() > 0 && (jSONObject2 = jSONArray.getJSONObject(0)) != null && (jSONArray2 = jSONObject2.getJSONArray("adInfo")) != null && jSONArray2.length() > 0 && (jSONObject3 = jSONArray2.getJSONObject(0)) != null) {
                    if (jSONObject3.has("advisible")) {
                        this.advisible = jSONObject3.getInt("advisible");
                    } else {
                        this.advisible = 1;
                    }
                    JSONArray jSONArray4 = jSONObject3.getJSONArray("material");
                    JSONArray jSONArray5 = jSONObject3.getJSONArray("extra");
                    if (jSONArray5 != null && jSONArray5.length() > 0 && (jSONObject4 = jSONArray5.getJSONObject(0)) != null) {
                        this.extraParam = jSONObject4.getString("v");
                        if (jSONArray4 != null && jSONArray4.length() > 0 && (jSONObject5 = jSONArray4.getJSONObject(0)) != null) {
                            String optString = jSONObject5.optString("info");
                            if (!TextUtils.isEmpty(optString) && (jSONArray3 = new JSONArray(optString)) != null && jSONArray3.length() > 0 && (jSONObject6 = jSONArray3.getJSONObject(0)) != null) {
                                this.adImgUrl = jSONObject6.optString("thread_pic");
                                this.redirectUrl = jSONObject6.optString("url");
                                this.displayName = jSONObject6.optString("displayName");
                                this.startShowTime = jSONObject6.optLong("start_show_time");
                                this.endShowTime = jSONObject6.optLong("end_show_time");
                                this.adVideoUrl = jSONObject6.optString("adVideo");
                                this.videoJumpUrl = jSONObject6.optString("video_jump");
                                this.videoWidth = jSONObject6.optInt("video_width");
                                this.videoHight = jSONObject6.optInt("video_height");
                                this.videoMd5 = jSONObject6.optString("video_md5");
                            }
                        }
                    }
                }
            } catch (NullPointerException e) {
                BdLog.e("服务端获取数据为空" + e);
            } catch (JSONException e2) {
                BdLog.e("解析服务端json数据异常" + e2);
            }
        }
    }

    public static ArrayList<String> convertStrToList(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                try {
                    arrayList.add(URLDecoder.decode(str2, "utf-8"));
                } catch (Exception e) {
                    BdLog.e("decode 监测地址失败" + e);
                }
            }
        }
        return arrayList;
    }
}
