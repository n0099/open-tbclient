package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String cCR;
    private String cCS;
    private boolean cCT;
    private boolean cCU;
    private String cCV;
    private long cCW;
    private boolean cCX;
    private boolean cCY;
    private String cCZ;
    private String cDa;
    private int mHeight;
    private String mSrc;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.mSrc = null;
        this.cCR = null;
        this.cCS = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.cCT = false;
        this.cCU = false;
        this.cCV = null;
        this.cCW = 0L;
        this.cCX = false;
        this.cCY = false;
        this.cDa = null;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.mSrc = null;
        this.cCR = null;
        this.cCS = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.cCT = false;
        this.cCU = false;
        this.cCV = null;
        this.cCW = 0L;
        this.cCX = false;
        this.cCY = false;
        this.cDa = null;
        if (pbContent != null) {
            this.mSrc = pbContent.src;
            this.cCR = pbContent.cdn_src;
            if (this.cCR == null || this.cCR.length() == 0) {
                this.cCR = this.mSrc;
            }
            this.cCS = pbContent.big_cdn_src;
            this.cDa = pbContent.big_src;
            if (StringUtils.isNull(this.cCS)) {
                this.cCS = this.cDa;
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
            if (this.cCR != null && this.cCR.indexOf(".baidu.com") != -1) {
                this.cCT = true;
            }
            this.cCV = pbContent.origin_src;
            this.cCW = pbContent.origin_size.intValue();
            this.cCX = pbContent.show_original_btn.intValue() == 1;
            this.cCY = pbContent.is_long_pic.intValue() == 1;
            this.cCZ = pbContent.cdn_src_active;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.mSrc = null;
        this.cCR = null;
        this.cCS = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.cCT = false;
        this.cCU = false;
        this.cCV = null;
        this.cCW = 0L;
        this.cCX = false;
        this.cCY = false;
        this.cDa = null;
        if (jSONObject != null) {
            this.mSrc = jSONObject.optString("src");
            this.cCR = jSONObject.optString("cdn_src", "");
            if (this.cCR == null || this.cCR.length() == 0) {
                this.cCR = this.mSrc;
            }
            this.cCS = jSONObject.optString("big_cdn_src", null);
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
            if (this.cCR != null && this.cCR.indexOf(".baidu.com") != -1) {
                this.cCT = true;
            }
        }
    }

    public String asL() {
        return this.cCS;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean asM() {
        return this.cCT;
    }

    public String Nv() {
        return this.mSrc;
    }

    public String asN() {
        return this.cDa;
    }

    public String asO() {
        return this.cCR;
    }

    public String asP() {
        return this.cCZ;
    }

    public boolean asQ() {
        return this.cCU;
    }

    public String asR() {
        return this.cCV;
    }

    public long getOriginalSize() {
        return this.cCW;
    }

    public boolean asS() {
        return this.cCX;
    }

    public boolean asT() {
        return this.cCY;
    }
}
