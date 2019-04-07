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
    private TbRichTextMemeInfo cCL;
    private int mType = 0;
    private TbRichTextCommInfo cDd = null;
    private TbRichTextImageInfo cCE = null;
    private TbRichTextVoiceInfo bTp = null;
    private TbRichTextEmotionInfo cCH = null;
    private f cCI = null;
    private TbRichTextLinkButtonInfo cCK = null;
    private TbRichTextLinkImageInfo cCJ = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.cDd = tbRichTextCommInfo;
        this.cCE = tbRichTextImageInfo;
        this.bTp = tbRichTextVoiceInfo;
        this.cCH = tbRichTextEmotionInfo;
        this.cCK = tbRichTextLinkButtonInfo;
        this.cCJ = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo asI() {
        if (this.mType == 1280) {
            return this.cCJ;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo asJ() {
        if (this.mType == 1024) {
            return this.cCK;
        }
        return null;
    }

    public TbRichTextImageInfo asA() {
        if (this.mType == 8) {
            return this.cCE;
        }
        return null;
    }

    public f asE() {
        if (this.mType != 32) {
            return null;
        }
        return this.cCI;
    }

    public TbRichTextVoiceInfo asC() {
        if (this.mType == 512 || this.mType == 768) {
            return this.bTp;
        }
        return null;
    }

    public TbRichTextEmotionInfo asF() {
        if (this.mType == 17) {
            return this.cCH;
        }
        return null;
    }

    public TbRichTextMemeInfo asG() {
        if (this.mType == 20) {
            return this.cCL;
        }
        return null;
    }

    private SpannableString asU() {
        if (this.mType != 1 || this.cDd == null) {
            return null;
        }
        return new SpannableString(this.cDd.getText());
    }

    private CharSequence z(ArrayList<b> arrayList) {
        SpannableString b;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.cDd != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(d.j.video_text));
            CharSequence B = B(arrayList);
            if (B != null) {
                spannableStringBuilder.append(B);
            }
            if (this.cDd.asv() == 1) {
                b = b(this.mType, this.cDd.getText(), this.cDd.asw(), 0);
            } else {
                b = b(this.mType, this.cDd.getText(), this.cDd.getText(), 0);
            }
            if (b != null) {
                spannableStringBuilder.append((CharSequence) b);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence A(ArrayList<b> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.cDd != null) {
            CharSequence B = B(arrayList);
            if (B != null) {
                spannableStringBuilder.append(B);
            }
            SpannableString b = b(this.mType, this.cDd.getLink(), this.cDd.getLink(), 0);
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
        if (this.mType != 32 || this.cDd == null) {
            return null;
        }
        if (this.cDd.asv() == 1) {
            return this.cDd.asw();
        }
        return this.cDd.getText();
    }

    private SpannableString asV() {
        if ((this.mType != 2 && this.mType != 18) || this.cDd == null) {
            return null;
        }
        if (this.cDd.asv() == 1) {
            return b(this.mType, this.cDd.getText(), this.cDd.asw(), 0);
        }
        return b(this.mType, this.cDd.getText(), this.cDd.getLink(), this.cDd.asx());
    }

    private SpannableString asW() {
        if (this.mType != 256 || this.cDd == null) {
            return null;
        }
        String text = this.cDd.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = text + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        c cVar = new c(this.mType, text);
        cVar.qb(this.cDd.getLink());
        spannableString.setSpan(cVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString asX() {
        if (this.mType != 16 || this.cDd == null) {
            return null;
        }
        return b(this.mType, this.cDd.getText(), this.cDd.getLink(), 0);
    }

    private SpannableString C(ArrayList<b> arrayList) {
        String text;
        int oH;
        a.C0238a pe;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.cDd != null && this.cDd.getText() != null && this.cDd.getLink() != null && (oH = TbFaceManager.anl().oH((text = this.cDd.getText()))) != 0) {
            String str = "#(" + TbFaceManager.anl().oJ(text) + ")";
            spannableString = new SpannableString(str + " ");
            b bVar = new b(TbadkCoreApplication.getInst().getContext(), oH);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            if (TbFaceManager.anl().pe(text) != null) {
                int width = (int) (0.5d * pe.getWidth());
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
                    TbRichTextItem.this.lq(str2);
                }
            };
        } else {
            cVar = new c(i, str2);
        }
        cVar.kL(i2);
        if (i2 == 1) {
            cVar.setTextColor(d.C0277d.cp_cont_d);
        } else {
            cVar.setTextColor(-1);
        }
        spannableString.setSpan(cVar, 0, str.length() - 1, 33);
        return spannableString;
    }

    private SpannableString asY() {
        if (this.mType != 1024 || this.cCK == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(Config.APP_VERSION_CODE);
        Drawable kN = d.kN(this.cCK.btn_type);
        kN.setBounds(0, 0, kN.getIntrinsicWidth(), kN.getIntrinsicHeight());
        com.baidu.tbadk.widget.c cVar = new com.baidu.tbadk.widget.c(kN);
        cVar.setVerticalOffset(l.h(TbadkCoreApplication.getInst().getContext(), d.e.ds4));
        spannableString.setSpan(cVar, 0, 1, 33);
        spannableString.setSpan(new c(1024, this.cCK.link), spannableString.length() - 1, Config.APP_VERSION_CODE.length(), 33);
        return spannableString;
    }

    public CharSequence D(ArrayList<b> arrayList) {
        switch (this.mType) {
            case 1:
                return asU();
            case 2:
                return asV();
            case 4:
                return C(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return asX();
            case 18:
                return asV();
            case 32:
                return z(arrayList);
            case 128:
                return A(arrayList);
            case 256:
                return asW();
            case 1024:
                return asY();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.cCI.ati() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = kM(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.cCE = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.cDd = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.cCH = new TbRichTextEmotionInfo();
                    this.cCH.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.cCH.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.cCH.mGifInfo.mStaticUrl = pbContent._static;
                    this.cCH.mType = this.mType;
                    this.cCH.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.cCH.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.cCH.mGifInfo.mPackageName = pbContent.packet_name;
                    this.cCH.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.cCH.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.cCH.mGifInfo.mGid = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.cCH.mGifInfo.mGid = split[i].split("_")[0];
                case 20:
                    this.cCL = new TbRichTextMemeInfo();
                    this.cCL.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.bTp = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.cCK = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case 1280:
                    this.cCJ = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.cCI = new f();
                        this.cCI.b(pbContent);
                        break;
                    }
                    this.cDd = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.anl().oH(this.cDd.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(d.j.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.cDd.setText(str);
                            break;
                        } else {
                            this.cDd.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.cDd.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.cDd != null) {
                this.cDd.asy();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = kM(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.cCE = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.bTp = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.cDd = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.cCH = new TbRichTextEmotionInfo();
                this.cCH.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.cCH.mGifInfo.mDynamicUrl = jSONObject.optString("dynamic");
                this.cCH.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.cCH.mType = this.mType;
                this.cCH.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.cCH.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.cCH.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.cCH.mGifInfo.mIcon = jSONObject.optString("icon");
                String[] split = this.cCH.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.cCH.mGifInfo.mGid = split[i].split("_")[0];
            } else {
                this.cDd = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int oH = TbFaceManager.anl().oH(this.cDd.getText());
                    String optString = jSONObject.optString("c");
                    if (oH <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(d.j.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.cDd.setText(str);
                    } else {
                        this.cDd.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.cDd.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.cDd != null) {
                this.cDd.asy();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int kM(int i) {
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
    public void lq(String str) {
        if (!TextUtils.isEmpty(str)) {
            k kVar = new k();
            kVar.mLink = str;
            kVar.type = 0;
            kVar.chw = "1";
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, kVar));
        }
    }
}
