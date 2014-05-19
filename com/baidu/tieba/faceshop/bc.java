package com.baidu.tieba.faceshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.widget.TbImageView;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class bc extends BaseAdapter {
    private Context a;
    private FacePurchaseRecordsData b = null;
    private com.baidu.tbadk.editortool.ab c;

    public bc(Context context) {
        this.a = context;
        this.c = new com.baidu.tbadk.editortool.ab(context);
        this.c.a(context.getResources().getDimensionPixelSize(com.baidu.tieba.p.faceshop_purchase_cover_width), context.getResources().getDimensionPixelSize(com.baidu.tieba.p.faceshop_purchase_cover_height));
    }

    public void a(FacePurchaseRecordsData facePurchaseRecordsData) {
        this.b = facePurchaseRecordsData;
        notifyDataSetChanged();
    }

    public com.baidu.tbadk.editortool.ab a() {
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
        int skinType = TbadkApplication.m252getInst().getSkinType();
        if (view == null) {
            view = b();
        }
        bd bdVar = (bd) view.getTag();
        if (this.a instanceof BaseActivity) {
            ((BaseActivity) this.a).getLayoutMode().a(skinType == 1);
            ((BaseActivity) this.a).getLayoutMode().a(view);
        }
        a(i, bdVar);
        return view;
    }

    private View b() {
        LayoutInflater from = LayoutInflater.from(this.a);
        bd bdVar = new bd(this, null);
        View inflate = from.inflate(com.baidu.tieba.s.face_purchase_record_item, (ViewGroup) null);
        bdVar.a = (TbImageView) inflate.findViewById(com.baidu.tieba.r.cover);
        bdVar.b = (TextView) inflate.findViewById(com.baidu.tieba.r.title);
        bdVar.c = (TextView) inflate.findViewById(com.baidu.tieba.r.time);
        bdVar.d = (TextView) inflate.findViewById(com.baidu.tieba.r.price);
        inflate.setTag(bdVar);
        return inflate;
    }

    private void a(int i, bd bdVar) {
        FacePurchasePackageData facePurchasePackageData = (FacePurchasePackageData) getItem(i);
        if (facePurchasePackageData != null) {
            bdVar.a.setTag(facePurchasePackageData.coverUrl);
            bdVar.d.setText(facePurchasePackageData.price);
            bdVar.b.setText(facePurchasePackageData.pname);
            Date date = new Date();
            date.setTime(facePurchasePackageData.puyTime * 1000);
            bdVar.c.setText(com.baidu.tbadk.core.util.be.d(date));
        }
    }
}
