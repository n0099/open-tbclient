package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private boolean fuA;
    private boolean fuB;
    private String fuC;
    private long fuD;
    private boolean fuE;
    private boolean fuF;
    private String fuG;
    private String fuH;
    private String fuy;
    private String fuz;
    private int mHeight;
    private String mSrc;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.mSrc = null;
        this.fuy = null;
        this.fuz = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.fuA = false;
        this.fuB = false;
        this.fuC = null;
        this.fuD = 0L;
        this.fuE = false;
        this.fuF = false;
        this.fuH = null;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.mSrc = null;
        this.fuy = null;
        this.fuz = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.fuA = false;
        this.fuB = false;
        this.fuC = null;
        this.fuD = 0L;
        this.fuE = false;
        this.fuF = false;
        this.fuH = null;
        if (pbContent != null) {
            this.mSrc = pbContent.src;
            this.fuy = pbContent.cdn_src;
            if (this.fuy == null || this.fuy.length() == 0) {
                this.fuy = this.mSrc;
            }
            this.fuz = pbContent.big_cdn_src;
            this.fuH = pbContent.big_src;
            if (StringUtils.isNull(this.fuz)) {
                this.fuz = this.fuH;
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
            if (this.fuy != null && this.fuy.indexOf(".baidu.com") != -1) {
                this.fuA = true;
            }
            this.fuC = pbContent.origin_src;
            this.fuD = pbContent.origin_size.intValue();
            this.fuE = pbContent.show_original_btn.intValue() == 1;
            this.fuF = pbContent.is_long_pic.intValue() == 1;
            this.fuG = pbContent.cdn_src_active;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.mSrc = null;
        this.fuy = null;
        this.fuz = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.fuA = false;
        this.fuB = false;
        this.fuC = null;
        this.fuD = 0L;
        this.fuE = false;
        this.fuF = false;
        this.fuH = null;
        if (jSONObject != null) {
            this.mSrc = jSONObject.optString("src");
            this.fuy = jSONObject.optString("cdn_src", "");
            if (this.fuy == null || this.fuy.length() == 0) {
                this.fuy = this.mSrc;
            }
            this.fuz = jSONObject.optString("big_cdn_src", null);
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
            if (this.fuy != null && this.fuy.indexOf(".baidu.com") != -1) {
                this.fuA = true;
            }
        }
    }

    public String bBJ() {
        return this.fuz;
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

    public boolean bBK() {
        return this.fuA;
    }

    public String getSrc() {
        return this.mSrc;
    }

    public void setSrc(String str) {
        this.mSrc = str;
    }

    public String bBL() {
        return this.fuH;
    }

    public String bBM() {
        return this.fuy;
    }

    public String bBN() {
        return this.fuG;
    }

    public boolean bBO() {
        return this.fuB;
    }

    public String bBP() {
        return this.fuC;
    }

    public void Ea(String str) {
        this.fuC = str;
    }

    public long getOriginalSize() {
        return this.fuD;
    }

    public boolean bBQ() {
        return this.fuE;
    }

    public boolean bBR() {
        return this.fuF;
    }

    public void kz(boolean z) {
        this.fuF = z;
    }
}
