package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String fIm;
    private String fIn;
    private boolean fIo;
    private boolean fIp;
    private String fIq;
    private long fIr;
    private boolean fIs;
    private boolean fIt;
    private String fIu;
    private String fIv;
    private int mHeight;
    private String mSrc;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.mSrc = null;
        this.fIm = null;
        this.fIn = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.fIo = false;
        this.fIp = false;
        this.fIq = null;
        this.fIr = 0L;
        this.fIs = false;
        this.fIt = false;
        this.fIv = null;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.mSrc = null;
        this.fIm = null;
        this.fIn = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.fIo = false;
        this.fIp = false;
        this.fIq = null;
        this.fIr = 0L;
        this.fIs = false;
        this.fIt = false;
        this.fIv = null;
        if (pbContent != null) {
            this.mSrc = pbContent.src;
            this.fIm = pbContent.cdn_src;
            if (this.fIm == null || this.fIm.length() == 0) {
                this.fIm = this.mSrc;
            }
            this.fIn = pbContent.big_cdn_src;
            this.fIv = pbContent.big_src;
            if (StringUtils.isNull(this.fIn)) {
                this.fIn = this.fIv;
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
            if (this.fIm != null && this.fIm.indexOf(".baidu.com") != -1) {
                this.fIo = true;
            }
            this.fIq = pbContent.origin_src;
            this.fIr = pbContent.origin_size.intValue();
            this.fIs = pbContent.show_original_btn.intValue() == 1;
            this.fIt = pbContent.is_long_pic.intValue() == 1;
            this.fIu = pbContent.cdn_src_active;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.mSrc = null;
        this.fIm = null;
        this.fIn = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.fIo = false;
        this.fIp = false;
        this.fIq = null;
        this.fIr = 0L;
        this.fIs = false;
        this.fIt = false;
        this.fIv = null;
        if (jSONObject != null) {
            this.mSrc = jSONObject.optString("src");
            this.fIm = jSONObject.optString("cdn_src", "");
            if (this.fIm == null || this.fIm.length() == 0) {
                this.fIm = this.mSrc;
            }
            this.fIn = jSONObject.optString("big_cdn_src", null);
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
            if (this.fIm != null && this.fIm.indexOf(".baidu.com") != -1) {
                this.fIo = true;
            }
        }
    }

    public String bFu() {
        return this.fIn;
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

    public boolean bFv() {
        return this.fIo;
    }

    public String getSrc() {
        return this.mSrc;
    }

    public void setSrc(String str) {
        this.mSrc = str;
    }

    public String bFw() {
        return this.fIv;
    }

    public String bFx() {
        return this.fIm;
    }

    public String bFy() {
        return this.fIu;
    }

    public boolean bFz() {
        return this.fIp;
    }

    public String bFA() {
        return this.fIq;
    }

    public void Ei(String str) {
        this.fIq = str;
    }

    public long getOriginalSize() {
        return this.fIr;
    }

    public boolean bFB() {
        return this.fIs;
    }

    public boolean bFC() {
        return this.fIt;
    }

    public void kW(boolean z) {
        this.fIt = z;
    }
}
