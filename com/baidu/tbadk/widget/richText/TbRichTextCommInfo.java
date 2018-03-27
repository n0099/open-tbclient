package com.baidu.tbadk.widget.richText;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.NativeApp;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextCommInfo extends OrmObject {
    public static final int NATIVE_APP_TYPE = 1;
    public static final int TYPE_LINK = 1;
    public static final int TYPE_VIDEO = 5;
    public static final int URL_VALIDITY_INVALID = 1;
    public static final int URL_VALIDITY_NORMAL = 0;
    public static final int URL_VALIDITY_VALID = 2;
    private String aUN;
    private int bKO;
    private String bKP;
    private String bKQ;
    private int bKR;
    private String mLink;
    private int mType;

    public TbRichTextCommInfo() {
        this.aUN = null;
        this.mLink = null;
        this.mType = 0;
        this.bKR = 0;
    }

    public TbRichTextCommInfo(JSONObject jSONObject) {
        this.aUN = null;
        this.mLink = null;
        this.mType = 0;
        this.bKR = 0;
        if (jSONObject != null) {
            this.aUN = jSONObject.optString("text");
            this.mLink = jSONObject.optString("link");
            this.mType = jSONObject.optInt("type", 0);
            this.bKR = jSONObject.optInt("url_type", 0);
            this.bKO = jSONObject.optInt("is_native_app", 0);
            if (this.bKO == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.bKO = 0;
                    return;
                }
                this.bKP = jSONObject.optString("jump_and");
                this.bKQ = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.bKP) || TextUtils.isEmpty(this.bKQ)) {
                    this.bKO = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.bKP += ";download_url:" + this.bKQ + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.bKP += ";download_url:" + this.bKQ + ";web_play_url:" + this.aUN;
                }
                this.bKP += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(PbContent pbContent) {
        this.aUN = null;
        this.mLink = null;
        this.mType = 0;
        this.bKR = 0;
        if (pbContent != null) {
            this.aUN = pbContent.text;
            this.mLink = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.bKR = pbContent.url_type.intValue();
            this.bKO = pbContent.is_native_app.intValue();
            if (this.bKO == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.bKO = 0;
                    return;
                }
                this.bKP = nativeApp.jump_and;
                this.bKQ = nativeApp.download_and;
                if (TextUtils.isEmpty(this.bKP) || TextUtils.isEmpty(this.bKQ)) {
                    this.bKO = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.bKP += ";download_url:" + this.bKQ + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.bKP += ";download_url:" + this.bKQ + ";web_play_url:" + this.aUN;
                }
                this.bKP += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(String str, String str2) {
        this.aUN = null;
        this.mLink = null;
        this.mType = 0;
        this.bKR = 0;
        this.aUN = str;
        this.mLink = str2;
    }

    public void setText(String str) {
        this.aUN = str;
    }

    public void setLink(String str) {
        this.mLink = str;
    }

    public String getText() {
        return this.aUN;
    }

    public String getLink() {
        return this.mLink;
    }

    public int Rj() {
        return this.bKO;
    }

    public String Rk() {
        return this.bKP;
    }

    public int Rl() {
        return this.bKR;
    }

    public void Rm() {
        if (this.aUN != null) {
            this.aUN = this.aUN.replaceAll("\n", "");
        }
        if (this.mLink != null) {
            this.mLink = this.mLink.replaceAll("\n", "");
        }
    }
}
