package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.lib.a.b.a.a.i {
    private String asu;
    private String asv;
    private String asw;
    private boolean asx;
    private boolean asy;
    private int mHeight;
    private int mWidth;

    public g() {
        this.asu = null;
        this.asv = null;
        this.asw = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.asx = false;
        this.asy = true;
    }

    public g(PbContent pbContent) {
        this.asu = null;
        this.asv = null;
        this.asw = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.asx = false;
        this.asy = true;
        if (pbContent != null) {
            this.asu = pbContent.src;
            this.asv = pbContent.cdn_src;
            if (this.asv == null || this.asv.length() == 0) {
                this.asv = this.asu;
            }
            this.asw = pbContent.big_cdn_src;
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
            if (this.asv != null && this.asv.indexOf(".baidu.com") != -1) {
                this.asx = true;
            }
        }
    }

    public g(JSONObject jSONObject) {
        this.asu = null;
        this.asv = null;
        this.asw = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.asx = false;
        this.asy = true;
        if (jSONObject != null) {
            this.asu = jSONObject.optString("src");
            this.asv = jSONObject.optString("cdn_src", "");
            if (this.asv == null || this.asv.length() == 0) {
                this.asv = this.asu;
            }
            this.asw = jSONObject.optString("big_cdn_src", null);
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
            if (this.asv != null && this.asv.indexOf(".baidu.com") != -1) {
                this.asx = true;
            }
        }
    }

    public String DG() {
        return this.asw;
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

    public boolean DH() {
        return this.asx;
    }

    public String getSrc() {
        return this.asu;
    }

    public String DI() {
        return this.asv;
    }

    public boolean DJ() {
        return this.asy;
    }

    public void bh(boolean z) {
        this.asy = z;
    }
}
