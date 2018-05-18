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
    private TbRichTextMemeInfo aVQ;
    private int mType = 0;
    private TbRichTextCommInfo aWh = null;
    private TbRichTextImageInfo aVJ = null;
    private TbRichTextVoiceInfo apt = null;
    private TbRichTextEmotionInfo aVM = null;
    private f aVN = null;
    private TbRichTextLinkButtonInfo aVP = null;
    private TbRichTextLinkImageInfo aVO = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.aWh = tbRichTextCommInfo;
        this.aVJ = tbRichTextImageInfo;
        this.apt = tbRichTextVoiceInfo;
        this.aVM = tbRichTextEmotionInfo;
        this.aVP = tbRichTextLinkButtonInfo;
        this.aVO = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo JV() {
        if (this.mType == 1280) {
            return this.aVO;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo JW() {
        if (this.mType == 1024) {
            return this.aVP;
        }
        return null;
    }

    public TbRichTextImageInfo JN() {
        if (this.mType == 8) {
            return this.aVJ;
        }
        return null;
    }

    public f JR() {
        if (this.mType != 32) {
            return null;
        }
        return this.aVN;
    }

    public TbRichTextVoiceInfo JP() {
        if (this.mType == 512 || this.mType == 768) {
            return this.apt;
        }
        return null;
    }

    public TbRichTextEmotionInfo JS() {
        if (this.mType == 17) {
            return this.aVM;
        }
        return null;
    }

    public TbRichTextMemeInfo JT() {
        if (this.mType == 20) {
            return this.aVQ;
        }
        return null;
    }

    private SpannableString Kg() {
        if (this.mType != 1 || this.aWh == null) {
            return null;
        }
        return new SpannableString(this.aWh.getText());
    }

    private CharSequence t(ArrayList<b> arrayList) {
        SpannableString b;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.aWh != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(d.k.video_text));
            CharSequence v = v(arrayList);
            if (v != null) {
                spannableStringBuilder.append(v);
            }
            if (this.aWh.JI() == 1) {
                b = b(this.mType, this.aWh.getText(), this.aWh.JJ(), 0);
            } else {
                b = b(this.mType, this.aWh.getText(), this.aWh.getText(), 0);
            }
            if (b != null) {
                spannableStringBuilder.append((CharSequence) b);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence u(ArrayList<b> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.aWh != null) {
            CharSequence v = v(arrayList);
            if (v != null) {
                spannableStringBuilder.append(v);
            }
            SpannableString b = b(this.mType, this.aWh.getLink(), this.aWh.getLink(), 0);
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
        if (this.mType != 32 || this.aWh == null) {
            return null;
        }
        if (this.aWh.JI() == 1) {
            return this.aWh.JJ();
        }
        return this.aWh.getText();
    }

    private SpannableString Kh() {
        if ((this.mType != 2 && this.mType != 18) || this.aWh == null) {
            return null;
        }
        if (this.aWh.JI() == 1) {
            return b(this.mType, this.aWh.getText(), this.aWh.JJ(), 0);
        }
        return b(this.mType, this.aWh.getText(), this.aWh.getLink(), this.aWh.JK());
    }

    private SpannableString Ki() {
        if (this.mType != 256 || this.aWh == null) {
            return null;
        }
        String text = this.aWh.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = text + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        c cVar = new c(this.mType, text);
        cVar.hu(this.aWh.getLink());
        spannableString.setSpan(cVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString Kj() {
        if (this.mType != 16 || this.aWh == null) {
            return null;
        }
        return b(this.mType, this.aWh.getText(), this.aWh.getLink(), 0);
    }

    private SpannableString w(ArrayList<b> arrayList) {
        String text;
        int gb;
        a.C0098a gB;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.aWh != null && this.aWh.getText() != null && this.aWh.getLink() != null && (gb = TbFaceManager.EX().gb((text = this.aWh.getText()))) != 0) {
            String str = "#(" + TbFaceManager.EX().gd(text) + ")";
            spannableString = new SpannableString(str + " ");
            b bVar = new b(TbadkCoreApplication.getInst().getContext(), gb);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            if (TbFaceManager.EX().gB(text) != null) {
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
            cVar.fX(i2);
            if (i2 == 1) {
                cVar.setTextColor(d.C0126d.cp_cont_d);
            } else {
                cVar.setTextColor(-1);
            }
            spannableString.setSpan(cVar, 0, str.length() - 1, 33);
        }
        return spannableString;
    }

    private SpannableString Kk() {
        if (this.mType != 1024 || this.aVP == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString("a");
        Drawable fZ = d.fZ(this.aVP.btn_type);
        fZ.setBounds(0, 0, fZ.getIntrinsicWidth(), fZ.getIntrinsicHeight());
        com.baidu.tbadk.widget.c cVar = new com.baidu.tbadk.widget.c(fZ);
        cVar.setVerticalOffset(l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds4));
        spannableString.setSpan(cVar, 0, 1, 33);
        spannableString.setSpan(new c(1024, this.aVP.link), spannableString.length() - 1, "a".length(), 33);
        return spannableString;
    }

    public CharSequence x(ArrayList<b> arrayList) {
        switch (this.mType) {
            case 1:
                return Kg();
            case 2:
                return Kh();
            case 4:
                return w(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return Kj();
            case 18:
                return Kh();
            case 32:
                return t(arrayList);
            case 128:
                return u(arrayList);
            case 256:
                return Ki();
            case 1024:
                return Kk();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.aVN.Ku() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = fY(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.aVJ = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.aWh = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.aVM = new TbRichTextEmotionInfo();
                    this.aVM.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.aVM.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.aVM.mGifInfo.mStaticUrl = pbContent._static;
                    this.aVM.mType = this.mType;
                    this.aVM.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.aVM.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.aVM.mGifInfo.mPackageName = pbContent.packet_name;
                    this.aVM.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.aVM.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.aVM.mGifInfo.mGid = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.aVM.mGifInfo.mGid = split[i].split("_")[0];
                case 20:
                    this.aVQ = new TbRichTextMemeInfo();
                    this.aVQ.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.apt = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.aVP = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case 1280:
                    this.aVO = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.aVN = new f();
                        this.aVN.b(pbContent);
                        break;
                    }
                    this.aWh = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.EX().gb(this.aWh.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(d.k.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.aWh.setText(str);
                            break;
                        } else {
                            this.aWh.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.aWh.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.aWh != null) {
                this.aWh.JL();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = fY(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.aVJ = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.apt = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.aWh = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.aVM = new TbRichTextEmotionInfo();
                this.aVM.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.aVM.mGifInfo.mDynamicUrl = jSONObject.optString("dynamic");
                this.aVM.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.aVM.mType = this.mType;
                this.aVM.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.aVM.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.aVM.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.aVM.mGifInfo.mIcon = jSONObject.optString("icon");
                String[] split = this.aVM.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.aVM.mGifInfo.mGid = split[i].split("_")[0];
            } else {
                this.aWh = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int gb = TbFaceManager.EX().gb(this.aWh.getText());
                    String optString = jSONObject.optString("c");
                    if (gb <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(d.k.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.aWh.setText(str);
                    } else {
                        this.aWh.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.aWh.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.aWh != null) {
                this.aWh.JL();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int fY(int i) {
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
