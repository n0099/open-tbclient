package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes2.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String ffm;
    private String ffn;
    private boolean ffo;
    private boolean ffp;
    private String ffq;
    private long ffr;
    private boolean ffs;
    private boolean fft;
    private String ffu;
    private String ffv;
    private int mHeight;
    private String mSrc;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.mSrc = null;
        this.ffm = null;
        this.ffn = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.ffo = false;
        this.ffp = false;
        this.ffq = null;
        this.ffr = 0L;
        this.ffs = false;
        this.fft = false;
        this.ffv = null;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.mSrc = null;
        this.ffm = null;
        this.ffn = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.ffo = false;
        this.ffp = false;
        this.ffq = null;
        this.ffr = 0L;
        this.ffs = false;
        this.fft = false;
        this.ffv = null;
        if (pbContent != null) {
            this.mSrc = pbContent.src;
            this.ffm = pbContent.cdn_src;
            if (this.ffm == null || this.ffm.length() == 0) {
                this.ffm = this.mSrc;
            }
            this.ffn = pbContent.big_cdn_src;
            this.ffv = pbContent.big_src;
            if (StringUtils.isNull(this.ffn)) {
                this.ffn = this.ffv;
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
            if (this.ffm != null && this.ffm.indexOf(".baidu.com") != -1) {
                this.ffo = true;
            }
            this.ffq = pbContent.origin_src;
            this.ffr = pbContent.origin_size.intValue();
            this.ffs = pbContent.show_original_btn.intValue() == 1;
            this.fft = pbContent.is_long_pic.intValue() == 1;
            this.ffu = pbContent.cdn_src_active;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.mSrc = null;
        this.ffm = null;
        this.ffn = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.ffo = false;
        this.ffp = false;
        this.ffq = null;
        this.ffr = 0L;
        this.ffs = false;
        this.fft = false;
        this.ffv = null;
        if (jSONObject != null) {
            this.mSrc = jSONObject.optString("src");
            this.ffm = jSONObject.optString("cdn_src", "");
            if (this.ffm == null || this.ffm.length() == 0) {
                this.ffm = this.mSrc;
            }
            this.ffn = jSONObject.optString("big_cdn_src", null);
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
            if (this.ffm != null && this.ffm.indexOf(".baidu.com") != -1) {
                this.ffo = true;
            }
        }
    }

    public String bxP() {
        return this.ffn;
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

    public boolean bxQ() {
        return this.ffo;
    }

    public String getSrc() {
        return this.mSrc;
    }

    public void setSrc(String str) {
        this.mSrc = str;
    }

    public String bxR() {
        return this.ffv;
    }

    public String bxS() {
        return this.ffm;
    }

    public String bxT() {
        return this.ffu;
    }

    public boolean bxU() {
        return this.ffp;
    }

    public String bxV() {
        return this.ffq;
    }

    public void CR(String str) {
        this.ffq = str;
    }

    public long getOriginalSize() {
        return this.ffr;
    }

    public boolean bxW() {
        return this.ffs;
    }

    public boolean bxX() {
        return this.fft;
    }

    public void jY(boolean z) {
        this.fft = z;
    }
}
