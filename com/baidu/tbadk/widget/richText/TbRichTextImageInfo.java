package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String aRU;
    private String aRV;
    private String aRW;
    private boolean aRX;
    private boolean aRY;
    private String aRZ;
    private long aSa;
    private boolean aSb;
    private boolean aSc;
    private int mHeight;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.aRU = null;
        this.aRV = null;
        this.aRW = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aRX = false;
        this.aRY = false;
        this.aRZ = null;
        this.aSa = 0L;
        this.aSb = false;
        this.aSc = false;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.aRU = null;
        this.aRV = null;
        this.aRW = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aRX = false;
        this.aRY = false;
        this.aRZ = null;
        this.aSa = 0L;
        this.aSb = false;
        this.aSc = false;
        if (pbContent != null) {
            this.aRU = pbContent.src;
            this.aRV = pbContent.cdn_src;
            if (this.aRV == null || this.aRV.length() == 0) {
                this.aRV = this.aRU;
            }
            this.aRW = pbContent.big_cdn_src;
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
            if (this.aRV != null && this.aRV.indexOf(".baidu.com") != -1) {
                this.aRX = true;
            }
            this.aRZ = pbContent.origin_src;
            this.aSa = pbContent.origin_size.intValue();
            this.aSb = pbContent.show_original_btn.intValue() == 1;
            this.aSc = pbContent.is_long_pic.intValue() == 1;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.aRU = null;
        this.aRV = null;
        this.aRW = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aRX = false;
        this.aRY = false;
        this.aRZ = null;
        this.aSa = 0L;
        this.aSb = false;
        this.aSc = false;
        if (jSONObject != null) {
            this.aRU = jSONObject.optString("src");
            this.aRV = jSONObject.optString("cdn_src", "");
            if (this.aRV == null || this.aRV.length() == 0) {
                this.aRV = this.aRU;
            }
            this.aRW = jSONObject.optString("big_cdn_src", null);
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
            if (this.aRV != null && this.aRV.indexOf(".baidu.com") != -1) {
                this.aRX = true;
            }
        }
    }

    public String IZ() {
        return this.aRW;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean Ja() {
        return this.aRX;
    }

    public String Jb() {
        return this.aRU;
    }

    public String Jc() {
        return this.aRV;
    }

    public boolean Jd() {
        return this.aRY;
    }

    public String Je() {
        return this.aRZ;
    }

    public long getOriginalSize() {
        return this.aSa;
    }

    public boolean Jf() {
        return this.aSb;
    }

    public boolean Jg() {
        return this.aSc;
    }
}
