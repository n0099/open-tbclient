package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String aNo;
    private String aNp;
    private String aNq;
    private boolean aNr;
    private boolean aNs;
    private String aNt;
    private long aNu;
    private int mHeight;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.aNo = null;
        this.aNp = null;
        this.aNq = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aNr = false;
        this.aNs = false;
        this.aNt = null;
        this.aNu = 0L;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.aNo = null;
        this.aNp = null;
        this.aNq = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aNr = false;
        this.aNs = false;
        this.aNt = null;
        this.aNu = 0L;
        if (pbContent != null) {
            this.aNo = pbContent.src;
            this.aNp = pbContent.cdn_src;
            if (this.aNp == null || this.aNp.length() == 0) {
                this.aNp = this.aNo;
            }
            this.aNq = pbContent.big_cdn_src;
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
            if (this.aNp != null && this.aNp.indexOf(".baidu.com") != -1) {
                this.aNr = true;
            }
            this.aNt = pbContent.origin_src;
            this.aNu = pbContent.origin_size.intValue();
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.aNo = null;
        this.aNp = null;
        this.aNq = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aNr = false;
        this.aNs = false;
        this.aNt = null;
        this.aNu = 0L;
        if (jSONObject != null) {
            this.aNo = jSONObject.optString("src");
            this.aNp = jSONObject.optString("cdn_src", "");
            if (this.aNp == null || this.aNp.length() == 0) {
                this.aNp = this.aNo;
            }
            this.aNq = jSONObject.optString("big_cdn_src", null);
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
            if (this.aNp != null && this.aNp.indexOf(".baidu.com") != -1) {
                this.aNr = true;
            }
        }
    }

    public String HO() {
        return this.aNq;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean HP() {
        return this.aNr;
    }

    public String HQ() {
        return this.aNo;
    }

    public String HR() {
        return this.aNp;
    }

    public boolean HS() {
        return this.aNs;
    }

    public String HT() {
        return this.aNt;
    }

    public long getOriginalSize() {
        return this.aNu;
    }
}
