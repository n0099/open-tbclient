package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
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
    private b aDk = null;
    private f aCS = null;
    private r aCU = null;
    private d aCW = null;
    private j aCX = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, b bVar, f fVar, r rVar, d dVar) {
        this.mType = i;
        this.aDk = bVar;
        this.aCS = fVar;
        this.aCU = rVar;
        this.aCW = dVar;
    }

    public f Fl() {
        if (this.mType == 8) {
            return this.aCS;
        }
        return null;
    }

    public j Fp() {
        if (this.mType != 32) {
            return null;
        }
        return this.aCX;
    }

    public r Fn() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aCU;
        }
        return null;
    }

    public d Fq() {
        if (this.mType == 17) {
            return this.aCW;
        }
        return null;
    }

    public SpannableString Fw() {
        if (this.mType != 1 || this.aDk == null) {
            return null;
        }
        return new SpannableString(this.aDk.getText());
    }

    public CharSequence t(ArrayList<e> arrayList) {
        SpannableString c;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.aDk != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.m411getInst().getString(i.h.video_text));
            CharSequence v = v(arrayList);
            if (v != null) {
                spannableStringBuilder.append(v);
            }
            if (this.aDk.Fh() == 1) {
                c = c(this.mType, this.aDk.getText(), this.aDk.Fi());
            } else {
                c = c(this.mType, this.aDk.getText(), this.aDk.getText());
            }
            if (c != null) {
                spannableStringBuilder.append((CharSequence) c);
            }
        }
        return spannableStringBuilder;
    }

    public CharSequence u(ArrayList<e> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.aDk != null) {
            CharSequence v = v(arrayList);
            if (v != null) {
                spannableStringBuilder.append(v);
            }
            SpannableString c = c(this.mType, this.aDk.getLink(), this.aDk.getLink());
            if (c != null) {
                spannableStringBuilder.append((CharSequence) c);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence v(ArrayList<e> arrayList) {
        h hVar = new h();
        hVar.a(4, new b("video_icon", " "), null, null, null);
        return hVar.x(arrayList);
    }

    public String getVideoUrl() {
        if (this.mType != 32 || this.aDk == null) {
            return null;
        }
        if (this.aDk.Fh() == 1) {
            return this.aDk.Fi();
        }
        return this.aDk.getText();
    }

    public SpannableString Fx() {
        if (this.mType != 2 || this.aDk == null) {
            return null;
        }
        if (this.aDk.Fh() == 1) {
            return c(this.mType, this.aDk.getText(), this.aDk.Fi());
        }
        return c(this.mType, this.aDk.getText(), this.aDk.getLink());
    }

    public SpannableString Fy() {
        if (this.mType != 256 || this.aDk == null) {
            return null;
        }
        String text = this.aDk.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = String.valueOf(text) + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        g gVar = new g(this.mType, text);
        gVar.fM(this.aDk.getLink());
        spannableString.setSpan(gVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    public SpannableString Fz() {
        if (this.mType != 16 || this.aDk == null) {
            return null;
        }
        return c(this.mType, this.aDk.getText(), this.aDk.getLink());
    }

    private SpannableString w(ArrayList<e> arrayList) {
        String text;
        int eH;
        a.C0049a ff;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.aDk != null && this.aDk.getText() != null && this.aDk.getLink() != null && (eH = TbFaceManager.Cr().eH((text = this.aDk.getText()))) != 0) {
            String str = "#(" + TbFaceManager.Cr().eJ(text) + ")";
            spannableString = new SpannableString(String.valueOf(str) + " ");
            e eVar = new e(TbadkCoreApplication.m411getInst().getContext(), eH);
            if (arrayList != null) {
                arrayList.add(eVar);
            }
            if (TbFaceManager.Cr().ff(text) != null) {
                int width = (int) (ff.getWidth() * 0.5d);
                eVar.setBounds(new Rect(0, 0, width, width));
            } else {
                eVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(eVar, 0), 0, str.length(), 33);
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

    public CharSequence x(ArrayList<e> arrayList) {
        switch (this.mType) {
            case 1:
                return Fw();
            case 2:
                return Fx();
            case 4:
                return w(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return Fz();
            case 32:
                return t(arrayList);
            case 128:
                return u(arrayList);
            case 256:
                return Fy();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:36:0x016b A[Catch: Exception -> 0x0076, TryCatch #0 {Exception -> 0x0076, blocks: (B:3:0x0002, B:4:0x0010, B:5:0x0013, B:7:0x001f, B:9:0x002f, B:11:0x003c, B:12:0x005b, B:13:0x0060, B:15:0x0064, B:17:0x0068, B:34:0x0134, B:35:0x014d, B:36:0x016b, B:38:0x0171, B:19:0x006e, B:23:0x007b, B:24:0x0083, B:25:0x0093, B:27:0x00fc, B:28:0x010f, B:30:0x011b, B:31:0x011e), top: B:40:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001f A[Catch: Exception -> 0x0076, TryCatch #0 {Exception -> 0x0076, blocks: (B:3:0x0002, B:4:0x0010, B:5:0x0013, B:7:0x001f, B:9:0x002f, B:11:0x003c, B:12:0x005b, B:13:0x0060, B:15:0x0064, B:17:0x0068, B:34:0x0134, B:35:0x014d, B:36:0x016b, B:38:0x0171, B:19:0x006e, B:23:0x007b, B:24:0x0083, B:25:0x0093, B:27:0x00fc, B:28:0x010f, B:30:0x011b, B:31:0x011e), top: B:40:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = eH(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.aCS = new f(pbContent);
                    break;
                case 16:
                    this.aDk = new b(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.aCW = new d();
                    this.aCW.avh.auI = String.format("#(%s)", pbContent.c);
                    this.aCW.avh.auK = pbContent.dynamic;
                    this.aCW.avh.auJ = pbContent._static;
                    this.aCW.mType = this.mType;
                    this.aCW.avh.auL = pbContent.width.intValue();
                    this.aCW.avh.auM = pbContent.height.intValue();
                    this.aCW.avh.mPackageName = pbContent.packet_name;
                    this.aCW.avh.auN = pbContent._static;
                    String[] split = this.aCW.avh.auK.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.aCW.avh.mGid = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.aCW.avh.mGid = split[i].split("_")[0];
                case 32:
                    this.aCX = new j();
                    this.aCX.b(pbContent);
                    if (this.aCX.FA()) {
                        break;
                    }
                    this.aDk = new b(pbContent);
                    if (this.mType != 4) {
                        if (TbFaceManager.Cr().eH(this.aDk.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.m411getInst().getString(i.h.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.aDk.setText(str);
                            break;
                        } else {
                            this.aDk.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.aDk.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
                case 512:
                    this.aCU = new r(pbContent);
                    break;
                default:
                    this.aDk = new b(pbContent);
                    if (this.mType != 4) {
                    }
                    break;
            }
            if (this.mType != 1 && this.aDk != null) {
                this.aDk.Fj();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = eH(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.aCS = new f(jSONObject);
            } else if (this.mType == 512) {
                this.aCU = new r(jSONObject);
            } else if (this.mType == 16) {
                this.aDk = new b(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.aCW = new d();
                this.aCW.avh.auI = String.format("#(%s)", jSONObject.optString("c"));
                this.aCW.avh.auK = jSONObject.optString("dynamic");
                this.aCW.avh.auJ = jSONObject.optString("static");
                this.aCW.mType = this.mType;
                this.aCW.avh.auL = jSONObject.optInt("width", 200);
                this.aCW.avh.auM = jSONObject.optInt("height", 200);
                this.aCW.avh.mPackageName = jSONObject.optString("packet_name", "");
                this.aCW.avh.auN = jSONObject.optString("icon");
                String[] split = this.aCW.avh.auK.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.aCW.avh.mGid = split[i].split("_")[0];
            } else {
                this.aDk = new b(jSONObject);
                if (this.mType == 4) {
                    int eH = TbFaceManager.Cr().eH(this.aDk.getText());
                    String optString = jSONObject.optString("c");
                    if (eH <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.m411getInst().getString(i.h.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.aDk.setText(str);
                    } else {
                        this.aDk.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.aDk.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.aDk != null) {
                this.aDk.Fj();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int eH(int i) {
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
        }
    }
}
