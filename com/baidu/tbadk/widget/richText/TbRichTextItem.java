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
    private TbRichTextMemeInfo bfk;
    private int mType = 0;
    private TbRichTextCommInfo bfB = null;
    private TbRichTextImageInfo bfd = null;
    private TbRichTextVoiceInfo ayr = null;
    private TbRichTextEmotionInfo bfg = null;
    private f bfh = null;
    private TbRichTextLinkButtonInfo bfj = null;
    private TbRichTextLinkImageInfo bfi = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.bfB = tbRichTextCommInfo;
        this.bfd = tbRichTextImageInfo;
        this.ayr = tbRichTextVoiceInfo;
        this.bfg = tbRichTextEmotionInfo;
        this.bfj = tbRichTextLinkButtonInfo;
        this.bfi = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo NN() {
        if (this.mType == 1280) {
            return this.bfi;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo NO() {
        if (this.mType == 1024) {
            return this.bfj;
        }
        return null;
    }

    public TbRichTextImageInfo NF() {
        if (this.mType == 8) {
            return this.bfd;
        }
        return null;
    }

    public f NJ() {
        if (this.mType != 32) {
            return null;
        }
        return this.bfh;
    }

    public TbRichTextVoiceInfo NH() {
        if (this.mType == 512 || this.mType == 768) {
            return this.ayr;
        }
        return null;
    }

    public TbRichTextEmotionInfo NK() {
        if (this.mType == 17) {
            return this.bfg;
        }
        return null;
    }

    public TbRichTextMemeInfo NL() {
        if (this.mType == 20) {
            return this.bfk;
        }
        return null;
    }

    private SpannableString NY() {
        if (this.mType != 1 || this.bfB == null) {
            return null;
        }
        return new SpannableString(this.bfB.getText());
    }

    private CharSequence w(ArrayList<b> arrayList) {
        SpannableString b;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.bfB != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(d.k.video_text));
            CharSequence y = y(arrayList);
            if (y != null) {
                spannableStringBuilder.append(y);
            }
            if (this.bfB.NA() == 1) {
                b = b(this.mType, this.bfB.getText(), this.bfB.NB(), 0);
            } else {
                b = b(this.mType, this.bfB.getText(), this.bfB.getText(), 0);
            }
            if (b != null) {
                spannableStringBuilder.append((CharSequence) b);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence x(ArrayList<b> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.bfB != null) {
            CharSequence y = y(arrayList);
            if (y != null) {
                spannableStringBuilder.append(y);
            }
            SpannableString b = b(this.mType, this.bfB.getLink(), this.bfB.getLink(), 0);
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
        if (this.mType != 32 || this.bfB == null) {
            return null;
        }
        if (this.bfB.NA() == 1) {
            return this.bfB.NB();
        }
        return this.bfB.getText();
    }

    private SpannableString NZ() {
        if ((this.mType != 2 && this.mType != 18) || this.bfB == null) {
            return null;
        }
        if (this.bfB.NA() == 1) {
            return b(this.mType, this.bfB.getText(), this.bfB.NB(), 0);
        }
        return b(this.mType, this.bfB.getText(), this.bfB.getLink(), this.bfB.NC());
    }

    private SpannableString Oa() {
        if (this.mType != 256 || this.bfB == null) {
            return null;
        }
        String text = this.bfB.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = text + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        c cVar = new c(this.mType, text);
        cVar.hW(this.bfB.getLink());
        spannableString.setSpan(cVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString Ob() {
        if (this.mType != 16 || this.bfB == null) {
            return null;
        }
        return b(this.mType, this.bfB.getText(), this.bfB.getLink(), 0);
    }

    private SpannableString z(ArrayList<b> arrayList) {
        String text;
        int gE;
        a.C0116a hd;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.bfB != null && this.bfB.getText() != null && this.bfB.getLink() != null && (gE = TbFaceManager.IU().gE((text = this.bfB.getText()))) != 0) {
            String str = "#(" + TbFaceManager.IU().gG(text) + ")";
            spannableString = new SpannableString(str + " ");
            b bVar = new b(TbadkCoreApplication.getInst().getContext(), gE);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            if (TbFaceManager.IU().hd(text) != null) {
                int width = (int) (0.5d * hd.getWidth());
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
            cVar.fZ(i2);
            if (i2 == 1) {
                cVar.setTextColor(d.C0142d.cp_cont_d);
            } else {
                cVar.setTextColor(-1);
            }
            spannableString.setSpan(cVar, 0, str.length() - 1, 33);
        }
        return spannableString;
    }

    private SpannableString Oc() {
        if (this.mType != 1024 || this.bfj == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString("a");
        Drawable gb = d.gb(this.bfj.btn_type);
        gb.setBounds(0, 0, gb.getIntrinsicWidth(), gb.getIntrinsicHeight());
        com.baidu.tbadk.widget.c cVar = new com.baidu.tbadk.widget.c(gb);
        cVar.setVerticalOffset(l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds4));
        spannableString.setSpan(cVar, 0, 1, 33);
        spannableString.setSpan(new c(1024, this.bfj.link), spannableString.length() - 1, "a".length(), 33);
        return spannableString;
    }

    public CharSequence A(ArrayList<b> arrayList) {
        switch (this.mType) {
            case 1:
                return NY();
            case 2:
                return NZ();
            case 4:
                return z(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return Ob();
            case 18:
                return NZ();
            case 32:
                return w(arrayList);
            case 128:
                return x(arrayList);
            case 256:
                return Oa();
            case 1024:
                return Oc();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.bfh.Om() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = ga(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.bfd = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.bfB = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.bfg = new TbRichTextEmotionInfo();
                    this.bfg.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.bfg.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.bfg.mGifInfo.mStaticUrl = pbContent._static;
                    this.bfg.mType = this.mType;
                    this.bfg.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.bfg.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.bfg.mGifInfo.mPackageName = pbContent.packet_name;
                    this.bfg.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.bfg.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.bfg.mGifInfo.mGid = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.bfg.mGifInfo.mGid = split[i].split("_")[0];
                case 20:
                    this.bfk = new TbRichTextMemeInfo();
                    this.bfk.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.ayr = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.bfj = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case 1280:
                    this.bfi = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.bfh = new f();
                        this.bfh.b(pbContent);
                        break;
                    }
                    this.bfB = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.IU().gE(this.bfB.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(d.k.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.bfB.setText(str);
                            break;
                        } else {
                            this.bfB.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.bfB.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.bfB != null) {
                this.bfB.ND();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = ga(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.bfd = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.ayr = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.bfB = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.bfg = new TbRichTextEmotionInfo();
                this.bfg.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.bfg.mGifInfo.mDynamicUrl = jSONObject.optString("dynamic");
                this.bfg.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.bfg.mType = this.mType;
                this.bfg.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.bfg.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.bfg.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.bfg.mGifInfo.mIcon = jSONObject.optString("icon");
                String[] split = this.bfg.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.bfg.mGifInfo.mGid = split[i].split("_")[0];
            } else {
                this.bfB = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int gE = TbFaceManager.IU().gE(this.bfB.getText());
                    String optString = jSONObject.optString("c");
                    if (gE <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(d.k.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.bfB.setText(str);
                    } else {
                        this.bfB.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.bfB.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.bfB != null) {
                this.bfB.ND();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int ga(int i) {
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
