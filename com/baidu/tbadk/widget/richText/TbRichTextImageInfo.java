package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String bea;
    private String beb;
    private boolean bec;
    private boolean bed;
    private String bee;
    private long bef;
    private boolean beh;
    private boolean bei;
    private String bej;
    private int mHeight;
    private String mSrc;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.mSrc = null;
        this.bea = null;
        this.beb = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.bec = false;
        this.bed = false;
        this.bee = null;
        this.bef = 0L;
        this.beh = false;
        this.bei = false;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.mSrc = null;
        this.bea = null;
        this.beb = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.bec = false;
        this.bed = false;
        this.bee = null;
        this.bef = 0L;
        this.beh = false;
        this.bei = false;
        if (pbContent != null) {
            this.mSrc = pbContent.src;
            this.bea = pbContent.cdn_src;
            if (this.bea == null || this.bea.length() == 0) {
                this.bea = this.mSrc;
            }
            this.beb = pbContent.big_cdn_src;
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
            if (this.bea != null && this.bea.indexOf(".baidu.com") != -1) {
                this.bec = true;
            }
            this.bee = pbContent.origin_src;
            this.bef = pbContent.origin_size.intValue();
            this.beh = pbContent.show_original_btn.intValue() == 1;
            this.bei = pbContent.is_long_pic.intValue() == 1;
            this.bej = pbContent.cdn_src_active;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.mSrc = null;
        this.bea = null;
        this.beb = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.bec = false;
        this.bed = false;
        this.bee = null;
        this.bef = 0L;
        this.beh = false;
        this.bei = false;
        if (jSONObject != null) {
            this.mSrc = jSONObject.optString("src");
            this.bea = jSONObject.optString("cdn_src", "");
            if (this.bea == null || this.bea.length() == 0) {
                this.bea = this.mSrc;
            }
            this.beb = jSONObject.optString("big_cdn_src", null);
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
            if (this.bea != null && this.bea.indexOf(".baidu.com") != -1) {
                this.bec = true;
            }
        }
    }

    public String Nx() {
        return this.beb;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean Ny() {
        return this.bec;
    }

    public String getSrc() {
        return this.mSrc;
    }

    public String Nz() {
        return this.bea;
    }

    public String NA() {
        return this.bej;
    }

    public boolean NB() {
        return this.bed;
    }

    public String NC() {
        return this.bee;
    }

    public long getOriginalSize() {
        return this.bef;
    }

    public boolean ND() {
        return this.beh;
    }

    public boolean NE() {
        return this.bei;
    }
}
