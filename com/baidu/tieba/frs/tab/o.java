package com.baidu.tieba.frs.tab;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.frs.cx;
import com.baidu.tieba.frs.tab.j;
import com.baidu.tieba.r;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends BaseAdapter {
    final /* synthetic */ n bNE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.bNE = nVar;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(r.h.tab_item_menu_item_view, (ViewGroup) null);
            view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(r.e.ds80)));
            j.c cVar = new j.c();
            cVar.aKH = (TextView) view.findViewById(r.g.tab_menu_name);
            cVar.bNy = (ImageView) view.findViewById(r.g.tab_menu_check);
            cVar.bNz = view.findViewById(r.g.tab_menu_line_s);
            cVar.bNA = view.findViewById(r.g.tab_menu_line_f);
            view.setTag(cVar);
        }
        ar.k(view, r.d.cp_bg_line_d);
        j.c cVar2 = (j.c) view.getTag();
        cx item = getItem(i);
        if (item != null) {
            cVar2.aKH.setText(item.name);
            if (item.isSelected) {
                ar.c(cVar2.aKH, r.d.cp_link_tip_a, 1);
                ar.c(cVar2.bNy, r.f.chx_tips_list_ok);
                cVar2.bNy.setVisibility(0);
            } else {
                ar.c(cVar2.aKH, r.d.cp_cont_c, 1);
                cVar2.bNy.setVisibility(8);
            }
            if (i >= 0 && i == getCount() - 1) {
                cVar2.bNA.setVisibility(0);
                cVar2.bNz.setVisibility(8);
                ar.l(cVar2.bNA, r.d.cp_bg_line_b);
            } else {
                cVar2.bNz.setVisibility(0);
                cVar2.bNA.setVisibility(8);
                ar.l(cVar2.bNz, r.d.cp_bg_line_b);
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
    /* renamed from: hQ */
    public cx getItem(int i) {
        List list;
        List list2;
        list = this.bNE.aUm;
        if (list != null) {
            list2 = this.bNE.aUm;
            return (cx) list2.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List list;
        List list2;
        list = this.bNE.aUm;
        if (list != null) {
            list2 = this.bNE.aUm;
            return list2.size();
        }
        return 0;
    }
}
