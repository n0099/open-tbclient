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
import com.baidu.tieba.R;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextItem extends OrmObject {
    private TbRichTextMemeInfo cKU;
    private int mType = 0;
    private TbRichTextCommInfo cLm = null;
    private TbRichTextImageInfo cKN = null;
    private TbRichTextVoiceInfo cbi = null;
    private TbRichTextEmotionInfo cKQ = null;
    private f cKR = null;
    private TbRichTextLinkButtonInfo cKT = null;
    private TbRichTextLinkImageInfo cKS = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.cLm = tbRichTextCommInfo;
        this.cKN = tbRichTextImageInfo;
        this.cbi = tbRichTextVoiceInfo;
        this.cKQ = tbRichTextEmotionInfo;
        this.cKT = tbRichTextLinkButtonInfo;
        this.cKS = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo axO() {
        if (this.mType == 1280) {
            return this.cKS;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo axP() {
        if (this.mType == 1024) {
            return this.cKT;
        }
        return null;
    }

    public TbRichTextImageInfo axG() {
        if (this.mType == 8) {
            return this.cKN;
        }
        return null;
    }

    public f axK() {
        if (this.mType != 32) {
            return null;
        }
        return this.cKR;
    }

    public TbRichTextVoiceInfo axI() {
        if (this.mType == 512 || this.mType == 768) {
            return this.cbi;
        }
        return null;
    }

    public TbRichTextEmotionInfo axL() {
        if (this.mType == 17) {
            return this.cKQ;
        }
        return null;
    }

    public TbRichTextMemeInfo axM() {
        if (this.mType == 20) {
            return this.cKU;
        }
        return null;
    }

    private SpannableString aya() {
        if (this.mType != 1 || this.cLm == null) {
            return null;
        }
        return new SpannableString(this.cLm.getText());
    }

    private CharSequence C(ArrayList<b> arrayList) {
        SpannableString b;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.cLm != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(R.string.video_text));
            CharSequence E = E(arrayList);
            if (E != null) {
                spannableStringBuilder.append(E);
            }
            if (this.cLm.axB() == 1) {
                b = b(this.mType, this.cLm.getText(), this.cLm.axC(), 0);
            } else {
                b = b(this.mType, this.cLm.getText(), this.cLm.getText(), 0);
            }
            if (b != null) {
                spannableStringBuilder.append((CharSequence) b);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence D(ArrayList<b> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.cLm != null) {
            CharSequence E = E(arrayList);
            if (E != null) {
                spannableStringBuilder.append(E);
            }
            SpannableString b = b(this.mType, this.cLm.getLink(), this.cLm.getLink(), 0);
            if (b != null) {
                spannableStringBuilder.append((CharSequence) b);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence E(ArrayList<b> arrayList) {
        TbRichTextItem tbRichTextItem = new TbRichTextItem();
        tbRichTextItem.a(4, new TbRichTextCommInfo("video_icon", " "), null, null, null, null, null);
        return tbRichTextItem.G(arrayList);
    }

    public String getVideoUrl() {
        if (this.mType != 32 || this.cLm == null) {
            return null;
        }
        if (this.cLm.axB() == 1) {
            return this.cLm.axC();
        }
        return this.cLm.getText();
    }

    private SpannableString ayb() {
        if ((this.mType != 2 && this.mType != 18) || this.cLm == null) {
            return null;
        }
        if (this.cLm.axB() == 1) {
            return b(this.mType, this.cLm.getText(), this.cLm.axC(), 0);
        }
        return b(this.mType, this.cLm.getText(), this.cLm.getLink(), this.cLm.axD());
    }

    private SpannableString ayc() {
        if (this.mType != 256 || this.cLm == null) {
            return null;
        }
        String text = this.cLm.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = text + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        c cVar = new c(this.mType, text);
        cVar.rk(this.cLm.getLink());
        spannableString.setSpan(cVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString ayd() {
        if (this.mType != 16 || this.cLm == null) {
            return null;
        }
        return b(this.mType, this.cLm.getText(), this.cLm.getLink(), 0);
    }

    private SpannableString F(ArrayList<b> arrayList) {
        String text;
        int pP;
        a.C0253a qm;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.cLm != null && this.cLm.getText() != null && this.cLm.getLink() != null && (pP = TbFaceManager.aso().pP((text = this.cLm.getText()))) != 0) {
            String str = "#(" + TbFaceManager.aso().pR(text) + ")";
            spannableString = new SpannableString(str + " ");
            b bVar = new b(TbadkCoreApplication.getInst().getContext(), pP);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            if (TbFaceManager.aso().qm(text) != null) {
                int width = (int) (0.5d * qm.getWidth());
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
                    TbRichTextItem.this.mv(str2);
                }
            };
        } else {
            cVar = new c(i, str2);
        }
        cVar.lA(i2);
        if (i2 == 1) {
            cVar.setTextColor(R.color.cp_cont_d);
        } else {
            cVar.setTextColor(-1);
        }
        spannableString.setSpan(cVar, 0, str.length() - 1, 33);
        return spannableString;
    }

    private SpannableString aye() {
        if (this.mType != 1024 || this.cKT == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(Config.APP_VERSION_CODE);
        Drawable lC = d.lC(this.cKT.btn_type);
        lC.setBounds(0, 0, lC.getIntrinsicWidth(), lC.getIntrinsicHeight());
        com.baidu.tbadk.widget.c cVar = new com.baidu.tbadk.widget.c(lC);
        cVar.setVerticalOffset(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds4));
        spannableString.setSpan(cVar, 0, 1, 33);
        spannableString.setSpan(new c(1024, this.cKT.link), spannableString.length() - 1, Config.APP_VERSION_CODE.length(), 33);
        return spannableString;
    }

    public CharSequence G(ArrayList<b> arrayList) {
        switch (this.mType) {
            case 1:
                return aya();
            case 2:
                return ayb();
            case 4:
                return F(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return ayd();
            case 18:
                return ayb();
            case 32:
                return C(arrayList);
            case 128:
                return D(arrayList);
            case 256:
                return ayc();
            case 1024:
                return aye();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.cKR.ayo() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = lB(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.cKN = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.cLm = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.cKQ = new TbRichTextEmotionInfo();
                    this.cKQ.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.cKQ.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.cKQ.mGifInfo.mStaticUrl = pbContent._static;
                    this.cKQ.mType = this.mType;
                    this.cKQ.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.cKQ.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.cKQ.mGifInfo.mPackageName = pbContent.packet_name;
                    this.cKQ.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.cKQ.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.cKQ.mGifInfo.mGid = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.cKQ.mGifInfo.mGid = split[i].split("_")[0];
                case 20:
                    this.cKU = new TbRichTextMemeInfo();
                    this.cKU.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.cbi = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.cKT = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case 1280:
                    this.cKS = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.cKR = new f();
                        this.cKR.b(pbContent);
                        break;
                    }
                    this.cLm = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.aso().pP(this.cLm.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.cLm.setText(str);
                            break;
                        } else {
                            this.cLm.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.cLm.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.cLm != null) {
                this.cLm.axE();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = lB(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.cKN = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.cbi = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.cLm = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.cKQ = new TbRichTextEmotionInfo();
                this.cKQ.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.cKQ.mGifInfo.mDynamicUrl = jSONObject.optString("dynamic");
                this.cKQ.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.cKQ.mType = this.mType;
                this.cKQ.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.cKQ.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.cKQ.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.cKQ.mGifInfo.mIcon = jSONObject.optString("icon");
                String[] split = this.cKQ.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.cKQ.mGifInfo.mGid = split[i].split("_")[0];
            } else {
                this.cLm = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int pP = TbFaceManager.aso().pP(this.cLm.getText());
                    String optString = jSONObject.optString("c");
                    if (pP <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.cLm.setText(str);
                    } else {
                        this.cLm.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.cLm.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.cLm != null) {
                this.cLm.axE();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int lB(int i) {
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
    public void mv(String str) {
        if (!TextUtils.isEmpty(str)) {
            k kVar = new k();
            kVar.mLink = str;
            kVar.type = 0;
            kVar.cpF = "1";
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, kVar));
        }
    }
}
