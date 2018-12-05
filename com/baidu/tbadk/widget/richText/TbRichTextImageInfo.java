package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.ng.ai.apps.view.coverview.model.ImageCoverViewModel;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String brk;
    private String brl;
    private boolean brm;
    private boolean brn;
    private String bro;
    private long brp;
    private boolean brq;
    private boolean brr;
    private String brs;
    private String brt;
    private int mHeight;
    private String mSrc;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.mSrc = null;
        this.brk = null;
        this.brl = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.brm = false;
        this.brn = false;
        this.bro = null;
        this.brp = 0L;
        this.brq = false;
        this.brr = false;
        this.brt = null;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.mSrc = null;
        this.brk = null;
        this.brl = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.brm = false;
        this.brn = false;
        this.bro = null;
        this.brp = 0L;
        this.brq = false;
        this.brr = false;
        this.brt = null;
        if (pbContent != null) {
            this.mSrc = pbContent.src;
            this.brk = pbContent.cdn_src;
            if (this.brk == null || this.brk.length() == 0) {
                this.brk = this.mSrc;
            }
            this.brl = pbContent.big_cdn_src;
            this.brt = pbContent.big_src;
            if (StringUtils.isNull(this.brl)) {
                this.brl = this.brt;
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
            if (this.brk != null && this.brk.indexOf(".baidu.com") != -1) {
                this.brm = true;
            }
            this.bro = pbContent.origin_src;
            this.brp = pbContent.origin_size.intValue();
            this.brq = pbContent.show_original_btn.intValue() == 1;
            this.brr = pbContent.is_long_pic.intValue() == 1;
            this.brs = pbContent.cdn_src_active;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.mSrc = null;
        this.brk = null;
        this.brl = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.brm = false;
        this.brn = false;
        this.bro = null;
        this.brp = 0L;
        this.brq = false;
        this.brr = false;
        this.brt = null;
        if (jSONObject != null) {
            this.mSrc = jSONObject.optString(ImageCoverViewModel.KEY_SRC);
            this.brk = jSONObject.optString("cdn_src", "");
            if (this.brk == null || this.brk.length() == 0) {
                this.brk = this.mSrc;
            }
            this.brl = jSONObject.optString("big_cdn_src", null);
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
            if (this.brk != null && this.brk.indexOf(".baidu.com") != -1) {
                this.brm = true;
            }
        }
    }

    public String Sq() {
        return this.brl;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean Sr() {
        return this.brm;
    }

    public String Ss() {
        return this.mSrc;
    }

    public String St() {
        return this.brt;
    }

    public String Su() {
        return this.brk;
    }

    public String Sv() {
        return this.brs;
    }

    public boolean Sw() {
        return this.brn;
    }

    public String Sx() {
        return this.bro;
    }

    public long getOriginalSize() {
        return this.brp;
    }

    public boolean Sy() {
        return this.brq;
    }

    public boolean Sz() {
        return this.brr;
    }
}
