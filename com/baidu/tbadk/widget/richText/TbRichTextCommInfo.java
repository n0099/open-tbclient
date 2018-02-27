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
    private String aUL;
    private int bKL;
    private String bKM;
    private String bKN;
    private int bKO;
    private String mLink;
    private int mType;

    public TbRichTextCommInfo() {
        this.aUL = null;
        this.mLink = null;
        this.mType = 0;
        this.bKO = 0;
    }

    public TbRichTextCommInfo(JSONObject jSONObject) {
        this.aUL = null;
        this.mLink = null;
        this.mType = 0;
        this.bKO = 0;
        if (jSONObject != null) {
            this.aUL = jSONObject.optString("text");
            this.mLink = jSONObject.optString("link");
            this.mType = jSONObject.optInt("type", 0);
            this.bKO = jSONObject.optInt("url_type", 0);
            this.bKL = jSONObject.optInt("is_native_app", 0);
            if (this.bKL == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.bKL = 0;
                    return;
                }
                this.bKM = jSONObject.optString("jump_and");
                this.bKN = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.bKM) || TextUtils.isEmpty(this.bKN)) {
                    this.bKL = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.bKM += ";download_url:" + this.bKN + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.bKM += ";download_url:" + this.bKN + ";web_play_url:" + this.aUL;
                }
                this.bKM += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(PbContent pbContent) {
        this.aUL = null;
        this.mLink = null;
        this.mType = 0;
        this.bKO = 0;
        if (pbContent != null) {
            this.aUL = pbContent.text;
            this.mLink = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.bKO = pbContent.url_type.intValue();
            this.bKL = pbContent.is_native_app.intValue();
            if (this.bKL == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.bKL = 0;
                    return;
                }
                this.bKM = nativeApp.jump_and;
                this.bKN = nativeApp.download_and;
                if (TextUtils.isEmpty(this.bKM) || TextUtils.isEmpty(this.bKN)) {
                    this.bKL = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.bKM += ";download_url:" + this.bKN + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.bKM += ";download_url:" + this.bKN + ";web_play_url:" + this.aUL;
                }
                this.bKM += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(String str, String str2) {
        this.aUL = null;
        this.mLink = null;
        this.mType = 0;
        this.bKO = 0;
        this.aUL = str;
        this.mLink = str2;
    }

    public void setText(String str) {
        this.aUL = str;
    }

    public void setLink(String str) {
        this.mLink = str;
    }

    public String getText() {
        return this.aUL;
    }

    public String getLink() {
        return this.mLink;
    }

    public int Ri() {
        return this.bKL;
    }

    public String Rj() {
        return this.bKM;
    }

    public int Rk() {
        return this.bKO;
    }

    public void Rl() {
        if (this.aUL != null) {
            this.aUL = this.aUL.replaceAll("\n", "");
        }
        if (this.mLink != null) {
            this.mLink = this.mLink.replaceAll("\n", "");
        }
    }
}
