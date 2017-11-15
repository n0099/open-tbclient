package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class f {
    private String aSo;
    private int aSp;
    private String aSq;
    private int aSr;
    private int aSs;
    private int duration;
    private int height;
    private String videoUrl;
    private int width;

    public void b(PbContent pbContent) {
        if (pbContent != null) {
            this.videoUrl = pbContent.link;
            this.aSo = pbContent.src;
            this.width = pbContent.width.intValue();
            this.height = pbContent.height.intValue();
            this.aSp = pbContent.e_type.intValue();
            this.aSq = pbContent.text;
            this.duration = pbContent.during_time.intValue();
            this.aSr = pbContent.count.intValue();
            this.aSs = pbContent.origin_size.intValue();
        }
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String getThumbUrl() {
        return this.aSo;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String JF() {
        return this.aSq;
    }

    public boolean JG() {
        return this.aSp == 15;
    }

    public boolean isAvaliable() {
        return !StringUtils.isNull(this.videoUrl) && this.width > 0 && this.height > 0;
    }

    public int JH() {
        return this.aSr;
    }

    public void fZ(int i) {
        this.aSr = i;
    }
}
