package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.lib.a.b.a.a.i {
    private String ajv;
    private String ajw;
    private String ajx;
    private boolean ajy;
    private boolean ajz;
    private int mHeight;
    private int mWidth;

    public g() {
        this.ajv = null;
        this.ajw = null;
        this.ajx = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.ajy = false;
        this.ajz = true;
    }

    public g(PbContent pbContent) {
        this.ajv = null;
        this.ajw = null;
        this.ajx = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.ajy = false;
        this.ajz = true;
        if (pbContent != null) {
            this.ajv = pbContent.src;
            this.ajw = pbContent.cdn_src;
            if (this.ajw == null || this.ajw.length() == 0) {
                this.ajw = this.ajv;
            }
            this.ajx = pbContent.big_cdn_src;
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
            if (this.ajw != null && this.ajw.indexOf(".baidu.com") != -1) {
                this.ajy = true;
            }
        }
    }

    public g(JSONObject jSONObject) {
        this.ajv = null;
        this.ajw = null;
        this.ajx = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.ajy = false;
        this.ajz = true;
        if (jSONObject != null) {
            this.ajv = jSONObject.optString("src");
            this.ajw = jSONObject.optString("cdn_src", "");
            if (this.ajw == null || this.ajw.length() == 0) {
                this.ajw = this.ajv;
            }
            this.ajx = jSONObject.optString("big_cdn_src", null);
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
            if (this.ajw != null && this.ajw.indexOf(".baidu.com") != -1) {
                this.ajy = true;
            }
        }
    }

    public String zW() {
        return this.ajx;
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

    public boolean zX() {
        return this.ajy;
    }

    public String getSrc() {
        return this.ajv;
    }

    public String zY() {
        return this.ajw;
    }

    public boolean zZ() {
        return this.ajz;
    }

    public void ba(boolean z) {
        this.ajz = z;
    }
}
