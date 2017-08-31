package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class e {
    private String WA;
    private int aQV;
    private String aQW;
    private int aQX;
    private int aQY;
    private int duration;
    private int height;
    private String videoUrl;
    private int width;

    public void a(PbContent pbContent) {
        if (pbContent != null) {
            this.videoUrl = pbContent.link;
            this.WA = pbContent.src;
            this.width = pbContent.width.intValue();
            this.height = pbContent.height.intValue();
            this.aQV = pbContent.e_type.intValue();
            this.aQW = pbContent.text;
            this.duration = pbContent.during_time.intValue();
            this.aQX = pbContent.count.intValue();
            this.aQY = pbContent.origin_size.intValue();
        }
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String getThumbUrl() {
        return this.WA;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String Jg() {
        return this.aQW;
    }

    public boolean Jh() {
        return this.aQV == 15;
    }

    public boolean isAvaliable() {
        return !StringUtils.isNull(this.videoUrl) && this.width > 0 && this.height > 0;
    }

    public int Ji() {
        return this.aQX;
    }

    public void fF(int i) {
        this.aQX = i;
    }
}
