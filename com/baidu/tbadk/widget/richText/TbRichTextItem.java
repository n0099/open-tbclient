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
    private TbRichTextMemeInfo fIz;
    private int mType = 0;
    private TbRichTextCommInfo fIV = null;
    private TbRichTextImageInfo fIs = null;
    private TbRichTextVoiceInfo eXi = null;
    private TbRichTextEmotionInfo fIv = null;
    private j fIw = null;
    private TbRichTextLinkButtonInfo fIy = null;
    private TbRichTextLinkImageInfo fIx = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.fIV = tbRichTextCommInfo;
        this.fIs = tbRichTextImageInfo;
        this.eXi = tbRichTextVoiceInfo;
        this.fIv = tbRichTextEmotionInfo;
        this.fIy = tbRichTextLinkButtonInfo;
        this.fIx = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo bFW() {
        if (this.mType == 1280) {
            return this.fIx;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo bGm() {
        if (this.mType == 1024) {
            return this.fIy;
        }
        return null;
    }

    public TbRichTextImageInfo bFO() {
        if (this.mType == 8) {
            return this.fIs;
        }
        return null;
    }

    public j bFS() {
        if (this.mType != 32) {
            return null;
        }
        return this.fIw;
    }

    public TbRichTextVoiceInfo bFQ() {
        if (this.mType == 512 || this.mType == 768) {
            return this.eXi;
        }
        return null;
    }

    public TbRichTextEmotionInfo bFT() {
        if (this.mType == 17) {
            return this.fIv;
        }
        return null;
    }

    public TbRichTextMemeInfo bFU() {
        if (this.mType == 20) {
            return this.fIz;
        }
        return null;
    }

    private SpannableString bGn() {
        if (this.mType != 1 || this.fIV == null) {
            return null;
        }
        return new SpannableString(this.fIV.getText());
    }

    private CharSequence Q(ArrayList<d> arrayList) {
        SpannableString a2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.fIV != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(R.string.video_text));
            CharSequence S = S(arrayList);
            if (S != null) {
                spannableStringBuilder.append(S);
            }
            if (this.fIV.bFK() == 1) {
                a2 = a(this.mType, this.fIV.getText(), this.fIV.bFL(), 0);
            } else {
                a2 = a(this.mType, this.fIV.getText(), this.fIV.getText(), 0);
            }
            if (a2 != null) {
                spannableStringBuilder.append((CharSequence) a2);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence R(ArrayList<d> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.fIV != null) {
            CharSequence S = S(arrayList);
            if (S != null) {
                spannableStringBuilder.append(S);
            }
            SpannableString a2 = a(this.mType, this.fIV.getLink(), this.fIV.getLink(), 0);
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
        if (this.mType != 32 || this.fIV == null) {
            return null;
        }
        if (this.fIV.bFK() == 1) {
            return this.fIV.bFL();
        }
        return this.fIV.getText();
    }

    private SpannableString bGo() {
        if ((this.mType != 2 && this.mType != 18) || this.fIV == null) {
            return null;
        }
        if (this.fIV.bFK() == 1) {
            return a(this.mType, this.fIV.getText(), this.fIV.bFL(), 0);
        }
        return a(this.mType, this.fIV.getText(), this.fIV.getLink(), this.fIV.bFM());
    }

    private SpannableString bGp() {
        if (this.mType != 256 || this.fIV == null) {
            return null;
        }
        String text = this.fIV.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = text + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        f fVar = new f(this.mType, text);
        fVar.EI(this.fIV.getLink());
        spannableString.setSpan(fVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString bGq() {
        if (this.mType != 16 || this.fIV == null) {
            return null;
        }
        return a(this.mType, this.fIV.getText(), this.fIV.getLink(), 0);
    }

    private SpannableString T(ArrayList<d> arrayList) {
        String text;
        int DD;
        String str;
        a.C0593a DY;
        if (this.mType != 4 || this.fIV == null || this.fIV.getText() == null || this.fIV.getLink() == null || (DD = TbFaceManager.bBc().DD((text = this.fIV.getText()))) == 0) {
            return null;
        }
        String DF = TbFaceManager.bBc().DF(text);
        if (!TextUtils.isEmpty(text) && text.startsWith("shoubai_emoji_")) {
            str = "[" + DF + "]";
        } else {
            str = "#(" + DF + ")";
        }
        SpannableString spannableString = new SpannableString(str + " ");
        d dVar = new d(TbadkCoreApplication.getInst().getContext(), DD);
        if (arrayList != null) {
            arrayList.add(dVar);
        }
        if (TbFaceManager.bBc().DY(text) != null) {
            int width = (int) (DY.getWidth() * 0.5d);
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
                        TbRichTextItem.this.EJ(str2);
                    }
                };
            } else {
                fVar = new f(i, str2);
            }
            fVar.sC(i2);
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

    private SpannableString bGr() {
        if (this.mType != 1024 || this.fIy == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString("a");
        Drawable sD = g.sD(this.fIy.btn_type);
        sD.setBounds(0, 0, sD.getIntrinsicWidth(), sD.getIntrinsicHeight());
        com.baidu.tbadk.widget.d dVar = new com.baidu.tbadk.widget.d(sD);
        dVar.setVerticalOffset(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds4));
        spannableString.setSpan(dVar, 0, 1, 33);
        spannableString.setSpan(new f(1024, this.fIy.link), spannableString.length() - 1, "a".length(), 33);
        return spannableString;
    }

    public CharSequence U(ArrayList<d> arrayList) {
        switch (this.mType) {
            case 1:
                return bGn();
            case 2:
                return bGo();
            case 4:
                return T(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return bGq();
            case 18:
                return bGo();
            case 32:
                return Q(arrayList);
            case 128:
                return R(arrayList);
            case 256:
                return bGp();
            case 1024:
                return bGr();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.fIw.bGB() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = sA(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.fIs = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.fIV = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.fIv = new TbRichTextEmotionInfo();
                    this.fIv.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.fIv.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.fIv.mGifInfo.mStaticUrl = pbContent._static;
                    this.fIv.mType = this.mType;
                    this.fIv.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.fIv.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.fIv.mGifInfo.mPackageName = pbContent.packet_name;
                    this.fIv.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.fIv.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.fIv.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
                            break;
                        }
                    }
                    this.fIv.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
                case 20:
                    this.fIz = new TbRichTextMemeInfo();
                    this.fIz.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.eXi = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.fIy = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case PlatformPlugin.DEFAULT_SYSTEM_UI /* 1280 */:
                    this.fIx = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.fIw = new j();
                        this.fIw.b(pbContent);
                        break;
                    }
                    this.fIV = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.bBc().DD(this.fIV.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.fIV.setText(str);
                            break;
                        } else {
                            this.fIV.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.fIV.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.fIV != null) {
                this.fIV.trim();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = sA(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.fIs = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.eXi = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.fIV = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.fIv = new TbRichTextEmotionInfo();
                this.fIv.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.fIv.mGifInfo.mDynamicUrl = jSONObject.optString(PraiseUBCHelper.SOURCE_DYNAMIC);
                this.fIv.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.fIv.mType = this.mType;
                this.fIv.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.fIv.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.fIv.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.fIv.mGifInfo.mIcon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                String[] split = this.fIv.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.fIv.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
            } else {
                this.fIV = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int DD = TbFaceManager.bBc().DD(this.fIV.getText());
                    String optString = jSONObject.optString("c");
                    if (DD <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.fIV.setText(str);
                    } else {
                        this.fIV.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.fIV.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.fIV != null) {
                this.fIV.trim();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int sA(int i) {
        return e.sA(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EJ(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tbadk.data.l lVar = new com.baidu.tbadk.data.l();
            lVar.mLink = str;
            lVar.type = 0;
            lVar.fmn = "1";
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, lVar));
        }
    }
}
