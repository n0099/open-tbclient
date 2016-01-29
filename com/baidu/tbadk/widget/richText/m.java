package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class m {
    private String aFI;
    private int aFJ;
    private String aFK;
    private int aFL;
    private int aFM;
    private int duration;
    private int height;
    private String videoUrl;
    private int width;

    public void b(PbContent pbContent) {
        if (pbContent != null) {
            this.videoUrl = pbContent.link;
            this.aFI = pbContent.src;
            this.width = pbContent.width.intValue();
            this.height = pbContent.height.intValue();
            this.aFJ = pbContent.e_type.intValue();
            this.aFK = pbContent.text;
            this.duration = pbContent.during_time.intValue();
            this.aFL = pbContent.count.intValue();
            this.aFM = pbContent.origin_size.intValue();
        }
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String Hx() {
        return this.aFI;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String Hy() {
        return this.aFK;
    }

    public boolean Hz() {
        return this.aFJ == 15;
    }

    public boolean isAvaliable() {
        return !StringUtils.isNull(this.videoUrl) && this.width > 0 && this.height > 0;
    }

    public int getDuration() {
        return this.duration;
    }

    public int HA() {
        return this.aFL;
    }

    public void fn(int i) {
        this.aFL = i;
    }
}
