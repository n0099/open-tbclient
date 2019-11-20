package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String cVT;
    private String cVU;
    private boolean cVV;
    private boolean cVW;
    private String cVX;
    private long cVY;
    private boolean cVZ;
    private boolean cWa;
    private String cWb;
    private String cWc;
    private int mHeight;
    private String mSrc;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.mSrc = null;
        this.cVT = null;
        this.cVU = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.cVV = false;
        this.cVW = false;
        this.cVX = null;
        this.cVY = 0L;
        this.cVZ = false;
        this.cWa = false;
        this.cWc = null;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.mSrc = null;
        this.cVT = null;
        this.cVU = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.cVV = false;
        this.cVW = false;
        this.cVX = null;
        this.cVY = 0L;
        this.cVZ = false;
        this.cWa = false;
        this.cWc = null;
        if (pbContent != null) {
            this.mSrc = pbContent.src;
            this.cVT = pbContent.cdn_src;
            if (this.cVT == null || this.cVT.length() == 0) {
                this.cVT = this.mSrc;
            }
            this.cVU = pbContent.big_cdn_src;
            this.cWc = pbContent.big_src;
            if (StringUtils.isNull(this.cVU)) {
                this.cVU = this.cWc;
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
            if (this.cVT != null && this.cVT.indexOf(".baidu.com") != -1) {
                this.cVV = true;
            }
            this.cVX = pbContent.origin_src;
            this.cVY = pbContent.origin_size.intValue();
            this.cVZ = pbContent.show_original_btn.intValue() == 1;
            this.cWa = pbContent.is_long_pic.intValue() == 1;
            this.cWb = pbContent.cdn_src_active;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.mSrc = null;
        this.cVT = null;
        this.cVU = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.cVV = false;
        this.cVW = false;
        this.cVX = null;
        this.cVY = 0L;
        this.cVZ = false;
        this.cWa = false;
        this.cWc = null;
        if (jSONObject != null) {
            this.mSrc = jSONObject.optString("src");
            this.cVT = jSONObject.optString("cdn_src", "");
            if (this.cVT == null || this.cVT.length() == 0) {
                this.cVT = this.mSrc;
            }
            this.cVU = jSONObject.optString("big_cdn_src", null);
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
            if (this.cVT != null && this.cVT.indexOf(".baidu.com") != -1) {
                this.cVV = true;
            }
        }
    }

    public String azy() {
        return this.cVU;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean azz() {
        return this.cVV;
    }

    public String getSrc() {
        return this.mSrc;
    }

    public String azA() {
        return this.cWc;
    }

    public String azB() {
        return this.cVT;
    }

    public String azC() {
        return this.cWb;
    }

    public boolean azD() {
        return this.cVW;
    }

    public String azE() {
        return this.cVX;
    }

    public long getOriginalSize() {
        return this.cVY;
    }

    public boolean azF() {
        return this.cVZ;
    }

    public boolean azG() {
        return this.cWa;
    }
}
