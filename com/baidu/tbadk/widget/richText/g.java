package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.lib.a.b.a.a.i {
    private String abF;
    private String abG;
    private String abH;
    private boolean abI;
    private int mHeight;
    private int mWidth;

    public g() {
        this.abF = null;
        this.abG = null;
        this.abH = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.abI = false;
    }

    public g(PbContent pbContent) {
        this.abF = null;
        this.abG = null;
        this.abH = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.abI = false;
        if (pbContent != null) {
            this.abF = pbContent.src;
            this.abG = pbContent.cdn_src;
            if (this.abG == null || this.abG.length() == 0) {
                this.abG = this.abF;
            }
            this.abH = pbContent.big_cdn_src;
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
            if (this.abG != null && this.abG.indexOf(".baidu.com") != -1) {
                this.abI = true;
            }
        }
    }

    public g(JSONObject jSONObject) {
        this.abF = null;
        this.abG = null;
        this.abH = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.abI = false;
        if (jSONObject != null) {
            this.abF = jSONObject.optString("src");
            this.abG = jSONObject.optString("cdn_src", "");
            if (this.abG == null || this.abG.length() == 0) {
                this.abG = this.abF;
            }
            this.abH = jSONObject.optString("big_cdn_src", null);
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
            if (this.abG != null && this.abG.indexOf(".baidu.com") != -1) {
                this.abI = true;
            }
        }
    }

    public String vJ() {
        return this.abH;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean vK() {
        return this.abI;
    }

    public String getSrc() {
        return this.abF;
    }

    public String vL() {
        return this.abG;
    }
}
