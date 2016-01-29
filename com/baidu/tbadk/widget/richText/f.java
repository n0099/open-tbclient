package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.lib.a.b.a.a.i {
    private String aFA;
    private boolean aFB;
    private boolean aFC;
    private String aFD;
    private long aFE;
    private String aFy;
    private String aFz;
    private int mHeight;
    private int mWidth;

    public f() {
        this.aFy = null;
        this.aFz = null;
        this.aFA = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aFB = false;
        this.aFC = true;
        this.aFD = null;
        this.aFE = 0L;
    }

    public f(PbContent pbContent) {
        this.aFy = null;
        this.aFz = null;
        this.aFA = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aFB = false;
        this.aFC = true;
        this.aFD = null;
        this.aFE = 0L;
        if (pbContent != null) {
            this.aFy = pbContent.src;
            this.aFz = pbContent.cdn_src;
            if (this.aFz == null || this.aFz.length() == 0) {
                this.aFz = this.aFy;
            }
            this.aFA = pbContent.big_cdn_src;
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
            if (this.aFz != null && this.aFz.indexOf(".baidu.com") != -1) {
                this.aFB = true;
            }
            this.aFD = pbContent.origin_src;
            this.aFE = pbContent.origin_size.intValue();
        }
    }

    public f(JSONObject jSONObject) {
        this.aFy = null;
        this.aFz = null;
        this.aFA = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aFB = false;
        this.aFC = true;
        this.aFD = null;
        this.aFE = 0L;
        if (jSONObject != null) {
            this.aFy = jSONObject.optString("src");
            this.aFz = jSONObject.optString("cdn_src", "");
            if (this.aFz == null || this.aFz.length() == 0) {
                this.aFz = this.aFy;
            }
            this.aFA = jSONObject.optString("big_cdn_src", null);
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
            if (this.aFz != null && this.aFz.indexOf(".baidu.com") != -1) {
                this.aFB = true;
            }
        }
    }

    public String Hg() {
        return this.aFA;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean Hh() {
        return this.aFB;
    }

    public String getSrc() {
        return this.aFy;
    }

    public String Hi() {
        return this.aFz;
    }

    public boolean Hj() {
        return this.aFC;
    }

    public String Hk() {
        return this.aFD;
    }

    public long getOriginalSize() {
        return this.aFE;
    }
}
