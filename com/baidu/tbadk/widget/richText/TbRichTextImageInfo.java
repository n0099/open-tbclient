package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String aMI;
    private String aMJ;
    private String aMK;
    private boolean aML;
    private boolean aMM;
    private String aMN;
    private long aMO;
    private int mHeight;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.aMI = null;
        this.aMJ = null;
        this.aMK = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aML = false;
        this.aMM = false;
        this.aMN = null;
        this.aMO = 0L;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.aMI = null;
        this.aMJ = null;
        this.aMK = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aML = false;
        this.aMM = false;
        this.aMN = null;
        this.aMO = 0L;
        if (pbContent != null) {
            this.aMI = pbContent.src;
            this.aMJ = pbContent.cdn_src;
            if (this.aMJ == null || this.aMJ.length() == 0) {
                this.aMJ = this.aMI;
            }
            this.aMK = pbContent.big_cdn_src;
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
            if (this.aMJ != null && this.aMJ.indexOf(".baidu.com") != -1) {
                this.aML = true;
            }
            this.aMN = pbContent.origin_src;
            this.aMO = pbContent.origin_size.intValue();
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.aMI = null;
        this.aMJ = null;
        this.aMK = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aML = false;
        this.aMM = false;
        this.aMN = null;
        this.aMO = 0L;
        if (jSONObject != null) {
            this.aMI = jSONObject.optString("src");
            this.aMJ = jSONObject.optString("cdn_src", "");
            if (this.aMJ == null || this.aMJ.length() == 0) {
                this.aMJ = this.aMI;
            }
            this.aMK = jSONObject.optString("big_cdn_src", null);
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
            if (this.aMJ != null && this.aMJ.indexOf(".baidu.com") != -1) {
                this.aML = true;
            }
        }
    }

    public String Ig() {
        return this.aMK;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean Ih() {
        return this.aML;
    }

    public String Ii() {
        return this.aMI;
    }

    public String Ij() {
        return this.aMJ;
    }

    public boolean Ik() {
        return this.aMM;
    }

    public String Il() {
        return this.aMN;
    }

    public long getOriginalSize() {
        return this.aMO;
    }
}
