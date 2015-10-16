package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
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
    private b aBQ = null;
    private f aBw = null;
    private r aBy = null;
    private d aBA = null;
    private j aBB = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, b bVar, f fVar, r rVar, d dVar) {
        this.mType = i;
        this.aBQ = bVar;
        this.aBw = fVar;
        this.aBy = rVar;
        this.aBA = dVar;
    }

    public f EY() {
        if (this.mType == 8) {
            return this.aBw;
        }
        return null;
    }

    public j Fc() {
        if (this.mType != 32) {
            return null;
        }
        return this.aBB;
    }

    public r Fa() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aBy;
        }
        return null;
    }

    public d Fd() {
        if (this.mType == 17) {
            return this.aBA;
        }
        return null;
    }

    public SpannableString Fk() {
        if (this.mType != 1 || this.aBQ == null) {
            return null;
        }
        return new SpannableString(this.aBQ.getText());
    }

    public CharSequence t(ArrayList<e> arrayList) {
        SpannableString c;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.aBQ != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.m411getInst().getString(i.h.video_text));
            CharSequence v = v(arrayList);
            if (v != null) {
                spannableStringBuilder.append(v);
            }
            if (this.aBQ.EU() == 1) {
                c = c(this.mType, this.aBQ.getText(), this.aBQ.EV());
            } else {
                c = c(this.mType, this.aBQ.getText(), this.aBQ.getText());
            }
            if (c != null) {
                spannableStringBuilder.append((CharSequence) c);
            }
        }
        return spannableStringBuilder;
    }

    public CharSequence u(ArrayList<e> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.aBQ != null) {
            CharSequence v = v(arrayList);
            if (v != null) {
                spannableStringBuilder.append(v);
            }
            SpannableString c = c(this.mType, this.aBQ.getLink(), this.aBQ.getLink());
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
        if (this.mType != 32 || this.aBQ == null) {
            return null;
        }
        if (this.aBQ.EU() == 1) {
            return this.aBQ.EV();
        }
        return this.aBQ.getText();
    }

    public SpannableString Fl() {
        if (this.mType != 2 || this.aBQ == null) {
            return null;
        }
        if (this.aBQ.EU() == 1) {
            return c(this.mType, this.aBQ.getText(), this.aBQ.EV());
        }
        return c(this.mType, this.aBQ.getText(), this.aBQ.getLink());
    }

    public SpannableString Fm() {
        if (this.mType != 256 || this.aBQ == null) {
            return null;
        }
        String text = this.aBQ.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = String.valueOf(text) + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        g gVar = new g(this.mType, text);
        gVar.fQ(this.aBQ.getLink());
        spannableString.setSpan(gVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    public SpannableString Fn() {
        if (this.mType != 16 || this.aBQ == null) {
            return null;
        }
        return c(this.mType, this.aBQ.getText(), this.aBQ.getLink());
    }

    private SpannableString w(ArrayList<e> arrayList) {
        String text;
        int eM;
        a.C0049a fk;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.aBQ != null && this.aBQ.getText() != null && this.aBQ.getLink() != null && (eM = TbFaceManager.Ce().eM((text = this.aBQ.getText()))) != 0) {
            String str = "#(" + TbFaceManager.Ce().eO(text) + ")";
            spannableString = new SpannableString(String.valueOf(str) + " ");
            e eVar = new e(TbadkCoreApplication.m411getInst().getContext(), eM);
            if (arrayList != null) {
                arrayList.add(eVar);
            }
            if (TbFaceManager.Ce().fk(text) != null) {
                int width = (int) (fk.getWidth() * 0.5d);
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

    public CharSequence x(ArrayList<e> arrayList) {
        switch (this.mType) {
            case 1:
                return Fk();
            case 2:
                return Fl();
            case 4:
                return w(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return Fn();
            case 32:
                return t(arrayList);
            case 128:
                return u(arrayList);
            case 256:
                return Fm();
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
            this.mType = eK(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.aBw = new f(pbContent);
                    break;
                case 16:
                    this.aBQ = new b(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.aBA = new d();
                    this.aBA.atF.atg = String.format("#(%s)", pbContent.c);
                    this.aBA.atF.ati = pbContent.dynamic;
                    this.aBA.atF.ath = pbContent._static;
                    this.aBA.mType = this.mType;
                    this.aBA.atF.atj = pbContent.width.intValue();
                    this.aBA.atF.atk = pbContent.height.intValue();
                    this.aBA.atF.mPackageName = pbContent.packet_name;
                    this.aBA.atF.atl = pbContent._static;
                    String[] split = this.aBA.atF.ati.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.aBA.atF.mGid = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.aBA.atF.mGid = split[i].split("_")[0];
                case 32:
                    this.aBB = new j();
                    this.aBB.b(pbContent);
                    if (this.aBB.Fo()) {
                        break;
                    }
                    this.aBQ = new b(pbContent);
                    if (this.mType != 4) {
                        if (TbFaceManager.Ce().eM(this.aBQ.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.m411getInst().getString(i.h.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.aBQ.setText(str);
                            break;
                        } else {
                            this.aBQ.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.aBQ.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
                case 512:
                    this.aBy = new r(pbContent);
                    break;
                default:
                    this.aBQ = new b(pbContent);
                    if (this.mType != 4) {
                    }
                    break;
            }
            if (this.mType != 1 && this.aBQ != null) {
                this.aBQ.EW();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = eK(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.aBw = new f(jSONObject);
            } else if (this.mType == 512) {
                this.aBy = new r(jSONObject);
            } else if (this.mType == 16) {
                this.aBQ = new b(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.aBA = new d();
                this.aBA.atF.atg = String.format("#(%s)", jSONObject.optString("c"));
                this.aBA.atF.ati = jSONObject.optString("dynamic");
                this.aBA.atF.ath = jSONObject.optString("static");
                this.aBA.mType = this.mType;
                this.aBA.atF.atj = jSONObject.optInt("width", 200);
                this.aBA.atF.atk = jSONObject.optInt("height", 200);
                this.aBA.atF.mPackageName = jSONObject.optString("packet_name", "");
                this.aBA.atF.atl = jSONObject.optString("icon");
                String[] split = this.aBA.atF.ati.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.aBA.atF.mGid = split[i].split("_")[0];
            } else {
                this.aBQ = new b(jSONObject);
                if (this.mType == 4) {
                    int eM = TbFaceManager.Ce().eM(this.aBQ.getText());
                    String optString = jSONObject.optString("c");
                    if (eM <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.m411getInst().getString(i.h.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.aBQ.setText(str);
                    } else {
                        this.aBQ.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.aBQ.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.aBQ != null) {
                this.aBQ.EW();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int eK(int i) {
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
