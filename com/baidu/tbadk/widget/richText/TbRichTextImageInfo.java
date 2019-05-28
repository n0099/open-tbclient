package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String cLa;
    private String cLb;
    private boolean cLc;
    private boolean cLd;
    private String cLe;
    private long cLf;
    private boolean cLg;
    private boolean cLh;
    private String cLi;
    private String cLj;
    private int mHeight;
    private String mSrc;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.mSrc = null;
        this.cLa = null;
        this.cLb = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.cLc = false;
        this.cLd = false;
        this.cLe = null;
        this.cLf = 0L;
        this.cLg = false;
        this.cLh = false;
        this.cLj = null;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.mSrc = null;
        this.cLa = null;
        this.cLb = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.cLc = false;
        this.cLd = false;
        this.cLe = null;
        this.cLf = 0L;
        this.cLg = false;
        this.cLh = false;
        this.cLj = null;
        if (pbContent != null) {
            this.mSrc = pbContent.src;
            this.cLa = pbContent.cdn_src;
            if (this.cLa == null || this.cLa.length() == 0) {
                this.cLa = this.mSrc;
            }
            this.cLb = pbContent.big_cdn_src;
            this.cLj = pbContent.big_src;
            if (StringUtils.isNull(this.cLb)) {
                this.cLb = this.cLj;
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
            if (this.cLa != null && this.cLa.indexOf(".baidu.com") != -1) {
                this.cLc = true;
            }
            this.cLe = pbContent.origin_src;
            this.cLf = pbContent.origin_size.intValue();
            this.cLg = pbContent.show_original_btn.intValue() == 1;
            this.cLh = pbContent.is_long_pic.intValue() == 1;
            this.cLi = pbContent.cdn_src_active;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.mSrc = null;
        this.cLa = null;
        this.cLb = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.cLc = false;
        this.cLd = false;
        this.cLe = null;
        this.cLf = 0L;
        this.cLg = false;
        this.cLh = false;
        this.cLj = null;
        if (jSONObject != null) {
            this.mSrc = jSONObject.optString("src");
            this.cLa = jSONObject.optString("cdn_src", "");
            if (this.cLa == null || this.cLa.length() == 0) {
                this.cLa = this.mSrc;
            }
            this.cLb = jSONObject.optString("big_cdn_src", null);
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
            if (this.cLa != null && this.cLa.indexOf(".baidu.com") != -1) {
                this.cLc = true;
            }
        }
    }

    public String axR() {
        return this.cLb;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean axS() {
        return this.cLc;
    }

    public String getSrc() {
        return this.mSrc;
    }

    public String axT() {
        return this.cLj;
    }

    public String axU() {
        return this.cLa;
    }

    public String axV() {
        return this.cLi;
    }

    public boolean axW() {
        return this.cLd;
    }

    public String axX() {
        return this.cLe;
    }

    public long getOriginalSize() {
        return this.cLf;
    }

    public boolean axY() {
        return this.cLg;
    }

    public boolean axZ() {
        return this.cLh;
    }
}
