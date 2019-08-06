package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.k;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.R;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextItem extends OrmObject {
    private TbRichTextMemeInfo cMw;
    private int mType = 0;
    private TbRichTextCommInfo cMO = null;
    private TbRichTextImageInfo cMp = null;
    private TbRichTextVoiceInfo cct = null;
    private TbRichTextEmotionInfo cMs = null;
    private f cMt = null;
    private TbRichTextLinkButtonInfo cMv = null;
    private TbRichTextLinkImageInfo cMu = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.cMO = tbRichTextCommInfo;
        this.cMp = tbRichTextImageInfo;
        this.cct = tbRichTextVoiceInfo;
        this.cMs = tbRichTextEmotionInfo;
        this.cMv = tbRichTextLinkButtonInfo;
        this.cMu = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo azc() {
        if (this.mType == 1280) {
            return this.cMu;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo azd() {
        if (this.mType == 1024) {
            return this.cMv;
        }
        return null;
    }

    public TbRichTextImageInfo ayU() {
        if (this.mType == 8) {
            return this.cMp;
        }
        return null;
    }

    public f ayY() {
        if (this.mType != 32) {
            return null;
        }
        return this.cMt;
    }

    public TbRichTextVoiceInfo ayW() {
        if (this.mType == 512 || this.mType == 768) {
            return this.cct;
        }
        return null;
    }

    public TbRichTextEmotionInfo ayZ() {
        if (this.mType == 17) {
            return this.cMs;
        }
        return null;
    }

    public TbRichTextMemeInfo aza() {
        if (this.mType == 20) {
            return this.cMw;
        }
        return null;
    }

    private SpannableString azo() {
        if (this.mType != 1 || this.cMO == null) {
            return null;
        }
        return new SpannableString(this.cMO.getText());
    }

    private CharSequence C(ArrayList<b> arrayList) {
        SpannableString b;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.cMO != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(R.string.video_text));
            CharSequence E = E(arrayList);
            if (E != null) {
                spannableStringBuilder.append(E);
            }
            if (this.cMO.ayP() == 1) {
                b = b(this.mType, this.cMO.getText(), this.cMO.ayQ(), 0);
            } else {
                b = b(this.mType, this.cMO.getText(), this.cMO.getText(), 0);
            }
            if (b != null) {
                spannableStringBuilder.append((CharSequence) b);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence D(ArrayList<b> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.cMO != null) {
            CharSequence E = E(arrayList);
            if (E != null) {
                spannableStringBuilder.append(E);
            }
            SpannableString b = b(this.mType, this.cMO.getLink(), this.cMO.getLink(), 0);
            if (b != null) {
                spannableStringBuilder.append((CharSequence) b);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence E(ArrayList<b> arrayList) {
        TbRichTextItem tbRichTextItem = new TbRichTextItem();
        tbRichTextItem.a(4, new TbRichTextCommInfo("video_icon", " "), null, null, null, null, null);
        return tbRichTextItem.G(arrayList);
    }

    public String getVideoUrl() {
        if (this.mType != 32 || this.cMO == null) {
            return null;
        }
        if (this.cMO.ayP() == 1) {
            return this.cMO.ayQ();
        }
        return this.cMO.getText();
    }

    private SpannableString azp() {
        if ((this.mType != 2 && this.mType != 18) || this.cMO == null) {
            return null;
        }
        if (this.cMO.ayP() == 1) {
            return b(this.mType, this.cMO.getText(), this.cMO.ayQ(), 0);
        }
        return b(this.mType, this.cMO.getText(), this.cMO.getLink(), this.cMO.ayR());
    }

    private SpannableString azq() {
        if (this.mType != 256 || this.cMO == null) {
            return null;
        }
        String text = this.cMO.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = text + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        c cVar = new c(this.mType, text);
        cVar.rB(this.cMO.getLink());
        spannableString.setSpan(cVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString azr() {
        if (this.mType != 16 || this.cMO == null) {
            return null;
        }
        return b(this.mType, this.cMO.getText(), this.cMO.getLink(), 0);
    }

    private SpannableString F(ArrayList<b> arrayList) {
        String text;
        int qf;
        a.C0255a qC;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.cMO != null && this.cMO.getText() != null && this.cMO.getLink() != null && (qf = TbFaceManager.atx().qf((text = this.cMO.getText()))) != 0) {
            String str = "#(" + TbFaceManager.atx().qh(text) + ")";
            spannableString = new SpannableString(str + " ");
            b bVar = new b(TbadkCoreApplication.getInst().getContext(), qf);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            if (TbFaceManager.atx().qC(text) != null) {
                int width = (int) (0.5d * qC.getWidth());
                bVar.setBounds(new Rect(0, 0, width, width));
            } else {
                bVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new com.baidu.tbadk.widget.a(bVar, 1), 0, str.length(), 33);
        }
        return spannableString;
    }

    private SpannableString b(int i, String str, final String str2, int i2) {
        c cVar;
        if (str == null) {
            return null;
        }
        if (!str.endsWith(" ")) {
            str = str + " ";
        }
        SpannableString spannableString = new SpannableString(str);
        if (this.mType == 18) {
            cVar = new c(i, str2) { // from class: com.baidu.tbadk.widget.richText.TbRichTextItem.1
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    TbRichTextItem.this.mF(str2);
                }
            };
        } else {
            cVar = new c(i, str2);
        }
        cVar.lH(i2);
        if (i2 == 1) {
            cVar.setTextColor(R.color.cp_cont_d);
        } else {
            cVar.setTextColor(-1);
        }
        spannableString.setSpan(cVar, 0, str.length() - 1, 33);
        return spannableString;
    }

    private SpannableString azs() {
        if (this.mType != 1024 || this.cMv == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(Config.APP_VERSION_CODE);
        Drawable lJ = d.lJ(this.cMv.btn_type);
        lJ.setBounds(0, 0, lJ.getIntrinsicWidth(), lJ.getIntrinsicHeight());
        com.baidu.tbadk.widget.c cVar = new com.baidu.tbadk.widget.c(lJ);
        cVar.setVerticalOffset(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds4));
        spannableString.setSpan(cVar, 0, 1, 33);
        spannableString.setSpan(new c(1024, this.cMv.link), spannableString.length() - 1, Config.APP_VERSION_CODE.length(), 33);
        return spannableString;
    }

    public CharSequence G(ArrayList<b> arrayList) {
        switch (this.mType) {
            case 1:
                return azo();
            case 2:
                return azp();
            case 4:
                return F(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return azr();
            case 18:
                return azp();
            case 32:
                return C(arrayList);
            case 128:
                return D(arrayList);
            case 256:
                return azq();
            case 1024:
                return azs();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.cMt.azC() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = lI(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.cMp = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.cMO = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.cMs = new TbRichTextEmotionInfo();
                    this.cMs.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.cMs.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.cMs.mGifInfo.mStaticUrl = pbContent._static;
                    this.cMs.mType = this.mType;
                    this.cMs.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.cMs.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.cMs.mGifInfo.mPackageName = pbContent.packet_name;
                    this.cMs.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.cMs.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.cMs.mGifInfo.mGid = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.cMs.mGifInfo.mGid = split[i].split("_")[0];
                case 20:
                    this.cMw = new TbRichTextMemeInfo();
                    this.cMw.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.cct = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.cMv = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case 1280:
                    this.cMu = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.cMt = new f();
                        this.cMt.b(pbContent);
                        break;
                    }
                    this.cMO = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.atx().qf(this.cMO.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.cMO.setText(str);
                            break;
                        } else {
                            this.cMO.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.cMO.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.cMO != null) {
                this.cMO.ayS();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = lI(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.cMp = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.cct = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.cMO = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.cMs = new TbRichTextEmotionInfo();
                this.cMs.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.cMs.mGifInfo.mDynamicUrl = jSONObject.optString("dynamic");
                this.cMs.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.cMs.mType = this.mType;
                this.cMs.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.cMs.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.cMs.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.cMs.mGifInfo.mIcon = jSONObject.optString("icon");
                String[] split = this.cMs.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.cMs.mGifInfo.mGid = split[i].split("_")[0];
            } else {
                this.cMO = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int qf = TbFaceManager.atx().qf(this.cMO.getText());
                    String optString = jSONObject.optString("c");
                    if (qf <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.cMO.setText(str);
                    } else {
                        this.cMO.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.cMO.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.cMO != null) {
                this.cMO.ayS();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int lI(int i) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mF(String str) {
        if (!TextUtils.isEmpty(str)) {
            k kVar = new k();
            kVar.mLink = str;
            kVar.type = 0;
            kVar.cqZ = "1";
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, kVar));
        }
    }
}
