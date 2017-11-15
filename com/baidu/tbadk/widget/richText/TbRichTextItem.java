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
    private TbRichTextMemeInfo aRY;
    private int mType = 0;
    private TbRichTextCommInfo aSn = null;
    private TbRichTextImageInfo aRR = null;
    private TbRichTextVoiceInfo aoa = null;
    private TbRichTextEmotionInfo aRU = null;
    private f aRV = null;
    private TbRichTextLinkButtonInfo aRX = null;
    private TbRichTextLinkImageInfo aRW = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.aSn = tbRichTextCommInfo;
        this.aRR = tbRichTextImageInfo;
        this.aoa = tbRichTextVoiceInfo;
        this.aRU = tbRichTextEmotionInfo;
        this.aRX = tbRichTextLinkButtonInfo;
        this.aRW = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo Jh() {
        if (this.mType == 1280) {
            return this.aRW;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo Ji() {
        if (this.mType == 1024) {
            return this.aRX;
        }
        return null;
    }

    public TbRichTextImageInfo IZ() {
        if (this.mType == 8) {
            return this.aRR;
        }
        return null;
    }

    public f Jd() {
        if (this.mType != 32) {
            return null;
        }
        return this.aRV;
    }

    public TbRichTextVoiceInfo Jb() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aoa;
        }
        return null;
    }

    public TbRichTextEmotionInfo Je() {
        if (this.mType == 17) {
            return this.aRU;
        }
        return null;
    }

    public TbRichTextMemeInfo Jf() {
        if (this.mType == 20) {
            return this.aRY;
        }
        return null;
    }

    private SpannableString Js() {
        if (this.mType != 1 || this.aSn == null) {
            return null;
        }
        return new SpannableString(this.aSn.getText());
    }

    private CharSequence t(ArrayList<b> arrayList) {
        SpannableString b;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.aSn != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(d.j.video_text));
            CharSequence v = v(arrayList);
            if (v != null) {
                spannableStringBuilder.append(v);
            }
            if (this.aSn.IU() == 1) {
                b = b(this.mType, this.aSn.getText(), this.aSn.IV(), 0);
            } else {
                b = b(this.mType, this.aSn.getText(), this.aSn.getText(), 0);
            }
            if (b != null) {
                spannableStringBuilder.append((CharSequence) b);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence u(ArrayList<b> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.aSn != null) {
            CharSequence v = v(arrayList);
            if (v != null) {
                spannableStringBuilder.append(v);
            }
            SpannableString b = b(this.mType, this.aSn.getLink(), this.aSn.getLink(), 0);
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
        if (this.mType != 32 || this.aSn == null) {
            return null;
        }
        if (this.aSn.IU() == 1) {
            return this.aSn.IV();
        }
        return this.aSn.getText();
    }

    private SpannableString Jt() {
        if ((this.mType != 2 && this.mType != 18) || this.aSn == null) {
            return null;
        }
        if (this.aSn.IU() == 1) {
            return b(this.mType, this.aSn.getText(), this.aSn.IV(), 0);
        }
        return b(this.mType, this.aSn.getText(), this.aSn.getLink(), this.aSn.IW());
    }

    private SpannableString Ju() {
        if (this.mType != 256 || this.aSn == null) {
            return null;
        }
        String text = this.aSn.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = text + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        c cVar = new c(this.mType, text);
        cVar.he(this.aSn.getLink());
        spannableString.setSpan(cVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString Jv() {
        if (this.mType != 16 || this.aSn == null) {
            return null;
        }
        return b(this.mType, this.aSn.getText(), this.aSn.getLink(), 0);
    }

    private SpannableString w(ArrayList<b> arrayList) {
        String text;
        int fG;
        a.C0058a gi;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.aSn != null && this.aSn.getText() != null && this.aSn.getLink() != null && (fG = TbFaceManager.Er().fG((text = this.aSn.getText()))) != 0) {
            String str = "#(" + TbFaceManager.Er().fI(text) + ")";
            spannableString = new SpannableString(str + " ");
            b bVar = new b(TbadkCoreApplication.getInst().getContext(), fG);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            if (TbFaceManager.Er().gi(text) != null) {
                int width = (int) (0.5d * gi.getWidth());
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
            cVar.fW(i2);
            if (i2 == 1) {
                cVar.setTextColor(d.C0080d.cp_cont_d);
            } else {
                cVar.setTextColor(-1);
            }
            spannableString.setSpan(cVar, 0, str.length() - 1, 33);
        }
        return spannableString;
    }

    private SpannableString Jw() {
        if (this.mType != 1024 || this.aRX == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString("a");
        Drawable fY = d.fY(this.aRX.btn_type);
        fY.setBounds(0, 0, fY.getIntrinsicWidth(), fY.getIntrinsicHeight());
        com.baidu.tbadk.widget.e eVar = new com.baidu.tbadk.widget.e(fY);
        eVar.setVerticalOffset(l.f(TbadkCoreApplication.getInst().getContext(), d.e.ds4));
        spannableString.setSpan(eVar, 0, 1, 33);
        spannableString.setSpan(new c(1024, this.aRX.link), spannableString.length() - 1, "a".length(), 33);
        return spannableString;
    }

    public CharSequence x(ArrayList<b> arrayList) {
        switch (this.mType) {
            case 1:
                return Js();
            case 2:
                return Jt();
            case 4:
                return w(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return Jv();
            case 18:
                return Jt();
            case 32:
                return t(arrayList);
            case 128:
                return u(arrayList);
            case 256:
                return Ju();
            case 1024:
                return Jw();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.aRV.JG() != false) goto L9;
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
                    this.aRR = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.aSn = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.aRU = new TbRichTextEmotionInfo();
                    this.aRU.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.aRU.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.aRU.mGifInfo.mStaticUrl = pbContent._static;
                    this.aRU.mType = this.mType;
                    this.aRU.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.aRU.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.aRU.mGifInfo.mPackageName = pbContent.packet_name;
                    this.aRU.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.aRU.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.aRU.mGifInfo.mGid = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.aRU.mGifInfo.mGid = split[i].split("_")[0];
                case 20:
                    this.aRY = new TbRichTextMemeInfo();
                    this.aRY.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.aoa = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.aRX = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case 1280:
                    this.aRW = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.aRV = new f();
                        this.aRV.b(pbContent);
                        break;
                    }
                    this.aSn = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.Er().fG(this.aSn.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(d.j.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.aSn.setText(str);
                            break;
                        } else {
                            this.aSn.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.aSn.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.aSn != null) {
                this.aSn.IX();
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
                this.aRR = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.aoa = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.aSn = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString(SapiAccountManager.SESSION_UID));
            } else if (this.mType == 17) {
                this.aRU = new TbRichTextEmotionInfo();
                this.aRU.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.aRU.mGifInfo.mDynamicUrl = jSONObject.optString("dynamic");
                this.aRU.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.aRU.mType = this.mType;
                this.aRU.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.aRU.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.aRU.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.aRU.mGifInfo.mIcon = jSONObject.optString("icon");
                String[] split = this.aRU.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.aRU.mGifInfo.mGid = split[i].split("_")[0];
            } else {
                this.aSn = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int fG = TbFaceManager.Er().fG(this.aSn.getText());
                    String optString = jSONObject.optString("c");
                    if (fG <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(d.j.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.aSn.setText(str);
                    } else {
                        this.aSn.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.aSn.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.aSn != null) {
                this.aSn.IX();
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
