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
    private int aQp;
    private String aQq;
    private String aQr;
    private int aQs;
    private String afg;
    private String mLink;
    private int mType;

    public TbRichTextCommInfo() {
        this.afg = null;
        this.mLink = null;
        this.mType = 0;
        this.aQs = 0;
    }

    public TbRichTextCommInfo(JSONObject jSONObject) {
        this.afg = null;
        this.mLink = null;
        this.mType = 0;
        this.aQs = 0;
        if (jSONObject != null) {
            this.afg = jSONObject.optString("text");
            this.mLink = jSONObject.optString("link");
            this.mType = jSONObject.optInt("type", 0);
            this.aQs = jSONObject.optInt("url_type", 0);
            this.aQp = jSONObject.optInt("is_native_app", 0);
            if (this.aQp == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.aQp = 0;
                    return;
                }
                this.aQq = jSONObject.optString("jump_and");
                this.aQr = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.aQq) || TextUtils.isEmpty(this.aQr)) {
                    this.aQp = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aQq += ";download_url:" + this.aQr + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aQq += ";download_url:" + this.aQr + ";web_play_url:" + this.afg;
                }
                this.aQq += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(PbContent pbContent) {
        this.afg = null;
        this.mLink = null;
        this.mType = 0;
        this.aQs = 0;
        if (pbContent != null) {
            this.afg = pbContent.text;
            this.mLink = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.aQs = pbContent.url_type.intValue();
            this.aQp = pbContent.is_native_app.intValue();
            if (this.aQp == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.aQp = 0;
                    return;
                }
                this.aQq = nativeApp.jump_and;
                this.aQr = nativeApp.download_and;
                if (TextUtils.isEmpty(this.aQq) || TextUtils.isEmpty(this.aQr)) {
                    this.aQp = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aQq += ";download_url:" + this.aQr + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aQq += ";download_url:" + this.aQr + ";web_play_url:" + this.afg;
                }
                this.aQq += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(String str, String str2) {
        this.afg = null;
        this.mLink = null;
        this.mType = 0;
        this.aQs = 0;
        this.afg = str;
        this.mLink = str2;
    }

    public void setText(String str) {
        this.afg = str;
    }

    public void setLink(String str) {
        this.mLink = str;
    }

    public String getText() {
        return this.afg;
    }

    public String getLink() {
        return this.mLink;
    }

    public int Iw() {
        return this.aQp;
    }

    public String Ix() {
        return this.aQq;
    }

    public int Iy() {
        return this.aQs;
    }

    public void Iz() {
        if (this.afg != null) {
            this.afg = this.afg.replaceAll("\n", "");
        }
        if (this.mLink != null) {
            this.mLink = this.mLink.replaceAll("\n", "");
        }
    }
}
