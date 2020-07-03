package com.baidu.tieba.homepage.concern.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class t extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.c, a> {
    private static int inf;
    private static int ing;

    public t(Context context) {
        super(context, com.baidu.tieba.homepage.concern.b.c.ino);
        inf = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds102);
        ing = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds166);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bz */
    public a b(ViewGroup viewGroup) {
        View inflate = View.inflate(viewGroup.getContext(), R.layout.concern_tip_layout, null);
        an.setBackgroundColor(inflate, R.color.cp_bg_line_e);
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
        aVar.inh.setText(cVar.tipString);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.inh.getLayoutParams();
        if (cVar.inr) {
            layoutParams.height = ing;
            aVar.hKh.setVisibility(0);
        } else if (cVar.f7int) {
            layoutParams.height = inf;
        }
        aVar.inh.setLayoutParams(layoutParams);
        aVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return aVar.getView();
    }

    /* loaded from: classes9.dex */
    public static class a extends ad.a {
        private int ahx;
        public View hKh;
        public TextView inh;

        public a(View view) {
            super(view);
            this.ahx = 3;
            this.inh = (TextView) view.findViewById(R.id.concern_tip_txt);
            this.hKh = view.findViewById(R.id.concern_tip_top_line);
        }

        protected void onChangeSkinType(int i) {
            if (this.ahx != i) {
                an.setBackgroundColor(getView(), R.color.cp_bg_line_e);
                an.setViewTextColor(this.inh, (int) R.color.cp_cont_d);
                an.setBackgroundResource(this.hKh, R.color.cp_bg_line_e);
            }
        }
    }
}
