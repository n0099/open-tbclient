package com.baidu.tieba.frs.tab;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.frs.dt;
import com.baidu.tieba.frs.tab.j;
import com.baidu.tieba.t;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends BaseAdapter {
    final /* synthetic */ n cdV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.cdV = nVar;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(t.h.tab_item_menu_item_view, (ViewGroup) null);
            view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(t.e.ds80)));
            j.c cVar = new j.c();
            cVar.aKZ = (TextView) view.findViewById(t.g.tab_menu_name);
            cVar.cdP = (ImageView) view.findViewById(t.g.tab_menu_check);
            cVar.cdQ = view.findViewById(t.g.tab_menu_line_s);
            cVar.cdR = view.findViewById(t.g.tab_menu_line_f);
            view.setTag(cVar);
        }
        av.k(view, t.d.cp_bg_line_d);
        j.c cVar2 = (j.c) view.getTag();
        dt item = getItem(i);
        if (item != null) {
            cVar2.aKZ.setText(item.name);
            if (item.isSelected) {
                av.c(cVar2.aKZ, t.d.cp_link_tip_a, 1);
                av.c(cVar2.cdP, t.f.chx_tips_list_ok);
                cVar2.cdP.setVisibility(0);
            } else {
                av.c(cVar2.aKZ, t.d.cp_cont_c, 1);
                cVar2.cdP.setVisibility(8);
            }
            if (i >= 0 && i == getCount() - 1) {
                cVar2.cdR.setVisibility(0);
                cVar2.cdQ.setVisibility(8);
                av.l(cVar2.cdR, t.d.cp_bg_line_b);
            } else {
                cVar2.cdQ.setVisibility(0);
                cVar2.cdR.setVisibility(8);
                av.l(cVar2.cdQ, t.d.cp_bg_line_b);
            }
        }
        return view;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: iw */
    public dt getItem(int i) {
        List list;
        List list2;
        list = this.cdV.aRP;
        if (list != null) {
            list2 = this.cdV.aRP;
            return (dt) list2.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List list;
        List list2;
        list = this.cdV.aRP;
        if (list != null) {
            list2 = this.cdV.aRP;
            return list2.size();
        }
        return 0;
    }
}
