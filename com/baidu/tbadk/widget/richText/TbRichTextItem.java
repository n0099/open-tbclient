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
import com.baidu.tieba.f;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextItem extends OrmObject {
    private TbRichTextMemeInfo bfv;
    private int mType = 0;
    private TbRichTextCommInfo bfO = null;
    private TbRichTextImageInfo bfo = null;
    private TbRichTextVoiceInfo ayb = null;
    private TbRichTextEmotionInfo bfr = null;
    private f bfs = null;
    private TbRichTextLinkButtonInfo bfu = null;
    private TbRichTextLinkImageInfo bft = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.bfO = tbRichTextCommInfo;
        this.bfo = tbRichTextImageInfo;
        this.ayb = tbRichTextVoiceInfo;
        this.bfr = tbRichTextEmotionInfo;
        this.bfu = tbRichTextLinkButtonInfo;
        this.bft = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo NK() {
        if (this.mType == 1280) {
            return this.bft;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo NL() {
        if (this.mType == 1024) {
            return this.bfu;
        }
        return null;
    }

    public TbRichTextImageInfo NC() {
        if (this.mType == 8) {
            return this.bfo;
        }
        return null;
    }

    public f NG() {
        if (this.mType != 32) {
            return null;
        }
        return this.bfs;
    }

    public TbRichTextVoiceInfo NE() {
        if (this.mType == 512 || this.mType == 768) {
            return this.ayb;
        }
        return null;
    }

    public TbRichTextEmotionInfo NH() {
        if (this.mType == 17) {
            return this.bfr;
        }
        return null;
    }

    public TbRichTextMemeInfo NI() {
        if (this.mType == 20) {
            return this.bfv;
        }
        return null;
    }

    private SpannableString NX() {
        if (this.mType != 1 || this.bfO == null) {
            return null;
        }
        return new SpannableString(this.bfO.getText());
    }

    private CharSequence w(ArrayList<b> arrayList) {
        SpannableString b;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.bfO != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(f.j.video_text));
            CharSequence y = y(arrayList);
            if (y != null) {
                spannableStringBuilder.append(y);
            }
            if (this.bfO.Nx() == 1) {
                b = b(this.mType, this.bfO.getText(), this.bfO.Ny(), 0);
            } else {
                b = b(this.mType, this.bfO.getText(), this.bfO.getText(), 0);
            }
            if (b != null) {
                spannableStringBuilder.append((CharSequence) b);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence x(ArrayList<b> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.bfO != null) {
            CharSequence y = y(arrayList);
            if (y != null) {
                spannableStringBuilder.append(y);
            }
            SpannableString b = b(this.mType, this.bfO.getLink(), this.bfO.getLink(), 0);
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
        if (this.mType != 32 || this.bfO == null) {
            return null;
        }
        if (this.bfO.Nx() == 1) {
            return this.bfO.Ny();
        }
        return this.bfO.getText();
    }

    private SpannableString NY() {
        if ((this.mType != 2 && this.mType != 18) || this.bfO == null) {
            return null;
        }
        if (this.bfO.Nx() == 1) {
            return b(this.mType, this.bfO.getText(), this.bfO.Ny(), 0);
        }
        return b(this.mType, this.bfO.getText(), this.bfO.getLink(), this.bfO.Nz());
    }

    private SpannableString NZ() {
        if (this.mType != 256 || this.bfO == null) {
            return null;
        }
        String text = this.bfO.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = text + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        c cVar = new c(this.mType, text);
        cVar.hU(this.bfO.getLink());
        spannableString.setSpan(cVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString Oa() {
        if (this.mType != 16 || this.bfO == null) {
            return null;
        }
        return b(this.mType, this.bfO.getText(), this.bfO.getLink(), 0);
    }

    private SpannableString z(ArrayList<b> arrayList) {
        String text;
        int gA;
        a.C0113a gZ;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.bfO != null && this.bfO.getText() != null && this.bfO.getLink() != null && (gA = TbFaceManager.IP().gA((text = this.bfO.getText()))) != 0) {
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
            cVar.ga(i2);
            if (i2 == 1) {
                cVar.setTextColor(f.d.cp_cont_d);
            } else {
                cVar.setTextColor(-1);
            }
            spannableString.setSpan(cVar, 0, str.length() - 1, 33);
        }
        return spannableString;
    }

    private SpannableString Ob() {
        if (this.mType != 1024 || this.bfu == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString("a");
        Drawable gc = d.gc(this.bfu.btn_type);
        gc.setBounds(0, 0, gc.getIntrinsicWidth(), gc.getIntrinsicHeight());
        com.baidu.tbadk.widget.c cVar = new com.baidu.tbadk.widget.c(gc);
        cVar.setVerticalOffset(l.f(TbadkCoreApplication.getInst().getContext(), f.e.ds4));
        spannableString.setSpan(cVar, 0, 1, 33);
        spannableString.setSpan(new c(1024, this.bfu.link), spannableString.length() - 1, "a".length(), 33);
        return spannableString;
    }

    public CharSequence A(ArrayList<b> arrayList) {
        switch (this.mType) {
            case 1:
                return NX();
            case 2:
                return NY();
            case 4:
                return z(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return Oa();
            case 18:
                return NY();
            case 32:
                return w(arrayList);
            case 128:
                return x(arrayList);
            case 256:
                return NZ();
            case 1024:
                return Ob();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.bfs.Ol() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = gb(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.bfo = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.bfO = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.bfr = new TbRichTextEmotionInfo();
                    this.bfr.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.bfr.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.bfr.mGifInfo.mStaticUrl = pbContent._static;
                    this.bfr.mType = this.mType;
                    this.bfr.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.bfr.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.bfr.mGifInfo.mPackageName = pbContent.packet_name;
                    this.bfr.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.bfr.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.bfr.mGifInfo.mGid = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.bfr.mGifInfo.mGid = split[i].split("_")[0];
                case 20:
                    this.bfv = new TbRichTextMemeInfo();
                    this.bfv.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.ayb = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.bfu = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case 1280:
                    this.bft = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.bfs = new f();
                        this.bfs.b(pbContent);
                        break;
                    }
                    this.bfO = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.IP().gA(this.bfO.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(f.j.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.bfO.setText(str);
                            break;
                        } else {
                            this.bfO.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.bfO.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.bfO != null) {
                this.bfO.NA();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = gb(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.bfo = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.ayb = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.bfO = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.bfr = new TbRichTextEmotionInfo();
                this.bfr.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.bfr.mGifInfo.mDynamicUrl = jSONObject.optString("dynamic");
                this.bfr.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.bfr.mType = this.mType;
                this.bfr.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.bfr.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.bfr.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.bfr.mGifInfo.mIcon = jSONObject.optString("icon");
                String[] split = this.bfr.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.bfr.mGifInfo.mGid = split[i].split("_")[0];
            } else {
                this.bfO = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int gA = TbFaceManager.IP().gA(this.bfO.getText());
                    String optString = jSONObject.optString("c");
                    if (gA <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(f.j.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.bfO.setText(str);
                    } else {
                        this.bfO.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.bfO.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.bfO != null) {
                this.bfO.NA();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int gb(int i) {
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
