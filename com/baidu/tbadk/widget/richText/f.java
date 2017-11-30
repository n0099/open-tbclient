package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class f {
    private String aVp;
    private int aVq;
    private String aVr;
    private int aVs;
    private int aVt;
    private int duration;
    private int height;
    private String videoUrl;
    private int width;

    public void b(PbContent pbContent) {
        if (pbContent != null) {
            this.videoUrl = pbContent.link;
            this.aVp = pbContent.src;
            this.width = pbContent.width.intValue();
            this.height = pbContent.height.intValue();
            this.aVq = pbContent.e_type.intValue();
            this.aVr = pbContent.text;
            this.duration = pbContent.during_time.intValue();
            this.aVs = pbContent.count.intValue();
            this.aVt = pbContent.origin_size.intValue();
        }
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String getThumbUrl() {
        return this.aVp;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String Kc() {
        return this.aVr;
    }

    public boolean Kd() {
        return this.aVq == 15;
    }

    public boolean isAvaliable() {
        return !StringUtils.isNull(this.videoUrl) && this.width > 0 && this.height > 0;
    }

    public int Ke() {
        return this.aVs;
    }

    public void gh(int i) {
        this.aVs = i;
    }
}
