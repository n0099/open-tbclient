package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.lib.a.b.a.a.i {
    private String asC;
    private String asD;
    private String asE;
    private boolean asF;
    private boolean asG;
    private int mHeight;
    private int mWidth;

    public g() {
        this.asC = null;
        this.asD = null;
        this.asE = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.asF = false;
        this.asG = true;
    }

    public g(PbContent pbContent) {
        this.asC = null;
        this.asD = null;
        this.asE = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.asF = false;
        this.asG = true;
        if (pbContent != null) {
            this.asC = pbContent.src;
            this.asD = pbContent.cdn_src;
            if (this.asD == null || this.asD.length() == 0) {
                this.asD = this.asC;
            }
            this.asE = pbContent.big_cdn_src;
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
            if (this.asD != null && this.asD.indexOf(".baidu.com") != -1) {
                this.asF = true;
            }
        }
    }

    public g(JSONObject jSONObject) {
        this.asC = null;
        this.asD = null;
        this.asE = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.asF = false;
        this.asG = true;
        if (jSONObject != null) {
            this.asC = jSONObject.optString("src");
            this.asD = jSONObject.optString("cdn_src", "");
            if (this.asD == null || this.asD.length() == 0) {
                this.asD = this.asC;
            }
            this.asE = jSONObject.optString("big_cdn_src", null);
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
            if (this.asD != null && this.asD.indexOf(".baidu.com") != -1) {
                this.asF = true;
            }
        }
    }

    public String DM() {
        return this.asE;
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

    public boolean DN() {
        return this.asF;
    }

    public String getSrc() {
        return this.asC;
    }

    public String DO() {
        return this.asD;
    }

    public boolean DP() {
        return this.asG;
    }

    public void bh(boolean z) {
        this.asG = z;
    }
}
