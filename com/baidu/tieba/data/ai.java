package com.baidu.tieba.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.ClipboardManager;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ai extends com.baidu.tbadk.core.util.a {
    private String e;
    private String g;
    private ArrayList<ai> k;
    private ArrayList<ai> m;
    private int o;
    private String p;
    private HashMap<String, MetaData> q;
    private com.baidu.tbadk.widget.richText.a n = null;
    private String a = null;
    private String b = null;
    private int c = 0;
    private long d = 0;
    private MetaData f = new MetaData();
    private ArrayList<f> h = new ArrayList<>();
    private ArrayList<f> i = new ArrayList<>();
    private int j = 0;
    private int l = 0;

    public ai() {
        this.k = null;
        this.m = null;
        this.k = new ArrayList<>();
        this.m = new ArrayList<>();
    }

    public ArrayList<ai> i() {
        return this.k;
    }

    public void j() {
        this.j--;
    }

    public void b(int i) {
        this.j = i;
    }

    public ArrayList<ai> k() {
        return this.m;
    }

    public void a(HashMap<String, MetaData> hashMap) {
        this.q = hashMap;
    }

    public String l() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    public void b(String str) {
        this.b = str;
    }

    public int m() {
        return this.c;
    }

    public void c(int i) {
        this.c = i;
    }

    public long n() {
        return this.d;
    }

    public void a(long j) {
        this.d = j;
    }

    public MetaData o() {
        return this.f;
    }

    public void a(MetaData metaData) {
        this.f = metaData;
    }

    public com.baidu.tbadk.widget.richText.a p() {
        return this.n;
    }

    public String q() {
        return this.p;
    }

    public void a(Context context, boolean z, com.baidu.tbadk.editortool.ab abVar) {
        String str;
        SpannableString spannableString;
        String str2;
        Bitmap a;
        if (context != null && this.n != null && this.n.a() != null) {
            LinkedList<IconData> tShowInfo = o().getTShowInfo();
            if (tShowInfo != null) {
                tShowInfo.size();
            }
            String str3 = z ? " [host]" : "";
            int b = com.baidu.adp.lib.util.k.b(context, 15.0f);
            ArrayList arrayList = new ArrayList();
            int i = TbadkApplication.m252getInst().getSkinType() == 1 ? com.baidu.tieba.u.pic_image_h_not_1 : com.baidu.tieba.u.pic_image_h_not;
            if (tShowInfo != null && abVar != null) {
                Iterator<IconData> it = tShowInfo.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.r rVar = new com.baidu.adp.widget.r(new aj(this, it.next(), abVar, context), i, 1);
                    rVar.a(0, 0, com.baidu.tieba.ai.c().d().getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_width), com.baidu.tieba.ai.c().d().getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_height));
                    arrayList.add(rVar);
                }
            }
            String str4 = "";
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                str4 = String.valueOf(str4) + i2;
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
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                spannableString.setSpan(arrayList.get(i3), i3, i3 + 1, 17);
            }
            int length = spannableString.length();
            al alVar = new al(this, context, str, str2);
            if (z) {
                if (TbadkApplication.m252getInst().getSkinType() == 1) {
                    a = com.baidu.tbadk.core.util.g.a(com.baidu.tieba.u.icon_floorhost_1);
                } else {
                    a = com.baidu.tbadk.core.util.g.a(com.baidu.tieba.u.icon_floorhost);
                }
                if (a != null) {
                    int width = (a.getWidth() * b) / a.getHeight();
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(a);
                    bitmapDrawable.setBounds(0, 0, width, b);
                    ImageSpan imageSpan = new ImageSpan(bitmapDrawable, 1);
                    if (this.f != null) {
                        spannableString.setSpan(imageSpan, str4.length() + this.f.getName_show().length() + 1, str3.length() + str4.length() + this.f.getName_show().length(), 17);
                    } else {
                        spannableString.setSpan(imageSpan, str4.length(), str3.length() + str4.length(), 17);
                    }
                }
            }
            spannableString.setSpan(alVar, 0, length, 18);
            ArrayList<com.baidu.tbadk.widget.richText.c> a2 = this.n.a();
            if (a2 != null && a2.size() > 0) {
                com.baidu.tbadk.widget.richText.c cVar = a2.get(0);
                if (cVar.d() != null) {
                    cVar.d().insert(0, (CharSequence) spannableString);
                    return;
                }
                com.baidu.tbadk.widget.richText.c cVar2 = new com.baidu.tbadk.widget.richText.c(768);
                cVar2.a(spannableString);
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 < a2.size()) {
                        if (a2.get(i5).a() != 512) {
                            i4 = i5 + 1;
                        } else {
                            cVar2.a(a2.get(i5).e());
                            a2.remove(i5);
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

    /* JADX INFO: Access modifiers changed from: protected */
    public Drawable a(com.baidu.adp.widget.a.a aVar) {
        Bitmap h;
        if (aVar == null || (h = aVar.h()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(h);
        bitmapDrawable.setBounds(0, 0, com.baidu.tieba.ai.c().d().getApplicationContext().getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_width), com.baidu.tieba.ai.c().d().getApplicationContext().getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_height));
        return bitmapDrawable;
    }

    public void a(ArrayList<f> arrayList) {
        this.h = arrayList;
    }

    public ArrayList<f> r() {
        return this.i;
    }

    public int s() {
        return this.j;
    }

    public int t() {
        return this.l;
    }

    public void a(Context context) {
        int a;
        int i;
        int i2;
        if (this.h != null) {
            int i3 = -1;
            int size = this.i.size();
            if (size > 0) {
                try {
                    i3 = this.i.get(size - 1).a();
                } catch (Exception e) {
                    BdLog.e("PostData", "uniteContentExcepFace", "error = " + e.getMessage());
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.h.size()) {
                f fVar = this.h.get(i4);
                if (f.b(i5, fVar.a())) {
                    this.i.get(size - 1).a(fVar.a(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (fVar.a() == 3 || fVar.a() == 2 || fVar.a() == 11) {
                        this.i.add(fVar);
                        a = fVar.a();
                    } else {
                        f fVar2 = new f();
                        fVar2.a(0);
                        fVar2.a(fVar.a(context));
                        this.i.add(fVar2);
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

    public void b(Context context) {
        int i;
        int i2;
        int i3;
        if (this.h != null) {
            int i4 = -1;
            int size = this.i.size();
            if (size > 0) {
                try {
                    i4 = this.i.get(size - 1).a();
                } catch (Exception e) {
                    BdLog.e("PostData", "uniteContent", "error = " + e.getMessage());
                    return;
                }
            }
            int i5 = 0;
            int i6 = i4;
            while (i5 < this.h.size()) {
                f fVar = this.h.get(i5);
                if (f.a(i6, fVar.a())) {
                    this.i.get(size - 1).a(fVar.a(context));
                    i3 = size;
                    i2 = i6;
                } else {
                    if (fVar.a() == 3) {
                        this.i.add(fVar);
                        i = 3;
                    } else if (fVar.a() == 11) {
                        this.i.add(fVar);
                        i = 11;
                    } else {
                        f fVar2 = new f();
                        fVar2.a(0);
                        fVar2.a(fVar.a(context));
                        this.i.add(fVar2);
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

    public void c(Context context) {
        try {
            if (this.n != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.n.toString());
                if (clipboardManager.getText() != null) {
                    BdLog.d(getClass().getName(), "clip_text", clipboardManager.getText().toString());
                    return;
                }
                return;
            }
            if (this.i == null || this.i.size() == 0) {
                a(context);
            }
            ArrayList<f> arrayList = this.i;
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
                            sb.append(context.getString(com.baidu.tieba.y.pic));
                        }
                    } else if (next.a() == 2) {
                        String d = TbFaceManager.a().d(next.b());
                        if (d != null) {
                            sb.append("[");
                            sb.append(d);
                            sb.append("]");
                        }
                    } else if (next.a() == 11 && !bg.c(next.c())) {
                        sb.append("[").append(next.c()).append("]");
                    }
                }
                ClipboardManager clipboardManager2 = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager2.setText(sb.toString());
                if (clipboardManager2.getText() != null) {
                    BdLog.d("PbActivity", "clip_text", clipboardManager2.getText().toString());
                }
            }
        } catch (NullPointerException e) {
            BdLog.e("PostData", "setClipString", e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        a(jSONObject, null);
    }

    public void a(JSONObject jSONObject, Context context) {
        MetaData metaData;
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optString("id");
                this.b = jSONObject.optString("title");
                this.c = jSONObject.optInt("floor", 0);
                this.d = jSONObject.optLong("time", 0L) * 1000;
                this.e = jSONObject.optString("time_ex");
                MetaData metaData2 = new MetaData();
                metaData2.parserJson(jSONObject.optJSONObject("author"));
                this.g = jSONObject.optString("author_id");
                if (this.g != null && this.g.length() > 0 && !this.g.equals("0") && (metaData = this.q.get(this.g)) != null) {
                    this.f = metaData;
                }
                if ((this.f.getUserId() == null || this.f.getUserId().length() <= 0 || this.f.getUserId().equals("0")) && metaData2 != null) {
                    this.f = metaData2;
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("content");
                this.j = jSONObject.optInt("sub_post_number");
                this.l = jSONObject.optInt("add_post_number");
                if (context == null) {
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            f fVar = new f();
                            fVar.a(optJSONArray.optJSONObject(i));
                            this.h.add(fVar);
                        }
                    }
                } else {
                    this.n = TbRichTextView.a(context, optJSONArray, true);
                }
                if (this.j > 0) {
                    JSONArray optJSONArray2 = jSONObject.optJSONObject("sub_post_list").optJSONArray("sub_post_list");
                    for (int i2 = 0; i2 < optJSONArray2.length() && i2 < 2; i2++) {
                        ai aiVar = new ai();
                        aiVar.a(this.q);
                        aiVar.a(optJSONArray2.getJSONObject(i2), context);
                        this.k.add(aiVar);
                    }
                }
                if (this.l > 0) {
                    JSONArray optJSONArray3 = jSONObject.optJSONObject("add_post_list").optJSONArray("add_post_list");
                    for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                        ai aiVar2 = new ai();
                        aiVar2.a(this.q);
                        aiVar2.a(optJSONArray3.getJSONObject(i3), context);
                        this.m.add(aiVar2);
                    }
                }
                this.p = jSONObject.optString("bimg_url");
                if (this.m.size() >= 5) {
                    this.o = 5;
                } else {
                    this.o = this.m.size();
                }
            } catch (Exception e) {
                BdLog.e("PostData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.a, com.baidu.tbadk.core.util.af
    public boolean isSupportImageSize() {
        return true;
    }

    @Override // com.baidu.tbadk.core.util.a, com.baidu.tbadk.core.util.af
    public LinkedList<String> getImageUrl() {
        ArrayList<com.baidu.tbadk.widget.richText.c> a;
        if (this.n == null || (a = this.n.a()) == null) {
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
        int size = this.m.size();
        for (int i = 0; i < size; i++) {
            linkedList.addAll(this.m.get(i).getImageUrl());
        }
        return linkedList;
    }

    @Override // com.baidu.tbadk.core.util.a, com.baidu.tbadk.core.util.af
    public LinkedList<com.baidu.tbadk.core.util.ab> getImagesWithEmotions() {
        ArrayList<com.baidu.tbadk.widget.richText.c> a;
        if (this.n == null || (a = this.n.a()) == null) {
            return null;
        }
        LinkedList<com.baidu.tbadk.core.util.ab> linkedList = new LinkedList<>();
        Iterator<com.baidu.tbadk.widget.richText.c> it = a.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.a() == 8) {
                com.baidu.tbadk.core.util.ab abVar = new com.baidu.tbadk.core.util.ab();
                abVar.b = next.c().c();
                abVar.c = next.c().b();
                abVar.a = next.c().f();
                linkedList.add(abVar);
            } else if (next.g() != null) {
                com.baidu.tbadk.core.util.ab abVar2 = new com.baidu.tbadk.core.util.ab();
                abVar2.b = next.g().b.f;
                abVar2.c = next.g().b.g;
                abVar2.d = next.g();
                linkedList.add(abVar2);
            }
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.o) {
                break;
            }
            linkedList.addAll(this.m.get(i2).getImagesWithEmotions());
            i = i2 + 1;
        }
        if (!TextUtils.isEmpty(this.p)) {
            com.baidu.tbadk.core.util.ab abVar3 = new com.baidu.tbadk.core.util.ab();
            abVar3.e = this.p;
            linkedList.add(abVar3);
        }
        return linkedList;
    }

    public String u() {
        ArrayList<com.baidu.tbadk.widget.richText.c> a;
        String str;
        if (this.n == null || (a = this.n.a()) == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<com.baidu.tbadk.widget.richText.c> it = a.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.a() == 1) {
                stringBuffer.append(next.d().toString());
            } else if (next.a() == 17 && (str = next.g().b.b) != null && str.startsWith("#(") && str.endsWith(")")) {
                stringBuffer.append("[" + str.substring(2, str.length() - 1) + "]");
            }
        }
        return stringBuffer.toString();
    }

    @Override // com.baidu.tbadk.core.util.a, com.baidu.tbadk.core.util.af
    public LinkedList<String> getPhotoUrl() {
        if (this.f == null) {
            return null;
        }
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(this.f.getPortrait());
        if (this.k != null) {
            Iterator<ai> it = this.k.iterator();
            while (it.hasNext()) {
                linkedList.addAll(it.next().getPhotoUrl());
            }
        }
        if (this.m != null) {
            Iterator<ai> it2 = this.m.iterator();
            while (it2.hasNext()) {
                linkedList.addAll(it2.next().getPhotoUrl());
            }
        }
        return linkedList;
    }

    public int v() {
        return this.o;
    }

    public void d(int i) {
        this.o = i;
    }
}
