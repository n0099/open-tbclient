package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class f {
    private String aSg;
    private int aSh;
    private String aSi;
    private int aSj;
    private int aSk;
    private int duration;
    private int height;
    private String videoUrl;
    private int width;

    public void b(PbContent pbContent) {
        if (pbContent != null) {
            this.videoUrl = pbContent.link;
            this.aSg = pbContent.src;
            this.width = pbContent.width.intValue();
            this.height = pbContent.height.intValue();
            this.aSh = pbContent.e_type.intValue();
            this.aSi = pbContent.text;
            this.duration = pbContent.during_time.intValue();
            this.aSj = pbContent.count.intValue();
            this.aSk = pbContent.origin_size.intValue();
        }
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String getThumbUrl() {
        return this.aSg;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String Ju() {
        return this.aSi;
    }

    public boolean Jv() {
        return this.aSh == 15;
    }

    public boolean isAvaliable() {
        return !StringUtils.isNull(this.videoUrl) && this.width > 0 && this.height > 0;
    }

    public int Jw() {
        return this.aSj;
    }

    public void ga(int i) {
        this.aSj = i;
    }
}
