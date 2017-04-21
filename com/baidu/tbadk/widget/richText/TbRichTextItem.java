package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.w;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextItem extends OrmObject {
    private TbRichTextGraffitiInfo aMU;
    private int mType = 0;
    private TbRichTextCommInfo aNj = null;
    private TbRichTextImageInfo aMM = null;
    private TbRichTextVoiceInfo aMO = null;
    private TbRichTextEmotionInfo aMQ = null;
    private e aMR = null;
    private TbRichTextLinkButtonInfo aMT = null;
    private TbRichTextLinkImageInfo aMS = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.aNj = tbRichTextCommInfo;
        this.aMM = tbRichTextImageInfo;
        this.aMO = tbRichTextVoiceInfo;
        this.aMQ = tbRichTextEmotionInfo;
        this.aMT = tbRichTextLinkButtonInfo;
        this.aMS = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo IB() {
        if (this.mType == 1280) {
            return this.aMS;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo IC() {
        if (this.mType == 1024) {
            return this.aMT;
        }
        return null;
    }

    public TbRichTextImageInfo Iu() {
        if (this.mType == 8) {
            return this.aMM;
        }
        return null;
    }

    public e Iy() {
        if (this.mType != 32) {
            return null;
        }
        return this.aMR;
    }

    public TbRichTextVoiceInfo Iw() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aMO;
        }
        return null;
    }

    public TbRichTextEmotionInfo Iz() {
        if (this.mType == 17) {
            return this.aMQ;
        }
        return null;
    }

    public TbRichTextGraffitiInfo ID() {
        if (this.mType == 1536) {
            return this.aMU;
        }
        return null;
    }

    private SpannableString IL() {
        if (this.mType != 1 || this.aNj == null) {
            return null;
        }
        return new SpannableString(this.aNj.getText());
    }

    private CharSequence t(ArrayList<a> arrayList) {
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.aNj != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.m9getInst().getString(w.l.video_text));
            CharSequence v = v(arrayList);
            if (v != null) {
                spannableStringBuilder.append(v);
            }
            if (this.aNj.Ip() == 1) {
                a = a(this.mType, this.aNj.getText(), this.aNj.Iq(), 0);
            } else {
                a = a(this.mType, this.aNj.getText(), this.aNj.getText(), 0);
            }
            if (a != null) {
                spannableStringBuilder.append((CharSequence) a);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence u(ArrayList<a> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.aNj != null) {
            CharSequence v = v(arrayList);
            if (v != null) {
                spannableStringBuilder.append(v);
            }
            SpannableString a = a(this.mType, this.aNj.getLink(), this.aNj.getLink(), 0);
            if (a != null) {
                spannableStringBuilder.append((CharSequence) a);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence v(ArrayList<a> arrayList) {
        TbRichTextItem tbRichTextItem = new TbRichTextItem();
        tbRichTextItem.a(4, new TbRichTextCommInfo("video_icon", " "), null, null, null, null, null);
        return tbRichTextItem.x(arrayList);
    }

    public String getVideoUrl() {
        if (this.mType != 32 || this.aNj == null) {
            return null;
        }
        if (this.aNj.Ip() == 1) {
            return this.aNj.Iq();
        }
        return this.aNj.getText();
    }

    private SpannableString IM() {
        if ((this.mType != 2 && this.mType != 18) || this.aNj == null) {
            return null;
        }
        if (this.aNj.Ip() == 1) {
            return a(this.mType, this.aNj.getText(), this.aNj.Iq(), 0);
        }
        return a(this.mType, this.aNj.getText(), this.aNj.getLink(), this.aNj.Ir());
    }

    private SpannableString IN() {
        if (this.mType != 256 || this.aNj == null) {
            return null;
        }
        String text = this.aNj.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = String.valueOf(text) + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        b bVar = new b(this.mType, text);
        bVar.gu(this.aNj.getLink());
        spannableString.setSpan(bVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString IO() {
        if (this.mType != 16 || this.aNj == null) {
            return null;
        }
        return a(this.mType, this.aNj.getText(), this.aNj.getLink(), 0);
    }

    private SpannableString w(ArrayList<a> arrayList) {
        String text;
        int fi;
        a.C0041a fK;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.aNj != null && this.aNj.getText() != null && this.aNj.getLink() != null && (fi = TbFaceManager.EI().fi((text = this.aNj.getText()))) != 0) {
            String str = "#(" + TbFaceManager.EI().fk(text) + ")";
            spannableString = new SpannableString(String.valueOf(str) + " ");
            a aVar = new a(TbadkCoreApplication.m9getInst().getContext(), fi);
            if (arrayList != null) {
                arrayList.add(aVar);
            }
            if (TbFaceManager.EI().fK(text) != null) {
                int width = (int) (fK.getWidth() * 0.5d);
                aVar.setBounds(new Rect(0, 0, width, width));
            } else {
                aVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new com.baidu.tbadk.widget.g(aVar), 0, str.length(), 33);
        }
        return spannableString;
    }

    private SpannableString a(int i, String str, String str2, int i2) {
        SpannableString spannableString = null;
        if (str != null) {
            if (!str.endsWith(" ")) {
                str = String.valueOf(str) + " ";
            }
            spannableString = new SpannableString(str);
            b bVar = new b(i, str2);
            bVar.fw(i2);
            if (i2 == 1) {
                bVar.setTextColor(w.e.cp_cont_d);
            } else {
                bVar.setTextColor(-1);
            }
            spannableString.setSpan(bVar, 0, str.length() - 1, 33);
        }
        return spannableString;
    }

    private SpannableString IP() {
        if (this.mType != 1024 || this.aMT == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString("a");
        Drawable fy = c.fy(this.aMT.btn_type);
        fy.setBounds(0, 0, fy.getIntrinsicWidth(), fy.getIntrinsicHeight());
        com.baidu.tbadk.widget.g gVar = new com.baidu.tbadk.widget.g(fy);
        gVar.setVerticalOffset(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getContext(), w.f.ds4));
        spannableString.setSpan(gVar, 0, 1, 33);
        spannableString.setSpan(new b(1024, this.aMT.link), spannableString.length() - 1, "a".length(), 33);
        return spannableString;
    }

    public CharSequence x(ArrayList<a> arrayList) {
        switch (this.mType) {
            case 1:
                return IL();
            case 2:
                return IM();
            case 4:
                return w(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return IO();
            case 18:
                return IM();
            case 32:
                return t(arrayList);
            case 128:
                return u(arrayList);
            case 256:
                return IN();
            case 1024:
                return IP();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.aMR.IZ() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = fx(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.aMM = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.aNj = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.aMQ = new TbRichTextEmotionInfo();
                    this.aMQ.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.aMQ.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.aMQ.mGifInfo.mStaticUrl = pbContent._static;
                    this.aMQ.mType = this.mType;
                    this.aMQ.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.aMQ.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.aMQ.mGifInfo.mPackageName = pbContent.packet_name;
                    this.aMQ.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.aMQ.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.aMQ.mGifInfo.mGid = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.aMQ.mGifInfo.mGid = split[i].split("_")[0];
                case 512:
                    this.aMO = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.aMT = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case 1280:
                    this.aMS = new TbRichTextLinkImageInfo(pbContent);
                    break;
                case 1536:
                    this.aMU = new TbRichTextGraffitiInfo();
                    this.aMU.a(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.aMR = new e();
                        this.aMR.a(pbContent);
                        break;
                    }
                    this.aNj = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.EI().fi(this.aNj.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.m9getInst().getString(w.l.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.aNj.setText(str);
                            break;
                        } else {
                            this.aNj.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.aNj.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.aNj != null) {
                this.aNj.Is();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = fx(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.aMM = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.aMO = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.aNj = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString(SapiAccountManager.SESSION_UID));
            } else if (this.mType == 17) {
                this.aMQ = new TbRichTextEmotionInfo();
                this.aMQ.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.aMQ.mGifInfo.mDynamicUrl = jSONObject.optString("dynamic");
                this.aMQ.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.aMQ.mType = this.mType;
                this.aMQ.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.aMQ.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.aMQ.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.aMQ.mGifInfo.mIcon = jSONObject.optString("icon");
                String[] split = this.aMQ.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.aMQ.mGifInfo.mGid = split[i].split("_")[0];
            } else {
                this.aNj = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int fi = TbFaceManager.EI().fi(this.aNj.getText());
                    String optString = jSONObject.optString("c");
                    if (fi <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.m9getInst().getString(w.l.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.aNj.setText(str);
                    } else {
                        this.aNj.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.aNj.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.aNj != null) {
                this.aNj.Is();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int fx(int i) {
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
            case 17:
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
            case 16:
                return 1536;
            case 18:
                return 18;
        }
    }
}
