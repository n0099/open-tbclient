package com.baidu.tbadk.widget.richText;

import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.util.BdLog;
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
    private b ake = null;
    private g ajN = null;
    private u ajP = null;
    private e ajR = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, b bVar, g gVar, u uVar, e eVar) {
        this.mType = i;
        this.ake = bVar;
        this.ajN = gVar;
        this.ajP = uVar;
        this.ajR = eVar;
    }

    public g Ak() {
        if (this.mType == 8) {
            return this.ajN;
        }
        return null;
    }

    public u Am() {
        if (this.mType == 512 || this.mType == 768) {
            return this.ajP;
        }
        return null;
    }

    public e Ao() {
        if (this.mType == 17) {
            return this.ajR;
        }
        return null;
    }

    public SpannableString Au() {
        if (this.mType != 1 || this.ake == null) {
            return null;
        }
        return new SpannableString(this.ake.getText());
    }

    public CharSequence b(Context context, ArrayList<f> arrayList) {
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.ake != null) {
            spannableStringBuilder.append((CharSequence) context.getString(z.video_text));
            CharSequence d = d(context, arrayList);
            if (d != null) {
                spannableStringBuilder.append(d);
            }
            if (this.ake.Ag() == 1) {
                a = a(context, this.mType, this.ake.getText(), this.ake.Ah());
            } else {
                a = a(context, this.mType, this.ake.getText(), this.ake.getText());
            }
            if (a != null) {
                spannableStringBuilder.append((CharSequence) a);
            }
        }
        return spannableStringBuilder;
    }

    public CharSequence c(Context context, ArrayList<f> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.ake != null) {
            CharSequence d = d(context, arrayList);
            if (d != null) {
                spannableStringBuilder.append(d);
            }
            SpannableString a = a(context, this.mType, this.ake.getLink(), this.ake.getLink());
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
        if (this.mType != 32 || this.ake == null) {
            return null;
        }
        if (this.ake.Ag() == 1) {
            return this.ake.Ah();
        }
        return this.ake.getText();
    }

    public SpannableString ad(Context context) {
        if (this.mType != 2 || this.ake == null) {
            return null;
        }
        if (this.ake.Ag() == 1) {
            return a(context, this.mType, this.ake.getText(), this.ake.Ah());
        }
        return a(context, this.mType, this.ake.getText(), this.ake.getLink());
    }

    public SpannableString ae(Context context) {
        if (this.mType != 256 || this.ake == null) {
            return null;
        }
        String text = this.ake.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = String.valueOf(text) + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        h hVar = new h(context, this.mType, text);
        hVar.eL(this.ake.getLink());
        spannableString.setSpan(hVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    public SpannableString af(Context context) {
        if (this.mType != 16 || this.ake == null) {
            return null;
        }
        return a(context, this.mType, this.ake.getText(), this.ake.getLink());
    }

    private SpannableString e(Context context, ArrayList<f> arrayList) {
        String text;
        int dZ;
        com.baidu.tbadk.imageManager.c ej;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.ake != null && this.ake.getText() != null && this.ake.getLink() != null && (dZ = TbFaceManager.wd().dZ((text = this.ake.getText()))) != 0) {
            String str = "#(" + TbFaceManager.wd().eb(text) + ")";
            spannableString = new SpannableString(String.valueOf(str) + " ");
            f fVar = new f(TbadkCoreApplication.m255getInst().getContext(), dZ);
            if (arrayList != null) {
                arrayList.add(fVar);
            }
            if (TbFaceManager.wd().ej(text) != null) {
                int width = (int) (ej.getWidth() * 0.5d);
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
                return Au();
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
            this.mType = ee(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.ajN = new g(pbContent);
                    break;
                case 16:
                    this.ake = new b(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.ajR = new e();
                    this.ajR.aap.ZP = String.format("#(%s)", pbContent.c);
                    this.ajR.aap.ZR = pbContent.dynamic;
                    this.ajR.aap.ZQ = pbContent._static;
                    this.ajR.mType = this.mType;
                    this.ajR.aap.ZT = pbContent.width.intValue();
                    this.ajR.aap.ZU = pbContent.height.intValue();
                    this.ajR.aap.mPackageName = pbContent.packet_name;
                    this.ajR.aap.ZV = pbContent._static;
                    String[] split = this.ajR.aap.ZR.split("/");
                    for (String str : split) {
                        i++;
                        if (str.equals("faceshop")) {
                            this.ajR.aap.ZS = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.ajR.aap.ZS = split[i].split("_")[0];
                case 512:
                    this.ajP = new u(pbContent);
                    break;
                default:
                    this.ake = new b(pbContent);
                    if (this.mType == 4) {
                        String str2 = "[" + pbContent.c + "]";
                        if (TbFaceManager.wd().dZ(this.ake.getText()) <= 0) {
                            this.mType = 1;
                            this.ake.setText(str2);
                            break;
                        } else {
                            this.ake.setLink(str2);
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.ake.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.ake != null) {
                this.ake.Ai();
            }
        } catch (Exception e) {
        }
    }

    public void parserJson(JSONObject jSONObject) {
        int i = 0;
        try {
            this.mType = ee(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.ajN = new g(jSONObject);
            } else if (this.mType == 512) {
                this.ajP = new u(jSONObject);
            } else if (this.mType == 16) {
                this.ake = new b(jSONObject.optString("text"), jSONObject.optString(SapiAccountManager.SESSION_UID));
            } else if (this.mType == 17) {
                this.ajR = new e();
                this.ajR.aap.ZP = String.format("#(%s)", jSONObject.optString("c"));
                this.ajR.aap.ZR = jSONObject.optString("dynamic");
                this.ajR.aap.ZQ = jSONObject.optString("static");
                this.ajR.mType = this.mType;
                this.ajR.aap.ZT = jSONObject.optInt("width", 200);
                this.ajR.aap.ZU = jSONObject.optInt("height", 200);
                this.ajR.aap.mPackageName = jSONObject.optString("packet_name", "");
                this.ajR.aap.ZV = jSONObject.optString("icon");
                String[] split = this.ajR.aap.ZR.split("/");
                for (String str : split) {
                    i++;
                    if (str.equals("faceshop")) {
                        break;
                    }
                }
                this.ajR.aap.ZS = split[i].split("_")[0];
            } else {
                this.ake = new b(jSONObject);
                if (this.mType == 4) {
                    String str2 = "[" + jSONObject.optString("c") + "]";
                    if (TbFaceManager.wd().dZ(this.ake.getText()) <= 0) {
                        this.mType = 1;
                        this.ake.setText(str2);
                    } else {
                        this.ake.setLink(str2);
                    }
                } else if (this.mType == 256) {
                    this.ake.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.ake != null) {
                this.ake.Ai();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int ee(int i) {
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
