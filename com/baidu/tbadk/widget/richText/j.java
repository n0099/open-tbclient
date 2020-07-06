package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class j {
    private int duration;
    private int eOA;
    private int eOy;
    private String eOz;
    private int height;
    private int playCount;
    private String thumbUrl;
    private String videoUrl;
    private int width;

    public void b(PbContent pbContent) {
        if (pbContent != null) {
            this.videoUrl = pbContent.link;
            this.thumbUrl = pbContent.src;
            this.width = pbContent.width.intValue();
            this.height = pbContent.height.intValue();
            this.eOy = pbContent.e_type.intValue();
            this.eOz = pbContent.text;
            this.duration = pbContent.during_time.intValue();
            this.playCount = pbContent.count.intValue();
            this.eOA = pbContent.origin_size.intValue();
        }
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String getThumbUrl() {
        return this.thumbUrl;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String blG() {
        return this.eOz;
    }

    public boolean blH() {
        return this.eOy == 15;
    }

    public boolean isAvaliable() {
        return !StringUtils.isNull(this.videoUrl) && this.width > 0 && this.height > 0;
    }

    public int getDuration() {
        return this.duration;
    }

    public int getFileSize() {
        return this.eOA;
    }
}
