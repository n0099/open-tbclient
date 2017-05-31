package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class e {
    private String VC;
    private int aNA;
    private int aNB;
    private int aNy;
    private String aNz;
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
            this.aNy = pbContent.e_type.intValue();
            this.aNz = pbContent.text;
            this.duration = pbContent.during_time.intValue();
            this.aNA = pbContent.count.intValue();
            this.aNB = pbContent.origin_size.intValue();
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

    public String Ih() {
        return this.aNz;
    }

    public boolean Ii() {
        return this.aNy == 15;
    }

    public boolean isAvaliable() {
        return !StringUtils.isNull(this.videoUrl) && this.width > 0 && this.height > 0;
    }

    public int Ij() {
        return this.aNA;
    }

    public void fx(int i) {
        this.aNA = i;
    }
}
