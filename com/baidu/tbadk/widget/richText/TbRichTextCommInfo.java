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
    private int aOl;
    private String aOm;
    private String aOn;
    private int aOo;
    private String aef;
    private String mLink;
    private int mType;

    public TbRichTextCommInfo() {
        this.aef = null;
        this.mLink = null;
        this.mType = 0;
        this.aOo = 0;
    }

    public TbRichTextCommInfo(JSONObject jSONObject) {
        this.aef = null;
        this.mLink = null;
        this.mType = 0;
        this.aOo = 0;
        if (jSONObject != null) {
            this.aef = jSONObject.optString("text");
            this.mLink = jSONObject.optString("link");
            this.mType = jSONObject.optInt("type", 0);
            this.aOo = jSONObject.optInt("url_type", 0);
            this.aOl = jSONObject.optInt("is_native_app", 0);
            if (this.aOl == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.aOl = 0;
                    return;
                }
                this.aOm = jSONObject.optString("jump_and");
                this.aOn = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.aOm) || TextUtils.isEmpty(this.aOn)) {
                    this.aOl = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aOm = String.valueOf(this.aOm) + ";download_url:" + this.aOn + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aOm = String.valueOf(this.aOm) + ";download_url:" + this.aOn + ";web_play_url:" + this.aef;
                }
                this.aOm = String.valueOf(this.aOm) + ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(PbContent pbContent) {
        this.aef = null;
        this.mLink = null;
        this.mType = 0;
        this.aOo = 0;
        if (pbContent != null) {
            this.aef = pbContent.text;
            this.mLink = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.aOo = pbContent.url_type.intValue();
            this.aOl = pbContent.is_native_app.intValue();
            if (this.aOl == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.aOl = 0;
                    return;
                }
                this.aOm = nativeApp.jump_and;
                this.aOn = nativeApp.download_and;
                if (TextUtils.isEmpty(this.aOm) || TextUtils.isEmpty(this.aOn)) {
                    this.aOl = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aOm = String.valueOf(this.aOm) + ";download_url:" + this.aOn + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aOm = String.valueOf(this.aOm) + ";download_url:" + this.aOn + ";web_play_url:" + this.aef;
                }
                this.aOm = String.valueOf(this.aOm) + ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(String str, String str2) {
        this.aef = null;
        this.mLink = null;
        this.mType = 0;
        this.aOo = 0;
        this.aef = str;
        this.mLink = str2;
    }

    public void setText(String str) {
        this.aef = str;
    }

    public void setLink(String str) {
        this.mLink = str;
    }

    public String getText() {
        return this.aef;
    }

    public String getLink() {
        return this.mLink;
    }

    public int HV() {
        return this.aOl;
    }

    public String HW() {
        return this.aOm;
    }

    public int HX() {
        return this.aOo;
    }

    public void HY() {
        if (this.aef != null) {
            this.aef = this.aef.replaceAll("\n", "");
        }
        if (this.mLink != null) {
            this.mLink = this.mLink.replaceAll("\n", "");
        }
    }
}
