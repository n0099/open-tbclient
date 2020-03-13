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
    private String dOW;
    private String dOX;
    private boolean dOY;
    private boolean dOZ;
    private String dPa;
    private long dPb;
    private boolean dPc;
    private boolean dPd;
    private String dPe;
    private String dPf;
    private int mHeight;
    private String mSrc;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.mSrc = null;
        this.dOW = null;
        this.dOX = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.dOY = false;
        this.dOZ = false;
        this.dPa = null;
        this.dPb = 0L;
        this.dPc = false;
        this.dPd = false;
        this.dPf = null;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.mSrc = null;
        this.dOW = null;
        this.dOX = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.dOY = false;
        this.dOZ = false;
        this.dPa = null;
        this.dPb = 0L;
        this.dPc = false;
        this.dPd = false;
        this.dPf = null;
        if (pbContent != null) {
            this.mSrc = pbContent.src;
            this.dOW = pbContent.cdn_src;
            if (this.dOW == null || this.dOW.length() == 0) {
                this.dOW = this.mSrc;
            }
            this.dOX = pbContent.big_cdn_src;
            this.dPf = pbContent.big_src;
            if (StringUtils.isNull(this.dOX)) {
                this.dOX = this.dPf;
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
            if (this.dOW != null && this.dOW.indexOf(".baidu.com") != -1) {
                this.dOY = true;
            }
            this.dPa = pbContent.origin_src;
            this.dPb = pbContent.origin_size.intValue();
            this.dPc = pbContent.show_original_btn.intValue() == 1;
            this.dPd = pbContent.is_long_pic.intValue() == 1;
            this.dPe = pbContent.cdn_src_active;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.mSrc = null;
        this.dOW = null;
        this.dOX = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.dOY = false;
        this.dOZ = false;
        this.dPa = null;
        this.dPb = 0L;
        this.dPc = false;
        this.dPd = false;
        this.dPf = null;
        if (jSONObject != null) {
            this.mSrc = jSONObject.optString(UserAccountActionItem.KEY_SRC);
            this.dOW = jSONObject.optString("cdn_src", "");
            if (this.dOW == null || this.dOW.length() == 0) {
                this.dOW = this.mSrc;
            }
            this.dOX = jSONObject.optString("big_cdn_src", null);
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
            if (this.dOW != null && this.dOW.indexOf(".baidu.com") != -1) {
                this.dOY = true;
            }
        }
    }

    public String aUj() {
        return this.dOX;
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

    public boolean aUk() {
        return this.dOY;
    }

    public String getSrc() {
        return this.mSrc;
    }

    public void setSrc(String str) {
        this.mSrc = str;
    }

    public String aUl() {
        return this.dPf;
    }

    public String aUm() {
        return this.dOW;
    }

    public String aUn() {
        return this.dPe;
    }

    public boolean aUo() {
        return this.dOZ;
    }

    public String aUp() {
        return this.dPa;
    }

    public void wf(String str) {
        this.dPa = str;
    }

    public long getOriginalSize() {
        return this.dPb;
    }

    public boolean aUq() {
        return this.dPc;
    }

    public boolean aUr() {
        return this.dPd;
    }

    public void hn(boolean z) {
        this.dPd = z;
    }
}
