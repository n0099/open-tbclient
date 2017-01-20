package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.r;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextItem extends OrmObject {
    private TbRichTextGraffitiInfo aHe;
    private int mType = 0;
    private TbRichTextCommInfo aHt = null;
    private TbRichTextImageInfo aGW = null;
    private TbRichTextVoiceInfo aGY = null;
    private TbRichTextEmotionInfo aHa = null;
    private e aHb = null;
    private TbRichTextLinkButtonInfo aHd = null;
    private TbRichTextLinkImageInfo aHc = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.aHt = tbRichTextCommInfo;
        this.aGW = tbRichTextImageInfo;
        this.aGY = tbRichTextVoiceInfo;
        this.aHa = tbRichTextEmotionInfo;
        this.aHd = tbRichTextLinkButtonInfo;
        this.aHc = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo HC() {
        if (this.mType == 1280) {
            return this.aHc;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo HD() {
        if (this.mType == 1024) {
            return this.aHd;
        }
        return null;
    }

    public TbRichTextImageInfo Hv() {
        if (this.mType == 8) {
            return this.aGW;
        }
        return null;
    }

    public e Hz() {
        if (this.mType != 32) {
            return null;
        }
        return this.aHb;
    }

    public TbRichTextVoiceInfo Hx() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aGY;
        }
        return null;
    }

    public TbRichTextEmotionInfo HA() {
        if (this.mType == 17) {
            return this.aHa;
        }
        return null;
    }

    public TbRichTextGraffitiInfo HE() {
        if (this.mType == 1536) {
            return this.aHe;
        }
        return null;
    }

    private SpannableString HM() {
        if (this.mType != 1 || this.aHt == null) {
            return null;
        }
        return new SpannableString(this.aHt.getText());
    }

    private CharSequence u(ArrayList<a> arrayList) {
        SpannableString c;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.aHt != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.m9getInst().getString(r.l.video_text));
            CharSequence w = w(arrayList);
            if (w != null) {
                spannableStringBuilder.append(w);
            }
            if (this.aHt.Hr() == 1) {
                c = c(this.mType, this.aHt.getText(), this.aHt.Hs());
            } else {
                c = c(this.mType, this.aHt.getText(), this.aHt.getText());
            }
            if (c != null) {
                spannableStringBuilder.append((CharSequence) c);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence v(ArrayList<a> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.aHt != null) {
            CharSequence w = w(arrayList);
            if (w != null) {
                spannableStringBuilder.append(w);
            }
            SpannableString c = c(this.mType, this.aHt.getLink(), this.aHt.getLink());
            if (c != null) {
                spannableStringBuilder.append((CharSequence) c);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence w(ArrayList<a> arrayList) {
        TbRichTextItem tbRichTextItem = new TbRichTextItem();
        tbRichTextItem.a(4, new TbRichTextCommInfo("video_icon", " "), null, null, null, null, null);
        return tbRichTextItem.y(arrayList);
    }

    public String getVideoUrl() {
        if (this.mType != 32 || this.aHt == null) {
            return null;
        }
        if (this.aHt.Hr() == 1) {
            return this.aHt.Hs();
        }
        return this.aHt.getText();
    }

    private SpannableString HN() {
        if ((this.mType != 2 && this.mType != 18) || this.aHt == null) {
            return null;
        }
        if (this.aHt.Hr() == 1) {
            return c(this.mType, this.aHt.getText(), this.aHt.Hs());
        }
        return c(this.mType, this.aHt.getText(), this.aHt.getLink());
    }

    private SpannableString HO() {
        if (this.mType != 256 || this.aHt == null) {
            return null;
        }
        String text = this.aHt.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = String.valueOf(text) + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        b bVar = new b(this.mType, text);
        bVar.gz(this.aHt.getLink());
        spannableString.setSpan(bVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString HP() {
        if (this.mType != 16 || this.aHt == null) {
            return null;
        }
        return c(this.mType, this.aHt.getText(), this.aHt.getLink());
    }

    private SpannableString x(ArrayList<a> arrayList) {
        String text;
        int fn;
        a.C0044a fP;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.aHt != null && this.aHt.getText() != null && this.aHt.getLink() != null && (fn = TbFaceManager.DR().fn((text = this.aHt.getText()))) != 0) {
            String str = "#(" + TbFaceManager.DR().fp(text) + ")";
            spannableString = new SpannableString(String.valueOf(str) + " ");
            a aVar = new a(TbadkCoreApplication.m9getInst().getContext(), fn);
            if (arrayList != null) {
                arrayList.add(aVar);
            }
            if (TbFaceManager.DR().fP(text) != null) {
                int width = (int) (fP.getWidth() * 0.5d);
                aVar.setBounds(new Rect(0, 0, width, width));
            } else {
                aVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new com.baidu.tbadk.widget.f(aVar), 0, str.length(), 33);
        }
        return spannableString;
    }

    private SpannableString c(int i, String str, String str2) {
        if (str == null) {
            return null;
        }
        if (!str.endsWith(" ")) {
            str = String.valueOf(str) + " ";
        }
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new b(i, str2), 0, str.length() - 1, 33);
        return spannableString;
    }

    private SpannableString HQ() {
        if (this.mType != 1024 || this.aHd == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString("a");
        Drawable fB = c.fB(this.aHd.btn_type);
        fB.setBounds(0, 0, fB.getIntrinsicWidth(), fB.getIntrinsicHeight());
        com.baidu.tbadk.widget.f fVar = new com.baidu.tbadk.widget.f(fB);
        fVar.setVerticalOffset(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getContext(), r.f.ds4));
        spannableString.setSpan(fVar, 0, 1, 33);
        spannableString.setSpan(new b(1024, this.aHd.link), spannableString.length() - 1, "a".length(), 33);
        return spannableString;
    }

    public CharSequence y(ArrayList<a> arrayList) {
        switch (this.mType) {
            case 1:
                return HM();
            case 2:
                return HN();
            case 4:
                return x(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return HP();
            case 18:
                return HN();
            case 32:
                return u(arrayList);
            case 128:
                return v(arrayList);
            case 256:
                return HO();
            case 1024:
                return HQ();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.aHb.Ia() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = fA(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.aGW = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.aHt = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.aHa = new TbRichTextEmotionInfo();
                    this.aHa.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.aHa.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.aHa.mGifInfo.mStaticUrl = pbContent._static;
                    this.aHa.mType = this.mType;
                    this.aHa.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.aHa.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.aHa.mGifInfo.mPackageName = pbContent.packet_name;
                    this.aHa.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.aHa.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.aHa.mGifInfo.mGid = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.aHa.mGifInfo.mGid = split[i].split("_")[0];
                case 512:
                    this.aGY = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.aHd = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case 1280:
                    this.aHc = new TbRichTextLinkImageInfo(pbContent);
                    break;
                case 1536:
                    this.aHe = new TbRichTextGraffitiInfo();
                    this.aHe.a(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.aHb = new e();
                        this.aHb.a(pbContent);
                        break;
                    }
                    this.aHt = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.DR().fn(this.aHt.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.m9getInst().getString(r.l.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.aHt.setText(str);
                            break;
                        } else {
                            this.aHt.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.aHt.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.aHt != null) {
                this.aHt.Ht();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = fA(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.aGW = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.aGY = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.aHt = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString(SapiAccountManager.SESSION_UID));
            } else if (this.mType == 17) {
                this.aHa = new TbRichTextEmotionInfo();
                this.aHa.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.aHa.mGifInfo.mDynamicUrl = jSONObject.optString("dynamic");
                this.aHa.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.aHa.mType = this.mType;
                this.aHa.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.aHa.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.aHa.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.aHa.mGifInfo.mIcon = jSONObject.optString("icon");
                String[] split = this.aHa.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.aHa.mGifInfo.mGid = split[i].split("_")[0];
            } else {
                this.aHt = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int fn = TbFaceManager.DR().fn(this.aHt.getText());
                    String optString = jSONObject.optString("c");
                    if (fn <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.m9getInst().getString(r.l.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.aHt.setText(str);
                    } else {
                        this.aHt.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.aHt.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.aHt != null) {
                this.aHt.Ht();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int fA(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
            case 12:
            case 15:
            case 17:
            default:
                return 0;
            case 8:
                return 128;
            case 9:
                return 256;
            case 10:
                return 512;
            case 11:
                return 17;
            case 13:
                return 1024;
            case 14:
                return 1280;
            case 16:
                return 1536;
            case 18:
                return 18;
        }
    }
}
