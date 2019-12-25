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
    private String dKA;
    private long dKB;
    private boolean dKC;
    private boolean dKD;
    private String dKE;
    private String dKF;
    private String dKw;
    private String dKx;
    private boolean dKy;
    private boolean dKz;
    private int mHeight;
    private String mSrc;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.mSrc = null;
        this.dKw = null;
        this.dKx = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.dKy = false;
        this.dKz = false;
        this.dKA = null;
        this.dKB = 0L;
        this.dKC = false;
        this.dKD = false;
        this.dKF = null;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.mSrc = null;
        this.dKw = null;
        this.dKx = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.dKy = false;
        this.dKz = false;
        this.dKA = null;
        this.dKB = 0L;
        this.dKC = false;
        this.dKD = false;
        this.dKF = null;
        if (pbContent != null) {
            this.mSrc = pbContent.src;
            this.dKw = pbContent.cdn_src;
            if (this.dKw == null || this.dKw.length() == 0) {
                this.dKw = this.mSrc;
            }
            this.dKx = pbContent.big_cdn_src;
            this.dKF = pbContent.big_src;
            if (StringUtils.isNull(this.dKx)) {
                this.dKx = this.dKF;
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
            if (this.dKw != null && this.dKw.indexOf(".baidu.com") != -1) {
                this.dKy = true;
            }
            this.dKA = pbContent.origin_src;
            this.dKB = pbContent.origin_size.intValue();
            this.dKC = pbContent.show_original_btn.intValue() == 1;
            this.dKD = pbContent.is_long_pic.intValue() == 1;
            this.dKE = pbContent.cdn_src_active;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.mSrc = null;
        this.dKw = null;
        this.dKx = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.dKy = false;
        this.dKz = false;
        this.dKA = null;
        this.dKB = 0L;
        this.dKC = false;
        this.dKD = false;
        this.dKF = null;
        if (jSONObject != null) {
            this.mSrc = jSONObject.optString(UserAccountActionItem.KEY_SRC);
            this.dKw = jSONObject.optString("cdn_src", "");
            if (this.dKw == null || this.dKw.length() == 0) {
                this.dKw = this.mSrc;
            }
            this.dKx = jSONObject.optString("big_cdn_src", null);
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
            if (this.dKw != null && this.dKw.indexOf(".baidu.com") != -1) {
                this.dKy = true;
            }
        }
    }

    public String aRw() {
        return this.dKx;
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

    public boolean aRx() {
        return this.dKy;
    }

    public String getSrc() {
        return this.mSrc;
    }

    public void setSrc(String str) {
        this.mSrc = str;
    }

    public String aRy() {
        return this.dKF;
    }

    public String aRz() {
        return this.dKw;
    }

    public String aRA() {
        return this.dKE;
    }

    public boolean aRB() {
        return this.dKz;
    }

    public String aRC() {
        return this.dKA;
    }

    public void vG(String str) {
        this.dKA = str;
    }

    public long getOriginalSize() {
        return this.dKB;
    }

    public boolean aRD() {
        return this.dKC;
    }

    public boolean aRE() {
        return this.dKD;
    }

    public void hb(boolean z) {
        this.dKD = z;
    }
}
