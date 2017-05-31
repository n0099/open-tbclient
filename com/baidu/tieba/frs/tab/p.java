package com.baidu.tieba.frs.tab;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.frs.cn;
import com.baidu.tieba.frs.tab.k;
import com.baidu.tieba.w;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends BaseAdapter {
    final /* synthetic */ o cgb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.cgb = oVar;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(w.j.tab_item_menu_item_view, (ViewGroup) null);
            view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(w.f.ds80)));
            k.c cVar = new k.c();
            cVar.name = (TextView) view.findViewById(w.h.tab_menu_name);
            cVar.cfV = (ImageView) view.findViewById(w.h.tab_menu_check);
            cVar.cfW = view.findViewById(w.h.tab_menu_line_s);
            cVar.cfX = view.findViewById(w.h.tab_menu_line_f);
            view.setTag(cVar);
        }
        aq.j(view, w.e.cp_bg_line_d);
        k.c cVar2 = (k.c) view.getTag();
        cn item = getItem(i);
        if (item != null) {
            cVar2.name.setText(item.name);
            if (item.isSelected) {
                aq.c(cVar2.name, w.e.cp_link_tip_a, 1);
                aq.c(cVar2.cfV, w.g.chx_tips_list_ok);
                cVar2.cfV.setVisibility(0);
            } else {
                aq.c(cVar2.name, w.e.cp_cont_c, 1);
                cVar2.cfV.setVisibility(8);
            }
            if (i >= 0 && i == getCount() - 1) {
                cVar2.cfX.setVisibility(0);
                cVar2.cfW.setVisibility(8);
                aq.k(cVar2.cfX, w.e.cp_bg_line_b);
            } else {
                cVar2.cfW.setVisibility(0);
                cVar2.cfX.setVisibility(8);
                aq.k(cVar2.cfW, w.e.cp_bg_line_b);
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
    /* renamed from: iW */
    public cn getItem(int i) {
        List list;
        List list2;
        list = this.cgb.aTD;
        if (list != null) {
            list2 = this.cgb.aTD;
            return (cn) list2.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List list;
        List list2;
        list = this.cgb.aTD;
        if (list != null) {
            list2 = this.cgb.aTD;
            return list2.size();
        }
        return 0;
    }
}
