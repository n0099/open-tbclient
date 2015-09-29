package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.lib.a.b.a.a.i {
    private boolean aBA;
    private boolean aBB;
    private String aBC;
    private long aBD;
    private String aBx;
    private String aBy;
    private String aBz;
    private int mHeight;
    private int mWidth;

    public f() {
        this.aBx = null;
        this.aBy = null;
        this.aBz = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aBA = false;
        this.aBB = true;
        this.aBC = null;
        this.aBD = 0L;
    }

    public f(PbContent pbContent) {
        this.aBx = null;
        this.aBy = null;
        this.aBz = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aBA = false;
        this.aBB = true;
        this.aBC = null;
        this.aBD = 0L;
        if (pbContent != null) {
            this.aBx = pbContent.src;
            this.aBy = pbContent.cdn_src;
            if (this.aBy == null || this.aBy.length() == 0) {
                this.aBy = this.aBx;
            }
            this.aBz = pbContent.big_cdn_src;
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
            if (this.aBy != null && this.aBy.indexOf(".baidu.com") != -1) {
                this.aBA = true;
            }
            this.aBC = pbContent.origin_src;
            this.aBD = pbContent.origin_size.intValue();
        }
    }

    public f(JSONObject jSONObject) {
        this.aBx = null;
        this.aBy = null;
        this.aBz = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aBA = false;
        this.aBB = true;
        this.aBC = null;
        this.aBD = 0L;
        if (jSONObject != null) {
            this.aBx = jSONObject.optString("src");
            this.aBy = jSONObject.optString("cdn_src", "");
            if (this.aBy == null || this.aBy.length() == 0) {
                this.aBy = this.aBx;
            }
            this.aBz = jSONObject.optString("big_cdn_src", null);
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
            if (this.aBy != null && this.aBy.indexOf(".baidu.com") != -1) {
                this.aBA = true;
            }
        }
    }

    public String Ff() {
        return this.aBz;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public boolean Fg() {
        return this.aBA;
    }

    public String getSrc() {
        return this.aBx;
    }

    public String Fh() {
        return this.aBy;
    }

    public boolean Fi() {
        return this.aBB;
    }

    public void bt(boolean z) {
        this.aBB = z;
    }

    public String Fj() {
        return this.aBC;
    }

    public long getOriginalSize() {
        return this.aBD;
    }
}
