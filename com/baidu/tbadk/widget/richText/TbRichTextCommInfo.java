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
    private int aQs;
    private String aQt;
    private String aQu;
    private int aQv;
    private String afh;
    private String mLink;
    private int mType;

    public TbRichTextCommInfo() {
        this.afh = null;
        this.mLink = null;
        this.mType = 0;
        this.aQv = 0;
    }

    public TbRichTextCommInfo(JSONObject jSONObject) {
        this.afh = null;
        this.mLink = null;
        this.mType = 0;
        this.aQv = 0;
        if (jSONObject != null) {
            this.afh = jSONObject.optString("text");
            this.mLink = jSONObject.optString("link");
            this.mType = jSONObject.optInt("type", 0);
            this.aQv = jSONObject.optInt("url_type", 0);
            this.aQs = jSONObject.optInt("is_native_app", 0);
            if (this.aQs == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.aQs = 0;
                    return;
                }
                this.aQt = jSONObject.optString("jump_and");
                this.aQu = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.aQt) || TextUtils.isEmpty(this.aQu)) {
                    this.aQs = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aQt += ";download_url:" + this.aQu + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aQt += ";download_url:" + this.aQu + ";web_play_url:" + this.afh;
                }
                this.aQt += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(PbContent pbContent) {
        this.afh = null;
        this.mLink = null;
        this.mType = 0;
        this.aQv = 0;
        if (pbContent != null) {
            this.afh = pbContent.text;
            this.mLink = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.aQv = pbContent.url_type.intValue();
            this.aQs = pbContent.is_native_app.intValue();
            if (this.aQs == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.aQs = 0;
                    return;
                }
                this.aQt = nativeApp.jump_and;
                this.aQu = nativeApp.download_and;
                if (TextUtils.isEmpty(this.aQt) || TextUtils.isEmpty(this.aQu)) {
                    this.aQs = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aQt += ";download_url:" + this.aQu + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aQt += ";download_url:" + this.aQu + ";web_play_url:" + this.afh;
                }
                this.aQt += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(String str, String str2) {
        this.afh = null;
        this.mLink = null;
        this.mType = 0;
        this.aQv = 0;
        this.afh = str;
        this.mLink = str2;
    }

    public void setText(String str) {
        this.afh = str;
    }

    public void setLink(String str) {
        this.mLink = str;
    }

    public String getText() {
        return this.afh;
    }

    public String getLink() {
        return this.mLink;
    }

    public int Iw() {
        return this.aQs;
    }

    public String Ix() {
        return this.aQt;
    }

    public int Iy() {
        return this.aQv;
    }

    public void Iz() {
        if (this.afh != null) {
            this.afh = this.afh.replaceAll("\n", "");
        }
        if (this.mLink != null) {
            this.mLink = this.mLink.replaceAll("\n", "");
        }
    }
}
