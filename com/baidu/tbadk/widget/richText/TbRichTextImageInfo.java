package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String aPN;
    private String aPO;
    private String aPP;
    private boolean aPQ;
    private boolean aPR;
    private String aPS;
    private long aPT;
    private int mHeight;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.aPN = null;
        this.aPO = null;
        this.aPP = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aPQ = false;
        this.aPR = false;
        this.aPS = null;
        this.aPT = 0L;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.aPN = null;
        this.aPO = null;
        this.aPP = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aPQ = false;
        this.aPR = false;
        this.aPS = null;
        this.aPT = 0L;
        if (pbContent != null) {
            this.aPN = pbContent.src;
            this.aPO = pbContent.cdn_src;
            if (this.aPO == null || this.aPO.length() == 0) {
                this.aPO = this.aPN;
            }
            this.aPP = pbContent.big_cdn_src;
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
            if (this.aPO != null && this.aPO.indexOf(".baidu.com") != -1) {
                this.aPQ = true;
            }
            this.aPS = pbContent.origin_src;
            this.aPT = pbContent.origin_size.intValue();
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.aPN = null;
        this.aPO = null;
        this.aPP = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aPQ = false;
        this.aPR = false;
        this.aPS = null;
        this.aPT = 0L;
        if (jSONObject != null) {
            this.aPN = jSONObject.optString("src");
            this.aPO = jSONObject.optString("cdn_src", "");
            if (this.aPO == null || this.aPO.length() == 0) {
                this.aPO = this.aPN;
            }
            this.aPP = jSONObject.optString("big_cdn_src", null);
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
            if (this.aPO != null && this.aPO.indexOf(".baidu.com") != -1) {
                this.aPQ = true;
            }
        }
    }

    public String Iy() {
        return this.aPP;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean Iz() {
        return this.aPQ;
    }

    public String IA() {
        return this.aPN;
    }

    public String IB() {
        return this.aPO;
    }

    public boolean IC() {
        return this.aPR;
    }

    public String ID() {
        return this.aPS;
    }

    public long getOriginalSize() {
        return this.aPT;
    }
}
