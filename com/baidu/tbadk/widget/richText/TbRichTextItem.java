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
    private TbRichTextMemeInfo cMp;
    private int mType = 0;
    private TbRichTextCommInfo cMH = null;
    private TbRichTextImageInfo cMi = null;
    private TbRichTextVoiceInfo ccl = null;
    private TbRichTextEmotionInfo cMl = null;
    private f cMm = null;
    private TbRichTextLinkButtonInfo cMo = null;
    private TbRichTextLinkImageInfo cMn = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.cMH = tbRichTextCommInfo;
        this.cMi = tbRichTextImageInfo;
        this.ccl = tbRichTextVoiceInfo;
        this.cMl = tbRichTextEmotionInfo;
        this.cMo = tbRichTextLinkButtonInfo;
        this.cMn = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo aza() {
        if (this.mType == 1280) {
            return this.cMn;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo azb() {
        if (this.mType == 1024) {
            return this.cMo;
        }
        return null;
    }

    public TbRichTextImageInfo ayS() {
        if (this.mType == 8) {
            return this.cMi;
        }
        return null;
    }

    public f ayW() {
        if (this.mType != 32) {
            return null;
        }
        return this.cMm;
    }

    public TbRichTextVoiceInfo ayU() {
        if (this.mType == 512 || this.mType == 768) {
            return this.ccl;
        }
        return null;
    }

    public TbRichTextEmotionInfo ayX() {
        if (this.mType == 17) {
            return this.cMl;
        }
        return null;
    }

    public TbRichTextMemeInfo ayY() {
        if (this.mType == 20) {
            return this.cMp;
        }
        return null;
    }

    private SpannableString azm() {
        if (this.mType != 1 || this.cMH == null) {
            return null;
        }
        return new SpannableString(this.cMH.getText());
    }

    private CharSequence C(ArrayList<b> arrayList) {
        SpannableString b;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.cMH != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(R.string.video_text));
            CharSequence E = E(arrayList);
            if (E != null) {
                spannableStringBuilder.append(E);
            }
            if (this.cMH.ayN() == 1) {
                b = b(this.mType, this.cMH.getText(), this.cMH.ayO(), 0);
            } else {
                b = b(this.mType, this.cMH.getText(), this.cMH.getText(), 0);
            }
            if (b != null) {
                spannableStringBuilder.append((CharSequence) b);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence D(ArrayList<b> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.cMH != null) {
            CharSequence E = E(arrayList);
            if (E != null) {
                spannableStringBuilder.append(E);
            }
            SpannableString b = b(this.mType, this.cMH.getLink(), this.cMH.getLink(), 0);
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
        if (this.mType != 32 || this.cMH == null) {
            return null;
        }
        if (this.cMH.ayN() == 1) {
            return this.cMH.ayO();
        }
        return this.cMH.getText();
    }

    private SpannableString azn() {
        if ((this.mType != 2 && this.mType != 18) || this.cMH == null) {
            return null;
        }
        if (this.cMH.ayN() == 1) {
            return b(this.mType, this.cMH.getText(), this.cMH.ayO(), 0);
        }
        return b(this.mType, this.cMH.getText(), this.cMH.getLink(), this.cMH.ayP());
    }

    private SpannableString azo() {
        if (this.mType != 256 || this.cMH == null) {
            return null;
        }
        String text = this.cMH.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = text + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        c cVar = new c(this.mType, text);
        cVar.rB(this.cMH.getLink());
        spannableString.setSpan(cVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString azp() {
        if (this.mType != 16 || this.cMH == null) {
            return null;
        }
        return b(this.mType, this.cMH.getText(), this.cMH.getLink(), 0);
    }

    private SpannableString F(ArrayList<b> arrayList) {
        String text;
        int qf;
        a.C0250a qC;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.cMH != null && this.cMH.getText() != null && this.cMH.getLink() != null && (qf = TbFaceManager.atv().qf((text = this.cMH.getText()))) != 0) {
            String str = "#(" + TbFaceManager.atv().qh(text) + ")";
            spannableString = new SpannableString(str + " ");
            b bVar = new b(TbadkCoreApplication.getInst().getContext(), qf);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            if (TbFaceManager.atv().qC(text) != null) {
                int width = (int) (0.5d * qC.getWidth());
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
                    TbRichTextItem.this.mF(str2);
                }
            };
        } else {
            cVar = new c(i, str2);
        }
        cVar.lG(i2);
        if (i2 == 1) {
            cVar.setTextColor(R.color.cp_cont_d);
        } else {
            cVar.setTextColor(-1);
        }
        spannableString.setSpan(cVar, 0, str.length() - 1, 33);
        return spannableString;
    }

    private SpannableString azq() {
        if (this.mType != 1024 || this.cMo == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(Config.APP_VERSION_CODE);
        Drawable lI = d.lI(this.cMo.btn_type);
        lI.setBounds(0, 0, lI.getIntrinsicWidth(), lI.getIntrinsicHeight());
        com.baidu.tbadk.widget.c cVar = new com.baidu.tbadk.widget.c(lI);
        cVar.setVerticalOffset(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds4));
        spannableString.setSpan(cVar, 0, 1, 33);
        spannableString.setSpan(new c(1024, this.cMo.link), spannableString.length() - 1, Config.APP_VERSION_CODE.length(), 33);
        return spannableString;
    }

    public CharSequence G(ArrayList<b> arrayList) {
        switch (this.mType) {
            case 1:
                return azm();
            case 2:
                return azn();
            case 4:
                return F(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return azp();
            case 18:
                return azn();
            case 32:
                return C(arrayList);
            case 128:
                return D(arrayList);
            case 256:
                return azo();
            case 1024:
                return azq();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.cMm.azA() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = lH(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.cMi = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.cMH = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.cMl = new TbRichTextEmotionInfo();
                    this.cMl.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.cMl.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.cMl.mGifInfo.mStaticUrl = pbContent._static;
                    this.cMl.mType = this.mType;
                    this.cMl.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.cMl.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.cMl.mGifInfo.mPackageName = pbContent.packet_name;
                    this.cMl.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.cMl.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.cMl.mGifInfo.mGid = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.cMl.mGifInfo.mGid = split[i].split("_")[0];
                case 20:
                    this.cMp = new TbRichTextMemeInfo();
                    this.cMp.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.ccl = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.cMo = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case 1280:
                    this.cMn = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.cMm = new f();
                        this.cMm.b(pbContent);
                        break;
                    }
                    this.cMH = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.atv().qf(this.cMH.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.cMH.setText(str);
                            break;
                        } else {
                            this.cMH.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.cMH.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.cMH != null) {
                this.cMH.ayQ();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = lH(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.cMi = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.ccl = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.cMH = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.cMl = new TbRichTextEmotionInfo();
                this.cMl.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.cMl.mGifInfo.mDynamicUrl = jSONObject.optString("dynamic");
                this.cMl.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.cMl.mType = this.mType;
                this.cMl.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.cMl.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.cMl.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.cMl.mGifInfo.mIcon = jSONObject.optString("icon");
                String[] split = this.cMl.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.cMl.mGifInfo.mGid = split[i].split("_")[0];
            } else {
                this.cMH = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int qf = TbFaceManager.atv().qf(this.cMH.getText());
                    String optString = jSONObject.optString("c");
                    if (qf <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.cMH.setText(str);
                    } else {
                        this.cMH.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.cMH.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.cMH != null) {
                this.cMH.ayQ();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int lH(int i) {
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
    public void mF(String str) {
        if (!TextUtils.isEmpty(str)) {
            k kVar = new k();
            kVar.mLink = str;
            kVar.type = 0;
            kVar.cqS = "1";
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, kVar));
        }
    }
}
