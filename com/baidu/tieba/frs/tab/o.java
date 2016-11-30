package com.baidu.tieba.frs.tab;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.frs.cx;
import com.baidu.tieba.frs.tab.j;
import com.baidu.tieba.r;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends BaseAdapter {
    final /* synthetic */ n chV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.chV = nVar;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(r.h.tab_item_menu_item_view, (ViewGroup) null);
            view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(r.e.ds80)));
            j.c cVar = new j.c();
            cVar.aLq = (TextView) view.findViewById(r.g.tab_menu_name);
            cVar.chP = (ImageView) view.findViewById(r.g.tab_menu_check);
            cVar.chQ = view.findViewById(r.g.tab_menu_line_s);
            cVar.chR = view.findViewById(r.g.tab_menu_line_f);
            view.setTag(cVar);
        }
        at.k(view, r.d.cp_bg_line_d);
        j.c cVar2 = (j.c) view.getTag();
        cx item = getItem(i);
        if (item != null) {
            cVar2.aLq.setText(item.name);
            if (item.isSelected) {
                at.c(cVar2.aLq, r.d.cp_link_tip_a, 1);
                at.c(cVar2.chP, r.f.chx_tips_list_ok);
                cVar2.chP.setVisibility(0);
            } else {
                at.c(cVar2.aLq, r.d.cp_cont_c, 1);
                cVar2.chP.setVisibility(8);
            }
            if (i >= 0 && i == getCount() - 1) {
                cVar2.chR.setVisibility(0);
                cVar2.chQ.setVisibility(8);
                at.l(cVar2.chR, r.d.cp_bg_line_b);
            } else {
                cVar2.chQ.setVisibility(0);
                cVar2.chR.setVisibility(8);
                at.l(cVar2.chQ, r.d.cp_bg_line_b);
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
    /* renamed from: iG */
    public cx getItem(int i) {
        List list;
        List list2;
        list = this.chV.aUV;
        if (list != null) {
            list2 = this.chV.aUV;
            return (cx) list2.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List list;
        List list2;
        list = this.chV.aUV;
        if (list != null) {
            list2 = this.chV.aUV;
            return list2.size();
        }
        return 0;
    }
}
