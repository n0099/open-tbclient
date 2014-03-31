package com.baidu.tbadk.motu_gallery;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class k extends BaseAdapter {
    public List<c> a;
    final /* synthetic */ d b;
    private Context c;

    public k(d dVar, Context context) {
        this.b = dVar;
        this.c = context;
    }

    public final void a(List<c> list) {
        this.a = list;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        if (this.a != null) {
            return this.a.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        if (this.a == null || i < 0 || i >= this.a.size()) {
            return null;
        }
        return this.a.get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        l lVar;
        ArrayList arrayList;
        Map map;
        ArrayList arrayList2;
        ArrayList arrayList3;
        Map map2;
        ArrayList arrayList4;
        Bitmap a;
        Map map3;
        Map map4;
        w unused;
        if (view == null) {
            view = LayoutInflater.from(this.c).inflate(com.baidu.tbadk.k.motu_albums_activity_item, (ViewGroup) null);
            lVar = new l(this);
            lVar.b = (ImageView) view.findViewById(com.baidu.tbadk.j.albums_item_photo_iv);
            lVar.c = (TextView) view.findViewById(com.baidu.tbadk.j.albums_name_tv);
            view.setTag(lVar);
        } else {
            lVar = (l) view.getTag();
        }
        String str = this.a.get(i).b;
        arrayList = this.b.f;
        StringBuilder append = new StringBuilder(String.valueOf(str.substring(((c) arrayList.get(i)).b.lastIndexOf("/") + 1))).append("(");
        map = this.b.g;
        arrayList2 = this.b.f;
        String sb = append.append(String.valueOf(map.get(String.valueOf(((c) arrayList2.get(i)).a)))).append(")").toString();
        d dVar = this.b;
        arrayList3 = this.b.f;
        String b = d.b(dVar, ((c) arrayList3.get(i)).a);
        lVar.c.setText(sb);
        lVar.a = String.valueOf(i);
        map2 = this.b.h;
        if (map2.containsKey(b)) {
            map4 = this.b.h;
            a = (Bitmap) map4.get(b);
        } else {
            d dVar2 = this.b;
            arrayList4 = this.b.f;
            c a2 = d.a(dVar2, ((c) arrayList4.get(i)).a);
            unused = this.b.k;
            a = w.a(this.b, a2, this.b.a(70.0f));
            if (a != null) {
                map3 = this.b.h;
                map3.put(b, a);
            }
        }
        lVar.b.setImageBitmap(a);
        lVar.b.setTag(this.a.get(i));
        return view;
    }
}
