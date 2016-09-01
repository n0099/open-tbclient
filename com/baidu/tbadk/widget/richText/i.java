package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GraffitiVcodeActivityConfig;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.t;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.lib.a.b.a.a.i {
    private f aIK;
    private n aIL;
    private int mType = 0;
    private b aJe = null;
    private g aIC = null;
    private z aIE = null;
    private d aIG = null;
    private o aIH = null;
    private k aIJ = null;
    private l aII = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, b bVar, g gVar, z zVar, d dVar, k kVar, l lVar) {
        this.mType = i;
        this.aJe = bVar;
        this.aIC = gVar;
        this.aIE = zVar;
        this.aIG = dVar;
        this.aIJ = kVar;
        this.aII = lVar;
    }

    public l Im() {
        if (this.mType == 1280) {
            return this.aII;
        }
        return null;
    }

    public k In() {
        if (this.mType == 1024) {
            return this.aIJ;
        }
        return null;
    }

    public g If() {
        if (this.mType == 8) {
            return this.aIC;
        }
        return null;
    }

    public o Ij() {
        if (this.mType != 32) {
            return null;
        }
        return this.aIH;
    }

    public z Ih() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aIE;
        }
        return null;
    }

    public d Ik() {
        if (this.mType == 17) {
            return this.aIG;
        }
        return null;
    }

    public f Io() {
        if (this.mType == 1536) {
            return this.aIK;
        }
        return null;
    }

    public n Ip() {
        if (this.mType == 1792) {
            return this.aIL;
        }
        return null;
    }

    private SpannableString Ix() {
        if (this.mType != 1 || this.aJe == null) {
            return null;
        }
        return new SpannableString(this.aJe.getText());
    }

    private CharSequence t(ArrayList<e> arrayList) {
        SpannableString c;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.aJe != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.m9getInst().getString(t.j.video_text));
            CharSequence v = v(arrayList);
            if (v != null) {
                spannableStringBuilder.append(v);
            }
            if (this.aJe.Ib() == 1) {
                c = c(this.mType, this.aJe.getText(), this.aJe.Ic());
            } else {
                c = c(this.mType, this.aJe.getText(), this.aJe.getText());
            }
            if (c != null) {
                spannableStringBuilder.append((CharSequence) c);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence u(ArrayList<e> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.aJe != null) {
            CharSequence v = v(arrayList);
            if (v != null) {
                spannableStringBuilder.append(v);
            }
            SpannableString c = c(this.mType, this.aJe.getLink(), this.aJe.getLink());
            if (c != null) {
                spannableStringBuilder.append((CharSequence) c);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence v(ArrayList<e> arrayList) {
        i iVar = new i();
        iVar.a(4, new b("video_icon", " "), null, null, null, null, null);
        return iVar.x(arrayList);
    }

    public String getVideoUrl() {
        if (this.mType != 32 || this.aJe == null) {
            return null;
        }
        if (this.aJe.Ib() == 1) {
            return this.aJe.Ic();
        }
        return this.aJe.getText();
    }

    private SpannableString Iy() {
        if ((this.mType != 2 && this.mType != 18) || this.aJe == null) {
            return null;
        }
        if (this.aJe.Ib() == 1) {
            return c(this.mType, this.aJe.getText(), this.aJe.Ic());
        }
        return c(this.mType, this.aJe.getText(), this.aJe.getLink());
    }

    private SpannableString Iz() {
        if (this.mType != 256 || this.aJe == null) {
            return null;
        }
        String text = this.aJe.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = String.valueOf(text) + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        h hVar = new h(this.mType, text);
        hVar.gD(this.aJe.getLink());
        spannableString.setSpan(hVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString IA() {
        if (this.mType != 16 || this.aJe == null) {
            return null;
        }
        return c(this.mType, this.aJe.getText(), this.aJe.getLink());
    }

    private SpannableString w(ArrayList<e> arrayList) {
        String text;
        int fp;
        a.C0044a fP;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.aJe != null && this.aJe.getText() != null && this.aJe.getLink() != null && (fp = TbFaceManager.Ej().fp((text = this.aJe.getText()))) != 0) {
            String str = "#(" + TbFaceManager.Ej().fr(text) + ")";
            spannableString = new SpannableString(String.valueOf(str) + " ");
            e eVar = new e(TbadkCoreApplication.m9getInst().getContext(), fp);
            if (arrayList != null) {
                arrayList.add(eVar);
            }
            if (TbFaceManager.Ej().fP(text) != null) {
                int width = (int) (fP.getWidth() * 0.5d);
                eVar.setBounds(new Rect(0, 0, width, width));
            } else {
                eVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new com.baidu.tbadk.widget.f(eVar), 0, str.length(), 33);
        }
        return spannableString;
    }

    private SpannableString c(int i, String str, String str2) {
        if (str == null) {
            return null;
        }
        if (!str.endsWith(" ")) {
            str = String.valueOf(str) + " ";
        }
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new h(i, str2), 0, str.length() - 1, 33);
        return spannableString;
    }

    private SpannableString IB() {
        if (this.mType != 1024 || this.aIJ == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString("a");
        Drawable fy = j.fy(this.aIJ.aJf);
        fy.setBounds(0, 0, fy.getIntrinsicWidth(), fy.getIntrinsicHeight());
        com.baidu.tbadk.widget.f fVar = new com.baidu.tbadk.widget.f(fy);
        fVar.setVerticalOffset(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getContext(), t.e.ds4));
        spannableString.setSpan(fVar, 0, 1, 33);
        spannableString.setSpan(new h(1024, this.aIJ.link), spannableString.length() - 1, "a".length(), 33);
        return spannableString;
    }

    public CharSequence x(ArrayList<e> arrayList) {
        switch (this.mType) {
            case 1:
                return Ix();
            case 2:
                return Iy();
            case 4:
                return w(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return IA();
            case 18:
                return Iy();
            case 32:
                return t(arrayList);
            case 128:
                return u(arrayList);
            case 256:
                return Iz();
            case 1024:
                return IB();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.aIH.IL() != false) goto L9;
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
                    this.aIC = new g(pbContent);
                    break;
                case 16:
                    this.aJe = new b(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.aIG = new d();
                    this.aIG.ayk.axL = String.format("#(%s)", pbContent.c);
                    this.aIG.ayk.axN = pbContent.dynamic;
                    this.aIG.ayk.axM = pbContent._static;
                    this.aIG.mType = this.mType;
                    this.aIG.ayk.axO = pbContent.width.intValue();
                    this.aIG.ayk.axP = pbContent.height.intValue();
                    this.aIG.ayk.mPackageName = pbContent.packet_name;
                    this.aIG.ayk.mIcon = pbContent._static;
                    String[] split = this.aIG.ayk.axN.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.aIG.ayk.mGid = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.aIG.ayk.mGid = split[i].split("_")[0];
                case 512:
                    this.aIE = new z(pbContent);
                    break;
                case 1024:
                    this.aIJ = new k(pbContent);
                    break;
                case 1280:
                    this.aII = new l(pbContent);
                    break;
                case 1536:
                    this.aIK = new f();
                    this.aIK.a(pbContent);
                    break;
                case 1792:
                    this.aIL = new n();
                    this.aIL.a(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.aIH = new o();
                        this.aIH.a(pbContent);
                        break;
                    }
                    this.aJe = new b(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.Ej().fp(this.aJe.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.m9getInst().getString(t.j.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.aJe.setText(str);
                            break;
                        } else {
                            this.aJe.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.aJe.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.aJe != null) {
                this.aJe.Id();
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
                this.aIC = new g(jSONObject);
            } else if (this.mType == 512) {
                this.aIE = new z(jSONObject);
            } else if (this.mType == 16) {
                this.aJe = new b(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.aIG = new d();
                this.aIG.ayk.axL = String.format("#(%s)", jSONObject.optString("c"));
                this.aIG.ayk.axN = jSONObject.optString("dynamic");
                this.aIG.ayk.axM = jSONObject.optString("static");
                this.aIG.mType = this.mType;
                this.aIG.ayk.axO = jSONObject.optInt(GraffitiVcodeActivityConfig.WIDTH, 200);
                this.aIG.ayk.axP = jSONObject.optInt(GraffitiVcodeActivityConfig.HEIGHT, 200);
                this.aIG.ayk.mPackageName = jSONObject.optString("packet_name", "");
                this.aIG.ayk.mIcon = jSONObject.optString("icon");
                String[] split = this.aIG.ayk.axN.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.aIG.ayk.mGid = split[i].split("_")[0];
            } else {
                this.aJe = new b(jSONObject);
                if (this.mType == 4) {
                    int fp = TbFaceManager.Ej().fp(this.aJe.getText());
                    String optString = jSONObject.optString("c");
                    if (fp <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.m9getInst().getString(t.j.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.aJe.setText(str);
                    } else {
                        this.aJe.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.aJe.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.aJe != null) {
                this.aJe.Id();
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
            case 17:
                return 1792;
            case 18:
                return 18;
        }
    }
}
