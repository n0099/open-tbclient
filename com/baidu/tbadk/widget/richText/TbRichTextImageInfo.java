package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String fIJ;
    private String fIK;
    private boolean fIL;
    private boolean fIM;
    private String fIN;
    private long fIO;
    private boolean fIP;
    private boolean fIQ;
    private String fIR;
    private String fIS;
    private int mHeight;
    private String mSrc;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.mSrc = null;
        this.fIJ = null;
        this.fIK = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.fIL = false;
        this.fIM = false;
        this.fIN = null;
        this.fIO = 0L;
        this.fIP = false;
        this.fIQ = false;
        this.fIS = null;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.mSrc = null;
        this.fIJ = null;
        this.fIK = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.fIL = false;
        this.fIM = false;
        this.fIN = null;
        this.fIO = 0L;
        this.fIP = false;
        this.fIQ = false;
        this.fIS = null;
        if (pbContent != null) {
            this.mSrc = pbContent.src;
            this.fIJ = pbContent.cdn_src;
            if (this.fIJ == null || this.fIJ.length() == 0) {
                this.fIJ = this.mSrc;
            }
            this.fIK = pbContent.big_cdn_src;
            this.fIS = pbContent.big_src;
            if (StringUtils.isNull(this.fIK)) {
                this.fIK = this.fIS;
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
            if (this.fIJ != null && this.fIJ.indexOf(".baidu.com") != -1) {
                this.fIL = true;
            }
            this.fIN = pbContent.origin_src;
            this.fIO = pbContent.origin_size.intValue();
            this.fIP = pbContent.show_original_btn.intValue() == 1;
            this.fIQ = pbContent.is_long_pic.intValue() == 1;
            this.fIR = pbContent.cdn_src_active;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.mSrc = null;
        this.fIJ = null;
        this.fIK = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.fIL = false;
        this.fIM = false;
        this.fIN = null;
        this.fIO = 0L;
        this.fIP = false;
        this.fIQ = false;
        this.fIS = null;
        if (jSONObject != null) {
            this.mSrc = jSONObject.optString("src");
            this.fIJ = jSONObject.optString("cdn_src", "");
            if (this.fIJ == null || this.fIJ.length() == 0) {
                this.fIJ = this.mSrc;
            }
            this.fIK = jSONObject.optString("big_cdn_src", null);
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
            if (this.fIJ != null && this.fIJ.indexOf(".baidu.com") != -1) {
                this.fIL = true;
            }
        }
    }

    public String bGb() {
        return this.fIK;
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

    public boolean bGc() {
        return this.fIL;
    }

    public String getSrc() {
        return this.mSrc;
    }

    public void setSrc(String str) {
        this.mSrc = str;
    }

    public String bGd() {
        return this.fIS;
    }

    public String bGe() {
        return this.fIJ;
    }

    public String bGf() {
        return this.fIR;
    }

    public boolean bGg() {
        return this.fIM;
    }

    public String bGh() {
        return this.fIN;
    }

    public void EH(String str) {
        this.fIN = str;
    }

    public long getOriginalSize() {
        return this.fIO;
    }

    public boolean bGi() {
        return this.fIP;
    }

    public boolean bGj() {
        return this.fIQ;
    }

    public void kV(boolean z) {
        this.fIQ = z;
    }
}
