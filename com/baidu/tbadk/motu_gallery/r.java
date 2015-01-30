package com.baidu.tbadk.motu_gallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends BaseAdapter {
    final /* synthetic */ JigsawAlbumListActivity adu;
    private Context mContext;

    public r(JigsawAlbumListActivity jigsawAlbumListActivity, Context context) {
        this.adu = jigsawAlbumListActivity;
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.adu.acP.getCount();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.adu.acP.dE(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewphotoLinkedHashMap viewphotoLinkedHashMap;
        a aVar;
        ViewphotoLinkedHashMap viewphotoLinkedHashMap2;
        boolean z;
        ViewphotoLinkedHashMap viewphotoLinkedHashMap3;
        c dE = this.adu.acP.dE(i);
        viewphotoLinkedHashMap = this.adu.adl;
        if (viewphotoLinkedHashMap.containsKey(Integer.valueOf(i))) {
            viewphotoLinkedHashMap3 = this.adu.adl;
            aVar = (a) viewphotoLinkedHashMap3.get((Object) Integer.valueOf(i));
        } else {
            aVar = new a(this.mContext);
            aVar.setLayoutParams(new AbsListView.LayoutParams(this.adu.adr, this.adu.adr));
            aVar.setTag(Integer.valueOf(i));
            aVar.setScaleType(ImageView.ScaleType.CENTER_CROP);
            aVar.setPadding(this.adu.ads, this.adu.ads, this.adu.ads, this.adu.ads);
            aVar.setOnClickListener(new s(this, dE));
            viewphotoLinkedHashMap2 = this.adu.adl;
            viewphotoLinkedHashMap2.put(Integer.valueOf(i), (ImageView) aVar);
        }
        z = this.adu.adt;
        if (z) {
            this.adu.adt = false;
        }
        if (dE != null && u.wG().g(dE.uri)) {
            aVar.setIsSelected(true);
        } else {
            aVar.setIsSelected(false);
        }
        return aVar;
    }
}
