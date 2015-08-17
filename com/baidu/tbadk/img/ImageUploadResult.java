package com.baidu.tbadk.img;

import com.baidu.adp.lib.a.b.a.a.i;
import java.io.Serializable;
/* loaded from: classes.dex */
public class ImageUploadResult extends i implements Serializable {
    public long picId;
    public static int INTER_ERROR_FILE_ERROR = -1;
    public static int INTER_ERROR_SEND_ERROR = -2;
    public static int INTER_ERROR_SEND_CALCELLED = -3;
    public static int CHUNK_ERROR = 2230203;
    public int error_code = 0;
    public String error_msg = null;
    public String resourceId = null;
    public int chunkNo = 0;
    public picInfo picInfo = null;

    /* loaded from: classes.dex */
    public static class PicDetailedInfo extends i implements Serializable {
        public int height;
        public String picUrl;
        public int type;
        public int width;
    }

    /* loaded from: classes.dex */
    public static class picInfo extends i implements Serializable {
        public PicDetailedInfo bigPic;
        public PicDetailedInfo originPic;
        public PicDetailedInfo smallPic;
    }

    public UploadedImageInfo getUploadedPicInfo() {
        if (this.picInfo == null || this.error_code != 0) {
            return null;
        }
        UploadedImageInfo uploadedImageInfo = new UploadedImageInfo();
        uploadedImageInfo.setPic_id(String.valueOf(this.picId));
        if (this.picInfo != null && this.picInfo.originPic != null) {
            uploadedImageInfo.setHeight(this.picInfo.originPic.height);
            uploadedImageInfo.setWidth(this.picInfo.originPic.width);
            return uploadedImageInfo;
        }
        return uploadedImageInfo;
    }

    public static ImageUploadResult parser(String str) {
        ImageUploadResult imageUploadResult = new ImageUploadResult();
        try {
            return (ImageUploadResult) i.objectWithJsonStr(str, ImageUploadResult.class);
        } catch (Exception e) {
            e.printStackTrace();
            return imageUploadResult;
        }
    }
}
