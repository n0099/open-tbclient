package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String aQI;
    private String aQJ;
    private String aQK;
    private boolean aQL;
    private boolean aQM;
    private String aQN;
    private long aQO;
    private int mHeight;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.aQI = null;
        this.aQJ = null;
        this.aQK = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aQL = false;
        this.aQM = false;
        this.aQN = null;
        this.aQO = 0L;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.aQI = null;
        this.aQJ = null;
        this.aQK = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aQL = false;
        this.aQM = false;
        this.aQN = null;
        this.aQO = 0L;
        if (pbContent != null) {
            this.aQI = pbContent.src;
            this.aQJ = pbContent.cdn_src;
            if (this.aQJ == null || this.aQJ.length() == 0) {
                this.aQJ = this.aQI;
            }
            this.aQK = pbContent.big_cdn_src;
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
            if (this.aQJ != null && this.aQJ.indexOf(".baidu.com") != -1) {
                this.aQL = true;
            }
            this.aQN = pbContent.origin_src;
            this.aQO = pbContent.origin_size.intValue();
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.aQI = null;
        this.aQJ = null;
        this.aQK = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.aQL = false;
        this.aQM = false;
        this.aQN = null;
        this.aQO = 0L;
        if (jSONObject != null) {
            this.aQI = jSONObject.optString("src");
            this.aQJ = jSONObject.optString("cdn_src", "");
            if (this.aQJ == null || this.aQJ.length() == 0) {
                this.aQJ = this.aQI;
            }
            this.aQK = jSONObject.optString("big_cdn_src", null);
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
            if (this.aQJ != null && this.aQJ.indexOf(".baidu.com") != -1) {
                this.aQL = true;
            }
        }
    }

    public String IN() {
        return this.aQK;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean IO() {
        return this.aQL;
    }

    public String IP() {
        return this.aQI;
    }

    public String IQ() {
        return this.aQJ;
    }

    public boolean IR() {
        return this.aQM;
    }

    public String IS() {
        return this.aQN;
    }

    public long getOriginalSize() {
        return this.aQO;
    }
}
