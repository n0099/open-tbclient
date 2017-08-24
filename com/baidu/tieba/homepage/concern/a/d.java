package com.baidu.tieba.homepage.concern.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.a, a> {
    private static int bwK;
    private static int cSp;

    public d(Context context) {
        super(context, com.baidu.tieba.homepage.concern.b.a.cSw);
        bwK = k.g(context, d.f.ds40);
        cSp = k.g(context, d.f.ds120);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: al */
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
        aVar2.cSq.setText(aVar.akj);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.cSq.getLayoutParams();
        if (aVar.cSx) {
            layoutParams.bottomMargin = cSp;
            aVar2.cSr.setVisibility(0);
        } else {
            layoutParams.bottomMargin = bwK;
            aVar2.cSr.setVisibility(8);
        }
        aVar2.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return aVar2.getView();
    }

    /* loaded from: classes.dex */
    public class a extends j.a {
        private int aqm;
        public TextView cSq;
        public View cSr;

        public a(View view) {
            super(view);
            this.aqm = 3;
            this.cSq = (TextView) view.findViewById(d.h.concern_tip_txt);
            this.cSr = view.findViewById(d.h.concern_tip_top_line);
        }

        protected void onChangeSkinType(int i) {
            if (this.aqm != i) {
                ai.k(getView(), d.e.cp_bg_line_d);
                ai.i(this.cSq, d.e.cp_cont_d);
                ai.j(this.cSr, d.e.cp_bg_line_c);
            }
        }
    }
}
