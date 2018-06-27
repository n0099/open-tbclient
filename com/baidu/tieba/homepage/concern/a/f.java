package com.baidu.tieba.homepage.concern.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.a, a> {
    private static int dQH;
    private static int dQI;

    public f(Context context) {
        super(context, com.baidu.tieba.homepage.concern.b.a.dQO);
        dQH = l.e(context, d.e.tbds102);
        dQI = l.e(context, d.e.tbds166);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        View inflate = View.inflate(viewGroup.getContext(), d.i.concern_tip_layout, null);
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
        aVar2.dQJ.setText(aVar.atN);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.dQJ.getLayoutParams();
        if (aVar.dQR) {
            layoutParams.height = dQI;
            aVar2.drT.setVisibility(0);
        } else if (aVar.dQS) {
            layoutParams.height = dQH;
        }
        ((a) this.viewholder).dQJ.setLayoutParams(layoutParams);
        aVar2.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return aVar2.getView();
    }

    /* loaded from: classes2.dex */
    public static class a extends q.a {
        private int azP;
        public TextView dQJ;
        public View drT;

        public a(View view) {
            super(view);
            this.azP = 3;
            this.dQJ = (TextView) view.findViewById(d.g.concern_tip_txt);
            this.drT = view.findViewById(d.g.concern_tip_top_line);
        }

        protected void onChangeSkinType(int i) {
            if (this.azP != i) {
                am.j(getView(), d.C0142d.cp_bg_line_e);
                am.h(this.dQJ, d.C0142d.cp_cont_d);
                am.i(this.drT, d.C0142d.cp_bg_line_e);
            }
        }
    }
}
