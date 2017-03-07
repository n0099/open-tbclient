package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextLinkImageInfo extends OrmObject {
    private boolean aML;
    private boolean aMM;
    private String cdn_src;
    private String link;
    private int mHeight;
    private int mWidth;

    public TbRichTextLinkImageInfo() {
        this.mWidth = 1;
        this.mHeight = 1;
        this.cdn_src = null;
        this.link = null;
        this.aML = false;
        this.aMM = true;
    }

    public TbRichTextLinkImageInfo(PbContent pbContent) {
        this.mWidth = 1;
        this.mHeight = 1;
        this.cdn_src = null;
        this.link = null;
        this.aML = false;
        this.aMM = true;
        this.cdn_src = pbContent.cdn_src;
        this.link = pbContent.link;
        String str = pbContent.bsize;
        if (str != null) {
            try {
                String[] split = str.split(",");
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
            this.aML = true;
        }
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public String Ir() {
        return this.cdn_src;
    }

    public String getLink() {
        return this.link;
    }

    public boolean Ik() {
        return this.aMM;
    }
}
