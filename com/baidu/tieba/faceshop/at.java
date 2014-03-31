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
public final class at extends BaseAdapter {
    private Context a;
    private ArrayList<String> b;
    private com.baidu.tbadk.editortool.aa c;

    public at(Context context, ArrayList<String> arrayList) {
        this.a = context;
        this.b = arrayList;
        this.c = new com.baidu.tbadk.editortool.aa(context);
    }

    public final void a(ArrayList<String> arrayList) {
        this.b = arrayList;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        if (this.b == null) {
            return 0;
        }
        return this.b.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        if (this.b == null || this.b.size() <= 0 || i < 0 || i >= this.b.size()) {
            return null;
        }
        return this.b.get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        int measuredWidth = viewGroup.getMeasuredWidth() / 4;
        this.c.a(measuredWidth, measuredWidth);
        if (view == null) {
            av avVar = new av(this, (byte) 0);
            view = LayoutInflater.from(this.a).inflate(com.baidu.tieba.a.i.face_package_item_image, (ViewGroup) null);
            avVar.a = (TbImageView) view.findViewById(com.baidu.tieba.a.h.image);
            view.setTag(avVar);
        }
        av avVar2 = (av) view.getTag();
        view.setLayoutParams(new AbsListView.LayoutParams(measuredWidth, measuredWidth));
        String obj = getItem(i).toString();
        avVar2.a.setTag(obj);
        avVar2.a.setBackgroundResource(TbadkApplication.j().l() == 1 ? com.baidu.tieba.a.g.btn_choose_face_selector_1 : com.baidu.tieba.a.g.btn_choose_face_selector);
        this.c.b(obj, new au(this, viewGroup));
        if (i == getCount() - 1) {
            viewGroup.invalidate();
        }
        return view;
    }

    public final void a() {
        if (this.c != null) {
            this.c.c();
        }
    }
}
