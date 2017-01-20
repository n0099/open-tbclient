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
    private String YI;
    private int aGS;
    private String aGT;
    private String aGU;
    private String mLink;
    private int mType;

    public TbRichTextCommInfo() {
        this.YI = null;
        this.mLink = null;
        this.mType = 0;
    }

    public TbRichTextCommInfo(JSONObject jSONObject) {
        this.YI = null;
        this.mLink = null;
        this.mType = 0;
        if (jSONObject != null) {
            this.YI = jSONObject.optString("text");
            this.mLink = jSONObject.optString("link");
            this.mType = jSONObject.optInt("type", 0);
            this.aGS = jSONObject.optInt("is_native_app", 0);
            if (this.aGS == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.aGS = 0;
                    return;
                }
                this.aGT = jSONObject.optString("jump_and");
                this.aGU = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.aGT) || TextUtils.isEmpty(this.aGU)) {
                    this.aGS = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aGT = String.valueOf(this.aGT) + ";download_url:" + this.aGU + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aGT = String.valueOf(this.aGT) + ";download_url:" + this.aGU + ";web_play_url:" + this.YI;
                }
                this.aGT = String.valueOf(this.aGT) + ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(PbContent pbContent) {
        this.YI = null;
        this.mLink = null;
        this.mType = 0;
        if (pbContent != null) {
            this.YI = pbContent.text;
            this.mLink = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.aGS = pbContent.is_native_app.intValue();
            if (this.aGS == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.aGS = 0;
                    return;
                }
                this.aGT = nativeApp.jump_and;
                this.aGU = nativeApp.download_and;
                if (TextUtils.isEmpty(this.aGT) || TextUtils.isEmpty(this.aGU)) {
                    this.aGS = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aGT = String.valueOf(this.aGT) + ";download_url:" + this.aGU + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aGT = String.valueOf(this.aGT) + ";download_url:" + this.aGU + ";web_play_url:" + this.YI;
                }
                this.aGT = String.valueOf(this.aGT) + ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(String str, String str2) {
        this.YI = null;
        this.mLink = null;
        this.mType = 0;
        this.YI = str;
        this.mLink = str2;
    }

    public void setText(String str) {
        this.YI = str;
    }

    public void setLink(String str) {
        this.mLink = str;
    }

    public String getText() {
        return this.YI;
    }

    public String getLink() {
        return this.mLink;
    }

    public int Hr() {
        return this.aGS;
    }

    public String Hs() {
        return this.aGT;
    }

    public void Ht() {
        if (this.YI != null) {
            this.YI = this.YI.replaceAll("\n", "");
        }
        if (this.mLink != null) {
            this.mLink = this.mLink.replaceAll("\n", "");
        }
    }
}
