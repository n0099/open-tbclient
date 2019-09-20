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
    private TbRichTextMemeInfo cNm;
    private int mType = 0;
    private TbRichTextCommInfo cNE = null;
    private TbRichTextImageInfo cNf = null;
    private TbRichTextVoiceInfo cdm = null;
    private TbRichTextEmotionInfo cNi = null;
    private f cNj = null;
    private TbRichTextLinkButtonInfo cNl = null;
    private TbRichTextLinkImageInfo cNk = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.cNE = tbRichTextCommInfo;
        this.cNf = tbRichTextImageInfo;
        this.cdm = tbRichTextVoiceInfo;
        this.cNi = tbRichTextEmotionInfo;
        this.cNl = tbRichTextLinkButtonInfo;
        this.cNk = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo azo() {
        if (this.mType == 1280) {
            return this.cNk;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo azp() {
        if (this.mType == 1024) {
            return this.cNl;
        }
        return null;
    }

    public TbRichTextImageInfo azg() {
        if (this.mType == 8) {
            return this.cNf;
        }
        return null;
    }

    public f azk() {
        if (this.mType != 32) {
            return null;
        }
        return this.cNj;
    }

    public TbRichTextVoiceInfo azi() {
        if (this.mType == 512 || this.mType == 768) {
            return this.cdm;
        }
        return null;
    }

    public TbRichTextEmotionInfo azl() {
        if (this.mType == 17) {
            return this.cNi;
        }
        return null;
    }

    public TbRichTextMemeInfo azm() {
        if (this.mType == 20) {
            return this.cNm;
        }
        return null;
    }

    private SpannableString azA() {
        if (this.mType != 1 || this.cNE == null) {
            return null;
        }
        return new SpannableString(this.cNE.getText());
    }

    private CharSequence C(ArrayList<b> arrayList) {
        SpannableString b;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.cNE != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(R.string.video_text));
            CharSequence E = E(arrayList);
            if (E != null) {
                spannableStringBuilder.append(E);
            }
            if (this.cNE.azb() == 1) {
                b = b(this.mType, this.cNE.getText(), this.cNE.azc(), 0);
            } else {
                b = b(this.mType, this.cNE.getText(), this.cNE.getText(), 0);
            }
            if (b != null) {
                spannableStringBuilder.append((CharSequence) b);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence D(ArrayList<b> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.cNE != null) {
            CharSequence E = E(arrayList);
            if (E != null) {
                spannableStringBuilder.append(E);
            }
            SpannableString b = b(this.mType, this.cNE.getLink(), this.cNE.getLink(), 0);
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
        if (this.mType != 32 || this.cNE == null) {
            return null;
        }
        if (this.cNE.azb() == 1) {
            return this.cNE.azc();
        }
        return this.cNE.getText();
    }

    private SpannableString azB() {
        if ((this.mType != 2 && this.mType != 18) || this.cNE == null) {
            return null;
        }
        if (this.cNE.azb() == 1) {
            return b(this.mType, this.cNE.getText(), this.cNE.azc(), 0);
        }
        return b(this.mType, this.cNE.getText(), this.cNE.getLink(), this.cNE.azd());
    }

    private SpannableString azC() {
        if (this.mType != 256 || this.cNE == null) {
            return null;
        }
        String text = this.cNE.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = text + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        c cVar = new c(this.mType, text);
        cVar.rM(this.cNE.getLink());
        spannableString.setSpan(cVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString azD() {
        if (this.mType != 16 || this.cNE == null) {
            return null;
        }
        return b(this.mType, this.cNE.getText(), this.cNE.getLink(), 0);
    }

    private SpannableString F(ArrayList<b> arrayList) {
        String text;
        int qq;
        a.C0264a qN;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.cNE != null && this.cNE.getText() != null && this.cNE.getLink() != null && (qq = TbFaceManager.atJ().qq((text = this.cNE.getText()))) != 0) {
            String str = "#(" + TbFaceManager.atJ().qs(text) + ")";
            spannableString = new SpannableString(str + " ");
            b bVar = new b(TbadkCoreApplication.getInst().getContext(), qq);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            if (TbFaceManager.atJ().qN(text) != null) {
                int width = (int) (0.5d * qN.getWidth());
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
                    TbRichTextItem.this.mH(str2);
                }
            };
        } else {
            cVar = new c(i, str2);
        }
        cVar.lL(i2);
        if (i2 == 1) {
            cVar.setTextColor(R.color.cp_cont_d);
        } else {
            cVar.setTextColor(-1);
        }
        spannableString.setSpan(cVar, 0, str.length() - 1, 33);
        return spannableString;
    }

    private SpannableString azE() {
        if (this.mType != 1024 || this.cNl == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(Config.APP_VERSION_CODE);
        Drawable lN = d.lN(this.cNl.btn_type);
        lN.setBounds(0, 0, lN.getIntrinsicWidth(), lN.getIntrinsicHeight());
        com.baidu.tbadk.widget.c cVar = new com.baidu.tbadk.widget.c(lN);
        cVar.setVerticalOffset(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds4));
        spannableString.setSpan(cVar, 0, 1, 33);
        spannableString.setSpan(new c(1024, this.cNl.link), spannableString.length() - 1, Config.APP_VERSION_CODE.length(), 33);
        return spannableString;
    }

    public CharSequence G(ArrayList<b> arrayList) {
        switch (this.mType) {
            case 1:
                return azA();
            case 2:
                return azB();
            case 4:
                return F(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return azD();
            case 18:
                return azB();
            case 32:
                return C(arrayList);
            case 128:
                return D(arrayList);
            case 256:
                return azC();
            case 1024:
                return azE();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.cNj.azO() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = lM(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.cNf = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.cNE = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.cNi = new TbRichTextEmotionInfo();
                    this.cNi.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.cNi.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.cNi.mGifInfo.mStaticUrl = pbContent._static;
                    this.cNi.mType = this.mType;
                    this.cNi.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.cNi.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.cNi.mGifInfo.mPackageName = pbContent.packet_name;
                    this.cNi.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.cNi.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.cNi.mGifInfo.mGid = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.cNi.mGifInfo.mGid = split[i].split("_")[0];
                case 20:
                    this.cNm = new TbRichTextMemeInfo();
                    this.cNm.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.cdm = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.cNl = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case 1280:
                    this.cNk = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.cNj = new f();
                        this.cNj.b(pbContent);
                        break;
                    }
                    this.cNE = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.atJ().qq(this.cNE.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.cNE.setText(str);
                            break;
                        } else {
                            this.cNE.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.cNE.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.cNE != null) {
                this.cNE.aze();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = lM(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.cNf = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.cdm = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.cNE = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.cNi = new TbRichTextEmotionInfo();
                this.cNi.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.cNi.mGifInfo.mDynamicUrl = jSONObject.optString("dynamic");
                this.cNi.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.cNi.mType = this.mType;
                this.cNi.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.cNi.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.cNi.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.cNi.mGifInfo.mIcon = jSONObject.optString("icon");
                String[] split = this.cNi.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.cNi.mGifInfo.mGid = split[i].split("_")[0];
            } else {
                this.cNE = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int qq = TbFaceManager.atJ().qq(this.cNE.getText());
                    String optString = jSONObject.optString("c");
                    if (qq <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.cNE.setText(str);
                    } else {
                        this.cNE.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.cNE.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.cNE != null) {
                this.cNE.aze();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int lM(int i) {
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
    public void mH(String str) {
        if (!TextUtils.isEmpty(str)) {
            k kVar = new k();
            kVar.mLink = str;
            kVar.type = 0;
            kVar.crU = "1";
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, kVar));
        }
    }
}
