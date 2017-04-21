package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class e {
    private String Ww;
    private int aNk;
    private String aNl;
    private int aNm;
    private int aNn;
    private int duration;
    private int height;
    private String videoUrl;
    private int width;

    public void a(PbContent pbContent) {
        if (pbContent != null) {
            this.videoUrl = pbContent.link;
            this.Ww = pbContent.src;
            this.width = pbContent.width.intValue();
            this.height = pbContent.height.intValue();
            this.aNk = pbContent.e_type.intValue();
            this.aNl = pbContent.text;
            this.duration = pbContent.during_time.intValue();
            this.aNm = pbContent.count.intValue();
            this.aNn = pbContent.origin_size.intValue();
        }
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String qP() {
        return this.Ww;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String IY() {
        return this.aNl;
    }

    public boolean IZ() {
        return this.aNk == 15;
    }

    public boolean isAvaliable() {
        return !StringUtils.isNull(this.videoUrl) && this.width > 0 && this.height > 0;
    }

    public int Ja() {
        return this.aNm;
    }

    public void fz(int i) {
        this.aNm = i;
    }
}
