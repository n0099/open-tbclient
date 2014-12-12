package com.baidu.tbadk.widget.richText;

import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.z;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.lib.a.b.a.a.i {
    private int mType = 0;
    private b ajB = null;
    private g ajk = null;
    private u ajm = null;
    private e ajo = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, b bVar, g gVar, u uVar, e eVar) {
        this.mType = i;
        this.ajB = bVar;
        this.ajk = gVar;
        this.ajm = uVar;
        this.ajo = eVar;
    }

    public g zQ() {
        if (this.mType == 8) {
            return this.ajk;
        }
        return null;
    }

    public u zS() {
        if (this.mType == 512 || this.mType == 768) {
            return this.ajm;
        }
        return null;
    }

    public e zU() {
        if (this.mType == 17) {
            return this.ajo;
        }
        return null;
    }

    public SpannableString Aa() {
        if (this.mType != 1 || this.ajB == null) {
            return null;
        }
        return new SpannableString(this.ajB.getText());
    }

    public CharSequence b(Context context, ArrayList<f> arrayList) {
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.ajB != null) {
            spannableStringBuilder.append((CharSequence) context.getString(z.video_text));
            CharSequence d = d(context, arrayList);
            if (d != null) {
                spannableStringBuilder.append(d);
            }
            if (this.ajB.zM() == 1) {
                a = a(context, this.mType, this.ajB.getText(), this.ajB.zN());
            } else {
                a = a(context, this.mType, this.ajB.getText(), this.ajB.getText());
            }
            if (a != null) {
                spannableStringBuilder.append((CharSequence) a);
            }
        }
        return spannableStringBuilder;
    }

    public CharSequence c(Context context, ArrayList<f> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.ajB != null) {
            CharSequence d = d(context, arrayList);
            if (d != null) {
                spannableStringBuilder.append(d);
            }
            SpannableString a = a(context, this.mType, this.ajB.getLink(), this.ajB.getLink());
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
        if (this.mType != 32 || this.ajB == null) {
            return null;
        }
        if (this.ajB.zM() == 1) {
            return this.ajB.zN();
        }
        return this.ajB.getText();
    }

    public SpannableString ad(Context context) {
        if (this.mType != 2 || this.ajB == null) {
            return null;
        }
        if (this.ajB.zM() == 1) {
            return a(context, this.mType, this.ajB.getText(), this.ajB.zN());
        }
        return a(context, this.mType, this.ajB.getText(), this.ajB.getLink());
    }

    public SpannableString ae(Context context) {
        if (this.mType != 256 || this.ajB == null) {
            return null;
        }
        String text = this.ajB.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = String.valueOf(text) + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        h hVar = new h(context, this.mType, text);
        hVar.eK(this.ajB.getLink());
        spannableString.setSpan(hVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    public SpannableString af(Context context) {
        if (this.mType != 16 || this.ajB == null) {
            return null;
        }
        return a(context, this.mType, this.ajB.getText(), this.ajB.getLink());
    }

    private SpannableString e(Context context, ArrayList<f> arrayList) {
        String text;
        int dZ;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.ajB != null && this.ajB.getText() != null && this.ajB.getLink() != null && (dZ = TbFaceManager.vK().dZ((text = this.ajB.getText()))) != 0) {
            String str = "#(" + TbFaceManager.vK().eb(text) + ")";
            spannableString = new SpannableString(String.valueOf(str) + " ");
            f fVar = new f(TbadkCoreApplication.m255getInst().getContext(), dZ);
            if (arrayList != null) {
                arrayList.add(fVar);
            }
            com.baidu.tbadk.imageManager.c ej = TbFaceManager.vK().ej(text);
            if (ej != null) {
                fVar.setBounds(new Rect(0, 0, ej.getWidth(), ej.getHeight()));
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
                return Aa();
            case 2:
                return ad(context);
            case 4:
                return e(context, arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return af(context);
            case 32:
                return b(context, arrayList);
            case 128:
                return c(context, arrayList);
            case 256:
                return ae(context);
        }
    }

    public void a(PbContent pbContent) {
        int i = 0;
        try {
            this.mType = dY(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.ajk = new g(pbContent);
                    break;
                case 16:
                    this.ajB = new b(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.ajo = new e();
                    this.ajo.ZO.Zo = String.format("#(%s)", pbContent.c);
                    this.ajo.ZO.Zq = pbContent.dynamic;
                    this.ajo.ZO.Zp = pbContent._static;
                    this.ajo.mType = this.mType;
                    this.ajo.ZO.Zs = pbContent.width.intValue();
                    this.ajo.ZO.Zt = pbContent.height.intValue();
                    this.ajo.ZO.mPackageName = pbContent.packet_name;
                    this.ajo.ZO.Zu = pbContent._static;
                    String[] split = this.ajo.ZO.Zq.split("/");
                    for (String str : split) {
                        i++;
                        if (str.equals("faceshop")) {
                            this.ajo.ZO.Zr = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.ajo.ZO.Zr = split[i].split("_")[0];
                case 512:
                    this.ajm = new u(pbContent);
                    break;
                default:
                    this.ajB = new b(pbContent);
                    if (this.mType == 4) {
                        String str2 = "[" + pbContent.c + "]";
                        if (TbFaceManager.vK().dZ(this.ajB.getText()) <= 0) {
                            this.mType = 1;
                            this.ajB.setText(str2);
                            break;
                        } else {
                            this.ajB.setLink(str2);
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.ajB.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.ajB != null) {
                this.ajB.zO();
            }
        } catch (Exception e) {
        }
    }

    public void parserJson(JSONObject jSONObject) {
        int i = 0;
        try {
            this.mType = dY(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.ajk = new g(jSONObject);
            } else if (this.mType == 512) {
                this.ajm = new u(jSONObject);
            } else if (this.mType == 16) {
                this.ajB = new b(jSONObject.optString("text"), jSONObject.optString(SapiAccountManager.SESSION_UID));
            } else if (this.mType == 17) {
                this.ajo = new e();
                this.ajo.ZO.Zo = String.format("#(%s)", jSONObject.optString("c"));
                this.ajo.ZO.Zq = jSONObject.optString("dynamic");
                this.ajo.ZO.Zp = jSONObject.optString("static");
                this.ajo.mType = this.mType;
                this.ajo.ZO.Zs = jSONObject.optInt("width", Constants.MEDIA_INFO);
                this.ajo.ZO.Zt = jSONObject.optInt("height", Constants.MEDIA_INFO);
                this.ajo.ZO.mPackageName = jSONObject.optString("packet_name", "");
                this.ajo.ZO.Zu = jSONObject.optString("icon");
                String[] split = this.ajo.ZO.Zq.split("/");
                for (String str : split) {
                    i++;
                    if (str.equals("faceshop")) {
                        break;
                    }
                }
                this.ajo.ZO.Zr = split[i].split("_")[0];
            } else {
                this.ajB = new b(jSONObject);
                if (this.mType == 4) {
                    String str2 = "[" + jSONObject.optString("c") + "]";
                    if (TbFaceManager.vK().dZ(this.ajB.getText()) <= 0) {
                        this.mType = 1;
                        this.ajB.setText(str2);
                    } else {
                        this.ajB.setLink(str2);
                    }
                } else if (this.mType == 256) {
                    this.ajB.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.ajB != null) {
                this.ajB.zO();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int dY(int i) {
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
