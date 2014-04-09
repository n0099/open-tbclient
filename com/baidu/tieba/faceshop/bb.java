package com.baidu.tieba.faceshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.widget.TbImageView;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public final class bb extends BaseAdapter {
    private Context a;
    private FacePurchaseRecordsData b = null;
    private com.baidu.tbadk.editortool.ab c;

    public bb(Context context) {
        this.a = context;
        this.c = new com.baidu.tbadk.editortool.ab(context);
        this.c.a(context.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.faceshop_purchase_cover_width), context.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.faceshop_purchase_cover_height));
    }

    public final void a(FacePurchaseRecordsData facePurchaseRecordsData) {
        this.b = facePurchaseRecordsData;
        notifyDataSetChanged();
    }

    public final com.baidu.tbadk.editortool.ab a() {
        return this.c;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        if (this.b == null || this.b.packList == null) {
            return 0;
        }
        return this.b.packList.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
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
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        int l = TbadkApplication.j().l();
        if (view == null) {
            LayoutInflater from = LayoutInflater.from(this.a);
            bc bcVar = new bc(this, (byte) 0);
            view = from.inflate(com.baidu.tieba.a.i.face_purchase_record_item, (ViewGroup) null);
            bcVar.a = (TbImageView) view.findViewById(com.baidu.tieba.a.h.cover);
            bcVar.b = (TextView) view.findViewById(com.baidu.tieba.a.h.title);
            bcVar.c = (TextView) view.findViewById(com.baidu.tieba.a.h.time);
            bcVar.d = (TextView) view.findViewById(com.baidu.tieba.a.h.price);
            view.setTag(bcVar);
        }
        bc bcVar2 = (bc) view.getTag();
        if (this.a instanceof com.baidu.tbadk.a) {
            ((com.baidu.tbadk.a) this.a).getLayoutMode().a(l == 1);
            ((com.baidu.tbadk.a) this.a).getLayoutMode().a(view);
        }
        FacePurchasePackageData facePurchasePackageData = (FacePurchasePackageData) getItem(i);
        if (facePurchasePackageData != null) {
            bcVar2.a.setTag(facePurchasePackageData.coverUrl);
            bcVar2.d.setText(facePurchasePackageData.price);
            bcVar2.b.setText(facePurchasePackageData.pname);
            Date date = new Date();
            date.setTime(facePurchasePackageData.puyTime * 1000);
            bcVar2.c.setText(com.baidu.tbadk.core.util.bc.d(date));
        }
        return view;
    }
}
