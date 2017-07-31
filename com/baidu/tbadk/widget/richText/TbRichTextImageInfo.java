package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String aRa;
    private String aRb;
    private String aRc;
    private boolean aRd;
    private boolean aRe;
    private String aRf;
    private long aRg;
    private int mHeight;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.aRa = null;
        this.aRb = null;
        this.aRc = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aRd = false;
        this.aRe = false;
        this.aRf = null;
        this.aRg = 0L;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.aRa = null;
        this.aRb = null;
        this.aRc = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aRd = false;
        this.aRe = false;
        this.aRf = null;
        this.aRg = 0L;
        if (pbContent != null) {
            this.aRa = pbContent.src;
            this.aRb = pbContent.cdn_src;
            if (this.aRb == null || this.aRb.length() == 0) {
                this.aRb = this.aRa;
            }
            this.aRc = pbContent.big_cdn_src;
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
            if (this.aRb != null && this.aRb.indexOf(".baidu.com") != -1) {
                this.aRd = true;
            }
            this.aRf = pbContent.origin_src;
            this.aRg = pbContent.origin_size.intValue();
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.aRa = null;
        this.aRb = null;
        this.aRc = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aRd = false;
        this.aRe = false;
        this.aRf = null;
        this.aRg = 0L;
        if (jSONObject != null) {
            this.aRa = jSONObject.optString("src");
            this.aRb = jSONObject.optString("cdn_src", "");
            if (this.aRb == null || this.aRb.length() == 0) {
                this.aRb = this.aRa;
            }
            this.aRc = jSONObject.optString("big_cdn_src", null);
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
            if (this.aRb != null && this.aRb.indexOf(".baidu.com") != -1) {
                this.aRd = true;
            }
        }
    }

    public String IF() {
        return this.aRc;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean IG() {
        return this.aRd;
    }

    public String IH() {
        return this.aRa;
    }

    public String II() {
        return this.aRb;
    }

    public boolean IJ() {
        return this.aRe;
    }

    public String IK() {
        return this.aRf;
    }

    public long getOriginalSize() {
        return this.aRg;
    }
}
