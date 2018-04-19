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
    private TbRichTextMemeInfo aVP;
    private int mType = 0;
    private TbRichTextCommInfo aWg = null;
    private TbRichTextImageInfo aVI = null;
    private TbRichTextVoiceInfo apt = null;
    private TbRichTextEmotionInfo aVL = null;
    private f aVM = null;
    private TbRichTextLinkButtonInfo aVO = null;
    private TbRichTextLinkImageInfo aVN = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.aWg = tbRichTextCommInfo;
        this.aVI = tbRichTextImageInfo;
        this.apt = tbRichTextVoiceInfo;
        this.aVL = tbRichTextEmotionInfo;
        this.aVO = tbRichTextLinkButtonInfo;
        this.aVN = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo JX() {
        if (this.mType == 1280) {
            return this.aVN;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo JY() {
        if (this.mType == 1024) {
            return this.aVO;
        }
        return null;
    }

    public TbRichTextImageInfo JP() {
        if (this.mType == 8) {
            return this.aVI;
        }
        return null;
    }

    public f JT() {
        if (this.mType != 32) {
            return null;
        }
        return this.aVM;
    }

    public TbRichTextVoiceInfo JR() {
        if (this.mType == 512 || this.mType == 768) {
            return this.apt;
        }
        return null;
    }

    public TbRichTextEmotionInfo JU() {
        if (this.mType == 17) {
            return this.aVL;
        }
        return null;
    }

    public TbRichTextMemeInfo JV() {
        if (this.mType == 20) {
            return this.aVP;
        }
        return null;
    }

    private SpannableString Ki() {
        if (this.mType != 1 || this.aWg == null) {
            return null;
        }
        return new SpannableString(this.aWg.getText());
    }

    private CharSequence t(ArrayList<b> arrayList) {
        SpannableString b;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.aWg != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(d.k.video_text));
            CharSequence v = v(arrayList);
            if (v != null) {
                spannableStringBuilder.append(v);
            }
            if (this.aWg.JK() == 1) {
                b = b(this.mType, this.aWg.getText(), this.aWg.JL(), 0);
            } else {
                b = b(this.mType, this.aWg.getText(), this.aWg.getText(), 0);
            }
            if (b != null) {
                spannableStringBuilder.append((CharSequence) b);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence u(ArrayList<b> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.aWg != null) {
            CharSequence v = v(arrayList);
            if (v != null) {
                spannableStringBuilder.append(v);
            }
            SpannableString b = b(this.mType, this.aWg.getLink(), this.aWg.getLink(), 0);
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
        if (this.mType != 32 || this.aWg == null) {
            return null;
        }
        if (this.aWg.JK() == 1) {
            return this.aWg.JL();
        }
        return this.aWg.getText();
    }

    private SpannableString Kj() {
        if ((this.mType != 2 && this.mType != 18) || this.aWg == null) {
            return null;
        }
        if (this.aWg.JK() == 1) {
            return b(this.mType, this.aWg.getText(), this.aWg.JL(), 0);
        }
        return b(this.mType, this.aWg.getText(), this.aWg.getLink(), this.aWg.JM());
    }

    private SpannableString Kk() {
        if (this.mType != 256 || this.aWg == null) {
            return null;
        }
        String text = this.aWg.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = text + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        c cVar = new c(this.mType, text);
        cVar.ht(this.aWg.getLink());
        spannableString.setSpan(cVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString Kl() {
        if (this.mType != 16 || this.aWg == null) {
            return null;
        }
        return b(this.mType, this.aWg.getText(), this.aWg.getLink(), 0);
    }

    private SpannableString w(ArrayList<b> arrayList) {
        String text;
        int gb;
        a.C0098a gB;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.aWg != null && this.aWg.getText() != null && this.aWg.getLink() != null && (gb = TbFaceManager.EZ().gb((text = this.aWg.getText()))) != 0) {
            String str = "#(" + TbFaceManager.EZ().gd(text) + ")";
            spannableString = new SpannableString(str + " ");
            b bVar = new b(TbadkCoreApplication.getInst().getContext(), gb);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            if (TbFaceManager.EZ().gB(text) != null) {
                int width = (int) (0.5d * gB.getWidth());
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
            cVar.fW(i2);
            if (i2 == 1) {
                cVar.setTextColor(d.C0126d.cp_cont_d);
            } else {
                cVar.setTextColor(-1);
            }
            spannableString.setSpan(cVar, 0, str.length() - 1, 33);
        }
        return spannableString;
    }

    private SpannableString Km() {
        if (this.mType != 1024 || this.aVO == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString("a");
        Drawable fY = d.fY(this.aVO.btn_type);
        fY.setBounds(0, 0, fY.getIntrinsicWidth(), fY.getIntrinsicHeight());
        com.baidu.tbadk.widget.c cVar = new com.baidu.tbadk.widget.c(fY);
        cVar.setVerticalOffset(l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds4));
        spannableString.setSpan(cVar, 0, 1, 33);
        spannableString.setSpan(new c(1024, this.aVO.link), spannableString.length() - 1, "a".length(), 33);
        return spannableString;
    }

    public CharSequence x(ArrayList<b> arrayList) {
        switch (this.mType) {
            case 1:
                return Ki();
            case 2:
                return Kj();
            case 4:
                return w(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return Kl();
            case 18:
                return Kj();
            case 32:
                return t(arrayList);
            case 128:
                return u(arrayList);
            case 256:
                return Kk();
            case 1024:
                return Km();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.aVM.Kw() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = fX(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.aVI = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.aWg = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.aVL = new TbRichTextEmotionInfo();
                    this.aVL.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.aVL.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.aVL.mGifInfo.mStaticUrl = pbContent._static;
                    this.aVL.mType = this.mType;
                    this.aVL.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.aVL.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.aVL.mGifInfo.mPackageName = pbContent.packet_name;
                    this.aVL.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.aVL.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.aVL.mGifInfo.mGid = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.aVL.mGifInfo.mGid = split[i].split("_")[0];
                case 20:
                    this.aVP = new TbRichTextMemeInfo();
                    this.aVP.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.apt = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.aVO = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case 1280:
                    this.aVN = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.aVM = new f();
                        this.aVM.b(pbContent);
                        break;
                    }
                    this.aWg = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.EZ().gb(this.aWg.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(d.k.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.aWg.setText(str);
                            break;
                        } else {
                            this.aWg.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.aWg.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.aWg != null) {
                this.aWg.JN();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = fX(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.aVI = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.apt = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.aWg = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.aVL = new TbRichTextEmotionInfo();
                this.aVL.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.aVL.mGifInfo.mDynamicUrl = jSONObject.optString("dynamic");
                this.aVL.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.aVL.mType = this.mType;
                this.aVL.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.aVL.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.aVL.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.aVL.mGifInfo.mIcon = jSONObject.optString("icon");
                String[] split = this.aVL.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.aVL.mGifInfo.mGid = split[i].split("_")[0];
            } else {
                this.aWg = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int gb = TbFaceManager.EZ().gb(this.aWg.getText());
                    String optString = jSONObject.optString("c");
                    if (gb <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(d.k.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.aWg.setText(str);
                    } else {
                        this.aWg.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.aWg.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.aWg != null) {
                this.aWg.JN();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int fX(int i) {
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
