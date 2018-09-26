package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.e;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextItem extends OrmObject {
    private TbRichTextMemeInfo biQ;
    private int mType = 0;
    private TbRichTextCommInfo bjj = null;
    private TbRichTextImageInfo biJ = null;
    private TbRichTextVoiceInfo aAY = null;
    private TbRichTextEmotionInfo biM = null;
    private f biN = null;
    private TbRichTextLinkButtonInfo biP = null;
    private TbRichTextLinkImageInfo biO = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.bjj = tbRichTextCommInfo;
        this.biJ = tbRichTextImageInfo;
        this.aAY = tbRichTextVoiceInfo;
        this.biM = tbRichTextEmotionInfo;
        this.biP = tbRichTextLinkButtonInfo;
        this.biO = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo Pd() {
        if (this.mType == 1280) {
            return this.biO;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo Pe() {
        if (this.mType == 1024) {
            return this.biP;
        }
        return null;
    }

    public TbRichTextImageInfo OV() {
        if (this.mType == 8) {
            return this.biJ;
        }
        return null;
    }

    public f OZ() {
        if (this.mType != 32) {
            return null;
        }
        return this.biN;
    }

    public TbRichTextVoiceInfo OX() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aAY;
        }
        return null;
    }

    public TbRichTextEmotionInfo Pa() {
        if (this.mType == 17) {
            return this.biM;
        }
        return null;
    }

    public TbRichTextMemeInfo Pb() {
        if (this.mType == 20) {
            return this.biQ;
        }
        return null;
    }

    private SpannableString Pq() {
        if (this.mType != 1 || this.bjj == null) {
            return null;
        }
        return new SpannableString(this.bjj.getText());
    }

    private CharSequence w(ArrayList<b> arrayList) {
        SpannableString b;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.bjj != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(e.j.video_text));
            CharSequence y = y(arrayList);
            if (y != null) {
                spannableStringBuilder.append(y);
            }
            if (this.bjj.OQ() == 1) {
                b = b(this.mType, this.bjj.getText(), this.bjj.OR(), 0);
            } else {
                b = b(this.mType, this.bjj.getText(), this.bjj.getText(), 0);
            }
            if (b != null) {
                spannableStringBuilder.append((CharSequence) b);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence x(ArrayList<b> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.bjj != null) {
            CharSequence y = y(arrayList);
            if (y != null) {
                spannableStringBuilder.append(y);
            }
            SpannableString b = b(this.mType, this.bjj.getLink(), this.bjj.getLink(), 0);
            if (b != null) {
                spannableStringBuilder.append((CharSequence) b);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence y(ArrayList<b> arrayList) {
        TbRichTextItem tbRichTextItem = new TbRichTextItem();
        tbRichTextItem.a(4, new TbRichTextCommInfo("video_icon", " "), null, null, null, null, null);
        return tbRichTextItem.A(arrayList);
    }

    public String getVideoUrl() {
        if (this.mType != 32 || this.bjj == null) {
            return null;
        }
        if (this.bjj.OQ() == 1) {
            return this.bjj.OR();
        }
        return this.bjj.getText();
    }

    private SpannableString Pr() {
        if ((this.mType != 2 && this.mType != 18) || this.bjj == null) {
            return null;
        }
        if (this.bjj.OQ() == 1) {
            return b(this.mType, this.bjj.getText(), this.bjj.OR(), 0);
        }
        return b(this.mType, this.bjj.getText(), this.bjj.getLink(), this.bjj.OS());
    }

    private SpannableString Ps() {
        if (this.mType != 256 || this.bjj == null) {
            return null;
        }
        String text = this.bjj.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = text + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        c cVar = new c(this.mType, text);
        cVar.is(this.bjj.getLink());
        spannableString.setSpan(cVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString Pt() {
        if (this.mType != 16 || this.bjj == null) {
            return null;
        }
        return b(this.mType, this.bjj.getText(), this.bjj.getLink(), 0);
    }

    private SpannableString z(ArrayList<b> arrayList) {
        String text;
        int gW;
        a.C0113a hv;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.bjj != null && this.bjj.getText() != null && this.bjj.getLink() != null && (gW = TbFaceManager.Kf().gW((text = this.bjj.getText()))) != 0) {
            String str = "#(" + TbFaceManager.Kf().gY(text) + ")";
            spannableString = new SpannableString(str + " ");
            b bVar = new b(TbadkCoreApplication.getInst().getContext(), gW);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            if (TbFaceManager.Kf().hv(text) != null) {
                int width = (int) (0.5d * hv.getWidth());
                bVar.setBounds(new Rect(0, 0, width, width));
            } else {
                bVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new com.baidu.tbadk.widget.a(bVar, 1), 0, str.length(), 33);
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
            cVar.gm(i2);
            if (i2 == 1) {
                cVar.setTextColor(e.d.cp_cont_d);
            } else {
                cVar.setTextColor(-1);
            }
            spannableString.setSpan(cVar, 0, str.length() - 1, 33);
        }
        return spannableString;
    }

    private SpannableString Pu() {
        if (this.mType != 1024 || this.biP == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(Config.APP_VERSION_CODE);
        Drawable go = d.go(this.biP.btn_type);
        go.setBounds(0, 0, go.getIntrinsicWidth(), go.getIntrinsicHeight());
        com.baidu.tbadk.widget.c cVar = new com.baidu.tbadk.widget.c(go);
        cVar.setVerticalOffset(l.h(TbadkCoreApplication.getInst().getContext(), e.C0141e.ds4));
        spannableString.setSpan(cVar, 0, 1, 33);
        spannableString.setSpan(new c(1024, this.biP.link), spannableString.length() - 1, Config.APP_VERSION_CODE.length(), 33);
        return spannableString;
    }

    public CharSequence A(ArrayList<b> arrayList) {
        switch (this.mType) {
            case 1:
                return Pq();
            case 2:
                return Pr();
            case 4:
                return z(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return Pt();
            case 18:
                return Pr();
            case 32:
                return w(arrayList);
            case 128:
                return x(arrayList);
            case 256:
                return Ps();
            case 1024:
                return Pu();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.biN.PE() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = gn(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.biJ = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.bjj = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.biM = new TbRichTextEmotionInfo();
                    this.biM.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.biM.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.biM.mGifInfo.mStaticUrl = pbContent._static;
                    this.biM.mType = this.mType;
                    this.biM.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.biM.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.biM.mGifInfo.mPackageName = pbContent.packet_name;
                    this.biM.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.biM.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.biM.mGifInfo.mGid = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.biM.mGifInfo.mGid = split[i].split("_")[0];
                case 20:
                    this.biQ = new TbRichTextMemeInfo();
                    this.biQ.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.aAY = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.biP = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case 1280:
                    this.biO = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.biN = new f();
                        this.biN.b(pbContent);
                        break;
                    }
                    this.bjj = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.Kf().gW(this.bjj.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(e.j.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.bjj.setText(str);
                            break;
                        } else {
                            this.bjj.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.bjj.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.bjj != null) {
                this.bjj.OT();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = gn(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.biJ = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.aAY = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.bjj = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.biM = new TbRichTextEmotionInfo();
                this.biM.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.biM.mGifInfo.mDynamicUrl = jSONObject.optString("dynamic");
                this.biM.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.biM.mType = this.mType;
                this.biM.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.biM.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.biM.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.biM.mGifInfo.mIcon = jSONObject.optString("icon");
                String[] split = this.biM.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.biM.mGifInfo.mGid = split[i].split("_")[0];
            } else {
                this.bjj = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int gW = TbFaceManager.Kf().gW(this.bjj.getText());
                    String optString = jSONObject.optString("c");
                    if (gW <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(e.j.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.bjj.setText(str);
                    } else {
                        this.bjj.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.bjj.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.bjj != null) {
                this.bjj.OT();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int gn(int i) {
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
