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
    private TbRichTextMemeInfo fUM;
    private int mType = 0;
    private TbRichTextCommInfo fVf = null;
    private TbRichTextImageInfo fUF = null;
    private TbRichTextVoiceInfo fiM = null;
    private TbRichTextEmotionInfo fUI = null;
    private i fUJ = null;
    private TbRichTextLinkButtonInfo fUL = null;
    private TbRichTextLinkImageInfo fUK = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.fVf = tbRichTextCommInfo;
        this.fUF = tbRichTextImageInfo;
        this.fiM = tbRichTextVoiceInfo;
        this.fUI = tbRichTextEmotionInfo;
        this.fUL = tbRichTextLinkButtonInfo;
        this.fUK = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo bHt() {
        if (this.mType == 1280) {
            return this.fUK;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo bHG() {
        if (this.mType == 1024) {
            return this.fUL;
        }
        return null;
    }

    public TbRichTextImageInfo bHl() {
        if (this.mType == 8) {
            return this.fUF;
        }
        return null;
    }

    public i bHp() {
        if (this.mType != 32) {
            return null;
        }
        return this.fUJ;
    }

    public TbRichTextVoiceInfo bHn() {
        if (this.mType == 512 || this.mType == 768) {
            return this.fiM;
        }
        return null;
    }

    public TbRichTextEmotionInfo bHq() {
        if (this.mType == 17) {
            return this.fUI;
        }
        return null;
    }

    public TbRichTextMemeInfo bHr() {
        if (this.mType == 20) {
            return this.fUM;
        }
        return null;
    }

    private SpannableString bHH() {
        if (this.mType != 1 || this.fVf == null) {
            return null;
        }
        return new SpannableString(this.fVf.getText());
    }

    private CharSequence L(ArrayList<d> arrayList) {
        SpannableString a2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.fVf != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(R.string.video_text));
            CharSequence N = N(arrayList);
            if (N != null) {
                spannableStringBuilder.append(N);
            }
            if (this.fVf.bHh() == 1) {
                a2 = a(this.mType, this.fVf.getText(), this.fVf.bHi(), 0);
            } else {
                a2 = a(this.mType, this.fVf.getText(), this.fVf.getText(), 0);
            }
            if (a2 != null) {
                spannableStringBuilder.append((CharSequence) a2);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence M(ArrayList<d> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.fVf != null) {
            CharSequence N = N(arrayList);
            if (N != null) {
                spannableStringBuilder.append(N);
            }
            SpannableString a2 = a(this.mType, this.fVf.getLink(), this.fVf.getLink(), 0);
            if (a2 != null) {
                spannableStringBuilder.append((CharSequence) a2);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence N(ArrayList<d> arrayList) {
        TbRichTextItem tbRichTextItem = new TbRichTextItem();
        tbRichTextItem.a(4, new TbRichTextCommInfo("video_icon", " "), null, null, null, null, null);
        return tbRichTextItem.P(arrayList);
    }

    public String getVideoUrl() {
        if (this.mType != 32 || this.fVf == null) {
            return null;
        }
        if (this.fVf.bHh() == 1) {
            return this.fVf.bHi();
        }
        return this.fVf.getText();
    }

    private SpannableString bHI() {
        if ((this.mType != 2 && this.mType != 18) || this.fVf == null) {
            return null;
        }
        if (this.fVf.bHh() == 1) {
            return a(this.mType, this.fVf.getText(), this.fVf.bHi(), 0);
        }
        return a(this.mType, this.fVf.getText(), this.fVf.getLink(), this.fVf.bHj());
    }

    private SpannableString bHJ() {
        if (this.mType != 256 || this.fVf == null) {
            return null;
        }
        String text = this.fVf.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = text + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        f fVar = new f(this.mType, text);
        fVar.DI(this.fVf.getLink());
        spannableString.setSpan(fVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString bHK() {
        if (this.mType != 16 || this.fVf == null) {
            return null;
        }
        return a(this.mType, this.fVf.getText(), this.fVf.getLink(), 0);
    }

    private SpannableString O(ArrayList<d> arrayList) {
        String text;
        int Cv;
        String str;
        a.C0579a CQ;
        if (this.mType != 4 || this.fVf == null || this.fVf.getText() == null || this.fVf.getLink() == null || (Cv = TbFaceManager.bCw().Cv((text = this.fVf.getText()))) == 0) {
            return null;
        }
        String Cx = TbFaceManager.bCw().Cx(text);
        if (!TextUtils.isEmpty(text) && text.startsWith("shoubai_emoji_")) {
            str = "[" + Cx + "]";
        } else {
            str = "#(" + Cx + ")";
        }
        SpannableString spannableString = new SpannableString(str + " ");
        d dVar = new d(TbadkCoreApplication.getInst().getContext(), Cv);
        if (arrayList != null) {
            arrayList.add(dVar);
        }
        if (TbFaceManager.bCw().CQ(text) != null) {
            int width = (int) (CQ.getWidth() * 0.5d);
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
            boolean z = i == 2 && e.eg(str, str2);
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
                        TbRichTextItem.this.DJ(str2);
                    }
                };
            } else {
                fVar = new f(i, str2);
            }
            fVar.si(i2);
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

    private SpannableString bHL() {
        if (this.mType != 1024 || this.fUL == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString("a");
        Drawable sj = g.sj(this.fUL.btn_type);
        sj.setBounds(0, 0, sj.getIntrinsicWidth(), sj.getIntrinsicHeight());
        com.baidu.tbadk.widget.d dVar = new com.baidu.tbadk.widget.d(sj);
        dVar.setVerticalOffset(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds4));
        spannableString.setSpan(dVar, 0, 1, 33);
        spannableString.setSpan(new f(1024, this.fUL.link), spannableString.length() - 1, "a".length(), 33);
        return spannableString;
    }

    public CharSequence P(ArrayList<d> arrayList) {
        switch (this.mType) {
            case 1:
                return bHH();
            case 2:
                return bHI();
            case 4:
                return O(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return bHK();
            case 18:
                return bHI();
            case 32:
                return L(arrayList);
            case 128:
                return M(arrayList);
            case 256:
                return bHJ();
            case 1024:
                return bHL();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.fUJ.bHV() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PbContent pbContent) {
        String str;
        try {
            this.mType = sg(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.fUF = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.fVf = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.fUI = new TbRichTextEmotionInfo();
                    this.fUI.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.fUI.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.fUI.mGifInfo.mStaticUrl = pbContent._static;
                    this.fUI.mType = this.mType;
                    this.fUI.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.fUI.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.fUI.mGifInfo.mPackageName = pbContent.packet_name;
                    this.fUI.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.fUI.mGifInfo.mDynamicUrl.split("/");
                    int i = 0;
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.fUI.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
                            break;
                        }
                    }
                    this.fUI.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
                case 20:
                    this.fUM = new TbRichTextMemeInfo();
                    this.fUM.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.fiM = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.fUL = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case PlatformPlugin.DEFAULT_SYSTEM_UI /* 1280 */:
                    this.fUK = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.fUJ = new i();
                        this.fUJ.b(pbContent);
                        break;
                    }
                    this.fVf = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.bCw().Cv(this.fVf.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.fVf.setText(str);
                            break;
                        } else {
                            this.fVf.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.fVf.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.fVf != null) {
                this.fVf.trim();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        try {
            this.mType = sg(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.fUF = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.fiM = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.fVf = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.fUI = new TbRichTextEmotionInfo();
                this.fUI.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.fUI.mGifInfo.mDynamicUrl = jSONObject.optString("dynamic");
                this.fUI.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.fUI.mType = this.mType;
                this.fUI.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.fUI.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.fUI.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.fUI.mGifInfo.mIcon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                String[] split = this.fUI.mGifInfo.mDynamicUrl.split("/");
                int i = 0;
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.fUI.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
            } else {
                this.fVf = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int Cv = TbFaceManager.bCw().Cv(this.fVf.getText());
                    String optString = jSONObject.optString("c");
                    if (Cv <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.fVf.setText(str);
                    } else {
                        this.fVf.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.fVf.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.fVf != null) {
                this.fVf.trim();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int sg(int i) {
        return e.sg(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DJ(String str) {
        if (!TextUtils.isEmpty(str)) {
            m mVar = new m();
            mVar.mLink = str;
            mVar.type = 0;
            mVar.fxW = "1";
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, mVar));
        }
    }
}
