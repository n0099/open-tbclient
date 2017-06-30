package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String aOE;
    private String aOF;
    private String aOG;
    private boolean aOH;
    private boolean aOI;
    private String aOJ;
    private long aOK;
    private int mHeight;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.aOE = null;
        this.aOF = null;
        this.aOG = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aOH = false;
        this.aOI = false;
        this.aOJ = null;
        this.aOK = 0L;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.aOE = null;
        this.aOF = null;
        this.aOG = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aOH = false;
        this.aOI = false;
        this.aOJ = null;
        this.aOK = 0L;
        if (pbContent != null) {
            this.aOE = pbContent.src;
            this.aOF = pbContent.cdn_src;
            if (this.aOF == null || this.aOF.length() == 0) {
                this.aOF = this.aOE;
            }
            this.aOG = pbContent.big_cdn_src;
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
            if (this.aOF != null && this.aOF.indexOf(".baidu.com") != -1) {
                this.aOH = true;
            }
            this.aOJ = pbContent.origin_src;
            this.aOK = pbContent.origin_size.intValue();
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.aOE = null;
        this.aOF = null;
        this.aOG = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aOH = false;
        this.aOI = false;
        this.aOJ = null;
        this.aOK = 0L;
        if (jSONObject != null) {
            this.aOE = jSONObject.optString("src");
            this.aOF = jSONObject.optString("cdn_src", "");
            if (this.aOF == null || this.aOF.length() == 0) {
                this.aOF = this.aOE;
            }
            this.aOG = jSONObject.optString("big_cdn_src", null);
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
            if (this.aOF != null && this.aOF.indexOf(".baidu.com") != -1) {
                this.aOH = true;
            }
        }
    }

    public String Im() {
        return this.aOG;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean In() {
        return this.aOH;
    }

    public String Io() {
        return this.aOE;
    }

    public String Ip() {
        return this.aOF;
    }

    public boolean Iq() {
        return this.aOI;
    }

    public String Ir() {
        return this.aOJ;
    }

    public long getOriginalSize() {
        return this.aOK;
    }
}
