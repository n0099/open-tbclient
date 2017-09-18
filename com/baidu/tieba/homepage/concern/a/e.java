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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.a, a> {
    private static int cZG;
    private static int cZH;

    public e(Context context) {
        super(context, com.baidu.tieba.homepage.concern.b.a.cZO);
        cZH = k.f(context, d.f.ds37);
        cZG = k.f(context, d.f.ds120);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aq */
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
        aVar2.cZI.setText(aVar.ajC);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.cZI.getLayoutParams();
        if (aVar.cZP) {
            layoutParams.bottomMargin = cZG;
            aVar2.cZJ.setVisibility(0);
        } else {
            layoutParams.bottomMargin = cZH;
            aVar2.cZJ.setVisibility(8);
        }
        aVar2.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return aVar2.getView();
    }

    /* loaded from: classes.dex */
    public class a extends j.a {
        private int apQ;
        public TextView cZI;
        public View cZJ;

        public a(View view) {
            super(view);
            this.apQ = 3;
            this.cZI = (TextView) view.findViewById(d.h.concern_tip_txt);
            this.cZJ = view.findViewById(d.h.concern_tip_top_line);
        }

        protected void onChangeSkinType(int i) {
            if (this.apQ != i) {
                aj.k(getView(), d.e.cp_bg_line_c);
                aj.i(this.cZI, d.e.cp_cont_j);
                aj.j(this.cZJ, d.e.cp_bg_line_c);
            }
        }
    }
}
