package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String bIV;
    private String bIW;
    private String bIX;
    private boolean bIY;
    private boolean bIZ;
    private String bJa;
    private long bJb;
    private boolean bJc;
    private boolean bJd;
    private String bJe;
    private int mHeight;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.bIV = null;
        this.bIW = null;
        this.bIX = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.bIY = false;
        this.bIZ = false;
        this.bJa = null;
        this.bJb = 0L;
        this.bJc = false;
        this.bJd = false;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.bIV = null;
        this.bIW = null;
        this.bIX = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.bIY = false;
        this.bIZ = false;
        this.bJa = null;
        this.bJb = 0L;
        this.bJc = false;
        this.bJd = false;
        if (pbContent != null) {
            this.bIV = pbContent.src;
            this.bIW = pbContent.cdn_src;
            if (this.bIW == null || this.bIW.length() == 0) {
                this.bIW = this.bIV;
            }
            this.bIX = pbContent.big_cdn_src;
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
            if (this.bIW != null && this.bIW.indexOf(".baidu.com") != -1) {
                this.bIY = true;
            }
            this.bJa = pbContent.origin_src;
            this.bJb = pbContent.origin_size.intValue();
            this.bJc = pbContent.show_original_btn.intValue() == 1;
            this.bJd = pbContent.is_long_pic.intValue() == 1;
            this.bJe = pbContent.cdn_src_active;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.bIV = null;
        this.bIW = null;
        this.bIX = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.bIY = false;
        this.bIZ = false;
        this.bJa = null;
        this.bJb = 0L;
        this.bJc = false;
        this.bJd = false;
        if (jSONObject != null) {
            this.bIV = jSONObject.optString("src");
            this.bIW = jSONObject.optString("cdn_src", "");
            if (this.bIW == null || this.bIW.length() == 0) {
                this.bIW = this.bIV;
            }
            this.bIX = jSONObject.optString("big_cdn_src", null);
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
            if (this.bIW != null && this.bIW.indexOf(".baidu.com") != -1) {
                this.bIY = true;
            }
        }
    }

    public String Re() {
        return this.bIX;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean Rf() {
        return this.bIY;
    }

    public String Rg() {
        return this.bIV;
    }

    public String Rh() {
        return this.bIW;
    }

    public String Ri() {
        return this.bJe;
    }

    public boolean Rj() {
        return this.bIZ;
    }

    public String Rk() {
        return this.bJa;
    }

    public long getOriginalSize() {
        return this.bJb;
    }

    public boolean Rl() {
        return this.bJc;
    }

    public boolean Rm() {
        return this.bJd;
    }
}
