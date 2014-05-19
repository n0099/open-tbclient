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
public class aw extends BaseAdapter {
    private Context a;
    private ArrayList<String> b;
    private com.baidu.tbadk.editortool.ab c;

    public aw(Context context, ArrayList<String> arrayList) {
        this.a = context;
        this.b = arrayList;
        this.c = new com.baidu.tbadk.editortool.ab(context);
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
        this.c.a(measuredWidth, measuredWidth);
        if (view == null) {
            ay ayVar = new ay(this, null);
            view = LayoutInflater.from(this.a).inflate(com.baidu.tieba.s.face_package_item_image, (ViewGroup) null);
            ayVar.a = (TbImageView) view.findViewById(com.baidu.tieba.r.image);
            view.setTag(ayVar);
        }
        ay ayVar2 = (ay) view.getTag();
        view.setLayoutParams(new AbsListView.LayoutParams(measuredWidth, measuredWidth));
        String obj = getItem(i).toString();
        ayVar2.a.setTag(obj);
        ayVar2.a.setBackgroundResource(TbadkApplication.m252getInst().getSkinType() == 1 ? com.baidu.tieba.q.btn_choose_face_selector_1 : com.baidu.tieba.q.btn_choose_face_selector);
        this.c.b(obj, new ax(this, viewGroup));
        if (i == getCount() - 1) {
            viewGroup.invalidate();
        }
        return view;
    }

    public void a() {
        if (this.c != null) {
            this.c.d();
        }
    }
}
