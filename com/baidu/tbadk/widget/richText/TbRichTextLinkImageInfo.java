package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextLinkImageInfo extends OrmObject {
    private boolean aRx;
    private boolean aRy;
    private String cdn_src;
    private String link;
    private int mHeight;
    private int mWidth;

    public TbRichTextLinkImageInfo() {
        this.mWidth = 1;
        this.mHeight = 1;
        this.cdn_src = null;
        this.link = null;
        this.aRx = false;
        this.aRy = true;
    }

    public TbRichTextLinkImageInfo(PbContent pbContent) {
        this.mWidth = 1;
        this.mHeight = 1;
        this.cdn_src = null;
        this.link = null;
        this.aRx = false;
        this.aRy = true;
        this.cdn_src = pbContent.cdn_src;
        this.link = pbContent.link;
        String str = pbContent.bsize;
        if (str != null) {
            try {
                String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                this.mWidth = Integer.valueOf(split[0]).intValue();
                this.mHeight = Integer.valueOf(split[1]).intValue();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        if (this.mWidth <= 0) {
            this.mWidth = 1;
        }
        if (this.mHeight <= 0) {
            this.mHeight = 1;
        }
        if (this.cdn_src != null && this.cdn_src.indexOf(".baidu.com") != -1) {
            this.aRx = true;
        }
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public String Jb() {
        return this.cdn_src;
    }

    public String getLink() {
        return this.link;
    }

    public boolean IS() {
        return this.aRy;
    }
}
