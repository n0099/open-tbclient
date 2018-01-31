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
    private String aTs;
    private int bIT;
    private String bIU;
    private String bIV;
    private int bIW;
    private String mLink;
    private int mType;

    public TbRichTextCommInfo() {
        this.aTs = null;
        this.mLink = null;
        this.mType = 0;
        this.bIW = 0;
    }

    public TbRichTextCommInfo(JSONObject jSONObject) {
        this.aTs = null;
        this.mLink = null;
        this.mType = 0;
        this.bIW = 0;
        if (jSONObject != null) {
            this.aTs = jSONObject.optString("text");
            this.mLink = jSONObject.optString("link");
            this.mType = jSONObject.optInt("type", 0);
            this.bIW = jSONObject.optInt("url_type", 0);
            this.bIT = jSONObject.optInt("is_native_app", 0);
            if (this.bIT == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.bIT = 0;
                    return;
                }
                this.bIU = jSONObject.optString("jump_and");
                this.bIV = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.bIU) || TextUtils.isEmpty(this.bIV)) {
                    this.bIT = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.bIU += ";download_url:" + this.bIV + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.bIU += ";download_url:" + this.bIV + ";web_play_url:" + this.aTs;
                }
                this.bIU += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(PbContent pbContent) {
        this.aTs = null;
        this.mLink = null;
        this.mType = 0;
        this.bIW = 0;
        if (pbContent != null) {
            this.aTs = pbContent.text;
            this.mLink = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.bIW = pbContent.url_type.intValue();
            this.bIT = pbContent.is_native_app.intValue();
            if (this.bIT == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.bIT = 0;
                    return;
                }
                this.bIU = nativeApp.jump_and;
                this.bIV = nativeApp.download_and;
                if (TextUtils.isEmpty(this.bIU) || TextUtils.isEmpty(this.bIV)) {
                    this.bIT = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.bIU += ";download_url:" + this.bIV + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.bIU += ";download_url:" + this.bIV + ";web_play_url:" + this.aTs;
                }
                this.bIU += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(String str, String str2) {
        this.aTs = null;
        this.mLink = null;
        this.mType = 0;
        this.bIW = 0;
        this.aTs = str;
        this.mLink = str2;
    }

    public void setText(String str) {
        this.aTs = str;
    }

    public void setLink(String str) {
        this.mLink = str;
    }

    public String getText() {
        return this.aTs;
    }

    public String getLink() {
        return this.mLink;
    }

    public int QE() {
        return this.bIT;
    }

    public String QF() {
        return this.bIU;
    }

    public int QG() {
        return this.bIW;
    }

    public void QH() {
        if (this.aTs != null) {
            this.aTs = this.aTs.replaceAll("\n", "");
        }
        if (this.mLink != null) {
            this.mLink = this.mLink.replaceAll("\n", "");
        }
    }
}
