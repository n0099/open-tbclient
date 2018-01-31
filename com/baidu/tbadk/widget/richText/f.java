package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class f {
    private String bJA;
    private int bJB;
    private int bJC;
    private String bJy;
    private int bJz;
    private int duration;
    private int height;
    private String videoUrl;
    private int width;

    public void b(PbContent pbContent) {
        if (pbContent != null) {
            this.videoUrl = pbContent.link;
            this.bJy = pbContent.src;
            this.width = pbContent.width.intValue();
            this.height = pbContent.height.intValue();
            this.bJz = pbContent.e_type.intValue();
            this.bJA = pbContent.text;
            this.duration = pbContent.during_time.intValue();
            this.bJB = pbContent.count.intValue();
            this.bJC = pbContent.origin_size.intValue();
        }
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String getThumbUrl() {
        return this.bJy;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String Rq() {
        return this.bJA;
    }

    public boolean Rr() {
        return this.bJz == 15;
    }

    public boolean isAvaliable() {
        return !StringUtils.isNull(this.videoUrl) && this.width > 0 && this.height > 0;
    }

    public int Rs() {
        return this.bJB;
    }

    public void jc(int i) {
        this.bJB = i;
    }
}
