package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.ng.ai.apps.view.coverview.model.ImageCoverViewModel;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String bsc;
    private String bsd;
    private boolean bse;
    private boolean bsf;
    private String bsg;
    private long bsh;
    private boolean bsi;
    private boolean bsj;
    private String bsk;
    private String bsl;
    private int mHeight;
    private String mSrc;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.mSrc = null;
        this.bsc = null;
        this.bsd = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.bse = false;
        this.bsf = false;
        this.bsg = null;
        this.bsh = 0L;
        this.bsi = false;
        this.bsj = false;
        this.bsl = null;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.mSrc = null;
        this.bsc = null;
        this.bsd = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.bse = false;
        this.bsf = false;
        this.bsg = null;
        this.bsh = 0L;
        this.bsi = false;
        this.bsj = false;
        this.bsl = null;
        if (pbContent != null) {
            this.mSrc = pbContent.src;
            this.bsc = pbContent.cdn_src;
            if (this.bsc == null || this.bsc.length() == 0) {
                this.bsc = this.mSrc;
            }
            this.bsd = pbContent.big_cdn_src;
            this.bsl = pbContent.big_src;
            if (StringUtils.isNull(this.bsd)) {
                this.bsd = this.bsl;
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
            if (this.bsc != null && this.bsc.indexOf(".baidu.com") != -1) {
                this.bse = true;
            }
            this.bsg = pbContent.origin_src;
            this.bsh = pbContent.origin_size.intValue();
            this.bsi = pbContent.show_original_btn.intValue() == 1;
            this.bsj = pbContent.is_long_pic.intValue() == 1;
            this.bsk = pbContent.cdn_src_active;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.mSrc = null;
        this.bsc = null;
        this.bsd = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.bse = false;
        this.bsf = false;
        this.bsg = null;
        this.bsh = 0L;
        this.bsi = false;
        this.bsj = false;
        this.bsl = null;
        if (jSONObject != null) {
            this.mSrc = jSONObject.optString(ImageCoverViewModel.KEY_SRC);
            this.bsc = jSONObject.optString("cdn_src", "");
            if (this.bsc == null || this.bsc.length() == 0) {
                this.bsc = this.mSrc;
            }
            this.bsd = jSONObject.optString("big_cdn_src", null);
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
            if (this.bsc != null && this.bsc.indexOf(".baidu.com") != -1) {
                this.bse = true;
            }
        }
    }

    public String SO() {
        return this.bsd;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean SP() {
        return this.bse;
    }

    public String SQ() {
        return this.mSrc;
    }

    public String SR() {
        return this.bsl;
    }

    public String SS() {
        return this.bsc;
    }

    public String ST() {
        return this.bsk;
    }

    public boolean SU() {
        return this.bsf;
    }

    public String SV() {
        return this.bsg;
    }

    public long getOriginalSize() {
        return this.bsh;
    }

    public boolean SW() {
        return this.bsi;
    }

    public boolean SX() {
        return this.bsj;
    }
}
