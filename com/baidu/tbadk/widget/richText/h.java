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
import com.baidu.tieba.t;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.lib.a.b.a.a.i {
    private int mType = 0;
    private b aFG = null;
    private f aFk = null;
    private v aFm = null;
    private d aFo = null;
    private m aFp = null;
    private j aFr = null;
    private k aFq = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, b bVar, f fVar, v vVar, d dVar, j jVar, k kVar) {
        this.mType = i;
        this.aFG = bVar;
        this.aFk = fVar;
        this.aFm = vVar;
        this.aFo = dVar;
        this.aFr = jVar;
        this.aFq = kVar;
    }

    public k He() {
        if (this.mType == 1280) {
            return this.aFq;
        }
        return null;
    }

    public j Hf() {
        if (this.mType == 1024) {
            return this.aFr;
        }
        return null;
    }

    public f GX() {
        if (this.mType == 8) {
            return this.aFk;
        }
        return null;
    }

    public m Hb() {
        if (this.mType != 32) {
            return null;
        }
        return this.aFp;
    }

    public v GZ() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aFm;
        }
        return null;
    }

    public d Hc() {
        if (this.mType == 17) {
            return this.aFo;
        }
        return null;
    }

    public SpannableString Hl() {
        if (this.mType != 1 || this.aFG == null) {
            return null;
        }
        return new SpannableString(this.aFG.getText());
    }

    public CharSequence v(ArrayList<e> arrayList) {
        SpannableString c;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.aFG != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.m411getInst().getString(t.j.video_text));
            CharSequence x = x(arrayList);
            if (x != null) {
                spannableStringBuilder.append(x);
            }
            if (this.aFG.GT() == 1) {
                c = c(this.mType, this.aFG.getText(), this.aFG.GU());
            } else {
                c = c(this.mType, this.aFG.getText(), this.aFG.getText());
            }
            if (c != null) {
                spannableStringBuilder.append((CharSequence) c);
            }
        }
        return spannableStringBuilder;
    }

    public CharSequence w(ArrayList<e> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.aFG != null) {
            CharSequence x = x(arrayList);
            if (x != null) {
                spannableStringBuilder.append(x);
            }
            SpannableString c = c(this.mType, this.aFG.getLink(), this.aFG.getLink());
            if (c != null) {
                spannableStringBuilder.append((CharSequence) c);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence x(ArrayList<e> arrayList) {
        h hVar = new h();
        hVar.a(4, new b("video_icon", " "), null, null, null, null, null);
        return hVar.z(arrayList);
    }

    public String getVideoUrl() {
        if (this.mType != 32 || this.aFG == null) {
            return null;
        }
        if (this.aFG.GT() == 1) {
            return this.aFG.GU();
        }
        return this.aFG.getText();
    }

    public SpannableString Hm() {
        if (this.mType != 2 || this.aFG == null) {
            return null;
        }
        if (this.aFG.GT() == 1) {
            return c(this.mType, this.aFG.getText(), this.aFG.GU());
        }
        return c(this.mType, this.aFG.getText(), this.aFG.getLink());
    }

    public SpannableString Hn() {
        if (this.mType != 256 || this.aFG == null) {
            return null;
        }
        String text = this.aFG.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = String.valueOf(text) + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        g gVar = new g(this.mType, text);
        gVar.gh(this.aFG.getLink());
        spannableString.setSpan(gVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    public SpannableString Ho() {
        if (this.mType != 16 || this.aFG == null) {
            return null;
        }
        return c(this.mType, this.aFG.getText(), this.aFG.getLink());
    }

    private SpannableString y(ArrayList<e> arrayList) {
        String text;
        int fd;
        a.C0052a fD;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.aFG != null && this.aFG.getText() != null && this.aFG.getLink() != null && (fd = TbFaceManager.Ec().fd((text = this.aFG.getText()))) != 0) {
            String str = "#(" + TbFaceManager.Ec().ff(text) + ")";
            spannableString = new SpannableString(String.valueOf(str) + " ");
            e eVar = new e(TbadkCoreApplication.m411getInst().getContext(), fd);
            if (arrayList != null) {
                arrayList.add(eVar);
            }
            if (TbFaceManager.Ec().fD(text) != null) {
                int width = (int) (fD.getWidth() * 0.5d);
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

    public SpannableString Hp() {
        if (this.mType != 1024 || this.aFr == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString("a");
        Drawable fm = i.fm(this.aFr.aFH);
        fm.setBounds(0, 0, fm.getIntrinsicWidth(), fm.getIntrinsicHeight());
        com.baidu.tbadk.widget.f fVar = new com.baidu.tbadk.widget.f(fm);
        fVar.setVerticalOffset(com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m411getInst().getContext(), t.e.ds4));
        spannableString.setSpan(fVar, 0, 1, 33);
        spannableString.setSpan(new g(1024, this.aFr.link), spannableString.length() - 1, "a".length(), 33);
        return spannableString;
    }

    public CharSequence z(ArrayList<e> arrayList) {
        switch (this.mType) {
            case 1:
                return Hl();
            case 2:
                return Hm();
            case 4:
                return y(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return Ho();
            case 32:
                return v(arrayList);
            case 128:
                return w(arrayList);
            case 256:
                return Hn();
            case 1024:
                return Hp();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.aFp.Hz() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = fl(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.aFk = new f(pbContent);
                    break;
                case 16:
                    this.aFG = new b(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.aFo = new d();
                    this.aFo.awQ.awr = String.format("#(%s)", pbContent.c);
                    this.aFo.awQ.awt = pbContent.dynamic;
                    this.aFo.awQ.aws = pbContent._static;
                    this.aFo.mType = this.mType;
                    this.aFo.awQ.awu = pbContent.width.intValue();
                    this.aFo.awQ.awv = pbContent.height.intValue();
                    this.aFo.awQ.mPackageName = pbContent.packet_name;
                    this.aFo.awQ.Vq = pbContent._static;
                    String[] split = this.aFo.awQ.awt.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.aFo.awQ.mGid = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.aFo.awQ.mGid = split[i].split("_")[0];
                case 512:
                    this.aFm = new v(pbContent);
                    break;
                case 1024:
                    this.aFr = new j(pbContent);
                    break;
                case 1280:
                    this.aFq = new k(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.aFp = new m();
                        this.aFp.b(pbContent);
                        break;
                    }
                    this.aFG = new b(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.Ec().fd(this.aFG.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.m411getInst().getString(t.j.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.aFG.setText(str);
                            break;
                        } else {
                            this.aFG.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.aFG.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.aFG != null) {
                this.aFG.GV();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = fl(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.aFk = new f(jSONObject);
            } else if (this.mType == 512) {
                this.aFm = new v(jSONObject);
            } else if (this.mType == 16) {
                this.aFG = new b(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.aFo = new d();
                this.aFo.awQ.awr = String.format("#(%s)", jSONObject.optString("c"));
                this.aFo.awQ.awt = jSONObject.optString("dynamic");
                this.aFo.awQ.aws = jSONObject.optString("static");
                this.aFo.mType = this.mType;
                this.aFo.awQ.awu = jSONObject.optInt("width", 200);
                this.aFo.awQ.awv = jSONObject.optInt("height", 200);
                this.aFo.awQ.mPackageName = jSONObject.optString("packet_name", "");
                this.aFo.awQ.Vq = jSONObject.optString("icon");
                String[] split = this.aFo.awQ.awt.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.aFo.awQ.mGid = split[i].split("_")[0];
            } else {
                this.aFG = new b(jSONObject);
                if (this.mType == 4) {
                    int fd = TbFaceManager.Ec().fd(this.aFG.getText());
                    String optString = jSONObject.optString("c");
                    if (fd <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.m411getInst().getString(t.j.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.aFG.setText(str);
                    } else {
                        this.aFG.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.aFG.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.aFG != null) {
                this.aFG.GV();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int fl(int i) {
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
