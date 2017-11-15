package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String aSc;
    private String aSd;
    private String aSe;
    private boolean aSf;
    private boolean aSg;
    private String aSh;
    private long aSi;
    private boolean aSj;
    private boolean aSk;
    private int mHeight;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.aSc = null;
        this.aSd = null;
        this.aSe = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aSf = false;
        this.aSg = false;
        this.aSh = null;
        this.aSi = 0L;
        this.aSj = false;
        this.aSk = false;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.aSc = null;
        this.aSd = null;
        this.aSe = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aSf = false;
        this.aSg = false;
        this.aSh = null;
        this.aSi = 0L;
        this.aSj = false;
        this.aSk = false;
        if (pbContent != null) {
            this.aSc = pbContent.src;
            this.aSd = pbContent.cdn_src;
            if (this.aSd == null || this.aSd.length() == 0) {
                this.aSd = this.aSc;
            }
            this.aSe = pbContent.big_cdn_src;
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
            if (this.aSd != null && this.aSd.indexOf(".baidu.com") != -1) {
                this.aSf = true;
            }
            this.aSh = pbContent.origin_src;
            this.aSi = pbContent.origin_size.intValue();
            this.aSj = pbContent.show_original_btn.intValue() == 1;
            this.aSk = pbContent.is_long_pic.intValue() == 1;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.aSc = null;
        this.aSd = null;
        this.aSe = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aSf = false;
        this.aSg = false;
        this.aSh = null;
        this.aSi = 0L;
        this.aSj = false;
        this.aSk = false;
        if (jSONObject != null) {
            this.aSc = jSONObject.optString("src");
            this.aSd = jSONObject.optString("cdn_src", "");
            if (this.aSd == null || this.aSd.length() == 0) {
                this.aSd = this.aSc;
            }
            this.aSe = jSONObject.optString("big_cdn_src", null);
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
            if (this.aSd != null && this.aSd.indexOf(".baidu.com") != -1) {
                this.aSf = true;
            }
        }
    }

    public String Jk() {
        return this.aSe;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean Jl() {
        return this.aSf;
    }

    public String Jm() {
        return this.aSc;
    }

    public String Jn() {
        return this.aSd;
    }

    public boolean Jo() {
        return this.aSg;
    }

    public String Jp() {
        return this.aSh;
    }

    public long getOriginalSize() {
        return this.aSi;
    }

    public boolean Jq() {
        return this.aSj;
    }

    public boolean Jr() {
        return this.aSk;
    }
}
