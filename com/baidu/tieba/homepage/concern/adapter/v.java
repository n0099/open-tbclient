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
/* loaded from: classes22.dex */
public class v extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.a.c, a> {
    private static int jwH;
    private static int jwI;

    public v(Context context) {
        super(context, com.baidu.tieba.homepage.concern.a.c.jwT);
        jwH = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds102);
        jwI = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds166);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bE */
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
        aVar.jwJ.setText(cVar.tipString);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.jwJ.getLayoutParams();
        if (cVar.jwW) {
            layoutParams.height = jwI;
            aVar.bJH.setVisibility(0);
        } else if (cVar.jwX) {
            layoutParams.height = jwH;
        }
        aVar.jwJ.setLayoutParams(layoutParams);
        aVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return aVar.getView();
    }

    /* loaded from: classes22.dex */
    public static class a extends af.a {
        private int ajq;
        public View bJH;
        public TextView jwJ;

        public a(View view) {
            super(view);
            this.ajq = 3;
            this.jwJ = (TextView) view.findViewById(R.id.concern_tip_txt);
            this.bJH = view.findViewById(R.id.concern_tip_top_line);
        }

        protected void onChangeSkinType(int i) {
            if (this.ajq != i) {
                ap.setBackgroundColor(getView(), R.color.cp_bg_line_e);
                ap.setViewTextColor(this.jwJ, R.color.cp_cont_d);
                ap.setBackgroundResource(this.bJH, R.color.cp_bg_line_e);
            }
        }
    }
}
