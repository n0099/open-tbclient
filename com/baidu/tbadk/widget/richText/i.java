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
    private f aEJ;
    private n aEK;
    private int mType = 0;
    private b aFb = null;
    private g aEB = null;
    private z aED = null;
    private d aEF = null;
    private o aEG = null;
    private k aEI = null;
    private l aEH = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, b bVar, g gVar, z zVar, d dVar, k kVar, l lVar) {
        this.mType = i;
        this.aFb = bVar;
        this.aEB = gVar;
        this.aED = zVar;
        this.aEF = dVar;
        this.aEI = kVar;
        this.aEH = lVar;
    }

    public l GR() {
        if (this.mType == 1280) {
            return this.aEH;
        }
        return null;
    }

    public k GS() {
        if (this.mType == 1024) {
            return this.aEI;
        }
        return null;
    }

    public g GK() {
        if (this.mType == 8) {
            return this.aEB;
        }
        return null;
    }

    public o GO() {
        if (this.mType != 32) {
            return null;
        }
        return this.aEG;
    }

    public z GM() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aED;
        }
        return null;
    }

    public d GP() {
        if (this.mType == 17) {
            return this.aEF;
        }
        return null;
    }

    public f GT() {
        if (this.mType == 1536) {
            return this.aEJ;
        }
        return null;
    }

    public n GU() {
        if (this.mType == 1792) {
            return this.aEK;
        }
        return null;
    }

    public SpannableString Ha() {
        if (this.mType != 1 || this.aFb == null) {
            return null;
        }
        return new SpannableString(this.aFb.getText());
    }

    public CharSequence s(ArrayList<e> arrayList) {
        SpannableString c;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.aFb != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.m9getInst().getString(u.j.video_text));
            CharSequence u = u(arrayList);
            if (u != null) {
                spannableStringBuilder.append(u);
            }
            if (this.aFb.GG() == 1) {
                c = c(this.mType, this.aFb.getText(), this.aFb.GH());
            } else {
                c = c(this.mType, this.aFb.getText(), this.aFb.getText());
            }
            if (c != null) {
                spannableStringBuilder.append((CharSequence) c);
            }
        }
        return spannableStringBuilder;
    }

    public CharSequence t(ArrayList<e> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.aFb != null) {
            CharSequence u = u(arrayList);
            if (u != null) {
                spannableStringBuilder.append(u);
            }
            SpannableString c = c(this.mType, this.aFb.getLink(), this.aFb.getLink());
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
        if (this.mType != 32 || this.aFb == null) {
            return null;
        }
        if (this.aFb.GG() == 1) {
            return this.aFb.GH();
        }
        return this.aFb.getText();
    }

    public SpannableString Hb() {
        if (this.mType != 2 || this.aFb == null) {
            return null;
        }
        if (this.aFb.GG() == 1) {
            return c(this.mType, this.aFb.getText(), this.aFb.GH());
        }
        return c(this.mType, this.aFb.getText(), this.aFb.getLink());
    }

    public SpannableString Hc() {
        if (this.mType != 256 || this.aFb == null) {
            return null;
        }
        String text = this.aFb.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = String.valueOf(text) + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        h hVar = new h(this.mType, text);
        hVar.gB(this.aFb.getLink());
        spannableString.setSpan(hVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    public SpannableString Hd() {
        if (this.mType != 16 || this.aFb == null) {
            return null;
        }
        return c(this.mType, this.aFb.getText(), this.aFb.getLink());
    }

    private SpannableString v(ArrayList<e> arrayList) {
        String text;
        int fo;
        a.C0043a fO;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.aFb != null && this.aFb.getText() != null && this.aFb.getLink() != null && (fo = TbFaceManager.CP().fo((text = this.aFb.getText()))) != 0) {
            String str = "#(" + TbFaceManager.CP().fq(text) + ")";
            spannableString = new SpannableString(String.valueOf(str) + " ");
            e eVar = new e(TbadkCoreApplication.m9getInst().getContext(), fo);
            if (arrayList != null) {
                arrayList.add(eVar);
            }
            if (TbFaceManager.CP().fO(text) != null) {
                int width = (int) (fO.getWidth() * 0.5d);
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

    public SpannableString He() {
        if (this.mType != 1024 || this.aEI == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString("a");
        Drawable fj = j.fj(this.aEI.aFc);
        fj.setBounds(0, 0, fj.getIntrinsicWidth(), fj.getIntrinsicHeight());
        com.baidu.tbadk.widget.f fVar = new com.baidu.tbadk.widget.f(fj);
        fVar.setVerticalOffset(com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m9getInst().getContext(), u.e.ds4));
        spannableString.setSpan(fVar, 0, 1, 33);
        spannableString.setSpan(new h(1024, this.aEI.link), spannableString.length() - 1, "a".length(), 33);
        return spannableString;
    }

    public CharSequence w(ArrayList<e> arrayList) {
        switch (this.mType) {
            case 1:
                return Ha();
            case 2:
                return Hb();
            case 4:
                return v(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return Hd();
            case 32:
                return s(arrayList);
            case 128:
                return t(arrayList);
            case 256:
                return Hc();
            case 1024:
                return He();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.aEG.Ho() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = fi(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.aEB = new g(pbContent);
                    break;
                case 16:
                    this.aFb = new b(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.aEF = new d();
                    this.aEF.auo.atP = String.format("#(%s)", pbContent.c);
                    this.aEF.auo.atR = pbContent.dynamic;
                    this.aEF.auo.atQ = pbContent._static;
                    this.aEF.mType = this.mType;
                    this.aEF.auo.atS = pbContent.width.intValue();
                    this.aEF.auo.atT = pbContent.height.intValue();
                    this.aEF.auo.mPackageName = pbContent.packet_name;
                    this.aEF.auo.mIcon = pbContent._static;
                    String[] split = this.aEF.auo.atR.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.aEF.auo.mGid = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.aEF.auo.mGid = split[i].split("_")[0];
                case 512:
                    this.aED = new z(pbContent);
                    break;
                case 1024:
                    this.aEI = new k(pbContent);
                    break;
                case 1280:
                    this.aEH = new l(pbContent);
                    break;
                case 1536:
                    this.aEJ = new f();
                    this.aEJ.a(pbContent);
                    break;
                case 1792:
                    this.aEK = new n();
                    this.aEK.a(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.aEG = new o();
                        this.aEG.a(pbContent);
                        break;
                    }
                    this.aFb = new b(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.CP().fo(this.aFb.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.m9getInst().getString(u.j.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.aFb.setText(str);
                            break;
                        } else {
                            this.aFb.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.aFb.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.aFb != null) {
                this.aFb.GI();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = fi(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.aEB = new g(jSONObject);
            } else if (this.mType == 512) {
                this.aED = new z(jSONObject);
            } else if (this.mType == 16) {
                this.aFb = new b(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.aEF = new d();
                this.aEF.auo.atP = String.format("#(%s)", jSONObject.optString("c"));
                this.aEF.auo.atR = jSONObject.optString("dynamic");
                this.aEF.auo.atQ = jSONObject.optString("static");
                this.aEF.mType = this.mType;
                this.aEF.auo.atS = jSONObject.optInt(GraffitiVcodeActivityConfig.WIDTH, 200);
                this.aEF.auo.atT = jSONObject.optInt(GraffitiVcodeActivityConfig.HEIGHT, 200);
                this.aEF.auo.mPackageName = jSONObject.optString("packet_name", "");
                this.aEF.auo.mIcon = jSONObject.optString("icon");
                String[] split = this.aEF.auo.atR.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.aEF.auo.mGid = split[i].split("_")[0];
            } else {
                this.aFb = new b(jSONObject);
                if (this.mType == 4) {
                    int fo = TbFaceManager.CP().fo(this.aFb.getText());
                    String optString = jSONObject.optString("c");
                    if (fo <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.m9getInst().getString(u.j.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.aFb.setText(str);
                    } else {
                        this.aFb.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.aFb.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.aFb != null) {
                this.aFb.GI();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int fi(int i) {
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
