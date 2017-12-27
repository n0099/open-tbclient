package com.baidu.tieba.homepage.concern.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.a, a> {
    private static int eaD;
    private static int eaE;

    public f(Context context) {
        super(context, com.baidu.tieba.homepage.concern.b.a.eaL);
        eaD = l.s(context, d.e.tbds102);
        eaE = l.s(context, d.e.tbds166);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        View inflate = View.inflate(viewGroup.getContext(), d.h.concern_tip_layout, null);
        a aVar = new a(inflate);
        ViewGroup.LayoutParams generateLayoutParamsByParent = generateLayoutParamsByParent(viewGroup);
        generateLayoutParamsByParent.width = -1;
        generateLayoutParamsByParent.height = -1;
        inflate.setLayoutParams(generateLayoutParamsByParent);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.a aVar, a aVar2) {
        aVar2.eaF.setText(aVar.aXT);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.eaF.getLayoutParams();
        if (aVar.eaO) {
            layoutParams.height = eaE;
            aVar2.dDx.setVisibility(0);
        } else if (aVar.eaP) {
            layoutParams.height = eaD;
        }
        ((a) this.viewholder).eaF.setLayoutParams(layoutParams);
        aVar2.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return aVar2.getView();
    }

    /* loaded from: classes2.dex */
    public class a extends r.a {
        private int bdE;
        public View dDx;
        public TextView eaF;

        public a(View view) {
            super(view);
            this.bdE = 3;
            this.eaF = (TextView) view.findViewById(d.g.concern_tip_txt);
            this.dDx = view.findViewById(d.g.concern_tip_top_line);
        }

        protected void onChangeSkinType(int i) {
            if (this.bdE != i) {
                aj.t(getView(), d.C0108d.cp_bg_line_e);
                aj.r(this.eaF, d.C0108d.cp_cont_d);
                aj.s(this.dDx, d.C0108d.cp_bg_line_e);
            }
        }
    }
}
