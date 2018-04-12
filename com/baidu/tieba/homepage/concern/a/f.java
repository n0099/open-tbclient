package com.baidu.tieba.homepage.concern.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.a, a> {
    private static int dBe;
    private static int dBf;

    public f(Context context) {
        super(context, com.baidu.tieba.homepage.concern.b.a.dBm);
        dBe = l.e(context, d.e.tbds102);
        dBf = l.e(context, d.e.tbds166);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aM */
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
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.a aVar, a aVar2) {
        aVar2.dBg.setText(aVar.alc);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.dBg.getLayoutParams();
        if (aVar.dBp) {
            layoutParams.height = dBf;
            aVar2.deq.setVisibility(0);
        } else if (aVar.dBq) {
            layoutParams.height = dBe;
        }
        ((a) this.viewholder).dBg.setLayoutParams(layoutParams);
        aVar2.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return aVar2.getView();
    }

    /* loaded from: classes2.dex */
    public class a extends q.a {
        private int aqQ;
        public TextView dBg;
        public View deq;

        public a(View view2) {
            super(view2);
            this.aqQ = 3;
            this.dBg = (TextView) view2.findViewById(d.g.concern_tip_txt);
            this.deq = view2.findViewById(d.g.concern_tip_top_line);
        }

        protected void onChangeSkinType(int i) {
            if (this.aqQ != i) {
                ak.j(getView(), d.C0126d.cp_bg_line_e);
                ak.h(this.dBg, d.C0126d.cp_cont_d);
                ak.i(this.deq, d.C0126d.cp_bg_line_e);
            }
        }
    }
}
