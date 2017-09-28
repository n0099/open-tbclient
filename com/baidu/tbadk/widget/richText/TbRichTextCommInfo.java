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
    private int aRr;
    private String aRs;
    private String aRt;
    private int aRu;
    private String aeD;
    private String mLink;
    private int mType;

    public TbRichTextCommInfo() {
        this.aeD = null;
        this.mLink = null;
        this.mType = 0;
        this.aRu = 0;
    }

    public TbRichTextCommInfo(JSONObject jSONObject) {
        this.aeD = null;
        this.mLink = null;
        this.mType = 0;
        this.aRu = 0;
        if (jSONObject != null) {
            this.aeD = jSONObject.optString("text");
            this.mLink = jSONObject.optString("link");
            this.mType = jSONObject.optInt("type", 0);
            this.aRu = jSONObject.optInt("url_type", 0);
            this.aRr = jSONObject.optInt("is_native_app", 0);
            if (this.aRr == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.aRr = 0;
                    return;
                }
                this.aRs = jSONObject.optString("jump_and");
                this.aRt = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.aRs) || TextUtils.isEmpty(this.aRt)) {
                    this.aRr = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aRs += ";download_url:" + this.aRt + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aRs += ";download_url:" + this.aRt + ";web_play_url:" + this.aeD;
                }
                this.aRs += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(PbContent pbContent) {
        this.aeD = null;
        this.mLink = null;
        this.mType = 0;
        this.aRu = 0;
        if (pbContent != null) {
            this.aeD = pbContent.text;
            this.mLink = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.aRu = pbContent.url_type.intValue();
            this.aRr = pbContent.is_native_app.intValue();
            if (this.aRr == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.aRr = 0;
                    return;
                }
                this.aRs = nativeApp.jump_and;
                this.aRt = nativeApp.download_and;
                if (TextUtils.isEmpty(this.aRs) || TextUtils.isEmpty(this.aRt)) {
                    this.aRr = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aRs += ";download_url:" + this.aRt + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aRs += ";download_url:" + this.aRt + ";web_play_url:" + this.aeD;
                }
                this.aRs += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(String str, String str2) {
        this.aeD = null;
        this.mLink = null;
        this.mType = 0;
        this.aRu = 0;
        this.aeD = str;
        this.mLink = str2;
    }

    public void setText(String str) {
        this.aeD = str;
    }

    public void setLink(String str) {
        this.mLink = str;
    }

    public String getText() {
        return this.aeD;
    }

    public String getLink() {
        return this.mLink;
    }

    public int IE() {
        return this.aRr;
    }

    public String IF() {
        return this.aRs;
    }

    public int IG() {
        return this.aRu;
    }

    public void IH() {
        if (this.aeD != null) {
            this.aeD = this.aeD.replaceAll("\n", "");
        }
        if (this.mLink != null) {
            this.mLink = this.mLink.replaceAll("\n", "");
        }
    }
}
