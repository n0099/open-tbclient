package com.baidu.tieba.ala.alasquare.live_tab.my_concern.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class e extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.b.k> {
    private View eIO;
    private d gmj;
    private d gmk;
    private LinearLayout gml;
    private ViewGroup rootView;

    public e(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.gmj = new d(tbPageContext);
        this.gmk = new d(tbPageContext);
        this.rootView = (ViewGroup) getView();
        this.gml = (LinearLayout) this.rootView.findViewById(R.id.id_tab_live_sub_row);
        this.eIO = this.rootView.findViewById(R.id.id_tab_live_sub_line_divider);
        View view = new View(getContext());
        this.gml.setPadding(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), 0, getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds12));
        this.gml.addView(this.gmj.getView());
        this.gml.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds12), -1));
        this.gml.addView(this.gmk.getView());
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        this.gmj.onChangeSkinType(tbPageContext, i);
        this.gmk.onChangeSkinType(tbPageContext, i);
        ap.setBackgroundResource(this.eIO, R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_sub_list_live_row;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.k kVar) {
        if (kVar != null) {
            this.gmj.b(kVar.gke);
            this.gmk.b(kVar.gkf);
            if (kVar.gkg) {
                this.eIO.setVisibility(0);
            } else {
                this.eIO.setVisibility(8);
            }
        }
    }

    public void a(o oVar) {
        this.gmj.a(oVar);
        this.gmk.a(oVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
