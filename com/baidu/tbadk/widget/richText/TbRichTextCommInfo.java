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
    private String amD;
    private int cMd;
    private String cMe;
    private String cMf;
    private int cMg;
    private String mLink;
    private int mType;

    public TbRichTextCommInfo() {
        this.amD = null;
        this.mLink = null;
        this.mType = 0;
        this.cMg = 0;
    }

    public TbRichTextCommInfo(JSONObject jSONObject) {
        this.amD = null;
        this.mLink = null;
        this.mType = 0;
        this.cMg = 0;
        if (jSONObject != null) {
            this.amD = jSONObject.optString("text");
            this.mLink = jSONObject.optString(SelectForumActivityConfig.KEY_SHARE_LINK);
            this.mType = jSONObject.optInt("type", 0);
            this.cMg = jSONObject.optInt("url_type", 0);
            this.cMd = jSONObject.optInt("is_native_app", 0);
            if (this.cMd == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.cMd = 0;
                    return;
                }
                this.cMe = jSONObject.optString("jump_and");
                this.cMf = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.cMe) || TextUtils.isEmpty(this.cMf)) {
                    this.cMd = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.cMe += ";download_url:" + this.cMf + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.cMe += ";download_url:" + this.cMf + ";web_play_url:" + this.amD;
                }
                this.cMe += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(PbContent pbContent) {
        this.amD = null;
        this.mLink = null;
        this.mType = 0;
        this.cMg = 0;
        if (pbContent != null) {
            this.amD = pbContent.text;
            this.mLink = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.cMg = pbContent.url_type.intValue();
            this.cMd = pbContent.is_native_app.intValue();
            if (this.cMd == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.cMd = 0;
                    return;
                }
                this.cMe = nativeApp.jump_and;
                this.cMf = nativeApp.download_and;
                if (TextUtils.isEmpty(this.cMe) || TextUtils.isEmpty(this.cMf)) {
                    this.cMd = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.cMe += ";download_url:" + this.cMf + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.cMe += ";download_url:" + this.cMf + ";web_play_url:" + this.amD;
                }
                this.cMe += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(String str, String str2) {
        this.amD = null;
        this.mLink = null;
        this.mType = 0;
        this.cMg = 0;
        this.amD = str;
        this.mLink = str2;
    }

    public void setText(String str) {
        this.amD = str;
    }

    public void setLink(String str) {
        this.mLink = str;
    }

    public String getText() {
        return this.amD;
    }

    public String getLink() {
        return this.mLink;
    }

    public int ayN() {
        return this.cMd;
    }

    public String ayO() {
        return this.cMe;
    }

    public int ayP() {
        return this.cMg;
    }

    public void ayQ() {
        if (this.amD != null) {
            this.amD = this.amD.replaceAll("\n", "");
        }
        if (this.mLink != null) {
            this.mLink = this.mLink.replaceAll("\n", "");
        }
    }
}
