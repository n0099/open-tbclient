package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String aVi;
    private String aVj;
    private String aVk;
    private boolean aVl;
    private boolean aVm;
    private String aVn;
    private long aVo;
    private boolean aVp;
    private boolean aVq;
    private int mHeight;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.aVi = null;
        this.aVj = null;
        this.aVk = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aVl = false;
        this.aVm = false;
        this.aVn = null;
        this.aVo = 0L;
        this.aVp = false;
        this.aVq = false;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.aVi = null;
        this.aVj = null;
        this.aVk = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aVl = false;
        this.aVm = false;
        this.aVn = null;
        this.aVo = 0L;
        this.aVp = false;
        this.aVq = false;
        if (pbContent != null) {
            this.aVi = pbContent.src;
            this.aVj = pbContent.cdn_src;
            if (this.aVj == null || this.aVj.length() == 0) {
                this.aVj = this.aVi;
            }
            this.aVk = pbContent.big_cdn_src;
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
            if (this.aVj != null && this.aVj.indexOf(".baidu.com") != -1) {
                this.aVl = true;
            }
            this.aVn = pbContent.origin_src;
            this.aVo = pbContent.origin_size.intValue();
            this.aVp = pbContent.show_original_btn.intValue() == 1;
            this.aVq = pbContent.is_long_pic.intValue() == 1;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.aVi = null;
        this.aVj = null;
        this.aVk = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aVl = false;
        this.aVm = false;
        this.aVn = null;
        this.aVo = 0L;
        this.aVp = false;
        this.aVq = false;
        if (jSONObject != null) {
            this.aVi = jSONObject.optString("src");
            this.aVj = jSONObject.optString("cdn_src", "");
            if (this.aVj == null || this.aVj.length() == 0) {
                this.aVj = this.aVi;
            }
            this.aVk = jSONObject.optString("big_cdn_src", null);
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
            if (this.aVj != null && this.aVj.indexOf(".baidu.com") != -1) {
                this.aVl = true;
            }
        }
    }

    public String JI() {
        return this.aVk;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean JJ() {
        return this.aVl;
    }

    public String JK() {
        return this.aVi;
    }

    public String JL() {
        return this.aVj;
    }

    public boolean JM() {
        return this.aVm;
    }

    public String JN() {
        return this.aVn;
    }

    public long getOriginalSize() {
        return this.aVo;
    }

    public boolean JO() {
        return this.aVp;
    }

    public boolean JP() {
        return this.aVq;
    }
}
