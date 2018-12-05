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
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.searchbox.ng.ai.apps.scheme.AiAppUnitedSchemeUtilsDispatcher;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.e;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextItem extends OrmObject {
    private TbRichTextMemeInfo bre;
    private int mType = 0;
    private TbRichTextCommInfo brw = null;
    private TbRichTextImageInfo bqX = null;
    private TbRichTextVoiceInfo aJV = null;
    private TbRichTextEmotionInfo bra = null;
    private f brb = null;
    private TbRichTextLinkButtonInfo brd = null;
    private TbRichTextLinkImageInfo brc = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.brw = tbRichTextCommInfo;
        this.bqX = tbRichTextImageInfo;
        this.aJV = tbRichTextVoiceInfo;
        this.bra = tbRichTextEmotionInfo;
        this.brd = tbRichTextLinkButtonInfo;
        this.brc = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo Sn() {
        if (this.mType == 1280) {
            return this.brc;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo So() {
        if (this.mType == 1024) {
            return this.brd;
        }
        return null;
    }

    public TbRichTextImageInfo Sf() {
        if (this.mType == 8) {
            return this.bqX;
        }
        return null;
    }

    public f Sj() {
        if (this.mType != 32) {
            return null;
        }
        return this.brb;
    }

    public TbRichTextVoiceInfo Sh() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aJV;
        }
        return null;
    }

    public TbRichTextEmotionInfo Sk() {
        if (this.mType == 17) {
            return this.bra;
        }
        return null;
    }

    public TbRichTextMemeInfo Sl() {
        if (this.mType == 20) {
            return this.bre;
        }
        return null;
    }

    private SpannableString SA() {
        if (this.mType != 1 || this.brw == null) {
            return null;
        }
        return new SpannableString(this.brw.getText());
    }

    private CharSequence w(ArrayList<b> arrayList) {
        SpannableString b;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.brw != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(e.j.video_text));
            CharSequence y = y(arrayList);
            if (y != null) {
                spannableStringBuilder.append(y);
            }
            if (this.brw.Sa() == 1) {
                b = b(this.mType, this.brw.getText(), this.brw.Sb(), 0);
            } else {
                b = b(this.mType, this.brw.getText(), this.brw.getText(), 0);
            }
            if (b != null) {
                spannableStringBuilder.append((CharSequence) b);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence x(ArrayList<b> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.brw != null) {
            CharSequence y = y(arrayList);
            if (y != null) {
                spannableStringBuilder.append(y);
            }
            SpannableString b = b(this.mType, this.brw.getLink(), this.brw.getLink(), 0);
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
        if (this.mType != 32 || this.brw == null) {
            return null;
        }
        if (this.brw.Sa() == 1) {
            return this.brw.Sb();
        }
        return this.brw.getText();
    }

    private SpannableString SB() {
        if ((this.mType != 2 && this.mType != 18) || this.brw == null) {
            return null;
        }
        if (this.brw.Sa() == 1) {
            return b(this.mType, this.brw.getText(), this.brw.Sb(), 0);
        }
        return b(this.mType, this.brw.getText(), this.brw.getLink(), this.brw.Sc());
    }

    private SpannableString SC() {
        if (this.mType != 256 || this.brw == null) {
            return null;
        }
        String text = this.brw.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = text + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        c cVar = new c(this.mType, text);
        cVar.iZ(this.brw.getLink());
        spannableString.setSpan(cVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString SD() {
        if (this.mType != 16 || this.brw == null) {
            return null;
        }
        return b(this.mType, this.brw.getText(), this.brw.getLink(), 0);
    }

    private SpannableString z(ArrayList<b> arrayList) {
        String text;
        int hD;
        a.C0171a ib;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.brw != null && this.brw.getText() != null && this.brw.getLink() != null && (hD = TbFaceManager.Nt().hD((text = this.brw.getText()))) != 0) {
            String str = "#(" + TbFaceManager.Nt().hF(text) + ")";
            spannableString = new SpannableString(str + " ");
            b bVar = new b(TbadkCoreApplication.getInst().getContext(), hD);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            if (TbFaceManager.Nt().ib(text) != null) {
                int width = (int) (0.5d * ib.getWidth());
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
            cVar.gW(i2);
            if (i2 == 1) {
                cVar.setTextColor(e.d.cp_cont_d);
            } else {
                cVar.setTextColor(-1);
            }
            spannableString.setSpan(cVar, 0, str.length() - 1, 33);
        }
        return spannableString;
    }

    private SpannableString SE() {
        if (this.mType != 1024 || this.brd == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(Config.APP_VERSION_CODE);
        Drawable gY = d.gY(this.brd.btn_type);
        gY.setBounds(0, 0, gY.getIntrinsicWidth(), gY.getIntrinsicHeight());
        com.baidu.tbadk.widget.c cVar = new com.baidu.tbadk.widget.c(gY);
        cVar.setVerticalOffset(l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.ds4));
        spannableString.setSpan(cVar, 0, 1, 33);
        spannableString.setSpan(new c(1024, this.brd.link), spannableString.length() - 1, Config.APP_VERSION_CODE.length(), 33);
        return spannableString;
    }

    public CharSequence A(ArrayList<b> arrayList) {
        switch (this.mType) {
            case 1:
                return SA();
            case 2:
                return SB();
            case 4:
                return z(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return SD();
            case 18:
                return SB();
            case 32:
                return w(arrayList);
            case 128:
                return x(arrayList);
            case 256:
                return SC();
            case 1024:
                return SE();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.brb.SO() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = gX(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.bqX = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.brw = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.bra = new TbRichTextEmotionInfo();
                    this.bra.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.bra.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.bra.mGifInfo.mStaticUrl = pbContent._static;
                    this.bra.mType = this.mType;
                    this.bra.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.bra.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.bra.mGifInfo.mPackageName = pbContent.packet_name;
                    this.bra.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.bra.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.bra.mGifInfo.mGid = split[i].split(BaseRequestAction.SPLITE)[0];
                            break;
                        }
                    }
                    this.bra.mGifInfo.mGid = split[i].split(BaseRequestAction.SPLITE)[0];
                case 20:
                    this.bre = new TbRichTextMemeInfo();
                    this.bre.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.aJV = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.brd = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case 1280:
                    this.brc = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.brb = new f();
                        this.brb.b(pbContent);
                        break;
                    }
                    this.brw = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.Nt().hD(this.brw.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(e.j.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.brw.setText(str);
                            break;
                        } else {
                            this.brw.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.brw.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.brw != null) {
                this.brw.Sd();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = gX(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.bqX = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.aJV = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.brw = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.bra = new TbRichTextEmotionInfo();
                this.bra.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.bra.mGifInfo.mDynamicUrl = jSONObject.optString("dynamic");
                this.bra.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.bra.mType = this.mType;
                this.bra.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.bra.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.bra.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.bra.mGifInfo.mIcon = jSONObject.optString(AiAppUnitedSchemeUtilsDispatcher.PARAM_TOAST_ICON_KEY);
                String[] split = this.bra.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.bra.mGifInfo.mGid = split[i].split(BaseRequestAction.SPLITE)[0];
            } else {
                this.brw = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int hD = TbFaceManager.Nt().hD(this.brw.getText());
                    String optString = jSONObject.optString("c");
                    if (hD <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(e.j.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.brw.setText(str);
                    } else {
                        this.brw.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.brw.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.brw != null) {
                this.brw.Sd();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int gX(int i) {
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
