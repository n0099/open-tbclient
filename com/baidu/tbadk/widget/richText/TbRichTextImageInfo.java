package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String aVV;
    private String aVW;
    private boolean aVX;
    private boolean aVY;
    private String aVZ;
    private long aWa;
    private boolean aWb;
    private boolean aWc;
    private String aWd;
    private int mHeight;
    private String mSrc;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.mSrc = null;
        this.aVV = null;
        this.aVW = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aVX = false;
        this.aVY = false;
        this.aVZ = null;
        this.aWa = 0L;
        this.aWb = false;
        this.aWc = false;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.mSrc = null;
        this.aVV = null;
        this.aVW = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aVX = false;
        this.aVY = false;
        this.aVZ = null;
        this.aWa = 0L;
        this.aWb = false;
        this.aWc = false;
        if (pbContent != null) {
            this.mSrc = pbContent.src;
            this.aVV = pbContent.cdn_src;
            if (this.aVV == null || this.aVV.length() == 0) {
                this.aVV = this.mSrc;
            }
            this.aVW = pbContent.big_cdn_src;
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
            if (this.aVV != null && this.aVV.indexOf(".baidu.com") != -1) {
                this.aVX = true;
            }
            this.aVZ = pbContent.origin_src;
            this.aWa = pbContent.origin_size.intValue();
            this.aWb = pbContent.show_original_btn.intValue() == 1;
            this.aWc = pbContent.is_long_pic.intValue() == 1;
            this.aWd = pbContent.cdn_src_active;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.mSrc = null;
        this.aVV = null;
        this.aVW = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aVX = false;
        this.aVY = false;
        this.aVZ = null;
        this.aWa = 0L;
        this.aWb = false;
        this.aWc = false;
        if (jSONObject != null) {
            this.mSrc = jSONObject.optString("src");
            this.aVV = jSONObject.optString("cdn_src", "");
            if (this.aVV == null || this.aVV.length() == 0) {
                this.aVV = this.mSrc;
            }
            this.aVW = jSONObject.optString("big_cdn_src", null);
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
            if (this.aVV != null && this.aVV.indexOf(".baidu.com") != -1) {
                this.aVX = true;
            }
        }
    }

    public String Ka() {
        return this.aVW;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean Kb() {
        return this.aVX;
    }

    public String getSrc() {
        return this.mSrc;
    }

    public String Kc() {
        return this.aVV;
    }

    public String Kd() {
        return this.aWd;
    }

    public boolean Ke() {
        return this.aVY;
    }

    public String Kf() {
        return this.aVZ;
    }

    public long getOriginalSize() {
        return this.aWa;
    }

    public boolean Kg() {
        return this.aWb;
    }

    public boolean Kh() {
        return this.aWc;
    }
}
