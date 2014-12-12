package com.baidu.tieba.addresslist;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends BaseAdapter {
    private List<com.baidu.tbadk.coreExtra.relationship.b> So;
    final /* synthetic */ QuickSearchActivity aoo;

    private p(QuickSearchActivity quickSearchActivity) {
        this.aoo = quickSearchActivity;
        this.So = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ p(QuickSearchActivity quickSearchActivity, p pVar) {
        this(quickSearchActivity);
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.b> list) {
        this.So = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.So != null) {
            return this.So.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ec */
    public com.baidu.tbadk.coreExtra.relationship.b getItem(int i) {
        if (this.So == null || i < 0 || i >= getCount()) {
            return null;
        }
        return this.So.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        q qVar;
        com.baidu.tbadk.core.c layoutMode = this.aoo.getLayoutMode();
        TbadkCoreApplication.m255getInst().getSkinType();
        com.baidu.tbadk.coreExtra.relationship.b item = getItem(i);
        if (item == null) {
            return null;
        }
        if (view == null) {
            view = com.baidu.adp.lib.g.b.ek().inflate(this.aoo.getPageContext().getPageActivity(), x.quick_search_item, null);
            q qVar2 = new q(this.aoo, null);
            qVar2.aop = (HeadImageView) view.findViewById(w.quick_search_item_icon);
            qVar2.aoq = (TextView) view.findViewById(w.quick_search_item_text);
            view.setTag(qVar2);
            qVar = qVar2;
        } else {
            qVar = (q) view.getTag();
        }
        layoutMode.h(view);
        ax.i(view, v.addresslist_item_bg);
        if (item.getUserName() != null) {
            qVar.aoq.setText(item.getUserName());
        }
        qVar.aop.d(item.getUserPortrait(), 12, false);
        return view;
    }
}
