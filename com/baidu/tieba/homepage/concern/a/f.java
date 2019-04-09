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
    private static int fGy;
    private static int fGz;

    public f(Context context) {
        super(context, com.baidu.tieba.homepage.concern.b.a.fGH);
        fGy = l.h(context, d.e.tbds102);
        fGz = l.h(context, d.e.tbds166);
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
        aVar2.fGA.setText(aVar.bOv);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.fGA.getLayoutParams();
        if (aVar.fGK) {
            layoutParams.height = fGz;
            aVar2.fhN.setVisibility(0);
        } else if (aVar.fGL) {
            layoutParams.height = fGy;
        }
        ((a) this.viewholder).fGA.setLayoutParams(layoutParams);
        aVar2.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return aVar2.getView();
    }

    /* loaded from: classes4.dex */
    public static class a extends v.a {
        private int bUN;
        public TextView fGA;
        public View fhN;

        public a(View view) {
            super(view);
            this.bUN = 3;
            this.fGA = (TextView) view.findViewById(d.g.concern_tip_txt);
            this.fhN = view.findViewById(d.g.concern_tip_top_line);
        }

        protected void onChangeSkinType(int i) {
            if (this.bUN != i) {
                al.l(getView(), d.C0277d.cp_bg_line_e);
                al.j(this.fGA, d.C0277d.cp_cont_d);
                al.k(this.fhN, d.C0277d.cp_bg_line_e);
            }
        }
    }
}
