package com.baidu.tieba.frs.tab;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.frs.co;
import com.baidu.tieba.frs.tab.k;
import com.baidu.tieba.w;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends BaseAdapter {
    final /* synthetic */ o cor;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.cor = oVar;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(w.j.tab_item_menu_item_view, (ViewGroup) null);
            view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(w.f.ds80)));
            k.c cVar = new k.c();
            cVar.name = (TextView) view.findViewById(w.h.tab_menu_name);
            cVar.col = (ImageView) view.findViewById(w.h.tab_menu_check);
            cVar.f1com = view.findViewById(w.h.tab_menu_line_s);
            cVar.con = view.findViewById(w.h.tab_menu_line_f);
            view.setTag(cVar);
        }
        as.j(view, w.e.cp_bg_line_d);
        k.c cVar2 = (k.c) view.getTag();
        co item = getItem(i);
        if (item != null) {
            cVar2.name.setText(item.name);
            if (item.isSelected) {
                as.c(cVar2.name, w.e.cp_link_tip_a, 1);
                as.c(cVar2.col, w.g.chx_tips_list_ok);
                cVar2.col.setVisibility(0);
            } else {
                as.c(cVar2.name, w.e.cp_cont_c, 1);
                cVar2.col.setVisibility(8);
            }
            if (i >= 0 && i == getCount() - 1) {
                cVar2.con.setVisibility(0);
                cVar2.f1com.setVisibility(8);
                as.k(cVar2.con, w.e.cp_bg_line_b);
            } else {
                cVar2.f1com.setVisibility(0);
                cVar2.con.setVisibility(8);
                as.k(cVar2.f1com, w.e.cp_bg_line_b);
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
    /* renamed from: ji */
    public co getItem(int i) {
        List list;
        List list2;
        list = this.cor.aUW;
        if (list != null) {
            list2 = this.cor.aUW;
            return (co) list2.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List list;
        List list2;
        list = this.cor.aUW;
        if (list != null) {
            list2 = this.cor.aUW;
            return list2.size();
        }
        return 0;
    }
}
