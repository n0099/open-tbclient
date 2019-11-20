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
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
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
    private TbRichTextMemeInfo cVN;
    private int mType = 0;
    private TbRichTextCommInfo cWf = null;
    private TbRichTextImageInfo cVG = null;
    private TbRichTextVoiceInfo cqI = null;
    private TbRichTextEmotionInfo cVJ = null;
    private f cVK = null;
    private TbRichTextLinkButtonInfo cVM = null;
    private TbRichTextLinkImageInfo cVL = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.cWf = tbRichTextCommInfo;
        this.cVG = tbRichTextImageInfo;
        this.cqI = tbRichTextVoiceInfo;
        this.cVJ = tbRichTextEmotionInfo;
        this.cVM = tbRichTextLinkButtonInfo;
        this.cVL = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo azv() {
        if (this.mType == 1280) {
            return this.cVL;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo azw() {
        if (this.mType == 1024) {
            return this.cVM;
        }
        return null;
    }

    public TbRichTextImageInfo azn() {
        if (this.mType == 8) {
            return this.cVG;
        }
        return null;
    }

    public f azr() {
        if (this.mType != 32) {
            return null;
        }
        return this.cVK;
    }

    public TbRichTextVoiceInfo azp() {
        if (this.mType == 512 || this.mType == 768) {
            return this.cqI;
        }
        return null;
    }

    public TbRichTextEmotionInfo azs() {
        if (this.mType == 17) {
            return this.cVJ;
        }
        return null;
    }

    public TbRichTextMemeInfo azt() {
        if (this.mType == 20) {
            return this.cVN;
        }
        return null;
    }

    private SpannableString azH() {
        if (this.mType != 1 || this.cWf == null) {
            return null;
        }
        return new SpannableString(this.cWf.getText());
    }

    private CharSequence E(ArrayList<b> arrayList) {
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.cWf != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(R.string.video_text));
            CharSequence G = G(arrayList);
            if (G != null) {
                spannableStringBuilder.append(G);
            }
            if (this.cWf.azi() == 1) {
                a = a(this.mType, this.cWf.getText(), this.cWf.azj(), 0);
            } else {
                a = a(this.mType, this.cWf.getText(), this.cWf.getText(), 0);
            }
            if (a != null) {
                spannableStringBuilder.append((CharSequence) a);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence F(ArrayList<b> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.cWf != null) {
            CharSequence G = G(arrayList);
            if (G != null) {
                spannableStringBuilder.append(G);
            }
            SpannableString a = a(this.mType, this.cWf.getLink(), this.cWf.getLink(), 0);
            if (a != null) {
                spannableStringBuilder.append((CharSequence) a);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence G(ArrayList<b> arrayList) {
        TbRichTextItem tbRichTextItem = new TbRichTextItem();
        tbRichTextItem.a(4, new TbRichTextCommInfo("video_icon", HanziToPinyin.Token.SEPARATOR), null, null, null, null, null);
        return tbRichTextItem.I(arrayList);
    }

    public String getVideoUrl() {
        if (this.mType != 32 || this.cWf == null) {
            return null;
        }
        if (this.cWf.azi() == 1) {
            return this.cWf.azj();
        }
        return this.cWf.getText();
    }

    private SpannableString azI() {
        if ((this.mType != 2 && this.mType != 18) || this.cWf == null) {
            return null;
        }
        if (this.cWf.azi() == 1) {
            return a(this.mType, this.cWf.getText(), this.cWf.azj(), 0);
        }
        return a(this.mType, this.cWf.getText(), this.cWf.getLink(), this.cWf.azk());
    }

    private SpannableString azJ() {
        if (this.mType != 256 || this.cWf == null) {
            return null;
        }
        String text = this.cWf.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(HanziToPinyin.Token.SEPARATOR)) {
            text = text + HanziToPinyin.Token.SEPARATOR;
        }
        SpannableString spannableString = new SpannableString(text);
        c cVar = new c(this.mType, text);
        cVar.qw(this.cWf.getLink());
        spannableString.setSpan(cVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString azK() {
        if (this.mType != 16 || this.cWf == null) {
            return null;
        }
        return a(this.mType, this.cWf.getText(), this.cWf.getLink(), 0);
    }

    private SpannableString H(ArrayList<b> arrayList) {
        String text;
        int pz;
        a.C0296a pV;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.cWf != null && this.cWf.getText() != null && this.cWf.getLink() != null && (pz = TbFaceManager.avr().pz((text = this.cWf.getText()))) != 0) {
            String str = "#(" + TbFaceManager.avr().pB(text) + ")";
            spannableString = new SpannableString(str + HanziToPinyin.Token.SEPARATOR);
            b bVar = new b(TbadkCoreApplication.getInst().getContext(), pz);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            if (TbFaceManager.avr().pV(text) != null) {
                int width = (int) (0.5d * pV.getWidth());
                bVar.setBounds(new Rect(0, 0, width, width));
            } else {
                bVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new com.baidu.tbadk.widget.a(bVar, 1), 0, str.length(), 33);
        }
        return spannableString;
    }

    private SpannableString a(int i, String str, final String str2, int i2) {
        c cVar;
        if (str == null) {
            return null;
        }
        if (!str.endsWith(HanziToPinyin.Token.SEPARATOR)) {
            str = str + HanziToPinyin.Token.SEPARATOR;
        }
        SpannableString spannableString = new SpannableString(str);
        if (this.mType == 18) {
            cVar = new c(i, str2) { // from class: com.baidu.tbadk.widget.richText.TbRichTextItem.1
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    TbRichTextItem.this.nf(str2);
                }
            };
        } else {
            cVar = new c(i, str2);
        }
        cVar.kP(i2);
        if (i2 == 1) {
            cVar.setTextColor(R.color.cp_cont_d);
        } else {
            cVar.setTextColor(-1);
        }
        spannableString.setSpan(cVar, 0, str.length() - 1, 33);
        return spannableString;
    }

    private SpannableString azL() {
        if (this.mType != 1024 || this.cVM == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(Config.APP_VERSION_CODE);
        Drawable kR = d.kR(this.cVM.btn_type);
        kR.setBounds(0, 0, kR.getIntrinsicWidth(), kR.getIntrinsicHeight());
        com.baidu.tbadk.widget.c cVar = new com.baidu.tbadk.widget.c(kR);
        cVar.setVerticalOffset(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds4));
        spannableString.setSpan(cVar, 0, 1, 33);
        spannableString.setSpan(new c(1024, this.cVM.link), spannableString.length() - 1, Config.APP_VERSION_CODE.length(), 33);
        return spannableString;
    }

    public CharSequence I(ArrayList<b> arrayList) {
        switch (this.mType) {
            case 1:
                return azH();
            case 2:
                return azI();
            case 4:
                return H(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return azK();
            case 18:
                return azI();
            case 32:
                return E(arrayList);
            case 128:
                return F(arrayList);
            case 256:
                return azJ();
            case 1024:
                return azL();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.cVK.azV() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = kQ(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.cVG = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.cWf = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.cVJ = new TbRichTextEmotionInfo();
                    this.cVJ.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.cVJ.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.cVJ.mGifInfo.mStaticUrl = pbContent._static;
                    this.cVJ.mType = this.mType;
                    this.cVJ.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.cVJ.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.cVJ.mGifInfo.mPackageName = pbContent.packet_name;
                    this.cVJ.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.cVJ.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.cVJ.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
                            break;
                        }
                    }
                    this.cVJ.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
                case 20:
                    this.cVN = new TbRichTextMemeInfo();
                    this.cVN.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.cqI = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.cVM = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case 1280:
                    this.cVL = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.cVK = new f();
                        this.cVK.b(pbContent);
                        break;
                    }
                    this.cWf = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.avr().pz(this.cWf.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.cWf.setText(str);
                            break;
                        } else {
                            this.cWf.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.cWf.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.cWf != null) {
                this.cWf.azl();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = kQ(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.cVG = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.cqI = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.cWf = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.cVJ = new TbRichTextEmotionInfo();
                this.cVJ.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.cVJ.mGifInfo.mDynamicUrl = jSONObject.optString("dynamic");
                this.cVJ.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.cVJ.mType = this.mType;
                this.cVJ.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.cVJ.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.cVJ.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.cVJ.mGifInfo.mIcon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                String[] split = this.cVJ.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.cVJ.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
            } else {
                this.cWf = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int pz = TbFaceManager.avr().pz(this.cWf.getText());
                    String optString = jSONObject.optString("c");
                    if (pz <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.cWf.setText(str);
                    } else {
                        this.cWf.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.cWf.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.cWf != null) {
                this.cWf.azl();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int kQ(int i) {
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
    public void nf(String str) {
        if (!TextUtils.isEmpty(str)) {
            k kVar = new k();
            kVar.mLink = str;
            kVar.type = 0;
            kVar.cDn = "1";
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, kVar));
        }
    }
}
