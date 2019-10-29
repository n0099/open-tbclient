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
    private TbRichTextMemeInfo cWE;
    private int mType = 0;
    private TbRichTextCommInfo cWW = null;
    private TbRichTextImageInfo cWx = null;
    private TbRichTextVoiceInfo crA = null;
    private TbRichTextEmotionInfo cWA = null;
    private f cWB = null;
    private TbRichTextLinkButtonInfo cWD = null;
    private TbRichTextLinkImageInfo cWC = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.cWW = tbRichTextCommInfo;
        this.cWx = tbRichTextImageInfo;
        this.crA = tbRichTextVoiceInfo;
        this.cWA = tbRichTextEmotionInfo;
        this.cWD = tbRichTextLinkButtonInfo;
        this.cWC = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo azx() {
        if (this.mType == 1280) {
            return this.cWC;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo azy() {
        if (this.mType == 1024) {
            return this.cWD;
        }
        return null;
    }

    public TbRichTextImageInfo azp() {
        if (this.mType == 8) {
            return this.cWx;
        }
        return null;
    }

    public f azt() {
        if (this.mType != 32) {
            return null;
        }
        return this.cWB;
    }

    public TbRichTextVoiceInfo azr() {
        if (this.mType == 512 || this.mType == 768) {
            return this.crA;
        }
        return null;
    }

    public TbRichTextEmotionInfo azu() {
        if (this.mType == 17) {
            return this.cWA;
        }
        return null;
    }

    public TbRichTextMemeInfo azv() {
        if (this.mType == 20) {
            return this.cWE;
        }
        return null;
    }

    private SpannableString azJ() {
        if (this.mType != 1 || this.cWW == null) {
            return null;
        }
        return new SpannableString(this.cWW.getText());
    }

    private CharSequence E(ArrayList<b> arrayList) {
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.cWW != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(R.string.video_text));
            CharSequence G = G(arrayList);
            if (G != null) {
                spannableStringBuilder.append(G);
            }
            if (this.cWW.azk() == 1) {
                a = a(this.mType, this.cWW.getText(), this.cWW.azl(), 0);
            } else {
                a = a(this.mType, this.cWW.getText(), this.cWW.getText(), 0);
            }
            if (a != null) {
                spannableStringBuilder.append((CharSequence) a);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence F(ArrayList<b> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.cWW != null) {
            CharSequence G = G(arrayList);
            if (G != null) {
                spannableStringBuilder.append(G);
            }
            SpannableString a = a(this.mType, this.cWW.getLink(), this.cWW.getLink(), 0);
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
        if (this.mType != 32 || this.cWW == null) {
            return null;
        }
        if (this.cWW.azk() == 1) {
            return this.cWW.azl();
        }
        return this.cWW.getText();
    }

    private SpannableString azK() {
        if ((this.mType != 2 && this.mType != 18) || this.cWW == null) {
            return null;
        }
        if (this.cWW.azk() == 1) {
            return a(this.mType, this.cWW.getText(), this.cWW.azl(), 0);
        }
        return a(this.mType, this.cWW.getText(), this.cWW.getLink(), this.cWW.azm());
    }

    private SpannableString azL() {
        if (this.mType != 256 || this.cWW == null) {
            return null;
        }
        String text = this.cWW.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(HanziToPinyin.Token.SEPARATOR)) {
            text = text + HanziToPinyin.Token.SEPARATOR;
        }
        SpannableString spannableString = new SpannableString(text);
        c cVar = new c(this.mType, text);
        cVar.qw(this.cWW.getLink());
        spannableString.setSpan(cVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString azM() {
        if (this.mType != 16 || this.cWW == null) {
            return null;
        }
        return a(this.mType, this.cWW.getText(), this.cWW.getLink(), 0);
    }

    private SpannableString H(ArrayList<b> arrayList) {
        String text;
        int pz;
        a.C0296a pV;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.cWW != null && this.cWW.getText() != null && this.cWW.getLink() != null && (pz = TbFaceManager.avt().pz((text = this.cWW.getText()))) != 0) {
            String str = "#(" + TbFaceManager.avt().pB(text) + ")";
            spannableString = new SpannableString(str + HanziToPinyin.Token.SEPARATOR);
            b bVar = new b(TbadkCoreApplication.getInst().getContext(), pz);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            if (TbFaceManager.avt().pV(text) != null) {
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
        cVar.kQ(i2);
        if (i2 == 1) {
            cVar.setTextColor(R.color.cp_cont_d);
        } else {
            cVar.setTextColor(-1);
        }
        spannableString.setSpan(cVar, 0, str.length() - 1, 33);
        return spannableString;
    }

    private SpannableString azN() {
        if (this.mType != 1024 || this.cWD == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(Config.APP_VERSION_CODE);
        Drawable kS = d.kS(this.cWD.btn_type);
        kS.setBounds(0, 0, kS.getIntrinsicWidth(), kS.getIntrinsicHeight());
        com.baidu.tbadk.widget.c cVar = new com.baidu.tbadk.widget.c(kS);
        cVar.setVerticalOffset(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds4));
        spannableString.setSpan(cVar, 0, 1, 33);
        spannableString.setSpan(new c(1024, this.cWD.link), spannableString.length() - 1, Config.APP_VERSION_CODE.length(), 33);
        return spannableString;
    }

    public CharSequence I(ArrayList<b> arrayList) {
        switch (this.mType) {
            case 1:
                return azJ();
            case 2:
                return azK();
            case 4:
                return H(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return azM();
            case 18:
                return azK();
            case 32:
                return E(arrayList);
            case 128:
                return F(arrayList);
            case 256:
                return azL();
            case 1024:
                return azN();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.cWB.azX() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = kR(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.cWx = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.cWW = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.cWA = new TbRichTextEmotionInfo();
                    this.cWA.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.cWA.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.cWA.mGifInfo.mStaticUrl = pbContent._static;
                    this.cWA.mType = this.mType;
                    this.cWA.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.cWA.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.cWA.mGifInfo.mPackageName = pbContent.packet_name;
                    this.cWA.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.cWA.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.cWA.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
                            break;
                        }
                    }
                    this.cWA.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
                case 20:
                    this.cWE = new TbRichTextMemeInfo();
                    this.cWE.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.crA = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.cWD = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case 1280:
                    this.cWC = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.cWB = new f();
                        this.cWB.b(pbContent);
                        break;
                    }
                    this.cWW = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.avt().pz(this.cWW.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.cWW.setText(str);
                            break;
                        } else {
                            this.cWW.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.cWW.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.cWW != null) {
                this.cWW.azn();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = kR(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.cWx = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.crA = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.cWW = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.cWA = new TbRichTextEmotionInfo();
                this.cWA.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.cWA.mGifInfo.mDynamicUrl = jSONObject.optString("dynamic");
                this.cWA.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.cWA.mType = this.mType;
                this.cWA.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.cWA.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.cWA.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.cWA.mGifInfo.mIcon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                String[] split = this.cWA.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.cWA.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
            } else {
                this.cWW = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int pz = TbFaceManager.avt().pz(this.cWW.getText());
                    String optString = jSONObject.optString("c");
                    if (pz <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.cWW.setText(str);
                    } else {
                        this.cWW.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.cWW.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.cWW != null) {
                this.cWW.azn();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int kR(int i) {
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
            kVar.cEe = "1";
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, kVar));
        }
    }
}
