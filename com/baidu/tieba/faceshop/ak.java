package com.baidu.tieba.faceshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.bs;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class ak extends BaseAdapter {
    private Context a;
    private FacePurchaseRecordsData b = null;
    private com.baidu.tieba.util.i c;

    public ak(Context context) {
        this.a = context;
        this.c = new com.baidu.tieba.util.i(context);
        this.c.a(context.getResources().getDimensionPixelSize(R.dimen.faceshop_purchase_cover_width), context.getResources().getDimensionPixelSize(R.dimen.faceshop_purchase_cover_height));
    }

    public void a(FacePurchaseRecordsData facePurchaseRecordsData) {
        this.b = facePurchaseRecordsData;
        notifyDataSetChanged();
    }

    public com.baidu.tieba.util.i a() {
        return this.c;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b == null || this.b.packList == null) {
            return 0;
        }
        return this.b.packList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.b == null || this.b.packList == null) {
            return null;
        }
        ArrayList<FacePurchasePackageData> arrayList = this.b.packList;
        if (i < 0 || i >= arrayList.size()) {
            return null;
        }
        return arrayList.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int al = TiebaApplication.g().al();
        if (view == null) {
            view = b();
        }
        al alVar = (al) view.getTag();
        if (this.a instanceof com.baidu.tieba.f) {
            ((com.baidu.tieba.f) this.a).getLayoutMode().a(al == 1);
            ((com.baidu.tieba.f) this.a).getLayoutMode().a(view);
        }
        a(i, alVar);
        return view;
    }

    private View b() {
        LayoutInflater from = LayoutInflater.from(this.a);
        al alVar = new al(this, null);
        View inflate = from.inflate(R.layout.face_purchase_record_item, (ViewGroup) null);
        alVar.a = (TbImageView) inflate.findViewById(R.id.cover);
        alVar.b = (TextView) inflate.findViewById(R.id.title);
        alVar.c = (TextView) inflate.findViewById(R.id.time);
        alVar.d = (TextView) inflate.findViewById(R.id.price);
        inflate.setTag(alVar);
        return inflate;
    }

    private void a(int i, al alVar) {
        FacePurchasePackageData facePurchasePackageData = (FacePurchasePackageData) getItem(i);
        if (facePurchasePackageData != null) {
            alVar.a.setTag(facePurchasePackageData.coverUrl);
            alVar.d.setText(facePurchasePackageData.price);
            alVar.b.setText(facePurchasePackageData.pname);
            Date date = new Date();
            date.setTime(facePurchasePackageData.puyTime * 1000);
            alVar.c.setText(bs.c(date));
        }
    }
}
