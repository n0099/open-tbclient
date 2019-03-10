package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.k;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.d;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextItem extends OrmObject {
    private TbRichTextMemeInfo cCM;
    private int mType = 0;
    private TbRichTextCommInfo cDe = null;
    private TbRichTextImageInfo cCF = null;
    private TbRichTextVoiceInfo bTm = null;
    private TbRichTextEmotionInfo cCI = null;
    private f cCJ = null;
    private TbRichTextLinkButtonInfo cCL = null;
    private TbRichTextLinkImageInfo cCK = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.cDe = tbRichTextCommInfo;
        this.cCF = tbRichTextImageInfo;
        this.bTm = tbRichTextVoiceInfo;
        this.cCI = tbRichTextEmotionInfo;
        this.cCL = tbRichTextLinkButtonInfo;
        this.cCK = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo asM() {
        if (this.mType == 1280) {
            return this.cCK;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo asN() {
        if (this.mType == 1024) {
            return this.cCL;
        }
        return null;
    }

    public TbRichTextImageInfo asE() {
        if (this.mType == 8) {
            return this.cCF;
        }
        return null;
    }

    public f asI() {
        if (this.mType != 32) {
            return null;
        }
        return this.cCJ;
    }

    public TbRichTextVoiceInfo asG() {
        if (this.mType == 512 || this.mType == 768) {
            return this.bTm;
        }
        return null;
    }

    public TbRichTextEmotionInfo asJ() {
        if (this.mType == 17) {
            return this.cCI;
        }
        return null;
    }

    public TbRichTextMemeInfo asK() {
        if (this.mType == 20) {
            return this.cCM;
        }
        return null;
    }

    private SpannableString asY() {
        if (this.mType != 1 || this.cDe == null) {
            return null;
        }
        return new SpannableString(this.cDe.getText());
    }

    private CharSequence z(ArrayList<b> arrayList) {
        SpannableString b;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.cDe != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(d.j.video_text));
            CharSequence B = B(arrayList);
            if (B != null) {
                spannableStringBuilder.append(B);
            }
            if (this.cDe.asz() == 1) {
                b = b(this.mType, this.cDe.getText(), this.cDe.asA(), 0);
            } else {
                b = b(this.mType, this.cDe.getText(), this.cDe.getText(), 0);
            }
            if (b != null) {
                spannableStringBuilder.append((CharSequence) b);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence A(ArrayList<b> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.cDe != null) {
            CharSequence B = B(arrayList);
            if (B != null) {
                spannableStringBuilder.append(B);
            }
            SpannableString b = b(this.mType, this.cDe.getLink(), this.cDe.getLink(), 0);
            if (b != null) {
                spannableStringBuilder.append((CharSequence) b);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence B(ArrayList<b> arrayList) {
        TbRichTextItem tbRichTextItem = new TbRichTextItem();
        tbRichTextItem.a(4, new TbRichTextCommInfo("video_icon", " "), null, null, null, null, null);
        return tbRichTextItem.D(arrayList);
    }

    public String getVideoUrl() {
        if (this.mType != 32 || this.cDe == null) {
            return null;
        }
        if (this.cDe.asz() == 1) {
            return this.cDe.asA();
        }
        return this.cDe.getText();
    }

    private SpannableString asZ() {
        if ((this.mType != 2 && this.mType != 18) || this.cDe == null) {
            return null;
        }
        if (this.cDe.asz() == 1) {
            return b(this.mType, this.cDe.getText(), this.cDe.asA(), 0);
        }
        return b(this.mType, this.cDe.getText(), this.cDe.getLink(), this.cDe.asB());
    }

    private SpannableString ata() {
        if (this.mType != 256 || this.cDe == null) {
            return null;
        }
        String text = this.cDe.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = text + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        c cVar = new c(this.mType, text);
        cVar.qc(this.cDe.getLink());
        spannableString.setSpan(cVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString atb() {
        if (this.mType != 16 || this.cDe == null) {
            return null;
        }
        return b(this.mType, this.cDe.getText(), this.cDe.getLink(), 0);
    }

    private SpannableString C(ArrayList<b> arrayList) {
        String text;
        int oG;
        a.C0204a pd;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.cDe != null && this.cDe.getText() != null && this.cDe.getLink() != null && (oG = TbFaceManager.anp().oG((text = this.cDe.getText()))) != 0) {
            String str = "#(" + TbFaceManager.anp().oI(text) + ")";
            spannableString = new SpannableString(str + " ");
            b bVar = new b(TbadkCoreApplication.getInst().getContext(), oG);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            if (TbFaceManager.anp().pd(text) != null) {
                int width = (int) (0.5d * pd.getWidth());
                bVar.setBounds(new Rect(0, 0, width, width));
            } else {
                bVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new com.baidu.tbadk.widget.a(bVar, 1), 0, str.length(), 33);
        }
        return spannableString;
    }

    private SpannableString b(int i, String str, final String str2, int i2) {
        c cVar;
        if (str == null) {
            return null;
        }
        if (!str.endsWith(" ")) {
            str = str + " ";
        }
        SpannableString spannableString = new SpannableString(str);
        if (this.mType == 18) {
            cVar = new c(i, str2) { // from class: com.baidu.tbadk.widget.richText.TbRichTextItem.1
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    TbRichTextItem.this.lp(str2);
                }
            };
        } else {
            cVar = new c(i, str2);
        }
        cVar.kM(i2);
        if (i2 == 1) {
            cVar.setTextColor(d.C0236d.cp_cont_d);
        } else {
            cVar.setTextColor(-1);
        }
        spannableString.setSpan(cVar, 0, str.length() - 1, 33);
        return spannableString;
    }

    private SpannableString atc() {
        if (this.mType != 1024 || this.cCL == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString("a");
        Drawable kO = d.kO(this.cCL.btn_type);
        kO.setBounds(0, 0, kO.getIntrinsicWidth(), kO.getIntrinsicHeight());
        com.baidu.tbadk.widget.c cVar = new com.baidu.tbadk.widget.c(kO);
        cVar.setVerticalOffset(l.h(TbadkCoreApplication.getInst().getContext(), d.e.ds4));
        spannableString.setSpan(cVar, 0, 1, 33);
        spannableString.setSpan(new c(1024, this.cCL.link), spannableString.length() - 1, "a".length(), 33);
        return spannableString;
    }

    public CharSequence D(ArrayList<b> arrayList) {
        switch (this.mType) {
            case 1:
                return asY();
            case 2:
                return asZ();
            case 4:
                return C(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return atb();
            case 18:
                return asZ();
            case 32:
                return z(arrayList);
            case 128:
                return A(arrayList);
            case 256:
                return ata();
            case 1024:
                return atc();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.cCJ.atm() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = kN(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.cCF = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.cDe = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.cCI = new TbRichTextEmotionInfo();
                    this.cCI.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.cCI.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.cCI.mGifInfo.mStaticUrl = pbContent._static;
                    this.cCI.mType = this.mType;
                    this.cCI.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.cCI.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.cCI.mGifInfo.mPackageName = pbContent.packet_name;
                    this.cCI.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.cCI.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.cCI.mGifInfo.mGid = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.cCI.mGifInfo.mGid = split[i].split("_")[0];
                case 20:
                    this.cCM = new TbRichTextMemeInfo();
                    this.cCM.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.bTm = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.cCL = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case 1280:
                    this.cCK = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.cCJ = new f();
                        this.cCJ.b(pbContent);
                        break;
                    }
                    this.cDe = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.anp().oG(this.cDe.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(d.j.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.cDe.setText(str);
                            break;
                        } else {
                            this.cDe.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.cDe.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.cDe != null) {
                this.cDe.asC();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = kN(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.cCF = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.bTm = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.cDe = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.cCI = new TbRichTextEmotionInfo();
                this.cCI.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.cCI.mGifInfo.mDynamicUrl = jSONObject.optString("dynamic");
                this.cCI.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.cCI.mType = this.mType;
                this.cCI.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.cCI.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.cCI.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.cCI.mGifInfo.mIcon = jSONObject.optString("icon");
                String[] split = this.cCI.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.cCI.mGifInfo.mGid = split[i].split("_")[0];
            } else {
                this.cDe = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int oG = TbFaceManager.anp().oG(this.cDe.getText());
                    String optString = jSONObject.optString("c");
                    if (oG <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(d.j.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.cDe.setText(str);
                    } else {
                        this.cDe.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.cDe.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.cDe != null) {
                this.cDe.asC();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int kN(int i) {
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
            case 16:
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
            case 18:
                return 18;
            case 20:
                return 20;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lp(String str) {
        if (!TextUtils.isEmpty(str)) {
            k kVar = new k();
            kVar.mLink = str;
            kVar.type = 0;
            kVar.chu = "1";
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, kVar));
        }
    }
}
