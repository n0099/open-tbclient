package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
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
    private TbRichTextGraffitiInfo aQE;
    private TbRichTextMemeInfo aQF;
    private int mType = 0;
    private TbRichTextCommInfo aQU = null;
    private TbRichTextImageInfo aQx = null;
    private TbRichTextVoiceInfo aoN = null;
    private TbRichTextEmotionInfo aQA = null;
    private e aQB = null;
    private TbRichTextLinkButtonInfo aQD = null;
    private TbRichTextLinkImageInfo aQC = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.aQU = tbRichTextCommInfo;
        this.aQx = tbRichTextImageInfo;
        this.aoN = tbRichTextVoiceInfo;
        this.aQA = tbRichTextEmotionInfo;
        this.aQD = tbRichTextLinkButtonInfo;
        this.aQC = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo IJ() {
        if (this.mType == 1280) {
            return this.aQC;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo IK() {
        if (this.mType == 1024) {
            return this.aQD;
        }
        return null;
    }

    public TbRichTextImageInfo IB() {
        if (this.mType == 8) {
            return this.aQx;
        }
        return null;
    }

    public e IF() {
        if (this.mType != 32) {
            return null;
        }
        return this.aQB;
    }

    public TbRichTextVoiceInfo ID() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aoN;
        }
        return null;
    }

    public TbRichTextEmotionInfo IG() {
        if (this.mType == 17) {
            return this.aQA;
        }
        return null;
    }

    public TbRichTextMemeInfo IH() {
        if (this.mType == 20) {
            return this.aQF;
        }
        return null;
    }

    public TbRichTextGraffitiInfo IL() {
        if (this.mType == 1536) {
            return this.aQE;
        }
        return null;
    }

    private SpannableString IT() {
        if (this.mType != 1 || this.aQU == null) {
            return null;
        }
        return new SpannableString(this.aQU.getText());
    }

    private CharSequence t(ArrayList<a> arrayList) {
        SpannableString b;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.aQU != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(d.l.video_text));
            CharSequence v = v(arrayList);
            if (v != null) {
                spannableStringBuilder.append(v);
            }
            if (this.aQU.Iw() == 1) {
                b = b(this.mType, this.aQU.getText(), this.aQU.Ix(), 0);
            } else {
                b = b(this.mType, this.aQU.getText(), this.aQU.getText(), 0);
            }
            if (b != null) {
                spannableStringBuilder.append((CharSequence) b);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence u(ArrayList<a> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.aQU != null) {
            CharSequence v = v(arrayList);
            if (v != null) {
                spannableStringBuilder.append(v);
            }
            SpannableString b = b(this.mType, this.aQU.getLink(), this.aQU.getLink(), 0);
            if (b != null) {
                spannableStringBuilder.append((CharSequence) b);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence v(ArrayList<a> arrayList) {
        TbRichTextItem tbRichTextItem = new TbRichTextItem();
        tbRichTextItem.a(4, new TbRichTextCommInfo("video_icon", " "), null, null, null, null, null);
        return tbRichTextItem.x(arrayList);
    }

    public String getVideoUrl() {
        if (this.mType != 32 || this.aQU == null) {
            return null;
        }
        if (this.aQU.Iw() == 1) {
            return this.aQU.Ix();
        }
        return this.aQU.getText();
    }

    private SpannableString IU() {
        if ((this.mType != 2 && this.mType != 18) || this.aQU == null) {
            return null;
        }
        if (this.aQU.Iw() == 1) {
            return b(this.mType, this.aQU.getText(), this.aQU.Ix(), 0);
        }
        return b(this.mType, this.aQU.getText(), this.aQU.getLink(), this.aQU.Iy());
    }

    private SpannableString IV() {
        if (this.mType != 256 || this.aQU == null) {
            return null;
        }
        String text = this.aQU.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = text + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        b bVar = new b(this.mType, text);
        bVar.gY(this.aQU.getLink());
        spannableString.setSpan(bVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString IW() {
        if (this.mType != 16 || this.aQU == null) {
            return null;
        }
        return b(this.mType, this.aQU.getText(), this.aQU.getLink(), 0);
    }

    private SpannableString w(ArrayList<a> arrayList) {
        String text;
        int fG;
        a.C0060a gh;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.aQU != null && this.aQU.getText() != null && this.aQU.getLink() != null && (fG = TbFaceManager.Eu().fG((text = this.aQU.getText()))) != 0) {
            String str = "#(" + TbFaceManager.Eu().fI(text) + ")";
            spannableString = new SpannableString(str + " ");
            a aVar = new a(TbadkCoreApplication.getInst().getContext(), fG);
            if (arrayList != null) {
                arrayList.add(aVar);
            }
            if (TbFaceManager.Eu().gh(text) != null) {
                int width = (int) (0.5d * gh.getWidth());
                aVar.setBounds(new Rect(0, 0, width, width));
            } else {
                aVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new com.baidu.tbadk.widget.c(aVar), 0, str.length(), 33);
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
            bVar.fC(i2);
            if (i2 == 1) {
                bVar.setTextColor(d.e.cp_cont_d);
            } else {
                bVar.setTextColor(-1);
            }
            spannableString.setSpan(bVar, 0, str.length() - 1, 33);
        }
        return spannableString;
    }

    private SpannableString IX() {
        if (this.mType != 1024 || this.aQD == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString("a");
        Drawable fE = c.fE(this.aQD.btn_type);
        fE.setBounds(0, 0, fE.getIntrinsicWidth(), fE.getIntrinsicHeight());
        com.baidu.tbadk.widget.c cVar = new com.baidu.tbadk.widget.c(fE);
        cVar.setVerticalOffset(k.g(TbadkCoreApplication.getInst().getContext(), d.f.ds4));
        spannableString.setSpan(cVar, 0, 1, 33);
        spannableString.setSpan(new b(1024, this.aQD.link), spannableString.length() - 1, "a".length(), 33);
        return spannableString;
    }

    public CharSequence x(ArrayList<a> arrayList) {
        switch (this.mType) {
            case 1:
                return IT();
            case 2:
                return IU();
            case 4:
                return w(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return IW();
            case 18:
                return IU();
            case 32:
                return t(arrayList);
            case 128:
                return u(arrayList);
            case 256:
                return IV();
            case 1024:
                return IX();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.aQB.Jh() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = fD(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.aQx = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.aQU = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.aQA = new TbRichTextEmotionInfo();
                    this.aQA.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.aQA.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.aQA.mGifInfo.mStaticUrl = pbContent._static;
                    this.aQA.mType = this.mType;
                    this.aQA.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.aQA.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.aQA.mGifInfo.mPackageName = pbContent.packet_name;
                    this.aQA.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.aQA.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.aQA.mGifInfo.mGid = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.aQA.mGifInfo.mGid = split[i].split("_")[0];
                case 20:
                    this.aQF = new TbRichTextMemeInfo();
                    this.aQF.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.aoN = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.aQD = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case 1280:
                    this.aQC = new TbRichTextLinkImageInfo(pbContent);
                    break;
                case 1536:
                    this.aQE = new TbRichTextGraffitiInfo();
                    this.aQE.a(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.aQB = new e();
                        this.aQB.a(pbContent);
                        break;
                    }
                    this.aQU = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.Eu().fG(this.aQU.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(d.l.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.aQU.setText(str);
                            break;
                        } else {
                            this.aQU.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.aQU.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.aQU != null) {
                this.aQU.Iz();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = fD(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.aQx = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.aoN = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.aQU = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString(SapiAccountManager.SESSION_UID));
            } else if (this.mType == 17) {
                this.aQA = new TbRichTextEmotionInfo();
                this.aQA.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.aQA.mGifInfo.mDynamicUrl = jSONObject.optString("dynamic");
                this.aQA.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.aQA.mType = this.mType;
                this.aQA.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.aQA.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.aQA.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.aQA.mGifInfo.mIcon = jSONObject.optString("icon");
                String[] split = this.aQA.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.aQA.mGifInfo.mGid = split[i].split("_")[0];
            } else {
                this.aQU = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int fG = TbFaceManager.Eu().fG(this.aQU.getText());
                    String optString = jSONObject.optString("c");
                    if (fG <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(d.l.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.aQU.setText(str);
                    } else {
                        this.aQU.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.aQU.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.aQU != null) {
                this.aQU.Iz();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int fD(int i) {
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
            case 16:
                return 1536;
            case 18:
                return 18;
            case 20:
                return 20;
        }
    }
}
