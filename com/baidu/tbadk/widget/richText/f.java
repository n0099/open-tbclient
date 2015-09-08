package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.lib.a.b.a.a.i {
    private String aDe;
    private String aDf;
    private String aDg;
    private boolean aDh;
    private boolean aDi;
    private int mHeight;
    private int mWidth;

    public f() {
        this.aDe = null;
        this.aDf = null;
        this.aDg = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aDh = false;
        this.aDi = true;
    }

    public f(PbContent pbContent) {
        this.aDe = null;
        this.aDf = null;
        this.aDg = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aDh = false;
        this.aDi = true;
        if (pbContent != null) {
            this.aDe = pbContent.src;
            this.aDf = pbContent.cdn_src;
            if (this.aDf == null || this.aDf.length() == 0) {
                this.aDf = this.aDe;
            }
            this.aDg = pbContent.big_cdn_src;
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
            if (this.aDf != null && this.aDf.indexOf(".baidu.com") != -1) {
                this.aDh = true;
            }
        }
    }

    public f(JSONObject jSONObject) {
        this.aDe = null;
        this.aDf = null;
        this.aDg = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aDh = false;
        this.aDi = true;
        if (jSONObject != null) {
            this.aDe = jSONObject.optString("src");
            this.aDf = jSONObject.optString("cdn_src", "");
            if (this.aDf == null || this.aDf.length() == 0) {
                this.aDf = this.aDe;
            }
            this.aDg = jSONObject.optString("big_cdn_src", null);
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
            if (this.aDf != null && this.aDf.indexOf(".baidu.com") != -1) {
                this.aDh = true;
            }
        }
    }

    public String Fs() {
        return this.aDg;
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

    public boolean Ft() {
        return this.aDh;
    }

    public String getSrc() {
        return this.aDe;
    }

    public String Fu() {
        return this.aDf;
    }

    public boolean Fv() {
        return this.aDi;
    }

    public void bx(boolean z) {
        this.aDi = z;
    }
}
