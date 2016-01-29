package com.baidu.tieba.frs.tab;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.frs.fm;
import com.baidu.tieba.frs.tab.i;
import com.baidu.tieba.t;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends BaseAdapter {
    final /* synthetic */ m bpq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.bpq = mVar;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(t.h.tab_item_menu_item_view, (ViewGroup) null);
            view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(t.e.ds80)));
            i.b bVar = new i.b();
            bVar.aHk = (TextView) view.findViewById(t.g.tab_menu_name);
            bVar.bpj = (ImageView) view.findViewById(t.g.tab_menu_check);
            bVar.bpk = view.findViewById(t.g.tab_menu_line_s);
            bVar.bpl = view.findViewById(t.g.tab_menu_line_f);
            view.setTag(bVar);
        }
        ar.k(view, t.d.cp_bg_line_d);
        i.b bVar2 = (i.b) view.getTag();
        fm item = getItem(i);
        if (item != null) {
            bVar2.aHk.setText(item.name);
            if (item.isSelected) {
                ar.b(bVar2.aHk, t.d.cp_link_tip_a, 1);
                ar.c(bVar2.bpj, t.f.chx_tips_list_ok);
                bVar2.bpj.setVisibility(0);
            } else {
                ar.b(bVar2.aHk, t.d.cp_cont_c, 1);
                bVar2.bpj.setVisibility(8);
            }
            if (i >= 0 && i == getCount() - 1) {
                bVar2.bpl.setVisibility(0);
                bVar2.bpk.setVisibility(8);
                ar.l(bVar2.bpl, t.d.cp_bg_line_b);
            } else {
                bVar2.bpk.setVisibility(0);
                bVar2.bpl.setVisibility(8);
                ar.l(bVar2.bpk, t.d.cp_bg_line_b);
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
    /* renamed from: gP */
    public fm getItem(int i) {
        List list;
        List list2;
        list = this.bpq.aIY;
        if (list != null) {
            list2 = this.bpq.aIY;
            return (fm) list2.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List list;
        List list2;
        list = this.bpq.aIY;
        if (list != null) {
            list2 = this.bpq.aIY;
            return list2.size();
        }
        return 0;
    }
}
