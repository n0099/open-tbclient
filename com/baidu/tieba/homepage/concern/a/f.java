package com.baidu.tieba.homepage.concern.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.a, a> {
    private static int fGK;
    private static int fGL;

    public f(Context context) {
        super(context, com.baidu.tieba.homepage.concern.b.a.fGT);
        fGK = l.h(context, d.e.tbds102);
        fGL = l.h(context, d.e.tbds166);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ba */
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
        aVar2.fGM.setText(aVar.bOs);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.fGM.getLayoutParams();
        if (aVar.fGW) {
            layoutParams.height = fGL;
            aVar2.fib.setVisibility(0);
        } else if (aVar.fGX) {
            layoutParams.height = fGK;
        }
        ((a) this.viewholder).fGM.setLayoutParams(layoutParams);
        aVar2.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return aVar2.getView();
    }

    /* loaded from: classes4.dex */
    public static class a extends v.a {
        private int bUK;
        public TextView fGM;
        public View fib;

        public a(View view) {
            super(view);
            this.bUK = 3;
            this.fGM = (TextView) view.findViewById(d.g.concern_tip_txt);
            this.fib = view.findViewById(d.g.concern_tip_top_line);
        }

        protected void onChangeSkinType(int i) {
            if (this.bUK != i) {
                al.l(getView(), d.C0277d.cp_bg_line_e);
                al.j(this.fGM, d.C0277d.cp_cont_d);
                al.k(this.fib, d.C0277d.cp_bg_line_e);
            }
        }
    }
}
