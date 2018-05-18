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
    private int aVE;
    private String aVF;
    private String aVG;
    private int aVH;
    private String agh;
    private String mLink;
    private int mType;

    public TbRichTextCommInfo() {
        this.agh = null;
        this.mLink = null;
        this.mType = 0;
        this.aVH = 0;
    }

    public TbRichTextCommInfo(JSONObject jSONObject) {
        this.agh = null;
        this.mLink = null;
        this.mType = 0;
        this.aVH = 0;
        if (jSONObject != null) {
            this.agh = jSONObject.optString("text");
            this.mLink = jSONObject.optString("link");
            this.mType = jSONObject.optInt("type", 0);
            this.aVH = jSONObject.optInt("url_type", 0);
            this.aVE = jSONObject.optInt("is_native_app", 0);
            if (this.aVE == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.aVE = 0;
                    return;
                }
                this.aVF = jSONObject.optString("jump_and");
                this.aVG = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.aVF) || TextUtils.isEmpty(this.aVG)) {
                    this.aVE = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aVF += ";download_url:" + this.aVG + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aVF += ";download_url:" + this.aVG + ";web_play_url:" + this.agh;
                }
                this.aVF += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(PbContent pbContent) {
        this.agh = null;
        this.mLink = null;
        this.mType = 0;
        this.aVH = 0;
        if (pbContent != null) {
            this.agh = pbContent.text;
            this.mLink = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.aVH = pbContent.url_type.intValue();
            this.aVE = pbContent.is_native_app.intValue();
            if (this.aVE == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.aVE = 0;
                    return;
                }
                this.aVF = nativeApp.jump_and;
                this.aVG = nativeApp.download_and;
                if (TextUtils.isEmpty(this.aVF) || TextUtils.isEmpty(this.aVG)) {
                    this.aVE = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aVF += ";download_url:" + this.aVG + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aVF += ";download_url:" + this.aVG + ";web_play_url:" + this.agh;
                }
                this.aVF += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(String str, String str2) {
        this.agh = null;
        this.mLink = null;
        this.mType = 0;
        this.aVH = 0;
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

    public int JI() {
        return this.aVE;
    }

    public String JJ() {
        return this.aVF;
    }

    public int JK() {
        return this.aVH;
    }

    public void JL() {
        if (this.agh != null) {
            this.agh = this.agh.replaceAll("\n", "");
        }
        if (this.mLink != null) {
            this.mLink = this.mLink.replaceAll("\n", "");
        }
    }
}
