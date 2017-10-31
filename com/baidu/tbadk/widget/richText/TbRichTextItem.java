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
    private TbRichTextMemeInfo aRQ;
    private int mType = 0;
    private TbRichTextCommInfo aSf = null;
    private TbRichTextImageInfo aRJ = null;
    private TbRichTextVoiceInfo aob = null;
    private TbRichTextEmotionInfo aRM = null;
    private f aRN = null;
    private TbRichTextLinkButtonInfo aRP = null;
    private TbRichTextLinkImageInfo aRO = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.aSf = tbRichTextCommInfo;
        this.aRJ = tbRichTextImageInfo;
        this.aob = tbRichTextVoiceInfo;
        this.aRM = tbRichTextEmotionInfo;
        this.aRP = tbRichTextLinkButtonInfo;
        this.aRO = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo IW() {
        if (this.mType == 1280) {
            return this.aRO;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo IX() {
        if (this.mType == 1024) {
            return this.aRP;
        }
        return null;
    }

    public TbRichTextImageInfo IO() {
        if (this.mType == 8) {
            return this.aRJ;
        }
        return null;
    }

    public f IS() {
        if (this.mType != 32) {
            return null;
        }
        return this.aRN;
    }

    public TbRichTextVoiceInfo IQ() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aob;
        }
        return null;
    }

    public TbRichTextEmotionInfo IT() {
        if (this.mType == 17) {
            return this.aRM;
        }
        return null;
    }

    public TbRichTextMemeInfo IU() {
        if (this.mType == 20) {
            return this.aRQ;
        }
        return null;
    }

    private SpannableString Jh() {
        if (this.mType != 1 || this.aSf == null) {
            return null;
        }
        return new SpannableString(this.aSf.getText());
    }

    private CharSequence t(ArrayList<b> arrayList) {
        SpannableString b;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.aSf != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(d.j.video_text));
            CharSequence v = v(arrayList);
            if (v != null) {
                spannableStringBuilder.append(v);
            }
            if (this.aSf.IJ() == 1) {
                b = b(this.mType, this.aSf.getText(), this.aSf.IK(), 0);
            } else {
                b = b(this.mType, this.aSf.getText(), this.aSf.getText(), 0);
            }
            if (b != null) {
                spannableStringBuilder.append((CharSequence) b);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence u(ArrayList<b> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.aSf != null) {
            CharSequence v = v(arrayList);
            if (v != null) {
                spannableStringBuilder.append(v);
            }
            SpannableString b = b(this.mType, this.aSf.getLink(), this.aSf.getLink(), 0);
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
        if (this.mType != 32 || this.aSf == null) {
            return null;
        }
        if (this.aSf.IJ() == 1) {
            return this.aSf.IK();
        }
        return this.aSf.getText();
    }

    private SpannableString Ji() {
        if ((this.mType != 2 && this.mType != 18) || this.aSf == null) {
            return null;
        }
        if (this.aSf.IJ() == 1) {
            return b(this.mType, this.aSf.getText(), this.aSf.IK(), 0);
        }
        return b(this.mType, this.aSf.getText(), this.aSf.getLink(), this.aSf.IL());
    }

    private SpannableString Jj() {
        if (this.mType != 256 || this.aSf == null) {
            return null;
        }
        String text = this.aSf.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = text + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        c cVar = new c(this.mType, text);
        cVar.hd(this.aSf.getLink());
        spannableString.setSpan(cVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString Jk() {
        if (this.mType != 16 || this.aSf == null) {
            return null;
        }
        return b(this.mType, this.aSf.getText(), this.aSf.getLink(), 0);
    }

    private SpannableString w(ArrayList<b> arrayList) {
        String text;
        int fF;
        a.C0058a gh;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.aSf != null && this.aSf.getText() != null && this.aSf.getLink() != null && (fF = TbFaceManager.Ef().fF((text = this.aSf.getText()))) != 0) {
            String str = "#(" + TbFaceManager.Ef().fH(text) + ")";
            spannableString = new SpannableString(str + " ");
            b bVar = new b(TbadkCoreApplication.getInst().getContext(), fF);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            if (TbFaceManager.Ef().gh(text) != null) {
                int width = (int) (0.5d * gh.getWidth());
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
            cVar.fX(i2);
            if (i2 == 1) {
                cVar.setTextColor(d.C0080d.cp_cont_d);
            } else {
                cVar.setTextColor(-1);
            }
            spannableString.setSpan(cVar, 0, str.length() - 1, 33);
        }
        return spannableString;
    }

    private SpannableString Jl() {
        if (this.mType != 1024 || this.aRP == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString("a");
        Drawable fZ = d.fZ(this.aRP.btn_type);
        fZ.setBounds(0, 0, fZ.getIntrinsicWidth(), fZ.getIntrinsicHeight());
        com.baidu.tbadk.widget.e eVar = new com.baidu.tbadk.widget.e(fZ);
        eVar.setVerticalOffset(l.f(TbadkCoreApplication.getInst().getContext(), d.e.ds4));
        spannableString.setSpan(eVar, 0, 1, 33);
        spannableString.setSpan(new c(1024, this.aRP.link), spannableString.length() - 1, "a".length(), 33);
        return spannableString;
    }

    public CharSequence x(ArrayList<b> arrayList) {
        switch (this.mType) {
            case 1:
                return Jh();
            case 2:
                return Ji();
            case 4:
                return w(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return Jk();
            case 18:
                return Ji();
            case 32:
                return t(arrayList);
            case 128:
                return u(arrayList);
            case 256:
                return Jj();
            case 1024:
                return Jl();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.aRN.Jv() != false) goto L9;
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
                    this.aRJ = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.aSf = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.aRM = new TbRichTextEmotionInfo();
                    this.aRM.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.aRM.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.aRM.mGifInfo.mStaticUrl = pbContent._static;
                    this.aRM.mType = this.mType;
                    this.aRM.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.aRM.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.aRM.mGifInfo.mPackageName = pbContent.packet_name;
                    this.aRM.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.aRM.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.aRM.mGifInfo.mGid = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.aRM.mGifInfo.mGid = split[i].split("_")[0];
                case 20:
                    this.aRQ = new TbRichTextMemeInfo();
                    this.aRQ.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.aob = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.aRP = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case 1280:
                    this.aRO = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.aRN = new f();
                        this.aRN.b(pbContent);
                        break;
                    }
                    this.aSf = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.Ef().fF(this.aSf.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(d.j.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.aSf.setText(str);
                            break;
                        } else {
                            this.aSf.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.aSf.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.aSf != null) {
                this.aSf.IM();
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
                this.aRJ = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.aob = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.aSf = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString(SapiAccountManager.SESSION_UID));
            } else if (this.mType == 17) {
                this.aRM = new TbRichTextEmotionInfo();
                this.aRM.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.aRM.mGifInfo.mDynamicUrl = jSONObject.optString("dynamic");
                this.aRM.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.aRM.mType = this.mType;
                this.aRM.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.aRM.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.aRM.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.aRM.mGifInfo.mIcon = jSONObject.optString("icon");
                String[] split = this.aRM.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.aRM.mGifInfo.mGid = split[i].split("_")[0];
            } else {
                this.aSf = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int fF = TbFaceManager.Ef().fF(this.aSf.getText());
                    String optString = jSONObject.optString("c");
                    if (fF <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(d.j.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.aSf.setText(str);
                    } else {
                        this.aSf.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.aSf.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.aSf != null) {
                this.aSf.IM();
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
