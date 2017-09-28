package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String aRH;
    private String aRI;
    private String aRJ;
    private boolean aRK;
    private boolean aRL;
    private String aRM;
    private long aRN;
    private boolean aRO;
    private boolean aRP;
    private int mHeight;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.aRH = null;
        this.aRI = null;
        this.aRJ = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aRK = false;
        this.aRL = false;
        this.aRM = null;
        this.aRN = 0L;
        this.aRO = false;
        this.aRP = false;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.aRH = null;
        this.aRI = null;
        this.aRJ = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aRK = false;
        this.aRL = false;
        this.aRM = null;
        this.aRN = 0L;
        this.aRO = false;
        this.aRP = false;
        if (pbContent != null) {
            this.aRH = pbContent.src;
            this.aRI = pbContent.cdn_src;
            if (this.aRI == null || this.aRI.length() == 0) {
                this.aRI = this.aRH;
            }
            this.aRJ = pbContent.big_cdn_src;
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
            if (this.aRI != null && this.aRI.indexOf(".baidu.com") != -1) {
                this.aRK = true;
            }
            this.aRM = pbContent.origin_src;
            this.aRN = pbContent.origin_size.intValue();
            this.aRO = pbContent.show_original_btn.intValue() == 1;
            this.aRP = pbContent.is_long_pic.intValue() == 1;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.aRH = null;
        this.aRI = null;
        this.aRJ = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aRK = false;
        this.aRL = false;
        this.aRM = null;
        this.aRN = 0L;
        this.aRO = false;
        this.aRP = false;
        if (jSONObject != null) {
            this.aRH = jSONObject.optString("src");
            this.aRI = jSONObject.optString("cdn_src", "");
            if (this.aRI == null || this.aRI.length() == 0) {
                this.aRI = this.aRH;
            }
            this.aRJ = jSONObject.optString("big_cdn_src", null);
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
            if (this.aRI != null && this.aRI.indexOf(".baidu.com") != -1) {
                this.aRK = true;
            }
        }
    }

    public String IU() {
        return this.aRJ;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean IV() {
        return this.aRK;
    }

    public String IW() {
        return this.aRH;
    }

    public String IX() {
        return this.aRI;
    }

    public boolean IY() {
        return this.aRL;
    }

    public String IZ() {
        return this.aRM;
    }

    public long getOriginalSize() {
        return this.aRN;
    }

    public boolean Ja() {
        return this.aRO;
    }

    public boolean Jb() {
        return this.aRP;
    }
}
