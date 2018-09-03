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
    private String aop;
    private int bfj;
    private String bfk;
    private String bfl;
    private int bfm;
    private String mLink;
    private int mType;

    public TbRichTextCommInfo() {
        this.aop = null;
        this.mLink = null;
        this.mType = 0;
        this.bfm = 0;
    }

    public TbRichTextCommInfo(JSONObject jSONObject) {
        this.aop = null;
        this.mLink = null;
        this.mType = 0;
        this.bfm = 0;
        if (jSONObject != null) {
            this.aop = jSONObject.optString("text");
            this.mLink = jSONObject.optString("link");
            this.mType = jSONObject.optInt("type", 0);
            this.bfm = jSONObject.optInt("url_type", 0);
            this.bfj = jSONObject.optInt("is_native_app", 0);
            if (this.bfj == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.bfj = 0;
                    return;
                }
                this.bfk = jSONObject.optString("jump_and");
                this.bfl = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.bfk) || TextUtils.isEmpty(this.bfl)) {
                    this.bfj = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.bfk += ";download_url:" + this.bfl + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.bfk += ";download_url:" + this.bfl + ";web_play_url:" + this.aop;
                }
                this.bfk += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(PbContent pbContent) {
        this.aop = null;
        this.mLink = null;
        this.mType = 0;
        this.bfm = 0;
        if (pbContent != null) {
            this.aop = pbContent.text;
            this.mLink = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.bfm = pbContent.url_type.intValue();
            this.bfj = pbContent.is_native_app.intValue();
            if (this.bfj == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.bfj = 0;
                    return;
                }
                this.bfk = nativeApp.jump_and;
                this.bfl = nativeApp.download_and;
                if (TextUtils.isEmpty(this.bfk) || TextUtils.isEmpty(this.bfl)) {
                    this.bfj = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.bfk += ";download_url:" + this.bfl + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.bfk += ";download_url:" + this.bfl + ";web_play_url:" + this.aop;
                }
                this.bfk += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(String str, String str2) {
        this.aop = null;
        this.mLink = null;
        this.mType = 0;
        this.bfm = 0;
        this.aop = str;
        this.mLink = str2;
    }

    public void setText(String str) {
        this.aop = str;
    }

    public void setLink(String str) {
        this.mLink = str;
    }

    public String getText() {
        return this.aop;
    }

    public String getLink() {
        return this.mLink;
    }

    public int Nx() {
        return this.bfj;
    }

    public String Ny() {
        return this.bfk;
    }

    public int Nz() {
        return this.bfm;
    }

    public void NA() {
        if (this.aop != null) {
            this.aop = this.aop.replaceAll("\n", "");
        }
        if (this.mLink != null) {
            this.mLink = this.mLink.replaceAll("\n", "");
        }
    }
}
