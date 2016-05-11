package com.baidu.tieba.frs.tab;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.frs.ft;
import com.baidu.tieba.frs.tab.j;
import com.baidu.tieba.t;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends BaseAdapter {
    final /* synthetic */ n btn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.btn = nVar;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(t.h.tab_item_menu_item_view, (ViewGroup) null);
            view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(t.e.ds80)));
            j.c cVar = new j.c();
            cVar.aGp = (TextView) view.findViewById(t.g.tab_menu_name);
            cVar.bth = (ImageView) view.findViewById(t.g.tab_menu_check);
            cVar.bti = view.findViewById(t.g.tab_menu_line_s);
            cVar.btj = view.findViewById(t.g.tab_menu_line_f);
            view.setTag(cVar);
        }
        at.k(view, t.d.cp_bg_line_d);
        j.c cVar2 = (j.c) view.getTag();
        ft item = getItem(i);
        if (item != null) {
            cVar2.aGp.setText(item.name);
            if (item.isSelected) {
                at.c(cVar2.aGp, t.d.cp_link_tip_a, 1);
                at.c(cVar2.bth, t.f.chx_tips_list_ok);
                cVar2.bth.setVisibility(0);
            } else {
                at.c(cVar2.aGp, t.d.cp_cont_c, 1);
                cVar2.bth.setVisibility(8);
            }
            if (i >= 0 && i == getCount() - 1) {
                cVar2.btj.setVisibility(0);
                cVar2.bti.setVisibility(8);
                at.l(cVar2.btj, t.d.cp_bg_line_b);
            } else {
                cVar2.bti.setVisibility(0);
                cVar2.btj.setVisibility(8);
                at.l(cVar2.bti, t.d.cp_bg_line_b);
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
    /* renamed from: gO */
    public ft getItem(int i) {
        List list;
        List list2;
        list = this.btn.aIe;
        if (list != null) {
            list2 = this.btn.aIe;
            return (ft) list2.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List list;
        List list2;
        list = this.btn.aIe;
        if (list != null) {
            list2 = this.btn.aIe;
            return list2.size();
        }
        return 0;
    }
}
