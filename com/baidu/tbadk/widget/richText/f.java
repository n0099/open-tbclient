package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.lib.a.b.a.a.i {
    private boolean aBA;
    private String aBw;
    private String aBx;
    private String aBy;
    private boolean aBz;
    private int mHeight;
    private int mWidth;

    public f() {
        this.aBw = null;
        this.aBx = null;
        this.aBy = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aBz = false;
        this.aBA = true;
    }

    public f(PbContent pbContent) {
        this.aBw = null;
        this.aBx = null;
        this.aBy = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aBz = false;
        this.aBA = true;
        if (pbContent != null) {
            this.aBw = pbContent.src;
            this.aBx = pbContent.cdn_src;
            if (this.aBx == null || this.aBx.length() == 0) {
                this.aBx = this.aBw;
            }
            this.aBy = pbContent.big_cdn_src;
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
            if (this.aBx != null && this.aBx.indexOf(".baidu.com") != -1) {
                this.aBz = true;
            }
        }
    }

    public f(JSONObject jSONObject) {
        this.aBw = null;
        this.aBx = null;
        this.aBy = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aBz = false;
        this.aBA = true;
        if (jSONObject != null) {
            this.aBw = jSONObject.optString("src");
            this.aBx = jSONObject.optString("cdn_src", "");
            if (this.aBx == null || this.aBx.length() == 0) {
                this.aBx = this.aBw;
            }
            this.aBy = jSONObject.optString("big_cdn_src", null);
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
            if (this.aBx != null && this.aBx.indexOf(".baidu.com") != -1) {
                this.aBz = true;
            }
        }
    }

    public String Fi() {
        return this.aBy;
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

    public boolean Fj() {
        return this.aBz;
    }

    public String getSrc() {
        return this.aBw;
    }

    public String Fk() {
        return this.aBx;
    }

    public boolean Fl() {
        return this.aBA;
    }

    public void bq(boolean z) {
        this.aBA = z;
    }
}
