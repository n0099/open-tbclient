package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String bJl;
    private String bJm;
    private String bJn;
    private boolean bJo;
    private boolean bJp;
    private String bJq;
    private long bJr;
    private boolean bJs;
    private boolean bJt;
    private String bJu;
    private int mHeight;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.bJl = null;
        this.bJm = null;
        this.bJn = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.bJo = false;
        this.bJp = false;
        this.bJq = null;
        this.bJr = 0L;
        this.bJs = false;
        this.bJt = false;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.bJl = null;
        this.bJm = null;
        this.bJn = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.bJo = false;
        this.bJp = false;
        this.bJq = null;
        this.bJr = 0L;
        this.bJs = false;
        this.bJt = false;
        if (pbContent != null) {
            this.bJl = pbContent.src;
            this.bJm = pbContent.cdn_src;
            if (this.bJm == null || this.bJm.length() == 0) {
                this.bJm = this.bJl;
            }
            this.bJn = pbContent.big_cdn_src;
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
            if (this.bJm != null && this.bJm.indexOf(".baidu.com") != -1) {
                this.bJo = true;
            }
            this.bJq = pbContent.origin_src;
            this.bJr = pbContent.origin_size.intValue();
            this.bJs = pbContent.show_original_btn.intValue() == 1;
            this.bJt = pbContent.is_long_pic.intValue() == 1;
            this.bJu = pbContent.cdn_src_active;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.bJl = null;
        this.bJm = null;
        this.bJn = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.bJo = false;
        this.bJp = false;
        this.bJq = null;
        this.bJr = 0L;
        this.bJs = false;
        this.bJt = false;
        if (jSONObject != null) {
            this.bJl = jSONObject.optString("src");
            this.bJm = jSONObject.optString("cdn_src", "");
            if (this.bJm == null || this.bJm.length() == 0) {
                this.bJm = this.bJl;
            }
            this.bJn = jSONObject.optString("big_cdn_src", null);
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
            if (this.bJm != null && this.bJm.indexOf(".baidu.com") != -1) {
                this.bJo = true;
            }
        }
    }

    public String QU() {
        return this.bJn;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean QV() {
        return this.bJo;
    }

    public String QW() {
        return this.bJl;
    }

    public String QX() {
        return this.bJm;
    }

    public String QY() {
        return this.bJu;
    }

    public boolean QZ() {
        return this.bJp;
    }

    public String Ra() {
        return this.bJq;
    }

    public long getOriginalSize() {
        return this.bJr;
    }

    public boolean Rb() {
        return this.bJs;
    }

    public boolean Rc() {
        return this.bJt;
    }
}
