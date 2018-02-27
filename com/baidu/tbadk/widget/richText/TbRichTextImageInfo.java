package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String bLd;
    private String bLe;
    private String bLf;
    private boolean bLg;
    private boolean bLh;
    private String bLi;
    private long bLj;
    private boolean bLk;
    private boolean bLl;
    private String bLm;
    private int mHeight;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.bLd = null;
        this.bLe = null;
        this.bLf = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.bLg = false;
        this.bLh = false;
        this.bLi = null;
        this.bLj = 0L;
        this.bLk = false;
        this.bLl = false;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.bLd = null;
        this.bLe = null;
        this.bLf = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.bLg = false;
        this.bLh = false;
        this.bLi = null;
        this.bLj = 0L;
        this.bLk = false;
        this.bLl = false;
        if (pbContent != null) {
            this.bLd = pbContent.src;
            this.bLe = pbContent.cdn_src;
            if (this.bLe == null || this.bLe.length() == 0) {
                this.bLe = this.bLd;
            }
            this.bLf = pbContent.big_cdn_src;
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
            if (this.bLe != null && this.bLe.indexOf(".baidu.com") != -1) {
                this.bLg = true;
            }
            this.bLi = pbContent.origin_src;
            this.bLj = pbContent.origin_size.intValue();
            this.bLk = pbContent.show_original_btn.intValue() == 1;
            this.bLl = pbContent.is_long_pic.intValue() == 1;
            this.bLm = pbContent.cdn_src_active;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.bLd = null;
        this.bLe = null;
        this.bLf = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.bLg = false;
        this.bLh = false;
        this.bLi = null;
        this.bLj = 0L;
        this.bLk = false;
        this.bLl = false;
        if (jSONObject != null) {
            this.bLd = jSONObject.optString("src");
            this.bLe = jSONObject.optString("cdn_src", "");
            if (this.bLe == null || this.bLe.length() == 0) {
                this.bLe = this.bLd;
            }
            this.bLf = jSONObject.optString("big_cdn_src", null);
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
            if (this.bLe != null && this.bLe.indexOf(".baidu.com") != -1) {
                this.bLg = true;
            }
        }
    }

    public String Ry() {
        return this.bLf;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean Rz() {
        return this.bLg;
    }

    public String RA() {
        return this.bLd;
    }

    public String RB() {
        return this.bLe;
    }

    public String RC() {
        return this.bLm;
    }

    public boolean RD() {
        return this.bLh;
    }

    public String RE() {
        return this.bLi;
    }

    public long getOriginalSize() {
        return this.bLj;
    }

    public boolean RF() {
        return this.bLk;
    }

    public boolean RG() {
        return this.bLl;
    }
}
