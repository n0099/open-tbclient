package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class e {
    private String Wg;
    private int aMS;
    private String aMT;
    private int aMU;
    private int aMV;
    private int duration;
    private int height;
    private String videoUrl;
    private int width;

    public void a(PbContent pbContent) {
        if (pbContent != null) {
            this.videoUrl = pbContent.link;
            this.Wg = pbContent.src;
            this.width = pbContent.width.intValue();
            this.height = pbContent.height.intValue();
            this.aMS = pbContent.e_type.intValue();
            this.aMT = pbContent.text;
            this.duration = pbContent.during_time.intValue();
            this.aMU = pbContent.count.intValue();
            this.aMV = pbContent.origin_size.intValue();
        }
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String qs() {
        return this.Wg;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String Iz() {
        return this.aMT;
    }

    public boolean IA() {
        return this.aMS == 15;
    }

    public boolean isAvaliable() {
        return !StringUtils.isNull(this.videoUrl) && this.width > 0 && this.height > 0;
    }

    public int IB() {
        return this.aMU;
    }

    public void fw(int i) {
        this.aMU = i;
    }
}
