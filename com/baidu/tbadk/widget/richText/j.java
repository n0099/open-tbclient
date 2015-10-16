package com.baidu.tbadk.widget.richText;

import android.text.SpannableString;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class j {
    private int aBR;
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
            this.aBR = pbContent.e_type.intValue();
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

    public SpannableString fR(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new g(2, this.videoUrl), 0, str.length() - 1, 33);
        return spannableString;
    }

    public boolean Fo() {
        return this.aBR == 12;
    }

    public boolean isAvaliable() {
        return !StringUtils.isNull(this.videoUrl) && !StringUtils.isNull(this.thumbUrl) && this.width > 0 && this.height > 0;
    }
}
