package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String aNr;
    private String aNs;
    private String aNt;
    private boolean aNu;
    private boolean aNv;
    private String aNw;
    private long aNx;
    private int mHeight;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.aNr = null;
        this.aNs = null;
        this.aNt = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aNu = false;
        this.aNv = false;
        this.aNw = null;
        this.aNx = 0L;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.aNr = null;
        this.aNs = null;
        this.aNt = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aNu = false;
        this.aNv = false;
        this.aNw = null;
        this.aNx = 0L;
        if (pbContent != null) {
            this.aNr = pbContent.src;
            this.aNs = pbContent.cdn_src;
            if (this.aNs == null || this.aNs.length() == 0) {
                this.aNs = this.aNr;
            }
            this.aNt = pbContent.big_cdn_src;
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
            if (this.aNs != null && this.aNs.indexOf(".baidu.com") != -1) {
                this.aNu = true;
            }
            this.aNw = pbContent.origin_src;
            this.aNx = pbContent.origin_size.intValue();
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.aNr = null;
        this.aNs = null;
        this.aNt = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aNu = false;
        this.aNv = false;
        this.aNw = null;
        this.aNx = 0L;
        if (jSONObject != null) {
            this.aNr = jSONObject.optString("src");
            this.aNs = jSONObject.optString("cdn_src", "");
            if (this.aNs == null || this.aNs.length() == 0) {
                this.aNs = this.aNr;
            }
            this.aNt = jSONObject.optString("big_cdn_src", null);
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
            if (this.aNs != null && this.aNs.indexOf(".baidu.com") != -1) {
                this.aNu = true;
            }
        }
    }

    public String HT() {
        return this.aNt;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean HU() {
        return this.aNu;
    }

    public String HV() {
        return this.aNr;
    }

    public String HW() {
        return this.aNs;
    }

    public boolean HX() {
        return this.aNv;
    }

    public String HY() {
        return this.aNw;
    }

    public long getOriginalSize() {
        return this.aNx;
    }
}
