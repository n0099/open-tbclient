package com.baidu.tieba.homepage.concern.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.a, a> {
    private static int DS20;
    private static int bhz;
    private static int dek;
    private static int del;

    public f(Context context) {
        super(context, com.baidu.tieba.homepage.concern.b.a.der);
        del = l.f(context, d.e.ds37);
        dek = l.f(context, d.e.ds90);
        DS20 = l.f(context, d.e.ds20);
        bhz = l.f(context, d.e.ds32);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aI */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        View inflate = View.inflate(viewGroup.getContext(), d.h.concern_tip_layout, null);
        a aVar = new a(inflate);
        inflate.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.a aVar, a aVar2) {
        aVar2.dem.setText(aVar.ajo);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.dem.getLayoutParams();
        layoutParams.topMargin = bhz;
        layoutParams.bottomMargin = bhz;
        if (aVar.dev) {
            layoutParams.bottomMargin = dek;
            aVar2.cEJ.setVisibility(0);
        } else if (aVar.dew) {
            layoutParams.topMargin = DS20;
        } else {
            layoutParams.bottomMargin = del;
            aVar2.cEJ.setVisibility(8);
        }
        aVar2.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return aVar2.getView();
    }

    /* loaded from: classes.dex */
    public class a extends j.a {
        private int api;
        public View cEJ;
        public TextView dem;

        public a(View view) {
            super(view);
            this.api = 3;
            this.dem = (TextView) view.findViewById(d.g.concern_tip_txt);
            this.cEJ = view.findViewById(d.g.concern_tip_top_line);
        }

        protected void onChangeSkinType(int i) {
            if (this.api != i) {
                aj.k(getView(), d.C0080d.cp_bg_line_e);
                aj.i(this.dem, d.C0080d.cp_cont_j);
                aj.j(this.cEJ, d.C0080d.cp_bg_line_e);
            }
        }
    }
}
