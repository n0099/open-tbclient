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
    private TbRichTextMemeInfo dOA;
    private int mType = 0;
    private TbRichTextCommInfo dOU = null;
    private TbRichTextImageInfo dOt = null;
    private TbRichTextVoiceInfo dip = null;
    private TbRichTextEmotionInfo dOw = null;
    private i dOx = null;
    private TbRichTextLinkButtonInfo dOz = null;
    private TbRichTextLinkImageInfo dOy = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.dOU = tbRichTextCommInfo;
        this.dOt = tbRichTextImageInfo;
        this.dip = tbRichTextVoiceInfo;
        this.dOw = tbRichTextEmotionInfo;
        this.dOz = tbRichTextLinkButtonInfo;
        this.dOy = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo aUe() {
        if (this.mType == 1280) {
            return this.dOy;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo aUq() {
        if (this.mType == 1024) {
            return this.dOz;
        }
        return null;
    }

    public TbRichTextImageInfo aTW() {
        if (this.mType == 8) {
            return this.dOt;
        }
        return null;
    }

    public i aUa() {
        if (this.mType != 32) {
            return null;
        }
        return this.dOx;
    }

    public TbRichTextVoiceInfo aTY() {
        if (this.mType == 512 || this.mType == 768) {
            return this.dip;
        }
        return null;
    }

    public TbRichTextEmotionInfo aUb() {
        if (this.mType == 17) {
            return this.dOw;
        }
        return null;
    }

    public TbRichTextMemeInfo aUc() {
        if (this.mType == 20) {
            return this.dOA;
        }
        return null;
    }

    private SpannableString aUr() {
        if (this.mType != 1 || this.dOU == null) {
            return null;
        }
        return new SpannableString(this.dOU.getText());
    }

    private CharSequence J(ArrayList<d> arrayList) {
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.dOU != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(R.string.video_text));
            CharSequence L = L(arrayList);
            if (L != null) {
                spannableStringBuilder.append(L);
            }
            if (this.dOU.aTS() == 1) {
                a = a(this.mType, this.dOU.getText(), this.dOU.aTT(), 0);
            } else {
                a = a(this.mType, this.dOU.getText(), this.dOU.getText(), 0);
            }
            if (a != null) {
                spannableStringBuilder.append((CharSequence) a);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence K(ArrayList<d> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.dOU != null) {
            CharSequence L = L(arrayList);
            if (L != null) {
                spannableStringBuilder.append(L);
            }
            SpannableString a = a(this.mType, this.dOU.getLink(), this.dOU.getLink(), 0);
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
        if (this.mType != 32 || this.dOU == null) {
            return null;
        }
        if (this.dOU.aTS() == 1) {
            return this.dOU.aTT();
        }
        return this.dOU.getText();
    }

    private SpannableString aUs() {
        if ((this.mType != 2 && this.mType != 18) || this.dOU == null) {
            return null;
        }
        if (this.dOU.aTS() == 1) {
            return a(this.mType, this.dOU.getText(), this.dOU.aTT(), 0);
        }
        return a(this.mType, this.dOU.getText(), this.dOU.getLink(), this.dOU.aTU());
    }

    private SpannableString aUt() {
        if (this.mType != 256 || this.dOU == null) {
            return null;
        }
        String text = this.dOU.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(HanziToPinyin.Token.SEPARATOR)) {
            text = text + HanziToPinyin.Token.SEPARATOR;
        }
        SpannableString spannableString = new SpannableString(text);
        f fVar = new f(this.mType, text);
        fVar.wf(this.dOU.getLink());
        spannableString.setSpan(fVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString aUu() {
        if (this.mType != 16 || this.dOU == null) {
            return null;
        }
        return a(this.mType, this.dOU.getText(), this.dOU.getLink(), 0);
    }

    private SpannableString M(ArrayList<d> arrayList) {
        String text;
        int vb;
        String str;
        a.C0391a vu;
        if (this.mType != 4 || this.dOU == null || this.dOU.getText() == null || this.dOU.getLink() == null || (vb = TbFaceManager.aPN().vb((text = this.dOU.getText()))) == 0) {
            return null;
        }
        String vd = TbFaceManager.aPN().vd(text);
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
        if (TbFaceManager.aPN().vu(text) != null) {
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
                    TbRichTextItem.this.wg(str2);
                }
            };
        } else {
            fVar = new f(i, str2);
        }
        fVar.nw(i2);
        if (i2 == 1) {
            fVar.setTextColor(R.color.cp_cont_d);
        } else {
            fVar.setTextColor(-1);
        }
        spannableString.setSpan(fVar, 0, str.length() - 1, 33);
        return spannableString;
    }

    private SpannableString aUv() {
        if (this.mType != 1024 || this.dOz == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(Config.APP_VERSION_CODE);
        Drawable nx = g.nx(this.dOz.btn_type);
        nx.setBounds(0, 0, nx.getIntrinsicWidth(), nx.getIntrinsicHeight());
        com.baidu.tbadk.widget.c cVar = new com.baidu.tbadk.widget.c(nx);
        cVar.setVerticalOffset(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds4));
        spannableString.setSpan(cVar, 0, 1, 33);
        spannableString.setSpan(new f(1024, this.dOz.link), spannableString.length() - 1, Config.APP_VERSION_CODE.length(), 33);
        return spannableString;
    }

    public CharSequence N(ArrayList<d> arrayList) {
        switch (this.mType) {
            case 1:
                return aUr();
            case 2:
                return aUs();
            case 4:
                return M(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return aUu();
            case 18:
                return aUs();
            case 32:
                return J(arrayList);
            case 128:
                return K(arrayList);
            case 256:
                return aUt();
            case 1024:
                return aUv();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.dOx.aUF() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = nu(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.dOt = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.dOU = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.dOw = new TbRichTextEmotionInfo();
                    this.dOw.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.dOw.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.dOw.mGifInfo.mStaticUrl = pbContent._static;
                    this.dOw.mType = this.mType;
                    this.dOw.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.dOw.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.dOw.mGifInfo.mPackageName = pbContent.packet_name;
                    this.dOw.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.dOw.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.dOw.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
                            break;
                        }
                    }
                    this.dOw.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
                case 20:
                    this.dOA = new TbRichTextMemeInfo();
                    this.dOA.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.dip = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.dOz = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case 1280:
                    this.dOy = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.dOx = new i();
                        this.dOx.b(pbContent);
                        break;
                    }
                    this.dOU = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.aPN().vb(this.dOU.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.dOU.setText(str);
                            break;
                        } else {
                            this.dOU.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.dOU.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.dOU != null) {
                this.dOU.trim();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = nu(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.dOt = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.dip = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.dOU = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.dOw = new TbRichTextEmotionInfo();
                this.dOw.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.dOw.mGifInfo.mDynamicUrl = jSONObject.optString(PraiseUBCHelper.SOURCE_DYNAMIC);
                this.dOw.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.dOw.mType = this.mType;
                this.dOw.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.dOw.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.dOw.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.dOw.mGifInfo.mIcon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                String[] split = this.dOw.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.dOw.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
            } else {
                this.dOU = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int vb = TbFaceManager.aPN().vb(this.dOU.getText());
                    String optString = jSONObject.optString("c");
                    if (vb <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.dOU.setText(str);
                    } else {
                        this.dOU.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.dOU.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.dOU != null) {
                this.dOU.trim();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int nu(int i) {
        return e.nu(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wg(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tbadk.data.l lVar = new com.baidu.tbadk.data.l();
            lVar.mLink = str;
            lVar.type = 0;
            lVar.dvC = "1";
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, lVar));
        }
    }
}
