package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class e {
    private String aRT;
    private int aRU;
    private String aRV;
    private int aRW;
    private int aRX;
    private int duration;
    private int height;
    private String videoUrl;
    private int width;

    public void b(PbContent pbContent) {
        if (pbContent != null) {
            this.videoUrl = pbContent.link;
            this.aRT = pbContent.src;
            this.width = pbContent.width.intValue();
            this.height = pbContent.height.intValue();
            this.aRU = pbContent.e_type.intValue();
            this.aRV = pbContent.text;
            this.duration = pbContent.during_time.intValue();
            this.aRW = pbContent.count.intValue();
            this.aRX = pbContent.origin_size.intValue();
        }
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String getThumbUrl() {
        return this.aRT;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String Jp() {
        return this.aRV;
    }

    public boolean Jq() {
        return this.aRU == 15;
    }

    public boolean isAvaliable() {
        return !StringUtils.isNull(this.videoUrl) && this.width > 0 && this.height > 0;
    }

    public int Jr() {
        return this.aRW;
    }

    public void fS(int i) {
        this.aRW = i;
    }
}
