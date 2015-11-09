package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.lib.a.b.a.a.i {
    private String aAA;
    private String aAB;
    private boolean aAC;
    private boolean aAD;
    private String aAE;
    private long aAF;
    private String aAz;
    private int mHeight;
    private int mWidth;

    public f() {
        this.aAz = null;
        this.aAA = null;
        this.aAB = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aAC = false;
        this.aAD = true;
        this.aAE = null;
        this.aAF = 0L;
    }

    public f(PbContent pbContent) {
        this.aAz = null;
        this.aAA = null;
        this.aAB = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aAC = false;
        this.aAD = true;
        this.aAE = null;
        this.aAF = 0L;
        if (pbContent != null) {
            this.aAz = pbContent.src;
            this.aAA = pbContent.cdn_src;
            if (this.aAA == null || this.aAA.length() == 0) {
                this.aAA = this.aAz;
            }
            this.aAB = pbContent.big_cdn_src;
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
            if (this.aAA != null && this.aAA.indexOf(".baidu.com") != -1) {
                this.aAC = true;
            }
            this.aAE = pbContent.origin_src;
            this.aAF = pbContent.origin_size.intValue();
        }
    }

    public f(JSONObject jSONObject) {
        this.aAz = null;
        this.aAA = null;
        this.aAB = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aAC = false;
        this.aAD = true;
        this.aAE = null;
        this.aAF = 0L;
        if (jSONObject != null) {
            this.aAz = jSONObject.optString("src");
            this.aAA = jSONObject.optString("cdn_src", "");
            if (this.aAA == null || this.aAA.length() == 0) {
                this.aAA = this.aAz;
            }
            this.aAB = jSONObject.optString("big_cdn_src", null);
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
            if (this.aAA != null && this.aAA.indexOf(".baidu.com") != -1) {
                this.aAC = true;
            }
        }
    }

    public String EW() {
        return this.aAB;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean EX() {
        return this.aAC;
    }

    public String getSrc() {
        return this.aAz;
    }

    public String EY() {
        return this.aAA;
    }

    public boolean EZ() {
        return this.aAD;
    }

    public String Fa() {
        return this.aAE;
    }

    public long getOriginalSize() {
        return this.aAF;
    }
}
