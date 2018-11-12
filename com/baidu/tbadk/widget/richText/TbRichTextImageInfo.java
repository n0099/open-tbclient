package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.ng.ai.apps.view.coverview.model.ImageCoverViewModel;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String bnN;
    private String bnO;
    private boolean bnP;
    private boolean bnQ;
    private String bnR;
    private long bnS;
    private boolean bnT;
    private boolean bnU;
    private String bnV;
    private String bnW;
    private int mHeight;
    private String mSrc;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.mSrc = null;
        this.bnN = null;
        this.bnO = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.bnP = false;
        this.bnQ = false;
        this.bnR = null;
        this.bnS = 0L;
        this.bnT = false;
        this.bnU = false;
        this.bnW = null;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.mSrc = null;
        this.bnN = null;
        this.bnO = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.bnP = false;
        this.bnQ = false;
        this.bnR = null;
        this.bnS = 0L;
        this.bnT = false;
        this.bnU = false;
        this.bnW = null;
        if (pbContent != null) {
            this.mSrc = pbContent.src;
            this.bnN = pbContent.cdn_src;
            if (this.bnN == null || this.bnN.length() == 0) {
                this.bnN = this.mSrc;
            }
            this.bnO = pbContent.big_cdn_src;
            this.bnW = pbContent.big_src;
            if (StringUtils.isNull(this.bnO)) {
                this.bnO = this.bnW;
            }
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
            if (this.bnN != null && this.bnN.indexOf(".baidu.com") != -1) {
                this.bnP = true;
            }
            this.bnR = pbContent.origin_src;
            this.bnS = pbContent.origin_size.intValue();
            this.bnT = pbContent.show_original_btn.intValue() == 1;
            this.bnU = pbContent.is_long_pic.intValue() == 1;
            this.bnV = pbContent.cdn_src_active;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.mSrc = null;
        this.bnN = null;
        this.bnO = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.bnP = false;
        this.bnQ = false;
        this.bnR = null;
        this.bnS = 0L;
        this.bnT = false;
        this.bnU = false;
        this.bnW = null;
        if (jSONObject != null) {
            this.mSrc = jSONObject.optString(ImageCoverViewModel.KEY_SRC);
            this.bnN = jSONObject.optString("cdn_src", "");
            if (this.bnN == null || this.bnN.length() == 0) {
                this.bnN = this.mSrc;
            }
            this.bnO = jSONObject.optString("big_cdn_src", null);
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
            if (this.bnN != null && this.bnN.indexOf(".baidu.com") != -1) {
                this.bnP = true;
            }
        }
    }

    public String Rk() {
        return this.bnO;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean Rl() {
        return this.bnP;
    }

    public String Rm() {
        return this.mSrc;
    }

    public String Rn() {
        return this.bnW;
    }

    public String Ro() {
        return this.bnN;
    }

    public String Rp() {
        return this.bnV;
    }

    public boolean Rq() {
        return this.bnQ;
    }

    public String Rr() {
        return this.bnR;
    }

    public long getOriginalSize() {
        return this.bnS;
    }

    public boolean Rs() {
        return this.bnT;
    }

    public boolean Rt() {
        return this.bnU;
    }
}
