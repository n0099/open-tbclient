package com.baidu.tieba.frs.tab;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.frs.ct;
import com.baidu.tieba.frs.tab.j;
import com.baidu.tieba.w;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends BaseAdapter {
    final /* synthetic */ n cbe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.cbe = nVar;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(w.j.tab_item_menu_item_view, (ViewGroup) null);
            view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(w.f.ds80)));
            j.c cVar = new j.c();
            cVar.name = (TextView) view.findViewById(w.h.tab_menu_name);
            cVar.caY = (ImageView) view.findViewById(w.h.tab_menu_check);
            cVar.caZ = view.findViewById(w.h.tab_menu_line_s);
            cVar.cba = view.findViewById(w.h.tab_menu_line_f);
            view.setTag(cVar);
        }
        aq.j(view, w.e.cp_bg_line_d);
        j.c cVar2 = (j.c) view.getTag();
        ct item = getItem(i);
        if (item != null) {
            cVar2.name.setText(item.name);
            if (item.isSelected) {
                aq.c(cVar2.name, w.e.cp_link_tip_a, 1);
                aq.c(cVar2.caY, w.g.chx_tips_list_ok);
                cVar2.caY.setVisibility(0);
            } else {
                aq.c(cVar2.name, w.e.cp_cont_c, 1);
                cVar2.caY.setVisibility(8);
            }
            if (i >= 0 && i == getCount() - 1) {
                cVar2.cba.setVisibility(0);
                cVar2.caZ.setVisibility(8);
                aq.k(cVar2.cba, w.e.cp_bg_line_b);
            } else {
                cVar2.caZ.setVisibility(0);
                cVar2.cba.setVisibility(8);
                aq.k(cVar2.caZ, w.e.cp_bg_line_b);
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
    /* renamed from: iz */
    public ct getItem(int i) {
        List list;
        List list2;
        list = this.cbe.aVq;
        if (list != null) {
            list2 = this.cbe.aVq;
            return (ct) list2.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List list;
        List list2;
        list = this.cbe.aVq;
        if (list != null) {
            list2 = this.cbe.aVq;
            return list2.size();
        }
        return 0;
    }
}
