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
import com.baidu.tieba.r;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.lib.a.b.a.a.i {
    private f aIj;
    private n aIk;
    private int mType = 0;
    private b aID = null;
    private g aIb = null;
    private z aId = null;
    private d aIf = null;
    private o aIg = null;
    private k aIi = null;
    private l aIh = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, b bVar, g gVar, z zVar, d dVar, k kVar, l lVar) {
        this.mType = i;
        this.aID = bVar;
        this.aIb = gVar;
        this.aId = zVar;
        this.aIf = dVar;
        this.aIi = kVar;
        this.aIh = lVar;
    }

    public l Il() {
        if (this.mType == 1280) {
            return this.aIh;
        }
        return null;
    }

    public k Im() {
        if (this.mType == 1024) {
            return this.aIi;
        }
        return null;
    }

    public g Ie() {
        if (this.mType == 8) {
            return this.aIb;
        }
        return null;
    }

    public o Ii() {
        if (this.mType != 32) {
            return null;
        }
        return this.aIg;
    }

    public z Ig() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aId;
        }
        return null;
    }

    public d Ij() {
        if (this.mType == 17) {
            return this.aIf;
        }
        return null;
    }

    public f In() {
        if (this.mType == 1536) {
            return this.aIj;
        }
        return null;
    }

    public n Io() {
        if (this.mType == 1792) {
            return this.aIk;
        }
        return null;
    }

    private SpannableString Iw() {
        if (this.mType != 1 || this.aID == null) {
            return null;
        }
        return new SpannableString(this.aID.getText());
    }

    private CharSequence t(ArrayList<e> arrayList) {
        SpannableString c;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.aID != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.m9getInst().getString(r.j.video_text));
            CharSequence v = v(arrayList);
            if (v != null) {
                spannableStringBuilder.append(v);
            }
            if (this.aID.Ia() == 1) {
                c = c(this.mType, this.aID.getText(), this.aID.Ib());
            } else {
                c = c(this.mType, this.aID.getText(), this.aID.getText());
            }
            if (c != null) {
                spannableStringBuilder.append((CharSequence) c);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence u(ArrayList<e> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.aID != null) {
            CharSequence v = v(arrayList);
            if (v != null) {
                spannableStringBuilder.append(v);
            }
            SpannableString c = c(this.mType, this.aID.getLink(), this.aID.getLink());
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
        if (this.mType != 32 || this.aID == null) {
            return null;
        }
        if (this.aID.Ia() == 1) {
            return this.aID.Ib();
        }
        return this.aID.getText();
    }

    private SpannableString Ix() {
        if ((this.mType != 2 && this.mType != 18) || this.aID == null) {
            return null;
        }
        if (this.aID.Ia() == 1) {
            return c(this.mType, this.aID.getText(), this.aID.Ib());
        }
        return c(this.mType, this.aID.getText(), this.aID.getLink());
    }

    private SpannableString Iy() {
        if (this.mType != 256 || this.aID == null) {
            return null;
        }
        String text = this.aID.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = String.valueOf(text) + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        h hVar = new h(this.mType, text);
        hVar.gH(this.aID.getLink());
        spannableString.setSpan(hVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString Iz() {
        if (this.mType != 16 || this.aID == null) {
            return null;
        }
        return c(this.mType, this.aID.getText(), this.aID.getLink());
    }

    private SpannableString w(ArrayList<e> arrayList) {
        String text;
        int fr;
        a.C0044a fT;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.aID != null && this.aID.getText() != null && this.aID.getLink() != null && (fr = TbFaceManager.Ej().fr((text = this.aID.getText()))) != 0) {
            String str = "#(" + TbFaceManager.Ej().ft(text) + ")";
            spannableString = new SpannableString(String.valueOf(str) + " ");
            e eVar = new e(TbadkCoreApplication.m9getInst().getContext(), fr);
            if (arrayList != null) {
                arrayList.add(eVar);
            }
            if (TbFaceManager.Ej().fT(text) != null) {
                int width = (int) (fT.getWidth() * 0.5d);
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

    private SpannableString IA() {
        if (this.mType != 1024 || this.aIi == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString("a");
        Drawable fx = j.fx(this.aIi.aIE);
        fx.setBounds(0, 0, fx.getIntrinsicWidth(), fx.getIntrinsicHeight());
        com.baidu.tbadk.widget.f fVar = new com.baidu.tbadk.widget.f(fx);
        fVar.setVerticalOffset(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getContext(), r.e.ds4));
        spannableString.setSpan(fVar, 0, 1, 33);
        spannableString.setSpan(new h(1024, this.aIi.link), spannableString.length() - 1, "a".length(), 33);
        return spannableString;
    }

    public CharSequence x(ArrayList<e> arrayList) {
        switch (this.mType) {
            case 1:
                return Iw();
            case 2:
                return Ix();
            case 4:
                return w(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return Iz();
            case 18:
                return Ix();
            case 32:
                return t(arrayList);
            case 128:
                return u(arrayList);
            case 256:
                return Iy();
            case 1024:
                return IA();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.aIg.IK() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = fw(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.aIb = new g(pbContent);
                    break;
                case 16:
                    this.aID = new b(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.aIf = new d();
                    this.aIf.axN.axo = String.format("#(%s)", pbContent.c);
                    this.aIf.axN.axq = pbContent.dynamic;
                    this.aIf.axN.axp = pbContent._static;
                    this.aIf.mType = this.mType;
                    this.aIf.axN.axr = pbContent.width.intValue();
                    this.aIf.axN.axs = pbContent.height.intValue();
                    this.aIf.axN.mPackageName = pbContent.packet_name;
                    this.aIf.axN.mIcon = pbContent._static;
                    String[] split = this.aIf.axN.axq.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.aIf.axN.mGid = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.aIf.axN.mGid = split[i].split("_")[0];
                case 512:
                    this.aId = new z(pbContent);
                    break;
                case 1024:
                    this.aIi = new k(pbContent);
                    break;
                case 1280:
                    this.aIh = new l(pbContent);
                    break;
                case 1536:
                    this.aIj = new f();
                    this.aIj.a(pbContent);
                    break;
                case 1792:
                    this.aIk = new n();
                    this.aIk.a(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.aIg = new o();
                        this.aIg.a(pbContent);
                        break;
                    }
                    this.aID = new b(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.Ej().fr(this.aID.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.m9getInst().getString(r.j.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.aID.setText(str);
                            break;
                        } else {
                            this.aID.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.aID.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.aID != null) {
                this.aID.Ic();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = fw(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.aIb = new g(jSONObject);
            } else if (this.mType == 512) {
                this.aId = new z(jSONObject);
            } else if (this.mType == 16) {
                this.aID = new b(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.aIf = new d();
                this.aIf.axN.axo = String.format("#(%s)", jSONObject.optString("c"));
                this.aIf.axN.axq = jSONObject.optString("dynamic");
                this.aIf.axN.axp = jSONObject.optString("static");
                this.aIf.mType = this.mType;
                this.aIf.axN.axr = jSONObject.optInt("width", 200);
                this.aIf.axN.axs = jSONObject.optInt("height", 200);
                this.aIf.axN.mPackageName = jSONObject.optString("packet_name", "");
                this.aIf.axN.mIcon = jSONObject.optString("icon");
                String[] split = this.aIf.axN.axq.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.aIf.axN.mGid = split[i].split("_")[0];
            } else {
                this.aID = new b(jSONObject);
                if (this.mType == 4) {
                    int fr = TbFaceManager.Ej().fr(this.aID.getText());
                    String optString = jSONObject.optString("c");
                    if (fr <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.m9getInst().getString(r.j.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.aID.setText(str);
                    } else {
                        this.aID.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.aID.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.aID != null) {
                this.aID.Ic();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int fw(int i) {
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
