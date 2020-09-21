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
    private TbRichTextMemeInfo fhX;
    private int mType = 0;
    private TbRichTextCommInfo fiv = null;
    private TbRichTextImageInfo fhQ = null;
    private TbRichTextVoiceInfo ewN = null;
    private TbRichTextEmotionInfo fhT = null;
    private j fhU = null;
    private TbRichTextLinkButtonInfo fhW = null;
    private TbRichTextLinkImageInfo fhV = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.fiv = tbRichTextCommInfo;
        this.fhQ = tbRichTextImageInfo;
        this.ewN = tbRichTextVoiceInfo;
        this.fhT = tbRichTextEmotionInfo;
        this.fhW = tbRichTextLinkButtonInfo;
        this.fhV = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo byU() {
        if (this.mType == 1280) {
            return this.fhV;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo bzk() {
        if (this.mType == 1024) {
            return this.fhW;
        }
        return null;
    }

    public TbRichTextImageInfo byM() {
        if (this.mType == 8) {
            return this.fhQ;
        }
        return null;
    }

    public j byQ() {
        if (this.mType != 32) {
            return null;
        }
        return this.fhU;
    }

    public TbRichTextVoiceInfo byO() {
        if (this.mType == 512 || this.mType == 768) {
            return this.ewN;
        }
        return null;
    }

    public TbRichTextEmotionInfo byR() {
        if (this.mType == 17) {
            return this.fhT;
        }
        return null;
    }

    public TbRichTextMemeInfo byS() {
        if (this.mType == 20) {
            return this.fhX;
        }
        return null;
    }

    private SpannableString bzl() {
        if (this.mType != 1 || this.fiv == null) {
            return null;
        }
        return new SpannableString(this.fiv.getText());
    }

    private CharSequence Q(ArrayList<d> arrayList) {
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.fiv != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(R.string.video_text));
            CharSequence S = S(arrayList);
            if (S != null) {
                spannableStringBuilder.append(S);
            }
            if (this.fiv.byI() == 1) {
                a = a(this.mType, this.fiv.getText(), this.fiv.byJ(), 0);
            } else {
                a = a(this.mType, this.fiv.getText(), this.fiv.getText(), 0);
            }
            if (a != null) {
                spannableStringBuilder.append((CharSequence) a);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence R(ArrayList<d> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.fiv != null) {
            CharSequence S = S(arrayList);
            if (S != null) {
                spannableStringBuilder.append(S);
            }
            SpannableString a = a(this.mType, this.fiv.getLink(), this.fiv.getLink(), 0);
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
        if (this.mType != 32 || this.fiv == null) {
            return null;
        }
        if (this.fiv.byI() == 1) {
            return this.fiv.byJ();
        }
        return this.fiv.getText();
    }

    private SpannableString bzm() {
        if ((this.mType != 2 && this.mType != 18) || this.fiv == null) {
            return null;
        }
        if (this.fiv.byI() == 1) {
            return a(this.mType, this.fiv.getText(), this.fiv.byJ(), 0);
        }
        return a(this.mType, this.fiv.getText(), this.fiv.getLink(), this.fiv.byK());
    }

    private SpannableString bzn() {
        if (this.mType != 256 || this.fiv == null) {
            return null;
        }
        String text = this.fiv.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = text + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        f fVar = new f(this.mType, text);
        fVar.Dp(this.fiv.getLink());
        spannableString.setSpan(fVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString bzo() {
        if (this.mType != 16 || this.fiv == null) {
            return null;
        }
        return a(this.mType, this.fiv.getText(), this.fiv.getLink(), 0);
    }

    private SpannableString T(ArrayList<d> arrayList) {
        String text;
        int Ck;
        String str;
        a.C0550a CF;
        if (this.mType != 4 || this.fiv == null || this.fiv.getText() == null || this.fiv.getLink() == null || (Ck = TbFaceManager.bua().Ck((text = this.fiv.getText()))) == 0) {
            return null;
        }
        String Cm = TbFaceManager.bua().Cm(text);
        if (!TextUtils.isEmpty(text) && text.startsWith("shoubai_emoji_")) {
            str = "[" + Cm + "]";
        } else {
            str = "#(" + Cm + ")";
        }
        SpannableString spannableString = new SpannableString(str + " ");
        d dVar = new d(TbadkCoreApplication.getInst().getContext(), Ck);
        if (arrayList != null) {
            arrayList.add(dVar);
        }
        if (TbFaceManager.bua().CF(text) != null) {
            int width = (int) (CF.getWidth() * 0.5d);
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
            boolean z = i == 2 && e.dP(str, str2);
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
                        TbRichTextItem.this.Dq(str2);
                    }
                };
            } else {
                fVar = new f(i, str2);
            }
            fVar.rJ(i2);
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

    private SpannableString bzp() {
        if (this.mType != 1024 || this.fhW == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString("a");
        Drawable rK = g.rK(this.fhW.btn_type);
        rK.setBounds(0, 0, rK.getIntrinsicWidth(), rK.getIntrinsicHeight());
        com.baidu.tbadk.widget.d dVar = new com.baidu.tbadk.widget.d(rK);
        dVar.setVerticalOffset(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds4));
        spannableString.setSpan(dVar, 0, 1, 33);
        spannableString.setSpan(new f(1024, this.fhW.link), spannableString.length() - 1, "a".length(), 33);
        return spannableString;
    }

    public CharSequence U(ArrayList<d> arrayList) {
        switch (this.mType) {
            case 1:
                return bzl();
            case 2:
                return bzm();
            case 4:
                return T(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return bzo();
            case 18:
                return bzm();
            case 32:
                return Q(arrayList);
            case 128:
                return R(arrayList);
            case 256:
                return bzn();
            case 1024:
                return bzp();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.fhU.bzz() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = rH(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.fhQ = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.fiv = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.fhT = new TbRichTextEmotionInfo();
                    this.fhT.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.fhT.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.fhT.mGifInfo.mStaticUrl = pbContent._static;
                    this.fhT.mType = this.mType;
                    this.fhT.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.fhT.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.fhT.mGifInfo.mPackageName = pbContent.packet_name;
                    this.fhT.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.fhT.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.fhT.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
                            break;
                        }
                    }
                    this.fhT.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
                case 20:
                    this.fhX = new TbRichTextMemeInfo();
                    this.fhX.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.ewN = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.fhW = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case PlatformPlugin.DEFAULT_SYSTEM_UI /* 1280 */:
                    this.fhV = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.fhU = new j();
                        this.fhU.b(pbContent);
                        break;
                    }
                    this.fiv = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.bua().Ck(this.fiv.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.fiv.setText(str);
                            break;
                        } else {
                            this.fiv.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.fiv.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.fiv != null) {
                this.fiv.trim();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = rH(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.fhQ = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.ewN = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.fiv = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.fhT = new TbRichTextEmotionInfo();
                this.fhT.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.fhT.mGifInfo.mDynamicUrl = jSONObject.optString(PraiseUBCHelper.SOURCE_DYNAMIC);
                this.fhT.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.fhT.mType = this.mType;
                this.fhT.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.fhT.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.fhT.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.fhT.mGifInfo.mIcon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                String[] split = this.fhT.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.fhT.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
            } else {
                this.fiv = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int Ck = TbFaceManager.bua().Ck(this.fiv.getText());
                    String optString = jSONObject.optString("c");
                    if (Ck <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.fiv.setText(str);
                    } else {
                        this.fiv.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.fiv.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.fiv != null) {
                this.fiv.trim();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int rH(int i) {
        return e.rH(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dq(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tbadk.data.l lVar = new com.baidu.tbadk.data.l();
            lVar.mLink = str;
            lVar.type = 0;
            lVar.eLR = "1";
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, lVar));
        }
    }
}
