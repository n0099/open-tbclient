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
    private TbRichTextMemeInfo aRD;
    private int mType = 0;
    private TbRichTextCommInfo aRS = null;
    private TbRichTextImageInfo aRw = null;
    private TbRichTextVoiceInfo anS = null;
    private TbRichTextEmotionInfo aRz = null;
    private e aRA = null;
    private TbRichTextLinkButtonInfo aRC = null;
    private TbRichTextLinkImageInfo aRB = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.aRS = tbRichTextCommInfo;
        this.aRw = tbRichTextImageInfo;
        this.anS = tbRichTextVoiceInfo;
        this.aRz = tbRichTextEmotionInfo;
        this.aRC = tbRichTextLinkButtonInfo;
        this.aRB = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo IR() {
        if (this.mType == 1280) {
            return this.aRB;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo IS() {
        if (this.mType == 1024) {
            return this.aRC;
        }
        return null;
    }

    public TbRichTextImageInfo IJ() {
        if (this.mType == 8) {
            return this.aRw;
        }
        return null;
    }

    public e IN() {
        if (this.mType != 32) {
            return null;
        }
        return this.aRA;
    }

    public TbRichTextVoiceInfo IL() {
        if (this.mType == 512 || this.mType == 768) {
            return this.anS;
        }
        return null;
    }

    public TbRichTextEmotionInfo IO() {
        if (this.mType == 17) {
            return this.aRz;
        }
        return null;
    }

    public TbRichTextMemeInfo IP() {
        if (this.mType == 20) {
            return this.aRD;
        }
        return null;
    }

    private SpannableString Jc() {
        if (this.mType != 1 || this.aRS == null) {
            return null;
        }
        return new SpannableString(this.aRS.getText());
    }

    private CharSequence s(ArrayList<a> arrayList) {
        SpannableString b;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.aRS != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(d.l.video_text));
            CharSequence u = u(arrayList);
            if (u != null) {
                spannableStringBuilder.append(u);
            }
            if (this.aRS.IE() == 1) {
                b = b(this.mType, this.aRS.getText(), this.aRS.IF(), 0);
            } else {
                b = b(this.mType, this.aRS.getText(), this.aRS.getText(), 0);
            }
            if (b != null) {
                spannableStringBuilder.append((CharSequence) b);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence t(ArrayList<a> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.aRS != null) {
            CharSequence u = u(arrayList);
            if (u != null) {
                spannableStringBuilder.append(u);
            }
            SpannableString b = b(this.mType, this.aRS.getLink(), this.aRS.getLink(), 0);
            if (b != null) {
                spannableStringBuilder.append((CharSequence) b);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence u(ArrayList<a> arrayList) {
        TbRichTextItem tbRichTextItem = new TbRichTextItem();
        tbRichTextItem.a(4, new TbRichTextCommInfo("video_icon", " "), null, null, null, null, null);
        return tbRichTextItem.w(arrayList);
    }

    public String getVideoUrl() {
        if (this.mType != 32 || this.aRS == null) {
            return null;
        }
        if (this.aRS.IE() == 1) {
            return this.aRS.IF();
        }
        return this.aRS.getText();
    }

    private SpannableString Jd() {
        if ((this.mType != 2 && this.mType != 18) || this.aRS == null) {
            return null;
        }
        if (this.aRS.IE() == 1) {
            return b(this.mType, this.aRS.getText(), this.aRS.IF(), 0);
        }
        return b(this.mType, this.aRS.getText(), this.aRS.getLink(), this.aRS.IG());
    }

    private SpannableString Je() {
        if (this.mType != 256 || this.aRS == null) {
            return null;
        }
        String text = this.aRS.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = text + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        b bVar = new b(this.mType, text);
        bVar.gW(this.aRS.getLink());
        spannableString.setSpan(bVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString Jf() {
        if (this.mType != 16 || this.aRS == null) {
            return null;
        }
        return b(this.mType, this.aRS.getText(), this.aRS.getLink(), 0);
    }

    private SpannableString v(ArrayList<a> arrayList) {
        String text;
        int fz;
        a.C0058a gb;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.aRS != null && this.aRS.getText() != null && this.aRS.getLink() != null && (fz = TbFaceManager.DY().fz((text = this.aRS.getText()))) != 0) {
            String str = "#(" + TbFaceManager.DY().fB(text) + ")";
            spannableString = new SpannableString(str + " ");
            a aVar = new a(TbadkCoreApplication.getInst().getContext(), fz);
            if (arrayList != null) {
                arrayList.add(aVar);
            }
            if (TbFaceManager.DY().gb(text) != null) {
                int width = (int) (0.5d * gb.getWidth());
                aVar.setBounds(new Rect(0, 0, width, width));
            } else {
                aVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new com.baidu.tbadk.widget.e(aVar), 0, str.length(), 33);
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
            b bVar = new b(i, str2);
            bVar.fP(i2);
            if (i2 == 1) {
                bVar.setTextColor(d.e.cp_cont_d);
            } else {
                bVar.setTextColor(-1);
            }
            spannableString.setSpan(bVar, 0, str.length() - 1, 33);
        }
        return spannableString;
    }

    private SpannableString Jg() {
        if (this.mType != 1024 || this.aRC == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString("a");
        Drawable fR = c.fR(this.aRC.btn_type);
        fR.setBounds(0, 0, fR.getIntrinsicWidth(), fR.getIntrinsicHeight());
        com.baidu.tbadk.widget.e eVar = new com.baidu.tbadk.widget.e(fR);
        eVar.setVerticalOffset(l.f(TbadkCoreApplication.getInst().getContext(), d.f.ds4));
        spannableString.setSpan(eVar, 0, 1, 33);
        spannableString.setSpan(new b(1024, this.aRC.link), spannableString.length() - 1, "a".length(), 33);
        return spannableString;
    }

    public CharSequence w(ArrayList<a> arrayList) {
        switch (this.mType) {
            case 1:
                return Jc();
            case 2:
                return Jd();
            case 4:
                return v(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return Jf();
            case 18:
                return Jd();
            case 32:
                return s(arrayList);
            case 128:
                return t(arrayList);
            case 256:
                return Je();
            case 1024:
                return Jg();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.aRA.Jq() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = fQ(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.aRw = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.aRS = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.aRz = new TbRichTextEmotionInfo();
                    this.aRz.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.aRz.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.aRz.mGifInfo.mStaticUrl = pbContent._static;
                    this.aRz.mType = this.mType;
                    this.aRz.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.aRz.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.aRz.mGifInfo.mPackageName = pbContent.packet_name;
                    this.aRz.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.aRz.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.aRz.mGifInfo.mGid = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.aRz.mGifInfo.mGid = split[i].split("_")[0];
                case 20:
                    this.aRD = new TbRichTextMemeInfo();
                    this.aRD.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.anS = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.aRC = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case 1280:
                    this.aRB = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.aRA = new e();
                        this.aRA.b(pbContent);
                        break;
                    }
                    this.aRS = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.DY().fz(this.aRS.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(d.l.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.aRS.setText(str);
                            break;
                        } else {
                            this.aRS.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.aRS.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.aRS != null) {
                this.aRS.IH();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = fQ(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.aRw = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.anS = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.aRS = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString(SapiAccountManager.SESSION_UID));
            } else if (this.mType == 17) {
                this.aRz = new TbRichTextEmotionInfo();
                this.aRz.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.aRz.mGifInfo.mDynamicUrl = jSONObject.optString("dynamic");
                this.aRz.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.aRz.mType = this.mType;
                this.aRz.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.aRz.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.aRz.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.aRz.mGifInfo.mIcon = jSONObject.optString("icon");
                String[] split = this.aRz.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.aRz.mGifInfo.mGid = split[i].split("_")[0];
            } else {
                this.aRS = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int fz = TbFaceManager.DY().fz(this.aRS.getText());
                    String optString = jSONObject.optString("c");
                    if (fz <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(d.l.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.aRS.setText(str);
                    } else {
                        this.aRS.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.aRS.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.aRS != null) {
                this.aRS.IH();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int fQ(int i) {
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
