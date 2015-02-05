package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.lib.a.b.a.a.i {
    private String ajV;
    private String ajW;
    private String ajX;
    private boolean ajY;
    private boolean ajZ;
    private int mHeight;
    private int mWidth;

    public g() {
        this.ajV = null;
        this.ajW = null;
        this.ajX = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.ajY = false;
        this.ajZ = true;
    }

    public g(PbContent pbContent) {
        this.ajV = null;
        this.ajW = null;
        this.ajX = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.ajY = false;
        this.ajZ = true;
        if (pbContent != null) {
            this.ajV = pbContent.src;
            this.ajW = pbContent.cdn_src;
            if (this.ajW == null || this.ajW.length() == 0) {
                this.ajW = this.ajV;
            }
            this.ajX = pbContent.big_cdn_src;
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
            if (this.ajW != null && this.ajW.indexOf(".baidu.com") != -1) {
                this.ajY = true;
            }
        }
    }

    public g(JSONObject jSONObject) {
        this.ajV = null;
        this.ajW = null;
        this.ajX = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.ajY = false;
        this.ajZ = true;
        if (jSONObject != null) {
            this.ajV = jSONObject.optString("src");
            this.ajW = jSONObject.optString("cdn_src", "");
            if (this.ajW == null || this.ajW.length() == 0) {
                this.ajW = this.ajV;
            }
            this.ajX = jSONObject.optString("big_cdn_src", null);
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
            if (this.ajW != null && this.ajW.indexOf(".baidu.com") != -1) {
                this.ajY = true;
            }
        }
    }

    public String Ak() {
        return this.ajX;
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

    public boolean Al() {
        return this.ajY;
    }

    public String getSrc() {
        return this.ajV;
    }

    public String Am() {
        return this.ajW;
    }

    public boolean An() {
        return this.ajZ;
    }

    public void bc(boolean z) {
        this.ajZ = z;
    }
}
