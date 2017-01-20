package com.baidu.tieba.frs.tab;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.frs.ct;
import com.baidu.tieba.frs.tab.j;
import com.baidu.tieba.r;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends BaseAdapter {
    final /* synthetic */ n bTS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.bTS = nVar;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(r.j.tab_item_menu_item_view, (ViewGroup) null);
            view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(r.f.ds80)));
            j.c cVar = new j.c();
            cVar.name = (TextView) view.findViewById(r.h.tab_menu_name);
            cVar.bTM = (ImageView) view.findViewById(r.h.tab_menu_check);
            cVar.bTN = view.findViewById(r.h.tab_menu_line_s);
            cVar.bTO = view.findViewById(r.h.tab_menu_line_f);
            view.setTag(cVar);
        }
        ap.j(view, r.e.cp_bg_line_d);
        j.c cVar2 = (j.c) view.getTag();
        ct item = getItem(i);
        if (item != null) {
            cVar2.name.setText(item.name);
            if (item.isSelected) {
                ap.c(cVar2.name, r.e.cp_link_tip_a, 1);
                ap.c(cVar2.bTM, r.g.chx_tips_list_ok);
                cVar2.bTM.setVisibility(0);
            } else {
                ap.c(cVar2.name, r.e.cp_cont_c, 1);
                cVar2.bTM.setVisibility(8);
            }
            if (i >= 0 && i == getCount() - 1) {
                cVar2.bTO.setVisibility(0);
                cVar2.bTN.setVisibility(8);
                ap.k(cVar2.bTO, r.e.cp_bg_line_b);
            } else {
                cVar2.bTN.setVisibility(0);
                cVar2.bTO.setVisibility(8);
                ap.k(cVar2.bTN, r.e.cp_bg_line_b);
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
    /* renamed from: iD */
    public ct getItem(int i) {
        List list;
        List list2;
        list = this.bTS.aPE;
        if (list != null) {
            list2 = this.bTS.aPE;
            return (ct) list2.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List list;
        List list2;
        list = this.bTS.aPE;
        if (list != null) {
            list2 = this.bTS.aPE;
            return list2.size();
        }
        return 0;
    }
}
