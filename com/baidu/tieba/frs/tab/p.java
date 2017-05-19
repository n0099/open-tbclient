package com.baidu.tieba.frs.tab;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.frs.cm;
import com.baidu.tieba.frs.tab.k;
import com.baidu.tieba.w;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends BaseAdapter {
    final /* synthetic */ o bZP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.bZP = oVar;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(w.j.tab_item_menu_item_view, (ViewGroup) null);
            view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(w.f.ds80)));
            k.c cVar = new k.c();
            cVar.name = (TextView) view.findViewById(w.h.tab_menu_name);
            cVar.bZJ = (ImageView) view.findViewById(w.h.tab_menu_check);
            cVar.bZK = view.findViewById(w.h.tab_menu_line_s);
            cVar.bZL = view.findViewById(w.h.tab_menu_line_f);
            view.setTag(cVar);
        }
        aq.j(view, w.e.cp_bg_line_d);
        k.c cVar2 = (k.c) view.getTag();
        cm item = getItem(i);
        if (item != null) {
            cVar2.name.setText(item.name);
            if (item.isSelected) {
                aq.c(cVar2.name, w.e.cp_link_tip_a, 1);
                aq.c(cVar2.bZJ, w.g.chx_tips_list_ok);
                cVar2.bZJ.setVisibility(0);
            } else {
                aq.c(cVar2.name, w.e.cp_cont_c, 1);
                cVar2.bZJ.setVisibility(8);
            }
            if (i >= 0 && i == getCount() - 1) {
                cVar2.bZL.setVisibility(0);
                cVar2.bZK.setVisibility(8);
                aq.k(cVar2.bZL, w.e.cp_bg_line_b);
            } else {
                cVar2.bZK.setVisibility(0);
                cVar2.bZL.setVisibility(8);
                aq.k(cVar2.bZK, w.e.cp_bg_line_b);
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
    /* renamed from: iy */
    public cm getItem(int i) {
        List list;
        List list2;
        list = this.bZP.aWb;
        if (list != null) {
            list2 = this.bZP.aWb;
            return (cm) list2.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List list;
        List list2;
        list = this.bZP.aWb;
        if (list != null) {
            list2 = this.bZP.aWb;
            return list2.size();
        }
        return 0;
    }
}
