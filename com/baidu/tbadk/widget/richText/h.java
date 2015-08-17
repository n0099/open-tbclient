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
    private b aBC = null;
    private f aBk = null;
    private r aBm = null;
    private d aBo = null;
    private j aBp = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, b bVar, f fVar, r rVar, d dVar) {
        this.mType = i;
        this.aBC = bVar;
        this.aBk = fVar;
        this.aBm = rVar;
        this.aBo = dVar;
    }

    public f Fb() {
        if (this.mType == 8) {
            return this.aBk;
        }
        return null;
    }

    public j Ff() {
        if (this.mType != 32) {
            return null;
        }
        return this.aBp;
    }

    public r Fd() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aBm;
        }
        return null;
    }

    public d Fg() {
        if (this.mType == 17) {
            return this.aBo;
        }
        return null;
    }

    public SpannableString Fm() {
        if (this.mType != 1 || this.aBC == null) {
            return null;
        }
        return new SpannableString(this.aBC.getText());
    }

    public CharSequence u(ArrayList<e> arrayList) {
        SpannableString b;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.aBC != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.m411getInst().getString(i.C0057i.video_text));
            CharSequence w = w(arrayList);
            if (w != null) {
                spannableStringBuilder.append(w);
            }
            if (this.aBC.EX() == 1) {
                b = b(this.mType, this.aBC.getText(), this.aBC.EY());
            } else {
                b = b(this.mType, this.aBC.getText(), this.aBC.getText());
            }
            if (b != null) {
                spannableStringBuilder.append((CharSequence) b);
            }
        }
        return spannableStringBuilder;
    }

    public CharSequence v(ArrayList<e> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.aBC != null) {
            CharSequence w = w(arrayList);
            if (w != null) {
                spannableStringBuilder.append(w);
            }
            SpannableString b = b(this.mType, this.aBC.getLink(), this.aBC.getLink());
            if (b != null) {
                spannableStringBuilder.append((CharSequence) b);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence w(ArrayList<e> arrayList) {
        h hVar = new h();
        hVar.a(4, new b("video_icon", " "), null, null, null);
        return hVar.y(arrayList);
    }

    public String getVideoUrl() {
        if (this.mType != 32 || this.aBC == null) {
            return null;
        }
        if (this.aBC.EX() == 1) {
            return this.aBC.EY();
        }
        return this.aBC.getText();
    }

    public SpannableString Fn() {
        if (this.mType != 2 || this.aBC == null) {
            return null;
        }
        if (this.aBC.EX() == 1) {
            return b(this.mType, this.aBC.getText(), this.aBC.EY());
        }
        return b(this.mType, this.aBC.getText(), this.aBC.getLink());
    }

    public SpannableString Fo() {
        if (this.mType != 256 || this.aBC == null) {
            return null;
        }
        String text = this.aBC.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = String.valueOf(text) + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        g gVar = new g(this.mType, text);
        gVar.fE(this.aBC.getLink());
        spannableString.setSpan(gVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    public SpannableString Fp() {
        if (this.mType != 16 || this.aBC == null) {
            return null;
        }
        return b(this.mType, this.aBC.getText(), this.aBC.getLink());
    }

    private SpannableString x(ArrayList<e> arrayList) {
        String text;
        int ez;
        a.C0049a eX;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.aBC != null && this.aBC.getText() != null && this.aBC.getLink() != null && (ez = TbFaceManager.Cd().ez((text = this.aBC.getText()))) != 0) {
            String str = "#(" + TbFaceManager.Cd().eB(text) + ")";
            spannableString = new SpannableString(String.valueOf(str) + " ");
            e eVar = new e(TbadkCoreApplication.m411getInst().getContext(), ez);
            if (arrayList != null) {
                arrayList.add(eVar);
            }
            if (TbFaceManager.Cd().eX(text) != null) {
                int width = (int) (eX.getWidth() * 0.5d);
                eVar.setBounds(new Rect(0, 0, width, width));
            } else {
                eVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(eVar, 0), 0, str.length(), 33);
        }
        return spannableString;
    }

    private SpannableString b(int i, String str, String str2) {
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

    public CharSequence y(ArrayList<e> arrayList) {
        switch (this.mType) {
            case 1:
                return Fm();
            case 2:
                return Fn();
            case 4:
                return x(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return Fp();
            case 32:
                return u(arrayList);
            case 128:
                return v(arrayList);
            case 256:
                return Fo();
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
            this.mType = ez(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.aBk = new f(pbContent);
                    break;
                case 16:
                    this.aBC = new b(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.aBo = new d();
                    this.aBo.atx.asY = String.format("#(%s)", pbContent.c);
                    this.aBo.atx.ata = pbContent.dynamic;
                    this.aBo.atx.asZ = pbContent._static;
                    this.aBo.mType = this.mType;
                    this.aBo.atx.atb = pbContent.width.intValue();
                    this.aBo.atx.atc = pbContent.height.intValue();
                    this.aBo.atx.mPackageName = pbContent.packet_name;
                    this.aBo.atx.atd = pbContent._static;
                    String[] split = this.aBo.atx.ata.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.aBo.atx.mGid = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.aBo.atx.mGid = split[i].split("_")[0];
                case 32:
                    this.aBp = new j();
                    this.aBp.b(pbContent);
                    if (this.aBp.Fq()) {
                        break;
                    }
                    this.aBC = new b(pbContent);
                    if (this.mType != 4) {
                        if (TbFaceManager.Cd().ez(this.aBC.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.m411getInst().getString(i.C0057i.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.aBC.setText(str);
                            break;
                        } else {
                            this.aBC.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.aBC.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
                case 512:
                    this.aBm = new r(pbContent);
                    break;
                default:
                    this.aBC = new b(pbContent);
                    if (this.mType != 4) {
                    }
                    break;
            }
            if (this.mType != 1 && this.aBC != null) {
                this.aBC.EZ();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = ez(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.aBk = new f(jSONObject);
            } else if (this.mType == 512) {
                this.aBm = new r(jSONObject);
            } else if (this.mType == 16) {
                this.aBC = new b(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.aBo = new d();
                this.aBo.atx.asY = String.format("#(%s)", jSONObject.optString("c"));
                this.aBo.atx.ata = jSONObject.optString("dynamic");
                this.aBo.atx.asZ = jSONObject.optString("static");
                this.aBo.mType = this.mType;
                this.aBo.atx.atb = jSONObject.optInt("width", 200);
                this.aBo.atx.atc = jSONObject.optInt("height", 200);
                this.aBo.atx.mPackageName = jSONObject.optString("packet_name", "");
                this.aBo.atx.atd = jSONObject.optString("icon");
                String[] split = this.aBo.atx.ata.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.aBo.atx.mGid = split[i].split("_")[0];
            } else {
                this.aBC = new b(jSONObject);
                if (this.mType == 4) {
                    int ez = TbFaceManager.Cd().ez(this.aBC.getText());
                    String optString = jSONObject.optString("c");
                    if (ez <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.m411getInst().getString(i.C0057i.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.aBC.setText(str);
                    } else {
                        this.aBC.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.aBC.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.aBC != null) {
                this.aBC.EZ();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int ez(int i) {
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
