package com.baidu.tbadk.widget.richText;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.NativeApp;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextCommInfo extends OrmObject {
    public static final int NATIVE_APP_TYPE = 1;
    public static final int TYPE_LINK = 1;
    public static final int TYPE_VIDEO = 5;
    public static final int URL_VALIDITY_INVALID = 1;
    public static final int URL_VALIDITY_NORMAL = 0;
    public static final int URL_VALIDITY_VALID = 2;
    private String aqV;
    private int biE;
    private String biF;
    private String biG;
    private int biH;
    private String mLink;
    private int mType;

    public TbRichTextCommInfo() {
        this.aqV = null;
        this.mLink = null;
        this.mType = 0;
        this.biH = 0;
    }

    public TbRichTextCommInfo(JSONObject jSONObject) {
        this.aqV = null;
        this.mLink = null;
        this.mType = 0;
        this.biH = 0;
        if (jSONObject != null) {
            this.aqV = jSONObject.optString("text");
            this.mLink = jSONObject.optString("link");
            this.mType = jSONObject.optInt("type", 0);
            this.biH = jSONObject.optInt("url_type", 0);
            this.biE = jSONObject.optInt("is_native_app", 0);
            if (this.biE == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.biE = 0;
                    return;
                }
                this.biF = jSONObject.optString("jump_and");
                this.biG = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.biF) || TextUtils.isEmpty(this.biG)) {
                    this.biE = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.biF += ";download_url:" + this.biG + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.biF += ";download_url:" + this.biG + ";web_play_url:" + this.aqV;
                }
                this.biF += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(PbContent pbContent) {
        this.aqV = null;
        this.mLink = null;
        this.mType = 0;
        this.biH = 0;
        if (pbContent != null) {
            this.aqV = pbContent.text;
            this.mLink = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.biH = pbContent.url_type.intValue();
            this.biE = pbContent.is_native_app.intValue();
            if (this.biE == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.biE = 0;
                    return;
                }
                this.biF = nativeApp.jump_and;
                this.biG = nativeApp.download_and;
                if (TextUtils.isEmpty(this.biF) || TextUtils.isEmpty(this.biG)) {
                    this.biE = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.biF += ";download_url:" + this.biG + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.biF += ";download_url:" + this.biG + ";web_play_url:" + this.aqV;
                }
                this.biF += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(String str, String str2) {
        this.aqV = null;
        this.mLink = null;
        this.mType = 0;
        this.biH = 0;
        this.aqV = str;
        this.mLink = str2;
    }

    public void setText(String str) {
        this.aqV = str;
    }

    public void setLink(String str) {
        this.mLink = str;
    }

    public String getText() {
        return this.aqV;
    }

    public String getLink() {
        return this.mLink;
    }

    public int OQ() {
        return this.biE;
    }

    public String OR() {
        return this.biF;
    }

    public int OS() {
        return this.biH;
    }

    public void OT() {
        if (this.aqV != null) {
            this.aqV = this.aqV.replaceAll("\n", "");
        }
        if (this.mLink != null) {
            this.mLink = this.mLink.replaceAll("\n", "");
        }
    }
}
