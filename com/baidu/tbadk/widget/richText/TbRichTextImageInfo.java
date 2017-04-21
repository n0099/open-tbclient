package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String aNa;
    private String aNb;
    private String aNc;
    private boolean aNd;
    private boolean aNe;
    private String aNf;
    private long aNg;
    private int mHeight;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.aNa = null;
        this.aNb = null;
        this.aNc = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aNd = false;
        this.aNe = false;
        this.aNf = null;
        this.aNg = 0L;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.aNa = null;
        this.aNb = null;
        this.aNc = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aNd = false;
        this.aNe = false;
        this.aNf = null;
        this.aNg = 0L;
        if (pbContent != null) {
            this.aNa = pbContent.src;
            this.aNb = pbContent.cdn_src;
            if (this.aNb == null || this.aNb.length() == 0) {
                this.aNb = this.aNa;
            }
            this.aNc = pbContent.big_cdn_src;
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
            if (this.aNb != null && this.aNb.indexOf(".baidu.com") != -1) {
                this.aNd = true;
            }
            this.aNf = pbContent.origin_src;
            this.aNg = pbContent.origin_size.intValue();
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.aNa = null;
        this.aNb = null;
        this.aNc = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aNd = false;
        this.aNe = false;
        this.aNf = null;
        this.aNg = 0L;
        if (jSONObject != null) {
            this.aNa = jSONObject.optString("src");
            this.aNb = jSONObject.optString("cdn_src", "");
            if (this.aNb == null || this.aNb.length() == 0) {
                this.aNb = this.aNa;
            }
            this.aNc = jSONObject.optString("big_cdn_src", null);
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
            if (this.aNb != null && this.aNb.indexOf(".baidu.com") != -1) {
                this.aNd = true;
            }
        }
    }

    public String IF() {
        return this.aNc;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean IG() {
        return this.aNd;
    }

    public String IH() {
        return this.aNa;
    }

    public String II() {
        return this.aNb;
    }

    public boolean IJ() {
        return this.aNe;
    }

    public String IK() {
        return this.aNf;
    }

    public long getOriginalSize() {
        return this.aNg;
    }
}
