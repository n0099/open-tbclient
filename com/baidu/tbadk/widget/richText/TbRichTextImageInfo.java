package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String aVf;
    private String aVg;
    private String aVh;
    private boolean aVi;
    private boolean aVj;
    private String aVk;
    private long aVl;
    private boolean aVm;
    private boolean aVn;
    private int mHeight;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.aVf = null;
        this.aVg = null;
        this.aVh = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aVi = false;
        this.aVj = false;
        this.aVk = null;
        this.aVl = 0L;
        this.aVm = false;
        this.aVn = false;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.aVf = null;
        this.aVg = null;
        this.aVh = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aVi = false;
        this.aVj = false;
        this.aVk = null;
        this.aVl = 0L;
        this.aVm = false;
        this.aVn = false;
        if (pbContent != null) {
            this.aVf = pbContent.src;
            this.aVg = pbContent.cdn_src;
            if (this.aVg == null || this.aVg.length() == 0) {
                this.aVg = this.aVf;
            }
            this.aVh = pbContent.big_cdn_src;
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
            if (this.aVg != null && this.aVg.indexOf(".baidu.com") != -1) {
                this.aVi = true;
            }
            this.aVk = pbContent.origin_src;
            this.aVl = pbContent.origin_size.intValue();
            this.aVm = pbContent.show_original_btn.intValue() == 1;
            this.aVn = pbContent.is_long_pic.intValue() == 1;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.aVf = null;
        this.aVg = null;
        this.aVh = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aVi = false;
        this.aVj = false;
        this.aVk = null;
        this.aVl = 0L;
        this.aVm = false;
        this.aVn = false;
        if (jSONObject != null) {
            this.aVf = jSONObject.optString("src");
            this.aVg = jSONObject.optString("cdn_src", "");
            if (this.aVg == null || this.aVg.length() == 0) {
                this.aVg = this.aVf;
            }
            this.aVh = jSONObject.optString("big_cdn_src", null);
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
            if (this.aVg != null && this.aVg.indexOf(".baidu.com") != -1) {
                this.aVi = true;
            }
        }
    }

    public String JI() {
        return this.aVh;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean JJ() {
        return this.aVi;
    }

    public String JK() {
        return this.aVf;
    }

    public String JL() {
        return this.aVg;
    }

    public boolean JM() {
        return this.aVj;
    }

    public String JN() {
        return this.aVk;
    }

    public long getOriginalSize() {
        return this.aVl;
    }

    public boolean JO() {
        return this.aVm;
    }

    public boolean JP() {
        return this.aVn;
    }
}
