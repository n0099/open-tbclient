package com.baidu.tieba.faceshop;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import com.baidu.tbadk.widget.TbImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ar extends BaseAdapter {
    private ArrayList<String> aew;
    private Context mContext;

    public ar(Context context, ArrayList<String> arrayList) {
        this.mContext = context;
        this.aew = arrayList;
    }

    public void setData(ArrayList<String> arrayList) {
        this.aew = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aew == null) {
            return 0;
        }
        return this.aew.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aew == null || this.aew.size() <= 0 || i < 0 || i >= this.aew.size()) {
            return null;
        }
        return this.aew.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int measuredWidth = viewGroup.getMeasuredWidth() / 4;
        if (view == null) {
            as asVar = new as(this, null);
            view = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, ca.face_package_item_image, null);
            asVar.atZ = (TbImageView) view.findViewById(bz.image);
            view.setTag(asVar);
        }
        as asVar2 = (as) view.getTag();
        view.setLayoutParams(new AbsListView.LayoutParams(measuredWidth, measuredWidth));
        String obj = getItem(i).toString();
        asVar2.atZ.setTag(obj);
        com.baidu.tbadk.core.util.aw.h(asVar2.atZ, by.btn_choose_face_selector);
        asVar2.atZ.a(obj, 10, measuredWidth, measuredWidth, false);
        if (i == getCount() - 1) {
            viewGroup.invalidate();
        }
        return view;
    }
}
