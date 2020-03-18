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
    private String dPn;
    private String dPo;
    private boolean dPp;
    private boolean dPq;
    private String dPr;
    private long dPs;
    private boolean dPt;
    private boolean dPu;
    private String dPv;
    private String dPw;
    private int mHeight;
    private String mSrc;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.mSrc = null;
        this.dPn = null;
        this.dPo = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.dPp = false;
        this.dPq = false;
        this.dPr = null;
        this.dPs = 0L;
        this.dPt = false;
        this.dPu = false;
        this.dPw = null;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.mSrc = null;
        this.dPn = null;
        this.dPo = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.dPp = false;
        this.dPq = false;
        this.dPr = null;
        this.dPs = 0L;
        this.dPt = false;
        this.dPu = false;
        this.dPw = null;
        if (pbContent != null) {
            this.mSrc = pbContent.src;
            this.dPn = pbContent.cdn_src;
            if (this.dPn == null || this.dPn.length() == 0) {
                this.dPn = this.mSrc;
            }
            this.dPo = pbContent.big_cdn_src;
            this.dPw = pbContent.big_src;
            if (StringUtils.isNull(this.dPo)) {
                this.dPo = this.dPw;
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
            if (this.dPn != null && this.dPn.indexOf(".baidu.com") != -1) {
                this.dPp = true;
            }
            this.dPr = pbContent.origin_src;
            this.dPs = pbContent.origin_size.intValue();
            this.dPt = pbContent.show_original_btn.intValue() == 1;
            this.dPu = pbContent.is_long_pic.intValue() == 1;
            this.dPv = pbContent.cdn_src_active;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.mSrc = null;
        this.dPn = null;
        this.dPo = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.dPp = false;
        this.dPq = false;
        this.dPr = null;
        this.dPs = 0L;
        this.dPt = false;
        this.dPu = false;
        this.dPw = null;
        if (jSONObject != null) {
            this.mSrc = jSONObject.optString(UserAccountActionItem.KEY_SRC);
            this.dPn = jSONObject.optString("cdn_src", "");
            if (this.dPn == null || this.dPn.length() == 0) {
                this.dPn = this.mSrc;
            }
            this.dPo = jSONObject.optString("big_cdn_src", null);
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
            if (this.dPn != null && this.dPn.indexOf(".baidu.com") != -1) {
                this.dPp = true;
            }
        }
    }

    public String aUn() {
        return this.dPo;
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

    public boolean aUo() {
        return this.dPp;
    }

    public String getSrc() {
        return this.mSrc;
    }

    public void setSrc(String str) {
        this.mSrc = str;
    }

    public String aUp() {
        return this.dPw;
    }

    public String aUq() {
        return this.dPn;
    }

    public String aUr() {
        return this.dPv;
    }

    public boolean aUs() {
        return this.dPq;
    }

    public String aUt() {
        return this.dPr;
    }

    public void wf(String str) {
        this.dPr = str;
    }

    public long getOriginalSize() {
        return this.dPs;
    }

    public boolean aUu() {
        return this.dPt;
    }

    public boolean aUv() {
        return this.dPu;
    }

    public void ho(boolean z) {
        this.dPu = z;
    }
}
