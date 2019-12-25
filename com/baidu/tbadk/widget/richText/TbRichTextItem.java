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
import com.baidu.searchbox.ui.animview.util.PraiseUBCHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.R;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextItem extends OrmObject {
    private TbRichTextMemeInfo dKo;
    private int mType = 0;
    private TbRichTextCommInfo dKI = null;
    private TbRichTextImageInfo dKh = null;
    private TbRichTextVoiceInfo dea = null;
    private TbRichTextEmotionInfo dKk = null;
    private i dKl = null;
    private TbRichTextLinkButtonInfo dKn = null;
    private TbRichTextLinkImageInfo dKm = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.dKI = tbRichTextCommInfo;
        this.dKh = tbRichTextImageInfo;
        this.dea = tbRichTextVoiceInfo;
        this.dKk = tbRichTextEmotionInfo;
        this.dKn = tbRichTextLinkButtonInfo;
        this.dKm = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo aRt() {
        if (this.mType == 1280) {
            return this.dKm;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo aRu() {
        if (this.mType == 1024) {
            return this.dKn;
        }
        return null;
    }

    public TbRichTextImageInfo aRl() {
        if (this.mType == 8) {
            return this.dKh;
        }
        return null;
    }

    public i aRp() {
        if (this.mType != 32) {
            return null;
        }
        return this.dKl;
    }

    public TbRichTextVoiceInfo aRn() {
        if (this.mType == 512 || this.mType == 768) {
            return this.dea;
        }
        return null;
    }

    public TbRichTextEmotionInfo aRq() {
        if (this.mType == 17) {
            return this.dKk;
        }
        return null;
    }

    public TbRichTextMemeInfo aRr() {
        if (this.mType == 20) {
            return this.dKo;
        }
        return null;
    }

    private SpannableString aRG() {
        if (this.mType != 1 || this.dKI == null) {
            return null;
        }
        return new SpannableString(this.dKI.getText());
    }

    private CharSequence H(ArrayList<d> arrayList) {
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.dKI != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(R.string.video_text));
            CharSequence J = J(arrayList);
            if (J != null) {
                spannableStringBuilder.append(J);
            }
            if (this.dKI.aRh() == 1) {
                a = a(this.mType, this.dKI.getText(), this.dKI.aRi(), 0);
            } else {
                a = a(this.mType, this.dKI.getText(), this.dKI.getText(), 0);
            }
            if (a != null) {
                spannableStringBuilder.append((CharSequence) a);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence I(ArrayList<d> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.dKI != null) {
            CharSequence J = J(arrayList);
            if (J != null) {
                spannableStringBuilder.append(J);
            }
            SpannableString a = a(this.mType, this.dKI.getLink(), this.dKI.getLink(), 0);
            if (a != null) {
                spannableStringBuilder.append((CharSequence) a);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence J(ArrayList<d> arrayList) {
        TbRichTextItem tbRichTextItem = new TbRichTextItem();
        tbRichTextItem.a(4, new TbRichTextCommInfo("video_icon", HanziToPinyin.Token.SEPARATOR), null, null, null, null, null);
        return tbRichTextItem.L(arrayList);
    }

    public String getVideoUrl() {
        if (this.mType != 32 || this.dKI == null) {
            return null;
        }
        if (this.dKI.aRh() == 1) {
            return this.dKI.aRi();
        }
        return this.dKI.getText();
    }

    private SpannableString aRH() {
        if ((this.mType != 2 && this.mType != 18) || this.dKI == null) {
            return null;
        }
        if (this.dKI.aRh() == 1) {
            return a(this.mType, this.dKI.getText(), this.dKI.aRi(), 0);
        }
        return a(this.mType, this.dKI.getText(), this.dKI.getLink(), this.dKI.aRj());
    }

    private SpannableString aRI() {
        if (this.mType != 256 || this.dKI == null) {
            return null;
        }
        String text = this.dKI.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(HanziToPinyin.Token.SEPARATOR)) {
            text = text + HanziToPinyin.Token.SEPARATOR;
        }
        SpannableString spannableString = new SpannableString(text);
        f fVar = new f(this.mType, text);
        fVar.vH(this.dKI.getLink());
        spannableString.setSpan(fVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString aRJ() {
        if (this.mType != 16 || this.dKI == null) {
            return null;
        }
        return a(this.mType, this.dKI.getText(), this.dKI.getLink(), 0);
    }

    private SpannableString K(ArrayList<d> arrayList) {
        String text;
        int uF;
        String str;
        a.C0379a uY;
        if (this.mType != 4 || this.dKI == null || this.dKI.getText() == null || this.dKI.getLink() == null || (uF = TbFaceManager.aMY().uF((text = this.dKI.getText()))) == 0) {
            return null;
        }
        String uH = TbFaceManager.aMY().uH(text);
        if (!TextUtils.isEmpty(text) && text.startsWith("shoubai_emoji_")) {
            str = "[" + uH + "]";
        } else {
            str = "#(" + uH + ")";
        }
        SpannableString spannableString = new SpannableString(str + HanziToPinyin.Token.SEPARATOR);
        d dVar = new d(TbadkCoreApplication.getInst().getContext(), uF);
        if (arrayList != null) {
            arrayList.add(dVar);
        }
        if (TbFaceManager.aMY().uY(text) != null) {
            int width = (int) (uY.getWidth() * 0.5d);
            dVar.setBounds(new Rect(0, 0, width, width));
        } else {
            dVar.setBounds(new Rect(0, 0, 0, 0));
        }
        spannableString.setSpan(new com.baidu.tbadk.widget.a(dVar, 1), 0, str.length(), 33);
        return spannableString;
    }

    private SpannableString a(int i, String str, final String str2, int i2) {
        f fVar;
        if (str == null) {
            return null;
        }
        if (!str.endsWith(HanziToPinyin.Token.SEPARATOR)) {
            str = str + HanziToPinyin.Token.SEPARATOR;
        }
        SpannableString spannableString = new SpannableString(str);
        if (this.mType == 18) {
            fVar = new f(i, str2) { // from class: com.baidu.tbadk.widget.richText.TbRichTextItem.1
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    TbRichTextItem.this.vI(str2);
                }
            };
        } else {
            fVar = new f(i, str2);
        }
        fVar.nf(i2);
        if (i2 == 1) {
            fVar.setTextColor(R.color.cp_cont_d);
        } else {
            fVar.setTextColor(-1);
        }
        spannableString.setSpan(fVar, 0, str.length() - 1, 33);
        return spannableString;
    }

    private SpannableString aRK() {
        if (this.mType != 1024 || this.dKn == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(Config.APP_VERSION_CODE);
        Drawable ng = g.ng(this.dKn.btn_type);
        ng.setBounds(0, 0, ng.getIntrinsicWidth(), ng.getIntrinsicHeight());
        com.baidu.tbadk.widget.c cVar = new com.baidu.tbadk.widget.c(ng);
        cVar.setVerticalOffset(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds4));
        spannableString.setSpan(cVar, 0, 1, 33);
        spannableString.setSpan(new f(1024, this.dKn.link), spannableString.length() - 1, Config.APP_VERSION_CODE.length(), 33);
        return spannableString;
    }

    public CharSequence L(ArrayList<d> arrayList) {
        switch (this.mType) {
            case 1:
                return aRG();
            case 2:
                return aRH();
            case 4:
                return K(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return aRJ();
            case 18:
                return aRH();
            case 32:
                return H(arrayList);
            case 128:
                return I(arrayList);
            case 256:
                return aRI();
            case 1024:
                return aRK();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.dKl.aRU() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = nd(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.dKh = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.dKI = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.dKk = new TbRichTextEmotionInfo();
                    this.dKk.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.dKk.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.dKk.mGifInfo.mStaticUrl = pbContent._static;
                    this.dKk.mType = this.mType;
                    this.dKk.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.dKk.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.dKk.mGifInfo.mPackageName = pbContent.packet_name;
                    this.dKk.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.dKk.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.dKk.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
                            break;
                        }
                    }
                    this.dKk.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
                case 20:
                    this.dKo = new TbRichTextMemeInfo();
                    this.dKo.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.dea = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.dKn = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case 1280:
                    this.dKm = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.dKl = new i();
                        this.dKl.b(pbContent);
                        break;
                    }
                    this.dKI = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.aMY().uF(this.dKI.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.dKI.setText(str);
                            break;
                        } else {
                            this.dKI.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.dKI.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.dKI != null) {
                this.dKI.trim();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = nd(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.dKh = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.dea = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.dKI = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.dKk = new TbRichTextEmotionInfo();
                this.dKk.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.dKk.mGifInfo.mDynamicUrl = jSONObject.optString(PraiseUBCHelper.SOURCE_DYNAMIC);
                this.dKk.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.dKk.mType = this.mType;
                this.dKk.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.dKk.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.dKk.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.dKk.mGifInfo.mIcon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                String[] split = this.dKk.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.dKk.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
            } else {
                this.dKI = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int uF = TbFaceManager.aMY().uF(this.dKI.getText());
                    String optString = jSONObject.optString("c");
                    if (uF <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.dKI.setText(str);
                    } else {
                        this.dKI.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.dKI.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.dKI != null) {
                this.dKI.trim();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int nd(int i) {
        return e.nd(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vI(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tbadk.data.l lVar = new com.baidu.tbadk.data.l();
            lVar.mLink = str;
            lVar.type = 0;
            lVar.drj = "1";
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, lVar));
        }
    }
}
