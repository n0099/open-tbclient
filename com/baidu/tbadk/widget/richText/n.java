package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class n {
    private String RK;
    private int aIN;
    private String aIO;
    private int aIP;
    private int aIQ;
    private int duration;
    private int height;
    private String videoUrl;
    private int width;

    public void a(PbContent pbContent) {
        if (pbContent != null) {
            this.videoUrl = pbContent.link;
            this.RK = pbContent.src;
            this.width = pbContent.width.intValue();
            this.height = pbContent.height.intValue();
            this.aIN = pbContent.e_type.intValue();
            this.aIO = pbContent.text;
            this.duration = pbContent.during_time.intValue();
            this.aIP = pbContent.count.intValue();
            this.aIQ = pbContent.origin_size.intValue();
        }
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String qh() {
        return this.RK;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String Ih() {
        return this.aIO;
    }

    public boolean Ii() {
        return this.aIN == 15;
    }

    public boolean isAvaliable() {
        return !StringUtils.isNull(this.videoUrl) && this.width > 0 && this.height > 0;
    }

    public int getDuration() {
        return this.duration;
    }

    public int Ij() {
        return this.aIP;
    }

    public void fB(int i) {
        this.aIP = i;
    }

    public int Ik() {
        return this.aIQ;
    }
}
