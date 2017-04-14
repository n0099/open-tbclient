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
    private int aMF;
    private String aMG;
    private String aMH;
    private int aMI;
    private String ael;
    private String mLink;
    private int mType;

    public TbRichTextCommInfo() {
        this.ael = null;
        this.mLink = null;
        this.mType = 0;
        this.aMI = 0;
    }

    public TbRichTextCommInfo(JSONObject jSONObject) {
        this.ael = null;
        this.mLink = null;
        this.mType = 0;
        this.aMI = 0;
        if (jSONObject != null) {
            this.ael = jSONObject.optString("text");
            this.mLink = jSONObject.optString("link");
            this.mType = jSONObject.optInt("type", 0);
            this.aMI = jSONObject.optInt("url_type", 0);
            this.aMF = jSONObject.optInt("is_native_app", 0);
            if (this.aMF == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.aMF = 0;
                    return;
                }
                this.aMG = jSONObject.optString("jump_and");
                this.aMH = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.aMG) || TextUtils.isEmpty(this.aMH)) {
                    this.aMF = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aMG = String.valueOf(this.aMG) + ";download_url:" + this.aMH + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aMG = String.valueOf(this.aMG) + ";download_url:" + this.aMH + ";web_play_url:" + this.ael;
                }
                this.aMG = String.valueOf(this.aMG) + ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(PbContent pbContent) {
        this.ael = null;
        this.mLink = null;
        this.mType = 0;
        this.aMI = 0;
        if (pbContent != null) {
            this.ael = pbContent.text;
            this.mLink = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.aMI = pbContent.url_type.intValue();
            this.aMF = pbContent.is_native_app.intValue();
            if (this.aMF == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.aMF = 0;
                    return;
                }
                this.aMG = nativeApp.jump_and;
                this.aMH = nativeApp.download_and;
                if (TextUtils.isEmpty(this.aMG) || TextUtils.isEmpty(this.aMH)) {
                    this.aMF = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aMG = String.valueOf(this.aMG) + ";download_url:" + this.aMH + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aMG = String.valueOf(this.aMG) + ";download_url:" + this.aMH + ";web_play_url:" + this.ael;
                }
                this.aMG = String.valueOf(this.aMG) + ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(String str, String str2) {
        this.ael = null;
        this.mLink = null;
        this.mType = 0;
        this.aMI = 0;
        this.ael = str;
        this.mLink = str2;
    }

    public void setText(String str) {
        this.ael = str;
    }

    public void setLink(String str) {
        this.mLink = str;
    }

    public String getText() {
        return this.ael;
    }

    public String getLink() {
        return this.mLink;
    }

    public int Ip() {
        return this.aMF;
    }

    public String Iq() {
        return this.aMG;
    }

    public int Ir() {
        return this.aMI;
    }

    public void Is() {
        if (this.ael != null) {
            this.ael = this.ael.replaceAll("\n", "");
        }
        if (this.mLink != null) {
            this.mLink = this.mLink.replaceAll("\n", "");
        }
    }
}
