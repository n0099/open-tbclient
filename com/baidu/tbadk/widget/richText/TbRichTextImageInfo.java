package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String aMY;
    private String aMZ;
    private String aNa;
    private boolean aNb;
    private boolean aNc;
    private String aNd;
    private long aNe;
    private int mHeight;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.aMY = null;
        this.aMZ = null;
        this.aNa = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aNb = false;
        this.aNc = false;
        this.aNd = null;
        this.aNe = 0L;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.aMY = null;
        this.aMZ = null;
        this.aNa = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aNb = false;
        this.aNc = false;
        this.aNd = null;
        this.aNe = 0L;
        if (pbContent != null) {
            this.aMY = pbContent.src;
            this.aMZ = pbContent.cdn_src;
            if (this.aMZ == null || this.aMZ.length() == 0) {
                this.aMZ = this.aMY;
            }
            this.aNa = pbContent.big_cdn_src;
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
            if (this.aMZ != null && this.aMZ.indexOf(".baidu.com") != -1) {
                this.aNb = true;
            }
            this.aNd = pbContent.origin_src;
            this.aNe = pbContent.origin_size.intValue();
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.aMY = null;
        this.aMZ = null;
        this.aNa = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aNb = false;
        this.aNc = false;
        this.aNd = null;
        this.aNe = 0L;
        if (jSONObject != null) {
            this.aMY = jSONObject.optString("src");
            this.aMZ = jSONObject.optString("cdn_src", "");
            if (this.aMZ == null || this.aMZ.length() == 0) {
                this.aMZ = this.aMY;
            }
            this.aNa = jSONObject.optString("big_cdn_src", null);
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
            if (this.aMZ != null && this.aMZ.indexOf(".baidu.com") != -1) {
                this.aNb = true;
            }
        }
    }

    public String IF() {
        return this.aNa;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean IG() {
        return this.aNb;
    }

    public String IH() {
        return this.aMY;
    }

    public String II() {
        return this.aMZ;
    }

    public boolean IJ() {
        return this.aNc;
    }

    public String IK() {
        return this.aNd;
    }

    public long getOriginalSize() {
        return this.aNe;
    }
}
