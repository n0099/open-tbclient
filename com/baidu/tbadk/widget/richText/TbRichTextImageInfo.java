package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.ng.ai.apps.view.coverview.model.ImageCoverViewModel;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String brn;
    private String bro;
    private boolean brp;
    private boolean brq;
    private String brr;
    private long brs;
    private boolean brt;
    private boolean bru;
    private String brv;
    private String brw;
    private int mHeight;
    private String mSrc;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.mSrc = null;
        this.brn = null;
        this.bro = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.brp = false;
        this.brq = false;
        this.brr = null;
        this.brs = 0L;
        this.brt = false;
        this.bru = false;
        this.brw = null;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.mSrc = null;
        this.brn = null;
        this.bro = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.brp = false;
        this.brq = false;
        this.brr = null;
        this.brs = 0L;
        this.brt = false;
        this.bru = false;
        this.brw = null;
        if (pbContent != null) {
            this.mSrc = pbContent.src;
            this.brn = pbContent.cdn_src;
            if (this.brn == null || this.brn.length() == 0) {
                this.brn = this.mSrc;
            }
            this.bro = pbContent.big_cdn_src;
            this.brw = pbContent.big_src;
            if (StringUtils.isNull(this.bro)) {
                this.bro = this.brw;
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
            if (this.brn != null && this.brn.indexOf(".baidu.com") != -1) {
                this.brp = true;
            }
            this.brr = pbContent.origin_src;
            this.brs = pbContent.origin_size.intValue();
            this.brt = pbContent.show_original_btn.intValue() == 1;
            this.bru = pbContent.is_long_pic.intValue() == 1;
            this.brv = pbContent.cdn_src_active;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.mSrc = null;
        this.brn = null;
        this.bro = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.brp = false;
        this.brq = false;
        this.brr = null;
        this.brs = 0L;
        this.brt = false;
        this.bru = false;
        this.brw = null;
        if (jSONObject != null) {
            this.mSrc = jSONObject.optString(ImageCoverViewModel.KEY_SRC);
            this.brn = jSONObject.optString("cdn_src", "");
            if (this.brn == null || this.brn.length() == 0) {
                this.brn = this.mSrc;
            }
            this.bro = jSONObject.optString("big_cdn_src", null);
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
            if (this.brn != null && this.brn.indexOf(".baidu.com") != -1) {
                this.brp = true;
            }
        }
    }

    public String Ss() {
        return this.bro;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean St() {
        return this.brp;
    }

    public String Su() {
        return this.mSrc;
    }

    public String Sv() {
        return this.brw;
    }

    public String Sw() {
        return this.brn;
    }

    public String Sx() {
        return this.brv;
    }

    public boolean Sy() {
        return this.brq;
    }

    public String Sz() {
        return this.brr;
    }

    public long getOriginalSize() {
        return this.brs;
    }

    public boolean SA() {
        return this.brt;
    }

    public boolean SB() {
        return this.bru;
    }
}
