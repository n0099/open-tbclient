package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class f {
    private String brA;
    private int brB;
    private String brC;
    private int brD;
    private int brE;
    private int duration;
    private int height;
    private String videoUrl;
    private int width;

    public void b(PbContent pbContent) {
        if (pbContent != null) {
            this.videoUrl = pbContent.link;
            this.brA = pbContent.src;
            this.width = pbContent.width.intValue();
            this.height = pbContent.height.intValue();
            this.brB = pbContent.e_type.intValue();
            this.brC = pbContent.text;
            this.duration = pbContent.during_time.intValue();
            this.brD = pbContent.count.intValue();
            this.brE = pbContent.origin_size.intValue();
        }
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String getThumbUrl() {
        return this.brA;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String SP() {
        return this.brC;
    }

    public boolean SQ() {
        return this.brB == 15;
    }

    public boolean isAvaliable() {
        return !StringUtils.isNull(this.videoUrl) && this.width > 0 && this.height > 0;
    }

    public int getDuration() {
        return this.duration;
    }

    public int getFileSize() {
        return this.brE;
    }
}
