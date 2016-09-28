package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class o {
    private String Rs;
    private int aIF;
    private String aIG;
    private int aIH;
    private int aII;
    private int duration;
    private int height;
    private String videoUrl;
    private int width;

    public void a(PbContent pbContent) {
        if (pbContent != null) {
            this.videoUrl = pbContent.link;
            this.Rs = pbContent.src;
            this.width = pbContent.width.intValue();
            this.height = pbContent.height.intValue();
            this.aIF = pbContent.e_type.intValue();
            this.aIG = pbContent.text;
            this.duration = pbContent.during_time.intValue();
            this.aIH = pbContent.count.intValue();
            this.aII = pbContent.origin_size.intValue();
        }
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String qd() {
        return this.Rs;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String IJ() {
        return this.aIG;
    }

    public boolean IK() {
        return this.aIF == 15;
    }

    public boolean isAvaliable() {
        return !StringUtils.isNull(this.videoUrl) && this.width > 0 && this.height > 0;
    }

    public int getDuration() {
        return this.duration;
    }

    public int IL() {
        return this.aIH;
    }

    public void fz(int i) {
        this.aIH = i;
    }

    public int IM() {
        return this.aII;
    }
}
