package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class e {
    private String QU;
    private int aHu;
    private String aHv;
    private int aHw;
    private int aHx;
    private int duration;
    private int height;
    private String videoUrl;
    private int width;

    public void a(PbContent pbContent) {
        if (pbContent != null) {
            this.videoUrl = pbContent.link;
            this.QU = pbContent.src;
            this.width = pbContent.width.intValue();
            this.height = pbContent.height.intValue();
            this.aHu = pbContent.e_type.intValue();
            this.aHv = pbContent.text;
            this.duration = pbContent.during_time.intValue();
            this.aHw = pbContent.count.intValue();
            this.aHx = pbContent.origin_size.intValue();
        }
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String qa() {
        return this.QU;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String HZ() {
        return this.aHv;
    }

    public boolean Ia() {
        return this.aHu == 15;
    }

    public boolean isAvaliable() {
        return !StringUtils.isNull(this.videoUrl) && this.width > 0 && this.height > 0;
    }

    public int Ib() {
        return this.aHw;
    }

    public void fC(int i) {
        this.aHw = i;
    }
}
