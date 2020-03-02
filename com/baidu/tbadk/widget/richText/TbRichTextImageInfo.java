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
    private String dOJ;
    private String dOK;
    private boolean dOL;
    private boolean dOM;
    private String dON;
    private long dOO;
    private boolean dOP;
    private boolean dOQ;
    private String dOR;
    private String dOS;
    private int mHeight;
    private String mSrc;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.mSrc = null;
        this.dOJ = null;
        this.dOK = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.dOL = false;
        this.dOM = false;
        this.dON = null;
        this.dOO = 0L;
        this.dOP = false;
        this.dOQ = false;
        this.dOS = null;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.mSrc = null;
        this.dOJ = null;
        this.dOK = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.dOL = false;
        this.dOM = false;
        this.dON = null;
        this.dOO = 0L;
        this.dOP = false;
        this.dOQ = false;
        this.dOS = null;
        if (pbContent != null) {
            this.mSrc = pbContent.src;
            this.dOJ = pbContent.cdn_src;
            if (this.dOJ == null || this.dOJ.length() == 0) {
                this.dOJ = this.mSrc;
            }
            this.dOK = pbContent.big_cdn_src;
            this.dOS = pbContent.big_src;
            if (StringUtils.isNull(this.dOK)) {
                this.dOK = this.dOS;
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
            if (this.dOJ != null && this.dOJ.indexOf(".baidu.com") != -1) {
                this.dOL = true;
            }
            this.dON = pbContent.origin_src;
            this.dOO = pbContent.origin_size.intValue();
            this.dOP = pbContent.show_original_btn.intValue() == 1;
            this.dOQ = pbContent.is_long_pic.intValue() == 1;
            this.dOR = pbContent.cdn_src_active;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.mSrc = null;
        this.dOJ = null;
        this.dOK = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.dOL = false;
        this.dOM = false;
        this.dON = null;
        this.dOO = 0L;
        this.dOP = false;
        this.dOQ = false;
        this.dOS = null;
        if (jSONObject != null) {
            this.mSrc = jSONObject.optString(UserAccountActionItem.KEY_SRC);
            this.dOJ = jSONObject.optString("cdn_src", "");
            if (this.dOJ == null || this.dOJ.length() == 0) {
                this.dOJ = this.mSrc;
            }
            this.dOK = jSONObject.optString("big_cdn_src", null);
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
            if (this.dOJ != null && this.dOJ.indexOf(".baidu.com") != -1) {
                this.dOL = true;
            }
        }
    }

    public String aUi() {
        return this.dOK;
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

    public boolean aUj() {
        return this.dOL;
    }

    public String getSrc() {
        return this.mSrc;
    }

    public void setSrc(String str) {
        this.mSrc = str;
    }

    public String aUk() {
        return this.dOS;
    }

    public String aUl() {
        return this.dOJ;
    }

    public String aUm() {
        return this.dOR;
    }

    public boolean aUn() {
        return this.dOM;
    }

    public String aUo() {
        return this.dON;
    }

    public void we(String str) {
        this.dON = str;
    }

    public long getOriginalSize() {
        return this.dOO;
    }

    public boolean aUp() {
        return this.dOP;
    }

    public boolean aUq() {
        return this.dOQ;
    }

    public void hn(boolean z) {
        this.dOQ = z;
    }
}
