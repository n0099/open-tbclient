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
    private int aPu;
    private String aPv;
    private String aPw;
    private int aPx;
    private String aeB;
    private String mLink;
    private int mType;

    public TbRichTextCommInfo() {
        this.aeB = null;
        this.mLink = null;
        this.mType = 0;
        this.aPx = 0;
    }

    public TbRichTextCommInfo(JSONObject jSONObject) {
        this.aeB = null;
        this.mLink = null;
        this.mType = 0;
        this.aPx = 0;
        if (jSONObject != null) {
            this.aeB = jSONObject.optString("text");
            this.mLink = jSONObject.optString("link");
            this.mType = jSONObject.optInt("type", 0);
            this.aPx = jSONObject.optInt("url_type", 0);
            this.aPu = jSONObject.optInt("is_native_app", 0);
            if (this.aPu == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.aPu = 0;
                    return;
                }
                this.aPv = jSONObject.optString("jump_and");
                this.aPw = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.aPv) || TextUtils.isEmpty(this.aPw)) {
                    this.aPu = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aPv += ";download_url:" + this.aPw + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aPv += ";download_url:" + this.aPw + ";web_play_url:" + this.aeB;
                }
                this.aPv += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(PbContent pbContent) {
        this.aeB = null;
        this.mLink = null;
        this.mType = 0;
        this.aPx = 0;
        if (pbContent != null) {
            this.aeB = pbContent.text;
            this.mLink = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.aPx = pbContent.url_type.intValue();
            this.aPu = pbContent.is_native_app.intValue();
            if (this.aPu == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.aPu = 0;
                    return;
                }
                this.aPv = nativeApp.jump_and;
                this.aPw = nativeApp.download_and;
                if (TextUtils.isEmpty(this.aPv) || TextUtils.isEmpty(this.aPw)) {
                    this.aPu = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aPv += ";download_url:" + this.aPw + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aPv += ";download_url:" + this.aPw + ";web_play_url:" + this.aeB;
                }
                this.aPv += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(String str, String str2) {
        this.aeB = null;
        this.mLink = null;
        this.mType = 0;
        this.aPx = 0;
        this.aeB = str;
        this.mLink = str2;
    }

    public void setText(String str) {
        this.aeB = str;
    }

    public void setLink(String str) {
        this.mLink = str;
    }

    public String getText() {
        return this.aeB;
    }

    public String getLink() {
        return this.mLink;
    }

    public int Ih() {
        return this.aPu;
    }

    public String Ii() {
        return this.aPv;
    }

    public int Ij() {
        return this.aPx;
    }

    public void Ik() {
        if (this.aeB != null) {
            this.aeB = this.aeB.replaceAll("\n", "");
        }
        if (this.mLink != null) {
            this.mLink = this.mLink.replaceAll("\n", "");
        }
    }
}
