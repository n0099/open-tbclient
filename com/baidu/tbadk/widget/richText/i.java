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
    private b akb = null;
    private g ajK = null;
    private u ajM = null;
    private e ajO = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, b bVar, g gVar, u uVar, e eVar) {
        this.mType = i;
        this.akb = bVar;
        this.ajK = gVar;
        this.ajM = uVar;
        this.ajO = eVar;
    }

    public g Ae() {
        if (this.mType == 8) {
            return this.ajK;
        }
        return null;
    }

    public u Ag() {
        if (this.mType == 512 || this.mType == 768) {
            return this.ajM;
        }
        return null;
    }

    public e Ai() {
        if (this.mType == 17) {
            return this.ajO;
        }
        return null;
    }

    public SpannableString Ao() {
        if (this.mType != 1 || this.akb == null) {
            return null;
        }
        return new SpannableString(this.akb.getText());
    }

    public CharSequence b(Context context, ArrayList<f> arrayList) {
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.akb != null) {
            spannableStringBuilder.append((CharSequence) context.getString(z.video_text));
            CharSequence d = d(context, arrayList);
            if (d != null) {
                spannableStringBuilder.append(d);
            }
            if (this.akb.Aa() == 1) {
                a = a(context, this.mType, this.akb.getText(), this.akb.Ab());
            } else {
                a = a(context, this.mType, this.akb.getText(), this.akb.getText());
            }
            if (a != null) {
                spannableStringBuilder.append((CharSequence) a);
            }
        }
        return spannableStringBuilder;
    }

    public CharSequence c(Context context, ArrayList<f> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.akb != null) {
            CharSequence d = d(context, arrayList);
            if (d != null) {
                spannableStringBuilder.append(d);
            }
            SpannableString a = a(context, this.mType, this.akb.getLink(), this.akb.getLink());
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
        if (this.mType != 32 || this.akb == null) {
            return null;
        }
        if (this.akb.Aa() == 1) {
            return this.akb.Ab();
        }
        return this.akb.getText();
    }

    public SpannableString ad(Context context) {
        if (this.mType != 2 || this.akb == null) {
            return null;
        }
        if (this.akb.Aa() == 1) {
            return a(context, this.mType, this.akb.getText(), this.akb.Ab());
        }
        return a(context, this.mType, this.akb.getText(), this.akb.getLink());
    }

    public SpannableString ae(Context context) {
        if (this.mType != 256 || this.akb == null) {
            return null;
        }
        String text = this.akb.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = String.valueOf(text) + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        h hVar = new h(context, this.mType, text);
        hVar.eI(this.akb.getLink());
        spannableString.setSpan(hVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    public SpannableString af(Context context) {
        if (this.mType != 16 || this.akb == null) {
            return null;
        }
        return a(context, this.mType, this.akb.getText(), this.akb.getLink());
    }

    private SpannableString e(Context context, ArrayList<f> arrayList) {
        String text;
        int dW;
        com.baidu.tbadk.imageManager.c eg;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.akb != null && this.akb.getText() != null && this.akb.getLink() != null && (dW = TbFaceManager.vX().dW((text = this.akb.getText()))) != 0) {
            String str = "#(" + TbFaceManager.vX().dY(text) + ")";
            spannableString = new SpannableString(String.valueOf(str) + " ");
            f fVar = new f(TbadkCoreApplication.m255getInst().getContext(), dW);
            if (arrayList != null) {
                arrayList.add(fVar);
            }
            if (TbFaceManager.vX().eg(text) != null) {
                int width = (int) (eg.getWidth() * 0.5d);
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
                return Ao();
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
                    this.ajK = new g(pbContent);
                    break;
                case 16:
                    this.akb = new b(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.ajO = new e();
                    this.ajO.aam.ZM = String.format("#(%s)", pbContent.c);
                    this.ajO.aam.ZO = pbContent.dynamic;
                    this.ajO.aam.ZN = pbContent._static;
                    this.ajO.mType = this.mType;
                    this.ajO.aam.ZQ = pbContent.width.intValue();
                    this.ajO.aam.ZR = pbContent.height.intValue();
                    this.ajO.aam.mPackageName = pbContent.packet_name;
                    this.ajO.aam.ZS = pbContent._static;
                    String[] split = this.ajO.aam.ZO.split("/");
                    for (String str : split) {
                        i++;
                        if (str.equals("faceshop")) {
                            this.ajO.aam.ZP = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.ajO.aam.ZP = split[i].split("_")[0];
                case 512:
                    this.ajM = new u(pbContent);
                    break;
                default:
                    this.akb = new b(pbContent);
                    if (this.mType == 4) {
                        String str2 = "[" + pbContent.c + "]";
                        if (TbFaceManager.vX().dW(this.akb.getText()) <= 0) {
                            this.mType = 1;
                            this.akb.setText(str2);
                            break;
                        } else {
                            this.akb.setLink(str2);
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.akb.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.akb != null) {
                this.akb.Ac();
            }
        } catch (Exception e) {
        }
    }

    public void parserJson(JSONObject jSONObject) {
        int i = 0;
        try {
            this.mType = ee(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.ajK = new g(jSONObject);
            } else if (this.mType == 512) {
                this.ajM = new u(jSONObject);
            } else if (this.mType == 16) {
                this.akb = new b(jSONObject.optString("text"), jSONObject.optString(SapiAccountManager.SESSION_UID));
            } else if (this.mType == 17) {
                this.ajO = new e();
                this.ajO.aam.ZM = String.format("#(%s)", jSONObject.optString("c"));
                this.ajO.aam.ZO = jSONObject.optString("dynamic");
                this.ajO.aam.ZN = jSONObject.optString("static");
                this.ajO.mType = this.mType;
                this.ajO.aam.ZQ = jSONObject.optInt("width", 200);
                this.ajO.aam.ZR = jSONObject.optInt("height", 200);
                this.ajO.aam.mPackageName = jSONObject.optString("packet_name", "");
                this.ajO.aam.ZS = jSONObject.optString("icon");
                String[] split = this.ajO.aam.ZO.split("/");
                for (String str : split) {
                    i++;
                    if (str.equals("faceshop")) {
                        break;
                    }
                }
                this.ajO.aam.ZP = split[i].split("_")[0];
            } else {
                this.akb = new b(jSONObject);
                if (this.mType == 4) {
                    String str2 = "[" + jSONObject.optString("c") + "]";
                    if (TbFaceManager.vX().dW(this.akb.getText()) <= 0) {
                        this.mType = 1;
                        this.akb.setText(str2);
                    } else {
                        this.akb.setLink(str2);
                    }
                } else if (this.mType == 256) {
                    this.akb.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.akb != null) {
                this.akb.Ac();
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
