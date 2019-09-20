package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String cNA;
    private String cNB;
    private String cNs;
    private String cNt;
    private boolean cNu;
    private boolean cNv;
    private String cNw;
    private long cNx;
    private boolean cNy;
    private boolean cNz;
    private int mHeight;
    private String mSrc;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.mSrc = null;
        this.cNs = null;
        this.cNt = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.cNu = false;
        this.cNv = false;
        this.cNw = null;
        this.cNx = 0L;
        this.cNy = false;
        this.cNz = false;
        this.cNB = null;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.mSrc = null;
        this.cNs = null;
        this.cNt = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.cNu = false;
        this.cNv = false;
        this.cNw = null;
        this.cNx = 0L;
        this.cNy = false;
        this.cNz = false;
        this.cNB = null;
        if (pbContent != null) {
            this.mSrc = pbContent.src;
            this.cNs = pbContent.cdn_src;
            if (this.cNs == null || this.cNs.length() == 0) {
                this.cNs = this.mSrc;
            }
            this.cNt = pbContent.big_cdn_src;
            this.cNB = pbContent.big_src;
            if (StringUtils.isNull(this.cNt)) {
                this.cNt = this.cNB;
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
            if (this.cNs != null && this.cNs.indexOf(".baidu.com") != -1) {
                this.cNu = true;
            }
            this.cNw = pbContent.origin_src;
            this.cNx = pbContent.origin_size.intValue();
            this.cNy = pbContent.show_original_btn.intValue() == 1;
            this.cNz = pbContent.is_long_pic.intValue() == 1;
            this.cNA = pbContent.cdn_src_active;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.mSrc = null;
        this.cNs = null;
        this.cNt = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.cNu = false;
        this.cNv = false;
        this.cNw = null;
        this.cNx = 0L;
        this.cNy = false;
        this.cNz = false;
        this.cNB = null;
        if (jSONObject != null) {
            this.mSrc = jSONObject.optString("src");
            this.cNs = jSONObject.optString("cdn_src", "");
            if (this.cNs == null || this.cNs.length() == 0) {
                this.cNs = this.mSrc;
            }
            this.cNt = jSONObject.optString("big_cdn_src", null);
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
            if (this.cNs != null && this.cNs.indexOf(".baidu.com") != -1) {
                this.cNu = true;
            }
        }
    }

    public String azr() {
        return this.cNt;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean azs() {
        return this.cNu;
    }

    public String getSrc() {
        return this.mSrc;
    }

    public String azt() {
        return this.cNB;
    }

    public String azu() {
        return this.cNs;
    }

    public String azv() {
        return this.cNA;
    }

    public boolean azw() {
        return this.cNv;
    }

    public String azx() {
        return this.cNw;
    }

    public long getOriginalSize() {
        return this.cNx;
    }

    public boolean azy() {
        return this.cNy;
    }

    public boolean azz() {
        return this.cNz;
    }
}
