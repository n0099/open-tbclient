package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String eDY;
    private String eDZ;
    private boolean eEa;
    private boolean eEb;
    private String eEc;
    private long eEd;
    private boolean eEe;
    private boolean eEf;
    private String eEg;
    private String eEh;
    private int mHeight;
    private String mSrc;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.mSrc = null;
        this.eDY = null;
        this.eDZ = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.eEa = false;
        this.eEb = false;
        this.eEc = null;
        this.eEd = 0L;
        this.eEe = false;
        this.eEf = false;
        this.eEh = null;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.mSrc = null;
        this.eDY = null;
        this.eDZ = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.eEa = false;
        this.eEb = false;
        this.eEc = null;
        this.eEd = 0L;
        this.eEe = false;
        this.eEf = false;
        this.eEh = null;
        if (pbContent != null) {
            this.mSrc = pbContent.src;
            this.eDY = pbContent.cdn_src;
            if (this.eDY == null || this.eDY.length() == 0) {
                this.eDY = this.mSrc;
            }
            this.eDZ = pbContent.big_cdn_src;
            this.eEh = pbContent.big_src;
            if (StringUtils.isNull(this.eDZ)) {
                this.eDZ = this.eEh;
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
            if (this.eDY != null && this.eDY.indexOf(".baidu.com") != -1) {
                this.eEa = true;
            }
            this.eEc = pbContent.origin_src;
            this.eEd = pbContent.origin_size.intValue();
            this.eEe = pbContent.show_original_btn.intValue() == 1;
            this.eEf = pbContent.is_long_pic.intValue() == 1;
            this.eEg = pbContent.cdn_src_active;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.mSrc = null;
        this.eDY = null;
        this.eDZ = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.eEa = false;
        this.eEb = false;
        this.eEc = null;
        this.eEd = 0L;
        this.eEe = false;
        this.eEf = false;
        this.eEh = null;
        if (jSONObject != null) {
            this.mSrc = jSONObject.optString(UserAccountActionItem.KEY_SRC);
            this.eDY = jSONObject.optString("cdn_src", "");
            if (this.eDY == null || this.eDY.length() == 0) {
                this.eDY = this.mSrc;
            }
            this.eDZ = jSONObject.optString("big_cdn_src", null);
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
            if (this.eDY != null && this.eDY.indexOf(".baidu.com") != -1) {
                this.eEa = true;
            }
        }
    }

    public String biI() {
        return this.eDZ;
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

    public boolean biJ() {
        return this.eEa;
    }

    public String getSrc() {
        return this.mSrc;
    }

    public void setSrc(String str) {
        this.mSrc = str;
    }

    public String biK() {
        return this.eEh;
    }

    public String biL() {
        return this.eDY;
    }

    public String biM() {
        return this.eEg;
    }

    public boolean biN() {
        return this.eEb;
    }

    public String biO() {
        return this.eEc;
    }

    public void zb(String str) {
        this.eEc = str;
    }

    public long getOriginalSize() {
        return this.eEd;
    }

    public boolean biP() {
        return this.eEe;
    }

    public boolean biQ() {
        return this.eEf;
    }

    public void iJ(boolean z) {
        this.eEf = z;
    }
}
