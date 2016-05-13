package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class o {
    private String Oo;
    private int aEC;
    private String aED;
    private int aEE;
    private int aEF;
    private int duration;
    private int height;
    private String videoUrl;
    private int width;

    public void a(PbContent pbContent) {
        if (pbContent != null) {
            this.videoUrl = pbContent.link;
            this.Oo = pbContent.src;
            this.width = pbContent.width.intValue();
            this.height = pbContent.height.intValue();
            this.aEC = pbContent.e_type.intValue();
            this.aED = pbContent.text;
            this.duration = pbContent.during_time.intValue();
            this.aEE = pbContent.count.intValue();
            this.aEF = pbContent.origin_size.intValue();
        }
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String po() {
        return this.Oo;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String Hm() {
        return this.aED;
    }

    public boolean Hn() {
        return this.aEC == 15;
    }

    public boolean isAvaliable() {
        return !StringUtils.isNull(this.videoUrl) && this.width > 0 && this.height > 0;
    }

    public int getDuration() {
        return this.duration;
    }

    public int Ho() {
        return this.aEE;
    }

    public void ff(int i) {
        this.aEE = i;
    }
}
