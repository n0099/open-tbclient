package com.baidu.tieba.frs.tab;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.frs.fc;
import com.baidu.tieba.frs.tab.i;
import com.baidu.tieba.n;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends BaseAdapter {
    final /* synthetic */ m bmB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.bmB = mVar;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(n.h.tab_item_menu_item_view, (ViewGroup) null);
            view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(n.e.ds80)));
            i.b bVar = new i.b();
            bVar.aGr = (TextView) view.findViewById(n.g.tab_menu_name);
            bVar.bmv = (ImageView) view.findViewById(n.g.tab_menu_check);
            bVar.bmw = view.findViewById(n.g.tab_menu_line_s);
            bVar.bmx = view.findViewById(n.g.tab_menu_line_f);
            view.setTag(bVar);
        }
        as.i(view, n.d.cp_bg_line_d);
        i.b bVar2 = (i.b) view.getTag();
        fc item = getItem(i);
        if (item != null) {
            bVar2.aGr.setText(item.name);
            if (item.isSelected) {
                as.b(bVar2.aGr, n.d.cp_link_tip_a, 1);
                as.c(bVar2.bmv, n.f.chx_tips_list_ok);
                bVar2.bmv.setVisibility(0);
            } else {
                as.b(bVar2.aGr, n.d.cp_cont_c, 1);
                bVar2.bmv.setVisibility(8);
            }
            if (i >= 0 && i == getCount() - 1) {
                bVar2.bmx.setVisibility(0);
                bVar2.bmw.setVisibility(8);
                as.j(bVar2.bmx, n.d.cp_bg_line_b);
            } else {
                bVar2.bmw.setVisibility(0);
                bVar2.bmx.setVisibility(8);
                as.j(bVar2.bmw, n.d.cp_bg_line_b);
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
    /* renamed from: gs */
    public fc getItem(int i) {
        List list;
        List list2;
        list = this.bmB.mData;
        if (list != null) {
            list2 = this.bmB.mData;
            return (fc) list2.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List list;
        List list2;
        list = this.bmB.mData;
        if (list != null) {
            list2 = this.bmB.mData;
            return list2.size();
        }
        return 0;
    }
}
