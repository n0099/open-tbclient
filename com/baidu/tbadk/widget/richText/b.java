package com.baidu.tbadk.widget.richText;

import android.text.TextUtils;
import org.json.JSONObject;
import tbclient.NativeApp;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.lib.a.b.a.a.i {
    private String ajI;
    private int ajJ;
    private String ajK;
    private String ajL;
    private String mText;
    private int mType;

    public b() {
        this.mText = null;
        this.ajI = null;
        this.mType = 0;
    }

    public b(JSONObject jSONObject) {
        this.mText = null;
        this.ajI = null;
        this.mType = 0;
        if (jSONObject != null) {
            this.mText = jSONObject.optString("text");
            this.ajI = jSONObject.optString("link");
            this.mType = jSONObject.optInt("type", 0);
            this.ajJ = jSONObject.optInt("is_native_app", 0);
            if (this.ajJ == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.ajJ = 0;
                    return;
                }
                this.ajK = jSONObject.optString("jump_and");
                this.ajL = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.ajK) || TextUtils.isEmpty(this.ajL)) {
                    this.ajJ = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.ajK = String.valueOf(this.ajK) + ";download_url:" + this.ajL + ";web_play_url:" + this.ajI;
                } else if (this.mType == 5) {
                    this.ajK = String.valueOf(this.ajK) + ";download_url:" + this.ajL + ";web_play_url:" + this.mText;
                }
                this.ajK = String.valueOf(this.ajK) + ";is_native_app=1";
            }
        }
    }

    public b(PbContent pbContent) {
        this.mText = null;
        this.ajI = null;
        this.mType = 0;
        if (pbContent != null) {
            this.mText = pbContent.text;
            this.ajI = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.ajJ = pbContent.is_native_app.intValue();
            if (this.ajJ == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.ajJ = 0;
                    return;
                }
                this.ajK = nativeApp.jump_and;
                this.ajL = nativeApp.download_and;
                if (TextUtils.isEmpty(this.ajK) || TextUtils.isEmpty(this.ajL)) {
                    this.ajJ = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.ajK = String.valueOf(this.ajK) + ";download_url:" + this.ajL + ";web_play_url:" + this.ajI;
                } else if (this.mType == 5) {
                    this.ajK = String.valueOf(this.ajK) + ";download_url:" + this.ajL + ";web_play_url:" + this.mText;
                }
                this.ajK = String.valueOf(this.ajK) + ";is_native_app=1";
            }
        }
    }

    public b(String str, String str2) {
        this.mText = null;
        this.ajI = null;
        this.mType = 0;
        this.mText = str;
        this.ajI = str2;
    }

    public void setText(String str) {
        this.mText = str;
    }

    public void setLink(String str) {
        this.ajI = str;
    }

    public String getText() {
        return this.mText;
    }

    public String getLink() {
        return this.ajI;
    }

    public int Ag() {
        return this.ajJ;
    }

    public String Ah() {
        return this.ajK;
    }

    public void Ai() {
        if (this.mText != null) {
            this.mText = this.mText.replaceAll("\n", "");
        }
        if (this.ajI != null) {
            this.ajI = this.ajI.replaceAll("\n", "");
        }
    }
}
