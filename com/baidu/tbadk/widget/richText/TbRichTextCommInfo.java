package com.baidu.tbadk.widget.richText;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
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
    private String alI;
    private int cCA;
    private String cCB;
    private String cCC;
    private int cCD;
    private String mLink;
    private int mType;

    public TbRichTextCommInfo() {
        this.alI = null;
        this.mLink = null;
        this.mType = 0;
        this.cCD = 0;
    }

    public TbRichTextCommInfo(JSONObject jSONObject) {
        this.alI = null;
        this.mLink = null;
        this.mType = 0;
        this.cCD = 0;
        if (jSONObject != null) {
            this.alI = jSONObject.optString("text");
            this.mLink = jSONObject.optString(SelectForumActivityConfig.KEY_SHARE_LINK);
            this.mType = jSONObject.optInt("type", 0);
            this.cCD = jSONObject.optInt("url_type", 0);
            this.cCA = jSONObject.optInt("is_native_app", 0);
            if (this.cCA == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.cCA = 0;
                    return;
                }
                this.cCB = jSONObject.optString("jump_and");
                this.cCC = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.cCB) || TextUtils.isEmpty(this.cCC)) {
                    this.cCA = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.cCB += ";download_url:" + this.cCC + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.cCB += ";download_url:" + this.cCC + ";web_play_url:" + this.alI;
                }
                this.cCB += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(PbContent pbContent) {
        this.alI = null;
        this.mLink = null;
        this.mType = 0;
        this.cCD = 0;
        if (pbContent != null) {
            this.alI = pbContent.text;
            this.mLink = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.cCD = pbContent.url_type.intValue();
            this.cCA = pbContent.is_native_app.intValue();
            if (this.cCA == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.cCA = 0;
                    return;
                }
                this.cCB = nativeApp.jump_and;
                this.cCC = nativeApp.download_and;
                if (TextUtils.isEmpty(this.cCB) || TextUtils.isEmpty(this.cCC)) {
                    this.cCA = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.cCB += ";download_url:" + this.cCC + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.cCB += ";download_url:" + this.cCC + ";web_play_url:" + this.alI;
                }
                this.cCB += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(String str, String str2) {
        this.alI = null;
        this.mLink = null;
        this.mType = 0;
        this.cCD = 0;
        this.alI = str;
        this.mLink = str2;
    }

    public void setText(String str) {
        this.alI = str;
    }

    public void setLink(String str) {
        this.mLink = str;
    }

    public String getText() {
        return this.alI;
    }

    public String getLink() {
        return this.mLink;
    }

    public int asz() {
        return this.cCA;
    }

    public String asA() {
        return this.cCB;
    }

    public int asB() {
        return this.cCD;
    }

    public void asC() {
        if (this.alI != null) {
            this.alI = this.alI.replaceAll("\n", "");
        }
        if (this.mLink != null) {
            this.mLink = this.mLink.replaceAll("\n", "");
        }
    }
}
