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
    private int aQH;
    private String aQI;
    private String aQJ;
    private int aQK;
    private String afV;
    private String mLink;
    private int mType;

    public TbRichTextCommInfo() {
        this.afV = null;
        this.mLink = null;
        this.mType = 0;
        this.aQK = 0;
    }

    public TbRichTextCommInfo(JSONObject jSONObject) {
        this.afV = null;
        this.mLink = null;
        this.mType = 0;
        this.aQK = 0;
        if (jSONObject != null) {
            this.afV = jSONObject.optString("text");
            this.mLink = jSONObject.optString("link");
            this.mType = jSONObject.optInt("type", 0);
            this.aQK = jSONObject.optInt("url_type", 0);
            this.aQH = jSONObject.optInt("is_native_app", 0);
            if (this.aQH == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.aQH = 0;
                    return;
                }
                this.aQI = jSONObject.optString("jump_and");
                this.aQJ = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.aQI) || TextUtils.isEmpty(this.aQJ)) {
                    this.aQH = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aQI += ";download_url:" + this.aQJ + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aQI += ";download_url:" + this.aQJ + ";web_play_url:" + this.afV;
                }
                this.aQI += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(PbContent pbContent) {
        this.afV = null;
        this.mLink = null;
        this.mType = 0;
        this.aQK = 0;
        if (pbContent != null) {
            this.afV = pbContent.text;
            this.mLink = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.aQK = pbContent.url_type.intValue();
            this.aQH = pbContent.is_native_app.intValue();
            if (this.aQH == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.aQH = 0;
                    return;
                }
                this.aQI = nativeApp.jump_and;
                this.aQJ = nativeApp.download_and;
                if (TextUtils.isEmpty(this.aQI) || TextUtils.isEmpty(this.aQJ)) {
                    this.aQH = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aQI += ";download_url:" + this.aQJ + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aQI += ";download_url:" + this.aQJ + ";web_play_url:" + this.afV;
                }
                this.aQI += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(String str, String str2) {
        this.afV = null;
        this.mLink = null;
        this.mType = 0;
        this.aQK = 0;
        this.afV = str;
        this.mLink = str2;
    }

    public void setText(String str) {
        this.afV = str;
    }

    public void setLink(String str) {
        this.mLink = str;
    }

    public String getText() {
        return this.afV;
    }

    public String getLink() {
        return this.mLink;
    }

    public int Ip() {
        return this.aQH;
    }

    public String Iq() {
        return this.aQI;
    }

    public int Ir() {
        return this.aQK;
    }

    public void bn() {
        if (this.afV != null) {
            this.afV = this.afV.replaceAll("\n", "");
        }
        if (this.mLink != null) {
            this.mLink = this.mLink.replaceAll("\n", "");
        }
    }
}
