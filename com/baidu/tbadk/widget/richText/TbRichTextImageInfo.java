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
    private String dKD;
    private String dKE;
    private boolean dKF;
    private boolean dKG;
    private String dKH;
    private long dKI;
    private boolean dKJ;
    private boolean dKK;
    private String dKL;
    private String dKM;
    private int mHeight;
    private String mSrc;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.mSrc = null;
        this.dKD = null;
        this.dKE = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.dKF = false;
        this.dKG = false;
        this.dKH = null;
        this.dKI = 0L;
        this.dKJ = false;
        this.dKK = false;
        this.dKM = null;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.mSrc = null;
        this.dKD = null;
        this.dKE = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.dKF = false;
        this.dKG = false;
        this.dKH = null;
        this.dKI = 0L;
        this.dKJ = false;
        this.dKK = false;
        this.dKM = null;
        if (pbContent != null) {
            this.mSrc = pbContent.src;
            this.dKD = pbContent.cdn_src;
            if (this.dKD == null || this.dKD.length() == 0) {
                this.dKD = this.mSrc;
            }
            this.dKE = pbContent.big_cdn_src;
            this.dKM = pbContent.big_src;
            if (StringUtils.isNull(this.dKE)) {
                this.dKE = this.dKM;
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
            if (this.dKD != null && this.dKD.indexOf(".baidu.com") != -1) {
                this.dKF = true;
            }
            this.dKH = pbContent.origin_src;
            this.dKI = pbContent.origin_size.intValue();
            this.dKJ = pbContent.show_original_btn.intValue() == 1;
            this.dKK = pbContent.is_long_pic.intValue() == 1;
            this.dKL = pbContent.cdn_src_active;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.mSrc = null;
        this.dKD = null;
        this.dKE = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.dKF = false;
        this.dKG = false;
        this.dKH = null;
        this.dKI = 0L;
        this.dKJ = false;
        this.dKK = false;
        this.dKM = null;
        if (jSONObject != null) {
            this.mSrc = jSONObject.optString(UserAccountActionItem.KEY_SRC);
            this.dKD = jSONObject.optString("cdn_src", "");
            if (this.dKD == null || this.dKD.length() == 0) {
                this.dKD = this.mSrc;
            }
            this.dKE = jSONObject.optString("big_cdn_src", null);
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
            if (this.dKD != null && this.dKD.indexOf(".baidu.com") != -1) {
                this.dKF = true;
            }
        }
    }

    public String aRQ() {
        return this.dKE;
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

    public boolean aRR() {
        return this.dKF;
    }

    public String getSrc() {
        return this.mSrc;
    }

    public void setSrc(String str) {
        this.mSrc = str;
    }

    public String aRS() {
        return this.dKM;
    }

    public String aRT() {
        return this.dKD;
    }

    public String aRU() {
        return this.dKL;
    }

    public boolean aRV() {
        return this.dKG;
    }

    public String aRW() {
        return this.dKH;
    }

    public void vK(String str) {
        this.dKH = str;
    }

    public long getOriginalSize() {
        return this.dKI;
    }

    public boolean aRX() {
        return this.dKJ;
    }

    public boolean aRY() {
        return this.dKK;
    }

    public void hg(boolean z) {
        this.dKK = z;
    }
}
