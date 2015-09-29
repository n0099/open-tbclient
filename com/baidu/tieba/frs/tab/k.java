package com.baidu.tieba.frs.tab;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.frs.tab.i;
import com.baidu.tieba.i;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends BaseAdapter {
    final /* synthetic */ i bbq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.bbq = iVar;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(i.g.tab_item_menu_item_view, (ViewGroup) null);
            view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(i.d.ds80)));
            i.b bVar = new i.b();
            bVar.aDa = (TextView) view.findViewById(i.f.tab_menu_name);
            bVar.bbs = (ImageView) view.findViewById(i.f.tab_menu_check);
            bVar.bbt = view.findViewById(i.f.tab_menu_line_s);
            bVar.bbu = view.findViewById(i.f.tab_menu_line_f);
            view.setTag(bVar);
        }
        am.i(view, i.c.cp_bg_line_d);
        i.b bVar2 = (i.b) view.getTag();
        h item = getItem(i);
        if (item != null) {
            bVar2.aDa.setText(item.name);
            if (item.isSelected) {
                am.b(bVar2.aDa, i.c.cp_link_tip_a, 1);
                am.c(bVar2.bbs, i.e.chx_tips_list_ok);
                bVar2.bbs.setVisibility(0);
            } else {
                am.b(bVar2.aDa, i.c.cp_cont_c, 1);
                bVar2.bbs.setVisibility(8);
            }
            if (i >= 0 && i == getCount() - 1) {
                bVar2.bbu.setVisibility(0);
                bVar2.bbt.setVisibility(8);
                am.j(bVar2.bbu, i.c.cp_bg_line_b);
            } else {
                bVar2.bbt.setVisibility(0);
                bVar2.bbu.setVisibility(8);
                am.j(bVar2.bbt, i.c.cp_bg_line_b);
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
    /* renamed from: fS */
    public h getItem(int i) {
        List list;
        List list2;
        list = this.bbq.mData;
        if (list != null) {
            list2 = this.bbq.mData;
            return (h) list2.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List list;
        List list2;
        list = this.bbq.mData;
        if (list != null) {
            list2 = this.bbq.mData;
            return list2.size();
        }
        return 0;
    }
}
