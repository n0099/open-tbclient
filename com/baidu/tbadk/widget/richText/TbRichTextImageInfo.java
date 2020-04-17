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
    private String eph;
    private String epi;
    private boolean epj;
    private boolean epk;
    private String epl;
    private long epm;
    private boolean epn;
    private boolean epo;
    private String epp;
    private String epq;
    private int mHeight;
    private String mSrc;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.mSrc = null;
        this.eph = null;
        this.epi = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.epj = false;
        this.epk = false;
        this.epl = null;
        this.epm = 0L;
        this.epn = false;
        this.epo = false;
        this.epq = null;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.mSrc = null;
        this.eph = null;
        this.epi = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.epj = false;
        this.epk = false;
        this.epl = null;
        this.epm = 0L;
        this.epn = false;
        this.epo = false;
        this.epq = null;
        if (pbContent != null) {
            this.mSrc = pbContent.src;
            this.eph = pbContent.cdn_src;
            if (this.eph == null || this.eph.length() == 0) {
                this.eph = this.mSrc;
            }
            this.epi = pbContent.big_cdn_src;
            this.epq = pbContent.big_src;
            if (StringUtils.isNull(this.epi)) {
                this.epi = this.epq;
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
            if (this.eph != null && this.eph.indexOf(".baidu.com") != -1) {
                this.epj = true;
            }
            this.epl = pbContent.origin_src;
            this.epm = pbContent.origin_size.intValue();
            this.epn = pbContent.show_original_btn.intValue() == 1;
            this.epo = pbContent.is_long_pic.intValue() == 1;
            this.epp = pbContent.cdn_src_active;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.mSrc = null;
        this.eph = null;
        this.epi = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.epj = false;
        this.epk = false;
        this.epl = null;
        this.epm = 0L;
        this.epn = false;
        this.epo = false;
        this.epq = null;
        if (jSONObject != null) {
            this.mSrc = jSONObject.optString(UserAccountActionItem.KEY_SRC);
            this.eph = jSONObject.optString("cdn_src", "");
            if (this.eph == null || this.eph.length() == 0) {
                this.eph = this.mSrc;
            }
            this.epi = jSONObject.optString("big_cdn_src", null);
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
            if (this.eph != null && this.eph.indexOf(".baidu.com") != -1) {
                this.epj = true;
            }
        }
    }

    public String bcx() {
        return this.epi;
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

    public boolean bcy() {
        return this.epj;
    }

    public String getSrc() {
        return this.mSrc;
    }

    public void setSrc(String str) {
        this.mSrc = str;
    }

    public String bcz() {
        return this.epq;
    }

    public String bcA() {
        return this.eph;
    }

    public String bcB() {
        return this.epp;
    }

    public boolean bcC() {
        return this.epk;
    }

    public String bcD() {
        return this.epl;
    }

    public void xs(String str) {
        this.epl = str;
    }

    public long getOriginalSize() {
        return this.epm;
    }

    public boolean bcE() {
        return this.epn;
    }

    public boolean bcF() {
        return this.epo;
    }

    public void im(boolean z) {
        this.epo = z;
    }
}
