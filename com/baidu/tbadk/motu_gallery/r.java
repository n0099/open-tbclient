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
    final /* synthetic */ JigsawAlbumListActivity WN;
    private Context mContext;

    public r(JigsawAlbumListActivity jigsawAlbumListActivity, Context context) {
        this.WN = jigsawAlbumListActivity;
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.WN.Wi.getCount();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.WN.Wi.db(i);
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
        c db = this.WN.Wi.db(i);
        viewphotoLinkedHashMap = this.WN.WE;
        if (viewphotoLinkedHashMap.containsKey(Integer.valueOf(i))) {
            viewphotoLinkedHashMap3 = this.WN.WE;
            aVar = (a) viewphotoLinkedHashMap3.get((Object) Integer.valueOf(i));
        } else {
            aVar = new a(this.mContext);
            aVar.setLayoutParams(new AbsListView.LayoutParams(this.WN.WK, this.WN.WK));
            aVar.setTag(Integer.valueOf(i));
            aVar.setScaleType(ImageView.ScaleType.CENTER_CROP);
            aVar.setPadding(this.WN.WL, this.WN.WL, this.WN.WL, this.WN.WL);
            aVar.setOnClickListener(new s(this, db));
            viewphotoLinkedHashMap2 = this.WN.WE;
            viewphotoLinkedHashMap2.put(Integer.valueOf(i), (ImageView) aVar);
        }
        z = this.WN.WM;
        if (z) {
            this.WN.WM = false;
        }
        if (db != null && u.sM().f(db.uri)) {
            aVar.setIsSelected(true);
        } else {
            aVar.setIsSelected(false);
        }
        return aVar;
    }
}
