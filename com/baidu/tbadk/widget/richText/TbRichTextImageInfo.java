package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String fXi;
    private String fXj;
    private boolean fXk;
    private boolean fXl;
    private String fXm;
    private long fXn;
    private boolean fXo;
    private boolean fXp;
    private String fXq;
    private String fXr;
    private int mHeight;
    private String mSrc;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.mSrc = null;
        this.fXi = null;
        this.fXj = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.fXk = false;
        this.fXl = false;
        this.fXm = null;
        this.fXn = 0L;
        this.fXo = false;
        this.fXp = false;
        this.fXr = null;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.mSrc = null;
        this.fXi = null;
        this.fXj = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.fXk = false;
        this.fXl = false;
        this.fXm = null;
        this.fXn = 0L;
        this.fXo = false;
        this.fXp = false;
        this.fXr = null;
        if (pbContent != null) {
            this.mSrc = pbContent.src;
            this.fXi = pbContent.cdn_src;
            if (this.fXi == null || this.fXi.length() == 0) {
                this.fXi = this.mSrc;
            }
            this.fXj = pbContent.big_cdn_src;
            this.fXr = pbContent.big_src;
            if (StringUtils.isNull(this.fXj)) {
                this.fXj = this.fXr;
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
            if (this.fXi != null && this.fXi.indexOf(".baidu.com") != -1) {
                this.fXk = true;
            }
            this.fXm = pbContent.origin_src;
            this.fXn = pbContent.origin_size.intValue();
            this.fXo = pbContent.show_original_btn.intValue() == 1;
            this.fXp = pbContent.is_long_pic.intValue() == 1;
            this.fXq = pbContent.cdn_src_active;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.mSrc = null;
        this.fXi = null;
        this.fXj = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.fXk = false;
        this.fXl = false;
        this.fXm = null;
        this.fXn = 0L;
        this.fXo = false;
        this.fXp = false;
        this.fXr = null;
        if (jSONObject != null) {
            this.mSrc = jSONObject.optString(UserAccountActionItem.KEY_SRC);
            this.fXi = jSONObject.optString("cdn_src", "");
            if (this.fXi == null || this.fXi.length() == 0) {
                this.fXi = this.mSrc;
            }
            this.fXj = jSONObject.optString("big_cdn_src", null);
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
            if (this.fXi != null && this.fXi.indexOf(".baidu.com") != -1) {
                this.fXk = true;
            }
        }
    }

    public String bHP() {
        return this.fXj;
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

    public boolean bHQ() {
        return this.fXk;
    }

    public String getSrc() {
        return this.mSrc;
    }

    public void setSrc(String str) {
        this.mSrc = str;
    }

    public String bHR() {
        return this.fXr;
    }

    public String bHS() {
        return this.fXi;
    }

    public String bHT() {
        return this.fXq;
    }

    public boolean bHU() {
        return this.fXl;
    }

    public String bHV() {
        return this.fXm;
    }

    public void Eb(String str) {
        this.fXm = str;
    }

    public long getOriginalSize() {
        return this.fXn;
    }

    public boolean bHW() {
        return this.fXo;
    }

    public boolean bHX() {
        return this.fXp;
    }

    public void lM(boolean z) {
        this.fXp = z;
    }
}
