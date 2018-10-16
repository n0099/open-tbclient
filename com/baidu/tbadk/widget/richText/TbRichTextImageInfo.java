package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.ng.ai.apps.view.coverview.model.ImageCoverViewModel;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String bnb;
    private String bnc;
    private boolean bnd;
    private boolean bne;
    private String bnf;
    private long bng;
    private boolean bnh;
    private boolean bni;
    private String bnj;
    private String bnk;
    private int mHeight;
    private String mSrc;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.mSrc = null;
        this.bnb = null;
        this.bnc = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.bnd = false;
        this.bne = false;
        this.bnf = null;
        this.bng = 0L;
        this.bnh = false;
        this.bni = false;
        this.bnk = null;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.mSrc = null;
        this.bnb = null;
        this.bnc = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.bnd = false;
        this.bne = false;
        this.bnf = null;
        this.bng = 0L;
        this.bnh = false;
        this.bni = false;
        this.bnk = null;
        if (pbContent != null) {
            this.mSrc = pbContent.src;
            this.bnb = pbContent.cdn_src;
            if (this.bnb == null || this.bnb.length() == 0) {
                this.bnb = this.mSrc;
            }
            this.bnc = pbContent.big_cdn_src;
            this.bnk = pbContent.big_src;
            if (StringUtils.isNull(this.bnc)) {
                this.bnc = this.bnk;
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
            if (this.bnb != null && this.bnb.indexOf(".baidu.com") != -1) {
                this.bnd = true;
            }
            this.bnf = pbContent.origin_src;
            this.bng = pbContent.origin_size.intValue();
            this.bnh = pbContent.show_original_btn.intValue() == 1;
            this.bni = pbContent.is_long_pic.intValue() == 1;
            this.bnj = pbContent.cdn_src_active;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.mSrc = null;
        this.bnb = null;
        this.bnc = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.bnd = false;
        this.bne = false;
        this.bnf = null;
        this.bng = 0L;
        this.bnh = false;
        this.bni = false;
        this.bnk = null;
        if (jSONObject != null) {
            this.mSrc = jSONObject.optString(ImageCoverViewModel.KEY_SRC);
            this.bnb = jSONObject.optString("cdn_src", "");
            if (this.bnb == null || this.bnb.length() == 0) {
                this.bnb = this.mSrc;
            }
            this.bnc = jSONObject.optString("big_cdn_src", null);
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
            if (this.bnb != null && this.bnb.indexOf(".baidu.com") != -1) {
                this.bnd = true;
            }
        }
    }

    public String Rb() {
        return this.bnc;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean Rc() {
        return this.bnd;
    }

    public String Rd() {
        return this.mSrc;
    }

    public String Re() {
        return this.bnk;
    }

    public String Rf() {
        return this.bnb;
    }

    public String Rg() {
        return this.bnj;
    }

    public boolean Rh() {
        return this.bne;
    }

    public String Ri() {
        return this.bnf;
    }

    public long getOriginalSize() {
        return this.bng;
    }

    public boolean Rj() {
        return this.bnh;
    }

    public boolean Rk() {
        return this.bni;
    }
}
