package com.baidu.tieba.ala.alasquare.special_forum.subtab.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class e extends com.baidu.tieba.card.a<com.baidu.tieba.ala.alasquare.special_forum.data.g> {
    private a eoF;

    public e(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.eoF = new a(getView());
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setViewTextColor(this.eoF.textView, (int) R.color.cp_cont_d);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.special_bar_concern_recommend_title;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.g gVar) {
        if (this.eoF != null) {
            if (gVar.eng) {
                this.eoF.devider.setVisibility(0);
            } else {
                this.eoF.devider.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes2.dex */
    public static class a extends v.a {
        public View cqd;
        public View devider;
        public TextView textView;

        public a(View view) {
            super(view);
            this.cqd = view;
            this.textView = (TextView) this.cqd.findViewById(R.id.title);
            this.devider = this.cqd.findViewById(R.id.divider);
        }
    }
}
