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
    private String aUX;
    private int bKY;
    private String bKZ;
    private String bLa;
    private int bLb;
    private String mLink;
    private int mType;

    public TbRichTextCommInfo() {
        this.aUX = null;
        this.mLink = null;
        this.mType = 0;
        this.bLb = 0;
    }

    public TbRichTextCommInfo(JSONObject jSONObject) {
        this.aUX = null;
        this.mLink = null;
        this.mType = 0;
        this.bLb = 0;
        if (jSONObject != null) {
            this.aUX = jSONObject.optString("text");
            this.mLink = jSONObject.optString("link");
            this.mType = jSONObject.optInt("type", 0);
            this.bLb = jSONObject.optInt("url_type", 0);
            this.bKY = jSONObject.optInt("is_native_app", 0);
            if (this.bKY == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.bKY = 0;
                    return;
                }
                this.bKZ = jSONObject.optString("jump_and");
                this.bLa = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.bKZ) || TextUtils.isEmpty(this.bLa)) {
                    this.bKY = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.bKZ += ";download_url:" + this.bLa + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.bKZ += ";download_url:" + this.bLa + ";web_play_url:" + this.aUX;
                }
                this.bKZ += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(PbContent pbContent) {
        this.aUX = null;
        this.mLink = null;
        this.mType = 0;
        this.bLb = 0;
        if (pbContent != null) {
            this.aUX = pbContent.text;
            this.mLink = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.bLb = pbContent.url_type.intValue();
            this.bKY = pbContent.is_native_app.intValue();
            if (this.bKY == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.bKY = 0;
                    return;
                }
                this.bKZ = nativeApp.jump_and;
                this.bLa = nativeApp.download_and;
                if (TextUtils.isEmpty(this.bKZ) || TextUtils.isEmpty(this.bLa)) {
                    this.bKY = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.bKZ += ";download_url:" + this.bLa + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.bKZ += ";download_url:" + this.bLa + ";web_play_url:" + this.aUX;
                }
                this.bKZ += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(String str, String str2) {
        this.aUX = null;
        this.mLink = null;
        this.mType = 0;
        this.bLb = 0;
        this.aUX = str;
        this.mLink = str2;
    }

    public void setText(String str) {
        this.aUX = str;
    }

    public void setLink(String str) {
        this.mLink = str;
    }

    public String getText() {
        return this.aUX;
    }

    public String getLink() {
        return this.mLink;
    }

    public int Rj() {
        return this.bKY;
    }

    public String Rk() {
        return this.bKZ;
    }

    public int Rl() {
        return this.bLb;
    }

    public void Rm() {
        if (this.aUX != null) {
            this.aUX = this.aUX.replaceAll("\n", "");
        }
        if (this.mLink != null) {
            this.mLink = this.mLink.replaceAll("\n", "");
        }
    }
}
