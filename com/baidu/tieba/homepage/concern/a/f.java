package com.baidu.tieba.homepage.concern.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.a, a> {
    private static int fGL;
    private static int fGM;

    public f(Context context) {
        super(context, com.baidu.tieba.homepage.concern.b.a.fGU);
        fGL = l.h(context, d.e.tbds102);
        fGM = l.h(context, d.e.tbds166);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ba */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        View inflate = View.inflate(viewGroup.getContext(), d.h.concern_tip_layout, null);
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
        aVar2.fGN.setText(aVar.bOr);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.fGN.getLayoutParams();
        if (aVar.fGX) {
            layoutParams.height = fGM;
            aVar2.fic.setVisibility(0);
        } else if (aVar.fGY) {
            layoutParams.height = fGL;
        }
        ((a) this.viewholder).fGN.setLayoutParams(layoutParams);
        aVar2.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return aVar2.getView();
    }

    /* loaded from: classes4.dex */
    public static class a extends v.a {
        private int bUJ;
        public TextView fGN;
        public View fic;

        public a(View view) {
            super(view);
            this.bUJ = 3;
            this.fGN = (TextView) view.findViewById(d.g.concern_tip_txt);
            this.fic = view.findViewById(d.g.concern_tip_top_line);
        }

        protected void onChangeSkinType(int i) {
            if (this.bUJ != i) {
                al.l(getView(), d.C0236d.cp_bg_line_e);
                al.j(this.fGN, d.C0236d.cp_cont_d);
                al.k(this.fic, d.C0236d.cp_bg_line_e);
            }
        }
    }
}
