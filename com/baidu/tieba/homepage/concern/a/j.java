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
    private static int fXH;
    private static int fXI;

    public j(Context context) {
        super(context, com.baidu.tieba.homepage.concern.b.a.fXS);
        fXH = com.baidu.adp.lib.util.l.g(context, R.dimen.tbds102);
        fXI = com.baidu.adp.lib.util.l.g(context, R.dimen.tbds166);
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
        aVar2.fXJ.setText(aVar.bWj);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.fXJ.getLayoutParams();
        if (aVar.fXV) {
            layoutParams.height = fXI;
            aVar2.fyj.setVisibility(0);
        } else if (aVar.fXW) {
            layoutParams.height = fXH;
        }
        aVar2.fXJ.setLayoutParams(layoutParams);
        aVar2.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return aVar2.getView();
    }

    /* loaded from: classes4.dex */
    public static class a extends v.a {
        private int ccI;
        public TextView fXJ;
        public View fyj;

        public a(View view) {
            super(view);
            this.ccI = 3;
            this.fXJ = (TextView) view.findViewById(R.id.concern_tip_txt);
            this.fyj = view.findViewById(R.id.concern_tip_top_line);
        }

        protected void onChangeSkinType(int i) {
            if (this.ccI != i) {
                al.l(getView(), R.color.cp_bg_line_e);
                al.j(this.fXJ, R.color.cp_cont_d);
                al.k(this.fyj, R.color.cp_bg_line_e);
            }
        }
    }
}
