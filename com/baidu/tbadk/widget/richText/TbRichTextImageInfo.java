package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextImageInfo extends OrmObject {
    private String fii;
    private String fij;
    private boolean fik;
    private boolean fil;
    private String fim;
    private long fin;
    private boolean fio;
    private boolean fiq;
    private String fir;
    private String fis;
    private int mHeight;
    private String mSrc;
    private int mWidth;

    public TbRichTextImageInfo() {
        this.mSrc = null;
        this.fii = null;
        this.fij = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.fik = false;
        this.fil = false;
        this.fim = null;
        this.fin = 0L;
        this.fio = false;
        this.fiq = false;
        this.fis = null;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.mSrc = null;
        this.fii = null;
        this.fij = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.fik = false;
        this.fil = false;
        this.fim = null;
        this.fin = 0L;
        this.fio = false;
        this.fiq = false;
        this.fis = null;
        if (pbContent != null) {
            this.mSrc = pbContent.src;
            this.fii = pbContent.cdn_src;
            if (this.fii == null || this.fii.length() == 0) {
                this.fii = this.mSrc;
            }
            this.fij = pbContent.big_cdn_src;
            this.fis = pbContent.big_src;
            if (StringUtils.isNull(this.fij)) {
                this.fij = this.fis;
            }
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
            if (this.fii != null && this.fii.indexOf(".baidu.com") != -1) {
                this.fik = true;
            }
            this.fim = pbContent.origin_src;
            this.fin = pbContent.origin_size.intValue();
            this.fio = pbContent.show_original_btn.intValue() == 1;
            this.fiq = pbContent.is_long_pic.intValue() == 1;
            this.fir = pbContent.cdn_src_active;
        }
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.mSrc = null;
        this.fii = null;
        this.fij = null;
        this.mWidth = 1;
        this.mHeight = 1;
        this.fik = false;
        this.fil = false;
        this.fim = null;
        this.fin = 0L;
        this.fio = false;
        this.fiq = false;
        this.fis = null;
        if (jSONObject != null) {
            this.mSrc = jSONObject.optString("src");
            this.fii = jSONObject.optString("cdn_src", "");
            if (this.fii == null || this.fii.length() == 0) {
                this.fii = this.mSrc;
            }
            this.fij = jSONObject.optString("big_cdn_src", null);
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
            if (this.fii != null && this.fii.indexOf(".baidu.com") != -1) {
                this.fik = true;
            }
        }
    }

    public String byZ() {
        return this.fij;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public boolean bza() {
        return this.fik;
    }

    public String getSrc() {
        return this.mSrc;
    }

    public void setSrc(String str) {
        this.mSrc = str;
    }

    public String bzb() {
        return this.fis;
    }

    public String bzc() {
        return this.fii;
    }

    public String bzd() {
        return this.fir;
    }

    public boolean bze() {
        return this.fil;
    }

    public String bzf() {
        return this.fim;
    }

    public void Do(String str) {
        this.fim = str;
    }

    public long getOriginalSize() {
        return this.fin;
    }

    public boolean bzg() {
        return this.fio;
    }

    public boolean bzh() {
        return this.fiq;
    }

    public void kb(boolean z) {
        this.fiq = z;
    }
}
