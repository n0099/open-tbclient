package com.baidu.tieba.addresslist;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends BaseAdapter {
    final /* synthetic */ QuickSearchActivity axA;
    private List<com.baidu.tbadk.coreExtra.relationship.a> axB;

    private n(QuickSearchActivity quickSearchActivity) {
        this.axA = quickSearchActivity;
        this.axB = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ n(QuickSearchActivity quickSearchActivity, n nVar) {
        this(quickSearchActivity);
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.axB = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.axB != null) {
            return this.axB.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: em */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        if (this.axB == null || i < 0 || i >= getCount()) {
            return null;
        }
        return this.axB.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        o oVar;
        com.baidu.tbadk.core.c layoutMode = this.axA.getLayoutMode();
        TbadkCoreApplication.m411getInst().getSkinType();
        com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
        if (item == null) {
            return null;
        }
        if (view == null) {
            view = com.baidu.adp.lib.g.b.hH().inflate(this.axA.getPageContext().getPageActivity(), w.quick_search_item, null);
            o oVar2 = new o(this.axA, null);
            oVar2.axC = (HeadImageView) view.findViewById(v.quick_search_item_icon);
            oVar2.axD = (TextView) view.findViewById(v.quick_search_item_text);
            view.setTag(oVar2);
            oVar = oVar2;
        } else {
            oVar = (o) view.getTag();
        }
        layoutMode.h(view);
        ba.i(view, u.addresslist_item_bg);
        if (item.getUserName() != null) {
            oVar.axD.setText(item.getUserName());
        }
        oVar.axC.c(item.getUserPortrait(), 12, false);
        return view;
    }
}
