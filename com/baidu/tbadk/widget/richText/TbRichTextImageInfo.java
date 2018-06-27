package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String bfq;
    private String bfr;
    private boolean bfs;
    private boolean bft;
    private String bfu;
    private long bfv;
    private boolean bfw;
    private boolean bfx;
    private String bfy;
    private int mHeight;
    private String mSrc;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.mSrc = null;
        this.bfq = null;
        this.bfr = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.bfs = false;
        this.bft = false;
        this.bfu = null;
        this.bfv = 0L;
        this.bfw = false;
        this.bfx = false;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.mSrc = null;
        this.bfq = null;
        this.bfr = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.bfs = false;
        this.bft = false;
        this.bfu = null;
        this.bfv = 0L;
        this.bfw = false;
        this.bfx = false;
        if (pbContent != null) {
            this.mSrc = pbContent.src;
            this.bfq = pbContent.cdn_src;
            if (this.bfq == null || this.bfq.length() == 0) {
                this.bfq = this.mSrc;
            }
            this.bfr = pbContent.big_cdn_src;
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
            if (this.bfq != null && this.bfq.indexOf(".baidu.com") != -1) {
                this.bfs = true;
            }
            this.bfu = pbContent.origin_src;
            this.bfv = pbContent.origin_size.intValue();
            this.bfw = pbContent.show_original_btn.intValue() == 1;
            this.bfx = pbContent.is_long_pic.intValue() == 1;
            this.bfy = pbContent.cdn_src_active;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.mSrc = null;
        this.bfq = null;
        this.bfr = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.bfs = false;
        this.bft = false;
        this.bfu = null;
        this.bfv = 0L;
        this.bfw = false;
        this.bfx = false;
        if (jSONObject != null) {
            this.mSrc = jSONObject.optString("src");
            this.bfq = jSONObject.optString("cdn_src", "");
            if (this.bfq == null || this.bfq.length() == 0) {
                this.bfq = this.mSrc;
            }
            this.bfr = jSONObject.optString("big_cdn_src", null);
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
            if (this.bfq != null && this.bfq.indexOf(".baidu.com") != -1) {
                this.bfs = true;
            }
        }
    }

    public String NQ() {
        return this.bfr;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean NR() {
        return this.bfs;
    }

    public String getSrc() {
        return this.mSrc;
    }

    public String NS() {
        return this.bfq;
    }

    public String NT() {
        return this.bfy;
    }

    public boolean NU() {
        return this.bft;
    }

    public String NV() {
        return this.bfu;
    }

    public long getOriginalSize() {
        return this.bfv;
    }

    public boolean NW() {
        return this.bfw;
    }

    public boolean NX() {
        return this.bfx;
    }
}
