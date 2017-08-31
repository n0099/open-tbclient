package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String aQL;
    private String aQM;
    private String aQN;
    private boolean aQO;
    private boolean aQP;
    private String aQQ;
    private long aQR;
    private int mHeight;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.aQL = null;
        this.aQM = null;
        this.aQN = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aQO = false;
        this.aQP = false;
        this.aQQ = null;
        this.aQR = 0L;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.aQL = null;
        this.aQM = null;
        this.aQN = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aQO = false;
        this.aQP = false;
        this.aQQ = null;
        this.aQR = 0L;
        if (pbContent != null) {
            this.aQL = pbContent.src;
            this.aQM = pbContent.cdn_src;
            if (this.aQM == null || this.aQM.length() == 0) {
                this.aQM = this.aQL;
            }
            this.aQN = pbContent.big_cdn_src;
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
            if (this.aQM != null && this.aQM.indexOf(".baidu.com") != -1) {
                this.aQO = true;
            }
            this.aQQ = pbContent.origin_src;
            this.aQR = pbContent.origin_size.intValue();
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.aQL = null;
        this.aQM = null;
        this.aQN = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aQO = false;
        this.aQP = false;
        this.aQQ = null;
        this.aQR = 0L;
        if (jSONObject != null) {
            this.aQL = jSONObject.optString("src");
            this.aQM = jSONObject.optString("cdn_src", "");
            if (this.aQM == null || this.aQM.length() == 0) {
                this.aQM = this.aQL;
            }
            this.aQN = jSONObject.optString("big_cdn_src", null);
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
            if (this.aQM != null && this.aQM.indexOf(".baidu.com") != -1) {
                this.aQO = true;
            }
        }
    }

    public String IN() {
        return this.aQN;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean IO() {
        return this.aQO;
    }

    public String IP() {
        return this.aQL;
    }

    public String IQ() {
        return this.aQM;
    }

    public boolean IR() {
        return this.aQP;
    }

    public String IS() {
        return this.aQQ;
    }

    public long getOriginalSize() {
        return this.aQR;
    }
}
