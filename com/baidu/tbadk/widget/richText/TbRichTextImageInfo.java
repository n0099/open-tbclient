package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String bJd;
    private String bJe;
    private String bJf;
    private boolean bJg;
    private boolean bJh;
    private String bJi;
    private long bJj;
    private boolean bJk;
    private boolean bJl;
    private String bJm;
    private int mHeight;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.bJd = null;
        this.bJe = null;
        this.bJf = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.bJg = false;
        this.bJh = false;
        this.bJi = null;
        this.bJj = 0L;
        this.bJk = false;
        this.bJl = false;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.bJd = null;
        this.bJe = null;
        this.bJf = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.bJg = false;
        this.bJh = false;
        this.bJi = null;
        this.bJj = 0L;
        this.bJk = false;
        this.bJl = false;
        if (pbContent != null) {
            this.bJd = pbContent.src;
            this.bJe = pbContent.cdn_src;
            if (this.bJe == null || this.bJe.length() == 0) {
                this.bJe = this.bJd;
            }
            this.bJf = pbContent.big_cdn_src;
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
            if (this.bJe != null && this.bJe.indexOf(".baidu.com") != -1) {
                this.bJg = true;
            }
            this.bJi = pbContent.origin_src;
            this.bJj = pbContent.origin_size.intValue();
            this.bJk = pbContent.show_original_btn.intValue() == 1;
            this.bJl = pbContent.is_long_pic.intValue() == 1;
            this.bJm = pbContent.cdn_src_active;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.bJd = null;
        this.bJe = null;
        this.bJf = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.bJg = false;
        this.bJh = false;
        this.bJi = null;
        this.bJj = 0L;
        this.bJk = false;
        this.bJl = false;
        if (jSONObject != null) {
            this.bJd = jSONObject.optString("src");
            this.bJe = jSONObject.optString("cdn_src", "");
            if (this.bJe == null || this.bJe.length() == 0) {
                this.bJe = this.bJd;
            }
            this.bJf = jSONObject.optString("big_cdn_src", null);
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
            if (this.bJe != null && this.bJe.indexOf(".baidu.com") != -1) {
                this.bJg = true;
            }
        }
    }

    public String QS() {
        return this.bJf;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean QT() {
        return this.bJg;
    }

    public String QU() {
        return this.bJd;
    }

    public String QV() {
        return this.bJe;
    }

    public String QW() {
        return this.bJm;
    }

    public boolean QX() {
        return this.bJh;
    }

    public String QY() {
        return this.bJi;
    }

    public long getOriginalSize() {
        return this.bJj;
    }

    public boolean QZ() {
        return this.bJk;
    }

    public boolean Ra() {
        return this.bJl;
    }
}
