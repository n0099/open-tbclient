package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.d;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextItem extends OrmObject {
    private TbRichTextMemeInfo bdU;
    private int mType = 0;
    private TbRichTextCommInfo bem = null;
    private TbRichTextImageInfo bdN = null;
    private TbRichTextVoiceInfo axA = null;
    private TbRichTextEmotionInfo bdQ = null;
    private f bdR = null;
    private TbRichTextLinkButtonInfo bdT = null;
    private TbRichTextLinkImageInfo bdS = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.bem = tbRichTextCommInfo;
        this.bdN = tbRichTextImageInfo;
        this.axA = tbRichTextVoiceInfo;
        this.bdQ = tbRichTextEmotionInfo;
        this.bdT = tbRichTextLinkButtonInfo;
        this.bdS = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo Nu() {
        if (this.mType == 1280) {
            return this.bdS;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo Nv() {
        if (this.mType == 1024) {
            return this.bdT;
        }
        return null;
    }

    public TbRichTextImageInfo Nm() {
        if (this.mType == 8) {
            return this.bdN;
        }
        return null;
    }

    public f Nq() {
        if (this.mType != 32) {
            return null;
        }
        return this.bdR;
    }

    public TbRichTextVoiceInfo No() {
        if (this.mType == 512 || this.mType == 768) {
            return this.axA;
        }
        return null;
    }

    public TbRichTextEmotionInfo Nr() {
        if (this.mType == 17) {
            return this.bdQ;
        }
        return null;
    }

    public TbRichTextMemeInfo Ns() {
        if (this.mType == 20) {
            return this.bdU;
        }
        return null;
    }

    private SpannableString NF() {
        if (this.mType != 1 || this.bem == null) {
            return null;
        }
        return new SpannableString(this.bem.getText());
    }

    private CharSequence s(ArrayList<b> arrayList) {
        SpannableString b;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.bem != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(d.k.video_text));
            CharSequence u = u(arrayList);
            if (u != null) {
                spannableStringBuilder.append(u);
            }
            if (this.bem.Nh() == 1) {
                b = b(this.mType, this.bem.getText(), this.bem.Ni(), 0);
            } else {
                b = b(this.mType, this.bem.getText(), this.bem.getText(), 0);
            }
            if (b != null) {
                spannableStringBuilder.append((CharSequence) b);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence t(ArrayList<b> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.bem != null) {
            CharSequence u = u(arrayList);
            if (u != null) {
                spannableStringBuilder.append(u);
            }
            SpannableString b = b(this.mType, this.bem.getLink(), this.bem.getLink(), 0);
            if (b != null) {
                spannableStringBuilder.append((CharSequence) b);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence u(ArrayList<b> arrayList) {
        TbRichTextItem tbRichTextItem = new TbRichTextItem();
        tbRichTextItem.a(4, new TbRichTextCommInfo("video_icon", " "), null, null, null, null, null);
        return tbRichTextItem.w(arrayList);
    }

    public String getVideoUrl() {
        if (this.mType != 32 || this.bem == null) {
            return null;
        }
        if (this.bem.Nh() == 1) {
            return this.bem.Ni();
        }
        return this.bem.getText();
    }

    private SpannableString NG() {
        if ((this.mType != 2 && this.mType != 18) || this.bem == null) {
            return null;
        }
        if (this.bem.Nh() == 1) {
            return b(this.mType, this.bem.getText(), this.bem.Ni(), 0);
        }
        return b(this.mType, this.bem.getText(), this.bem.getLink(), this.bem.Nj());
    }

    private SpannableString NH() {
        if (this.mType != 256 || this.bem == null) {
            return null;
        }
        String text = this.bem.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = text + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        c cVar = new c(this.mType, text);
        cVar.hS(this.bem.getLink());
        spannableString.setSpan(cVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString NI() {
        if (this.mType != 16 || this.bem == null) {
            return null;
        }
        return b(this.mType, this.bem.getText(), this.bem.getLink(), 0);
    }

    private SpannableString v(ArrayList<b> arrayList) {
        String text;
        int gA;
        a.C0115a gZ;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.bem != null && this.bem.getText() != null && this.bem.getLink() != null && (gA = TbFaceManager.IC().gA((text = this.bem.getText()))) != 0) {
            String str = "#(" + TbFaceManager.IC().gC(text) + ")";
            spannableString = new SpannableString(str + " ");
            b bVar = new b(TbadkCoreApplication.getInst().getContext(), gA);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            if (TbFaceManager.IC().gZ(text) != null) {
                int width = (int) (0.5d * gZ.getWidth());
                bVar.setBounds(new Rect(0, 0, width, width));
            } else {
                bVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new com.baidu.tbadk.widget.a(bVar, 1), 0, str.length(), 33);
        }
        return spannableString;
    }

    private SpannableString b(int i, String str, String str2, int i2) {
        SpannableString spannableString = null;
        if (str != null) {
            if (!str.endsWith(" ")) {
                str = str + " ";
            }
            spannableString = new SpannableString(str);
            c cVar = new c(i, str2);
            cVar.fY(i2);
            if (i2 == 1) {
                cVar.setTextColor(d.C0141d.cp_cont_d);
            } else {
                cVar.setTextColor(-1);
            }
            spannableString.setSpan(cVar, 0, str.length() - 1, 33);
        }
        return spannableString;
    }

    private SpannableString NJ() {
        if (this.mType != 1024 || this.bdT == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString("a");
        Drawable ga = d.ga(this.bdT.btn_type);
        ga.setBounds(0, 0, ga.getIntrinsicWidth(), ga.getIntrinsicHeight());
        com.baidu.tbadk.widget.c cVar = new com.baidu.tbadk.widget.c(ga);
        cVar.setVerticalOffset(l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds4));
        spannableString.setSpan(cVar, 0, 1, 33);
        spannableString.setSpan(new c(1024, this.bdT.link), spannableString.length() - 1, "a".length(), 33);
        return spannableString;
    }

    public CharSequence w(ArrayList<b> arrayList) {
        switch (this.mType) {
            case 1:
                return NF();
            case 2:
                return NG();
            case 4:
                return v(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return NI();
            case 18:
                return NG();
            case 32:
                return s(arrayList);
            case 128:
                return t(arrayList);
            case 256:
                return NH();
            case 1024:
                return NJ();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.bdR.NT() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = fZ(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.bdN = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.bem = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.bdQ = new TbRichTextEmotionInfo();
                    this.bdQ.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.bdQ.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.bdQ.mGifInfo.mStaticUrl = pbContent._static;
                    this.bdQ.mType = this.mType;
                    this.bdQ.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.bdQ.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.bdQ.mGifInfo.mPackageName = pbContent.packet_name;
                    this.bdQ.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.bdQ.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.bdQ.mGifInfo.mGid = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.bdQ.mGifInfo.mGid = split[i].split("_")[0];
                case 20:
                    this.bdU = new TbRichTextMemeInfo();
                    this.bdU.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.axA = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.bdT = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case 1280:
                    this.bdS = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.bdR = new f();
                        this.bdR.b(pbContent);
                        break;
                    }
                    this.bem = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.IC().gA(this.bem.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(d.k.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.bem.setText(str);
                            break;
                        } else {
                            this.bem.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.bem.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.bem != null) {
                this.bem.Nk();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = fZ(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.bdN = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.axA = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.bem = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.bdQ = new TbRichTextEmotionInfo();
                this.bdQ.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.bdQ.mGifInfo.mDynamicUrl = jSONObject.optString("dynamic");
                this.bdQ.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.bdQ.mType = this.mType;
                this.bdQ.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.bdQ.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.bdQ.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.bdQ.mGifInfo.mIcon = jSONObject.optString("icon");
                String[] split = this.bdQ.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.bdQ.mGifInfo.mGid = split[i].split("_")[0];
            } else {
                this.bem = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int gA = TbFaceManager.IC().gA(this.bem.getText());
                    String optString = jSONObject.optString("c");
                    if (gA <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(d.k.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.bem.setText(str);
                    } else {
                        this.bem.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.bem.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.bem != null) {
                this.bem.Nk();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int fZ(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
            case 12:
            case 15:
            case 16:
            case 17:
            case 19:
            default:
                return 0;
            case 8:
                return 128;
            case 9:
                return 256;
            case 10:
                return 512;
            case 11:
                return 17;
            case 13:
                return 1024;
            case 14:
                return 1280;
            case 18:
                return 18;
            case 20:
                return 20;
        }
    }
}
