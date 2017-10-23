package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private long aRA;
    private boolean aRB;
    private boolean aRC;
    private String aRu;
    private String aRv;
    private String aRw;
    private boolean aRx;
    private boolean aRy;
    private String aRz;
    private int mHeight;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.aRu = null;
        this.aRv = null;
        this.aRw = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aRx = false;
        this.aRy = false;
        this.aRz = null;
        this.aRA = 0L;
        this.aRB = false;
        this.aRC = false;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.aRu = null;
        this.aRv = null;
        this.aRw = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aRx = false;
        this.aRy = false;
        this.aRz = null;
        this.aRA = 0L;
        this.aRB = false;
        this.aRC = false;
        if (pbContent != null) {
            this.aRu = pbContent.src;
            this.aRv = pbContent.cdn_src;
            if (this.aRv == null || this.aRv.length() == 0) {
                this.aRv = this.aRu;
            }
            this.aRw = pbContent.big_cdn_src;
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
            if (this.aRv != null && this.aRv.indexOf(".baidu.com") != -1) {
                this.aRx = true;
            }
            this.aRz = pbContent.origin_src;
            this.aRA = pbContent.origin_size.intValue();
            this.aRB = pbContent.show_original_btn.intValue() == 1;
            this.aRC = pbContent.is_long_pic.intValue() == 1;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.aRu = null;
        this.aRv = null;
        this.aRw = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aRx = false;
        this.aRy = false;
        this.aRz = null;
        this.aRA = 0L;
        this.aRB = false;
        this.aRC = false;
        if (jSONObject != null) {
            this.aRu = jSONObject.optString("src");
            this.aRv = jSONObject.optString("cdn_src", "");
            if (this.aRv == null || this.aRv.length() == 0) {
                this.aRv = this.aRu;
            }
            this.aRw = jSONObject.optString("big_cdn_src", null);
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
            if (this.aRv != null && this.aRv.indexOf(".baidu.com") != -1) {
                this.aRx = true;
            }
        }
    }

    public String IO() {
        return this.aRw;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean IP() {
        return this.aRx;
    }

    public String IQ() {
        return this.aRu;
    }

    public String IR() {
        return this.aRv;
    }

    public boolean IS() {
        return this.aRy;
    }

    public String IT() {
        return this.aRz;
    }

    public long getOriginalSize() {
        return this.aRA;
    }

    public boolean IU() {
        return this.aRB;
    }

    public boolean IV() {
        return this.aRC;
    }
}
