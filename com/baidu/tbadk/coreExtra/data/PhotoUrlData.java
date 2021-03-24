package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class PhotoUrlData implements Serializable {
    public static final long serialVersionUID = -6994746964706195260L;
    public String bigurl;
    public String height;
    public String originPic;
    public String pic;
    public String picId;
    public String smallurl;
    public String toServerPhotoInfo;
    public String width;

    private void parsePicInfo(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        str.replaceAll("#\\(|\\)", "");
        String[] split = str.split(",");
        if (split == null || split.length != 4) {
            return;
        }
        this.pic = split[0];
        this.picId = split[1];
        this.width = split[2];
        this.height = split[3];
    }

    public String getBigurl() {
        return this.bigurl;
    }

    public String getHeight() {
        return this.height;
    }

    public String getOriginPic() {
        return this.originPic;
    }

    public String getPic() {
        return this.pic;
    }

    public String getPicId() {
        return this.picId;
    }

    public String getSmallurl() {
        return this.smallurl;
    }

    public String getToServerPhotoInfo() {
        return this.toServerPhotoInfo;
    }

    public String getWidth() {
        return this.width;
    }

    public void parseJson(JSONObject jSONObject) {
        this.smallurl = jSONObject.optString("smallurl", "");
        this.bigurl = jSONObject.optString("bigurl", "");
        this.picId = jSONObject.optString("picId", "");
        String optString = jSONObject.optString("toServerPhotoInfo", "");
        this.toServerPhotoInfo = optString;
        parsePicInfo(optString);
    }

    public void setBigurl(String str) {
        this.bigurl = str;
    }

    public void setHeight(String str) {
        this.height = str;
    }

    public void setOriginPic(String str) {
        this.originPic = str;
    }

    public void setPic(String str) {
        this.pic = str;
    }

    public void setPicId(String str) {
        this.picId = str;
    }

    public void setSmallurl(String str) {
        this.smallurl = str;
    }

    public void setToServerPhotoInfo(String str) {
        this.toServerPhotoInfo = str;
        parsePicInfo(str);
    }

    public void setWidth(String str) {
        this.width = str;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("smallUrl", this.smallurl);
            jSONObject.put("bigurl", this.bigurl);
            jSONObject.put("picId", this.picId);
            jSONObject.put("toServerPhotoInfo", this.toServerPhotoInfo);
            return jSONObject;
        } catch (JSONException e2) {
            BdLog.e(e2.getMessage());
            return null;
        }
    }
}
