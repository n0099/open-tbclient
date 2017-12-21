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
    private static int dov;
    private static int dow;

    public f(Context context) {
        super(context, com.baidu.tieba.homepage.concern.b.a.doD);
        dov = l.f(context, d.e.tbds102);
        dow = l.f(context, d.e.tbds166);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aJ */
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
        aVar2.dox.setText(aVar.ajK);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.dox.getLayoutParams();
        if (aVar.doG) {
            layoutParams.height = dow;
            aVar2.cOx.setVisibility(0);
        } else if (aVar.doH) {
            layoutParams.height = dov;
        }
        ((a) this.viewholder).dox.setLayoutParams(layoutParams);
        aVar2.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return aVar2.getView();
    }

    /* loaded from: classes.dex */
    public class a extends j.a {
        private int apG;
        public View cOx;
        public TextView dox;

        public a(View view) {
            super(view);
            this.apG = 3;
            this.dox = (TextView) view.findViewById(d.g.concern_tip_txt);
            this.cOx = view.findViewById(d.g.concern_tip_top_line);
        }

        protected void onChangeSkinType(int i) {
            if (this.apG != i) {
                aj.k(getView(), d.C0095d.cp_bg_line_e);
                aj.i(this.dox, d.C0095d.cp_cont_d);
                aj.j(this.cOx, d.C0095d.cp_bg_line_e);
            }
        }
    }
}
