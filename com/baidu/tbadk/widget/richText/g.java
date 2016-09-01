package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.lib.a.b.a.a.i {
    private String aIV;
    private String aIW;
    private String aIX;
    private boolean aIY;
    private boolean aIZ;
    private String aJa;
    private long aJb;
    private int mHeight;
    private int mWidth;

    public g() {
        this.aIV = null;
        this.aIW = null;
        this.aIX = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aIY = false;
        this.aIZ = true;
        this.aJa = null;
        this.aJb = 0L;
    }

    public g(PbContent pbContent) {
        this.aIV = null;
        this.aIW = null;
        this.aIX = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aIY = false;
        this.aIZ = true;
        this.aJa = null;
        this.aJb = 0L;
        if (pbContent != null) {
            this.aIV = pbContent.src;
            this.aIW = pbContent.cdn_src;
            if (this.aIW == null || this.aIW.length() == 0) {
                this.aIW = this.aIV;
            }
            this.aIX = pbContent.big_cdn_src;
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
            if (this.aIW != null && this.aIW.indexOf(".baidu.com") != -1) {
                this.aIY = true;
            }
            this.aJa = pbContent.origin_src;
            this.aJb = pbContent.origin_size.intValue();
        }
    }

    public g(JSONObject jSONObject) {
        this.aIV = null;
        this.aIW = null;
        this.aIX = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aIY = false;
        this.aIZ = true;
        this.aJa = null;
        this.aJb = 0L;
        if (jSONObject != null) {
            this.aIV = jSONObject.optString("src");
            this.aIW = jSONObject.optString("cdn_src", "");
            if (this.aIW == null || this.aIW.length() == 0) {
                this.aIW = this.aIV;
            }
            this.aIX = jSONObject.optString("big_cdn_src", null);
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
            if (this.aIW != null && this.aIW.indexOf(".baidu.com") != -1) {
                this.aIY = true;
            }
        }
    }

    public String Ir() {
        return this.aIX;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean Is() {
        return this.aIY;
    }

    public String It() {
        return this.aIV;
    }

    public String Iu() {
        return this.aIW;
    }

    public boolean Iv() {
        return this.aIZ;
    }

    public String Iw() {
        return this.aJa;
    }

    public long getOriginalSize() {
        return this.aJb;
    }
}
