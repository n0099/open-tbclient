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
    private String eOj;
    private String eOk;
    private boolean eOl;
    private boolean eOm;
    private String eOn;
    private long eOo;
    private boolean eOp;
    private boolean eOq;
    private String eOr;
    private String eOs;
    private int mHeight;
    private String mSrc;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.mSrc = null;
        this.eOj = null;
        this.eOk = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.eOl = false;
        this.eOm = false;
        this.eOn = null;
        this.eOo = 0L;
        this.eOp = false;
        this.eOq = false;
        this.eOs = null;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.mSrc = null;
        this.eOj = null;
        this.eOk = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.eOl = false;
        this.eOm = false;
        this.eOn = null;
        this.eOo = 0L;
        this.eOp = false;
        this.eOq = false;
        this.eOs = null;
        if (pbContent != null) {
            this.mSrc = pbContent.src;
            this.eOj = pbContent.cdn_src;
            if (this.eOj == null || this.eOj.length() == 0) {
                this.eOj = this.mSrc;
            }
            this.eOk = pbContent.big_cdn_src;
            this.eOs = pbContent.big_src;
            if (StringUtils.isNull(this.eOk)) {
                this.eOk = this.eOs;
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
            if (this.eOj != null && this.eOj.indexOf(".baidu.com") != -1) {
                this.eOl = true;
            }
            this.eOn = pbContent.origin_src;
            this.eOo = pbContent.origin_size.intValue();
            this.eOp = pbContent.show_original_btn.intValue() == 1;
            this.eOq = pbContent.is_long_pic.intValue() == 1;
            this.eOr = pbContent.cdn_src_active;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.mSrc = null;
        this.eOj = null;
        this.eOk = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.eOl = false;
        this.eOm = false;
        this.eOn = null;
        this.eOo = 0L;
        this.eOp = false;
        this.eOq = false;
        this.eOs = null;
        if (jSONObject != null) {
            this.mSrc = jSONObject.optString(UserAccountActionItem.KEY_SRC);
            this.eOj = jSONObject.optString("cdn_src", "");
            if (this.eOj == null || this.eOj.length() == 0) {
                this.eOj = this.mSrc;
            }
            this.eOk = jSONObject.optString("big_cdn_src", null);
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
            if (this.eOj != null && this.eOj.indexOf(".baidu.com") != -1) {
                this.eOl = true;
            }
        }
    }

    public String blh() {
        return this.eOk;
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

    public boolean bli() {
        return this.eOl;
    }

    public String getSrc() {
        return this.mSrc;
    }

    public void setSrc(String str) {
        this.mSrc = str;
    }

    public String blj() {
        return this.eOs;
    }

    public String blk() {
        return this.eOj;
    }

    public String bll() {
        return this.eOr;
    }

    public boolean blm() {
        return this.eOm;
    }

    public String bln() {
        return this.eOn;
    }

    public void zu(String str) {
        this.eOn = str;
    }

    public long getOriginalSize() {
        return this.eOo;
    }

    public boolean blo() {
        return this.eOp;
    }

    public boolean blp() {
        return this.eOq;
    }

    public void iV(boolean z) {
        this.eOq = z;
    }
}
