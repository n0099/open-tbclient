package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.lib.a.b.a.a.i {
    private String aFK;
    private String aFL;
    private String aFM;
    private boolean aFN;
    private boolean aFO;
    private String aFP;
    private long aFQ;
    private int mHeight;
    private int mWidth;

    public g() {
        this.aFK = null;
        this.aFL = null;
        this.aFM = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aFN = false;
        this.aFO = true;
        this.aFP = null;
        this.aFQ = 0L;
    }

    public g(PbContent pbContent) {
        this.aFK = null;
        this.aFL = null;
        this.aFM = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aFN = false;
        this.aFO = true;
        this.aFP = null;
        this.aFQ = 0L;
        if (pbContent != null) {
            this.aFK = pbContent.src;
            this.aFL = pbContent.cdn_src;
            if (this.aFL == null || this.aFL.length() == 0) {
                this.aFL = this.aFK;
            }
            this.aFM = pbContent.big_cdn_src;
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
            if (this.aFL != null && this.aFL.indexOf(".baidu.com") != -1) {
                this.aFN = true;
            }
            this.aFP = pbContent.origin_src;
            this.aFQ = pbContent.origin_size.intValue();
        }
    }

    public g(JSONObject jSONObject) {
        this.aFK = null;
        this.aFL = null;
        this.aFM = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aFN = false;
        this.aFO = true;
        this.aFP = null;
        this.aFQ = 0L;
        if (jSONObject != null) {
            this.aFK = jSONObject.optString("src");
            this.aFL = jSONObject.optString("cdn_src", "");
            if (this.aFL == null || this.aFL.length() == 0) {
                this.aFL = this.aFK;
            }
            this.aFM = jSONObject.optString("big_cdn_src", null);
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
            if (this.aFL != null && this.aFL.indexOf(".baidu.com") != -1) {
                this.aFN = true;
            }
        }
    }

    public String GT() {
        return this.aFM;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean GU() {
        return this.aFN;
    }

    public String getSrc() {
        return this.aFK;
    }

    public String GV() {
        return this.aFL;
    }

    public boolean GW() {
        return this.aFO;
    }

    public String GX() {
        return this.aFP;
    }

    public long getOriginalSize() {
        return this.aFQ;
    }
}
