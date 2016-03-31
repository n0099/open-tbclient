package com.baidu.tieba.frs.tab;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.frs.fu;
import com.baidu.tieba.frs.tab.i;
import com.baidu.tieba.t;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends BaseAdapter {
    final /* synthetic */ m bur;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.bur = mVar;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(t.h.tab_item_menu_item_view, (ViewGroup) null);
            view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(t.e.ds80)));
            i.c cVar = new i.c();
            cVar.aKg = (TextView) view.findViewById(t.g.tab_menu_name);
            cVar.bul = (ImageView) view.findViewById(t.g.tab_menu_check);
            cVar.bum = view.findViewById(t.g.tab_menu_line_s);
            cVar.bun = view.findViewById(t.g.tab_menu_line_f);
            view.setTag(cVar);
        }
        at.k(view, t.d.cp_bg_line_d);
        i.c cVar2 = (i.c) view.getTag();
        fu item = getItem(i);
        if (item != null) {
            cVar2.aKg.setText(item.name);
            if (item.isSelected) {
                at.b(cVar2.aKg, t.d.cp_link_tip_a, 1);
                at.c(cVar2.bul, t.f.chx_tips_list_ok);
                cVar2.bul.setVisibility(0);
            } else {
                at.b(cVar2.aKg, t.d.cp_cont_c, 1);
                cVar2.bul.setVisibility(8);
            }
            if (i >= 0 && i == getCount() - 1) {
                cVar2.bun.setVisibility(0);
                cVar2.bum.setVisibility(8);
                at.l(cVar2.bun, t.d.cp_bg_line_b);
            } else {
                cVar2.bum.setVisibility(0);
                cVar2.bun.setVisibility(8);
                at.l(cVar2.bum, t.d.cp_bg_line_b);
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
    /* renamed from: hh */
    public fu getItem(int i) {
        List list;
        List list2;
        list = this.bur.aLU;
        if (list != null) {
            list2 = this.bur.aLU;
            return (fu) list2.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List list;
        List list2;
        list = this.bur.aLU;
        if (list != null) {
            list2 = this.bur.aLU;
            return list2.size();
        }
        return 0;
    }
}
