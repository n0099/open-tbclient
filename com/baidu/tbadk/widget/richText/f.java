package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class f {
    private String bfO;
    private int bfP;
    private String bfQ;
    private int bfR;
    private int bfS;
    private int duration;
    private int height;
    private String videoUrl;
    private int width;

    public void b(PbContent pbContent) {
        if (pbContent != null) {
            this.videoUrl = pbContent.link;
            this.bfO = pbContent.src;
            this.width = pbContent.width.intValue();
            this.height = pbContent.height.intValue();
            this.bfP = pbContent.e_type.intValue();
            this.bfQ = pbContent.text;
            this.duration = pbContent.during_time.intValue();
            this.bfR = pbContent.count.intValue();
            this.bfS = pbContent.origin_size.intValue();
        }
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String getThumbUrl() {
        return this.bfO;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String Ol() {
        return this.bfQ;
    }

    public boolean Om() {
        return this.bfP == 15;
    }

    public boolean isAvaliable() {
        return !StringUtils.isNull(this.videoUrl) && this.width > 0 && this.height > 0;
    }

    public int getDuration() {
        return this.duration;
    }

    public int getFileSize() {
        return this.bfS;
    }
}
