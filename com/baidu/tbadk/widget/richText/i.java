package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.r;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.lib.a.b.a.a.i {
    private f aIs;
    private int mType = 0;
    private b aIL = null;
    private g aIk = null;
    private y aIm = null;
    private d aIo = null;
    private n aIp = null;
    private k aIr = null;
    private l aIq = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, b bVar, g gVar, y yVar, d dVar, k kVar, l lVar) {
        this.mType = i;
        this.aIL = bVar;
        this.aIk = gVar;
        this.aIm = yVar;
        this.aIo = dVar;
        this.aIr = kVar;
        this.aIq = lVar;
    }

    public l HK() {
        if (this.mType == 1280) {
            return this.aIq;
        }
        return null;
    }

    public k HL() {
        if (this.mType == 1024) {
            return this.aIr;
        }
        return null;
    }

    public g HD() {
        if (this.mType == 8) {
            return this.aIk;
        }
        return null;
    }

    public n HH() {
        if (this.mType != 32) {
            return null;
        }
        return this.aIp;
    }

    public y HF() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aIm;
        }
        return null;
    }

    public d HI() {
        if (this.mType == 17) {
            return this.aIo;
        }
        return null;
    }

    public f HM() {
        if (this.mType == 1536) {
            return this.aIs;
        }
        return null;
    }

    private SpannableString HU() {
        if (this.mType != 1 || this.aIL == null) {
            return null;
        }
        return new SpannableString(this.aIL.getText());
    }

    private CharSequence u(ArrayList<e> arrayList) {
        SpannableString c;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.aIL != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.m9getInst().getString(r.j.video_text));
            CharSequence w = w(arrayList);
            if (w != null) {
                spannableStringBuilder.append(w);
            }
            if (this.aIL.Hz() == 1) {
                c = c(this.mType, this.aIL.getText(), this.aIL.HA());
            } else {
                c = c(this.mType, this.aIL.getText(), this.aIL.getText());
            }
            if (c != null) {
                spannableStringBuilder.append((CharSequence) c);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence v(ArrayList<e> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.aIL != null) {
            CharSequence w = w(arrayList);
            if (w != null) {
                spannableStringBuilder.append(w);
            }
            SpannableString c = c(this.mType, this.aIL.getLink(), this.aIL.getLink());
            if (c != null) {
                spannableStringBuilder.append((CharSequence) c);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence w(ArrayList<e> arrayList) {
        i iVar = new i();
        iVar.a(4, new b("video_icon", " "), null, null, null, null, null);
        return iVar.y(arrayList);
    }

    public String getVideoUrl() {
        if (this.mType != 32 || this.aIL == null) {
            return null;
        }
        if (this.aIL.Hz() == 1) {
            return this.aIL.HA();
        }
        return this.aIL.getText();
    }

    private SpannableString HV() {
        if ((this.mType != 2 && this.mType != 18) || this.aIL == null) {
            return null;
        }
        if (this.aIL.Hz() == 1) {
            return c(this.mType, this.aIL.getText(), this.aIL.HA());
        }
        return c(this.mType, this.aIL.getText(), this.aIL.getLink());
    }

    private SpannableString HW() {
        if (this.mType != 256 || this.aIL == null) {
            return null;
        }
        String text = this.aIL.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = String.valueOf(text) + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        h hVar = new h(this.mType, text);
        hVar.gC(this.aIL.getLink());
        spannableString.setSpan(hVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString HX() {
        if (this.mType != 16 || this.aIL == null) {
            return null;
        }
        return c(this.mType, this.aIL.getText(), this.aIL.getLink());
    }

    private SpannableString x(ArrayList<e> arrayList) {
        String text;
        int fq;
        a.C0044a fS;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.aIL != null && this.aIL.getText() != null && this.aIL.getLink() != null && (fq = TbFaceManager.DW().fq((text = this.aIL.getText()))) != 0) {
            String str = "#(" + TbFaceManager.DW().fs(text) + ")";
            spannableString = new SpannableString(String.valueOf(str) + " ");
            e eVar = new e(TbadkCoreApplication.m9getInst().getContext(), fq);
            if (arrayList != null) {
                arrayList.add(eVar);
            }
            if (TbFaceManager.DW().fS(text) != null) {
                int width = (int) (fS.getWidth() * 0.5d);
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

    private SpannableString HY() {
        if (this.mType != 1024 || this.aIr == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString("a");
        Drawable fA = j.fA(this.aIr.aIM);
        fA.setBounds(0, 0, fA.getIntrinsicWidth(), fA.getIntrinsicHeight());
        com.baidu.tbadk.widget.f fVar = new com.baidu.tbadk.widget.f(fA);
        fVar.setVerticalOffset(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getContext(), r.e.ds4));
        spannableString.setSpan(fVar, 0, 1, 33);
        spannableString.setSpan(new h(1024, this.aIr.link), spannableString.length() - 1, "a".length(), 33);
        return spannableString;
    }

    public CharSequence y(ArrayList<e> arrayList) {
        switch (this.mType) {
            case 1:
                return HU();
            case 2:
                return HV();
            case 4:
                return x(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return HX();
            case 18:
                return HV();
            case 32:
                return u(arrayList);
            case 128:
                return v(arrayList);
            case 256:
                return HW();
            case 1024:
                return HY();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.aIp.Ii() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = fz(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.aIk = new g(pbContent);
                    break;
                case 16:
                    this.aIL = new b(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.aIo = new d();
                    this.aIo.ayb.axC = String.format("#(%s)", pbContent.c);
                    this.aIo.ayb.axE = pbContent.dynamic;
                    this.aIo.ayb.axD = pbContent._static;
                    this.aIo.mType = this.mType;
                    this.aIo.ayb.axF = pbContent.width.intValue();
                    this.aIo.ayb.axG = pbContent.height.intValue();
                    this.aIo.ayb.mPackageName = pbContent.packet_name;
                    this.aIo.ayb.mIcon = pbContent._static;
                    String[] split = this.aIo.ayb.axE.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.aIo.ayb.mGid = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.aIo.ayb.mGid = split[i].split("_")[0];
                case 512:
                    this.aIm = new y(pbContent);
                    break;
                case 1024:
                    this.aIr = new k(pbContent);
                    break;
                case 1280:
                    this.aIq = new l(pbContent);
                    break;
                case 1536:
                    this.aIs = new f();
                    this.aIs.a(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.aIp = new n();
                        this.aIp.a(pbContent);
                        break;
                    }
                    this.aIL = new b(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.DW().fq(this.aIL.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.m9getInst().getString(r.j.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.aIL.setText(str);
                            break;
                        } else {
                            this.aIL.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.aIL.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.aIL != null) {
                this.aIL.HB();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = fz(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.aIk = new g(jSONObject);
            } else if (this.mType == 512) {
                this.aIm = new y(jSONObject);
            } else if (this.mType == 16) {
                this.aIL = new b(jSONObject.optString("text"), jSONObject.optString(SapiAccountManager.SESSION_UID));
            } else if (this.mType == 17) {
                this.aIo = new d();
                this.aIo.ayb.axC = String.format("#(%s)", jSONObject.optString("c"));
                this.aIo.ayb.axE = jSONObject.optString("dynamic");
                this.aIo.ayb.axD = jSONObject.optString("static");
                this.aIo.mType = this.mType;
                this.aIo.ayb.axF = jSONObject.optInt("width", 200);
                this.aIo.ayb.axG = jSONObject.optInt("height", 200);
                this.aIo.ayb.mPackageName = jSONObject.optString("packet_name", "");
                this.aIo.ayb.mIcon = jSONObject.optString("icon");
                String[] split = this.aIo.ayb.axE.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.aIo.ayb.mGid = split[i].split("_")[0];
            } else {
                this.aIL = new b(jSONObject);
                if (this.mType == 4) {
                    int fq = TbFaceManager.DW().fq(this.aIL.getText());
                    String optString = jSONObject.optString("c");
                    if (fq <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.m9getInst().getString(r.j.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.aIL.setText(str);
                    } else {
                        this.aIL.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.aIL.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.aIL != null) {
                this.aIL.HB();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int fz(int i) {
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
            case 17:
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
            case 18:
                return 18;
        }
    }
}
