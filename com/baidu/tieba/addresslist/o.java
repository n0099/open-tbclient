package com.baidu.tieba.addresslist;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends BaseAdapter {
    private List<com.baidu.tbadk.coreExtra.relationship.b> Mr;
    final /* synthetic */ QuickSearchActivity agP;

    private o(QuickSearchActivity quickSearchActivity) {
        this.agP = quickSearchActivity;
        this.Mr = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ o(QuickSearchActivity quickSearchActivity, o oVar) {
        this(quickSearchActivity);
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.b> list) {
        this.Mr = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Mr != null) {
            return this.Mr.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: dI */
    public com.baidu.tbadk.coreExtra.relationship.b getItem(int i) {
        if (this.Mr == null || i < 0 || i >= getCount()) {
            return null;
        }
        return this.Mr.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        p pVar;
        com.baidu.tbadk.core.d layoutMode = this.agP.getLayoutMode();
        TbadkApplication.m251getInst().getSkinType();
        com.baidu.tbadk.coreExtra.relationship.b item = getItem(i);
        if (item == null) {
            return null;
        }
        if (view == null) {
            view = com.baidu.adp.lib.g.b.ek().inflate(this.agP, w.quick_search_item, null);
            p pVar2 = new p(this.agP, null);
            pVar2.agQ = (HeadImageView) view.findViewById(v.quick_search_item_icon);
            pVar2.agR = (TextView) view.findViewById(v.quick_search_item_text);
            view.setTag(pVar2);
            pVar = pVar2;
        } else {
            pVar = (p) view.getTag();
        }
        layoutMode.h(view);
        aw.h(view, u.addresslist_item_bg);
        if (item.getUserName() != null) {
            pVar.agR.setText(item.getUserName());
        }
        pVar.agQ.c(item.getUserPortrait(), 12, false);
        return view;
    }
}
