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
    private int aUN;
    private String aUO;
    private String aUP;
    private int aUQ;
    private String afc;
    private String mLink;
    private int mType;

    public TbRichTextCommInfo() {
        this.afc = null;
        this.mLink = null;
        this.mType = 0;
        this.aUQ = 0;
    }

    public TbRichTextCommInfo(JSONObject jSONObject) {
        this.afc = null;
        this.mLink = null;
        this.mType = 0;
        this.aUQ = 0;
        if (jSONObject != null) {
            this.afc = jSONObject.optString("text");
            this.mLink = jSONObject.optString("link");
            this.mType = jSONObject.optInt("type", 0);
            this.aUQ = jSONObject.optInt("url_type", 0);
            this.aUN = jSONObject.optInt("is_native_app", 0);
            if (this.aUN == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.aUN = 0;
                    return;
                }
                this.aUO = jSONObject.optString("jump_and");
                this.aUP = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.aUO) || TextUtils.isEmpty(this.aUP)) {
                    this.aUN = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aUO += ";download_url:" + this.aUP + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aUO += ";download_url:" + this.aUP + ";web_play_url:" + this.afc;
                }
                this.aUO += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(PbContent pbContent) {
        this.afc = null;
        this.mLink = null;
        this.mType = 0;
        this.aUQ = 0;
        if (pbContent != null) {
            this.afc = pbContent.text;
            this.mLink = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.aUQ = pbContent.url_type.intValue();
            this.aUN = pbContent.is_native_app.intValue();
            if (this.aUN == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.aUN = 0;
                    return;
                }
                this.aUO = nativeApp.jump_and;
                this.aUP = nativeApp.download_and;
                if (TextUtils.isEmpty(this.aUO) || TextUtils.isEmpty(this.aUP)) {
                    this.aUN = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aUO += ";download_url:" + this.aUP + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aUO += ";download_url:" + this.aUP + ";web_play_url:" + this.afc;
                }
                this.aUO += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(String str, String str2) {
        this.afc = null;
        this.mLink = null;
        this.mType = 0;
        this.aUQ = 0;
        this.afc = str;
        this.mLink = str2;
    }

    public void setText(String str) {
        this.afc = str;
    }

    public void setLink(String str) {
        this.mLink = str;
    }

    public String getText() {
        return this.afc;
    }

    public String getLink() {
        return this.mLink;
    }

    public int Js() {
        return this.aUN;
    }

    public String Jt() {
        return this.aUO;
    }

    public int Ju() {
        return this.aUQ;
    }

    public void Jv() {
        if (this.afc != null) {
            this.afc = this.afc.replaceAll("\n", "");
        }
        if (this.mLink != null) {
            this.mLink = this.mLink.replaceAll("\n", "");
        }
    }
}
