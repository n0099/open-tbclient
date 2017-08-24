package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class e {
    private String Xr;
    private int aRm;
    private String aRn;
    private int aRo;
    private int aRp;
    private int duration;
    private int height;
    private String videoUrl;
    private int width;

    public void a(PbContent pbContent) {
        if (pbContent != null) {
            this.videoUrl = pbContent.link;
            this.Xr = pbContent.src;
            this.width = pbContent.width.intValue();
            this.height = pbContent.height.intValue();
            this.aRm = pbContent.e_type.intValue();
            this.aRn = pbContent.text;
            this.duration = pbContent.during_time.intValue();
            this.aRo = pbContent.count.intValue();
            this.aRp = pbContent.origin_size.intValue();
        }
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String getThumbUrl() {
        return this.Xr;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String IY() {
        return this.aRn;
    }

    public boolean IZ() {
        return this.aRm == 15;
    }

    public boolean isAvaliable() {
        return !StringUtils.isNull(this.videoUrl) && this.width > 0 && this.height > 0;
    }

    public int Ja() {
        return this.aRo;
    }

    public void fE(int i) {
        this.aRo = i;
    }
}
