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
public class ar {
    private String e;
    private ArrayList j;
    private com.baidu.tbadk.widget.richText.a k = null;
    private String a = null;
    private String b = null;
    private int c = 0;
    private long d = 0;
    private be f = new be();
    private ArrayList g = new ArrayList();
    private ArrayList h = new ArrayList();
    private int i = 0;

    public ar() {
        this.j = null;
        this.j = new ArrayList();
    }

    public ArrayList a() {
        return this.j;
    }

    public void b() {
        this.i++;
    }

    public void c() {
        this.i--;
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

    public be h() {
        return this.f;
    }

    public com.baidu.tbadk.widget.richText.a i() {
        return this.k;
    }

    public void a(Context context) {
        SpannableString spannableString;
        String str;
        String str2 = null;
        if (context != null && this.k != null && this.k.a() != null) {
            if (this.f != null) {
                spannableString = new SpannableString(String.valueOf(this.f.d()) + "：");
                str = this.f.c();
                str2 = this.f.a();
            } else {
                spannableString = new SpannableString("：");
                str = null;
            }
            spannableString.setSpan(new as(this, context, str, str2), 0, spannableString.length(), 18);
            ArrayList a = this.k.a();
            if (a != null && a.size() > 0) {
                com.baidu.tbadk.widget.richText.c cVar = (com.baidu.tbadk.widget.richText.c) a.get(0);
                if (cVar.d() != null) {
                    cVar.d().insert(0, (CharSequence) spannableString);
                }
            }
        }
    }

    public void a(ArrayList arrayList) {
        this.g = arrayList;
    }

    public ArrayList j() {
        return this.h;
    }

    public int k() {
        return this.i;
    }

    public void b(Context context) {
        int a;
        int i;
        int i2;
        if (this.g != null) {
            int i3 = -1;
            int size = this.h.size();
            if (size > 0) {
                try {
                    i3 = ((k) this.h.get(size - 1)).a();
                } catch (Exception e) {
                    com.baidu.tieba.d.ae.b("PostData", "uniteContentExcepFace", "error = " + e.getMessage());
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.g.size()) {
                k kVar = (k) this.g.get(i4);
                if (k.b(i5, kVar.a())) {
                    ((k) this.h.get(size - 1)).a(kVar.a(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (kVar.a() == 3 || kVar.a() == 2) {
                        this.h.add(kVar);
                        a = kVar.a();
                    } else {
                        k kVar2 = new k();
                        kVar2.a(0);
                        kVar2.a(kVar.a(context));
                        this.h.add(kVar2);
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

    public void c(Context context) {
        int a;
        int i;
        if (this.g != null) {
            int i2 = -1;
            int size = this.h.size();
            if (size > 0) {
                try {
                    i2 = ((k) this.h.get(size - 1)).a();
                } catch (Exception e) {
                    com.baidu.tieba.d.ae.b("PostData", "uniteContentExcepFaceVideo", "error = " + e.getMessage());
                    return;
                }
            }
            int i3 = 0;
            int i4 = i2;
            while (i3 < this.g.size()) {
                k kVar = (k) this.g.get(i3);
                if (k.c(i4, kVar.a())) {
                    ((k) this.h.get(size - 1)).a(kVar.a(context));
                    a = i4;
                } else {
                    if (kVar.a() == 3 || kVar.a() == 2) {
                        this.h.add(kVar);
                        a = kVar.a();
                        i = size;
                    } else if (kVar.a() == 5) {
                        k kVar2 = new k();
                        kVar2.a(1000);
                        kVar2.b(kVar.d());
                        this.h.add(kVar2);
                        i = size + 1;
                        k kVar3 = new k();
                        kVar3.a(0);
                        kVar3.a(kVar.a(context));
                        this.h.add(kVar3);
                        a = 0;
                    } else {
                        k kVar4 = new k();
                        kVar4.a(0);
                        kVar4.a(kVar.a(context));
                        this.h.add(kVar4);
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

    public void d(Context context) {
        int i;
        int i2;
        int i3;
        if (this.g != null) {
            int i4 = -1;
            int size = this.h.size();
            if (size > 0) {
                try {
                    i4 = ((k) this.h.get(size - 1)).a();
                } catch (Exception e) {
                    com.baidu.tieba.d.ae.b("PostData", "uniteContent", "error = " + e.getMessage());
                    return;
                }
            }
            int i5 = 0;
            int i6 = i4;
            while (i5 < this.g.size()) {
                k kVar = (k) this.g.get(i5);
                if (k.a(i6, kVar.a())) {
                    ((k) this.h.get(size - 1)).a(kVar.a(context));
                    i3 = size;
                    i2 = i6;
                } else {
                    if (kVar.a() == 3) {
                        this.h.add(kVar);
                        i = 3;
                    } else {
                        k kVar2 = new k();
                        kVar2.a(0);
                        kVar2.a(kVar.a(context));
                        this.h.add(kVar2);
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

    public void e(Context context) {
        String d;
        try {
            if (this.k != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.k.toString());
                if (clipboardManager.getText() != null) {
                    com.baidu.tieba.d.ae.e(getClass().getName(), "clip_text", clipboardManager.getText().toString());
                    return;
                }
                return;
            }
            if (this.h == null || this.h.size() == 0) {
                b(context);
            }
            ArrayList arrayList = this.h;
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
                ClipboardManager clipboardManager2 = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager2.setText(sb.toString());
                if (clipboardManager2.getText() != null) {
                    com.baidu.tieba.d.ae.e("PbActivity", "clip_text", clipboardManager2.getText().toString());
                }
            }
        } catch (NullPointerException e) {
            com.baidu.tieba.d.ae.b("PostData", "setClipString", e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        a(jSONObject, null);
    }

    public void a(JSONObject jSONObject, Context context) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optString("id");
                this.b = jSONObject.optString("title");
                this.c = jSONObject.optInt("floor", 0);
                this.d = jSONObject.optLong("time", 0L) * 1000;
                this.e = jSONObject.optString("time_ex");
                this.f.a(jSONObject.optJSONObject("author"));
                JSONArray optJSONArray = jSONObject.optJSONArray(PushConstants.EXTRA_CONTENT);
                this.i = jSONObject.optInt("sub_post_number");
                if (context == null) {
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            k kVar = new k();
                            kVar.a(optJSONArray.optJSONObject(i));
                            this.g.add(kVar);
                        }
                    }
                } else {
                    this.k = TbRichTextView.a(context, optJSONArray, true);
                }
                if (this.i > 0) {
                    JSONArray optJSONArray2 = jSONObject.optJSONObject("sub_post_list").optJSONArray("sub_post_list");
                    for (int i2 = 0; i2 < optJSONArray2.length() && i2 < 2; i2++) {
                        ar arVar = new ar();
                        arVar.a(optJSONArray2.getJSONObject(i2), context);
                        this.j.add(arVar);
                    }
                }
            } catch (Exception e) {
                com.baidu.tieba.d.ae.b("PostData", "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
