package com.baidu.tbadk.widget.richText;

import android.text.TextUtils;
import org.json.JSONObject;
import tbclient.NativeApp;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.lib.a.b.a.a.i {
    private String Zf;
    private String aAg;
    private int aAh;
    private String aAi;
    private String aAj;
    private int mType;

    public b() {
        this.Zf = null;
        this.aAg = null;
        this.mType = 0;
    }

    public b(JSONObject jSONObject) {
        this.Zf = null;
        this.aAg = null;
        this.mType = 0;
        if (jSONObject != null) {
            this.Zf = jSONObject.optString("text");
            this.aAg = jSONObject.optString("link");
            this.mType = jSONObject.optInt("type", 0);
            this.aAh = jSONObject.optInt("is_native_app", 0);
            if (this.aAh == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.aAh = 0;
                    return;
                }
                this.aAi = jSONObject.optString("jump_and");
                this.aAj = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.aAi) || TextUtils.isEmpty(this.aAj)) {
                    this.aAh = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aAi = String.valueOf(this.aAi) + ";download_url:" + this.aAj + ";web_play_url:" + this.aAg;
                } else if (this.mType == 5) {
                    this.aAi = String.valueOf(this.aAi) + ";download_url:" + this.aAj + ";web_play_url:" + this.Zf;
                }
                this.aAi = String.valueOf(this.aAi) + ";is_native_app=1";
            }
        }
    }

    public b(PbContent pbContent) {
        this.Zf = null;
        this.aAg = null;
        this.mType = 0;
        if (pbContent != null) {
            this.Zf = pbContent.text;
            this.aAg = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.aAh = pbContent.is_native_app.intValue();
            if (this.aAh == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.aAh = 0;
                    return;
                }
                this.aAi = nativeApp.jump_and;
                this.aAj = nativeApp.download_and;
                if (TextUtils.isEmpty(this.aAi) || TextUtils.isEmpty(this.aAj)) {
                    this.aAh = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aAi = String.valueOf(this.aAi) + ";download_url:" + this.aAj + ";web_play_url:" + this.aAg;
                } else if (this.mType == 5) {
                    this.aAi = String.valueOf(this.aAi) + ";download_url:" + this.aAj + ";web_play_url:" + this.Zf;
                }
                this.aAi = String.valueOf(this.aAi) + ";is_native_app=1";
            }
        }
    }

    public b(String str, String str2) {
        this.Zf = null;
        this.aAg = null;
        this.mType = 0;
        this.Zf = str;
        this.aAg = str2;
    }

    public void setText(String str) {
        this.Zf = str;
    }

    public void setLink(String str) {
        this.aAg = str;
    }

    public String getText() {
        return this.Zf;
    }

    public String getLink() {
        return this.aAg;
    }

    public int EJ() {
        return this.aAh;
    }

    public String EK() {
        return this.aAi;
    }

    public void EL() {
        if (this.Zf != null) {
            this.Zf = this.Zf.replaceAll("\n", "");
        }
        if (this.aAg != null) {
            this.aAg = this.aAg.replaceAll("\n", "");
        }
    }
}
