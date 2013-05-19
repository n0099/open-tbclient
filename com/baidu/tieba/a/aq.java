package com.baidu.tieba.a;

import android.content.Context;
import android.text.ClipboardManager;
import android.text.SpannableString;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class aq {
    private String e;
    private ArrayList k;
    private JSONArray g = null;
    private com.baidu.tbadk.widget.richText.a l = null;
    private com.baidu.tbadk.widget.richText.a m = null;
    private String a = null;
    private String b = null;
    private int c = 0;
    private long d = 0;
    private bd f = new bd();
    private ArrayList h = new ArrayList();
    private ArrayList i = new ArrayList();
    private int j = 0;

    public aq() {
        this.k = null;
        this.k = new ArrayList();
    }

    public ArrayList a() {
        return this.k;
    }

    public void b() {
        this.j++;
    }

    public void c() {
        this.j--;
    }

    public String d() {
        return this.a;
    }

    public String e() {
        return this.e;
    }

    public int f() {
        return this.c;
    }

    public long g() {
        return this.d;
    }

    public bd h() {
        return this.f;
    }

    public ArrayList i() {
        return this.h;
    }

    public com.baidu.tbadk.widget.richText.a a(Context context) {
        if (this.l != null) {
            return this.l;
        }
        if (this.g != null) {
            this.l = TbRichTextView.a(context, this.g, true);
        }
        return this.l;
    }

    public com.baidu.tbadk.widget.richText.a b(Context context) {
        SpannableString spannableString;
        String str;
        String str2 = null;
        if (this.m != null) {
            return this.m;
        }
        if (this.g != null) {
            this.m = TbRichTextView.a(context, this.g);
            if (this.f != null) {
                spannableString = new SpannableString(String.valueOf(this.f.d()) + "：");
                str = this.f.c();
                str2 = this.f.a();
            } else {
                spannableString = new SpannableString("：");
                str = null;
            }
            spannableString.setSpan(new ar(this, context, str, str2), 0, spannableString.length(), 18);
            ArrayList a = this.m.a();
            if (a != null && a.size() > 0) {
                com.baidu.tbadk.widget.richText.c cVar = (com.baidu.tbadk.widget.richText.c) a.get(0);
                if (cVar.d() != null) {
                    cVar.d().insert(0, (CharSequence) spannableString);
                }
            }
        }
        return this.m;
    }

    public void a(ArrayList arrayList) {
        this.h = arrayList;
    }

    public ArrayList j() {
        return this.i;
    }

    public int k() {
        return this.j;
    }

    public void c(Context context) {
        int a;
        int i;
        int i2;
        if (this.h != null) {
            int i3 = -1;
            int size = this.i.size();
            if (size > 0) {
                try {
                    i3 = ((k) this.i.get(size - 1)).a();
                } catch (Exception e) {
                    com.baidu.tieba.d.ae.b("PostData", "uniteContentExcepFace", "error = " + e.getMessage());
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.h.size()) {
                k kVar = (k) this.h.get(i4);
                if (k.b(i5, kVar.a())) {
                    ((k) this.i.get(size - 1)).a(kVar.a(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (kVar.a() == 3 || kVar.a() == 2) {
                        this.i.add(kVar);
                        a = kVar.a();
                    } else {
                        k kVar2 = new k();
                        kVar2.a(0);
                        kVar2.a(kVar.a(context));
                        this.i.add(kVar2);
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
    }

    public void d(Context context) {
        int a;
        int i;
        if (this.h != null) {
            int i2 = -1;
            int size = this.i.size();
            if (size > 0) {
                try {
                    i2 = ((k) this.i.get(size - 1)).a();
                } catch (Exception e) {
                    com.baidu.tieba.d.ae.b("PostData", "uniteContentExcepFaceVideo", "error = " + e.getMessage());
                    return;
                }
            }
            int i3 = 0;
            int i4 = i2;
            while (i3 < this.h.size()) {
                k kVar = (k) this.h.get(i3);
                if (k.c(i4, kVar.a())) {
                    ((k) this.i.get(size - 1)).a(kVar.a(context));
                    a = i4;
                } else {
                    if (kVar.a() == 3 || kVar.a() == 2) {
                        this.i.add(kVar);
                        a = kVar.a();
                        i = size;
                    } else if (kVar.a() == 5) {
                        k kVar2 = new k();
                        kVar2.a(1000);
                        kVar2.b(kVar.d());
                        this.i.add(kVar2);
                        i = size + 1;
                        k kVar3 = new k();
                        kVar3.a(0);
                        kVar3.a(kVar.a(context));
                        this.i.add(kVar3);
                        a = 0;
                    } else {
                        k kVar4 = new k();
                        kVar4.a(0);
                        kVar4.a(kVar.a(context));
                        this.i.add(kVar4);
                        i = size;
                        a = 0;
                    }
                    size = i + 1;
                }
                i3++;
                i4 = a;
            }
        }
    }

    public void e(Context context) {
        int i;
        int i2;
        int i3;
        if (this.h != null) {
            int i4 = -1;
            int size = this.i.size();
            if (size > 0) {
                try {
                    i4 = ((k) this.i.get(size - 1)).a();
                } catch (Exception e) {
                    com.baidu.tieba.d.ae.b("PostData", "uniteContent", "error = " + e.getMessage());
                    return;
                }
            }
            int i5 = 0;
            int i6 = i4;
            while (i5 < this.h.size()) {
                k kVar = (k) this.h.get(i5);
                if (k.a(i6, kVar.a())) {
                    ((k) this.i.get(size - 1)).a(kVar.a(context));
                    i3 = size;
                    i2 = i6;
                } else {
                    if (kVar.a() == 3) {
                        this.i.add(kVar);
                        i = 3;
                    } else {
                        k kVar2 = new k();
                        kVar2.a(0);
                        kVar2.a(kVar.a(context));
                        this.i.add(kVar2);
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
    }

    public void f(Context context) {
        String d;
        if (this.i == null || this.i.size() == 0) {
            c(context);
        }
        ArrayList arrayList = this.i;
        if (arrayList != null) {
            StringBuilder sb = new StringBuilder();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                k kVar = (k) it.next();
                if (kVar.a() == 0) {
                    if (kVar.e() != null) {
                        sb.append((CharSequence) kVar.e());
                    }
                } else if (kVar.a() == 3) {
                    if (kVar.f() != null) {
                        sb.append(context.getString(R.string.pic));
                    }
                } else if (kVar.a() == 2 && (d = com.baidu.tbadk.a.a.a().d(kVar.d())) != null) {
                    sb.append("[");
                    sb.append(d);
                    sb.append("]");
                }
            }
            ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
            clipboardManager.setText(sb.toString());
            if (clipboardManager.getText() != null) {
                com.baidu.tieba.d.ae.e("PbActivity", "clip_text", clipboardManager.getText().toString());
            }
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optString("id");
                this.b = jSONObject.optString("title");
                this.c = jSONObject.optInt("floor", 0);
                this.d = jSONObject.optLong("time", 0L) * 1000;
                this.e = jSONObject.optString("time_ex");
                this.f.a(jSONObject.optJSONObject("author"));
                JSONArray optJSONArray = jSONObject.optJSONArray(PushConstants.EXTRA_CONTENT);
                this.g = optJSONArray;
                this.j = jSONObject.optInt("sub_post_number");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        k kVar = new k();
                        kVar.a(optJSONArray.optJSONObject(i));
                        this.h.add(kVar);
                    }
                }
                if (this.j > 0) {
                    JSONArray optJSONArray2 = jSONObject.optJSONObject("sub_post_list").optJSONArray("sub_post_list");
                    for (int i2 = 0; i2 < optJSONArray2.length() && i2 < 2; i2++) {
                        aq aqVar = new aq();
                        aqVar.a(optJSONArray2.getJSONObject(i2));
                        this.k.add(aqVar);
                    }
                }
            } catch (Exception e) {
                com.baidu.tieba.d.ae.b("PostData", "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
