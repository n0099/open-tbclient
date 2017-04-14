package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class e {
    private String Wv;
    private int aNi;
    private String aNj;
    private int aNk;
    private int aNl;
    private int duration;
    private int height;
    private String videoUrl;
    private int width;

    public void a(PbContent pbContent) {
        if (pbContent != null) {
            this.videoUrl = pbContent.link;
            this.Wv = pbContent.src;
            this.width = pbContent.width.intValue();
            this.height = pbContent.height.intValue();
            this.aNi = pbContent.e_type.intValue();
            this.aNj = pbContent.text;
            this.duration = pbContent.during_time.intValue();
            this.aNk = pbContent.count.intValue();
            this.aNl = pbContent.origin_size.intValue();
        }
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String qP() {
        return this.Wv;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String IY() {
        return this.aNj;
    }

    public boolean IZ() {
        return this.aNi == 15;
    }

    public boolean isAvaliable() {
        return !StringUtils.isNull(this.videoUrl) && this.width > 0 && this.height > 0;
    }

    public int Ja() {
        return this.aNk;
    }

    public void fz(int i) {
        this.aNk = i;
    }
}
