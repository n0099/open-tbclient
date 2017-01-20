package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String aHk;
    private String aHl;
    private String aHm;
    private boolean aHn;
    private boolean aHo;
    private String aHp;
    private long aHq;
    private int mHeight;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.aHk = null;
        this.aHl = null;
        this.aHm = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aHn = false;
        this.aHo = false;
        this.aHp = null;
        this.aHq = 0L;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.aHk = null;
        this.aHl = null;
        this.aHm = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aHn = false;
        this.aHo = false;
        this.aHp = null;
        this.aHq = 0L;
        if (pbContent != null) {
            this.aHk = pbContent.src;
            this.aHl = pbContent.cdn_src;
            if (this.aHl == null || this.aHl.length() == 0) {
                this.aHl = this.aHk;
            }
            this.aHm = pbContent.big_cdn_src;
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
            if (this.aHl != null && this.aHl.indexOf(".baidu.com") != -1) {
                this.aHn = true;
            }
            this.aHp = pbContent.origin_src;
            this.aHq = pbContent.origin_size.intValue();
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.aHk = null;
        this.aHl = null;
        this.aHm = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aHn = false;
        this.aHo = false;
        this.aHp = null;
        this.aHq = 0L;
        if (jSONObject != null) {
            this.aHk = jSONObject.optString("src");
            this.aHl = jSONObject.optString("cdn_src", "");
            if (this.aHl == null || this.aHl.length() == 0) {
                this.aHl = this.aHk;
            }
            this.aHm = jSONObject.optString("big_cdn_src", null);
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
            if (this.aHl != null && this.aHl.indexOf(".baidu.com") != -1) {
                this.aHn = true;
            }
        }
    }

    public String HG() {
        return this.aHm;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean HH() {
        return this.aHn;
    }

    public String HI() {
        return this.aHk;
    }

    public String HJ() {
        return this.aHl;
    }

    public boolean HK() {
        return this.aHo;
    }

    public String HL() {
        return this.aHp;
    }

    public long getOriginalSize() {
        return this.aHq;
    }
}
