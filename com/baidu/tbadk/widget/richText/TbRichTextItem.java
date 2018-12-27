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
    private TbRichTextMemeInfo brh;
    private int mType = 0;
    private TbRichTextCommInfo brz = null;
    private TbRichTextImageInfo bra = null;
    private TbRichTextVoiceInfo aJX = null;
    private TbRichTextEmotionInfo brd = null;
    private f bre = null;
    private TbRichTextLinkButtonInfo brg = null;
    private TbRichTextLinkImageInfo brf = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.brz = tbRichTextCommInfo;
        this.bra = tbRichTextImageInfo;
        this.aJX = tbRichTextVoiceInfo;
        this.brd = tbRichTextEmotionInfo;
        this.brg = tbRichTextLinkButtonInfo;
        this.brf = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo Sp() {
        if (this.mType == 1280) {
            return this.brf;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo Sq() {
        if (this.mType == 1024) {
            return this.brg;
        }
        return null;
    }

    public TbRichTextImageInfo Sh() {
        if (this.mType == 8) {
            return this.bra;
        }
        return null;
    }

    public f Sl() {
        if (this.mType != 32) {
            return null;
        }
        return this.bre;
    }

    public TbRichTextVoiceInfo Sj() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aJX;
        }
        return null;
    }

    public TbRichTextEmotionInfo Sm() {
        if (this.mType == 17) {
            return this.brd;
        }
        return null;
    }

    public TbRichTextMemeInfo Sn() {
        if (this.mType == 20) {
            return this.brh;
        }
        return null;
    }

    private SpannableString SC() {
        if (this.mType != 1 || this.brz == null) {
            return null;
        }
        return new SpannableString(this.brz.getText());
    }

    private CharSequence w(ArrayList<b> arrayList) {
        SpannableString b;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.brz != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(e.j.video_text));
            CharSequence y = y(arrayList);
            if (y != null) {
                spannableStringBuilder.append(y);
            }
            if (this.brz.Sc() == 1) {
                b = b(this.mType, this.brz.getText(), this.brz.Sd(), 0);
            } else {
                b = b(this.mType, this.brz.getText(), this.brz.getText(), 0);
            }
            if (b != null) {
                spannableStringBuilder.append((CharSequence) b);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence x(ArrayList<b> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.brz != null) {
            CharSequence y = y(arrayList);
            if (y != null) {
                spannableStringBuilder.append(y);
            }
            SpannableString b = b(this.mType, this.brz.getLink(), this.brz.getLink(), 0);
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
        if (this.mType != 32 || this.brz == null) {
            return null;
        }
        if (this.brz.Sc() == 1) {
            return this.brz.Sd();
        }
        return this.brz.getText();
    }

    private SpannableString SD() {
        if ((this.mType != 2 && this.mType != 18) || this.brz == null) {
            return null;
        }
        if (this.brz.Sc() == 1) {
            return b(this.mType, this.brz.getText(), this.brz.Sd(), 0);
        }
        return b(this.mType, this.brz.getText(), this.brz.getLink(), this.brz.Se());
    }

    private SpannableString SE() {
        if (this.mType != 256 || this.brz == null) {
            return null;
        }
        String text = this.brz.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = text + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        c cVar = new c(this.mType, text);
        cVar.ja(this.brz.getLink());
        spannableString.setSpan(cVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString SF() {
        if (this.mType != 16 || this.brz == null) {
            return null;
        }
        return b(this.mType, this.brz.getText(), this.brz.getLink(), 0);
    }

    private SpannableString z(ArrayList<b> arrayList) {
        String text;
        int hE;
        a.C0171a ic;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.brz != null && this.brz.getText() != null && this.brz.getLink() != null && (hE = TbFaceManager.Nu().hE((text = this.brz.getText()))) != 0) {
            String str = "#(" + TbFaceManager.Nu().hG(text) + ")";
            spannableString = new SpannableString(str + " ");
            b bVar = new b(TbadkCoreApplication.getInst().getContext(), hE);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            if (TbFaceManager.Nu().ic(text) != null) {
                int width = (int) (0.5d * ic.getWidth());
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
            cVar.gX(i2);
            if (i2 == 1) {
                cVar.setTextColor(e.d.cp_cont_d);
            } else {
                cVar.setTextColor(-1);
            }
            spannableString.setSpan(cVar, 0, str.length() - 1, 33);
        }
        return spannableString;
    }

    private SpannableString SG() {
        if (this.mType != 1024 || this.brg == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(Config.APP_VERSION_CODE);
        Drawable gZ = d.gZ(this.brg.btn_type);
        gZ.setBounds(0, 0, gZ.getIntrinsicWidth(), gZ.getIntrinsicHeight());
        com.baidu.tbadk.widget.c cVar = new com.baidu.tbadk.widget.c(gZ);
        cVar.setVerticalOffset(l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.ds4));
        spannableString.setSpan(cVar, 0, 1, 33);
        spannableString.setSpan(new c(1024, this.brg.link), spannableString.length() - 1, Config.APP_VERSION_CODE.length(), 33);
        return spannableString;
    }

    public CharSequence A(ArrayList<b> arrayList) {
        switch (this.mType) {
            case 1:
                return SC();
            case 2:
                return SD();
            case 4:
                return z(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return SF();
            case 18:
                return SD();
            case 32:
                return w(arrayList);
            case 128:
                return x(arrayList);
            case 256:
                return SE();
            case 1024:
                return SG();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.bre.SQ() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = gY(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.bra = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.brz = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.brd = new TbRichTextEmotionInfo();
                    this.brd.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.brd.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.brd.mGifInfo.mStaticUrl = pbContent._static;
                    this.brd.mType = this.mType;
                    this.brd.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.brd.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.brd.mGifInfo.mPackageName = pbContent.packet_name;
                    this.brd.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.brd.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.brd.mGifInfo.mGid = split[i].split(BaseRequestAction.SPLITE)[0];
                            break;
                        }
                    }
                    this.brd.mGifInfo.mGid = split[i].split(BaseRequestAction.SPLITE)[0];
                case 20:
                    this.brh = new TbRichTextMemeInfo();
                    this.brh.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.aJX = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.brg = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case 1280:
                    this.brf = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.bre = new f();
                        this.bre.b(pbContent);
                        break;
                    }
                    this.brz = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.Nu().hE(this.brz.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(e.j.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.brz.setText(str);
                            break;
                        } else {
                            this.brz.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.brz.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.brz != null) {
                this.brz.Sf();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = gY(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.bra = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.aJX = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.brz = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.brd = new TbRichTextEmotionInfo();
                this.brd.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.brd.mGifInfo.mDynamicUrl = jSONObject.optString("dynamic");
                this.brd.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.brd.mType = this.mType;
                this.brd.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.brd.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.brd.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.brd.mGifInfo.mIcon = jSONObject.optString(AiAppUnitedSchemeUtilsDispatcher.PARAM_TOAST_ICON_KEY);
                String[] split = this.brd.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.brd.mGifInfo.mGid = split[i].split(BaseRequestAction.SPLITE)[0];
            } else {
                this.brz = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int hE = TbFaceManager.Nu().hE(this.brz.getText());
                    String optString = jSONObject.optString("c");
                    if (hE <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(e.j.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.brz.setText(str);
                    } else {
                        this.brz.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.brz.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.brz != null) {
                this.brz.Sf();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int gY(int i) {
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
