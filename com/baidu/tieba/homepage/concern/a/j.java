package com.baidu.tieba.homepage.concern.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class j extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.a, a> {
    private static int gfp;
    private static int gfq;

    public j(Context context) {
        super(context, com.baidu.tieba.homepage.concern.b.a.gfA);
        gfp = com.baidu.adp.lib.util.l.g(context, R.dimen.tbds102);
        gfq = com.baidu.adp.lib.util.l.g(context, R.dimen.tbds166);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: be */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        View inflate = View.inflate(viewGroup.getContext(), R.layout.concern_tip_layout, null);
        am.l(inflate, R.color.cp_bg_line_e);
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
        aVar2.gfr.setText(aVar.bYl);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.gfr.getLayoutParams();
        if (aVar.gfD) {
            layoutParams.height = gfq;
            aVar2.fFH.setVisibility(0);
        } else if (aVar.gfE) {
            layoutParams.height = gfp;
        }
        aVar2.gfr.setLayoutParams(layoutParams);
        aVar2.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return aVar2.getView();
    }

    /* loaded from: classes4.dex */
    public static class a extends v.a {
        private int ceL;
        public View fFH;
        public TextView gfr;

        public a(View view) {
            super(view);
            this.ceL = 3;
            this.gfr = (TextView) view.findViewById(R.id.concern_tip_txt);
            this.fFH = view.findViewById(R.id.concern_tip_top_line);
        }

        protected void onChangeSkinType(int i) {
            if (this.ceL != i) {
                am.l(getView(), R.color.cp_bg_line_e);
                am.j(this.gfr, R.color.cp_cont_d);
                am.k(this.fFH, R.color.cp_bg_line_e);
            }
        }
    }
}
