package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class e {
    private String VP;
    private int aNB;
    private String aNC;
    private int aND;
    private int aNE;
    private int duration;
    private int height;
    private String videoUrl;
    private int width;

    public void a(PbContent pbContent) {
        if (pbContent != null) {
            this.videoUrl = pbContent.link;
            this.VP = pbContent.src;
            this.width = pbContent.width.intValue();
            this.height = pbContent.height.intValue();
            this.aNB = pbContent.e_type.intValue();
            this.aNC = pbContent.text;
            this.duration = pbContent.during_time.intValue();
            this.aND = pbContent.count.intValue();
            this.aNE = pbContent.origin_size.intValue();
        }
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String qc() {
        return this.VP;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String Im() {
        return this.aNC;
    }

    public boolean In() {
        return this.aNB == 15;
    }

    public boolean isAvaliable() {
        return !StringUtils.isNull(this.videoUrl) && this.width > 0 && this.height > 0;
    }

    public int Io() {
        return this.aND;
    }

    public void fw(int i) {
        this.aND = i;
    }
}
