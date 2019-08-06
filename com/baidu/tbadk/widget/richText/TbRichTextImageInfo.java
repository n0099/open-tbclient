package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String cMC;
    private String cMD;
    private boolean cME;
    private boolean cMF;
    private String cMG;
    private long cMH;
    private boolean cMI;
    private boolean cMJ;
    private String cMK;
    private String cML;
    private int mHeight;
    private String mSrc;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.mSrc = null;
        this.cMC = null;
        this.cMD = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.cME = false;
        this.cMF = false;
        this.cMG = null;
        this.cMH = 0L;
        this.cMI = false;
        this.cMJ = false;
        this.cML = null;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.mSrc = null;
        this.cMC = null;
        this.cMD = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.cME = false;
        this.cMF = false;
        this.cMG = null;
        this.cMH = 0L;
        this.cMI = false;
        this.cMJ = false;
        this.cML = null;
        if (pbContent != null) {
            this.mSrc = pbContent.src;
            this.cMC = pbContent.cdn_src;
            if (this.cMC == null || this.cMC.length() == 0) {
                this.cMC = this.mSrc;
            }
            this.cMD = pbContent.big_cdn_src;
            this.cML = pbContent.big_src;
            if (StringUtils.isNull(this.cMD)) {
                this.cMD = this.cML;
            }
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
            if (this.cMC != null && this.cMC.indexOf(".baidu.com") != -1) {
                this.cME = true;
            }
            this.cMG = pbContent.origin_src;
            this.cMH = pbContent.origin_size.intValue();
            this.cMI = pbContent.show_original_btn.intValue() == 1;
            this.cMJ = pbContent.is_long_pic.intValue() == 1;
            this.cMK = pbContent.cdn_src_active;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.mSrc = null;
        this.cMC = null;
        this.cMD = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.cME = false;
        this.cMF = false;
        this.cMG = null;
        this.cMH = 0L;
        this.cMI = false;
        this.cMJ = false;
        this.cML = null;
        if (jSONObject != null) {
            this.mSrc = jSONObject.optString("src");
            this.cMC = jSONObject.optString("cdn_src", "");
            if (this.cMC == null || this.cMC.length() == 0) {
                this.cMC = this.mSrc;
            }
            this.cMD = jSONObject.optString("big_cdn_src", null);
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
            if (this.cMC != null && this.cMC.indexOf(".baidu.com") != -1) {
                this.cME = true;
            }
        }
    }

    public String azf() {
        return this.cMD;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean azg() {
        return this.cME;
    }

    public String getSrc() {
        return this.mSrc;
    }

    public String azh() {
        return this.cML;
    }

    public String azi() {
        return this.cMC;
    }

    public String azj() {
        return this.cMK;
    }

    public boolean azk() {
        return this.cMF;
    }

    public String azl() {
        return this.cMG;
    }

    public long getOriginalSize() {
        return this.cMH;
    }

    public boolean azm() {
        return this.cMI;
    }

    public boolean azn() {
        return this.cMJ;
    }
}
