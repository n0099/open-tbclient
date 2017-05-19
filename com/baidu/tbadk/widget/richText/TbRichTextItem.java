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
    private TbRichTextGraffitiInfo aNl;
    private int mType = 0;
    private TbRichTextCommInfo aNA = null;
    private TbRichTextImageInfo aNd = null;
    private TbRichTextVoiceInfo aNf = null;
    private TbRichTextEmotionInfo aNh = null;
    private e aNi = null;
    private TbRichTextLinkButtonInfo aNk = null;
    private TbRichTextLinkImageInfo aNj = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.aNA = tbRichTextCommInfo;
        this.aNd = tbRichTextImageInfo;
        this.aNf = tbRichTextVoiceInfo;
        this.aNh = tbRichTextEmotionInfo;
        this.aNk = tbRichTextLinkButtonInfo;
        this.aNj = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo HP() {
        if (this.mType == 1280) {
            return this.aNj;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo HQ() {
        if (this.mType == 1024) {
            return this.aNk;
        }
        return null;
    }

    public TbRichTextImageInfo HI() {
        if (this.mType == 8) {
            return this.aNd;
        }
        return null;
    }

    public e HM() {
        if (this.mType != 32) {
            return null;
        }
        return this.aNi;
    }

    public TbRichTextVoiceInfo HK() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aNf;
        }
        return null;
    }

    public TbRichTextEmotionInfo HN() {
        if (this.mType == 17) {
            return this.aNh;
        }
        return null;
    }

    public TbRichTextGraffitiInfo HR() {
        if (this.mType == 1536) {
            return this.aNl;
        }
        return null;
    }

    private SpannableString HZ() {
        if (this.mType != 1 || this.aNA == null) {
            return null;
        }
        return new SpannableString(this.aNA.getText());
    }

    private CharSequence t(ArrayList<a> arrayList) {
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.aNA != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.m9getInst().getString(w.l.video_text));
            CharSequence v = v(arrayList);
            if (v != null) {
                spannableStringBuilder.append(v);
            }
            if (this.aNA.HD() == 1) {
                a = a(this.mType, this.aNA.getText(), this.aNA.HE(), 0);
            } else {
                a = a(this.mType, this.aNA.getText(), this.aNA.getText(), 0);
            }
            if (a != null) {
                spannableStringBuilder.append((CharSequence) a);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence u(ArrayList<a> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.aNA != null) {
            CharSequence v = v(arrayList);
            if (v != null) {
                spannableStringBuilder.append(v);
            }
            SpannableString a = a(this.mType, this.aNA.getLink(), this.aNA.getLink(), 0);
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
        if (this.mType != 32 || this.aNA == null) {
            return null;
        }
        if (this.aNA.HD() == 1) {
            return this.aNA.HE();
        }
        return this.aNA.getText();
    }

    private SpannableString Ia() {
        if ((this.mType != 2 && this.mType != 18) || this.aNA == null) {
            return null;
        }
        if (this.aNA.HD() == 1) {
            return a(this.mType, this.aNA.getText(), this.aNA.HE(), 0);
        }
        return a(this.mType, this.aNA.getText(), this.aNA.getLink(), this.aNA.HF());
    }

    private SpannableString Ib() {
        if (this.mType != 256 || this.aNA == null) {
            return null;
        }
        String text = this.aNA.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = String.valueOf(text) + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        b bVar = new b(this.mType, text);
        bVar.gs(this.aNA.getLink());
        spannableString.setSpan(bVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString Ic() {
        if (this.mType != 16 || this.aNA == null) {
            return null;
        }
        return a(this.mType, this.aNA.getText(), this.aNA.getLink(), 0);
    }

    private SpannableString w(ArrayList<a> arrayList) {
        String text;
        int ff;
        a.C0045a fH;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.aNA != null && this.aNA.getText() != null && this.aNA.getLink() != null && (ff = TbFaceManager.DM().ff((text = this.aNA.getText()))) != 0) {
            String str = "#(" + TbFaceManager.DM().fh(text) + ")";
            spannableString = new SpannableString(String.valueOf(str) + " ");
            a aVar = new a(TbadkCoreApplication.m9getInst().getContext(), ff);
            if (arrayList != null) {
                arrayList.add(aVar);
            }
            if (TbFaceManager.DM().fH(text) != null) {
                int width = (int) (fH.getWidth() * 0.5d);
                aVar.setBounds(new Rect(0, 0, width, width));
            } else {
                aVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new com.baidu.tbadk.widget.h(aVar), 0, str.length(), 33);
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

    private SpannableString Id() {
        if (this.mType != 1024 || this.aNk == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString("a");
        Drawable fv = c.fv(this.aNk.btn_type);
        fv.setBounds(0, 0, fv.getIntrinsicWidth(), fv.getIntrinsicHeight());
        com.baidu.tbadk.widget.h hVar = new com.baidu.tbadk.widget.h(fv);
        hVar.setVerticalOffset(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getContext(), w.f.ds4));
        spannableString.setSpan(hVar, 0, 1, 33);
        spannableString.setSpan(new b(1024, this.aNk.link), spannableString.length() - 1, "a".length(), 33);
        return spannableString;
    }

    public CharSequence x(ArrayList<a> arrayList) {
        switch (this.mType) {
            case 1:
                return HZ();
            case 2:
                return Ia();
            case 4:
                return w(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return Ic();
            case 18:
                return Ia();
            case 32:
                return t(arrayList);
            case 128:
                return u(arrayList);
            case 256:
                return Ib();
            case 1024:
                return Id();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.aNi.In() != false) goto L9;
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
                    this.aNd = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.aNA = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.aNh = new TbRichTextEmotionInfo();
                    this.aNh.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.aNh.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.aNh.mGifInfo.mStaticUrl = pbContent._static;
                    this.aNh.mType = this.mType;
                    this.aNh.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.aNh.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.aNh.mGifInfo.mPackageName = pbContent.packet_name;
                    this.aNh.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.aNh.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.aNh.mGifInfo.mGid = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.aNh.mGifInfo.mGid = split[i].split("_")[0];
                case 512:
                    this.aNf = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.aNk = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case 1280:
                    this.aNj = new TbRichTextLinkImageInfo(pbContent);
                    break;
                case 1536:
                    this.aNl = new TbRichTextGraffitiInfo();
                    this.aNl.a(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.aNi = new e();
                        this.aNi.a(pbContent);
                        break;
                    }
                    this.aNA = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.DM().ff(this.aNA.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.m9getInst().getString(w.l.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.aNA.setText(str);
                            break;
                        } else {
                            this.aNA.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.aNA.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.aNA != null) {
                this.aNA.HG();
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
                this.aNd = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.aNf = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.aNA = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString(SapiAccountManager.SESSION_UID));
            } else if (this.mType == 17) {
                this.aNh = new TbRichTextEmotionInfo();
                this.aNh.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.aNh.mGifInfo.mDynamicUrl = jSONObject.optString("dynamic");
                this.aNh.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.aNh.mType = this.mType;
                this.aNh.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.aNh.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.aNh.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.aNh.mGifInfo.mIcon = jSONObject.optString("icon");
                String[] split = this.aNh.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.aNh.mGifInfo.mGid = split[i].split("_")[0];
            } else {
                this.aNA = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int ff = TbFaceManager.DM().ff(this.aNA.getText());
                    String optString = jSONObject.optString("c");
                    if (ff <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.m9getInst().getString(w.l.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.aNA.setText(str);
                    } else {
                        this.aNA.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.aNA.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.aNA != null) {
                this.aNA.HG();
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
