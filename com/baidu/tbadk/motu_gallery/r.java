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
    final /* synthetic */ JigsawAlbumListActivity WR;
    private Context mContext;

    public r(JigsawAlbumListActivity jigsawAlbumListActivity, Context context) {
        this.WR = jigsawAlbumListActivity;
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.WR.Wm.getCount();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.WR.Wm.db(i);
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
        c db = this.WR.Wm.db(i);
        viewphotoLinkedHashMap = this.WR.WI;
        if (viewphotoLinkedHashMap.containsKey(Integer.valueOf(i))) {
            viewphotoLinkedHashMap3 = this.WR.WI;
            aVar = (a) viewphotoLinkedHashMap3.get((Object) Integer.valueOf(i));
        } else {
            aVar = new a(this.mContext);
            aVar.setLayoutParams(new AbsListView.LayoutParams(this.WR.WO, this.WR.WO));
            aVar.setTag(Integer.valueOf(i));
            aVar.setScaleType(ImageView.ScaleType.CENTER_CROP);
            aVar.setPadding(this.WR.WP, this.WR.WP, this.WR.WP, this.WR.WP);
            aVar.setOnClickListener(new s(this, db));
            viewphotoLinkedHashMap2 = this.WR.WI;
            viewphotoLinkedHashMap2.put(Integer.valueOf(i), (ImageView) aVar);
        }
        z = this.WR.WQ;
        if (z) {
            this.WR.WQ = false;
        }
        if (db != null && u.sO().f(db.uri)) {
            aVar.setIsSelected(true);
        } else {
            aVar.setIsSelected(false);
        }
        return aVar;
    }
}
