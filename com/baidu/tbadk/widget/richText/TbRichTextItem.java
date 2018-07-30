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
    private TbRichTextMemeInfo bfu;
    private int mType = 0;
    private TbRichTextCommInfo bfN = null;
    private TbRichTextImageInfo bfn = null;
    private TbRichTextVoiceInfo aye = null;
    private TbRichTextEmotionInfo bfq = null;
    private f bfr = null;
    private TbRichTextLinkButtonInfo bft = null;
    private TbRichTextLinkImageInfo bfs = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.bfN = tbRichTextCommInfo;
        this.bfn = tbRichTextImageInfo;
        this.aye = tbRichTextVoiceInfo;
        this.bfq = tbRichTextEmotionInfo;
        this.bft = tbRichTextLinkButtonInfo;
        this.bfs = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo NL() {
        if (this.mType == 1280) {
            return this.bfs;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo NM() {
        if (this.mType == 1024) {
            return this.bft;
        }
        return null;
    }

    public TbRichTextImageInfo ND() {
        if (this.mType == 8) {
            return this.bfn;
        }
        return null;
    }

    public f NH() {
        if (this.mType != 32) {
            return null;
        }
        return this.bfr;
    }

    public TbRichTextVoiceInfo NF() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aye;
        }
        return null;
    }

    public TbRichTextEmotionInfo NI() {
        if (this.mType == 17) {
            return this.bfq;
        }
        return null;
    }

    public TbRichTextMemeInfo NJ() {
        if (this.mType == 20) {
            return this.bfu;
        }
        return null;
    }

    private SpannableString NY() {
        if (this.mType != 1 || this.bfN == null) {
            return null;
        }
        return new SpannableString(this.bfN.getText());
    }

    private CharSequence w(ArrayList<b> arrayList) {
        SpannableString b;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.bfN != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(d.j.video_text));
            CharSequence y = y(arrayList);
            if (y != null) {
                spannableStringBuilder.append(y);
            }
            if (this.bfN.Ny() == 1) {
                b = b(this.mType, this.bfN.getText(), this.bfN.Nz(), 0);
            } else {
                b = b(this.mType, this.bfN.getText(), this.bfN.getText(), 0);
            }
            if (b != null) {
                spannableStringBuilder.append((CharSequence) b);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence x(ArrayList<b> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.bfN != null) {
            CharSequence y = y(arrayList);
            if (y != null) {
                spannableStringBuilder.append(y);
            }
            SpannableString b = b(this.mType, this.bfN.getLink(), this.bfN.getLink(), 0);
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
        if (this.mType != 32 || this.bfN == null) {
            return null;
        }
        if (this.bfN.Ny() == 1) {
            return this.bfN.Nz();
        }
        return this.bfN.getText();
    }

    private SpannableString NZ() {
        if ((this.mType != 2 && this.mType != 18) || this.bfN == null) {
            return null;
        }
        if (this.bfN.Ny() == 1) {
            return b(this.mType, this.bfN.getText(), this.bfN.Nz(), 0);
        }
        return b(this.mType, this.bfN.getText(), this.bfN.getLink(), this.bfN.NA());
    }

    private SpannableString Oa() {
        if (this.mType != 256 || this.bfN == null) {
            return null;
        }
        String text = this.bfN.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = text + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        c cVar = new c(this.mType, text);
        cVar.hT(this.bfN.getLink());
        spannableString.setSpan(cVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString Ob() {
        if (this.mType != 16 || this.bfN == null) {
            return null;
        }
        return b(this.mType, this.bfN.getText(), this.bfN.getLink(), 0);
    }

    private SpannableString z(ArrayList<b> arrayList) {
        String text;
        int gA;
        a.C0113a gZ;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.bfN != null && this.bfN.getText() != null && this.bfN.getLink() != null && (gA = TbFaceManager.IP().gA((text = this.bfN.getText()))) != 0) {
            String str = "#(" + TbFaceManager.IP().gC(text) + ")";
            spannableString = new SpannableString(str + " ");
            b bVar = new b(TbadkCoreApplication.getInst().getContext(), gA);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            if (TbFaceManager.IP().gZ(text) != null) {
                int width = (int) (0.5d * gZ.getWidth());
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
            cVar.gb(i2);
            if (i2 == 1) {
                cVar.setTextColor(d.C0140d.cp_cont_d);
            } else {
                cVar.setTextColor(-1);
            }
            spannableString.setSpan(cVar, 0, str.length() - 1, 33);
        }
        return spannableString;
    }

    private SpannableString Oc() {
        if (this.mType != 1024 || this.bft == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString("a");
        Drawable gd = d.gd(this.bft.btn_type);
        gd.setBounds(0, 0, gd.getIntrinsicWidth(), gd.getIntrinsicHeight());
        com.baidu.tbadk.widget.c cVar = new com.baidu.tbadk.widget.c(gd);
        cVar.setVerticalOffset(l.f(TbadkCoreApplication.getInst().getContext(), d.e.ds4));
        spannableString.setSpan(cVar, 0, 1, 33);
        spannableString.setSpan(new c(1024, this.bft.link), spannableString.length() - 1, "a".length(), 33);
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
        if (r7.bfr.Om() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = gc(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.bfn = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.bfN = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.bfq = new TbRichTextEmotionInfo();
                    this.bfq.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.bfq.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.bfq.mGifInfo.mStaticUrl = pbContent._static;
                    this.bfq.mType = this.mType;
                    this.bfq.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.bfq.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.bfq.mGifInfo.mPackageName = pbContent.packet_name;
                    this.bfq.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.bfq.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.bfq.mGifInfo.mGid = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.bfq.mGifInfo.mGid = split[i].split("_")[0];
                case 20:
                    this.bfu = new TbRichTextMemeInfo();
                    this.bfu.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.aye = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.bft = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case 1280:
                    this.bfs = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.bfr = new f();
                        this.bfr.b(pbContent);
                        break;
                    }
                    this.bfN = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.IP().gA(this.bfN.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(d.j.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.bfN.setText(str);
                            break;
                        } else {
                            this.bfN.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.bfN.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.bfN != null) {
                this.bfN.NB();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = gc(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.bfn = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.aye = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.bfN = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.bfq = new TbRichTextEmotionInfo();
                this.bfq.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.bfq.mGifInfo.mDynamicUrl = jSONObject.optString("dynamic");
                this.bfq.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.bfq.mType = this.mType;
                this.bfq.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.bfq.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.bfq.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.bfq.mGifInfo.mIcon = jSONObject.optString("icon");
                String[] split = this.bfq.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.bfq.mGifInfo.mGid = split[i].split("_")[0];
            } else {
                this.bfN = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int gA = TbFaceManager.IP().gA(this.bfN.getText());
                    String optString = jSONObject.optString("c");
                    if (gA <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(d.j.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.bfN.setText(str);
                    } else {
                        this.bfN.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.bfN.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.bfN != null) {
                this.bfN.NB();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int gc(int i) {
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
