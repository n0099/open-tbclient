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
    private String alJ;
    private int cCA;
    private int cCx;
    private String cCy;
    private String cCz;
    private String mLink;
    private int mType;

    public TbRichTextCommInfo() {
        this.alJ = null;
        this.mLink = null;
        this.mType = 0;
        this.cCA = 0;
    }

    public TbRichTextCommInfo(JSONObject jSONObject) {
        this.alJ = null;
        this.mLink = null;
        this.mType = 0;
        this.cCA = 0;
        if (jSONObject != null) {
            this.alJ = jSONObject.optString("text");
            this.mLink = jSONObject.optString(SelectForumActivityConfig.KEY_SHARE_LINK);
            this.mType = jSONObject.optInt("type", 0);
            this.cCA = jSONObject.optInt("url_type", 0);
            this.cCx = jSONObject.optInt("is_native_app", 0);
            if (this.cCx == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.cCx = 0;
                    return;
                }
                this.cCy = jSONObject.optString("jump_and");
                this.cCz = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.cCy) || TextUtils.isEmpty(this.cCz)) {
                    this.cCx = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.cCy += ";download_url:" + this.cCz + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.cCy += ";download_url:" + this.cCz + ";web_play_url:" + this.alJ;
                }
                this.cCy += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(PbContent pbContent) {
        this.alJ = null;
        this.mLink = null;
        this.mType = 0;
        this.cCA = 0;
        if (pbContent != null) {
            this.alJ = pbContent.text;
            this.mLink = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.cCA = pbContent.url_type.intValue();
            this.cCx = pbContent.is_native_app.intValue();
            if (this.cCx == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.cCx = 0;
                    return;
                }
                this.cCy = nativeApp.jump_and;
                this.cCz = nativeApp.download_and;
                if (TextUtils.isEmpty(this.cCy) || TextUtils.isEmpty(this.cCz)) {
                    this.cCx = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.cCy += ";download_url:" + this.cCz + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.cCy += ";download_url:" + this.cCz + ";web_play_url:" + this.alJ;
                }
                this.cCy += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(String str, String str2) {
        this.alJ = null;
        this.mLink = null;
        this.mType = 0;
        this.cCA = 0;
        this.alJ = str;
        this.mLink = str2;
    }

    public void setText(String str) {
        this.alJ = str;
    }

    public void setLink(String str) {
        this.mLink = str;
    }

    public String getText() {
        return this.alJ;
    }

    public String getLink() {
        return this.mLink;
    }

    public int asy() {
        return this.cCx;
    }

    public String asz() {
        return this.cCy;
    }

    public int asA() {
        return this.cCA;
    }

    public void asB() {
        if (this.alJ != null) {
            this.alJ = this.alJ.replaceAll("\n", "");
        }
        if (this.mLink != null) {
            this.mLink = this.mLink.replaceAll("\n", "");
        }
    }
}
