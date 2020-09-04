package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String ffq;
    private String ffr;
    private boolean ffs;
    private boolean fft;
    private String ffu;
    private long ffv;
    private boolean ffw;
    private boolean ffx;
    private String ffy;
    private String ffz;
    private int mHeight;
    private String mSrc;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.mSrc = null;
        this.ffq = null;
        this.ffr = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.ffs = false;
        this.fft = false;
        this.ffu = null;
        this.ffv = 0L;
        this.ffw = false;
        this.ffx = false;
        this.ffz = null;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.mSrc = null;
        this.ffq = null;
        this.ffr = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.ffs = false;
        this.fft = false;
        this.ffu = null;
        this.ffv = 0L;
        this.ffw = false;
        this.ffx = false;
        this.ffz = null;
        if (pbContent != null) {
            this.mSrc = pbContent.src;
            this.ffq = pbContent.cdn_src;
            if (this.ffq == null || this.ffq.length() == 0) {
                this.ffq = this.mSrc;
            }
            this.ffr = pbContent.big_cdn_src;
            this.ffz = pbContent.big_src;
            if (StringUtils.isNull(this.ffr)) {
                this.ffr = this.ffz;
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
            if (this.ffq != null && this.ffq.indexOf(".baidu.com") != -1) {
                this.ffs = true;
            }
            this.ffu = pbContent.origin_src;
            this.ffv = pbContent.origin_size.intValue();
            this.ffw = pbContent.show_original_btn.intValue() == 1;
            this.ffx = pbContent.is_long_pic.intValue() == 1;
            this.ffy = pbContent.cdn_src_active;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.mSrc = null;
        this.ffq = null;
        this.ffr = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.ffs = false;
        this.fft = false;
        this.ffu = null;
        this.ffv = 0L;
        this.ffw = false;
        this.ffx = false;
        this.ffz = null;
        if (jSONObject != null) {
            this.mSrc = jSONObject.optString("src");
            this.ffq = jSONObject.optString("cdn_src", "");
            if (this.ffq == null || this.ffq.length() == 0) {
                this.ffq = this.mSrc;
            }
            this.ffr = jSONObject.optString("big_cdn_src", null);
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
            if (this.ffq != null && this.ffq.indexOf(".baidu.com") != -1) {
                this.ffs = true;
            }
        }
    }

    public String bxQ() {
        return this.ffr;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public boolean bxR() {
        return this.ffs;
    }

    public String getSrc() {
        return this.mSrc;
    }

    public void setSrc(String str) {
        this.mSrc = str;
    }

    public String bxS() {
        return this.ffz;
    }

    public String bxT() {
        return this.ffq;
    }

    public String bxU() {
        return this.ffy;
    }

    public boolean bxV() {
        return this.fft;
    }

    public String bxW() {
        return this.ffu;
    }

    public void CS(String str) {
        this.ffu = str;
    }

    public long getOriginalSize() {
        return this.ffv;
    }

    public boolean bxX() {
        return this.ffw;
    }

    public boolean bxY() {
        return this.ffx;
    }

    public void ka(boolean z) {
        this.ffx = z;
    }
}
