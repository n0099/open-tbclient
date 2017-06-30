package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.w;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextItem extends OrmObject {
    private TbRichTextGraffitiInfo aOx;
    private TbRichTextMemeInfo aOy;
    private int mType = 0;
    private TbRichTextCommInfo aON = null;
    private TbRichTextImageInfo aOq = null;
    private TbRichTextVoiceInfo anc = null;
    private TbRichTextEmotionInfo aOt = null;
    private e aOu = null;
    private TbRichTextLinkButtonInfo aOw = null;
    private TbRichTextLinkImageInfo aOv = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.aON = tbRichTextCommInfo;
        this.aOq = tbRichTextImageInfo;
        this.anc = tbRichTextVoiceInfo;
        this.aOt = tbRichTextEmotionInfo;
        this.aOw = tbRichTextLinkButtonInfo;
        this.aOv = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo Ii() {
        if (this.mType == 1280) {
            return this.aOv;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo Ij() {
        if (this.mType == 1024) {
            return this.aOw;
        }
        return null;
    }

    public TbRichTextImageInfo Ia() {
        if (this.mType == 8) {
            return this.aOq;
        }
        return null;
    }

    public e Ie() {
        if (this.mType != 32) {
            return null;
        }
        return this.aOu;
    }

    public TbRichTextVoiceInfo Ic() {
        if (this.mType == 512 || this.mType == 768) {
            return this.anc;
        }
        return null;
    }

    public TbRichTextEmotionInfo If() {
        if (this.mType == 17) {
            return this.aOt;
        }
        return null;
    }

    public TbRichTextMemeInfo Ig() {
        if (this.mType == 20) {
            return this.aOy;
        }
        return null;
    }

    public TbRichTextGraffitiInfo Ik() {
        if (this.mType == 1536) {
            return this.aOx;
        }
        return null;
    }

    private SpannableString Is() {
        if (this.mType != 1 || this.aON == null) {
            return null;
        }
        return new SpannableString(this.aON.getText());
    }

    private CharSequence t(ArrayList<a> arrayList) {
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.aON != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.m9getInst().getString(w.l.video_text));
            CharSequence v = v(arrayList);
            if (v != null) {
                spannableStringBuilder.append(v);
            }
            if (this.aON.HV() == 1) {
                a = a(this.mType, this.aON.getText(), this.aON.HW(), 0);
            } else {
                a = a(this.mType, this.aON.getText(), this.aON.getText(), 0);
            }
            if (a != null) {
                spannableStringBuilder.append((CharSequence) a);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence u(ArrayList<a> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.aON != null) {
            CharSequence v = v(arrayList);
            if (v != null) {
                spannableStringBuilder.append(v);
            }
            SpannableString a = a(this.mType, this.aON.getLink(), this.aON.getLink(), 0);
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
        if (this.mType != 32 || this.aON == null) {
            return null;
        }
        if (this.aON.HV() == 1) {
            return this.aON.HW();
        }
        return this.aON.getText();
    }

    private SpannableString It() {
        if ((this.mType != 2 && this.mType != 18) || this.aON == null) {
            return null;
        }
        if (this.aON.HV() == 1) {
            return a(this.mType, this.aON.getText(), this.aON.HW(), 0);
        }
        return a(this.mType, this.aON.getText(), this.aON.getLink(), this.aON.HX());
    }

    private SpannableString Iu() {
        if (this.mType != 256 || this.aON == null) {
            return null;
        }
        String text = this.aON.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = String.valueOf(text) + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        b bVar = new b(this.mType, text);
        bVar.gO(this.aON.getLink());
        spannableString.setSpan(bVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString Iv() {
        if (this.mType != 16 || this.aON == null) {
            return null;
        }
        return a(this.mType, this.aON.getText(), this.aON.getLink(), 0);
    }

    private SpannableString w(ArrayList<a> arrayList) {
        String text;
        int fx;
        a.C0047a fZ;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.aON != null && this.aON.getText() != null && this.aON.getLink() != null && (fx = TbFaceManager.Ea().fx((text = this.aON.getText()))) != 0) {
            String str = "#(" + TbFaceManager.Ea().fz(text) + ")";
            spannableString = new SpannableString(String.valueOf(str) + " ");
            a aVar = new a(TbadkCoreApplication.m9getInst().getContext(), fx);
            if (arrayList != null) {
                arrayList.add(aVar);
            }
            if (TbFaceManager.Ea().fZ(text) != null) {
                int width = (int) (fZ.getWidth() * 0.5d);
                aVar.setBounds(new Rect(0, 0, width, width));
            } else {
                aVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new com.baidu.tbadk.widget.i(aVar), 0, str.length(), 33);
        }
        return spannableString;
    }

    private SpannableString a(int i, String str, String str2, int i2) {
        SpannableString spannableString = null;
        if (str != null) {
            if (!str.endsWith(" ")) {
                str = String.valueOf(str) + " ";
            }
            spannableString = new SpannableString(str);
            b bVar = new b(i, str2);
            bVar.fw(i2);
            if (i2 == 1) {
                bVar.setTextColor(w.e.cp_cont_d);
            } else {
                bVar.setTextColor(-1);
            }
            spannableString.setSpan(bVar, 0, str.length() - 1, 33);
        }
        return spannableString;
    }

    private SpannableString Iw() {
        if (this.mType != 1024 || this.aOw == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString("a");
        Drawable fy = c.fy(this.aOw.btn_type);
        fy.setBounds(0, 0, fy.getIntrinsicWidth(), fy.getIntrinsicHeight());
        com.baidu.tbadk.widget.i iVar = new com.baidu.tbadk.widget.i(fy);
        iVar.setVerticalOffset(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getContext(), w.f.ds4));
        spannableString.setSpan(iVar, 0, 1, 33);
        spannableString.setSpan(new b(1024, this.aOw.link), spannableString.length() - 1, "a".length(), 33);
        return spannableString;
    }

    public CharSequence x(ArrayList<a> arrayList) {
        switch (this.mType) {
            case 1:
                return Is();
            case 2:
                return It();
            case 4:
                return w(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return Iv();
            case 18:
                return It();
            case 32:
                return t(arrayList);
            case 128:
                return u(arrayList);
            case 256:
                return Iu();
            case 1024:
                return Iw();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.aOu.IG() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = fx(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.aOq = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.aON = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.aOt = new TbRichTextEmotionInfo();
                    this.aOt.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.aOt.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.aOt.mGifInfo.mStaticUrl = pbContent._static;
                    this.aOt.mType = this.mType;
                    this.aOt.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.aOt.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.aOt.mGifInfo.mPackageName = pbContent.packet_name;
                    this.aOt.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.aOt.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.aOt.mGifInfo.mGid = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.aOt.mGifInfo.mGid = split[i].split("_")[0];
                case 20:
                    this.aOy = new TbRichTextMemeInfo();
                    this.aOy.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.anc = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.aOw = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case 1280:
                    this.aOv = new TbRichTextLinkImageInfo(pbContent);
                    break;
                case 1536:
                    this.aOx = new TbRichTextGraffitiInfo();
                    this.aOx.a(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.aOu = new e();
                        this.aOu.a(pbContent);
                        break;
                    }
                    this.aON = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.Ea().fx(this.aON.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.m9getInst().getString(w.l.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.aON.setText(str);
                            break;
                        } else {
                            this.aON.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.aON.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.aON != null) {
                this.aON.HY();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = fx(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.aOq = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.anc = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.aON = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString(SapiAccountManager.SESSION_UID));
            } else if (this.mType == 17) {
                this.aOt = new TbRichTextEmotionInfo();
                this.aOt.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.aOt.mGifInfo.mDynamicUrl = jSONObject.optString("dynamic");
                this.aOt.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.aOt.mType = this.mType;
                this.aOt.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.aOt.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.aOt.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.aOt.mGifInfo.mIcon = jSONObject.optString("icon");
                String[] split = this.aOt.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.aOt.mGifInfo.mGid = split[i].split("_")[0];
            } else {
                this.aON = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int fx = TbFaceManager.Ea().fx(this.aON.getText());
                    String optString = jSONObject.optString("c");
                    if (fx <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.m9getInst().getString(w.l.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.aON.setText(str);
                    } else {
                        this.aON.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.aON.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.aON != null) {
                this.aON.HY();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int fx(int i) {
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
