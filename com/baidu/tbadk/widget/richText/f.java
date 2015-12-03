package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.lib.a.b.a.a.i {
    private String aDj;
    private String aDk;
    private String aDl;
    private boolean aDm;
    private boolean aDn;
    private String aDo;
    private long aDp;
    private int mHeight;
    private int mWidth;

    public f() {
        this.aDj = null;
        this.aDk = null;
        this.aDl = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aDm = false;
        this.aDn = true;
        this.aDo = null;
        this.aDp = 0L;
    }

    public f(PbContent pbContent) {
        this.aDj = null;
        this.aDk = null;
        this.aDl = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aDm = false;
        this.aDn = true;
        this.aDo = null;
        this.aDp = 0L;
        if (pbContent != null) {
            this.aDj = pbContent.src;
            this.aDk = pbContent.cdn_src;
            if (this.aDk == null || this.aDk.length() == 0) {
                this.aDk = this.aDj;
            }
            this.aDl = pbContent.big_cdn_src;
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
            if (this.aDk != null && this.aDk.indexOf(".baidu.com") != -1) {
                this.aDm = true;
            }
            this.aDo = pbContent.origin_src;
            this.aDp = pbContent.origin_size.intValue();
        }
    }

    public f(JSONObject jSONObject) {
        this.aDj = null;
        this.aDk = null;
        this.aDl = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aDm = false;
        this.aDn = true;
        this.aDo = null;
        this.aDp = 0L;
        if (jSONObject != null) {
            this.aDj = jSONObject.optString("src");
            this.aDk = jSONObject.optString("cdn_src", "");
            if (this.aDk == null || this.aDk.length() == 0) {
                this.aDk = this.aDj;
            }
            this.aDl = jSONObject.optString("big_cdn_src", null);
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
            if (this.aDk != null && this.aDk.indexOf(".baidu.com") != -1) {
                this.aDm = true;
            }
        }
    }

    public String FZ() {
        return this.aDl;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean Ga() {
        return this.aDm;
    }

    public String getSrc() {
        return this.aDj;
    }

    public String Gb() {
        return this.aDk;
    }

    public boolean Gc() {
        return this.aDn;
    }

    public String Gd() {
        return this.aDo;
    }

    public long getOriginalSize() {
        return this.aDp;
    }
}
