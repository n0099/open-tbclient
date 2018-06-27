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
    private String aoM;
    private int beX;
    private String beY;
    private String beZ;
    private int bfa;
    private String mLink;
    private int mType;

    public TbRichTextCommInfo() {
        this.aoM = null;
        this.mLink = null;
        this.mType = 0;
        this.bfa = 0;
    }

    public TbRichTextCommInfo(JSONObject jSONObject) {
        this.aoM = null;
        this.mLink = null;
        this.mType = 0;
        this.bfa = 0;
        if (jSONObject != null) {
            this.aoM = jSONObject.optString("text");
            this.mLink = jSONObject.optString("link");
            this.mType = jSONObject.optInt("type", 0);
            this.bfa = jSONObject.optInt("url_type", 0);
            this.beX = jSONObject.optInt("is_native_app", 0);
            if (this.beX == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.beX = 0;
                    return;
                }
                this.beY = jSONObject.optString("jump_and");
                this.beZ = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.beY) || TextUtils.isEmpty(this.beZ)) {
                    this.beX = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.beY += ";download_url:" + this.beZ + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.beY += ";download_url:" + this.beZ + ";web_play_url:" + this.aoM;
                }
                this.beY += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(PbContent pbContent) {
        this.aoM = null;
        this.mLink = null;
        this.mType = 0;
        this.bfa = 0;
        if (pbContent != null) {
            this.aoM = pbContent.text;
            this.mLink = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.bfa = pbContent.url_type.intValue();
            this.beX = pbContent.is_native_app.intValue();
            if (this.beX == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.beX = 0;
                    return;
                }
                this.beY = nativeApp.jump_and;
                this.beZ = nativeApp.download_and;
                if (TextUtils.isEmpty(this.beY) || TextUtils.isEmpty(this.beZ)) {
                    this.beX = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.beY += ";download_url:" + this.beZ + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.beY += ";download_url:" + this.beZ + ";web_play_url:" + this.aoM;
                }
                this.beY += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(String str, String str2) {
        this.aoM = null;
        this.mLink = null;
        this.mType = 0;
        this.bfa = 0;
        this.aoM = str;
        this.mLink = str2;
    }

    public void setText(String str) {
        this.aoM = str;
    }

    public void setLink(String str) {
        this.mLink = str;
    }

    public String getText() {
        return this.aoM;
    }

    public String getLink() {
        return this.mLink;
    }

    public int NA() {
        return this.beX;
    }

    public String NB() {
        return this.beY;
    }

    public int NC() {
        return this.bfa;
    }

    public void ND() {
        if (this.aoM != null) {
            this.aoM = this.aoM.replaceAll("\n", "");
        }
        if (this.mLink != null) {
            this.mLink = this.mLink.replaceAll("\n", "");
        }
    }
}
