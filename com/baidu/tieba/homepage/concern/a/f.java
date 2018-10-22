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
    private static int eiB;
    private static int eiC;

    public f(Context context) {
        super(context, com.baidu.tieba.homepage.concern.b.a.eiJ);
        eiB = l.h(context, e.C0175e.tbds102);
        eiC = l.h(context, e.C0175e.tbds166);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
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
        aVar2.eiD.setText(aVar.aBr);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.eiD.getLayoutParams();
        if (aVar.eiM) {
            layoutParams.height = eiC;
            aVar2.dJk.setVisibility(0);
        } else if (aVar.eiN) {
            layoutParams.height = eiB;
        }
        ((a) this.viewholder).eiD.setLayoutParams(layoutParams);
        aVar2.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return aVar2.getView();
    }

    /* loaded from: classes6.dex */
    public static class a extends q.a {
        private int aHp;
        public View dJk;
        public TextView eiD;

        public a(View view) {
            super(view);
            this.aHp = 3;
            this.eiD = (TextView) view.findViewById(e.g.concern_tip_txt);
            this.dJk = view.findViewById(e.g.concern_tip_top_line);
        }

        protected void onChangeSkinType(int i) {
            if (this.aHp != i) {
                al.j(getView(), e.d.cp_bg_line_e);
                al.h(this.eiD, e.d.cp_cont_d);
                al.i(this.dJk, e.d.cp_bg_line_e);
            }
        }
    }
}
