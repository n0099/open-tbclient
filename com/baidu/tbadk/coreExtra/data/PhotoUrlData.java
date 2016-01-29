package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PhotoUrlData implements Serializable {
    private static final long serialVersionUID = -6994746964706195260L;
    private String bigurl;
    private String height;
    private String pic;
    private String picId;
    private String smallurl;
    private String toServerPhotoInfo;
    private String width;

    public String getPic() {
        return this.pic;
    }

    public void setPic(String str) {
        this.pic = str;
    }

    public String getWidth() {
        return this.width;
    }

    public void setWidth(String str) {
        this.width = str;
    }

    public String getHeight() {
        return this.height;
    }

    public void setHeight(String str) {
        this.height = str;
    }

    public String getPicId() {
        return this.picId;
    }

    public void setPicId(String str) {
        this.picId = str;
    }

    public String getSmallurl() {
        return this.smallurl;
    }

    public void setSmallurl(String str) {
        this.smallurl = str;
    }

    public String getBigurl() {
        return this.bigurl;
    }

    public void setBigurl(String str) {
        this.bigurl = str;
    }

    public String getToServerPhotoInfo() {
        return this.toServerPhotoInfo;
    }

    public void setToServerPhotoInfo(String str) {
        this.toServerPhotoInfo = str;
        ea(str);
    }

    public JSONObject toJson() {
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

    public void parseJson(JSONObject jSONObject) {
        this.smallurl = jSONObject.optString("smallurl", "");
        this.bigurl = jSONObject.optString("bigurl", "");
        this.picId = jSONObject.optString("picId", "");
        this.toServerPhotoInfo = jSONObject.optString("toServerPhotoInfo", "");
        ea(this.toServerPhotoInfo);
    }

    private void ea(String str) {
        if (!StringUtils.isNull(str)) {
            str.replaceAll("#\\(|\\)", "");
            String[] split = str.split(",");
            if (split != null && split.length == 4) {
                this.pic = split[0];
                this.picId = split[1];
                this.width = split[2];
                this.height = split[3];
            }
        }
    }
}
