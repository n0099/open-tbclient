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
import com.baidu.tieba.w;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextItem extends OrmObject {
    private TbRichTextGraffitiInfo aMC;
    private int mType = 0;
    private TbRichTextCommInfo aMR = null;
    private TbRichTextImageInfo aMu = null;
    private TbRichTextVoiceInfo aMw = null;
    private TbRichTextEmotionInfo aMy = null;
    private e aMz = null;
    private TbRichTextLinkButtonInfo aMB = null;
    private TbRichTextLinkImageInfo aMA = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.aMR = tbRichTextCommInfo;
        this.aMu = tbRichTextImageInfo;
        this.aMw = tbRichTextVoiceInfo;
        this.aMy = tbRichTextEmotionInfo;
        this.aMB = tbRichTextLinkButtonInfo;
        this.aMA = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo Ic() {
        if (this.mType == 1280) {
            return this.aMA;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo Id() {
        if (this.mType == 1024) {
            return this.aMB;
        }
        return null;
    }

    public TbRichTextImageInfo HV() {
        if (this.mType == 8) {
            return this.aMu;
        }
        return null;
    }

    public e HZ() {
        if (this.mType != 32) {
            return null;
        }
        return this.aMz;
    }

    public TbRichTextVoiceInfo HX() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aMw;
        }
        return null;
    }

    public TbRichTextEmotionInfo Ia() {
        if (this.mType == 17) {
            return this.aMy;
        }
        return null;
    }

    public TbRichTextGraffitiInfo Ie() {
        if (this.mType == 1536) {
            return this.aMC;
        }
        return null;
    }

    private SpannableString Im() {
        if (this.mType != 1 || this.aMR == null) {
            return null;
        }
        return new SpannableString(this.aMR.getText());
    }

    private CharSequence t(ArrayList<a> arrayList) {
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.aMR != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.m9getInst().getString(w.l.video_text));
            CharSequence v = v(arrayList);
            if (v != null) {
                spannableStringBuilder.append(v);
            }
            if (this.aMR.HQ() == 1) {
                a = a(this.mType, this.aMR.getText(), this.aMR.HR(), 0);
            } else {
                a = a(this.mType, this.aMR.getText(), this.aMR.getText(), 0);
            }
            if (a != null) {
                spannableStringBuilder.append((CharSequence) a);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence u(ArrayList<a> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.aMR != null) {
            CharSequence v = v(arrayList);
            if (v != null) {
                spannableStringBuilder.append(v);
            }
            SpannableString a = a(this.mType, this.aMR.getLink(), this.aMR.getLink(), 0);
            if (a != null) {
                spannableStringBuilder.append((CharSequence) a);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence v(ArrayList<a> arrayList) {
        TbRichTextItem tbRichTextItem = new TbRichTextItem();
        tbRichTextItem.a(4, new TbRichTextCommInfo("video_icon", " "), null, null, null, null, null);
        return tbRichTextItem.x(arrayList);
    }

    public String getVideoUrl() {
        if (this.mType != 32 || this.aMR == null) {
            return null;
        }
        if (this.aMR.HQ() == 1) {
            return this.aMR.HR();
        }
        return this.aMR.getText();
    }

    private SpannableString In() {
        if ((this.mType != 2 && this.mType != 18) || this.aMR == null) {
            return null;
        }
        if (this.aMR.HQ() == 1) {
            return a(this.mType, this.aMR.getText(), this.aMR.HR(), 0);
        }
        return a(this.mType, this.aMR.getText(), this.aMR.getLink(), this.aMR.HS());
    }

    private SpannableString Io() {
        if (this.mType != 256 || this.aMR == null) {
            return null;
        }
        String text = this.aMR.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = String.valueOf(text) + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        b bVar = new b(this.mType, text);
        bVar.go(this.aMR.getLink());
        spannableString.setSpan(bVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString Ip() {
        if (this.mType != 16 || this.aMR == null) {
            return null;
        }
        return a(this.mType, this.aMR.getText(), this.aMR.getLink(), 0);
    }

    private SpannableString w(ArrayList<a> arrayList) {
        String text;
        int fc;
        a.C0043a fE;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.aMR != null && this.aMR.getText() != null && this.aMR.getLink() != null && (fc = TbFaceManager.Ek().fc((text = this.aMR.getText()))) != 0) {
            String str = "#(" + TbFaceManager.Ek().fe(text) + ")";
            spannableString = new SpannableString(String.valueOf(str) + " ");
            a aVar = new a(TbadkCoreApplication.m9getInst().getContext(), fc);
            if (arrayList != null) {
                arrayList.add(aVar);
            }
            if (TbFaceManager.Ek().fE(text) != null) {
                int width = (int) (fE.getWidth() * 0.5d);
                aVar.setBounds(new Rect(0, 0, width, width));
            } else {
                aVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new com.baidu.tbadk.widget.g(aVar), 0, str.length(), 33);
        }
        return spannableString;
    }

    private SpannableString a(int i, String str, String str2, int i2) {
        SpannableString spannableString = null;
        if (str != null) {
            if (!str.endsWith(" ")) {
                str = String.valueOf(str) + " ";
            }
            spannableString = new SpannableString(str);
            b bVar = new b(i, str2);
            bVar.ft(i2);
            if (i2 == 1) {
                bVar.setTextColor(w.e.cp_cont_d);
            } else {
                bVar.setTextColor(-1);
            }
            spannableString.setSpan(bVar, 0, str.length() - 1, 33);
        }
        return spannableString;
    }

    private SpannableString Iq() {
        if (this.mType != 1024 || this.aMB == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString("a");
        Drawable fv = c.fv(this.aMB.btn_type);
        fv.setBounds(0, 0, fv.getIntrinsicWidth(), fv.getIntrinsicHeight());
        com.baidu.tbadk.widget.g gVar = new com.baidu.tbadk.widget.g(fv);
        gVar.setVerticalOffset(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getContext(), w.f.ds4));
        spannableString.setSpan(gVar, 0, 1, 33);
        spannableString.setSpan(new b(1024, this.aMB.link), spannableString.length() - 1, "a".length(), 33);
        return spannableString;
    }

    public CharSequence x(ArrayList<a> arrayList) {
        switch (this.mType) {
            case 1:
                return Im();
            case 2:
                return In();
            case 4:
                return w(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return Ip();
            case 18:
                return In();
            case 32:
                return t(arrayList);
            case 128:
                return u(arrayList);
            case 256:
                return Io();
            case 1024:
                return Iq();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.aMz.IA() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = fu(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.aMu = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.aMR = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.aMy = new TbRichTextEmotionInfo();
                    this.aMy.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.aMy.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.aMy.mGifInfo.mStaticUrl = pbContent._static;
                    this.aMy.mType = this.mType;
                    this.aMy.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.aMy.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.aMy.mGifInfo.mPackageName = pbContent.packet_name;
                    this.aMy.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.aMy.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.aMy.mGifInfo.mGid = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.aMy.mGifInfo.mGid = split[i].split("_")[0];
                case 512:
                    this.aMw = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.aMB = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case 1280:
                    this.aMA = new TbRichTextLinkImageInfo(pbContent);
                    break;
                case 1536:
                    this.aMC = new TbRichTextGraffitiInfo();
                    this.aMC.a(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.aMz = new e();
                        this.aMz.a(pbContent);
                        break;
                    }
                    this.aMR = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.Ek().fc(this.aMR.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.m9getInst().getString(w.l.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.aMR.setText(str);
                            break;
                        } else {
                            this.aMR.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.aMR.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.aMR != null) {
                this.aMR.HT();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = fu(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.aMu = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.aMw = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.aMR = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString(SapiAccountManager.SESSION_UID));
            } else if (this.mType == 17) {
                this.aMy = new TbRichTextEmotionInfo();
                this.aMy.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.aMy.mGifInfo.mDynamicUrl = jSONObject.optString("dynamic");
                this.aMy.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.aMy.mType = this.mType;
                this.aMy.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.aMy.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.aMy.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.aMy.mGifInfo.mIcon = jSONObject.optString("icon");
                String[] split = this.aMy.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.aMy.mGifInfo.mGid = split[i].split("_")[0];
            } else {
                this.aMR = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int fc = TbFaceManager.Ek().fc(this.aMR.getText());
                    String optString = jSONObject.optString("c");
                    if (fc <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.m9getInst().getString(w.l.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.aMR.setText(str);
                    } else {
                        this.aMR.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.aMR.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.aMR != null) {
                this.aMR.HT();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int fu(int i) {
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
