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
    private static int gdx;
    private static int gdy;

    public j(Context context) {
        super(context, com.baidu.tieba.homepage.concern.b.a.gdI);
        gdx = com.baidu.adp.lib.util.l.g(context, R.dimen.tbds102);
        gdy = com.baidu.adp.lib.util.l.g(context, R.dimen.tbds166);
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
        aVar2.gdz.setText(aVar.bXs);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.gdz.getLayoutParams();
        if (aVar.gdL) {
            layoutParams.height = gdy;
            aVar2.fDU.setVisibility(0);
        } else if (aVar.gdM) {
            layoutParams.height = gdx;
        }
        aVar2.gdz.setLayoutParams(layoutParams);
        aVar2.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return aVar2.getView();
    }

    /* loaded from: classes4.dex */
    public static class a extends v.a {
        private int cdS;
        public View fDU;
        public TextView gdz;

        public a(View view) {
            super(view);
            this.cdS = 3;
            this.gdz = (TextView) view.findViewById(R.id.concern_tip_txt);
            this.fDU = view.findViewById(R.id.concern_tip_top_line);
        }

        protected void onChangeSkinType(int i) {
            if (this.cdS != i) {
                am.l(getView(), R.color.cp_bg_line_e);
                am.j(this.gdz, R.color.cp_cont_d);
                am.k(this.fDU, R.color.cp_bg_line_e);
            }
        }
    }
}
