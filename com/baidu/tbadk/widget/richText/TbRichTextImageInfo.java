package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String fUT;
    private String fUU;
    private boolean fUV;
    private boolean fUW;
    private String fUX;
    private long fUY;
    private boolean fUZ;
    private boolean fVa;
    private String fVb;
    private String fVc;
    private int mHeight;
    private String mSrc;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.mSrc = null;
        this.fUT = null;
        this.fUU = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.fUV = false;
        this.fUW = false;
        this.fUX = null;
        this.fUY = 0L;
        this.fUZ = false;
        this.fVa = false;
        this.fVc = null;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.mSrc = null;
        this.fUT = null;
        this.fUU = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.fUV = false;
        this.fUW = false;
        this.fUX = null;
        this.fUY = 0L;
        this.fUZ = false;
        this.fVa = false;
        this.fVc = null;
        if (pbContent != null) {
            this.mSrc = pbContent.src;
            this.fUT = pbContent.cdn_src;
            if (this.fUT == null || this.fUT.length() == 0) {
                this.fUT = this.mSrc;
            }
            this.fUU = pbContent.big_cdn_src;
            this.fVc = pbContent.big_src;
            if (StringUtils.isNull(this.fUU)) {
                this.fUU = this.fVc;
            }
            String str = pbContent.bsize;
            if (str != null) {
                try {
                    String[] split = str.split(",");
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
            if (this.fUT != null && this.fUT.indexOf(".baidu.com") != -1) {
                this.fUV = true;
            }
            this.fUX = pbContent.origin_src;
            this.fUY = pbContent.origin_size.intValue();
            this.fUZ = pbContent.show_original_btn.intValue() == 1;
            this.fVa = pbContent.is_long_pic.intValue() == 1;
            this.fVb = pbContent.cdn_src_active;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.mSrc = null;
        this.fUT = null;
        this.fUU = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.fUV = false;
        this.fUW = false;
        this.fUX = null;
        this.fUY = 0L;
        this.fUZ = false;
        this.fVa = false;
        this.fVc = null;
        if (jSONObject != null) {
            this.mSrc = jSONObject.optString(UserAccountActionItem.KEY_SRC);
            this.fUT = jSONObject.optString("cdn_src", "");
            if (this.fUT == null || this.fUT.length() == 0) {
                this.fUT = this.mSrc;
            }
            this.fUU = jSONObject.optString("big_cdn_src", null);
            try {
                String[] split = jSONObject.optString("bsize").split(",");
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
            if (this.fUT != null && this.fUT.indexOf(".baidu.com") != -1) {
                this.fUV = true;
            }
        }
    }

    public String bHv() {
        return this.fUU;
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

    public boolean bHw() {
        return this.fUV;
    }

    public String getSrc() {
        return this.mSrc;
    }

    public void setSrc(String str) {
        this.mSrc = str;
    }

    public String bHx() {
        return this.fVc;
    }

    public String bHy() {
        return this.fUT;
    }

    public String bHz() {
        return this.fVb;
    }

    public boolean bHA() {
        return this.fUW;
    }

    public String bHB() {
        return this.fUX;
    }

    public void DH(String str) {
        this.fUX = str;
    }

    public long getOriginalSize() {
        return this.fUY;
    }

    public boolean bHC() {
        return this.fUZ;
    }

    public boolean bHD() {
        return this.fVa;
    }

    public void lI(boolean z) {
        this.fVa = z;
    }
}
