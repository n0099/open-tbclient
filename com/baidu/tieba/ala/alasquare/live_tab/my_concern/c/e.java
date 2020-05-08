package com.baidu.tieba.ala.alasquare.live_tab.my_concern.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class e extends com.baidu.tieba.card.a<com.baidu.tieba.ala.alasquare.live_tab.b.k> {
    private View dvw;
    private d eSe;
    private d eSf;
    private LinearLayout eSg;
    private ViewGroup rootView;

    public e(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.eSe = new d(tbPageContext);
        this.eSf = new d(tbPageContext);
        this.rootView = (ViewGroup) getView();
        this.eSg = (LinearLayout) this.rootView.findViewById(R.id.id_tab_live_sub_row);
        this.dvw = this.rootView.findViewById(R.id.id_tab_live_sub_line_divider);
        View view = new View(getContext());
        this.eSg.setPadding(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), 0, getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds12));
        this.eSg.addView(this.eSe.getView());
        this.eSg.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds12), -1));
        this.eSg.addView(this.eSf.getView());
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        this.eSe.onChangeSkinType(tbPageContext, i);
        this.eSf.onChangeSkinType(tbPageContext, i);
        am.setBackgroundResource(this.dvw, R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.tab_sub_list_live_row;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.k kVar) {
        if (kVar != null) {
            this.eSe.b(kVar.eQe);
            this.eSf.b(kVar.eQf);
            if (kVar.eQg) {
                this.dvw.setVisibility(0);
            } else {
                this.dvw.setVisibility(8);
            }
        }
    }

    public void a(o oVar) {
        this.eSe.a(oVar);
        this.eSf.a(oVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
