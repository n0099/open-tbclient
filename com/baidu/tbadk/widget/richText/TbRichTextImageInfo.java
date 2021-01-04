package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String fZA;
    private String fZB;
    private boolean fZC;
    private boolean fZD;
    private String fZE;
    private long fZF;
    private boolean fZG;
    private boolean fZH;
    private String fZI;
    private String fZJ;
    private int mHeight;
    private String mSrc;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.mSrc = null;
        this.fZA = null;
        this.fZB = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.fZC = false;
        this.fZD = false;
        this.fZE = null;
        this.fZF = 0L;
        this.fZG = false;
        this.fZH = false;
        this.fZJ = null;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.mSrc = null;
        this.fZA = null;
        this.fZB = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.fZC = false;
        this.fZD = false;
        this.fZE = null;
        this.fZF = 0L;
        this.fZG = false;
        this.fZH = false;
        this.fZJ = null;
        if (pbContent != null) {
            this.mSrc = pbContent.src;
            this.fZA = pbContent.cdn_src;
            if (this.fZA == null || this.fZA.length() == 0) {
                this.fZA = this.mSrc;
            }
            this.fZB = pbContent.big_cdn_src;
            this.fZJ = pbContent.big_src;
            if (StringUtils.isNull(this.fZB)) {
                this.fZB = this.fZJ;
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
            if (this.fZA != null && this.fZA.indexOf(".baidu.com") != -1) {
                this.fZC = true;
            }
            this.fZE = pbContent.origin_src;
            this.fZF = pbContent.origin_size.intValue();
            this.fZG = pbContent.show_original_btn.intValue() == 1;
            this.fZH = pbContent.is_long_pic.intValue() == 1;
            this.fZI = pbContent.cdn_src_active;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.mSrc = null;
        this.fZA = null;
        this.fZB = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.fZC = false;
        this.fZD = false;
        this.fZE = null;
        this.fZF = 0L;
        this.fZG = false;
        this.fZH = false;
        this.fZJ = null;
        if (jSONObject != null) {
            this.mSrc = jSONObject.optString("src");
            this.fZA = jSONObject.optString("cdn_src", "");
            if (this.fZA == null || this.fZA.length() == 0) {
                this.fZA = this.mSrc;
            }
            this.fZB = jSONObject.optString("big_cdn_src", null);
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
            if (this.fZA != null && this.fZA.indexOf(".baidu.com") != -1) {
                this.fZC = true;
            }
        }
    }

    public String bLm() {
        return this.fZB;
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

    public boolean bLn() {
        return this.fZC;
    }

    public String getSrc() {
        return this.mSrc;
    }

    public void setSrc(String str) {
        this.mSrc = str;
    }

    public String bLo() {
        return this.fZJ;
    }

    public String bLp() {
        return this.fZA;
    }

    public String bLq() {
        return this.fZI;
    }

    public boolean bLr() {
        return this.fZD;
    }

    public String bLs() {
        return this.fZE;
    }

    public void ET(String str) {
        this.fZE = str;
    }

    public long getOriginalSize() {
        return this.fZF;
    }

    public boolean bLt() {
        return this.fZG;
    }

    public boolean bLu() {
        return this.fZH;
    }

    public void lM(boolean z) {
        this.fZH = z;
    }
}
