package com.baidu.tbadk.widget.richText;

import android.text.TextUtils;
import org.json.JSONObject;
import tbclient.NativeApp;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.lib.a.b.a.a.i {
    private int aEq;
    private String aEr;
    private String aEs;
    private String aav;
    private String mLink;
    private int mType;

    public b() {
        this.aav = null;
        this.mLink = null;
        this.mType = 0;
    }

    public b(JSONObject jSONObject) {
        this.aav = null;
        this.mLink = null;
        this.mType = 0;
        if (jSONObject != null) {
            this.aav = jSONObject.optString("text");
            this.mLink = jSONObject.optString("link");
            this.mType = jSONObject.optInt("type", 0);
            this.aEq = jSONObject.optInt("is_native_app", 0);
            if (this.aEq == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.aEq = 0;
                    return;
                }
                this.aEr = jSONObject.optString("jump_and");
                this.aEs = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.aEr) || TextUtils.isEmpty(this.aEs)) {
                    this.aEq = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aEr = String.valueOf(this.aEr) + ";download_url:" + this.aEs + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aEr = String.valueOf(this.aEr) + ";download_url:" + this.aEs + ";web_play_url:" + this.aav;
                }
                this.aEr = String.valueOf(this.aEr) + ";is_native_app=1";
            }
        }
    }

    public b(PbContent pbContent) {
        this.aav = null;
        this.mLink = null;
        this.mType = 0;
        if (pbContent != null) {
            this.aav = pbContent.text;
            this.mLink = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.aEq = pbContent.is_native_app.intValue();
            if (this.aEq == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.aEq = 0;
                    return;
                }
                this.aEr = nativeApp.jump_and;
                this.aEs = nativeApp.download_and;
                if (TextUtils.isEmpty(this.aEr) || TextUtils.isEmpty(this.aEs)) {
                    this.aEq = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aEr = String.valueOf(this.aEr) + ";download_url:" + this.aEs + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aEr = String.valueOf(this.aEr) + ";download_url:" + this.aEs + ";web_play_url:" + this.aav;
                }
                this.aEr = String.valueOf(this.aEr) + ";is_native_app=1";
            }
        }
    }

    public b(String str, String str2) {
        this.aav = null;
        this.mLink = null;
        this.mType = 0;
        this.aav = str;
        this.mLink = str2;
    }

    public void setText(String str) {
        this.aav = str;
    }

    public void setLink(String str) {
        this.mLink = str;
    }

    public String getText() {
        return this.aav;
    }

    public String getLink() {
        return this.mLink;
    }

    public int FB() {
        return this.aEq;
    }

    public String FC() {
        return this.aEr;
    }

    public void FD() {
        if (this.aav != null) {
            this.aav = this.aav.replaceAll("\n", "");
        }
        if (this.mLink != null) {
            this.mLink = this.mLink.replaceAll("\n", "");
        }
    }
}
