package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.ng.ai.apps.view.coverview.model.ImageCoverViewModel;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String bsb;
    private String bsc;
    private boolean bsd;
    private boolean bse;
    private String bsf;
    private long bsg;
    private boolean bsh;
    private boolean bsi;
    private String bsj;
    private String bsk;
    private int mHeight;
    private String mSrc;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.mSrc = null;
        this.bsb = null;
        this.bsc = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.bsd = false;
        this.bse = false;
        this.bsf = null;
        this.bsg = 0L;
        this.bsh = false;
        this.bsi = false;
        this.bsk = null;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.mSrc = null;
        this.bsb = null;
        this.bsc = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.bsd = false;
        this.bse = false;
        this.bsf = null;
        this.bsg = 0L;
        this.bsh = false;
        this.bsi = false;
        this.bsk = null;
        if (pbContent != null) {
            this.mSrc = pbContent.src;
            this.bsb = pbContent.cdn_src;
            if (this.bsb == null || this.bsb.length() == 0) {
                this.bsb = this.mSrc;
            }
            this.bsc = pbContent.big_cdn_src;
            this.bsk = pbContent.big_src;
            if (StringUtils.isNull(this.bsc)) {
                this.bsc = this.bsk;
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
            if (this.bsb != null && this.bsb.indexOf(".baidu.com") != -1) {
                this.bsd = true;
            }
            this.bsf = pbContent.origin_src;
            this.bsg = pbContent.origin_size.intValue();
            this.bsh = pbContent.show_original_btn.intValue() == 1;
            this.bsi = pbContent.is_long_pic.intValue() == 1;
            this.bsj = pbContent.cdn_src_active;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.mSrc = null;
        this.bsb = null;
        this.bsc = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.bsd = false;
        this.bse = false;
        this.bsf = null;
        this.bsg = 0L;
        this.bsh = false;
        this.bsi = false;
        this.bsk = null;
        if (jSONObject != null) {
            this.mSrc = jSONObject.optString(ImageCoverViewModel.KEY_SRC);
            this.bsb = jSONObject.optString("cdn_src", "");
            if (this.bsb == null || this.bsb.length() == 0) {
                this.bsb = this.mSrc;
            }
            this.bsc = jSONObject.optString("big_cdn_src", null);
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
            if (this.bsb != null && this.bsb.indexOf(".baidu.com") != -1) {
                this.bsd = true;
            }
        }
    }

    public String SO() {
        return this.bsc;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean SP() {
        return this.bsd;
    }

    public String SQ() {
        return this.mSrc;
    }

    public String SR() {
        return this.bsk;
    }

    public String SS() {
        return this.bsb;
    }

    public String ST() {
        return this.bsj;
    }

    public boolean SU() {
        return this.bse;
    }

    public String SV() {
        return this.bsf;
    }

    public long getOriginalSize() {
        return this.bsg;
    }

    public boolean SW() {
        return this.bsh;
    }

    public boolean SX() {
        return this.bsi;
    }
}
