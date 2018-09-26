package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String biW;
    private String biX;
    private String biY;
    private boolean biZ;
    private boolean bja;
    private String bjb;
    private long bjc;
    private boolean bjd;
    private boolean bje;
    private String bjf;
    private String bjg;
    private int mHeight;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.biW = null;
        this.biX = null;
        this.biY = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.biZ = false;
        this.bja = false;
        this.bjb = null;
        this.bjc = 0L;
        this.bjd = false;
        this.bje = false;
        this.bjg = null;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.biW = null;
        this.biX = null;
        this.biY = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.biZ = false;
        this.bja = false;
        this.bjb = null;
        this.bjc = 0L;
        this.bjd = false;
        this.bje = false;
        this.bjg = null;
        if (pbContent != null) {
            this.biW = pbContent.src;
            this.biX = pbContent.cdn_src;
            if (this.biX == null || this.biX.length() == 0) {
                this.biX = this.biW;
            }
            this.biY = pbContent.big_cdn_src;
            this.bjg = pbContent.big_src;
            if (StringUtils.isNull(this.biY)) {
                this.biY = this.bjg;
            }
            String str = pbContent.bsize;
            if (str != null) {
                try {
                    String[] split = str.split(",");
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
            if (this.biX != null && this.biX.indexOf(".baidu.com") != -1) {
                this.biZ = true;
            }
            this.bjb = pbContent.origin_src;
            this.bjc = pbContent.origin_size.intValue();
            this.bjd = pbContent.show_original_btn.intValue() == 1;
            this.bje = pbContent.is_long_pic.intValue() == 1;
            this.bjf = pbContent.cdn_src_active;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.biW = null;
        this.biX = null;
        this.biY = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.biZ = false;
        this.bja = false;
        this.bjb = null;
        this.bjc = 0L;
        this.bjd = false;
        this.bje = false;
        this.bjg = null;
        if (jSONObject != null) {
            this.biW = jSONObject.optString("src");
            this.biX = jSONObject.optString("cdn_src", "");
            if (this.biX == null || this.biX.length() == 0) {
                this.biX = this.biW;
            }
            this.biY = jSONObject.optString("big_cdn_src", null);
            try {
                String[] split = jSONObject.optString("bsize").split(",");
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
            if (this.biX != null && this.biX.indexOf(".baidu.com") != -1) {
                this.biZ = true;
            }
        }
    }

    public String Pg() {
        return this.biY;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean Ph() {
        return this.biZ;
    }

    public String Pi() {
        return this.biW;
    }

    public String Pj() {
        return this.bjg;
    }

    public String Pk() {
        return this.biX;
    }

    public String Pl() {
        return this.bjf;
    }

    public boolean Pm() {
        return this.bja;
    }

    public String Pn() {
        return this.bjb;
    }

    public long getOriginalSize() {
        return this.bjc;
    }

    public boolean Po() {
        return this.bjd;
    }

    public boolean Pp() {
        return this.bje;
    }
}
