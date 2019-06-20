package com.baidu.tieba.homepage.concern.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class j extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.a, a> {
    private static int fXK;
    private static int fXL;

    public j(Context context) {
        super(context, com.baidu.tieba.homepage.concern.b.a.fXV);
        fXK = com.baidu.adp.lib.util.l.g(context, R.dimen.tbds102);
        fXL = com.baidu.adp.lib.util.l.g(context, R.dimen.tbds166);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ba */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        View inflate = View.inflate(viewGroup.getContext(), R.layout.concern_tip_layout, null);
        al.l(inflate, R.color.cp_bg_line_e);
        a aVar = new a(inflate);
        ViewGroup.LayoutParams generateLayoutParamsByParent = generateLayoutParamsByParent(viewGroup);
        generateLayoutParamsByParent.width = -1;
        generateLayoutParamsByParent.height = -2;
        inflate.setLayoutParams(generateLayoutParamsByParent);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.a aVar, a aVar2) {
        aVar2.fXM.setText(aVar.bWk);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.fXM.getLayoutParams();
        if (aVar.fXY) {
            layoutParams.height = fXL;
            aVar2.fyk.setVisibility(0);
        } else if (aVar.fXZ) {
            layoutParams.height = fXK;
        }
        aVar2.fXM.setLayoutParams(layoutParams);
        aVar2.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return aVar2.getView();
    }

    /* loaded from: classes4.dex */
    public static class a extends v.a {
        private int ccJ;
        public TextView fXM;
        public View fyk;

        public a(View view) {
            super(view);
            this.ccJ = 3;
            this.fXM = (TextView) view.findViewById(R.id.concern_tip_txt);
            this.fyk = view.findViewById(R.id.concern_tip_top_line);
        }

        protected void onChangeSkinType(int i) {
            if (this.ccJ != i) {
                al.l(getView(), R.color.cp_bg_line_e);
                al.j(this.fXM, R.color.cp_cont_d);
                al.k(this.fyk, R.color.cp_bg_line_e);
            }
        }
    }
}
