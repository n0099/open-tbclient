package com.baidu.tieba.im.data;

import com.google.gson.GsonBuilder;
import java.io.Serializable;
/* loaded from: classes.dex */
public class UploadPicData2 implements Serializable {
    public long picId;
    public int error_code = 0;
    public String error_msg = null;
    public String resourceId = null;
    public int chunkNo = 0;
    public picInfo picInfo = null;

    /* loaded from: classes.dex */
    public class PicDetailedInfo implements Serializable {
        public int height;
        public String picUrl;
        public int type;
        public int width;
    }

    /* loaded from: classes.dex */
    public class picInfo implements Serializable {
        public PicDetailedInfo bigPic;
        public PicDetailedInfo originPic;
        public PicDetailedInfo smallPic;
    }

    public static UploadPicData2 parser(String str) {
        return (UploadPicData2) new GsonBuilder().create().fromJson(str, (Class<Object>) UploadPicData2.class);
    }
}
