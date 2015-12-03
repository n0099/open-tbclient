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
    final /* synthetic */ m biK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.biK = mVar;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(n.g.tab_item_menu_item_view, (ViewGroup) null);
            view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(n.d.ds80)));
            i.b bVar = new i.b();
            bVar.aER = (TextView) view.findViewById(n.f.tab_menu_name);
            bVar.biE = (ImageView) view.findViewById(n.f.tab_menu_check);
            bVar.biF = view.findViewById(n.f.tab_menu_line_s);
            bVar.biG = view.findViewById(n.f.tab_menu_line_f);
            view.setTag(bVar);
        }
        as.i(view, n.c.cp_bg_line_d);
        i.b bVar2 = (i.b) view.getTag();
        fc item = getItem(i);
        if (item != null) {
            bVar2.aER.setText(item.name);
            if (item.isSelected) {
                as.b(bVar2.aER, n.c.cp_link_tip_a, 1);
                as.c(bVar2.biE, n.e.chx_tips_list_ok);
                bVar2.biE.setVisibility(0);
            } else {
                as.b(bVar2.aER, n.c.cp_cont_c, 1);
                bVar2.biE.setVisibility(8);
            }
            if (i >= 0 && i == getCount() - 1) {
                bVar2.biG.setVisibility(0);
                bVar2.biF.setVisibility(8);
                as.j(bVar2.biG, n.c.cp_bg_line_b);
            } else {
                bVar2.biF.setVisibility(0);
                bVar2.biG.setVisibility(8);
                as.j(bVar2.biF, n.c.cp_bg_line_b);
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
    /* renamed from: gz */
    public fc getItem(int i) {
        List list;
        List list2;
        list = this.biK.mData;
        if (list != null) {
            list2 = this.biK.mData;
            return (fc) list2.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List list;
        List list2;
        list = this.biK.mData;
        if (list != null) {
            list2 = this.biK.mData;
            return list2.size();
        }
        return 0;
    }
}
