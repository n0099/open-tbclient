package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class m {
    private String aDt;
    private int aDu;
    private String aDv;
    private int height;
    private String videoUrl;
    private int width;

    public void b(PbContent pbContent) {
        if (pbContent != null) {
            this.videoUrl = pbContent.link;
            this.aDt = pbContent.src;
            this.width = pbContent.width.intValue();
            this.height = pbContent.height.intValue();
            this.aDu = pbContent.e_type.intValue();
            this.aDv = pbContent.text;
        }
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String Gk() {
        return this.aDt;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String Gl() {
        return this.aDv;
    }

    public boolean Gm() {
        return this.aDu == 15;
    }

    public boolean isAvaliable() {
        return !StringUtils.isNull(this.videoUrl) && this.width > 0 && this.height > 0;
    }
}
