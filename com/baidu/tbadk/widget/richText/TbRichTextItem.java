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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.searchbox.ui.animview.util.PraiseUBCHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.m;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.R;
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextItem extends OrmObject {
    private TbRichTextMemeInfo fPQ;
    private int mType = 0;
    private TbRichTextCommInfo fQk = null;
    private TbRichTextImageInfo fPJ = null;
    private TbRichTextVoiceInfo fdM = null;
    private TbRichTextEmotionInfo fPM = null;
    private i fPN = null;
    private TbRichTextLinkButtonInfo fPP = null;
    private TbRichTextLinkImageInfo fPO = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.fQk = tbRichTextCommInfo;
        this.fPJ = tbRichTextImageInfo;
        this.fdM = tbRichTextVoiceInfo;
        this.fPM = tbRichTextEmotionInfo;
        this.fPP = tbRichTextLinkButtonInfo;
        this.fPO = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo bIQ() {
        if (this.mType == 1280) {
            return this.fPO;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo bJf() {
        if (this.mType == 1024) {
            return this.fPP;
        }
        return null;
    }

    public TbRichTextImageInfo bII() {
        if (this.mType == 8) {
            return this.fPJ;
        }
        return null;
    }

    public i bIM() {
        if (this.mType != 32) {
            return null;
        }
        return this.fPN;
    }

    public TbRichTextVoiceInfo bIK() {
        if (this.mType == 512 || this.mType == 768) {
            return this.fdM;
        }
        return null;
    }

    public TbRichTextEmotionInfo bIN() {
        if (this.mType == 17) {
            return this.fPM;
        }
        return null;
    }

    public TbRichTextMemeInfo bIO() {
        if (this.mType == 20) {
            return this.fPQ;
        }
        return null;
    }

    private SpannableString bJg() {
        if (this.mType != 1 || this.fQk == null) {
            return null;
        }
        return new SpannableString(this.fQk.getText());
    }

    private CharSequence Q(ArrayList<d> arrayList) {
        SpannableString a2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.fQk != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(R.string.video_text));
            CharSequence S = S(arrayList);
            if (S != null) {
                spannableStringBuilder.append(S);
            }
            if (this.fQk.bIE() == 1) {
                a2 = a(this.mType, this.fQk.getText(), this.fQk.bIF(), 0);
            } else {
                a2 = a(this.mType, this.fQk.getText(), this.fQk.getText(), 0);
            }
            if (a2 != null) {
                spannableStringBuilder.append((CharSequence) a2);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence R(ArrayList<d> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.fQk != null) {
            CharSequence S = S(arrayList);
            if (S != null) {
                spannableStringBuilder.append(S);
            }
            SpannableString a2 = a(this.mType, this.fQk.getLink(), this.fQk.getLink(), 0);
            if (a2 != null) {
                spannableStringBuilder.append((CharSequence) a2);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence S(ArrayList<d> arrayList) {
        TbRichTextItem tbRichTextItem = new TbRichTextItem();
        tbRichTextItem.a(4, new TbRichTextCommInfo("video_icon", " "), null, null, null, null, null);
        return tbRichTextItem.U(arrayList);
    }

    public String getVideoUrl() {
        if (this.mType != 32 || this.fQk == null) {
            return null;
        }
        if (this.fQk.bIE() == 1) {
            return this.fQk.bIF();
        }
        return this.fQk.getText();
    }

    private SpannableString bJh() {
        if ((this.mType != 2 && this.mType != 18) || this.fQk == null) {
            return null;
        }
        if (this.fQk.bIE() == 1) {
            return a(this.mType, this.fQk.getText(), this.fQk.bIF(), 0);
        }
        return a(this.mType, this.fQk.getText(), this.fQk.getLink(), this.fQk.bIG());
    }

    private SpannableString bJi() {
        if (this.mType != 256 || this.fQk == null) {
            return null;
        }
        String text = this.fQk.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = text + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        f fVar = new f(this.mType, text);
        fVar.EX(this.fQk.getLink());
        spannableString.setSpan(fVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString bJj() {
        if (this.mType != 16 || this.fQk == null) {
            return null;
        }
        return a(this.mType, this.fQk.getText(), this.fQk.getLink(), 0);
    }

    private SpannableString T(ArrayList<d> arrayList) {
        String text;
        int DK;
        String str;
        a.C0605a Ef;
        if (this.mType != 4 || this.fQk == null || this.fQk.getText() == null || this.fQk.getLink() == null || (DK = TbFaceManager.bDU().DK((text = this.fQk.getText()))) == 0) {
            return null;
        }
        String DM = TbFaceManager.bDU().DM(text);
        if (!TextUtils.isEmpty(text) && text.startsWith("shoubai_emoji_")) {
            str = "[" + DM + "]";
        } else {
            str = "#(" + DM + ")";
        }
        SpannableString spannableString = new SpannableString(str + " ");
        d dVar = new d(TbadkCoreApplication.getInst().getContext(), DK);
        if (arrayList != null) {
            arrayList.add(dVar);
        }
        if (TbFaceManager.bDU().Ef(text) != null) {
            int width = (int) (Ef.getWidth() * 0.5d);
            dVar.setBounds(new Rect(0, 0, width, width));
        } else {
            dVar.setBounds(new Rect(0, 0, 0, 0));
        }
        spannableString.setSpan(new com.baidu.tbadk.widget.b(dVar, 1), 0, str.length(), 33);
        return spannableString;
    }

    private SpannableString a(int i, String str, final String str2, int i2) {
        f fVar;
        SpannableString spannableString = null;
        if (str != null) {
            boolean z = i == 2 && e.ei(str, str2);
            if (!str.endsWith(" ")) {
                str = str + " ";
            }
            if (z) {
                spannableString = new SpannableString(" " + str);
            } else {
                spannableString = new SpannableString(str);
            }
            if (this.mType == 18) {
                fVar = new f(i, str2) { // from class: com.baidu.tbadk.widget.richText.TbRichTextItem.1
                    @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        view.setTag(R.id.tag_subpb_ban_display_keyboard, true);
                        TbRichTextItem.this.EY(str2);
                    }
                };
            } else {
                fVar = new f(i, str2);
            }
            fVar.tD(i2);
            if (i2 == 1) {
                fVar.setTextColor(R.color.CAM_X0109);
            } else {
                fVar.setTextColor(-1);
            }
            if (z) {
                EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.icon_pure_post_link16, R.color.CAM_X0304, EMRichTextAnyIconSpan.IconType.WEBP);
                eMRichTextAnyIconSpan.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
                spannableString.setSpan(eMRichTextAnyIconSpan, 0, " ".length(), 33);
                spannableString.setSpan(fVar, " ".length(), (" ".length() + str.length()) - 1, 33);
            } else {
                spannableString.setSpan(fVar, 0, str.length() - 1, 33);
            }
        }
        return spannableString;
    }

    private SpannableString bJk() {
        if (this.mType != 1024 || this.fPP == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString("a");
        Drawable tE = g.tE(this.fPP.btn_type);
        tE.setBounds(0, 0, tE.getIntrinsicWidth(), tE.getIntrinsicHeight());
        com.baidu.tbadk.widget.d dVar = new com.baidu.tbadk.widget.d(tE);
        dVar.setVerticalOffset(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds4));
        spannableString.setSpan(dVar, 0, 1, 33);
        spannableString.setSpan(new f(1024, this.fPP.link), spannableString.length() - 1, "a".length(), 33);
        return spannableString;
    }

    public CharSequence U(ArrayList<d> arrayList) {
        switch (this.mType) {
            case 1:
                return bJg();
            case 2:
                return bJh();
            case 4:
                return T(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return bJj();
            case 18:
                return bJh();
            case 32:
                return Q(arrayList);
            case 128:
                return R(arrayList);
            case 256:
                return bJi();
            case 1024:
                return bJk();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.fPN.bJu() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = tB(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.fPJ = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.fQk = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.fPM = new TbRichTextEmotionInfo();
                    this.fPM.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.fPM.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.fPM.mGifInfo.mStaticUrl = pbContent._static;
                    this.fPM.mType = this.mType;
                    this.fPM.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.fPM.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.fPM.mGifInfo.mPackageName = pbContent.packet_name;
                    this.fPM.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.fPM.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.fPM.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
                            break;
                        }
                    }
                    this.fPM.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
                case 20:
                    this.fPQ = new TbRichTextMemeInfo();
                    this.fPQ.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.fdM = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.fPP = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case PlatformPlugin.DEFAULT_SYSTEM_UI /* 1280 */:
                    this.fPO = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.fPN = new i();
                        this.fPN.b(pbContent);
                        break;
                    }
                    this.fQk = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.bDU().DK(this.fQk.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.fQk.setText(str);
                            break;
                        } else {
                            this.fQk.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.fQk.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.fQk != null) {
                this.fQk.trim();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = tB(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.fPJ = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.fdM = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.fQk = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.fPM = new TbRichTextEmotionInfo();
                this.fPM.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.fPM.mGifInfo.mDynamicUrl = jSONObject.optString(PraiseUBCHelper.SOURCE_DYNAMIC);
                this.fPM.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.fPM.mType = this.mType;
                this.fPM.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.fPM.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.fPM.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.fPM.mGifInfo.mIcon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                String[] split = this.fPM.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.fPM.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
            } else {
                this.fQk = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int DK = TbFaceManager.bDU().DK(this.fQk.getText());
                    String optString = jSONObject.optString("c");
                    if (DK <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.fQk.setText(str);
                    } else {
                        this.fQk.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.fQk.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.fQk != null) {
                this.fQk.trim();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int tB(int i) {
        return e.tB(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EY(String str) {
        if (!TextUtils.isEmpty(str)) {
            m mVar = new m();
            mVar.mLink = str;
            mVar.type = 0;
            mVar.fsY = "1";
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, mVar));
        }
    }
}
