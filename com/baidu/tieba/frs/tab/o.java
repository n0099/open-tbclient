package com.baidu.tieba.frs.tab;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.frs.dy;
import com.baidu.tieba.frs.tab.j;
import com.baidu.tieba.u;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends BaseAdapter {
    final /* synthetic */ n bSP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.bSP = nVar;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(u.h.tab_item_menu_item_view, (ViewGroup) null);
            view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(u.e.ds80)));
            j.c cVar = new j.c();
            cVar.aHI = (TextView) view.findViewById(u.g.tab_menu_name);
            cVar.bSJ = (ImageView) view.findViewById(u.g.tab_menu_check);
            cVar.bSK = view.findViewById(u.g.tab_menu_line_s);
            cVar.bSL = view.findViewById(u.g.tab_menu_line_f);
            view.setTag(cVar);
        }
        av.k(view, u.d.cp_bg_line_d);
        j.c cVar2 = (j.c) view.getTag();
        dy item = getItem(i);
        if (item != null) {
            cVar2.aHI.setText(item.name);
            if (item.isSelected) {
                av.c(cVar2.aHI, u.d.cp_link_tip_a, 1);
                av.c(cVar2.bSJ, u.f.chx_tips_list_ok);
                cVar2.bSJ.setVisibility(0);
            } else {
                av.c(cVar2.aHI, u.d.cp_cont_c, 1);
                cVar2.bSJ.setVisibility(8);
            }
            if (i >= 0 && i == getCount() - 1) {
                cVar2.bSL.setVisibility(0);
                cVar2.bSK.setVisibility(8);
                av.l(cVar2.bSL, u.d.cp_bg_line_b);
            } else {
                cVar2.bSK.setVisibility(0);
                cVar2.bSL.setVisibility(8);
                av.l(cVar2.bSK, u.d.cp_bg_line_b);
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
    /* renamed from: hT */
    public dy getItem(int i) {
        List list;
        List list2;
        list = this.bSP.aMv;
        if (list != null) {
            list2 = this.bSP.aMv;
            return (dy) list2.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List list;
        List list2;
        list = this.bSP.aMv;
        if (list != null) {
            list2 = this.bSP.aMv;
            return list2.size();
        }
        return 0;
    }
}
