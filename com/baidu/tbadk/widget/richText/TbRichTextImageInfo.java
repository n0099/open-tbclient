package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String aRb;
    private String aRc;
    private String aRd;
    private boolean aRe;
    private boolean aRf;
    private String aRg;
    private long aRh;
    private int mHeight;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.aRb = null;
        this.aRc = null;
        this.aRd = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aRe = false;
        this.aRf = false;
        this.aRg = null;
        this.aRh = 0L;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.aRb = null;
        this.aRc = null;
        this.aRd = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aRe = false;
        this.aRf = false;
        this.aRg = null;
        this.aRh = 0L;
        if (pbContent != null) {
            this.aRb = pbContent.src;
            this.aRc = pbContent.cdn_src;
            if (this.aRc == null || this.aRc.length() == 0) {
                this.aRc = this.aRb;
            }
            this.aRd = pbContent.big_cdn_src;
            String str = pbContent.bsize;
            if (str != null) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
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
            if (this.aRc != null && this.aRc.indexOf(".baidu.com") != -1) {
                this.aRe = true;
            }
            this.aRg = pbContent.origin_src;
            this.aRh = pbContent.origin_size.intValue();
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.aRb = null;
        this.aRc = null;
        this.aRd = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aRe = false;
        this.aRf = false;
        this.aRg = null;
        this.aRh = 0L;
        if (jSONObject != null) {
            this.aRb = jSONObject.optString("src");
            this.aRc = jSONObject.optString("cdn_src", "");
            if (this.aRc == null || this.aRc.length() == 0) {
                this.aRc = this.aRb;
            }
            this.aRd = jSONObject.optString("big_cdn_src", null);
            try {
                String[] split = jSONObject.optString("bsize").split(Constants.ACCEPT_TIME_SEPARATOR_SP);
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
            if (this.aRc != null && this.aRc.indexOf(".baidu.com") != -1) {
                this.aRe = true;
            }
        }
    }

    public String IF() {
        return this.aRd;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean IG() {
        return this.aRe;
    }

    public String IH() {
        return this.aRb;
    }

    public String II() {
        return this.aRc;
    }

    public boolean IJ() {
        return this.aRf;
    }

    public String IK() {
        return this.aRg;
    }

    public long getOriginalSize() {
        return this.aRh;
    }
}
