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
    private TbRichTextMemeInfo bmV;
    private int mType = 0;
    private TbRichTextCommInfo bnn = null;
    private TbRichTextImageInfo bmO = null;
    private TbRichTextVoiceInfo aFF = null;
    private TbRichTextEmotionInfo bmR = null;
    private f bmS = null;
    private TbRichTextLinkButtonInfo bmU = null;
    private TbRichTextLinkImageInfo bmT = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.bnn = tbRichTextCommInfo;
        this.bmO = tbRichTextImageInfo;
        this.aFF = tbRichTextVoiceInfo;
        this.bmR = tbRichTextEmotionInfo;
        this.bmU = tbRichTextLinkButtonInfo;
        this.bmT = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo QY() {
        if (this.mType == 1280) {
            return this.bmT;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo QZ() {
        if (this.mType == 1024) {
            return this.bmU;
        }
        return null;
    }

    public TbRichTextImageInfo QQ() {
        if (this.mType == 8) {
            return this.bmO;
        }
        return null;
    }

    public f QU() {
        if (this.mType != 32) {
            return null;
        }
        return this.bmS;
    }

    public TbRichTextVoiceInfo QS() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aFF;
        }
        return null;
    }

    public TbRichTextEmotionInfo QV() {
        if (this.mType == 17) {
            return this.bmR;
        }
        return null;
    }

    public TbRichTextMemeInfo QW() {
        if (this.mType == 20) {
            return this.bmV;
        }
        return null;
    }

    private SpannableString Rl() {
        if (this.mType != 1 || this.bnn == null) {
            return null;
        }
        return new SpannableString(this.bnn.getText());
    }

    private CharSequence w(ArrayList<b> arrayList) {
        SpannableString b;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.bnn != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(e.j.video_text));
            CharSequence y = y(arrayList);
            if (y != null) {
                spannableStringBuilder.append(y);
            }
            if (this.bnn.QL() == 1) {
                b = b(this.mType, this.bnn.getText(), this.bnn.QM(), 0);
            } else {
                b = b(this.mType, this.bnn.getText(), this.bnn.getText(), 0);
            }
            if (b != null) {
                spannableStringBuilder.append((CharSequence) b);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence x(ArrayList<b> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.bnn != null) {
            CharSequence y = y(arrayList);
            if (y != null) {
                spannableStringBuilder.append(y);
            }
            SpannableString b = b(this.mType, this.bnn.getLink(), this.bnn.getLink(), 0);
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
        if (this.mType != 32 || this.bnn == null) {
            return null;
        }
        if (this.bnn.QL() == 1) {
            return this.bnn.QM();
        }
        return this.bnn.getText();
    }

    private SpannableString Rm() {
        if ((this.mType != 2 && this.mType != 18) || this.bnn == null) {
            return null;
        }
        if (this.bnn.QL() == 1) {
            return b(this.mType, this.bnn.getText(), this.bnn.QM(), 0);
        }
        return b(this.mType, this.bnn.getText(), this.bnn.getLink(), this.bnn.QN());
    }

    private SpannableString Rn() {
        if (this.mType != 256 || this.bnn == null) {
            return null;
        }
        String text = this.bnn.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = text + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        c cVar = new c(this.mType, text);
        cVar.iF(this.bnn.getLink());
        spannableString.setSpan(cVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString Ro() {
        if (this.mType != 16 || this.bnn == null) {
            return null;
        }
        return b(this.mType, this.bnn.getText(), this.bnn.getLink(), 0);
    }

    private SpannableString z(ArrayList<b> arrayList) {
        String text;
        int hk;
        a.C0137a hJ;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.bnn != null && this.bnn.getText() != null && this.bnn.getLink() != null && (hk = TbFaceManager.Md().hk((text = this.bnn.getText()))) != 0) {
            String str = "#(" + TbFaceManager.Md().hm(text) + ")";
            spannableString = new SpannableString(str + " ");
            b bVar = new b(TbadkCoreApplication.getInst().getContext(), hk);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            if (TbFaceManager.Md().hJ(text) != null) {
                int width = (int) (0.5d * hJ.getWidth());
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
            cVar.gu(i2);
            if (i2 == 1) {
                cVar.setTextColor(e.d.cp_cont_d);
            } else {
                cVar.setTextColor(-1);
            }
            spannableString.setSpan(cVar, 0, str.length() - 1, 33);
        }
        return spannableString;
    }

    private SpannableString Rp() {
        if (this.mType != 1024 || this.bmU == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(Config.APP_VERSION_CODE);
        Drawable gw = d.gw(this.bmU.btn_type);
        gw.setBounds(0, 0, gw.getIntrinsicWidth(), gw.getIntrinsicHeight());
        com.baidu.tbadk.widget.c cVar = new com.baidu.tbadk.widget.c(gw);
        cVar.setVerticalOffset(l.h(TbadkCoreApplication.getInst().getContext(), e.C0175e.ds4));
        spannableString.setSpan(cVar, 0, 1, 33);
        spannableString.setSpan(new c(1024, this.bmU.link), spannableString.length() - 1, Config.APP_VERSION_CODE.length(), 33);
        return spannableString;
    }

    public CharSequence A(ArrayList<b> arrayList) {
        switch (this.mType) {
            case 1:
                return Rl();
            case 2:
                return Rm();
            case 4:
                return z(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return Ro();
            case 18:
                return Rm();
            case 32:
                return w(arrayList);
            case 128:
                return x(arrayList);
            case 256:
                return Rn();
            case 1024:
                return Rp();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.bmS.Rz() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = gv(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.bmO = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.bnn = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.bmR = new TbRichTextEmotionInfo();
                    this.bmR.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.bmR.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.bmR.mGifInfo.mStaticUrl = pbContent._static;
                    this.bmR.mType = this.mType;
                    this.bmR.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.bmR.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.bmR.mGifInfo.mPackageName = pbContent.packet_name;
                    this.bmR.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.bmR.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.bmR.mGifInfo.mGid = split[i].split(BaseRequestAction.SPLITE)[0];
                            break;
                        }
                    }
                    this.bmR.mGifInfo.mGid = split[i].split(BaseRequestAction.SPLITE)[0];
                case 20:
                    this.bmV = new TbRichTextMemeInfo();
                    this.bmV.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.aFF = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.bmU = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case 1280:
                    this.bmT = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.bmS = new f();
                        this.bmS.b(pbContent);
                        break;
                    }
                    this.bnn = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.Md().hk(this.bnn.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(e.j.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.bnn.setText(str);
                            break;
                        } else {
                            this.bnn.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.bnn.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.bnn != null) {
                this.bnn.QO();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = gv(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.bmO = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.aFF = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.bnn = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.bmR = new TbRichTextEmotionInfo();
                this.bmR.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.bmR.mGifInfo.mDynamicUrl = jSONObject.optString("dynamic");
                this.bmR.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.bmR.mType = this.mType;
                this.bmR.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.bmR.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.bmR.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.bmR.mGifInfo.mIcon = jSONObject.optString(AiAppUnitedSchemeUtilsDispatcher.PARAM_TOAST_ICON_KEY);
                String[] split = this.bmR.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.bmR.mGifInfo.mGid = split[i].split(BaseRequestAction.SPLITE)[0];
            } else {
                this.bnn = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int hk = TbFaceManager.Md().hk(this.bnn.getText());
                    String optString = jSONObject.optString("c");
                    if (hk <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(e.j.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.bnn.setText(str);
                    } else {
                        this.bnn.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.bnn.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.bnn != null) {
                this.bnn.QO();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int gv(int i) {
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
