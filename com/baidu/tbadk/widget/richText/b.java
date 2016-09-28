package com.baidu.tbadk.widget.richText;

import android.text.TextUtils;
import org.json.JSONObject;
import tbclient.NativeApp;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.lib.a.b.a.a.i {
    private String ZC;
    private int aHX;
    private String aHY;
    private String aHZ;
    private String mLink;
    private int mType;

    public b() {
        this.ZC = null;
        this.mLink = null;
        this.mType = 0;
    }

    public b(JSONObject jSONObject) {
        this.ZC = null;
        this.mLink = null;
        this.mType = 0;
        if (jSONObject != null) {
            this.ZC = jSONObject.optString("text");
            this.mLink = jSONObject.optString("link");
            this.mType = jSONObject.optInt("type", 0);
            this.aHX = jSONObject.optInt("is_native_app", 0);
            if (this.aHX == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.aHX = 0;
                    return;
                }
                this.aHY = jSONObject.optString("jump_and");
                this.aHZ = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.aHY) || TextUtils.isEmpty(this.aHZ)) {
                    this.aHX = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aHY = String.valueOf(this.aHY) + ";download_url:" + this.aHZ + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aHY = String.valueOf(this.aHY) + ";download_url:" + this.aHZ + ";web_play_url:" + this.ZC;
                }
                this.aHY = String.valueOf(this.aHY) + ";is_native_app=1";
            }
        }
    }

    public b(PbContent pbContent) {
        this.ZC = null;
        this.mLink = null;
        this.mType = 0;
        if (pbContent != null) {
            this.ZC = pbContent.text;
            this.mLink = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.aHX = pbContent.is_native_app.intValue();
            if (this.aHX == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.aHX = 0;
                    return;
                }
                this.aHY = nativeApp.jump_and;
                this.aHZ = nativeApp.download_and;
                if (TextUtils.isEmpty(this.aHY) || TextUtils.isEmpty(this.aHZ)) {
                    this.aHX = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aHY = String.valueOf(this.aHY) + ";download_url:" + this.aHZ + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aHY = String.valueOf(this.aHY) + ";download_url:" + this.aHZ + ";web_play_url:" + this.ZC;
                }
                this.aHY = String.valueOf(this.aHY) + ";is_native_app=1";
            }
        }
    }

    public b(String str, String str2) {
        this.ZC = null;
        this.mLink = null;
        this.mType = 0;
        this.ZC = str;
        this.mLink = str2;
    }

    public void setText(String str) {
        this.ZC = str;
    }

    public void setLink(String str) {
        this.mLink = str;
    }

    public String getText() {
        return this.ZC;
    }

    public String getLink() {
        return this.mLink;
    }

    public int Ia() {
        return this.aHX;
    }

    public String Ib() {
        return this.aHY;
    }

    public void Ic() {
        if (this.ZC != null) {
            this.ZC = this.ZC.replaceAll("\n", "");
        }
        if (this.mLink != null) {
            this.mLink = this.mLink.replaceAll("\n", "");
        }
    }
}
