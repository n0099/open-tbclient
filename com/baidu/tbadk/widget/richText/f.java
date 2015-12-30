package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.lib.a.b.a.a.i {
    private String aEI;
    private String aEJ;
    private String aEK;
    private boolean aEL;
    private boolean aEM;
    private String aEN;
    private long aEO;
    private int mHeight;
    private int mWidth;

    public f() {
        this.aEI = null;
        this.aEJ = null;
        this.aEK = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aEL = false;
        this.aEM = true;
        this.aEN = null;
        this.aEO = 0L;
    }

    public f(PbContent pbContent) {
        this.aEI = null;
        this.aEJ = null;
        this.aEK = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aEL = false;
        this.aEM = true;
        this.aEN = null;
        this.aEO = 0L;
        if (pbContent != null) {
            this.aEI = pbContent.src;
            this.aEJ = pbContent.cdn_src;
            if (this.aEJ == null || this.aEJ.length() == 0) {
                this.aEJ = this.aEI;
            }
            this.aEK = pbContent.big_cdn_src;
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
            if (this.aEJ != null && this.aEJ.indexOf(".baidu.com") != -1) {
                this.aEL = true;
            }
            this.aEN = pbContent.origin_src;
            this.aEO = pbContent.origin_size.intValue();
        }
    }

    public f(JSONObject jSONObject) {
        this.aEI = null;
        this.aEJ = null;
        this.aEK = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aEL = false;
        this.aEM = true;
        this.aEN = null;
        this.aEO = 0L;
        if (jSONObject != null) {
            this.aEI = jSONObject.optString("src");
            this.aEJ = jSONObject.optString("cdn_src", "");
            if (this.aEJ == null || this.aEJ.length() == 0) {
                this.aEJ = this.aEI;
            }
            this.aEK = jSONObject.optString("big_cdn_src", null);
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
            if (this.aEJ != null && this.aEJ.indexOf(".baidu.com") != -1) {
                this.aEL = true;
            }
        }
    }

    public String FO() {
        return this.aEK;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean FP() {
        return this.aEL;
    }

    public String getSrc() {
        return this.aEI;
    }

    public String FQ() {
        return this.aEJ;
    }

    public boolean FR() {
        return this.aEM;
    }

    public String FS() {
        return this.aEN;
    }

    public long getOriginalSize() {
        return this.aEO;
    }
}
