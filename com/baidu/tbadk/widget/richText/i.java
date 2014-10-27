package com.baidu.tbadk.widget.richText;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.y;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.lib.a.b.a.a.i {
    private int mType = 0;
    private b abK = null;
    private g abu = null;
    private u abw = null;
    private e aby = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, b bVar, g gVar, u uVar, e eVar) {
        this.mType = i;
        this.abK = bVar;
        this.abu = gVar;
        this.abw = uVar;
        this.aby = eVar;
    }

    public g vD() {
        if (this.mType == 8) {
            return this.abu;
        }
        return null;
    }

    public u vF() {
        if (this.mType == 512 || this.mType == 768) {
            return this.abw;
        }
        return null;
    }

    public e vH() {
        if (this.mType == 17) {
            return this.aby;
        }
        return null;
    }

    public SpannableString vM() {
        if (this.mType != 1 || this.abK == null) {
            return null;
        }
        return new SpannableString(this.abK.getText());
    }

    public CharSequence a(Context context, ArrayList<f> arrayList) {
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.abK != null) {
            spannableStringBuilder.append((CharSequence) context.getString(y.video_text));
            CharSequence c = c(context, arrayList);
            if (c != null) {
                spannableStringBuilder.append(c);
            }
            if (this.abK.vz() == 1) {
                a = a(context, this.mType, this.abK.getText(), this.abK.vA());
            } else {
                a = a(context, this.mType, this.abK.getText(), this.abK.getText());
            }
            if (a != null) {
                spannableStringBuilder.append((CharSequence) a);
            }
        }
        return spannableStringBuilder;
    }

    public CharSequence b(Context context, ArrayList<f> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.abK != null) {
            CharSequence c = c(context, arrayList);
            if (c != null) {
                spannableStringBuilder.append(c);
            }
            SpannableString a = a(context, this.mType, this.abK.getLink(), this.abK.getLink());
            if (a != null) {
                spannableStringBuilder.append((CharSequence) a);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence c(Context context, ArrayList<f> arrayList) {
        i iVar = new i();
        iVar.a(4, new b("video_icon", " "), null, null, null);
        return iVar.e(context, arrayList);
    }

    public String getVideoUrl() {
        if (this.mType != 32 || this.abK == null) {
            return null;
        }
        if (this.abK.vz() == 1) {
            return this.abK.vA();
        }
        return this.abK.getText();
    }

    public SpannableString G(Context context) {
        if (this.mType != 2 || this.abK == null) {
            return null;
        }
        if (this.abK.vz() == 1) {
            return a(context, this.mType, this.abK.getText(), this.abK.vA());
        }
        return a(context, this.mType, this.abK.getText(), this.abK.getLink());
    }

    public SpannableString H(Context context) {
        if (this.mType != 256 || this.abK == null) {
            return null;
        }
        String text = this.abK.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = String.valueOf(text) + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        h hVar = new h(context, this.mType, text);
        hVar.dR(this.abK.getLink());
        spannableString.setSpan(hVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    public SpannableString I(Context context) {
        if (this.mType != 16 || this.abK == null) {
            return null;
        }
        return a(context, this.mType, this.abK.getText(), this.abK.getLink());
    }

    private SpannableString d(Context context, ArrayList<f> arrayList) {
        String text;
        int dd;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.abK != null && this.abK.getText() != null && this.abK.getLink() != null && (dd = TbFaceManager.sf().dd((text = this.abK.getText()))) != 0) {
            String str = "#(" + TbFaceManager.sf().df(text) + ")";
            spannableString = new SpannableString(String.valueOf(str) + " ");
            f fVar = new f(TbadkApplication.m251getInst(), dd);
            if (arrayList != null) {
                arrayList.add(fVar);
            }
            com.baidu.tbadk.imageManager.c dp = TbFaceManager.sf().dp(text);
            if (dp != null) {
                fVar.setBounds(new Rect(0, 0, dp.getWidth(), dp.getHeight()));
            } else {
                fVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(fVar, 0), 0, str.length(), 33);
        }
        return spannableString;
    }

    private SpannableString a(Context context, int i, String str, String str2) {
        if (str == null) {
            return null;
        }
        if (!str.endsWith(" ")) {
            str = String.valueOf(str) + " ";
        }
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new h(context, i, str2), 0, str.length() - 1, 33);
        return spannableString;
    }

    public CharSequence e(Context context, ArrayList<f> arrayList) {
        switch (this.mType) {
            case 1:
                return vM();
            case 2:
                return G(context);
            case 4:
                return d(context, arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return I(context);
            case AccessibilityNodeInfoCompat.ACTION_LONG_CLICK /* 32 */:
                return a(context, arrayList);
            case 128:
                return b(context, arrayList);
            case 256:
                return H(context);
        }
    }

    public void a(PbContent pbContent) {
        int i = 0;
        try {
            this.mType = dv(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.abu = new g(pbContent);
                    break;
                case 16:
                    this.abK = new b(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.aby = new e();
                    this.aby.TF.Tf = String.format("#(%s)", pbContent.c);
                    this.aby.TF.Th = pbContent.dynamic;
                    this.aby.TF.Tg = pbContent._static;
                    this.aby.mType = this.mType;
                    this.aby.TF.Tj = pbContent.width.intValue();
                    this.aby.TF.Tk = pbContent.height.intValue();
                    this.aby.TF.mPackageName = pbContent.packet_name;
                    this.aby.TF.Tl = pbContent._static;
                    String[] split = this.aby.TF.Th.split("/");
                    for (String str : split) {
                        i++;
                        if (str.equals("faceshop")) {
                            this.aby.TF.Ti = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.aby.TF.Ti = split[i].split("_")[0];
                case 512:
                    this.abw = new u(pbContent);
                    break;
                default:
                    this.abK = new b(pbContent);
                    if (this.mType == 4) {
                        String str2 = "[" + pbContent.c + "]";
                        if (TbFaceManager.sf().dd(this.abK.getText()) <= 0) {
                            this.mType = 1;
                            this.abK.setText(str2);
                            break;
                        } else {
                            this.abK.setLink(str2);
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.abK.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.abK != null) {
                this.abK.vB();
            }
        } catch (Exception e) {
        }
    }

    public void parserJson(JSONObject jSONObject) {
        int i = 0;
        try {
            this.mType = dv(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.abu = new g(jSONObject);
            } else if (this.mType == 512) {
                this.abw = new u(jSONObject);
            } else if (this.mType == 16) {
                this.abK = new b(jSONObject.optString("text"), jSONObject.optString(SapiAccountManager.SESSION_UID));
            } else if (this.mType == 17) {
                this.aby = new e();
                this.aby.TF.Tf = String.format("#(%s)", jSONObject.optString("c"));
                this.aby.TF.Th = jSONObject.optString("dynamic");
                this.aby.TF.Tg = jSONObject.optString("static");
                this.aby.mType = this.mType;
                this.aby.TF.Tj = jSONObject.optInt("width", Constants.MEDIA_INFO);
                this.aby.TF.Tk = jSONObject.optInt("height", Constants.MEDIA_INFO);
                this.aby.TF.mPackageName = jSONObject.optString("packet_name", "");
                this.aby.TF.Tl = jSONObject.optString("icon");
                String[] split = this.aby.TF.Th.split("/");
                for (String str : split) {
                    i++;
                    if (str.equals("faceshop")) {
                        break;
                    }
                }
                this.aby.TF.Ti = split[i].split("_")[0];
            } else {
                this.abK = new b(jSONObject);
                if (this.mType == 4) {
                    String str2 = "[" + jSONObject.optString("c") + "]";
                    if (TbFaceManager.sf().dd(this.abK.getText()) <= 0) {
                        this.mType = 1;
                        this.abK.setText(str2);
                    } else {
                        this.abK.setLink(str2);
                    }
                } else if (this.mType == 256) {
                    this.abK.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.abK != null) {
                this.abK.vB();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int dv(int i) {
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
        }
    }
}
