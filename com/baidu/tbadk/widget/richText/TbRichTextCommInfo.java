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
    private String ama;
    private int cKJ;
    private String cKK;
    private String cKL;
    private int cKM;
    private String mLink;
    private int mType;

    public TbRichTextCommInfo() {
        this.ama = null;
        this.mLink = null;
        this.mType = 0;
        this.cKM = 0;
    }

    public TbRichTextCommInfo(JSONObject jSONObject) {
        this.ama = null;
        this.mLink = null;
        this.mType = 0;
        this.cKM = 0;
        if (jSONObject != null) {
            this.ama = jSONObject.optString("text");
            this.mLink = jSONObject.optString(SelectForumActivityConfig.KEY_SHARE_LINK);
            this.mType = jSONObject.optInt("type", 0);
            this.cKM = jSONObject.optInt("url_type", 0);
            this.cKJ = jSONObject.optInt("is_native_app", 0);
            if (this.cKJ == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.cKJ = 0;
                    return;
                }
                this.cKK = jSONObject.optString("jump_and");
                this.cKL = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.cKK) || TextUtils.isEmpty(this.cKL)) {
                    this.cKJ = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.cKK += ";download_url:" + this.cKL + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.cKK += ";download_url:" + this.cKL + ";web_play_url:" + this.ama;
                }
                this.cKK += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(PbContent pbContent) {
        this.ama = null;
        this.mLink = null;
        this.mType = 0;
        this.cKM = 0;
        if (pbContent != null) {
            this.ama = pbContent.text;
            this.mLink = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.cKM = pbContent.url_type.intValue();
            this.cKJ = pbContent.is_native_app.intValue();
            if (this.cKJ == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.cKJ = 0;
                    return;
                }
                this.cKK = nativeApp.jump_and;
                this.cKL = nativeApp.download_and;
                if (TextUtils.isEmpty(this.cKK) || TextUtils.isEmpty(this.cKL)) {
                    this.cKJ = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.cKK += ";download_url:" + this.cKL + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.cKK += ";download_url:" + this.cKL + ";web_play_url:" + this.ama;
                }
                this.cKK += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(String str, String str2) {
        this.ama = null;
        this.mLink = null;
        this.mType = 0;
        this.cKM = 0;
        this.ama = str;
        this.mLink = str2;
    }

    public void setText(String str) {
        this.ama = str;
    }

    public void setLink(String str) {
        this.mLink = str;
    }

    public String getText() {
        return this.ama;
    }

    public String getLink() {
        return this.mLink;
    }

    public int axB() {
        return this.cKJ;
    }

    public String axC() {
        return this.cKK;
    }

    public int axD() {
        return this.cKM;
    }

    public void axE() {
        if (this.ama != null) {
            this.ama = this.ama.replaceAll("\n", "");
        }
        if (this.mLink != null) {
            this.mLink = this.mLink.replaceAll("\n", "");
        }
    }
}
