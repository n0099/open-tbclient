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
    public List<c> WB;
    final /* synthetic */ JigsawAlbumActivity Wz;
    private Context mContext;

    public j(JigsawAlbumActivity jigsawAlbumActivity, Context context) {
        this.Wz = jigsawAlbumActivity;
        this.mContext = context;
    }

    public void p(List<c> list) {
        this.WB = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.WB != null) {
            return this.WB.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.WB == null || i < 0 || i >= this.WB.size()) {
            return null;
        }
        return this.WB.get(i);
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
        String cY;
        Map map2;
        ArrayList arrayList4;
        c cZ;
        u uVar;
        Bitmap a;
        Map map3;
        Map map4;
        if (view == null) {
            view = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.motu_albums_activity_item, null);
            k s = s(view);
            view.setTag(s);
            kVar = s;
        } else {
            kVar = (k) view.getTag();
        }
        String str = this.WB.get(i).path;
        arrayList = this.Wz.Wi;
        StringBuilder append = new StringBuilder(String.valueOf(str.substring(((c) arrayList.get(i)).path.lastIndexOf("/") + 1))).append("(");
        map = this.Wz.map;
        arrayList2 = this.Wz.Wi;
        String sb = append.append(String.valueOf(map.get(String.valueOf(((c) arrayList2.get(i)).type)))).append(")").toString();
        JigsawAlbumActivity jigsawAlbumActivity = this.Wz;
        arrayList3 = this.Wz.Wi;
        cY = jigsawAlbumActivity.cY(((c) arrayList3.get(i)).type);
        kVar.WE.setText(sb);
        kVar.WC = String.valueOf(i);
        map2 = this.Wz.Wj;
        if (map2.containsKey(cY)) {
            map4 = this.Wz.Wj;
            a = (Bitmap) map4.get(cY);
        } else {
            JigsawAlbumActivity jigsawAlbumActivity2 = this.Wz;
            arrayList4 = this.Wz.Wi;
            cZ = jigsawAlbumActivity2.cZ(((c) arrayList4.get(i)).type);
            uVar = this.Wz.Wm;
            a = uVar.a(this.Wz, cZ, this.Wz.s(70.0f));
            if (a != null) {
                map3 = this.Wz.Wj;
                map3.put(cY, a);
            }
        }
        kVar.WD.setImageBitmap(a);
        kVar.WD.setTag(this.WB.get(i));
        return view;
    }

    private k s(View view) {
        k kVar = new k(this);
        kVar.WD = (ImageView) view.findViewById(com.baidu.tieba.v.albums_item_photo_iv);
        kVar.WE = (TextView) view.findViewById(com.baidu.tieba.v.albums_name_tv);
        return kVar;
    }
}
