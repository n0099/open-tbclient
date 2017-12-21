package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class f {
    private String aVu;
    private int aVv;
    private String aVw;
    private int aVx;
    private int aVy;
    private int duration;
    private int height;
    private String videoUrl;
    private int width;

    public void b(PbContent pbContent) {
        if (pbContent != null) {
            this.videoUrl = pbContent.link;
            this.aVu = pbContent.src;
            this.width = pbContent.width.intValue();
            this.height = pbContent.height.intValue();
            this.aVv = pbContent.e_type.intValue();
            this.aVw = pbContent.text;
            this.duration = pbContent.during_time.intValue();
            this.aVx = pbContent.count.intValue();
            this.aVy = pbContent.origin_size.intValue();
        }
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String getThumbUrl() {
        return this.aVu;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String Kd() {
        return this.aVw;
    }

    public boolean Ke() {
        return this.aVv == 15;
    }

    public boolean isAvaliable() {
        return !StringUtils.isNull(this.videoUrl) && this.width > 0 && this.height > 0;
    }

    public int Kf() {
        return this.aVx;
    }

    public void gh(int i) {
        this.aVx = i;
    }
}
