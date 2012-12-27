package com.baidu.tieba.a;

import android.content.Context;
import android.text.ClipboardManager;
import com.baidu.location.LocationClientOption;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class am {
    private String a = null;
    private String b = null;
    private int c = 0;
    private long d = 0;
    private au e = new au();
    private ArrayList f = new ArrayList();
    private ArrayList g = new ArrayList();
    private int h = 0;

    public String a() {
        return this.a;
    }

    public void a(Context context) {
        int a;
        int i;
        int i2;
        if (this.f == null) {
            return;
        }
        int i3 = -1;
        int size = this.g.size();
        if (size > 0) {
            try {
                i3 = ((j) this.g.get(size - 1)).a();
            } catch (Exception e) {
                com.baidu.tieba.c.ae.b("PostData", "uniteContentExcepFace", "error = " + e.getMessage());
                return;
            }
        }
        int i4 = 0;
        int i5 = i3;
        while (i4 < this.f.size()) {
            j jVar = (j) this.f.get(i4);
            if (j.b(i5, jVar.a())) {
                ((j) this.g.get(size - 1)).a(jVar.a(context));
                i2 = size;
                i = i5;
            } else {
                if (jVar.a() == 3 || jVar.a() == 2) {
                    this.g.add(jVar);
                    a = jVar.a();
                } else {
                    j jVar2 = new j();
                    jVar2.a(0);
                    jVar2.a(jVar.a(context));
                    this.g.add(jVar2);
                    a = 0;
                }
                i = a;
                i2 = size + 1;
            }
            i4++;
            i5 = i;
            size = i2;
        }
    }

    public void a(ArrayList arrayList) {
        this.f = arrayList;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.a = jSONObject.optString("id");
            this.b = jSONObject.optString("title");
            this.c = jSONObject.optInt("floor", 0);
            this.d = jSONObject.optLong("time", 0L) * 1000;
            this.e.a(jSONObject.optJSONObject("author"));
            JSONArray optJSONArray = jSONObject.optJSONArray("content");
            this.h = jSONObject.optInt("sub_post_number");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    j jVar = new j();
                    jVar.a(optJSONArray.optJSONObject(i));
                    this.f.add(jVar);
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b("PostData", "parserJson", "error = " + e.getMessage());
        }
    }

    public int b() {
        return this.c;
    }

    public void b(Context context) {
        int a;
        int i;
        if (this.f == null) {
            return;
        }
        int i2 = -1;
        int size = this.g.size();
        if (size > 0) {
            try {
                i2 = ((j) this.g.get(size - 1)).a();
            } catch (Exception e) {
                com.baidu.tieba.c.ae.b("PostData", "uniteContentExcepFaceVideo", "error = " + e.getMessage());
                return;
            }
        }
        int i3 = 0;
        int i4 = i2;
        while (i3 < this.f.size()) {
            j jVar = (j) this.f.get(i3);
            if (j.c(i4, jVar.a())) {
                ((j) this.g.get(size - 1)).a(jVar.a(context));
                a = i4;
            } else {
                if (jVar.a() == 3 || jVar.a() == 2) {
                    this.g.add(jVar);
                    a = jVar.a();
                    i = size;
                } else if (jVar.a() == 5) {
                    j jVar2 = new j();
                    jVar2.a(LocationClientOption.MIN_SCAN_SPAN);
                    jVar2.a(jVar.d());
                    this.g.add(jVar2);
                    i = size + 1;
                    j jVar3 = new j();
                    jVar3.a(0);
                    jVar3.a(jVar.a(context));
                    this.g.add(jVar3);
                    a = 0;
                } else {
                    j jVar4 = new j();
                    jVar4.a(0);
                    jVar4.a(jVar.a(context));
                    this.g.add(jVar4);
                    i = size;
                    a = 0;
                }
                size = i + 1;
            }
            i3++;
            i4 = a;
        }
    }

    public long c() {
        return this.d;
    }

    public void c(Context context) {
        int i;
        int i2;
        int i3;
        if (this.f == null) {
            return;
        }
        int i4 = -1;
        int size = this.g.size();
        if (size > 0) {
            try {
                i4 = ((j) this.g.get(size - 1)).a();
            } catch (Exception e) {
                com.baidu.tieba.c.ae.b("PostData", "uniteContent", "error = " + e.getMessage());
                return;
            }
        }
        int i5 = 0;
        int i6 = i4;
        while (i5 < this.f.size()) {
            j jVar = (j) this.f.get(i5);
            if (j.a(i6, jVar.a())) {
                ((j) this.g.get(size - 1)).a(jVar.a(context));
                i3 = size;
                i2 = i6;
            } else {
                if (jVar.a() == 3) {
                    this.g.add(jVar);
                    i = 3;
                } else {
                    j jVar2 = new j();
                    jVar2.a(0);
                    jVar2.a(jVar.a(context));
                    this.g.add(jVar2);
                    i = 0;
                }
                i2 = i;
                i3 = size + 1;
            }
            i5++;
            i6 = i2;
            size = i3;
        }
    }

    public au d() {
        return this.e;
    }

    public void d(Context context) {
        String a;
        ArrayList arrayList = this.g;
        if (arrayList != null) {
            StringBuilder sb = new StringBuilder();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                j jVar = (j) it.next();
                if (jVar.a() == 0) {
                    if (jVar.e() != null) {
                        sb.append((CharSequence) jVar.e());
                    }
                } else if (jVar.a() == 3) {
                    if (jVar.f() != null) {
                        sb.append(context.getString(R.string.pic));
                    }
                } else if (jVar.a() == 2 && (a = com.baidu.tieba.c.n.a(jVar.d())) != null) {
                    sb.append("(");
                    sb.append(a);
                    sb.append(") ");
                }
            }
            ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
            clipboardManager.setText(sb.toString());
            if (clipboardManager.getText() != null) {
                com.baidu.tieba.c.ae.c("PbActivity", "clip_text", clipboardManager.getText().toString());
            }
        }
    }

    public ArrayList e() {
        return this.g;
    }

    public int f() {
        return this.h;
    }
}
