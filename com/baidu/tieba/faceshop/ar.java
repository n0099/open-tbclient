package com.baidu.tieba.faceshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.widget.TbImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ar extends BaseAdapter {
    private Context a;
    private ArrayList<String> b;

    public ar(Context context, ArrayList<String> arrayList) {
        this.a = context;
        this.b = arrayList;
    }

    public void a(ArrayList<String> arrayList) {
        this.b = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b == null) {
            return 0;
        }
        return this.b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.b == null || this.b.size() <= 0 || i < 0 || i >= this.b.size()) {
            return null;
        }
        return this.b.get(i);
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
            view = LayoutInflater.from(this.a).inflate(com.baidu.tieba.v.face_package_item_image, (ViewGroup) null);
            asVar.a = (TbImageView) view.findViewById(com.baidu.tieba.u.image);
            view.setTag(asVar);
        }
        as asVar2 = (as) view.getTag();
        view.setLayoutParams(new AbsListView.LayoutParams(measuredWidth, measuredWidth));
        String obj = getItem(i).toString();
        asVar2.a.setTag(obj);
        asVar2.a.setBackgroundResource(TbadkApplication.m252getInst().getSkinType() == 1 ? com.baidu.tieba.t.btn_choose_face_selector_1 : com.baidu.tieba.t.btn_choose_face_selector);
        asVar2.a.a(obj, 10, measuredWidth, measuredWidth, false);
        if (i == getCount() - 1) {
            viewGroup.invalidate();
        }
        return view;
    }
}
