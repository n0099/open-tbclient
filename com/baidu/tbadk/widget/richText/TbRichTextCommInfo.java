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
    private String aTp;
    private int bIL;
    private String bIM;
    private String bIN;
    private int bIO;
    private String mLink;
    private int mType;

    public TbRichTextCommInfo() {
        this.aTp = null;
        this.mLink = null;
        this.mType = 0;
        this.bIO = 0;
    }

    public TbRichTextCommInfo(JSONObject jSONObject) {
        this.aTp = null;
        this.mLink = null;
        this.mType = 0;
        this.bIO = 0;
        if (jSONObject != null) {
            this.aTp = jSONObject.optString("text");
            this.mLink = jSONObject.optString("link");
            this.mType = jSONObject.optInt("type", 0);
            this.bIO = jSONObject.optInt("url_type", 0);
            this.bIL = jSONObject.optInt("is_native_app", 0);
            if (this.bIL == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.bIL = 0;
                    return;
                }
                this.bIM = jSONObject.optString("jump_and");
                this.bIN = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.bIM) || TextUtils.isEmpty(this.bIN)) {
                    this.bIL = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.bIM += ";download_url:" + this.bIN + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.bIM += ";download_url:" + this.bIN + ";web_play_url:" + this.aTp;
                }
                this.bIM += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(PbContent pbContent) {
        this.aTp = null;
        this.mLink = null;
        this.mType = 0;
        this.bIO = 0;
        if (pbContent != null) {
            this.aTp = pbContent.text;
            this.mLink = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.bIO = pbContent.url_type.intValue();
            this.bIL = pbContent.is_native_app.intValue();
            if (this.bIL == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.bIL = 0;
                    return;
                }
                this.bIM = nativeApp.jump_and;
                this.bIN = nativeApp.download_and;
                if (TextUtils.isEmpty(this.bIM) || TextUtils.isEmpty(this.bIN)) {
                    this.bIL = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.bIM += ";download_url:" + this.bIN + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.bIM += ";download_url:" + this.bIN + ";web_play_url:" + this.aTp;
                }
                this.bIM += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(String str, String str2) {
        this.aTp = null;
        this.mLink = null;
        this.mType = 0;
        this.bIO = 0;
        this.aTp = str;
        this.mLink = str2;
    }

    public void setText(String str) {
        this.aTp = str;
    }

    public void setLink(String str) {
        this.mLink = str;
    }

    public String getText() {
        return this.aTp;
    }

    public String getLink() {
        return this.mLink;
    }

    public int QC() {
        return this.bIL;
    }

    public String QD() {
        return this.bIM;
    }

    public int QE() {
        return this.bIO;
    }

    public void QF() {
        if (this.aTp != null) {
            this.aTp = this.aTp.replaceAll("\n", "");
        }
        if (this.mLink != null) {
            this.mLink = this.mLink.replaceAll("\n", "");
        }
    }
}
