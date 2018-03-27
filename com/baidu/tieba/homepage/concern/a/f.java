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
    private static int egy;
    private static int egz;

    public f(Context context) {
        super(context, com.baidu.tieba.homepage.concern.b.a.egG);
        egy = l.t(context, d.e.tbds102);
        egz = l.t(context, d.e.tbds166);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aN */
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
        aVar2.egA.setText(aVar.aZz);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.egA.getLayoutParams();
        if (aVar.egJ) {
            layoutParams.height = egz;
            aVar2.dLn.setVisibility(0);
        } else if (aVar.egK) {
            layoutParams.height = egy;
        }
        ((a) this.viewholder).egA.setLayoutParams(layoutParams);
        aVar2.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return aVar2.getView();
    }

    /* loaded from: classes2.dex */
    public class a extends r.a {
        private int bfC;
        public View dLn;
        public TextView egA;

        public a(View view) {
            super(view);
            this.bfC = 3;
            this.egA = (TextView) view.findViewById(d.g.concern_tip_txt);
            this.dLn = view.findViewById(d.g.concern_tip_top_line);
        }

        protected void onChangeSkinType(int i) {
            if (this.bfC != i) {
                aj.t(getView(), d.C0141d.cp_bg_line_e);
                aj.r(this.egA, d.C0141d.cp_cont_d);
                aj.s(this.dLn, d.C0141d.cp_bg_line_e);
            }
        }
    }
}
