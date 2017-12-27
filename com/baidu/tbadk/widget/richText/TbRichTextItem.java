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
    private TbRichTextMemeInfo bIP;
    private int mType = 0;
    private TbRichTextCommInfo bJh = null;
    private TbRichTextImageInfo bII = null;
    private TbRichTextVoiceInfo bcn = null;
    private TbRichTextEmotionInfo bIL = null;
    private f bIM = null;
    private TbRichTextLinkButtonInfo bIO = null;
    private TbRichTextLinkImageInfo bIN = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.bJh = tbRichTextCommInfo;
        this.bII = tbRichTextImageInfo;
        this.bcn = tbRichTextVoiceInfo;
        this.bIL = tbRichTextEmotionInfo;
        this.bIO = tbRichTextLinkButtonInfo;
        this.bIN = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo Rb() {
        if (this.mType == 1280) {
            return this.bIN;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo Rc() {
        if (this.mType == 1024) {
            return this.bIO;
        }
        return null;
    }

    public TbRichTextImageInfo QT() {
        if (this.mType == 8) {
            return this.bII;
        }
        return null;
    }

    public f QX() {
        if (this.mType != 32) {
            return null;
        }
        return this.bIM;
    }

    public TbRichTextVoiceInfo QV() {
        if (this.mType == 512 || this.mType == 768) {
            return this.bcn;
        }
        return null;
    }

    public TbRichTextEmotionInfo QY() {
        if (this.mType == 17) {
            return this.bIL;
        }
        return null;
    }

    public TbRichTextMemeInfo QZ() {
        if (this.mType == 20) {
            return this.bIP;
        }
        return null;
    }

    private SpannableString Rn() {
        if (this.mType != 1 || this.bJh == null) {
            return null;
        }
        return new SpannableString(this.bJh.getText());
    }

    private CharSequence u(ArrayList<b> arrayList) {
        SpannableString b;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.bJh != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(d.j.video_text));
            CharSequence w = w(arrayList);
            if (w != null) {
                spannableStringBuilder.append(w);
            }
            if (this.bJh.QO() == 1) {
                b = b(this.mType, this.bJh.getText(), this.bJh.QP(), 0);
            } else {
                b = b(this.mType, this.bJh.getText(), this.bJh.getText(), 0);
            }
            if (b != null) {
                spannableStringBuilder.append((CharSequence) b);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence v(ArrayList<b> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.bJh != null) {
            CharSequence w = w(arrayList);
            if (w != null) {
                spannableStringBuilder.append(w);
            }
            SpannableString b = b(this.mType, this.bJh.getLink(), this.bJh.getLink(), 0);
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
        if (this.mType != 32 || this.bJh == null) {
            return null;
        }
        if (this.bJh.QO() == 1) {
            return this.bJh.QP();
        }
        return this.bJh.getText();
    }

    private SpannableString Ro() {
        if ((this.mType != 2 && this.mType != 18) || this.bJh == null) {
            return null;
        }
        if (this.bJh.QO() == 1) {
            return b(this.mType, this.bJh.getText(), this.bJh.QP(), 0);
        }
        return b(this.mType, this.bJh.getText(), this.bJh.getLink(), this.bJh.QQ());
    }

    private SpannableString Rp() {
        if (this.mType != 256 || this.bJh == null) {
            return null;
        }
        String text = this.bJh.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = text + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        c cVar = new c(this.mType, text);
        cVar.hi(this.bJh.getLink());
        spannableString.setSpan(cVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString Rq() {
        if (this.mType != 16 || this.bJh == null) {
            return null;
        }
        return b(this.mType, this.bJh.getText(), this.bJh.getLink(), 0);
    }

    private SpannableString x(ArrayList<b> arrayList) {
        String text;
        int fS;
        a.C0085a gr;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.bJh != null && this.bJh.getText() != null && this.bJh.getLink() != null && (fS = TbFaceManager.Ma().fS((text = this.bJh.getText()))) != 0) {
            String str = "#(" + TbFaceManager.Ma().fU(text) + ")";
            spannableString = new SpannableString(str + " ");
            b bVar = new b(TbadkCoreApplication.getInst().getContext(), fS);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            if (TbFaceManager.Ma().gr(text) != null) {
                int width = (int) (0.5d * gr.getWidth());
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
            cVar.jd(i2);
            if (i2 == 1) {
                cVar.setTextColor(d.C0108d.cp_cont_d);
            } else {
                cVar.setTextColor(-1);
            }
            spannableString.setSpan(cVar, 0, str.length() - 1, 33);
        }
        return spannableString;
    }

    private SpannableString Rr() {
        if (this.mType != 1024 || this.bIO == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString("a");
        Drawable jf = d.jf(this.bIO.btn_type);
        jf.setBounds(0, 0, jf.getIntrinsicWidth(), jf.getIntrinsicHeight());
        com.baidu.tbadk.widget.f fVar = new com.baidu.tbadk.widget.f(jf);
        fVar.setVerticalOffset(l.s(TbadkCoreApplication.getInst().getContext(), d.e.ds4));
        spannableString.setSpan(fVar, 0, 1, 33);
        spannableString.setSpan(new c(1024, this.bIO.link), spannableString.length() - 1, "a".length(), 33);
        return spannableString;
    }

    public CharSequence y(ArrayList<b> arrayList) {
        switch (this.mType) {
            case 1:
                return Rn();
            case 2:
                return Ro();
            case 4:
                return x(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return Rq();
            case 18:
                return Ro();
            case 32:
                return u(arrayList);
            case 128:
                return v(arrayList);
            case 256:
                return Rp();
            case 1024:
                return Rr();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.bIM.RB() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = je(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.bII = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.bJh = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.bIL = new TbRichTextEmotionInfo();
                    this.bIL.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.bIL.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.bIL.mGifInfo.mStaticUrl = pbContent._static;
                    this.bIL.mType = this.mType;
                    this.bIL.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.bIL.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.bIL.mGifInfo.mPackageName = pbContent.packet_name;
                    this.bIL.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.bIL.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.bIL.mGifInfo.mGid = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.bIL.mGifInfo.mGid = split[i].split("_")[0];
                case 20:
                    this.bIP = new TbRichTextMemeInfo();
                    this.bIP.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.bcn = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.bIO = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case 1280:
                    this.bIN = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.bIM = new f();
                        this.bIM.b(pbContent);
                        break;
                    }
                    this.bJh = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.Ma().fS(this.bJh.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(d.j.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.bJh.setText(str);
                            break;
                        } else {
                            this.bJh.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.bJh.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.bJh != null) {
                this.bJh.QR();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = je(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.bII = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.bcn = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.bJh = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.bIL = new TbRichTextEmotionInfo();
                this.bIL.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.bIL.mGifInfo.mDynamicUrl = jSONObject.optString("dynamic");
                this.bIL.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.bIL.mType = this.mType;
                this.bIL.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.bIL.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.bIL.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.bIL.mGifInfo.mIcon = jSONObject.optString("icon");
                String[] split = this.bIL.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.bIL.mGifInfo.mGid = split[i].split("_")[0];
            } else {
                this.bJh = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int fS = TbFaceManager.Ma().fS(this.bJh.getText());
                    String optString = jSONObject.optString("c");
                    if (fS <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(d.j.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.bJh.setText(str);
                    } else {
                        this.bJh.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.bJh.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.bJh != null) {
                this.bJh.QR();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int je(int i) {
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
