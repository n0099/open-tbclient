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
    private TbRichTextMemeInfo bJf;
    private int mType = 0;
    private TbRichTextCommInfo bJx = null;
    private TbRichTextImageInfo bIY = null;
    private TbRichTextVoiceInfo bcv = null;
    private TbRichTextEmotionInfo bJb = null;
    private f bJc = null;
    private TbRichTextLinkButtonInfo bJe = null;
    private TbRichTextLinkImageInfo bJd = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.bJx = tbRichTextCommInfo;
        this.bIY = tbRichTextImageInfo;
        this.bcv = tbRichTextVoiceInfo;
        this.bJb = tbRichTextEmotionInfo;
        this.bJe = tbRichTextLinkButtonInfo;
        this.bJd = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo QR() {
        if (this.mType == 1280) {
            return this.bJd;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo QS() {
        if (this.mType == 1024) {
            return this.bJe;
        }
        return null;
    }

    public TbRichTextImageInfo QJ() {
        if (this.mType == 8) {
            return this.bIY;
        }
        return null;
    }

    public f QN() {
        if (this.mType != 32) {
            return null;
        }
        return this.bJc;
    }

    public TbRichTextVoiceInfo QL() {
        if (this.mType == 512 || this.mType == 768) {
            return this.bcv;
        }
        return null;
    }

    public TbRichTextEmotionInfo QO() {
        if (this.mType == 17) {
            return this.bJb;
        }
        return null;
    }

    public TbRichTextMemeInfo QP() {
        if (this.mType == 20) {
            return this.bJf;
        }
        return null;
    }

    private SpannableString Rd() {
        if (this.mType != 1 || this.bJx == null) {
            return null;
        }
        return new SpannableString(this.bJx.getText());
    }

    private CharSequence u(ArrayList<b> arrayList) {
        SpannableString b;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.bJx != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(d.j.video_text));
            CharSequence w = w(arrayList);
            if (w != null) {
                spannableStringBuilder.append(w);
            }
            if (this.bJx.QE() == 1) {
                b = b(this.mType, this.bJx.getText(), this.bJx.QF(), 0);
            } else {
                b = b(this.mType, this.bJx.getText(), this.bJx.getText(), 0);
            }
            if (b != null) {
                spannableStringBuilder.append((CharSequence) b);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence v(ArrayList<b> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.bJx != null) {
            CharSequence w = w(arrayList);
            if (w != null) {
                spannableStringBuilder.append(w);
            }
            SpannableString b = b(this.mType, this.bJx.getLink(), this.bJx.getLink(), 0);
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
        if (this.mType != 32 || this.bJx == null) {
            return null;
        }
        if (this.bJx.QE() == 1) {
            return this.bJx.QF();
        }
        return this.bJx.getText();
    }

    private SpannableString Re() {
        if ((this.mType != 2 && this.mType != 18) || this.bJx == null) {
            return null;
        }
        if (this.bJx.QE() == 1) {
            return b(this.mType, this.bJx.getText(), this.bJx.QF(), 0);
        }
        return b(this.mType, this.bJx.getText(), this.bJx.getLink(), this.bJx.QG());
    }

    private SpannableString Rf() {
        if (this.mType != 256 || this.bJx == null) {
            return null;
        }
        String text = this.bJx.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = text + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        c cVar = new c(this.mType, text);
        cVar.hr(this.bJx.getLink());
        spannableString.setSpan(cVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString Rg() {
        if (this.mType != 16 || this.bJx == null) {
            return null;
        }
        return b(this.mType, this.bJx.getText(), this.bJx.getLink(), 0);
    }

    private SpannableString x(ArrayList<b> arrayList) {
        String text;
        int gb;
        a.C0085a gB;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.bJx != null && this.bJx.getText() != null && this.bJx.getLink() != null && (gb = TbFaceManager.LQ().gb((text = this.bJx.getText()))) != 0) {
            String str = "#(" + TbFaceManager.LQ().gd(text) + ")";
            spannableString = new SpannableString(str + " ");
            b bVar = new b(TbadkCoreApplication.getInst().getContext(), gb);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            if (TbFaceManager.LQ().gB(text) != null) {
                int width = (int) (0.5d * gB.getWidth());
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
                cVar.setTextColor(d.C0108d.cp_cont_d);
            } else {
                cVar.setTextColor(-1);
            }
            spannableString.setSpan(cVar, 0, str.length() - 1, 33);
        }
        return spannableString;
    }

    private SpannableString Rh() {
        if (this.mType != 1024 || this.bJe == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString("a");
        Drawable jb = d.jb(this.bJe.btn_type);
        jb.setBounds(0, 0, jb.getIntrinsicWidth(), jb.getIntrinsicHeight());
        com.baidu.tbadk.widget.f fVar = new com.baidu.tbadk.widget.f(jb);
        fVar.setVerticalOffset(l.s(TbadkCoreApplication.getInst().getContext(), d.e.ds4));
        spannableString.setSpan(fVar, 0, 1, 33);
        spannableString.setSpan(new c(1024, this.bJe.link), spannableString.length() - 1, "a".length(), 33);
        return spannableString;
    }

    public CharSequence y(ArrayList<b> arrayList) {
        switch (this.mType) {
            case 1:
                return Rd();
            case 2:
                return Re();
            case 4:
                return x(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return Rg();
            case 18:
                return Re();
            case 32:
                return u(arrayList);
            case 128:
                return v(arrayList);
            case 256:
                return Rf();
            case 1024:
                return Rh();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.bJc.Rr() != false) goto L9;
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
                    this.bIY = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.bJx = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.bJb = new TbRichTextEmotionInfo();
                    this.bJb.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.bJb.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.bJb.mGifInfo.mStaticUrl = pbContent._static;
                    this.bJb.mType = this.mType;
                    this.bJb.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.bJb.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.bJb.mGifInfo.mPackageName = pbContent.packet_name;
                    this.bJb.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.bJb.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.bJb.mGifInfo.mGid = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.bJb.mGifInfo.mGid = split[i].split("_")[0];
                case 20:
                    this.bJf = new TbRichTextMemeInfo();
                    this.bJf.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.bcv = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.bJe = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case 1280:
                    this.bJd = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.bJc = new f();
                        this.bJc.b(pbContent);
                        break;
                    }
                    this.bJx = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.LQ().gb(this.bJx.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(d.j.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.bJx.setText(str);
                            break;
                        } else {
                            this.bJx.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.bJx.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.bJx != null) {
                this.bJx.QH();
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
                this.bIY = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.bcv = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.bJx = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.bJb = new TbRichTextEmotionInfo();
                this.bJb.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.bJb.mGifInfo.mDynamicUrl = jSONObject.optString("dynamic");
                this.bJb.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.bJb.mType = this.mType;
                this.bJb.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.bJb.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.bJb.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.bJb.mGifInfo.mIcon = jSONObject.optString("icon");
                String[] split = this.bJb.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.bJb.mGifInfo.mGid = split[i].split("_")[0];
            } else {
                this.bJx = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int gb = TbFaceManager.LQ().gb(this.bJx.getText());
                    String optString = jSONObject.optString("c");
                    if (gb <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(d.j.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.bJx.setText(str);
                    } else {
                        this.bJx.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.bJx.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.bJx != null) {
                this.bJx.QH();
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
