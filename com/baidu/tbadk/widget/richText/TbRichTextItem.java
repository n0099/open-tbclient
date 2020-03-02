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
    private TbRichTextMemeInfo dOB;
    private int mType = 0;
    private TbRichTextCommInfo dOV = null;
    private TbRichTextImageInfo dOu = null;
    private TbRichTextVoiceInfo diq = null;
    private TbRichTextEmotionInfo dOx = null;
    private i dOy = null;
    private TbRichTextLinkButtonInfo dOA = null;
    private TbRichTextLinkImageInfo dOz = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.dOV = tbRichTextCommInfo;
        this.dOu = tbRichTextImageInfo;
        this.diq = tbRichTextVoiceInfo;
        this.dOx = tbRichTextEmotionInfo;
        this.dOA = tbRichTextLinkButtonInfo;
        this.dOz = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo aUg() {
        if (this.mType == 1280) {
            return this.dOz;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo aUs() {
        if (this.mType == 1024) {
            return this.dOA;
        }
        return null;
    }

    public TbRichTextImageInfo aTY() {
        if (this.mType == 8) {
            return this.dOu;
        }
        return null;
    }

    public i aUc() {
        if (this.mType != 32) {
            return null;
        }
        return this.dOy;
    }

    public TbRichTextVoiceInfo aUa() {
        if (this.mType == 512 || this.mType == 768) {
            return this.diq;
        }
        return null;
    }

    public TbRichTextEmotionInfo aUd() {
        if (this.mType == 17) {
            return this.dOx;
        }
        return null;
    }

    public TbRichTextMemeInfo aUe() {
        if (this.mType == 20) {
            return this.dOB;
        }
        return null;
    }

    private SpannableString aUt() {
        if (this.mType != 1 || this.dOV == null) {
            return null;
        }
        return new SpannableString(this.dOV.getText());
    }

    private CharSequence J(ArrayList<d> arrayList) {
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.dOV != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(R.string.video_text));
            CharSequence L = L(arrayList);
            if (L != null) {
                spannableStringBuilder.append(L);
            }
            if (this.dOV.aTU() == 1) {
                a = a(this.mType, this.dOV.getText(), this.dOV.aTV(), 0);
            } else {
                a = a(this.mType, this.dOV.getText(), this.dOV.getText(), 0);
            }
            if (a != null) {
                spannableStringBuilder.append((CharSequence) a);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence K(ArrayList<d> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.dOV != null) {
            CharSequence L = L(arrayList);
            if (L != null) {
                spannableStringBuilder.append(L);
            }
            SpannableString a = a(this.mType, this.dOV.getLink(), this.dOV.getLink(), 0);
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
        if (this.mType != 32 || this.dOV == null) {
            return null;
        }
        if (this.dOV.aTU() == 1) {
            return this.dOV.aTV();
        }
        return this.dOV.getText();
    }

    private SpannableString aUu() {
        if ((this.mType != 2 && this.mType != 18) || this.dOV == null) {
            return null;
        }
        if (this.dOV.aTU() == 1) {
            return a(this.mType, this.dOV.getText(), this.dOV.aTV(), 0);
        }
        return a(this.mType, this.dOV.getText(), this.dOV.getLink(), this.dOV.aTW());
    }

    private SpannableString aUv() {
        if (this.mType != 256 || this.dOV == null) {
            return null;
        }
        String text = this.dOV.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(HanziToPinyin.Token.SEPARATOR)) {
            text = text + HanziToPinyin.Token.SEPARATOR;
        }
        SpannableString spannableString = new SpannableString(text);
        f fVar = new f(this.mType, text);
        fVar.wf(this.dOV.getLink());
        spannableString.setSpan(fVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString aUw() {
        if (this.mType != 16 || this.dOV == null) {
            return null;
        }
        return a(this.mType, this.dOV.getText(), this.dOV.getLink(), 0);
    }

    private SpannableString M(ArrayList<d> arrayList) {
        String text;
        int vb;
        String str;
        a.C0391a vu;
        if (this.mType != 4 || this.dOV == null || this.dOV.getText() == null || this.dOV.getLink() == null || (vb = TbFaceManager.aPP().vb((text = this.dOV.getText()))) == 0) {
            return null;
        }
        String vd = TbFaceManager.aPP().vd(text);
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
        if (TbFaceManager.aPP().vu(text) != null) {
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

    private SpannableString aUx() {
        if (this.mType != 1024 || this.dOA == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(Config.APP_VERSION_CODE);
        Drawable nx = g.nx(this.dOA.btn_type);
        nx.setBounds(0, 0, nx.getIntrinsicWidth(), nx.getIntrinsicHeight());
        com.baidu.tbadk.widget.c cVar = new com.baidu.tbadk.widget.c(nx);
        cVar.setVerticalOffset(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds4));
        spannableString.setSpan(cVar, 0, 1, 33);
        spannableString.setSpan(new f(1024, this.dOA.link), spannableString.length() - 1, Config.APP_VERSION_CODE.length(), 33);
        return spannableString;
    }

    public CharSequence N(ArrayList<d> arrayList) {
        switch (this.mType) {
            case 1:
                return aUt();
            case 2:
                return aUu();
            case 4:
                return M(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return aUw();
            case 18:
                return aUu();
            case 32:
                return J(arrayList);
            case 128:
                return K(arrayList);
            case 256:
                return aUv();
            case 1024:
                return aUx();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.dOy.aUH() != false) goto L9;
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
                    this.dOu = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.dOV = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.dOx = new TbRichTextEmotionInfo();
                    this.dOx.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.dOx.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.dOx.mGifInfo.mStaticUrl = pbContent._static;
                    this.dOx.mType = this.mType;
                    this.dOx.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.dOx.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.dOx.mGifInfo.mPackageName = pbContent.packet_name;
                    this.dOx.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.dOx.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.dOx.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
                            break;
                        }
                    }
                    this.dOx.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
                case 20:
                    this.dOB = new TbRichTextMemeInfo();
                    this.dOB.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.diq = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.dOA = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case 1280:
                    this.dOz = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.dOy = new i();
                        this.dOy.b(pbContent);
                        break;
                    }
                    this.dOV = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.aPP().vb(this.dOV.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.dOV.setText(str);
                            break;
                        } else {
                            this.dOV.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.dOV.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.dOV != null) {
                this.dOV.trim();
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
                this.dOu = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.diq = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.dOV = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.dOx = new TbRichTextEmotionInfo();
                this.dOx.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.dOx.mGifInfo.mDynamicUrl = jSONObject.optString(PraiseUBCHelper.SOURCE_DYNAMIC);
                this.dOx.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.dOx.mType = this.mType;
                this.dOx.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.dOx.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.dOx.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.dOx.mGifInfo.mIcon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                String[] split = this.dOx.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.dOx.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
            } else {
                this.dOV = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int vb = TbFaceManager.aPP().vb(this.dOV.getText());
                    String optString = jSONObject.optString("c");
                    if (vb <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.dOV.setText(str);
                    } else {
                        this.dOV.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.dOV.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.dOV != null) {
                this.dOV.trim();
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
            lVar.dvD = "1";
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, lVar));
        }
    }
}
