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
    private static int aRY;
    private static int cWg;
    private static int cWh;
    private static int cWi;

    public f(Context context) {
        super(context, com.baidu.tieba.homepage.concern.b.a.cWo);
        cWh = l.f(context, d.f.ds37);
        cWg = l.f(context, d.f.ds90);
        cWi = l.f(context, d.f.ds20);
        aRY = l.f(context, d.f.ds32);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ar */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        View inflate = View.inflate(viewGroup.getContext(), d.j.concern_tip_layout, null);
        a aVar = new a(inflate);
        inflate.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.a aVar, a aVar2) {
        aVar2.cWj.setText(aVar.aje);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.cWj.getLayoutParams();
        layoutParams.topMargin = aRY;
        layoutParams.bottomMargin = aRY;
        if (aVar.cWr) {
            layoutParams.bottomMargin = cWg;
            aVar2.cVZ.setVisibility(0);
        } else if (aVar.cWs) {
            layoutParams.topMargin = cWi;
        } else {
            layoutParams.bottomMargin = cWh;
            aVar2.cVZ.setVisibility(8);
        }
        aVar2.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return aVar2.getView();
    }

    /* loaded from: classes.dex */
    public class a extends j.a {
        private int aoZ;
        public View cVZ;
        public TextView cWj;

        public a(View view) {
            super(view);
            this.aoZ = 3;
            this.cWj = (TextView) view.findViewById(d.h.concern_tip_txt);
            this.cVZ = view.findViewById(d.h.concern_tip_top_line);
        }

        protected void onChangeSkinType(int i) {
            if (this.aoZ != i) {
                aj.k(getView(), d.e.cp_bg_line_e);
                aj.i(this.cWj, d.e.cp_cont_j);
                aj.j(this.cVZ, d.e.cp_bg_line_e);
            }
        }
    }
}
