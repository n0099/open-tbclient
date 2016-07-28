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
import com.baidu.tieba.u;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.lib.a.b.a.a.i {
    private f aFA;
    private n aFB;
    private int mType = 0;
    private b aFS = null;
    private g aFs = null;
    private z aFu = null;
    private d aFw = null;
    private o aFx = null;
    private k aFz = null;
    private l aFy = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, b bVar, g gVar, z zVar, d dVar, k kVar, l lVar) {
        this.mType = i;
        this.aFS = bVar;
        this.aFs = gVar;
        this.aFu = zVar;
        this.aFw = dVar;
        this.aFz = kVar;
        this.aFy = lVar;
    }

    public l GP() {
        if (this.mType == 1280) {
            return this.aFy;
        }
        return null;
    }

    public k GQ() {
        if (this.mType == 1024) {
            return this.aFz;
        }
        return null;
    }

    public g GI() {
        if (this.mType == 8) {
            return this.aFs;
        }
        return null;
    }

    public o GM() {
        if (this.mType != 32) {
            return null;
        }
        return this.aFx;
    }

    public z GK() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aFu;
        }
        return null;
    }

    public d GN() {
        if (this.mType == 17) {
            return this.aFw;
        }
        return null;
    }

    public f GR() {
        if (this.mType == 1536) {
            return this.aFA;
        }
        return null;
    }

    public n GS() {
        if (this.mType == 1792) {
            return this.aFB;
        }
        return null;
    }

    public SpannableString GY() {
        if (this.mType != 1 || this.aFS == null) {
            return null;
        }
        return new SpannableString(this.aFS.getText());
    }

    public CharSequence t(ArrayList<e> arrayList) {
        SpannableString c;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.aFS != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.m10getInst().getString(u.j.video_text));
            CharSequence v = v(arrayList);
            if (v != null) {
                spannableStringBuilder.append(v);
            }
            if (this.aFS.GE() == 1) {
                c = c(this.mType, this.aFS.getText(), this.aFS.GF());
            } else {
                c = c(this.mType, this.aFS.getText(), this.aFS.getText());
            }
            if (c != null) {
                spannableStringBuilder.append((CharSequence) c);
            }
        }
        return spannableStringBuilder;
    }

    public CharSequence u(ArrayList<e> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.aFS != null) {
            CharSequence v = v(arrayList);
            if (v != null) {
                spannableStringBuilder.append(v);
            }
            SpannableString c = c(this.mType, this.aFS.getLink(), this.aFS.getLink());
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
        if (this.mType != 32 || this.aFS == null) {
            return null;
        }
        if (this.aFS.GE() == 1) {
            return this.aFS.GF();
        }
        return this.aFS.getText();
    }

    public SpannableString GZ() {
        if (this.mType != 2 || this.aFS == null) {
            return null;
        }
        if (this.aFS.GE() == 1) {
            return c(this.mType, this.aFS.getText(), this.aFS.GF());
        }
        return c(this.mType, this.aFS.getText(), this.aFS.getLink());
    }

    public SpannableString Ha() {
        if (this.mType != 256 || this.aFS == null) {
            return null;
        }
        String text = this.aFS.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = String.valueOf(text) + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        h hVar = new h(this.mType, text);
        hVar.gA(this.aFS.getLink());
        spannableString.setSpan(hVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    public SpannableString Hb() {
        if (this.mType != 16 || this.aFS == null) {
            return null;
        }
        return c(this.mType, this.aFS.getText(), this.aFS.getLink());
    }

    private SpannableString w(ArrayList<e> arrayList) {
        String text;
        int fm;
        a.C0044a fM;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.aFS != null && this.aFS.getText() != null && this.aFS.getLink() != null && (fm = TbFaceManager.CO().fm((text = this.aFS.getText()))) != 0) {
            String str = "#(" + TbFaceManager.CO().fo(text) + ")";
            spannableString = new SpannableString(String.valueOf(str) + " ");
            e eVar = new e(TbadkCoreApplication.m10getInst().getContext(), fm);
            if (arrayList != null) {
                arrayList.add(eVar);
            }
            if (TbFaceManager.CO().fM(text) != null) {
                int width = (int) (fM.getWidth() * 0.5d);
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

    public SpannableString Hc() {
        if (this.mType != 1024 || this.aFz == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString("a");
        Drawable fi = j.fi(this.aFz.aFT);
        fi.setBounds(0, 0, fi.getIntrinsicWidth(), fi.getIntrinsicHeight());
        com.baidu.tbadk.widget.f fVar = new com.baidu.tbadk.widget.f(fi);
        fVar.setVerticalOffset(com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m10getInst().getContext(), u.e.ds4));
        spannableString.setSpan(fVar, 0, 1, 33);
        spannableString.setSpan(new h(1024, this.aFz.link), spannableString.length() - 1, "a".length(), 33);
        return spannableString;
    }

    public CharSequence x(ArrayList<e> arrayList) {
        switch (this.mType) {
            case 1:
                return GY();
            case 2:
                return GZ();
            case 4:
                return w(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return Hb();
            case 32:
                return t(arrayList);
            case 128:
                return u(arrayList);
            case 256:
                return Ha();
            case 1024:
                return Hc();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.aFx.Hm() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = fh(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.aFs = new g(pbContent);
                    break;
                case 16:
                    this.aFS = new b(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.aFw = new d();
                    this.aFw.avd.auE = String.format("#(%s)", pbContent.c);
                    this.aFw.avd.auG = pbContent.dynamic;
                    this.aFw.avd.auF = pbContent._static;
                    this.aFw.mType = this.mType;
                    this.aFw.avd.auH = pbContent.width.intValue();
                    this.aFw.avd.auI = pbContent.height.intValue();
                    this.aFw.avd.mPackageName = pbContent.packet_name;
                    this.aFw.avd.mIcon = pbContent._static;
                    String[] split = this.aFw.avd.auG.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.aFw.avd.mGid = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.aFw.avd.mGid = split[i].split("_")[0];
                case 512:
                    this.aFu = new z(pbContent);
                    break;
                case 1024:
                    this.aFz = new k(pbContent);
                    break;
                case 1280:
                    this.aFy = new l(pbContent);
                    break;
                case 1536:
                    this.aFA = new f();
                    this.aFA.a(pbContent);
                    break;
                case 1792:
                    this.aFB = new n();
                    this.aFB.a(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.aFx = new o();
                        this.aFx.a(pbContent);
                        break;
                    }
                    this.aFS = new b(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.CO().fm(this.aFS.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.m10getInst().getString(u.j.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.aFS.setText(str);
                            break;
                        } else {
                            this.aFS.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.aFS.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.aFS != null) {
                this.aFS.GG();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = fh(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.aFs = new g(jSONObject);
            } else if (this.mType == 512) {
                this.aFu = new z(jSONObject);
            } else if (this.mType == 16) {
                this.aFS = new b(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.aFw = new d();
                this.aFw.avd.auE = String.format("#(%s)", jSONObject.optString("c"));
                this.aFw.avd.auG = jSONObject.optString("dynamic");
                this.aFw.avd.auF = jSONObject.optString("static");
                this.aFw.mType = this.mType;
                this.aFw.avd.auH = jSONObject.optInt(GraffitiVcodeActivityConfig.WIDTH, 200);
                this.aFw.avd.auI = jSONObject.optInt(GraffitiVcodeActivityConfig.HEIGHT, 200);
                this.aFw.avd.mPackageName = jSONObject.optString("packet_name", "");
                this.aFw.avd.mIcon = jSONObject.optString("icon");
                String[] split = this.aFw.avd.auG.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.aFw.avd.mGid = split[i].split("_")[0];
            } else {
                this.aFS = new b(jSONObject);
                if (this.mType == 4) {
                    int fm = TbFaceManager.CO().fm(this.aFS.getText());
                    String optString = jSONObject.optString("c");
                    if (fm <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.m10getInst().getString(u.j.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.aFS.setText(str);
                    } else {
                        this.aFS.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.aFS.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.aFS != null) {
                this.aFS.GG();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int fh(int i) {
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
