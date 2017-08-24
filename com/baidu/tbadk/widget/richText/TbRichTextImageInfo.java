package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String aRc;
    private String aRd;
    private String aRe;
    private boolean aRf;
    private boolean aRg;
    private String aRh;
    private long aRi;
    private int mHeight;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.aRc = null;
        this.aRd = null;
        this.aRe = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aRf = false;
        this.aRg = false;
        this.aRh = null;
        this.aRi = 0L;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.aRc = null;
        this.aRd = null;
        this.aRe = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aRf = false;
        this.aRg = false;
        this.aRh = null;
        this.aRi = 0L;
        if (pbContent != null) {
            this.aRc = pbContent.src;
            this.aRd = pbContent.cdn_src;
            if (this.aRd == null || this.aRd.length() == 0) {
                this.aRd = this.aRc;
            }
            this.aRe = pbContent.big_cdn_src;
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
            if (this.aRd != null && this.aRd.indexOf(".baidu.com") != -1) {
                this.aRf = true;
            }
            this.aRh = pbContent.origin_src;
            this.aRi = pbContent.origin_size.intValue();
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.aRc = null;
        this.aRd = null;
        this.aRe = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aRf = false;
        this.aRg = false;
        this.aRh = null;
        this.aRi = 0L;
        if (jSONObject != null) {
            this.aRc = jSONObject.optString("src");
            this.aRd = jSONObject.optString("cdn_src", "");
            if (this.aRd == null || this.aRd.length() == 0) {
                this.aRd = this.aRc;
            }
            this.aRe = jSONObject.optString("big_cdn_src", null);
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
            if (this.aRd != null && this.aRd.indexOf(".baidu.com") != -1) {
                this.aRf = true;
            }
        }
    }

    public String IF() {
        return this.aRe;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean IG() {
        return this.aRf;
    }

    public String IH() {
        return this.aRc;
    }

    public String II() {
        return this.aRd;
    }

    public boolean IJ() {
        return this.aRg;
    }

    public String IK() {
        return this.aRh;
    }

    public long getOriginalSize() {
        return this.aRi;
    }
}
