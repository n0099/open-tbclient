package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbContent;
/* loaded from: classes2.dex */
public class j {
    private int bTC;
    private int duration;
    private int ffB;
    private String ffC;
    private int ffD;
    private int height;
    private String thumbUrl;
    private String videoUrl;
    private int width;

    public void b(PbContent pbContent) {
        if (pbContent != null) {
            this.videoUrl = pbContent.link;
            this.thumbUrl = pbContent.src;
            this.width = pbContent.width.intValue();
            this.height = pbContent.height.intValue();
            this.ffB = pbContent.e_type.intValue();
            this.ffC = pbContent.text;
            this.duration = pbContent.during_time.intValue();
            this.bTC = pbContent.count.intValue();
            this.ffD = pbContent.origin_size.intValue();
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

    public String byo() {
        return this.ffC;
    }

    public boolean byp() {
        return this.ffB == 15;
    }

    public boolean isAvaliable() {
        return !StringUtils.isNull(this.videoUrl) && this.width > 0 && this.height > 0;
    }

    public int getDuration() {
        return this.duration;
    }

    public int getFileSize() {
        return this.ffD;
    }
}
