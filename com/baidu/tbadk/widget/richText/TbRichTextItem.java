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
    private TbRichTextMemeInfo brV;
    private int mType = 0;
    private TbRichTextCommInfo bsn = null;
    private TbRichTextImageInfo brO = null;
    private TbRichTextVoiceInfo aKz = null;
    private TbRichTextEmotionInfo brR = null;
    private f brS = null;
    private TbRichTextLinkButtonInfo brU = null;
    private TbRichTextLinkImageInfo brT = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.bsn = tbRichTextCommInfo;
        this.brO = tbRichTextImageInfo;
        this.aKz = tbRichTextVoiceInfo;
        this.brR = tbRichTextEmotionInfo;
        this.brU = tbRichTextLinkButtonInfo;
        this.brT = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo SL() {
        if (this.mType == 1280) {
            return this.brT;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo SM() {
        if (this.mType == 1024) {
            return this.brU;
        }
        return null;
    }

    public TbRichTextImageInfo SD() {
        if (this.mType == 8) {
            return this.brO;
        }
        return null;
    }

    public f SH() {
        if (this.mType != 32) {
            return null;
        }
        return this.brS;
    }

    public TbRichTextVoiceInfo SF() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aKz;
        }
        return null;
    }

    public TbRichTextEmotionInfo SI() {
        if (this.mType == 17) {
            return this.brR;
        }
        return null;
    }

    public TbRichTextMemeInfo SJ() {
        if (this.mType == 20) {
            return this.brV;
        }
        return null;
    }

    private SpannableString SY() {
        if (this.mType != 1 || this.bsn == null) {
            return null;
        }
        return new SpannableString(this.bsn.getText());
    }

    private CharSequence w(ArrayList<b> arrayList) {
        SpannableString b;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.bsn != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(e.j.video_text));
            CharSequence y = y(arrayList);
            if (y != null) {
                spannableStringBuilder.append(y);
            }
            if (this.bsn.Sy() == 1) {
                b = b(this.mType, this.bsn.getText(), this.bsn.Sz(), 0);
            } else {
                b = b(this.mType, this.bsn.getText(), this.bsn.getText(), 0);
            }
            if (b != null) {
                spannableStringBuilder.append((CharSequence) b);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence x(ArrayList<b> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.bsn != null) {
            CharSequence y = y(arrayList);
            if (y != null) {
                spannableStringBuilder.append(y);
            }
            SpannableString b = b(this.mType, this.bsn.getLink(), this.bsn.getLink(), 0);
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
        if (this.mType != 32 || this.bsn == null) {
            return null;
        }
        if (this.bsn.Sy() == 1) {
            return this.bsn.Sz();
        }
        return this.bsn.getText();
    }

    private SpannableString SZ() {
        if ((this.mType != 2 && this.mType != 18) || this.bsn == null) {
            return null;
        }
        if (this.bsn.Sy() == 1) {
            return b(this.mType, this.bsn.getText(), this.bsn.Sz(), 0);
        }
        return b(this.mType, this.bsn.getText(), this.bsn.getLink(), this.bsn.SA());
    }

    private SpannableString Ta() {
        if (this.mType != 256 || this.bsn == null) {
            return null;
        }
        String text = this.bsn.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = text + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        c cVar = new c(this.mType, text);
        cVar.jq(this.bsn.getLink());
        spannableString.setSpan(cVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString Tb() {
        if (this.mType != 16 || this.bsn == null) {
            return null;
        }
        return b(this.mType, this.bsn.getText(), this.bsn.getLink(), 0);
    }

    private SpannableString z(ArrayList<b> arrayList) {
        String text;
        int hS;
        a.C0171a ir;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.bsn != null && this.bsn.getText() != null && this.bsn.getLink() != null && (hS = TbFaceManager.NL().hS((text = this.bsn.getText()))) != 0) {
            String str = "#(" + TbFaceManager.NL().hU(text) + ")";
            spannableString = new SpannableString(str + " ");
            b bVar = new b(TbadkCoreApplication.getInst().getContext(), hS);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            if (TbFaceManager.NL().ir(text) != null) {
                int width = (int) (0.5d * ir.getWidth());
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

    private SpannableString Tc() {
        if (this.mType != 1024 || this.brU == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(Config.APP_VERSION_CODE);
        Drawable gZ = d.gZ(this.brU.btn_type);
        gZ.setBounds(0, 0, gZ.getIntrinsicWidth(), gZ.getIntrinsicHeight());
        com.baidu.tbadk.widget.c cVar = new com.baidu.tbadk.widget.c(gZ);
        cVar.setVerticalOffset(l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.ds4));
        spannableString.setSpan(cVar, 0, 1, 33);
        spannableString.setSpan(new c(1024, this.brU.link), spannableString.length() - 1, Config.APP_VERSION_CODE.length(), 33);
        return spannableString;
    }

    public CharSequence A(ArrayList<b> arrayList) {
        switch (this.mType) {
            case 1:
                return SY();
            case 2:
                return SZ();
            case 4:
                return z(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return Tb();
            case 18:
                return SZ();
            case 32:
                return w(arrayList);
            case 128:
                return x(arrayList);
            case 256:
                return Ta();
            case 1024:
                return Tc();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.brS.Tm() != false) goto L9;
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
                    this.brO = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.bsn = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.brR = new TbRichTextEmotionInfo();
                    this.brR.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.brR.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.brR.mGifInfo.mStaticUrl = pbContent._static;
                    this.brR.mType = this.mType;
                    this.brR.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.brR.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.brR.mGifInfo.mPackageName = pbContent.packet_name;
                    this.brR.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.brR.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.brR.mGifInfo.mGid = split[i].split(BaseRequestAction.SPLITE)[0];
                            break;
                        }
                    }
                    this.brR.mGifInfo.mGid = split[i].split(BaseRequestAction.SPLITE)[0];
                case 20:
                    this.brV = new TbRichTextMemeInfo();
                    this.brV.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.aKz = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.brU = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case 1280:
                    this.brT = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.brS = new f();
                        this.brS.b(pbContent);
                        break;
                    }
                    this.bsn = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.NL().hS(this.bsn.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(e.j.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.bsn.setText(str);
                            break;
                        } else {
                            this.bsn.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.bsn.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.bsn != null) {
                this.bsn.SB();
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
                this.brO = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.aKz = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.bsn = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.brR = new TbRichTextEmotionInfo();
                this.brR.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.brR.mGifInfo.mDynamicUrl = jSONObject.optString("dynamic");
                this.brR.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.brR.mType = this.mType;
                this.brR.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.brR.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.brR.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.brR.mGifInfo.mIcon = jSONObject.optString(AiAppUnitedSchemeUtilsDispatcher.PARAM_TOAST_ICON_KEY);
                String[] split = this.brR.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.brR.mGifInfo.mGid = split[i].split(BaseRequestAction.SPLITE)[0];
            } else {
                this.bsn = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int hS = TbFaceManager.NL().hS(this.bsn.getText());
                    String optString = jSONObject.optString("c");
                    if (hS <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(e.j.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.bsn.setText(str);
                    } else {
                        this.bsn.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.bsn.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.bsn != null) {
                this.bsn.SB();
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
