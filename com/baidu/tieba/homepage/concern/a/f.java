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
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.a, a> {
    private static int dTp;
    private static int dTq;

    public f(Context context) {
        super(context, com.baidu.tieba.homepage.concern.b.a.dTw);
        dTp = l.f(context, f.e.tbds102);
        dTq = l.f(context, f.e.tbds166);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        View inflate = View.inflate(viewGroup.getContext(), f.h.concern_tip_layout, null);
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
        aVar2.dTr.setText(aVar.ats);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.dTr.getLayoutParams();
        if (aVar.dTz) {
            layoutParams.height = dTq;
            aVar2.duD.setVisibility(0);
        } else if (aVar.dTA) {
            layoutParams.height = dTp;
        }
        ((a) this.viewholder).dTr.setLayoutParams(layoutParams);
        aVar2.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return aVar2.getView();
    }

    /* loaded from: classes2.dex */
    public static class a extends q.a {
        private int azF;
        public TextView dTr;
        public View duD;

        public a(View view) {
            super(view);
            this.azF = 3;
            this.dTr = (TextView) view.findViewById(f.g.concern_tip_txt);
            this.duD = view.findViewById(f.g.concern_tip_top_line);
        }

        protected void onChangeSkinType(int i) {
            if (this.azF != i) {
                am.j(getView(), f.d.cp_bg_line_e);
                am.h(this.dTr, f.d.cp_cont_d);
                am.i(this.duD, f.d.cp_bg_line_e);
            }
        }
    }
}
