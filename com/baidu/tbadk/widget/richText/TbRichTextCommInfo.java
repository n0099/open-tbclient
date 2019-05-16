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
    private int cKI;
    private String cKJ;
    private String cKK;
    private int cKL;
    private String mLink;
    private int mType;

    public TbRichTextCommInfo() {
        this.ama = null;
        this.mLink = null;
        this.mType = 0;
        this.cKL = 0;
    }

    public TbRichTextCommInfo(JSONObject jSONObject) {
        this.ama = null;
        this.mLink = null;
        this.mType = 0;
        this.cKL = 0;
        if (jSONObject != null) {
            this.ama = jSONObject.optString("text");
            this.mLink = jSONObject.optString(SelectForumActivityConfig.KEY_SHARE_LINK);
            this.mType = jSONObject.optInt("type", 0);
            this.cKL = jSONObject.optInt("url_type", 0);
            this.cKI = jSONObject.optInt("is_native_app", 0);
            if (this.cKI == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.cKI = 0;
                    return;
                }
                this.cKJ = jSONObject.optString("jump_and");
                this.cKK = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.cKJ) || TextUtils.isEmpty(this.cKK)) {
                    this.cKI = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.cKJ += ";download_url:" + this.cKK + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.cKJ += ";download_url:" + this.cKK + ";web_play_url:" + this.ama;
                }
                this.cKJ += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(PbContent pbContent) {
        this.ama = null;
        this.mLink = null;
        this.mType = 0;
        this.cKL = 0;
        if (pbContent != null) {
            this.ama = pbContent.text;
            this.mLink = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.cKL = pbContent.url_type.intValue();
            this.cKI = pbContent.is_native_app.intValue();
            if (this.cKI == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.cKI = 0;
                    return;
                }
                this.cKJ = nativeApp.jump_and;
                this.cKK = nativeApp.download_and;
                if (TextUtils.isEmpty(this.cKJ) || TextUtils.isEmpty(this.cKK)) {
                    this.cKI = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.cKJ += ";download_url:" + this.cKK + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.cKJ += ";download_url:" + this.cKK + ";web_play_url:" + this.ama;
                }
                this.cKJ += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(String str, String str2) {
        this.ama = null;
        this.mLink = null;
        this.mType = 0;
        this.cKL = 0;
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

    public int axA() {
        return this.cKI;
    }

    public String axB() {
        return this.cKJ;
    }

    public int axC() {
        return this.cKL;
    }

    public void axD() {
        if (this.ama != null) {
            this.ama = this.ama.replaceAll("\n", "");
        }
        if (this.mLink != null) {
            this.mLink = this.mLink.replaceAll("\n", "");
        }
    }
}
