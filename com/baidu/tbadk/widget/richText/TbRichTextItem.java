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
    private TbRichTextMemeInfo fuo;
    private int mType = 0;
    private TbRichTextCommInfo fuK = null;
    private TbRichTextImageInfo fuh = null;
    private TbRichTextVoiceInfo eIX = null;
    private TbRichTextEmotionInfo fuk = null;
    private j ful = null;
    private TbRichTextLinkButtonInfo fun = null;
    private TbRichTextLinkImageInfo fum = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.fuK = tbRichTextCommInfo;
        this.fuh = tbRichTextImageInfo;
        this.eIX = tbRichTextVoiceInfo;
        this.fuk = tbRichTextEmotionInfo;
        this.fun = tbRichTextLinkButtonInfo;
        this.fum = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo bBE() {
        if (this.mType == 1280) {
            return this.fum;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo bBU() {
        if (this.mType == 1024) {
            return this.fun;
        }
        return null;
    }

    public TbRichTextImageInfo bBw() {
        if (this.mType == 8) {
            return this.fuh;
        }
        return null;
    }

    public j bBA() {
        if (this.mType != 32) {
            return null;
        }
        return this.ful;
    }

    public TbRichTextVoiceInfo bBy() {
        if (this.mType == 512 || this.mType == 768) {
            return this.eIX;
        }
        return null;
    }

    public TbRichTextEmotionInfo bBB() {
        if (this.mType == 17) {
            return this.fuk;
        }
        return null;
    }

    public TbRichTextMemeInfo bBC() {
        if (this.mType == 20) {
            return this.fuo;
        }
        return null;
    }

    private SpannableString bBV() {
        if (this.mType != 1 || this.fuK == null) {
            return null;
        }
        return new SpannableString(this.fuK.getText());
    }

    private CharSequence Q(ArrayList<d> arrayList) {
        SpannableString a2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.fuK != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(R.string.video_text));
            CharSequence S = S(arrayList);
            if (S != null) {
                spannableStringBuilder.append(S);
            }
            if (this.fuK.bBs() == 1) {
                a2 = a(this.mType, this.fuK.getText(), this.fuK.bBt(), 0);
            } else {
                a2 = a(this.mType, this.fuK.getText(), this.fuK.getText(), 0);
            }
            if (a2 != null) {
                spannableStringBuilder.append((CharSequence) a2);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence R(ArrayList<d> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.fuK != null) {
            CharSequence S = S(arrayList);
            if (S != null) {
                spannableStringBuilder.append(S);
            }
            SpannableString a2 = a(this.mType, this.fuK.getLink(), this.fuK.getLink(), 0);
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
        if (this.mType != 32 || this.fuK == null) {
            return null;
        }
        if (this.fuK.bBs() == 1) {
            return this.fuK.bBt();
        }
        return this.fuK.getText();
    }

    private SpannableString bBW() {
        if ((this.mType != 2 && this.mType != 18) || this.fuK == null) {
            return null;
        }
        if (this.fuK.bBs() == 1) {
            return a(this.mType, this.fuK.getText(), this.fuK.bBt(), 0);
        }
        return a(this.mType, this.fuK.getText(), this.fuK.getLink(), this.fuK.bBu());
    }

    private SpannableString bBX() {
        if (this.mType != 256 || this.fuK == null) {
            return null;
        }
        String text = this.fuK.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = text + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        f fVar = new f(this.mType, text);
        fVar.Eb(this.fuK.getLink());
        spannableString.setSpan(fVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString bBY() {
        if (this.mType != 16 || this.fuK == null) {
            return null;
        }
        return a(this.mType, this.fuK.getText(), this.fuK.getLink(), 0);
    }

    private SpannableString T(ArrayList<d> arrayList) {
        String text;
        int CW;
        String str;
        a.C0567a Dr;
        if (this.mType != 4 || this.fuK == null || this.fuK.getText() == null || this.fuK.getLink() == null || (CW = TbFaceManager.bwK().CW((text = this.fuK.getText()))) == 0) {
            return null;
        }
        String CY = TbFaceManager.bwK().CY(text);
        if (!TextUtils.isEmpty(text) && text.startsWith("shoubai_emoji_")) {
            str = "[" + CY + "]";
        } else {
            str = "#(" + CY + ")";
        }
        SpannableString spannableString = new SpannableString(str + " ");
        d dVar = new d(TbadkCoreApplication.getInst().getContext(), CW);
        if (arrayList != null) {
            arrayList.add(dVar);
        }
        if (TbFaceManager.bwK().Dr(text) != null) {
            int width = (int) (Dr.getWidth() * 0.5d);
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
            boolean z = i == 2 && e.dU(str, str2);
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
                        TbRichTextItem.this.Ec(str2);
                    }
                };
            } else {
                fVar = new f(i, str2);
            }
            fVar.sh(i2);
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

    private SpannableString bBZ() {
        if (this.mType != 1024 || this.fun == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString("a");
        Drawable si = g.si(this.fun.btn_type);
        si.setBounds(0, 0, si.getIntrinsicWidth(), si.getIntrinsicHeight());
        com.baidu.tbadk.widget.d dVar = new com.baidu.tbadk.widget.d(si);
        dVar.setVerticalOffset(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds4));
        spannableString.setSpan(dVar, 0, 1, 33);
        spannableString.setSpan(new f(1024, this.fun.link), spannableString.length() - 1, "a".length(), 33);
        return spannableString;
    }

    public CharSequence U(ArrayList<d> arrayList) {
        switch (this.mType) {
            case 1:
                return bBV();
            case 2:
                return bBW();
            case 4:
                return T(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return bBY();
            case 18:
                return bBW();
            case 32:
                return Q(arrayList);
            case 128:
                return R(arrayList);
            case 256:
                return bBX();
            case 1024:
                return bBZ();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.ful.bCj() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = sf(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.fuh = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.fuK = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.fuk = new TbRichTextEmotionInfo();
                    this.fuk.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.fuk.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.fuk.mGifInfo.mStaticUrl = pbContent._static;
                    this.fuk.mType = this.mType;
                    this.fuk.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.fuk.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.fuk.mGifInfo.mPackageName = pbContent.packet_name;
                    this.fuk.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.fuk.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.fuk.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
                            break;
                        }
                    }
                    this.fuk.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
                case 20:
                    this.fuo = new TbRichTextMemeInfo();
                    this.fuo.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.eIX = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.fun = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case PlatformPlugin.DEFAULT_SYSTEM_UI /* 1280 */:
                    this.fum = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.ful = new j();
                        this.ful.b(pbContent);
                        break;
                    }
                    this.fuK = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.bwK().CW(this.fuK.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.fuK.setText(str);
                            break;
                        } else {
                            this.fuK.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.fuK.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.fuK != null) {
                this.fuK.trim();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = sf(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.fuh = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.eIX = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.fuK = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.fuk = new TbRichTextEmotionInfo();
                this.fuk.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.fuk.mGifInfo.mDynamicUrl = jSONObject.optString(PraiseUBCHelper.SOURCE_DYNAMIC);
                this.fuk.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.fuk.mType = this.mType;
                this.fuk.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.fuk.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.fuk.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.fuk.mGifInfo.mIcon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                String[] split = this.fuk.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.fuk.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
            } else {
                this.fuK = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int CW = TbFaceManager.bwK().CW(this.fuK.getText());
                    String optString = jSONObject.optString("c");
                    if (CW <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.fuK.setText(str);
                    } else {
                        this.fuK.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.fuK.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.fuK != null) {
                this.fuK.trim();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int sf(int i) {
        return e.sf(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ec(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tbadk.data.l lVar = new com.baidu.tbadk.data.l();
            lVar.mLink = str;
            lVar.type = 0;
            lVar.eXY = "1";
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, lVar));
        }
    }
}
