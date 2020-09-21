package com.baidu.tieba.homepage.concern.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class u extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.a.c, a> {
    private static int iPs;
    private static int iPt;

    public u(Context context) {
        super(context, com.baidu.tieba.homepage.concern.a.c.iPE);
        iPs = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds102);
        iPt = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds166);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bA */
    public a c(ViewGroup viewGroup) {
        View inflate = View.inflate(viewGroup.getContext(), R.layout.concern_tip_layout, null);
        ap.setBackgroundColor(inflate, R.color.cp_bg_line_e);
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
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.a.c cVar, a aVar) {
        aVar.iPu.setText(cVar.tipString);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.iPu.getLayoutParams();
        if (cVar.iPH) {
            layoutParams.height = iPt;
            aVar.ily.setVisibility(0);
        } else if (cVar.iPI) {
            layoutParams.height = iPs;
        }
        aVar.iPu.setLayoutParams(layoutParams);
        aVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return aVar.getView();
    }

    /* loaded from: classes21.dex */
    public static class a extends af.a {
        private int aiX;
        public TextView iPu;
        public View ily;

        public a(View view) {
            super(view);
            this.aiX = 3;
            this.iPu = (TextView) view.findViewById(R.id.concern_tip_txt);
            this.ily = view.findViewById(R.id.concern_tip_top_line);
        }

        protected void onChangeSkinType(int i) {
            if (this.aiX != i) {
                ap.setBackgroundColor(getView(), R.color.cp_bg_line_e);
                ap.setViewTextColor(this.iPu, R.color.cp_cont_d);
                ap.setBackgroundResource(this.ily, R.color.cp_bg_line_e);
            }
        }
    }
}
