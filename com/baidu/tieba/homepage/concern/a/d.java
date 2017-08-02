package com.baidu.tieba.homepage.concern.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.a, a> {
    private static int buQ;
    private static int cOX;

    public d(Context context) {
        super(context, com.baidu.tieba.homepage.concern.b.a.cPe);
        buQ = k.g(context, d.f.ds40);
        cOX = k.g(context, d.f.ds120);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ak */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        View inflate = View.inflate(viewGroup.getContext(), d.j.concern_tip_layout, null);
        a aVar = new a(inflate);
        inflate.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.a aVar, a aVar2) {
        aVar2.cOY.setText(aVar.aiO);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.cOY.getLayoutParams();
        if (aVar.cPf) {
            layoutParams.bottomMargin = cOX;
            aVar2.cOZ.setVisibility(0);
        } else {
            layoutParams.bottomMargin = buQ;
            aVar2.cOZ.setVisibility(8);
        }
        aVar2.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return aVar2.getView();
    }

    /* loaded from: classes.dex */
    public class a extends j.a {
        private int aoR;
        public TextView cOY;
        public View cOZ;

        public a(View view) {
            super(view);
            this.aoR = 3;
            this.cOY = (TextView) view.findViewById(d.h.concern_tip_txt);
            this.cOZ = view.findViewById(d.h.concern_tip_top_line);
        }

        protected void onChangeSkinType(int i) {
            if (this.aoR != i) {
                ai.k(getView(), d.e.cp_bg_line_d);
                ai.i(this.cOY, d.e.cp_cont_d);
                ai.j(this.cOZ, d.e.cp_bg_line_c);
            }
        }
    }
}
