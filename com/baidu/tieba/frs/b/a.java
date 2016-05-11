package com.baidu.tieba.frs.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.x;
import com.baidu.tieba.frs.bw;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.v;
/* loaded from: classes.dex */
public class a extends bw<x, b> {
    private b brN;
    private x brO;

    public a(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: N */
    public b b(ViewGroup viewGroup) {
        View a = v.a(this.bek.getPageContext(), this.brO);
        if (a == null) {
            return null;
        }
        return new b(a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bw, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, x xVar, b bVar) {
        super.a(i, view, viewGroup, (ViewGroup) xVar, (x) bVar);
        View view2 = bVar.getView();
        v.c(view2, xVar.getCardInfo());
        return view2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, x xVar) {
        View view2;
        this.brO = xVar;
        int a = v.a(xVar);
        if (q(view, a)) {
            this.brN = b(viewGroup);
            if (this.brN == null) {
                return null;
            }
            view2 = this.brN.getView();
            view2.setTag(t.g.frs, Integer.valueOf(a));
        } else {
            view2 = view;
        }
        return a(i, view2, viewGroup, xVar, (b) view2.getTag());
    }

    private boolean q(View view, int i) {
        if (view == null || view.getTag() == null || this.brN == null) {
            return true;
        }
        if (this.brN.getClass().isAssignableFrom(view.getTag().getClass()) && view.getTag().getClass().isAssignableFrom(this.brN.getClass())) {
            return ((view.getTag(t.g.frs) instanceof Integer) && ((Integer) view.getTag(t.g.frs)).intValue() == i) ? false : true;
        }
        return true;
    }
}
