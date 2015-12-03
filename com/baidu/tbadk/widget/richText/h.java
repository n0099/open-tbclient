package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.n;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.lib.a.b.a.a.i {
    private int mType = 0;
    private b aDr = null;
    private f aCV = null;
    private v aCX = null;
    private d aCZ = null;
    private m aDa = null;
    private j aDc = null;
    private k aDb = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, b bVar, f fVar, v vVar, d dVar, j jVar, k kVar) {
        this.mType = i;
        this.aDr = bVar;
        this.aCV = fVar;
        this.aCX = vVar;
        this.aCZ = dVar;
        this.aDc = jVar;
        this.aDb = kVar;
    }

    public k FX() {
        if (this.mType == 1280) {
            return this.aDb;
        }
        return null;
    }

    public j FY() {
        if (this.mType == 1024) {
            return this.aDc;
        }
        return null;
    }

    public f FQ() {
        if (this.mType == 8) {
            return this.aCV;
        }
        return null;
    }

    public m FU() {
        if (this.mType != 32) {
            return null;
        }
        return this.aDa;
    }

    public v FS() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aCX;
        }
        return null;
    }

    public d FV() {
        if (this.mType == 17) {
            return this.aCZ;
        }
        return null;
    }

    public SpannableString Ge() {
        if (this.mType != 1 || this.aDr == null) {
            return null;
        }
        return new SpannableString(this.aDr.getText());
    }

    public CharSequence w(ArrayList<e> arrayList) {
        SpannableString c;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.aDr != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.m411getInst().getString(n.i.video_text));
            CharSequence y = y(arrayList);
            if (y != null) {
                spannableStringBuilder.append(y);
            }
            if (this.aDr.FM() == 1) {
                c = c(this.mType, this.aDr.getText(), this.aDr.FN());
            } else {
                c = c(this.mType, this.aDr.getText(), this.aDr.getText());
            }
            if (c != null) {
                spannableStringBuilder.append((CharSequence) c);
            }
        }
        return spannableStringBuilder;
    }

    public CharSequence x(ArrayList<e> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.aDr != null) {
            CharSequence y = y(arrayList);
            if (y != null) {
                spannableStringBuilder.append(y);
            }
            SpannableString c = c(this.mType, this.aDr.getLink(), this.aDr.getLink());
            if (c != null) {
                spannableStringBuilder.append((CharSequence) c);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence y(ArrayList<e> arrayList) {
        h hVar = new h();
        hVar.a(4, new b("video_icon", " "), null, null, null, null, null);
        return hVar.A(arrayList);
    }

    public String getVideoUrl() {
        if (this.mType != 32 || this.aDr == null) {
            return null;
        }
        if (this.aDr.FM() == 1) {
            return this.aDr.FN();
        }
        return this.aDr.getText();
    }

    public SpannableString Gf() {
        if (this.mType != 2 || this.aDr == null) {
            return null;
        }
        if (this.aDr.FM() == 1) {
            return c(this.mType, this.aDr.getText(), this.aDr.FN());
        }
        return c(this.mType, this.aDr.getText(), this.aDr.getLink());
    }

    public SpannableString Gg() {
        if (this.mType != 256 || this.aDr == null) {
            return null;
        }
        String text = this.aDr.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = String.valueOf(text) + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        g gVar = new g(this.mType, text);
        gVar.gg(this.aDr.getLink());
        spannableString.setSpan(gVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    public SpannableString Gh() {
        if (this.mType != 16 || this.aDr == null) {
            return null;
        }
        return c(this.mType, this.aDr.getText(), this.aDr.getLink());
    }

    private SpannableString z(ArrayList<e> arrayList) {
        String text;
        int fa;
        a.C0051a fB;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.aDr != null && this.aDr.getText() != null && this.aDr.getLink() != null && (fa = TbFaceManager.CW().fa((text = this.aDr.getText()))) != 0) {
            String str = "#(" + TbFaceManager.CW().fc(text) + ")";
            spannableString = new SpannableString(String.valueOf(str) + " ");
            e eVar = new e(TbadkCoreApplication.m411getInst().getContext(), fa);
            if (arrayList != null) {
                arrayList.add(eVar);
            }
            if (TbFaceManager.CW().fB(text) != null) {
                int width = (int) (fB.getWidth() * 0.5d);
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
        spannableString.setSpan(new g(i, str2), 0, str.length() - 1, 33);
        return spannableString;
    }

    public SpannableString Gi() {
        if (this.mType != 1024 || this.aDc == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString("a");
        Drawable eX = i.eX(this.aDc.aDs);
        eX.setBounds(0, 0, eX.getIntrinsicWidth(), eX.getIntrinsicHeight());
        com.baidu.tbadk.widget.f fVar = new com.baidu.tbadk.widget.f(eX);
        fVar.setVerticalOffset(com.baidu.adp.lib.util.k.d(TbadkCoreApplication.m411getInst().getContext(), n.d.ds4));
        spannableString.setSpan(fVar, 0, 1, 33);
        spannableString.setSpan(new g(1024, this.aDc.link), spannableString.length() - 1, "a".length(), 33);
        return spannableString;
    }

    public CharSequence A(ArrayList<e> arrayList) {
        switch (this.mType) {
            case 1:
                return Ge();
            case 2:
                return Gf();
            case 4:
                return z(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return Gh();
            case 32:
                return w(arrayList);
            case 128:
                return x(arrayList);
            case 256:
                return Gg();
            case 1024:
                return Gi();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.aDa.Gm() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = eW(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.aCV = new f(pbContent);
                    break;
                case 16:
                    this.aDr = new b(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.aCZ = new d();
                    this.aCZ.auv.atV = String.format("#(%s)", pbContent.c);
                    this.aCZ.auv.atX = pbContent.dynamic;
                    this.aCZ.auv.atW = pbContent._static;
                    this.aCZ.mType = this.mType;
                    this.aCZ.auv.atY = pbContent.width.intValue();
                    this.aCZ.auv.atZ = pbContent.height.intValue();
                    this.aCZ.auv.mPackageName = pbContent.packet_name;
                    this.aCZ.auv.aua = pbContent._static;
                    String[] split = this.aCZ.auv.atX.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.aCZ.auv.mGid = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.aCZ.auv.mGid = split[i].split("_")[0];
                case 512:
                    this.aCX = new v(pbContent);
                    break;
                case 1024:
                    this.aDc = new j(pbContent);
                    break;
                case 1280:
                    this.aDb = new k(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.aDa = new m();
                        this.aDa.b(pbContent);
                        break;
                    }
                    this.aDr = new b(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.CW().fa(this.aDr.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.m411getInst().getString(n.i.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.aDr.setText(str);
                            break;
                        } else {
                            this.aDr.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.aDr.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.aDr != null) {
                this.aDr.FO();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = eW(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.aCV = new f(jSONObject);
            } else if (this.mType == 512) {
                this.aCX = new v(jSONObject);
            } else if (this.mType == 16) {
                this.aDr = new b(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.aCZ = new d();
                this.aCZ.auv.atV = String.format("#(%s)", jSONObject.optString("c"));
                this.aCZ.auv.atX = jSONObject.optString("dynamic");
                this.aCZ.auv.atW = jSONObject.optString("static");
                this.aCZ.mType = this.mType;
                this.aCZ.auv.atY = jSONObject.optInt("width", 200);
                this.aCZ.auv.atZ = jSONObject.optInt("height", 200);
                this.aCZ.auv.mPackageName = jSONObject.optString("packet_name", "");
                this.aCZ.auv.aua = jSONObject.optString("icon");
                String[] split = this.aCZ.auv.atX.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.aCZ.auv.mGid = split[i].split("_")[0];
            } else {
                this.aDr = new b(jSONObject);
                if (this.mType == 4) {
                    int fa = TbFaceManager.CW().fa(this.aDr.getText());
                    String optString = jSONObject.optString("c");
                    if (fa <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.m411getInst().getString(n.i.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.aDr.setText(str);
                    } else {
                        this.aDr.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.aDr.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.aDr != null) {
                this.aDr.FO();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int eW(int i) {
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
        }
    }
}
