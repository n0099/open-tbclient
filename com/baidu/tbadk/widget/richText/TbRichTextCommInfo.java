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
    private int aQJ;
    private String aQK;
    private String aQL;
    private int aQM;
    private String afX;
    private String mLink;
    private int mType;

    public TbRichTextCommInfo() {
        this.afX = null;
        this.mLink = null;
        this.mType = 0;
        this.aQM = 0;
    }

    public TbRichTextCommInfo(JSONObject jSONObject) {
        this.afX = null;
        this.mLink = null;
        this.mType = 0;
        this.aQM = 0;
        if (jSONObject != null) {
            this.afX = jSONObject.optString("text");
            this.mLink = jSONObject.optString("link");
            this.mType = jSONObject.optInt("type", 0);
            this.aQM = jSONObject.optInt("url_type", 0);
            this.aQJ = jSONObject.optInt("is_native_app", 0);
            if (this.aQJ == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.aQJ = 0;
                    return;
                }
                this.aQK = jSONObject.optString("jump_and");
                this.aQL = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.aQK) || TextUtils.isEmpty(this.aQL)) {
                    this.aQJ = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aQK += ";download_url:" + this.aQL + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aQK += ";download_url:" + this.aQL + ";web_play_url:" + this.afX;
                }
                this.aQK += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(PbContent pbContent) {
        this.afX = null;
        this.mLink = null;
        this.mType = 0;
        this.aQM = 0;
        if (pbContent != null) {
            this.afX = pbContent.text;
            this.mLink = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.aQM = pbContent.url_type.intValue();
            this.aQJ = pbContent.is_native_app.intValue();
            if (this.aQJ == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.aQJ = 0;
                    return;
                }
                this.aQK = nativeApp.jump_and;
                this.aQL = nativeApp.download_and;
                if (TextUtils.isEmpty(this.aQK) || TextUtils.isEmpty(this.aQL)) {
                    this.aQJ = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aQK += ";download_url:" + this.aQL + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aQK += ";download_url:" + this.aQL + ";web_play_url:" + this.afX;
                }
                this.aQK += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(String str, String str2) {
        this.afX = null;
        this.mLink = null;
        this.mType = 0;
        this.aQM = 0;
        this.afX = str;
        this.mLink = str2;
    }

    public void setText(String str) {
        this.afX = str;
    }

    public void setLink(String str) {
        this.mLink = str;
    }

    public String getText() {
        return this.afX;
    }

    public String getLink() {
        return this.mLink;
    }

    public int Ip() {
        return this.aQJ;
    }

    public String Iq() {
        return this.aQK;
    }

    public int Ir() {
        return this.aQM;
    }

    public void bn() {
        if (this.afX != null) {
            this.afX = this.afX.replaceAll("\n", "");
        }
        if (this.mLink != null) {
            this.mLink = this.mLink.replaceAll("\n", "");
        }
    }
}
