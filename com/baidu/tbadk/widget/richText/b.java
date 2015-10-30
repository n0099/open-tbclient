package com.baidu.tbadk.widget.richText;

import android.text.TextUtils;
import org.json.JSONObject;
import tbclient.NativeApp;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.lib.a.b.a.a.i {
    private String Zb;
    private String aBr;
    private int aBs;
    private String aBt;
    private String aBu;
    private int mType;

    public b() {
        this.Zb = null;
        this.aBr = null;
        this.mType = 0;
    }

    public b(JSONObject jSONObject) {
        this.Zb = null;
        this.aBr = null;
        this.mType = 0;
        if (jSONObject != null) {
            this.Zb = jSONObject.optString("text");
            this.aBr = jSONObject.optString("link");
            this.mType = jSONObject.optInt("type", 0);
            this.aBs = jSONObject.optInt("is_native_app", 0);
            if (this.aBs == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.aBs = 0;
                    return;
                }
                this.aBt = jSONObject.optString("jump_and");
                this.aBu = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.aBt) || TextUtils.isEmpty(this.aBu)) {
                    this.aBs = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aBt = String.valueOf(this.aBt) + ";download_url:" + this.aBu + ";web_play_url:" + this.aBr;
                } else if (this.mType == 5) {
                    this.aBt = String.valueOf(this.aBt) + ";download_url:" + this.aBu + ";web_play_url:" + this.Zb;
                }
                this.aBt = String.valueOf(this.aBt) + ";is_native_app=1";
            }
        }
    }

    public b(PbContent pbContent) {
        this.Zb = null;
        this.aBr = null;
        this.mType = 0;
        if (pbContent != null) {
            this.Zb = pbContent.text;
            this.aBr = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.aBs = pbContent.is_native_app.intValue();
            if (this.aBs == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.aBs = 0;
                    return;
                }
                this.aBt = nativeApp.jump_and;
                this.aBu = nativeApp.download_and;
                if (TextUtils.isEmpty(this.aBt) || TextUtils.isEmpty(this.aBu)) {
                    this.aBs = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aBt = String.valueOf(this.aBt) + ";download_url:" + this.aBu + ";web_play_url:" + this.aBr;
                } else if (this.mType == 5) {
                    this.aBt = String.valueOf(this.aBt) + ";download_url:" + this.aBu + ";web_play_url:" + this.Zb;
                }
                this.aBt = String.valueOf(this.aBt) + ";is_native_app=1";
            }
        }
    }

    public b(String str, String str2) {
        this.Zb = null;
        this.aBr = null;
        this.mType = 0;
        this.Zb = str;
        this.aBr = str2;
    }

    public void setText(String str) {
        this.Zb = str;
    }

    public void setLink(String str) {
        this.aBr = str;
    }

    public String getText() {
        return this.Zb;
    }

    public String getLink() {
        return this.aBr;
    }

    public int EQ() {
        return this.aBs;
    }

    public String ER() {
        return this.aBt;
    }

    public void ES() {
        if (this.Zb != null) {
            this.Zb = this.Zb.replaceAll("\n", "");
        }
        if (this.aBr != null) {
            this.aBr = this.aBr.replaceAll("\n", "");
        }
    }
}
