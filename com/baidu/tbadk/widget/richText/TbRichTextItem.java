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
    private TbRichTextMemeInfo eDF;
    private int mType = 0;
    private TbRichTextCommInfo eDZ = null;
    private TbRichTextImageInfo eDy = null;
    private TbRichTextVoiceInfo dXe = null;
    private TbRichTextEmotionInfo eDB = null;
    private i eDC = null;
    private TbRichTextLinkButtonInfo eDE = null;
    private TbRichTextLinkImageInfo eDD = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.eDZ = tbRichTextCommInfo;
        this.eDy = tbRichTextImageInfo;
        this.dXe = tbRichTextVoiceInfo;
        this.eDB = tbRichTextEmotionInfo;
        this.eDE = tbRichTextLinkButtonInfo;
        this.eDD = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo biE() {
        if (this.mType == 1280) {
            return this.eDD;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo biQ() {
        if (this.mType == 1024) {
            return this.eDE;
        }
        return null;
    }

    public TbRichTextImageInfo biw() {
        if (this.mType == 8) {
            return this.eDy;
        }
        return null;
    }

    public i biA() {
        if (this.mType != 32) {
            return null;
        }
        return this.eDC;
    }

    public TbRichTextVoiceInfo biy() {
        if (this.mType == 512 || this.mType == 768) {
            return this.dXe;
        }
        return null;
    }

    public TbRichTextEmotionInfo biB() {
        if (this.mType == 17) {
            return this.eDB;
        }
        return null;
    }

    public TbRichTextMemeInfo biC() {
        if (this.mType == 20) {
            return this.eDF;
        }
        return null;
    }

    private SpannableString biR() {
        if (this.mType != 1 || this.eDZ == null) {
            return null;
        }
        return new SpannableString(this.eDZ.getText());
    }

    private CharSequence J(ArrayList<d> arrayList) {
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.eDZ != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(R.string.video_text));
            CharSequence L = L(arrayList);
            if (L != null) {
                spannableStringBuilder.append(L);
            }
            if (this.eDZ.bis() == 1) {
                a = a(this.mType, this.eDZ.getText(), this.eDZ.bit(), 0);
            } else {
                a = a(this.mType, this.eDZ.getText(), this.eDZ.getText(), 0);
            }
            if (a != null) {
                spannableStringBuilder.append((CharSequence) a);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence K(ArrayList<d> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.eDZ != null) {
            CharSequence L = L(arrayList);
            if (L != null) {
                spannableStringBuilder.append(L);
            }
            SpannableString a = a(this.mType, this.eDZ.getLink(), this.eDZ.getLink(), 0);
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
        if (this.mType != 32 || this.eDZ == null) {
            return null;
        }
        if (this.eDZ.bis() == 1) {
            return this.eDZ.bit();
        }
        return this.eDZ.getText();
    }

    private SpannableString biS() {
        if ((this.mType != 2 && this.mType != 18) || this.eDZ == null) {
            return null;
        }
        if (this.eDZ.bis() == 1) {
            return a(this.mType, this.eDZ.getText(), this.eDZ.bit(), 0);
        }
        return a(this.mType, this.eDZ.getText(), this.eDZ.getLink(), this.eDZ.biu());
    }

    private SpannableString biT() {
        if (this.mType != 256 || this.eDZ == null) {
            return null;
        }
        String text = this.eDZ.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = text + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        f fVar = new f(this.mType, text);
        fVar.zc(this.eDZ.getLink());
        spannableString.setSpan(fVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString biU() {
        if (this.mType != 16 || this.eDZ == null) {
            return null;
        }
        return a(this.mType, this.eDZ.getText(), this.eDZ.getLink(), 0);
    }

    private SpannableString M(ArrayList<d> arrayList) {
        String text;
        int xY;
        String str;
        a.C0490a ys;
        if (this.mType != 4 || this.eDZ == null || this.eDZ.getText() == null || this.eDZ.getLink() == null || (xY = TbFaceManager.bes().xY((text = this.eDZ.getText()))) == 0) {
            return null;
        }
        String ya = TbFaceManager.bes().ya(text);
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
        if (TbFaceManager.bes().ys(text) != null) {
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
        fVar.op(i2);
        if (i2 == 1) {
            fVar.setTextColor(R.color.cp_cont_d);
        } else {
            fVar.setTextColor(-1);
        }
        spannableString.setSpan(fVar, 0, str.length() - 1, 33);
        return spannableString;
    }

    private SpannableString biV() {
        if (this.mType != 1024 || this.eDE == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(Config.APP_VERSION_CODE);
        Drawable oq = g.oq(this.eDE.btn_type);
        oq.setBounds(0, 0, oq.getIntrinsicWidth(), oq.getIntrinsicHeight());
        com.baidu.tbadk.widget.d dVar = new com.baidu.tbadk.widget.d(oq);
        dVar.setVerticalOffset(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds4));
        spannableString.setSpan(dVar, 0, 1, 33);
        spannableString.setSpan(new f(1024, this.eDE.link), spannableString.length() - 1, Config.APP_VERSION_CODE.length(), 33);
        return spannableString;
    }

    public CharSequence N(ArrayList<d> arrayList) {
        switch (this.mType) {
            case 1:
                return biR();
            case 2:
                return biS();
            case 4:
                return M(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return biU();
            case 18:
                return biS();
            case 32:
                return J(arrayList);
            case 128:
                return K(arrayList);
            case 256:
                return biT();
            case 1024:
                return biV();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.eDC.bjf() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = om(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.eDy = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.eDZ = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.eDB = new TbRichTextEmotionInfo();
                    this.eDB.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.eDB.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.eDB.mGifInfo.mStaticUrl = pbContent._static;
                    this.eDB.mType = this.mType;
                    this.eDB.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.eDB.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.eDB.mGifInfo.mPackageName = pbContent.packet_name;
                    this.eDB.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.eDB.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.eDB.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
                            break;
                        }
                    }
                    this.eDB.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
                case 20:
                    this.eDF = new TbRichTextMemeInfo();
                    this.eDF.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.dXe = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.eDE = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case 1280:
                    this.eDD = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.eDC = new i();
                        this.eDC.b(pbContent);
                        break;
                    }
                    this.eDZ = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.bes().xY(this.eDZ.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.eDZ.setText(str);
                            break;
                        } else {
                            this.eDZ.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.eDZ.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.eDZ != null) {
                this.eDZ.trim();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = om(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.eDy = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.dXe = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.eDZ = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.eDB = new TbRichTextEmotionInfo();
                this.eDB.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.eDB.mGifInfo.mDynamicUrl = jSONObject.optString(PraiseUBCHelper.SOURCE_DYNAMIC);
                this.eDB.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.eDB.mType = this.mType;
                this.eDB.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.eDB.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.eDB.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.eDB.mGifInfo.mIcon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                String[] split = this.eDB.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.eDB.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
            } else {
                this.eDZ = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int xY = TbFaceManager.bes().xY(this.eDZ.getText());
                    String optString = jSONObject.optString("c");
                    if (xY <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.eDZ.setText(str);
                    } else {
                        this.eDZ.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.eDZ.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.eDZ != null) {
                this.eDZ.trim();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int om(int i) {
        return e.om(i);
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
