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
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.ui.animview.util.PraiseUBCHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.R;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextItem extends OrmObject {
    private TbRichTextMemeInfo dPf;
    private int mType = 0;
    private TbRichTextCommInfo dPz = null;
    private TbRichTextImageInfo dOY = null;
    private TbRichTextVoiceInfo diS = null;
    private TbRichTextEmotionInfo dPb = null;
    private i dPc = null;
    private TbRichTextLinkButtonInfo dPe = null;
    private TbRichTextLinkImageInfo dPd = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.dPz = tbRichTextCommInfo;
        this.dOY = tbRichTextImageInfo;
        this.diS = tbRichTextVoiceInfo;
        this.dPb = tbRichTextEmotionInfo;
        this.dPe = tbRichTextLinkButtonInfo;
        this.dPd = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo aUl() {
        if (this.mType == 1280) {
            return this.dPd;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo aUx() {
        if (this.mType == 1024) {
            return this.dPe;
        }
        return null;
    }

    public TbRichTextImageInfo aUd() {
        if (this.mType == 8) {
            return this.dOY;
        }
        return null;
    }

    public i aUh() {
        if (this.mType != 32) {
            return null;
        }
        return this.dPc;
    }

    public TbRichTextVoiceInfo aUf() {
        if (this.mType == 512 || this.mType == 768) {
            return this.diS;
        }
        return null;
    }

    public TbRichTextEmotionInfo aUi() {
        if (this.mType == 17) {
            return this.dPb;
        }
        return null;
    }

    public TbRichTextMemeInfo aUj() {
        if (this.mType == 20) {
            return this.dPf;
        }
        return null;
    }

    private SpannableString aUy() {
        if (this.mType != 1 || this.dPz == null) {
            return null;
        }
        return new SpannableString(this.dPz.getText());
    }

    private CharSequence J(ArrayList<d> arrayList) {
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.dPz != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(R.string.video_text));
            CharSequence L = L(arrayList);
            if (L != null) {
                spannableStringBuilder.append(L);
            }
            if (this.dPz.aTZ() == 1) {
                a = a(this.mType, this.dPz.getText(), this.dPz.aUa(), 0);
            } else {
                a = a(this.mType, this.dPz.getText(), this.dPz.getText(), 0);
            }
            if (a != null) {
                spannableStringBuilder.append((CharSequence) a);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence K(ArrayList<d> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.dPz != null) {
            CharSequence L = L(arrayList);
            if (L != null) {
                spannableStringBuilder.append(L);
            }
            SpannableString a = a(this.mType, this.dPz.getLink(), this.dPz.getLink(), 0);
            if (a != null) {
                spannableStringBuilder.append((CharSequence) a);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence L(ArrayList<d> arrayList) {
        TbRichTextItem tbRichTextItem = new TbRichTextItem();
        tbRichTextItem.a(4, new TbRichTextCommInfo("video_icon", HanziToPinyin.Token.SEPARATOR), null, null, null, null, null);
        return tbRichTextItem.N(arrayList);
    }

    public String getVideoUrl() {
        if (this.mType != 32 || this.dPz == null) {
            return null;
        }
        if (this.dPz.aTZ() == 1) {
            return this.dPz.aUa();
        }
        return this.dPz.getText();
    }

    private SpannableString aUz() {
        if ((this.mType != 2 && this.mType != 18) || this.dPz == null) {
            return null;
        }
        if (this.dPz.aTZ() == 1) {
            return a(this.mType, this.dPz.getText(), this.dPz.aUa(), 0);
        }
        return a(this.mType, this.dPz.getText(), this.dPz.getLink(), this.dPz.aUb());
    }

    private SpannableString aUA() {
        if (this.mType != 256 || this.dPz == null) {
            return null;
        }
        String text = this.dPz.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(HanziToPinyin.Token.SEPARATOR)) {
            text = text + HanziToPinyin.Token.SEPARATOR;
        }
        SpannableString spannableString = new SpannableString(text);
        f fVar = new f(this.mType, text);
        fVar.wg(this.dPz.getLink());
        spannableString.setSpan(fVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString aUB() {
        if (this.mType != 16 || this.dPz == null) {
            return null;
        }
        return a(this.mType, this.dPz.getText(), this.dPz.getLink(), 0);
    }

    private SpannableString M(ArrayList<d> arrayList) {
        String text;
        int vb;
        String str;
        a.C0391a vu;
        if (this.mType != 4 || this.dPz == null || this.dPz.getText() == null || this.dPz.getLink() == null || (vb = TbFaceManager.aPU().vb((text = this.dPz.getText()))) == 0) {
            return null;
        }
        String vd = TbFaceManager.aPU().vd(text);
        if (!TextUtils.isEmpty(text) && text.startsWith("shoubai_emoji_")) {
            str = "[" + vd + "]";
        } else {
            str = "#(" + vd + ")";
        }
        SpannableString spannableString = new SpannableString(str + HanziToPinyin.Token.SEPARATOR);
        d dVar = new d(TbadkCoreApplication.getInst().getContext(), vb);
        if (arrayList != null) {
            arrayList.add(dVar);
        }
        if (TbFaceManager.aPU().vu(text) != null) {
            int width = (int) (vu.getWidth() * 0.5d);
            dVar.setBounds(new Rect(0, 0, width, width));
        } else {
            dVar.setBounds(new Rect(0, 0, 0, 0));
        }
        spannableString.setSpan(new com.baidu.tbadk.widget.a(dVar, 1), 0, str.length(), 33);
        return spannableString;
    }

    private SpannableString a(int i, String str, final String str2, int i2) {
        f fVar;
        if (str == null) {
            return null;
        }
        if (!str.endsWith(HanziToPinyin.Token.SEPARATOR)) {
            str = str + HanziToPinyin.Token.SEPARATOR;
        }
        SpannableString spannableString = new SpannableString(str);
        if (this.mType == 18) {
            fVar = new f(i, str2) { // from class: com.baidu.tbadk.widget.richText.TbRichTextItem.1
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    TbRichTextItem.this.wh(str2);
                }
            };
        } else {
            fVar = new f(i, str2);
        }
        fVar.ny(i2);
        if (i2 == 1) {
            fVar.setTextColor(R.color.cp_cont_d);
        } else {
            fVar.setTextColor(-1);
        }
        spannableString.setSpan(fVar, 0, str.length() - 1, 33);
        return spannableString;
    }

    private SpannableString aUC() {
        if (this.mType != 1024 || this.dPe == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(Config.APP_VERSION_CODE);
        Drawable nz = g.nz(this.dPe.btn_type);
        nz.setBounds(0, 0, nz.getIntrinsicWidth(), nz.getIntrinsicHeight());
        com.baidu.tbadk.widget.c cVar = new com.baidu.tbadk.widget.c(nz);
        cVar.setVerticalOffset(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds4));
        spannableString.setSpan(cVar, 0, 1, 33);
        spannableString.setSpan(new f(1024, this.dPe.link), spannableString.length() - 1, Config.APP_VERSION_CODE.length(), 33);
        return spannableString;
    }

    public CharSequence N(ArrayList<d> arrayList) {
        switch (this.mType) {
            case 1:
                return aUy();
            case 2:
                return aUz();
            case 4:
                return M(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return aUB();
            case 18:
                return aUz();
            case 32:
                return J(arrayList);
            case 128:
                return K(arrayList);
            case 256:
                return aUA();
            case 1024:
                return aUC();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.dPc.aUM() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = nw(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.dOY = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.dPz = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.dPb = new TbRichTextEmotionInfo();
                    this.dPb.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.dPb.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.dPb.mGifInfo.mStaticUrl = pbContent._static;
                    this.dPb.mType = this.mType;
                    this.dPb.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.dPb.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.dPb.mGifInfo.mPackageName = pbContent.packet_name;
                    this.dPb.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.dPb.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.dPb.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
                            break;
                        }
                    }
                    this.dPb.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
                case 20:
                    this.dPf = new TbRichTextMemeInfo();
                    this.dPf.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.diS = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.dPe = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case 1280:
                    this.dPd = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.dPc = new i();
                        this.dPc.b(pbContent);
                        break;
                    }
                    this.dPz = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.aPU().vb(this.dPz.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.dPz.setText(str);
                            break;
                        } else {
                            this.dPz.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.dPz.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.dPz != null) {
                this.dPz.trim();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = nw(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.dOY = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.diS = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.dPz = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.dPb = new TbRichTextEmotionInfo();
                this.dPb.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.dPb.mGifInfo.mDynamicUrl = jSONObject.optString(PraiseUBCHelper.SOURCE_DYNAMIC);
                this.dPb.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.dPb.mType = this.mType;
                this.dPb.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.dPb.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.dPb.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.dPb.mGifInfo.mIcon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                String[] split = this.dPb.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.dPb.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
            } else {
                this.dPz = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int vb = TbFaceManager.aPU().vb(this.dPz.getText());
                    String optString = jSONObject.optString("c");
                    if (vb <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.dPz.setText(str);
                    } else {
                        this.dPz.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.dPz.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.dPz != null) {
                this.dPz.trim();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int nw(int i) {
        return e.nw(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wh(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tbadk.data.l lVar = new com.baidu.tbadk.data.l();
            lVar.mLink = str;
            lVar.type = 0;
            lVar.dwd = "1";
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, lVar));
        }
    }
}
