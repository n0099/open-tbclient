package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class e {
    private String VC;
    private int aOO;
    private String aOP;
    private int aOQ;
    private int aOR;
    private int duration;
    private int height;
    private String videoUrl;
    private int width;

    public void a(PbContent pbContent) {
        if (pbContent != null) {
            this.videoUrl = pbContent.link;
            this.VC = pbContent.src;
            this.width = pbContent.width.intValue();
            this.height = pbContent.height.intValue();
            this.aOO = pbContent.e_type.intValue();
            this.aOP = pbContent.text;
            this.duration = pbContent.during_time.intValue();
            this.aOQ = pbContent.count.intValue();
            this.aOR = pbContent.origin_size.intValue();
        }
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String getThumbUrl() {
        return this.VC;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String IF() {
        return this.aOP;
    }

    public boolean IG() {
        return this.aOO == 15;
    }

    public boolean isAvaliable() {
        return !StringUtils.isNull(this.videoUrl) && this.width > 0 && this.height > 0;
    }

    public int IH() {
        return this.aOQ;
    }

    public void fz(int i) {
        this.aOQ = i;
    }
}
