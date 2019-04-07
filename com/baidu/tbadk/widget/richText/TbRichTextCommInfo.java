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
    private String alN;
    private String cCA;
    private String cCB;
    private int cCC;
    private int cCz;
    private String mLink;
    private int mType;

    public TbRichTextCommInfo() {
        this.alN = null;
        this.mLink = null;
        this.mType = 0;
        this.cCC = 0;
    }

    public TbRichTextCommInfo(JSONObject jSONObject) {
        this.alN = null;
        this.mLink = null;
        this.mType = 0;
        this.cCC = 0;
        if (jSONObject != null) {
            this.alN = jSONObject.optString("text");
            this.mLink = jSONObject.optString(SelectForumActivityConfig.KEY_SHARE_LINK);
            this.mType = jSONObject.optInt("type", 0);
            this.cCC = jSONObject.optInt("url_type", 0);
            this.cCz = jSONObject.optInt("is_native_app", 0);
            if (this.cCz == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.cCz = 0;
                    return;
                }
                this.cCA = jSONObject.optString("jump_and");
                this.cCB = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.cCA) || TextUtils.isEmpty(this.cCB)) {
                    this.cCz = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.cCA += ";download_url:" + this.cCB + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.cCA += ";download_url:" + this.cCB + ";web_play_url:" + this.alN;
                }
                this.cCA += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(PbContent pbContent) {
        this.alN = null;
        this.mLink = null;
        this.mType = 0;
        this.cCC = 0;
        if (pbContent != null) {
            this.alN = pbContent.text;
            this.mLink = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.cCC = pbContent.url_type.intValue();
            this.cCz = pbContent.is_native_app.intValue();
            if (this.cCz == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.cCz = 0;
                    return;
                }
                this.cCA = nativeApp.jump_and;
                this.cCB = nativeApp.download_and;
                if (TextUtils.isEmpty(this.cCA) || TextUtils.isEmpty(this.cCB)) {
                    this.cCz = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.cCA += ";download_url:" + this.cCB + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.cCA += ";download_url:" + this.cCB + ";web_play_url:" + this.alN;
                }
                this.cCA += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(String str, String str2) {
        this.alN = null;
        this.mLink = null;
        this.mType = 0;
        this.cCC = 0;
        this.alN = str;
        this.mLink = str2;
    }

    public void setText(String str) {
        this.alN = str;
    }

    public void setLink(String str) {
        this.mLink = str;
    }

    public String getText() {
        return this.alN;
    }

    public String getLink() {
        return this.mLink;
    }

    public int asv() {
        return this.cCz;
    }

    public String asw() {
        return this.cCA;
    }

    public int asx() {
        return this.cCC;
    }

    public void asy() {
        if (this.alN != null) {
            this.alN = this.alN.replaceAll("\n", "");
        }
        if (this.mLink != null) {
            this.mLink = this.mLink.replaceAll("\n", "");
        }
    }
}
