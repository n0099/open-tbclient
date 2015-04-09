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
    private b asI = null;
    private g asr = null;
    private u ast = null;
    private e asv = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, b bVar, g gVar, u uVar, e eVar) {
        this.mType = i;
        this.asI = bVar;
        this.asr = gVar;
        this.ast = uVar;
        this.asv = eVar;
    }

    public g DG() {
        if (this.mType == 8) {
            return this.asr;
        }
        return null;
    }

    public u DI() {
        if (this.mType == 512 || this.mType == 768) {
            return this.ast;
        }
        return null;
    }

    public e DK() {
        if (this.mType == 17) {
            return this.asv;
        }
        return null;
    }

    public SpannableString DQ() {
        if (this.mType != 1 || this.asI == null) {
            return null;
        }
        return new SpannableString(this.asI.getText());
    }

    public CharSequence b(Context context, ArrayList<f> arrayList) {
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.asI != null) {
            spannableStringBuilder.append((CharSequence) context.getString(y.video_text));
            CharSequence d = d(context, arrayList);
            if (d != null) {
                spannableStringBuilder.append(d);
            }
            if (this.asI.DC() == 1) {
                a = a(context, this.mType, this.asI.getText(), this.asI.DD());
            } else {
                a = a(context, this.mType, this.asI.getText(), this.asI.getText());
            }
            if (a != null) {
                spannableStringBuilder.append((CharSequence) a);
            }
        }
        return spannableStringBuilder;
    }

    public CharSequence c(Context context, ArrayList<f> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.asI != null) {
            CharSequence d = d(context, arrayList);
            if (d != null) {
                spannableStringBuilder.append(d);
            }
            SpannableString a = a(context, this.mType, this.asI.getLink(), this.asI.getLink());
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
        if (this.mType != 32 || this.asI == null) {
            return null;
        }
        if (this.asI.DC() == 1) {
            return this.asI.DD();
        }
        return this.asI.getText();
    }

    public SpannableString ag(Context context) {
        if (this.mType != 2 || this.asI == null) {
            return null;
        }
        if (this.asI.DC() == 1) {
            return a(context, this.mType, this.asI.getText(), this.asI.DD());
        }
        return a(context, this.mType, this.asI.getText(), this.asI.getLink());
    }

    public SpannableString ah(Context context) {
        if (this.mType != 256 || this.asI == null) {
            return null;
        }
        String text = this.asI.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = String.valueOf(text) + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        h hVar = new h(context, this.mType, text);
        hVar.eQ(this.asI.getLink());
        spannableString.setSpan(hVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    public SpannableString ai(Context context) {
        if (this.mType != 16 || this.asI == null) {
            return null;
        }
        return a(context, this.mType, this.asI.getText(), this.asI.getLink());
    }

    private SpannableString e(Context context, ArrayList<f> arrayList) {
        String text;
        int ed;
        com.baidu.tbadk.imageManager.c eq;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.asI != null && this.asI.getText() != null && this.asI.getLink() != null && (ed = TbFaceManager.zx().ed((text = this.asI.getText()))) != 0) {
            String str = "#(" + TbFaceManager.zx().ef(text) + ")";
            spannableString = new SpannableString(String.valueOf(str) + " ");
            f fVar = new f(TbadkCoreApplication.m411getInst().getContext(), ed);
            if (arrayList != null) {
                arrayList.add(fVar);
            }
            if (TbFaceManager.zx().eq(text) != null) {
                int width = (int) (eq.getWidth() * 0.5d);
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
                return DQ();
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
                    this.asr = new g(pbContent);
                    break;
                case 16:
                    this.asI = new b(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.asv = new e();
                    this.asv.akS.aks = String.format("#(%s)", pbContent.c);
                    this.asv.akS.aku = pbContent.dynamic;
                    this.asv.akS.akt = pbContent._static;
                    this.asv.mType = this.mType;
                    this.asv.akS.akw = pbContent.width.intValue();
                    this.asv.akS.akx = pbContent.height.intValue();
                    this.asv.akS.mPackageName = pbContent.packet_name;
                    this.asv.akS.aky = pbContent._static;
                    String[] split = this.asv.akS.aku.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.asv.akS.akv = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.asv.akS.akv = split[i].split("_")[0];
                case 512:
                    this.ast = new u(pbContent);
                    break;
                default:
                    this.asI = new b(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.zx().ed(this.asI.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.m411getInst().getString(y.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.asI.setText(str);
                            break;
                        } else {
                            this.asI.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.asI.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.asI != null) {
                this.asI.DE();
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
                this.asr = new g(jSONObject);
            } else if (this.mType == 512) {
                this.ast = new u(jSONObject);
            } else if (this.mType == 16) {
                this.asI = new b(jSONObject.optString("text"), jSONObject.optString(SapiAccountManager.SESSION_UID));
            } else if (this.mType == 17) {
                this.asv = new e();
                this.asv.akS.aks = String.format("#(%s)", jSONObject.optString("c"));
                this.asv.akS.aku = jSONObject.optString("dynamic");
                this.asv.akS.akt = jSONObject.optString("static");
                this.asv.mType = this.mType;
                this.asv.akS.akw = jSONObject.optInt("width", 200);
                this.asv.akS.akx = jSONObject.optInt("height", 200);
                this.asv.akS.mPackageName = jSONObject.optString("packet_name", "");
                this.asv.akS.aky = jSONObject.optString("icon");
                String[] split = this.asv.akS.aku.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.asv.akS.akv = split[i].split("_")[0];
            } else {
                this.asI = new b(jSONObject);
                if (this.mType == 4) {
                    int ed = TbFaceManager.zx().ed(this.asI.getText());
                    String optString = jSONObject.optString("c");
                    if (ed <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.m411getInst().getString(y.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.asI.setText(str);
                    } else {
                        this.asI.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.asI.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.asI != null) {
                this.asI.DE();
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
