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
    private TbRichTextMemeInfo aRq;
    private int mType = 0;
    private TbRichTextCommInfo aRF = null;
    private TbRichTextImageInfo aRj = null;
    private TbRichTextVoiceInfo anG = null;
    private TbRichTextEmotionInfo aRm = null;
    private e aRn = null;
    private TbRichTextLinkButtonInfo aRp = null;
    private TbRichTextLinkImageInfo aRo = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.aRF = tbRichTextCommInfo;
        this.aRj = tbRichTextImageInfo;
        this.anG = tbRichTextVoiceInfo;
        this.aRm = tbRichTextEmotionInfo;
        this.aRp = tbRichTextLinkButtonInfo;
        this.aRo = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo IL() {
        if (this.mType == 1280) {
            return this.aRo;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo IM() {
        if (this.mType == 1024) {
            return this.aRp;
        }
        return null;
    }

    public TbRichTextImageInfo ID() {
        if (this.mType == 8) {
            return this.aRj;
        }
        return null;
    }

    public e IH() {
        if (this.mType != 32) {
            return null;
        }
        return this.aRn;
    }

    public TbRichTextVoiceInfo IF() {
        if (this.mType == 512 || this.mType == 768) {
            return this.anG;
        }
        return null;
    }

    public TbRichTextEmotionInfo II() {
        if (this.mType == 17) {
            return this.aRm;
        }
        return null;
    }

    public TbRichTextMemeInfo IJ() {
        if (this.mType == 20) {
            return this.aRq;
        }
        return null;
    }

    private SpannableString IW() {
        if (this.mType != 1 || this.aRF == null) {
            return null;
        }
        return new SpannableString(this.aRF.getText());
    }

    private CharSequence s(ArrayList<a> arrayList) {
        SpannableString b;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.aRF != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(d.l.video_text));
            CharSequence u = u(arrayList);
            if (u != null) {
                spannableStringBuilder.append(u);
            }
            if (this.aRF.Iy() == 1) {
                b = b(this.mType, this.aRF.getText(), this.aRF.Iz(), 0);
            } else {
                b = b(this.mType, this.aRF.getText(), this.aRF.getText(), 0);
            }
            if (b != null) {
                spannableStringBuilder.append((CharSequence) b);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence t(ArrayList<a> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.aRF != null) {
            CharSequence u = u(arrayList);
            if (u != null) {
                spannableStringBuilder.append(u);
            }
            SpannableString b = b(this.mType, this.aRF.getLink(), this.aRF.getLink(), 0);
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
        if (this.mType != 32 || this.aRF == null) {
            return null;
        }
        if (this.aRF.Iy() == 1) {
            return this.aRF.Iz();
        }
        return this.aRF.getText();
    }

    private SpannableString IX() {
        if ((this.mType != 2 && this.mType != 18) || this.aRF == null) {
            return null;
        }
        if (this.aRF.Iy() == 1) {
            return b(this.mType, this.aRF.getText(), this.aRF.Iz(), 0);
        }
        return b(this.mType, this.aRF.getText(), this.aRF.getLink(), this.aRF.IA());
    }

    private SpannableString IY() {
        if (this.mType != 256 || this.aRF == null) {
            return null;
        }
        String text = this.aRF.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = text + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        b bVar = new b(this.mType, text);
        bVar.gV(this.aRF.getLink());
        spannableString.setSpan(bVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString IZ() {
        if (this.mType != 16 || this.aRF == null) {
            return null;
        }
        return b(this.mType, this.aRF.getText(), this.aRF.getLink(), 0);
    }

    private SpannableString v(ArrayList<a> arrayList) {
        String text;
        int fy;
        a.C0058a ga;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.aRF != null && this.aRF.getText() != null && this.aRF.getLink() != null && (fy = TbFaceManager.DS().fy((text = this.aRF.getText()))) != 0) {
            String str = "#(" + TbFaceManager.DS().fA(text) + ")";
            spannableString = new SpannableString(str + " ");
            a aVar = new a(TbadkCoreApplication.getInst().getContext(), fy);
            if (arrayList != null) {
                arrayList.add(aVar);
            }
            if (TbFaceManager.DS().ga(text) != null) {
                int width = (int) (0.5d * ga.getWidth());
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
            bVar.fO(i2);
            if (i2 == 1) {
                bVar.setTextColor(d.e.cp_cont_d);
            } else {
                bVar.setTextColor(-1);
            }
            spannableString.setSpan(bVar, 0, str.length() - 1, 33);
        }
        return spannableString;
    }

    private SpannableString Ja() {
        if (this.mType != 1024 || this.aRp == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString("a");
        Drawable fQ = c.fQ(this.aRp.btn_type);
        fQ.setBounds(0, 0, fQ.getIntrinsicWidth(), fQ.getIntrinsicHeight());
        com.baidu.tbadk.widget.e eVar = new com.baidu.tbadk.widget.e(fQ);
        eVar.setVerticalOffset(l.f(TbadkCoreApplication.getInst().getContext(), d.f.ds4));
        spannableString.setSpan(eVar, 0, 1, 33);
        spannableString.setSpan(new b(1024, this.aRp.link), spannableString.length() - 1, "a".length(), 33);
        return spannableString;
    }

    public CharSequence w(ArrayList<a> arrayList) {
        switch (this.mType) {
            case 1:
                return IW();
            case 2:
                return IX();
            case 4:
                return v(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return IZ();
            case 18:
                return IX();
            case 32:
                return s(arrayList);
            case 128:
                return t(arrayList);
            case 256:
                return IY();
            case 1024:
                return Ja();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.aRn.Jk() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = fP(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.aRj = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.aRF = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.aRm = new TbRichTextEmotionInfo();
                    this.aRm.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.aRm.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.aRm.mGifInfo.mStaticUrl = pbContent._static;
                    this.aRm.mType = this.mType;
                    this.aRm.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.aRm.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.aRm.mGifInfo.mPackageName = pbContent.packet_name;
                    this.aRm.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.aRm.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.aRm.mGifInfo.mGid = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.aRm.mGifInfo.mGid = split[i].split("_")[0];
                case 20:
                    this.aRq = new TbRichTextMemeInfo();
                    this.aRq.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.anG = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.aRp = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case 1280:
                    this.aRo = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.aRn = new e();
                        this.aRn.b(pbContent);
                        break;
                    }
                    this.aRF = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.DS().fy(this.aRF.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(d.l.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.aRF.setText(str);
                            break;
                        } else {
                            this.aRF.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.aRF.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.aRF != null) {
                this.aRF.IB();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = fP(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.aRj = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.anG = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.aRF = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString(SapiAccountManager.SESSION_UID));
            } else if (this.mType == 17) {
                this.aRm = new TbRichTextEmotionInfo();
                this.aRm.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.aRm.mGifInfo.mDynamicUrl = jSONObject.optString("dynamic");
                this.aRm.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.aRm.mType = this.mType;
                this.aRm.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.aRm.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.aRm.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.aRm.mGifInfo.mIcon = jSONObject.optString("icon");
                String[] split = this.aRm.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.aRm.mGifInfo.mGid = split[i].split("_")[0];
            } else {
                this.aRF = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int fy = TbFaceManager.DS().fy(this.aRF.getText());
                    String optString = jSONObject.optString("c");
                    if (fy <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(d.l.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.aRF.setText(str);
                    } else {
                        this.aRF.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.aRF.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.aRF != null) {
                this.aRF.IB();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int fP(int i) {
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
