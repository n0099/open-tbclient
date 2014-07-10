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
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.bm;
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
public class am implements bg {
    private String e;
    private String g;
    private ArrayList<am> k;
    private ArrayList<am> m;
    private int o;
    private String p;
    private HashMap<String, MetaData> q;
    private b r;
    private com.baidu.tbadk.widget.richText.a n = null;
    private String a = null;
    private String b = null;
    private int c = 0;
    private long d = 0;
    private MetaData f = new MetaData();
    private ArrayList<g> h = new ArrayList<>();
    private ArrayList<g> i = new ArrayList<>();
    private int j = 0;
    private int l = 0;

    public am() {
        this.k = null;
        this.m = null;
        this.k = new ArrayList<>();
        this.m = new ArrayList<>();
    }

    public ArrayList<am> i() {
        return this.k;
    }

    public void j() {
        this.j--;
    }

    public void b(int i) {
        this.j = i;
    }

    public ArrayList<am> k() {
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

    public b r() {
        return this.r;
    }

    public void a(Context context, boolean z, com.baidu.tbadk.editortool.aa aaVar) {
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
            int b = com.baidu.adp.lib.util.j.b(context, 15.0f);
            ArrayList arrayList = new ArrayList();
            int i = TbadkApplication.m252getInst().getSkinType() == 1 ? com.baidu.tieba.u.pic_image_h_not_1 : com.baidu.tieba.u.pic_image_h_not;
            if (tShowInfo != null && aaVar != null) {
                Iterator<IconData> it = tShowInfo.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.r rVar = new com.baidu.adp.widget.r(new an(this, it.next(), aaVar, context), i, 1);
                    rVar.a(0, 0, com.baidu.tieba.ai.c().d().getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_width), com.baidu.tieba.ai.c().d().getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_height));
                    arrayList.add(rVar);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                sb.append(i2);
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.f == null) {
                str = null;
                spannableString = new SpannableString(String.valueOf(sb2) + str3 + "：");
                str2 = null;
            } else {
                spannableString = new SpannableString(String.valueOf(sb2) + this.f.getName_show() + str3 + "：");
                str = this.f.getUserName();
                str2 = this.f.getUserId();
            }
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                spannableString.setSpan(arrayList.get(i3), i3, i3 + 1, 17);
            }
            int length = spannableString.length();
            ap apVar = new ap(this, context, str, str2);
            if (z) {
                if (TbadkApplication.m252getInst().getSkinType() == 1) {
                    a = com.baidu.tbadk.core.util.h.a(com.baidu.tieba.u.icon_floorhost_1);
                } else {
                    a = com.baidu.tbadk.core.util.h.a(com.baidu.tieba.u.icon_floorhost);
                }
                if (a != null) {
                    int width = (a.getWidth() * b) / a.getHeight();
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(a);
                    bitmapDrawable.setBounds(0, 0, width, b);
                    ImageSpan imageSpan = new ImageSpan(bitmapDrawable, 1);
                    if (this.f != null) {
                        spannableString.setSpan(imageSpan, sb2.length() + this.f.getName_show().length() + 1, str3.length() + sb2.length() + this.f.getName_show().length(), 17);
                    } else {
                        spannableString.setSpan(imageSpan, sb2.length(), str3.length() + sb2.length(), 17);
                    }
                }
            }
            spannableString.setSpan(apVar, 0, length, 18);
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

    public void a(ArrayList<g> arrayList) {
        this.h = arrayList;
    }

    public ArrayList<g> s() {
        return this.i;
    }

    public int t() {
        return this.j;
    }

    public int u() {
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
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.h.size()) {
                g gVar = this.h.get(i4);
                if (g.b(i5, gVar.a())) {
                    this.i.get(size - 1).a(gVar.a(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (gVar.a() == 3 || gVar.a() == 2 || gVar.a() == 11) {
                        this.i.add(gVar);
                        a = gVar.a();
                    } else {
                        g gVar2 = new g();
                        gVar2.a(0);
                        gVar2.a(gVar.a(context));
                        this.i.add(gVar2);
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
                    BdLog.detailException(e);
                    return;
                }
            }
            int i5 = 0;
            int i6 = i4;
            while (i5 < this.h.size()) {
                g gVar = this.h.get(i5);
                if (g.a(i6, gVar.a())) {
                    this.i.get(size - 1).a(gVar.a(context));
                    i3 = size;
                    i2 = i6;
                } else {
                    if (gVar.a() == 3) {
                        this.i.add(gVar);
                        i = 3;
                    } else if (gVar.a() == 11) {
                        this.i.add(gVar);
                        i = 11;
                    } else {
                        g gVar2 = new g();
                        gVar2.a(0);
                        gVar2.a(gVar.a(context));
                        this.i.add(gVar2);
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
                clipboardManager.getText();
                return;
            }
            if (this.i == null || this.i.size() == 0) {
                a(context);
            }
            ArrayList<g> arrayList = this.i;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<g> it = arrayList.iterator();
                while (it.hasNext()) {
                    g next = it.next();
                    if (next.a() == 0) {
                        if (next.d() != null) {
                            sb.append((CharSequence) next.d());
                        }
                    } else if (next.a() == 3) {
                        if (next.e() != null) {
                            sb.append(context.getString(com.baidu.tieba.y.pic_str));
                        }
                    } else if (next.a() == 6) {
                        sb.append(context.getString(com.baidu.tieba.y.voice_str));
                    } else if (next.a() == 2) {
                        String d = TbFaceManager.a().d(next.b());
                        if (d != null) {
                            sb.append("[");
                            sb.append(d);
                            sb.append("]");
                        }
                    } else if (next.a() == 11 && !bm.c(next.c())) {
                        sb.append("[").append(next.c()).append("]");
                    }
                }
                ClipboardManager clipboardManager2 = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager2.setText(sb.toString());
                clipboardManager2.getText();
            }
        } catch (NullPointerException e) {
            BdLog.detailException(e);
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
                            g gVar = new g();
                            gVar.a(optJSONArray.optJSONObject(i));
                            this.h.add(gVar);
                        }
                    }
                } else {
                    this.n = TbRichTextView.a(context, optJSONArray, true);
                }
                if (this.j > 0) {
                    JSONArray optJSONArray2 = jSONObject.optJSONObject("sub_post_list").optJSONArray("sub_post_list");
                    for (int i2 = 0; i2 < optJSONArray2.length() && i2 < 2; i2++) {
                        am amVar = new am();
                        amVar.a(this.q);
                        amVar.a(optJSONArray2.getJSONObject(i2), context);
                        this.k.add(amVar);
                    }
                }
                if (this.l > 0) {
                    JSONArray optJSONArray3 = jSONObject.optJSONObject("add_post_list").optJSONArray("add_post_list");
                    for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                        am amVar2 = new am();
                        amVar2.a(this.q);
                        amVar2.a(optJSONArray3.getJSONObject(i3), context);
                        this.m.add(amVar2);
                    }
                }
                this.p = jSONObject.optString("bimg_url");
                if (this.m.size() >= 5) {
                    this.o = 5;
                } else {
                    this.o = this.m.size();
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("tail_info");
                if (optJSONObject != null) {
                    this.r = new b();
                    this.r.a(optJSONObject);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public String d(Context context) {
        ArrayList<com.baidu.tbadk.widget.richText.c> a;
        if (this.n == null || (a = this.n.a()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<com.baidu.tbadk.widget.richText.c> it = a.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.a() == 1) {
                stringBuffer.append(next.d().toString());
            } else if (next.a() == 17) {
                String str = next.g().b.b;
                if (str != null && str.startsWith("#(") && str.endsWith(")")) {
                    stringBuffer.append("[" + str.substring(2, str.length() - 1) + "]");
                }
            } else if (next.a() == 8) {
                stringBuffer.append("[" + context.getString(com.baidu.tieba.y.msglist_image) + "]");
            } else if (next.a() == 512) {
                stringBuffer.append("[" + context.getString(com.baidu.tieba.y.msglist_voice) + "]");
            } else if (next.a() == 32) {
                stringBuffer.append("[" + context.getString(com.baidu.tieba.y.msglist_video) + "]");
            }
        }
        return stringBuffer.toString();
    }

    public int v() {
        return this.o;
    }

    public void d(int i) {
        this.o = i;
    }

    public bf w() {
        ArrayList<com.baidu.tbadk.widget.richText.c> a;
        if (this.n != null && (a = this.n.a()) != null) {
            Iterator<com.baidu.tbadk.widget.richText.c> it = a.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.widget.richText.c next = it.next();
                if (next.a() == 8) {
                    bf bfVar = new bf();
                    bfVar.b = next.c().c();
                    bfVar.c = next.c().b();
                    bfVar.a = next.c().f();
                    bfVar.d = 17;
                    return bfVar;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.bg
    public LinkedList<bf> getImages() {
        ArrayList<com.baidu.tbadk.widget.richText.c> a;
        if (this.n == null || (a = this.n.a()) == null) {
            return null;
        }
        LinkedList<bf> linkedList = new LinkedList<>();
        Iterator<com.baidu.tbadk.widget.richText.c> it = a.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.a() == 8) {
                bf bfVar = new bf();
                bfVar.b = next.c().c();
                bfVar.c = next.c().b();
                bfVar.a = next.c().f();
                bfVar.d = 17;
                linkedList.add(bfVar);
            } else if (next.g() != null) {
                bf bfVar2 = new bf();
                bfVar2.b = next.g().b.f;
                bfVar2.c = next.g().b.g;
                bfVar2.e = next.g();
                bfVar2.d = 20;
                linkedList.add(bfVar2);
            }
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.o) {
                break;
            }
            linkedList.addAll(this.m.get(i2).getImages());
            i = i2 + 1;
        }
        if (!TextUtils.isEmpty(this.p)) {
            bf bfVar3 = new bf();
            bfVar3.a = this.p;
            bfVar3.b = 105;
            bfVar3.b = 105;
            bfVar3.d = 19;
            linkedList.add(bfVar3);
        }
        if (this.f == null) {
            return linkedList;
        }
        bf bfVar4 = new bf();
        bfVar4.a = this.f.getPortrait();
        bfVar4.d = 12;
        linkedList.add(bfVar4);
        if (this.k != null) {
            Iterator<am> it2 = this.k.iterator();
            while (it2.hasNext()) {
                linkedList.addAll(it2.next().getImages());
            }
        }
        if (this.m != null) {
            Iterator<am> it3 = this.m.iterator();
            while (it3.hasNext()) {
                linkedList.addAll(it3.next().getImages());
            }
        }
        return linkedList;
    }
}
