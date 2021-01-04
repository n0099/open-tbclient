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
    private TbRichTextMemeInfo fZt;
    private int mType = 0;
    private TbRichTextCommInfo fZM = null;
    private TbRichTextImageInfo fZm = null;
    private TbRichTextVoiceInfo fnv = null;
    private TbRichTextEmotionInfo fZp = null;
    private i fZq = null;
    private TbRichTextLinkButtonInfo fZs = null;
    private TbRichTextLinkImageInfo fZr = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.fZM = tbRichTextCommInfo;
        this.fZm = tbRichTextImageInfo;
        this.fnv = tbRichTextVoiceInfo;
        this.fZp = tbRichTextEmotionInfo;
        this.fZs = tbRichTextLinkButtonInfo;
        this.fZr = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo bLk() {
        if (this.mType == 1280) {
            return this.fZr;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo bLx() {
        if (this.mType == 1024) {
            return this.fZs;
        }
        return null;
    }

    public TbRichTextImageInfo bLc() {
        if (this.mType == 8) {
            return this.fZm;
        }
        return null;
    }

    public i bLg() {
        if (this.mType != 32) {
            return null;
        }
        return this.fZq;
    }

    public TbRichTextVoiceInfo bLe() {
        if (this.mType == 512 || this.mType == 768) {
            return this.fnv;
        }
        return null;
    }

    public TbRichTextEmotionInfo bLh() {
        if (this.mType == 17) {
            return this.fZp;
        }
        return null;
    }

    public TbRichTextMemeInfo bLi() {
        if (this.mType == 20) {
            return this.fZt;
        }
        return null;
    }

    private SpannableString bLy() {
        if (this.mType != 1 || this.fZM == null) {
            return null;
        }
        return new SpannableString(this.fZM.getText());
    }

    private CharSequence Q(ArrayList<d> arrayList) {
        SpannableString a2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.fZM != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(R.string.video_text));
            CharSequence S = S(arrayList);
            if (S != null) {
                spannableStringBuilder.append(S);
            }
            if (this.fZM.bKY() == 1) {
                a2 = a(this.mType, this.fZM.getText(), this.fZM.bKZ(), 0);
            } else {
                a2 = a(this.mType, this.fZM.getText(), this.fZM.getText(), 0);
            }
            if (a2 != null) {
                spannableStringBuilder.append((CharSequence) a2);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence R(ArrayList<d> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.fZM != null) {
            CharSequence S = S(arrayList);
            if (S != null) {
                spannableStringBuilder.append(S);
            }
            SpannableString a2 = a(this.mType, this.fZM.getLink(), this.fZM.getLink(), 0);
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
        if (this.mType != 32 || this.fZM == null) {
            return null;
        }
        if (this.fZM.bKY() == 1) {
            return this.fZM.bKZ();
        }
        return this.fZM.getText();
    }

    private SpannableString bLz() {
        if ((this.mType != 2 && this.mType != 18) || this.fZM == null) {
            return null;
        }
        if (this.fZM.bKY() == 1) {
            return a(this.mType, this.fZM.getText(), this.fZM.bKZ(), 0);
        }
        return a(this.mType, this.fZM.getText(), this.fZM.getLink(), this.fZM.bLa());
    }

    private SpannableString bLA() {
        if (this.mType != 256 || this.fZM == null) {
            return null;
        }
        String text = this.fZM.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = text + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        f fVar = new f(this.mType, text);
        fVar.EU(this.fZM.getLink());
        spannableString.setSpan(fVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString bLB() {
        if (this.mType != 16 || this.fZM == null) {
            return null;
        }
        return a(this.mType, this.fZM.getText(), this.fZM.getLink(), 0);
    }

    private SpannableString T(ArrayList<d> arrayList) {
        String text;
        int DH;
        String str;
        a.C0596a Ec;
        if (this.mType != 4 || this.fZM == null || this.fZM.getText() == null || this.fZM.getLink() == null || (DH = TbFaceManager.bGo().DH((text = this.fZM.getText()))) == 0) {
            return null;
        }
        String DJ = TbFaceManager.bGo().DJ(text);
        if (!TextUtils.isEmpty(text) && text.startsWith("shoubai_emoji_")) {
            str = "[" + DJ + "]";
        } else {
            str = "#(" + DJ + ")";
        }
        SpannableString spannableString = new SpannableString(str + " ");
        d dVar = new d(TbadkCoreApplication.getInst().getContext(), DH);
        if (arrayList != null) {
            arrayList.add(dVar);
        }
        if (TbFaceManager.bGo().Ec(text) != null) {
            int width = (int) (Ec.getWidth() * 0.5d);
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
            boolean z = i == 2 && e.eh(str, str2);
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
                        TbRichTextItem.this.EV(str2);
                    }
                };
            } else {
                fVar = new f(i, str2);
            }
            fVar.tO(i2);
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

    private SpannableString bLC() {
        if (this.mType != 1024 || this.fZs == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString("a");
        Drawable tP = g.tP(this.fZs.btn_type);
        tP.setBounds(0, 0, tP.getIntrinsicWidth(), tP.getIntrinsicHeight());
        com.baidu.tbadk.widget.d dVar = new com.baidu.tbadk.widget.d(tP);
        dVar.setVerticalOffset(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds4));
        spannableString.setSpan(dVar, 0, 1, 33);
        spannableString.setSpan(new f(1024, this.fZs.link), spannableString.length() - 1, "a".length(), 33);
        return spannableString;
    }

    public CharSequence U(ArrayList<d> arrayList) {
        switch (this.mType) {
            case 1:
                return bLy();
            case 2:
                return bLz();
            case 4:
                return T(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return bLB();
            case 18:
                return bLz();
            case 32:
                return Q(arrayList);
            case 128:
                return R(arrayList);
            case 256:
                return bLA();
            case 1024:
                return bLC();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.fZq.bLM() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PbContent pbContent) {
        String str;
        try {
            this.mType = tM(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.fZm = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.fZM = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.fZp = new TbRichTextEmotionInfo();
                    this.fZp.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.fZp.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.fZp.mGifInfo.mStaticUrl = pbContent._static;
                    this.fZp.mType = this.mType;
                    this.fZp.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.fZp.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.fZp.mGifInfo.mPackageName = pbContent.packet_name;
                    this.fZp.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.fZp.mGifInfo.mDynamicUrl.split("/");
                    int i = 0;
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.fZp.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
                            break;
                        }
                    }
                    this.fZp.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
                case 20:
                    this.fZt = new TbRichTextMemeInfo();
                    this.fZt.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.fnv = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.fZs = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case PlatformPlugin.DEFAULT_SYSTEM_UI /* 1280 */:
                    this.fZr = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.fZq = new i();
                        this.fZq.b(pbContent);
                        break;
                    }
                    this.fZM = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.bGo().DH(this.fZM.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.fZM.setText(str);
                            break;
                        } else {
                            this.fZM.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.fZM.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.fZM != null) {
                this.fZM.trim();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        try {
            this.mType = tM(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.fZm = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.fnv = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.fZM = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.fZp = new TbRichTextEmotionInfo();
                this.fZp.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.fZp.mGifInfo.mDynamicUrl = jSONObject.optString("dynamic");
                this.fZp.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.fZp.mType = this.mType;
                this.fZp.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.fZp.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.fZp.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.fZp.mGifInfo.mIcon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                String[] split = this.fZp.mGifInfo.mDynamicUrl.split("/");
                int i = 0;
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.fZp.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
            } else {
                this.fZM = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int DH = TbFaceManager.bGo().DH(this.fZM.getText());
                    String optString = jSONObject.optString("c");
                    if (DH <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.fZM.setText(str);
                    } else {
                        this.fZM.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.fZM.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.fZM != null) {
                this.fZM.trim();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int tM(int i) {
        return e.tM(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EV(String str) {
        if (!TextUtils.isEmpty(str)) {
            m mVar = new m();
            mVar.mLink = str;
            mVar.type = 0;
            mVar.fCE = "1";
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, mVar));
        }
    }
}
