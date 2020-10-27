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
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.R;
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextItem extends OrmObject {
    private TbRichTextMemeInfo fCJ;
    private int mType = 0;
    private TbRichTextCommInfo fDf = null;
    private TbRichTextImageInfo fCC = null;
    private TbRichTextVoiceInfo eRt = null;
    private TbRichTextEmotionInfo fCF = null;
    private j fCG = null;
    private TbRichTextLinkButtonInfo fCI = null;
    private TbRichTextLinkImageInfo fCH = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.fDf = tbRichTextCommInfo;
        this.fCC = tbRichTextImageInfo;
        this.eRt = tbRichTextVoiceInfo;
        this.fCF = tbRichTextEmotionInfo;
        this.fCI = tbRichTextLinkButtonInfo;
        this.fCH = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo bDx() {
        if (this.mType == 1280) {
            return this.fCH;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo bDN() {
        if (this.mType == 1024) {
            return this.fCI;
        }
        return null;
    }

    public TbRichTextImageInfo bDp() {
        if (this.mType == 8) {
            return this.fCC;
        }
        return null;
    }

    public j bDt() {
        if (this.mType != 32) {
            return null;
        }
        return this.fCG;
    }

    public TbRichTextVoiceInfo bDr() {
        if (this.mType == 512 || this.mType == 768) {
            return this.eRt;
        }
        return null;
    }

    public TbRichTextEmotionInfo bDu() {
        if (this.mType == 17) {
            return this.fCF;
        }
        return null;
    }

    public TbRichTextMemeInfo bDv() {
        if (this.mType == 20) {
            return this.fCJ;
        }
        return null;
    }

    private SpannableString bDO() {
        if (this.mType != 1 || this.fDf == null) {
            return null;
        }
        return new SpannableString(this.fDf.getText());
    }

    private CharSequence Q(ArrayList<d> arrayList) {
        SpannableString a2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.fDf != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(R.string.video_text));
            CharSequence S = S(arrayList);
            if (S != null) {
                spannableStringBuilder.append(S);
            }
            if (this.fDf.bDl() == 1) {
                a2 = a(this.mType, this.fDf.getText(), this.fDf.bDm(), 0);
            } else {
                a2 = a(this.mType, this.fDf.getText(), this.fDf.getText(), 0);
            }
            if (a2 != null) {
                spannableStringBuilder.append((CharSequence) a2);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence R(ArrayList<d> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.fDf != null) {
            CharSequence S = S(arrayList);
            if (S != null) {
                spannableStringBuilder.append(S);
            }
            SpannableString a2 = a(this.mType, this.fDf.getLink(), this.fDf.getLink(), 0);
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
        if (this.mType != 32 || this.fDf == null) {
            return null;
        }
        if (this.fDf.bDl() == 1) {
            return this.fDf.bDm();
        }
        return this.fDf.getText();
    }

    private SpannableString bDP() {
        if ((this.mType != 2 && this.mType != 18) || this.fDf == null) {
            return null;
        }
        if (this.fDf.bDl() == 1) {
            return a(this.mType, this.fDf.getText(), this.fDf.bDm(), 0);
        }
        return a(this.mType, this.fDf.getText(), this.fDf.getLink(), this.fDf.bDn());
    }

    private SpannableString bDQ() {
        if (this.mType != 256 || this.fDf == null) {
            return null;
        }
        String text = this.fDf.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = text + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        f fVar = new f(this.mType, text);
        fVar.Eu(this.fDf.getLink());
        spannableString.setSpan(fVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString bDR() {
        if (this.mType != 16 || this.fDf == null) {
            return null;
        }
        return a(this.mType, this.fDf.getText(), this.fDf.getLink(), 0);
    }

    private SpannableString T(ArrayList<d> arrayList) {
        String text;
        int Dp;
        String str;
        a.C0581a DK;
        if (this.mType != 4 || this.fDf == null || this.fDf.getText() == null || this.fDf.getLink() == null || (Dp = TbFaceManager.byD().Dp((text = this.fDf.getText()))) == 0) {
            return null;
        }
        String Dr = TbFaceManager.byD().Dr(text);
        if (!TextUtils.isEmpty(text) && text.startsWith("shoubai_emoji_")) {
            str = "[" + Dr + "]";
        } else {
            str = "#(" + Dr + ")";
        }
        SpannableString spannableString = new SpannableString(str + " ");
        d dVar = new d(TbadkCoreApplication.getInst().getContext(), Dp);
        if (arrayList != null) {
            arrayList.add(dVar);
        }
        if (TbFaceManager.byD().DK(text) != null) {
            int width = (int) (DK.getWidth() * 0.5d);
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
            boolean z = i == 2 && e.eb(str, str2);
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
                        TbRichTextItem.this.Ev(str2);
                    }
                };
            } else {
                fVar = new f(i, str2);
            }
            fVar.ss(i2);
            if (i2 == 1) {
                fVar.setTextColor(R.color.cp_cont_d);
            } else {
                fVar.setTextColor(-1);
            }
            if (z) {
                h hVar = new h();
                hVar.setPaddingRight(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8));
                spannableString.setSpan(hVar, 0, " ".length(), 33);
                spannableString.setSpan(fVar, " ".length(), (" ".length() + str.length()) - 1, 33);
            } else {
                spannableString.setSpan(fVar, 0, str.length() - 1, 33);
            }
        }
        return spannableString;
    }

    private SpannableString bDS() {
        if (this.mType != 1024 || this.fCI == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString("a");
        Drawable st = g.st(this.fCI.btn_type);
        st.setBounds(0, 0, st.getIntrinsicWidth(), st.getIntrinsicHeight());
        com.baidu.tbadk.widget.d dVar = new com.baidu.tbadk.widget.d(st);
        dVar.setVerticalOffset(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds4));
        spannableString.setSpan(dVar, 0, 1, 33);
        spannableString.setSpan(new f(1024, this.fCI.link), spannableString.length() - 1, "a".length(), 33);
        return spannableString;
    }

    public CharSequence U(ArrayList<d> arrayList) {
        switch (this.mType) {
            case 1:
                return bDO();
            case 2:
                return bDP();
            case 4:
                return T(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return bDR();
            case 18:
                return bDP();
            case 32:
                return Q(arrayList);
            case 128:
                return R(arrayList);
            case 256:
                return bDQ();
            case 1024:
                return bDS();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.fCG.bEc() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = sq(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.fCC = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.fDf = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.fCF = new TbRichTextEmotionInfo();
                    this.fCF.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.fCF.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.fCF.mGifInfo.mStaticUrl = pbContent._static;
                    this.fCF.mType = this.mType;
                    this.fCF.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.fCF.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.fCF.mGifInfo.mPackageName = pbContent.packet_name;
                    this.fCF.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.fCF.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.fCF.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
                            break;
                        }
                    }
                    this.fCF.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
                case 20:
                    this.fCJ = new TbRichTextMemeInfo();
                    this.fCJ.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.eRt = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.fCI = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case PlatformPlugin.DEFAULT_SYSTEM_UI /* 1280 */:
                    this.fCH = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.fCG = new j();
                        this.fCG.b(pbContent);
                        break;
                    }
                    this.fDf = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.byD().Dp(this.fDf.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.fDf.setText(str);
                            break;
                        } else {
                            this.fDf.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.fDf.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.fDf != null) {
                this.fDf.trim();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = sq(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.fCC = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.eRt = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.fDf = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.fCF = new TbRichTextEmotionInfo();
                this.fCF.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.fCF.mGifInfo.mDynamicUrl = jSONObject.optString(PraiseUBCHelper.SOURCE_DYNAMIC);
                this.fCF.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.fCF.mType = this.mType;
                this.fCF.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.fCF.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.fCF.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.fCF.mGifInfo.mIcon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                String[] split = this.fCF.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.fCF.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
            } else {
                this.fDf = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int Dp = TbFaceManager.byD().Dp(this.fDf.getText());
                    String optString = jSONObject.optString("c");
                    if (Dp <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.fDf.setText(str);
                    } else {
                        this.fDf.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.fDf.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.fDf != null) {
                this.fDf.trim();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int sq(int i) {
        return e.sq(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ev(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tbadk.data.l lVar = new com.baidu.tbadk.data.l();
            lVar.mLink = str;
            lVar.type = 0;
            lVar.fgu = "1";
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, lVar));
        }
    }
}
