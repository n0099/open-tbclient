package com.baidu.tieba.addresslist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends BaseAdapter {
    final /* synthetic */ QuickSearchActivity a;
    private List<com.baidu.tbadk.coreExtra.relationship.b> b;
    private LayoutInflater c;

    private m(QuickSearchActivity quickSearchActivity) {
        this.a = quickSearchActivity;
        this.b = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ m(QuickSearchActivity quickSearchActivity, m mVar) {
        this(quickSearchActivity);
    }

    public void a(List<com.baidu.tbadk.coreExtra.relationship.b> list) {
        this.b = list;
        this.c = LayoutInflater.from(this.a);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b != null) {
            return this.b.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public com.baidu.tbadk.coreExtra.relationship.b getItem(int i) {
        if (this.b == null || i < 0 || i >= getCount()) {
            return null;
        }
        return this.b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        n nVar;
        com.baidu.tbadk.core.c layoutMode = this.a.getLayoutMode();
        boolean z = TbadkApplication.m252getInst().getSkinType() == 1;
        com.baidu.tbadk.coreExtra.relationship.b item = getItem(i);
        if (item == null) {
            return null;
        }
        if (view == null) {
            view = this.c.inflate(v.quick_search_item, (ViewGroup) null);
            n nVar2 = new n(this.a, null);
            nVar2.a = (HeadImageView) view.findViewById(u.quick_search_item_icon);
            nVar2.b = (TextView) view.findViewById(u.quick_search_item_text);
            view.setTag(nVar2);
            nVar = nVar2;
        } else {
            nVar = (n) view.getTag();
        }
        layoutMode.a(view);
        view.setBackgroundResource(z ? t.addresslist_item_bg_1 : t.addresslist_item_bg);
        if (item.b() != null) {
            nVar.b.setText(item.b());
        }
        nVar.a.a(item.d(), 12, false);
        return view;
    }
}
