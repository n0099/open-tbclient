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
    private String aoo;
    private int bfi;
    private String bfj;
    private String bfk;
    private int bfl;
    private String mLink;
    private int mType;

    public TbRichTextCommInfo() {
        this.aoo = null;
        this.mLink = null;
        this.mType = 0;
        this.bfl = 0;
    }

    public TbRichTextCommInfo(JSONObject jSONObject) {
        this.aoo = null;
        this.mLink = null;
        this.mType = 0;
        this.bfl = 0;
        if (jSONObject != null) {
            this.aoo = jSONObject.optString("text");
            this.mLink = jSONObject.optString("link");
            this.mType = jSONObject.optInt("type", 0);
            this.bfl = jSONObject.optInt("url_type", 0);
            this.bfi = jSONObject.optInt("is_native_app", 0);
            if (this.bfi == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.bfi = 0;
                    return;
                }
                this.bfj = jSONObject.optString("jump_and");
                this.bfk = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.bfj) || TextUtils.isEmpty(this.bfk)) {
                    this.bfi = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.bfj += ";download_url:" + this.bfk + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.bfj += ";download_url:" + this.bfk + ";web_play_url:" + this.aoo;
                }
                this.bfj += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(PbContent pbContent) {
        this.aoo = null;
        this.mLink = null;
        this.mType = 0;
        this.bfl = 0;
        if (pbContent != null) {
            this.aoo = pbContent.text;
            this.mLink = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.bfl = pbContent.url_type.intValue();
            this.bfi = pbContent.is_native_app.intValue();
            if (this.bfi == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.bfi = 0;
                    return;
                }
                this.bfj = nativeApp.jump_and;
                this.bfk = nativeApp.download_and;
                if (TextUtils.isEmpty(this.bfj) || TextUtils.isEmpty(this.bfk)) {
                    this.bfi = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.bfj += ";download_url:" + this.bfk + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.bfj += ";download_url:" + this.bfk + ";web_play_url:" + this.aoo;
                }
                this.bfj += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(String str, String str2) {
        this.aoo = null;
        this.mLink = null;
        this.mType = 0;
        this.bfl = 0;
        this.aoo = str;
        this.mLink = str2;
    }

    public void setText(String str) {
        this.aoo = str;
    }

    public void setLink(String str) {
        this.mLink = str;
    }

    public String getText() {
        return this.aoo;
    }

    public String getLink() {
        return this.mLink;
    }

    public int Ny() {
        return this.bfi;
    }

    public String Nz() {
        return this.bfj;
    }

    public int NA() {
        return this.bfl;
    }

    public void NB() {
        if (this.aoo != null) {
            this.aoo = this.aoo.replaceAll("\n", "");
        }
        if (this.mLink != null) {
            this.mLink = this.mLink.replaceAll("\n", "");
        }
    }
}
