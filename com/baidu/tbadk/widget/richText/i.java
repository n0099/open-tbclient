package com.baidu.tbadk.widget.richText;

import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.lib.a.b.a.a.i {
    private int mType = 0;
    private b auo = null;
    private g atX = null;
    private u atZ = null;
    private e aub = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, b bVar, g gVar, u uVar, e eVar) {
        this.mType = i;
        this.auo = bVar;
        this.atX = gVar;
        this.atZ = uVar;
        this.aub = eVar;
    }

    public g Er() {
        if (this.mType == 8) {
            return this.atX;
        }
        return null;
    }

    public u Et() {
        if (this.mType == 512 || this.mType == 768) {
            return this.atZ;
        }
        return null;
    }

    public e Ev() {
        if (this.mType == 17) {
            return this.aub;
        }
        return null;
    }

    public SpannableString EB() {
        if (this.mType != 1 || this.auo == null) {
            return null;
        }
        return new SpannableString(this.auo.getText());
    }

    public CharSequence b(Context context, ArrayList<f> arrayList) {
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.auo != null) {
            spannableStringBuilder.append((CharSequence) context.getString(com.baidu.tieba.t.video_text));
            CharSequence d = d(context, arrayList);
            if (d != null) {
                spannableStringBuilder.append(d);
            }
            if (this.auo.En() == 1) {
                a = a(context, this.mType, this.auo.getText(), this.auo.Eo());
            } else {
                a = a(context, this.mType, this.auo.getText(), this.auo.getText());
            }
            if (a != null) {
                spannableStringBuilder.append((CharSequence) a);
            }
        }
        return spannableStringBuilder;
    }

    public CharSequence c(Context context, ArrayList<f> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.auo != null) {
            CharSequence d = d(context, arrayList);
            if (d != null) {
                spannableStringBuilder.append(d);
            }
            SpannableString a = a(context, this.mType, this.auo.getLink(), this.auo.getLink());
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
        if (this.mType != 32 || this.auo == null) {
            return null;
        }
        if (this.auo.En() == 1) {
            return this.auo.Eo();
        }
        return this.auo.getText();
    }

    public SpannableString al(Context context) {
        if (this.mType != 2 || this.auo == null) {
            return null;
        }
        if (this.auo.En() == 1) {
            return a(context, this.mType, this.auo.getText(), this.auo.Eo());
        }
        return a(context, this.mType, this.auo.getText(), this.auo.getLink());
    }

    public SpannableString am(Context context) {
        if (this.mType != 256 || this.auo == null) {
            return null;
        }
        String text = this.auo.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = String.valueOf(text) + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        h hVar = new h(context, this.mType, text);
        hVar.fl(this.auo.getLink());
        spannableString.setSpan(hVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    public SpannableString an(Context context) {
        if (this.mType != 16 || this.auo == null) {
            return null;
        }
        return a(context, this.mType, this.auo.getText(), this.auo.getLink());
    }

    private SpannableString e(Context context, ArrayList<f> arrayList) {
        String text;
        int eu;
        com.baidu.tbadk.imageManager.c eH;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.auo != null && this.auo.getText() != null && this.auo.getLink() != null && (eu = TbFaceManager.Al().eu((text = this.auo.getText()))) != 0) {
            String str = "#(" + TbFaceManager.Al().ew(text) + ")";
            spannableString = new SpannableString(String.valueOf(str) + " ");
            f fVar = new f(TbadkCoreApplication.m411getInst().getContext(), eu);
            if (arrayList != null) {
                arrayList.add(fVar);
            }
            if (TbFaceManager.Al().eH(text) != null) {
                int width = (int) (eH.getWidth() * 0.5d);
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
                return EB();
            case 2:
                return al(context);
            case 4:
                return e(context, arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return an(context);
            case 32:
                return b(context, arrayList);
            case 128:
                return c(context, arrayList);
            case 256:
                return am(context);
        }
    }

    public void a(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = eu(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.atX = new g(pbContent);
                    break;
                case 16:
                    this.auo = new b(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.aub = new e();
                    this.aub.alT.alt = String.format("#(%s)", pbContent.c);
                    this.aub.alT.alv = pbContent.dynamic;
                    this.aub.alT.alu = pbContent._static;
                    this.aub.mType = this.mType;
                    this.aub.alT.alx = pbContent.width.intValue();
                    this.aub.alT.aly = pbContent.height.intValue();
                    this.aub.alT.mPackageName = pbContent.packet_name;
                    this.aub.alT.alz = pbContent._static;
                    String[] split = this.aub.alT.alv.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.aub.alT.alw = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.aub.alT.alw = split[i].split("_")[0];
                case 512:
                    this.atZ = new u(pbContent);
                    break;
                default:
                    this.auo = new b(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.Al().eu(this.auo.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.m411getInst().getString(com.baidu.tieba.t.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.auo.setText(str);
                            break;
                        } else {
                            this.auo.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.auo.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.auo != null) {
                this.auo.Ep();
            }
        } catch (Exception e) {
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = eu(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.atX = new g(jSONObject);
            } else if (this.mType == 512) {
                this.atZ = new u(jSONObject);
            } else if (this.mType == 16) {
                this.auo = new b(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.aub = new e();
                this.aub.alT.alt = String.format("#(%s)", jSONObject.optString("c"));
                this.aub.alT.alv = jSONObject.optString("dynamic");
                this.aub.alT.alu = jSONObject.optString("static");
                this.aub.mType = this.mType;
                this.aub.alT.alx = jSONObject.optInt("width", 200);
                this.aub.alT.aly = jSONObject.optInt("height", 200);
                this.aub.alT.mPackageName = jSONObject.optString("packet_name", "");
                this.aub.alT.alz = jSONObject.optString("icon");
                String[] split = this.aub.alT.alv.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.aub.alT.alw = split[i].split("_")[0];
            } else {
                this.auo = new b(jSONObject);
                if (this.mType == 4) {
                    int eu = TbFaceManager.Al().eu(this.auo.getText());
                    String optString = jSONObject.optString("c");
                    if (eu <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.m411getInst().getString(com.baidu.tieba.t.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.auo.setText(str);
                    } else {
                        this.auo.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.auo.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.auo != null) {
                this.auo.Ep();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int eu(int i) {
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
