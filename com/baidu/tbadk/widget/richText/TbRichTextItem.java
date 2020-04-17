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
    private TbRichTextMemeInfo eoZ;
    private int mType = 0;
    private TbRichTextCommInfo ept = null;
    private TbRichTextImageInfo eoS = null;
    private TbRichTextVoiceInfo dIL = null;
    private TbRichTextEmotionInfo eoV = null;
    private i eoW = null;
    private TbRichTextLinkButtonInfo eoY = null;
    private TbRichTextLinkImageInfo eoX = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.ept = tbRichTextCommInfo;
        this.eoS = tbRichTextImageInfo;
        this.dIL = tbRichTextVoiceInfo;
        this.eoV = tbRichTextEmotionInfo;
        this.eoY = tbRichTextLinkButtonInfo;
        this.eoX = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo bcv() {
        if (this.mType == 1280) {
            return this.eoX;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo bcH() {
        if (this.mType == 1024) {
            return this.eoY;
        }
        return null;
    }

    public TbRichTextImageInfo bcn() {
        if (this.mType == 8) {
            return this.eoS;
        }
        return null;
    }

    public i bcr() {
        if (this.mType != 32) {
            return null;
        }
        return this.eoW;
    }

    public TbRichTextVoiceInfo bcp() {
        if (this.mType == 512 || this.mType == 768) {
            return this.dIL;
        }
        return null;
    }

    public TbRichTextEmotionInfo bcs() {
        if (this.mType == 17) {
            return this.eoV;
        }
        return null;
    }

    public TbRichTextMemeInfo bct() {
        if (this.mType == 20) {
            return this.eoZ;
        }
        return null;
    }

    private SpannableString bcI() {
        if (this.mType != 1 || this.ept == null) {
            return null;
        }
        return new SpannableString(this.ept.getText());
    }

    private CharSequence J(ArrayList<d> arrayList) {
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.ept != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(R.string.video_text));
            CharSequence L = L(arrayList);
            if (L != null) {
                spannableStringBuilder.append(L);
            }
            if (this.ept.bcj() == 1) {
                a = a(this.mType, this.ept.getText(), this.ept.bck(), 0);
            } else {
                a = a(this.mType, this.ept.getText(), this.ept.getText(), 0);
            }
            if (a != null) {
                spannableStringBuilder.append((CharSequence) a);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence K(ArrayList<d> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.ept != null) {
            CharSequence L = L(arrayList);
            if (L != null) {
                spannableStringBuilder.append(L);
            }
            SpannableString a = a(this.mType, this.ept.getLink(), this.ept.getLink(), 0);
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
        if (this.mType != 32 || this.ept == null) {
            return null;
        }
        if (this.ept.bcj() == 1) {
            return this.ept.bck();
        }
        return this.ept.getText();
    }

    private SpannableString bcJ() {
        if ((this.mType != 2 && this.mType != 18) || this.ept == null) {
            return null;
        }
        if (this.ept.bcj() == 1) {
            return a(this.mType, this.ept.getText(), this.ept.bck(), 0);
        }
        return a(this.mType, this.ept.getText(), this.ept.getLink(), this.ept.bcl());
    }

    private SpannableString bcK() {
        if (this.mType != 256 || this.ept == null) {
            return null;
        }
        String text = this.ept.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = text + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        f fVar = new f(this.mType, text);
        fVar.xt(this.ept.getLink());
        spannableString.setSpan(fVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString bcL() {
        if (this.mType != 16 || this.ept == null) {
            return null;
        }
        return a(this.mType, this.ept.getText(), this.ept.getLink(), 0);
    }

    private SpannableString M(ArrayList<d> arrayList) {
        String text;
        int wp;
        String str;
        a.C0422a wJ;
        if (this.mType != 4 || this.ept == null || this.ept.getText() == null || this.ept.getLink() == null || (wp = TbFaceManager.aYl().wp((text = this.ept.getText()))) == 0) {
            return null;
        }
        String wr = TbFaceManager.aYl().wr(text);
        if (!TextUtils.isEmpty(text) && text.startsWith("shoubai_emoji_")) {
            str = "[" + wr + "]";
        } else {
            str = "#(" + wr + ")";
        }
        SpannableString spannableString = new SpannableString(str + " ");
        d dVar = new d(TbadkCoreApplication.getInst().getContext(), wp);
        if (arrayList != null) {
            arrayList.add(dVar);
        }
        if (TbFaceManager.aYl().wJ(text) != null) {
            int width = (int) (wJ.getWidth() * 0.5d);
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
                    TbRichTextItem.this.xu(str2);
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

    private SpannableString bcM() {
        if (this.mType != 1024 || this.eoY == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(Config.APP_VERSION_CODE);
        Drawable nL = g.nL(this.eoY.btn_type);
        nL.setBounds(0, 0, nL.getIntrinsicWidth(), nL.getIntrinsicHeight());
        com.baidu.tbadk.widget.d dVar = new com.baidu.tbadk.widget.d(nL);
        dVar.setVerticalOffset(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds4));
        spannableString.setSpan(dVar, 0, 1, 33);
        spannableString.setSpan(new f(1024, this.eoY.link), spannableString.length() - 1, Config.APP_VERSION_CODE.length(), 33);
        return spannableString;
    }

    public CharSequence N(ArrayList<d> arrayList) {
        switch (this.mType) {
            case 1:
                return bcI();
            case 2:
                return bcJ();
            case 4:
                return M(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return bcL();
            case 18:
                return bcJ();
            case 32:
                return J(arrayList);
            case 128:
                return K(arrayList);
            case 256:
                return bcK();
            case 1024:
                return bcM();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.eoW.bcW() != false) goto L9;
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
                    this.eoS = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.ept = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.eoV = new TbRichTextEmotionInfo();
                    this.eoV.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.eoV.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.eoV.mGifInfo.mStaticUrl = pbContent._static;
                    this.eoV.mType = this.mType;
                    this.eoV.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.eoV.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.eoV.mGifInfo.mPackageName = pbContent.packet_name;
                    this.eoV.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.eoV.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.eoV.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
                            break;
                        }
                    }
                    this.eoV.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
                case 20:
                    this.eoZ = new TbRichTextMemeInfo();
                    this.eoZ.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.dIL = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.eoY = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case 1280:
                    this.eoX = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.eoW = new i();
                        this.eoW.b(pbContent);
                        break;
                    }
                    this.ept = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.aYl().wp(this.ept.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.ept.setText(str);
                            break;
                        } else {
                            this.ept.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.ept.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.ept != null) {
                this.ept.trim();
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
                this.eoS = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.dIL = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.ept = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.eoV = new TbRichTextEmotionInfo();
                this.eoV.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.eoV.mGifInfo.mDynamicUrl = jSONObject.optString(PraiseUBCHelper.SOURCE_DYNAMIC);
                this.eoV.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.eoV.mType = this.mType;
                this.eoV.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.eoV.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.eoV.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.eoV.mGifInfo.mIcon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                String[] split = this.eoV.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.eoV.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
            } else {
                this.ept = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int wp = TbFaceManager.aYl().wp(this.ept.getText());
                    String optString = jSONObject.optString("c");
                    if (wp <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.ept.setText(str);
                    } else {
                        this.ept.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.ept.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.ept != null) {
                this.ept.trim();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int nI(int i) {
        return e.nI(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xu(String str) {
        if (!TextUtils.isEmpty(str)) {
            j jVar = new j();
            jVar.mLink = str;
            jVar.type = 0;
            jVar.dVK = "1";
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, jVar));
        }
    }
}
