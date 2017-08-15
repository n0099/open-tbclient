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
    private TbRichTextGraffitiInfo aQU;
    private TbRichTextMemeInfo aQV;
    private int mType = 0;
    private TbRichTextCommInfo aRk = null;
    private TbRichTextImageInfo aQN = null;
    private TbRichTextVoiceInfo aph = null;
    private TbRichTextEmotionInfo aQQ = null;
    private e aQR = null;
    private TbRichTextLinkButtonInfo aQT = null;
    private TbRichTextLinkImageInfo aQS = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.aRk = tbRichTextCommInfo;
        this.aQN = tbRichTextImageInfo;
        this.aph = tbRichTextVoiceInfo;
        this.aQQ = tbRichTextEmotionInfo;
        this.aQT = tbRichTextLinkButtonInfo;
        this.aQS = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo IB() {
        if (this.mType == 1280) {
            return this.aQS;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo IC() {
        if (this.mType == 1024) {
            return this.aQT;
        }
        return null;
    }

    public TbRichTextImageInfo It() {
        if (this.mType == 8) {
            return this.aQN;
        }
        return null;
    }

    public e Ix() {
        if (this.mType != 32) {
            return null;
        }
        return this.aQR;
    }

    public TbRichTextVoiceInfo Iv() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aph;
        }
        return null;
    }

    public TbRichTextEmotionInfo Iy() {
        if (this.mType == 17) {
            return this.aQQ;
        }
        return null;
    }

    public TbRichTextMemeInfo Iz() {
        if (this.mType == 20) {
            return this.aQV;
        }
        return null;
    }

    public TbRichTextGraffitiInfo ID() {
        if (this.mType == 1536) {
            return this.aQU;
        }
        return null;
    }

    private SpannableString IL() {
        if (this.mType != 1 || this.aRk == null) {
            return null;
        }
        return new SpannableString(this.aRk.getText());
    }

    private CharSequence t(ArrayList<a> arrayList) {
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.aRk != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(d.l.video_text));
            CharSequence v = v(arrayList);
            if (v != null) {
                spannableStringBuilder.append(v);
            }
            if (this.aRk.Ip() == 1) {
                a = a(this.mType, this.aRk.getText(), this.aRk.Iq(), 0);
            } else {
                a = a(this.mType, this.aRk.getText(), this.aRk.getText(), 0);
            }
            if (a != null) {
                spannableStringBuilder.append((CharSequence) a);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence u(ArrayList<a> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.aRk != null) {
            CharSequence v = v(arrayList);
            if (v != null) {
                spannableStringBuilder.append(v);
            }
            SpannableString a = a(this.mType, this.aRk.getLink(), this.aRk.getLink(), 0);
            if (a != null) {
                spannableStringBuilder.append((CharSequence) a);
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
        if (this.mType != 32 || this.aRk == null) {
            return null;
        }
        if (this.aRk.Ip() == 1) {
            return this.aRk.Iq();
        }
        return this.aRk.getText();
    }

    private SpannableString IM() {
        if ((this.mType != 2 && this.mType != 18) || this.aRk == null) {
            return null;
        }
        if (this.aRk.Ip() == 1) {
            return a(this.mType, this.aRk.getText(), this.aRk.Iq(), 0);
        }
        return a(this.mType, this.aRk.getText(), this.aRk.getLink(), this.aRk.Ir());
    }

    private SpannableString IN() {
        if (this.mType != 256 || this.aRk == null) {
            return null;
        }
        String text = this.aRk.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = text + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        b bVar = new b(this.mType, text);
        bVar.gZ(this.aRk.getLink());
        spannableString.setSpan(bVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString IO() {
        if (this.mType != 16 || this.aRk == null) {
            return null;
        }
        return a(this.mType, this.aRk.getText(), this.aRk.getLink(), 0);
    }

    private SpannableString w(ArrayList<a> arrayList) {
        String text;
        int fH;
        a.C0057a gj;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.aRk != null && this.aRk.getText() != null && this.aRk.getLink() != null && (fH = TbFaceManager.Ew().fH((text = this.aRk.getText()))) != 0) {
            String str = "#(" + TbFaceManager.Ew().fJ(text) + ")";
            spannableString = new SpannableString(str + " ");
            a aVar = new a(TbadkCoreApplication.getInst().getContext(), fH);
            if (arrayList != null) {
                arrayList.add(aVar);
            }
            if (TbFaceManager.Ew().gj(text) != null) {
                int width = (int) (0.5d * gj.getWidth());
                aVar.setBounds(new Rect(0, 0, width, width));
            } else {
                aVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new com.baidu.tbadk.widget.c(aVar), 0, str.length(), 33);
        }
        return spannableString;
    }

    private SpannableString a(int i, String str, String str2, int i2) {
        SpannableString spannableString = null;
        if (str != null) {
            if (!str.endsWith(" ")) {
                str = str + " ";
            }
            spannableString = new SpannableString(str);
            b bVar = new b(i, str2);
            bVar.fB(i2);
            if (i2 == 1) {
                bVar.setTextColor(d.e.cp_cont_d);
            } else {
                bVar.setTextColor(-1);
            }
            spannableString.setSpan(bVar, 0, str.length() - 1, 33);
        }
        return spannableString;
    }

    private SpannableString IP() {
        if (this.mType != 1024 || this.aQT == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString("a");
        Drawable fD = c.fD(this.aQT.btn_type);
        fD.setBounds(0, 0, fD.getIntrinsicWidth(), fD.getIntrinsicHeight());
        com.baidu.tbadk.widget.c cVar = new com.baidu.tbadk.widget.c(fD);
        cVar.setVerticalOffset(k.g(TbadkCoreApplication.getInst().getContext(), d.f.ds4));
        spannableString.setSpan(cVar, 0, 1, 33);
        spannableString.setSpan(new b(1024, this.aQT.link), spannableString.length() - 1, "a".length(), 33);
        return spannableString;
    }

    public CharSequence x(ArrayList<a> arrayList) {
        switch (this.mType) {
            case 1:
                return IL();
            case 2:
                return IM();
            case 4:
                return w(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return IO();
            case 18:
                return IM();
            case 32:
                return t(arrayList);
            case 128:
                return u(arrayList);
            case 256:
                return IN();
            case 1024:
                return IP();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.aQR.IZ() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = fC(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.aQN = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.aRk = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.aQQ = new TbRichTextEmotionInfo();
                    this.aQQ.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.aQQ.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.aQQ.mGifInfo.mStaticUrl = pbContent._static;
                    this.aQQ.mType = this.mType;
                    this.aQQ.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.aQQ.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.aQQ.mGifInfo.mPackageName = pbContent.packet_name;
                    this.aQQ.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.aQQ.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.aQQ.mGifInfo.mGid = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.aQQ.mGifInfo.mGid = split[i].split("_")[0];
                case 20:
                    this.aQV = new TbRichTextMemeInfo();
                    this.aQV.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.aph = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.aQT = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case 1280:
                    this.aQS = new TbRichTextLinkImageInfo(pbContent);
                    break;
                case 1536:
                    this.aQU = new TbRichTextGraffitiInfo();
                    this.aQU.a(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.aQR = new e();
                        this.aQR.a(pbContent);
                        break;
                    }
                    this.aRk = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.Ew().fH(this.aRk.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(d.l.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.aRk.setText(str);
                            break;
                        } else {
                            this.aRk.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.aRk.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.aRk != null) {
                this.aRk.bn();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = fC(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.aQN = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.aph = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.aRk = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString(SapiAccountManager.SESSION_UID));
            } else if (this.mType == 17) {
                this.aQQ = new TbRichTextEmotionInfo();
                this.aQQ.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.aQQ.mGifInfo.mDynamicUrl = jSONObject.optString("dynamic");
                this.aQQ.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.aQQ.mType = this.mType;
                this.aQQ.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.aQQ.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.aQQ.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.aQQ.mGifInfo.mIcon = jSONObject.optString("icon");
                String[] split = this.aQQ.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.aQQ.mGifInfo.mGid = split[i].split("_")[0];
            } else {
                this.aRk = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int fH = TbFaceManager.Ew().fH(this.aRk.getText());
                    String optString = jSONObject.optString("c");
                    if (fH <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(d.l.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.aRk.setText(str);
                    } else {
                        this.aRk.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.aRk.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.aRk != null) {
                this.aRk.bn();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int fC(int i) {
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
