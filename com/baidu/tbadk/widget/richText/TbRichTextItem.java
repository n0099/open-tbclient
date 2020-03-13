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
    private TbRichTextMemeInfo dOO;
    private int mType = 0;
    private TbRichTextCommInfo dPi = null;
    private TbRichTextImageInfo dOH = null;
    private TbRichTextVoiceInfo diF = null;
    private TbRichTextEmotionInfo dOK = null;
    private i dOL = null;
    private TbRichTextLinkButtonInfo dON = null;
    private TbRichTextLinkImageInfo dOM = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.dPi = tbRichTextCommInfo;
        this.dOH = tbRichTextImageInfo;
        this.diF = tbRichTextVoiceInfo;
        this.dOK = tbRichTextEmotionInfo;
        this.dON = tbRichTextLinkButtonInfo;
        this.dOM = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo aUh() {
        if (this.mType == 1280) {
            return this.dOM;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo aUt() {
        if (this.mType == 1024) {
            return this.dON;
        }
        return null;
    }

    public TbRichTextImageInfo aTZ() {
        if (this.mType == 8) {
            return this.dOH;
        }
        return null;
    }

    public i aUd() {
        if (this.mType != 32) {
            return null;
        }
        return this.dOL;
    }

    public TbRichTextVoiceInfo aUb() {
        if (this.mType == 512 || this.mType == 768) {
            return this.diF;
        }
        return null;
    }

    public TbRichTextEmotionInfo aUe() {
        if (this.mType == 17) {
            return this.dOK;
        }
        return null;
    }

    public TbRichTextMemeInfo aUf() {
        if (this.mType == 20) {
            return this.dOO;
        }
        return null;
    }

    private SpannableString aUu() {
        if (this.mType != 1 || this.dPi == null) {
            return null;
        }
        return new SpannableString(this.dPi.getText());
    }

    private CharSequence J(ArrayList<d> arrayList) {
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.dPi != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(R.string.video_text));
            CharSequence L = L(arrayList);
            if (L != null) {
                spannableStringBuilder.append(L);
            }
            if (this.dPi.aTV() == 1) {
                a = a(this.mType, this.dPi.getText(), this.dPi.aTW(), 0);
            } else {
                a = a(this.mType, this.dPi.getText(), this.dPi.getText(), 0);
            }
            if (a != null) {
                spannableStringBuilder.append((CharSequence) a);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence K(ArrayList<d> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.dPi != null) {
            CharSequence L = L(arrayList);
            if (L != null) {
                spannableStringBuilder.append(L);
            }
            SpannableString a = a(this.mType, this.dPi.getLink(), this.dPi.getLink(), 0);
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
        if (this.mType != 32 || this.dPi == null) {
            return null;
        }
        if (this.dPi.aTV() == 1) {
            return this.dPi.aTW();
        }
        return this.dPi.getText();
    }

    private SpannableString aUv() {
        if ((this.mType != 2 && this.mType != 18) || this.dPi == null) {
            return null;
        }
        if (this.dPi.aTV() == 1) {
            return a(this.mType, this.dPi.getText(), this.dPi.aTW(), 0);
        }
        return a(this.mType, this.dPi.getText(), this.dPi.getLink(), this.dPi.aTX());
    }

    private SpannableString aUw() {
        if (this.mType != 256 || this.dPi == null) {
            return null;
        }
        String text = this.dPi.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(HanziToPinyin.Token.SEPARATOR)) {
            text = text + HanziToPinyin.Token.SEPARATOR;
        }
        SpannableString spannableString = new SpannableString(text);
        f fVar = new f(this.mType, text);
        fVar.wg(this.dPi.getLink());
        spannableString.setSpan(fVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString aUx() {
        if (this.mType != 16 || this.dPi == null) {
            return null;
        }
        return a(this.mType, this.dPi.getText(), this.dPi.getLink(), 0);
    }

    private SpannableString M(ArrayList<d> arrayList) {
        String text;
        int vc;
        String str;
        a.C0391a vv;
        if (this.mType != 4 || this.dPi == null || this.dPi.getText() == null || this.dPi.getLink() == null || (vc = TbFaceManager.aPQ().vc((text = this.dPi.getText()))) == 0) {
            return null;
        }
        String ve = TbFaceManager.aPQ().ve(text);
        if (!TextUtils.isEmpty(text) && text.startsWith("shoubai_emoji_")) {
            str = "[" + ve + "]";
        } else {
            str = "#(" + ve + ")";
        }
        SpannableString spannableString = new SpannableString(str + HanziToPinyin.Token.SEPARATOR);
        d dVar = new d(TbadkCoreApplication.getInst().getContext(), vc);
        if (arrayList != null) {
            arrayList.add(dVar);
        }
        if (TbFaceManager.aPQ().vv(text) != null) {
            int width = (int) (vv.getWidth() * 0.5d);
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
        fVar.nw(i2);
        if (i2 == 1) {
            fVar.setTextColor(R.color.cp_cont_d);
        } else {
            fVar.setTextColor(-1);
        }
        spannableString.setSpan(fVar, 0, str.length() - 1, 33);
        return spannableString;
    }

    private SpannableString aUy() {
        if (this.mType != 1024 || this.dON == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(Config.APP_VERSION_CODE);
        Drawable nx = g.nx(this.dON.btn_type);
        nx.setBounds(0, 0, nx.getIntrinsicWidth(), nx.getIntrinsicHeight());
        com.baidu.tbadk.widget.c cVar = new com.baidu.tbadk.widget.c(nx);
        cVar.setVerticalOffset(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds4));
        spannableString.setSpan(cVar, 0, 1, 33);
        spannableString.setSpan(new f(1024, this.dON.link), spannableString.length() - 1, Config.APP_VERSION_CODE.length(), 33);
        return spannableString;
    }

    public CharSequence N(ArrayList<d> arrayList) {
        switch (this.mType) {
            case 1:
                return aUu();
            case 2:
                return aUv();
            case 4:
                return M(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return aUx();
            case 18:
                return aUv();
            case 32:
                return J(arrayList);
            case 128:
                return K(arrayList);
            case 256:
                return aUw();
            case 1024:
                return aUy();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.dOL.aUI() != false) goto L9;
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
                    this.dOH = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.dPi = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.dOK = new TbRichTextEmotionInfo();
                    this.dOK.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.dOK.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.dOK.mGifInfo.mStaticUrl = pbContent._static;
                    this.dOK.mType = this.mType;
                    this.dOK.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.dOK.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.dOK.mGifInfo.mPackageName = pbContent.packet_name;
                    this.dOK.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.dOK.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.dOK.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
                            break;
                        }
                    }
                    this.dOK.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
                case 20:
                    this.dOO = new TbRichTextMemeInfo();
                    this.dOO.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.diF = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.dON = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case 1280:
                    this.dOM = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.dOL = new i();
                        this.dOL.b(pbContent);
                        break;
                    }
                    this.dPi = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.aPQ().vc(this.dPi.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.dPi.setText(str);
                            break;
                        } else {
                            this.dPi.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.dPi.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.dPi != null) {
                this.dPi.trim();
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
                this.dOH = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.diF = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.dPi = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.dOK = new TbRichTextEmotionInfo();
                this.dOK.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.dOK.mGifInfo.mDynamicUrl = jSONObject.optString(PraiseUBCHelper.SOURCE_DYNAMIC);
                this.dOK.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.dOK.mType = this.mType;
                this.dOK.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.dOK.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.dOK.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.dOK.mGifInfo.mIcon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                String[] split = this.dOK.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.dOK.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
            } else {
                this.dPi = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int vc = TbFaceManager.aPQ().vc(this.dPi.getText());
                    String optString = jSONObject.optString("c");
                    if (vc <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.dPi.setText(str);
                    } else {
                        this.dPi.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.dPi.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.dPi != null) {
                this.dPi.trim();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int nu(int i) {
        return e.nu(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wh(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tbadk.data.l lVar = new com.baidu.tbadk.data.l();
            lVar.mLink = str;
            lVar.type = 0;
            lVar.dvQ = "1";
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, lVar));
        }
    }
}
