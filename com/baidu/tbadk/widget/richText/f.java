package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class f {
    private String ben;
    private int beo;
    private String bep;
    private int beq;
    private int ber;
    private int duration;
    private int height;
    private String videoUrl;
    private int width;

    public void b(PbContent pbContent) {
        if (pbContent != null) {
            this.videoUrl = pbContent.link;
            this.ben = pbContent.src;
            this.width = pbContent.width.intValue();
            this.height = pbContent.height.intValue();
            this.beo = pbContent.e_type.intValue();
            this.bep = pbContent.text;
            this.duration = pbContent.during_time.intValue();
            this.beq = pbContent.count.intValue();
            this.ber = pbContent.origin_size.intValue();
        }
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String getThumbUrl() {
        return this.ben;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String NS() {
        return this.bep;
    }

    public boolean NT() {
        return this.beo == 15;
    }

    public boolean isAvaliable() {
        return !StringUtils.isNull(this.videoUrl) && this.width > 0 && this.height > 0;
    }
}
