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
import com.baidu.tieba.i;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.lib.a.b.a.a.i {
    private int mType = 0;
    private b aAH = null;
    private f aAl = null;
    private v aAn = null;
    private d aAp = null;
    private m aAq = null;
    private j aAs = null;
    private k aAr = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, b bVar, f fVar, v vVar, d dVar, j jVar, k kVar) {
        this.mType = i;
        this.aAH = bVar;
        this.aAl = fVar;
        this.aAn = vVar;
        this.aAp = dVar;
        this.aAs = jVar;
        this.aAr = kVar;
    }

    public k EU() {
        if (this.mType == 1280) {
            return this.aAr;
        }
        return null;
    }

    public j EV() {
        if (this.mType == 1024) {
            return this.aAs;
        }
        return null;
    }

    public f EN() {
        if (this.mType == 8) {
            return this.aAl;
        }
        return null;
    }

    public m ER() {
        if (this.mType != 32) {
            return null;
        }
        return this.aAq;
    }

    public v EP() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aAn;
        }
        return null;
    }

    public d ES() {
        if (this.mType == 17) {
            return this.aAp;
        }
        return null;
    }

    public SpannableString Fb() {
        if (this.mType != 1 || this.aAH == null) {
            return null;
        }
        return new SpannableString(this.aAH.getText());
    }

    public CharSequence t(ArrayList<e> arrayList) {
        SpannableString c;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.aAH != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.m411getInst().getString(i.h.video_text));
            CharSequence v = v(arrayList);
            if (v != null) {
                spannableStringBuilder.append(v);
            }
            if (this.aAH.EJ() == 1) {
                c = c(this.mType, this.aAH.getText(), this.aAH.EK());
            } else {
                c = c(this.mType, this.aAH.getText(), this.aAH.getText());
            }
            if (c != null) {
                spannableStringBuilder.append((CharSequence) c);
            }
        }
        return spannableStringBuilder;
    }

    public CharSequence u(ArrayList<e> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.aAH != null) {
            CharSequence v = v(arrayList);
            if (v != null) {
                spannableStringBuilder.append(v);
            }
            SpannableString c = c(this.mType, this.aAH.getLink(), this.aAH.getLink());
            if (c != null) {
                spannableStringBuilder.append((CharSequence) c);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence v(ArrayList<e> arrayList) {
        h hVar = new h();
        hVar.a(4, new b("video_icon", " "), null, null, null, null, null);
        return hVar.x(arrayList);
    }

    public String getVideoUrl() {
        if (this.mType != 32 || this.aAH == null) {
            return null;
        }
        if (this.aAH.EJ() == 1) {
            return this.aAH.EK();
        }
        return this.aAH.getText();
    }

    public SpannableString Fc() {
        if (this.mType != 2 || this.aAH == null) {
            return null;
        }
        if (this.aAH.EJ() == 1) {
            return c(this.mType, this.aAH.getText(), this.aAH.EK());
        }
        return c(this.mType, this.aAH.getText(), this.aAH.getLink());
    }

    public SpannableString Fd() {
        if (this.mType != 256 || this.aAH == null) {
            return null;
        }
        String text = this.aAH.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = String.valueOf(text) + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        g gVar = new g(this.mType, text);
        gVar.fS(this.aAH.getLink());
        spannableString.setSpan(gVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    public SpannableString Fe() {
        if (this.mType != 16 || this.aAH == null) {
            return null;
        }
        return c(this.mType, this.aAH.getText(), this.aAH.getLink());
    }

    private SpannableString w(ArrayList<e> arrayList) {
        String text;
        int eM;
        a.C0049a fm;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.aAH != null && this.aAH.getText() != null && this.aAH.getLink() != null && (eM = TbFaceManager.BU().eM((text = this.aAH.getText()))) != 0) {
            String str = "#(" + TbFaceManager.BU().eO(text) + ")";
            spannableString = new SpannableString(String.valueOf(str) + " ");
            e eVar = new e(TbadkCoreApplication.m411getInst().getContext(), eM);
            if (arrayList != null) {
                arrayList.add(eVar);
            }
            if (TbFaceManager.BU().fm(text) != null) {
                int width = (int) (fm.getWidth() * 0.5d);
                eVar.setBounds(new Rect(0, 0, width, width));
            } else {
                eVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new com.baidu.tbadk.widget.g(eVar), 0, str.length(), 33);
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

    public SpannableString Ff() {
        if (this.mType != 1024 || this.aAs == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString("a");
        Drawable eK = i.eK(this.aAs.aAI);
        eK.setBounds(0, 0, eK.getIntrinsicWidth(), eK.getIntrinsicHeight());
        com.baidu.tbadk.widget.g gVar = new com.baidu.tbadk.widget.g(eK);
        gVar.eH(com.baidu.adp.lib.util.k.d(TbadkCoreApplication.m411getInst().getContext(), i.d.ds4));
        spannableString.setSpan(gVar, 0, 1, 33);
        spannableString.setSpan(new g(1024, this.aAs.link), spannableString.length() - 1, "a".length(), 33);
        return spannableString;
    }

    public CharSequence x(ArrayList<e> arrayList) {
        switch (this.mType) {
            case 1:
                return Fb();
            case 2:
                return Fc();
            case 4:
                return w(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return Fe();
            case 32:
                return t(arrayList);
            case 128:
                return u(arrayList);
            case 256:
                return Fd();
            case 1024:
                return Ff();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.aAq.Fh() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = eJ(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.aAl = new f(pbContent);
                    break;
                case 16:
                    this.aAH = new b(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.aAp = new d();
                    this.aAp.ast.arU = String.format("#(%s)", pbContent.c);
                    this.aAp.ast.arW = pbContent.dynamic;
                    this.aAp.ast.arV = pbContent._static;
                    this.aAp.mType = this.mType;
                    this.aAp.ast.arX = pbContent.width.intValue();
                    this.aAp.ast.arY = pbContent.height.intValue();
                    this.aAp.ast.mPackageName = pbContent.packet_name;
                    this.aAp.ast.arZ = pbContent._static;
                    String[] split = this.aAp.ast.arW.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.aAp.ast.mGid = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.aAp.ast.mGid = split[i].split("_")[0];
                case 512:
                    this.aAn = new v(pbContent);
                    break;
                case 1024:
                    this.aAs = new j(pbContent);
                    break;
                case 1280:
                    this.aAr = new k(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.aAq = new m();
                        this.aAq.b(pbContent);
                        break;
                    }
                    this.aAH = new b(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.BU().eM(this.aAH.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.m411getInst().getString(i.h.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.aAH.setText(str);
                            break;
                        } else {
                            this.aAH.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.aAH.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.aAH != null) {
                this.aAH.EL();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = eJ(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.aAl = new f(jSONObject);
            } else if (this.mType == 512) {
                this.aAn = new v(jSONObject);
            } else if (this.mType == 16) {
                this.aAH = new b(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.aAp = new d();
                this.aAp.ast.arU = String.format("#(%s)", jSONObject.optString("c"));
                this.aAp.ast.arW = jSONObject.optString("dynamic");
                this.aAp.ast.arV = jSONObject.optString("static");
                this.aAp.mType = this.mType;
                this.aAp.ast.arX = jSONObject.optInt("width", 200);
                this.aAp.ast.arY = jSONObject.optInt("height", 200);
                this.aAp.ast.mPackageName = jSONObject.optString("packet_name", "");
                this.aAp.ast.arZ = jSONObject.optString("icon");
                String[] split = this.aAp.ast.arW.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.aAp.ast.mGid = split[i].split("_")[0];
            } else {
                this.aAH = new b(jSONObject);
                if (this.mType == 4) {
                    int eM = TbFaceManager.BU().eM(this.aAH.getText());
                    String optString = jSONObject.optString("c");
                    if (eM <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.m411getInst().getString(i.h.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.aAH.setText(str);
                    } else {
                        this.aAH.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.aAH.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.aAH != null) {
                this.aAH.EL();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int eJ(int i) {
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
