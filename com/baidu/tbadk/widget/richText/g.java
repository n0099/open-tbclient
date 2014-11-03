package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.lib.a.b.a.a.i {
    private String abK;
    private String abL;
    private String abM;
    private boolean abN;
    private int mHeight;
    private int mWidth;

    public g() {
        this.abK = null;
        this.abL = null;
        this.abM = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.abN = false;
    }

    public g(PbContent pbContent) {
        this.abK = null;
        this.abL = null;
        this.abM = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.abN = false;
        if (pbContent != null) {
            this.abK = pbContent.src;
            this.abL = pbContent.cdn_src;
            if (this.abL == null || this.abL.length() == 0) {
                this.abL = this.abK;
            }
            this.abM = pbContent.big_cdn_src;
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
            if (this.abL != null && this.abL.indexOf(".baidu.com") != -1) {
                this.abN = true;
            }
        }
    }

    public g(JSONObject jSONObject) {
        this.abK = null;
        this.abL = null;
        this.abM = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.abN = false;
        if (jSONObject != null) {
            this.abK = jSONObject.optString("src");
            this.abL = jSONObject.optString("cdn_src", "");
            if (this.abL == null || this.abL.length() == 0) {
                this.abL = this.abK;
            }
            this.abM = jSONObject.optString("big_cdn_src", null);
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
            if (this.abL != null && this.abL.indexOf(".baidu.com") != -1) {
                this.abN = true;
            }
        }
    }

    public String vL() {
        return this.abM;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean vM() {
        return this.abN;
    }

    public String getSrc() {
        return this.abK;
    }

    public String vN() {
        return this.abL;
    }
}
