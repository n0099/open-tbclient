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
import com.baidu.mobstat.Config;
import com.baidu.searchbox.ui.animview.util.PraiseUBCHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.k;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.R;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextItem extends OrmObject {
    private TbRichTextMemeInfo eDQ;
    private int mType = 0;
    private TbRichTextCommInfo eEk = null;
    private TbRichTextImageInfo eDJ = null;
    private TbRichTextVoiceInfo dXe = null;
    private TbRichTextEmotionInfo eDM = null;
    private i eDN = null;
    private TbRichTextLinkButtonInfo eDP = null;
    private TbRichTextLinkImageInfo eDO = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.eEk = tbRichTextCommInfo;
        this.eDJ = tbRichTextImageInfo;
        this.dXe = tbRichTextVoiceInfo;
        this.eDM = tbRichTextEmotionInfo;
        this.eDP = tbRichTextLinkButtonInfo;
        this.eDO = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo biG() {
        if (this.mType == 1280) {
            return this.eDO;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo biS() {
        if (this.mType == 1024) {
            return this.eDP;
        }
        return null;
    }

    public TbRichTextImageInfo biy() {
        if (this.mType == 8) {
            return this.eDJ;
        }
        return null;
    }

    public i biC() {
        if (this.mType != 32) {
            return null;
        }
        return this.eDN;
    }

    public TbRichTextVoiceInfo biA() {
        if (this.mType == 512 || this.mType == 768) {
            return this.dXe;
        }
        return null;
    }

    public TbRichTextEmotionInfo biD() {
        if (this.mType == 17) {
            return this.eDM;
        }
        return null;
    }

    public TbRichTextMemeInfo biE() {
        if (this.mType == 20) {
            return this.eDQ;
        }
        return null;
    }

    private SpannableString biT() {
        if (this.mType != 1 || this.eEk == null) {
            return null;
        }
        return new SpannableString(this.eEk.getText());
    }

    private CharSequence J(ArrayList<d> arrayList) {
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.eEk != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(R.string.video_text));
            CharSequence L = L(arrayList);
            if (L != null) {
                spannableStringBuilder.append(L);
            }
            if (this.eEk.biu() == 1) {
                a = a(this.mType, this.eEk.getText(), this.eEk.biv(), 0);
            } else {
                a = a(this.mType, this.eEk.getText(), this.eEk.getText(), 0);
            }
            if (a != null) {
                spannableStringBuilder.append((CharSequence) a);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence K(ArrayList<d> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.eEk != null) {
            CharSequence L = L(arrayList);
            if (L != null) {
                spannableStringBuilder.append(L);
            }
            SpannableString a = a(this.mType, this.eEk.getLink(), this.eEk.getLink(), 0);
            if (a != null) {
                spannableStringBuilder.append((CharSequence) a);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence L(ArrayList<d> arrayList) {
        TbRichTextItem tbRichTextItem = new TbRichTextItem();
        tbRichTextItem.a(4, new TbRichTextCommInfo("video_icon", " "), null, null, null, null, null);
        return tbRichTextItem.N(arrayList);
    }

    public String getVideoUrl() {
        if (this.mType != 32 || this.eEk == null) {
            return null;
        }
        if (this.eEk.biu() == 1) {
            return this.eEk.biv();
        }
        return this.eEk.getText();
    }

    private SpannableString biU() {
        if ((this.mType != 2 && this.mType != 18) || this.eEk == null) {
            return null;
        }
        if (this.eEk.biu() == 1) {
            return a(this.mType, this.eEk.getText(), this.eEk.biv(), 0);
        }
        return a(this.mType, this.eEk.getText(), this.eEk.getLink(), this.eEk.biw());
    }

    private SpannableString biV() {
        if (this.mType != 256 || this.eEk == null) {
            return null;
        }
        String text = this.eEk.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = text + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        f fVar = new f(this.mType, text);
        fVar.zc(this.eEk.getLink());
        spannableString.setSpan(fVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString biW() {
        if (this.mType != 16 || this.eEk == null) {
            return null;
        }
        return a(this.mType, this.eEk.getText(), this.eEk.getLink(), 0);
    }

    private SpannableString M(ArrayList<d> arrayList) {
        String text;
        int xY;
        String str;
        a.C0490a ys;
        if (this.mType != 4 || this.eEk == null || this.eEk.getText() == null || this.eEk.getLink() == null || (xY = TbFaceManager.bet().xY((text = this.eEk.getText()))) == 0) {
            return null;
        }
        String ya = TbFaceManager.bet().ya(text);
        if (!TextUtils.isEmpty(text) && text.startsWith("shoubai_emoji_")) {
            str = "[" + ya + "]";
        } else {
            str = "#(" + ya + ")";
        }
        SpannableString spannableString = new SpannableString(str + " ");
        d dVar = new d(TbadkCoreApplication.getInst().getContext(), xY);
        if (arrayList != null) {
            arrayList.add(dVar);
        }
        if (TbFaceManager.bet().ys(text) != null) {
            int width = (int) (ys.getWidth() * 0.5d);
            dVar.setBounds(new Rect(0, 0, width, width));
        } else {
            dVar.setBounds(new Rect(0, 0, 0, 0));
        }
        spannableString.setSpan(new com.baidu.tbadk.widget.b(dVar, 1), 0, str.length(), 33);
        return spannableString;
    }

    private SpannableString a(int i, String str, final String str2, int i2) {
        f fVar;
        if (str == null) {
            return null;
        }
        if (!str.endsWith(" ")) {
            str = str + " ";
        }
        SpannableString spannableString = new SpannableString(str);
        if (this.mType == 18) {
            fVar = new f(i, str2) { // from class: com.baidu.tbadk.widget.richText.TbRichTextItem.1
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    view.setTag(R.id.tag_subpb_ban_display_keyboard, true);
                    TbRichTextItem.this.zd(str2);
                }
            };
        } else {
            fVar = new f(i, str2);
        }
        fVar.or(i2);
        if (i2 == 1) {
            fVar.setTextColor(R.color.cp_cont_d);
        } else {
            fVar.setTextColor(-1);
        }
        spannableString.setSpan(fVar, 0, str.length() - 1, 33);
        return spannableString;
    }

    private SpannableString biX() {
        if (this.mType != 1024 || this.eDP == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(Config.APP_VERSION_CODE);
        Drawable os = g.os(this.eDP.btn_type);
        os.setBounds(0, 0, os.getIntrinsicWidth(), os.getIntrinsicHeight());
        com.baidu.tbadk.widget.d dVar = new com.baidu.tbadk.widget.d(os);
        dVar.setVerticalOffset(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds4));
        spannableString.setSpan(dVar, 0, 1, 33);
        spannableString.setSpan(new f(1024, this.eDP.link), spannableString.length() - 1, Config.APP_VERSION_CODE.length(), 33);
        return spannableString;
    }

    public CharSequence N(ArrayList<d> arrayList) {
        switch (this.mType) {
            case 1:
                return biT();
            case 2:
                return biU();
            case 4:
                return M(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return biW();
            case 18:
                return biU();
            case 32:
                return J(arrayList);
            case 128:
                return K(arrayList);
            case 256:
                return biV();
            case 1024:
                return biX();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.eDN.bjh() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = oo(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.eDJ = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.eEk = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.eDM = new TbRichTextEmotionInfo();
                    this.eDM.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.eDM.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.eDM.mGifInfo.mStaticUrl = pbContent._static;
                    this.eDM.mType = this.mType;
                    this.eDM.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.eDM.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.eDM.mGifInfo.mPackageName = pbContent.packet_name;
                    this.eDM.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.eDM.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.eDM.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
                            break;
                        }
                    }
                    this.eDM.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
                case 20:
                    this.eDQ = new TbRichTextMemeInfo();
                    this.eDQ.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.dXe = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.eDP = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case 1280:
                    this.eDO = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.eDN = new i();
                        this.eDN.b(pbContent);
                        break;
                    }
                    this.eEk = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.bet().xY(this.eEk.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.eEk.setText(str);
                            break;
                        } else {
                            this.eEk.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.eEk.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.eEk != null) {
                this.eEk.trim();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = oo(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.eDJ = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.dXe = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.eEk = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.eDM = new TbRichTextEmotionInfo();
                this.eDM.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.eDM.mGifInfo.mDynamicUrl = jSONObject.optString(PraiseUBCHelper.SOURCE_DYNAMIC);
                this.eDM.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.eDM.mType = this.mType;
                this.eDM.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.eDM.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.eDM.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.eDM.mGifInfo.mIcon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                String[] split = this.eDM.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.eDM.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
            } else {
                this.eEk = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int xY = TbFaceManager.bet().xY(this.eEk.getText());
                    String optString = jSONObject.optString("c");
                    if (xY <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.eEk.setText(str);
                    } else {
                        this.eEk.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.eEk.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.eEk != null) {
                this.eEk.trim();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int oo(int i) {
        return e.oo(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zd(String str) {
        if (!TextUtils.isEmpty(str)) {
            k kVar = new k();
            kVar.mLink = str;
            kVar.type = 0;
            kVar.ejY = "1";
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, kVar));
        }
    }
}
