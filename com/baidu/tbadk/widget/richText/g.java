package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.lib.a.b.a.a.i {
    private String aIs;
    private String aIt;
    private String aIu;
    private boolean aIv;
    private boolean aIw;
    private String aIx;
    private long aIy;
    private int mHeight;
    private int mWidth;

    public g() {
        this.aIs = null;
        this.aIt = null;
        this.aIu = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aIv = false;
        this.aIw = true;
        this.aIx = null;
        this.aIy = 0L;
    }

    public g(PbContent pbContent) {
        this.aIs = null;
        this.aIt = null;
        this.aIu = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aIv = false;
        this.aIw = true;
        this.aIx = null;
        this.aIy = 0L;
        if (pbContent != null) {
            this.aIs = pbContent.src;
            this.aIt = pbContent.cdn_src;
            if (this.aIt == null || this.aIt.length() == 0) {
                this.aIt = this.aIs;
            }
            this.aIu = pbContent.big_cdn_src;
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
            if (this.aIt != null && this.aIt.indexOf(".baidu.com") != -1) {
                this.aIv = true;
            }
            this.aIx = pbContent.origin_src;
            this.aIy = pbContent.origin_size.intValue();
        }
    }

    public g(JSONObject jSONObject) {
        this.aIs = null;
        this.aIt = null;
        this.aIu = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aIv = false;
        this.aIw = true;
        this.aIx = null;
        this.aIy = 0L;
        if (jSONObject != null) {
            this.aIs = jSONObject.optString("src");
            this.aIt = jSONObject.optString("cdn_src", "");
            if (this.aIt == null || this.aIt.length() == 0) {
                this.aIt = this.aIs;
            }
            this.aIu = jSONObject.optString("big_cdn_src", null);
            try {
                String[] split = jSONObject.optString("bsize").split(",");
                this.mWidth = Integer.valueOf(split[0]).intValue();
                this.mHeight = Integer.valueOf(split[1]).intValue();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            if (this.mWidth <= 0) {
                this.mWidth = 1;
            }
            if (this.mHeight <= 0) {
                this.mHeight = 1;
            }
            if (this.aIt != null && this.aIt.indexOf(".baidu.com") != -1) {
                this.aIv = true;
            }
        }
    }

    public String IB() {
        return this.aIu;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean IC() {
        return this.aIv;
    }

    public String getSrc() {
        return this.aIs;
    }

    public String IE() {
        return this.aIt;
    }

    public boolean IF() {
        return this.aIw;
    }

    public String IG() {
        return this.aIx;
    }

    public long getOriginalSize() {
        return this.aIy;
    }
}
