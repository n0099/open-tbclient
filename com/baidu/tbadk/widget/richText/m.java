package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class m {
    private String aES;
    private int aET;
    private String aEU;
    private int height;
    private String videoUrl;
    private int width;

    public void b(PbContent pbContent) {
        if (pbContent != null) {
            this.videoUrl = pbContent.link;
            this.aES = pbContent.src;
            this.width = pbContent.width.intValue();
            this.height = pbContent.height.intValue();
            this.aET = pbContent.e_type.intValue();
            this.aEU = pbContent.text;
        }
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String FZ() {
        return this.aES;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String Ga() {
        return this.aEU;
    }

    public boolean Gb() {
        return this.aET == 15;
    }

    public boolean isAvaliable() {
        return !StringUtils.isNull(this.videoUrl) && this.width > 0 && this.height > 0;
    }
}
