package com.baidu.tbadk.widget.richText;

import android.text.TextUtils;
import org.json.JSONObject;
import tbclient.NativeApp;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.lib.a.b.a.a.i {
    private String Zf;
    private String aCN;
    private int aCO;
    private String aCP;
    private String aCQ;
    private int mType;

    public b() {
        this.Zf = null;
        this.aCN = null;
        this.mType = 0;
    }

    public b(JSONObject jSONObject) {
        this.Zf = null;
        this.aCN = null;
        this.mType = 0;
        if (jSONObject != null) {
            this.Zf = jSONObject.optString("text");
            this.aCN = jSONObject.optString("link");
            this.mType = jSONObject.optInt("type", 0);
            this.aCO = jSONObject.optInt("is_native_app", 0);
            if (this.aCO == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.aCO = 0;
                    return;
                }
                this.aCP = jSONObject.optString("jump_and");
                this.aCQ = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.aCP) || TextUtils.isEmpty(this.aCQ)) {
                    this.aCO = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aCP = String.valueOf(this.aCP) + ";download_url:" + this.aCQ + ";web_play_url:" + this.aCN;
                } else if (this.mType == 5) {
                    this.aCP = String.valueOf(this.aCP) + ";download_url:" + this.aCQ + ";web_play_url:" + this.Zf;
                }
                this.aCP = String.valueOf(this.aCP) + ";is_native_app=1";
            }
        }
    }

    public b(PbContent pbContent) {
        this.Zf = null;
        this.aCN = null;
        this.mType = 0;
        if (pbContent != null) {
            this.Zf = pbContent.text;
            this.aCN = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.aCO = pbContent.is_native_app.intValue();
            if (this.aCO == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.aCO = 0;
                    return;
                }
                this.aCP = nativeApp.jump_and;
                this.aCQ = nativeApp.download_and;
                if (TextUtils.isEmpty(this.aCP) || TextUtils.isEmpty(this.aCQ)) {
                    this.aCO = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aCP = String.valueOf(this.aCP) + ";download_url:" + this.aCQ + ";web_play_url:" + this.aCN;
                } else if (this.mType == 5) {
                    this.aCP = String.valueOf(this.aCP) + ";download_url:" + this.aCQ + ";web_play_url:" + this.Zf;
                }
                this.aCP = String.valueOf(this.aCP) + ";is_native_app=1";
            }
        }
    }

    public b(String str, String str2) {
        this.Zf = null;
        this.aCN = null;
        this.mType = 0;
        this.Zf = str;
        this.aCN = str2;
    }

    public void setText(String str) {
        this.Zf = str;
    }

    public void setLink(String str) {
        this.aCN = str;
    }

    public String getText() {
        return this.Zf;
    }

    public String getLink() {
        return this.aCN;
    }

    public int Fh() {
        return this.aCO;
    }

    public String Fi() {
        return this.aCP;
    }

    public void Fj() {
        if (this.Zf != null) {
            this.Zf = this.Zf.replaceAll("\n", "");
        }
        if (this.aCN != null) {
            this.aCN = this.aCN.replaceAll("\n", "");
        }
    }
}
