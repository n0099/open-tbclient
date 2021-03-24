package com.baidu.tieba.faceshop.emotiondetail.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
/* loaded from: classes4.dex */
public class EmotionDetailData extends OrmObject {
    public String error;
    public String no;
    public PckInfo pck_info;
    public PicInfo pic_info;

    /* loaded from: classes4.dex */
    public static class PckInfo extends OrmObject {
        public String cover;
        public String download;
        public String forum_avatar;
        public String forum_name;
        public Owner owner;
        public int pck_id;
        public String pck_name;
        public String status;
        public String type;

        /* loaded from: classes4.dex */
        public static class Owner extends OrmObject {
            public String user_id;
            public String user_name;
            public String user_name_show;
        }
    }

    /* loaded from: classes4.dex */
    public static class PicInfo extends OrmObject {
        public int height;
        public long pic_id;
        public String pic_url;
        public String thumbnail;
        public int type;
        public int width;
    }
}
