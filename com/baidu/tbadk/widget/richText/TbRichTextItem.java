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
    private TbRichTextGraffitiInfo aNi;
    private int mType = 0;
    private TbRichTextCommInfo aNx = null;
    private TbRichTextImageInfo aNa = null;
    private TbRichTextVoiceInfo aNc = null;
    private TbRichTextEmotionInfo aNe = null;
    private e aNf = null;
    private TbRichTextLinkButtonInfo aNh = null;
    private TbRichTextLinkImageInfo aNg = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.aNx = tbRichTextCommInfo;
        this.aNa = tbRichTextImageInfo;
        this.aNc = tbRichTextVoiceInfo;
        this.aNe = tbRichTextEmotionInfo;
        this.aNh = tbRichTextLinkButtonInfo;
        this.aNg = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo HK() {
        if (this.mType == 1280) {
            return this.aNg;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo HL() {
        if (this.mType == 1024) {
            return this.aNh;
        }
        return null;
    }

    public TbRichTextImageInfo HD() {
        if (this.mType == 8) {
            return this.aNa;
        }
        return null;
    }

    public e HH() {
        if (this.mType != 32) {
            return null;
        }
        return this.aNf;
    }

    public TbRichTextVoiceInfo HF() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aNc;
        }
        return null;
    }

    public TbRichTextEmotionInfo HI() {
        if (this.mType == 17) {
            return this.aNe;
        }
        return null;
    }

    public TbRichTextGraffitiInfo HM() {
        if (this.mType == 1536) {
            return this.aNi;
        }
        return null;
    }

    private SpannableString HU() {
        if (this.mType != 1 || this.aNx == null) {
            return null;
        }
        return new SpannableString(this.aNx.getText());
    }

    private CharSequence t(ArrayList<a> arrayList) {
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.aNx != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.m9getInst().getString(w.l.video_text));
            CharSequence v = v(arrayList);
            if (v != null) {
                spannableStringBuilder.append(v);
            }
            if (this.aNx.Hy() == 1) {
                a = a(this.mType, this.aNx.getText(), this.aNx.Hz(), 0);
            } else {
                a = a(this.mType, this.aNx.getText(), this.aNx.getText(), 0);
            }
            if (a != null) {
                spannableStringBuilder.append((CharSequence) a);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence u(ArrayList<a> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.aNx != null) {
            CharSequence v = v(arrayList);
            if (v != null) {
                spannableStringBuilder.append(v);
            }
            SpannableString a = a(this.mType, this.aNx.getLink(), this.aNx.getLink(), 0);
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
        if (this.mType != 32 || this.aNx == null) {
            return null;
        }
        if (this.aNx.Hy() == 1) {
            return this.aNx.Hz();
        }
        return this.aNx.getText();
    }

    private SpannableString HV() {
        if ((this.mType != 2 && this.mType != 18) || this.aNx == null) {
            return null;
        }
        if (this.aNx.Hy() == 1) {
            return a(this.mType, this.aNx.getText(), this.aNx.Hz(), 0);
        }
        return a(this.mType, this.aNx.getText(), this.aNx.getLink(), this.aNx.HA());
    }

    private SpannableString HW() {
        if (this.mType != 256 || this.aNx == null) {
            return null;
        }
        String text = this.aNx.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = String.valueOf(text) + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        b bVar = new b(this.mType, text);
        bVar.gr(this.aNx.getLink());
        spannableString.setSpan(bVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString HX() {
        if (this.mType != 16 || this.aNx == null) {
            return null;
        }
        return a(this.mType, this.aNx.getText(), this.aNx.getLink(), 0);
    }

    private SpannableString w(ArrayList<a> arrayList) {
        String text;
        int fd;
        a.C0045a fF;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.aNx != null && this.aNx.getText() != null && this.aNx.getLink() != null && (fd = TbFaceManager.DG().fd((text = this.aNx.getText()))) != 0) {
            String str = "#(" + TbFaceManager.DG().ff(text) + ")";
            spannableString = new SpannableString(String.valueOf(str) + " ");
            a aVar = new a(TbadkCoreApplication.m9getInst().getContext(), fd);
            if (arrayList != null) {
                arrayList.add(aVar);
            }
            if (TbFaceManager.DG().fF(text) != null) {
                int width = (int) (fF.getWidth() * 0.5d);
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
            bVar.fu(i2);
            if (i2 == 1) {
                bVar.setTextColor(w.e.cp_cont_d);
            } else {
                bVar.setTextColor(-1);
            }
            spannableString.setSpan(bVar, 0, str.length() - 1, 33);
        }
        return spannableString;
    }

    private SpannableString HY() {
        if (this.mType != 1024 || this.aNh == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString("a");
        Drawable fw = c.fw(this.aNh.btn_type);
        fw.setBounds(0, 0, fw.getIntrinsicWidth(), fw.getIntrinsicHeight());
        com.baidu.tbadk.widget.i iVar = new com.baidu.tbadk.widget.i(fw);
        iVar.setVerticalOffset(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getContext(), w.f.ds4));
        spannableString.setSpan(iVar, 0, 1, 33);
        spannableString.setSpan(new b(1024, this.aNh.link), spannableString.length() - 1, "a".length(), 33);
        return spannableString;
    }

    public CharSequence x(ArrayList<a> arrayList) {
        switch (this.mType) {
            case 1:
                return HU();
            case 2:
                return HV();
            case 4:
                return w(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return HX();
            case 18:
                return HV();
            case 32:
                return t(arrayList);
            case 128:
                return u(arrayList);
            case 256:
                return HW();
            case 1024:
                return HY();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.aNf.Ii() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = fv(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.aNa = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.aNx = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.aNe = new TbRichTextEmotionInfo();
                    this.aNe.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.aNe.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.aNe.mGifInfo.mStaticUrl = pbContent._static;
                    this.aNe.mType = this.mType;
                    this.aNe.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.aNe.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.aNe.mGifInfo.mPackageName = pbContent.packet_name;
                    this.aNe.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.aNe.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.aNe.mGifInfo.mGid = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.aNe.mGifInfo.mGid = split[i].split("_")[0];
                case 512:
                    this.aNc = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.aNh = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case 1280:
                    this.aNg = new TbRichTextLinkImageInfo(pbContent);
                    break;
                case 1536:
                    this.aNi = new TbRichTextGraffitiInfo();
                    this.aNi.a(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.aNf = new e();
                        this.aNf.a(pbContent);
                        break;
                    }
                    this.aNx = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.DG().fd(this.aNx.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.m9getInst().getString(w.l.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.aNx.setText(str);
                            break;
                        } else {
                            this.aNx.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.aNx.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.aNx != null) {
                this.aNx.HB();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = fv(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.aNa = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.aNc = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.aNx = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString(SapiAccountManager.SESSION_UID));
            } else if (this.mType == 17) {
                this.aNe = new TbRichTextEmotionInfo();
                this.aNe.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.aNe.mGifInfo.mDynamicUrl = jSONObject.optString("dynamic");
                this.aNe.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.aNe.mType = this.mType;
                this.aNe.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.aNe.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.aNe.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.aNe.mGifInfo.mIcon = jSONObject.optString("icon");
                String[] split = this.aNe.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.aNe.mGifInfo.mGid = split[i].split("_")[0];
            } else {
                this.aNx = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int fd = TbFaceManager.DG().fd(this.aNx.getText());
                    String optString = jSONObject.optString("c");
                    if (fd <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.m9getInst().getString(w.l.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.aNx.setText(str);
                    } else {
                        this.aNx.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.aNx.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.aNx != null) {
                this.aNx.HB();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int fv(int i) {
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
        }
    }
}
