package com.baidu.tieba.homepage.concern.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.a, a> {
    private static int eqP;
    private static int eqQ;

    public f(Context context) {
        super(context, com.baidu.tieba.homepage.concern.b.a.eqX);
        eqP = l.h(context, e.C0210e.tbds102);
        eqQ = l.h(context, e.C0210e.tbds166);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aM */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        View inflate = View.inflate(viewGroup.getContext(), e.h.concern_tip_layout, null);
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
        aVar2.eqR.setText(aVar.aFG);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.eqR.getLayoutParams();
        if (aVar.era) {
            layoutParams.height = eqQ;
            aVar2.dQR.setVisibility(0);
        } else if (aVar.erb) {
            layoutParams.height = eqP;
        }
        ((a) this.viewholder).eqR.setLayoutParams(layoutParams);
        aVar2.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return aVar2.getView();
    }

    /* loaded from: classes6.dex */
    public static class a extends q.a {
        private int aLF;
        public View dQR;
        public TextView eqR;

        public a(View view) {
            super(view);
            this.aLF = 3;
            this.eqR = (TextView) view.findViewById(e.g.concern_tip_txt);
            this.dQR = view.findViewById(e.g.concern_tip_top_line);
        }

        protected void onChangeSkinType(int i) {
            if (this.aLF != i) {
                al.j(getView(), e.d.cp_bg_line_e);
                al.h(this.eqR, e.d.cp_cont_d);
                al.i(this.dQR, e.d.cp_bg_line_e);
            }
        }
    }
}
