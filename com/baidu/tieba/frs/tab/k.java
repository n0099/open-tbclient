package com.baidu.tieba.frs.tab;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.frs.tab.i;
import com.baidu.tieba.i;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends BaseAdapter {
    final /* synthetic */ i bbc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.bbc = iVar;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(i.g.tab_item_menu_item_view, (ViewGroup) null);
            view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(i.d.ds80)));
            i.b bVar = new i.b();
            bVar.aPi = (TextView) view.findViewById(i.f.tab_menu_name);
            bVar.bbe = (ImageView) view.findViewById(i.f.tab_menu_check);
            bVar.bbf = view.findViewById(i.f.tab_menu_line_s);
            bVar.bbg = view.findViewById(i.f.tab_menu_line_f);
            view.setTag(bVar);
        }
        al.i(view, i.c.cp_bg_line_d);
        i.b bVar2 = (i.b) view.getTag();
        h item = getItem(i);
        if (item != null) {
            bVar2.aPi.setText(item.name);
            if (item.isSelected) {
                al.b(bVar2.aPi, i.c.cp_link_tip_a, 1);
                al.c(bVar2.bbe, i.e.chx_tips_list_ok);
                bVar2.bbe.setVisibility(0);
            } else {
                al.b(bVar2.aPi, i.c.cp_cont_c, 1);
                bVar2.bbe.setVisibility(8);
            }
            if (i >= 0 && i == getCount() - 1) {
                bVar2.bbg.setVisibility(0);
                bVar2.bbf.setVisibility(8);
                al.j(bVar2.bbg, i.c.cp_bg_line_b);
            } else {
                bVar2.bbf.setVisibility(0);
                bVar2.bbg.setVisibility(8);
                al.j(bVar2.bbf, i.c.cp_bg_line_b);
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
    /* renamed from: fE */
    public h getItem(int i) {
        List list;
        List list2;
        list = this.bbc.mData;
        if (list != null) {
            list2 = this.bbc.mData;
            return (h) list2.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List list;
        List list2;
        list = this.bbc.mData;
        if (list != null) {
            list2 = this.bbc.mData;
            return list2.size();
        }
        return 0;
    }
}
