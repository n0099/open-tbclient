package com.baidu.tbadk.widget.richText;

import android.text.TextUtils;
import org.json.JSONObject;
import tbclient.NativeApp;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.lib.a.b.a.a.i {
    private int aIN;
    private String aIO;
    private String aIP;
    private String aaa;
    private String mLink;
    private int mType;

    public b() {
        this.aaa = null;
        this.mLink = null;
        this.mType = 0;
    }

    public b(JSONObject jSONObject) {
        this.aaa = null;
        this.mLink = null;
        this.mType = 0;
        if (jSONObject != null) {
            this.aaa = jSONObject.optString("text");
            this.mLink = jSONObject.optString("link");
            this.mType = jSONObject.optInt("type", 0);
            this.aIN = jSONObject.optInt("is_native_app", 0);
            if (this.aIN == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.aIN = 0;
                    return;
                }
                this.aIO = jSONObject.optString("jump_and");
                this.aIP = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.aIO) || TextUtils.isEmpty(this.aIP)) {
                    this.aIN = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aIO = String.valueOf(this.aIO) + ";download_url:" + this.aIP + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aIO = String.valueOf(this.aIO) + ";download_url:" + this.aIP + ";web_play_url:" + this.aaa;
                }
                this.aIO = String.valueOf(this.aIO) + ";is_native_app=1";
            }
        }
    }

    public b(PbContent pbContent) {
        this.aaa = null;
        this.mLink = null;
        this.mType = 0;
        if (pbContent != null) {
            this.aaa = pbContent.text;
            this.mLink = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.aIN = pbContent.is_native_app.intValue();
            if (this.aIN == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.aIN = 0;
                    return;
                }
                this.aIO = nativeApp.jump_and;
                this.aIP = nativeApp.download_and;
                if (TextUtils.isEmpty(this.aIO) || TextUtils.isEmpty(this.aIP)) {
                    this.aIN = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aIO = String.valueOf(this.aIO) + ";download_url:" + this.aIP + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aIO = String.valueOf(this.aIO) + ";download_url:" + this.aIP + ";web_play_url:" + this.aaa;
                }
                this.aIO = String.valueOf(this.aIO) + ";is_native_app=1";
            }
        }
    }

    public b(String str, String str2) {
        this.aaa = null;
        this.mLink = null;
        this.mType = 0;
        this.aaa = str;
        this.mLink = str2;
    }

    public void setText(String str) {
        this.aaa = str;
    }

    public void setLink(String str) {
        this.mLink = str;
    }

    public String getText() {
        return this.aaa;
    }

    public String getLink() {
        return this.mLink;
    }

    public int Id() {
        return this.aIN;
    }

    public String Ie() {
        return this.aIO;
    }

    public void If() {
        if (this.aaa != null) {
            this.aaa = this.aaa.replaceAll("\n", "");
        }
        if (this.mLink != null) {
            this.mLink = this.mLink.replaceAll("\n", "");
        }
    }
}
