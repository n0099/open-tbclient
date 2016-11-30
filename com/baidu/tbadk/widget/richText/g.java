package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.lib.a.b.a.a.i {
    private String aJk;
    private String aJl;
    private String aJm;
    private boolean aJn;
    private boolean aJo;
    private String aJp;
    private long aJq;
    private int mHeight;
    private int mWidth;

    public g() {
        this.aJk = null;
        this.aJl = null;
        this.aJm = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aJn = false;
        this.aJo = false;
        this.aJp = null;
        this.aJq = 0L;
    }

    public g(PbContent pbContent) {
        this.aJk = null;
        this.aJl = null;
        this.aJm = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aJn = false;
        this.aJo = false;
        this.aJp = null;
        this.aJq = 0L;
        if (pbContent != null) {
            this.aJk = pbContent.src;
            this.aJl = pbContent.cdn_src;
            if (this.aJl == null || this.aJl.length() == 0) {
                this.aJl = this.aJk;
            }
            this.aJm = pbContent.big_cdn_src;
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
            if (this.aJl != null && this.aJl.indexOf(".baidu.com") != -1) {
                this.aJn = true;
            }
            this.aJp = pbContent.origin_src;
            this.aJq = pbContent.origin_size.intValue();
        }
    }

    public g(JSONObject jSONObject) {
        this.aJk = null;
        this.aJl = null;
        this.aJm = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aJn = false;
        this.aJo = false;
        this.aJp = null;
        this.aJq = 0L;
        if (jSONObject != null) {
            this.aJk = jSONObject.optString("src");
            this.aJl = jSONObject.optString("cdn_src", "");
            if (this.aJl == null || this.aJl.length() == 0) {
                this.aJl = this.aJk;
            }
            this.aJm = jSONObject.optString("big_cdn_src", null);
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
            if (this.aJl != null && this.aJl.indexOf(".baidu.com") != -1) {
                this.aJn = true;
            }
        }
    }

    public String It() {
        return this.aJm;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean Iu() {
        return this.aJn;
    }

    public String Iv() {
        return this.aJk;
    }

    public String Iw() {
        return this.aJl;
    }

    public boolean Ix() {
        return this.aJo;
    }

    public String Iy() {
        return this.aJp;
    }

    public long getOriginalSize() {
        return this.aJq;
    }
}
