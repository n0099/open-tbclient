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
    private TbRichTextMemeInfo bKX;
    private int mType = 0;
    private TbRichTextCommInfo bLp = null;
    private TbRichTextImageInfo bKQ = null;
    private TbRichTextVoiceInfo bdZ = null;
    private TbRichTextEmotionInfo bKT = null;
    private f bKU = null;
    private TbRichTextLinkButtonInfo bKW = null;
    private TbRichTextLinkImageInfo bKV = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.bLp = tbRichTextCommInfo;
        this.bKQ = tbRichTextImageInfo;
        this.bdZ = tbRichTextVoiceInfo;
        this.bKT = tbRichTextEmotionInfo;
        this.bKW = tbRichTextLinkButtonInfo;
        this.bKV = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo Rv() {
        if (this.mType == 1280) {
            return this.bKV;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo Rw() {
        if (this.mType == 1024) {
            return this.bKW;
        }
        return null;
    }

    public TbRichTextImageInfo Rn() {
        if (this.mType == 8) {
            return this.bKQ;
        }
        return null;
    }

    public f Rr() {
        if (this.mType != 32) {
            return null;
        }
        return this.bKU;
    }

    public TbRichTextVoiceInfo Rp() {
        if (this.mType == 512 || this.mType == 768) {
            return this.bdZ;
        }
        return null;
    }

    public TbRichTextEmotionInfo Rs() {
        if (this.mType == 17) {
            return this.bKT;
        }
        return null;
    }

    public TbRichTextMemeInfo Rt() {
        if (this.mType == 20) {
            return this.bKX;
        }
        return null;
    }

    private SpannableString RH() {
        if (this.mType != 1 || this.bLp == null) {
            return null;
        }
        return new SpannableString(this.bLp.getText());
    }

    private CharSequence u(ArrayList<b> arrayList) {
        SpannableString b;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.bLp != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(d.j.video_text));
            CharSequence w = w(arrayList);
            if (w != null) {
                spannableStringBuilder.append(w);
            }
            if (this.bLp.Ri() == 1) {
                b = b(this.mType, this.bLp.getText(), this.bLp.Rj(), 0);
            } else {
                b = b(this.mType, this.bLp.getText(), this.bLp.getText(), 0);
            }
            if (b != null) {
                spannableStringBuilder.append((CharSequence) b);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence v(ArrayList<b> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.bLp != null) {
            CharSequence w = w(arrayList);
            if (w != null) {
                spannableStringBuilder.append(w);
            }
            SpannableString b = b(this.mType, this.bLp.getLink(), this.bLp.getLink(), 0);
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
        if (this.mType != 32 || this.bLp == null) {
            return null;
        }
        if (this.bLp.Ri() == 1) {
            return this.bLp.Rj();
        }
        return this.bLp.getText();
    }

    private SpannableString RI() {
        if ((this.mType != 2 && this.mType != 18) || this.bLp == null) {
            return null;
        }
        if (this.bLp.Ri() == 1) {
            return b(this.mType, this.bLp.getText(), this.bLp.Rj(), 0);
        }
        return b(this.mType, this.bLp.getText(), this.bLp.getLink(), this.bLp.Rk());
    }

    private SpannableString RJ() {
        if (this.mType != 256 || this.bLp == null) {
            return null;
        }
        String text = this.bLp.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = text + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        c cVar = new c(this.mType, text);
        cVar.hA(this.bLp.getLink());
        spannableString.setSpan(cVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString RK() {
        if (this.mType != 16 || this.bLp == null) {
            return null;
        }
        return b(this.mType, this.bLp.getText(), this.bLp.getLink(), 0);
    }

    private SpannableString x(ArrayList<b> arrayList) {
        String text;
        int gk;
        a.C0109a gK;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.bLp != null && this.bLp.getText() != null && this.bLp.getLink() != null && (gk = TbFaceManager.Mv().gk((text = this.bLp.getText()))) != 0) {
            String str = "#(" + TbFaceManager.Mv().gm(text) + ")";
            spannableString = new SpannableString(str + " ");
            b bVar = new b(TbadkCoreApplication.getInst().getContext(), gk);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            if (TbFaceManager.Mv().gK(text) != null) {
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

    private SpannableString RL() {
        if (this.mType != 1024 || this.bKW == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString("a");
        Drawable iY = d.iY(this.bKW.btn_type);
        iY.setBounds(0, 0, iY.getIntrinsicWidth(), iY.getIntrinsicHeight());
        com.baidu.tbadk.widget.f fVar = new com.baidu.tbadk.widget.f(iY);
        fVar.setVerticalOffset(l.t(TbadkCoreApplication.getInst().getContext(), d.e.ds4));
        spannableString.setSpan(fVar, 0, 1, 33);
        spannableString.setSpan(new c(1024, this.bKW.link), spannableString.length() - 1, "a".length(), 33);
        return spannableString;
    }

    public CharSequence y(ArrayList<b> arrayList) {
        switch (this.mType) {
            case 1:
                return RH();
            case 2:
                return RI();
            case 4:
                return x(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return RK();
            case 18:
                return RI();
            case 32:
                return u(arrayList);
            case 128:
                return v(arrayList);
            case 256:
                return RJ();
            case 1024:
                return RL();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.bKU.RV() != false) goto L9;
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
                    this.bKQ = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.bLp = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.bKT = new TbRichTextEmotionInfo();
                    this.bKT.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.bKT.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.bKT.mGifInfo.mStaticUrl = pbContent._static;
                    this.bKT.mType = this.mType;
                    this.bKT.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.bKT.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.bKT.mGifInfo.mPackageName = pbContent.packet_name;
                    this.bKT.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.bKT.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.bKT.mGifInfo.mGid = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.bKT.mGifInfo.mGid = split[i].split("_")[0];
                case 20:
                    this.bKX = new TbRichTextMemeInfo();
                    this.bKX.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.bdZ = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.bKW = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case 1280:
                    this.bKV = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.bKU = new f();
                        this.bKU.b(pbContent);
                        break;
                    }
                    this.bLp = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.Mv().gk(this.bLp.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(d.j.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.bLp.setText(str);
                            break;
                        } else {
                            this.bLp.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.bLp.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.bLp != null) {
                this.bLp.Rl();
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
                this.bKQ = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.bdZ = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.bLp = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.bKT = new TbRichTextEmotionInfo();
                this.bKT.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.bKT.mGifInfo.mDynamicUrl = jSONObject.optString("dynamic");
                this.bKT.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.bKT.mType = this.mType;
                this.bKT.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.bKT.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.bKT.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.bKT.mGifInfo.mIcon = jSONObject.optString("icon");
                String[] split = this.bKT.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.bKT.mGifInfo.mGid = split[i].split("_")[0];
            } else {
                this.bLp = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int gk = TbFaceManager.Mv().gk(this.bLp.getText());
                    String optString = jSONObject.optString("c");
                    if (gk <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(d.j.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.bLp.setText(str);
                    } else {
                        this.bLp.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.bLp.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.bLp != null) {
                this.bLp.Rl();
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
