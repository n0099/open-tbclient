package com.baidu.tbadk.widget.richText;

import android.text.TextUtils;
import org.json.JSONObject;
import tbclient.NativeApp;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.lib.a.b.a.a.i {
    private String Dm;
    private String abo;
    private int abp;
    private String abq;
    private String abr;
    private int mType;

    public b() {
        this.Dm = null;
        this.abo = null;
        this.mType = 0;
    }

    public b(JSONObject jSONObject) {
        this.Dm = null;
        this.abo = null;
        this.mType = 0;
        if (jSONObject != null) {
            this.Dm = jSONObject.optString("text");
            this.abo = jSONObject.optString("link");
            this.mType = jSONObject.optInt("type", 0);
            this.abp = jSONObject.optInt("is_native_app", 0);
            if (this.abp == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.abp = 0;
                    return;
                }
                this.abq = jSONObject.optString("jump_and");
                this.abr = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.abq) || TextUtils.isEmpty(this.abr)) {
                    this.abp = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.abq = String.valueOf(this.abq) + ";download_url:" + this.abr + ";web_play_url:" + this.abo;
                } else if (this.mType == 5) {
                    this.abq = String.valueOf(this.abq) + ";download_url:" + this.abr + ";web_play_url:" + this.Dm;
                }
                this.abq = String.valueOf(this.abq) + ";is_native_app=1";
            }
        }
    }

    public b(PbContent pbContent) {
        this.Dm = null;
        this.abo = null;
        this.mType = 0;
        if (pbContent != null) {
            this.Dm = pbContent.text;
            this.abo = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.abp = pbContent.is_native_app.intValue();
            if (this.abp == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.abp = 0;
                    return;
                }
                this.abq = nativeApp.jump_and;
                this.abr = nativeApp.download_and;
                if (TextUtils.isEmpty(this.abq) || TextUtils.isEmpty(this.abr)) {
                    this.abp = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.abq = String.valueOf(this.abq) + ";download_url:" + this.abr + ";web_play_url:" + this.abo;
                } else if (this.mType == 5) {
                    this.abq = String.valueOf(this.abq) + ";download_url:" + this.abr + ";web_play_url:" + this.Dm;
                }
                this.abq = String.valueOf(this.abq) + ";is_native_app=1";
            }
        }
    }

    public b(String str, String str2) {
        this.Dm = null;
        this.abo = null;
        this.mType = 0;
        this.Dm = str;
        this.abo = str2;
    }

    public void setText(String str) {
        this.Dm = str;
    }

    public void setLink(String str) {
        this.abo = str;
    }

    public String getText() {
        return this.Dm;
    }

    public String getLink() {
        return this.abo;
    }

    public int vz() {
        return this.abp;
    }

    public String vA() {
        return this.abq;
    }

    public void vB() {
        if (this.Dm != null) {
            this.Dm = this.Dm.replaceAll("\n", "");
        }
        if (this.abo != null) {
            this.abo = this.abo.replaceAll("\n", "");
        }
    }
}
