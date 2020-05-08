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
import com.baidu.tbadk.data.j;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.R;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextItem extends OrmObject {
    private TbRichTextMemeInfo epe;
    private int mType = 0;
    private TbRichTextCommInfo epy = null;
    private TbRichTextImageInfo eoX = null;
    private TbRichTextVoiceInfo dIP = null;
    private TbRichTextEmotionInfo epa = null;
    private i epb = null;
    private TbRichTextLinkButtonInfo epd = null;
    private TbRichTextLinkImageInfo epc = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.epy = tbRichTextCommInfo;
        this.eoX = tbRichTextImageInfo;
        this.dIP = tbRichTextVoiceInfo;
        this.epa = tbRichTextEmotionInfo;
        this.epd = tbRichTextLinkButtonInfo;
        this.epc = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo bct() {
        if (this.mType == 1280) {
            return this.epc;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo bcF() {
        if (this.mType == 1024) {
            return this.epd;
        }
        return null;
    }

    public TbRichTextImageInfo bcl() {
        if (this.mType == 8) {
            return this.eoX;
        }
        return null;
    }

    public i bcp() {
        if (this.mType != 32) {
            return null;
        }
        return this.epb;
    }

    public TbRichTextVoiceInfo bcn() {
        if (this.mType == 512 || this.mType == 768) {
            return this.dIP;
        }
        return null;
    }

    public TbRichTextEmotionInfo bcq() {
        if (this.mType == 17) {
            return this.epa;
        }
        return null;
    }

    public TbRichTextMemeInfo bcr() {
        if (this.mType == 20) {
            return this.epe;
        }
        return null;
    }

    private SpannableString bcG() {
        if (this.mType != 1 || this.epy == null) {
            return null;
        }
        return new SpannableString(this.epy.getText());
    }

    private CharSequence J(ArrayList<d> arrayList) {
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.epy != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(R.string.video_text));
            CharSequence L = L(arrayList);
            if (L != null) {
                spannableStringBuilder.append(L);
            }
            if (this.epy.bch() == 1) {
                a = a(this.mType, this.epy.getText(), this.epy.bci(), 0);
            } else {
                a = a(this.mType, this.epy.getText(), this.epy.getText(), 0);
            }
            if (a != null) {
                spannableStringBuilder.append((CharSequence) a);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence K(ArrayList<d> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.epy != null) {
            CharSequence L = L(arrayList);
            if (L != null) {
                spannableStringBuilder.append(L);
            }
            SpannableString a = a(this.mType, this.epy.getLink(), this.epy.getLink(), 0);
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
        if (this.mType != 32 || this.epy == null) {
            return null;
        }
        if (this.epy.bch() == 1) {
            return this.epy.bci();
        }
        return this.epy.getText();
    }

    private SpannableString bcH() {
        if ((this.mType != 2 && this.mType != 18) || this.epy == null) {
            return null;
        }
        if (this.epy.bch() == 1) {
            return a(this.mType, this.epy.getText(), this.epy.bci(), 0);
        }
        return a(this.mType, this.epy.getText(), this.epy.getLink(), this.epy.bcj());
    }

    private SpannableString bcI() {
        if (this.mType != 256 || this.epy == null) {
            return null;
        }
        String text = this.epy.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = text + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        f fVar = new f(this.mType, text);
        fVar.xw(this.epy.getLink());
        spannableString.setSpan(fVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString bcJ() {
        if (this.mType != 16 || this.epy == null) {
            return null;
        }
        return a(this.mType, this.epy.getText(), this.epy.getLink(), 0);
    }

    private SpannableString M(ArrayList<d> arrayList) {
        String text;
        int ws;
        String str;
        a.C0443a wM;
        if (this.mType != 4 || this.epy == null || this.epy.getText() == null || this.epy.getLink() == null || (ws = TbFaceManager.aYj().ws((text = this.epy.getText()))) == 0) {
            return null;
        }
        String wu = TbFaceManager.aYj().wu(text);
        if (!TextUtils.isEmpty(text) && text.startsWith("shoubai_emoji_")) {
            str = "[" + wu + "]";
        } else {
            str = "#(" + wu + ")";
        }
        SpannableString spannableString = new SpannableString(str + " ");
        d dVar = new d(TbadkCoreApplication.getInst().getContext(), ws);
        if (arrayList != null) {
            arrayList.add(dVar);
        }
        if (TbFaceManager.aYj().wM(text) != null) {
            int width = (int) (wM.getWidth() * 0.5d);
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
                    TbRichTextItem.this.xx(str2);
                }
            };
        } else {
            fVar = new f(i, str2);
        }
        fVar.nK(i2);
        if (i2 == 1) {
            fVar.setTextColor(R.color.cp_cont_d);
        } else {
            fVar.setTextColor(-1);
        }
        spannableString.setSpan(fVar, 0, str.length() - 1, 33);
        return spannableString;
    }

    private SpannableString bcK() {
        if (this.mType != 1024 || this.epd == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(Config.APP_VERSION_CODE);
        Drawable nL = g.nL(this.epd.btn_type);
        nL.setBounds(0, 0, nL.getIntrinsicWidth(), nL.getIntrinsicHeight());
        com.baidu.tbadk.widget.d dVar = new com.baidu.tbadk.widget.d(nL);
        dVar.setVerticalOffset(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds4));
        spannableString.setSpan(dVar, 0, 1, 33);
        spannableString.setSpan(new f(1024, this.epd.link), spannableString.length() - 1, Config.APP_VERSION_CODE.length(), 33);
        return spannableString;
    }

    public CharSequence N(ArrayList<d> arrayList) {
        switch (this.mType) {
            case 1:
                return bcG();
            case 2:
                return bcH();
            case 4:
                return M(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return bcJ();
            case 18:
                return bcH();
            case 32:
                return J(arrayList);
            case 128:
                return K(arrayList);
            case 256:
                return bcI();
            case 1024:
                return bcK();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.epb.bcU() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = nI(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.eoX = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.epy = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.epa = new TbRichTextEmotionInfo();
                    this.epa.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.epa.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.epa.mGifInfo.mStaticUrl = pbContent._static;
                    this.epa.mType = this.mType;
                    this.epa.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.epa.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.epa.mGifInfo.mPackageName = pbContent.packet_name;
                    this.epa.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.epa.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.epa.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
                            break;
                        }
                    }
                    this.epa.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
                case 20:
                    this.epe = new TbRichTextMemeInfo();
                    this.epe.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.dIP = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.epd = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case 1280:
                    this.epc = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.epb = new i();
                        this.epb.b(pbContent);
                        break;
                    }
                    this.epy = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.aYj().ws(this.epy.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.epy.setText(str);
                            break;
                        } else {
                            this.epy.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.epy.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.epy != null) {
                this.epy.trim();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = nI(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.eoX = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.dIP = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.epy = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.epa = new TbRichTextEmotionInfo();
                this.epa.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.epa.mGifInfo.mDynamicUrl = jSONObject.optString(PraiseUBCHelper.SOURCE_DYNAMIC);
                this.epa.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.epa.mType = this.mType;
                this.epa.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.epa.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.epa.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.epa.mGifInfo.mIcon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                String[] split = this.epa.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.epa.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
            } else {
                this.epy = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int ws = TbFaceManager.aYj().ws(this.epy.getText());
                    String optString = jSONObject.optString("c");
                    if (ws <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.epy.setText(str);
                    } else {
                        this.epy.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.epy.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.epy != null) {
                this.epy.trim();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int nI(int i) {
        return e.nI(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xx(String str) {
        if (!TextUtils.isEmpty(str)) {
            j jVar = new j();
            jVar.mLink = str;
            jVar.type = 0;
            jVar.dVP = "1";
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, jVar));
        }
    }
}
