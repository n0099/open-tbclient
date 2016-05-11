package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CommonVcodeActivityConfig;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.t;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.lib.a.b.a.a.i {
    private f aEi;
    private n aEj;
    private int mType = 0;
    private b aEA = null;
    private g aEa = null;
    private z aEc = null;
    private d aEe = null;
    private o aEf = null;
    private k aEh = null;
    private l aEg = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, b bVar, g gVar, z zVar, d dVar, k kVar, l lVar) {
        this.mType = i;
        this.aEA = bVar;
        this.aEa = gVar;
        this.aEc = zVar;
        this.aEe = dVar;
        this.aEh = kVar;
        this.aEg = lVar;
    }

    public l GO() {
        if (this.mType == 1280) {
            return this.aEg;
        }
        return null;
    }

    public k GP() {
        if (this.mType == 1024) {
            return this.aEh;
        }
        return null;
    }

    public g GH() {
        if (this.mType == 8) {
            return this.aEa;
        }
        return null;
    }

    public o GL() {
        if (this.mType != 32) {
            return null;
        }
        return this.aEf;
    }

    public z GJ() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aEc;
        }
        return null;
    }

    public d GM() {
        if (this.mType == 17) {
            return this.aEe;
        }
        return null;
    }

    public f GQ() {
        if (this.mType == 1536) {
            return this.aEi;
        }
        return null;
    }

    public n GR() {
        if (this.mType == 1792) {
            return this.aEj;
        }
        return null;
    }

    public SpannableString GX() {
        if (this.mType != 1 || this.aEA == null) {
            return null;
        }
        return new SpannableString(this.aEA.getText());
    }

    public CharSequence s(ArrayList<e> arrayList) {
        SpannableString c;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.aEA != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.m11getInst().getString(t.j.video_text));
            CharSequence u = u(arrayList);
            if (u != null) {
                spannableStringBuilder.append(u);
            }
            if (this.aEA.GD() == 1) {
                c = c(this.mType, this.aEA.getText(), this.aEA.GE());
            } else {
                c = c(this.mType, this.aEA.getText(), this.aEA.getText());
            }
            if (c != null) {
                spannableStringBuilder.append((CharSequence) c);
            }
        }
        return spannableStringBuilder;
    }

    public CharSequence t(ArrayList<e> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.aEA != null) {
            CharSequence u = u(arrayList);
            if (u != null) {
                spannableStringBuilder.append(u);
            }
            SpannableString c = c(this.mType, this.aEA.getLink(), this.aEA.getLink());
            if (c != null) {
                spannableStringBuilder.append((CharSequence) c);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence u(ArrayList<e> arrayList) {
        i iVar = new i();
        iVar.a(4, new b("video_icon", " "), null, null, null, null, null);
        return iVar.w(arrayList);
    }

    public String getVideoUrl() {
        if (this.mType != 32 || this.aEA == null) {
            return null;
        }
        if (this.aEA.GD() == 1) {
            return this.aEA.GE();
        }
        return this.aEA.getText();
    }

    public SpannableString GY() {
        if (this.mType != 2 || this.aEA == null) {
            return null;
        }
        if (this.aEA.GD() == 1) {
            return c(this.mType, this.aEA.getText(), this.aEA.GE());
        }
        return c(this.mType, this.aEA.getText(), this.aEA.getLink());
    }

    public SpannableString GZ() {
        if (this.mType != 256 || this.aEA == null) {
            return null;
        }
        String text = this.aEA.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = String.valueOf(text) + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        h hVar = new h(this.mType, text);
        hVar.gu(this.aEA.getLink());
        spannableString.setSpan(hVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    public SpannableString Ha() {
        if (this.mType != 16 || this.aEA == null) {
            return null;
        }
        return c(this.mType, this.aEA.getText(), this.aEA.getLink());
    }

    private SpannableString v(ArrayList<e> arrayList) {
        String text;
        int fi;
        a.C0043a fI;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.aEA != null && this.aEA.getText() != null && this.aEA.getLink() != null && (fi = TbFaceManager.CG().fi((text = this.aEA.getText()))) != 0) {
            String str = "#(" + TbFaceManager.CG().fk(text) + ")";
            spannableString = new SpannableString(String.valueOf(str) + " ");
            e eVar = new e(TbadkCoreApplication.m11getInst().getContext(), fi);
            if (arrayList != null) {
                arrayList.add(eVar);
            }
            if (TbFaceManager.CG().fI(text) != null) {
                int width = (int) (fI.getWidth() * 0.5d);
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

    public SpannableString Hb() {
        if (this.mType != 1024 || this.aEh == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString("a");
        Drawable fe = j.fe(this.aEh.aEB);
        fe.setBounds(0, 0, fe.getIntrinsicWidth(), fe.getIntrinsicHeight());
        com.baidu.tbadk.widget.f fVar = new com.baidu.tbadk.widget.f(fe);
        fVar.setVerticalOffset(com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m11getInst().getContext(), t.e.ds4));
        spannableString.setSpan(fVar, 0, 1, 33);
        spannableString.setSpan(new h(1024, this.aEh.link), spannableString.length() - 1, "a".length(), 33);
        return spannableString;
    }

    public CharSequence w(ArrayList<e> arrayList) {
        switch (this.mType) {
            case 1:
                return GX();
            case 2:
                return GY();
            case 4:
                return v(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return Ha();
            case 32:
                return s(arrayList);
            case 128:
                return t(arrayList);
            case 256:
                return GZ();
            case 1024:
                return Hb();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.aEf.Hl() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = fd(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.aEa = new g(pbContent);
                    break;
                case 16:
                    this.aEA = new b(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.aEe = new d();
                    this.aEe.aty.asZ = String.format("#(%s)", pbContent.c);
                    this.aEe.aty.atb = pbContent.dynamic;
                    this.aEe.aty.ata = pbContent._static;
                    this.aEe.mType = this.mType;
                    this.aEe.aty.atc = pbContent.width.intValue();
                    this.aEe.aty.atd = pbContent.height.intValue();
                    this.aEe.aty.mPackageName = pbContent.packet_name;
                    this.aEe.aty.NM = pbContent._static;
                    String[] split = this.aEe.aty.atb.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.aEe.aty.mGid = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.aEe.aty.mGid = split[i].split("_")[0];
                case 512:
                    this.aEc = new z(pbContent);
                    break;
                case 1024:
                    this.aEh = new k(pbContent);
                    break;
                case 1280:
                    this.aEg = new l(pbContent);
                    break;
                case 1536:
                    this.aEi = new f();
                    this.aEi.a(pbContent);
                    break;
                case 1792:
                    this.aEj = new n();
                    this.aEj.a(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.aEf = new o();
                        this.aEf.a(pbContent);
                        break;
                    }
                    this.aEA = new b(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.CG().fi(this.aEA.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.m11getInst().getString(t.j.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.aEA.setText(str);
                            break;
                        } else {
                            this.aEA.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.aEA.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.aEA != null) {
                this.aEA.GF();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = fd(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.aEa = new g(jSONObject);
            } else if (this.mType == 512) {
                this.aEc = new z(jSONObject);
            } else if (this.mType == 16) {
                this.aEA = new b(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.aEe = new d();
                this.aEe.aty.asZ = String.format("#(%s)", jSONObject.optString("c"));
                this.aEe.aty.atb = jSONObject.optString("dynamic");
                this.aEe.aty.ata = jSONObject.optString("static");
                this.aEe.mType = this.mType;
                this.aEe.aty.atc = jSONObject.optInt(CommonVcodeActivityConfig.WIDTH, 200);
                this.aEe.aty.atd = jSONObject.optInt(CommonVcodeActivityConfig.HEIGHT, 200);
                this.aEe.aty.mPackageName = jSONObject.optString("packet_name", "");
                this.aEe.aty.NM = jSONObject.optString("icon");
                String[] split = this.aEe.aty.atb.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.aEe.aty.mGid = split[i].split("_")[0];
            } else {
                this.aEA = new b(jSONObject);
                if (this.mType == 4) {
                    int fi = TbFaceManager.CG().fi(this.aEA.getText());
                    String optString = jSONObject.optString("c");
                    if (fi <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.m11getInst().getString(t.j.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.aEA.setText(str);
                    } else {
                        this.aEA.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.aEA.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.aEA != null) {
                this.aEA.GF();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int fd(int i) {
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
        }
    }
}
