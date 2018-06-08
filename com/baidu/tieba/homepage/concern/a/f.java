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
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.a, a> {
    private static int dNp;
    private static int dNq;

    public f(Context context) {
        super(context, com.baidu.tieba.homepage.concern.b.a.dNw);
        dNp = l.e(context, d.e.tbds102);
        dNq = l.e(context, d.e.tbds166);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aN */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        View inflate = View.inflate(viewGroup.getContext(), d.i.concern_tip_layout, null);
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
        aVar2.dNr.setText(aVar.atk);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.dNr.getLayoutParams();
        if (aVar.dNz) {
            layoutParams.height = dNq;
            aVar2.doK.setVisibility(0);
        } else if (aVar.dNA) {
            layoutParams.height = dNp;
        }
        ((a) this.viewholder).dNr.setLayoutParams(layoutParams);
        aVar2.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return aVar2.getView();
    }

    /* loaded from: classes2.dex */
    public static class a extends q.a {
        private int ayX;
        public TextView dNr;
        public View doK;

        public a(View view) {
            super(view);
            this.ayX = 3;
            this.dNr = (TextView) view.findViewById(d.g.concern_tip_txt);
            this.doK = view.findViewById(d.g.concern_tip_top_line);
        }

        protected void onChangeSkinType(int i) {
            if (this.ayX != i) {
                al.j(getView(), d.C0141d.cp_bg_line_e);
                al.h(this.dNr, d.C0141d.cp_cont_d);
                al.i(this.doK, d.C0141d.cp_bg_line_e);
            }
        }
    }
}
