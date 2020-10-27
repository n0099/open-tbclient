package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String fCT;
    private String fCU;
    private boolean fCV;
    private boolean fCW;
    private String fCX;
    private long fCY;
    private boolean fCZ;
    private boolean fDa;
    private String fDb;
    private String fDc;
    private int mHeight;
    private String mSrc;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.mSrc = null;
        this.fCT = null;
        this.fCU = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.fCV = false;
        this.fCW = false;
        this.fCX = null;
        this.fCY = 0L;
        this.fCZ = false;
        this.fDa = false;
        this.fDc = null;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.mSrc = null;
        this.fCT = null;
        this.fCU = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.fCV = false;
        this.fCW = false;
        this.fCX = null;
        this.fCY = 0L;
        this.fCZ = false;
        this.fDa = false;
        this.fDc = null;
        if (pbContent != null) {
            this.mSrc = pbContent.src;
            this.fCT = pbContent.cdn_src;
            if (this.fCT == null || this.fCT.length() == 0) {
                this.fCT = this.mSrc;
            }
            this.fCU = pbContent.big_cdn_src;
            this.fDc = pbContent.big_src;
            if (StringUtils.isNull(this.fCU)) {
                this.fCU = this.fDc;
            }
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
            if (this.fCT != null && this.fCT.indexOf(".baidu.com") != -1) {
                this.fCV = true;
            }
            this.fCX = pbContent.origin_src;
            this.fCY = pbContent.origin_size.intValue();
            this.fCZ = pbContent.show_original_btn.intValue() == 1;
            this.fDa = pbContent.is_long_pic.intValue() == 1;
            this.fDb = pbContent.cdn_src_active;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.mSrc = null;
        this.fCT = null;
        this.fCU = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.fCV = false;
        this.fCW = false;
        this.fCX = null;
        this.fCY = 0L;
        this.fCZ = false;
        this.fDa = false;
        this.fDc = null;
        if (jSONObject != null) {
            this.mSrc = jSONObject.optString("src");
            this.fCT = jSONObject.optString("cdn_src", "");
            if (this.fCT == null || this.fCT.length() == 0) {
                this.fCT = this.mSrc;
            }
            this.fCU = jSONObject.optString("big_cdn_src", null);
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
            if (this.fCT != null && this.fCT.indexOf(".baidu.com") != -1) {
                this.fCV = true;
            }
        }
    }

    public String bDC() {
        return this.fCU;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public boolean bDD() {
        return this.fCV;
    }

    public String getSrc() {
        return this.mSrc;
    }

    public void setSrc(String str) {
        this.mSrc = str;
    }

    public String bDE() {
        return this.fDc;
    }

    public String bDF() {
        return this.fCT;
    }

    public String bDG() {
        return this.fDb;
    }

    public boolean bDH() {
        return this.fCW;
    }

    public String bDI() {
        return this.fCX;
    }

    public void Et(String str) {
        this.fCX = str;
    }

    public long getOriginalSize() {
        return this.fCY;
    }

    public boolean bDJ() {
        return this.fCZ;
    }

    public boolean bDK() {
        return this.fDa;
    }

    public void kM(boolean z) {
        this.fDa = z;
    }
}
