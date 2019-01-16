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
    private static int eun;
    private static int euo;

    public f(Context context) {
        super(context, com.baidu.tieba.homepage.concern.b.a.euv);
        eun = l.h(context, e.C0210e.tbds102);
        euo = l.h(context, e.C0210e.tbds166);
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
        aVar2.eup.setText(aVar.aGj);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.eup.getLayoutParams();
        if (aVar.euy) {
            layoutParams.height = euo;
            aVar2.dUo.setVisibility(0);
        } else if (aVar.euz) {
            layoutParams.height = eun;
        }
        ((a) this.viewholder).eup.setLayoutParams(layoutParams);
        aVar2.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return aVar2.getView();
    }

    /* loaded from: classes6.dex */
    public static class a extends q.a {
        private int aMj;
        public View dUo;
        public TextView eup;

        public a(View view) {
            super(view);
            this.aMj = 3;
            this.eup = (TextView) view.findViewById(e.g.concern_tip_txt);
            this.dUo = view.findViewById(e.g.concern_tip_top_line);
        }

        protected void onChangeSkinType(int i) {
            if (this.aMj != i) {
                al.j(getView(), e.d.cp_bg_line_e);
                al.h(this.eup, e.d.cp_cont_d);
                al.i(this.dUo, e.d.cp_bg_line_e);
            }
        }
    }
}
