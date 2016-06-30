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
    final /* synthetic */ n bQR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.bQR = nVar;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(u.h.tab_item_menu_item_view, (ViewGroup) null);
            view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(u.e.ds80)));
            j.c cVar = new j.c();
            cVar.aGR = (TextView) view.findViewById(u.g.tab_menu_name);
            cVar.bQL = (ImageView) view.findViewById(u.g.tab_menu_check);
            cVar.bQM = view.findViewById(u.g.tab_menu_line_s);
            cVar.bQN = view.findViewById(u.g.tab_menu_line_f);
            view.setTag(cVar);
        }
        av.k(view, u.d.cp_bg_line_d);
        j.c cVar2 = (j.c) view.getTag();
        dy item = getItem(i);
        if (item != null) {
            cVar2.aGR.setText(item.name);
            if (item.isSelected) {
                av.c(cVar2.aGR, u.d.cp_link_tip_a, 1);
                av.c(cVar2.bQL, u.f.chx_tips_list_ok);
                cVar2.bQL.setVisibility(0);
            } else {
                av.c(cVar2.aGR, u.d.cp_cont_c, 1);
                cVar2.bQL.setVisibility(8);
            }
            if (i >= 0 && i == getCount() - 1) {
                cVar2.bQN.setVisibility(0);
                cVar2.bQM.setVisibility(8);
                av.l(cVar2.bQN, u.d.cp_bg_line_b);
            } else {
                cVar2.bQM.setVisibility(0);
                cVar2.bQN.setVisibility(8);
                av.l(cVar2.bQM, u.d.cp_bg_line_b);
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
    /* renamed from: hS */
    public dy getItem(int i) {
        List list;
        List list2;
        list = this.bQR.aLB;
        if (list != null) {
            list2 = this.bQR.aLB;
            return (dy) list2.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List list;
        List list2;
        list = this.bQR.aLB;
        if (list != null) {
            list2 = this.bQR.aLB;
            return list2.size();
        }
        return 0;
    }
}
