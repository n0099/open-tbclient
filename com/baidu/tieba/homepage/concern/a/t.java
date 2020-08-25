package com.baidu.tieba.homepage.concern.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class t extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.c, a> {
    private static int iHA;
    private static int iHz;

    public t(Context context) {
        super(context, com.baidu.tieba.homepage.concern.b.c.iHI);
        iHz = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds102);
        iHA = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds166);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bz */
    public a b(ViewGroup viewGroup) {
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
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.c cVar, a aVar) {
        aVar.iHB.setText(cVar.tipString);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.iHB.getLayoutParams();
        if (cVar.iHL) {
            layoutParams.height = iHA;
            aVar.ies.setVisibility(0);
        } else if (cVar.iHM) {
            layoutParams.height = iHz;
        }
        aVar.iHB.setLayoutParams(layoutParams);
        aVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return aVar.getView();
    }

    /* loaded from: classes16.dex */
    public static class a extends af.a {
        private int aiB;
        public TextView iHB;
        public View ies;

        public a(View view) {
            super(view);
            this.aiB = 3;
            this.iHB = (TextView) view.findViewById(R.id.concern_tip_txt);
            this.ies = view.findViewById(R.id.concern_tip_top_line);
        }

        protected void onChangeSkinType(int i) {
            if (this.aiB != i) {
                ap.setBackgroundColor(getView(), R.color.cp_bg_line_e);
                ap.setViewTextColor(this.iHB, R.color.cp_cont_d);
                ap.setBackgroundResource(this.ies, R.color.cp_bg_line_e);
            }
        }
    }
}
