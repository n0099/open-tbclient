package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.lib.a.b.a.a.i {
    private String aEs;
    private String aEt;
    private String aEu;
    private boolean aEv;
    private boolean aEw;
    private String aEx;
    private long aEy;
    private int mHeight;
    private int mWidth;

    public g() {
        this.aEs = null;
        this.aEt = null;
        this.aEu = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aEv = false;
        this.aEw = true;
        this.aEx = null;
        this.aEy = 0L;
    }

    public g(PbContent pbContent) {
        this.aEs = null;
        this.aEt = null;
        this.aEu = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aEv = false;
        this.aEw = true;
        this.aEx = null;
        this.aEy = 0L;
        if (pbContent != null) {
            this.aEs = pbContent.src;
            this.aEt = pbContent.cdn_src;
            if (this.aEt == null || this.aEt.length() == 0) {
                this.aEt = this.aEs;
            }
            this.aEu = pbContent.big_cdn_src;
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
            if (this.aEt != null && this.aEt.indexOf(".baidu.com") != -1) {
                this.aEv = true;
            }
            this.aEx = pbContent.origin_src;
            this.aEy = pbContent.origin_size.intValue();
        }
    }

    public g(JSONObject jSONObject) {
        this.aEs = null;
        this.aEt = null;
        this.aEu = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aEv = false;
        this.aEw = true;
        this.aEx = null;
        this.aEy = 0L;
        if (jSONObject != null) {
            this.aEs = jSONObject.optString("src");
            this.aEt = jSONObject.optString("cdn_src", "");
            if (this.aEt == null || this.aEt.length() == 0) {
                this.aEt = this.aEs;
            }
            this.aEu = jSONObject.optString("big_cdn_src", null);
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
            if (this.aEt != null && this.aEt.indexOf(".baidu.com") != -1) {
                this.aEv = true;
            }
        }
    }

    public String GS() {
        return this.aEu;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean GT() {
        return this.aEv;
    }

    public String getSrc() {
        return this.aEs;
    }

    public String GU() {
        return this.aEt;
    }

    public boolean GV() {
        return this.aEw;
    }

    public String GW() {
        return this.aEx;
    }

    public long getOriginalSize() {
        return this.aEy;
    }
}
