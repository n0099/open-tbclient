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
    private int aRe;
    private String aRf;
    private String aRg;
    private int aRh;
    private String aer;
    private String mLink;
    private int mType;

    public TbRichTextCommInfo() {
        this.aer = null;
        this.mLink = null;
        this.mType = 0;
        this.aRh = 0;
    }

    public TbRichTextCommInfo(JSONObject jSONObject) {
        this.aer = null;
        this.mLink = null;
        this.mType = 0;
        this.aRh = 0;
        if (jSONObject != null) {
            this.aer = jSONObject.optString("text");
            this.mLink = jSONObject.optString("link");
            this.mType = jSONObject.optInt("type", 0);
            this.aRh = jSONObject.optInt("url_type", 0);
            this.aRe = jSONObject.optInt("is_native_app", 0);
            if (this.aRe == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.aRe = 0;
                    return;
                }
                this.aRf = jSONObject.optString("jump_and");
                this.aRg = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.aRf) || TextUtils.isEmpty(this.aRg)) {
                    this.aRe = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aRf += ";download_url:" + this.aRg + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aRf += ";download_url:" + this.aRg + ";web_play_url:" + this.aer;
                }
                this.aRf += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(PbContent pbContent) {
        this.aer = null;
        this.mLink = null;
        this.mType = 0;
        this.aRh = 0;
        if (pbContent != null) {
            this.aer = pbContent.text;
            this.mLink = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.aRh = pbContent.url_type.intValue();
            this.aRe = pbContent.is_native_app.intValue();
            if (this.aRe == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.aRe = 0;
                    return;
                }
                this.aRf = nativeApp.jump_and;
                this.aRg = nativeApp.download_and;
                if (TextUtils.isEmpty(this.aRf) || TextUtils.isEmpty(this.aRg)) {
                    this.aRe = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aRf += ";download_url:" + this.aRg + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aRf += ";download_url:" + this.aRg + ";web_play_url:" + this.aer;
                }
                this.aRf += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(String str, String str2) {
        this.aer = null;
        this.mLink = null;
        this.mType = 0;
        this.aRh = 0;
        this.aer = str;
        this.mLink = str2;
    }

    public void setText(String str) {
        this.aer = str;
    }

    public void setLink(String str) {
        this.mLink = str;
    }

    public String getText() {
        return this.aer;
    }

    public String getLink() {
        return this.mLink;
    }

    public int Iy() {
        return this.aRe;
    }

    public String Iz() {
        return this.aRf;
    }

    public int IA() {
        return this.aRh;
    }

    public void IB() {
        if (this.aer != null) {
            this.aer = this.aer.replaceAll("\n", "");
        }
        if (this.mLink != null) {
            this.mLink = this.mLink.replaceAll("\n", "");
        }
    }
}
