package com.baidu.tbadk.widget.richText;

import android.text.TextUtils;
import org.json.JSONObject;
import tbclient.NativeApp;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.lib.a.b.a.a.i {
    private String YW;
    private String aBf;
    private int aBg;
    private String aBh;
    private String aBi;
    private int mType;

    public b() {
        this.YW = null;
        this.aBf = null;
        this.mType = 0;
    }

    public b(JSONObject jSONObject) {
        this.YW = null;
        this.aBf = null;
        this.mType = 0;
        if (jSONObject != null) {
            this.YW = jSONObject.optString("text");
            this.aBf = jSONObject.optString("link");
            this.mType = jSONObject.optInt("type", 0);
            this.aBg = jSONObject.optInt("is_native_app", 0);
            if (this.aBg == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.aBg = 0;
                    return;
                }
                this.aBh = jSONObject.optString("jump_and");
                this.aBi = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.aBh) || TextUtils.isEmpty(this.aBi)) {
                    this.aBg = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aBh = String.valueOf(this.aBh) + ";download_url:" + this.aBi + ";web_play_url:" + this.aBf;
                } else if (this.mType == 5) {
                    this.aBh = String.valueOf(this.aBh) + ";download_url:" + this.aBi + ";web_play_url:" + this.YW;
                }
                this.aBh = String.valueOf(this.aBh) + ";is_native_app=1";
            }
        }
    }

    public b(PbContent pbContent) {
        this.YW = null;
        this.aBf = null;
        this.mType = 0;
        if (pbContent != null) {
            this.YW = pbContent.text;
            this.aBf = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.aBg = pbContent.is_native_app.intValue();
            if (this.aBg == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.aBg = 0;
                    return;
                }
                this.aBh = nativeApp.jump_and;
                this.aBi = nativeApp.download_and;
                if (TextUtils.isEmpty(this.aBh) || TextUtils.isEmpty(this.aBi)) {
                    this.aBg = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aBh = String.valueOf(this.aBh) + ";download_url:" + this.aBi + ";web_play_url:" + this.aBf;
                } else if (this.mType == 5) {
                    this.aBh = String.valueOf(this.aBh) + ";download_url:" + this.aBi + ";web_play_url:" + this.YW;
                }
                this.aBh = String.valueOf(this.aBh) + ";is_native_app=1";
            }
        }
    }

    public b(String str, String str2) {
        this.YW = null;
        this.aBf = null;
        this.mType = 0;
        this.YW = str;
        this.aBf = str2;
    }

    public void setText(String str) {
        this.YW = str;
    }

    public void setLink(String str) {
        this.aBf = str;
    }

    public String getText() {
        return this.YW;
    }

    public String getLink() {
        return this.aBf;
    }

    public int EX() {
        return this.aBg;
    }

    public String EY() {
        return this.aBh;
    }

    public void EZ() {
        if (this.YW != null) {
            this.YW = this.YW.replaceAll("\n", "");
        }
        if (this.aBf != null) {
            this.aBf = this.aBf.replaceAll("\n", "");
        }
    }
}
