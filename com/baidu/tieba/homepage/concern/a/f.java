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
    private static int bhI;
    private static int deF;
    private static int deG;

    public f(Context context) {
        super(context, com.baidu.tieba.homepage.concern.b.a.deM);
        deG = l.f(context, d.e.ds37);
        deF = l.f(context, d.e.ds90);
        DS20 = l.f(context, d.e.ds20);
        bhI = l.f(context, d.e.ds32);
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
        aVar2.deH.setText(aVar.ajo);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.deH.getLayoutParams();
        layoutParams.topMargin = bhI;
        layoutParams.bottomMargin = bhI;
        if (aVar.deP) {
            layoutParams.bottomMargin = deF;
            aVar2.cFc.setVisibility(0);
        } else if (aVar.deQ) {
            layoutParams.topMargin = DS20;
        } else {
            layoutParams.bottomMargin = deG;
            aVar2.cFc.setVisibility(8);
        }
        aVar2.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return aVar2.getView();
    }

    /* loaded from: classes.dex */
    public class a extends j.a {
        private int aph;
        public View cFc;
        public TextView deH;

        public a(View view) {
            super(view);
            this.aph = 3;
            this.deH = (TextView) view.findViewById(d.g.concern_tip_txt);
            this.cFc = view.findViewById(d.g.concern_tip_top_line);
        }

        protected void onChangeSkinType(int i) {
            if (this.aph != i) {
                aj.k(getView(), d.C0080d.cp_bg_line_e);
                aj.i(this.deH, d.C0080d.cp_cont_j);
                aj.j(this.cFc, d.C0080d.cp_bg_line_e);
            }
        }
    }
}
