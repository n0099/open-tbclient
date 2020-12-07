package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String fPY;
    private String fPZ;
    private boolean fQa;
    private boolean fQb;
    private String fQc;
    private long fQd;
    private boolean fQe;
    private boolean fQf;
    private String fQg;
    private String fQh;
    private int mHeight;
    private String mSrc;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.mSrc = null;
        this.fPY = null;
        this.fPZ = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.fQa = false;
        this.fQb = false;
        this.fQc = null;
        this.fQd = 0L;
        this.fQe = false;
        this.fQf = false;
        this.fQh = null;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.mSrc = null;
        this.fPY = null;
        this.fPZ = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.fQa = false;
        this.fQb = false;
        this.fQc = null;
        this.fQd = 0L;
        this.fQe = false;
        this.fQf = false;
        this.fQh = null;
        if (pbContent != null) {
            this.mSrc = pbContent.src;
            this.fPY = pbContent.cdn_src;
            if (this.fPY == null || this.fPY.length() == 0) {
                this.fPY = this.mSrc;
            }
            this.fPZ = pbContent.big_cdn_src;
            this.fQh = pbContent.big_src;
            if (StringUtils.isNull(this.fPZ)) {
                this.fPZ = this.fQh;
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
            if (this.fPY != null && this.fPY.indexOf(".baidu.com") != -1) {
                this.fQa = true;
            }
            this.fQc = pbContent.origin_src;
            this.fQd = pbContent.origin_size.intValue();
            this.fQe = pbContent.show_original_btn.intValue() == 1;
            this.fQf = pbContent.is_long_pic.intValue() == 1;
            this.fQg = pbContent.cdn_src_active;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.mSrc = null;
        this.fPY = null;
        this.fPZ = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.fQa = false;
        this.fQb = false;
        this.fQc = null;
        this.fQd = 0L;
        this.fQe = false;
        this.fQf = false;
        this.fQh = null;
        if (jSONObject != null) {
            this.mSrc = jSONObject.optString("src");
            this.fPY = jSONObject.optString("cdn_src", "");
            if (this.fPY == null || this.fPY.length() == 0) {
                this.fPY = this.mSrc;
            }
            this.fPZ = jSONObject.optString("big_cdn_src", null);
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
            if (this.fPY != null && this.fPY.indexOf(".baidu.com") != -1) {
                this.fQa = true;
            }
        }
    }

    public String bIU() {
        return this.fPZ;
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

    public boolean bIV() {
        return this.fQa;
    }

    public String getSrc() {
        return this.mSrc;
    }

    public void setSrc(String str) {
        this.mSrc = str;
    }

    public String bIW() {
        return this.fQh;
    }

    public String bIX() {
        return this.fPY;
    }

    public String bIY() {
        return this.fQg;
    }

    public boolean bIZ() {
        return this.fQb;
    }

    public String bJa() {
        return this.fQc;
    }

    public void EW(String str) {
        this.fQc = str;
    }

    public long getOriginalSize() {
        return this.fQd;
    }

    public boolean bJb() {
        return this.fQe;
    }

    public boolean bJc() {
        return this.fQf;
    }

    public void lq(boolean z) {
        this.fQf = z;
    }
}
