package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String bLg;
    private String bLh;
    private String bLi;
    private boolean bLj;
    private boolean bLk;
    private String bLl;
    private long bLm;
    private boolean bLn;
    private boolean bLo;
    private String bLp;
    private int mHeight;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.bLg = null;
        this.bLh = null;
        this.bLi = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.bLj = false;
        this.bLk = false;
        this.bLl = null;
        this.bLm = 0L;
        this.bLn = false;
        this.bLo = false;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.bLg = null;
        this.bLh = null;
        this.bLi = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.bLj = false;
        this.bLk = false;
        this.bLl = null;
        this.bLm = 0L;
        this.bLn = false;
        this.bLo = false;
        if (pbContent != null) {
            this.bLg = pbContent.src;
            this.bLh = pbContent.cdn_src;
            if (this.bLh == null || this.bLh.length() == 0) {
                this.bLh = this.bLg;
            }
            this.bLi = pbContent.big_cdn_src;
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
            if (this.bLh != null && this.bLh.indexOf(".baidu.com") != -1) {
                this.bLj = true;
            }
            this.bLl = pbContent.origin_src;
            this.bLm = pbContent.origin_size.intValue();
            this.bLn = pbContent.show_original_btn.intValue() == 1;
            this.bLo = pbContent.is_long_pic.intValue() == 1;
            this.bLp = pbContent.cdn_src_active;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.bLg = null;
        this.bLh = null;
        this.bLi = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.bLj = false;
        this.bLk = false;
        this.bLl = null;
        this.bLm = 0L;
        this.bLn = false;
        this.bLo = false;
        if (jSONObject != null) {
            this.bLg = jSONObject.optString("src");
            this.bLh = jSONObject.optString("cdn_src", "");
            if (this.bLh == null || this.bLh.length() == 0) {
                this.bLh = this.bLg;
            }
            this.bLi = jSONObject.optString("big_cdn_src", null);
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
            if (this.bLh != null && this.bLh.indexOf(".baidu.com") != -1) {
                this.bLj = true;
            }
        }
    }

    public String Rz() {
        return this.bLi;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean RA() {
        return this.bLj;
    }

    public String RB() {
        return this.bLg;
    }

    public String RC() {
        return this.bLh;
    }

    public String RD() {
        return this.bLp;
    }

    public boolean RE() {
        return this.bLk;
    }

    public String RF() {
        return this.bLl;
    }

    public long getOriginalSize() {
        return this.bLm;
    }

    public boolean RG() {
        return this.bLn;
    }

    public boolean RH() {
        return this.bLo;
    }
}
