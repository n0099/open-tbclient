package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class e {
    private String aRG;
    private int aRH;
    private String aRI;
    private int aRJ;
    private int aRK;
    private int duration;
    private int height;
    private String videoUrl;
    private int width;

    public void b(PbContent pbContent) {
        if (pbContent != null) {
            this.videoUrl = pbContent.link;
            this.aRG = pbContent.src;
            this.width = pbContent.width.intValue();
            this.height = pbContent.height.intValue();
            this.aRH = pbContent.e_type.intValue();
            this.aRI = pbContent.text;
            this.duration = pbContent.during_time.intValue();
            this.aRJ = pbContent.count.intValue();
            this.aRK = pbContent.origin_size.intValue();
        }
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String getThumbUrl() {
        return this.aRG;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String Jj() {
        return this.aRI;
    }

    public boolean Jk() {
        return this.aRH == 15;
    }

    public boolean isAvaliable() {
        return !StringUtils.isNull(this.videoUrl) && this.width > 0 && this.height > 0;
    }

    public int Jl() {
        return this.aRJ;
    }

    public void fR(int i) {
        this.aRJ = i;
    }
}
