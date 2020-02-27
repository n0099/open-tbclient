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
/* loaded from: classes9.dex */
public class q extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.c, a> {
    private static int gXO;
    private static int gXP;

    public q(Context context) {
        super(context, com.baidu.tieba.homepage.concern.b.c.gYf);
        gXO = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds102);
        gXP = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds166);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bh */
    public a b(ViewGroup viewGroup) {
        View inflate = View.inflate(viewGroup.getContext(), R.layout.concern_tip_layout, null);
        am.setBackgroundColor(inflate, R.color.cp_bg_line_e);
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
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.c cVar, a aVar) {
        aVar.gXQ.setText(cVar.tipString);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.gXQ.getLayoutParams();
        if (cVar.gYi) {
            layoutParams.height = gXP;
            aVar.gxK.setVisibility(0);
        } else if (cVar.gYj) {
            layoutParams.height = gXO;
        }
        aVar.gXQ.setLayoutParams(layoutParams);
        aVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return aVar.getView();
    }

    /* loaded from: classes9.dex */
    public static class a extends v.a {
        private int Ni;
        public TextView gXQ;
        public View gxK;

        public a(View view) {
            super(view);
            this.Ni = 3;
            this.gXQ = (TextView) view.findViewById(R.id.concern_tip_txt);
            this.gxK = view.findViewById(R.id.concern_tip_top_line);
        }

        protected void onChangeSkinType(int i) {
            if (this.Ni != i) {
                am.setBackgroundColor(getView(), R.color.cp_bg_line_e);
                am.setViewTextColor(this.gXQ, (int) R.color.cp_cont_d);
                am.setBackgroundResource(this.gxK, R.color.cp_bg_line_e);
            }
        }
    }
}
