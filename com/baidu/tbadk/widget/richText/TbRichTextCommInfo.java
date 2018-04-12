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
    private int aVD;
    private String aVE;
    private String aVF;
    private int aVG;
    private String agh;
    private String mLink;
    private int mType;

    public TbRichTextCommInfo() {
        this.agh = null;
        this.mLink = null;
        this.mType = 0;
        this.aVG = 0;
    }

    public TbRichTextCommInfo(JSONObject jSONObject) {
        this.agh = null;
        this.mLink = null;
        this.mType = 0;
        this.aVG = 0;
        if (jSONObject != null) {
            this.agh = jSONObject.optString("text");
            this.mLink = jSONObject.optString("link");
            this.mType = jSONObject.optInt("type", 0);
            this.aVG = jSONObject.optInt("url_type", 0);
            this.aVD = jSONObject.optInt("is_native_app", 0);
            if (this.aVD == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.aVD = 0;
                    return;
                }
                this.aVE = jSONObject.optString("jump_and");
                this.aVF = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.aVE) || TextUtils.isEmpty(this.aVF)) {
                    this.aVD = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aVE += ";download_url:" + this.aVF + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aVE += ";download_url:" + this.aVF + ";web_play_url:" + this.agh;
                }
                this.aVE += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(PbContent pbContent) {
        this.agh = null;
        this.mLink = null;
        this.mType = 0;
        this.aVG = 0;
        if (pbContent != null) {
            this.agh = pbContent.text;
            this.mLink = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.aVG = pbContent.url_type.intValue();
            this.aVD = pbContent.is_native_app.intValue();
            if (this.aVD == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.aVD = 0;
                    return;
                }
                this.aVE = nativeApp.jump_and;
                this.aVF = nativeApp.download_and;
                if (TextUtils.isEmpty(this.aVE) || TextUtils.isEmpty(this.aVF)) {
                    this.aVD = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aVE += ";download_url:" + this.aVF + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aVE += ";download_url:" + this.aVF + ";web_play_url:" + this.agh;
                }
                this.aVE += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(String str, String str2) {
        this.agh = null;
        this.mLink = null;
        this.mType = 0;
        this.aVG = 0;
        this.agh = str;
        this.mLink = str2;
    }

    public void setText(String str) {
        this.agh = str;
    }

    public void setLink(String str) {
        this.mLink = str;
    }

    public String getText() {
        return this.agh;
    }

    public String getLink() {
        return this.mLink;
    }

    public int JK() {
        return this.aVD;
    }

    public String JL() {
        return this.aVE;
    }

    public int JM() {
        return this.aVG;
    }

    public void JN() {
        if (this.agh != null) {
            this.agh = this.agh.replaceAll("\n", "");
        }
        if (this.mLink != null) {
            this.mLink = this.mLink.replaceAll("\n", "");
        }
    }
}
