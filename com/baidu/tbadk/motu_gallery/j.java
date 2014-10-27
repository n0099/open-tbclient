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
    final /* synthetic */ JigsawAlbumActivity Wv;
    public List<c> Wx;
    private Context mContext;

    public j(JigsawAlbumActivity jigsawAlbumActivity, Context context) {
        this.Wv = jigsawAlbumActivity;
        this.mContext = context;
    }

    public void p(List<c> list) {
        this.Wx = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Wx != null) {
            return this.Wx.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.Wx == null || i < 0 || i >= this.Wx.size()) {
            return null;
        }
        return this.Wx.get(i);
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
        String str = this.Wx.get(i).path;
        arrayList = this.Wv.We;
        StringBuilder append = new StringBuilder(String.valueOf(str.substring(((c) arrayList.get(i)).path.lastIndexOf("/") + 1))).append("(");
        map = this.Wv.map;
        arrayList2 = this.Wv.We;
        String sb = append.append(String.valueOf(map.get(String.valueOf(((c) arrayList2.get(i)).type)))).append(")").toString();
        JigsawAlbumActivity jigsawAlbumActivity = this.Wv;
        arrayList3 = this.Wv.We;
        cY = jigsawAlbumActivity.cY(((c) arrayList3.get(i)).type);
        kVar.WA.setText(sb);
        kVar.Wy = String.valueOf(i);
        map2 = this.Wv.Wf;
        if (map2.containsKey(cY)) {
            map4 = this.Wv.Wf;
            a = (Bitmap) map4.get(cY);
        } else {
            JigsawAlbumActivity jigsawAlbumActivity2 = this.Wv;
            arrayList4 = this.Wv.We;
            cZ = jigsawAlbumActivity2.cZ(((c) arrayList4.get(i)).type);
            uVar = this.Wv.Wi;
            a = uVar.a(this.Wv, cZ, this.Wv.s(70.0f));
            if (a != null) {
                map3 = this.Wv.Wf;
                map3.put(cY, a);
            }
        }
        kVar.Wz.setImageBitmap(a);
        kVar.Wz.setTag(this.Wx.get(i));
        return view;
    }

    private k s(View view) {
        k kVar = new k(this);
        kVar.Wz = (ImageView) view.findViewById(com.baidu.tieba.v.albums_item_photo_iv);
        kVar.WA = (TextView) view.findViewById(com.baidu.tieba.v.albums_name_tv);
        return kVar;
    }
}
