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
    private TbRichTextMemeInfo bLa;
    private int mType = 0;
    private TbRichTextCommInfo bLs = null;
    private TbRichTextImageInfo bKT = null;
    private TbRichTextVoiceInfo bec = null;
    private TbRichTextEmotionInfo bKW = null;
    private f bKX = null;
    private TbRichTextLinkButtonInfo bKZ = null;
    private TbRichTextLinkImageInfo bKY = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.bLs = tbRichTextCommInfo;
        this.bKT = tbRichTextImageInfo;
        this.bec = tbRichTextVoiceInfo;
        this.bKW = tbRichTextEmotionInfo;
        this.bKZ = tbRichTextLinkButtonInfo;
        this.bKY = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo Rw() {
        if (this.mType == 1280) {
            return this.bKY;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo Rx() {
        if (this.mType == 1024) {
            return this.bKZ;
        }
        return null;
    }

    public TbRichTextImageInfo Ro() {
        if (this.mType == 8) {
            return this.bKT;
        }
        return null;
    }

    public f Rs() {
        if (this.mType != 32) {
            return null;
        }
        return this.bKX;
    }

    public TbRichTextVoiceInfo Rq() {
        if (this.mType == 512 || this.mType == 768) {
            return this.bec;
        }
        return null;
    }

    public TbRichTextEmotionInfo Rt() {
        if (this.mType == 17) {
            return this.bKW;
        }
        return null;
    }

    public TbRichTextMemeInfo Ru() {
        if (this.mType == 20) {
            return this.bLa;
        }
        return null;
    }

    private SpannableString RI() {
        if (this.mType != 1 || this.bLs == null) {
            return null;
        }
        return new SpannableString(this.bLs.getText());
    }

    private CharSequence u(ArrayList<b> arrayList) {
        SpannableString b;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.bLs != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(d.j.video_text));
            CharSequence w = w(arrayList);
            if (w != null) {
                spannableStringBuilder.append(w);
            }
            if (this.bLs.Rj() == 1) {
                b = b(this.mType, this.bLs.getText(), this.bLs.Rk(), 0);
            } else {
                b = b(this.mType, this.bLs.getText(), this.bLs.getText(), 0);
            }
            if (b != null) {
                spannableStringBuilder.append((CharSequence) b);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence v(ArrayList<b> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.bLs != null) {
            CharSequence w = w(arrayList);
            if (w != null) {
                spannableStringBuilder.append(w);
            }
            SpannableString b = b(this.mType, this.bLs.getLink(), this.bLs.getLink(), 0);
            if (b != null) {
                spannableStringBuilder.append((CharSequence) b);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence w(ArrayList<b> arrayList) {
        TbRichTextItem tbRichTextItem = new TbRichTextItem();
        tbRichTextItem.a(4, new TbRichTextCommInfo("video_icon", " "), null, null, null, null, null);
        return tbRichTextItem.y(arrayList);
    }

    public String getVideoUrl() {
        if (this.mType != 32 || this.bLs == null) {
            return null;
        }
        if (this.bLs.Rj() == 1) {
            return this.bLs.Rk();
        }
        return this.bLs.getText();
    }

    private SpannableString RJ() {
        if ((this.mType != 2 && this.mType != 18) || this.bLs == null) {
            return null;
        }
        if (this.bLs.Rj() == 1) {
            return b(this.mType, this.bLs.getText(), this.bLs.Rk(), 0);
        }
        return b(this.mType, this.bLs.getText(), this.bLs.getLink(), this.bLs.Rl());
    }

    private SpannableString RK() {
        if (this.mType != 256 || this.bLs == null) {
            return null;
        }
        String text = this.bLs.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = text + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        c cVar = new c(this.mType, text);
        cVar.hA(this.bLs.getLink());
        spannableString.setSpan(cVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString RL() {
        if (this.mType != 16 || this.bLs == null) {
            return null;
        }
        return b(this.mType, this.bLs.getText(), this.bLs.getLink(), 0);
    }

    private SpannableString x(ArrayList<b> arrayList) {
        String text;
        int gk;
        a.C0109a gK;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.bLs != null && this.bLs.getText() != null && this.bLs.getLink() != null && (gk = TbFaceManager.Mw().gk((text = this.bLs.getText()))) != 0) {
            String str = "#(" + TbFaceManager.Mw().gm(text) + ")";
            spannableString = new SpannableString(str + " ");
            b bVar = new b(TbadkCoreApplication.getInst().getContext(), gk);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            if (TbFaceManager.Mw().gK(text) != null) {
                int width = (int) (0.5d * gK.getWidth());
                bVar.setBounds(new Rect(0, 0, width, width));
            } else {
                bVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new com.baidu.tbadk.widget.c(bVar, 1), 0, str.length(), 33);
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
            cVar.iW(i2);
            if (i2 == 1) {
                cVar.setTextColor(d.C0141d.cp_cont_d);
            } else {
                cVar.setTextColor(-1);
            }
            spannableString.setSpan(cVar, 0, str.length() - 1, 33);
        }
        return spannableString;
    }

    private SpannableString RM() {
        if (this.mType != 1024 || this.bKZ == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString("a");
        Drawable iY = d.iY(this.bKZ.btn_type);
        iY.setBounds(0, 0, iY.getIntrinsicWidth(), iY.getIntrinsicHeight());
        com.baidu.tbadk.widget.f fVar = new com.baidu.tbadk.widget.f(iY);
        fVar.setVerticalOffset(l.t(TbadkCoreApplication.getInst().getContext(), d.e.ds4));
        spannableString.setSpan(fVar, 0, 1, 33);
        spannableString.setSpan(new c(1024, this.bKZ.link), spannableString.length() - 1, "a".length(), 33);
        return spannableString;
    }

    public CharSequence y(ArrayList<b> arrayList) {
        switch (this.mType) {
            case 1:
                return RI();
            case 2:
                return RJ();
            case 4:
                return x(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return RL();
            case 18:
                return RJ();
            case 32:
                return u(arrayList);
            case 128:
                return v(arrayList);
            case 256:
                return RK();
            case 1024:
                return RM();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.bKX.RW() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = iX(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.bKT = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.bLs = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.bKW = new TbRichTextEmotionInfo();
                    this.bKW.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.bKW.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.bKW.mGifInfo.mStaticUrl = pbContent._static;
                    this.bKW.mType = this.mType;
                    this.bKW.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.bKW.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.bKW.mGifInfo.mPackageName = pbContent.packet_name;
                    this.bKW.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.bKW.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.bKW.mGifInfo.mGid = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.bKW.mGifInfo.mGid = split[i].split("_")[0];
                case 20:
                    this.bLa = new TbRichTextMemeInfo();
                    this.bLa.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.bec = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.bKZ = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case 1280:
                    this.bKY = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.bKX = new f();
                        this.bKX.b(pbContent);
                        break;
                    }
                    this.bLs = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.Mw().gk(this.bLs.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(d.j.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.bLs.setText(str);
                            break;
                        } else {
                            this.bLs.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.bLs.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.bLs != null) {
                this.bLs.Rm();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = iX(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.bKT = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.bec = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.bLs = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.bKW = new TbRichTextEmotionInfo();
                this.bKW.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.bKW.mGifInfo.mDynamicUrl = jSONObject.optString("dynamic");
                this.bKW.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.bKW.mType = this.mType;
                this.bKW.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.bKW.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.bKW.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.bKW.mGifInfo.mIcon = jSONObject.optString("icon");
                String[] split = this.bKW.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.bKW.mGifInfo.mGid = split[i].split("_")[0];
            } else {
                this.bLs = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int gk = TbFaceManager.Mw().gk(this.bLs.getText());
                    String optString = jSONObject.optString("c");
                    if (gk <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(d.j.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.bLs.setText(str);
                    } else {
                        this.bLs.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.bLs.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.bLs != null) {
                this.bLs.Rm();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int iX(int i) {
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
