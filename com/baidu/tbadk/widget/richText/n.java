package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class n {
    private String TA;
    private int aIC;
    private String aID;
    private int aIE;
    private int aIF;
    private int duration;
    private int height;
    private String videoUrl;
    private int width;

    public void a(PbContent pbContent) {
        if (pbContent != null) {
            this.videoUrl = pbContent.link;
            this.TA = pbContent.src;
            this.width = pbContent.width.intValue();
            this.height = pbContent.height.intValue();
            this.aIC = pbContent.e_type.intValue();
            this.aID = pbContent.text;
            this.duration = pbContent.during_time.intValue();
            this.aIE = pbContent.count.intValue();
            this.aIF = pbContent.origin_size.intValue();
        }
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String rV() {
        return this.TA;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String IU() {
        return this.aID;
    }

    public boolean IV() {
        return this.aIC == 15;
    }

    public boolean isAvaliable() {
        return !StringUtils.isNull(this.videoUrl) && this.width > 0 && this.height > 0;
    }

    public int getDuration() {
        return this.duration;
    }

    public int IW() {
        return this.aIE;
    }

    public void fA(int i) {
        this.aIE = i;
    }
}
