package com.baidu.tieba.homepage.concern.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class t extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.c, a> {
    private static int iti;
    private static int itj;

    public t(Context context) {
        super(context, com.baidu.tieba.homepage.concern.b.c.itr);
        iti = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds102);
        itj = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds166);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bA */
    public a b(ViewGroup viewGroup) {
        View inflate = View.inflate(viewGroup.getContext(), R.layout.concern_tip_layout, null);
        ao.setBackgroundColor(inflate, R.color.cp_bg_line_e);
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
        aVar.itk.setText(cVar.tipString);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.itk.getLayoutParams();
        if (cVar.itu) {
            layoutParams.height = itj;
            aVar.hQh.setVisibility(0);
        } else if (cVar.itv) {
            layoutParams.height = iti;
        }
        aVar.itk.setLayoutParams(layoutParams);
        aVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return aVar.getView();
    }

    /* loaded from: classes16.dex */
    public static class a extends ad.a {
        private int aho;
        public View hQh;
        public TextView itk;

        public a(View view) {
            super(view);
            this.aho = 3;
            this.itk = (TextView) view.findViewById(R.id.concern_tip_txt);
            this.hQh = view.findViewById(R.id.concern_tip_top_line);
        }

        protected void onChangeSkinType(int i) {
            if (this.aho != i) {
                ao.setBackgroundColor(getView(), R.color.cp_bg_line_e);
                ao.setViewTextColor(this.itk, R.color.cp_cont_d);
                ao.setBackgroundResource(this.hQh, R.color.cp_bg_line_e);
            }
        }
    }
}
