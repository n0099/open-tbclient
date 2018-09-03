package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String bfB;
    private String bfC;
    private String bfD;
    private boolean bfE;
    private boolean bfF;
    private String bfG;
    private long bfH;
    private boolean bfI;
    private boolean bfJ;
    private String bfK;
    private String bfL;
    private int mHeight;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.bfB = null;
        this.bfC = null;
        this.bfD = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.bfE = false;
        this.bfF = false;
        this.bfG = null;
        this.bfH = 0L;
        this.bfI = false;
        this.bfJ = false;
        this.bfL = null;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.bfB = null;
        this.bfC = null;
        this.bfD = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.bfE = false;
        this.bfF = false;
        this.bfG = null;
        this.bfH = 0L;
        this.bfI = false;
        this.bfJ = false;
        this.bfL = null;
        if (pbContent != null) {
            this.bfB = pbContent.src;
            this.bfC = pbContent.cdn_src;
            if (this.bfC == null || this.bfC.length() == 0) {
                this.bfC = this.bfB;
            }
            this.bfD = pbContent.big_cdn_src;
            this.bfL = pbContent.big_src;
            if (StringUtils.isNull(this.bfD)) {
                this.bfD = this.bfL;
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
            if (this.bfC != null && this.bfC.indexOf(".baidu.com") != -1) {
                this.bfE = true;
            }
            this.bfG = pbContent.origin_src;
            this.bfH = pbContent.origin_size.intValue();
            this.bfI = pbContent.show_original_btn.intValue() == 1;
            this.bfJ = pbContent.is_long_pic.intValue() == 1;
            this.bfK = pbContent.cdn_src_active;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.bfB = null;
        this.bfC = null;
        this.bfD = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.bfE = false;
        this.bfF = false;
        this.bfG = null;
        this.bfH = 0L;
        this.bfI = false;
        this.bfJ = false;
        this.bfL = null;
        if (jSONObject != null) {
            this.bfB = jSONObject.optString("src");
            this.bfC = jSONObject.optString("cdn_src", "");
            if (this.bfC == null || this.bfC.length() == 0) {
                this.bfC = this.bfB;
            }
            this.bfD = jSONObject.optString("big_cdn_src", null);
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
            if (this.bfC != null && this.bfC.indexOf(".baidu.com") != -1) {
                this.bfE = true;
            }
        }
    }

    public String NN() {
        return this.bfD;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean NO() {
        return this.bfE;
    }

    public String NP() {
        return this.bfB;
    }

    public String NQ() {
        return this.bfL;
    }

    public String NR() {
        return this.bfC;
    }

    public String NS() {
        return this.bfK;
    }

    public boolean NT() {
        return this.bfF;
    }

    public String NU() {
        return this.bfG;
    }

    public long getOriginalSize() {
        return this.bfH;
    }

    public boolean NV() {
        return this.bfI;
    }

    public boolean NW() {
        return this.bfJ;
    }
}
