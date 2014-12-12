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
    final /* synthetic */ JigsawAlbumActivity acF;
    private Context mContext;
    public List<c> mList;

    public j(JigsawAlbumActivity jigsawAlbumActivity, Context context) {
        this.acF = jigsawAlbumActivity;
        this.mContext = context;
    }

    public void t(List<c> list) {
        this.mList = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mList != null) {
            return this.mList.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.mList == null || i < 0 || i >= this.mList.size()) {
            return null;
        }
        return this.mList.get(i);
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
        String dv;
        Map map2;
        ArrayList arrayList4;
        c dw;
        u uVar;
        Bitmap a;
        Map map3;
        Map map4;
        if (view == null) {
            view = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.x.motu_albums_activity_item, null);
            k r = r(view);
            view.setTag(r);
            kVar = r;
        } else {
            kVar = (k) view.getTag();
        }
        String str = this.mList.get(i).path;
        arrayList = this.acF.acn;
        StringBuilder append = new StringBuilder(String.valueOf(str.substring(((c) arrayList.get(i)).path.lastIndexOf("/") + 1))).append("(");
        map = this.acF.map;
        arrayList2 = this.acF.acn;
        String sb = append.append(String.valueOf(map.get(String.valueOf(((c) arrayList2.get(i)).type)))).append(")").toString();
        JigsawAlbumActivity jigsawAlbumActivity = this.acF;
        arrayList3 = this.acF.acn;
        dv = jigsawAlbumActivity.dv(((c) arrayList3.get(i)).type);
        kVar.acJ.setText(sb);
        kVar.acH = String.valueOf(i);
        map2 = this.acF.aco;
        if (map2.containsKey(dv)) {
            map4 = this.acF.aco;
            a = (Bitmap) map4.get(dv);
        } else {
            JigsawAlbumActivity jigsawAlbumActivity2 = this.acF;
            arrayList4 = this.acF.acn;
            dw = jigsawAlbumActivity2.dw(((c) arrayList4.get(i)).type);
            uVar = this.acF.acr;
            a = uVar.a(this.acF.getPageContext().getPageActivity(), dw, this.acF.dip2px(70.0f));
            if (a != null) {
                map3 = this.acF.aco;
                map3.put(dv, a);
            }
        }
        kVar.acI.setImageBitmap(a);
        kVar.acI.setTag(this.mList.get(i));
        return view;
    }

    private k r(View view) {
        k kVar = new k(this);
        kVar.acI = (ImageView) view.findViewById(com.baidu.tieba.w.albums_item_photo_iv);
        kVar.acJ = (TextView) view.findViewById(com.baidu.tieba.w.albums_name_tv);
        return kVar;
    }
}
