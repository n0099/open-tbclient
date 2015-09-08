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
    final /* synthetic */ i bbw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.bbw = iVar;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(i.g.tab_item_menu_item_view, (ViewGroup) null);
            view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(i.d.ds80)));
            i.b bVar = new i.b();
            bVar.aPv = (TextView) view.findViewById(i.f.tab_menu_name);
            bVar.bby = (ImageView) view.findViewById(i.f.tab_menu_check);
            bVar.bbz = view.findViewById(i.f.tab_menu_line_s);
            bVar.bbA = view.findViewById(i.f.tab_menu_line_f);
            view.setTag(bVar);
        }
        al.h(view, i.c.cp_bg_line_d);
        i.b bVar2 = (i.b) view.getTag();
        h item = getItem(i);
        if (item != null) {
            bVar2.aPv.setText(item.name);
            if (item.isSelected) {
                al.b(bVar2.aPv, i.c.cp_link_tip_a, 1);
                al.c(bVar2.bby, i.e.chx_tips_list_ok);
                bVar2.bby.setVisibility(0);
            } else {
                al.b(bVar2.aPv, i.c.cp_cont_c, 1);
                bVar2.bby.setVisibility(8);
            }
            if (i >= 0 && i == getCount() - 1) {
                bVar2.bbA.setVisibility(0);
                bVar2.bbz.setVisibility(8);
                al.i(bVar2.bbA, i.c.cp_bg_line_b);
            } else {
                bVar2.bbz.setVisibility(0);
                bVar2.bbA.setVisibility(8);
                al.i(bVar2.bbz, i.c.cp_bg_line_b);
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
    /* renamed from: fN */
    public h getItem(int i) {
        List list;
        List list2;
        list = this.bbw.mData;
        if (list != null) {
            list2 = this.bbw.mData;
            return (h) list2.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List list;
        List list2;
        list = this.bbw.mData;
        if (list != null) {
            list2 = this.bbw.mData;
            return list2.size();
        }
        return 0;
    }
}
