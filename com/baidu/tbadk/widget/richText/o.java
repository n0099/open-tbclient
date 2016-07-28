package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class o {
    private String Oz;
    private int aFU;
    private String aFV;
    private int aFW;
    private int aFX;
    private int duration;
    private int height;
    private String videoUrl;
    private int width;

    public void a(PbContent pbContent) {
        if (pbContent != null) {
            this.videoUrl = pbContent.link;
            this.Oz = pbContent.src;
            this.width = pbContent.width.intValue();
            this.height = pbContent.height.intValue();
            this.aFU = pbContent.e_type.intValue();
            this.aFV = pbContent.text;
            this.duration = pbContent.during_time.intValue();
            this.aFW = pbContent.count.intValue();
            this.aFX = pbContent.origin_size.intValue();
        }
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String oP() {
        return this.Oz;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String Hl() {
        return this.aFV;
    }

    public boolean Hm() {
        return this.aFU == 15;
    }

    public boolean isAvaliable() {
        return !StringUtils.isNull(this.videoUrl) && this.width > 0 && this.height > 0;
    }

    public int getDuration() {
        return this.duration;
    }

    public int Hn() {
        return this.aFW;
    }

    public void fk(int i) {
        this.aFW = i;
    }
}
