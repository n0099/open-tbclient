package com.baidu.tbadk.widget.richText;

import android.text.TextUtils;
import org.json.JSONObject;
import tbclient.NativeApp;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.lib.a.b.a.a.i {
    private String ZR;
    private int aCR;
    private String aCS;
    private String aCT;
    private String mLink;
    private int mType;

    public b() {
        this.ZR = null;
        this.mLink = null;
        this.mType = 0;
    }

    public b(JSONObject jSONObject) {
        this.ZR = null;
        this.mLink = null;
        this.mType = 0;
        if (jSONObject != null) {
            this.ZR = jSONObject.optString("text");
            this.mLink = jSONObject.optString("link");
            this.mType = jSONObject.optInt("type", 0);
            this.aCR = jSONObject.optInt("is_native_app", 0);
            if (this.aCR == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.aCR = 0;
                    return;
                }
                this.aCS = jSONObject.optString("jump_and");
                this.aCT = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.aCS) || TextUtils.isEmpty(this.aCT)) {
                    this.aCR = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aCS = String.valueOf(this.aCS) + ";download_url:" + this.aCT + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aCS = String.valueOf(this.aCS) + ";download_url:" + this.aCT + ";web_play_url:" + this.ZR;
                }
                this.aCS = String.valueOf(this.aCS) + ";is_native_app=1";
            }
        }
    }

    public b(PbContent pbContent) {
        this.ZR = null;
        this.mLink = null;
        this.mType = 0;
        if (pbContent != null) {
            this.ZR = pbContent.text;
            this.mLink = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.aCR = pbContent.is_native_app.intValue();
            if (this.aCR == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.aCR = 0;
                    return;
                }
                this.aCS = nativeApp.jump_and;
                this.aCT = nativeApp.download_and;
                if (TextUtils.isEmpty(this.aCS) || TextUtils.isEmpty(this.aCT)) {
                    this.aCR = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aCS = String.valueOf(this.aCS) + ";download_url:" + this.aCT + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aCS = String.valueOf(this.aCS) + ";download_url:" + this.aCT + ";web_play_url:" + this.ZR;
                }
                this.aCS = String.valueOf(this.aCS) + ";is_native_app=1";
            }
        }
    }

    public b(String str, String str2) {
        this.ZR = null;
        this.mLink = null;
        this.mType = 0;
        this.ZR = str;
        this.mLink = str2;
    }

    public void setText(String str) {
        this.ZR = str;
    }

    public void setLink(String str) {
        this.mLink = str;
    }

    public String getText() {
        return this.ZR;
    }

    public String getLink() {
        return this.mLink;
    }

    public int FM() {
        return this.aCR;
    }

    public String FN() {
        return this.aCS;
    }

    public void FO() {
        if (this.ZR != null) {
            this.ZR = this.ZR.replaceAll("\n", "");
        }
        if (this.mLink != null) {
            this.mLink = this.mLink.replaceAll("\n", "");
        }
    }
}
