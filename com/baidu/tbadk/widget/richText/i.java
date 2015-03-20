package com.baidu.tbadk.widget.richText;

import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.y;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.lib.a.b.a.a.i {
    private int mType = 0;
    private b asA = null;
    private g asj = null;
    private u asl = null;
    private e asn = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, b bVar, g gVar, u uVar, e eVar) {
        this.mType = i;
        this.asA = bVar;
        this.asj = gVar;
        this.asl = uVar;
        this.asn = eVar;
    }

    public g DA() {
        if (this.mType == 8) {
            return this.asj;
        }
        return null;
    }

    public u DC() {
        if (this.mType == 512 || this.mType == 768) {
            return this.asl;
        }
        return null;
    }

    public e DE() {
        if (this.mType == 17) {
            return this.asn;
        }
        return null;
    }

    public SpannableString DK() {
        if (this.mType != 1 || this.asA == null) {
            return null;
        }
        return new SpannableString(this.asA.getText());
    }

    public CharSequence b(Context context, ArrayList<f> arrayList) {
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.asA != null) {
            spannableStringBuilder.append((CharSequence) context.getString(y.video_text));
            CharSequence d = d(context, arrayList);
            if (d != null) {
                spannableStringBuilder.append(d);
            }
            if (this.asA.Dw() == 1) {
                a = a(context, this.mType, this.asA.getText(), this.asA.Dx());
            } else {
                a = a(context, this.mType, this.asA.getText(), this.asA.getText());
            }
            if (a != null) {
                spannableStringBuilder.append((CharSequence) a);
            }
        }
        return spannableStringBuilder;
    }

    public CharSequence c(Context context, ArrayList<f> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.asA != null) {
            CharSequence d = d(context, arrayList);
            if (d != null) {
                spannableStringBuilder.append(d);
            }
            SpannableString a = a(context, this.mType, this.asA.getLink(), this.asA.getLink());
            if (a != null) {
                spannableStringBuilder.append((CharSequence) a);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence d(Context context, ArrayList<f> arrayList) {
        i iVar = new i();
        iVar.a(4, new b("video_icon", " "), null, null, null);
        return iVar.f(context, arrayList);
    }

    public String getVideoUrl() {
        if (this.mType != 32 || this.asA == null) {
            return null;
        }
        if (this.asA.Dw() == 1) {
            return this.asA.Dx();
        }
        return this.asA.getText();
    }

    public SpannableString ag(Context context) {
        if (this.mType != 2 || this.asA == null) {
            return null;
        }
        if (this.asA.Dw() == 1) {
            return a(context, this.mType, this.asA.getText(), this.asA.Dx());
        }
        return a(context, this.mType, this.asA.getText(), this.asA.getLink());
    }

    public SpannableString ah(Context context) {
        if (this.mType != 256 || this.asA == null) {
            return null;
        }
        String text = this.asA.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = String.valueOf(text) + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        h hVar = new h(context, this.mType, text);
        hVar.eN(this.asA.getLink());
        spannableString.setSpan(hVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    public SpannableString ai(Context context) {
        if (this.mType != 16 || this.asA == null) {
            return null;
        }
        return a(context, this.mType, this.asA.getText(), this.asA.getLink());
    }

    private SpannableString e(Context context, ArrayList<f> arrayList) {
        String text;
        int ea;
        com.baidu.tbadk.imageManager.c en;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.asA != null && this.asA.getText() != null && this.asA.getLink() != null && (ea = TbFaceManager.zr().ea((text = this.asA.getText()))) != 0) {
            String str = "#(" + TbFaceManager.zr().ec(text) + ")";
            spannableString = new SpannableString(String.valueOf(str) + " ");
            f fVar = new f(TbadkCoreApplication.m411getInst().getContext(), ea);
            if (arrayList != null) {
                arrayList.add(fVar);
            }
            if (TbFaceManager.zr().en(text) != null) {
                int width = (int) (en.getWidth() * 0.5d);
                fVar.setBounds(new Rect(0, 0, width, width));
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

    public CharSequence f(Context context, ArrayList<f> arrayList) {
        switch (this.mType) {
            case 1:
                return DK();
            case 2:
                return ag(context);
            case 4:
                return e(context, arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return ai(context);
            case 32:
                return b(context, arrayList);
            case 128:
                return c(context, arrayList);
            case 256:
                return ah(context);
        }
    }

    public void a(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = ei(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.asj = new g(pbContent);
                    break;
                case 16:
                    this.asA = new b(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.asn = new e();
                    this.asn.akK.akk = String.format("#(%s)", pbContent.c);
                    this.asn.akK.akm = pbContent.dynamic;
                    this.asn.akK.akl = pbContent._static;
                    this.asn.mType = this.mType;
                    this.asn.akK.ako = pbContent.width.intValue();
                    this.asn.akK.akp = pbContent.height.intValue();
                    this.asn.akK.mPackageName = pbContent.packet_name;
                    this.asn.akK.akq = pbContent._static;
                    String[] split = this.asn.akK.akm.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.asn.akK.akn = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.asn.akK.akn = split[i].split("_")[0];
                case 512:
                    this.asl = new u(pbContent);
                    break;
                default:
                    this.asA = new b(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.zr().ea(this.asA.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.m411getInst().getString(y.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.asA.setText(str);
                            break;
                        } else {
                            this.asA.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.asA.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.asA != null) {
                this.asA.Dy();
            }
        } catch (Exception e) {
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = ei(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.asj = new g(jSONObject);
            } else if (this.mType == 512) {
                this.asl = new u(jSONObject);
            } else if (this.mType == 16) {
                this.asA = new b(jSONObject.optString("text"), jSONObject.optString(SapiAccountManager.SESSION_UID));
            } else if (this.mType == 17) {
                this.asn = new e();
                this.asn.akK.akk = String.format("#(%s)", jSONObject.optString("c"));
                this.asn.akK.akm = jSONObject.optString("dynamic");
                this.asn.akK.akl = jSONObject.optString("static");
                this.asn.mType = this.mType;
                this.asn.akK.ako = jSONObject.optInt("width", 200);
                this.asn.akK.akp = jSONObject.optInt("height", 200);
                this.asn.akK.mPackageName = jSONObject.optString("packet_name", "");
                this.asn.akK.akq = jSONObject.optString("icon");
                String[] split = this.asn.akK.akm.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.asn.akK.akn = split[i].split("_")[0];
            } else {
                this.asA = new b(jSONObject);
                if (this.mType == 4) {
                    int ea = TbFaceManager.zr().ea(this.asA.getText());
                    String optString = jSONObject.optString("c");
                    if (ea <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.m411getInst().getString(y.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.asA.setText(str);
                    } else {
                        this.asA.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.asA.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.asA != null) {
                this.asA.Dy();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int ei(int i) {
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
