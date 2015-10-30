package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.lib.a.b.a.a.i {
    private String aBI;
    private String aBJ;
    private String aBK;
    private boolean aBL;
    private boolean aBM;
    private String aBN;
    private long aBO;
    private int mHeight;
    private int mWidth;

    public f() {
        this.aBI = null;
        this.aBJ = null;
        this.aBK = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aBL = false;
        this.aBM = true;
        this.aBN = null;
        this.aBO = 0L;
    }

    public f(PbContent pbContent) {
        this.aBI = null;
        this.aBJ = null;
        this.aBK = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aBL = false;
        this.aBM = true;
        this.aBN = null;
        this.aBO = 0L;
        if (pbContent != null) {
            this.aBI = pbContent.src;
            this.aBJ = pbContent.cdn_src;
            if (this.aBJ == null || this.aBJ.length() == 0) {
                this.aBJ = this.aBI;
            }
            this.aBK = pbContent.big_cdn_src;
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
            if (this.aBJ != null && this.aBJ.indexOf(".baidu.com") != -1) {
                this.aBL = true;
            }
            this.aBN = pbContent.origin_src;
            this.aBO = pbContent.origin_size.intValue();
        }
    }

    public f(JSONObject jSONObject) {
        this.aBI = null;
        this.aBJ = null;
        this.aBK = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aBL = false;
        this.aBM = true;
        this.aBN = null;
        this.aBO = 0L;
        if (jSONObject != null) {
            this.aBI = jSONObject.optString("src");
            this.aBJ = jSONObject.optString("cdn_src", "");
            if (this.aBJ == null || this.aBJ.length() == 0) {
                this.aBJ = this.aBI;
            }
            this.aBK = jSONObject.optString("big_cdn_src", null);
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
            if (this.aBJ != null && this.aBJ.indexOf(".baidu.com") != -1) {
                this.aBL = true;
            }
        }
    }

    public String Fb() {
        return this.aBK;
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

    public boolean Fc() {
        return this.aBL;
    }

    public String getSrc() {
        return this.aBI;
    }

    public String Fd() {
        return this.aBJ;
    }

    public boolean Fe() {
        return this.aBM;
    }

    public void bt(boolean z) {
        this.aBM = z;
    }

    public String Ff() {
        return this.aBN;
    }

    public long getOriginalSize() {
        return this.aBO;
    }
}
