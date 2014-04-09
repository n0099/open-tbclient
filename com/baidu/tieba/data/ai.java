package com.baidu.tieba.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.ClipboardManager;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class ai extends com.baidu.tbadk.core.util.a {
    private String e;
    private ArrayList<ai> j;
    private ArrayList<ai> l;
    private int n;
    private String o;
    private com.baidu.tbadk.widget.richText.a m = null;
    private String a = null;
    private String b = null;
    private int c = 0;
    private long d = 0;
    private UserData f = new UserData();
    private ArrayList<f> g = new ArrayList<>();
    private ArrayList<f> h = new ArrayList<>();
    private int i = 0;
    private int k = 0;

    public ai() {
        this.j = null;
        this.l = null;
        this.j = new ArrayList<>();
        this.l = new ArrayList<>();
    }

    public final ArrayList<ai> a() {
        return this.j;
    }

    public final void b() {
        this.i--;
    }

    public final void a(int i) {
        this.i = i;
    }

    public final ArrayList<ai> c() {
        return this.l;
    }

    public final String d() {
        return this.a;
    }

    public final void a(String str) {
        this.a = str;
    }

    public final void b(String str) {
        this.b = str;
    }

    public final int e() {
        return this.c;
    }

    public final void b(int i) {
        this.c = 1;
    }

    public final long f() {
        return this.d;
    }

    public final void a(long j) {
        this.d = j;
    }

    public final UserData g() {
        return this.f;
    }

    public final void a(UserData userData) {
        this.f = userData;
    }

    public final com.baidu.tbadk.widget.richText.a h() {
        return this.m;
    }

    public final String i() {
        return this.o;
    }

    public final void a(Context context, boolean z, com.baidu.tbadk.editortool.ab abVar) {
        String str;
        SpannableString spannableString;
        String str2;
        Bitmap a;
        Bitmap h;
        if (context != null && this.m != null && this.m.a() != null) {
            LinkedList<IconData> tShowInfo = this.f.getTShowInfo();
            if (tShowInfo != null) {
                tShowInfo.size();
            }
            String str3 = z ? " [host]" : "";
            int b = com.baidu.adp.lib.util.i.b(context, 15.0f);
            ArrayList arrayList = new ArrayList();
            if (tShowInfo != null && abVar != null) {
                Iterator<IconData> it = tShowInfo.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ImageView.b b2 = abVar.b(it.next().getIcon(), null);
                    if (b2 != null && (h = b2.h()) != null) {
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(h);
                        com.baidu.tieba.p.c();
                        int dimensionPixelSize = com.baidu.tieba.p.d().getApplicationContext().getResources().getDimensionPixelSize(com.baidu.tieba.a.f.small_icon_width);
                        com.baidu.tieba.p.c();
                        bitmapDrawable.setBounds(0, 0, dimensionPixelSize, com.baidu.tieba.p.d().getApplicationContext().getResources().getDimensionPixelSize(com.baidu.tieba.a.f.small_icon_height));
                        arrayList.add(new com.baidu.adp.widget.t(bitmapDrawable, 1));
                    }
                }
            }
            String str4 = "";
            for (int i = 0; i < arrayList.size(); i++) {
                str4 = String.valueOf(str4) + i;
            }
            if (str4.length() > 0) {
                str4 = String.valueOf(str4) + " ";
            }
            if (this.f == null) {
                str = null;
                spannableString = new SpannableString(String.valueOf(str4) + str3 + "：");
                str2 = null;
            } else {
                spannableString = new SpannableString(String.valueOf(str4) + this.f.getName_show() + str3 + "：");
                str = this.f.getUserName();
                str2 = this.f.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            int length = spannableString.length();
            aj ajVar = new aj(this, context, str, str2);
            if (z) {
                if (TbadkApplication.j().l() == 1) {
                    a = com.baidu.tbadk.core.util.g.a(com.baidu.tieba.a.g.icon_floorhost_1);
                } else {
                    a = com.baidu.tbadk.core.util.g.a(com.baidu.tieba.a.g.icon_floorhost);
                }
                if (a != null) {
                    int width = (a.getWidth() * b) / a.getHeight();
                    BitmapDrawable bitmapDrawable2 = new BitmapDrawable(a);
                    bitmapDrawable2.setBounds(0, 0, width, b);
                    ImageSpan imageSpan = new ImageSpan(bitmapDrawable2, 1);
                    if (this.f != null) {
                        spannableString.setSpan(imageSpan, str4.length() + this.f.getName_show().length() + 1, str4.length() + this.f.getName_show().length() + str3.length(), 17);
                    } else {
                        spannableString.setSpan(imageSpan, str4.length(), str4.length() + str3.length(), 17);
                    }
                }
            }
            spannableString.setSpan(ajVar, 0, length, 18);
            ArrayList<com.baidu.tbadk.widget.richText.c> a2 = this.m.a();
            if (a2 != null && a2.size() > 0) {
                com.baidu.tbadk.widget.richText.c cVar = a2.get(0);
                if (cVar.d() != null) {
                    cVar.d().insert(0, (CharSequence) spannableString);
                    return;
                }
                com.baidu.tbadk.widget.richText.c cVar2 = new com.baidu.tbadk.widget.richText.c(768);
                cVar2.a(spannableString);
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < a2.size()) {
                        if (a2.get(i4).a() != 512) {
                            i3 = i4 + 1;
                        } else {
                            cVar2.a(a2.get(i4).e());
                            a2.remove(i4);
                            break;
                        }
                    } else {
                        break;
                    }
                }
                a2.add(0, cVar2);
            }
        }
    }

    public final void a(ArrayList<f> arrayList) {
        this.g = arrayList;
    }

    public final ArrayList<f> j() {
        return this.h;
    }

    public final int k() {
        return this.i;
    }

    public final int l() {
        return this.k;
    }

    public final void a(Context context) {
        int a;
        int i;
        int i2;
        if (this.g != null) {
            int i3 = -1;
            int size = this.h.size();
            if (size > 0) {
                try {
                    i3 = this.h.get(size - 1).a();
                } catch (Exception e) {
                    com.baidu.adp.lib.util.f.b("PostData", "uniteContentExcepFace", "error = " + e.getMessage());
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.g.size()) {
                f fVar = this.g.get(i4);
                if (f.b(i5, fVar.a())) {
                    this.h.get(size - 1).a(fVar.a(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (fVar.a() == 3 || fVar.a() == 2 || fVar.a() == 11) {
                        this.h.add(fVar);
                        a = fVar.a();
                    } else {
                        f fVar2 = new f();
                        fVar2.a(0);
                        fVar2.a(fVar.a(context));
                        this.h.add(fVar2);
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

    public final void b(Context context) {
        int i;
        int i2;
        int i3;
        if (this.g != null) {
            int i4 = -1;
            int size = this.h.size();
            if (size > 0) {
                try {
                    i4 = this.h.get(size - 1).a();
                } catch (Exception e) {
                    com.baidu.adp.lib.util.f.b("PostData", "uniteContent", "error = " + e.getMessage());
                    return;
                }
            }
            int i5 = 0;
            int i6 = i4;
            while (i5 < this.g.size()) {
                f fVar = this.g.get(i5);
                if (f.a(i6, fVar.a())) {
                    this.h.get(size - 1).a(fVar.a(context));
                    i3 = size;
                    i2 = i6;
                } else {
                    if (fVar.a() == 3) {
                        this.h.add(fVar);
                        i = 3;
                    } else if (fVar.a() == 11) {
                        this.h.add(fVar);
                        i = 11;
                    } else {
                        f fVar2 = new f();
                        fVar2.a(0);
                        fVar2.a(fVar.a(context));
                        this.h.add(fVar2);
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

    public final void c(Context context) {
        try {
            if (this.m != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.m.toString());
                if (clipboardManager.getText() != null) {
                    com.baidu.adp.lib.util.f.e(getClass().getName(), "clip_text", clipboardManager.getText().toString());
                    return;
                }
                return;
            }
            if (this.h == null || this.h.size() == 0) {
                a(context);
            }
            ArrayList<f> arrayList = this.h;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<f> it = arrayList.iterator();
                while (it.hasNext()) {
                    f next = it.next();
                    if (next.a() == 0) {
                        if (next.d() != null) {
                            sb.append((CharSequence) next.d());
                        }
                    } else if (next.a() == 3) {
                        if (next.e() != null) {
                            sb.append(context.getString(com.baidu.tieba.a.k.pic));
                        }
                    } else if (next.a() == 2) {
                        String d = TbFaceManager.a().d(next.b());
                        if (d != null) {
                            sb.append("[");
                            sb.append(d);
                            sb.append("]");
                        }
                    } else if (next.a() == 11 && !bc.c(next.c())) {
                        sb.append("[").append(next.c()).append("]");
                    }
                }
                ClipboardManager clipboardManager2 = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager2.setText(sb.toString());
                if (clipboardManager2.getText() != null) {
                    com.baidu.adp.lib.util.f.e("PbActivity", "clip_text", clipboardManager2.getText().toString());
                }
            }
        } catch (NullPointerException e) {
            com.baidu.adp.lib.util.f.b("PostData", "setClipString", e.getMessage());
        }
    }

    public final void a(JSONObject jSONObject) {
        a(jSONObject, null);
    }

    public final void a(JSONObject jSONObject, Context context) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optString("id");
                this.b = jSONObject.optString("title");
                this.c = jSONObject.optInt("floor", 0);
                this.d = jSONObject.optLong("time", 0L) * 1000;
                this.e = jSONObject.optString("time_ex");
                this.f.parserJson(jSONObject.optJSONObject("author"));
                JSONArray optJSONArray = jSONObject.optJSONArray("content");
                this.i = jSONObject.optInt("sub_post_number");
                this.k = jSONObject.optInt("add_post_number");
                if (context == null) {
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            f fVar = new f();
                            fVar.a(optJSONArray.optJSONObject(i));
                            this.g.add(fVar);
                        }
                    }
                } else {
                    this.m = TbRichTextView.a(context, optJSONArray, true);
                }
                if (this.i > 0) {
                    JSONArray optJSONArray2 = jSONObject.optJSONObject("sub_post_list").optJSONArray("sub_post_list");
                    for (int i2 = 0; i2 < optJSONArray2.length() && i2 < 2; i2++) {
                        ai aiVar = new ai();
                        aiVar.a(optJSONArray2.getJSONObject(i2), context);
                        this.j.add(aiVar);
                    }
                }
                if (this.k > 0) {
                    JSONArray optJSONArray3 = jSONObject.optJSONObject("add_post_list").optJSONArray("add_post_list");
                    for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                        ai aiVar2 = new ai();
                        aiVar2.a(optJSONArray3.getJSONObject(i3), context);
                        this.l.add(aiVar2);
                    }
                }
                this.o = jSONObject.optString("bimg_url");
                if (this.l.size() >= 5) {
                    this.n = 5;
                } else {
                    this.n = this.l.size();
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("PostData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.a, com.baidu.tbadk.core.util.ab
    public final boolean isSupportImageSize() {
        return true;
    }

    @Override // com.baidu.tbadk.core.util.a, com.baidu.tbadk.core.util.ab
    public final LinkedList<String> getImageUrl() {
        ArrayList<com.baidu.tbadk.widget.richText.c> a;
        if (this.m == null || (a = this.m.a()) == null) {
            return null;
        }
        LinkedList<String> linkedList = new LinkedList<>();
        Iterator<com.baidu.tbadk.widget.richText.c> it = a.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.a() == 8) {
                linkedList.add(next.c().f());
            }
        }
        int size = this.l.size();
        for (int i = 0; i < size; i++) {
            linkedList.addAll(this.l.get(i).getImageUrl());
        }
        return linkedList;
    }

    @Override // com.baidu.tbadk.core.util.a, com.baidu.tbadk.core.util.ab
    public final LinkedList<com.baidu.tbadk.core.util.aa> getImagesWithEmotions() {
        ArrayList<com.baidu.tbadk.widget.richText.c> a;
        if (this.m == null || (a = this.m.a()) == null) {
            return null;
        }
        LinkedList<com.baidu.tbadk.core.util.aa> linkedList = new LinkedList<>();
        Iterator<com.baidu.tbadk.widget.richText.c> it = a.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.a() == 8) {
                com.baidu.tbadk.core.util.aa aaVar = new com.baidu.tbadk.core.util.aa();
                aaVar.b = next.c().c();
                aaVar.c = next.c().b();
                aaVar.a = next.c().f();
                linkedList.add(aaVar);
            } else if (next.g() != null) {
                com.baidu.tbadk.core.util.aa aaVar2 = new com.baidu.tbadk.core.util.aa();
                aaVar2.b = next.g().f;
                aaVar2.c = next.g().g;
                aaVar2.d = next.g();
                linkedList.add(aaVar2);
            }
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.n) {
                break;
            }
            linkedList.addAll(this.l.get(i2).getImagesWithEmotions());
            i = i2 + 1;
        }
        if (!TextUtils.isEmpty(this.o)) {
            com.baidu.tbadk.core.util.aa aaVar3 = new com.baidu.tbadk.core.util.aa();
            aaVar3.e = this.o;
            linkedList.add(aaVar3);
        }
        return linkedList;
    }

    public final String m() {
        ArrayList<com.baidu.tbadk.widget.richText.c> a;
        String str;
        if (this.m == null || (a = this.m.a()) == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<com.baidu.tbadk.widget.richText.c> it = a.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.a() == 1) {
                stringBuffer.append(next.d().toString());
            } else if (next.a() == 17 && (str = next.g().c) != null && str.startsWith("#(") && str.endsWith(")")) {
                stringBuffer.append("[" + str.substring(2, str.length() - 1) + "]");
            }
        }
        return stringBuffer.toString();
    }

    @Override // com.baidu.tbadk.core.util.a, com.baidu.tbadk.core.util.ab
    public final LinkedList<String> getPhotoUrl() {
        if (this.f == null) {
            return null;
        }
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(this.f.getPortrait());
        if (this.j != null) {
            Iterator<ai> it = this.j.iterator();
            while (it.hasNext()) {
                linkedList.addAll(it.next().getPhotoUrl());
            }
        }
        if (this.l != null) {
            Iterator<ai> it2 = this.l.iterator();
            while (it2.hasNext()) {
                linkedList.addAll(it2.next().getPhotoUrl());
            }
        }
        return linkedList;
    }

    public final int n() {
        return this.n;
    }

    public final void c(int i) {
        this.n = i;
    }
}
