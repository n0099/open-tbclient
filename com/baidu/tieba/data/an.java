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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.AddPostList;
import tbclient.Post;
import tbclient.SubPost;
import tbclient.SubPostList;
/* loaded from: classes.dex */
public class an implements com.baidu.tbadk.core.util.av {
    private String e;
    private String g;
    private ArrayList<an> k;
    private ArrayList<an> m;
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

    public an() {
        this.k = null;
        this.m = null;
        this.k = new ArrayList<>();
        this.m = new ArrayList<>();
    }

    public ArrayList<an> n_() {
        return this.k;
    }

    public void b() {
        this.j--;
    }

    public void a_(int i) {
        this.j = i;
    }

    public ArrayList<an> c() {
        return this.m;
    }

    public void a(HashMap<String, MetaData> hashMap) {
        this.q = hashMap;
    }

    public String d() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    public void b(String str) {
        this.b = str;
    }

    public int e() {
        return this.c;
    }

    public void b(int i) {
        this.c = i;
    }

    public long o_() {
        return this.d;
    }

    public void a(long j) {
        this.d = j;
    }

    public MetaData g() {
        return this.f;
    }

    public void a(MetaData metaData) {
        this.f = metaData;
    }

    public com.baidu.tbadk.widget.richText.a h() {
        return this.n;
    }

    public String i() {
        return this.p;
    }

    public b j() {
        return this.r;
    }

