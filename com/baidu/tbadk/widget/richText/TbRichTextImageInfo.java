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
    private String dOI;
    private String dOJ;
    private boolean dOK;
    private boolean dOL;
    private String dOM;
    private long dON;
    private boolean dOO;
    private boolean dOP;
    private String dOQ;
    private String dOR;
    private int mHeight;
    private String mSrc;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.mSrc = null;
        this.dOI = null;
        this.dOJ = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.dOK = false;
        this.dOL = false;
        this.dOM = null;
        this.dON = 0L;
        this.dOO = false;
        this.dOP = false;
        this.dOR = null;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.mSrc = null;
        this.dOI = null;
        this.dOJ = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.dOK = false;
        this.dOL = false;
        this.dOM = null;
        this.dON = 0L;
        this.dOO = false;
        this.dOP = false;
        this.dOR = null;
        if (pbContent != null) {
            this.mSrc = pbContent.src;
            this.dOI = pbContent.cdn_src;
            if (this.dOI == null || this.dOI.length() == 0) {
                this.dOI = this.mSrc;
            }
            this.dOJ = pbContent.big_cdn_src;
            this.dOR = pbContent.big_src;
            if (StringUtils.isNull(this.dOJ)) {
                this.dOJ = this.dOR;
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
            if (this.dOI != null && this.dOI.indexOf(".baidu.com") != -1) {
                this.dOK = true;
            }
            this.dOM = pbContent.origin_src;
            this.dON = pbContent.origin_size.intValue();
            this.dOO = pbContent.show_original_btn.intValue() == 1;
            this.dOP = pbContent.is_long_pic.intValue() == 1;
            this.dOQ = pbContent.cdn_src_active;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.mSrc = null;
        this.dOI = null;
        this.dOJ = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.dOK = false;
        this.dOL = false;
        this.dOM = null;
        this.dON = 0L;
        this.dOO = false;
        this.dOP = false;
        this.dOR = null;
        if (jSONObject != null) {
            this.mSrc = jSONObject.optString(UserAccountActionItem.KEY_SRC);
            this.dOI = jSONObject.optString("cdn_src", "");
            if (this.dOI == null || this.dOI.length() == 0) {
                this.dOI = this.mSrc;
            }
            this.dOJ = jSONObject.optString("big_cdn_src", null);
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
            if (this.dOI != null && this.dOI.indexOf(".baidu.com") != -1) {
                this.dOK = true;
            }
        }
    }

    public String aUg() {
        return this.dOJ;
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

    public boolean aUh() {
        return this.dOK;
    }

    public String getSrc() {
        return this.mSrc;
    }

    public void setSrc(String str) {
        this.mSrc = str;
    }

    public String aUi() {
        return this.dOR;
    }

    public String aUj() {
        return this.dOI;
    }

    public String aUk() {
        return this.dOQ;
    }

    public boolean aUl() {
        return this.dOL;
    }

    public String aUm() {
        return this.dOM;
    }

    public void we(String str) {
        this.dOM = str;
    }

    public long getOriginalSize() {
        return this.dON;
    }

    public boolean aUn() {
        return this.dOO;
    }

    public boolean aUo() {
        return this.dOP;
    }

    public void hn(boolean z) {
        this.dOP = z;
    }
}
