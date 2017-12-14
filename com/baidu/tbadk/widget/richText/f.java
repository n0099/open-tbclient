package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class f {
    private String aVr;
    private int aVs;
    private String aVt;
    private int aVu;
    private int aVv;
    private int duration;
    private int height;
    private String videoUrl;
    private int width;

    public void b(PbContent pbContent) {
        if (pbContent != null) {
            this.videoUrl = pbContent.link;
            this.aVr = pbContent.src;
            this.width = pbContent.width.intValue();
            this.height = pbContent.height.intValue();
            this.aVs = pbContent.e_type.intValue();
            this.aVt = pbContent.text;
            this.duration = pbContent.during_time.intValue();
            this.aVu = pbContent.count.intValue();
            this.aVv = pbContent.origin_size.intValue();
        }
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String getThumbUrl() {
        return this.aVr;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String Kd() {
        return this.aVt;
    }

    public boolean Ke() {
        return this.aVs == 15;
    }

    public boolean isAvaliable() {
        return !StringUtils.isNull(this.videoUrl) && this.width > 0 && this.height > 0;
    }

    public int Kf() {
        return this.aVu;
    }

    public void gh(int i) {
        this.aVu = i;
    }
}