    public void a(Context context, boolean z) {
        String str;
        SpannableString spannableString;
        String str2;
        Bitmap a;
        if (context != null && this.n != null && this.n.a() != null) {
            LinkedList<IconData> tShowInfo = g().getTShowInfo();
            if (tShowInfo != null) {
                tShowInfo.size();
            }
            String str3 = z ? " [host]" : "";
            int b = com.baidu.adp.lib.util.j.b(context, 15.0f);
            ArrayList arrayList = new ArrayList();
            int i = TbadkApplication.m252getInst().getSkinType() == 1 ? com.baidu.tieba.t.pic_image_h_not_1 : com.baidu.tieba.t.pic_image_h_not;
            if (tShowInfo != null) {
                Iterator<IconData> it = tShowInfo.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.r rVar = new com.baidu.adp.widget.r(new ao(this, it.next(), context), i, 1);
                    rVar.a(0, 0, com.baidu.tieba.ai.c().d().getResources().getDimensionPixelSize(com.baidu.tieba.s.small_icon_width), com.baidu.tieba.ai.c().d().getResources().getDimensionPixelSize(com.baidu.tieba.s.small_icon_height));
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
            aq aqVar = new aq(this, context, str, str2);
            if (z) {
                if (TbadkApplication.m252getInst().getSkinType() == 1) {
                    a = com.baidu.tbadk.core.util.d.a(com.baidu.tieba.t.icon_floorhost_1);
                } else {
                    a = com.baidu.tbadk.core.util.d.a(com.baidu.tieba.t.icon_floorhost);
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
            spannableString.setSpan(aqVar, 0, length, 18);
            ArrayList<com.baidu.tbadk.widget.richText.c> a2 = this.n.a();
            if (a2 != null && a2.size() > 0) {
                com.baidu.tbadk.widget.richText.c cVar = a2.get(0);
                if (cVar.d() != null) {
                    cVar.a(sb.length());
                    cVar.d().insert(0, (CharSequence) spannableString);
                    return;
                }
                com.baidu.tbadk.widget.richText.c cVar2 = new com.baidu.tbadk.widget.richText.c(768);
                cVar2.a(sb.length());
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
        bitmapDrawable.setBounds(0, 0, com.baidu.tieba.ai.c().d().getApplicationContext().getResources().getDimensionPixelSize(com.baidu.tieba.s.small_icon_width), com.baidu.tieba.ai.c().d().getApplicationContext().getResources().getDimensionPixelSize(com.baidu.tieba.s.small_icon_height));
        return bitmapDrawable;
    }

    public void a(ArrayList<g> arrayList) {
        this.h = arrayList;
    }

    public ArrayList<g> k() {
        return this.i;
    }

    public int l() {
        return this.j;
    }

    public int m() {
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
                            sb.append(context.getString(com.baidu.tieba.x.pic_str));
                        }
                    } else if (next.a() == 6) {
                        sb.append(context.getString(com.baidu.tieba.x.voice_str));
                    } else if (next.a() == 2) {
                        String d = TbFaceManager.a().d(next.b());
                        if (d != null) {
                            sb.append("[");
                            sb.append(d);
                            sb.append("]");
                        }
                    } else if (next.a() == 11 && !ba.c(next.c())) {
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
        a(jSONObject, (Context) null);
    }

    public void a(SubPostList subPostList, Context context) {
        a(subPostList, context, false);
    }

    public void a(SubPostList subPostList, Context context, boolean z) {
        MetaData metaData;
        if (subPostList != null) {
            try {
                this.a = String.valueOf(subPostList.id);
                this.b = subPostList.title;
                this.c = subPostList.floor.intValue();
                this.d = subPostList.time.intValue() * 1000;
                this.g = String.valueOf(subPostList.author_id);
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.g != null && this.g.length() > 0 && !this.g.equals("0") && (metaData = this.q.get(this.g)) != null) {
                    this.f = metaData;
                }
                if ((this.f.getUserId() == null || this.f.getUserId().length() <= 0 || this.f.getUserId().equals("0")) && metaData2 != null) {
                    this.f = metaData2;
                }
                this.n = TbRichTextView.a(context, subPostList.content, z);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
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
                        an anVar = new an();
                        anVar.a(this.q);
                        anVar.a(optJSONArray2.getJSONObject(i2), context);
                        this.k.add(anVar);
                    }
                }
                if (this.l > 0) {
                    JSONArray optJSONArray3 = jSONObject.optJSONObject("add_post_list").optJSONArray("add_post_list");
                    for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                        an anVar2 = new an();
                        anVar2.a(this.q);
                        anVar2.a(optJSONArray3.getJSONObject(i3), context);
                        this.m.add(anVar2);
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

    public void a(Post post, Context context) {
        if (post != null) {
            try {
                this.a = String.valueOf(post.id);
                this.b = post.title;
                this.c = post.floor.intValue();
                this.d = post.time.intValue() * 1000;
                this.e = post.time_ex;
                this.g = String.valueOf(post.author_id);
                if (this.g != null && this.g.length() > 0 && !this.g.equals("0")) {
                    MetaData metaData = this.q.get(this.g);
                    if (metaData != null) {
                        this.f = metaData;
                    }
                } else {
                    this.f.parserProtobuf(post.author);
                }
                this.j = post.sub_post_number.intValue();
                this.l = post.add_post_number.intValue();
                this.n = TbRichTextView.a(context, post.content, true);
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size() && i < 2; i++) {
                            an anVar = new an();
                            anVar.a(this.q);
                            anVar.a(list.get(i), context);
                            this.k.add(anVar);
                        }
                    }
                }
                AddPostList addPostList = post.add_post_list;
                if (addPostList != null) {
                    List<SubPostList> list2 = addPostList.add_post_list;
                    if (list2.size() > 0) {
                        for (SubPostList subPostList : list2) {
                            an anVar2 = new an();
                            anVar2.a(this.q);
                            anVar2.a(subPostList, context);
                            this.m.add(anVar2);
                        }
                    }
                }
                this.p = post.bimg_url;
                if (this.m.size() >= 5) {
                    this.o = 5;
                } else {
                    this.o = this.m.size();
                }
                if (post.tail_info != null) {
                    this.r = new b();
                    this.r.a(post.tail_info);
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
                stringBuffer.append("[" + context.getString(com.baidu.tieba.x.msglist_image) + "]");
            } else if (next.a() == 512) {
                stringBuffer.append("[" + context.getString(com.baidu.tieba.x.msglist_voice) + "]");
            } else if (next.a() == 32) {
                stringBuffer.append("[" + context.getString(com.baidu.tieba.x.msglist_video) + "]");
            }
        }
        return stringBuffer.toString();
    }

    public int n() {
        return this.o;
    }

    public void c(int i) {
        this.o = i;
    }

    public com.baidu.tbadk.core.util.au o() {
        ArrayList<com.baidu.tbadk.widget.richText.c> a;
        if (this.n != null && (a = this.n.a()) != null) {
            Iterator<com.baidu.tbadk.widget.richText.c> it = a.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.widget.richText.c next = it.next();
                if (next.a() == 8) {
                    com.baidu.tbadk.core.util.au auVar = new com.baidu.tbadk.core.util.au();
                    auVar.b = next.c().c();
                    auVar.c = next.c().b();
                    auVar.a = next.c().f();
                    auVar.d = 17;
                    return auVar;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.av
    public LinkedList<com.baidu.tbadk.core.util.au> getImages() {
        ArrayList<com.baidu.tbadk.widget.richText.c> a;
        if (this.n == null || (a = this.n.a()) == null) {
            return null;
        }
        LinkedList<com.baidu.tbadk.core.util.au> linkedList = new LinkedList<>();
        Iterator<com.baidu.tbadk.widget.richText.c> it = a.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.a() == 8) {
                com.baidu.tbadk.core.util.au auVar = new com.baidu.tbadk.core.util.au();
                auVar.b = next.c().c();
                auVar.c = next.c().b();
                auVar.a = next.c().f();
                auVar.d = 17;
                linkedList.add(auVar);
            } else if (next.g() != null) {
                com.baidu.tbadk.core.util.au auVar2 = new com.baidu.tbadk.core.util.au();
                auVar2.b = next.g().b.f;
                auVar2.c = next.g().b.g;
                auVar2.e = next.g();
                auVar2.d = 20;
                linkedList.add(auVar2);
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
            com.baidu.tbadk.core.util.au auVar3 = new com.baidu.tbadk.core.util.au();
            auVar3.a = this.p;
            auVar3.b = 105;
            auVar3.b = 105;
            auVar3.d = 19;
            linkedList.add(auVar3);
        }
        if (this.f == null) {
            return linkedList;
        }
        com.baidu.tbadk.core.util.au auVar4 = new com.baidu.tbadk.core.util.au();
        auVar4.a = this.f.getPortrait();
        auVar4.d = 12;
        linkedList.add(auVar4);
        if (this.k != null) {
            Iterator<an> it2 = this.k.iterator();
            while (it2.hasNext()) {
                linkedList.addAll(it2.next().getImages());
            }
        }
        if (this.m != null) {
            Iterator<an> it3 = this.m.iterator();
            while (it3.hasNext()) {
                linkedList.addAll(it3.next().getImages());
            }
        }
        return linkedList;
    }
}
