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
    private int brJ;
    private String brK;
    private String brL;
    private int brM;
    private String mLink;
    private String mText;
    private int mType;

    public TbRichTextCommInfo() {
        this.mText = null;
        this.mLink = null;
        this.mType = 0;
        this.brM = 0;
    }

    public TbRichTextCommInfo(JSONObject jSONObject) {
        this.mText = null;
        this.mLink = null;
        this.mType = 0;
        this.brM = 0;
        if (jSONObject != null) {
            this.mText = jSONObject.optString("text");
            this.mLink = jSONObject.optString(SelectForumActivityConfig.KEY_SHARE_LINK);
            this.mType = jSONObject.optInt("type", 0);
            this.brM = jSONObject.optInt("url_type", 0);
            this.brJ = jSONObject.optInt("is_native_app", 0);
            if (this.brJ == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.brJ = 0;
                    return;
                }
                this.brK = jSONObject.optString("jump_and");
                this.brL = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.brK) || TextUtils.isEmpty(this.brL)) {
                    this.brJ = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.brK += ";download_url:" + this.brL + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.brK += ";download_url:" + this.brL + ";web_play_url:" + this.mText;
                }
                this.brK += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(PbContent pbContent) {
        this.mText = null;
        this.mLink = null;
        this.mType = 0;
        this.brM = 0;
        if (pbContent != null) {
            this.mText = pbContent.text;
            this.mLink = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.brM = pbContent.url_type.intValue();
            this.brJ = pbContent.is_native_app.intValue();
            if (this.brJ == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.brJ = 0;
                    return;
                }
                this.brK = nativeApp.jump_and;
                this.brL = nativeApp.download_and;
                if (TextUtils.isEmpty(this.brK) || TextUtils.isEmpty(this.brL)) {
                    this.brJ = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.brK += ";download_url:" + this.brL + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.brK += ";download_url:" + this.brL + ";web_play_url:" + this.mText;
                }
                this.brK += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(String str, String str2) {
        this.mText = null;
        this.mLink = null;
        this.mType = 0;
        this.brM = 0;
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

    public int Sy() {
        return this.brJ;
    }

    public String Sz() {
        return this.brK;
    }

    public int SA() {
        return this.brM;
    }

    public void SB() {
        if (this.mText != null) {
            this.mText = this.mText.replaceAll("\n", "");
        }
        if (this.mLink != null) {
            this.mLink = this.mLink.replaceAll("\n", "");
        }
    }
}
