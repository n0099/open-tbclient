package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class e {
    private String Xo;
    private int aRk;
    private String aRl;
    private int aRm;
    private int aRn;
    private int duration;
    private int height;
    private String videoUrl;
    private int width;

    public void a(PbContent pbContent) {
        if (pbContent != null) {
            this.videoUrl = pbContent.link;
            this.Xo = pbContent.src;
            this.width = pbContent.width.intValue();
            this.height = pbContent.height.intValue();
            this.aRk = pbContent.e_type.intValue();
            this.aRl = pbContent.text;
            this.duration = pbContent.during_time.intValue();
            this.aRm = pbContent.count.intValue();
            this.aRn = pbContent.origin_size.intValue();
        }
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String getThumbUrl() {
        return this.Xo;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String IY() {
        return this.aRl;
    }

    public boolean IZ() {
        return this.aRk == 15;
    }

    public boolean isAvaliable() {
        return !StringUtils.isNull(this.videoUrl) && this.width > 0 && this.height > 0;
    }

    public int Ja() {
        return this.aRm;
    }

    public void fE(int i) {
        this.aRm = i;
    }
}
