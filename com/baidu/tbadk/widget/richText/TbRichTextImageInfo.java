package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String eUE;
    private String eUF;
    private boolean eUG;
    private boolean eUH;
    private String eUI;
    private long eUJ;
    private boolean eUK;
    private boolean eUL;
    private String eUM;
    private String eUN;
    private int mHeight;
    private String mSrc;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.mSrc = null;
        this.eUE = null;
        this.eUF = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.eUG = false;
        this.eUH = false;
        this.eUI = null;
        this.eUJ = 0L;
        this.eUK = false;
        this.eUL = false;
        this.eUN = null;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.mSrc = null;
        this.eUE = null;
        this.eUF = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.eUG = false;
        this.eUH = false;
        this.eUI = null;
        this.eUJ = 0L;
        this.eUK = false;
        this.eUL = false;
        this.eUN = null;
        if (pbContent != null) {
            this.mSrc = pbContent.src;
            this.eUE = pbContent.cdn_src;
            if (this.eUE == null || this.eUE.length() == 0) {
                this.eUE = this.mSrc;
            }
            this.eUF = pbContent.big_cdn_src;
            this.eUN = pbContent.big_src;
            if (StringUtils.isNull(this.eUF)) {
                this.eUF = this.eUN;
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
            if (this.eUE != null && this.eUE.indexOf(".baidu.com") != -1) {
                this.eUG = true;
            }
            this.eUI = pbContent.origin_src;
            this.eUJ = pbContent.origin_size.intValue();
            this.eUK = pbContent.show_original_btn.intValue() == 1;
            this.eUL = pbContent.is_long_pic.intValue() == 1;
            this.eUM = pbContent.cdn_src_active;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.mSrc = null;
        this.eUE = null;
        this.eUF = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.eUG = false;
        this.eUH = false;
        this.eUI = null;
        this.eUJ = 0L;
        this.eUK = false;
        this.eUL = false;
        this.eUN = null;
        if (jSONObject != null) {
            this.mSrc = jSONObject.optString(UserAccountActionItem.KEY_SRC);
            this.eUE = jSONObject.optString("cdn_src", "");
            if (this.eUE == null || this.eUE.length() == 0) {
                this.eUE = this.mSrc;
            }
            this.eUF = jSONObject.optString("big_cdn_src", null);
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
            if (this.eUE != null && this.eUE.indexOf(".baidu.com") != -1) {
                this.eUG = true;
            }
        }
    }

    public String bpb() {
        return this.eUF;
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

    public boolean bpc() {
        return this.eUG;
    }

    public String getSrc() {
        return this.mSrc;
    }

    public void setSrc(String str) {
        this.mSrc = str;
    }

    public String bpd() {
        return this.eUN;
    }

    public String bpe() {
        return this.eUE;
    }

    public String bpf() {
        return this.eUM;
    }

    public boolean bpg() {
        return this.eUH;
    }

    public String bph() {
        return this.eUI;
    }

    public void AC(String str) {
        this.eUI = str;
    }

    public long getOriginalSize() {
        return this.eUJ;
    }

    public boolean bpi() {
        return this.eUK;
    }

    public boolean bpj() {
        return this.eUL;
    }

    public void jA(boolean z) {
        this.eUL = z;
    }
}
