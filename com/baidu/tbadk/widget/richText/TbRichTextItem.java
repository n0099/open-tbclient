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
import com.baidu.tbadk.data.k;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.R;
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes2.dex */
public class TbRichTextItem extends OrmObject {
    private TbRichTextMemeInfo ffc;
    private int mType = 0;
    private TbRichTextCommInfo ffy = null;
    private TbRichTextImageInfo feV = null;
    private TbRichTextVoiceInfo euF = null;
    private TbRichTextEmotionInfo feY = null;
    private j feZ = null;
    private TbRichTextLinkButtonInfo ffb = null;
    private TbRichTextLinkImageInfo ffa = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.ffy = tbRichTextCommInfo;
        this.feV = tbRichTextImageInfo;
        this.euF = tbRichTextVoiceInfo;
        this.feY = tbRichTextEmotionInfo;
        this.ffb = tbRichTextLinkButtonInfo;
        this.ffa = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo bxK() {
        if (this.mType == 1280) {
            return this.ffa;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo bya() {
        if (this.mType == 1024) {
            return this.ffb;
        }
        return null;
    }

    public TbRichTextImageInfo bxC() {
        if (this.mType == 8) {
            return this.feV;
        }
        return null;
    }

    public j bxG() {
        if (this.mType != 32) {
            return null;
        }
        return this.feZ;
    }

    public TbRichTextVoiceInfo bxE() {
        if (this.mType == 512 || this.mType == 768) {
            return this.euF;
        }
        return null;
    }

    public TbRichTextEmotionInfo bxH() {
        if (this.mType == 17) {
            return this.feY;
        }
        return null;
    }

    public TbRichTextMemeInfo bxI() {
        if (this.mType == 20) {
            return this.ffc;
        }
        return null;
    }

    private SpannableString byb() {
        if (this.mType != 1 || this.ffy == null) {
            return null;
        }
        return new SpannableString(this.ffy.getText());
    }

    private CharSequence Q(ArrayList<d> arrayList) {
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.ffy != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(R.string.video_text));
            CharSequence S = S(arrayList);
            if (S != null) {
                spannableStringBuilder.append(S);
            }
            if (this.ffy.bxy() == 1) {
                a = a(this.mType, this.ffy.getText(), this.ffy.bxz(), 0);
            } else {
                a = a(this.mType, this.ffy.getText(), this.ffy.getText(), 0);
            }
            if (a != null) {
                spannableStringBuilder.append((CharSequence) a);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence R(ArrayList<d> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.ffy != null) {
            CharSequence S = S(arrayList);
            if (S != null) {
                spannableStringBuilder.append(S);
            }
            SpannableString a = a(this.mType, this.ffy.getLink(), this.ffy.getLink(), 0);
            if (a != null) {
                spannableStringBuilder.append((CharSequence) a);
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
        if (this.mType != 32 || this.ffy == null) {
            return null;
        }
        if (this.ffy.bxy() == 1) {
            return this.ffy.bxz();
        }
        return this.ffy.getText();
    }

    private SpannableString byc() {
        if ((this.mType != 2 && this.mType != 18) || this.ffy == null) {
            return null;
        }
        if (this.ffy.bxy() == 1) {
            return a(this.mType, this.ffy.getText(), this.ffy.bxz(), 0);
        }
        return a(this.mType, this.ffy.getText(), this.ffy.getLink(), this.ffy.bxA());
    }

    private SpannableString byd() {
        if (this.mType != 256 || this.ffy == null) {
            return null;
        }
        String text = this.ffy.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = text + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        f fVar = new f(this.mType, text);
        fVar.CS(this.ffy.getLink());
        spannableString.setSpan(fVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString bye() {
        if (this.mType != 16 || this.ffy == null) {
            return null;
        }
        return a(this.mType, this.ffy.getText(), this.ffy.getLink(), 0);
    }

    private SpannableString T(ArrayList<d> arrayList) {
        String text;
        int BN;
        String str;
        a.C0554a Ci;
        if (this.mType != 4 || this.ffy == null || this.ffy.getText() == null || this.ffy.getLink() == null || (BN = TbFaceManager.bsV().BN((text = this.ffy.getText()))) == 0) {
            return null;
        }
        String BP = TbFaceManager.bsV().BP(text);
        if (!TextUtils.isEmpty(text) && text.startsWith("shoubai_emoji_")) {
            str = "[" + BP + "]";
        } else {
            str = "#(" + BP + ")";
        }
        SpannableString spannableString = new SpannableString(str + " ");
        d dVar = new d(TbadkCoreApplication.getInst().getContext(), BN);
        if (arrayList != null) {
            arrayList.add(dVar);
        }
        if (TbFaceManager.bsV().Ci(text) != null) {
            int width = (int) (Ci.getWidth() * 0.5d);
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
            boolean z = i == 2 && e.dM(str, str2);
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
                        TbRichTextItem.this.CT(str2);
                    }
                };
            } else {
                fVar = new f(i, str2);
            }
            fVar.rs(i2);
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

    private SpannableString byf() {
        if (this.mType != 1024 || this.ffb == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString("a");
        Drawable rt = g.rt(this.ffb.btn_type);
        rt.setBounds(0, 0, rt.getIntrinsicWidth(), rt.getIntrinsicHeight());
        com.baidu.tbadk.widget.d dVar = new com.baidu.tbadk.widget.d(rt);
        dVar.setVerticalOffset(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds4));
        spannableString.setSpan(dVar, 0, 1, 33);
        spannableString.setSpan(new f(1024, this.ffb.link), spannableString.length() - 1, "a".length(), 33);
        return spannableString;
    }

    public CharSequence U(ArrayList<d> arrayList) {
        switch (this.mType) {
            case 1:
                return byb();
            case 2:
                return byc();
            case 4:
                return T(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return bye();
            case 18:
                return byc();
            case 32:
                return Q(arrayList);
            case 128:
                return R(arrayList);
            case 256:
                return byd();
            case 1024:
                return byf();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.feZ.byp() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = rq(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.feV = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.ffy = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.feY = new TbRichTextEmotionInfo();
                    this.feY.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.feY.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.feY.mGifInfo.mStaticUrl = pbContent._static;
                    this.feY.mType = this.mType;
                    this.feY.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.feY.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.feY.mGifInfo.mPackageName = pbContent.packet_name;
                    this.feY.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.feY.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.feY.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
                            break;
                        }
                    }
                    this.feY.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
                case 20:
                    this.ffc = new TbRichTextMemeInfo();
                    this.ffc.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.euF = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.ffb = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case PlatformPlugin.DEFAULT_SYSTEM_UI /* 1280 */:
                    this.ffa = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.feZ = new j();
                        this.feZ.b(pbContent);
                        break;
                    }
                    this.ffy = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.bsV().BN(this.ffy.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.ffy.setText(str);
                            break;
                        } else {
                            this.ffy.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.ffy.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.ffy != null) {
                this.ffy.trim();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = rq(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.feV = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.euF = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.ffy = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.feY = new TbRichTextEmotionInfo();
                this.feY.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.feY.mGifInfo.mDynamicUrl = jSONObject.optString(PraiseUBCHelper.SOURCE_DYNAMIC);
                this.feY.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.feY.mType = this.mType;
                this.feY.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.feY.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.feY.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.feY.mGifInfo.mIcon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                String[] split = this.feY.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.feY.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
            } else {
                this.ffy = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int BN = TbFaceManager.bsV().BN(this.ffy.getText());
                    String optString = jSONObject.optString("c");
                    if (BN <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.ffy.setText(str);
                    } else {
                        this.ffy.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.ffy.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.ffy != null) {
                this.ffy.trim();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int rq(int i) {
        return e.rq(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CT(String str) {
        if (!TextUtils.isEmpty(str)) {
            k kVar = new k();
            kVar.mLink = str;
            kVar.type = 0;
            kVar.eJB = "1";
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, kVar));
        }
    }
}
