package com.baidu.tieba.frs.tab;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.frs.ek;
import com.baidu.tieba.frs.tab.i;
import com.baidu.tieba.i;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends BaseAdapter {
    final /* synthetic */ m bcf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.bcf = mVar;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(i.g.tab_item_menu_item_view, (ViewGroup) null);
            view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(i.d.ds80)));
            i.b bVar = new i.b();
            bVar.aCf = (TextView) view.findViewById(i.f.tab_menu_name);
            bVar.bbZ = (ImageView) view.findViewById(i.f.tab_menu_check);
            bVar.bca = view.findViewById(i.f.tab_menu_line_s);
            bVar.bcb = view.findViewById(i.f.tab_menu_line_f);
            view.setTag(bVar);
        }
        an.i(view, i.c.cp_bg_line_d);
        i.b bVar2 = (i.b) view.getTag();
        ek item = getItem(i);
        if (item != null) {
            bVar2.aCf.setText(item.name);
            if (item.isSelected) {
                an.b(bVar2.aCf, i.c.cp_link_tip_a, 1);
                an.c(bVar2.bbZ, i.e.chx_tips_list_ok);
                bVar2.bbZ.setVisibility(0);
            } else {
                an.b(bVar2.aCf, i.c.cp_cont_c, 1);
                bVar2.bbZ.setVisibility(8);
            }
            if (i >= 0 && i == getCount() - 1) {
                bVar2.bcb.setVisibility(0);
                bVar2.bca.setVisibility(8);
                an.j(bVar2.bcb, i.c.cp_bg_line_b);
            } else {
                bVar2.bca.setVisibility(0);
                bVar2.bcb.setVisibility(8);
                an.j(bVar2.bca, i.c.cp_bg_line_b);
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
    /* renamed from: gd */
    public ek getItem(int i) {
        List list;
        List list2;
        list = this.bcf.mData;
        if (list != null) {
            list2 = this.bcf.mData;
            return (ek) list2.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List list;
        List list2;
        list = this.bcf.mData;
        if (list != null) {
            list2 = this.bcf.mData;
            return list2.size();
        }
        return 0;
    }
}
