package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.lib.a.b.a.a.i {
    private String aIC;
    private String aID;
    private String aIE;
    private boolean aIF;
    private boolean aIG;
    private String aIH;
    private long aII;
    private int mHeight;
    private int mWidth;

    public g() {
        this.aIC = null;
        this.aID = null;
        this.aIE = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aIF = false;
        this.aIG = false;
        this.aIH = null;
        this.aII = 0L;
    }

    public g(PbContent pbContent) {
        this.aIC = null;
        this.aID = null;
        this.aIE = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aIF = false;
        this.aIG = false;
        this.aIH = null;
        this.aII = 0L;
        if (pbContent != null) {
            this.aIC = pbContent.src;
            this.aID = pbContent.cdn_src;
            if (this.aID == null || this.aID.length() == 0) {
                this.aID = this.aIC;
            }
            this.aIE = pbContent.big_cdn_src;
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
            if (this.aID != null && this.aID.indexOf(".baidu.com") != -1) {
                this.aIF = true;
            }
            this.aIH = pbContent.origin_src;
            this.aII = pbContent.origin_size.intValue();
        }
    }

    public g(JSONObject jSONObject) {
        this.aIC = null;
        this.aID = null;
        this.aIE = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aIF = false;
        this.aIG = false;
        this.aIH = null;
        this.aII = 0L;
        if (jSONObject != null) {
            this.aIC = jSONObject.optString("src");
            this.aID = jSONObject.optString("cdn_src", "");
            if (this.aID == null || this.aID.length() == 0) {
                this.aID = this.aIC;
            }
            this.aIE = jSONObject.optString("big_cdn_src", null);
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
            if (this.aID != null && this.aID.indexOf(".baidu.com") != -1) {
                this.aIF = true;
            }
        }
    }

    public String HO() {
        return this.aIE;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean HP() {
        return this.aIF;
    }

    public String HQ() {
        return this.aIC;
    }

    public String HR() {
        return this.aID;
    }

    public boolean HS() {
        return this.aIG;
    }

    public String HT() {
        return this.aIH;
    }

    public long getOriginalSize() {
        return this.aII;
    }
}
