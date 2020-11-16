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
import com.baidu.tbadk.core.elementsMaven.view.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.R;
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextItem extends OrmObject {
    private TbRichTextMemeInfo fId;
    private int mType = 0;
    private TbRichTextCommInfo fIy = null;
    private TbRichTextImageInfo fHW = null;
    private TbRichTextVoiceInfo eWp = null;
    private TbRichTextEmotionInfo fHZ = null;
    private i fIa = null;
    private TbRichTextLinkButtonInfo fIc = null;
    private TbRichTextLinkImageInfo fIb = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.fIy = tbRichTextCommInfo;
        this.fHW = tbRichTextImageInfo;
        this.eWp = tbRichTextVoiceInfo;
        this.fHZ = tbRichTextEmotionInfo;
        this.fIc = tbRichTextLinkButtonInfo;
        this.fIb = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo bFp() {
        if (this.mType == 1280) {
            return this.fIb;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo bFF() {
        if (this.mType == 1024) {
            return this.fIc;
        }
        return null;
    }

    public TbRichTextImageInfo bFh() {
        if (this.mType == 8) {
            return this.fHW;
        }
        return null;
    }

    public i bFl() {
        if (this.mType != 32) {
            return null;
        }
        return this.fIa;
    }

    public TbRichTextVoiceInfo bFj() {
        if (this.mType == 512 || this.mType == 768) {
            return this.eWp;
        }
        return null;
    }

    public TbRichTextEmotionInfo bFm() {
        if (this.mType == 17) {
            return this.fHZ;
        }
        return null;
    }

    public TbRichTextMemeInfo bFn() {
        if (this.mType == 20) {
            return this.fId;
        }
        return null;
    }

    private SpannableString bFG() {
        if (this.mType != 1 || this.fIy == null) {
            return null;
        }
        return new SpannableString(this.fIy.getText());
    }

    private CharSequence Q(ArrayList<d> arrayList) {
        SpannableString a2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.fIy != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(R.string.video_text));
            CharSequence S = S(arrayList);
            if (S != null) {
                spannableStringBuilder.append(S);
            }
            if (this.fIy.bFd() == 1) {
                a2 = a(this.mType, this.fIy.getText(), this.fIy.bFe(), 0);
            } else {
                a2 = a(this.mType, this.fIy.getText(), this.fIy.getText(), 0);
            }
            if (a2 != null) {
                spannableStringBuilder.append((CharSequence) a2);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence R(ArrayList<d> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.fIy != null) {
            CharSequence S = S(arrayList);
            if (S != null) {
                spannableStringBuilder.append(S);
            }
            SpannableString a2 = a(this.mType, this.fIy.getLink(), this.fIy.getLink(), 0);
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
        if (this.mType != 32 || this.fIy == null) {
            return null;
        }
        if (this.fIy.bFd() == 1) {
            return this.fIy.bFe();
        }
        return this.fIy.getText();
    }

    private SpannableString bFH() {
        if ((this.mType != 2 && this.mType != 18) || this.fIy == null) {
            return null;
        }
        if (this.fIy.bFd() == 1) {
            return a(this.mType, this.fIy.getText(), this.fIy.bFe(), 0);
        }
        return a(this.mType, this.fIy.getText(), this.fIy.getLink(), this.fIy.bFf());
    }

    private SpannableString bFI() {
        if (this.mType != 256 || this.fIy == null) {
            return null;
        }
        String text = this.fIy.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = text + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        f fVar = new f(this.mType, text);
        fVar.Ej(this.fIy.getLink());
        spannableString.setSpan(fVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString bFJ() {
        if (this.mType != 16 || this.fIy == null) {
            return null;
        }
        return a(this.mType, this.fIy.getText(), this.fIy.getLink(), 0);
    }

    private SpannableString T(ArrayList<d> arrayList) {
        String text;
        int Dc;
        String str;
        a.C0592a Dx;
        if (this.mType != 4 || this.fIy == null || this.fIy.getText() == null || this.fIy.getLink() == null || (Dc = TbFaceManager.bAs().Dc((text = this.fIy.getText()))) == 0) {
            return null;
        }
        String De = TbFaceManager.bAs().De(text);
        if (!TextUtils.isEmpty(text) && text.startsWith("shoubai_emoji_")) {
            str = "[" + De + "]";
        } else {
            str = "#(" + De + ")";
        }
        SpannableString spannableString = new SpannableString(str + " ");
        d dVar = new d(TbadkCoreApplication.getInst().getContext(), Dc);
        if (arrayList != null) {
            arrayList.add(dVar);
        }
        if (TbFaceManager.bAs().Dx(text) != null) {
            int width = (int) (Dx.getWidth() * 0.5d);
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
                        TbRichTextItem.this.Ek(str2);
                    }
                };
            } else {
                fVar = new f(i, str2);
            }
            fVar.ta(i2);
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

    private SpannableString bFK() {
        if (this.mType != 1024 || this.fIc == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString("a");
        Drawable tb = g.tb(this.fIc.btn_type);
        tb.setBounds(0, 0, tb.getIntrinsicWidth(), tb.getIntrinsicHeight());
        com.baidu.tbadk.widget.d dVar = new com.baidu.tbadk.widget.d(tb);
        dVar.setVerticalOffset(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds4));
        spannableString.setSpan(dVar, 0, 1, 33);
        spannableString.setSpan(new f(1024, this.fIc.link), spannableString.length() - 1, "a".length(), 33);
        return spannableString;
    }

    public CharSequence U(ArrayList<d> arrayList) {
        switch (this.mType) {
            case 1:
                return bFG();
            case 2:
                return bFH();
            case 4:
                return T(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return bFJ();
            case 18:
                return bFH();
            case 32:
                return Q(arrayList);
            case 128:
                return R(arrayList);
            case 256:
                return bFI();
            case 1024:
                return bFK();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.fIa.bFU() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = sY(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.fHW = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.fIy = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.fHZ = new TbRichTextEmotionInfo();
                    this.fHZ.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.fHZ.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.fHZ.mGifInfo.mStaticUrl = pbContent._static;
                    this.fHZ.mType = this.mType;
                    this.fHZ.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.fHZ.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.fHZ.mGifInfo.mPackageName = pbContent.packet_name;
                    this.fHZ.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.fHZ.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.fHZ.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
                            break;
                        }
                    }
                    this.fHZ.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
                case 20:
                    this.fId = new TbRichTextMemeInfo();
                    this.fId.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.eWp = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.fIc = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case PlatformPlugin.DEFAULT_SYSTEM_UI /* 1280 */:
                    this.fIb = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.fIa = new i();
                        this.fIa.b(pbContent);
                        break;
                    }
                    this.fIy = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.bAs().Dc(this.fIy.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.fIy.setText(str);
                            break;
                        } else {
                            this.fIy.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.fIy.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.fIy != null) {
                this.fIy.trim();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = sY(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.fHW = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.eWp = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.fIy = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.fHZ = new TbRichTextEmotionInfo();
                this.fHZ.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.fHZ.mGifInfo.mDynamicUrl = jSONObject.optString(PraiseUBCHelper.SOURCE_DYNAMIC);
                this.fHZ.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.fHZ.mType = this.mType;
                this.fHZ.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.fHZ.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.fHZ.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.fHZ.mGifInfo.mIcon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                String[] split = this.fHZ.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.fHZ.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
            } else {
                this.fIy = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int Dc = TbFaceManager.bAs().Dc(this.fIy.getText());
                    String optString = jSONObject.optString("c");
                    if (Dc <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.fIy.setText(str);
                    } else {
                        this.fIy.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.fIy.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.fIy != null) {
                this.fIy.trim();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int sY(int i) {
        return e.sY(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ek(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tbadk.data.l lVar = new com.baidu.tbadk.data.l();
            lVar.mLink = str;
            lVar.type = 0;
            lVar.flv = "1";
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, lVar));
        }
    }
}
