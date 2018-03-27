package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class f {
    private String bLt;
    private int bLu;
    private String bLv;
    private int bLw;
    private int bLx;
    private int duration;
    private int height;
    private String videoUrl;
    private int width;

    public void b(PbContent pbContent) {
        if (pbContent != null) {
            this.videoUrl = pbContent.link;
            this.bLt = pbContent.src;
            this.width = pbContent.width.intValue();
            this.height = pbContent.height.intValue();
            this.bLu = pbContent.e_type.intValue();
            this.bLv = pbContent.text;
            this.duration = pbContent.during_time.intValue();
            this.bLw = pbContent.count.intValue();
            this.bLx = pbContent.origin_size.intValue();
        }
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String getThumbUrl() {
        return this.bLt;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String RV() {
        return this.bLv;
    }

    public boolean RW() {
        return this.bLu == 15;
    }

    public boolean isAvaliable() {
        return !StringUtils.isNull(this.videoUrl) && this.width > 0 && this.height > 0;
    }
}
