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
    private static int aRL;
    private static int cVU;
    private static int cVV;
    private static int cVW;

    public f(Context context) {
        super(context, com.baidu.tieba.homepage.concern.b.a.cWc);
        cVV = l.f(context, d.f.ds37);
        cVU = l.f(context, d.f.ds90);
        cVW = l.f(context, d.f.ds20);
        aRL = l.f(context, d.f.ds32);
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
        aVar2.cVX.setText(aVar.aiS);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.cVX.getLayoutParams();
        layoutParams.topMargin = aRL;
        layoutParams.bottomMargin = aRL;
        if (aVar.cWf) {
            layoutParams.bottomMargin = cVU;
            aVar2.cVN.setVisibility(0);
        } else if (aVar.cWg) {
            layoutParams.topMargin = cVW;
        } else {
            layoutParams.bottomMargin = cVV;
            aVar2.cVN.setVisibility(8);
        }
        aVar2.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return aVar2.getView();
    }

    /* loaded from: classes.dex */
    public class a extends j.a {
        private int aoN;
        public View cVN;
        public TextView cVX;

        public a(View view) {
            super(view);
            this.aoN = 3;
            this.cVX = (TextView) view.findViewById(d.h.concern_tip_txt);
            this.cVN = view.findViewById(d.h.concern_tip_top_line);
        }

        protected void onChangeSkinType(int i) {
            if (this.aoN != i) {
                aj.k(getView(), d.e.cp_bg_line_e);
                aj.i(this.cVX, d.e.cp_cont_j);
                aj.j(this.cVN, d.e.cp_bg_line_e);
            }
        }
    }
}
