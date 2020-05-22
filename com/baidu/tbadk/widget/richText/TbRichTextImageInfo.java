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
    private String eDN;
    private String eDO;
    private boolean eDP;
    private boolean eDQ;
    private String eDR;
    private long eDS;
    private boolean eDT;
    private boolean eDU;
    private String eDV;
    private String eDW;
    private int mHeight;
    private String mSrc;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.mSrc = null;
        this.eDN = null;
        this.eDO = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.eDP = false;
        this.eDQ = false;
        this.eDR = null;
        this.eDS = 0L;
        this.eDT = false;
        this.eDU = false;
        this.eDW = null;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.mSrc = null;
        this.eDN = null;
        this.eDO = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.eDP = false;
        this.eDQ = false;
        this.eDR = null;
        this.eDS = 0L;
        this.eDT = false;
        this.eDU = false;
        this.eDW = null;
        if (pbContent != null) {
            this.mSrc = pbContent.src;
            this.eDN = pbContent.cdn_src;
            if (this.eDN == null || this.eDN.length() == 0) {
                this.eDN = this.mSrc;
            }
            this.eDO = pbContent.big_cdn_src;
            this.eDW = pbContent.big_src;
            if (StringUtils.isNull(this.eDO)) {
                this.eDO = this.eDW;
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
            if (this.eDN != null && this.eDN.indexOf(".baidu.com") != -1) {
                this.eDP = true;
            }
            this.eDR = pbContent.origin_src;
            this.eDS = pbContent.origin_size.intValue();
            this.eDT = pbContent.show_original_btn.intValue() == 1;
            this.eDU = pbContent.is_long_pic.intValue() == 1;
            this.eDV = pbContent.cdn_src_active;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.mSrc = null;
        this.eDN = null;
        this.eDO = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.eDP = false;
        this.eDQ = false;
        this.eDR = null;
        this.eDS = 0L;
        this.eDT = false;
        this.eDU = false;
        this.eDW = null;
        if (jSONObject != null) {
            this.mSrc = jSONObject.optString(UserAccountActionItem.KEY_SRC);
            this.eDN = jSONObject.optString("cdn_src", "");
            if (this.eDN == null || this.eDN.length() == 0) {
                this.eDN = this.mSrc;
            }
            this.eDO = jSONObject.optString("big_cdn_src", null);
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
            if (this.eDN != null && this.eDN.indexOf(".baidu.com") != -1) {
                this.eDP = true;
            }
        }
    }

    public String biG() {
        return this.eDO;
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

    public boolean biH() {
        return this.eDP;
    }

    public String getSrc() {
        return this.mSrc;
    }

    public void setSrc(String str) {
        this.mSrc = str;
    }

    public String biI() {
        return this.eDW;
    }

    public String biJ() {
        return this.eDN;
    }

    public String biK() {
        return this.eDV;
    }

    public boolean biL() {
        return this.eDQ;
    }

    public String biM() {
        return this.eDR;
    }

    public void zb(String str) {
        this.eDR = str;
    }

    public long getOriginalSize() {
        return this.eDS;
    }

    public boolean biN() {
        return this.eDT;
    }

    public boolean biO() {
        return this.eDU;
    }

    public void iJ(boolean z) {
        this.eDU = z;
    }
}
