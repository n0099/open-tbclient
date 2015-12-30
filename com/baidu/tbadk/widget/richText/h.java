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
    private b aEQ = null;
    private f aEu = null;
    private v aEw = null;
    private d aEy = null;
    private m aEz = null;
    private j aEB = null;
    private k aEA = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, b bVar, f fVar, v vVar, d dVar, j jVar, k kVar) {
        this.mType = i;
        this.aEQ = bVar;
        this.aEu = fVar;
        this.aEw = vVar;
        this.aEy = dVar;
        this.aEB = jVar;
        this.aEA = kVar;
    }

    public k FM() {
        if (this.mType == 1280) {
            return this.aEA;
        }
        return null;
    }

    public j FN() {
        if (this.mType == 1024) {
            return this.aEB;
        }
        return null;
    }

    public f FF() {
        if (this.mType == 8) {
            return this.aEu;
        }
        return null;
    }

    public m FJ() {
        if (this.mType != 32) {
            return null;
        }
        return this.aEz;
    }

    public v FH() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aEw;
        }
        return null;
    }

    public d FK() {
        if (this.mType == 17) {
            return this.aEy;
        }
        return null;
    }

    public SpannableString FT() {
        if (this.mType != 1 || this.aEQ == null) {
            return null;
        }
        return new SpannableString(this.aEQ.getText());
    }

    public CharSequence u(ArrayList<e> arrayList) {
        SpannableString c;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.aEQ != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.m411getInst().getString(n.j.video_text));
            CharSequence w = w(arrayList);
            if (w != null) {
                spannableStringBuilder.append(w);
            }
            if (this.aEQ.FB() == 1) {
                c = c(this.mType, this.aEQ.getText(), this.aEQ.FC());
            } else {
                c = c(this.mType, this.aEQ.getText(), this.aEQ.getText());
            }
            if (c != null) {
                spannableStringBuilder.append((CharSequence) c);
            }
        }
        return spannableStringBuilder;
    }

    public CharSequence v(ArrayList<e> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.aEQ != null) {
            CharSequence w = w(arrayList);
            if (w != null) {
                spannableStringBuilder.append(w);
            }
            SpannableString c = c(this.mType, this.aEQ.getLink(), this.aEQ.getLink());
            if (c != null) {
                spannableStringBuilder.append((CharSequence) c);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence w(ArrayList<e> arrayList) {
        h hVar = new h();
        hVar.a(4, new b("video_icon", " "), null, null, null, null, null);
        return hVar.y(arrayList);
    }

    public String getVideoUrl() {
        if (this.mType != 32 || this.aEQ == null) {
            return null;
        }
        if (this.aEQ.FB() == 1) {
            return this.aEQ.FC();
        }
        return this.aEQ.getText();
    }

    public SpannableString FU() {
        if (this.mType != 2 || this.aEQ == null) {
            return null;
        }
        if (this.aEQ.FB() == 1) {
            return c(this.mType, this.aEQ.getText(), this.aEQ.FC());
        }
        return c(this.mType, this.aEQ.getText(), this.aEQ.getLink());
    }

    public SpannableString FV() {
        if (this.mType != 256 || this.aEQ == null) {
            return null;
        }
        String text = this.aEQ.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = String.valueOf(text) + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        g gVar = new g(this.mType, text);
        gVar.gk(this.aEQ.getLink());
        spannableString.setSpan(gVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    public SpannableString FW() {
        if (this.mType != 16 || this.aEQ == null) {
            return null;
        }
        return c(this.mType, this.aEQ.getText(), this.aEQ.getLink());
    }

    private SpannableString x(ArrayList<e> arrayList) {
        String text;
        int fe;
        a.C0051a fF;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.aEQ != null && this.aEQ.getText() != null && this.aEQ.getLink() != null && (fe = TbFaceManager.CL().fe((text = this.aEQ.getText()))) != 0) {
            String str = "#(" + TbFaceManager.CL().fg(text) + ")";
            spannableString = new SpannableString(String.valueOf(str) + " ");
            e eVar = new e(TbadkCoreApplication.m411getInst().getContext(), fe);
            if (arrayList != null) {
                arrayList.add(eVar);
            }
            if (TbFaceManager.CL().fF(text) != null) {
                int width = (int) (fF.getWidth() * 0.5d);
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

    public SpannableString FX() {
        if (this.mType != 1024 || this.aEB == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString("a");
        Drawable eR = i.eR(this.aEB.aER);
        eR.setBounds(0, 0, eR.getIntrinsicWidth(), eR.getIntrinsicHeight());
        com.baidu.tbadk.widget.f fVar = new com.baidu.tbadk.widget.f(eR);
        fVar.setVerticalOffset(com.baidu.adp.lib.util.k.d(TbadkCoreApplication.m411getInst().getContext(), n.e.ds4));
        spannableString.setSpan(fVar, 0, 1, 33);
        spannableString.setSpan(new g(1024, this.aEB.link), spannableString.length() - 1, "a".length(), 33);
        return spannableString;
    }

    public CharSequence y(ArrayList<e> arrayList) {
        switch (this.mType) {
            case 1:
                return FT();
            case 2:
                return FU();
            case 4:
                return x(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return FW();
            case 32:
                return u(arrayList);
            case 128:
                return v(arrayList);
            case 256:
                return FV();
            case 1024:
                return FX();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.aEz.Gb() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = eQ(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.aEu = new f(pbContent);
                    break;
                case 16:
                    this.aEQ = new b(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.aEy = new d();
                    this.aEy.avZ.avz = String.format("#(%s)", pbContent.c);
                    this.aEy.avZ.avB = pbContent.dynamic;
                    this.aEy.avZ.avA = pbContent._static;
                    this.aEy.mType = this.mType;
                    this.aEy.avZ.avC = pbContent.width.intValue();
                    this.aEy.avZ.avD = pbContent.height.intValue();
                    this.aEy.avZ.mPackageName = pbContent.packet_name;
                    this.aEy.avZ.avE = pbContent._static;
                    String[] split = this.aEy.avZ.avB.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.aEy.avZ.mGid = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.aEy.avZ.mGid = split[i].split("_")[0];
                case 512:
                    this.aEw = new v(pbContent);
                    break;
                case 1024:
                    this.aEB = new j(pbContent);
                    break;
                case 1280:
                    this.aEA = new k(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.aEz = new m();
                        this.aEz.b(pbContent);
                        break;
                    }
                    this.aEQ = new b(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.CL().fe(this.aEQ.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.m411getInst().getString(n.j.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.aEQ.setText(str);
                            break;
                        } else {
                            this.aEQ.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.aEQ.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.aEQ != null) {
                this.aEQ.FD();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = eQ(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.aEu = new f(jSONObject);
            } else if (this.mType == 512) {
                this.aEw = new v(jSONObject);
            } else if (this.mType == 16) {
                this.aEQ = new b(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.aEy = new d();
                this.aEy.avZ.avz = String.format("#(%s)", jSONObject.optString("c"));
                this.aEy.avZ.avB = jSONObject.optString("dynamic");
                this.aEy.avZ.avA = jSONObject.optString("static");
                this.aEy.mType = this.mType;
                this.aEy.avZ.avC = jSONObject.optInt("width", 200);
                this.aEy.avZ.avD = jSONObject.optInt("height", 200);
                this.aEy.avZ.mPackageName = jSONObject.optString("packet_name", "");
                this.aEy.avZ.avE = jSONObject.optString("icon");
                String[] split = this.aEy.avZ.avB.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.aEy.avZ.mGid = split[i].split("_")[0];
            } else {
                this.aEQ = new b(jSONObject);
                if (this.mType == 4) {
                    int fe = TbFaceManager.CL().fe(this.aEQ.getText());
                    String optString = jSONObject.optString("c");
                    if (fe <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.m411getInst().getString(n.j.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.aEQ.setText(str);
                    } else {
                        this.aEQ.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.aEQ.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.aEQ != null) {
                this.aEQ.FD();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int eQ(int i) {
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
