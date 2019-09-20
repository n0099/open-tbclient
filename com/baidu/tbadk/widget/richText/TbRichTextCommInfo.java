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
    private String anb;
    private int cNa;
    private String cNb;
    private String cNc;
    private int cNd;
    private String mLink;
    private int mType;

    public TbRichTextCommInfo() {
        this.anb = null;
        this.mLink = null;
        this.mType = 0;
        this.cNd = 0;
    }

    public TbRichTextCommInfo(JSONObject jSONObject) {
        this.anb = null;
        this.mLink = null;
        this.mType = 0;
        this.cNd = 0;
        if (jSONObject != null) {
            this.anb = jSONObject.optString("text");
            this.mLink = jSONObject.optString(SelectForumActivityConfig.KEY_SHARE_LINK);
            this.mType = jSONObject.optInt("type", 0);
            this.cNd = jSONObject.optInt("url_type", 0);
            this.cNa = jSONObject.optInt("is_native_app", 0);
            if (this.cNa == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.cNa = 0;
                    return;
                }
                this.cNb = jSONObject.optString("jump_and");
                this.cNc = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.cNb) || TextUtils.isEmpty(this.cNc)) {
                    this.cNa = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.cNb += ";download_url:" + this.cNc + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.cNb += ";download_url:" + this.cNc + ";web_play_url:" + this.anb;
                }
                this.cNb += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(PbContent pbContent) {
        this.anb = null;
        this.mLink = null;
        this.mType = 0;
        this.cNd = 0;
        if (pbContent != null) {
            this.anb = pbContent.text;
            this.mLink = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.cNd = pbContent.url_type.intValue();
            this.cNa = pbContent.is_native_app.intValue();
            if (this.cNa == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.cNa = 0;
                    return;
                }
                this.cNb = nativeApp.jump_and;
                this.cNc = nativeApp.download_and;
                if (TextUtils.isEmpty(this.cNb) || TextUtils.isEmpty(this.cNc)) {
                    this.cNa = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.cNb += ";download_url:" + this.cNc + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.cNb += ";download_url:" + this.cNc + ";web_play_url:" + this.anb;
                }
                this.cNb += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(String str, String str2) {
        this.anb = null;
        this.mLink = null;
        this.mType = 0;
        this.cNd = 0;
        this.anb = str;
        this.mLink = str2;
    }

    public void setText(String str) {
        this.anb = str;
    }

    public void setLink(String str) {
        this.mLink = str;
    }

    public String getText() {
        return this.anb;
    }

    public String getLink() {
        return this.mLink;
    }

    public int azb() {
        return this.cNa;
    }

    public String azc() {
        return this.cNb;
    }

    public int azd() {
        return this.cNd;
    }

    public void aze() {
        if (this.anb != null) {
            this.anb = this.anb.replaceAll("\n", "");
        }
        if (this.mLink != null) {
            this.mLink = this.mLink.replaceAll("\n", "");
        }
    }
}
