package com.baidu.tbadk.widget.richText;

import android.text.TextUtils;
import org.json.JSONObject;
import tbclient.NativeApp;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.lib.a.b.a.a.i {
    private String ajF;
    private int ajG;
    private String ajH;
    private String ajI;
    private String mText;
    private int mType;

    public b() {
        this.mText = null;
        this.ajF = null;
        this.mType = 0;
    }

    public b(JSONObject jSONObject) {
        this.mText = null;
        this.ajF = null;
        this.mType = 0;
        if (jSONObject != null) {
            this.mText = jSONObject.optString("text");
            this.ajF = jSONObject.optString("link");
            this.mType = jSONObject.optInt("type", 0);
            this.ajG = jSONObject.optInt("is_native_app", 0);
            if (this.ajG == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.ajG = 0;
                    return;
                }
                this.ajH = jSONObject.optString("jump_and");
                this.ajI = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.ajH) || TextUtils.isEmpty(this.ajI)) {
                    this.ajG = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.ajH = String.valueOf(this.ajH) + ";download_url:" + this.ajI + ";web_play_url:" + this.ajF;
                } else if (this.mType == 5) {
                    this.ajH = String.valueOf(this.ajH) + ";download_url:" + this.ajI + ";web_play_url:" + this.mText;
                }
                this.ajH = String.valueOf(this.ajH) + ";is_native_app=1";
            }
        }
    }

    public b(PbContent pbContent) {
        this.mText = null;
        this.ajF = null;
        this.mType = 0;
        if (pbContent != null) {
            this.mText = pbContent.text;
            this.ajF = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.ajG = pbContent.is_native_app.intValue();
            if (this.ajG == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.ajG = 0;
                    return;
                }
                this.ajH = nativeApp.jump_and;
                this.ajI = nativeApp.download_and;
                if (TextUtils.isEmpty(this.ajH) || TextUtils.isEmpty(this.ajI)) {
                    this.ajG = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.ajH = String.valueOf(this.ajH) + ";download_url:" + this.ajI + ";web_play_url:" + this.ajF;
                } else if (this.mType == 5) {
                    this.ajH = String.valueOf(this.ajH) + ";download_url:" + this.ajI + ";web_play_url:" + this.mText;
                }
                this.ajH = String.valueOf(this.ajH) + ";is_native_app=1";
            }
        }
    }

    public b(String str, String str2) {
        this.mText = null;
        this.ajF = null;
        this.mType = 0;
        this.mText = str;
        this.ajF = str2;
    }

    public void setText(String str) {
        this.mText = str;
    }

    public void setLink(String str) {
        this.ajF = str;
    }

    public String getText() {
        return this.mText;
    }

    public String getLink() {
        return this.ajF;
    }

    public int Aa() {
        return this.ajG;
    }

    public String Ab() {
        return this.ajH;
    }

    public void Ac() {
        if (this.mText != null) {
            this.mText = this.mText.replaceAll("\n", "");
        }
        if (this.ajF != null) {
            this.ajF = this.ajF.replaceAll("\n", "");
        }
    }
}
