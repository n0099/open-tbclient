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
    private static int gdU;
    private static int gdV;

    public j(Context context) {
        super(context, com.baidu.tieba.homepage.concern.b.a.gef);
        gdU = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds102);
        gdV = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds166);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bg */
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
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.a aVar, a aVar2) {
        aVar2.gdW.setText(aVar.tipString);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.gdW.getLayoutParams();
        if (aVar.gei) {
            layoutParams.height = gdV;
            aVar2.fEh.setVisibility(0);
        } else if (aVar.gej) {
            layoutParams.height = gdU;
        }
        aVar2.gdW.setLayoutParams(layoutParams);
        aVar2.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return aVar2.getView();
    }

    /* loaded from: classes4.dex */
    public static class a extends v.a {
        private int csg;
        public View fEh;
        public TextView gdW;

        public a(View view) {
            super(view);
            this.csg = 3;
            this.gdW = (TextView) view.findViewById(R.id.concern_tip_txt);
            this.fEh = view.findViewById(R.id.concern_tip_top_line);
        }

        protected void onChangeSkinType(int i) {
            if (this.csg != i) {
                am.setBackgroundColor(getView(), R.color.cp_bg_line_e);
                am.setViewTextColor(this.gdW, (int) R.color.cp_cont_d);
                am.setBackgroundResource(this.fEh, R.color.cp_bg_line_e);
            }
        }
    }
}
