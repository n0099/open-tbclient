package com.baidu.tbadk.widget.richText;

import android.text.TextUtils;
import org.json.JSONObject;
import tbclient.NativeApp;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.lib.a.b.a.a.i {
    private String Zu;
    private int aIg;
    private String aIh;
    private String aIi;
    private String mLink;
    private int mType;

    public b() {
        this.Zu = null;
        this.mLink = null;
        this.mType = 0;
    }

    public b(JSONObject jSONObject) {
        this.Zu = null;
        this.mLink = null;
        this.mType = 0;
        if (jSONObject != null) {
            this.Zu = jSONObject.optString("text");
            this.mLink = jSONObject.optString("link");
            this.mType = jSONObject.optInt("type", 0);
            this.aIg = jSONObject.optInt("is_native_app", 0);
            if (this.aIg == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.aIg = 0;
                    return;
                }
                this.aIh = jSONObject.optString("jump_and");
                this.aIi = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.aIh) || TextUtils.isEmpty(this.aIi)) {
                    this.aIg = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aIh = String.valueOf(this.aIh) + ";download_url:" + this.aIi + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aIh = String.valueOf(this.aIh) + ";download_url:" + this.aIi + ";web_play_url:" + this.Zu;
                }
                this.aIh = String.valueOf(this.aIh) + ";is_native_app=1";
            }
        }
    }

    public b(PbContent pbContent) {
        this.Zu = null;
        this.mLink = null;
        this.mType = 0;
        if (pbContent != null) {
            this.Zu = pbContent.text;
            this.mLink = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.aIg = pbContent.is_native_app.intValue();
            if (this.aIg == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.aIg = 0;
                    return;
                }
                this.aIh = nativeApp.jump_and;
                this.aIi = nativeApp.download_and;
                if (TextUtils.isEmpty(this.aIh) || TextUtils.isEmpty(this.aIi)) {
                    this.aIg = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aIh = String.valueOf(this.aIh) + ";download_url:" + this.aIi + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aIh = String.valueOf(this.aIh) + ";download_url:" + this.aIi + ";web_play_url:" + this.Zu;
                }
                this.aIh = String.valueOf(this.aIh) + ";is_native_app=1";
            }
        }
    }

    public b(String str, String str2) {
        this.Zu = null;
        this.mLink = null;
        this.mType = 0;
        this.Zu = str;
        this.mLink = str2;
    }

    public void setText(String str) {
        this.Zu = str;
    }

    public void setLink(String str) {
        this.mLink = str;
    }

    public String getText() {
        return this.Zu;
    }

    public String getLink() {
        return this.mLink;
    }

    public int Hz() {
        return this.aIg;
    }

    public String HA() {
        return this.aIh;
    }

    public void HB() {
        if (this.Zu != null) {
            this.Zu = this.Zu.replaceAll("\n", "");
        }
        if (this.mLink != null) {
            this.mLink = this.mLink.replaceAll("\n", "");
        }
    }
}
