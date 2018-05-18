package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String aVW;
    private String aVX;
    private boolean aVY;
    private boolean aVZ;
    private String aWa;
    private long aWb;
    private boolean aWc;
    private boolean aWd;
    private String aWe;
    private int mHeight;
    private String mSrc;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.mSrc = null;
        this.aVW = null;
        this.aVX = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aVY = false;
        this.aVZ = false;
        this.aWa = null;
        this.aWb = 0L;
        this.aWc = false;
        this.aWd = false;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.mSrc = null;
        this.aVW = null;
        this.aVX = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aVY = false;
        this.aVZ = false;
        this.aWa = null;
        this.aWb = 0L;
        this.aWc = false;
        this.aWd = false;
        if (pbContent != null) {
            this.mSrc = pbContent.src;
            this.aVW = pbContent.cdn_src;
            if (this.aVW == null || this.aVW.length() == 0) {
                this.aVW = this.mSrc;
            }
            this.aVX = pbContent.big_cdn_src;
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
            if (this.aVW != null && this.aVW.indexOf(".baidu.com") != -1) {
                this.aVY = true;
            }
            this.aWa = pbContent.origin_src;
            this.aWb = pbContent.origin_size.intValue();
            this.aWc = pbContent.show_original_btn.intValue() == 1;
            this.aWd = pbContent.is_long_pic.intValue() == 1;
            this.aWe = pbContent.cdn_src_active;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.mSrc = null;
        this.aVW = null;
        this.aVX = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aVY = false;
        this.aVZ = false;
        this.aWa = null;
        this.aWb = 0L;
        this.aWc = false;
        this.aWd = false;
        if (jSONObject != null) {
            this.mSrc = jSONObject.optString("src");
            this.aVW = jSONObject.optString("cdn_src", "");
            if (this.aVW == null || this.aVW.length() == 0) {
                this.aVW = this.mSrc;
            }
            this.aVX = jSONObject.optString("big_cdn_src", null);
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
            if (this.aVW != null && this.aVW.indexOf(".baidu.com") != -1) {
                this.aVY = true;
            }
        }
    }

    public String JY() {
        return this.aVX;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean JZ() {
        return this.aVY;
    }

    public String getSrc() {
        return this.mSrc;
    }

    public String Ka() {
        return this.aVW;
    }

    public String Kb() {
        return this.aWe;
    }

    public boolean Kc() {
        return this.aVZ;
    }

    public String Kd() {
        return this.aWa;
    }

    public long getOriginalSize() {
        return this.aWb;
    }

    public boolean Ke() {
        return this.aWc;
    }

    public boolean Kf() {
        return this.aWd;
    }
}
