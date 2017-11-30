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
    private int aUL;
    private String aUM;
    private String aUN;
    private int aUO;
    private String afi;
    private String mLink;
    private int mType;

    public TbRichTextCommInfo() {
        this.afi = null;
        this.mLink = null;
        this.mType = 0;
        this.aUO = 0;
    }

    public TbRichTextCommInfo(JSONObject jSONObject) {
        this.afi = null;
        this.mLink = null;
        this.mType = 0;
        this.aUO = 0;
        if (jSONObject != null) {
            this.afi = jSONObject.optString("text");
            this.mLink = jSONObject.optString("link");
            this.mType = jSONObject.optInt("type", 0);
            this.aUO = jSONObject.optInt("url_type", 0);
            this.aUL = jSONObject.optInt("is_native_app", 0);
            if (this.aUL == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.aUL = 0;
                    return;
                }
                this.aUM = jSONObject.optString("jump_and");
                this.aUN = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.aUM) || TextUtils.isEmpty(this.aUN)) {
                    this.aUL = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aUM += ";download_url:" + this.aUN + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aUM += ";download_url:" + this.aUN + ";web_play_url:" + this.afi;
                }
                this.aUM += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(PbContent pbContent) {
        this.afi = null;
        this.mLink = null;
        this.mType = 0;
        this.aUO = 0;
        if (pbContent != null) {
            this.afi = pbContent.text;
            this.mLink = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.aUO = pbContent.url_type.intValue();
            this.aUL = pbContent.is_native_app.intValue();
            if (this.aUL == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.aUL = 0;
                    return;
                }
                this.aUM = nativeApp.jump_and;
                this.aUN = nativeApp.download_and;
                if (TextUtils.isEmpty(this.aUM) || TextUtils.isEmpty(this.aUN)) {
                    this.aUL = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aUM += ";download_url:" + this.aUN + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aUM += ";download_url:" + this.aUN + ";web_play_url:" + this.afi;
                }
                this.aUM += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(String str, String str2) {
        this.afi = null;
        this.mLink = null;
        this.mType = 0;
        this.aUO = 0;
        this.afi = str;
        this.mLink = str2;
    }

    public void setText(String str) {
        this.afi = str;
    }

    public void setLink(String str) {
        this.mLink = str;
    }

    public String getText() {
        return this.afi;
    }

    public String getLink() {
        return this.mLink;
    }

    public int Jr() {
        return this.aUL;
    }

    public String Js() {
        return this.aUM;
    }

    public int Jt() {
        return this.aUO;
    }

    public void Ju() {
        if (this.afi != null) {
            this.afi = this.afi.replaceAll("\n", "");
        }
        if (this.mLink != null) {
            this.mLink = this.mLink.replaceAll("\n", "");
        }
    }
}
