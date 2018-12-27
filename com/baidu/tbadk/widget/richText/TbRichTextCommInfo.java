package com.baidu.tbadk.widget.richText;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
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
    private int bqV;
    private String bqW;
    private String bqX;
    private int bqY;
    private String mLink;
    private String mText;
    private int mType;

    public TbRichTextCommInfo() {
        this.mText = null;
        this.mLink = null;
        this.mType = 0;
        this.bqY = 0;
    }

    public TbRichTextCommInfo(JSONObject jSONObject) {
        this.mText = null;
        this.mLink = null;
        this.mType = 0;
        this.bqY = 0;
        if (jSONObject != null) {
            this.mText = jSONObject.optString("text");
            this.mLink = jSONObject.optString(SelectForumActivityConfig.KEY_SHARE_LINK);
            this.mType = jSONObject.optInt("type", 0);
            this.bqY = jSONObject.optInt("url_type", 0);
            this.bqV = jSONObject.optInt("is_native_app", 0);
            if (this.bqV == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.bqV = 0;
                    return;
                }
                this.bqW = jSONObject.optString("jump_and");
                this.bqX = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.bqW) || TextUtils.isEmpty(this.bqX)) {
                    this.bqV = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.bqW += ";download_url:" + this.bqX + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.bqW += ";download_url:" + this.bqX + ";web_play_url:" + this.mText;
                }
                this.bqW += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(PbContent pbContent) {
        this.mText = null;
        this.mLink = null;
        this.mType = 0;
        this.bqY = 0;
        if (pbContent != null) {
            this.mText = pbContent.text;
            this.mLink = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.bqY = pbContent.url_type.intValue();
            this.bqV = pbContent.is_native_app.intValue();
            if (this.bqV == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.bqV = 0;
                    return;
                }
                this.bqW = nativeApp.jump_and;
                this.bqX = nativeApp.download_and;
                if (TextUtils.isEmpty(this.bqW) || TextUtils.isEmpty(this.bqX)) {
                    this.bqV = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.bqW += ";download_url:" + this.bqX + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.bqW += ";download_url:" + this.bqX + ";web_play_url:" + this.mText;
                }
                this.bqW += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(String str, String str2) {
        this.mText = null;
        this.mLink = null;
        this.mType = 0;
        this.bqY = 0;
        this.mText = str;
        this.mLink = str2;
    }

    public void setText(String str) {
        this.mText = str;
    }

    public void setLink(String str) {
        this.mLink = str;
    }

    public String getText() {
        return this.mText;
    }

    public String getLink() {
        return this.mLink;
    }

    public int Sc() {
        return this.bqV;
    }

    public String Sd() {
        return this.bqW;
    }

    public int Se() {
        return this.bqY;
    }

    public void Sf() {
        if (this.mText != null) {
            this.mText = this.mText.replaceAll("\n", "");
        }
        if (this.mLink != null) {
            this.mLink = this.mLink.replaceAll("\n", "");
        }
    }
}
