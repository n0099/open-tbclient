package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.lib.a.b.a.a.i {
    private String aET;
    private String aEU;
    private String aEV;
    private boolean aEW;
    private boolean aEX;
    private String aEY;
    private long aEZ;
    private int mHeight;
    private int mWidth;

    public g() {
        this.aET = null;
        this.aEU = null;
        this.aEV = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aEW = false;
        this.aEX = true;
        this.aEY = null;
        this.aEZ = 0L;
    }

    public g(PbContent pbContent) {
        this.aET = null;
        this.aEU = null;
        this.aEV = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aEW = false;
        this.aEX = true;
        this.aEY = null;
        this.aEZ = 0L;
        if (pbContent != null) {
            this.aET = pbContent.src;
            this.aEU = pbContent.cdn_src;
            if (this.aEU == null || this.aEU.length() == 0) {
                this.aEU = this.aET;
            }
            this.aEV = pbContent.big_cdn_src;
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
            if (this.aEU != null && this.aEU.indexOf(".baidu.com") != -1) {
                this.aEW = true;
            }
            this.aEY = pbContent.origin_src;
            this.aEZ = pbContent.origin_size.intValue();
        }
    }

    public g(JSONObject jSONObject) {
        this.aET = null;
        this.aEU = null;
        this.aEV = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aEW = false;
        this.aEX = true;
        this.aEY = null;
        this.aEZ = 0L;
        if (jSONObject != null) {
            this.aET = jSONObject.optString("src");
            this.aEU = jSONObject.optString("cdn_src", "");
            if (this.aEU == null || this.aEU.length() == 0) {
                this.aEU = this.aET;
            }
            this.aEV = jSONObject.optString("big_cdn_src", null);
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
            if (this.aEU != null && this.aEU.indexOf(".baidu.com") != -1) {
                this.aEW = true;
            }
        }
    }

    public String GV() {
        return this.aEV;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean GW() {
        return this.aEW;
    }

    public String getSrc() {
        return this.aET;
    }

    public String GX() {
        return this.aEU;
    }

    public boolean GY() {
        return this.aEX;
    }

    public String GZ() {
        return this.aEY;
    }

    public long getOriginalSize() {
        return this.aEZ;
    }
}
