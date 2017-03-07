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
    private int aMp;
    private String aMq;
    private String aMr;
    private int aMs;
    private String adX;
    private String mLink;
    private int mType;

    public TbRichTextCommInfo() {
        this.adX = null;
        this.mLink = null;
        this.mType = 0;
        this.aMs = 0;
    }

    public TbRichTextCommInfo(JSONObject jSONObject) {
        this.adX = null;
        this.mLink = null;
        this.mType = 0;
        this.aMs = 0;
        if (jSONObject != null) {
            this.adX = jSONObject.optString("text");
            this.mLink = jSONObject.optString("link");
            this.mType = jSONObject.optInt("type", 0);
            this.aMs = jSONObject.optInt("url_type", 0);
            this.aMp = jSONObject.optInt("is_native_app", 0);
            if (this.aMp == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.aMp = 0;
                    return;
                }
                this.aMq = jSONObject.optString("jump_and");
                this.aMr = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.aMq) || TextUtils.isEmpty(this.aMr)) {
                    this.aMp = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aMq = String.valueOf(this.aMq) + ";download_url:" + this.aMr + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aMq = String.valueOf(this.aMq) + ";download_url:" + this.aMr + ";web_play_url:" + this.adX;
                }
                this.aMq = String.valueOf(this.aMq) + ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(PbContent pbContent) {
        this.adX = null;
        this.mLink = null;
        this.mType = 0;
        this.aMs = 0;
        if (pbContent != null) {
            this.adX = pbContent.text;
            this.mLink = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.aMs = pbContent.url_type.intValue();
            this.aMp = pbContent.is_native_app.intValue();
            if (this.aMp == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.aMp = 0;
                    return;
                }
                this.aMq = nativeApp.jump_and;
                this.aMr = nativeApp.download_and;
                if (TextUtils.isEmpty(this.aMq) || TextUtils.isEmpty(this.aMr)) {
                    this.aMp = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aMq = String.valueOf(this.aMq) + ";download_url:" + this.aMr + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aMq = String.valueOf(this.aMq) + ";download_url:" + this.aMr + ";web_play_url:" + this.adX;
                }
                this.aMq = String.valueOf(this.aMq) + ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(String str, String str2) {
        this.adX = null;
        this.mLink = null;
        this.mType = 0;
        this.aMs = 0;
        this.adX = str;
        this.mLink = str2;
    }

    public void setText(String str) {
        this.adX = str;
    }

    public void setLink(String str) {
        this.mLink = str;
    }

    public String getText() {
        return this.adX;
    }

    public String getLink() {
        return this.mLink;
    }

    public int HQ() {
        return this.aMp;
    }

    public String HR() {
        return this.aMq;
    }

    public int HS() {
        return this.aMs;
    }

    public void HT() {
        if (this.adX != null) {
            this.adX = this.adX.replaceAll("\n", "");
        }
        if (this.mLink != null) {
            this.mLink = this.mLink.replaceAll("\n", "");
        }
    }
}
