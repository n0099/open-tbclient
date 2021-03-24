package com.baidu.tbadk.img;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ImageUploadResult extends OrmObject implements Serializable {
    public static int CHUNK_ERROR = 2230203;
    public static int INTER_ERROR_FILE_ERROR = -1;
    public static int INTER_ERROR_SEND_CALCELLED = -3;
    public static int INTER_ERROR_SEND_ERROR = -2;
    public String picId;
    public int error_code = 0;
    public String error_msg = null;
    public String resourceId = null;
    public int chunkNo = 0;
    public picInfo picInfo = null;

    /* loaded from: classes3.dex */
    public static class PicDetailedInfo extends OrmObject implements Serializable {
        public int height;
        public String picUrl;
        public int type;
        public int width;

        public void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.width = jSONObject.optInt("width");
            this.height = jSONObject.optInt("height");
            this.picUrl = jSONObject.optString("picUrl");
        }

        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("width", this.width);
                jSONObject.put("height", this.height);
                jSONObject.put("picUrl", this.picUrl);
            } catch (JSONException e2) {
                BdLog.e(e2.getMessage());
            }
            return jSONObject;
        }
    }

    /* loaded from: classes3.dex */
    public static class picInfo extends OrmObject implements Serializable {
        public PicDetailedInfo bigPic;
        public PicDetailedInfo originPic;
        public PicDetailedInfo smallPic;

        public void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            PicDetailedInfo picDetailedInfo = new PicDetailedInfo();
            this.bigPic = picDetailedInfo;
            picDetailedInfo.parseJson(jSONObject.optJSONObject("bigPic"));
            PicDetailedInfo picDetailedInfo2 = new PicDetailedInfo();
            this.smallPic = picDetailedInfo2;
            picDetailedInfo2.parseJson(jSONObject.optJSONObject("smallPic"));
            PicDetailedInfo picDetailedInfo3 = new PicDetailedInfo();
            this.originPic = picDetailedInfo3;
            picDetailedInfo3.parseJson(jSONObject.optJSONObject("originPic"));
        }

        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            try {
                if (this.bigPic != null) {
                    jSONObject.put("bigPic", this.bigPic.toJson());
                }
                if (this.smallPic != null) {
                    jSONObject.put("smallPic", this.smallPic.toJson());
                }
                if (this.originPic != null) {
                    jSONObject.put("originPic", this.originPic.toJson());
                }
            } catch (JSONException e2) {
                BdLog.e(e2.getMessage());
            }
            return jSONObject;
        }
    }

    public static ImageUploadResult parser(String str) {
        ImageUploadResult imageUploadResult = new ImageUploadResult();
        try {
            return (ImageUploadResult) OrmObject.objectWithJsonStr(str, ImageUploadResult.class);
        } catch (Exception e2) {
            e2.printStackTrace();
            return imageUploadResult;
        }
    }

    public UploadedImageInfo getUploadedPicInfo() {
        PicDetailedInfo picDetailedInfo;
        if (this.picInfo == null || this.error_code != 0) {
            return null;
        }
        UploadedImageInfo uploadedImageInfo = new UploadedImageInfo();
        uploadedImageInfo.setPic_id(String.valueOf(this.picId));
        picInfo picinfo = this.picInfo;
        if (picinfo != null && (picDetailedInfo = picinfo.originPic) != null) {
            uploadedImageInfo.setHeight(picDetailedInfo.height);
            uploadedImageInfo.setWidth(this.picInfo.originPic.width);
        }
        return uploadedImageInfo;
    }
}
