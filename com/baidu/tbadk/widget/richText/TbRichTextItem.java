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
import com.baidu.mobstat.Config;
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
    private TbRichTextMemeInfo cCJ;
    private int mType = 0;
    private TbRichTextCommInfo cDb = null;
    private TbRichTextImageInfo cCC = null;
    private TbRichTextVoiceInfo bTn = null;
    private TbRichTextEmotionInfo cCF = null;
    private f cCG = null;
    private TbRichTextLinkButtonInfo cCI = null;
    private TbRichTextLinkImageInfo cCH = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.cDb = tbRichTextCommInfo;
        this.cCC = tbRichTextImageInfo;
        this.bTn = tbRichTextVoiceInfo;
        this.cCF = tbRichTextEmotionInfo;
        this.cCI = tbRichTextLinkButtonInfo;
        this.cCH = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo asL() {
        if (this.mType == 1280) {
            return this.cCH;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo asM() {
        if (this.mType == 1024) {
            return this.cCI;
        }
        return null;
    }

    public TbRichTextImageInfo asD() {
        if (this.mType == 8) {
            return this.cCC;
        }
        return null;
    }

    public f asH() {
        if (this.mType != 32) {
            return null;
        }
        return this.cCG;
    }

    public TbRichTextVoiceInfo asF() {
        if (this.mType == 512 || this.mType == 768) {
            return this.bTn;
        }
        return null;
    }

    public TbRichTextEmotionInfo asI() {
        if (this.mType == 17) {
            return this.cCF;
        }
        return null;
    }

    public TbRichTextMemeInfo asJ() {
        if (this.mType == 20) {
            return this.cCJ;
        }
        return null;
    }

    private SpannableString asX() {
        if (this.mType != 1 || this.cDb == null) {
            return null;
        }
        return new SpannableString(this.cDb.getText());
    }

    private CharSequence z(ArrayList<b> arrayList) {
        SpannableString b;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.cDb != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(d.j.video_text));
            CharSequence B = B(arrayList);
            if (B != null) {
                spannableStringBuilder.append(B);
            }
            if (this.cDb.asy() == 1) {
                b = b(this.mType, this.cDb.getText(), this.cDb.asz(), 0);
            } else {
                b = b(this.mType, this.cDb.getText(), this.cDb.getText(), 0);
            }
            if (b != null) {
                spannableStringBuilder.append((CharSequence) b);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence A(ArrayList<b> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.cDb != null) {
            CharSequence B = B(arrayList);
            if (B != null) {
                spannableStringBuilder.append(B);
            }
            SpannableString b = b(this.mType, this.cDb.getLink(), this.cDb.getLink(), 0);
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
        if (this.mType != 32 || this.cDb == null) {
            return null;
        }
        if (this.cDb.asy() == 1) {
            return this.cDb.asz();
        }
        return this.cDb.getText();
    }

    private SpannableString asY() {
        if ((this.mType != 2 && this.mType != 18) || this.cDb == null) {
            return null;
        }
        if (this.cDb.asy() == 1) {
            return b(this.mType, this.cDb.getText(), this.cDb.asz(), 0);
        }
        return b(this.mType, this.cDb.getText(), this.cDb.getLink(), this.cDb.asA());
    }

    private SpannableString asZ() {
        if (this.mType != 256 || this.cDb == null) {
            return null;
        }
        String text = this.cDb.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = text + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        c cVar = new c(this.mType, text);
        cVar.qa(this.cDb.getLink());
        spannableString.setSpan(cVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString ata() {
        if (this.mType != 16 || this.cDb == null) {
            return null;
        }
        return b(this.mType, this.cDb.getText(), this.cDb.getLink(), 0);
    }

    private SpannableString C(ArrayList<b> arrayList) {
        String text;
        int oG;
        a.C0238a pd;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.cDb != null && this.cDb.getText() != null && this.cDb.getLink() != null && (oG = TbFaceManager.ano().oG((text = this.cDb.getText()))) != 0) {
            String str = "#(" + TbFaceManager.ano().oI(text) + ")";
            spannableString = new SpannableString(str + " ");
            b bVar = new b(TbadkCoreApplication.getInst().getContext(), oG);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            if (TbFaceManager.ano().pd(text) != null) {
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
            cVar.setTextColor(d.C0277d.cp_cont_d);
        } else {
            cVar.setTextColor(-1);
        }
        spannableString.setSpan(cVar, 0, str.length() - 1, 33);
        return spannableString;
    }

    private SpannableString atb() {
        if (this.mType != 1024 || this.cCI == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(Config.APP_VERSION_CODE);
        Drawable kO = d.kO(this.cCI.btn_type);
        kO.setBounds(0, 0, kO.getIntrinsicWidth(), kO.getIntrinsicHeight());
        com.baidu.tbadk.widget.c cVar = new com.baidu.tbadk.widget.c(kO);
        cVar.setVerticalOffset(l.h(TbadkCoreApplication.getInst().getContext(), d.e.ds4));
        spannableString.setSpan(cVar, 0, 1, 33);
        spannableString.setSpan(new c(1024, this.cCI.link), spannableString.length() - 1, Config.APP_VERSION_CODE.length(), 33);
        return spannableString;
    }

    public CharSequence D(ArrayList<b> arrayList) {
        switch (this.mType) {
            case 1:
                return asX();
            case 2:
                return asY();
            case 4:
                return C(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return ata();
            case 18:
                return asY();
            case 32:
                return z(arrayList);
            case 128:
                return A(arrayList);
            case 256:
                return asZ();
            case 1024:
                return atb();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.cCG.atl() != false) goto L9;
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
                    this.cCC = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.cDb = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.cCF = new TbRichTextEmotionInfo();
                    this.cCF.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.cCF.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.cCF.mGifInfo.mStaticUrl = pbContent._static;
                    this.cCF.mType = this.mType;
                    this.cCF.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.cCF.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.cCF.mGifInfo.mPackageName = pbContent.packet_name;
                    this.cCF.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.cCF.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.cCF.mGifInfo.mGid = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.cCF.mGifInfo.mGid = split[i].split("_")[0];
                case 20:
                    this.cCJ = new TbRichTextMemeInfo();
                    this.cCJ.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.bTn = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.cCI = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case 1280:
                    this.cCH = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.cCG = new f();
                        this.cCG.b(pbContent);
                        break;
                    }
                    this.cDb = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.ano().oG(this.cDb.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(d.j.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.cDb.setText(str);
                            break;
                        } else {
                            this.cDb.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.cDb.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.cDb != null) {
                this.cDb.asB();
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
                this.cCC = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.bTn = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.cDb = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.cCF = new TbRichTextEmotionInfo();
                this.cCF.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.cCF.mGifInfo.mDynamicUrl = jSONObject.optString("dynamic");
                this.cCF.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.cCF.mType = this.mType;
                this.cCF.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.cCF.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.cCF.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.cCF.mGifInfo.mIcon = jSONObject.optString("icon");
                String[] split = this.cCF.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.cCF.mGifInfo.mGid = split[i].split("_")[0];
            } else {
                this.cDb = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int oG = TbFaceManager.ano().oG(this.cDb.getText());
                    String optString = jSONObject.optString("c");
                    if (oG <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(d.j.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.cDb.setText(str);
                    } else {
                        this.cDb.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.cDb.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.cDb != null) {
                this.cDb.asB();
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
