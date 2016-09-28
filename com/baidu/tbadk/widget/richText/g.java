package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.lib.a.b.a.a.i {
    private long aIA;
    private String aIu;
    private String aIv;
    private String aIw;
    private boolean aIx;
    private boolean aIy;
    private String aIz;
    private int mHeight;
    private int mWidth;

    public g() {
        this.aIu = null;
        this.aIv = null;
        this.aIw = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aIx = false;
        this.aIy = true;
        this.aIz = null;
        this.aIA = 0L;
    }

    public g(PbContent pbContent) {
        this.aIu = null;
        this.aIv = null;
        this.aIw = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aIx = false;
        this.aIy = true;
        this.aIz = null;
        this.aIA = 0L;
        if (pbContent != null) {
            this.aIu = pbContent.src;
            this.aIv = pbContent.cdn_src;
            if (this.aIv == null || this.aIv.length() == 0) {
                this.aIv = this.aIu;
            }
            this.aIw = pbContent.big_cdn_src;
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
            if (this.aIv != null && this.aIv.indexOf(".baidu.com") != -1) {
                this.aIx = true;
            }
            this.aIz = pbContent.origin_src;
            this.aIA = pbContent.origin_size.intValue();
        }
    }

    public g(JSONObject jSONObject) {
        this.aIu = null;
        this.aIv = null;
        this.aIw = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aIx = false;
        this.aIy = true;
        this.aIz = null;
        this.aIA = 0L;
        if (jSONObject != null) {
            this.aIu = jSONObject.optString("src");
            this.aIv = jSONObject.optString("cdn_src", "");
            if (this.aIv == null || this.aIv.length() == 0) {
                this.aIv = this.aIu;
            }
            this.aIw = jSONObject.optString("big_cdn_src", null);
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
            if (this.aIv != null && this.aIv.indexOf(".baidu.com") != -1) {
                this.aIx = true;
            }
        }
    }

    public String Iq() {
        return this.aIw;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean Ir() {
        return this.aIx;
    }

    public String Is() {
        return this.aIu;
    }

    public String It() {
        return this.aIv;
    }

    public boolean Iu() {
        return this.aIy;
    }

    public String Iv() {
        return this.aIz;
    }

    public long getOriginalSize() {
        return this.aIA;
    }
}
