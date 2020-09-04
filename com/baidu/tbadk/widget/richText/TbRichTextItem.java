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
/* loaded from: classes.dex */
public class TbRichTextItem extends OrmObject {
    private TbRichTextMemeInfo ffg;
    private int mType = 0;
    private TbRichTextCommInfo ffC = null;
    private TbRichTextImageInfo feZ = null;
    private TbRichTextVoiceInfo euJ = null;
    private TbRichTextEmotionInfo ffc = null;
    private j ffd = null;
    private TbRichTextLinkButtonInfo fff = null;
    private TbRichTextLinkImageInfo ffe = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.ffC = tbRichTextCommInfo;
        this.feZ = tbRichTextImageInfo;
        this.euJ = tbRichTextVoiceInfo;
        this.ffc = tbRichTextEmotionInfo;
        this.fff = tbRichTextLinkButtonInfo;
        this.ffe = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo bxL() {
        if (this.mType == 1280) {
            return this.ffe;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo byb() {
        if (this.mType == 1024) {
            return this.fff;
        }
        return null;
    }

    public TbRichTextImageInfo bxD() {
        if (this.mType == 8) {
            return this.feZ;
        }
        return null;
    }

    public j bxH() {
        if (this.mType != 32) {
            return null;
        }
        return this.ffd;
    }

    public TbRichTextVoiceInfo bxF() {
        if (this.mType == 512 || this.mType == 768) {
            return this.euJ;
        }
        return null;
    }

    public TbRichTextEmotionInfo bxI() {
        if (this.mType == 17) {
            return this.ffc;
        }
        return null;
    }

    public TbRichTextMemeInfo bxJ() {
        if (this.mType == 20) {
            return this.ffg;
        }
        return null;
    }

    private SpannableString byc() {
        if (this.mType != 1 || this.ffC == null) {
            return null;
        }
        return new SpannableString(this.ffC.getText());
    }

    private CharSequence Q(ArrayList<d> arrayList) {
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.ffC != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(R.string.video_text));
            CharSequence S = S(arrayList);
            if (S != null) {
                spannableStringBuilder.append(S);
            }
            if (this.ffC.bxz() == 1) {
                a = a(this.mType, this.ffC.getText(), this.ffC.bxA(), 0);
            } else {
                a = a(this.mType, this.ffC.getText(), this.ffC.getText(), 0);
            }
            if (a != null) {
                spannableStringBuilder.append((CharSequence) a);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence R(ArrayList<d> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.ffC != null) {
            CharSequence S = S(arrayList);
            if (S != null) {
                spannableStringBuilder.append(S);
            }
            SpannableString a = a(this.mType, this.ffC.getLink(), this.ffC.getLink(), 0);
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
        if (this.mType != 32 || this.ffC == null) {
            return null;
        }
        if (this.ffC.bxz() == 1) {
            return this.ffC.bxA();
        }
        return this.ffC.getText();
    }

    private SpannableString byd() {
        if ((this.mType != 2 && this.mType != 18) || this.ffC == null) {
            return null;
        }
        if (this.ffC.bxz() == 1) {
            return a(this.mType, this.ffC.getText(), this.ffC.bxA(), 0);
        }
        return a(this.mType, this.ffC.getText(), this.ffC.getLink(), this.ffC.bxB());
    }

    private SpannableString bye() {
        if (this.mType != 256 || this.ffC == null) {
            return null;
        }
        String text = this.ffC.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = text + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        f fVar = new f(this.mType, text);
        fVar.CT(this.ffC.getLink());
        spannableString.setSpan(fVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString byf() {
        if (this.mType != 16 || this.ffC == null) {
            return null;
        }
        return a(this.mType, this.ffC.getText(), this.ffC.getLink(), 0);
    }

    private SpannableString T(ArrayList<d> arrayList) {
        String text;
        int BO;
        String str;
        a.C0554a Cj;
        if (this.mType != 4 || this.ffC == null || this.ffC.getText() == null || this.ffC.getLink() == null || (BO = TbFaceManager.bsW().BO((text = this.ffC.getText()))) == 0) {
            return null;
        }
        String BQ = TbFaceManager.bsW().BQ(text);
        if (!TextUtils.isEmpty(text) && text.startsWith("shoubai_emoji_")) {
            str = "[" + BQ + "]";
        } else {
            str = "#(" + BQ + ")";
        }
        SpannableString spannableString = new SpannableString(str + " ");
        d dVar = new d(TbadkCoreApplication.getInst().getContext(), BO);
        if (arrayList != null) {
            arrayList.add(dVar);
        }
        if (TbFaceManager.bsW().Cj(text) != null) {
            int width = (int) (Cj.getWidth() * 0.5d);
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
            boolean z = i == 2 && e.dN(str, str2);
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
                        TbRichTextItem.this.CU(str2);
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

    private SpannableString byg() {
        if (this.mType != 1024 || this.fff == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString("a");
        Drawable rt = g.rt(this.fff.btn_type);
        rt.setBounds(0, 0, rt.getIntrinsicWidth(), rt.getIntrinsicHeight());
        com.baidu.tbadk.widget.d dVar = new com.baidu.tbadk.widget.d(rt);
        dVar.setVerticalOffset(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds4));
        spannableString.setSpan(dVar, 0, 1, 33);
        spannableString.setSpan(new f(1024, this.fff.link), spannableString.length() - 1, "a".length(), 33);
        return spannableString;
    }

    public CharSequence U(ArrayList<d> arrayList) {
        switch (this.mType) {
            case 1:
                return byc();
            case 2:
                return byd();
            case 4:
                return T(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return byf();
            case 18:
                return byd();
            case 32:
                return Q(arrayList);
            case 128:
                return R(arrayList);
            case 256:
                return bye();
            case 1024:
                return byg();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.ffd.byq() != false) goto L9;
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
                    this.feZ = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.ffC = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.ffc = new TbRichTextEmotionInfo();
                    this.ffc.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.ffc.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.ffc.mGifInfo.mStaticUrl = pbContent._static;
                    this.ffc.mType = this.mType;
                    this.ffc.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.ffc.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.ffc.mGifInfo.mPackageName = pbContent.packet_name;
                    this.ffc.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.ffc.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.ffc.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
                            break;
                        }
                    }
                    this.ffc.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
                case 20:
                    this.ffg = new TbRichTextMemeInfo();
                    this.ffg.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.euJ = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.fff = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case PlatformPlugin.DEFAULT_SYSTEM_UI /* 1280 */:
                    this.ffe = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.ffd = new j();
                        this.ffd.b(pbContent);
                        break;
                    }
                    this.ffC = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.bsW().BO(this.ffC.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.ffC.setText(str);
                            break;
                        } else {
                            this.ffC.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.ffC.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.ffC != null) {
                this.ffC.trim();
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
                this.feZ = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.euJ = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.ffC = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.ffc = new TbRichTextEmotionInfo();
                this.ffc.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.ffc.mGifInfo.mDynamicUrl = jSONObject.optString(PraiseUBCHelper.SOURCE_DYNAMIC);
                this.ffc.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.ffc.mType = this.mType;
                this.ffc.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.ffc.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.ffc.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.ffc.mGifInfo.mIcon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                String[] split = this.ffc.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.ffc.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
            } else {
                this.ffC = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int BO = TbFaceManager.bsW().BO(this.ffC.getText());
                    String optString = jSONObject.optString("c");
                    if (BO <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.ffC.setText(str);
                    } else {
                        this.ffC.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.ffC.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.ffC != null) {
                this.ffC.trim();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int rq(int i) {
        return e.rq(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CU(String str) {
        if (!TextUtils.isEmpty(str)) {
            k kVar = new k();
            kVar.mLink = str;
            kVar.type = 0;
            kVar.eJF = "1";
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, kVar));
        }
    }
}
