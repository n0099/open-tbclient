package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CommonVcodeActivityConfig;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.t;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.lib.a.b.a.a.i {
    private f aIj;
    private int mType = 0;
    private b aIA = null;
    private g aIb = null;
    private x aId = null;
    private d aIf = null;
    private n aIg = null;
    private k aIi = null;
    private l aIh = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, b bVar, g gVar, x xVar, d dVar, k kVar, l lVar) {
        this.mType = i;
        this.aIA = bVar;
        this.aIb = gVar;
        this.aId = xVar;
        this.aIf = dVar;
        this.aIi = kVar;
        this.aIh = lVar;
    }

    public l Iy() {
        if (this.mType == 1280) {
            return this.aIh;
        }
        return null;
    }

    public k Iz() {
        if (this.mType == 1024) {
            return this.aIi;
        }
        return null;
    }

    public g Ir() {
        if (this.mType == 8) {
            return this.aIb;
        }
        return null;
    }

    public n Iv() {
        if (this.mType != 32) {
            return null;
        }
        return this.aIg;
    }

    public x It() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aId;
        }
        return null;
    }

    public d Iw() {
        if (this.mType == 17) {
            return this.aIf;
        }
        return null;
    }

    public f IA() {
        if (this.mType == 1536) {
            return this.aIj;
        }
        return null;
    }

    public SpannableString IH() {
        if (this.mType != 1 || this.aIA == null) {
            return null;
        }
        return new SpannableString(this.aIA.getText());
    }

    public CharSequence s(ArrayList<e> arrayList) {
        SpannableString c;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.aIA != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.m411getInst().getString(t.j.video_text));
            CharSequence u = u(arrayList);
            if (u != null) {
                spannableStringBuilder.append(u);
            }
            if (this.aIA.In() == 1) {
                c = c(this.mType, this.aIA.getText(), this.aIA.Io());
            } else {
                c = c(this.mType, this.aIA.getText(), this.aIA.getText());
            }
            if (c != null) {
                spannableStringBuilder.append((CharSequence) c);
            }
        }
        return spannableStringBuilder;
    }

    public CharSequence t(ArrayList<e> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.aIA != null) {
            CharSequence u = u(arrayList);
            if (u != null) {
                spannableStringBuilder.append(u);
            }
            SpannableString c = c(this.mType, this.aIA.getLink(), this.aIA.getLink());
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
        if (this.mType != 32 || this.aIA == null) {
            return null;
        }
        if (this.aIA.In() == 1) {
            return this.aIA.Io();
        }
        return this.aIA.getText();
    }

    public SpannableString II() {
        if (this.mType != 2 || this.aIA == null) {
            return null;
        }
        if (this.aIA.In() == 1) {
            return c(this.mType, this.aIA.getText(), this.aIA.Io());
        }
        return c(this.mType, this.aIA.getText(), this.aIA.getLink());
    }

    public SpannableString IJ() {
        if (this.mType != 256 || this.aIA == null) {
            return null;
        }
        String text = this.aIA.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = String.valueOf(text) + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        h hVar = new h(this.mType, text);
        hVar.gt(this.aIA.getLink());
        spannableString.setSpan(hVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    public SpannableString IK() {
        if (this.mType != 16 || this.aIA == null) {
            return null;
        }
        return c(this.mType, this.aIA.getText(), this.aIA.getLink());
    }

    private SpannableString v(ArrayList<e> arrayList) {
        String text;
        int fl;
        a.C0052a fL;
        SpannableString spannableString = null;
        if (this.mType == 4 && this.aIA != null && this.aIA.getText() != null && this.aIA.getLink() != null && (fl = TbFaceManager.EN().fl((text = this.aIA.getText()))) != 0) {
            String str = "#(" + TbFaceManager.EN().fn(text) + ")";
            spannableString = new SpannableString(String.valueOf(str) + " ");
            e eVar = new e(TbadkCoreApplication.m411getInst().getContext(), fl);
            if (arrayList != null) {
                arrayList.add(eVar);
            }
            if (TbFaceManager.EN().fL(text) != null) {
                int width = (int) (fL.getWidth() * 0.5d);
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

    public SpannableString IL() {
        if (this.mType != 1024 || this.aIi == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString("a");
        Drawable fz = j.fz(this.aIi.aIB);
        fz.setBounds(0, 0, fz.getIntrinsicWidth(), fz.getIntrinsicHeight());
        com.baidu.tbadk.widget.f fVar = new com.baidu.tbadk.widget.f(fz);
        fVar.setVerticalOffset(com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m411getInst().getContext(), t.e.ds4));
        spannableString.setSpan(fVar, 0, 1, 33);
        spannableString.setSpan(new h(1024, this.aIi.link), spannableString.length() - 1, "a".length(), 33);
        return spannableString;
    }

    public CharSequence w(ArrayList<e> arrayList) {
        switch (this.mType) {
            case 1:
                return IH();
            case 2:
                return II();
            case 4:
                return v(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return IK();
            case 32:
                return s(arrayList);
            case 128:
                return t(arrayList);
            case 256:
                return IJ();
            case 1024:
                return IL();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.aIg.IV() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = fy(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.aIb = new g(pbContent);
                    break;
                case 16:
                    this.aIA = new b(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.aIf = new d();
                    this.aIf.axx.awY = String.format("#(%s)", pbContent.c);
                    this.aIf.axx.axa = pbContent.dynamic;
                    this.aIf.axx.awZ = pbContent._static;
                    this.aIf.mType = this.mType;
                    this.aIf.axx.axb = pbContent.width.intValue();
                    this.aIf.axx.axc = pbContent.height.intValue();
                    this.aIf.axx.mPackageName = pbContent.packet_name;
                    this.aIf.axx.Ta = pbContent._static;
                    String[] split = this.aIf.axx.axa.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.aIf.axx.mGid = split[i].split("_")[0];
                            break;
                        }
                    }
                    this.aIf.axx.mGid = split[i].split("_")[0];
                case 512:
                    this.aId = new x(pbContent);
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
                default:
                    if (this.mType == 32) {
                        this.aIg = new n();
                        this.aIg.a(pbContent);
                        break;
                    }
                    this.aIA = new b(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.EN().fl(this.aIA.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.m411getInst().getString(t.j.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.aIA.setText(str);
                            break;
                        } else {
                            this.aIA.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.aIA.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.aIA != null) {
                this.aIA.Ip();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = fy(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.aIb = new g(jSONObject);
            } else if (this.mType == 512) {
                this.aId = new x(jSONObject);
            } else if (this.mType == 16) {
                this.aIA = new b(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.aIf = new d();
                this.aIf.axx.awY = String.format("#(%s)", jSONObject.optString("c"));
                this.aIf.axx.axa = jSONObject.optString("dynamic");
                this.aIf.axx.awZ = jSONObject.optString("static");
                this.aIf.mType = this.mType;
                this.aIf.axx.axb = jSONObject.optInt(CommonVcodeActivityConfig.WIDTH, 200);
                this.aIf.axx.axc = jSONObject.optInt(CommonVcodeActivityConfig.HEIGHT, 200);
                this.aIf.axx.mPackageName = jSONObject.optString("packet_name", "");
                this.aIf.axx.Ta = jSONObject.optString("icon");
                String[] split = this.aIf.axx.axa.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.aIf.axx.mGid = split[i].split("_")[0];
            } else {
                this.aIA = new b(jSONObject);
                if (this.mType == 4) {
                    int fl = TbFaceManager.EN().fl(this.aIA.getText());
                    String optString = jSONObject.optString("c");
                    if (fl <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.m411getInst().getString(t.j.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.aIA.setText(str);
                    } else {
                        this.aIA.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.aIA.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.aIA != null) {
                this.aIA.Ip();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int fy(int i) {
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
        }
    }
}
