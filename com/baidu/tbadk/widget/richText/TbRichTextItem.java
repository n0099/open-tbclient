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
    private TbRichTextMemeInfo eOa;
    private int mType = 0;
    private TbRichTextCommInfo eOv = null;
    private TbRichTextImageInfo eNT = null;
    private TbRichTextVoiceInfo eeA = null;
    private TbRichTextEmotionInfo eNW = null;
    private j eNX = null;
    private TbRichTextLinkButtonInfo eNZ = null;
    private TbRichTextLinkImageInfo eNY = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.eOv = tbRichTextCommInfo;
        this.eNT = tbRichTextImageInfo;
        this.eeA = tbRichTextVoiceInfo;
        this.eNW = tbRichTextEmotionInfo;
        this.eNZ = tbRichTextLinkButtonInfo;
        this.eNY = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo blc() {
        if (this.mType == 1280) {
            return this.eNY;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo blr() {
        if (this.mType == 1024) {
            return this.eNZ;
        }
        return null;
    }

    public TbRichTextImageInfo bkU() {
        if (this.mType == 8) {
            return this.eNT;
        }
        return null;
    }

    public j bkY() {
        if (this.mType != 32) {
            return null;
        }
        return this.eNX;
    }

    public TbRichTextVoiceInfo bkW() {
        if (this.mType == 512 || this.mType == 768) {
            return this.eeA;
        }
        return null;
    }

    public TbRichTextEmotionInfo bkZ() {
        if (this.mType == 17) {
            return this.eNW;
        }
        return null;
    }

    public TbRichTextMemeInfo bla() {
        if (this.mType == 20) {
            return this.eOa;
        }
        return null;
    }

    private SpannableString bls() {
        if (this.mType != 1 || this.eOv == null) {
            return null;
        }
        return new SpannableString(this.eOv.getText());
    }

    private CharSequence J(ArrayList<d> arrayList) {
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.eOv != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(R.string.video_text));
            CharSequence L = L(arrayList);
            if (L != null) {
                spannableStringBuilder.append(L);
            }
            if (this.eOv.bkQ() == 1) {
                a = a(this.mType, this.eOv.getText(), this.eOv.bkR(), 0);
            } else {
                a = a(this.mType, this.eOv.getText(), this.eOv.getText(), 0);
            }
            if (a != null) {
                spannableStringBuilder.append((CharSequence) a);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence K(ArrayList<d> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.eOv != null) {
            CharSequence L = L(arrayList);
            if (L != null) {
                spannableStringBuilder.append(L);
            }
            SpannableString a = a(this.mType, this.eOv.getLink(), this.eOv.getLink(), 0);
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
        if (this.mType != 32 || this.eOv == null) {
            return null;
        }
        if (this.eOv.bkQ() == 1) {
            return this.eOv.bkR();
        }
        return this.eOv.getText();
    }

    private SpannableString blt() {
        if ((this.mType != 2 && this.mType != 18) || this.eOv == null) {
            return null;
        }
        if (this.eOv.bkQ() == 1) {
            return a(this.mType, this.eOv.getText(), this.eOv.bkR(), 0);
        }
        return a(this.mType, this.eOv.getText(), this.eOv.getLink(), this.eOv.bkS());
    }

    private SpannableString blu() {
        if (this.mType != 256 || this.eOv == null) {
            return null;
        }
        String text = this.eOv.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = text + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        f fVar = new f(this.mType, text);
        fVar.zv(this.eOv.getLink());
        spannableString.setSpan(fVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString blv() {
        if (this.mType != 16 || this.eOv == null) {
            return null;
        }
        return a(this.mType, this.eOv.getText(), this.eOv.getLink(), 0);
    }

    private SpannableString M(ArrayList<d> arrayList) {
        String text;
        int yr;
        String str;
        a.C0496a yL;
        if (this.mType != 4 || this.eOv == null || this.eOv.getText() == null || this.eOv.getLink() == null || (yr = TbFaceManager.bgy().yr((text = this.eOv.getText()))) == 0) {
            return null;
        }
        String yt = TbFaceManager.bgy().yt(text);
        if (!TextUtils.isEmpty(text) && text.startsWith("shoubai_emoji_")) {
            str = "[" + yt + "]";
        } else {
            str = "#(" + yt + ")";
        }
        SpannableString spannableString = new SpannableString(str + " ");
        d dVar = new d(TbadkCoreApplication.getInst().getContext(), yr);
        if (arrayList != null) {
            arrayList.add(dVar);
        }
        if (TbFaceManager.bgy().yL(text) != null) {
            int width = (int) (yL.getWidth() * 0.5d);
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
            boolean z = i == 2 && e.dv(str, str2);
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
                        TbRichTextItem.this.zw(str2);
                    }
                };
            } else {
                fVar = new f(i, str2);
            }
            fVar.oP(i2);
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

    private SpannableString blw() {
        if (this.mType != 1024 || this.eNZ == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(Config.APP_VERSION_CODE);
        Drawable oQ = g.oQ(this.eNZ.btn_type);
        oQ.setBounds(0, 0, oQ.getIntrinsicWidth(), oQ.getIntrinsicHeight());
        com.baidu.tbadk.widget.d dVar = new com.baidu.tbadk.widget.d(oQ);
        dVar.setVerticalOffset(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds4));
        spannableString.setSpan(dVar, 0, 1, 33);
        spannableString.setSpan(new f(1024, this.eNZ.link), spannableString.length() - 1, Config.APP_VERSION_CODE.length(), 33);
        return spannableString;
    }

    public CharSequence N(ArrayList<d> arrayList) {
        switch (this.mType) {
            case 1:
                return bls();
            case 2:
                return blt();
            case 4:
                return M(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return blv();
            case 18:
                return blt();
            case 32:
                return J(arrayList);
            case 128:
                return K(arrayList);
            case 256:
                return blu();
            case 1024:
                return blw();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.eNX.blG() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = oM(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.eNT = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.eOv = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.eNW = new TbRichTextEmotionInfo();
                    this.eNW.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.eNW.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.eNW.mGifInfo.mStaticUrl = pbContent._static;
                    this.eNW.mType = this.mType;
                    this.eNW.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.eNW.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.eNW.mGifInfo.mPackageName = pbContent.packet_name;
                    this.eNW.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.eNW.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.eNW.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
                            break;
                        }
                    }
                    this.eNW.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
                case 20:
                    this.eOa = new TbRichTextMemeInfo();
                    this.eOa.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.eeA = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.eNZ = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case 1280:
                    this.eNY = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.eNX = new j();
                        this.eNX.b(pbContent);
                        break;
                    }
                    this.eOv = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.bgy().yr(this.eOv.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.eOv.setText(str);
                            break;
                        } else {
                            this.eOv.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.eOv.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.eOv != null) {
                this.eOv.trim();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = oM(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.eNT = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.eeA = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.eOv = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.eNW = new TbRichTextEmotionInfo();
                this.eNW.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.eNW.mGifInfo.mDynamicUrl = jSONObject.optString(PraiseUBCHelper.SOURCE_DYNAMIC);
                this.eNW.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.eNW.mType = this.mType;
                this.eNW.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.eNW.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.eNW.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.eNW.mGifInfo.mIcon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                String[] split = this.eNW.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.eNW.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
            } else {
                this.eOv = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int yr = TbFaceManager.bgy().yr(this.eOv.getText());
                    String optString = jSONObject.optString("c");
                    if (yr <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.eOv.setText(str);
                    } else {
                        this.eOv.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.eOv.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.eOv != null) {
                this.eOv.trim();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int oM(int i) {
        return e.oM(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zw(String str) {
        if (!TextUtils.isEmpty(str)) {
            k kVar = new k();
            kVar.mLink = str;
            kVar.type = 0;
            kVar.esJ = "1";
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, kVar));
        }
    }
}
