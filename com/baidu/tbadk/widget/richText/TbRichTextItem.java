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
    private TbRichTextMemeInfo aVc;
    private int mType = 0;
    private TbRichTextCommInfo aVt = null;
    private TbRichTextImageInfo aUV = null;
    private TbRichTextVoiceInfo aop = null;
    private TbRichTextEmotionInfo aUY = null;
    private f aUZ = null;
    private TbRichTextLinkButtonInfo aVb = null;
    private TbRichTextLinkImageInfo aVa = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.aVt = tbRichTextCommInfo;
        this.aUV = tbRichTextImageInfo;
        this.aop = tbRichTextVoiceInfo;
        this.aUY = tbRichTextEmotionInfo;
        this.aVb = tbRichTextLinkButtonInfo;
        this.aVa = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo JF() {
        if (this.mType == 1280) {
            return this.aVa;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo JG() {
        if (this.mType == 1024) {
            return this.aVb;
        }
        return null;
    }

    public TbRichTextImageInfo Jx() {
        if (this.mType == 8) {
            return this.aUV;
        }
        return null;
    }

    public f JB() {
        if (this.mType != 32) {
            return null;
        }
        return this.aUZ;
    }

    public TbRichTextVoiceInfo Jz() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aop;
        }
        return null;
    }

    public TbRichTextEmotionInfo JC() {
        if (this.mType == 17) {
            return this.aUY;
        }
        return null;
    }

    public TbRichTextMemeInfo JD() {
        if (this.mType == 20) {
            return this.aVc;
        }
        return null;
    }

    private SpannableString JQ() {
        if (this.mType != 1 || this.aVt == null) {
            return null;
        }
        return new SpannableString(this.aVt.getText());
    }

    private CharSequence t(ArrayList<b> arrayList) {
        SpannableString b;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.aVt != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(d.j.video_text));
            CharSequence v = v(arrayList);
            if (v != null) {
                spannableStringBuilder.append(v);
            }
            if (this.aVt.Js() == 1) {
                b = b(this.mType, this.aVt.getText(), this.aVt.Jt(), 0);
            } else {
                b = b(this.mType, this.aVt.getText(), this.aVt.getText(), 0);
            }
            if (b != null) {
                spannableStringBuilder.append((CharSequence) b);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence u(ArrayList<b> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.aVt != null) {
            CharSequence v = v(arrayList);
            if (v != null) {
                spannableStringBuilder.append(v);
            }
            SpannableString b = b(this.mType, this.aVt.getLink(), this.aVt.getLink(), 0);
            if (b != null) {
                spannableStringBuilder.append((CharSequence) b);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence v(ArrayList<b> arrayList) {
        TbRichTextItem tbRichTextItem = new TbRichTextItem();
        tbRichTextItem.a(4, new TbRichTextCommInfo("video_icon", " "), null, null, null, null, null);
        return tbRichTextItem.x(arrayList);
    }

    public String getVideoUrl() {
        if (this.mType != 32 || this.aVt == null) {
            return null;
        }
        if (this.aVt.Js() == 1) {
            return this.aVt.Jt();
        }
        return this.aVt.getText();
    }

    private SpannableString JR() {
        if ((this.mType != 2 && this.mType != 18) || this.aVt == null) {
            return null;
        }
        if (this.aVt.Js() == 1) {
            return b(this.mType, this.aVt.getText(), this.aVt.Jt(), 0);
        }
        return b(this.mType, this.aVt.getText(), this.aVt.getLink(), this.aVt.Ju());
    }

    private SpannableString JS() {
        if (this.mType != 256 || this.aVt == null) {
            return null;
        }
        String text = this.aVt.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = text + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        c cVar = new c(this.mType, text);
        cVar.hf(this.aVt.getLink());
        spannableString.setSpan(cVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString JT() {
        if (this.mType != 16 || this.aVt == null) {
            return null;
        }
        return b(this.mType, this.aVt.getText(), this.aVt.getLink(), 0);
    }

    private SpannableString w(ArrayList<b> arrayList) {
        String text;
        int fL;
        a.C0071a gk;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.aVt != null && this.aVt.getText() != null && this.aVt.getLink() != null && (fL = TbFaceManager.Ez().fL((text = this.aVt.getText()))) != 0) {
            String str = "#(" + TbFaceManager.Ez().fN(text) + ")";
            spannableString = new SpannableString(str + " ");
            b bVar = new b(TbadkCoreApplication.getInst().getContext(), fL);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            if (TbFaceManager.Ez().gk(text) != null) {
                int width = (int) (0.5d * gk.getWidth());
                bVar.setBounds(new Rect(0, 0, width, width));
            } else {
                bVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new com.baidu.tbadk.widget.e(bVar), 0, str.length(), 33);
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
            cVar.ge(i2);
            if (i2 == 1) {
                cVar.setTextColor(d.C0095d.cp_cont_d);
            } else {
                cVar.setTextColor(-1);
            }
            spannableString.setSpan(cVar, 0, str.length() - 1, 33);
        }
        return spannableString;
    }

    private SpannableString JU() {
        if (this.mType != 1024 || this.aVb == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString("a");
        Drawable gg = d.gg(this.aVb.btn_type);
        gg.setBounds(0, 0, gg.getIntrinsicWidth(), gg.getIntrinsicHeight());
        com.baidu.tbadk.widget.e eVar = new com.baidu.tbadk.widget.e(gg);
        eVar.setVerticalOffset(l.f(TbadkCoreApplication.getInst().getContext(), d.e.ds4));
        spannableString.setSpan(eVar, 0, 1, 33);
        spannableString.setSpan(new c(1024, this.aVb.link), spannableString.length() - 1, "a".length(), 33);
        return spannableString;
    }

    public CharSequence x(ArrayList<b> arrayList) {
        switch (this.mType) {
            case 1:
                return JQ();
            case 2:
                return JR();
            case 4:
                return w(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return JT();
            case 18:
                return JR();
            case 32:
                return t(arrayList);
            case 128:
                return u(arrayList);
            case 256:
                return JS();
            case 1024:
                return JU();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.aUZ.Ke() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = gf(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.aUV = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.aVt = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.aUY = new TbRichTextEmotionInfo();
                    this.aUY.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.aUY.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.aUY.mGifInfo.mStaticUrl = pbContent._static;
                    this.aUY.mType = this.mType;
                    this.aUY.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.aUY.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.aUY.mGifInfo.mPackageName = pbContent.packet_name;
                    this.aUY.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.aUY.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.aUY.mGifInfo.mGid = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.aUY.mGifInfo.mGid = split[i].split("_")[0];
                case 20:
                    this.aVc = new TbRichTextMemeInfo();
                    this.aVc.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.aop = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.aVb = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case 1280:
                    this.aVa = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.aUZ = new f();
                        this.aUZ.b(pbContent);
                        break;
                    }
                    this.aVt = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.Ez().fL(this.aVt.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(d.j.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.aVt.setText(str);
                            break;
                        } else {
                            this.aVt.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.aVt.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.aVt != null) {
                this.aVt.Jv();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = gf(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.aUV = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.aop = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.aVt = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.aUY = new TbRichTextEmotionInfo();
                this.aUY.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.aUY.mGifInfo.mDynamicUrl = jSONObject.optString("dynamic");
                this.aUY.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.aUY.mType = this.mType;
                this.aUY.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.aUY.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.aUY.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.aUY.mGifInfo.mIcon = jSONObject.optString("icon");
                String[] split = this.aUY.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.aUY.mGifInfo.mGid = split[i].split("_")[0];
            } else {
                this.aVt = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int fL = TbFaceManager.Ez().fL(this.aVt.getText());
                    String optString = jSONObject.optString("c");
                    if (fL <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(d.j.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.aVt.setText(str);
                    } else {
                        this.aVt.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.aVt.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.aVt != null) {
                this.aVt.Jv();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int gf(int i) {
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
