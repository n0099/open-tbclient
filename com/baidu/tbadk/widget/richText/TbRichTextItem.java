package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.d;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextItem extends OrmObject {
    private TbRichTextMemeInfo aUX;
    private int mType = 0;
    private TbRichTextCommInfo aVo = null;
    private TbRichTextImageInfo aUQ = null;
    private TbRichTextVoiceInfo aok = null;
    private TbRichTextEmotionInfo aUT = null;
    private f aUU = null;
    private TbRichTextLinkButtonInfo aUW = null;
    private TbRichTextLinkImageInfo aUV = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.aVo = tbRichTextCommInfo;
        this.aUQ = tbRichTextImageInfo;
        this.aok = tbRichTextVoiceInfo;
        this.aUT = tbRichTextEmotionInfo;
        this.aUW = tbRichTextLinkButtonInfo;
        this.aUV = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo JE() {
        if (this.mType == 1280) {
            return this.aUV;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo JF() {
        if (this.mType == 1024) {
            return this.aUW;
        }
        return null;
    }

    public TbRichTextImageInfo Jw() {
        if (this.mType == 8) {
            return this.aUQ;
        }
        return null;
    }

    public f JA() {
        if (this.mType != 32) {
            return null;
        }
        return this.aUU;
    }

    public TbRichTextVoiceInfo Jy() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aok;
        }
        return null;
    }

    public TbRichTextEmotionInfo JB() {
        if (this.mType == 17) {
            return this.aUT;
        }
        return null;
    }

    public TbRichTextMemeInfo JC() {
        if (this.mType == 20) {
            return this.aUX;
        }
        return null;
    }

    private SpannableString JP() {
        if (this.mType != 1 || this.aVo == null) {
            return null;
        }
        return new SpannableString(this.aVo.getText());
    }

    private CharSequence t(ArrayList<b> arrayList) {
        SpannableString b;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.aVo != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(d.j.video_text));
            CharSequence v = v(arrayList);
            if (v != null) {
                spannableStringBuilder.append(v);
            }
            if (this.aVo.Jr() == 1) {
                b = b(this.mType, this.aVo.getText(), this.aVo.Js(), 0);
            } else {
                b = b(this.mType, this.aVo.getText(), this.aVo.getText(), 0);
            }
            if (b != null) {
                spannableStringBuilder.append((CharSequence) b);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence u(ArrayList<b> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.aVo != null) {
            CharSequence v = v(arrayList);
            if (v != null) {
                spannableStringBuilder.append(v);
            }
            SpannableString b = b(this.mType, this.aVo.getLink(), this.aVo.getLink(), 0);
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
        if (this.mType != 32 || this.aVo == null) {
            return null;
        }
        if (this.aVo.Jr() == 1) {
            return this.aVo.Js();
        }
        return this.aVo.getText();
    }

    private SpannableString JQ() {
        if ((this.mType != 2 && this.mType != 18) || this.aVo == null) {
            return null;
        }
        if (this.aVo.Jr() == 1) {
            return b(this.mType, this.aVo.getText(), this.aVo.Js(), 0);
        }
        return b(this.mType, this.aVo.getText(), this.aVo.getLink(), this.aVo.Jt());
    }

    private SpannableString JR() {
        if (this.mType != 256 || this.aVo == null) {
            return null;
        }
        String text = this.aVo.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = text + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        c cVar = new c(this.mType, text);
        cVar.hh(this.aVo.getLink());
        spannableString.setSpan(cVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString JS() {
        if (this.mType != 16 || this.aVo == null) {
            return null;
        }
        return b(this.mType, this.aVo.getText(), this.aVo.getLink(), 0);
    }

    private SpannableString w(ArrayList<b> arrayList) {
        String text;
        int fM;
        a.C0058a gl;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.aVo != null && this.aVo.getText() != null && this.aVo.getLink() != null && (fM = TbFaceManager.Ey().fM((text = this.aVo.getText()))) != 0) {
            String str = "#(" + TbFaceManager.Ey().fO(text) + ")";
            spannableString = new SpannableString(str + " ");
            b bVar = new b(TbadkCoreApplication.getInst().getContext(), fM);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            if (TbFaceManager.Ey().gl(text) != null) {
                int width = (int) (0.5d * gl.getWidth());
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
                cVar.setTextColor(d.C0082d.cp_cont_d);
            } else {
                cVar.setTextColor(-1);
            }
            spannableString.setSpan(cVar, 0, str.length() - 1, 33);
        }
        return spannableString;
    }

    private SpannableString JT() {
        if (this.mType != 1024 || this.aUW == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString("a");
        Drawable gg = d.gg(this.aUW.btn_type);
        gg.setBounds(0, 0, gg.getIntrinsicWidth(), gg.getIntrinsicHeight());
        com.baidu.tbadk.widget.e eVar = new com.baidu.tbadk.widget.e(gg);
        eVar.setVerticalOffset(l.f(TbadkCoreApplication.getInst().getContext(), d.e.ds4));
        spannableString.setSpan(eVar, 0, 1, 33);
        spannableString.setSpan(new c(1024, this.aUW.link), spannableString.length() - 1, "a".length(), 33);
        return spannableString;
    }

    public CharSequence x(ArrayList<b> arrayList) {
        switch (this.mType) {
            case 1:
                return JP();
            case 2:
                return JQ();
            case 4:
                return w(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return JS();
            case 18:
                return JQ();
            case 32:
                return t(arrayList);
            case 128:
                return u(arrayList);
            case 256:
                return JR();
            case 1024:
                return JT();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.aUU.Kd() != false) goto L9;
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
                    this.aUQ = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.aVo = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.aUT = new TbRichTextEmotionInfo();
                    this.aUT.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.aUT.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.aUT.mGifInfo.mStaticUrl = pbContent._static;
                    this.aUT.mType = this.mType;
                    this.aUT.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.aUT.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.aUT.mGifInfo.mPackageName = pbContent.packet_name;
                    this.aUT.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.aUT.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.aUT.mGifInfo.mGid = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.aUT.mGifInfo.mGid = split[i].split("_")[0];
                case 20:
                    this.aUX = new TbRichTextMemeInfo();
                    this.aUX.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.aok = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.aUW = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case 1280:
                    this.aUV = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.aUU = new f();
                        this.aUU.b(pbContent);
                        break;
                    }
                    this.aVo = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.Ey().fM(this.aVo.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(d.j.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.aVo.setText(str);
                            break;
                        } else {
                            this.aVo.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.aVo.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.aVo != null) {
                this.aVo.Ju();
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
                this.aUQ = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.aok = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.aVo = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString(SapiAccountManager.SESSION_UID));
            } else if (this.mType == 17) {
                this.aUT = new TbRichTextEmotionInfo();
                this.aUT.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.aUT.mGifInfo.mDynamicUrl = jSONObject.optString("dynamic");
                this.aUT.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.aUT.mType = this.mType;
                this.aUT.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.aUT.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.aUT.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.aUT.mGifInfo.mIcon = jSONObject.optString("icon");
                String[] split = this.aUT.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.aUT.mGifInfo.mGid = split[i].split("_")[0];
            } else {
                this.aVo = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int fM = TbFaceManager.Ey().fM(this.aVo.getText());
                    String optString = jSONObject.optString("c");
                    if (fM <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(d.j.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.aVo.setText(str);
                    } else {
                        this.aVo.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.aVo.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.aVo != null) {
                this.aVo.Ju();
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
