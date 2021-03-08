package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String fYI;
    private String fYJ;
    private boolean fYK;
    private boolean fYL;
    private String fYM;
    private long fYN;
    private boolean fYO;
    private boolean fYP;
    private String fYQ;
    private String fYR;
    private int mHeight;
    private String mSrc;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.mSrc = null;
        this.fYI = null;
        this.fYJ = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.fYK = false;
        this.fYL = false;
        this.fYM = null;
        this.fYN = 0L;
        this.fYO = false;
        this.fYP = false;
        this.fYR = null;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.mSrc = null;
        this.fYI = null;
        this.fYJ = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.fYK = false;
        this.fYL = false;
        this.fYM = null;
        this.fYN = 0L;
        this.fYO = false;
        this.fYP = false;
        this.fYR = null;
        if (pbContent != null) {
            this.mSrc = pbContent.src;
            this.fYI = pbContent.cdn_src;
            if (this.fYI == null || this.fYI.length() == 0) {
                this.fYI = this.mSrc;
            }
            this.fYJ = pbContent.big_cdn_src;
            this.fYR = pbContent.big_src;
            if (StringUtils.isNull(this.fYJ)) {
                this.fYJ = this.fYR;
            }
            String str = pbContent.bsize;
            if (str != null) {
                try {
                    String[] split = str.split(",");
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
            if (this.fYI != null && this.fYI.indexOf(".baidu.com") != -1) {
                this.fYK = true;
            }
            this.fYM = pbContent.origin_src;
            this.fYN = pbContent.origin_size.intValue();
            this.fYO = pbContent.show_original_btn.intValue() == 1;
            this.fYP = pbContent.is_long_pic.intValue() == 1;
            this.fYQ = pbContent.cdn_src_active;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.mSrc = null;
        this.fYI = null;
        this.fYJ = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.fYK = false;
        this.fYL = false;
        this.fYM = null;
        this.fYN = 0L;
        this.fYO = false;
        this.fYP = false;
        this.fYR = null;
        if (jSONObject != null) {
            this.mSrc = jSONObject.optString(UserAccountActionItem.KEY_SRC);
            this.fYI = jSONObject.optString("cdn_src", "");
            if (this.fYI == null || this.fYI.length() == 0) {
                this.fYI = this.mSrc;
            }
            this.fYJ = jSONObject.optString("big_cdn_src", null);
            try {
                String[] split = jSONObject.optString("bsize").split(",");
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
            if (this.fYI != null && this.fYI.indexOf(".baidu.com") != -1) {
                this.fYK = true;
            }
        }
    }

    public String bHT() {
        return this.fYJ;
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

    public boolean bHU() {
        return this.fYK;
    }

    public String getSrc() {
        return this.mSrc;
    }

    public void setSrc(String str) {
        this.mSrc = str;
    }

    public String bHV() {
        return this.fYR;
    }

    public String bHW() {
        return this.fYI;
    }

    public String bHX() {
        return this.fYQ;
    }

    public boolean bHY() {
        return this.fYL;
    }

    public String bHZ() {
        return this.fYM;
    }

    public void Ei(String str) {
        this.fYM = str;
    }

    public long getOriginalSize() {
        return this.fYN;
    }

    public boolean bIa() {
        return this.fYO;
    }

    public boolean bIb() {
        return this.fYP;
    }

    public void lM(boolean z) {
        this.fYP = z;
    }
}
