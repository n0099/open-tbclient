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
    final /* synthetic */ JigsawAlbumListActivity acW;
    private Context mContext;

    public r(JigsawAlbumListActivity jigsawAlbumListActivity, Context context) {
        this.acW = jigsawAlbumListActivity;
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.acW.acr.getCount();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.acW.acr.dy(i);
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
        c dy = this.acW.acr.dy(i);
        viewphotoLinkedHashMap = this.acW.acN;
        if (viewphotoLinkedHashMap.containsKey(Integer.valueOf(i))) {
            viewphotoLinkedHashMap3 = this.acW.acN;
            aVar = (a) viewphotoLinkedHashMap3.get((Object) Integer.valueOf(i));
        } else {
            aVar = new a(this.mContext);
            aVar.setLayoutParams(new AbsListView.LayoutParams(this.acW.acT, this.acW.acT));
            aVar.setTag(Integer.valueOf(i));
            aVar.setScaleType(ImageView.ScaleType.CENTER_CROP);
            aVar.setPadding(this.acW.acU, this.acW.acU, this.acW.acU, this.acW.acU);
            aVar.setOnClickListener(new s(this, dy));
            viewphotoLinkedHashMap2 = this.acW.acN;
            viewphotoLinkedHashMap2.put(Integer.valueOf(i), (ImageView) aVar);
        }
        z = this.acW.acV;
        if (z) {
            this.acW.acV = false;
        }
        if (dy != null && u.wq().g(dy.uri)) {
            aVar.setIsSelected(true);
        } else {
            aVar.setIsSelected(false);
        }
        return aVar;
    }
}
