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
    private String aTq;
    private int bID;
    private String bIE;
    private String bIF;
    private int bIG;
    private String mLink;
    private int mType;

    public TbRichTextCommInfo() {
        this.aTq = null;
        this.mLink = null;
        this.mType = 0;
        this.bIG = 0;
    }

    public TbRichTextCommInfo(JSONObject jSONObject) {
        this.aTq = null;
        this.mLink = null;
        this.mType = 0;
        this.bIG = 0;
        if (jSONObject != null) {
            this.aTq = jSONObject.optString("text");
            this.mLink = jSONObject.optString("link");
            this.mType = jSONObject.optInt("type", 0);
            this.bIG = jSONObject.optInt("url_type", 0);
            this.bID = jSONObject.optInt("is_native_app", 0);
            if (this.bID == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.bID = 0;
                    return;
                }
                this.bIE = jSONObject.optString("jump_and");
                this.bIF = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.bIE) || TextUtils.isEmpty(this.bIF)) {
                    this.bID = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.bIE += ";download_url:" + this.bIF + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.bIE += ";download_url:" + this.bIF + ";web_play_url:" + this.aTq;
                }
                this.bIE += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(PbContent pbContent) {
        this.aTq = null;
        this.mLink = null;
        this.mType = 0;
        this.bIG = 0;
        if (pbContent != null) {
            this.aTq = pbContent.text;
            this.mLink = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.bIG = pbContent.url_type.intValue();
            this.bID = pbContent.is_native_app.intValue();
            if (this.bID == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.bID = 0;
                    return;
                }
                this.bIE = nativeApp.jump_and;
                this.bIF = nativeApp.download_and;
                if (TextUtils.isEmpty(this.bIE) || TextUtils.isEmpty(this.bIF)) {
                    this.bID = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.bIE += ";download_url:" + this.bIF + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.bIE += ";download_url:" + this.bIF + ";web_play_url:" + this.aTq;
                }
                this.bIE += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(String str, String str2) {
        this.aTq = null;
        this.mLink = null;
        this.mType = 0;
        this.bIG = 0;
        this.aTq = str;
        this.mLink = str2;
    }

    public void setText(String str) {
        this.aTq = str;
    }

    public void setLink(String str) {
        this.mLink = str;
    }

    public String getText() {
        return this.aTq;
    }

    public String getLink() {
        return this.mLink;
    }

    public int QO() {
        return this.bID;
    }

    public String QP() {
        return this.bIE;
    }

    public int QQ() {
        return this.bIG;
    }

    public void QR() {
        if (this.aTq != null) {
            this.aTq = this.aTq.replaceAll("\n", "");
        }
        if (this.mLink != null) {
            this.mLink = this.mLink.replaceAll("\n", "");
        }
    }
}
