package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.lib.a.b.a.a.i {
    private String aui;
    private String auj;
    private String auk;
    private boolean aul;
    private boolean aum;
    private int mHeight;
    private int mWidth;

    public g() {
        this.aui = null;
        this.auj = null;
        this.auk = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aul = false;
        this.aum = true;
    }

    public g(PbContent pbContent) {
        this.aui = null;
        this.auj = null;
        this.auk = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aul = false;
        this.aum = true;
        if (pbContent != null) {
            this.aui = pbContent.src;
            this.auj = pbContent.cdn_src;
            if (this.auj == null || this.auj.length() == 0) {
                this.auj = this.aui;
            }
            this.auk = pbContent.big_cdn_src;
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
            if (this.auj != null && this.auj.indexOf(".baidu.com") != -1) {
                this.aul = true;
            }
        }
    }

    public g(JSONObject jSONObject) {
        this.aui = null;
        this.auj = null;
        this.auk = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aul = false;
        this.aum = true;
        if (jSONObject != null) {
            this.aui = jSONObject.optString("src");
            this.auj = jSONObject.optString("cdn_src", "");
            if (this.auj == null || this.auj.length() == 0) {
                this.auj = this.aui;
            }
            this.auk = jSONObject.optString("big_cdn_src", null);
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
            if (this.auj != null && this.auj.indexOf(".baidu.com") != -1) {
                this.aul = true;
            }
        }
    }

    public String Ew() {
        return this.auk;
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

    public boolean Ex() {
        return this.aul;
    }

    public String getSrc() {
        return this.aui;
    }

    public String Ey() {
        return this.auj;
    }

    public boolean Ez() {
        return this.aum;
    }

    public void bp(boolean z) {
        this.aum = z;
    }
}
