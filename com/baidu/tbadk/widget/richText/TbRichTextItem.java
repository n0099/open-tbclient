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
    private TbRichTextMemeInfo bIX;
    private int mType = 0;
    private TbRichTextCommInfo bJp = null;
    private TbRichTextImageInfo bIQ = null;
    private TbRichTextVoiceInfo bcn = null;
    private TbRichTextEmotionInfo bIT = null;
    private f bIU = null;
    private TbRichTextLinkButtonInfo bIW = null;
    private TbRichTextLinkImageInfo bIV = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.bJp = tbRichTextCommInfo;
        this.bIQ = tbRichTextImageInfo;
        this.bcn = tbRichTextVoiceInfo;
        this.bIT = tbRichTextEmotionInfo;
        this.bIW = tbRichTextLinkButtonInfo;
        this.bIV = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo QP() {
        if (this.mType == 1280) {
            return this.bIV;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo QQ() {
        if (this.mType == 1024) {
            return this.bIW;
        }
        return null;
    }

    public TbRichTextImageInfo QH() {
        if (this.mType == 8) {
            return this.bIQ;
        }
        return null;
    }

    public f QL() {
        if (this.mType != 32) {
            return null;
        }
        return this.bIU;
    }

    public TbRichTextVoiceInfo QJ() {
        if (this.mType == 512 || this.mType == 768) {
            return this.bcn;
        }
        return null;
    }

    public TbRichTextEmotionInfo QM() {
        if (this.mType == 17) {
            return this.bIT;
        }
        return null;
    }

    public TbRichTextMemeInfo QN() {
        if (this.mType == 20) {
            return this.bIX;
        }
        return null;
    }

    private SpannableString Rb() {
        if (this.mType != 1 || this.bJp == null) {
            return null;
        }
        return new SpannableString(this.bJp.getText());
    }

    private CharSequence u(ArrayList<b> arrayList) {
        SpannableString b;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.bJp != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(d.j.video_text));
            CharSequence w = w(arrayList);
            if (w != null) {
                spannableStringBuilder.append(w);
            }
            if (this.bJp.QC() == 1) {
                b = b(this.mType, this.bJp.getText(), this.bJp.QD(), 0);
            } else {
                b = b(this.mType, this.bJp.getText(), this.bJp.getText(), 0);
            }
            if (b != null) {
                spannableStringBuilder.append((CharSequence) b);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence v(ArrayList<b> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.bJp != null) {
            CharSequence w = w(arrayList);
            if (w != null) {
                spannableStringBuilder.append(w);
            }
            SpannableString b = b(this.mType, this.bJp.getLink(), this.bJp.getLink(), 0);
            if (b != null) {
                spannableStringBuilder.append((CharSequence) b);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence w(ArrayList<b> arrayList) {
        TbRichTextItem tbRichTextItem = new TbRichTextItem();
        tbRichTextItem.a(4, new TbRichTextCommInfo("video_icon", " "), null, null, null, null, null);
        return tbRichTextItem.y(arrayList);
    }

    public String getVideoUrl() {
        if (this.mType != 32 || this.bJp == null) {
            return null;
        }
        if (this.bJp.QC() == 1) {
            return this.bJp.QD();
        }
        return this.bJp.getText();
    }

    private SpannableString Rc() {
        if ((this.mType != 2 && this.mType != 18) || this.bJp == null) {
            return null;
        }
        if (this.bJp.QC() == 1) {
            return b(this.mType, this.bJp.getText(), this.bJp.QD(), 0);
        }
        return b(this.mType, this.bJp.getText(), this.bJp.getLink(), this.bJp.QE());
    }

    private SpannableString Rd() {
        if (this.mType != 256 || this.bJp == null) {
            return null;
        }
        String text = this.bJp.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = text + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        c cVar = new c(this.mType, text);
        cVar.hj(this.bJp.getLink());
        spannableString.setSpan(cVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString Re() {
        if (this.mType != 16 || this.bJp == null) {
            return null;
        }
        return b(this.mType, this.bJp.getText(), this.bJp.getLink(), 0);
    }

    private SpannableString x(ArrayList<b> arrayList) {
        String text;
        int fT;
        a.C0084a gt;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.bJp != null && this.bJp.getText() != null && this.bJp.getLink() != null && (fT = TbFaceManager.LO().fT((text = this.bJp.getText()))) != 0) {
            String str = "#(" + TbFaceManager.LO().fV(text) + ")";
            spannableString = new SpannableString(str + " ");
            b bVar = new b(TbadkCoreApplication.getInst().getContext(), fT);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            if (TbFaceManager.LO().gt(text) != null) {
                int width = (int) (0.5d * gt.getWidth());
                bVar.setBounds(new Rect(0, 0, width, width));
            } else {
                bVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new com.baidu.tbadk.widget.c(bVar, 1), 0, str.length(), 33);
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
            cVar.iZ(i2);
            if (i2 == 1) {
                cVar.setTextColor(d.C0107d.cp_cont_d);
            } else {
                cVar.setTextColor(-1);
            }
            spannableString.setSpan(cVar, 0, str.length() - 1, 33);
        }
        return spannableString;
    }

    private SpannableString Rf() {
        if (this.mType != 1024 || this.bIW == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString("a");
        Drawable jb = d.jb(this.bIW.btn_type);
        jb.setBounds(0, 0, jb.getIntrinsicWidth(), jb.getIntrinsicHeight());
        com.baidu.tbadk.widget.f fVar = new com.baidu.tbadk.widget.f(jb);
        fVar.setVerticalOffset(l.s(TbadkCoreApplication.getInst().getContext(), d.e.ds4));
        spannableString.setSpan(fVar, 0, 1, 33);
        spannableString.setSpan(new c(1024, this.bIW.link), spannableString.length() - 1, "a".length(), 33);
        return spannableString;
    }

    public CharSequence y(ArrayList<b> arrayList) {
        switch (this.mType) {
            case 1:
                return Rb();
            case 2:
                return Rc();
            case 4:
                return x(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return Re();
            case 18:
                return Rc();
            case 32:
                return u(arrayList);
            case 128:
                return v(arrayList);
            case 256:
                return Rd();
            case 1024:
                return Rf();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.bIU.Rp() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = ja(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.bIQ = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.bJp = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.bIT = new TbRichTextEmotionInfo();
                    this.bIT.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.bIT.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.bIT.mGifInfo.mStaticUrl = pbContent._static;
                    this.bIT.mType = this.mType;
                    this.bIT.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.bIT.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.bIT.mGifInfo.mPackageName = pbContent.packet_name;
                    this.bIT.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.bIT.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.bIT.mGifInfo.mGid = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.bIT.mGifInfo.mGid = split[i].split("_")[0];
                case 20:
                    this.bIX = new TbRichTextMemeInfo();
                    this.bIX.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.bcn = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.bIW = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case 1280:
                    this.bIV = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.bIU = new f();
                        this.bIU.b(pbContent);
                        break;
                    }
                    this.bJp = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.LO().fT(this.bJp.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(d.j.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.bJp.setText(str);
                            break;
                        } else {
                            this.bJp.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.bJp.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.bJp != null) {
                this.bJp.QF();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = ja(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.bIQ = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.bcn = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.bJp = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.bIT = new TbRichTextEmotionInfo();
                this.bIT.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.bIT.mGifInfo.mDynamicUrl = jSONObject.optString("dynamic");
                this.bIT.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.bIT.mType = this.mType;
                this.bIT.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.bIT.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.bIT.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.bIT.mGifInfo.mIcon = jSONObject.optString("icon");
                String[] split = this.bIT.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.bIT.mGifInfo.mGid = split[i].split("_")[0];
            } else {
                this.bJp = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int fT = TbFaceManager.LO().fT(this.bJp.getText());
                    String optString = jSONObject.optString("c");
                    if (fT <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(d.j.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.bJp.setText(str);
                    } else {
                        this.bJp.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.bJp.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.bJp != null) {
                this.bJp.QF();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int ja(int i) {
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
