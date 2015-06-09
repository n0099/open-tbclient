package com.baidu.tieba.addresslist;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadImageView;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends BaseAdapter {
    final /* synthetic */ QuickSearchActivity azv;
    private List<com.baidu.tbadk.coreExtra.relationship.a> azw;

    private s(QuickSearchActivity quickSearchActivity) {
        this.azv = quickSearchActivity;
        this.azw = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ s(QuickSearchActivity quickSearchActivity, s sVar) {
        this(quickSearchActivity);
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.azw = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.azw != null) {
            return this.azw.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ey */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        if (this.azw == null || i < 0 || i >= getCount()) {
            return null;
        }
        return this.azw.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        t tVar;
        com.baidu.tbadk.core.c layoutMode = this.azv.getLayoutMode();
        TbadkCoreApplication.m411getInst().getSkinType();
        com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
        if (item == null) {
            return null;
        }
        if (view == null) {
            view = com.baidu.adp.lib.g.b.hr().inflate(this.azv.getPageContext().getPageActivity(), com.baidu.tieba.r.quick_search_item, null);
            t tVar2 = new t(this.azv, null);
            tVar2.azx = (HeadImageView) view.findViewById(com.baidu.tieba.q.quick_search_item_icon);
            tVar2.azy = (TextView) view.findViewById(com.baidu.tieba.q.quick_search_item_text);
            view.setTag(tVar2);
            tVar = tVar2;
        } else {
            tVar = (t) view.getTag();
        }
        layoutMode.j(view);
        ay.i(view, com.baidu.tieba.p.addresslist_item_bg);
        if (item.getUserName() != null) {
            tVar.azy.setText(item.getUserName());
        }
        tVar.azx.c(item.getUserPortrait(), 12, false);
        return view;
    }
}
