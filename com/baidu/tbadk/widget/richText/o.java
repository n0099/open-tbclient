package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class o {
    private String Rm;
    private int aJg;
    private String aJh;
    private int aJi;
    private int aJj;
    private int duration;
    private int height;
    private String videoUrl;
    private int width;

    public void a(PbContent pbContent) {
        if (pbContent != null) {
            this.videoUrl = pbContent.link;
            this.Rm = pbContent.src;
            this.width = pbContent.width.intValue();
            this.height = pbContent.height.intValue();
            this.aJg = pbContent.e_type.intValue();
            this.aJh = pbContent.text;
            this.duration = pbContent.during_time.intValue();
            this.aJi = pbContent.count.intValue();
            this.aJj = pbContent.origin_size.intValue();
        }
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String pS() {
        return this.Rm;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String IK() {
        return this.aJh;
    }

    public boolean IL() {
        return this.aJg == 15;
    }

    public boolean isAvaliable() {
        return !StringUtils.isNull(this.videoUrl) && this.width > 0 && this.height > 0;
    }

    public int getDuration() {
        return this.duration;
    }

    public int IM() {
        return this.aJi;
    }

    public void fA(int i) {
        this.aJi = i;
    }
}
