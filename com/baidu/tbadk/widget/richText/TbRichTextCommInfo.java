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
    private int aMY;
    private String aMZ;
    private String aNa;
    private int aNb;
    private String adE;
    private String mLink;
    private int mType;

    public TbRichTextCommInfo() {
        this.adE = null;
        this.mLink = null;
        this.mType = 0;
        this.aNb = 0;
    }

    public TbRichTextCommInfo(JSONObject jSONObject) {
        this.adE = null;
        this.mLink = null;
        this.mType = 0;
        this.aNb = 0;
        if (jSONObject != null) {
            this.adE = jSONObject.optString("text");
            this.mLink = jSONObject.optString("link");
            this.mType = jSONObject.optInt("type", 0);
            this.aNb = jSONObject.optInt("url_type", 0);
            this.aMY = jSONObject.optInt("is_native_app", 0);
            if (this.aMY == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.aMY = 0;
                    return;
                }
                this.aMZ = jSONObject.optString("jump_and");
                this.aNa = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.aMZ) || TextUtils.isEmpty(this.aNa)) {
                    this.aMY = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aMZ = String.valueOf(this.aMZ) + ";download_url:" + this.aNa + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aMZ = String.valueOf(this.aMZ) + ";download_url:" + this.aNa + ";web_play_url:" + this.adE;
                }
                this.aMZ = String.valueOf(this.aMZ) + ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(PbContent pbContent) {
        this.adE = null;
        this.mLink = null;
        this.mType = 0;
        this.aNb = 0;
        if (pbContent != null) {
            this.adE = pbContent.text;
            this.mLink = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.aNb = pbContent.url_type.intValue();
            this.aMY = pbContent.is_native_app.intValue();
            if (this.aMY == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.aMY = 0;
                    return;
                }
                this.aMZ = nativeApp.jump_and;
                this.aNa = nativeApp.download_and;
                if (TextUtils.isEmpty(this.aMZ) || TextUtils.isEmpty(this.aNa)) {
                    this.aMY = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aMZ = String.valueOf(this.aMZ) + ";download_url:" + this.aNa + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aMZ = String.valueOf(this.aMZ) + ";download_url:" + this.aNa + ";web_play_url:" + this.adE;
                }
                this.aMZ = String.valueOf(this.aMZ) + ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(String str, String str2) {
        this.adE = null;
        this.mLink = null;
        this.mType = 0;
        this.aNb = 0;
        this.adE = str;
        this.mLink = str2;
    }

    public void setText(String str) {
        this.adE = str;
    }

    public void setLink(String str) {
        this.mLink = str;
    }

    public String getText() {
        return this.adE;
    }

    public String getLink() {
        return this.mLink;
    }

    public int HD() {
        return this.aMY;
    }

    public String HE() {
        return this.aMZ;
    }

    public int HF() {
        return this.aNb;
    }

    public void HG() {
        if (this.adE != null) {
            this.adE = this.adE.replaceAll("\n", "");
        }
        if (this.mLink != null) {
            this.mLink = this.mLink.replaceAll("\n", "");
        }
    }
}
