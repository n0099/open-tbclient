package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class o {
    private String On;
    private int aFd;
    private String aFe;
    private int aFf;
    private int aFg;
    private int duration;
    private int height;
    private String videoUrl;
    private int width;

    public void a(PbContent pbContent) {
        if (pbContent != null) {
            this.videoUrl = pbContent.link;
            this.On = pbContent.src;
            this.width = pbContent.width.intValue();
            this.height = pbContent.height.intValue();
            this.aFd = pbContent.e_type.intValue();
            this.aFe = pbContent.text;
            this.duration = pbContent.during_time.intValue();
            this.aFf = pbContent.count.intValue();
            this.aFg = pbContent.origin_size.intValue();
        }
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String pg() {
        return this.On;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String Hn() {
        return this.aFe;
    }

    public boolean Ho() {
        return this.aFd == 15;
    }

    public boolean isAvaliable() {
        return !StringUtils.isNull(this.videoUrl) && this.width > 0 && this.height > 0;
    }

    public int getDuration() {
        return this.duration;
    }

    public int Hp() {
        return this.aFf;
    }

    public void fl(int i) {
        this.aFf = i;
    }
}
