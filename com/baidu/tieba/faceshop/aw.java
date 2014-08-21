package com.baidu.tieba.faceshop;

import android.content.Context;
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
public class aw extends BaseAdapter {
    private Context a;
    private FacePurchaseRecordsData b = null;

    public aw(Context context) {
        this.a = context;
    }

    public void a(FacePurchaseRecordsData facePurchaseRecordsData) {
        this.b = facePurchaseRecordsData;
        notifyDataSetChanged();
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
            view = a();
        }
        ax axVar = (ax) view.getTag();
        if (this.a instanceof BaseActivity) {
            ((BaseActivity) this.a).getLayoutMode().a(skinType == 1);
            ((BaseActivity) this.a).getLayoutMode().a(view);
        }
        a(i, axVar);
        return view;
    }

    private View a() {
        ax axVar = new ax(this, null);
        View a = com.baidu.adp.lib.e.b.a().a(this.a, com.baidu.tieba.v.face_purchase_record_item, null);
        axVar.a = (TbImageView) a.findViewById(com.baidu.tieba.u.cover);
        axVar.b = (TextView) a.findViewById(com.baidu.tieba.u.title);
        axVar.c = (TextView) a.findViewById(com.baidu.tieba.u.time);
        axVar.d = (TextView) a.findViewById(com.baidu.tieba.u.price);
        a.setTag(axVar);
        return a;
    }

    private void a(int i, ax axVar) {
        FacePurchasePackageData facePurchasePackageData = (FacePurchasePackageData) getItem(i);
        if (facePurchasePackageData != null) {
            axVar.a.setTag(facePurchasePackageData.coverUrl);
            axVar.a.a(facePurchasePackageData.coverUrl, 10, this.a.getResources().getDimensionPixelSize(com.baidu.tieba.s.faceshop_purchase_cover_width), this.a.getResources().getDimensionPixelSize(com.baidu.tieba.s.faceshop_purchase_cover_height), false);
            axVar.d.setText(facePurchasePackageData.price);
            axVar.b.setText(facePurchasePackageData.pname);
            Date date = new Date();
            date.setTime(facePurchasePackageData.puyTime * 1000);
            axVar.c.setText(com.baidu.tbadk.core.util.ba.d(date));
        }
    }
}
