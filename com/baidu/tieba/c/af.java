package com.baidu.tieba.c;

import com.baidu.tieba.TiebaApplication;
import com.baidu.zeus.WebChromeClient;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class af {
    private boolean c = true;
    private List a = new ArrayList();
    private List b = new ArrayList();
    private int[] d = {R.drawable.ball_blue, R.drawable.ball_green, R.drawable.ball_lightblue, R.drawable.ball_orange, R.drawable.ball_violet, R.drawable.ball_yellow, R.drawable.ball_yolk};
    private int[][] e = {new int[]{28, 52}, new int[]{90, 40}, new int[]{25, 97}, new int[]{110, 121}};
    private int[][] f = {new int[]{WebChromeClient.STRING_DLG_BTN_CLEAR, 149}, new int[]{121, 193}, new int[]{207, 146}, new int[]{188, 75}};
    private int[][] g = {new int[]{22, 249}, new int[]{16, 206}, new int[]{94, 253}, new int[]{19, 326}};
    private int[][] h = {new int[]{175, 286}, new int[]{225, 299}, new int[]{136, 322}, new int[]{219, 228}};
    private List i = new ArrayList();
    private List j = new ArrayList();

    public List a() {
        return this.a;
    }

    public List b() {
        return this.b;
    }

    public void c() {
        int[][] iArr;
        int a = com.baidu.tieba.d.ag.a(TiebaApplication.d().getApplicationContext());
        int b = com.baidu.tieba.d.ag.b(TiebaApplication.d().getApplicationContext());
        if (a > 0 && b > 0) {
            int min = Math.min((int) (((a * 145) * 1.0d) / 320.0d), (int) (((b * 145) * 1.0d) / 480.0d));
            int min2 = Math.min((int) (((a * WebChromeClient.STRING_DLG_TITLE_COLOR) * 1.0d) / 320.0d), (int) (((b * WebChromeClient.STRING_DLG_TITLE_COLOR) * 1.0d) / 480.0d));
            int length = this.d.length;
            Random random = new Random(length);
            int nextInt = random.nextInt(length);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (this.a != null && this.a.size() > 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.a.size()) {
                        break;
                    }
                    com.baidu.tieba.a.aa aaVar = (com.baidu.tieba.a.aa) this.a.get(i2);
                    if (aaVar.b().size() == 2 && arrayList.size() < 3) {
                        arrayList.add(aaVar);
                    } else if (arrayList2.size() < 12) {
                        arrayList2.add(aaVar);
                    }
                    i = i2 + 1;
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                int i3 = 0;
                while (i3 < arrayList.size()) {
                    com.baidu.tieba.a.aa aaVar2 = (com.baidu.tieba.a.aa) arrayList.get(i3);
                    int i4 = nextInt + 1;
                    aaVar2.f(this.d[nextInt % length]);
                    aaVar2.a(i3 % 3);
                    List b2 = aaVar2.b();
                    aaVar2.d(min);
                    aaVar2.e(min);
                    int i5 = this.f[0][0];
                    int i6 = this.f[0][1];
                    aaVar2.b((int) ((((i5 - ((random.nextInt() % 3) * 10)) * a) * 1.0d) / 320.0d));
                    aaVar2.c((int) ((((i6 - ((random.nextInt() % 3) * 10)) * b) * 1.0d) / 480.0d));
                    if (b2 != null && b2.size() > 0) {
                        int nextInt2 = random.nextInt(length);
                        int i7 = 0;
                        while (i7 < b2.size()) {
                            int i8 = nextInt2 + 1;
                            ((com.baidu.tieba.a.ab) b2.get(i7)).f(this.d[nextInt2 % length]);
                            ((com.baidu.tieba.a.ab) b2.get(i7)).d(min2);
                            ((com.baidu.tieba.a.ab) b2.get(i7)).e(min2);
                            int i9 = this.f[(i7 + 1) % 4][0];
                            int i10 = this.f[(i7 + 1) % 4][1];
                            ((com.baidu.tieba.a.ab) b2.get(i7)).b((int) (((i9 * a) * 1.0d) / 320.0d));
                            ((com.baidu.tieba.a.ab) b2.get(i7)).c((int) (((i10 * b) * 1.0d) / 480.0d));
                            i7++;
                            nextInt2 = i8;
                        }
                    }
                    i3++;
                    nextInt = i4;
                }
            }
            int i11 = nextInt;
            if (arrayList2 != null && arrayList2.size() > 0) {
                int i12 = i11;
                int i13 = 0;
                while (i13 < arrayList2.size()) {
                    com.baidu.tieba.a.aa aaVar3 = (com.baidu.tieba.a.aa) arrayList2.get(i13);
                    int i14 = i12 + 1;
                    aaVar3.f(this.d[i12 % length]);
                    aaVar3.a((i13 / 3) % 3);
                    List b3 = aaVar3.b();
                    aaVar3.d(min);
                    aaVar3.e(min);
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
                    aaVar3.b((int) ((((i15 - ((random.nextInt() % 3) * 10)) * a) * 1.0d) / 320.0d));
                    aaVar3.c((int) ((((i16 - ((random.nextInt() % 3) * 10)) * b) * 1.0d) / 480.0d));
                    if (b3 != null && b3.size() > 0) {
                        int nextInt3 = random.nextInt(length);
                        int i17 = 0;
                        while (i17 < b3.size()) {
                            int i18 = nextInt3 + 1;
                            ((com.baidu.tieba.a.ab) b3.get(i17)).f(this.d[nextInt3 % length]);
                            ((com.baidu.tieba.a.ab) b3.get(i17)).d(min2);
                            ((com.baidu.tieba.a.ab) b3.get(i17)).e(min2);
                            int i19 = iArr[(i17 + 1) % 4][0];
                            int i20 = iArr[(i17 + 1) % 4][1];
                            ((com.baidu.tieba.a.ab) b3.get(i17)).b((int) (((i19 * a) * 1.0d) / 320.0d));
                            ((com.baidu.tieba.a.ab) b3.get(i17)).c((int) (((i20 * b) * 1.0d) / 480.0d));
                            i17++;
                            nextInt3 = i18;
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
                    ((com.baidu.tieba.a.ab) this.b.get(i22)).f(this.d[i21 % length]);
                    ((com.baidu.tieba.a.ab) this.b.get(i22)).d(min2);
                    ((com.baidu.tieba.a.ab) this.b.get(i22)).e(min2);
                    ((com.baidu.tieba.a.ab) this.b.get(i22)).a(i22 % 3);
                    int i24 = this.f[3][0];
                    int i25 = this.f[3][1];
                    ((com.baidu.tieba.a.ab) this.b.get(i22)).b((int) ((((i24 - ((random.nextInt() % 3) * 10)) * a) * 1.0d) / 320.0d));
                    ((com.baidu.tieba.a.ab) this.b.get(i22)).c((int) ((((i25 - ((random.nextInt() % 3) * 0)) * b) * 1.0d) / 480.0d));
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
            com.baidu.tieba.d.ae.b("LabelModel", "parserJson", "error = " + e.getMessage());
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
                    com.baidu.tieba.a.aa aaVar = new com.baidu.tieba.a.aa();
                    aaVar.a(optJSONArray.getJSONObject(i));
                    this.a.add(aaVar);
                }
            }
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                this.b.clear();
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    com.baidu.tieba.a.ab abVar = new com.baidu.tieba.a.ab();
                    abVar.a(optJSONArray2.getJSONObject(i2));
                    this.b.add(abVar);
                }
            }
            if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                    com.baidu.tieba.a.bb bbVar = new com.baidu.tieba.a.bb();
                    bbVar.a(optJSONArray3.getJSONObject(i3));
                    this.i.add(bbVar);
                    this.j.add(bbVar);
                }
            }
            c();
        } catch (Exception e) {
            this.c = false;
            com.baidu.tieba.d.ae.b("LabelModel", "parserJson", "error = " + e.getMessage());
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
                    stringBuffer.append(((com.baidu.tieba.a.bb) list.get(i2)).a());
                }
                i = i2 + 1;
            } else {
                return stringBuffer.toString();
            }
        }
    }

    public String[] d() {
        String[] strArr = {"", ""};
        if (this.j.size() == 0) {
            if (this.i.size() == 0) {
                return strArr;
            }
            strArr[0] = a(this.i);
            return strArr;
        } else if (this.i.size() == 0) {
            strArr[1] = a(this.j);
            return strArr;
        } else {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (com.baidu.tieba.a.bb bbVar : this.i) {
                if (!this.j.contains(bbVar)) {
                    arrayList.add(bbVar);
                }
            }
            for (com.baidu.tieba.a.bb bbVar2 : this.j) {
                if (!this.i.contains(bbVar2)) {
                    arrayList2.add(bbVar2);
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
            this.i.clear();
            for (int i = 0; i < split.length; i = i + 1 + 1) {
                com.baidu.tieba.a.bb bbVar = new com.baidu.tieba.a.bb();
                bbVar.a(split[i]);
                bbVar.b(split[i + 1]);
                this.i.add(bbVar);
                this.j.add(bbVar);
            }
        }
    }

    public static String e() {
        String b = com.baidu.tieba.d.k.b(12);
        if (b != null && b.length() > 0) {
            ArrayList arrayList = new ArrayList();
            String[] split = b.split(",");
            if (split != null && split.length > 0) {
                for (int i = 0; i < split.length; i = i + 1 + 1) {
                    com.baidu.tieba.a.bb bbVar = new com.baidu.tieba.a.bb();
                    bbVar.a(split[i]);
                    bbVar.b(split[i + 1]);
                    arrayList.add(bbVar);
                }
                return a(arrayList);
            }
        }
        return null;
    }

    public String f() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.i.size() == 0) {
            return "";
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.i.size()) {
                if (i2 > 0) {
                    stringBuffer.append(',');
                }
                if (this.i.get(i2) != null) {
                    stringBuffer.append(((com.baidu.tieba.a.bb) this.i.get(i2)).a());
                    stringBuffer.append(',');
                    stringBuffer.append(((com.baidu.tieba.a.bb) this.i.get(i2)).b());
                }
                i = i2 + 1;
            } else {
                return stringBuffer.toString();
            }
        }
    }

    public String g() {
        return a(this.i);
    }

    public boolean a(com.baidu.tieba.a.bb bbVar) {
        boolean z;
        Iterator it = this.i.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            } else if (((com.baidu.tieba.a.bb) it.next()).a().equals(bbVar.a())) {
                z = true;
                break;
            }
        }
        if (z) {
            return false;
        }
        return this.i.add(bbVar);
    }

    public boolean b(com.baidu.tieba.a.bb bbVar) {
        for (com.baidu.tieba.a.bb bbVar2 : this.i) {
            if (bbVar2.a().equals(bbVar.a())) {
                return this.i.remove(bbVar2);
            }
        }
        return false;
    }

    public List h() {
        return this.i;
    }
}
