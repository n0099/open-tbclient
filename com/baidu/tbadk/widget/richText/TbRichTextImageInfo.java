package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String bfA;
    private String bfB;
    private String bfC;
    private boolean bfD;
    private boolean bfE;
    private String bfF;
    private long bfG;
    private boolean bfH;
    private boolean bfI;
    private String bfJ;
    private String bfK;
    private int mHeight;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.bfA = null;
        this.bfB = null;
        this.bfC = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.bfD = false;
        this.bfE = false;
        this.bfF = null;
        this.bfG = 0L;
        this.bfH = false;
        this.bfI = false;
        this.bfK = null;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.bfA = null;
        this.bfB = null;
        this.bfC = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.bfD = false;
        this.bfE = false;
        this.bfF = null;
        this.bfG = 0L;
        this.bfH = false;
        this.bfI = false;
        this.bfK = null;
        if (pbContent != null) {
            this.bfA = pbContent.src;
            this.bfB = pbContent.cdn_src;
            if (this.bfB == null || this.bfB.length() == 0) {
                this.bfB = this.bfA;
            }
            this.bfC = pbContent.big_cdn_src;
            this.bfK = pbContent.big_src;
            if (StringUtils.isNull(this.bfC)) {
                this.bfC = this.bfK;
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
            if (this.bfB != null && this.bfB.indexOf(".baidu.com") != -1) {
                this.bfD = true;
            }
            this.bfF = pbContent.origin_src;
            this.bfG = pbContent.origin_size.intValue();
            this.bfH = pbContent.show_original_btn.intValue() == 1;
            this.bfI = pbContent.is_long_pic.intValue() == 1;
            this.bfJ = pbContent.cdn_src_active;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.bfA = null;
        this.bfB = null;
        this.bfC = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.bfD = false;
        this.bfE = false;
        this.bfF = null;
        this.bfG = 0L;
        this.bfH = false;
        this.bfI = false;
        this.bfK = null;
        if (jSONObject != null) {
            this.bfA = jSONObject.optString("src");
            this.bfB = jSONObject.optString("cdn_src", "");
            if (this.bfB == null || this.bfB.length() == 0) {
                this.bfB = this.bfA;
            }
            this.bfC = jSONObject.optString("big_cdn_src", null);
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
            if (this.bfB != null && this.bfB.indexOf(".baidu.com") != -1) {
                this.bfD = true;
            }
        }
    }

    public String NO() {
        return this.bfC;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean NP() {
        return this.bfD;
    }

    public String NQ() {
        return this.bfA;
    }

    public String NR() {
        return this.bfK;
    }

    public String NS() {
        return this.bfB;
    }

    public String NT() {
        return this.bfJ;
    }

    public boolean NU() {
        return this.bfE;
    }

    public String NV() {
        return this.bfF;
    }

    public long getOriginalSize() {
        return this.bfG;
    }

    public boolean NW() {
        return this.bfH;
    }

    public boolean NX() {
        return this.bfI;
    }
}
