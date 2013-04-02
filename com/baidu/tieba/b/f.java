package com.baidu.tieba.b;

import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.a.aw;
import com.baidu.tieba.c.ag;
import com.baidu.tieba.c.ai;
import com.baidu.zeus.WebChromeClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    private final int i = 145;
    private final int j = 145;
    private final int k = WebChromeClient.STRING_DLG_TITLE_COLOR;
    private final int l = WebChromeClient.STRING_DLG_TITLE_COLOR;
    private boolean c = true;
    private List a = new ArrayList();
    private List b = new ArrayList();
    private int[] d = {R.drawable.ball_blue, R.drawable.ball_green, R.drawable.ball_lightblue, R.drawable.ball_orange, R.drawable.ball_violet, R.drawable.ball_yellow, R.drawable.ball_yolk};
    private int[][] e = {new int[]{28, 52}, new int[]{90, 40}, new int[]{25, 97}, new int[]{110, 121}};
    private int[][] f = {new int[]{WebChromeClient.STRING_DLG_BTN_CLEAR, 149}, new int[]{121, 193}, new int[]{207, 146}, new int[]{188, 75}};
    private int[][] g = {new int[]{22, 249}, new int[]{16, 206}, new int[]{94, 253}, new int[]{19, 326}};
    private int[][] h = {new int[]{175, 286}, new int[]{225, 299}, new int[]{136, 322}, new int[]{219, 228}};
    private List m = new ArrayList();
    private List n = new ArrayList();

    public List a() {
        return this.a;
    }

    public List b() {
        return this.b;
    }

    public void c() {
        int[][] iArr;
        int a = ai.a(TiebaApplication.b().getApplicationContext());
        int b = ai.b(TiebaApplication.b().getApplicationContext());
        if (a > 0 && b > 0) {
            int min = Math.min((int) (((a * 145) * 1.0d) / 320.0d), (int) (((b * 145) * 1.0d) / 480.0d));
            int min2 = Math.min((int) (((a * WebChromeClient.STRING_DLG_TITLE_COLOR) * 1.0d) / 320.0d), (int) (((b * WebChromeClient.STRING_DLG_TITLE_COLOR) * 1.0d) / 480.0d));
            int length = this.d.length;
            Random random = new Random(length);
            int abs = Math.abs(random.nextInt()) % length;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (this.a != null && this.a.size() > 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.a.size()) {
                        break;
                    }
                    com.baidu.tieba.a.y yVar = (com.baidu.tieba.a.y) this.a.get(i2);
                    if (yVar.b().size() == 2 && arrayList.size() < 3) {
                        arrayList.add(yVar);
                    } else if (arrayList2.size() < 12) {
                        arrayList2.add(yVar);
                    }
                    i = i2 + 1;
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                int i3 = 0;
                while (i3 < arrayList.size()) {
                    com.baidu.tieba.a.y yVar2 = (com.baidu.tieba.a.y) arrayList.get(i3);
                    int i4 = abs + 1;
                    yVar2.f(this.d[abs % length]);
                    yVar2.a(i3 % 3);
                    List b2 = yVar2.b();
                    yVar2.d(min);
                    yVar2.e(min);
                    int i5 = this.f[0][0];
                    int i6 = this.f[0][1];
                    yVar2.b((int) ((((i5 - ((random.nextInt() % 3) * 10)) * a) * 1.0d) / 320.0d));
                    yVar2.c((int) ((((i6 - ((random.nextInt() % 3) * 10)) * b) * 1.0d) / 480.0d));
                    if (b2 != null && b2.size() > 0) {
                        int abs2 = Math.abs(random.nextInt()) % length;
                        int i7 = 0;
                        while (i7 < b2.size()) {
                            int i8 = abs2 + 1;
                            ((com.baidu.tieba.a.z) b2.get(i7)).f(this.d[abs2 % length]);
                            ((com.baidu.tieba.a.z) b2.get(i7)).d(min2);
                            ((com.baidu.tieba.a.z) b2.get(i7)).e(min2);
                            int i9 = this.f[(i7 + 1) % 4][0];
                            int i10 = this.f[(i7 + 1) % 4][1];
                            ((com.baidu.tieba.a.z) b2.get(i7)).b((int) (((i9 * a) * 1.0d) / 320.0d));
                            ((com.baidu.tieba.a.z) b2.get(i7)).c((int) (((i10 * b) * 1.0d) / 480.0d));
                            i7++;
                            abs2 = i8;
                        }
                    }
                    i3++;
                    abs = i4;
                }
            }
            int i11 = abs;
            if (arrayList2 != null && arrayList2.size() > 0) {
                int i12 = i11;
                int i13 = 0;
                while (i13 < arrayList2.size()) {
                    com.baidu.tieba.a.y yVar3 = (com.baidu.tieba.a.y) arrayList2.get(i13);
                    int i14 = i12 + 1;
                    yVar3.f(this.d[i12 % length]);
                    yVar3.a((i13 / 3) % 3);
                    List b3 = yVar3.b();
                    yVar3.d(min);
                    yVar3.e(min);
                    switch (i13 % 3) {
                        case 0:
                            iArr = this.e;
                            break;
                        case 1:
                            iArr = this.g;
                            break;
                        case 2:
                            iArr = this.h;
                            break;
                        default:
                            iArr = this.e;
                            break;
                    }
                    int i15 = iArr[0][0];
                    int i16 = iArr[0][1];
                    yVar3.b((int) ((((i15 - ((random.nextInt() % 3) * 10)) * a) * 1.0d) / 320.0d));
                    yVar3.c((int) ((((i16 - ((random.nextInt() % 3) * 10)) * b) * 1.0d) / 480.0d));
                    if (b3 != null && b3.size() > 0) {
                        int abs3 = Math.abs(random.nextInt()) % length;
                        int i17 = 0;
                        while (i17 < b3.size()) {
                            int i18 = abs3 + 1;
                            ((com.baidu.tieba.a.z) b3.get(i17)).f(this.d[abs3 % length]);
                            ((com.baidu.tieba.a.z) b3.get(i17)).d(min2);
                            ((com.baidu.tieba.a.z) b3.get(i17)).e(min2);
                            int i19 = iArr[(i17 + 1) % 4][0];
                            int i20 = iArr[(i17 + 1) % 4][1];
                            ((com.baidu.tieba.a.z) b3.get(i17)).b((int) (((i19 * a) * 1.0d) / 320.0d));
                            ((com.baidu.tieba.a.z) b3.get(i17)).c((int) (((i20 * b) * 1.0d) / 480.0d));
                            i17++;
                            abs3 = i18;
                        }
                    }
                    i13++;
                    i12 = i14;
                }
                i11 = i12;
            }
            if (this.b != null && this.b.size() > 0) {
                int i21 = i11;
                int i22 = 0;
                while (i22 < this.b.size()) {
                    int i23 = i21 + 1;
                    ((com.baidu.tieba.a.z) this.b.get(i22)).f(this.d[i21 % length]);
                    ((com.baidu.tieba.a.z) this.b.get(i22)).d(min2);
                    ((com.baidu.tieba.a.z) this.b.get(i22)).e(min2);
                    ((com.baidu.tieba.a.z) this.b.get(i22)).a(i22 % 3);
                    int i24 = this.f[3][0];
                    int i25 = this.f[3][1];
                    ((com.baidu.tieba.a.z) this.b.get(i22)).b((int) ((((i24 - ((random.nextInt() % 3) * 10)) * a) * 1.0d) / 320.0d));
                    ((com.baidu.tieba.a.z) this.b.get(i22)).c((int) ((((i25 - ((random.nextInt() % 3) * 0)) * b) * 1.0d) / 480.0d));
                    i22++;
                    i21 = i23;
                }
            }
        }
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            this.c = false;
            ag.b("LabelModel", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            JSONArray optJSONArray = optJSONObject.optJSONArray("level1");
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("level2");
            JSONArray optJSONArray3 = optJSONObject.optJSONArray("user_tag");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.a.clear();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    com.baidu.tieba.a.y yVar = new com.baidu.tieba.a.y();
                    yVar.a(optJSONArray.getJSONObject(i));
                    this.a.add(yVar);
                }
            }
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                this.b.clear();
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    com.baidu.tieba.a.z zVar = new com.baidu.tieba.a.z();
                    zVar.a(optJSONArray2.getJSONObject(i2));
                    this.b.add(zVar);
                }
            }
            if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                    aw awVar = new aw();
                    awVar.a(optJSONArray3.getJSONObject(i3));
                    this.m.add(awVar);
                    this.n.add(awVar);
                }
            }
            c();
        } catch (Exception e) {
            this.c = false;
            ag.b("LabelModel", "parserJson", "error = " + e.getMessage());
        }
    }

    private static String a(List list) {
        StringBuffer stringBuffer = new StringBuffer();
        if (list.size() == 0) {
            return "";
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                if (i2 > 0) {
                    stringBuffer.append(',');
                }
                if (list.get(i2) != null) {
                    stringBuffer.append(((aw) list.get(i2)).a());
                }
                i = i2 + 1;
            } else {
                return stringBuffer.toString();
            }
        }
    }

    public String[] d() {
        String[] strArr = {"", ""};
        if (this.n.size() == 0) {
            if (this.m.size() == 0) {
                return strArr;
            }
            strArr[0] = a(this.m);
            return strArr;
        } else if (this.m.size() == 0) {
            strArr[1] = a(this.n);
            return strArr;
        } else {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (aw awVar : this.m) {
                if (!this.n.contains(awVar)) {
                    arrayList.add(awVar);
                }
            }
            for (aw awVar2 : this.n) {
                if (!this.m.contains(awVar2)) {
                    arrayList2.add(awVar2);
                }
            }
            strArr[0] = a(arrayList);
            strArr[1] = a(arrayList2);
            return strArr;
        }
    }

    public void b(String str) {
        String[] split;
        if (str != null && str.length() > 0 && (split = str.split(",")) != null && split.length > 0) {
            this.m.clear();
            for (int i = 0; i < split.length; i = i + 1 + 1) {
                aw awVar = new aw();
                awVar.a(split[i]);
                awVar.b(split[i + 1]);
                this.m.add(awVar);
                this.n.add(awVar);
            }
        }
    }

    public static String e() {
        String b = com.baidu.tieba.c.k.b(12);
        if (b != null && b.length() > 0) {
            ArrayList arrayList = new ArrayList();
            String[] split = b.split(",");
            if (split != null && split.length > 0) {
                for (int i = 0; i < split.length; i = i + 1 + 1) {
                    aw awVar = new aw();
                    awVar.a(split[i]);
                    awVar.b(split[i + 1]);
                    arrayList.add(awVar);
                }
                return a(arrayList);
            }
        }
        return null;
    }

    public String f() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.m.size() == 0) {
            return "";
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.m.size()) {
                if (i2 > 0) {
                    stringBuffer.append(',');
                }
                if (this.m.get(i2) != null) {
                    stringBuffer.append(((aw) this.m.get(i2)).a());
                    stringBuffer.append(',');
                    stringBuffer.append(((aw) this.m.get(i2)).b());
                }
                i = i2 + 1;
            } else {
                return stringBuffer.toString();
            }
        }
    }

    public String g() {
        return a(this.m);
    }

    public boolean a(aw awVar) {
        boolean z;
        Iterator it = this.m.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            } else if (((aw) it.next()).a().equals(awVar.a())) {
                z = true;
                break;
            }
        }
        if (z) {
            return false;
        }
        return this.m.add(awVar);
    }

    public boolean b(aw awVar) {
        for (aw awVar2 : this.m) {
            if (awVar2.a().equals(awVar.a())) {
                return this.m.remove(awVar2);
            }
        }
        return false;
    }

    public List h() {
        return this.m;
    }
}
