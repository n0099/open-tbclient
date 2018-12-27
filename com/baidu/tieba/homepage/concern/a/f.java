package com.baidu.tieba.homepage.concern.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.a, a> {
    private static int etH;
    private static int etI;

    public f(Context context) {
        super(context, com.baidu.tieba.homepage.concern.b.a.etP);
        etH = l.h(context, e.C0210e.tbds102);
        etI = l.h(context, e.C0210e.tbds166);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aN */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        View inflate = View.inflate(viewGroup.getContext(), e.h.concern_tip_layout, null);
        a aVar = new a(inflate);
        ViewGroup.LayoutParams generateLayoutParamsByParent = generateLayoutParamsByParent(viewGroup);
        generateLayoutParamsByParent.width = -1;
        generateLayoutParamsByParent.height = -1;
        inflate.setLayoutParams(generateLayoutParamsByParent);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.a aVar, a aVar2) {
        aVar2.etJ.setText(aVar.aFH);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.etJ.getLayoutParams();
        if (aVar.etS) {
            layoutParams.height = etI;
            aVar2.dTI.setVisibility(0);
        } else if (aVar.etT) {
            layoutParams.height = etH;
        }
        ((a) this.viewholder).etJ.setLayoutParams(layoutParams);
        aVar2.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return aVar2.getView();
    }

    /* loaded from: classes6.dex */
    public static class a extends q.a {
        private int aLH;
        public View dTI;
        public TextView etJ;

        public a(View view) {
            super(view);
            this.aLH = 3;
            this.etJ = (TextView) view.findViewById(e.g.concern_tip_txt);
            this.dTI = view.findViewById(e.g.concern_tip_top_line);
        }

        protected void onChangeSkinType(int i) {
            if (this.aLH != i) {
                al.j(getView(), e.d.cp_bg_line_e);
                al.h(this.etJ, e.d.cp_cont_d);
                al.i(this.dTI, e.d.cp_bg_line_e);
            }
        }
    }
}
