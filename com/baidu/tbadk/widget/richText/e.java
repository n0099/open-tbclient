package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class e {
    private String WA;
    private int aQS;
    private String aQT;
    private int aQU;
    private int aQV;
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
            this.aQS = pbContent.e_type.intValue();
            this.aQT = pbContent.text;
            this.duration = pbContent.during_time.intValue();
            this.aQU = pbContent.count.intValue();
            this.aQV = pbContent.origin_size.intValue();
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
        return this.aQT;
    }

    public boolean Jh() {
        return this.aQS == 15;
    }

    public boolean isAvaliable() {
        return !StringUtils.isNull(this.videoUrl) && this.width > 0 && this.height > 0;
    }

    public int Ji() {
        return this.aQU;
    }

    public void fF(int i) {
        this.aQU = i;
    }
}
