package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String cLb;
    private String cLc;
    private boolean cLd;
    private boolean cLe;
    private String cLf;
    private long cLg;
    private boolean cLh;
    private boolean cLi;
    private String cLj;
    private String cLk;
    private int mHeight;
    private String mSrc;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.mSrc = null;
        this.cLb = null;
        this.cLc = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.cLd = false;
        this.cLe = false;
        this.cLf = null;
        this.cLg = 0L;
        this.cLh = false;
        this.cLi = false;
        this.cLk = null;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.mSrc = null;
        this.cLb = null;
        this.cLc = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.cLd = false;
        this.cLe = false;
        this.cLf = null;
        this.cLg = 0L;
        this.cLh = false;
        this.cLi = false;
        this.cLk = null;
        if (pbContent != null) {
            this.mSrc = pbContent.src;
            this.cLb = pbContent.cdn_src;
            if (this.cLb == null || this.cLb.length() == 0) {
                this.cLb = this.mSrc;
            }
            this.cLc = pbContent.big_cdn_src;
            this.cLk = pbContent.big_src;
            if (StringUtils.isNull(this.cLc)) {
                this.cLc = this.cLk;
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
            if (this.cLb != null && this.cLb.indexOf(".baidu.com") != -1) {
                this.cLd = true;
            }
            this.cLf = pbContent.origin_src;
            this.cLg = pbContent.origin_size.intValue();
            this.cLh = pbContent.show_original_btn.intValue() == 1;
            this.cLi = pbContent.is_long_pic.intValue() == 1;
            this.cLj = pbContent.cdn_src_active;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.mSrc = null;
        this.cLb = null;
        this.cLc = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.cLd = false;
        this.cLe = false;
        this.cLf = null;
        this.cLg = 0L;
        this.cLh = false;
        this.cLi = false;
        this.cLk = null;
        if (jSONObject != null) {
            this.mSrc = jSONObject.optString("src");
            this.cLb = jSONObject.optString("cdn_src", "");
            if (this.cLb == null || this.cLb.length() == 0) {
                this.cLb = this.mSrc;
            }
            this.cLc = jSONObject.optString("big_cdn_src", null);
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
            if (this.cLb != null && this.cLb.indexOf(".baidu.com") != -1) {
                this.cLd = true;
            }
        }
    }

    public String axR() {
        return this.cLc;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean axS() {
        return this.cLd;
    }

    public String getSrc() {
        return this.mSrc;
    }

    public String axT() {
        return this.cLk;
    }

    public String axU() {
        return this.cLb;
    }

    public String axV() {
        return this.cLj;
    }

    public boolean axW() {
        return this.cLe;
    }

    public String axX() {
        return this.cLf;
    }

    public long getOriginalSize() {
        return this.cLg;
    }

    public boolean axY() {
        return this.cLh;
    }

    public boolean axZ() {
        return this.cLi;
    }
}
