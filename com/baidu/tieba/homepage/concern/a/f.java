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
    private static int ejV;
    private static int ejW;

    public f(Context context) {
        super(context, com.baidu.tieba.homepage.concern.b.a.ekd);
        ejV = l.h(context, e.C0200e.tbds102);
        ejW = l.h(context, e.C0200e.tbds166);
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
        aVar2.ejX.setText(aVar.aCg);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.ejX.getLayoutParams();
        if (aVar.ekg) {
            layoutParams.height = ejW;
            aVar2.dKo.setVisibility(0);
        } else if (aVar.ekh) {
            layoutParams.height = ejV;
        }
        ((a) this.viewholder).ejX.setLayoutParams(layoutParams);
        aVar2.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return aVar2.getView();
    }

    /* loaded from: classes6.dex */
    public static class a extends q.a {
        private int aIf;
        public View dKo;
        public TextView ejX;

        public a(View view) {
            super(view);
            this.aIf = 3;
            this.ejX = (TextView) view.findViewById(e.g.concern_tip_txt);
            this.dKo = view.findViewById(e.g.concern_tip_top_line);
        }

        protected void onChangeSkinType(int i) {
            if (this.aIf != i) {
                al.j(getView(), e.d.cp_bg_line_e);
                al.h(this.ejX, e.d.cp_cont_d);
                al.i(this.dKo, e.d.cp_bg_line_e);
            }
        }
    }
}
