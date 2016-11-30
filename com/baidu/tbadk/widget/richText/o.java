package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class o {
    private String RO;
    private int aJv;
    private String aJw;
    private int aJx;
    private int aJy;
    private int duration;
    private int height;
    private String videoUrl;
    private int width;

    public void a(PbContent pbContent) {
        if (pbContent != null) {
            this.videoUrl = pbContent.link;
            this.RO = pbContent.src;
            this.width = pbContent.width.intValue();
            this.height = pbContent.height.intValue();
            this.aJv = pbContent.e_type.intValue();
            this.aJw = pbContent.text;
            this.duration = pbContent.during_time.intValue();
            this.aJx = pbContent.count.intValue();
            this.aJy = pbContent.origin_size.intValue();
        }
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String qg() {
        return this.RO;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String IM() {
        return this.aJw;
    }

    public boolean IN() {
        return this.aJv == 15;
    }

    public boolean isAvaliable() {
        return !StringUtils.isNull(this.videoUrl) && this.width > 0 && this.height > 0;
    }

    public int getDuration() {
        return this.duration;
    }

    public int IO() {
        return this.aJx;
    }

    public void fC(int i) {
        this.aJx = i;
    }

    public int IP() {
        return this.aJy;
    }
}
