package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class e {
    private String VS;
    private int aPX;
    private String aPY;
    private int aPZ;
    private int aQa;
    private int duration;
    private int height;
    private String videoUrl;
    private int width;

    public void a(PbContent pbContent) {
        if (pbContent != null) {
            this.videoUrl = pbContent.link;
            this.VS = pbContent.src;
            this.width = pbContent.width.intValue();
            this.height = pbContent.height.intValue();
            this.aPX = pbContent.e_type.intValue();
            this.aPY = pbContent.text;
            this.duration = pbContent.during_time.intValue();
            this.aPZ = pbContent.count.intValue();
            this.aQa = pbContent.origin_size.intValue();
        }
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String getThumbUrl() {
        return this.VS;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String IR() {
        return this.aPY;
    }

    public boolean IS() {
        return this.aPX == 15;
    }

    public boolean isAvaliable() {
        return !StringUtils.isNull(this.videoUrl) && this.width > 0 && this.height > 0;
    }

    public int IT() {
        return this.aPZ;
    }

    public void fC(int i) {
        this.aPZ = i;
    }
}
