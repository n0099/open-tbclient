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
    final /* synthetic */ JigsawAlbumActivity acZ;
    private Context mContext;
    public List<c> mList;

    public j(JigsawAlbumActivity jigsawAlbumActivity, Context context) {
        this.acZ = jigsawAlbumActivity;
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
        String dB;
        Map map2;
        ArrayList arrayList4;
        c dC;
        u uVar;
        Bitmap a;
        Map map3;
        Map map4;
        if (view == null) {
            view = com.baidu.adp.lib.g.b.ei().inflate(this.mContext, com.baidu.tieba.x.motu_albums_activity_item, null);
            k r = r(view);
            view.setTag(r);
            kVar = r;
        } else {
            kVar = (k) view.getTag();
        }
        String str = this.mList.get(i).path;
        arrayList = this.acZ.acI;
        StringBuilder append = new StringBuilder(String.valueOf(str.substring(((c) arrayList.get(i)).path.lastIndexOf("/") + 1))).append("(");
        map = this.acZ.map;
        arrayList2 = this.acZ.acI;
        String sb = append.append(String.valueOf(map.get(String.valueOf(((c) arrayList2.get(i)).type)))).append(")").toString();
        JigsawAlbumActivity jigsawAlbumActivity = this.acZ;
        arrayList3 = this.acZ.acI;
        dB = jigsawAlbumActivity.dB(((c) arrayList3.get(i)).type);
        kVar.ade.setText(sb);
        kVar.adb = String.valueOf(i);
        map2 = this.acZ.acJ;
        if (map2.containsKey(dB)) {
            map4 = this.acZ.acJ;
            a = (Bitmap) map4.get(dB);
        } else {
            JigsawAlbumActivity jigsawAlbumActivity2 = this.acZ;
            arrayList4 = this.acZ.acI;
            dC = jigsawAlbumActivity2.dC(((c) arrayList4.get(i)).type);
            uVar = this.acZ.acM;
            a = uVar.a(this.acZ.getPageContext().getPageActivity(), dC, this.acZ.t(70.0f));
            if (a != null) {
                map3 = this.acZ.acJ;
                map3.put(dB, a);
            }
        }
        kVar.adc.setImageBitmap(a);
        kVar.adc.setTag(this.mList.get(i));
        return view;
    }

    private k r(View view) {
        k kVar = new k(this);
        kVar.adc = (ImageView) view.findViewById(com.baidu.tieba.w.albums_item_photo_iv);
        kVar.ade = (TextView) view.findViewById(com.baidu.tieba.w.albums_name_tv);
        return kVar;
    }
}
