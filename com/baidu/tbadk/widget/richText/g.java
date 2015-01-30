package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.lib.a.b.a.a.i {
    private String ajY;
    private String ajZ;
    private String aka;
    private boolean akb;
    private boolean akc;
    private int mHeight;
    private int mWidth;

    public g() {
        this.ajY = null;
        this.ajZ = null;
        this.aka = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.akb = false;
        this.akc = true;
    }

    public g(PbContent pbContent) {
        this.ajY = null;
        this.ajZ = null;
        this.aka = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.akb = false;
        this.akc = true;
        if (pbContent != null) {
            this.ajY = pbContent.src;
            this.ajZ = pbContent.cdn_src;
            if (this.ajZ == null || this.ajZ.length() == 0) {
                this.ajZ = this.ajY;
            }
            this.aka = pbContent.big_cdn_src;
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
            if (this.ajZ != null && this.ajZ.indexOf(".baidu.com") != -1) {
                this.akb = true;
            }
        }
    }

    public g(JSONObject jSONObject) {
        this.ajY = null;
        this.ajZ = null;
        this.aka = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.akb = false;
        this.akc = true;
        if (jSONObject != null) {
            this.ajY = jSONObject.optString("src");
            this.ajZ = jSONObject.optString("cdn_src", "");
            if (this.ajZ == null || this.ajZ.length() == 0) {
                this.ajZ = this.ajY;
            }
            this.aka = jSONObject.optString("big_cdn_src", null);
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
            if (this.ajZ != null && this.ajZ.indexOf(".baidu.com") != -1) {
                this.akb = true;
            }
        }
    }

    public String Aq() {
        return this.aka;
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

    public boolean Ar() {
        return this.akb;
    }

    public String getSrc() {
        return this.ajY;
    }

    public String As() {
        return this.ajZ;
    }

    public boolean At() {
        return this.akc;
    }

    public void bc(boolean z) {
        this.akc = z;
    }
}
