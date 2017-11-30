package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String aVd;
    private String aVe;
    private String aVf;
    private boolean aVg;
    private boolean aVh;
    private String aVi;
    private long aVj;
    private boolean aVk;
    private boolean aVl;
    private int mHeight;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.aVd = null;
        this.aVe = null;
        this.aVf = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aVg = false;
        this.aVh = false;
        this.aVi = null;
        this.aVj = 0L;
        this.aVk = false;
        this.aVl = false;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.aVd = null;
        this.aVe = null;
        this.aVf = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aVg = false;
        this.aVh = false;
        this.aVi = null;
        this.aVj = 0L;
        this.aVk = false;
        this.aVl = false;
        if (pbContent != null) {
            this.aVd = pbContent.src;
            this.aVe = pbContent.cdn_src;
            if (this.aVe == null || this.aVe.length() == 0) {
                this.aVe = this.aVd;
            }
            this.aVf = pbContent.big_cdn_src;
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
            if (this.aVe != null && this.aVe.indexOf(".baidu.com") != -1) {
                this.aVg = true;
            }
            this.aVi = pbContent.origin_src;
            this.aVj = pbContent.origin_size.intValue();
            this.aVk = pbContent.show_original_btn.intValue() == 1;
            this.aVl = pbContent.is_long_pic.intValue() == 1;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.aVd = null;
        this.aVe = null;
        this.aVf = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aVg = false;
        this.aVh = false;
        this.aVi = null;
        this.aVj = 0L;
        this.aVk = false;
        this.aVl = false;
        if (jSONObject != null) {
            this.aVd = jSONObject.optString("src");
            this.aVe = jSONObject.optString("cdn_src", "");
            if (this.aVe == null || this.aVe.length() == 0) {
                this.aVe = this.aVd;
            }
            this.aVf = jSONObject.optString("big_cdn_src", null);
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
            if (this.aVe != null && this.aVe.indexOf(".baidu.com") != -1) {
                this.aVg = true;
            }
        }
    }

    public String JH() {
        return this.aVf;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean JI() {
        return this.aVg;
    }

    public String JJ() {
        return this.aVd;
    }

    public String JK() {
        return this.aVe;
    }

    public boolean JL() {
        return this.aVh;
    }

    public String JM() {
        return this.aVi;
    }

    public long getOriginalSize() {
        return this.aVj;
    }

    public boolean JN() {
        return this.aVk;
    }

    public boolean JO() {
        return this.aVl;
    }
}
