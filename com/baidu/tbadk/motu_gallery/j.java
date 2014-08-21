package com.baidu.tbadk.motu_gallery;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class j extends BaseAdapter {
    public List<c> a;
    final /* synthetic */ JigsawAlbumActivity b;
    private Context c;

    public j(JigsawAlbumActivity jigsawAlbumActivity, Context context) {
        this.b = jigsawAlbumActivity;
        this.c = context;
    }

    public void a(List<c> list) {
        this.a = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.a != null) {
            return this.a.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.a == null || i < 0 || i >= this.a.size()) {
            return null;
        }
        return this.a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        k kVar;
        ArrayList arrayList;
        Map map;
        ArrayList arrayList2;
        ArrayList arrayList3;
        String a;
        Map map2;
        ArrayList arrayList4;
        c b;
        u uVar;
        Bitmap a2;
        Map map3;
        Map map4;
        if (view == null) {
            view = com.baidu.adp.lib.e.b.a().a(this.c, com.baidu.tieba.v.motu_albums_activity_item, null);
            k a3 = a(view);
            view.setTag(a3);
            kVar = a3;
        } else {
            kVar = (k) view.getTag();
        }
        String str = this.a.get(i).b;
        arrayList = this.b.f;
        StringBuilder append = new StringBuilder(String.valueOf(str.substring(((c) arrayList.get(i)).b.lastIndexOf("/") + 1))).append("(");
        map = this.b.g;
        arrayList2 = this.b.f;
        String sb = append.append(String.valueOf(map.get(String.valueOf(((c) arrayList2.get(i)).a)))).append(")").toString();
        JigsawAlbumActivity jigsawAlbumActivity = this.b;
        arrayList3 = this.b.f;
        a = jigsawAlbumActivity.a(((c) arrayList3.get(i)).a);
        kVar.c.setText(sb);
        kVar.a = String.valueOf(i);
        map2 = this.b.h;
        if (map2.containsKey(a)) {
            map4 = this.b.h;
            a2 = (Bitmap) map4.get(a);
        } else {
            JigsawAlbumActivity jigsawAlbumActivity2 = this.b;
            arrayList4 = this.b.f;
            b = jigsawAlbumActivity2.b(((c) arrayList4.get(i)).a);
            uVar = this.b.k;
            a2 = uVar.a(this.b, b, this.b.a(70.0f));
            if (a2 != null) {
                map3 = this.b.h;
                map3.put(a, a2);
            }
        }
        kVar.b.setImageBitmap(a2);
        kVar.b.setTag(this.a.get(i));
        return view;
    }

    private k a(View view) {
        k kVar = new k(this);
        kVar.b = (ImageView) view.findViewById(com.baidu.tieba.u.albums_item_photo_iv);
        kVar.c = (TextView) view.findViewById(com.baidu.tieba.u.albums_name_tv);
        return kVar;
    }
}
