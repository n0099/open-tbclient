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
public class w extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.a.b, a> {
    private static int jKY;
    private static int jKZ;

    public w(Context context) {
        super(context, com.baidu.tieba.homepage.concern.a.b.jLl);
        jKY = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds102);
        jKZ = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds166);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bD */
    public a c(ViewGroup viewGroup) {
        View inflate = View.inflate(viewGroup.getContext(), R.layout.concern_tip_layout, null);
        ap.setBackgroundColor(inflate, R.color.CAM_X0205);
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
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.a.b bVar, a aVar) {
        aVar.jLa.setText(bVar.tipString);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.jLa.getLayoutParams();
        if (bVar.jLo) {
            layoutParams.height = jKZ;
            aVar.bNe.setVisibility(0);
        } else if (bVar.jLp) {
            layoutParams.height = jKY;
        }
        aVar.jLa.setLayoutParams(layoutParams);
        aVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return aVar.getView();
    }

    /* loaded from: classes22.dex */
    public static class a extends af.a {
        private int aku;
        public View bNe;
        public TextView jLa;

        public a(View view) {
            super(view);
            this.aku = 3;
            this.jLa = (TextView) view.findViewById(R.id.concern_tip_txt);
            this.bNe = view.findViewById(R.id.concern_tip_top_line);
        }

        protected void onChangeSkinType(int i) {
            if (this.aku != i) {
                ap.setBackgroundColor(getView(), R.color.CAM_X0205);
                ap.setViewTextColor(this.jLa, R.color.CAM_X0109);
                ap.setBackgroundResource(this.bNe, R.color.CAM_X0205);
            }
        }
    }
}
