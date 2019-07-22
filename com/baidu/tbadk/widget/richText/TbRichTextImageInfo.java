package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private long cMA;
    private boolean cMB;
    private boolean cMC;
    private String cMD;
    private String cME;
    private String cMv;
    private String cMw;
    private boolean cMx;
    private boolean cMy;
    private String cMz;
    private int mHeight;
    private String mSrc;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.mSrc = null;
        this.cMv = null;
        this.cMw = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.cMx = false;
        this.cMy = false;
        this.cMz = null;
        this.cMA = 0L;
        this.cMB = false;
        this.cMC = false;
        this.cME = null;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.mSrc = null;
        this.cMv = null;
        this.cMw = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.cMx = false;
        this.cMy = false;
        this.cMz = null;
        this.cMA = 0L;
        this.cMB = false;
        this.cMC = false;
        this.cME = null;
        if (pbContent != null) {
            this.mSrc = pbContent.src;
            this.cMv = pbContent.cdn_src;
            if (this.cMv == null || this.cMv.length() == 0) {
                this.cMv = this.mSrc;
            }
            this.cMw = pbContent.big_cdn_src;
            this.cME = pbContent.big_src;
            if (StringUtils.isNull(this.cMw)) {
                this.cMw = this.cME;
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
            if (this.cMv != null && this.cMv.indexOf(".baidu.com") != -1) {
                this.cMx = true;
            }
            this.cMz = pbContent.origin_src;
            this.cMA = pbContent.origin_size.intValue();
            this.cMB = pbContent.show_original_btn.intValue() == 1;
            this.cMC = pbContent.is_long_pic.intValue() == 1;
            this.cMD = pbContent.cdn_src_active;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.mSrc = null;
        this.cMv = null;
        this.cMw = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.cMx = false;
        this.cMy = false;
        this.cMz = null;
        this.cMA = 0L;
        this.cMB = false;
        this.cMC = false;
        this.cME = null;
        if (jSONObject != null) {
            this.mSrc = jSONObject.optString("src");
            this.cMv = jSONObject.optString("cdn_src", "");
            if (this.cMv == null || this.cMv.length() == 0) {
                this.cMv = this.mSrc;
            }
            this.cMw = jSONObject.optString("big_cdn_src", null);
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
            if (this.cMv != null && this.cMv.indexOf(".baidu.com") != -1) {
                this.cMx = true;
            }
        }
    }

    public String azd() {
        return this.cMw;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean aze() {
        return this.cMx;
    }

    public String getSrc() {
        return this.mSrc;
    }

    public String azf() {
        return this.cME;
    }

    public String azg() {
        return this.cMv;
    }

    public String azh() {
        return this.cMD;
    }

    public boolean azi() {
        return this.cMy;
    }

    public String azj() {
        return this.cMz;
    }

    public long getOriginalSize() {
        return this.cMA;
    }

    public boolean azk() {
        return this.cMB;
    }

    public boolean azl() {
        return this.cMC;
    }
}
