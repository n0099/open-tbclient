package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class f {
    private int cDd;
    private String cDe;
    private int cDf;
    private int cDg;
    private int duration;
    private int height;
    private String thumbUrl;
    private String videoUrl;
    private int width;

    public void b(PbContent pbContent) {
        if (pbContent != null) {
            this.videoUrl = pbContent.link;
            this.thumbUrl = pbContent.src;
            this.width = pbContent.width.intValue();
            this.height = pbContent.height.intValue();
            this.cDd = pbContent.e_type.intValue();
            this.cDe = pbContent.text;
            this.duration = pbContent.during_time.intValue();
            this.cDf = pbContent.count.intValue();
            this.cDg = pbContent.origin_size.intValue();
        }
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String getThumbUrl() {
        return this.thumbUrl;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String atk() {
        return this.cDe;
    }

    public boolean atl() {
        return this.cDd == 15;
    }

    public boolean isAvaliable() {
        return !StringUtils.isNull(this.videoUrl) && this.width > 0 && this.height > 0;
    }

    public int getDuration() {
        return this.duration;
    }

    public int getFileSize() {
        return this.cDg;
    }
}
