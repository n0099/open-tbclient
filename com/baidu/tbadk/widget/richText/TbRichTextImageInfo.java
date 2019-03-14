package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String cCP;
    private String cCQ;
    private boolean cCR;
    private boolean cCS;
    private String cCT;
    private long cCU;
    private boolean cCV;
    private boolean cCW;
    private String cCX;
    private String cCY;
    private int mHeight;
    private String mSrc;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.mSrc = null;
        this.cCP = null;
        this.cCQ = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.cCR = false;
        this.cCS = false;
        this.cCT = null;
        this.cCU = 0L;
        this.cCV = false;
        this.cCW = false;
        this.cCY = null;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.mSrc = null;
        this.cCP = null;
        this.cCQ = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.cCR = false;
        this.cCS = false;
        this.cCT = null;
        this.cCU = 0L;
        this.cCV = false;
        this.cCW = false;
        this.cCY = null;
        if (pbContent != null) {
            this.mSrc = pbContent.src;
            this.cCP = pbContent.cdn_src;
            if (this.cCP == null || this.cCP.length() == 0) {
                this.cCP = this.mSrc;
            }
            this.cCQ = pbContent.big_cdn_src;
            this.cCY = pbContent.big_src;
            if (StringUtils.isNull(this.cCQ)) {
                this.cCQ = this.cCY;
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
            if (this.cCP != null && this.cCP.indexOf(".baidu.com") != -1) {
                this.cCR = true;
            }
            this.cCT = pbContent.origin_src;
            this.cCU = pbContent.origin_size.intValue();
            this.cCV = pbContent.show_original_btn.intValue() == 1;
            this.cCW = pbContent.is_long_pic.intValue() == 1;
            this.cCX = pbContent.cdn_src_active;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.mSrc = null;
        this.cCP = null;
        this.cCQ = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.cCR = false;
        this.cCS = false;
        this.cCT = null;
        this.cCU = 0L;
        this.cCV = false;
        this.cCW = false;
        this.cCY = null;
        if (jSONObject != null) {
            this.mSrc = jSONObject.optString("src");
            this.cCP = jSONObject.optString("cdn_src", "");
            if (this.cCP == null || this.cCP.length() == 0) {
                this.cCP = this.mSrc;
            }
            this.cCQ = jSONObject.optString("big_cdn_src", null);
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
            if (this.cCP != null && this.cCP.indexOf(".baidu.com") != -1) {
                this.cCR = true;
            }
        }
    }

    public String asO() {
        return this.cCQ;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean asP() {
        return this.cCR;
    }

    public String Nx() {
        return this.mSrc;
    }

    public String asQ() {
        return this.cCY;
    }

    public String asR() {
        return this.cCP;
    }

    public String asS() {
        return this.cCX;
    }

    public boolean asT() {
        return this.cCS;
    }

    public String asU() {
        return this.cCT;
    }

    public long getOriginalSize() {
        return this.cCU;
    }

    public boolean asV() {
        return this.cCV;
    }

    public boolean asW() {
        return this.cCW;
    }
}
