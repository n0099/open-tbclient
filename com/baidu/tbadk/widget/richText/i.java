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
    private f aIZ;
    private n aJa;
    private int mType = 0;
    private b aJt = null;
    private g aIR = null;
    private z aIT = null;
    private d aIV = null;
    private o aIW = null;
    private k aIY = null;
    private l aIX = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, b bVar, g gVar, z zVar, d dVar, k kVar, l lVar) {
        this.mType = i;
        this.aJt = bVar;
        this.aIR = gVar;
        this.aIT = zVar;
        this.aIV = dVar;
        this.aIY = kVar;
        this.aIX = lVar;
    }

    public l Io() {
        if (this.mType == 1280) {
            return this.aIX;
        }
        return null;
    }

    public k Ip() {
        if (this.mType == 1024) {
            return this.aIY;
        }
        return null;
    }

    public g Ih() {
        if (this.mType == 8) {
            return this.aIR;
        }
        return null;
    }

    public o Il() {
        if (this.mType != 32) {
            return null;
        }
        return this.aIW;
    }

    public z Ij() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aIT;
        }
        return null;
    }

    public d Im() {
        if (this.mType == 17) {
            return this.aIV;
        }
        return null;
    }

    public f Iq() {
        if (this.mType == 1536) {
            return this.aIZ;
        }
        return null;
    }

    public n Ir() {
        if (this.mType == 1792) {
            return this.aJa;
        }
        return null;
    }

    private SpannableString Iz() {
        if (this.mType != 1 || this.aJt == null) {
            return null;
        }
        return new SpannableString(this.aJt.getText());
    }

    private CharSequence u(ArrayList<e> arrayList) {
        SpannableString c;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.aJt != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.m9getInst().getString(r.j.video_text));
            CharSequence w = w(arrayList);
            if (w != null) {
                spannableStringBuilder.append(w);
            }
            if (this.aJt.Id() == 1) {
                c = c(this.mType, this.aJt.getText(), this.aJt.Ie());
            } else {
                c = c(this.mType, this.aJt.getText(), this.aJt.getText());
            }
            if (c != null) {
                spannableStringBuilder.append((CharSequence) c);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence v(ArrayList<e> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.aJt != null) {
            CharSequence w = w(arrayList);
            if (w != null) {
                spannableStringBuilder.append(w);
            }
            SpannableString c = c(this.mType, this.aJt.getLink(), this.aJt.getLink());
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
        if (this.mType != 32 || this.aJt == null) {
            return null;
        }
        if (this.aJt.Id() == 1) {
            return this.aJt.Ie();
        }
        return this.aJt.getText();
    }

    private SpannableString IA() {
        if ((this.mType != 2 && this.mType != 18) || this.aJt == null) {
            return null;
        }
        if (this.aJt.Id() == 1) {
            return c(this.mType, this.aJt.getText(), this.aJt.Ie());
        }
        return c(this.mType, this.aJt.getText(), this.aJt.getLink());
    }

    private SpannableString IB() {
        if (this.mType != 256 || this.aJt == null) {
            return null;
        }
        String text = this.aJt.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = String.valueOf(text) + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        h hVar = new h(this.mType, text);
        hVar.gH(this.aJt.getLink());
        spannableString.setSpan(hVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString IC() {
        if (this.mType != 16 || this.aJt == null) {
            return null;
        }
        return c(this.mType, this.aJt.getText(), this.aJt.getLink());
    }

    private SpannableString x(ArrayList<e> arrayList) {
        String text;
        int fu;
        a.C0044a fW;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.aJt != null && this.aJt.getText() != null && this.aJt.getLink() != null && (fu = TbFaceManager.Eo().fu((text = this.aJt.getText()))) != 0) {
            String str = "#(" + TbFaceManager.Eo().fw(text) + ")";
            spannableString = new SpannableString(String.valueOf(str) + " ");
            e eVar = new e(TbadkCoreApplication.m9getInst().getContext(), fu);
            if (arrayList != null) {
                arrayList.add(eVar);
            }
            if (TbFaceManager.Eo().fW(text) != null) {
                int width = (int) (fW.getWidth() * 0.5d);
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

    private SpannableString ID() {
        if (this.mType != 1024 || this.aIY == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString("a");
        Drawable fA = j.fA(this.aIY.aJu);
        fA.setBounds(0, 0, fA.getIntrinsicWidth(), fA.getIntrinsicHeight());
        com.baidu.tbadk.widget.f fVar = new com.baidu.tbadk.widget.f(fA);
        fVar.setVerticalOffset(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getContext(), r.e.ds4));
        spannableString.setSpan(fVar, 0, 1, 33);
        spannableString.setSpan(new h(1024, this.aIY.link), spannableString.length() - 1, "a".length(), 33);
        return spannableString;
    }

    public CharSequence y(ArrayList<e> arrayList) {
        switch (this.mType) {
            case 1:
                return Iz();
            case 2:
                return IA();
            case 4:
                return x(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return IC();
            case 18:
                return IA();
            case 32:
                return u(arrayList);
            case 128:
                return v(arrayList);
            case 256:
                return IB();
            case 1024:
                return ID();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.aIW.IN() != false) goto L9;
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
                    this.aIR = new g(pbContent);
                    break;
                case 16:
                    this.aJt = new b(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.aIV = new d();
                    this.aIV.ayE.ayf = String.format("#(%s)", pbContent.c);
                    this.aIV.ayE.ayh = pbContent.dynamic;
                    this.aIV.ayE.ayg = pbContent._static;
                    this.aIV.mType = this.mType;
                    this.aIV.ayE.ayi = pbContent.width.intValue();
                    this.aIV.ayE.ayj = pbContent.height.intValue();
                    this.aIV.ayE.mPackageName = pbContent.packet_name;
                    this.aIV.ayE.mIcon = pbContent._static;
                    String[] split = this.aIV.ayE.ayh.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.aIV.ayE.mGid = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.aIV.ayE.mGid = split[i].split("_")[0];
                case 512:
                    this.aIT = new z(pbContent);
                    break;
                case 1024:
                    this.aIY = new k(pbContent);
                    break;
                case 1280:
                    this.aIX = new l(pbContent);
                    break;
                case 1536:
                    this.aIZ = new f();
                    this.aIZ.a(pbContent);
                    break;
                case 1792:
                    this.aJa = new n();
                    this.aJa.a(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.aIW = new o();
                        this.aIW.a(pbContent);
                        break;
                    }
                    this.aJt = new b(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.Eo().fu(this.aJt.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.m9getInst().getString(r.j.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.aJt.setText(str);
                            break;
                        } else {
                            this.aJt.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.aJt.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.aJt != null) {
                this.aJt.If();
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
                this.aIR = new g(jSONObject);
            } else if (this.mType == 512) {
                this.aIT = new z(jSONObject);
            } else if (this.mType == 16) {
                this.aJt = new b(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.aIV = new d();
                this.aIV.ayE.ayf = String.format("#(%s)", jSONObject.optString("c"));
                this.aIV.ayE.ayh = jSONObject.optString("dynamic");
                this.aIV.ayE.ayg = jSONObject.optString("static");
                this.aIV.mType = this.mType;
                this.aIV.ayE.ayi = jSONObject.optInt("width", 200);
                this.aIV.ayE.ayj = jSONObject.optInt("height", 200);
                this.aIV.ayE.mPackageName = jSONObject.optString("packet_name", "");
                this.aIV.ayE.mIcon = jSONObject.optString("icon");
                String[] split = this.aIV.ayE.ayh.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.aIV.ayE.mGid = split[i].split("_")[0];
            } else {
                this.aJt = new b(jSONObject);
                if (this.mType == 4) {
                    int fu = TbFaceManager.Eo().fu(this.aJt.getText());
                    String optString = jSONObject.optString("c");
                    if (fu <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.m9getInst().getString(r.j.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.aJt.setText(str);
                    } else {
                        this.aJt.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.aJt.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.aJt != null) {
                this.aJt.If();
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
