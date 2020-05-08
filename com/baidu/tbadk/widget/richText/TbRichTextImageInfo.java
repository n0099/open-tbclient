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
    private String epm;
    private String epn;
    private boolean epo;
    private boolean epp;
    private String epq;
    private long epr;
    private boolean eps;
    private boolean ept;
    private String epu;
    private String epv;
    private int mHeight;
    private String mSrc;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.mSrc = null;
        this.epm = null;
        this.epn = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.epo = false;
        this.epp = false;
        this.epq = null;
        this.epr = 0L;
        this.eps = false;
        this.ept = false;
        this.epv = null;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.mSrc = null;
        this.epm = null;
        this.epn = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.epo = false;
        this.epp = false;
        this.epq = null;
        this.epr = 0L;
        this.eps = false;
        this.ept = false;
        this.epv = null;
        if (pbContent != null) {
            this.mSrc = pbContent.src;
            this.epm = pbContent.cdn_src;
            if (this.epm == null || this.epm.length() == 0) {
                this.epm = this.mSrc;
            }
            this.epn = pbContent.big_cdn_src;
            this.epv = pbContent.big_src;
            if (StringUtils.isNull(this.epn)) {
                this.epn = this.epv;
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
            if (this.epm != null && this.epm.indexOf(".baidu.com") != -1) {
                this.epo = true;
            }
            this.epq = pbContent.origin_src;
            this.epr = pbContent.origin_size.intValue();
            this.eps = pbContent.show_original_btn.intValue() == 1;
            this.ept = pbContent.is_long_pic.intValue() == 1;
            this.epu = pbContent.cdn_src_active;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.mSrc = null;
        this.epm = null;
        this.epn = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.epo = false;
        this.epp = false;
        this.epq = null;
        this.epr = 0L;
        this.eps = false;
        this.ept = false;
        this.epv = null;
        if (jSONObject != null) {
            this.mSrc = jSONObject.optString(UserAccountActionItem.KEY_SRC);
            this.epm = jSONObject.optString("cdn_src", "");
            if (this.epm == null || this.epm.length() == 0) {
                this.epm = this.mSrc;
            }
            this.epn = jSONObject.optString("big_cdn_src", null);
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
            if (this.epm != null && this.epm.indexOf(".baidu.com") != -1) {
                this.epo = true;
            }
        }
    }

    public String bcv() {
        return this.epn;
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

    public boolean bcw() {
        return this.epo;
    }

    public String getSrc() {
        return this.mSrc;
    }

    public void setSrc(String str) {
        this.mSrc = str;
    }

    public String bcx() {
        return this.epv;
    }

    public String bcy() {
        return this.epm;
    }

    public String bcz() {
        return this.epu;
    }

    public boolean bcA() {
        return this.epp;
    }

    public String bcB() {
        return this.epq;
    }

    public void xv(String str) {
        this.epq = str;
    }

    public long getOriginalSize() {
        return this.epr;
    }

    public boolean bcC() {
        return this.eps;
    }

    public boolean bcD() {
        return this.ept;
    }

    public void im(boolean z) {
        this.ept = z;
    }
}
