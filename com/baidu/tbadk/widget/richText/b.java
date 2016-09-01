package com.baidu.tbadk.widget.richText;

import android.text.TextUtils;
import org.json.JSONObject;
import tbclient.NativeApp;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.lib.a.b.a.a.i {
    private String Zp;
    private String aIA;
    private int aIy;
    private String aIz;
    private String mLink;
    private int mType;

    public b() {
        this.Zp = null;
        this.mLink = null;
        this.mType = 0;
    }

    public b(JSONObject jSONObject) {
        this.Zp = null;
        this.mLink = null;
        this.mType = 0;
        if (jSONObject != null) {
            this.Zp = jSONObject.optString("text");
            this.mLink = jSONObject.optString("link");
            this.mType = jSONObject.optInt("type", 0);
            this.aIy = jSONObject.optInt("is_native_app", 0);
            if (this.aIy == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.aIy = 0;
                    return;
                }
                this.aIz = jSONObject.optString("jump_and");
                this.aIA = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.aIz) || TextUtils.isEmpty(this.aIA)) {
                    this.aIy = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aIz = String.valueOf(this.aIz) + ";download_url:" + this.aIA + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aIz = String.valueOf(this.aIz) + ";download_url:" + this.aIA + ";web_play_url:" + this.Zp;
                }
                this.aIz = String.valueOf(this.aIz) + ";is_native_app=1";
            }
        }
    }

    public b(PbContent pbContent) {
        this.Zp = null;
        this.mLink = null;
        this.mType = 0;
        if (pbContent != null) {
            this.Zp = pbContent.text;
            this.mLink = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.aIy = pbContent.is_native_app.intValue();
            if (this.aIy == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.aIy = 0;
                    return;
                }
                this.aIz = nativeApp.jump_and;
                this.aIA = nativeApp.download_and;
                if (TextUtils.isEmpty(this.aIz) || TextUtils.isEmpty(this.aIA)) {
                    this.aIy = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aIz = String.valueOf(this.aIz) + ";download_url:" + this.aIA + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aIz = String.valueOf(this.aIz) + ";download_url:" + this.aIA + ";web_play_url:" + this.Zp;
                }
                this.aIz = String.valueOf(this.aIz) + ";is_native_app=1";
            }
        }
    }

    public b(String str, String str2) {
        this.Zp = null;
        this.mLink = null;
        this.mType = 0;
        this.Zp = str;
        this.mLink = str2;
    }

    public void setText(String str) {
        this.Zp = str;
    }

    public void setLink(String str) {
        this.mLink = str;
    }

    public String getText() {
        return this.Zp;
    }

    public String getLink() {
        return this.mLink;
    }

    public int Ib() {
        return this.aIy;
    }

    public String Ic() {
        return this.aIz;
    }

    public void Id() {
        if (this.Zp != null) {
            this.Zp = this.Zp.replaceAll("\n", "");
        }
        if (this.mLink != null) {
            this.mLink = this.mLink.replaceAll("\n", "");
        }
    }
}
