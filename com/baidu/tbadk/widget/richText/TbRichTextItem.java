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
    private TbRichTextMemeInfo dKv;
    private int mType = 0;
    private TbRichTextCommInfo dKP = null;
    private TbRichTextImageInfo dKo = null;
    private TbRichTextVoiceInfo dek = null;
    private TbRichTextEmotionInfo dKr = null;
    private i dKs = null;
    private TbRichTextLinkButtonInfo dKu = null;
    private TbRichTextLinkImageInfo dKt = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.dKP = tbRichTextCommInfo;
        this.dKo = tbRichTextImageInfo;
        this.dek = tbRichTextVoiceInfo;
        this.dKr = tbRichTextEmotionInfo;
        this.dKu = tbRichTextLinkButtonInfo;
        this.dKt = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo aRN() {
        if (this.mType == 1280) {
            return this.dKt;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo aRO() {
        if (this.mType == 1024) {
            return this.dKu;
        }
        return null;
    }

    public TbRichTextImageInfo aRF() {
        if (this.mType == 8) {
            return this.dKo;
        }
        return null;
    }

    public i aRJ() {
        if (this.mType != 32) {
            return null;
        }
        return this.dKs;
    }

    public TbRichTextVoiceInfo aRH() {
        if (this.mType == 512 || this.mType == 768) {
            return this.dek;
        }
        return null;
    }

    public TbRichTextEmotionInfo aRK() {
        if (this.mType == 17) {
            return this.dKr;
        }
        return null;
    }

    public TbRichTextMemeInfo aRL() {
        if (this.mType == 20) {
            return this.dKv;
        }
        return null;
    }

    private SpannableString aSa() {
        if (this.mType != 1 || this.dKP == null) {
            return null;
        }
        return new SpannableString(this.dKP.getText());
    }

    private CharSequence H(ArrayList<d> arrayList) {
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.dKP != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(R.string.video_text));
            CharSequence J = J(arrayList);
            if (J != null) {
                spannableStringBuilder.append(J);
            }
            if (this.dKP.aRB() == 1) {
                a = a(this.mType, this.dKP.getText(), this.dKP.aRC(), 0);
            } else {
                a = a(this.mType, this.dKP.getText(), this.dKP.getText(), 0);
            }
            if (a != null) {
                spannableStringBuilder.append((CharSequence) a);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence I(ArrayList<d> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.dKP != null) {
            CharSequence J = J(arrayList);
            if (J != null) {
                spannableStringBuilder.append(J);
            }
            SpannableString a = a(this.mType, this.dKP.getLink(), this.dKP.getLink(), 0);
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
        if (this.mType != 32 || this.dKP == null) {
            return null;
        }
        if (this.dKP.aRB() == 1) {
            return this.dKP.aRC();
        }
        return this.dKP.getText();
    }

    private SpannableString aSb() {
        if ((this.mType != 2 && this.mType != 18) || this.dKP == null) {
            return null;
        }
        if (this.dKP.aRB() == 1) {
            return a(this.mType, this.dKP.getText(), this.dKP.aRC(), 0);
        }
        return a(this.mType, this.dKP.getText(), this.dKP.getLink(), this.dKP.aRD());
    }

    private SpannableString aSc() {
        if (this.mType != 256 || this.dKP == null) {
            return null;
        }
        String text = this.dKP.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(HanziToPinyin.Token.SEPARATOR)) {
            text = text + HanziToPinyin.Token.SEPARATOR;
        }
        SpannableString spannableString = new SpannableString(text);
        f fVar = new f(this.mType, text);
        fVar.vL(this.dKP.getLink());
        spannableString.setSpan(fVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString aSd() {
        if (this.mType != 16 || this.dKP == null) {
            return null;
        }
        return a(this.mType, this.dKP.getText(), this.dKP.getLink(), 0);
    }

    private SpannableString K(ArrayList<d> arrayList) {
        String text;
        int uK;
        String str;
        a.C0381a vd;
        if (this.mType != 4 || this.dKP == null || this.dKP.getText() == null || this.dKP.getLink() == null || (uK = TbFaceManager.aNr().uK((text = this.dKP.getText()))) == 0) {
            return null;
        }
        String uM = TbFaceManager.aNr().uM(text);
        if (!TextUtils.isEmpty(text) && text.startsWith("shoubai_emoji_")) {
            str = "[" + uM + "]";
        } else {
            str = "#(" + uM + ")";
        }
        SpannableString spannableString = new SpannableString(str + HanziToPinyin.Token.SEPARATOR);
        d dVar = new d(TbadkCoreApplication.getInst().getContext(), uK);
        if (arrayList != null) {
            arrayList.add(dVar);
        }
        if (TbFaceManager.aNr().vd(text) != null) {
            int width = (int) (vd.getWidth() * 0.5d);
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
                    TbRichTextItem.this.vM(str2);
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

    private SpannableString aSe() {
        if (this.mType != 1024 || this.dKu == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(Config.APP_VERSION_CODE);
        Drawable ng = g.ng(this.dKu.btn_type);
        ng.setBounds(0, 0, ng.getIntrinsicWidth(), ng.getIntrinsicHeight());
        com.baidu.tbadk.widget.c cVar = new com.baidu.tbadk.widget.c(ng);
        cVar.setVerticalOffset(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds4));
        spannableString.setSpan(cVar, 0, 1, 33);
        spannableString.setSpan(new f(1024, this.dKu.link), spannableString.length() - 1, Config.APP_VERSION_CODE.length(), 33);
        return spannableString;
    }

    public CharSequence L(ArrayList<d> arrayList) {
        switch (this.mType) {
            case 1:
                return aSa();
            case 2:
                return aSb();
            case 4:
                return K(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return aSd();
            case 18:
                return aSb();
            case 32:
                return H(arrayList);
            case 128:
                return I(arrayList);
            case 256:
                return aSc();
            case 1024:
                return aSe();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.dKs.aSo() != false) goto L9;
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
                    this.dKo = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.dKP = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.dKr = new TbRichTextEmotionInfo();
                    this.dKr.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.dKr.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.dKr.mGifInfo.mStaticUrl = pbContent._static;
                    this.dKr.mType = this.mType;
                    this.dKr.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.dKr.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.dKr.mGifInfo.mPackageName = pbContent.packet_name;
                    this.dKr.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.dKr.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.dKr.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
                            break;
                        }
                    }
                    this.dKr.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
                case 20:
                    this.dKv = new TbRichTextMemeInfo();
                    this.dKv.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.dek = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.dKu = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case 1280:
                    this.dKt = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.dKs = new i();
                        this.dKs.b(pbContent);
                        break;
                    }
                    this.dKP = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.aNr().uK(this.dKP.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.dKP.setText(str);
                            break;
                        } else {
                            this.dKP.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.dKP.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.dKP != null) {
                this.dKP.trim();
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
                this.dKo = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.dek = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.dKP = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.dKr = new TbRichTextEmotionInfo();
                this.dKr.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.dKr.mGifInfo.mDynamicUrl = jSONObject.optString(PraiseUBCHelper.SOURCE_DYNAMIC);
                this.dKr.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.dKr.mType = this.mType;
                this.dKr.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.dKr.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.dKr.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.dKr.mGifInfo.mIcon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                String[] split = this.dKr.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.dKr.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
            } else {
                this.dKP = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int uK = TbFaceManager.aNr().uK(this.dKP.getText());
                    String optString = jSONObject.optString("c");
                    if (uK <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.dKP.setText(str);
                    } else {
                        this.dKP.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.dKP.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.dKP != null) {
                this.dKP.trim();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int nd(int i) {
        return e.nd(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vM(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tbadk.data.l lVar = new com.baidu.tbadk.data.l();
            lVar.mLink = str;
            lVar.type = 0;
            lVar.drv = "1";
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, lVar));
        }
    }
}
