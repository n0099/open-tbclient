package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class f {
    private String bJi;
    private int bJj;
    private String bJk;
    private int bJl;
    private int bJm;
    private int duration;
    private int height;
    private String videoUrl;
    private int width;

    public void b(PbContent pbContent) {
        if (pbContent != null) {
            this.videoUrl = pbContent.link;
            this.bJi = pbContent.src;
            this.width = pbContent.width.intValue();
            this.height = pbContent.height.intValue();
            this.bJj = pbContent.e_type.intValue();
            this.bJk = pbContent.text;
            this.duration = pbContent.during_time.intValue();
            this.bJl = pbContent.count.intValue();
            this.bJm = pbContent.origin_size.intValue();
        }
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String getThumbUrl() {
        return this.bJi;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String RA() {
        return this.bJk;
    }

    public boolean RB() {
        return this.bJj == 15;
    }

    public boolean isAvaliable() {
        return !StringUtils.isNull(this.videoUrl) && this.width > 0 && this.height > 0;
    }

    public int RC() {
        return this.bJl;
    }

    public void jg(int i) {
        this.bJl = i;
    }
}
