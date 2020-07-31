package com.baidu.tieba.ala.alasquare.live_tab.my_concern.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class e extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.b.k> {
    private View dWz;
    private d fvs;
    private d fvt;
    private LinearLayout fvu;
    private ViewGroup rootView;

    public e(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.fvs = new d(tbPageContext);
        this.fvt = new d(tbPageContext);
        this.rootView = (ViewGroup) getView();
        this.fvu = (LinearLayout) this.rootView.findViewById(R.id.id_tab_live_sub_row);
        this.dWz = this.rootView.findViewById(R.id.id_tab_live_sub_line_divider);
        View view = new View(getContext());
        this.fvu.setPadding(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), 0, getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds12));
        this.fvu.addView(this.fvs.getView());
        this.fvu.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds12), -1));
        this.fvu.addView(this.fvt.getView());
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ao.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        this.fvs.onChangeSkinType(tbPageContext, i);
        this.fvt.onChangeSkinType(tbPageContext, i);
        ao.setBackgroundResource(this.dWz, R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_sub_list_live_row;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.k kVar) {
        if (kVar != null) {
            this.fvs.b(kVar.fts);
            this.fvt.b(kVar.ftt);
            if (kVar.ftu) {
                this.dWz.setVisibility(0);
            } else {
                this.dWz.setVisibility(8);
            }
        }
    }

    public void a(o oVar) {
        this.fvs.a(oVar);
        this.fvt.a(oVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
