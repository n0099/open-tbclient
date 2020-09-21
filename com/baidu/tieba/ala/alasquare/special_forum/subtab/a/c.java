package com.baidu.tieba.ala.alasquare.special_forum.subtab.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.special_forum.data.e> {
    private a fOP;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.fOP = new a(getView());
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setViewTextColor(this.fOP.textView, R.color.cp_cont_d);
        ap.setBackgroundColor(this.fOP.eis, R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.special_bar_concern_empty;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.e eVar) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes4.dex */
    public static class a extends af.a {
        public View dBl;
        public View eis;
        public TextView textView;

        public a(View view) {
            super(view);
            this.dBl = view;
            this.textView = (TextView) this.dBl.findViewById(R.id.tv_empty);
            this.eis = this.dBl.findViewById(R.id.devider_line);
        }
    }
}
