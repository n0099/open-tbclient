package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String cWK;
    private String cWL;
    private boolean cWM;
    private boolean cWN;
    private String cWO;
    private long cWP;
    private boolean cWQ;
    private boolean cWR;
    private String cWS;
    private String cWT;
    private int mHeight;
    private String mSrc;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.mSrc = null;
        this.cWK = null;
        this.cWL = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.cWM = false;
        this.cWN = false;
        this.cWO = null;
        this.cWP = 0L;
        this.cWQ = false;
        this.cWR = false;
        this.cWT = null;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.mSrc = null;
        this.cWK = null;
        this.cWL = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.cWM = false;
        this.cWN = false;
        this.cWO = null;
        this.cWP = 0L;
        this.cWQ = false;
        this.cWR = false;
        this.cWT = null;
        if (pbContent != null) {
            this.mSrc = pbContent.src;
            this.cWK = pbContent.cdn_src;
            if (this.cWK == null || this.cWK.length() == 0) {
                this.cWK = this.mSrc;
            }
            this.cWL = pbContent.big_cdn_src;
            this.cWT = pbContent.big_src;
            if (StringUtils.isNull(this.cWL)) {
                this.cWL = this.cWT;
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
            if (this.cWK != null && this.cWK.indexOf(".baidu.com") != -1) {
                this.cWM = true;
            }
            this.cWO = pbContent.origin_src;
            this.cWP = pbContent.origin_size.intValue();
            this.cWQ = pbContent.show_original_btn.intValue() == 1;
            this.cWR = pbContent.is_long_pic.intValue() == 1;
            this.cWS = pbContent.cdn_src_active;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.mSrc = null;
        this.cWK = null;
        this.cWL = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.cWM = false;
        this.cWN = false;
        this.cWO = null;
        this.cWP = 0L;
        this.cWQ = false;
        this.cWR = false;
        this.cWT = null;
        if (jSONObject != null) {
            this.mSrc = jSONObject.optString("src");
            this.cWK = jSONObject.optString("cdn_src", "");
            if (this.cWK == null || this.cWK.length() == 0) {
                this.cWK = this.mSrc;
            }
            this.cWL = jSONObject.optString("big_cdn_src", null);
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
            if (this.cWK != null && this.cWK.indexOf(".baidu.com") != -1) {
                this.cWM = true;
            }
        }
    }

    public String azA() {
        return this.cWL;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean azB() {
        return this.cWM;
    }

    public String getSrc() {
        return this.mSrc;
    }

    public String azC() {
        return this.cWT;
    }

    public String azD() {
        return this.cWK;
    }

    public String azE() {
        return this.cWS;
    }

    public boolean azF() {
        return this.cWN;
    }

    public String azG() {
        return this.cWO;
    }

    public long getOriginalSize() {
        return this.cWP;
    }

    public boolean azH() {
        return this.cWQ;
    }

    public boolean azI() {
        return this.cWR;
    }
}
