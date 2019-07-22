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
    private static int gcH;
    private static int gcI;

    public j(Context context) {
        super(context, com.baidu.tieba.homepage.concern.b.a.gcS);
        gcH = com.baidu.adp.lib.util.l.g(context, R.dimen.tbds102);
        gcI = com.baidu.adp.lib.util.l.g(context, R.dimen.tbds166);
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
        aVar2.gcJ.setText(aVar.bXm);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.gcJ.getLayoutParams();
        if (aVar.gcV) {
            layoutParams.height = gcI;
            aVar2.fDg.setVisibility(0);
        } else if (aVar.gcW) {
            layoutParams.height = gcH;
        }
        aVar2.gcJ.setLayoutParams(layoutParams);
        aVar2.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return aVar2.getView();
    }

    /* loaded from: classes4.dex */
    public static class a extends v.a {
        private int cdL;
        public View fDg;
        public TextView gcJ;

        public a(View view) {
            super(view);
            this.cdL = 3;
            this.gcJ = (TextView) view.findViewById(R.id.concern_tip_txt);
            this.fDg = view.findViewById(R.id.concern_tip_top_line);
        }

        protected void onChangeSkinType(int i) {
            if (this.cdL != i) {
                am.l(getView(), R.color.cp_bg_line_e);
                am.j(this.gcJ, R.color.cp_cont_d);
                am.k(this.fDg, R.color.cp_bg_line_e);
            }
        }
    }
}
