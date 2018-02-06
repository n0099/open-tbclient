package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String bLq;
    private String bLr;
    private String bLs;
    private boolean bLt;
    private boolean bLu;
    private String bLv;
    private long bLw;
    private boolean bLx;
    private boolean bLy;
    private String bLz;
    private int mHeight;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.bLq = null;
        this.bLr = null;
        this.bLs = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.bLt = false;
        this.bLu = false;
        this.bLv = null;
        this.bLw = 0L;
        this.bLx = false;
        this.bLy = false;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.bLq = null;
        this.bLr = null;
        this.bLs = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.bLt = false;
        this.bLu = false;
        this.bLv = null;
        this.bLw = 0L;
        this.bLx = false;
        this.bLy = false;
        if (pbContent != null) {
            this.bLq = pbContent.src;
            this.bLr = pbContent.cdn_src;
            if (this.bLr == null || this.bLr.length() == 0) {
                this.bLr = this.bLq;
            }
            this.bLs = pbContent.big_cdn_src;
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
            if (this.bLr != null && this.bLr.indexOf(".baidu.com") != -1) {
                this.bLt = true;
            }
            this.bLv = pbContent.origin_src;
            this.bLw = pbContent.origin_size.intValue();
            this.bLx = pbContent.show_original_btn.intValue() == 1;
            this.bLy = pbContent.is_long_pic.intValue() == 1;
            this.bLz = pbContent.cdn_src_active;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.bLq = null;
        this.bLr = null;
        this.bLs = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.bLt = false;
        this.bLu = false;
        this.bLv = null;
        this.bLw = 0L;
        this.bLx = false;
        this.bLy = false;
        if (jSONObject != null) {
            this.bLq = jSONObject.optString("src");
            this.bLr = jSONObject.optString("cdn_src", "");
            if (this.bLr == null || this.bLr.length() == 0) {
                this.bLr = this.bLq;
            }
            this.bLs = jSONObject.optString("big_cdn_src", null);
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
            if (this.bLr != null && this.bLr.indexOf(".baidu.com") != -1) {
                this.bLt = true;
            }
        }
    }

    public String Rz() {
        return this.bLs;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean RA() {
        return this.bLt;
    }

    public String RB() {
        return this.bLq;
    }

    public String RC() {
        return this.bLr;
    }

    public String RD() {
        return this.bLz;
    }

    public boolean RE() {
        return this.bLu;
    }

    public String RF() {
        return this.bLv;
    }

    public long getOriginalSize() {
        return this.bLw;
    }

    public boolean RG() {
        return this.bLx;
    }

    public boolean RH() {
        return this.bLy;
    }
}
