package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.BdLog;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class l extends com.baidu.adp.lib.a.b.a.a.i {
    private boolean aEv;
    private boolean aEw;
    private String cdn_src;
    private String link;
    private int mHeight;
    private int mWidth;

    public l() {
        this.mWidth = 1;
        this.mHeight = 1;
        this.cdn_src = null;
        this.link = null;
        this.aEv = false;
        this.aEw = true;
    }

    public l(PbContent pbContent) {
        this.mWidth = 1;
        this.mHeight = 1;
        this.cdn_src = null;
        this.link = null;
        this.aEv = false;
        this.aEw = true;
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
            this.aEv = true;
        }
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public String He() {
        return this.cdn_src;
    }

    public String getLink() {
        return this.link;
    }

    public boolean GX() {
        return this.aEw;
    }
}
