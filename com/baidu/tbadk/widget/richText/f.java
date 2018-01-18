package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class f {
    private String bJq;
    private int bJr;
    private String bJs;
    private int bJt;
    private int bJu;
    private int duration;
    private int height;
    private String videoUrl;
    private int width;

    public void b(PbContent pbContent) {
        if (pbContent != null) {
            this.videoUrl = pbContent.link;
            this.bJq = pbContent.src;
            this.width = pbContent.width.intValue();
            this.height = pbContent.height.intValue();
            this.bJr = pbContent.e_type.intValue();
            this.bJs = pbContent.text;
            this.duration = pbContent.during_time.intValue();
            this.bJt = pbContent.count.intValue();
            this.bJu = pbContent.origin_size.intValue();
        }
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String getThumbUrl() {
        return this.bJq;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String Ro() {
        return this.bJs;
    }

    public boolean Rp() {
        return this.bJr == 15;
    }

    public boolean isAvaliable() {
        return !StringUtils.isNull(this.videoUrl) && this.width > 0 && this.height > 0;
    }

    public int Rq() {
        return this.bJt;
    }

    public void jc(int i) {
        this.bJt = i;
    }
}
