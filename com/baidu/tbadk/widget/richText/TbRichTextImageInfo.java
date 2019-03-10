package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String cCS;
    private String cCT;
    private boolean cCU;
    private boolean cCV;
    private String cCW;
    private long cCX;
    private boolean cCY;
    private boolean cCZ;
    private String cDa;
    private String cDb;
    private int mHeight;
    private String mSrc;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.mSrc = null;
        this.cCS = null;
        this.cCT = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.cCU = false;
        this.cCV = false;
        this.cCW = null;
        this.cCX = 0L;
        this.cCY = false;
        this.cCZ = false;
        this.cDb = null;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.mSrc = null;
        this.cCS = null;
        this.cCT = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.cCU = false;
        this.cCV = false;
        this.cCW = null;
        this.cCX = 0L;
        this.cCY = false;
        this.cCZ = false;
        this.cDb = null;
        if (pbContent != null) {
            this.mSrc = pbContent.src;
            this.cCS = pbContent.cdn_src;
            if (this.cCS == null || this.cCS.length() == 0) {
                this.cCS = this.mSrc;
            }
            this.cCT = pbContent.big_cdn_src;
            this.cDb = pbContent.big_src;
            if (StringUtils.isNull(this.cCT)) {
                this.cCT = this.cDb;
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
            if (this.cCS != null && this.cCS.indexOf(".baidu.com") != -1) {
                this.cCU = true;
            }
            this.cCW = pbContent.origin_src;
            this.cCX = pbContent.origin_size.intValue();
            this.cCY = pbContent.show_original_btn.intValue() == 1;
            this.cCZ = pbContent.is_long_pic.intValue() == 1;
            this.cDa = pbContent.cdn_src_active;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.mSrc = null;
        this.cCS = null;
        this.cCT = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.cCU = false;
        this.cCV = false;
        this.cCW = null;
        this.cCX = 0L;
        this.cCY = false;
        this.cCZ = false;
        this.cDb = null;
        if (jSONObject != null) {
            this.mSrc = jSONObject.optString("src");
            this.cCS = jSONObject.optString("cdn_src", "");
            if (this.cCS == null || this.cCS.length() == 0) {
                this.cCS = this.mSrc;
            }
            this.cCT = jSONObject.optString("big_cdn_src", null);
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
            if (this.cCS != null && this.cCS.indexOf(".baidu.com") != -1) {
                this.cCU = true;
            }
        }
    }

    public String asP() {
        return this.cCT;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean asQ() {
        return this.cCU;
    }

    public String Nx() {
        return this.mSrc;
    }

    public String asR() {
        return this.cDb;
    }

    public String asS() {
        return this.cCS;
    }

    public String asT() {
        return this.cDa;
    }

    public boolean asU() {
        return this.cCV;
    }

    public String asV() {
        return this.cCW;
    }

    public long getOriginalSize() {
        return this.cCX;
    }

    public boolean asW() {
        return this.cCY;
    }

    public boolean asX() {
        return this.cCZ;
    }
}
