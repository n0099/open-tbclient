package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.d;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextItem extends OrmObject {
    private TbRichTextGraffitiInfo aPG;
    private TbRichTextMemeInfo aPH;
    private int mType = 0;
    private TbRichTextCommInfo aPW = null;
    private TbRichTextImageInfo aPz = null;
    private TbRichTextVoiceInfo anN = null;
    private TbRichTextEmotionInfo aPC = null;
    private e aPD = null;
    private TbRichTextLinkButtonInfo aPF = null;
    private TbRichTextLinkImageInfo aPE = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.aPW = tbRichTextCommInfo;
        this.aPz = tbRichTextImageInfo;
        this.anN = tbRichTextVoiceInfo;
        this.aPC = tbRichTextEmotionInfo;
        this.aPF = tbRichTextLinkButtonInfo;
        this.aPE = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo Iu() {
        if (this.mType == 1280) {
            return this.aPE;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo Iv() {
        if (this.mType == 1024) {
            return this.aPF;
        }
        return null;
    }

    public TbRichTextImageInfo Im() {
        if (this.mType == 8) {
            return this.aPz;
        }
        return null;
    }

    public e Iq() {
        if (this.mType != 32) {
            return null;
        }
        return this.aPD;
    }

    public TbRichTextVoiceInfo Io() {
        if (this.mType == 512 || this.mType == 768) {
            return this.anN;
        }
        return null;
    }

    public TbRichTextEmotionInfo Ir() {
        if (this.mType == 17) {
            return this.aPC;
        }
        return null;
    }

    public TbRichTextMemeInfo Is() {
        if (this.mType == 20) {
            return this.aPH;
        }
        return null;
    }

    public TbRichTextGraffitiInfo Iw() {
        if (this.mType == 1536) {
            return this.aPG;
        }
        return null;
    }

    private SpannableString IE() {
        if (this.mType != 1 || this.aPW == null) {
            return null;
        }
        return new SpannableString(this.aPW.getText());
    }

    private CharSequence t(ArrayList<a> arrayList) {
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.aPW != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(d.l.video_text));
            CharSequence v = v(arrayList);
            if (v != null) {
                spannableStringBuilder.append(v);
            }
            if (this.aPW.Ih() == 1) {
                a = a(this.mType, this.aPW.getText(), this.aPW.Ii(), 0);
            } else {
                a = a(this.mType, this.aPW.getText(), this.aPW.getText(), 0);
            }
            if (a != null) {
                spannableStringBuilder.append((CharSequence) a);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence u(ArrayList<a> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.aPW != null) {
            CharSequence v = v(arrayList);
            if (v != null) {
                spannableStringBuilder.append(v);
            }
            SpannableString a = a(this.mType, this.aPW.getLink(), this.aPW.getLink(), 0);
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
        if (this.mType != 32 || this.aPW == null) {
            return null;
        }
        if (this.aPW.Ih() == 1) {
            return this.aPW.Ii();
        }
        return this.aPW.getText();
    }

    private SpannableString IF() {
        if ((this.mType != 2 && this.mType != 18) || this.aPW == null) {
            return null;
        }
        if (this.aPW.Ih() == 1) {
            return a(this.mType, this.aPW.getText(), this.aPW.Ii(), 0);
        }
        return a(this.mType, this.aPW.getText(), this.aPW.getLink(), this.aPW.Ij());
    }

    private SpannableString IG() {
        if (this.mType != 256 || this.aPW == null) {
            return null;
        }
        String text = this.aPW.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = text + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        b bVar = new b(this.mType, text);
        bVar.gU(this.aPW.getLink());
        spannableString.setSpan(bVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString IH() {
        if (this.mType != 16 || this.aPW == null) {
            return null;
        }
        return a(this.mType, this.aPW.getText(), this.aPW.getLink(), 0);
    }

    private SpannableString w(ArrayList<a> arrayList) {
        String text;
        int fB;
        a.C0057a gd;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.aPW != null && this.aPW.getText() != null && this.aPW.getLink() != null && (fB = TbFaceManager.Eo().fB((text = this.aPW.getText()))) != 0) {
            String str = "#(" + TbFaceManager.Eo().fD(text) + ")";
            spannableString = new SpannableString(str + " ");
            a aVar = new a(TbadkCoreApplication.getInst().getContext(), fB);
            if (arrayList != null) {
                arrayList.add(aVar);
            }
            if (TbFaceManager.Eo().gd(text) != null) {
                int width = (int) (0.5d * gd.getWidth());
                aVar.setBounds(new Rect(0, 0, width, width));
            } else {
                aVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new com.baidu.tbadk.widget.c(aVar), 0, str.length(), 33);
        }
        return spannableString;
    }

    private SpannableString a(int i, String str, String str2, int i2) {
        SpannableString spannableString = null;
        if (str != null) {
            if (!str.endsWith(" ")) {
                str = str + " ";
            }
            spannableString = new SpannableString(str);
            b bVar = new b(i, str2);
            bVar.fz(i2);
            if (i2 == 1) {
                bVar.setTextColor(d.e.cp_cont_d);
            } else {
                bVar.setTextColor(-1);
            }
            spannableString.setSpan(bVar, 0, str.length() - 1, 33);
        }
        return spannableString;
    }

    private SpannableString II() {
        if (this.mType != 1024 || this.aPF == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString("a");
        Drawable fB = c.fB(this.aPF.btn_type);
        fB.setBounds(0, 0, fB.getIntrinsicWidth(), fB.getIntrinsicHeight());
        com.baidu.tbadk.widget.c cVar = new com.baidu.tbadk.widget.c(fB);
        cVar.setVerticalOffset(k.g(TbadkCoreApplication.getInst().getContext(), d.f.ds4));
        spannableString.setSpan(cVar, 0, 1, 33);
        spannableString.setSpan(new b(1024, this.aPF.link), spannableString.length() - 1, "a".length(), 33);
        return spannableString;
    }

    public CharSequence x(ArrayList<a> arrayList) {
        switch (this.mType) {
            case 1:
                return IE();
            case 2:
                return IF();
            case 4:
                return w(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return IH();
            case 18:
                return IF();
            case 32:
                return t(arrayList);
            case 128:
                return u(arrayList);
            case 256:
                return IG();
            case 1024:
                return II();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.aPD.IS() != false) goto L9;
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
                    this.aPz = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.aPW = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.aPC = new TbRichTextEmotionInfo();
                    this.aPC.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.aPC.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.aPC.mGifInfo.mStaticUrl = pbContent._static;
                    this.aPC.mType = this.mType;
                    this.aPC.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.aPC.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.aPC.mGifInfo.mPackageName = pbContent.packet_name;
                    this.aPC.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.aPC.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.aPC.mGifInfo.mGid = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.aPC.mGifInfo.mGid = split[i].split("_")[0];
                case 20:
                    this.aPH = new TbRichTextMemeInfo();
                    this.aPH.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.anN = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.aPF = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case 1280:
                    this.aPE = new TbRichTextLinkImageInfo(pbContent);
                    break;
                case 1536:
                    this.aPG = new TbRichTextGraffitiInfo();
                    this.aPG.a(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.aPD = new e();
                        this.aPD.a(pbContent);
                        break;
                    }
                    this.aPW = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.Eo().fB(this.aPW.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(d.l.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.aPW.setText(str);
                            break;
                        } else {
                            this.aPW.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.aPW.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.aPW != null) {
                this.aPW.Ik();
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
                this.aPz = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.anN = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.aPW = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString(SapiAccountManager.SESSION_UID));
            } else if (this.mType == 17) {
                this.aPC = new TbRichTextEmotionInfo();
                this.aPC.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.aPC.mGifInfo.mDynamicUrl = jSONObject.optString("dynamic");
                this.aPC.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.aPC.mType = this.mType;
                this.aPC.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.aPC.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.aPC.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.aPC.mGifInfo.mIcon = jSONObject.optString("icon");
                String[] split = this.aPC.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.aPC.mGifInfo.mGid = split[i].split("_")[0];
            } else {
                this.aPW = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int fB = TbFaceManager.Eo().fB(this.aPW.getText());
                    String optString = jSONObject.optString("c");
                    if (fB <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(d.l.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.aPW.setText(str);
                    } else {
                        this.aPW.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.aPW.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.aPW != null) {
                this.aPW.Ik();
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
            case 19:
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
            case 20:
                return 20;
        }
    }
}
