package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class e {
    private String Xq;
    private int aRl;
    private String aRm;
    private int aRn;
    private int aRo;
    private int duration;
    private int height;
    private String videoUrl;
    private int width;

    public void a(PbContent pbContent) {
        if (pbContent != null) {
            this.videoUrl = pbContent.link;
            this.Xq = pbContent.src;
            this.width = pbContent.width.intValue();
            this.height = pbContent.height.intValue();
            this.aRl = pbContent.e_type.intValue();
            this.aRm = pbContent.text;
            this.duration = pbContent.during_time.intValue();
            this.aRn = pbContent.count.intValue();
            this.aRo = pbContent.origin_size.intValue();
        }
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String getThumbUrl() {
        return this.Xq;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String IY() {
        return this.aRm;
    }

    public boolean IZ() {
        return this.aRl == 15;
    }

    public boolean isAvaliable() {
        return !StringUtils.isNull(this.videoUrl) && this.width > 0 && this.height > 0;
    }

    public int Ja() {
        return this.aRn;
    }

    public void fE(int i) {
        this.aRn = i;
    }
}
