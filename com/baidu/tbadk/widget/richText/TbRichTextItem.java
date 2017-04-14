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
    private TbRichTextGraffitiInfo aMS;
    private int mType = 0;
    private TbRichTextCommInfo aNh = null;
    private TbRichTextImageInfo aMK = null;
    private TbRichTextVoiceInfo aMM = null;
    private TbRichTextEmotionInfo aMO = null;
    private e aMP = null;
    private TbRichTextLinkButtonInfo aMR = null;
    private TbRichTextLinkImageInfo aMQ = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.aNh = tbRichTextCommInfo;
        this.aMK = tbRichTextImageInfo;
        this.aMM = tbRichTextVoiceInfo;
        this.aMO = tbRichTextEmotionInfo;
        this.aMR = tbRichTextLinkButtonInfo;
        this.aMQ = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo IB() {
        if (this.mType == 1280) {
            return this.aMQ;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo IC() {
        if (this.mType == 1024) {
            return this.aMR;
        }
        return null;
    }

    public TbRichTextImageInfo Iu() {
        if (this.mType == 8) {
            return this.aMK;
        }
        return null;
    }

    public e Iy() {
        if (this.mType != 32) {
            return null;
        }
        return this.aMP;
    }

    public TbRichTextVoiceInfo Iw() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aMM;
        }
        return null;
    }

    public TbRichTextEmotionInfo Iz() {
        if (this.mType == 17) {
            return this.aMO;
        }
        return null;
    }

    public TbRichTextGraffitiInfo ID() {
        if (this.mType == 1536) {
            return this.aMS;
        }
        return null;
    }

    private SpannableString IL() {
        if (this.mType != 1 || this.aNh == null) {
            return null;
        }
        return new SpannableString(this.aNh.getText());
    }

    private CharSequence t(ArrayList<a> arrayList) {
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.aNh != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.m9getInst().getString(w.l.video_text));
            CharSequence v = v(arrayList);
            if (v != null) {
                spannableStringBuilder.append(v);
            }
            if (this.aNh.Ip() == 1) {
                a = a(this.mType, this.aNh.getText(), this.aNh.Iq(), 0);
            } else {
                a = a(this.mType, this.aNh.getText(), this.aNh.getText(), 0);
            }
            if (a != null) {
                spannableStringBuilder.append((CharSequence) a);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence u(ArrayList<a> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.aNh != null) {
            CharSequence v = v(arrayList);
            if (v != null) {
                spannableStringBuilder.append(v);
            }
            SpannableString a = a(this.mType, this.aNh.getLink(), this.aNh.getLink(), 0);
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
        if (this.mType != 32 || this.aNh == null) {
            return null;
        }
        if (this.aNh.Ip() == 1) {
            return this.aNh.Iq();
        }
        return this.aNh.getText();
    }

    private SpannableString IM() {
        if ((this.mType != 2 && this.mType != 18) || this.aNh == null) {
            return null;
        }
        if (this.aNh.Ip() == 1) {
            return a(this.mType, this.aNh.getText(), this.aNh.Iq(), 0);
        }
        return a(this.mType, this.aNh.getText(), this.aNh.getLink(), this.aNh.Ir());
    }

    private SpannableString IN() {
        if (this.mType != 256 || this.aNh == null) {
            return null;
        }
        String text = this.aNh.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = String.valueOf(text) + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        b bVar = new b(this.mType, text);
        bVar.gu(this.aNh.getLink());
        spannableString.setSpan(bVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString IO() {
        if (this.mType != 16 || this.aNh == null) {
            return null;
        }
        return a(this.mType, this.aNh.getText(), this.aNh.getLink(), 0);
    }

    private SpannableString w(ArrayList<a> arrayList) {
        String text;
        int fi;
        a.C0041a fK;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.aNh != null && this.aNh.getText() != null && this.aNh.getLink() != null && (fi = TbFaceManager.EI().fi((text = this.aNh.getText()))) != 0) {
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
        if (this.mType != 1024 || this.aMR == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString("a");
        Drawable fy = c.fy(this.aMR.btn_type);
        fy.setBounds(0, 0, fy.getIntrinsicWidth(), fy.getIntrinsicHeight());
        com.baidu.tbadk.widget.g gVar = new com.baidu.tbadk.widget.g(fy);
        gVar.setVerticalOffset(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getContext(), w.f.ds4));
        spannableString.setSpan(gVar, 0, 1, 33);
        spannableString.setSpan(new b(1024, this.aMR.link), spannableString.length() - 1, "a".length(), 33);
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
        if (r7.aMP.IZ() != false) goto L9;
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
                    this.aMK = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.aNh = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.aMO = new TbRichTextEmotionInfo();
                    this.aMO.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.aMO.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.aMO.mGifInfo.mStaticUrl = pbContent._static;
                    this.aMO.mType = this.mType;
                    this.aMO.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.aMO.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.aMO.mGifInfo.mPackageName = pbContent.packet_name;
                    this.aMO.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.aMO.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.aMO.mGifInfo.mGid = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.aMO.mGifInfo.mGid = split[i].split("_")[0];
                case 512:
                    this.aMM = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.aMR = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case 1280:
                    this.aMQ = new TbRichTextLinkImageInfo(pbContent);
                    break;
                case 1536:
                    this.aMS = new TbRichTextGraffitiInfo();
                    this.aMS.a(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.aMP = new e();
                        this.aMP.a(pbContent);
                        break;
                    }
                    this.aNh = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.EI().fi(this.aNh.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.m9getInst().getString(w.l.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.aNh.setText(str);
                            break;
                        } else {
                            this.aNh.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.aNh.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.aNh != null) {
                this.aNh.Is();
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
                this.aMK = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.aMM = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.aNh = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString(SapiAccountManager.SESSION_UID));
            } else if (this.mType == 17) {
                this.aMO = new TbRichTextEmotionInfo();
                this.aMO.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.aMO.mGifInfo.mDynamicUrl = jSONObject.optString("dynamic");
                this.aMO.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.aMO.mType = this.mType;
                this.aMO.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.aMO.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.aMO.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.aMO.mGifInfo.mIcon = jSONObject.optString("icon");
                String[] split = this.aMO.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.aMO.mGifInfo.mGid = split[i].split("_")[0];
            } else {
                this.aNh = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int fi = TbFaceManager.EI().fi(this.aNh.getText());
                    String optString = jSONObject.optString("c");
                    if (fi <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.m9getInst().getString(w.l.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.aNh.setText(str);
                    } else {
                        this.aNh.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.aNh.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.aNh != null) {
                this.aNh.Is();
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
